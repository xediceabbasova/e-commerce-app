package com.khadija.ecommerce.service;

import com.khadija.ecommerce.dto.OrderLineMapper;
import com.khadija.ecommerce.dto.OrderLineRequest;
import com.khadija.ecommerce.model.OrderLine;
import com.khadija.ecommerce.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    public OrderLineService(OrderLineRepository repository, OrderLineMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Integer saveOrderLine(OrderLineRequest request) {
        OrderLine orderLine = mapper.toOrderLine(request);
        return repository.save(orderLine).getId();
    }
}
