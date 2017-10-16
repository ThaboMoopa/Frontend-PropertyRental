package com.rentalproperty.Services;

import com.rentalproperty.domain.Orders;

import javax.persistence.criteria.Order;

public interface OrdersService {
    Orders create(Orders orders);
    Orders read(long id);
    Orders update(Orders orders);
    void delete(long id);
    Orders readOrderNumber(long orderNumber);
}
