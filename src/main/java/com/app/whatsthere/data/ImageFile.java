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

    private File file;
    private final static String IMAGE_PATH="/root/wt_data/";
    Image image;

    public ImageFile(byte[] byteArray,String imageHashTags,LocalDateTime timeOfCapture,
                     String user,Location location ) throws IOException, NoSuchAlgorithmException {
       try{
      //  String file_Name = imagePath + name + "-uploaded" ;
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(new File( IMAGE_PATH+ timeOfCapture.toString())));
        stream.write(byteArray);
        stream.close();

        //return "Successfully uploaded " + name + " into " + name + "-uploaded !";
//        FileOutputStream output = new FileOutputStream(new File("target-file.png"));
//        IOUtils.write(byteArray, output);
         String url = IMAGE_PATH +  timeOfCapture.toString() ;
       // Create an Image
         image = new Image( url , imageHashTags , user , timeOfCapture, location);

       }catch (IOException e) {
           throw e;
       }
    }
    public Image getImage(){
        return this.image;
    }

}
