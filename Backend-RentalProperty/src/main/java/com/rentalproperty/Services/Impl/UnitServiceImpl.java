package com.rentalproperty.Services.Impl;

import com.rentalproperty.Repositories.UnitRepository;
import com.rentalproperty.Services.UnitService;
import com.rentalproperty.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by thabomoopa on 17/08/2017.
 */
@Component
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitRepository unitService;

    @Override
    public Unit create(Unit unit) {
        return unitService.save(unit);
    }

    @Override
    public Unit read(long id) {
        return unitService.findOne(id);
    }

    @Override
    public Unit update(Unit unit) {
        return unitService.save(unit);
    }

    @Override
    public void delete(long id) {
        unitService.delete(id);
    }
}
