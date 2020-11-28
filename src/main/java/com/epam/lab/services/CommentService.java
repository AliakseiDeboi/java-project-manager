package com.epam.lab.services;

import com.epam.lab.models.Comment;

import java.sql.SQLException;
import java.util.List;

/**
 * This interface represents service for comment
 */
public interface CommentService {

    /**
     * This method will describe logic of adding comment
     * @param comment Comment in input
     * @throws SQLException e
     */
    void addComment(Comment comment) throws SQLException;

    /**
     * This method will describe logic of editing comment
     * @param comment Comment in input
     * @throws SQLException e
     */
    void editComment(Comment comment) throws SQLException;

    /**
     * This method will describe logic of deleting comment
     * @param comment Comment in input
     * @throws SQLException e
     */
    void deleteComment(Comment comment) throws SQLException;

    /**
     * This method will describe logic of getting comment
     * @param commentId int in input
     * @return Comment
     * @throws SQLException e
     */
    Comment getComment(int commentId) throws SQLException;

    /**
     * This method will describe logic of getting all comments in list
     * @param taskId int in input
     * @return List<Comment>
     * @throws SQLException e
     */
    List<Comment> getComments(int taskId) throws SQLException;
}
