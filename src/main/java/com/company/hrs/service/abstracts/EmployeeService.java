package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Employee;
import com.company.hrs.service.dtos.employee.requests.CreateEmployeeRequest;
import com.company.hrs.service.result.Result;

public interface EmployeeService {
    Result create(CreateEmployeeRequest employee);
}
