package com.rentalproperty.Factories;

import com.rentalproperty.domain.OrderLine;
import com.rentalproperty.domain.Orders;
import com.rentalproperty.domain.Property;

public class OrderLineFactory {
    public static OrderLine getOrderLine(int orderLineNumber, Property property, Orders orders)
    {
        OrderLine orderLine = new OrderLine.Builder()
                .orderLine(orderLineNumber)
                .property(property)
                .orders(orders)
                .build();
        return orderLine;
    }
}
