package com.epam.lab.DAO;

import com.epam.lab.models.Dashboard;

import java.sql.SQLException;
import java.util.List;

/**
 * This interface represents Data Access Object pattern for Dashboard
 */
public interface DashboardDAO {

    /**
     * This method will describe logic of adding a dashboard.
     * @param dashboard Dashboard in input
     * @throws SQLException e
     */
    void addDashboard(Dashboard dashboard) throws SQLException;

    /**
     * This method will describe logic of editing a dashboard.
     * @param dashboard Dashboard in input
     * @throws SQLException e
     */
    void editDashboard(Dashboard dashboard) throws SQLException;

    /**
     * This method will describe logic of deleting a dashboard.
     * @param dashboard Dashboard in input
     * @throws SQLException e
     */
    void deleteDashboard(Dashboard dashboard) throws SQLException;

    /**
     * This method will describe logic of getting a dashboard.
     * @param dashboardId int in input
     * @return Dashboard
     * @throws SQLException e
     */
    Dashboard getDashboard(int dashboardId) throws SQLException;

    /**
     * This method will describe logic of getting all dashboards in a list.
     * @return List<Dashboard>
     * @throws SQLException e
     */
    List<Dashboard> getDashboards() throws SQLException;
}
