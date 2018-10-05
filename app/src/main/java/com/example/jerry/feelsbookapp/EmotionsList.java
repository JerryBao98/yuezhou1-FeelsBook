package com.example.jerry.feelsbookapp;

import java.util.ArrayList;

// Array class used specifically to hold emotions
// extends the basic ArrayList class
// Can only be used alongside Emotion objects
public class EmotionsList<Emotion> extends ArrayList<Emotion> {

    // Add an emotion to the array
    public Emotion addEmotion(Emotion emotion){
        super.add(emotion);
        return emotion;
    }

    // Remove an emotion
    public void removeEmotion(Emotion emotion){
        super.remove(emotion);
    }

    // Get an emotion, based off of its position
    public Emotion getEmotion(int index){
        return super.get(index);
    }

    // Get the size of the array
    public int getSize(){
        return super.size();
    }
}
