package com.unittesting;

import androidx.appcompat.widget.WithHint;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {
    private final String dummyVolume = "504.0";
    private final String dummyCircumference = "100.0";
    private final String dummySurfaceArea = "369.0";
    private final String dummyLength = "12.0";
    private final String dummyWidth = "7.0";
    private final String dummyHeight = "6.0";
    private final String emptyInput = "";
    private final String fieldEmpty = "Field ini tidak boleh kosong";

    @Rule
    public ActivityTestRule<MainActivity> mMainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void assertGetCircumference() {
        onView(withId(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.et_lebar)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.et_tinggi)).perform(typeText(dummyHeight), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_circumference)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_circumference)).perform(click());

        onView(withId(R.id.tv_hasil)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_hasil)).check(matches(withText(dummyCircumference)));
    }

    @Test
    public void assertGetSurfaceArea() {
        onView(withId(R.id.et_lebar)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.et_tinggi)).perform(typeText(dummyHeight), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_surfacearea)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_surfacearea)).perform(click());

        onView(withId(R.id.tv_hasil)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_hasil)).check(matches(withText(dummySurfaceArea)));
    }

    @Test
    public void assertGetVolume () {
        onView(withText(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.et_tinggi)).perform(typeText(dummyHeight), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_vol)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_vol)).perform(click());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).check(matches(withText(dummyVolume)));
    }

    //pengecekan untuk empty input
    @Test
    public void assertEmptyInput () {
        //pengecekan input untuk length
        onView(withId(R.id.et_panjang)).perform(typeText(emptyInput), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.et_panjang)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());

        //pengecekan input untuk width
        onView(withId(R.id.et_lebar)).perform(typeText(emptyInput), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.et_lebar)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.et_lebar)).perform(typeText(dummyWidth), closeSoftKeyboard());

        //pengecekan input untuk tinggi
        onView(withId(R.id.et_tinggi)).perform(typeText(emptyInput), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(hasErrorText(emptyInput)));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.et_tinggi)).check(matches(isDisplayed()));
        onView(withId(R.id.et_tinggi)).perform(click());


    }
}