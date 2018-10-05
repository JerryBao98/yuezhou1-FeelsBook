package com.example.jerry.feelsbookapp;

import java.util.Date;

// Public abstract class of Emotion
// Used by the 6 emotions as a super class
// Abstract class was used in case of future modifications to the program
// Rather than having one emotion class represent all emotions,
// which can be troublesome later on as each individual emotion may get their own methods
// and method calls
// For example, we may show different graphic effects based on which emotion is selected.
// Therefore, each child emotion class can have its own methods and controllers

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
    // SetComment provides a double check to that the comment is less than 100 characters
    public void setComment(String comment) {
        if (comment.length() <= 100){
            this.comment = comment;
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
        return this.emotionName;
    }

    @Override
    public String toString(){
        return this.emotionName;
    }
}
