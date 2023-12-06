package com.techelevator.service;

import com.techelevator.exception.DaoException;
import com.techelevator.exception.ServiceException;
import com.techelevator.model.Address;
import com.techelevator.model.Property;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService{

}
    @Override
    public List<Property> searchProperties(Address address, int numberOfRooms, BigDecimal rent, boolean isAvailable) {
        return null;
    }

    @Override
    public Property viewPropertyById(Principal principal, int propertyId) {
        try {
            Property property =
            return property;
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());


    }

//    @Override
//    public List<Property> viewPropertiesByNumberOfRooms(Principal principal, int numberOfRooms) {
//        return null;
//    }
//
//    @Override
//    public List<Property> viewPropertiesByZipcode(Principal principal, String zip) {
//        return null;
//    }
//
//    @Override
//    public List<Property> viewPropertiesByAvailability(Principal principal, boolean isAvailable) {
//        return null;
//    }
    @Override
    public List<Property> viewPropertiesByUsername(Principal principal, String username) {

    }

    @Override
    public Property createProperty(Principal principal, Property property) {
        return null;
    }

    @Override
    public Property updateProperty(Principal principal, int propertyId, Property updatedProperty) {
        return null;
    }
}
