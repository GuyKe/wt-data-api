package com.app.whatsthere.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;

import com.app.whatsthere.data.Image;
import com.app.whatsthere.data.ImageFile;
import com.app.whatsthere.data.Location;
import com.app.whatsthere.data.User;
import com.app.whatsthere.exception.ImageToOldException;
import com.app.whatsthere.manager.ImageStore;
import com.app.whatsthere.transformers.MessageTransformer;
import com.app.whatsthere.transformers.ToJsonTransformer;

import org.joda.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/data")
public class FileUploadController {

    private final ImageStore imageStore= new ImageStore();
    //private final MessageTransformer<Image> transformer = new ToJsonTransformer();
    private final String imagePath="/root/wt_data/";

//    /**
//     * TODO add get all images for app main screen
//     * @param data
//     * @return
//     */
//
//    @RequestMapping(value = "/image/store", method = RequestMethod.POST)
//    public ResponseEntity<Image> storeImage(@RequestBody String data) {
//        Image imageToStore = transformer.transform(data);
//        try {
//            imageStore.storeImage(imageToStore);
//        } catch (ImageToOldException e) {
//            e.getImageId();
//        }
//        return new ResponseEntity<Image>(imageToStore, HttpStatus.OK);
//    }

    @RequestMapping(value="/image/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String imageHashTags,
                                                 @RequestParam("file") MultipartFile file,

                                                 @RequestParam("time") String timeOfCapture,
                                                 @RequestParam("user") String user,
                                                 @RequestParam("location") String location){
        if (!file.isEmpty()) {
            try {
               // byte[] bytes =
                ImageFile imageFile = new ImageFile(file.getBytes(),
                        imageHashTags,
                        LocalDateTime.parse(timeOfCapture),
                         user,
                        //location
                        new Location(imageHashTags.substring(imageHashTags.indexOf("#"),imageHashTags.lastIndexOf(" ",imageHashTags.indexOf("#"))),
                        Double.parseDouble(location.substring(0,location.indexOf(",")) ),
                                Double.parseDouble(location.substring(location.indexOf(",")))
                        )
                ) ;
                return new ToJsonTransformer(imageFile.getImage()).getGson().toString();
            } catch (Exception e) {
                return "failed to upload " + imageHashTags + " => " + e.getMessage();
            }
        } else {
            return "Error: File" + imageHashTags + "empty";
        }

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