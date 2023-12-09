package com.techelevator.dao;

import com.techelevator.model.ServiceRequest;

import java.util.List;

public interface ServiceRequestDao {
    List<ServiceRequest> getServiceRequestsByManagerUsername(String username);
    List<ServiceRequest> getServiceRequestsByTenantUsername(String username);
    ServiceRequest getServiceRequestById(int serviceRequestId);

    //Status: Open, In Prog, Complete
    List<ServiceRequest> getServiceRequestByStatus(String status, int userId);

    ServiceRequest createServiceRequest(ServiceRequest serviceRequest);

    ServiceRequest updateServiceRequest(ServiceRequest serviceRequest);

    int deleteServiceRequestById(int serviceRequestId);
}
