package com.example.jerry.feelsbookapp;

import java.util.Date;

public class Surprise extends Emotion{

    private String emotionName = "Surprise";

    Surprise(){
        super();
    }

    Surprise(Date date){
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
