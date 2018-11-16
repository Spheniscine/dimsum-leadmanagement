package app.salescandy.android.test.dimsum

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import app.salescandy.android.test.dimsum.ui.AddEditSalespersonActivity
import app.salescandy.android.test.dimsum.ui.MainActivity
import app.salescandy.android.test.dimsum.ui.ManagerActivity
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickBack
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.internal.matcher.DrawableMatcher.Companion.withDrawable
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ManagerActivityTest {
    @get:Rule
    var activityRule = ActivityTestRule(ManagerActivity::class.java)

    @Test
    fun clickUpButton_goesBackToMainActivity() {
        clickOn(upButton)
        assertTrue(currentActivity is MainActivity)
    }

    @Test
    fun clickBack_goesBackToMainActivity() {
        clickBack()
        assertTrue(currentActivity is MainActivity)
    }

    @Test
    fun clickAddSalesperson_goesToAddSalespersonActivity() {
        clickOn(R.id.button_addSalesperson)
        assertTrue(currentActivity is AddEditSalespersonActivity)
        assertEquals(context.getString(R.string.add_salesperson_title), currentActivity?.title)
    }

    @Test
    fun clickBack_fromAddSalespersonActivity_goesBackToManagerActivity() {
        clickOn(R.id.button_addSalesperson)
        clickBack()
        assertTrue(currentActivity is ManagerActivity)
    }

    @Test
    fun clickUpButton_fromAddSalespersonActivity_goesBackToManagerActivity() {
        clickOn(R.id.button_addSalesperson)
        clickOn(upButton)
        assertTrue(currentActivity is ManagerActivity)
    }
}