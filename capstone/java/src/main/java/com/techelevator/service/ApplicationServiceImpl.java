package com.techelevator.service;

import com.techelevator.dao.ApplicationDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Application;

import java.security.Principal;
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
        return null;
    }

    @Override
    public List<Application> viewApplicationsByStatus(Principal principal) {
        return null;
    }

    @Override
    public Application viewApplicationById(Principal principal, int applicationId) {
        //use principal to get username, check role and make sure its an admin
        //
        //
        return null;
    }

    @Override
    public Application createApplication(Principal principal) {
        return null;
    }

    @Override
    public Application approveApplication(Principal principal, int applicationId) {
        return null;
    }

    @Override
    public Application rejectApplication(Principal principal, int applicationId) {
        return null;
    }
}
