package com.khadija.ecommerce.controller;

import com.khadija.ecommerce.dto.OrderLineDto;
import com.khadija.ecommerce.email.OrderLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-line")
public class OrderLineController {

    private final OrderLineService service;

    public OrderLineController(OrderLineService service) {
        this.service = service;
    }

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineDto>> findByOrderId(@PathVariable("order-id") Integer orderId) {
        return ResponseEntity.ok(service.findAllByOrderId(orderId));
    }
}
