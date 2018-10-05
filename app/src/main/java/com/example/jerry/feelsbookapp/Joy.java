package com.example.jerry.feelsbookapp;

import java.util.Date;

// Class of Joy inherits Emotion
// Has its own emotion name and and Override to toString()
public class Joy extends Emotion {
    private String emotionName = this.getClass().getSimpleName();

    Joy(Date date){
        super(date);
    }

    public String getEmotionName(){
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString(){
        return this.emotionName;
    }
}
