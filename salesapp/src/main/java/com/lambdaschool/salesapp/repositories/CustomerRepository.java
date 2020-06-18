package com.lambdaschool.salesapp.repositories;

import com.lambdaschool.salesapp.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
