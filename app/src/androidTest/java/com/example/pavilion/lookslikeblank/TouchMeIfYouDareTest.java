package com.example.pavilion.lookslikeblank;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Pavilion on 4/20/2017.
 */

@RunWith(AndroidJUnit4.class)
public class TouchMeIfYouDareTest {

    @Rule
    public ActivityTestRule<TouchMeIfYouDare> TouchMeIfYouDareActivityTestRule =
            new ActivityTestRule<TouchMeIfYouDare>(TouchMeIfYouDare.class);

    @Test
    public void clickTouchMeIfYouDare_OpensPicture() throws Exception {
        onView(withId(R.id.button3))
                .check(matches(withText("Check Out What It is")));
    }
}
