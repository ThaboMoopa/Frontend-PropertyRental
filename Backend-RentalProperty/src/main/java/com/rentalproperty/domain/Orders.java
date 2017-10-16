package com.rentalproperty.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long orderNumber;
    private Date ordersDate;

    @ManyToOne
    private Resident resident;

    private Orders()
    {

    }
    public Orders(Builder builder) {
        this.id = builder.id;
        this.ordersDate = builder.ordersDate;
        this.orderNumber = builder.orderNumber;
        this.resident = builder.resident;
    }

    public static class Builder{
        private long id;
        private long orderNumber;
        private Date ordersDate;
        private Resident resident;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder orderNumber(long value)
        {
            this.orderNumber = value;
            return this;
        }
        public Builder ordersDate(Date value)
        {
            this.ordersDate = value;
            return this;
        }

        public Builder resident(Resident value)
        {
            this.resident = value;
            return this;
        }
        public Orders build()
        {
            return new Orders(this);
        }
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return ordersDate;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public Resident getResident() {
        return resident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        return id == orders.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
