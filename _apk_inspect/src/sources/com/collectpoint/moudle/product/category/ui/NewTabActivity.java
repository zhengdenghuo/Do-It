package com.collectpoint.moudle.product.category.ui;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.collectpoint.moudle.product.category.BaseActivity;
import com.collectpoint.moudle.product.category.ui.fragment.EvaluateFragment;
import com.collectpoint.moudle.product.category.ui.fragment.GoodsFragment;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class NewTabActivity extends BaseActivity {
    private MyAdapter adapter;
    private TabLayout tabLayout;
    private String[] titles = {"商品", "评论", "商家"};
    private Toolbar toolBar;
    private ViewPager viewPager;

    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return NewTabActivity.this.titles.length;
        }

        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new GoodsFragment();
                case 1:
                    return new EvaluateFragment();
                case 2:
                    return new EvaluateFragment();
                default:
                    return null;
            }
        }

        public CharSequence getPageTitle(int i) {
            return NewTabActivity.this.titles[i];
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492899);
        Toolbar toolbarFindViewById = findViewById(2131296930);
        this.toolBar = toolbarFindViewById;
        toolbarFindViewById.setTitle("南京大排档(德基店)");
        setSupportActionBar(this.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.tabLayout = findViewById(2131296893);
        this.viewPager = findViewById(2131297210);
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        this.adapter = myAdapter;
        this.viewPager.setAdapter(myAdapter);
        this.tabLayout.setupWithViewPager(this.viewPager);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
