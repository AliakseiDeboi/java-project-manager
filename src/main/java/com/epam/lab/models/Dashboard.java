package com.epam.lab.models;

import javax.persistence.*;

/**
 * Dashboard is a class that represents project's dashboard
 */
@Entity
@Table(name = "dashboard")
public class Dashboard {

    /**
     * This field represents unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * This field represents dashboard's title
     */
    @Column(name = "title")
    private String title;

    /**
     * This field represents dashboard's description
     */
    @Column(name = "description")
    private String description;

    /**
     * This field represents status of dashboard
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
     * This field represents dashboard's author
     */
    @Column(name = "author")
    private String author;

    /**
     * Default constructor
     */
    public Dashboard() {}

    /**
     * Public constructor
     * @param id int in input
     * @param title String in input
     * @param description String in input
     * @param status String in input
     * @param dateStart String in input
     * @param dateEnd String in input
     * @param author String in input
     */
    public Dashboard(int id, String title, String description, String status, String dateStart, String dateEnd, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}