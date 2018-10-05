package com.example.jerry.feelsbookapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static EmotionsList<Emotion> emotionsArrayList = new EmotionsList<>();
    static TimeController timeController = new TimeController();
    private LoadAndSaveController loadAndSaveController = new LoadAndSaveController(this);
    ListView oldEmotionsList;
    EmotionAdapter emotionAdapter;
    EditText editQuickComment;
    Button emotionSummaryButton;
    Button loveButton;
    Button joyButton;
    Button surpriseButton;
    Button angerButton;
    Button sadnessButton;
    Button fearButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set content view, load old data
        setContentView(R.layout.activity_main);

        findAllEditTexts();
        findAllButtons();

        // When you click on an item in the list view
        // Sends user to another view, supplies the data of the Object clicked
        // emotion id is an index for the id of the Object clicked
        oldEmotionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EmotionActivity.class);
                intent.putExtra("emotionId", position);
                startActivity(intent);
            }
        });

        emotionSummaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmotionSummaryActivity.class);
                startActivity(intent);
            }
        });

        // Call the method to set an onclick listener for all buttons
        setAllEmotionOnClick();
    }

    // On start, load data, set the adapter to the custom emotion adapter
    // Also be sure to sort the list by date
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        emotionsArrayList = loadAndSaveController.loadData(emotionsArrayList);
        timeController.sortArrayByDate(emotionsArrayList);
        emotionAdapter = new EmotionAdapter(getApplicationContext(), emotionsArrayList);
        oldEmotionsList.setAdapter(emotionAdapter);
    }

    // Finds and assigns all the edit text fields in the xml to the local variables
    private void findAllEditTexts(){
        // Get the reference to the summary button as well as the old emotions list
        // Create an object for the edit text
        emotionSummaryButton = findViewById(R.id.emotionSummaryButton);
        oldEmotionsList = findViewById(R.id.listView);
        editQuickComment = findViewById(R.id.quickcommentEditText);

        // Set up a hint for the quick edit comment
        editQuickComment.setHint("Enter a Quick Comment Here!");
    }


    // Finds and assigns all the buttons in the xml to the local variables
    private void findAllButtons(){
        // Get the references to the buttons in the activity
        // Set onclick Listeners for all the Buttons
        loveButton = findViewById(R.id.loveButton);
        joyButton = findViewById(R.id.joyButton);
        angerButton = findViewById(R.id.angerButton);
        sadnessButton = findViewById(R.id.sadnessButton);
        fearButton = findViewById(R.id.fearButton);
        surpriseButton = findViewById(R.id.surpriseButton);
    }

    // Method to set the on click listeners for all emotion buttons
    // Long method, but logic is repeated to its fine
    private void setAllEmotionOnClick(){
        fearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fear fear = new Fear(new Date());
                emotionsArrayList.addEmotion(fear);
                emotionAdapter.notifyDataSetChanged();
                fear.setComment(editQuickComment.getText().toString());
                stepsForEmotionClicked();
            }
        });
        joyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Joy joy = new Joy(new Date());
                emotionsArrayList.addEmotion(joy);
                emotionAdapter.notifyDataSetChanged();
                joy.setComment(editQuickComment.getText().toString());
                stepsForEmotionClicked();
            }
        });
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Love love = new Love(new Date());
                emotionsArrayList.addEmotion(love);
                emotionAdapter.notifyDataSetChanged();
                love.setComment(editQuickComment.getText().toString());
                stepsForEmotionClicked();
            }
        });
        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Surprise surprise = new Surprise(new Date());
                emotionsArrayList.addEmotion(surprise);
                emotionAdapter.notifyDataSetChanged();
                surprise.setComment(editQuickComment.getText().toString());
                stepsForEmotionClicked();
            }
        });
        sadnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sadness sadness = new Sadness(new Date());
                emotionsArrayList.addEmotion(sadness);
                emotionAdapter.notifyDataSetChanged();
                sadness.setComment(editQuickComment.getText().toString());
                stepsForEmotionClicked();
            }
        });
        angerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anger anger = new Anger(new Date());
                emotionsArrayList.addEmotion(anger);
                emotionAdapter.notifyDataSetChanged();
                anger.setComment(editQuickComment.getText().toString());
                stepsForEmotionClicked();
            }
        });
    }

    // Steps taken for when any emotion button is clicked
    // use a function to reduce redundancy
    // saves the data for the new emotion, sets the comment equal to the quick comment
    private void stepsForEmotionClicked(){
        loadAndSaveController.saveData(emotionsArrayList);
        timeController.sortArrayByDate(emotionsArrayList);
        emotionAdapter.notifyDataSetChanged();
        editQuickComment.getText().clear();
        displaySuccessful();
    }

    // If saving an emotion is successful
    private void displaySuccessful(){
        Toast.makeText(MainActivity.this, "Emotion Successfully Added!",
                Toast.LENGTH_LONG).show();
    }

}
