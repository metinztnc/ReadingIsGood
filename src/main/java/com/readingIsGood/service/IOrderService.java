package com.readingIsGood.service;


import com.readingIsGood.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService {
    Order getOrderById(Long id);

    Order createOrder(Order order);

    List<Order> getOrderByDate(LocalDateTime startDate, LocalDateTime endDate);

}
