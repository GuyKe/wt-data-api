package com.app.whatsthere.utils;

import org.joda.time.LocalDateTime;

/**
 * Created by guyk on 11/5/14.
 */
public class DateTimeUtils {


    public boolean ValidateDateTime(LocalDateTime dateTime) {
        return (dateTime.getMillisOfDay() - dateTime.plusHours(1).getMillisOfDay() >= 3600000 ) ? true : false;
    }
}