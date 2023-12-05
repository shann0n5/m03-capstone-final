package com.techelevator.service;

import com.techelevator.model.Application;
import org.springframework.security.core.parameters.P;

import java.security.Principal;
import java.util.List;

public interface ApplicationService {
    public List<Application> viewAllApplications(Principal principal);
    public List<Application> viewApplicationsByStatus(Principal principal);
    public Application viewApplicationById(Principal principal, int applicationId);
    public Application createApplication(Principal principal);
    public Application approveApplication(Principal principal, int applicationId);
    public Application rejectApplication(Principal principal, int applicationId);

}
