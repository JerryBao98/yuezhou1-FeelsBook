package com.example.jerry.feelsbookapp;

import java.util.Date;

public class Anger extends Emotion {
    private String emotionName = this.getClass().getSimpleName();

    Anger(Date date){
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
