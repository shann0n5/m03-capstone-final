package com.techelevator.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.validation.constraints.NotNull;

public class Application {
    @NotNull( message = "The field 'applicationId' is required.")
    private int applicationId;
    @NotNull( message = "The field 'userId' is required.")
    private int userId;
    @NotNull( message = "The field 'propertyId' is required.")
    private int propertyId;
    @NotNull( message = "The field 'status' is required.")
    //Status: Pending, Rejected, Withdrawn
    private String status;
    @NotNull( message = "The field 'hasRoomates' is required.")
    private boolean hasRoomates;
    private String roomateNames;

    public Application() {}

    public Application(int applicationId, int userId, int propertyId, String status, boolean hasRoomates, String roomateNames) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.propertyId = propertyId;
        this.status = status;
        this.hasRoomates = hasRoomates;
        this.roomateNames = roomateNames;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHasRoomates() {
        return hasRoomates;
    }

    public void setHasRoomates(boolean hasRoomates) {
        this.hasRoomates = hasRoomates;
    }

    public String getRoomateNames() {
        return roomateNames;
    }

    public void setRoomateNames(String roomateNames) {
        this.roomateNames = roomateNames;
    }
}
