package com.workshop.mongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDate convertDate(String textDate, LocalDate defaulLocalDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = sdf.parse(textDate);
            LocalDate localDate = d1.toInstant().atZone(ZoneId.of("GMT")).toLocalDate();
            return localDate;
        } catch (ParseException e) {
            return defaulLocalDate;
        }
    }
}
