package com.khadija.ecommerce.repository;

import com.khadija.ecommerce.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
