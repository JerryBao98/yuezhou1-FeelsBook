package com.example.jerry.feelsbookapp;

import java.util.Date;

public class Surprise extends Emotion{
    private String emotionName = this.getClass().getSimpleName();

    Surprise(Date date){
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
