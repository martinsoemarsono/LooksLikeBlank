package com.example.pavilion.lookslikeblank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private static final String ifAMatch = "We See The Same Thing!";

    private static final String AcceptableAnswer1 = "A Man";
    private static final String AcceptableAnswer2 = "A Human";
    private static final String AcceptableAnswer3 = "A Human Being";
    private static final String AcceptableAnswer4 = "Human";
    private static final String AcceptableAnswer5 = "Man";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_activity);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(TouchMeIfYouDare.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(message);

        TextView textView1 = (TextView) findViewById(R.id.textView6);

        if (message.toLowerCase().equals(AcceptableAnswer1.toLowerCase())
         || (message.toLowerCase().equals(AcceptableAnswer2.toLowerCase()))
         || (message.toLowerCase().equals(AcceptableAnswer3.toLowerCase()))
         || (message.toLowerCase().equals(AcceptableAnswer4.toLowerCase()))
         || (message.toLowerCase().equals(AcceptableAnswer5.toLowerCase()))) {
            textView1.setText(ifAMatch);
        } else {
            textView1.setText(null);
        }
    }


}
