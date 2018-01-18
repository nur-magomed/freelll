package com.vantuz.nm.hop_freelancer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vantuz.nm.hop_freelancer.R;

public class SearchOffersFragment extends AbstractTabFragment {

    /** Tag for the log messages */
    public static final String LOG_TAG = SearchOffersFragment.class.getSimpleName();

    private static final int LAYOUT = R.layout.fragment_search_offers;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(LAYOUT, container, false);
        // Inflate the layout for this fragment
        return view;
    }

    public static AbstractTabFragment getInstance(Context context) {
        Bundle args = new Bundle();
        SearchOffersFragment fragment = new SearchOffersFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.search_tab));

        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
