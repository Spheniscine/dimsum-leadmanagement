package app.salescandy.android.test.dimsum.util.android

import android.content.Context
import android.content.Intent
import android.widget.Toast
import kotlin.reflect.KClass

/**
 * Extension function to launch an activity
 * @param activityClass The class of the activity to launch
 */
fun Context.launchActivity(activityClass: KClass<*>) {
    val intent = Intent(this, activityClass.java)
    startActivity(intent)
}

fun Context.showToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}