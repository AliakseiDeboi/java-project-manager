package com.epam.lab.DAOImplementation;

import com.epam.lab.DAO.CommentDAO;
import com.epam.lab.constants.Constants;
import com.epam.lab.constants.SQLQueries;
import com.epam.lab.models.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * This class represents implementation of CommentDAO
 */
@Repository
public class CommentDAOImplementation implements CommentDAO {

    /**
     * This fields represent session.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * This method describes logic of adding comment
     * @param comment Comment in input
     * @throws SQLException e
     */
    @Override
    public void addComment(Comment comment) throws SQLException {
        currentSession().save(comment);
    }

    /**
     * This method describes logic of editing comment
     * @param comment Comment in input
     * @throws SQLException e
     */
    @Override
    public void editComment(Comment comment) throws SQLException {
        currentSession().update(comment);
    }

    /**
     * This method describes logic of deleting comment
     * @param comment Comment in input
     * @throws SQLException e
     */
    @Override
    public void deleteComment(Comment comment) throws SQLException {
        currentSession().delete(comment);
    }

    /**
     * This method describes logic of getting all comments
     * @param taskId int in input
     * @return List
     * @throws SQLException e
     */
    @Override
    public List getComments(int taskId) throws SQLException {
        return  currentSession().createQuery(SQLQueries.SQL_COMMENT).setParameter(Constants.ID, taskId).list();
    }

    /**
     * This method describes logic of getting comment
     * @param commentId int in input
     * @return Comment
     * @throws SQLException e
     */
    @Override
    public Comment getComment(int commentId) throws SQLException {
        return (Comment) currentSession().get(Comment.class, commentId);
    }

    /**
     * This method describes logic of getting current Session
     * @return Session
     */
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

}
