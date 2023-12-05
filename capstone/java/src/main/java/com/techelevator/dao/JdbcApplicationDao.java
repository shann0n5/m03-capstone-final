package com.techelevator.dao;

import com.techelevator.Application;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcApplicationDao implements ApplicationDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Application> getApplications() {
        return null;
    }

    @Override
    public Application getApplicationById(int applicationId) {
        return null;
    }

    @Override
    public List<Application> getApplicationsByStatus(String status) {
        return null;
    }

    @Override
    public Application createApplication(Application application) {
        return null;
    }

    @Override
    public Application updateApplication(Application application) {
        return null;
    }

    @Override
    public int deleteApplication(int applicationId) {
        return 0;
    }

    private Application mapToRowApplication(SqlRowSet results){
        Application application = new Application();
        application.setApplicationId(results.getInt());
        return application;
    }
}
