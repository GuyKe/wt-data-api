package com.app.whatsthere.transformers;

import com.app.whatsthere.data.Image;
import com.google.gson.Gson;

/**
 * Created by guyk on 11/8/14.
 */
public class ToJsonTransformer implements MessageTransformer {

    private Gson gson = new Gson();

    @Override
    public Image transform(String imageData) {
        Image image = gson.fromJson(imageData, Image.class);
        return image;
    }
    public  ToJsonTransformer(Image image) {
       // return  gson.toJsonTree(image, Image.class);
     // return new Gson();
    }
    public Gson getGson(){
        return gson;
    }



}
