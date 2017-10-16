package com.rentalproperty.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class OrderLine implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int orderLineNumber;
    @OneToOne
    private Property property;

    @ManyToOne
    private Orders orders;

    private OrderLine()
    {

    }

    public OrderLine(Builder builder) {
        this.id = builder.id;
        this.orderLineNumber = builder.orderLineNumber;
        this.property = builder.property;
        this.orders = builder.orders;

    }
    public static class Builder{
        private long id;
        private int orderLineNumber;
        private Property property;
        private Orders orders;

        public Builder orderLine(int value)
        {
            this.orderLineNumber = value;
            return this;
        }

        public Builder orders(Orders value)
        {
            this.orders = value;
            return this;
        }

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }


        public Builder property(Property value)
        {
            this.property = value;
            return this;
        }

        public OrderLine build()
        {
            return new OrderLine(this);
        }
    }

    public long getId() {
        return id;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public Property getProperty() {
        return property;
    }

    public Orders getOrders() {
        return orders;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderLine that = (OrderLine) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
