package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.BathroomRepository;
import com.rentalproperty.Services.BathroomService;
import com.rentalproperty.domain.Bathroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by thabomoopa on 17/08/2017.
 */
@Component
public class BathroomServiceImpl implements BathroomService {

    @Autowired
    BathroomRepository bathroomService;

    @Override
    public Bathroom create(Bathroom bathroom) {
        return bathroomService.save(bathroom);
    }

    @Override
    public Bathroom read(long id) {
        return bathroomService.findOne(id);
    }

    @Override
    public Bathroom update(Bathroom bathroom) {
        return bathroomService.save(bathroom);
    }

    @Override
    public void delete(long id) {
        bathroomService.delete(id);

    }
}
