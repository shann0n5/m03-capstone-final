package com.techelevator.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Property {


    private int propertyId;

    @NotNull( message = "The field 'address' is required.")
    private Address address;

    @Min( value = 1, message = "The minimum number of rooms is 1.")
    private int numberOfRooms;

    @NotNull( message = "The field 'rent' is required.")
    private BigDecimal rent;

    @NotNull( message = "The field 'isAvailable' is required.")
    private boolean isAvailable;
    @NotNull( message = "The field 'isOwner' is required.")
    private boolean isOwner;

    public Property() {}

    public Property(int propertyId, Address address, int numberOfRooms, BigDecimal rent, boolean isAvailable, boolean isOwner) {
        this.propertyId = propertyId;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.rent = rent;
        this.isAvailable = isAvailable;
        this.isOwner = isOwner;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setIsOwner(boolean owner) {
        isOwner = owner;
    }
}
