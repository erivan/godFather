package com.app.godfather.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erivan on 21/10/16.
 */
public class User {
    public static final int GOD_FATHER = 0;
    public static final int CHEMICAL_DEPENDENT = 1;

    private String email;
    private int type;
    private List<String> godSonEmails;
    private List<String> godFatherEmails;

    public User() {
        this.godSonEmails = new ArrayList<String>();
        this.godFatherEmails = new ArrayList<String>();
    }

    public User(String email, int type) {
        this.email = email;
        this.type = type;
        this.godSonEmails = new ArrayList<String>();
        this.godFatherEmails = new ArrayList<String>();
    }

    public String getEmail() {
        return email;
    }

    public int getType() {
        return type;
    }

    public List<String> getGodSonEmails(){
        return godSonEmails;
    }


    public List<String> getGodFatherEmails(){
        return godFatherEmails;
    }

    public void addFatherEmail(String email) {
        getGodFatherEmails().add(email);
    }

    public void addSonEmail(String email) {
        getGodSonEmails().add(email);
    }
}
