package com.techelevator.dao;

import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);

    //TODO get users by property id????? check if principal = admin then show users by property id

    // List<User> getUsersByProperty(int propertyId, Principal principal)
}
