package com.example.android.quiz_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

/**
 * Created by Dragon on 4/5/2017.
 */

public class Q1Activity extends AppCompatActivity
{
public CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Q1Fragment()).commit();

    }
}
