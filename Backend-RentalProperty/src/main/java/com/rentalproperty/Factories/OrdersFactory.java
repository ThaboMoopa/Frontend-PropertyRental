package com.rentalproperty.Factories;


import com.rentalproperty.domain.OrderLine;
import com.rentalproperty.domain.Orders;
import com.rentalproperty.domain.Resident;

import java.util.Date;
import java.util.List;

public class OrdersFactory {
        public static Orders getOrders(Resident resident, Date date, long orderNumber)
        {
            Orders orders = new Orders.Builder()
                    .orderNumber(orderNumber)
                    .resident(resident)
                    .ordersDate(date)
                    .build();
            return orders;
        }
    }

