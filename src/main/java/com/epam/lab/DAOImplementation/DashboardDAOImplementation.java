package com.epam.lab.DAOImplementation;

import com.epam.lab.DAO.DashboardDAO;
import com.epam.lab.constants.SQLQueries;
import com.epam.lab.models.Dashboard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * This class represents implementation of DashboardDAO
 */
@Repository
public class DashboardDAOImplementation implements DashboardDAO {

    /**
     * This fields represent session.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * This method describes logic of adding a dashboard.
     * @param dashboard Dashboard in input
     * @throws SQLException e
     */
    @Override
    public void addDashboard(Dashboard dashboard) throws SQLException {
        currentSession().save(dashboard);
    }

    /**
     * This method describes logic of editing a dashboard.
     * @param dashboard Dashboard in input
     * @throws SQLException e
     */
    @Override
    public void editDashboard(Dashboard dashboard) throws SQLException {
        currentSession().update(dashboard);
    }

    /**
     * This method describes logic of deleting a dashboard.
     * @param dashboard Dashboard in input
     * @throws SQLException e
     */
    @Override
    public void deleteDashboard(Dashboard dashboard) throws SQLException {
        currentSession().delete(dashboard);

    }

    /**
     * This method describes logic of getting a dashboard.
     * @param dashboardId int in input
     * @return Dashboard
     * @throws SQLException e
     */
    @Override
    public Dashboard getDashboard(int dashboardId) throws SQLException {
        return (Dashboard) currentSession().get(Dashboard.class, dashboardId);
    }

    /**
     * This method describes logic of getting all dashboards.
     * @return List
     * @throws SQLException e
     */
    @Override
    public List getDashboards() throws SQLException {
        return currentSession().createQuery(SQLQueries.SQL_DASHBOARD).list();
    }

    /**
     * This method describes logic of getting current session
     * @return Session
     */
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}
