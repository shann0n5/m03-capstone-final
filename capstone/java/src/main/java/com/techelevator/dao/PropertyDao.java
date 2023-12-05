package com.techelevator.dao;

import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDao {

    List<Property> getProperties();

    Property getPropertyById(int propertyId);

    //TODO get property by zipcode = use Address class
    //Property getPropertyByZipcode(int zipcode); where zipcode = address.zipcode
    Property getPropertyByNumberOfRooms(int numberOfRooms);

    List<Property> getPropertiesByAvailability(boolean isAvailable);

    Property createProperty(Property property);

    Property updateProperty(Property property);

    int deleteProperty(int propertyId);


}
