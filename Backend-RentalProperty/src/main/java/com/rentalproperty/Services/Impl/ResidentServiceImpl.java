package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.ResidentRepository;
import com.rentalproperty.Services.ResidentService;
import com.rentalproperty.domain.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by thabomoopa on 17/08/2017.
 */
@Component
public class ResidentServiceImpl implements ResidentService {

    @Autowired
    ResidentRepository residentService;


    @Override
    public Resident create(Resident resident) {
        return residentService.save(resident);
    }

    @Override
    public Resident read(long id) {
        return residentService.findOne(id);
    }

    @Override
    public Resident update(Resident resident) {
        return residentService.save(resident);
    }

    @Override
    public void delete(long id) {
        residentService.delete(id);
    }

    @Override
    public Resident readEmailFindID(String email) {
        return residentService.findByEmail(email);
    }

    @Override
    public Resident findByEmail(String email)
    {
        return residentService.findByEmail(email);

    }

}
