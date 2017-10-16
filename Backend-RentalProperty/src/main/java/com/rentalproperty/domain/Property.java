package com.rentalproperty.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Property implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//   @OneToOne
//    private Address address;

    private String propertyName;
    private int propertyNumber;

//  @ManyToOne
//    private Unit unit;

    private Property()
    {

    }

    public Property(Builder builder) {
        this.id = builder.id;
        this.propertyNumber = builder.propertyNumber;
        this.propertyName = builder.propertyName;
        //this.unit = builder.unit;
    }
    public static class Builder{
        private long id;
        private String propertyName;
        private int propertyNumber;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder propertyName(String value)
        {
            this.propertyName = value;
            return this;
        }
        public Builder propertyNumber(int value)
        {
            this.propertyNumber = value;
            return this;
        }
//        public Builder unit(Unit value)
//        {
//            this.unit = value;
//            return this;
//        }
        public Property build()
        {
            return new Property(this);
        }
    }

    public long getId() {
        return id;
    }

//    public Address getAddress() {
//        return address;
//    }

    public String getPropertyName() {
        return propertyName;
    }

//    //public Unit getUnit() {
//        return unit;
//    }


    public int getPropertyNumber() {
        return propertyNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        return id == property.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
