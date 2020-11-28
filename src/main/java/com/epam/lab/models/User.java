package com.epam.lab.models;

import javax.persistence.*;

/**
 * User is a class that represents user of my task manager
 */
@Entity
@Table(name = "user")
public class User {

    /**
     * This field represents unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * This field represents loging
     */
    @Column(name = "login")
    private String login;

    /**
     * This field represents password
     */
    @Column(name = "password")
    private String password;

    /**
     * This field represents role
     */
    @Column(name = "role")
    private String role;

    /**
     * Default constructor
     */
    public User() {}

    /**
     * Public constructor
     * @param id int in input
     * @param login String in input
     * @param password String in input
     * @param role String in input
     */
    public User(int id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    /*

    Getters and Setters

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}