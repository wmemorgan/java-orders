package com.lambdaschool.salesapp.services;

import com.lambdaschool.salesapp.models.Customer;
import com.lambdaschool.salesapp.models.Order;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers();

    Customer findCustomerById(long id);

    List<Customer> findByNameLike(String likename);

    // POST & PUT
    Customer save(Customer customer);

    // PATCH
    Customer update(Customer customer, long id);

    // DELETE
    void delete(long id);
}
