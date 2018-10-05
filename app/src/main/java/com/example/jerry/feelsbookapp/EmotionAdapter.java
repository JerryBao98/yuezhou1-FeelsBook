package com.example.jerry.feelsbookapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

// Custom Adapter class for the Emotion Object
// Inherits the BaseAdapter class
// Displays the Emotion name as well as its date

public class EmotionAdapter extends BaseAdapter {
    private List<Emotion> mEmotionList;
    private static TimeController timeController = new TimeController();
    private Context mContext;

    // Constructor
    // We need to have the context and emotion list specified
    EmotionAdapter(Context mContext, List<Emotion> mEmotionList){
        this.mContext = mContext;
        this.mEmotionList = mEmotionList;
    }

    // Will return a count of the emotions list
    @Override
    public int getCount(){
        return this.mEmotionList.size();
    }

    // Will return an item from the emotion list based on its position
    @Override
    public Object getItem(int position) {
        return mEmotionList.get(position);
    }

    // Will return an item's index
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Gets the view and attaches it to the list
    // Modifies the text views of the list item to match adapter_view_layout.xml
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Instantiate the view
        View v = View.inflate(mContext, R.layout.adapter_view_layout, null);

        // Get the text view items from the layout, be sure to convert as the view is different
        TextView textViewName = v.findViewById(R.id.emotionTextView);
        TextView textViewdate = v.findViewById(R.id.dateTextView);

        // Set the text view to the date and time of the instance of the emotion
        textViewName.setText(mEmotionList.get(position).getEmotionName());
        textViewdate.setText(timeController.formatDateToISO(mEmotionList.get(position).getDate()));

        // Set the tag of the view object to the name of the emotion
        v.setTag(mEmotionList.get(position).getEmotionName());
        return v;
    }
}
