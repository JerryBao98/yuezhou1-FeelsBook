package com.example.jerry.feelsbookapp;

import android.widget.Spinner;

import java.util.Date;

public class Anger extends Emotion {
    private String emotionName = "Anger";

    Anger(){
        super();
    }

    Anger(Date date){
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
