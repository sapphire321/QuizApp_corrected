package com.example.android.quiz_v2;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quiz_v2.MainActivity.score;

/**
 * A simple {@link Fragment} subclass.
 */
public class Q5Fragment extends Fragment {

    private RadioGroup buttonsGroup;
    private String[] answers ={"Do", "Don't"};
    private ImageView questionImage;
    private TextView questionText;

    public Q5Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.row, container, false);
        super.onCreate(savedInstanceState);

        // Question in Image View
        questionImage = (ImageView) rootView.findViewById(R.id.imageView);
        questionImage.setImageResource(R.drawable.edittextsample);
        // Question in TextView
        questionText = (TextView) rootView.findViewById(R.id.textView);
        questionText.setText(R.string.questionQ5);


        // FINDING THE RADIO GROUP TO DISPLAY THE BUTTONS FOR CHOOSING THE ANSWER
        buttonsGroup = (RadioGroup) rootView.findViewById(R.id.radio_group);

        //Creating Radio buttons
        for (int a = 0; a < 2; a++){
            RadioButton buttons = new RadioButton(rootView.getContext());
            buttons.setId(500 + a);
            buttons.setText(answers[a]);
            buttons.setTextColor(Color.parseColor("#303F9F"));
            buttons.setTextSize(14);
            buttons.setPadding(0, 10, 10, 10);
            buttonsGroup.addView(buttons, a);
        }

        buttonsGroup.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT);
                toast.show();
                score++;
                showSubmitBtn();
            }
        });
        return rootView;
    }

    private void showSubmitBtn()
    {
        Button btn = (Button) getActivity().findViewById(R.id.checkBtn);
        btn.setVisibility(View.VISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(score == 5) {
                    Intent intent = new Intent(getContext(), SubmitAnswers.class);
                    startActivity(intent);
                }
                else
                {
                    Toast toast2 = Toast.makeText(getActivity(), "You didn't answer correctly all the questions.", Toast.LENGTH_SHORT);
                    toast2.show();
                }
            }
        });


    }

}
