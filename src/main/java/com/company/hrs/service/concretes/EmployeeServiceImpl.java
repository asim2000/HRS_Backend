package com.company.hrs.service.concretes;

import com.company.hrs.entities.Employee;
import com.company.hrs.repository.EmployeeRepository;
import com.company.hrs.service.abstracts.EmployeeService;
import com.company.hrs.service.dtos.employee.requests.CreateEmployeeRequest;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void create(CreateEmployeeRequest employee) {
        employeeRepository.save(modelMapperService.forRequest().map(employee,Employee.class));
    }
}
