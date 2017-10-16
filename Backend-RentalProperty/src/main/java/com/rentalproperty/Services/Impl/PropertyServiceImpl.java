package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.PropertyRepository;
import com.rentalproperty.Services.PropertyService;
import com.rentalproperty.domain.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by thabomoopa on 17/08/2017.
 */
@Component
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyService;

    @Override
    public Property create(Property property) {
        return propertyService.save(property);
    }

    @Override
    public Property read(long id) {
        return propertyService.findOne(id);
    }

    @Override
    public Property update(Property property) {
        return propertyService.save(property);
    }

    @Override
    public void delete(long id) {
        propertyService.delete(id);
    }

    @Override
    public Property findByPropertyNumber(int propertyNumber) {
        return propertyService.findByPropertyNumber(propertyNumber);
    }
}
