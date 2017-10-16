//package com.rentalproperty.controller;
//
//import com.rentalproperty.Factories.ParkingFactory;
//import com.rentalproperty.Services.Impl.ParkingServiceImpl;
//import com.rentalproperty.domain.Parking;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import static com.rentalproperty.domain.Parking.Builder;
//import static java.awt.Color.blue;
//
//
////TestScript: http://localhost:8080/addParking?id=1&parkingNumber=24&price=4500.00
//@Controller
//
//public class ParkingController {
//
//    private Parking parking;
//    @Autowired
//    private ParkingServiceImpl parkingService;
//
//    @RequestMapping(path = "/addParking")
//    public
//    @ResponseBody
//    Parking create(@RequestParam long id, @RequestParam int parkingNumber, @RequestParam double price) {
//
//        parking = ParkingFactory.getParking(id, parkingNumber, price);
//        return parkingService.create(parking);
//    }
//    //localhost:8080/readParking?id=1
//    @RequestMapping(path = "/readParking")
//    public
//    @ResponseBody
//    Parking read(@RequestParam long id) {
//        return parkingService.read(id);
//    }
//
//    @RequestMapping(path = "/updateParking")
//    public
//    @ResponseBody
//    Parking update(@RequestParam long id, @RequestParam int parkingNumber, @RequestParam double price) {
//        parkingService.read(id);
//        Parking updateParking = new Builder()
//                .id(id)
//                .parkingNumber(parkingNumber)
//                .price(price)
//                .build();
//        return parkingService.update(updateParking);
//    }
//    //localhost:8080/deleteParking?id=1
//    @RequestMapping(path = "/deleteParking")
//    public
//    @ResponseBody
//    void delete(@RequestParam long id) {
//        parkingService.delete(id);
//    }
//
//    //@RequestMapping(path = "/showParking")
////    public
////    @ResponseBody
////    Iterable<Parking> getParking() {
////        return parkingService.findAll();
////    }
//
//}
