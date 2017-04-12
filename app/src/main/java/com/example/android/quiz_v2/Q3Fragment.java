package com.example.android.quiz_v2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.quiz_v2.MainActivity.score;

/**
 * A simple {@link Fragment} subclass.
 */
public class Q3Fragment extends Fragment {

    private String[] answers ={"Yes", "A little bit of color won't hurt"};
    private int checked = 0;

    public Q3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        super.onCreate(savedInstanceState);


        // Create a list of words
        final ArrayList<Question> words = new ArrayList<Question>();
        words.add(new Question(R.drawable.backgroundtextcolor, "Avoid placing a large amount of colored text on colored backgrounds?"));


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

        //Checkbox Container
        LinearLayout containerCheckBox = (LinearLayout) rootView.findViewById(R.id.layout_container);

        // Listener - how many checkboxes are checked
        CompoundButton.OnCheckedChangeListener checkedChange = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checked++;
                    if (checked == 2)
                    {
                        Toast toast = Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT);
                        toast.show();
                        score++;
                    }
                }
                else
                {
                    checked--;
                }
            }
        };

        //Creating CheckBoxes
        for (int a = 0; a < 2; a++) {
            final CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(answers[a]);
            checkBox.setId(300 + a);
            checkBox.setTextSize(14);
            checkBox.setPadding(0, 10, 10, 10);
            containerCheckBox.addView(checkBox, a);
            checkBox.setOnCheckedChangeListener(checkedChange);
        }
        return rootView;
    }
}
