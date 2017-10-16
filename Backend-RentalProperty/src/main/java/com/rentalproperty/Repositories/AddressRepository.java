package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
//    Address create(Address address);
//    Address read(long id);
//    Address update(Address address);
//    void delete(long id);
    Address findById(long propertyID);
}
