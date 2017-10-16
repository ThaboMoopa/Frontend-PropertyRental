package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.AddressRepository;
import com.rentalproperty.Services.AddressService;
import com.rentalproperty.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by thabomoopa on 17/08/2017.
 */
@Component
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address read(long id) {
        return addressRepository.findOne(id);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(long id) {
        addressRepository.delete(id);

    }

    @Override
    public Address findByPropertyID(long propertyID) {
        return addressRepository.findById(propertyID);
    }

}
