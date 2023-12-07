package com.techelevator.dao;

import com.techelevator.model.Application;
import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcApplicationDao implements ApplicationDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Application> getApplications() {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT application_id, user_id, property_id, status, has_roomates, " +
                "roomate_names FROM applications";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                Application application = mapRowToApplication(results);
                applications.add(application);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return applications;
    }

    @Override
    public List<Application> getApplicationsByPropertyId(int propertyId) {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT a.application_id, a.user_id, a.property_id, a.status, a.has_roomates, " +
                "a.roomate_names FROM applications a " +
                "JOIN properties p ON a.property_id = p.property_id " +
                "WHERE a.property_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
            while(results.next()){
                Application application = mapRowToApplication(results);
                applications.add(application);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return applications;
    }

    @Override
    public Application getApplicationById(int applicationId) {
        Application application = null;
        String sql = "SELECT application_id, user_id, property_id, status, has_roomates, " +
                "roomate_names FROM applications WHERE application_id = ?";
        try{
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, applicationId);
            if(result.next()){
                application = mapRowToApplication(result);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return application;
    }

    @Override
    public List<Application> getApplicationsByStatus(String status) {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT SELECT application_id, user_id, property_id, status, has_roomates, " +
                "roomate_names FROM applications WHERE status = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, status);
            while(results.next()){
                Application application = mapRowToApplication(results);
                applications.add(application);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return applications;
    }

    @Override
    public Application createApplication(Application application) {
        Application newApplication = null;
        String sql = "INSERT INTO applications (user_id, property_id, status, has_roomates, " +
                "roomate_names) VALUES (?, ?, ?, ?, ?) RETURNING application_id";
        try{
            int newApplicationId = jdbcTemplate.queryForObject(sql, int.class, application.getUserId(), application.getPropertyId(),
                    application.getStatus(), application.isHasRoomates(), application.getRoomateNames());
            newApplication = getApplicationById(newApplicationId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newApplication;
    }

    @Override
    public Application updateApplication(Application application) {
        Application updatedApplication = null;
        String sql = "UPDATE applications SET user_id = ?, property_id = ?, status = ?, has_roomates = ?, " +
                "roomate_names = ? WHERE application_id = ?";
        try{
            int rowsAffected = jdbcTemplate.update(sql, application.getUserId(), application.getPropertyId(),
                    application.getStatus(), application.isHasRoomates(), application.getRoomateNames(),
                    application.getApplicationId());
            if(rowsAffected == 0){
                throw new DaoException("Zero rows affected, expected at least one");
            }else{
                updatedApplication = getApplicationById(application.getApplicationId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedApplication;
    }

    @Override
    public int deleteApplication(int applicationId) {
        int rowsAffected;
        String sql = "DELETE FROM applications WHERE application_id = ?";
        try{
            rowsAffected = jdbcTemplate.update(sql, applicationId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return rowsAffected;
    }

    private Application mapRowToApplication(SqlRowSet results){
        Application application = new Application();
        application.setApplicationId(results.getInt("application_id"));
        application.setUserId(results.getInt("user_id"));
        application.setPropertyId(results.getInt("property_id"));
        application.setStatus(results.getString("status"));
        application.setHasRoomates(results.getBoolean("has_roomates"));
        application.setRoomateNames(results.getString("roomate_names"));
        return application;
    }
}
