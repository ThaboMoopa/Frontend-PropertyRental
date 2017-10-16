package com.rentalproperty.Factories;

import com.rentalproperty.domain.Address;
import com.rentalproperty.domain.Property;

import java.util.Map;

public class AddressFactory {
    public static Address getAddress(Map<String, String> addressValues, Property property)
    {
        Address address = new Address.Builder()
                .street(addressValues.get("street"))
                .city(addressValues.get("city"))
                .province(addressValues.get("province"))
                .postalCode(addressValues.get("postalCode"))
                .property(property)
                .build();
        return address;
    }
}
