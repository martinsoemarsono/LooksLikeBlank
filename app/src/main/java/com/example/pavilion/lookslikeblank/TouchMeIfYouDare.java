package com.example.pavilion.lookslikeblank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.duration;

public class TouchMeIfYouDare extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.pavilion.MESSAGE";

    Context context = getApplicationContext();
    CharSequence text = "No answer is read";
    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_me_if_you_dare);
    }

    public void CheckAnswer(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, AnswerActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText3);
        String message = editText.getText().toString();
        if (!message.equals(null)) {
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else {
            Toast.makeText(context, text, duration).show();
            CheckAnswer(view);
        }
    }
}
