package app.salescandy.android.test.dimsum.util.android

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.lang.IllegalArgumentException
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

open class FragmentEntry(var title: String, var fragmentClass: KClass<*>) {
    init {
        if (!fragmentClass.isSubclassOf(Fragment::class)) throw IllegalArgumentException("fragmentClass must be subclass of Fragment")
    }
}

open class MyFragmentPagerAdapter(fm : FragmentManager,
                             val fragmentEntries : List<FragmentEntry>) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return fragmentEntries[position].fragmentClass.java.newInstance() as Fragment
    }

    override fun getCount(): Int {
        return fragmentEntries.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentEntries[position].title
    }

}