package com.Final.Back.Configuration;

public class Notification {
    private Long id;
    private String message;

    // Constructors, Getters, and Setters
    public Notification() {
    }

    public Notification(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}