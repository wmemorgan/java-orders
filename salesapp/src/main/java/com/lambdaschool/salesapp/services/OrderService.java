package com.lambdaschool.salesapp.services;

import com.lambdaschool.salesapp.models.Order;

public interface OrderService {
    Order findByOrderId(long id);

    Order save(Order order);
}
