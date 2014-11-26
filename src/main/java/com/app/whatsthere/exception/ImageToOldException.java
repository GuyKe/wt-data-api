package com.app.whatsthere.exception;

/**
 * Created by guyk on 11/5/14.
 */
public class ImageToOldException extends Exception {

    private int imageId;

    public ImageToOldException(int imageId) {
        super("Image " + imageId +" is older than an hour");
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }
}