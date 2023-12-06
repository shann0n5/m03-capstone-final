package com.techelevator.service;

import com.techelevator.dao.ServiceRequestDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ServiceException;
import com.techelevator.model.ServiceRequest;
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
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        try {
            serviceRequests = serviceRequestDao.getServiceRequests();
            return serviceRequests;
        }catch (DaoException e) {
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public List<ServiceRequest> viewServiceRequestsByStatus(Principal principal, String status) {
//        List<ServiceRequest>
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

//    @Override
//    public ServiceRequest deleteServiceRequest(Principal principal, ServiceRequest serviceRequest) {
//        return null;
//    }
}
