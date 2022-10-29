package com.readingIsGood.repository;


import com.readingIsGood.entity.Order;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends BaseJpaRepository<Order,Long> {

    List<Order> findByCreateDateTimeIsBetween(LocalDateTime startDate, LocalDateTime endDate);
}
