package com.company.hrs.security;

import com.company.hrs.entities.Person;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.PersonRepository;
import com.company.hrs.repository.PersonRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PersonRepository personRepository;
    private final PersonRoleRepository personRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.getPersonByEmailAndActive(username, Status.ACTIVE);
        return new User(username,person.getPassword(),getAuthorities(personRoleRepository.getRoleNamesByPersonId(person.getId())));
    }
    private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    }

    public UserDetails loadUserById(Long id) {
        Person person = personRepository.getById(id);
        return new User(person.getContact().getEmail(),person.getPassword(),getAuthorities(personRoleRepository.getRoleNamesByPersonId(person.getId())));
    }

}