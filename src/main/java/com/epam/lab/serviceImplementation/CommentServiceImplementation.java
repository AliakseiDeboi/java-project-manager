package com.epam.lab.serviceImplementation;

import com.epam.lab.DAO.CommentDAO;
import com.epam.lab.models.Comment;
import com.epam.lab.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

/**
 * This class represents implementation of comment service. Using CommentDAO - bad practice.
 */
@Service
public class CommentServiceImplementation implements CommentService {

    /**
     * This field represents DAO layer.
     */
    @Autowired
    private CommentDAO commentDAO;

    /**
     * This method describes logic of adding comment
     * @param comment Comment in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void addComment(Comment comment) throws SQLException {
        commentDAO.addComment(comment);
    }

    /**
     * This method describes logic of editing comment
     * @param comment Comment in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void editComment(Comment comment) throws SQLException {
        commentDAO.editComment(comment);
    }

    /**
     * This method describes logic of deleting comment
     * @param comment Comment in input
     * @throws SQLException e
     */
    @Override
    @Transactional
    public void deleteComment(Comment comment) throws SQLException {
        commentDAO.deleteComment(comment);
    }

    /**
     * This method describes logic of getting all comments
     * @param taskId int in input
     * @return List<Comment>
     * @throws SQLException e
     */
    @Override
    @Transactional
    public List<Comment> getComments(int taskId) throws SQLException {
        return commentDAO.getComments(taskId);
    }

    /**
     * This method describes logic of getting comment
     * @param commentId int in input
     * @return Comment
     * @throws SQLException e
     */
    @Override
    @Transactional
    public Comment getComment(int commentId) throws SQLException {
        return commentDAO.getComment(commentId);
    }
}
