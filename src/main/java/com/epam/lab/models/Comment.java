package com.epam.lab.models;

import javax.persistence.*;

/**
 * Comment is a class that represents a comment for task.
 */

@Entity
@Table(name = "comment")
public class Comment {

    /**
     * This field represents unique id for task
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * This field represents user's login
     */
    @Column(name = "login")
    private String login;

    /**
     * This field represents date
     */
    @Column(name = "date")
    private String date;

    /**
     * This field represents task's id
     */
    @Column(name = "task_id")
    private int task_id;

    /**
     * This field represents comment itself
     */
    @Column(name = "comment")
    private String comment;

    /**
     * Default constructor
     */
    public Comment() {}

    /**
     * Public constructor
     * @param id int in input
     * @param login String in input
     * @param date String in input
     * @param task_id int in input
     * @param comment String in input
     */
    public Comment(int id, String login, String date, int task_id, String comment) {
        this.id = id;
        this.login = login;
        this.date = date;
        this.task_id = task_id;
        this.comment = comment;
    }

    /*

        Getters and setters.

     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int taskId) {
        this.task_id = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}