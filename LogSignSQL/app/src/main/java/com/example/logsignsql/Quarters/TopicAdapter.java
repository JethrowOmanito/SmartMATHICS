package com.example.logsignsql.Quarters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.logsignsql.R;


public class TopicAdapter extends BaseAdapter {
    String topicName[];
    Context context;

    public TopicAdapter(String[] topicName, Context context){
        this.topicName = topicName;
        this.context = context;
    }

    @Override
    public int getCount() {
        return topicName.length;
    }

    @Override
    public Object getItem(int i) {
        return topicName[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View gridView = view;
        LayoutInflater inflater;

        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.custom_topic_item_layout, null);
        }
        TextView textView = gridView.findViewById(R.id.topic_text);
        textView.setText(topicName[i]);

        return gridView;
    }
}

