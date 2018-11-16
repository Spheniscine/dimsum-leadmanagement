package app.salescandy.android.test.dimsum.ui

import android.os.Bundle
import app.salescandy.android.test.dimsum.R
import app.salescandy.android.test.dimsum.util.android.FragmentEntry
import app.salescandy.android.test.dimsum.util.android.MyFragmentPagerAdapter
import app.salescandy.android.test.dimsum.util.android.SubActivity
import app.salescandy.android.test.dimsum.viewmodel.SalespersonMngViewModel
import kotlinx.android.synthetic.main.activity_manager.*

class ManagerActivity : SubActivity(MainActivity::class) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_exit)

        // Set up fragments
        val fragmentEntries = listOf(
            FragmentEntry(getString(R.string.salespeople_title), ManagerSalespeopleFragment::class),
            FragmentEntry(getString(R.string.leads_title), ManagerLeadFragment::class)
        )
        viewPager.adapter = MyFragmentPagerAdapter(supportFragmentManager, fragmentEntries)
        tabLayout.setupWithViewPager(viewPager)
    }

}
