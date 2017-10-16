package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Resident;
import org.springframework.data.repository.CrudRepository;

public interface ResidentRepository extends CrudRepository<Resident, Long> {
    Resident findByEmail(String email);
    //Resident findByEmail(String email);
//    Resident read(long id);
//    Resident update(Resident resident);
//    void delete(long id);
}
