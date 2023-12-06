package com.techelevator.service;

import com.techelevator.dao.ServiceRequestDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ServiceRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService{+
    private ServiceRequestDao serviceRequestDao;
    private UserDao userDao;

    public ServiceRequestServiceImpl(ServiceRequestDao serviceRequestDao, UserDao userDao) {
        this.serviceRequestDao = serviceRequestDao;
        this.userDao = userDao;
    }

    @Override
    public List<ServiceRequest> viewAllServiceRequests(Principal principal) {
        List<>
        return null;
    }

    @Override
    public List<ServiceRequest> viewServiceRequestsByStatus(Principal principal, String status) {
        return null;
    }

    @Override
    public ServiceRequest viewServiceRequestById(Principal principal, int serviceRequestId) {
        return null;
    }

    @Override
    public ServiceRequest createServiceRequest(Principal principal, ServiceRequest serviceRequest) {
        return null;
    }

    @Override
    public ServiceRequest approveServiceRequest(Principal principal, ServiceRequest serviceRequest) {
        return null;
    }

    @Override
    public ServiceRequest rejectServiceRequest(Principal principal, ServiceRequest serviceRequest) {
        return null;
    }
}
