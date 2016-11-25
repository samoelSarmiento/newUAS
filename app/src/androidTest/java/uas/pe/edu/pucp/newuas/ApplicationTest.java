package uas.pe.edu.pucp.newuas;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import uas.pe.edu.pucp.newuas.view.LogInActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

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
    public void LogInUsuarioFalla() throws InterruptedException {
        //escribe usuario incorrectos
        onView(withId(R.id.edtName))
                .perform(typeText("admin"), closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(typeText("secreto"), closeSoftKeyboard());
        //click al login
        onView(withId(R.id.btnLogin)).perform(click());

        Thread.sleep(3000);
        //probar
        onView(withText(R.string.tvErrorLogin))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().peekDecorView())))
                .check(matches(isDisplayed()));
    }

    @Test
    public void LogInUsuarioFunciona() throws InterruptedException {
        //escribe usuario incorrectos
        onView(withId(R.id.edtName))
                .perform(typeText("admin"), closeSoftKeyboard());
        onView(withId(R.id.edtPassword))
                .perform(typeText("secret"), closeSoftKeyboard());
        //click al login
        onView(withId(R.id.btnLogin)).perform(click());

        Thread.sleep(3000);
        //probar
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
    }

}