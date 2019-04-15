package com.example.m6.views;

import org.junit.Rule;
import org.junit.Test;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import com.example.m6.R;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import static org.junit.Assert.*;

public class ConfigurationActivityTest {
    @Rule
    public ActivityTestRule<ConfigurationActivity> activityTestRule = new ActivityTestRule<>(ConfigurationActivity.class);

    @Test
    public void allGood() {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(player_information.class.getName(), null, false);

        onView(withId(R.id.name_text))
                .perform(typeText("Ray"), closeSoftKeyboard());
        onView(withId(R.id.fighter_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.trader_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.pilot_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.engineer_point_text))
                .perform(typeText("13"), closeSoftKeyboard());
        onView(withId(R.id.save_button)).perform(click());

        onView(withId(android.R.id.message))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(withText("player Ray is successfully created")));
        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        player_information nextActivity = (player_information) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 2000);
        // next activity is opened and captured.

        assertNotNull(nextActivity);
        nextActivity .finish();
    }

    @Test
    public void nameIsNull() {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(player_information.class.getName(), null, false);

        onView(withId(R.id.fighter_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.trader_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.pilot_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.engineer_point_text))
                .perform(typeText("13"), closeSoftKeyboard());
        onView(withId(R.id.save_button)).perform(click());

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        onView(withId(android.R.id.message))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(withText("input field can not be blank")));
        player_information nextActivity = (player_information) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 2000);
        // next activity is opened and captured.
        assertNull(nextActivity);

    }

    @Test
    public void sumIsNot16() {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(player_information.class.getName(), null, false);

        onView(withId(R.id.name_text))
                .perform(typeText("Ray"), closeSoftKeyboard());
        onView(withId(R.id.fighter_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.trader_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.pilot_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.engineer_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.save_button)).perform(click());

        onView(withId(android.R.id.message))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(withText("the sum of skill point should be 16")));
        player_information nextActivity = (player_information) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 2000);
        // next activity is opened and captured.
        assertNull(nextActivity);
    }

    @Test
    public void pointsNull() {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(player_information.class.getName(), null, false);

        onView(withId(R.id.name_text))
                .perform(typeText("Ray"), closeSoftKeyboard());
        onView(withId(R.id.fighter_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.trader_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.pilot_point_text))
                .perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.save_button)).perform(click());

        onView(withId(android.R.id.message))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(withText("input field can not be blank")));
        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        player_information nextActivity = (player_information) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 2000);
        // next activity is opened and captured.
        assertNull(nextActivity);
//        nextActivity .finish();
    }

}