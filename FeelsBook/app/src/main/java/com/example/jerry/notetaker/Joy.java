package com.example.jerry.notetaker;

import android.widget.Spinner;

import java.util.Date;

public class Joy extends Emotion {
    private String emotionName = "Joy";

    Joy(){
        super();
    }

    Joy(Date date){
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
