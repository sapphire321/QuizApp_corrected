package com.example.android.quiz_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quiz_v2.MainActivity.timesUp;


public class SubmitAnswers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.submit_answeres);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.summaryTextView);
        OrderSummaryTextView.setText(message);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitName(View view)
    {
        EditText name = (EditText) findViewById(R.id.editTextView);
        String playerName = name.getText().toString();
        String Message = createSummary(playerName);
        if (playerName.length() == 0)
        {
            Toast toast = Toast.makeText(this, "Please introduce your name first", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            displayMessage (Message);
        }
    }

    public String createSummary(String playerName)
    {
        String Message ="";
        if (timesUp == 0)
        {
            Message = getString(R.string.congratz) + " " + playerName;
            Message += "\n" + getString(R.string.summarytext);
        }
        else
        {
            Message = getString(R.string.shame) + " " + playerName;
            Message += "\n" + getString(R.string.summarytextshame);
        }
        return Message;
    }

    public void exitBtn(View v)
    {

       this.finishAffinity();
    }
}
