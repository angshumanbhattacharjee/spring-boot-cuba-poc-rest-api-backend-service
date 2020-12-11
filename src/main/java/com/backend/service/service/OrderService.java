package com.backend.service.service;

import com.backend.service.model.OrderCriteriaModel;
import com.backend.service.model.OrderModel;

import java.util.List;
import java.util.UUID;

public interface OrderService {
	
	OrderModel createOrder(OrderModel orderModel);

    List<OrderModel> getOrdersByCriteria(OrderCriteriaModel orderCriteriaModel) throws Exception;

    OrderModel deleteOrderById(UUID orderId) throws Exception;
}
