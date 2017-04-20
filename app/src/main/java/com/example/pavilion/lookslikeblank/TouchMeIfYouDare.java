package com.example.pavilion.lookslikeblank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TouchMeIfYouDare extends AppCompatActivity {
public static final String EXTRA_MESSAGE1 = "com.example.pavilion.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_me_if_you_dare);
    }

    public void CheckAnswer(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, AnswerActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1, message);
        startActivity(intent);
    }
}
