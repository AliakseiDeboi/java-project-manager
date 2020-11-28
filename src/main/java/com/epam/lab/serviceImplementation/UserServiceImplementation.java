package com.epam.lab.serviceImplementation;

import com.epam.lab.DAO.UserDAO;
import com.epam.lab.models.User;
import com.epam.lab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

/**
 * This class represents implementation of task service. Using TaskDAO - bad practice.
 */
@Service
public class UserServiceImplementation implements UserService {

    /**
     * This field represents DAO layer.
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * This method describes logic of adding user
     * @param user User in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }

    /**
     * This method describes logic of getting all users
     * @param role String in input
     * @return List<User>
     * @throws SQLException e
     */
    @Override
    @Transactional
    public List<User> getUsers(String role) throws SQLException {
        return userDAO.getUsers(role);
    }

    /**
     * This method describes logic of getting user
     * @param login String in input
     * @return User
     * @throws SQLException e
     */
    @Override
    @Transactional
    public User getUser(String login) throws SQLException {
        return userDAO.getUser(login);
    }
}
