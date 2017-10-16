package com.rentalproperty.Services;

import com.rentalproperty.domain.Resident;

public interface ResidentService {
    Resident create(Resident Resident);
    Resident read(long id);
    Resident update(Resident resident);
    void delete(long id);

    //function to find the id of client
    Resident readEmailFindID(String email);

    //function to verify that an email address does not exist
     Resident findByEmail(String email);

}
