package com.techelevator.model;

import java.util.Objects;
import java.util.UUID;

// This was taken from Securing APIs Lecture Final
public class Address {
    private String id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;

    public Address(){

    }

    public Address(String id, String address1, String address2, String city, String state, String zipcode) {
        this.id = id;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    public Address(String address1, String address2, String city, String state, String zipcode) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getId() {
        return id;
    }
    public void setId(String addressId) {
        this.id = addressId;
    }

    private void setRandomId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address addressOne = (Address) o;
        return id.equals(addressOne.id) && address1.equals(addressOne.address1) && address2.equals(addressOne.address2) && city.equals(addressOne.city) && state.equals(addressOne.state) && zipcode.equals(addressOne.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address1, address2, city, state, zipcode);
    }
}



