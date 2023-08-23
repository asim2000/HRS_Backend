package com.company.hrs.security;

import java.io.IOException;
import java.util.Calendar;

import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.result.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
//        response.setContentType("application/json");
//        response.setStatus(HttpServletResponse.SC_OK);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(new Result(StatusCode.UN_AUTHORIZATION,Message.UN_AUTHORIZATION));
//        response.getWriter().write(json);
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getOutputStream().println("{ \"error\": \"" + authException.getMessage() + "\" }");

    }
}