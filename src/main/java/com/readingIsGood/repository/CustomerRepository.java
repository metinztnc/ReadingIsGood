package com.readingIsGood.repository;


import com.readingIsGood.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseJpaRepository<Customer,Long> {
}
