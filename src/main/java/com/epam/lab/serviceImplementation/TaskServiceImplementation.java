package com.epam.lab.serviceImplementation;

import com.epam.lab.DAO.TaskDAO;
import com.epam.lab.models.Task;
import com.epam.lab.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

/**
 * This class represents implementation of task service. Using TaskDAO - bad practice.
 */
@Service
public class TaskServiceImplementation implements TaskService {

    /**
     * This field represents DAO layer.
     */
    @Autowired
    private TaskDAO taskDAO;

    /**
     * This method describes logic of adding task
     * @param task Task in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void addTask(Task task) throws SQLException {
        taskDAO.addTask(task);
    }

    /**
     * This method describes logic of editing task
     * @param task Task in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void editTask(Task task) throws SQLException {
        taskDAO.editTask(task);
    }

    /**
     * This method describes logic of deleting task
     * @param task Task in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void deleteTask(Task task) throws SQLException {
        taskDAO.deleteTask(task);
    }

    /**
     * This method describes logic of getting task
     * @param taskId int in input
     * @return Task
     * @throws SQLException e
     */
    @Override
    @Transactional
    public Task getTask(int taskId) throws SQLException {
        return taskDAO.getTask(taskId);
    }

    /**
     * This method describes logic of getting task
     * @param projectId int in input
     * @return List<Task>
     * @throws SQLException e
     */
    @Override
    @Transactional
    public List<Task> getTasks(int projectId) throws SQLException {
        return taskDAO.getTasks(projectId);
    }

}
