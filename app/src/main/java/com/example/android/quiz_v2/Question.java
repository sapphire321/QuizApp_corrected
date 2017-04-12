package com.example.android.quiz_v2;

/**
 * Created by Dragon on 4/5/2017.
 */

public class Question
{

    private int mImageResourceId;

    private String mQuestion;

/**
 * Create a new Question object.
 * @param imageResourceId is the image that comes with question
 * @param mQuestion is the question associated with the image
 **/
    public Question(int imageResourceId, String question)
    {
        mImageResourceId = imageResourceId;
        mQuestion = question;
    }


    //Get the image for the question
    public int getmImageResourceId()
    {
        return mImageResourceId;
    }

    //Get the question_text for the question
    public String getmQuestion()
    {
        return mQuestion;
    }
}

