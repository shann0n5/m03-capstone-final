package com.techelevator.controller;

import com.techelevator.exception.ServiceException;
import com.techelevator.model.Application;
import com.techelevator.service.ApplicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class ApplicationController {
    private ApplicationServiceImpl applicationService;

    public ApplicationController(ApplicationServiceImpl applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/applications")
    public List<Application> getApplications(Principal principal) {
        try{
            List<Application> applications = applicationService.viewAllApplications(principal);
            return applications;
        }catch (ServiceException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered");
        }
    }


}
