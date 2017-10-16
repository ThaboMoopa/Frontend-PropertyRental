package com.rentalproperty.Repositories;

import com.rentalproperty.domain.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
    Orders findByOrderNumber(long orderNumber);
}
