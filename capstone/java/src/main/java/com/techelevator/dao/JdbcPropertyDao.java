package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Property;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPropertyDao implements PropertyDao {

    private final JdbcTemplate jdbcTemplate;

    private final List<Property> properties = new ArrayList<>();

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
    public Property createProperty(Property property, Principal principal) {
       // int newPropertyId;

        try {
            String sql = "INSERT INTO properties (address, number_of_rooms, rent, is_available, is_owner) " +
                    "VALUES (?, ?, ?, ?, ?) RETURNING property_id;";

            int  newPropertyId = jdbcTemplate.queryForObject(sql, int.class, property.getAddress(), property.getNumberOfRooms(), property.getRent(), property.isAvailable(), property.isOwner());
            sql = " INSERT INTO user_properties (user_id, property_id) SELECT user_id, ? " +
                    "FROM users " +
                    "WHERE username = ?;";
            jdbcTemplate.queryForObject(sql, void.class, newPropertyId, principal.getName());
            return getPropertyById(newPropertyId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
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
        Property property = new Property(results.getInt("property_id"), results.getString("address"), results.getInt("number_of_rooms"), results.getBigDecimal("rent"), results.getBoolean("is_available"), results.getBoolean("is_owner"));

        return property;
    }

    // THIS SHOULD BE FILTERED IN VUE BY RETURNING ALL PROPERTIES
//    @Override
//    public List<Property>  getPropertiesByNumberOfRooms(int numberOfRooms) {
//        List<Property> properties = new ArrayList<>();
//        String sql = "SELECT property_id, address_id, number_of_rooms, rent, is_available, is_owner " +
//                "FROM properties " +
//                "WHERE number_of_rooms = ?;";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, numberOfRooms);
//            while (results.next()) {
//                properties.add(mapRowToProperty(results));
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return properties;
//    }
//    @Override
//    public List<Property> getPropertiesByRent(BigDecimal rent) {
//        List<Property> properties = new ArrayList<>();
//        String sql = "SELECT property_id, address, number_of_rooms, rent, is_available, is_owner " +
//                "FROM properties " +
//                "WHERE rent = ?;";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, rent);
//            while (results.next()) {
//                properties.add(mapRowToProperty(results));
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return properties;
////    }
//@Override
//public List<Property> getPropertiesByZipcode(String zipcode) {
//    List<Property> properties = new ArrayList<>();
//
//    String sql = "SELECT property_id, address, number_of_rooms, rent, is_available, is_owner " +
//            "FROM properties p " +
//            "JOIN addresses ON p.property_id = a.property_id" +
//            "WHERE zipcode = ?;";
//    try {
//        SqlRowSet results = null;
//        if (zipcode != null && !zipcode.isEmpty()) {
//            results = jdbcTemplate.queryForRowSet(sql, zipcode);
//        }
//        while (true) {
//            assert results != null;
//            if (!results.next()) break;
//            Property property = mapRowToProperty(results);
//            properties.add(property);
//        }
//    } catch (CannotGetJdbcConnectionException e) {
//        throw new DaoException("Unable to connect to server or database", e);
//    }
//    return properties;
//}
//
//    @Override
//    public List<Property> getPropertiesByCityState(String state, String city) {
//        final String SQL_WHERE_CITY_STATE = "WHERE a.city = ? AND a.state = ?;";
//        final String SQL_WHERE_CITY = "WHERE a.city = ?;";
//        final String SQL_WHERE_STATE = "WHERE a.state = ?;";
//        List<Property> properties = new ArrayList<>();
//        SqlRowSet results = null;
//        String sql = "SELECT p.property_id, p.address, p.number_of_rooms, p.rent, p.is_available, p.is_owner " +
//                "a.address_id, a.address, a.address2, a.city, a.state, a.zipcode " +
//                "FROM properties p " +
//                "JOIN addresses ON p.property_id = a.property_id ";
//
//        try {
//
//            if (state != null && !state.isEmpty() && city != null && !city.isEmpty()) {
//                sql += SQL_WHERE_CITY_STATE;
//                results = jdbcTemplate.queryForRowSet(sql, state, city);
//            } else if (state != null && !state.isEmpty()) {
//                sql += SQL_WHERE_STATE;
//                results = jdbcTemplate.queryForRowSet(sql, state);
//            } else if (city != null && !city.isEmpty()) {
//                sql += SQL_WHERE_CITY;
//                results = jdbcTemplate.queryForRowSet(sql, city);
//            } else {
//                results = jdbcTemplate.queryForRowSet(sql);
//            }
//
//            while (results.next()) {
//                Property property = mapRowToProperty(results);
//                properties.add(property);
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return properties;
//    }
//
//    @Override
//    public List<Property> getPropertiesByAvailability(boolean isAvailable) {
//        List<Property> properties = new ArrayList<>();
//
//        String sql = "SELECT property_id, address, number_of_rooms, rent, is_available, is_owner " +
//                "FROM properties " +
//                "WHERE is_available = ?";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, isAvailable);
//            while (results.next()) {
//                properties.add(mapRowToProperty(results));
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return properties;
//    }
}
