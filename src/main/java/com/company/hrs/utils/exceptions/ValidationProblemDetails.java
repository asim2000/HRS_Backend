package com.company.hrs.utils.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ValidationProblemDetails extends ProblemDetails{
    private Map<String,String> validationErrors;
}