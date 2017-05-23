package com.ronadi.example.transitiondetail.model;
/*
 * Created by ronadi on 5/23/17.
 */

import java.io.Serializable;

public class Sport implements Serializable {
    private int id;
    private String title;
    private String description;
    private String url;

    public Sport(int id, String title, String description, String url){
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
