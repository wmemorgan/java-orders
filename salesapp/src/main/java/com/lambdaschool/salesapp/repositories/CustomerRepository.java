package com.lambdaschool.salesapp.repositories;

import com.lambdaschool.salesapp.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByCustnameContainingIgnoringCase (String likename);
}
