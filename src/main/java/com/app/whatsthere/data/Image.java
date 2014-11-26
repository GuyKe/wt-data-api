package com.app.whatsthere.data;


import org.joda.time.LocalDateTime;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by guyk on 11/5/14.
 */
@Entity
@Table(name = "image")
@Resource
public class Image {

    @Id
    @Column(name = "id")
    private int id;
    @Column
    private String url;
    @Column
    private String imageHashTags;
    @Column
    private String user;
    @Column
    private  LocalDateTime timeOfCapture;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLocalDateTime(LocalDateTime timeOfCapture) {
        this.timeOfCapture = timeOfCapture;
    }
    public LocalDateTime getTimeOfCapture() {
        return timeOfCapture;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setImageHashTags(String imageHashTags) {
        this.imageHashTags = imageHashTags;
    }
    public String getImageHashTags() {
        return imageHashTags;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

}
