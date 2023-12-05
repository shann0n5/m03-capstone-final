package com.techelevator.service;

import com.techelevator.model.Property;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService{
    @Override
    public List<Property> viewAllProperties(Principal principal) {
        return null;
    }

    @Override
    public Property viewPropertyById(Principal principal, int propertyId) {
        return null;
    }

    @Override
    public List<Property> viewPropertiesByNumberOfRooms(Principal principal, int numberOfRooms) {
        return null;
    }

    @Override
    public List<Property> viewPropertiesByZipcode(Principal principal, String zip) {
        return null;
    }

    @Override
    public List<Property> viewPropertiesByAvailability(Principal principal, boolean isAvailable) {
        return null;
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
