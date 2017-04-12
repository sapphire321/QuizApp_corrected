package com.example.android.quiz_v2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class QuestionAdapter extends ArrayAdapter<Question>
{
    public QuestionAdapter(Activity context, ArrayList<Question> question, int resource)
    {
        super(context, 0, question);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        // Get the {@link Question} object located at this position in the list
        Question currentQuestion = getItem(position);

        //Find imageView in the row.xml with the ID
        ImageView primaryImageView = (ImageView) listItemView.findViewById(R.id.imageView);

        //Display provided image
        primaryImageView.setImageResource(currentQuestion.getmImageResourceId());

        //Find TextView of the question displayed
        TextView primaryTextView = (TextView) listItemView.findViewById(R.id.textView);

        primaryTextView.setText(currentQuestion.getmQuestion());

        return listItemView;
    }
}
