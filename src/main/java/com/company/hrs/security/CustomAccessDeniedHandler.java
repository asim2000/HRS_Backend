package com.company.hrs.security;

import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.result.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
//        response.setContentType("application/json");
//        response.setStatus(HttpServletResponse.SC_OK);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(new Result(StatusCode.ACCESS_DENIED,Message.ACCESS_DENIED));
//        response.getWriter().write(json);
        response.sendError(HttpServletResponse.SC_FORBIDDEN,accessDeniedException.getMessage());
    }
}
