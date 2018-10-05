package com.example.jerry.feelsbookapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;

public class EmotionActivity extends AppCompatActivity {

    int emotionId;
    static TimeController timeController = new TimeController();
    private LoadAndSaveController loadAndSaveController = new LoadAndSaveController(this);
    Spinner emotionSpinner;
    Button saveButton;
    Button cancelButton;
    Button deleteButton;
    EditText timeEditText;
    Emotion emotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion);

        // Get the Intent, as well as the comment field: edit text
        final EditText editText = findViewById(R.id.editText);
        Intent intent = getIntent();

        // Get the id of the object you are using
        // Get a reference to the spinner
        // Get the save, delete and cancel buttons
        emotionId = intent.getIntExtra("emotionId", -1);
        findAllXMLItems();

        // Populate the spinner, the comment section. and the date
        // This will MAKE SURE the user clicked on an existing emotion
        // Just extra error-checking
        // Single list is used only for populating the spinner
        // If we decide to change the feature so that user's can change their emotions,
        // then singleList will now have more options for emotions
        EmotionsList<Emotion> singleList = new EmotionsList<>();
        if (emotionId != -1){
            emotion = MainActivity.emotionsArrayList.getEmotion(emotionId);
            singleList.addEmotion(emotion);
            timeEditText.setText(timeController.formatDateToISO(
                    MainActivity.emotionsArrayList.getEmotion(emotionId).getDate()));
            editText.setText(MainActivity.emotionsArrayList.getEmotion(emotionId).getComment());
        }

        // Initialize the spinner object
        ArrayAdapter<Emotion> adapter = populateSpinner(singleList);
        emotionSpinner.setAdapter(adapter);

        // When the save Button is pressed
        // Will save all the changes
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = editText.getText().toString();

                // If statement is unnecessary, but if the code undergoes more changes
                // sanity checking is always a good thing
                if (emotionId != -1){
                    // If the object is an existing one
                    // Simply update the time and the comment
                    // DO NOT let the user change the actual emotion
                    // Check to see that the date can actually be changed or that it's illegal

                    emotion.setComment(comment);
                    if (timeController.checkValidDate(timeEditText.getText().toString())) {
                        emotion.setDate(timeController.toCalendar((timeEditText.getText().toString())));
                        displaySuccessful();
                        loadAndSaveController.saveData(MainActivity.emotionsArrayList);
                        openMainActivity();
                    }
                    else {
                        displayFailed();
                    }
                }
            }
        });

        // Set an on click for canceling
        // Will not save anything, only sends the viewer to the main activity
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        // Set a listener for delete
        // Will only delete an object that already exists, otherwise, it will just redirect to main
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emotionId != -1){
                    MainActivity.emotionsArrayList.removeEmotion(MainActivity.emotionsArrayList.getEmotion(emotionId));
                    loadAndSaveController.saveData(MainActivity.emotionsArrayList);
                }
                openMainActivity();
            }
        });
    }


    // References all the xml fields you need to edit
    private void findAllXMLItems(){
        emotionSpinner = findViewById(R.id.emotionSpinner);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);
        deleteButton = findViewById(R.id.deleteButton);

        // Get the edit text input box
        timeEditText = findViewById(R.id.timeEditText);
    }

    // If saving an emotion is successful
    private void displaySuccessful(){
        Toast.makeText(EmotionActivity.this, "Emotion Successfully Saved!",
                Toast.LENGTH_LONG).show();
    }

    // If an emotions date is incorrect
    private void displayFailed(){
        Toast.makeText(EmotionActivity.this, "Emotion Failed to Save, Invalid Date",
                Toast.LENGTH_LONG).show();
    }

    // Used to open the main Activity
    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Populates the spinner
    // List of emotions as input and an array adapter of those emotions as the output
    private ArrayAdapter<Emotion> populateSpinner(List<Emotion> emotionList){
        ArrayAdapter<Emotion> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, emotionList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }
}
