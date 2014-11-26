package com.app.whatsthere.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.app.whatsthere.data.Image;
import com.app.whatsthere.data.User;
import com.app.whatsthere.exception.ImageToOldException;
import com.app.whatsthere.manager.ImageStore;
import com.app.whatsthere.transformers.MessageTransformer;
import com.app.whatsthere.transformers.ToJsonTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/data")
public class FileUploadController {

    private final ImageStore imageStore= new ImageStore();
    private final MessageTransformer<Image> transformer = new ToJsonTransformer();


    /**
     * TODO add get all images for app main screen
     * @param data
     * @return
     */

    @RequestMapping(value = "/image/store", method = RequestMethod.POST)
    public ResponseEntity<Image> storeImage(@RequestBody String data) {
        Image imageToStore = transformer.transform(data);
        try {
            imageStore.storeImage(imageToStore);
        } catch (ImageToOldException e) {
            e.getImageId();
        }
        return new ResponseEntity<Image>(imageToStore, HttpStatus.OK);
    }

    @RequestMapping(value="/image/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "Successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "file" + name + "empty";
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




}