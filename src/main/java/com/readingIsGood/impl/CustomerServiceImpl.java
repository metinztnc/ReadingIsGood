package com.readingIsGood.impl;

import com.readingIsGood.entity.Customer;
import com.readingIsGood.repository.CustomerRepository;
import com.readingIsGood.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Customer getCustomerById(Long id) {
        Optional<Customer> customerEntity = this.customerRepository.findById(id);
        return customerEntity.orElse(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Page<Customer> getAllCustomer(int pageIndex, int pageSize) {
        Page<Customer> response = customerRepository.findAll(PageRequest.of(pageIndex, pageSize));
        return response;
    }
}
