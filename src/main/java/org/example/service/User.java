package org.example.service;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private String token;
    private final int role = 2;
    private Status status;

    public enum Status {
        CONFIRM, NOT_CONFIRM;
    }

    public User() {

    }

    public User(String login, String password, String email, String token) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.token = token;
    }

    public User(int id, String login, String password, String email, String token) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.token = token;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getRole() {
        return role;
    }
}
