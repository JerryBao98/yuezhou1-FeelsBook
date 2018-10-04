package com.example.jerry.feelsbookapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Simple class used to reformat Dates, into ISO and vice-versa
public class TimeReformatter {

    // Formats the current Date to comply with iso 8601
    // Returns that as a string
    public String formatDateToISO(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return df.format(date);
    }

    // Converts the Iso back into a Date Time
    public Date toCalendar(String isoTime){
        try {
            DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date finalResult = df1.parse(isoTime);
            return finalResult;
        } catch (Exception ex){
            return new Date();
        }
    }
}
