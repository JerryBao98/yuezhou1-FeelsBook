package com.example.jerry.feelsbookapp;

import java.util.Date;

// Class of Love inherits Emotion
// Has its own emotion name and and Override to toString()
public class Love extends Emotion {
    private String emotionName = this.getClass().getSimpleName();

    Love(Date date){
        super(date);
    }

    public String getEmotionName(){
        return this.emotionName;
    }

    @Override
    public String toString(){
        return this.emotionName;
    }

}