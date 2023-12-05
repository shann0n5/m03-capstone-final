package com.techelevator.controller;

import com.techelevator.exception.ServiceException;
import com.techelevator.model.Application;
import com.techelevator.service.ApplicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
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
    @PostMapping("/applications")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Application> addApplication(@Valid Principal principal, @RequestBody Application newApplication){
        Application createdApplication = null;
        try{
            createdApplication = applicationService.createApplication(principal, newApplication);
            if(createdApplication == null){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return ResponseEntity.ok(createdApplication);
            }
        } catch (ServiceException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("applications/{status}")
    public List<Application> getApplicationByStatus(@Valid Principal principal, @PathVariable("status") String status){
        try{
            List<Application> applications = applicationService.viewApplicationsByStatus(principal, status);
            return applications;
        }catch (ServiceException e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Server error encountered");
        }
    }

    @GetMapping("applications/{id}")
    public Application getApplicationById(@Valid Principal principal, @PathVariable("id") int applicationId){
        try{

            return null;
        }catch (ServiceException e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Server error encountered");
        }
    }


}
