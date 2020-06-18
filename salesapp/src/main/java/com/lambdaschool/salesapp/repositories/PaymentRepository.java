package com.lambdaschool.salesapp.repositories;

import com.lambdaschool.salesapp.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
