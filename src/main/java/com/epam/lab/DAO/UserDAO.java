package com.epam.lab.DAO;

import com.epam.lab.models.User;

import java.sql.SQLException;
import java.util.List;

/**
 * This interface represents Data Access Object pattern for User
 */
public interface UserDAO {

    /**
     * This method will describe logic of adding user
     * @param user User in input
     * @throws SQLException e
     */
    void addUser(User user) throws SQLException;

    /**
     * This method will describe logic of getting user
     * @param login String in input
     * @return User
     * @throws SQLException e
     */
    User getUser(String login) throws SQLException;

    /**
     * This method will describe logic of getting all users in a list
     * @param role String in input
     * @return List<User>
     * @throws SQLException e
     */
    List<User> getUsers(String role) throws SQLException;
}
