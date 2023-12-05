package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ServiceRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcServiceRequestDao implements ServiceRequestDao {

    private JdbcTemplate jdbcTemplate;

    private List<ServiceRequest> serviceRequests = new ArrayList<>();

    public JdbcServiceRequestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ServiceRequest> getServiceRequests() {
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        String sql = "SELECT service_request_id, request_details, status " +
                "FROM service_requests;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                serviceRequests.add(mapRowToServiceRequest(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return serviceRequests;
    }

    @Override
    public ServiceRequest getServiceRequestById(int serviceRequestId) {
        ServiceRequest serviceRequest = null;
        String sql = "SELECT service_request_id, request_details, status " +
                "FROM service_requests " +
                "WHERE service_request_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, serviceRequestId);
            if (results.next()) {
                serviceRequest = mapRowToServiceRequest(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return serviceRequest;
    }

    @Override
    //Status: Open, In Prog, Complete
    public List<ServiceRequest> getServiceRequestByStatus(String status) {
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        String sql = "SELECT service_request_id, request_details, status " +
                "FROM service_requests " +
                "WHERE status = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, status);
            while (results.next()) {
                serviceRequests.add(mapRowToServiceRequest(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return serviceRequests;
    }

    @Override
    //Status: Open, In Prog, Complete
    public ServiceRequest createServiceRequest(ServiceRequest serviceRequest) {
        String status = "";
        String open = "Open";
        String inProg = "In Prog";
        String complete = "Complete";

        try {
            if ((serviceRequest.getStatus().toLowerCase()).contains(open.toLowerCase())) {
                serviceRequest.setStatus(open);
            } else if ((serviceRequest.getStatus().toLowerCase()).contains(inProg.toLowerCase())) {
                serviceRequest.setStatus(inProg);
            } else if ((serviceRequest.getStatus().toLowerCase()).contains(complete.toLowerCase())) {
                serviceRequest.setStatus(complete);
            }

            String sql = "INSERT INTO service_requests (service_request_id, request_details, status " +
                    "VALUES (?, ?, ?) RETURNING service_request_id;";

            status = jdbcTemplate.queryForObject(sql, String.class, serviceRequest.getServiceRequestId(), serviceRequest.getRequestDetails(), serviceRequest.getStatus());

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return serviceRequest;
    }

    @Override
    public ServiceRequest updateServiceRequest(ServiceRequest serviceRequest) {
        ServiceRequest updatedServiceRequest = null;
        String sql = "UPDATE service_requests " +
                "SET service_request_id = ?, request_details = ?, status = ? " +
                "WHERE service_request_id = ?;";
        try {
            int rowsAffected = jdbcTemplate.update(sql, serviceRequest.getServiceRequestId(), serviceRequest.getRequestDetails(), serviceRequest.getStatus());
            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedServiceRequest = getServiceRequestById(serviceRequest.getServiceRequestId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedServiceRequest;
    }

    @Override
    public int deleteServiceRequestById(int serviceRequestId) {
        int rowsAffected;
        String sql = "DELETE FROM service_requests WHERE service_request_id = ?;";
        try {
            rowsAffected = jdbcTemplate.update(sql, serviceRequestId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return rowsAffected;
    }

    private ServiceRequest mapRowToServiceRequest(SqlRowSet results) {
        ServiceRequest serviceRequest = new ServiceRequest();
                serviceRequest.setServiceRequestId(results.getInt("service_request_id"));
                serviceRequest.setRequestDetails(results.getNString("request_details"));
                serviceRequest.setStatus(results.getNString("status"));

        return serviceRequest;
    }
}
