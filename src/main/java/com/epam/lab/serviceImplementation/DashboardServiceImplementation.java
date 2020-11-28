package com.epam.lab.serviceImplementation;

import com.epam.lab.DAO.DashboardDAO;
import com.epam.lab.models.Dashboard;
import com.epam.lab.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

/**
 * This class represents implementation of dashboard service. Using DashboardDAO - bad practice.
 */
@Service
public class DashboardServiceImplementation implements DashboardService {

    /**
     * This field represents DAO layer.
     */
    @Autowired
    private DashboardDAO dashboardDAO;

    /**
     * This method describes logic of adding a dashboard.
     * @param dashboard Dashboard in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void addDashboard(Dashboard dashboard) throws SQLException {
        dashboardDAO.addDashboard(dashboard);
    }

    /**
     * This method describes logic of editing a dashboard.
     * @param dashboard Dashboard in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void editDashboard(Dashboard dashboard) throws SQLException {
        dashboardDAO.editDashboard(dashboard);
    }

    /**
     * This method describes logic of deleting a dashboard.
     * @param dashboard Dashboard in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void deleteDashboard(Dashboard dashboard) throws SQLException {
        dashboardDAO.deleteDashboard(dashboard);
    }

    /**
     * This method describes logic of getting a dashboard.
     * @param dashboardId int in input
     * @return Dashboard
     * @throws SQLException e
     */
    @Override
    @Transactional
    public Dashboard getDashboard(int dashboardId) throws SQLException {
        return dashboardDAO.getDashboard(dashboardId);
    }

    /**
     * This method describes logic of getting all dashboards.
     * @return List<Dashboard>
     * @throws SQLException e
     */
    @Override
    @Transactional
    public List<Dashboard> getDashboards() throws SQLException {
        return dashboardDAO.getDashboards();
    }
}
