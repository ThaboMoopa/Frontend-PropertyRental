package com.rentalproperty.controller;

import com.rentalproperty.Factories.BathroomFactory;
import com.rentalproperty.Services.Impl.BathroomServiceImpl;
import com.rentalproperty.domain.Bathroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.rentalproperty.domain.Bathroom.Builder;


//Addition sign used for spaces
//testscript: localhost:8080/bathroom/addBathroom?id=1&bathroomType=shower+only
@Controller
@RequestMapping(path = "/bathroom")
public class BathroomController {

    private Bathroom bathroom;

    @Autowired
    private BathroomServiceImpl bathroomService;

    @GetMapping(path = "/addBathroom")
    public
    @ResponseBody
    Bathroom create(@RequestParam long id, @RequestParam String bathroomType) {

        bathroom = BathroomFactory.getBathroom(id, bathroomType);
        return bathroomService.create(bathroom);

    }

    @GetMapping(path = "readBathroom")
    public
    @ResponseBody
    Bathroom read(@RequestParam long id) {
        return bathroomService.read(id);
    }

    @GetMapping(path = "/updateBathroom")
    public
    @ResponseBody
    Bathroom update(@RequestParam long id, @RequestParam String bathroomType) {
        bathroomService.read(id);
        Bathroom updateBathroom = new Builder()
                .id(id)
                .bathroomType(bathroomType)
                .build();
        return bathroomService.update(updateBathroom);
    }

    @GetMapping(path = "/deleteBathroom")
    public
    @ResponseBody
    void delete(@RequestParam long id) {
        bathroomService.delete(id);
    }

   // @GetMapping(path = "/showBathroom")
//    public
//    @ResponseBody
//    Iterable<Bathroom> getBathroom() {
//        return bathroomService.findAll();
//    }
}
