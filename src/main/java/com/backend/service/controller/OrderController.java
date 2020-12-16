package com.backend.service.controller;

import com.backend.service.model.OrderCriteriaModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.service.model.OrderModel;
import com.backend.service.service.OrderService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v2")
@Log4j2
public class OrderController {
	
	@Autowired
    OrderService orderService;

	/*
	* API used to create/update Order object
	* Updates existing Order entity if Id field is provided in Request Body
	* @Params orderModel object
    * @Returns ResponseEntity object
	* */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/order-service/createOrder", produces = "application/json")
    public ResponseEntity<OrderModel> createOrder(@RequestBody OrderModel orderModel) throws Exception {
        ResponseEntity responseEntity;
        try {
            log.info("Order Model received at createOrder controller. Model sent to service class for persistence");
            responseEntity = new ResponseEntity(orderService.createOrder(orderModel), HttpStatus.CREATED);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
            throw exception;
        }
        return responseEntity;
    }

    /*
    * API used to fetch Order objects based on Criteria Model fields
    * @Params orderCriteriaModel object
    * @Returns ResponseEntity object
    * */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping(value = "/order-service/getOrdersByCriteria", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderModel>> getOrdersByCriteria(@RequestBody OrderCriteriaModel orderCriteriaModel) throws Exception {
        ResponseEntity responseEntity;
        try {
            log.info("OrderCriteria Model received at getOrdersByCriteria controller. Model sent to service class to fetch data");
            responseEntity = new ResponseEntity(orderService.getOrdersByCriteria(orderCriteriaModel), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
            throw exception;
        }
        return responseEntity;
    }

    /*
     * API used to delete Order object based on orderId
     * @Params String orderId
     * @Returns ResponseEntity object
     * */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping(value = "/order-service/deleteOrderById", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity deleteOrderById(@RequestBody String orderId) throws Exception {
        ResponseEntity responseEntity;
        try {
            log.info("OrderId received at deleteOrderById controller. OrderId sent to service class to delete data");
            responseEntity = new ResponseEntity(orderService.deleteOrderById(UUID.fromString(orderId)), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
            throw exception;
        }
        return responseEntity;
    }
}
