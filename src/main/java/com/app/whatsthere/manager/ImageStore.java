package com.app.whatsthere.manager;

import com.app.whatsthere.dao.Dao;
import com.app.whatsthere.dao.ImageDaoImpl;
import com.app.whatsthere.data.Image;
import com.app.whatsthere.data.ImageFile;
import com.app.whatsthere.data.Location;
import com.app.whatsthere.exception.ImageToOldException;
import com.app.whatsthere.utils.DateTimeUtils;
import org.joda.time.LocalDateTime;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by guyk on 11/5/14.
 */
public class ImageStore {

    private final Dao dao = new ImageDaoImpl();
    private final DateTimeUtils dateTimeUtils = new DateTimeUtils();
    ImageFile imageFile;

    public String writeFile(byte[] fileContent) throws ImageToOldException {
        try {
            imageFile = new ImageFile(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
            return "NA";
        }
    return imageFile.getPath();
    }

    public boolean storeImage(String name, String hashTagText, String timeOfCapture
            , String fbToken, String formattedLocation) {
        Image image = new Image(name,hashTagText,fbToken,formattedLocation,timeOfCapture);
        return false;

    }

    public Image fetchImage(int id) {
        return null;
    }
}

