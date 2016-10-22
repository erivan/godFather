package com.app.godfather.domain.entity;

/**
 * Created by erivan on 21/10/16.
 */
public class User {
    public static final int GOD_FATHER = 0;
    public static final int CHEMICAL_DEPENDENT = 1;

    private String email;
    private int type;

    public User(String email, int type) {
        this.email = email;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public int getType() {
        return type;
    }
}
