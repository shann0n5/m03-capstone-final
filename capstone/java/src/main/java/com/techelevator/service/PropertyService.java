package com.techelevator.service;

import com.techelevator.model.Address;
import com.techelevator.model.Property;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface PropertyService {

    List<Property> searchProperties(Address address, int numberOfRooms, BigDecimal rent, boolean isAvailable);

//    List<Property> viewAllProperties(Principal principal);

    Property viewPropertyById(Principal principal, int propertyId);

    List<Property> viewPropertiesByUsername(Principal principal, String username);

//    List<Property> viewPropertiesByNumberOfRooms(Principal principal, int numberOfRooms);

//    List<Property> viewPropertiesByZipcode(Principal principal, String zip);

//    List<Property> viewPropertiesByAvailability(Principal principal, boolean isAvailable);

    Property createProperty(Principal principal, Property property);

    Property updateProperty(Principal principal, int propertyId, Property updatedProperty);

}
