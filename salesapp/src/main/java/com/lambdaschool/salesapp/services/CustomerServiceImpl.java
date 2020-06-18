package com.lambdaschool.salesapp.services;

import com.lambdaschool.salesapp.models.Customer;
import com.lambdaschool.salesapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

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
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " not found"));
    }

    @Override
    public List<Customer> findByNameLike(String likename) {
        return customerRepository.findByCustnameContainingIgnoringCase(likename);
    }
}
