package com.rentalproperty.Factories;

import com.rentalproperty.domain.Resident;

import java.util.Map;

    public class ResidentFactory {
        public static Resident getResident(Map<String, String> values)
        {
            Resident resident = new Resident.Builder()
                    .name(values.get("name"))
                    .surname(values.get("surname"))
                    .email(values.get("email"))
                    .contact(values.get("contact"))
                    .password(values.get("password"))
                    .build();
            return resident;
        }
    }


