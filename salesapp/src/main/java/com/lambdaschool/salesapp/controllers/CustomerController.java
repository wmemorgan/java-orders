package com.lambdaschool.salesapp.controllers;

import com.lambdaschool.salesapp.models.Customer;
import com.lambdaschool.salesapp.models.Order;
import com.lambdaschool.salesapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

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

    // http://localhost:2019/customers/customer/{id}
    @GetMapping(value = "/customer/{id}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerById(@PathVariable long id) {
        Customer c = customerService.findCustomerById(id);

        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    // http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{likename}", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomersLikeName(@PathVariable String likename) {

        List<Customer> myCustomers = customerService.findByNameLike(likename);
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

}
