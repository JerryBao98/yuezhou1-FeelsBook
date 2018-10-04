package com.example.jerry.feelsbookapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

// Custom Adapter class for the Emotion Object

public class EmotionAdapter extends BaseAdapter {
    private List<Emotion> mEmotionList;
    static TimeReformatter timeReformatter = new TimeReformatter();
    private Context mContext;

    public EmotionAdapter(Context mContext, List<Emotion> mEmotionList){
        this.mContext = mContext;
        this.mEmotionList = mEmotionList;
    }

    @Override
    public int getCount(){
        return this.mEmotionList.size();
    }

    @Override
    public Object getItem(int position) {
        return mEmotionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Gets the view and attaches it to the list
    // Modifies the textviews of the list item to match adapter_view_layout.xml
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
        textViewdate.setText(timeReformatter.formatDateToISO(mEmotionList.get(position).getDate()));

        v.setTag(mEmotionList.get(position).getEmotionName());
        return v;
    }
}
