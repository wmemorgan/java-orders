package com.lambdaschool.salesapp.controllers;

import com.lambdaschool.salesapp.models.Order;
import com.lambdaschool.salesapp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // http://localhost:2019/orders/order/52
    @GetMapping(value = "/order/{id}", produces = {"application/json"})
    public ResponseEntity<?> findOrderById(@PathVariable long id) {

        Order o = orderService.findByOrderId(id);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
}
