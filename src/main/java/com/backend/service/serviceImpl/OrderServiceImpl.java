package com.backend.service.serviceImpl;

import com.backend.service.model.OrderCriteriaModel;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	/*
	* Method used to persist new Order object or
	* update existing Order object.
	* @Params orderModel object
	* @Returns orderModel object
	* */
	@Override
	public OrderModel createOrder(OrderModel orderModel) {
		try {
			return orderRepository.save(orderModel);
		} catch (Exception e) {
			log.error("Error occurred in processing request : " + e.getMessage());
		}
		return null;
	}

	/*
	* Method used to fetch OrderModel objects based on CriteriaModel fields
	* @Params orderCriteriaModel object
	* @Returns List of orderModel objects
	* */
	@Override
	public List<OrderModel> getOrdersByCriteria(OrderCriteriaModel orderModelCriteria) {
		try {
			return orderRepository.findByCriteria(orderModelCriteria);
		} catch (Exception e) {
			log.error("Error occurred in processing request : " + e.getMessage());
		}
		return null;
	}

	/*
	 * Method used to delete Order object based on orderId
	 * @Params UUID orderId
	 * @Returns String object
	 * */
	@Override
	public String deleteOrderById(UUID orderId) {
		String response = "Order item not found with Order_Id: " + orderId.toString();
		try {
			Integer result = orderRepository.deleteByOrderId(orderId);
			log.info("Integer received: "+ result);
			if (result == 1) {
				response = "Order item deleted with Order_Id: " + orderId.toString();
				return response;
			}
		} catch (Exception e) {
			log.error("Error occurred in processing request : " + e.getMessage());
		}
		return response;
	}
}
