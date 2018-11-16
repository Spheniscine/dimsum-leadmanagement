package app.salescandy.android.test.dimsum

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import app.salescandy.android.test.dimsum.ui.MainActivity
import app.salescandy.android.test.dimsum.ui.ManagerActivity
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clickManagerLogin_launchesManagerActivity() {
        clickOn(R.id.button_managerLogin)
        assertTrue(currentActivity is ManagerActivity)
    }

    @Test
    fun clickUpButton_fromManagerActivity_goesBackToMainActivity() {
        clickOn(R.id.button_managerLogin)
        clickOn(upButton)
        assertTrue(currentActivity is MainActivity)
    }
}