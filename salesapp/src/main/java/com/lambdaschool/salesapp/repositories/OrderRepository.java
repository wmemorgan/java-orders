package com.lambdaschool.salesapp.repositories;

import com.lambdaschool.salesapp.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
