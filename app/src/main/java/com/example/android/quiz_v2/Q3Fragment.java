package com.example.android.quiz_v2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quiz_v2.MainActivity.score;

/**
 * A simple {@link Fragment} subclass.
 */
public class Q3Fragment extends Fragment {

    private String[] answers ={"Yes", "A little bit of color won't hurt"};
    private int checked = 0;
    private ImageView questionImage;
    private TextView questionText;

    public Q3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.row, container, false);
        super.onCreate(savedInstanceState);

        // Question in Image View
        questionImage = (ImageView) rootView.findViewById(R.id.imageView);
        questionImage.setImageResource(R.drawable.backgroundtextcolor);
        // Question in TextView
        questionText = (TextView) rootView.findViewById(R.id.textView);
        questionText.setText(R.string.questionQ3);

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
