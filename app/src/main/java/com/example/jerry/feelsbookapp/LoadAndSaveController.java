package com.example.jerry.feelsbookapp;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.jerry.feelsbookapp.MainActivity.emotionsArrayList;

// Simple class used to save and load using Gson and Shared Preferences,
// Called in both the EmotionsActivity and MainActivity
// Requires a context to be instantiated

public class LoadAndSaveController {

    private Context context;

    // Constructor with context as parameter
    // Must declare the context in activity
    LoadAndSaveController(Context context){
        this.context = context;
    }

    // Called to save changes
    // Code source listed in readme
    // Must have input context
    public void saveData(EmotionsList<Emotion> emotionArrayList){
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(emotionArrayList);
        editor.putString("task list", json);
        editor.apply();
    }

    // Called to load the data from system preferences
    // Source of code is listed in the readme
    // Special thanks to CodingFlow for code
    // Instantiate an Array list of type Fear since Emotion is abstract and Gson can instantiate it
    public EmotionsList<Emotion> loadData(EmotionsList<Emotion> emotionArrayList){
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
            Gson gson = new Gson();
            String json = sharedPreferences.getString("task list", null);
            Type type = new TypeToken<EmotionsList<Fear>>() {}.getType();
            emotionArrayList = gson.fromJson(json, type);
            if (emotionArrayList == null) {
                emotionArrayList = new EmotionsList<>();
            }
        } catch (NullPointerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return emotionArrayList;
    }
}
