package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.OrderLineRepository;
import com.rentalproperty.Services.OrderLineService;
import com.rentalproperty.domain.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by thabomoopa on 17/08/2017.
 */
@Component
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    @Override
    public OrderLine create(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public OrderLine read(long id) {
        return orderLineRepository.findOne(id);
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public void delete(long id) {
        orderLineRepository.delete(id);

    }

    @Override
    public OrderLine findByOrderLineNumber(int orderLineNumber) {
        return orderLineRepository.findByOrderLineNumber(orderLineNumber);
    }
}
