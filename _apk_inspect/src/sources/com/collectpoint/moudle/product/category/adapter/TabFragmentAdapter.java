package com.collectpoint.moudle.product.category.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class TabFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public TabFragmentAdapter(FragmentManager fragmentManager, List<Fragment> list, List<String> list2) {
        super(fragmentManager);
        this.mFragments = list;
        this.mTitles = list2;
    }

    public int getCount() {
        return this.mTitles.size();
    }

    public Fragment getItem(int i) {
        return this.mFragments.get(i);
    }

    public CharSequence getPageTitle(int i) {
        List<String> list = this.mTitles;
        return list.get(i % list.size());
    }
}
