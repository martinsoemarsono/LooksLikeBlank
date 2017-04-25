package com.example.pavilion.lookslikeblank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    public static final String ifAMatch = "We See The Same Thing!";

    public static final String AcceptableAnswer1 = "A Man";
    public static final String AcceptableAnswer2 = "A Human";
    public static final String AcceptableAnswer3 = "A Human Being";
    public static final String AcceptableAnswer4 = "Human";
    public static final String AcceptableAnswer5 = "Man";

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

        //Find textView6 on the app and assign it to textView1 variable
        TextView textView1 = (TextView) findViewById(R.id.textView6);

        //Data validation on the input in textView1.  Users will be allowed to put in
        //a variety of different inputs (this includes non-case-sensitive, regardless of spacebar
        //characters, as well as synonyms of the answer).
        if (message.toLowerCase().replaceAll("\\s+$", "").equals(AcceptableAnswer1.toLowerCase()
         .replaceAll("\\s+$", ""))
         || (message.toLowerCase().replaceAll("\\s+$", "").equals(AcceptableAnswer2.toLowerCase()
         .replaceAll("\\s+$", "")))
         || (message.toLowerCase().replaceAll("\\s+$", "").equals(AcceptableAnswer3.toLowerCase()
         .replaceAll("\\s+$", "")))
         || (message.toLowerCase().replaceAll("\\s+$", "").equals(AcceptableAnswer4.toLowerCase()
         .replaceAll("\\s+$", "")))
         || (message.toLowerCase().replaceAll("\\s+$", "").equals(AcceptableAnswer5.toLowerCase()
         .replaceAll("\\s+$", "")))) {
            textView1.setText(ifAMatch);
        } else {
            textView1.setText(" ");
        }
    }
}
