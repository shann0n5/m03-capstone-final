package com.techelevator.dao;

import com.techelevator.model.ServiceRequest;

import java.util.List;

public interface ServiceRequestDao {
    List<ServiceRequest> getServiceRequests();

    ServiceRequest getServiceRequestById(int serviceRequestId);

    //Status: Open, In Prog, Complete
    List<ServiceRequest> getServiceRequestByStatus(String status);

    ServiceRequest createServiceRequest(ServiceRequest serviceRequest);

    ServiceRequest updateServiceRequest(ServiceRequest serviceRequest);

    int deleteServiceRequestById(int serviceRequestId);
}
