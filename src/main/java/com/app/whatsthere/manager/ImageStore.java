package com.app.whatsthere.manager;

import com.app.whatsthere.dao.Dao;
import com.app.whatsthere.dao.ImageDaoImpl;
import com.app.whatsthere.data.Image;
import com.app.whatsthere.exception.ImageToOldException;
import com.app.whatsthere.utils.DateTimeUtils;

/**
 * Created by guyk on 11/5/14.
 */
public class ImageStore {

    private final Dao dao = new ImageDaoImpl();
    private final DateTimeUtils dateTimeUtils = new DateTimeUtils();

    public void storeImage(Image image) throws ImageToOldException {
        if (!dateTimeUtils.ValidateDateTime(image.getTimeOfCapture())) throw new ImageToOldException(image.getId());

    }

    public Image fetchImage(int id) {
        return null;
    }
}

