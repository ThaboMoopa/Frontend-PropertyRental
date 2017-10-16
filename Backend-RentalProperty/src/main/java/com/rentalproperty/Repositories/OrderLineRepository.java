package com.rentalproperty.Repositories;

import com.rentalproperty.domain.OrderLine;
import org.springframework.data.repository.CrudRepository;

public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {
//    OrderLine create(OrderLine orderLine);
//    OrderLine read(long id);
//    OrderLine update(OrderLine orderLine);
//    void delete(long id);
    OrderLine findByOrderLineNumber(int orderLineNumber);

}
