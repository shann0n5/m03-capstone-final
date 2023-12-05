package com.techelevator.model;

import javax.validation.constraints.NotNull;

public class ServiceRequest {
    @NotNull( message = "The field 'serviceRequestId' is required.")
    private int serviceRequestId;
    @NotNull( message = "The field 'requestDetails' is required.")
    private String requestDetails;
    @NotNull( message = "The field 'status' is required.")
    //Status: Open, In Prog, Complete
    private String status;

    public ServiceRequest(int serviceRequestId, String requestDetails, String status) {
        this.serviceRequestId = serviceRequestId;
        this.requestDetails = requestDetails;
        this.status = status;
    }

    public int getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(int serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(String requestDetails) {
        this.requestDetails = requestDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
