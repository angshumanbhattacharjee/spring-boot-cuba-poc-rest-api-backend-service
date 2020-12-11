package com.backend.service.serviceImpl;

import com.backend.service.model.OrderCriteriaModel;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.model.OrderModel;
import com.backend.service.repository.OrderRepository;
import com.backend.service.service.OrderService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
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

	@Override
	public OrderModel deleteOrderById(UUID orderId) throws Exception {

//		orderModel = Optional.ofNullable(orderRepository.findByOrderId(orderId));
//		if(orderModel.isPresent()) {
//			orderRepository.deleteOrderModelByOrderId(orderId);
//			return "Order item deleted";
//		}
		OrderModel orderModel = null;
		orderModel = orderRepository.deleteOrderModelByOrderId(orderId);
		if (orderModel != null) {
			return orderModel;
		}
		else {
			return null;
		}
//		orderRepository.deleteById(orderId);
//		if (orderModel != null) {
//			return "Order item deleted";
//		}
//		else {
//			return "Order item not found";
//		}
//		return "Order Item deleted";
	}

}
