package com.company.hrs.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.company.hrs.entities.Person;
import com.company.hrs.entities.PersonRole;
import com.company.hrs.entities.Role;
import com.company.hrs.repository.PersonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
    @Autowired
    PersonRoleRepository personRoleRepository;

    @Value("${hrs.app.secret}")
    private String APP_SECRET;

    @Value("${hrs.expires.in}")
    private Long EXPIRES_IN;

    public String generateJwtToken(Person person) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + EXPIRES_IN);
        return Jwts.builder().setSubject(Long.toString(person.getId()))
                .setIssuedAt(now).setExpiration(expireDate)
                .claim("roles",personRoleRepository.getRoleNamesByPersonId(person.getId()))
                .signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();
    }

    public String generateJwtTokenByUserId(Long userId) {
        Date expireDate = new Date(new Date().getTime() + 5*60*1000);
        return Jwts.builder().setSubject(Long.toString(userId))
                .setIssuedAt(new Date()).setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();
    }

    Long getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

    boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (SignatureException e) {
            return false;
        } catch (MalformedJwtException e) {
            return false;
        } catch (ExpiredJwtException e) {
            return false;
        } catch (UnsupportedJwtException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }

}
