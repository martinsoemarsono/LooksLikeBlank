package com.example.pavilion.lookslikeblank;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.pavilion.lookslikeblank.AnswerActivity.AcceptableAnswer1;
import static com.example.pavilion.lookslikeblank.AnswerActivity.AcceptableAnswer3;
import static com.example.pavilion.lookslikeblank.AnswerActivity.ifAMatch;

/**
 * Created by Pavilion on 4/20/2017.
 */

@RunWith(AndroidJUnit4.class)
public class TouchMeIfYouDareTest {

    @Rule
    public ActivityTestRule<TouchMeIfYouDare> TouchMeIfYouDareActivityTestRule =
            new ActivityTestRule<TouchMeIfYouDare>(TouchMeIfYouDare.class);

    @Test
    public void AnswerSubmitted() throws Exception {
        onView(withId(R.id.editText3))
         .perform(typeText(AcceptableAnswer1));
        closeSoftKeyboard();
        onView(withId(R.id.button3))
         .perform(click());
        onView(withId(R.id.textView3))
         .check(matches(withText(AcceptableAnswer1)));
    }

    public void ClearInput(){
        onView(withId(R.id.editText3)).perform(clearText());
    }

    public void InputIteratorValidator(String stringInput){
        onView(withId(R.id.editText3))
         .perform(typeText(stringInput));

        closeSoftKeyboard();

        onView(withId(R.id.button3))
         .perform(click());
        onView(withId(R.id.textView6))
         .check(matches(withText(ifAMatch)));
    }

    @Test
    public void CapitalizationTest() throws Exception {
        String[] strArray = new String[5];

        strArray[0] = "man ";
        strArray[1] = "human";
        strArray[2] = "a man";
        strArray[3] = "a human ";
        strArray[4] = "a human being";

        for(int i = 0; i < strArray.length; i++){
            InputIteratorValidator(strArray[i]);
            pressBack();
            ClearInput();
        }

        for(int i = 0; i < strArray.length; i++){
            InputIteratorValidator(strArray[i].toUpperCase());
            pressBack();
            ClearInput();
        }
    }
}
