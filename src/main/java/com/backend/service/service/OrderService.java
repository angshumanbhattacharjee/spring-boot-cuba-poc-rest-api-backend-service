package com.backend.service.service;

import com.backend.service.model.OrderCriteriaModel;
import com.backend.service.model.OrderModel;

import java.util.List;

public interface OrderService {
	
	OrderModel createOrder(OrderModel orderModel);

    List<OrderModel> getOrdersByCriteria(OrderCriteriaModel orderCriteriaModel) throws Exception;
}
