package com.example.jerry.feelsbookapp;

import java.util.Date;

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