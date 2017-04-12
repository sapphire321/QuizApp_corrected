package com.example.android.quiz_v2;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.quiz_v2.MainActivity.score;

/**
 * A simple {@link Fragment} subclass.
 */
public class Q5Fragment extends Fragment {

    private RadioGroup buttonsGroup;
    private String[] answers ={"Do", "Don't"};
    private int checked = 0;

    public Q5Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        super.onCreate(savedInstanceState);


        // Create a list of words
        final ArrayList<Question> words = new ArrayList<Question>();
        words.add(new Question(R.drawable.edittextsample, "Use a secondary color on top of a background if there is not enough contrast between the two colors?"));


        // Create an {@link QuestionAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        //WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_colors);
        QuestionAdapter adapter = new QuestionAdapter(getActivity(), words, 0);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

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
