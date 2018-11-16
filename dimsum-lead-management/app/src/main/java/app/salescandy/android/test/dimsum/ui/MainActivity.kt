package app.salescandy.android.test.dimsum.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.salescandy.android.test.dimsum.R
import app.salescandy.android.test.dimsum.util.android.launchActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // clicking on manager login button goes to manager activity
        button_managerLogin.setOnClickListener {
            finish()
            this@MainActivity.launchActivity(ManagerActivity::class)
        }
    }
}
