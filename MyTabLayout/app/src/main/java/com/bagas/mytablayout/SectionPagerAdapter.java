package com.bagas.mytablayout;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SectionPagerAdapter extends FragmentPagerAdapter {



    @StringRes
    private final int[] TAB_TITLES = new int[] {
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
    };

    private final Context mContext;

    public SectionPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = HomeFragment.newInstance(position + 1);
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
