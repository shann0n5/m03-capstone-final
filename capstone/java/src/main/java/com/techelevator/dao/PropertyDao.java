package com.techelevator.dao;

import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDao {

    List<Property> getProperties();

    Property getPropertyById(int propertyId);

    List<Property> getPropertiesByUsername(String username);

    //TODO get property by zipcode = use Address class
    List<Property> getPropertiesByZipcode(String zipcode);

    Property getPropertyByNumberOfRooms(int numberOfRooms);

    List<Property> getPropertiesByAvailability(boolean isAvailable);

    Property createProperty(Property property);

    Property updateProperty(Property property);

    int deleteProperty(int propertyId);


}
