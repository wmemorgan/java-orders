package com.lambdaschool.salesapp.controllers;

import com.lambdaschool.salesapp.models.Customer;
import com.lambdaschool.salesapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    // POST http://localhost:2019/customers/customer
    @PostMapping(value = "/customer", consumes = {"application/json"})
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer newCustomer) {

        newCustomer.setCustcode(0);
        newCustomer = customerService.save(newCustomer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{customerid}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();

        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // PUT http://localhost:2019/customers/customer/{custcode}
    @PutMapping(value = "/customer/{custcode}", consumes = {"application/json"})
    public ResponseEntity<?> replaceCustomer(@Valid @RequestBody Customer replaceCustomer, @PathVariable long custcode) {

        replaceCustomer.setCustcode(custcode);
        customerService.save(replaceCustomer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // PATCH http://localhost:2019/customers/customer/{custcode}
    @PatchMapping(value = "/customer/{custcode}", consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer updateCustomer,
                                            @PathVariable long custcode) {
        customerService.update(updateCustomer, custcode);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
