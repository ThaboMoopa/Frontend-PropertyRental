package com.rentalproperty.Factories;

import com.rentalproperty.domain.*;

import java.util.Date;
import java.util.Map;

public class UnitFactory {
    public static Unit getUnit(Map<String, Integer> values, String bathroomType,
                               float price, int parking, Date startDate, Date endDate, Property property)
    {
        Unit unit = new Unit.Builder()
                .unitNo(values.get("rooms"))
                .rooms(values.get("unitNo"))
                .bathroomType(bathroomType)
                .price(price)
                .parking(parking)
                .startDate(startDate)
                .endDate(endDate)
                .property(property)
                .build();
        return unit;
    }
}
