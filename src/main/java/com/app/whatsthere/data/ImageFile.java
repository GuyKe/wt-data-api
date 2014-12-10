package com.app.whatsthere.data;

import org.apache.commons.io.IOUtils;
import org.joda.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by guyk on 11/12/14.
 */
public class ImageFile {


    private String pathToFile;
    private final static String IMAGE_PATH="/Users/guyk/tmp/";
    private final static String IMAGE_SUFFIX = ".jpg";
    Image image;

    public ImageFile(byte[] byteArray) throws IOException {
       try{
            pathToFile =  IMAGE_PATH + LocalDateTime.now().toString() + IMAGE_SUFFIX;
            BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(new File(pathToFile)));
            stream.write(byteArray);
            stream.close();
       }catch (IOException e) {
           throw e;
       }
    }
    public Image getImage(){
        return this.image;
    }

    public String getPath(){
        return this.pathToFile;
    }

}
