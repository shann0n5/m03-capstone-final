package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Address;
import com.techelevator.model.Property;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
        }
        return properties;
    }

    @Override
    public Property getPropertyById(int propertyId) {
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
        }
        return property;
    }

    @Override
    public List<Property> getPropertiesByUsername(String username) {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT p.property_id, p.address, p.number_of_rooms, p.rent, p.is_available, p.is_owner " +
                "FROM properties p " +
                "JOIN user_properties up ON p.property_id = up.property_id " +
                "JOIN users u ON up.user_id = u.user_id " +
                "WHERE username = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()) {
                properties.add(mapRowToProperty(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return properties;
    }

    @Override
    public List<Property> getPropertiesByZipcode(String zipcode) {
        List<Property> properties = new ArrayList<>();

        String sql = "SELECT property_id, address, number_of_rooms, rent, is_available, is_owner " +
                "FROM properties p " +
                "JOIN addresses ON p.property_id = a.property_id" +
                "WHERE zipcode = ?;";
        try {
            SqlRowSet results = null;
            if (zipcode != null && !zipcode.isEmpty()) {
                results = jdbcTemplate.queryForRowSet(sql, zipcode);
            }
            while (true) {
                assert results != null;
                if (!results.next()) break;
                Property property = mapRowToProperty(results);
                properties.add(property);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return properties;
    }

    public List<Property> getPropertiesByStateAndCity(String state, String city) {
        final String SQL_WHERE_CITY_STATE = "WHERE a.city = ? AND a.state = ?;";
        final String SQL_WHERE_CITY = "WHERE a.city = ?;";
        final String SQL_WHERE_STATE = "WHERE a.state = ?;";
        List<Property> properties = new ArrayList<>();
        SqlRowSet results = null;
        String sql = "SELECT p.property_id, p.address, p.number_of_rooms, p.rent, p.is_available, p.is_owner " +
                "a.address_id, a.address, a.address2, a.city, a.state, a.zipcode " +
                "FROM properties p " +
                "JOIN addresses ON p.property_id = a.property_id ";

        try {

            if (state != null && !state.isEmpty() && city != null && !city.isEmpty()) {
                sql += SQL_WHERE_CITY_STATE;
                results = jdbcTemplate.queryForRowSet(sql, state, city);
            } else if (state != null && !state.isEmpty()) {
                sql += SQL_WHERE_STATE;
                results = jdbcTemplate.queryForRowSet(sql, state);
            } else if (city != null && !city.isEmpty()) {
                sql += SQL_WHERE_CITY;
                results = jdbcTemplate.queryForRowSet(sql, city);
            } else {
                results = jdbcTemplate.queryForRowSet(sql);
            }

            while (results.next()) {
                Property property = mapRowToProperty(results);
                properties.add(property);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return properties;
    }

    @Override
    public List<Property> getPropertiesByAvailability(boolean isAvailable) {
        List<Property> properties = new ArrayList<>();

        String sql = "SELECT property_id, address, number_of_rooms, rent, is_available, is_owner " +
                "FROM properties " +
                "WHERE is_available = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, isAvailable);
            while (results.next()) {
                properties.add(mapRowToProperty(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return properties;
    }

    @Override
    public Property createProperty(Property property) {
        Integer newPropertyId;
        Integer addressId;
        try {
            String sql = "INSERT INTO address (address, address2, city, state, zipcode, property_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING address_id;";
            addressId = jdbcTemplate.update(sql, property.getAddress().getAddress(), property.getAddress().getAddress2(), property.getAddress().getCity(), property.getAddress().getState(), property.getAddress().getZipcode());

            sql = "INSERT INTO properties (address_id, number_of_rooms, rent, is_available, is_owner) " +
                    "VALUES (?, ?, ?, ?, ?) RETURNING property_id;";

            newPropertyId = jdbcTemplate.queryForObject(sql, Integer.class, property.getAddress(), property.getNumberOfRooms(), property.getRent(), property.isAvailable(), property.isOwner());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return getPropertyById(newPropertyId);
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
                updatedProperty = getPropertyById(property.getPropertyId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedProperty;
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
        property.setNumberOfRooms(results.getInt("number_of_rooms"));
        property.setRent(results.getBigDecimal("rent"));
        property.setIsAvailable(results.getBoolean("is_available"));
        property.setIsOwner(results.getBoolean("is_owner"));

        Address address = new Address();

        address.setId(results.getString("address_id"));
        address.setAddress(results.getString("address"));
        address.setAddress2(results.getString("address2"));
        address.setCity(results.getString("city"));
        address.setState(results.getString("state"));
        address.setZipcode(results.getString("zipcode"));

        property.setAddress(address);
        return property;
    }
}
