package com.epam.lab.DAO;

import com.epam.lab.models.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * This interface represents Data Access Object pattern for Task
 */
public interface TaskDAO {
    /**
     * This method will describe logic of adding task
     * @param task Task in input
     * @throws SQLException e
     */
    void addTask(Task task) throws SQLException;

    /**
     * This method will describe logic of editing task
     * @param task Task in input
     * @throws SQLException e
     */
    void editTask(Task task) throws SQLException;

    /**
     * This method will describe logic of deleting task
     * @param task Task in input
     * @throws SQLException e
     */
    void deleteTask(Task task) throws SQLException;

    /**
     * This method will describe logic of getting task
     * @param taskId int in input
     * @return Task
     * @throws SQLException e
     */
    Task getTask(int taskId) throws SQLException;

    /**
     * This method will describe logic of getting all tasks in a list
     * @param projectId int in input
     * @return List<Task>
     * @throws SQLException e
     */
    List<Task> getTasks(int projectId) throws SQLException;
}
