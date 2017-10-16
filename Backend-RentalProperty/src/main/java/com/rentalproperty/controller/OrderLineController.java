package com.rentalproperty.controller;

import com.rentalproperty.Repositories.OrderLineRepository;
import com.rentalproperty.Repositories.PropertyRepository;
import com.rentalproperty.Services.Impl.OrderLineServiceImpl;
import com.rentalproperty.Services.Impl.OrdersServiceImpl;
import com.rentalproperty.Services.Impl.PropertyServiceImpl;
import com.rentalproperty.Services.Impl.UnitServiceImpl;
import com.rentalproperty.Services.UnitService;
import com.rentalproperty.domain.OrderLine;
import com.rentalproperty.domain.Orders;
import com.rentalproperty.domain.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.rentalproperty.Factories.OrderLineFactory.getOrderLine;
import static com.rentalproperty.domain.OrderLine.Builder;

@Controller
@RequestMapping(path = "/OrderLine")
public class OrderLineController {
    OrderLine orderLine;
    Property property;
    Orders orders;
    @Autowired
    private OrderLineServiceImpl orderLineService;

    @Autowired
    private PropertyServiceImpl propertyService;


    @Autowired
    private OrdersServiceImpl orderService;

    //localhost:8080/order/1/1/addOrderLine?id=1&quantity=65&price=6500
    @RequestMapping(path = "/{propertyId}/{orderId}/addOrderLine")
    public
    @ResponseBody
    OrderLine create(@PathVariable long propertyId, @PathVariable long orderId, @RequestParam int orderLineNumber) {

        property = propertyService.read(propertyId);
        orders = orderService.read(orderId);
        orderLine = getOrderLine(orderLineNumber, property, orders);

        orderLineService.create(orderLine);
        return orderLine;
    }

    @RequestMapping(path = "/findByOrderLineNumber")
    public
    @ResponseBody
    OrderLine read(@RequestParam int orderLineNumber) {
        return orderLineService.findByOrderLineNumber(orderLineNumber);
    }

    @RequestMapping(path = "/order/{orderId}/{propertyId}/readOrderLine")
    public
    @ResponseBody
    OrderLine read(@PathVariable long orderId, @PathVariable long propertyId, @RequestParam long id) {
        return orderLineService.read(id);
    }

    @RequestMapping(path = "/order/{orderId}/{propertyId}/updateOrderLine/{id}")
    public
    @ResponseBody
    OrderLine update(@PathVariable long orderId, @PathVariable long propertyId, @RequestParam long id, @RequestParam int quantity, @RequestParam double price) {
        orderLineService.read(id);
        OrderLine updateOrderLine = new Builder()
                .id(id)
                .build();
        return orderLineService.create(updateOrderLine);

    }

    @RequestMapping(path = "/order/{orderId}/{propertyId}/deleteOrderLine")
    public void delete(@PathVariable long orderId, @PathVariable long propertyId, @RequestParam long id) {
        orderLineService.delete(id);
    }


}
