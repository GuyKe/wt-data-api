package com.app.whatsthere.controller;

import java.io.*;

import com.app.whatsthere.data.User;
import com.app.whatsthere.exception.ImageToOldException;
import com.app.whatsthere.manager.ImageStore;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig(
        fileSizeThreshold   = 10,
        maxFileSize         = 10,
        maxRequestSize      = 5,
        location            = "/root/wt_data/")
@RequestMapping("/data")
public class FileUploadController {

    private final ImageStore imageStore = new ImageStore();
    //private final MessageTransformer<Image> transformer = new ToJsonTransformer();
    private final String imagePath="/root/wt_data/";

//    /**
//     * TODO add get all images for app main screen
//     * @param data
//     * @return
//     */
//
//    @RequestMapping(value = "/image/store", method = RequestMethod.POST)
//    public ResponseEntity<Image> writeFile(@RequestBody String data) {
//        Image imageToStore = transformer.transform(data);
//        try {
//            imageStore.writeFile(imageToStore);
//        } catch (ImageToOldException e) {
//            e.getImageId();
//        }
//        return new ResponseEntity<Image>(imageToStore, HttpStatus.OK);
//    }
/*

("file",file) ("location",formattedLocation) ("name",hashTagText)
("fbToken",faceBookToken)
("timeStamp",ts)
 */
    @RequestMapping(value="/image/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String hashTagText,
                                                 @RequestParam("file") MultipartFile file,
                                                 @RequestParam("timeStamp") String timeOfCapture,
                                                 @RequestParam("fbToken") String fbToken,
                                                 @RequestParam("location") String formattedLocation){
        String fileName = "";
        if (!file.isEmpty()) {
            try {
               fileName =  imageStore.writeFile(file.getBytes());
            } catch (ImageToOldException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageStore.storeImage(fileName,hashTagText,timeOfCapture,fbToken,formattedLocation);
        }
        return "";
    }

    @RequestMapping(value = "/image/getImage/tag" ,params = "tag", method = RequestMethod.GET)
    public HttpStatus getImageByTag(final String tag) {
        //Add response body
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/image/getImage/location" ,params = "location", method = RequestMethod.GET)
    public HttpStatus getImageByLocation(final String location) {
        //Add response body
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/image/fetch/userId" , params = "userId" , method = RequestMethod.GET)
    public HttpStatus getImageByUserId(final String userId) {
        return HttpStatus.OK;
    }


    @RequestMapping(value = "/image/fetch/tagByLocation" , params = "tag" , method = RequestMethod.GET)
    public HttpStatus getTagsByLocation(final String tag) {
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/user/store" , method = RequestMethod.POST)
    public ResponseEntity<User> storeUser(@RequestBody String user) {
        User userToStore = new User();
        return new ResponseEntity<User>(userToStore, HttpStatus.OK);
    }
//    public String getMd5(String file_name) {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        try (InputStream is = Files.newInputStream(Paths.get("file.txt"))) {
//            DigestInputStream dis = new DigestInputStream(is, md);
//  /* Read stream to EOF as normal... */
//        }
//        byte[] digest = md.digest();
//    }




}