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

    private final String STATUS_COMPLETE = "STATUS_COMPLETE";
    private final String STATUS_IN_PROGRESS = "STATUS_IN_PROGRESS";
    private final String STATUS_OPEN = "STATUS_OPEN";

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
        User loggedInUser = userDao.getUserByUsername(principal.getName());
        Authority managerRole = new Authority("ROLE_ADMIN");
        Authority tenantRole = new Authority("ROLE_USER");
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        try {
            if (loggedInUser.getAuthorities().contains(managerRole)) {
                int managerId = serviceRequestDao.getManagerIdFromUserId(loggedInUser.getId());
                 serviceRequests = serviceRequestDao.getManagerServiceRequestsByStatus(status, managerId);
            } else if (loggedInUser.getAuthorities().contains(tenantRole)) {
                int tenantId = serviceRequestDao.getTenantIdFromUserId(loggedInUser.getId());
                serviceRequests = serviceRequestDao.getTenantServiceRequestsByStatus(status, tenantId);
            }
            return serviceRequests;
        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public ServiceRequest viewServiceRequestById(Principal principal, int serviceRequestId) {

        User loggedInUser = userDao.getUserByUsername(principal.getName());
        Authority managerRole = new Authority("ROLE_ADMIN");
        Authority tenantRole = new Authority("ROLE_USER");
        ServiceRequest serviceRequest = null;
        try{
            if(serviceRequestId <= 6000){
                throw new DaoException("Cannot find a service request with id provided.");
            }
            else {
                if(loggedInUser.getAuthorities().contains(managerRole)){
                    int managerId = serviceRequestDao.getManagerIdFromUserId(loggedInUser.getId());
                    serviceRequest = serviceRequestDao.getManagerServiceRequestById(serviceRequestId, managerId);
                } else if (loggedInUser.getAuthorities().contains(tenantRole)) {
                    int tenantId = serviceRequestDao.getTenantIdFromUserId(loggedInUser.getId());
                    serviceRequest = serviceRequestDao.getTenantServiceRequestById(serviceRequestId, tenantId);
                }
                return serviceRequest;
            }
        }catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public ServiceRequest createServiceRequest(Principal principal, ServiceRequest serviceRequest) {
        User loggedInUser = userDao.getUserByUsername(principal.getName());
        try{
            int tenantId = serviceRequestDao.getTenantIdFromUserId(loggedInUser.getId());
            serviceRequest.setTenantId(tenantId);   // automatically set the tenantId to the user's tenantId
            serviceRequest.setStatus(STATUS_OPEN);  // automatically set status to open
            return serviceRequestDao.createServiceRequest(serviceRequest);


        } catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public ServiceRequest updateServiceRequest(Principal principal, ServiceRequest serviceRequest) {
        List<ServiceRequest> openServiceRequests = viewServiceRequestsByStatus(principal, "STATUS _OPEN");
        ServiceRequest updatedServiceRequest = null;
        try {
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
