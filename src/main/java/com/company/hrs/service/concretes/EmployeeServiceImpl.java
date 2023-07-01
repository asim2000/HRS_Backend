package com.company.hrs.service.concretes;

import com.company.hrs.entities.Employee;
import com.company.hrs.repository.EmployeeRepository;
import com.company.hrs.service.abstracts.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }
}
