//package com.rentalproperty.Services.Impl;
//
//import com.rentalproperty.Repositories.OccupationRepository;
//import com.rentalproperty.Services.OccupationService;
//import com.rentalproperty.domain.Occupation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * Created by thabomoopa on 17/08/2017.
// */
//@Component
//public class OccupationServiceImpl implements OccupationService {
//
//    @Autowired
//    OccupationRepository occupationService;
//
//    @Override
//    public Occupation create(Occupation occupation) {
//        return occupationService.save(occupation);
//    }
//
//    @Override
//    public Occupation read(long id) {
//        return occupationService.findOne(id);
//    }
//
//    @Override
//    public Occupation update(Occupation occupation) {
//        return occupationService.save(occupation);
//    }
//
//    @Override
//    public void delete(long id) {
//        occupationService.delete(id);
//    }
//}
