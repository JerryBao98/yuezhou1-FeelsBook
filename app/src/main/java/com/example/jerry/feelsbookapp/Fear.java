package com.example.jerry.feelsbookapp;

import java.util.Date;

public class Fear extends Emotion {

    private String emotionName = "Fear";

    Fear(){
        super();
    }

    Fear(Date date){
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