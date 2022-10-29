package com.readingIsGood.controller;



import com.readingIsGood.entity.Order;
import com.readingIsGood.service.IOrderService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping(value = "/create")
    @Operation(summary = "Create a Order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Order Created"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return new ResponseEntity(orderService.createOrder(order), HttpStatus.OK);
    }

    @GetMapping(value = "/getOrderById/{id}")
    @Operation(summary = "Get a Specific Order Instance by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Get Order By ID"),
            @ApiResponse(code = 404, message = "No Order Found With ID"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @GetMapping(value = "/getOrderByDate")
    @Operation(summary = "Get a Specific Order Instance by Interval Date")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Get Order By Date"),
            @ApiResponse(code = 404, message = "No Order Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<List<Order>> getOrderById(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        List<Order> orderList = orderService.getOrderByDate(startDate, endDate);
        if (!CollectionUtils.isEmpty(orderList))
            return ResponseEntity.ok(orderList);

        return ResponseEntity.notFound().build();
    }
}
