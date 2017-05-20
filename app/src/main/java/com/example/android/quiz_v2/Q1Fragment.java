package com.example.android.quiz_v2;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quiz_v2.MainActivity.score;

/**
 * A simple {@link Fragment} subclass.
 */
public class Q1Fragment extends Fragment {

    private RadioGroup buttonsGroup;
    private String[] answers = {"Do", "Don't"};
    private ImageView questionImage;
    private TextView questionText;


    public Q1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.row, container, false);
        super.onCreate(savedInstanceState);

        // Question in Image View
        questionImage = (ImageView) rootView.findViewById(R.id.imageView);
        questionImage.setImageResource(R.drawable.lol2);
        // Question in TextView
        questionText = (TextView) rootView.findViewById(R.id.textView);
        questionText.setText(R.string.questionQ1);

        // FINDING THE RADIO GROUP TO DISPLAY THE BUTTONS FOR CHOOSING THE ANSWER
        buttonsGroup = (RadioGroup) rootView.findViewById(R.id.radio_group);

        //Creating Radio buttons
        for (int a = 0; a < 2; a++) {
            RadioButton buttons = new RadioButton(getContext());
            buttons.setId(100 + a);
            buttons.setText(answers[a]);
            buttons.setTextColor(Color.parseColor("#303F9F"));
            buttons.setTextSize(14);
            buttons.setPadding(0, 10, 10, 10);
            buttonsGroup.addView(buttons, a);
        }

        buttonsGroup.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT);
                toast.show();
                score++;
            }
        });
        return rootView;
    }

}