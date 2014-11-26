package com.app.whatsthere.data;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by guyk on 11/12/14.
 */
public class ImageFile {

    private File file;

    public ImageFile(byte[] byteArray) throws IOException, NoSuchAlgorithmException {

        FileOutputStream output = new FileOutputStream(new File("target-file.png"));
        IOUtils.write(byteArray, output);


    }

}
