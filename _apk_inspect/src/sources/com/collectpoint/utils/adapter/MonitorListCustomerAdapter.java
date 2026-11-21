package com.collectpoint.utils.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class MonitorListCustomerAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<BaseCompany> companyList;
    private Context ctx;
    private BaseCompany currentChosenCustomer;
    private List<BaseCompany> customerShownList;
    private OnItemClickListener listener;
    private List<String> shrinkCustomerIdList = new ArrayList();

    public interface OnItemClickListener {
        void onItemClick(BaseCompany baseCompany);
    }

    public MonitorListCustomerAdapter(Context context, List<BaseCompany> list) {
        this.ctx = context;
        this.companyList = list;
        this.customerShownList = new ArrayList(list.size());
        initCustomerShownList();
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getItemCount() {
        return this.customerShownList.size();
    }

    public void initCustomerShownList() {
        this.customerShownList.clear();
        int i = 0;
        while (i < this.companyList.size()) {
            BaseCompany baseCompany = this.companyList.get(i);
            if (this.shrinkCustomerIdList.contains(baseCompany.getCompanyID())) {
                this.customerShownList.add(baseCompany);
                int companyLevel = baseCompany.getCompanyLevel();
                while (true) {
                    i++;
                    if (i < this.companyList.size()) {
                        if (this.companyList.get(i).getCompanyLevel() <= companyLevel) {
                            i--;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                this.customerShownList.add(baseCompany);
            }
            i++;
        }
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        final BaseCompany baseCompany = this.customerShownList.get(i);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(2131296661);
        TextView textView = (TextView) baseViewHolder.getView(2131296980);
        textView.setText(baseCompany.getCompanyName());
        ImageView imageView = (ImageView) baseViewHolder.getView(2131296621);
        BaseCompany baseCompany2 = this.currentChosenCustomer;
        if (baseCompany2 == null || !baseCompany.equals(baseCompany2)) {
            textView.setTextColor(-16777216);
        } else {
            textView.setTextColor(Color.rgb(34, 136, 255));
        }
        int companyLevel = baseCompany.getCompanyLevel();
        if (baseCompany.isHasChildCompany()) {
            imageView.setVisibility(0);
            if (this.shrinkCustomerIdList.contains(baseCompany.getCompanyID())) {
                imageView.setImageResource(2131230907);
            } else {
                imageView.setImageResource(2131230908);
            }
        } else {
            imageView.setVisibility(4);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.setMargins(dip2px(this.ctx, ((companyLevel + 1) * 12) - 8), 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.utils.adapter.MonitorListCustomerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MonitorListCustomerAdapter.this.shrinkCustomerIdList.contains(baseCompany.getCompanyID())) {
                    MonitorListCustomerAdapter.this.shrinkCustomerIdList.remove(baseCompany.getCompanyID());
                } else {
                    MonitorListCustomerAdapter.this.shrinkCustomerIdList.add(baseCompany.getCompanyID());
                }
                MonitorListCustomerAdapter.this.initCustomerShownList();
                MonitorListCustomerAdapter.this.notifyDataSetChanged();
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.utils.adapter.MonitorListCustomerAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MonitorListCustomerAdapter.this.currentChosenCustomer = baseCompany;
                if (MonitorListCustomerAdapter.this.listener != null) {
                    MonitorListCustomerAdapter.this.listener.onItemClick(baseCompany);
                }
                MonitorListCustomerAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BaseViewHolder(LayoutInflater.from(this.ctx).inflate(2131493029, viewGroup, false));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
}
