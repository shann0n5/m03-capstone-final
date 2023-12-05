package com.techelevator.dao;

import com.techelevator.model.Application;

import java.util.List;

public interface ApplicationDao {
    List<Application> getApplications();
    List<Application> getApplicationsByPropertyId(int propertyId);

    Application getApplicationById(int applicationId);

    //Status: Pending, Rejected, Withdrawn
    List<Application> getApplicationsByStatus(String status);

    Application createApplication(Application application);

    Application updateApplication(Application application);

    int deleteApplication(int applicationId);

}
