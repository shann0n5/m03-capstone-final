package com.techelevator.service;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ServiceException;
import com.techelevator.model.Authority;
import com.techelevator.model.Property;
import com.techelevator.model.User;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService{

    private final PropertyDao propertyDao;

    public PropertyServiceImpl(PropertyDao propertyDao, UserDao userDao) {
        this.propertyDao = propertyDao;
    }

    @Override
    public List<Property> viewAllProperties() {
        try {
            return propertyDao.getProperties();
        } catch (DaoException e){
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public Property viewPropertyById(Principal principal, int propertyId) {
        try {
            return propertyDao.getPropertyById(propertyId);
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public List<Property> viewPropertiesByUsername(Principal principal) {
        try {
            return propertyDao.getPropertiesByUsername(principal.getName());
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public Property createProperty(Principal principal, Property propertyToCreate) {
        Property newProperty = null;
//        Authority adminRole = new Authority("ROLE_ADMIN");
        try {
//           User loggedInUser = userDao.getUserByUsername(principal.getName());
//            if (loggedInUser.getAuthorities().contains(adminRole)){
                 newProperty = propertyDao.createProperty(propertyToCreate);
//            }
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
        return newProperty;
    }

    @Override
    public Property updateProperty(Principal principal, int propertyId, Property propertyToUpdateTo) {
        try {
            // resetting the property id to the one they passed in
            propertyToUpdateTo.setPropertyId(propertyId);
            return propertyDao.updateProperty(propertyToUpdateTo);
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public void deleteProperty(Principal principal, int propertyId){
        try {
            propertyDao.deleteProperty(propertyId);
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }
    //    @Override
//    public List<Property> viewPropertiesByNumberOfRooms(Principal principal, int numberOfRooms) {
//        return null;
//    }
//    @Override
//    public List<Property> viewPropertiesByZipcode(Principal principal, String zip) {
//        return null;
//    }
//    @Override
//    public List<Property> viewPropertiesByAvailability(Principal principal, boolean isAvailable) {
//    return null;
//    }

    //    public List<Property> searchPropertiesByZipcode (String zipcode) {
//        try {
//           return propertyDao.getPropertiesByZipcode(zipcode);
//        } catch (DaoException e) {
//            throw new ServiceException("An error has occurred: " + e.getMessage());
//        }
//    }
//    @Override
//    public List<Property> searchPropertiesByStateAndCity (String state, String city) {
//        try {
//            return propertyDao.getPropertiesByCityState(state, city);
//        } catch (DaoException e) {
//            throw new ServiceException("An error has occurred: " + e.getMessage());
//        }
//    }
//    @Override
//    public List<Property> searchPropertiesByNumberOfRooms (int numberOfRooms) {
//        try {
//            return propertyDao.getPropertiesByNumberOfRooms(numberOfRooms);
//        } catch (DaoException e) {
//            throw new ServiceException("An error has occurred: " + e.getMessage());
//        }
//    }
//    @Override
//    public List<Property> searchPropertiesByRent (BigDecimal rent) {
//        try {
//            return propertyDao.getPropertiesByRent(rent);
//        } catch (DaoException e) {
//            throw new ServiceException("An error has occurred: " + e.getMessage());
//        }
//    }
//    @Override
//    public List<Property> searchPropertiesByAvailability (boolean isAvailable) {
//        try {
//            return propertyDao.getPropertiesByAvailability(isAvailable);
//        } catch (DaoException e) {
//            throw new ServiceException("An error has occurred: " + e.getMessage());
//        }
//    }
}
