package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.OrdersRepository;
import com.rentalproperty.Services.OrdersService;
import com.rentalproperty.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Order;

/**
 * Created by thabomoopa on 17/08/2017.
 */
@Component
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersService;

    @Override
    public Orders create(Orders orders) {
        return ordersService.save(orders);
    }

    @Override
    public Orders read(long id) {
        return ordersService.findOne(id);
    }

    @Override
    public Orders update(Orders orders) {
        return ordersService.save(orders);
    }

    @Override
    public void delete(long id) {
        ordersService.delete(id);
    }

    @Override
    public Orders readOrderNumber(long orderNumber) {
        return ordersService.findByOrderNumber(orderNumber);
    }

}
