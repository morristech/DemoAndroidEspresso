package com.icetea09.demoespresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
	public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void userShouldBeAbleToLoginIfUsernameAndPasswordProvided() {
        //Type the username
        onView(withId(R.id.et_username)).perform(typeText("trinh.le"));
        //Type the password
        onView(withId(R.id.et_password)).perform(typeText("dummypassword"));
        //Click on Login button, we can use withId(R.id.btn_login) instead of withText("Login")
        onView(withText("Login")).perform(click());
        //Check if the TextView message display the proper text
        onView(allOf(withId(R.id.tv_message), withText("Login successfully!"))).check(matches(isDisplayed()));
    }

    @Test
    public void userShouldSeeErrorMessageIfUsernameMissing() {
        //Type the password
        onView(withId(R.id.et_password)).perform(typeText("dummypassowrd"));
        //Click on Login button, we can use withId(R.id.btn_login) instead of withText("Login")
        onView(withText("Login")).perform(click());
        //Check if the TextView message display the proper text
        onView(allOf(withId(R.id.tv_message), withText("You must enter both username and password!"))).check(matches(isDisplayed()));
    }

    @Test
    public void userShouldSeeErrorMessageIfPasswordMissing() {
        //Type the username
        onView(withId(R.id.et_username)).perform(typeText("trinh.le"));
        //Click on Login button, we can use withId(R.id.btn_login) instead of withText("Login")
        onView(withText("Login")).perform(click());
        //Check if the TextView message display the proper text
        onView(allOf(withId(R.id.tv_message), withText("You must enter both username and password!"))).check(matches(isDisplayed()));
    }

}
