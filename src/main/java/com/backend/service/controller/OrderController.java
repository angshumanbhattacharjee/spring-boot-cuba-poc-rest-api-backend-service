package com.backend.service.controller;

import com.backend.service.model.OrderCriteriaModel;
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
public class OrderController {
	
	@Autowired
    OrderService orderService;


	/*
	* API used to create/update Order object
	* Updates existing Order entity if Id field is provided in Request Body
	* */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/order-service/createOrder", produces = "application/json")
    public ResponseEntity<OrderModel> createOrder(@RequestBody OrderModel orderModel) throws Exception {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(orderService.createOrder(orderModel), HttpStatus.CREATED);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
            throw exception;
        }
        return responseEntity;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping(value = "/order-service/getOrdersByCriteria", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderModel>> getOrdersByCriteria(@RequestBody OrderCriteriaModel orderCriteriaModel) throws Exception {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(orderService.getOrdersByCriteria(orderCriteriaModel), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
            throw exception;
        }
        return responseEntity;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping(value = "/order-service/deleteOrderById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteOrderById(@RequestParam UUID orderId) throws Exception {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(orderService.deleteOrderById(orderId), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
            throw exception;
        }
        return responseEntity;
    }
}
