package com.khadija.ecommerce.service;

import com.khadija.ecommerce.client.CustomerClient;
import com.khadija.ecommerce.client.ProductClient;
import com.khadija.ecommerce.dto.CustomerDto;
import com.khadija.ecommerce.dto.OrderLineRequest;
import com.khadija.ecommerce.dto.OrderMapper;
import com.khadija.ecommerce.dto.OrderRequest;
import com.khadija.ecommerce.exception.BusinessException;
import com.khadija.ecommerce.model.Order;
import com.khadija.ecommerce.product.PurchaseRequest;
import com.khadija.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public OrderService(CustomerClient customerClient, ProductClient productClient, OrderRepository orderRepository, OrderMapper mapper, OrderLineService orderLineService) {
        this.customerClient = customerClient;
        this.productClient = productClient;
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.orderLineService = orderLineService;
    }

    public Integer createOrder(OrderRequest request) {
        CustomerDto customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot created order:: No customer exists with the provided ID"));

        productClient.purchaseProducts(request.products());

        Order order = orderRepository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // todo start payment process

        // todo send order confirmation
        return null;
    }
}
