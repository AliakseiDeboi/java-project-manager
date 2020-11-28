package com.epam.lab.constants;

/**
 * This class represents my sql queries
 */
public class SQLQueries {

    public static final String SQL_COMMENT = "FROM Comment c WHERE c.task_id = :id";
    public static final String SQL_TASK = "FROM Task t WHERE t.dashboard_id = :id";
    public static final String SQL_DASHBOARD = "FROM Dashboard";
    public static final String SQL_USER = "FROM User u WHERE u.role = :role ORDER BY u.login";
}
