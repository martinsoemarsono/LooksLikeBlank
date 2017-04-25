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
import static com.example.pavilion.lookslikeblank.EspressoTestMatchers.withDrawable;

/**
 * Created by Pavilion on 4/20/2017.
 */

@RunWith(AndroidJUnit4.class)
public class TouchMeIfYouDareTest {

    String[] strArray = new String[5];

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
        //Clears the text in the input field
        onView(withId(R.id.editText3)).perform(clearText());
    }

    public void InputIteratorValidator(String stringInput){
        //Automates actions starting from typing,
        // closing the soft keyboard and clicking
        onView(withId(R.id.editText3))
         .perform(typeText(stringInput));

        closeSoftKeyboard();

        onView(withId(R.id.button3))
         .perform(click());
    }

    public void ifAMatchTest() throws Exception {
        onView(withId(R.id.textView6))
         .check(matches(withText(ifAMatch)));
    }

    public void ifNotAMatchTest() throws Exception {
        onView(withId(R.id.textView6))
         .check(matches(withText(" ")));
    }

    @Test
    public void CapitalizationTest() throws Exception {
        //Test Strings
        strArray[0] = "man ";
        strArray[1] = "human";
        strArray[2] = "a man";
        strArray[3] = "a human ";
        strArray[4] = "a human being";

        for(int i = 0; i < strArray.length; i++){
            InputIteratorValidator(strArray[i]);
            ifAMatchTest();
            pressBack();
            ClearInput();
        }

        for(int i = 0; i < strArray.length; i++){
            InputIteratorValidator(strArray[i].toUpperCase());
            ifAMatchTest();
            pressBack();
            ClearInput();
        }
    }

    @Test
    public void ContentTest() throws Exception {
        //Test Strings
        strArray[0] = "min ";
        strArray[1] = "hooman";
        strArray[2] = "a many";
        strArray[3] = "a hman ";
        strArray[4] = "a human bein";

        for(int i = 0; i < strArray.length; i++){
            InputIteratorValidator(strArray[i]);
            ifNotAMatchTest();
            pressBack();
            ClearInput();
        }

        for(int i = 0; i < strArray.length; i++){
            InputIteratorValidator(strArray[i].toUpperCase());
            ifNotAMatchTest();
            pressBack();
            ClearInput();
        }
    }

    @Test
    public void CorrectImageTest() throws Exception {
        //Checks if the image showing is the right one
        onView(withId(R.id.imageView2))
         .check(matches(withDrawable(R.drawable.picture1)));
    }

    @Test
    public void NextTest() throws Exception {
        //Goes to the next page
        onView(withId(R.id.button10))
         .perform(click());
        onView(withId(R.id.button10))
         .check(matches(withText("Next")));
        onView(withId(R.id.imageView2))
         .check(matches(withDrawable(R.drawable.picture2)));
    }

    @Test
    public void PreviousTest() throws Exception {
        //Go to the next page first
        NextTest();

        //Clicks the previous button
        onView(withId(R.id.button9))
         .perform(click());
        onView(withId(R.id.button9))
         .check(matches(withText("Previous")));
        onView(withId(R.id.imageView2))
         .check(matches(withDrawable(R.drawable.picture1)));
    }

    @Test
    public void NextOnLastScreenTest() throws Exception {
        /*
        When users click on the next button on the last picture
        of the app, the following will happen:
        - The app will pop up a toast which displays a message
         telling the user that there is no more picture to play with
        - The app will not move to a different screen
         */

        /*
         for (int i = 0; i < numOfPages; i++) {
            NextTest();
         }
        */

        /*

        The following code is to test for a Toast item
         Source: (http://stackoverflow.com/questions/
         28390574/checking-toast-message-in-android-espresso)

         import static android.support.test.espresso.assertion.ViewAssertions.matches;
         import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
         import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
         import static android.support.test.espresso.matcher.ViewMatchers.withText;
         import static org.hamcrest.Matchers.is;
         import static org.hamcrest.Matchers.not;
         ....
         onView(withText(R.string.TOAST_STRING)).inRoot(withDecorView(not(is(getActivity().getWindow()
          .getDecorView())))).check(matches(isDisplayed()));
          */


    }
}
