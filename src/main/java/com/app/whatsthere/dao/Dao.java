package com.app.whatsthere.dao;

import org.joda.time.LocalDateTime;

import java.util.List;

/**
 * Created by guyk on 11/5/14.
 */
public interface Dao {

    void store(final String url, final List<String> imageHashTags, final String user, LocalDateTime dateTime);

    void fetch(String imageId);
}

