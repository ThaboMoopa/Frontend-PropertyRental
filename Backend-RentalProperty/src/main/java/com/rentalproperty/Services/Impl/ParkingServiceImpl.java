//package com.rentalproperty.Services.Impl;
//
//import com.rentalproperty.Repositories.ParkingRepository;
//import com.rentalproperty.Services.ParkingService;
//import com.rentalproperty.domain.Parking;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * Created by thabomoopa on 17/08/2017.
// */
//@Component
//public class ParkingServiceImpl implements ParkingService {
//    @Autowired
//    ParkingRepository parkingService;
//
//    @Override
//    public Parking create(Parking parking) {
//        return parkingService.save(parking);
//    }
//
//    @Override
//    public Parking read(long id) {
//        return parkingService.findOne(id);
//    }
//
//    @Override
//    public Parking update(Parking parking) {
//        return parkingService.save(parking);
//    }
//
//    @Override
//    public void delete(long id) {
//        parkingService.delete(id);
//    }
//}
