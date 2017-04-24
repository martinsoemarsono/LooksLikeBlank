package com.example.pavilion.lookslikeblank;

import android.view.View;

import org.hamcrest.Matcher;

/**
 * Created by Pavilion on 4/24/2017.
 */

public class EspressoTestMatchers {

    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }

    public static Matcher<View> noDrawable() {
        return new DrawableMatcher(-1);
    }
}
