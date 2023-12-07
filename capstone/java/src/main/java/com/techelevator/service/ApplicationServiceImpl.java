package com.techelevator.service;

import com.techelevator.dao.ApplicationDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ServiceException;
import com.techelevator.model.Application;
import com.techelevator.model.Property;
import com.techelevator.model.User;
import org.apache.catalina.core.AprLifecycleListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
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
//        List<Application> applications;
        try{
            for(Property property : properties){
                applications.addAll(applicationDao.getApplicationsByPropertyId(property.getPropertyId()));
            }
//            applications = applicationDao.getApplications();
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
        Application application = null;
//        List<Application> applications = viewAllApplications(principal);
        try {
//            for (Application app : applications) {
//                if (app.getApplicationId() == applicationId) {
//                    application = applicationDao.getApplicationById(app.getApplicationId());
//                }
            if(applicationId <= 3000){
                throw new DaoException("Cannot find an application with id provided.");
            } else{
                application = applicationDao.getApplicationById(applicationId);
            }
            return application;
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public Application createApplication(Principal principal, Application application) {
        try{
            Application newApplication = applicationDao.createApplication(application);
            return newApplication;
        }catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public Application approveApplication(Principal principal, Application updatedApplication) {
        List<Application> pendingApps = viewApplicationsByStatus(principal,"Pending");
        Application updatedApp = null;
        try{
            for(Application app : pendingApps){
                if(app.getApplicationId() == updatedApplication.getApplicationId()){
                    updatedApp = applicationDao.updateApplication(updatedApplication);
                    updatedApp.setStatus("Approved");
                }
            }
            return updatedApp;
        }catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }


    @Override
    public Application rejectApplication(Principal principal, Application rejectedApplication) {
        List<Application> pendingApps = viewApplicationsByStatus(principal, "Pending");
        Application rejectedApp = null;
        try{
            for (Application app: pendingApps){
                if(app.getApplicationId() == rejectedApplication.getApplicationId()){
                    rejectedApp = applicationDao.updateApplication(rejectedApplication);
                }
            }
            return rejectedApp;
        }catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }
}
