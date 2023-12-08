package com.techelevator.service;

import com.techelevator.dao.ServiceRequestDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ServiceException;
import com.techelevator.model.Authority;
import com.techelevator.model.ServiceRequest;
import com.techelevator.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService{
    private ServiceRequestDao serviceRequestDao;
    private UserDao userDao;

    public ServiceRequestServiceImpl(ServiceRequestDao serviceRequestDao, UserDao userDao) {
        this.serviceRequestDao = serviceRequestDao;
        this.userDao = userDao;
    }

    @Override
    public List<ServiceRequest> viewAllServiceRequests(Principal principal) {
        User loggedInUser = userDao.getUserByUsername(principal.getName());
        Authority managerRole = new Authority("ROLE_ADMIN");
        Authority tenantRole = new Authority("ROLE_USER");
        List<ServiceRequest> serviceRequests = null;
        try {
            if(loggedInUser.getAuthorities().contains(managerRole)){
                serviceRequests = serviceRequestDao.getServiceRequestsByManagerUsername(principal.getName());
            } else if (loggedInUser.getAuthorities().contains(tenantRole)) {
                serviceRequests = serviceRequestDao.getServiceRequestsByTenantUsername(principal.getName());
            }
            return serviceRequests;
        }catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public List<ServiceRequest> viewServiceRequestsByStatus(Principal principal, String status) {
        try {
            List<ServiceRequest> serviceRequests = serviceRequestDao.getServiceRequestByStatus(status);
            return serviceRequests;
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public ServiceRequest viewServiceRequestById(Principal principal, int serviceRequestId) {
        ServiceRequest serviceRequest = null;
        try{
            if(serviceRequestId <= 4000){
                throw new DaoException("Cannot find a service request with id provided.");
            }
            else {
                serviceRequest = serviceRequestDao.getServiceRequestById(serviceRequestId);
                return serviceRequest;
            }
        }catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public ServiceRequest createServiceRequest(Principal principal, ServiceRequest serviceRequest) {
        try{
            ServiceRequest newServiceRequest = serviceRequestDao.createServiceRequest(serviceRequest);
            return newServiceRequest;
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public ServiceRequest updateServiceRequest(Principal principal, ServiceRequest serviceRequest) {
        List<ServiceRequest> openServiceRequests = viewServiceRequestsByStatus(principal, "Open");
        ServiceRequest updatedServiceRequest = null;
        try{
            for (ServiceRequest request : openServiceRequests){
                if(request.getServiceRequestId() == serviceRequest.getServiceRequestId()){
                    updatedServiceRequest = serviceRequestDao.updateServiceRequest(serviceRequest);
                }
            }
            return updatedServiceRequest;
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }

    }

}
