package fariborz.com.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Fariborz on 19/03/2020.
 */
class MovieViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    var mFragmentList : MutableList<Fragment> = arrayListOf()
    var mFragmentTitleList : MutableList<String> = arrayListOf()

    fun addFragment(fragment:Fragment, title:String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList.get(position)
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
}