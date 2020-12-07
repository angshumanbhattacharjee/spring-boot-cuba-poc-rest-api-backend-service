package com.backend.service.repository;

import com.backend.service.model.OrderCriteriaModel;
import com.backend.service.model.OrderModel;

import java.util.List;

@FunctionalInterface
public interface OrderRepositoryCriteria {

    List<OrderModel> findByCriteria(OrderCriteriaModel orderCriteriaModel) throws Exception;

}
