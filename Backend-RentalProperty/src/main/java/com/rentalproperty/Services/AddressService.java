package com.rentalproperty.Services;

import com.rentalproperty.domain.Address;

/**
 * Created by thabomoopa on 17/08/2017.
 */
public interface AddressService {
    Address save(Address address);
    Address read(long id);
    Address update(Address address);
    void delete(long id);
    Address findByPropertyID(long propertyID);
}
