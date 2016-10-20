package uas.pe.edu.pucp.newuas;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import uas.pe.edu.pucp.newuas.view.LogInActivity;
import uas.pe.edu.pucp.newuas.view.MainActivity;


@RunWith(AndroidJUnit4.class)
public class ApplicationTest {
    @Rule
    public ActivityTestRule<LogInActivity> mActivityRule = new ActivityTestRule<>(
            LogInActivity.class);

    @Test
    public void LogInDisplay() {
        onView(withId(R.id.activity_login)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void LogInUsuarioFalla() {
        //escribe usuario incorrectos
        onView(withId(R.id.edtName))
                .perform(typeText("admin"), closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(typeText("secreto"), closeSoftKeyboard());
        //click al login
        onView(withId(R.id.btnLogin)).perform(click());
        //se verifica q el toast haya aparecido con el mensaje de que fue incorrecto
        onView(withText("Usuario o contraseña incorrectos"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

 }