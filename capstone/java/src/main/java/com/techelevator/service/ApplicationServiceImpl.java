package com.techelevator.service;

import com.techelevator.dao.ApplicationDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ServiceException;
import com.techelevator.model.Application;
import com.techelevator.model.Property;
import com.techelevator.model.User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class ApplicationServiceImpl implements ApplicationService{
    private ApplicationDao applicationDao;
    private UserDao userDao;
    private PropertyDao propertyDao;

    public ApplicationServiceImpl(ApplicationDao applicationDao, UserDao userDao, PropertyDao propertyDao) {
        this.applicationDao = applicationDao;
        this.userDao = userDao;
        this.propertyDao = propertyDao;
    }

    @Override
    public List<Application> viewAllApplications(Principal principal) {
        List<Property> properties = propertyDao.getPropertiesByUsername(principal.getName());
        List<Application> applications = new ArrayList<>();
        try{
            for(Property property : properties){
                applications.addAll(applicationDao.getApplicationsByPropertyId(property.getPropertyId()));
            }
            return applications;
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public List<Application> viewApplicationsByStatus(Principal principal, String status) {
        List<Property> properties = propertyDao.getPropertiesByUsername(principal.getName());
        List<Application> applications = new ArrayList<>();
        try{
            for(Property property : properties){
                applications.addAll(applicationDao.getApplicationsByStatus(status));
            }
            return applications;
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public Application viewApplicationById(Principal principal, int applicationId) {
        Application application =
        return null;
    }

    @Override
    public Application createApplication(Principal principal, Application application) {

        return null;
    }

    @Override
    public Application approveApplication(Principal principal, int applicationId, Application updatedApplication) {
        return null;
    }


    @Override
    public Application rejectApplication(Principal principal, int applicationId, Application rejectedApplication) {
        return null;
    }
}
