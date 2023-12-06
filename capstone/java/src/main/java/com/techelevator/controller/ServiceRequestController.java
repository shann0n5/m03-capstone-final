package com.techelevator.controller;

import com.techelevator.model.ServiceRequest;
import com.techelevator.service.ServiceRequestService;
import com.techelevator.service.ServiceRequestServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<ServiceRequest> getAllServiceRequests(@Valid Principal principal){
        return null;
    }

    @PostMapping("service-requests")
    @ResponseStatus(HttpStatus.CREATED) //Status: Open
    public ResponseEntity<ServiceRequest> addServiceRequest(@Valid Principal principal, @RequestBody ServiceRequest newServiceRequest){
        return null;
    }

    @GetMapping("service-requests/{status}")
    public List<ServiceRequest> getServiceRequestsByStatus(@Valid Principal principal, String status){
        return null;
    }

    @GetMapping("service-requests/{id}")
    public ServiceRequest getServiceRequestById(@Valid Principal principal, @PathVariable("id") int serviceRequestId){
        return null;
    }

    @PutMapping("service-requests/approve/{id}") //Status: In Progress
    public ServiceRequest approveServiceRequest(@Valid Principal principal, @PathVariable("id") int serviceRequestId){
        return null;
    }

}
