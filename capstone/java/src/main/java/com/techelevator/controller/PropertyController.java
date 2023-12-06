package com.techelevator.controller;

import com.techelevator.exception.ServiceException;
import com.techelevator.model.Address;
import com.techelevator.model.Property;
import com.techelevator.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated")
public class PropertyController {
    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    /**
     * /properties
     * /properties?zipcode=90210
     * /properties?state=CA
     * /properties?state=CA&city=Irvine
     * /properties?number_of_rooms=3
     * /properties?is_Available=true
     *
//     * @param zipcode the zipcode to filter by
//     * @param state the state to filter by
//     * @param city  the city to filter by
     * @param address
     * @param numberOfRooms  the number of rooms to filter by
     * @param isAvailable  the availability to filter by
     * @return a list of properties that match the search parameters
     */
    @PreAuthorize("permitAll")
    @GetMapping("/properties")
    public List<Property> listProperties (@RequestParam(required = false) Address address, @RequestParam(required = false) int numberOfRooms, @RequestParam(required = false) BigDecimal rent, @RequestParam(required = false) boolean isAvailable) {
//        try {
//            return propertyService.searchProperties(address, numberOfRooms, rent, isAvailable);
//        } catch (ServiceException e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
//        }
        return null;
    }

    /**
     *
     * @param id the id of the property
     * @return all info for a given property
     */
    @PreAuthorize("permitAll")
    @GetMapping("/properties/{id}")
    public Property fetchProperty(@PathVariable int id, Principal principal) {
        try {
            return propertyService.viewPropertyById(principal,id);
        } catch (ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }
    }

    /**
     *
     * @param username the username of the user
     * @return all properties managed by that user
     */
    @PreAuthorize("hasRole'ROLE_ADMIN'")
    @GetMapping("/properties/{username}")
    public List<Property> fetchPropertiesInfoByUsername(@PathVariable String username, Principal principal) {
        try {
            return propertyService.viewPropertiesByUsername(principal, username);
        } catch (ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }
    }
    //    As a property owner, I want to be able to see the data for my properties (average rent, vacancy%, etc.)

}
