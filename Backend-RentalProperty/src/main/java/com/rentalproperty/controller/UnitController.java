package com.rentalproperty.controller;

import com.rentalproperty.Factories.UnitFactory;
import com.rentalproperty.Repositories.BathroomRepository;

import com.rentalproperty.Repositories.UnitRepository;
import com.rentalproperty.Services.Impl.BathroomServiceImpl;

import com.rentalproperty.Services.Impl.PropertyServiceImpl;
import com.rentalproperty.Services.Impl.UnitServiceImpl;
import com.rentalproperty.domain.Bathroom;
import com.rentalproperty.domain.Property;
import com.rentalproperty.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.rentalproperty.Factories.UnitFactory.getUnit;
import static com.rentalproperty.domain.Unit.Builder;

@Controller
@RequestMapping(path = "/unit")
public class UnitController {

    Unit unit;
    Property property;
    //Parking parking;

    @Autowired
    private UnitServiceImpl unitService;

    @Autowired
    private PropertyServiceImpl propertyService;


    //http://localhost:8080/unit/2/addUnit?&rooms=3&unitNo=24&parking=true&bathroomType=shower+only&price=6500&startDate=20/12/2017&endDate=20/12/2017    @RequestMapping(path = "/{propertyId}/addUnit")
    @RequestMapping(path = "/{propertyId}/addUnit")
    public
    @ResponseBody
    Unit create(
                @PathVariable long propertyId, @RequestParam int rooms, @RequestParam int unitNo,@RequestParam int parking,
                @RequestParam String bathroomType, @RequestParam float price,
                @RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy") Date startDate,
                @RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy") Date endDate) {

        //bathroom = bathroomService.read(bathroomId);
        property = propertyService.read(propertyId);
        Map<String, Integer> unitValues = new HashMap<String, Integer>();
        unitValues.put("rooms", rooms);
        unitValues.put("unitNo", unitNo);

        unit = getUnit(unitValues, bathroomType, price, parking, startDate, endDate, property);
        return unitService.create(unit);

    }
    //function to retrieve the id of the unit
    @RequestMapping(path = "/findByPropertyId")
    public
    @ResponseBody
    Unit findByPropertyId(@RequestParam long id) {
        return unitService.read(id);
    }

    @RequestMapping(path = "/bathroom/{bathroomId}/{parkingId}/{occupationId}/readUnit")
    public
    @ResponseBody
    Unit read(@RequestParam long id) {
        return unitService.read(id);
    }

    @RequestMapping(path = "/bathroom/{bathroomId}/{parkingId}/{occupationId}/updateUnit")
    public
    @ResponseBody
    Unit update(@PathVariable long propertyId,@RequestParam long id, @RequestParam int rooms, @RequestParam int unitNo,
                @RequestParam String bathroomType, @RequestParam float price,
                @RequestParam @DateTimeFormat(pattern = "yyyy/mm/dd") Date startDate,
                @RequestParam @DateTimeFormat(pattern = "yyyy/mm/dd") Date endDate) {
        unitService.read(id);
        Unit updateUnit = new Builder()
                .id(id)
                .rooms(rooms)
                .unitNo(unitNo)
                .bathroomType(bathroomType)
                .price(price)
                .startDate(startDate)
                .endDate(endDate)
                .property(property)
                .build();
        return unitService.update(updateUnit);
    }

    @RequestMapping(path = "/bathroom/{bathroomId}/{parkingId}/{occupationId}/deleteUnit")
    public
    @ResponseBody
    void delete(@PathVariable long parkingId, @RequestParam long id) {
        unitService.delete(id);
    }

}
