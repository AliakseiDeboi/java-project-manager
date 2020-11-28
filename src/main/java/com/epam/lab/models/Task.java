package com.epam.lab.models;

import javax.persistence.*;

/**
 * Task is a class that represents task on dashboard.
 */
@Entity
@Table(name = "task")
public class Task {

    /**
     * This field represents unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * This field represents task's title
     */
    @Column(name = "title")
    private String title;

    /**
     * This field represents task's description
     */
    @Column(name = "description")
    private String description;

    /**
     * This field represents task's title
     */
    @Column(name = "status")
    private String status;

    /**
     * This field represents first date
     */
    @Column(name = "date_start")
    private String dateStart;

    /**
     * This field represents second date
     */
    @Column(name = "date_end")
    private String dateEnd;

    /**
     * This field represent id of a dashboard.
     */
    @Column(name = "dashboard_id")
    private int dashboard_id;

    /**
     * This field represents creator of task
     */
    @Column(name = "author")
    private String author;

    /**
     * This field represents
     */
    @Column(name="user")
    private String user;

    /**
     * Default constructor
     */
    public Task() {}

    /**
     * Public constructor
     * @param id int in input
     * @param title  String in input
     * @param description String in input
     * @param status String in input
     * @param dateStart String in input
     * @param dateEnd String in input
     * @param dashboard_id int in input
     * @param author String in input
     * @param user String in input
     */
    public Task(int id, String title, String description, String status, String dateStart, String dateEnd, int dashboard_id, String author, String user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.dashboard_id = dashboard_id;
        this.author = author;
        this.user = user;
    }

    /*

    Getters and setters

     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getDashboardId() {
        return dashboard_id;
    }

    public void setDashboardId(int project_id) {
        this.dashboard_id = project_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String developer) {
        this.user = developer;
    }

}