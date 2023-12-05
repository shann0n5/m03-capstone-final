package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Property;
import com.techelevator.model.RentTransaction;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

public class JdbcPropertyDao implements PropertyDao {

    private JdbcTemplate jdbcTemplate;

    private List<Property> properties = new ArrayList<>();

    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();

        String sql = "SELECT property_id, address, number_of_rooms, rent, is_available, is_owner " +
                "FROM properties;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                properties.add(mapRowToProperty(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return properties;
    }

    @Override
    public  Property getPropertyById(int propertyId) {
        Property property = null;
        String sql = "SELECT property_id, address, number_of_rooms, rent, is_available, is_owner " +
                "FROM properties " +
                "WHERE property_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
            if (results.next()) {
                property = mapRowToProperty(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return property;
    }

    @Override
    public Property getPropertyByUsername(String username) {
        Property property = null;
        String sql = "SELECT property_id, address, number_of_rooms, rent, is_available, is_owner " +
                "FROM properties p " +
                "JOIN user_properties up ON p.property_id = up.property_id " +
                "JOIN users u ON up.user_id = u.user_id " +
                "WHERE username = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            if (results.next()) {
                property = mapRowToProperty(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return property;
    }



    //TODO get property by zipcode = use Address class
    //Property getPropertyByZipcode(int zipcode); where zipcode = address.zipcode

    @Override
    public Property getPropertyByNumberOfRooms(int numberOfRooms) {
        Property property = null;
        String sql = "SELECT property_id, address, number_of_rooms, rent, is_available, is_owner " +
                "FROM properties " +
                "WHERE number_of_rooms = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, numberOfRooms);
            if (results.next()) {
                property = mapRowToProperty(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return property;
    }

    @Override
    public List<Property> getPropertiesByAvailability(boolean isAvailable) {

    }

    @Override
    public Property createProperty(Property property) {
        Property newProperty = null;
        String sql = "INSERT INTO rent_transactions (address, number_of_rooms, rent, is_available, is_owner) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING _id;";
        try {
            int newPropertyId = jdbcTemplate.queryForObject(sql, int.class, property.getAddress(),property.getNumberOfRooms(), property.getRent(), property.isAvailable(), property.isOwner());
            newProperty = getPropertyById(newPropertyId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return property;
    }

    @Override
    public Property updateProperty(Property property) {
        Property updatedProperty = null;
        String sql = "UPDATE properties SET address = ?, number_of_rooms = ?, rent = ?, is_available = ?, is_owner = ? " +
                "WHERE property_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, property.getAddress(),
                    property.getNumberOfRooms(), property.getRent(), property.isAvailable(), property.isOwner(), property.getPropertyId());
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedProperty = 
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedRentTransaction;
    }

    @Override
    public int deleteProperty(int propertyId) {
        int rowsAffected;
        String sql = "DELETE FROM properties WHERE property_id = ?;";
        try {
            rowsAffected = jdbcTemplate.update(sql, propertyId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return rowsAffected;
    }

    private Property mapRowToProperty(SqlRowSet results) {
        Property property = new Property();
        property.setPropertyId(results.getInt("property_id"));
        property.setAddress(results.getString("address"));
        property.setNumberOfRooms(results.getInt("number_of_rooms"));
        property.setRent(results.getBigDecimal("rent"));
        property.setIsAvailable(results.getBoolean("is_available"));
        property.setIsOwner(results.getBoolean("is_owner"));
        return property;
    }


}
