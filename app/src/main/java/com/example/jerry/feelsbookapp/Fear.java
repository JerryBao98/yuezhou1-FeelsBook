package com.example.jerry.feelsbookapp;

import java.util.Date;

// Fear is a different class since its used in loading the gson type
public class Fear extends Emotion {
    private String emotionName = this.getClass().getSimpleName();

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