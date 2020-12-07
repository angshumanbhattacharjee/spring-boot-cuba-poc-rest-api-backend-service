package com.backend.service.serviceImpl;

import com.backend.service.model.OrderCriteriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.model.OrderModel;
import com.backend.service.repository.OrderRepository;
import com.backend.service.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderModel createOrder(OrderModel orderModel) {
		try {
			return orderRepository.save(orderModel);
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	@Override
	public List<OrderModel> getOrdersByCriteria(OrderCriteriaModel orderModelCriteria) throws Exception {
		return orderRepository.findByCriteria(orderModelCriteria);
	}

}
