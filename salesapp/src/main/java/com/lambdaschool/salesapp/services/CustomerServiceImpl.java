package com.lambdaschool.salesapp.services;

import com.lambdaschool.salesapp.models.Customer;
import com.lambdaschool.salesapp.models.Order;
import com.lambdaschool.salesapp.repositories.CustomerRepository;
import com.lambdaschool.salesapp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> rtnList = new ArrayList<>();

        customerRepository.findAll()
                .iterator()
                .forEachRemaining(rtnList::add);

        return rtnList;
    }

    @Override
    public Customer findCustomerById(long id) {
        return null;
    }

    @Override
    public List<Customer> findByNameLike(String name) {
        return null;
    }
}
