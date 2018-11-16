package app.salescandy.android.test.dimsum

import android.app.Activity
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.withContentDescription
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import android.support.test.runner.lifecycle.Stage
import android.view.View
import org.hamcrest.Matcher
import kotlin.reflect.KClass

val context : Context = InstrumentationRegistry.getTargetContext()

/**
 * Assert that an activity is launched. Intents.init() must be called before the action intended to launch the activity.
 * @param activityClass The class of the activity to be launched.
 */
fun assertActivityLaunch(activityClass: KClass<*>) {
    intended(hasComponent(activityClass.java.name))
}

/**
 * Extension to Barista, to allow clicking on widgets that match ViewMatchers
 */
fun clickOn(matcher: Matcher<View>) {
    onView(matcher).perform(click())
}

/**
 * Constant to get the matcher for up buttons
 */
val upButton : Matcher<View> = withContentDescription(context.getString(R.string.abc_action_bar_up_description))


/**
 * Get current activity instance (https://qathread.blogspot.com/2014/09/discovering-espresso-for-android-how-to.html)
 * @return The current activity, or null if no activities are found
 */
val currentActivity : Activity? get() {
    var it : Activity? = null
    InstrumentationRegistry.getInstrumentation().runOnMainSync {
        val resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED)
        it = resumedActivities.lastOrNull()
    }
    return it
}