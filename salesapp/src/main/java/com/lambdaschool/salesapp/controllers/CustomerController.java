package com.lambdaschool.salesapp.controllers;

import com.lambdaschool.salesapp.models.Customer;
import com.lambdaschool.salesapp.models.Order;
import com.lambdaschool.salesapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers() {

        List<Customer> myCustomers = customerService.findAllCustomers();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    // http://localhost:2019/customers/customer/23

    // http://localhost:2019/customers/customer/77 (Invalid customer)

    // http://localhost:2019/customers/namelike/mes

    // http://localhost:2019/customers/namelike/zin (Invalid name)




}
