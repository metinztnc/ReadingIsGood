package com.readingIsGood.service;

import com.readingIsGood.entity.Customer;
import org.springframework.data.domain.Page;

public interface ICustomerService {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(Long id);

    Page<Customer> getAllCustomer(int pageIndex, int pageSize);


}
