package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ServiceRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcServiceRequestDao implements ServiceRequestDao {

    private JdbcTemplate jdbcTemplate;

    private List<ServiceRequest> serviceRequests = new ArrayList<>();

    public JdbcServiceRequestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override //ADMIN accessing service requests to their properties
    public List<ServiceRequest> getServiceRequestsByManagerUsername(String username) {
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        String sql = "SELECT service_request_id, tenant_id, request_details, status " +
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


    @Override //TENANT accessing their own service requests
    public List<ServiceRequest> getServiceRequestsByTenantUsername(String username) {
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        String sql = "SELECT sr.service_request_id, sr.tenant_id, sr.request_details, sr.status " +
                "FROM service_requests sr " +
                "JOIN tenant_profiles tp ON sr.tenant_id = tp.tenant_id " +
                "JOIN users u ON tp.user_id = u.user_id " +
                "WHERE u.username = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
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
//        String status = "";
//        String open = "Open";
//        String inProg = "In Prog";
//        String complete = "Complete";
        ServiceRequest request = null;
        String sql = "INSERT INTO service_requests (request_details, status) " +
                "VALUES (?, ?) RETURNING service_request_id;";
        try {
//            if ((serviceRequest.getStatus().toLowerCase()).contains(open.toLowerCase())) {
//                serviceRequest.setStatus(open);
//            } else if ((serviceRequest.getStatus().toLowerCase()).contains(inProg.toLowerCase())) {
//                serviceRequest.setStatus(inProg);
//            } else if ((serviceRequest.getStatus().toLowerCase()).contains(complete.toLowerCase())) {
//                serviceRequest.setStatus(complete);
//            }
//            status = jdbcTemplate.queryForObject(sql, String.class, serviceRequest.getServiceRequestId(),
//                    serviceRequest.getRequestDetails(), serviceRequest.getStatus());
            int requestId = jdbcTemplate.queryForObject(sql, int.class, serviceRequest.getRequestDetails(),
                    serviceRequest.getStatus());
            request = getServiceRequestById(requestId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return request;
    }

    @Override
    public ServiceRequest updateServiceRequest(ServiceRequest serviceRequest) {
        ServiceRequest updatedServiceRequest = null;
        String sql = "UPDATE service_requests " +
                "SET request_details = ?, status = ? " +
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
        serviceRequest.setTenantId(results.getInt("tenant_id"));
        serviceRequest.setRequestDetails(results.getString("request_details"));
        serviceRequest.setStatus(results.getString("status"));
        return serviceRequest;
    }
}
