package com.example.jerry.feelsbookapp;

import android.widget.Spinner;

import java.util.Date;

public class Sadness extends Emotion {
    private String emotionName = "Sadness";

    Sadness(Date date){ super(date); }

    public String getEmotionName(){
        return this.emotionName;
    }

    @Override
    public String toString(){
        return this.emotionName;
    }
}
