package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Employee;
import com.company.hrs.service.dtos.employee.requests.CreateEmployeeRequest;

public interface EmployeeService {
    void create(CreateEmployeeRequest employee);
}
