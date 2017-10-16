package com.rentalproperty.controller;


import com.rentalproperty.Services.Impl.OrderLineServiceImpl;
import com.rentalproperty.Services.Impl.OrdersServiceImpl;
import com.rentalproperty.Services.Impl.ResidentServiceImpl;
import com.rentalproperty.domain.OrderLine;
import com.rentalproperty.domain.Orders;
import com.rentalproperty.domain.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.rentalproperty.Factories.OrdersFactory.getOrders;
import static com.rentalproperty.domain.Orders.Builder;
import static java.lang.System.out;


@Controller
@RequestMapping(path = "/order")
public class OrdersController {

    private Orders orders;
    private Resident resident;
    private OrderLine orderLine;


    @Autowired
    private OrdersServiceImpl ordersService;

    @Autowired
    private ResidentServiceImpl residentService;

    //@Autowired
    //private OrderLineServiceImpl orderLineService;

    //http://localhost:8080/order/1/addOrder?orderNumber=55&dateDay=1997/12/30
    //@GetMapping(path = "/resident/{residentId}/{orderLineId}/order")
    @GetMapping(path = "/{residentId}/addOrder")
    public
    @ResponseBody
    //Orders create(@PathVariable long residentId, @PathVariable long orderLineId,
                  //@RequestParam long id, @RequestParam @DateTimeFormat(pattern = "dd.mm.yyyy") Date dateDay)
    Orders create(@PathVariable long residentId,
                  @RequestParam long orderNumber,  @RequestParam @DateTimeFormat(pattern = "yyyy/mm/dd") Date dateDay) {
        resident = residentService.read(residentId);
        //OrderLine information
        //orderLine = orderLineService.read(orderLineId);
        //List<OrderLine> orderLines = new ArrayList<OrderLine>();
        //orderLines.add(orderLine);

        orders = getOrders(resident, dateDay, orderNumber);//, orderLines);
        ordersService.create(orders);
        return orders;
    }

    //http://localhost:8080/resident/1/order/1/readOrder?id=1
    @GetMapping(path = "/{residentId}/order/{id}/readOrder")
    public
    @ResponseBody
    Orders read(@PathVariable long id) {
        return ordersService.read(id);
    }


    //http://localhost:8080/resident/1/order/1/updateOrder?dateDay=12.01.1888
    @GetMapping(path = "/{residentId}/order/{id}/updateOrder")
    public
    @ResponseBody
    Orders update(@PathVariable long id, @RequestParam @DateTimeFormat(pattern = "dd.mm.yyyy") Date dateDay) {
        orders = ordersService.read(id);
        Orders updateOrder = new Builder()
                .id(id)
                .ordersDate(dateDay)
                .build();

        orders = ordersService.create(updateOrder);

        return orders;

    }

    //http://localhost:8080/resident/1/order/1/readOrder?id=1
    @GetMapping(path = "/{residentId}/deleteOrder")
    public
    @ResponseBody
    void delete(@PathVariable long residentId, @RequestParam long id) {
        ordersService.delete(id);
    }

    //function to retrieve the id of the order
    @RequestMapping(path = "/findOrderByOrderNumber", method = RequestMethod.GET)
    public @ResponseBody
    Orders readOrderNumber(@RequestParam long orderNumber)
    {
        return ordersService.readOrderNumber(orderNumber);
    }

}
