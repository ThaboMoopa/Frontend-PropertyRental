package com.rentalproperty.controller;


import com.rentalproperty.Services.Impl.AddressServiceImpl;
import com.rentalproperty.Services.Impl.PropertyServiceImpl;
import com.rentalproperty.Services.Impl.UnitServiceImpl;
import com.rentalproperty.domain.Address;
import com.rentalproperty.domain.Property;
import com.rentalproperty.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.rentalproperty.Factories.PropertyFactory.getProperty;
import static com.rentalproperty.domain.Property.Builder;

@Controller

public class PropertyController {

    Property property;
    //Address address;
    //Unit unit;

    @Autowired
    private PropertyServiceImpl propertyService;


    //localhost:8080/addProperty?&propertyName=rosenvale&propertyNumber=4673574
    @RequestMapping(path = "/addProperty")
    public
    @ResponseBody
    Property create(@RequestParam String propertyName, @RequestParam int propertyNumber) {
        //address = addressService.read(addressId);
        //unit = unitService.read(unitId);
        property = getProperty(propertyName, propertyNumber);

        return propertyService.create(property);
    }

    //function to retrieve the id of the property
    ///http://localhost:8080/findByPropertyNumber?&propertyNumber=4673574
    @RequestMapping(path = "/findByPropertyNumber")
    public
    @ResponseBody
    Property findByPropertyNumber(@RequestParam int propertyNumber) {
        return propertyService.findByPropertyNumber(propertyNumber);
    }

    @RequestMapping(path = "/unit/{unitId}/{addressId}/readProperty")
    public
    @ResponseBody
    Property read(@PathVariable long addressId, @RequestParam long id) {
        return propertyService.read(id);
    }

    @RequestMapping(path = "/unit/{unitId}/{addressId}/updateProperty")
    public
    @ResponseBody
    Property update(@RequestParam long id, @RequestParam String propertyName, @RequestParam int propertyNumber) {
        property = propertyService.read(id);
        Property updateProperty = new Builder()
                .id(id)
                .propertyName(propertyName)
                .propertyNumber(propertyNumber)
                .build();
        return propertyService.update(updateProperty);
    }

    @RequestMapping(path = "/unit/{unitId}/{addressId}/deleteProperty")
    public
    @ResponseBody
    void delete(@PathVariable long addressId, @RequestParam long id) {
        propertyService.delete(id);
    }
}
