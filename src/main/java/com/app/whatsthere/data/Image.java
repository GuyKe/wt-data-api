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
    private String fileName;
    @Column
    private String hashTagText;
    @Column
    private String fbToken;
    @Column
    private String formattedLocation;
    @Column
    private  String timeOfCapture;


    public Image (String fileName, String hashTagText ,String fbToken,String formattedLocation,String timeOfCapture){
        this.fileName = fileName;
        this.setFormattedLocation(formattedLocation);
        this.setLocalDateTime(timeOfCapture);
        this.setHashTagText(hashTagText);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLocalDateTime(String timeOfCapture) {
        this.timeOfCapture = timeOfCapture;
    }
    public String getTimeOfCapture() {
        return timeOfCapture;
    }

    public void setHashTagText(String url) {
        this.hashTagText = hashTagText;
    }

    public String getHashTagText() {
        return hashTagText;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }
    public String getFbToken() {
        return fbToken;
    }

    public void setFormattedLocation(String formattedLocation) {
        this.formattedLocation = formattedLocation;
    }

    public String getFormattedLocation() {
        return formattedLocation;
    }

}
