package com.rentalproperty.Services;

import com.rentalproperty.Factories.ResidentFactory;
import com.rentalproperty.domain.Resident;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class ResidentServiceTest {
//    Resident resident;
//    long id;
//    Map<String, String> residentValues;
//    ResidentService service;
//
//
//    @BeforeMethod
//    public void setUp() throws Exception {
//
//
//        id = 1;
//        service = new ResidentServiceImpl();
//        //Setup for Resident
//        residentValues = new HashMap<String, String>();
//        residentValues.put("name", "Thabo");
//        residentValues.put("surname", "Moopa");
//        residentValues.put("email", "Thabo.moopa@gmail.com");
//        residentValues.put("contact", "0849262255");
//        residentValues.put("password", "John1moopa");
//
//    }
//
//    @Test
//    public void create() throws Exception {
//        //Resident resident = ResidentFactory.getResident(id,residentValues);
//        service.create(resident);
//        assertEquals(resident.getName(), "Thabo");
//    }
//
//    @Test(dependsOnMethods = {"create"})
//    public void read() throws Exception {
//        resident = service.read(1);
//        assertEquals("Moopa", resident.getSurname());
//    }
//
//    @Test(dependsOnMethods = {"read","create"})
//    public void update() throws Exception {
//        resident = service.read(1);
//        Resident updateResident = new Resident.Builder()
//                .id(id)
//                .name(residentValues.get("name"))
//                .surname(residentValues.get("surname"))
//                .contact("0829379914")
//                .email(residentValues.get("email"))
//                .password(residentValues.get("password"))
//                .build();
//        service.update(updateResident);
//        resident = service.read(1);
//        assertEquals(resident.getContact(), "0829379914");
//    }
//
//    @Test(dependsOnMethods = {"create", "read"})
//    public void delete() throws Exception {
//        service.delete(1);
//        resident = service.read(1);
//        assertNull(resident);
//    }

}