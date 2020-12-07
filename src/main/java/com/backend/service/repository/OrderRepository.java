package com.backend.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.service.model.OrderModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel, String>, OrderRepositoryCriteria {

}
