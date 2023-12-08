package com.techelevator.dao;

import com.techelevator.model.Property;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface PropertyDao {

    List<Property> getProperties();

    Property getPropertyById(int propertyId);

    //List<Property> getPropertiesByUsername(String username);
    List<Property> getPropertiesByTenantUsername(String username);
    List<Property> getPropertiesByManagerUsername(String username);
    Property createProperty(Property property, int userId);

//    List<Property> getPropertiesByCityState(String state, String city);
//
//    List<Property> getPropertiesByZipcode(String zipcode);
//
//    List<Property>  getPropertiesByNumberOfRooms(int numberOfRooms);
//
//    List<Property> getPropertiesByRent(BigDecimal rent);
//
//    List<Property> getPropertiesByAvailability(boolean isAvailable);

   // Property createProperty(Property property, Principal principal);

    Property updateProperty(Property property, int userId);

    int deleteProperty(int propertyId, int userId);


}
