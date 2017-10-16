package com.rentalproperty.Factories;

import com.rentalproperty.domain.Address;
import com.rentalproperty.domain.Property;
import com.rentalproperty.domain.Unit;

import java.util.List;

public class PropertyFactory {
    public static Property getProperty(String propertyName, int propertyNumber)
    {
        Property property = new Property.Builder()
                .propertyName(propertyName)
                .propertyNumber(propertyNumber)
                .build();
        return property;
    }
}
