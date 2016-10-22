package com.app.godfather.domain.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by erivan on 21/10/16.
 */
public class Experience {

    private String text;
    private String createdAt;

    public Experience() {}

    public Experience(String text, String createdAt) {
        this.text = text;
        this.createdAt = createdAt;
    }

    public Experience(String text) {
        this.text = text;
        this.createdAt = new SimpleDateFormat("dd MMM yyyy").format(new Date());
    }

    public String getText() {
        return text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

}
