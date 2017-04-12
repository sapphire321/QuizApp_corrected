package com.example.android.quiz_v2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter
{
    /**Fragment TABS part**/
    final int PAGE_COUNT = 5;
    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3", "Tab4", "Tab5" };
    private Context context;
    /**Fragment TABS END**/

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.context = context;    /**Fragment TABS END**/
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0) {
            return new Q1Fragment();
        } else if (position == 1) {
            return new Q2Fragment();
        } else if (position == 2) {
            return new Q3Fragment();
        } else if (position == 3) {
            return new Q4Fragment();
        } else {
            return new Q5Fragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    /**Fragment TABS part*/
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
    /**Fragment TABS END**/
}
