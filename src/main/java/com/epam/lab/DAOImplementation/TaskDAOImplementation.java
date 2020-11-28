package com.epam.lab.DAOImplementation;

import com.epam.lab.DAO.TaskDAO;
import com.epam.lab.constants.Constants;
import com.epam.lab.constants.SQLQueries;
import com.epam.lab.models.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * This class represents implementation of TaskDAO
 */
@Repository
public class TaskDAOImplementation implements TaskDAO {

    /**
     * This fields represent session.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * This method describes logic of adding task
     * @param task Task in input
     * @throws SQLException e
     */
    @Override
    public void addTask(Task task) throws SQLException {
        currentSession().save(task);
    }

    /**
     * This method describes logic of editing task
     * @param task Task in input
     * @throws SQLException e
     */
    @Override
    public void editTask(Task task) throws SQLException {
        currentSession().update(task);
    }

    /**
     * This method describes logic of deleting task
     * @param task Task in input
     * @throws SQLException e
     */
    @Override
    public void deleteTask(Task task) throws SQLException {
        currentSession().delete(task);
    }

    /**
     * This method describes logic of getting task
     * @param taskId int in input
     * @return Task
     * @throws SQLException e
     */
    @Override
    public Task getTask(int taskId) throws SQLException {
        return (Task) currentSession().get(Task.class, taskId);
    }

    /**
     * This method describes logic of getting all tasks in a list
     * @param projectId int in input
     * @return List
     * @throws SQLException e
     */
    @Override
    public List getTasks(int projectId) throws SQLException {
        return currentSession().createQuery(SQLQueries.SQL_TASK).setParameter(Constants.ID, projectId).list();
    }

    /**
     * This method describes logic of getting current session
     * @return Session
     */
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

}
