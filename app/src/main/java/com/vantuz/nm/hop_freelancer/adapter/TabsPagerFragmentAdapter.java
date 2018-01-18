package com.vantuz.nm.hop_freelancer.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vantuz.nm.hop_freelancer.fragment.AbstractTabFragment;
import com.vantuz.nm.hop_freelancer.fragment.OpenOffersFragment;
import com.vantuz.nm.hop_freelancer.fragment.SearchOffersFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NM on 12/09/17.
 */
public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    public TabsPagerFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        tabs = new HashMap<>();
        this.context = context;
        initTabsMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs.put(0, SearchOffersFragment.getInstance(context));
        tabs.put(1, OpenOffersFragment.getInstance(context));

//        tabs.put(2, ArchiveFragment.getInstance(context));
    }
}
