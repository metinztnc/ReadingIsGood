package com.readingIsGood.impl;

import com.readingIsGood.entity.Order;
import com.readingIsGood.repository.OrderRepository;
import com.readingIsGood.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order getOrderById(Long id) {
        Optional<Order> orderEntity = this.orderRepository.findById(id);
        return orderEntity.orElse(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order createOrder(Order order) {
        return orderRepository.save(order);
        // TODO: stock logic
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> getOrderByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findByCreateDateTimeIsBetween(startDate,endDate);
    }
}
