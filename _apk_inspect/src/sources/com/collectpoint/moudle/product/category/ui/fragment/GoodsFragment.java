package com.collectpoint.moudle.product.category.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.collectpoint.MyApp;
import java.util.ArrayList;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class GoodsFragment extends BaseFragment implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    private GroupAdapter groupAdapter;
    private HeadAdapter headAdapter;
    ListView lv;
    StickyListHeadersListView shl;
    boolean isScroll = false;
    private ArrayList<Head> heads = new ArrayList<>();
    private ArrayList<Data> datas = new ArrayList<>();

    class Data {
        int headId;
        int headIndex;
        public String info;

        Data() {
        }
    }

    private class GroupAdapter extends BaseAdapter implements StickyListHeadersAdapter {
        private GroupAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return GoodsFragment.this.datas.size();
        }

        public long getHeaderId(int i) {
            return ((Data) GoodsFragment.this.datas.get(i)).headId;
        }

        public View getHeaderView(int i, View view, ViewGroup viewGroup) {
            Head head = (Head) GoodsFragment.this.heads.get(((Data) GoodsFragment.this.datas.get(i)).headIndex);
            TextView textView = new TextView(MyApp.getContext());
            textView.setText(head.info);
            textView.setTextColor(-16777216);
            textView.setBackgroundColor(Color.parseColor("#BFBFBF"));
            return textView;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return GoodsFragment.this.datas.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(MyApp.getContext());
            textView.setText(((Data) GoodsFragment.this.datas.get(i)).info);
            textView.setTextColor(-16777216);
            return textView;
        }
    }

    class Head {
        int groupFirstIndex;
        String info;

        Head() {
        }
    }

    private class HeadAdapter extends BaseAdapter {
        private int selectPosition;

        private HeadAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return GoodsFragment.this.heads.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return GoodsFragment.this.heads.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(MyApp.getContext());
            textView.setText(((Head) GoodsFragment.this.heads.get(i)).info);
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, 100));
            textView.setGravity(17);
            textView.setTextSize(16.0f);
            textView.setTextColor(-16777216);
            if (i == this.selectPosition) {
                textView.setBackgroundColor(-1);
            } else {
                textView.setBackgroundColor(Color.parseColor("#BFBFBF"));
            }
            return textView;
        }

        public void setSelectPosition(int i) {
            if (this.selectPosition == i) {
                return;
            }
            this.selectPosition = i;
            notifyDataSetChanged();
        }
    }

    private void testData() {
        for (int i = 0; i < 10; i++) {
            Head head = new Head();
            head.info = "头" + i;
            this.heads.add(head);
            head.groupFirstIndex = this.datas.size();
            for (int i2 = 0; i2 < 10; i2++) {
                Data data = new Data();
                data.info = "普通条目" + i2;
                data.headId = i;
                data.headIndex = i;
                this.datas.add(data);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(2131492998, (ViewGroup) null);
        this.shl = viewInflate.findViewById(2131296827);
        this.lv = (ListView) viewInflate.findViewById(2131296677);
        return viewInflate;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.headAdapter.setSelectPosition(i);
        this.shl.setSelection(this.heads.get(i).groupFirstIndex);
        this.isScroll = false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.isScroll) {
            Data data = this.datas.get(i);
            this.headAdapter.setSelectPosition(data.headIndex);
            int firstVisiblePosition = this.lv.getFirstVisiblePosition();
            if (data.headIndex >= this.lv.getLastVisiblePosition() || data.headIndex <= firstVisiblePosition) {
                this.lv.setSelection(data.headIndex);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.isScroll = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        testData();
        HeadAdapter headAdapter = new HeadAdapter();
        this.headAdapter = headAdapter;
        this.lv.setAdapter((ListAdapter) headAdapter);
        GroupAdapter groupAdapter = new GroupAdapter();
        this.groupAdapter = groupAdapter;
        this.shl.setAdapter(groupAdapter);
        this.lv.setOnItemClickListener(this);
        this.shl.setOnScrollListener(this);
    }
}
