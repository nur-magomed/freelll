package com.vantuz.nm.hop_freelancer.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by NM on 13/09/17.
 */
public class AbstractTabFragment extends Fragment {

    protected Context context;

    protected View view;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
