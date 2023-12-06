package com.techelevator.controller;

import com.techelevator.model.ServiceRequest;
import com.techelevator.service.ServiceRequestService;
import com.techelevator.service.ServiceRequestServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class ServiceRequestController {
    private ServiceRequestServiceImpl serviceRequestService;

    public ServiceRequestController(ServiceRequestServiceImpl serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping("service-requests")
    public List<ServiceRequest> getAllServiceRequests(Principal principal){
        
    }

}
