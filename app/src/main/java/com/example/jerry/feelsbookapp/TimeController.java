package com.example.jerry.feelsbookapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

// Simple class used for time-related tasks
// Such as changing ISO from to Date and vice versa
// Also validates input time, to see that the dates are correct
// Has a feature to sort an array my date, in descending order,
// that way the emotion entries are easier to be accessed at the top of the project

public class TimeController {

    // Formats the current Date to comply with iso 8601
    // Returns that as a string
    public String formatDateToISO(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return df.format(date);
    }

    // Checks to see if the Date time is valid
    public Boolean checkValidDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            df.parse(date);
            Date finalResult = df.parse(date);
            Date currentTime = new Date();
            return (currentTime.after(finalResult) || currentTime.equals(finalResult));
        }catch (Exception ex){
            return false;
        }
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

    // Method to sort the array by date
    public void sortArrayByDate(EmotionsList<Emotion> emotionArrayList){
        Collections.sort(emotionArrayList, new Comparator<Emotion>() {
            @Override
            public int compare(Emotion o1, Emotion o2) {
                // TODO Auto-generated method stub
                return o2.getDate().compareTo(o1.getDate());
            }
        });
    }
}
