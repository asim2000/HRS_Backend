package com.company.hrs.service.concretes;

import com.company.hrs.entities.Customer;
import com.company.hrs.repository.CustomerRepository;
import com.company.hrs.service.abstracts.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }
}
