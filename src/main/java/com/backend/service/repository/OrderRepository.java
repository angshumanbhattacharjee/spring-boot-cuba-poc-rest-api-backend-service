package com.backend.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.service.model.OrderModel;

import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel, UUID>, OrderRepositoryCriteria {

    public OrderModel deleteOrderModelByOrderId(UUID orderId);

    public OrderModel findByOrderId(UUID orderId);
}
