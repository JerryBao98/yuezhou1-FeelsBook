package com.example.jerry.notetaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EmotionSummaryActivity extends AppCompatActivity {

    Button mainMenuButton;

    private int numSad = 0;
    private int numAnger = 0;
    private int numFear = 0;
    private int numSurprise = 0;
    private int numLove = 0;
    private int numJoy = 0;

    TextView sadnessTextView;
    TextView angerTextView;
    TextView fearTextView;
    TextView surpriseTextView;
    TextView loveTextView;
    TextView joyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_summary);
        mainMenuButton = findViewById(R.id.mainMenuButton);
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // Count the total number of emotions for each type
        countEmotion(MainActivity.emotionsArrayList);

        // Reference the text views and
        // Display the values
        sadnessTextView = findViewById(R.id.sadnessTextView);
        sadnessTextView.setText(String.valueOf(numSad));

        angerTextView = findViewById(R.id.angerTextView);
        angerTextView.setText(String.valueOf(numAnger));

        fearTextView = findViewById(R.id.fearTextView);
        fearTextView.setText(String.valueOf(numFear));

        surpriseTextView = findViewById(R.id.surpriseTextView);
        surpriseTextView.setText(String.valueOf(numSurprise));

        loveTextView = findViewById(R.id.loveTextView);
        loveTextView.setText(String.valueOf(numLove));

        joyTextView = findViewById(R.id.joyTextView);
        joyTextView.setText(String.valueOf(numJoy));
    }

    // Provides a count of all the emotions
    private void countEmotion(ArrayList<Emotion> emotions){
        for (int i = 0; i< emotions.size(); i ++) {
            if (emotions.get(i).getEmotionName().equals("Fear")) {
                this.numFear += 1;
            }
            if (emotions.get(i).getEmotionName().equals("Anger")) {
                this.numAnger += 1;
            }
            if (emotions.get(i).getEmotionName().equals("Joy")) {
                this.numJoy += 1;
            }
            if (emotions.get(i).getEmotionName().equals("Surprise")) {
                this.numSurprise += 1;
            }
            if (emotions.get(i).getEmotionName().equals("Sadness")) {
                this.numSad += 1;
            }
            if (emotions.get(i).getEmotionName().equals("Love")) {
                this.numLove += 1;
            }
        }
    }

}
