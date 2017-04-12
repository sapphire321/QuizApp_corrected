package com.example.android.quiz_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dragon on 4/6/2017.
 */

public class Q5Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Q5Fragment()).commit();
    }
}
