package com.example.jerry.feelsbookapp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public abstract class Emotion{
    private transient String emotionName = "Base";
    private String comment;
    private Date date;

    Emotion(){
        this.date = new Date();
    }

    Emotion(Date date){
        this.date = date;
    }

    // Setters
    public void setComment(String comment) {
        if (comment.length() <= 100){
            this.comment = comment;
        }
        else{
        }
    }

    public void setDate(Date date){
        this.date = date;
    }

    // Getters
    public Date getDate(){
        return this.date;
    }

    public String getComment(){
        return this.comment;
    }

    public String getEmotionName(){
        return emotionName;
    }

    @Override
    public String toString(){
        return emotionName;
    }

    // Formats the current Date to comply with iso 8601
    // Returns that as a string
    public String formatDateToISO(){
        //String tzStr = Calendar.getInstance().getTimeZone().getDisplayName();
        TimeZone tz = TimeZone.getTimeZone("MST");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        df.setTimeZone(tz);
        return df.format(this.date);
    }
}
