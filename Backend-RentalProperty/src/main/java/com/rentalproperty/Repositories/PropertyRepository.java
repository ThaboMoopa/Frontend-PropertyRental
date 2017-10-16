package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Long> {
//    Property create(Property property);
//    Property read(long id);
//    Property update(Property property);
//    void delete(long id);
    Property findByPropertyNumber(int propertyNumber);
}
