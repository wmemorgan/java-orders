package com.lambdaschool.salesapp.services;

import com.lambdaschool.salesapp.models.Customer;
import com.lambdaschool.salesapp.models.Order;
import com.lambdaschool.salesapp.models.Payment;
import com.lambdaschool.salesapp.repositories.OrderRepository;
import com.lambdaschool.salesapp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Order findByOrderId(long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order " + id + " not found"));
    }

    @Transactional
    @Override
    public Order save(Order order) {
        Order newOrder = new Order();

        Customer c = customerService.findCustomerById(order.getCustomer().getCustcode());

        if (order.getOrdnum() != 0) {

            // put
            orderRepository.findById(order.getOrdnum())
                    .orElseThrow(() -> new EntityNotFoundException("Thingy " + order.getOrdnum() + " Not found"));

            newOrder.setOrdnum(order.getOrdnum());
        }

        newOrder.setOrdamount(order.getOrdamount());
        newOrder.setAdvanceamount(order.getAdvanceamount());
        newOrder.setCustomer(c);
        newOrder.setOrderdescription(order.getOrderdescription());

        newOrder.getPayments().clear();
        for (Payment p: order.getPayments()) {
            Payment newPay = paymentRepository.findById(p.getPaymentid())
                    .orElseThrow(() -> new EntityNotFoundException("Payment " + p.getPaymentid() + " Not Found"));
            newOrder.addPayments(newPay);
        }

        return orderRepository.save(newOrder);
    }

    @Transactional
    @Override
    public void delete(long id) {
        if(orderRepository.findById(id).isPresent()) {
            orderRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Order " + id + " Not Found");
        }
    }
}
