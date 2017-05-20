package com.example.android.quiz_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Q1Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Q1Fragment()).commit();

    }
}
