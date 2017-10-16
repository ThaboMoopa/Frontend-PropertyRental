package com.rentalproperty.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Unit implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int rooms;
    private int unitNo;
    private int parking;
    private float price;
    private Date startDate;
    private Date endDate;
    private String bathroomType;

  @ManyToOne
   private Property property;


   private Unit()
   {

   }

    public Unit(Builder builder) {
        this.id = builder.id;
        this.rooms = builder.rooms;
        this.unitNo = builder.unitNo;
        this.parking = builder.parking;
        this.price = builder.price;
        this.bathroomType = builder.bathroomType;
        this.property = builder.property;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;


    }
    public static class Builder{
        private long id;
        private int rooms;
        private int unitNo;
        private int parking;
        private float price;
        private Date startDate;
        private Date endDate;
        private String bathroomType;
        private Property property;

     public Builder startDate(Date value)
     {
         this.startDate = value;
         return this;
     }
     public Builder endDate(Date value)
     {
         this.endDate = value;
         return this;
     }
        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder rooms(int value)
        {
            this.rooms = value;
            return this;
        }
        public Builder unitNo(int value)
        {
            this.unitNo = value;
            return this;
        }
        public Builder parking(int value)
        {
            this.parking = value;
            return this;
        }
        public Builder price(float value)
        {
            this.price = value;
            return this;
        }
        public Builder bathroomType(String value)
        {
            this.bathroomType = value;
            return this;
        }
        public Builder property(Property value)
        {
            this.property = value;
            return this;
        }


        public Unit build()
        {
            return new Unit(this);
        }
    }

    public long getId() {
        return id;
    }

    public int getRooms() {
        return rooms;
    }

    public int getUnitNo() {
        return unitNo;
    }

    public int isParking() {
        return parking;
    }

    public float getPrice() {
        return price;
    }

    public String getBathroom() {
        return bathroomType;
    }


    public String getBathroomType() {
        return bathroomType;
    }


    public Property getProperty() {
        return property;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        return id == unit.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}

