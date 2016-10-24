package uas.pe.edu.pucp.newuas;

import android.support.test.espresso.Root;

import org.hamcrest.Matcher;

/**
 * Created by samoe on 21/10/2016.
 */

public class MobileViewMatchers {
    public static Matcher<Root> isToast() {
        return new ToastMatcher();
    }
}
