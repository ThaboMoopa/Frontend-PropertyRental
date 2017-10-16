package com.rentalproperty.controller;

import com.rentalproperty.Factories.ResidentFactory;
import com.rentalproperty.Repositories.ResidentRepository;
import com.rentalproperty.Services.Impl.ResidentServiceImpl;
import com.rentalproperty.domain.Resident;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.rentalproperty.Factories.ResidentFactory.getResident;
import static com.rentalproperty.domain.Resident.Builder;
import static java.lang.System.out;

@Controller
@RequestMapping(path = "/resident")
public class ResidentController {

    private Resident resident;

    @Autowired
    private ResidentServiceImpl residentService;


    //localhost:8080/resident/addResident?name=John&surname=Moopa&email=thabo.moopa@gmail.com&contact=0849262255&password=John1moopa
    @RequestMapping(path = "/addResident")
    public
    @ResponseBody
    Resident create(@RequestParam String name, @RequestParam String surname,
                    @RequestParam String email, @RequestParam String contact,
                    @RequestParam String password) {
        Map<String, String> residentValues;
        residentValues = new HashMap<String, String>();
        residentValues.put("name", name);
        residentValues.put("surname", surname);
        residentValues.put("email", email);
        residentValues.put("contact", contact);
        residentValues.put("password", password);
        resident = getResident(residentValues);

        residentService.create(resident);
        return resident;

    }

    //http://localhost:8080/resident/readResident?id=1
    @RequestMapping(path = "/readResident")
    public
    @ResponseBody
    Resident read(@RequestParam long id) {
        return residentService.read(id);

    }

    //http://localhost:8080/resident/readResidentEmail?email=thabo.moopa@gmail.com
    //function to verify that the email address does not exist
    @RequestMapping(path = "/readResidentEmail")
    public
    @ResponseBody
    Resident readEmail(@RequestParam String email) {

        return residentService.findByEmail(email);
    }
    //localhost:8080/resident/updateResident?id=1&name=John&surname=Moopa&email=thabo.moopa@gmail.com&contact=0849262255&password=John1moopa
    @RequestMapping(path = "/updateResident")
    public
    @ResponseBody
    Resident update(@RequestParam long id, @RequestParam String name, @RequestParam String surname,
                    @RequestParam String email, @RequestParam String contact,
                    @RequestParam String password) {
        resident = residentService.read(id);
        Resident updateResident = new Builder()
                .id(id)
                .name(name)
                .surname(surname)
                .email(email)
                .contact(contact)
                .password(password)
                .build();

        resident = residentService.update(updateResident);
        return resident;

    }

    //http://localhost:8080/resident/deleteResident?id=1
    @RequestMapping(path = "/deleteResident", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void delete(long id) {
        out.print("deleted");
        residentService.delete(id);
    }

    //http://localhost:8080/resident/findResidentIDbyEmail?email=thabo.moopa@gmail.com
    //function to retrieve the id of the customer
    @RequestMapping(path = "/findResidentIDbyEmail", method = RequestMethod.GET)
    public @ResponseBody
    Resident readEmailFindID(@RequestParam String email)
    {
        return residentService.findByEmail(email);
    }



}
