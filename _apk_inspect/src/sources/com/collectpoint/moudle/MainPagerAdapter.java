package com.collectpoint.moudle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.collectpoint.moudle.product.OrderFrag;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class MainPagerAdapter extends FragmentPagerAdapter {
    public MainPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public int getCount() {
        return 2;
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return HomeFrag.newInstance();
            default:
                return OrderFrag.newInstance();
        }
    }
}
