package app.salescandy.android.test.dimsum.util.android

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlin.reflect.KClass

/**
 * Activity class that overrides some methods to support up navigation.
 */
abstract class SubActivity(private var parentActivityClass: KClass<*>) : AppCompatActivity() {
    private fun goBack() {
        if(isTaskRoot) {
            finish()
            launchActivity(parentActivityClass)
        } else {
            NavUtils.navigateUpFromSameTask(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        goBack()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                goBack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}