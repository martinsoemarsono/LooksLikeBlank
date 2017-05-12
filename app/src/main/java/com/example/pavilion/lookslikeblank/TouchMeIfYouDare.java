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

public class TouchMeIfYouDare extends AppCompatActivity
        implements ThreeBottomButtonFragment.ButtonClickListener {
    public static final String EXTRA_MESSAGE = "com.example.pavilion.MESSAGE";

    /*
    Context context = getApplicationContext();
    CharSequence text = "No answer is read";
    int duration = Toast.LENGTH_SHORT;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_me_if_you_dare_2);
/*
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
        }

        ImageFragment topFragment = new ImageFragment();
        ThreeBottomButtonFragment bottomFragment = new ThreeBottomButtonFragment();

        topFragment.setArguments(getIntent().getExtras());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, topFragment).commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, bottomFragment).commit();*/
    }

    @Override
    public void PreviousButtonListener(int position) {

    }

    @Override
    public void ProceedButtonListener(int position) {
        Intent intent = new Intent(this, AnswerActivity.class);
        startActivity(intent);
    }

    @Override
    public void NextButtonListener(int position) {

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
            /*Toast.makeText(context, text, duration).show();
            CheckAnswer(view);*/
        }
    }

}
