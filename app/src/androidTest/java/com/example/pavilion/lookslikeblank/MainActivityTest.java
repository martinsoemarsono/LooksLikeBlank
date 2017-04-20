package com.example.pavilion.lookslikeblank;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Pavilion on 4/20/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public static final String TEST_STRING = "This is just a test";
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void clickSendButton_sendsStringToDisplayMessageActivity() throws Exception {
        onView(withId(R.id.editText))
                .perform(typeText(TEST_STRING));
        onView(withText("Send"))
                .perform(click());
        onView(withId(R.id.textView2))
                .check(matches(withText(TEST_STRING)));
    }

    @Test
    public void clickTouchMeIfYouDare_OpensPicture() throws Exception {
        onView(withText("Touch Me If You Dare"))
                .perform(click());
        //matches withHint is case sensitive
        onView(withId(R.id.editText3))
                .check(matches(withHint("What do you see?")));
    }

}
