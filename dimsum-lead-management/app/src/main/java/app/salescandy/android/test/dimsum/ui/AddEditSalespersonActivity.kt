package app.salescandy.android.test.dimsum.ui

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import app.salescandy.android.test.dimsum.R
import app.salescandy.android.test.dimsum.util.PACKAGE_NAME
import app.salescandy.android.test.dimsum.util.android.showToast
import kotlinx.android.synthetic.main.activity_add_edit_salesperson.*

class AddEditSalespersonActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "$PACKAGE_NAME.EXTRA_ID"
        const val EXTRA_USERNAME = "$PACKAGE_NAME.EXTRA_USERNAME"
        const val EXTRA_PHONE = "$PACKAGE_NAME.EXTRA_PHONE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_salesperson)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)

        if(intent.hasExtra(EXTRA_ID)) {
            title = getString(R.string.edit_salesperson_title)
            editText_username.setText(intent.getStringExtra(EXTRA_USERNAME))
            editText_phone.setText(intent.getStringExtra(EXTRA_PHONE))
        } else title = getString(R.string.add_salesperson_title)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit_salesperson, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.save_salesperson -> {
                saveSalesperson()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveSalesperson() {
        val username = editText_username.text.toString().trim()
        val phone = editText_phone.text.toString().trim()

        if(arrayOf(username, phone).any{ it.isEmpty() }) {
            showToast("Please insert a username and phone number")
            return
        }

        val data = Intent().apply {
            putExtra(EXTRA_USERNAME, username)
            putExtra(EXTRA_PHONE, phone)
        }

        val id = intent.getIntExtra(EXTRA_ID, -1)
        if(id != -1) data.putExtra(EXTRA_ID, id)

        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
