package com.epam.lab.DAOImplementation;

import com.epam.lab.DAO.UserDAO;
import com.epam.lab.constants.Constants;
import com.epam.lab.constants.SQLQueries;
import com.epam.lab.models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * This class represents implementation of UserDAO
 */
@Repository
public class UserDAOImplementation implements UserDAO {

    /**
     * This fields represent session.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * This method describes logic of adding user
     * @param user User in input
     * @throws SQLException e
     */
    @Override
    public void addUser(User user) throws SQLException {
        currentSession().save(user);
    }

    /**
     * This method describes logic of getting all users in a list
     * @param role String in input
     * @return List
     * @throws SQLException e
     */
    @Override
    public List getUsers(String role) throws SQLException {
        return currentSession().createQuery(SQLQueries.SQL_USER).setParameter(Constants.ROLE, role).list();
    }

    /**
     * This method describes logic of getting user
     * @param login String in input
     * @return User
     * @throws SQLException e
     */
    @Override
    public User getUser(String login) throws SQLException {
        Criteria criteria = currentSession().createCriteria(User.class);
        criteria.add(Restrictions.like(Constants.LOGIN, login));
        return (User) criteria.uniqueResult();
    }

    /**
     * This method describes logic of getting current session
     * @return Session
     */
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}
