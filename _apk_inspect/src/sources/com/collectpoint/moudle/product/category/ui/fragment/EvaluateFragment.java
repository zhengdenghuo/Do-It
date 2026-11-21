package com.collectpoint.moudle.product.category.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.collectpoint.moudle.product.category.entity.Evaluate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class EvaluateFragment extends Fragment {
    private String keywords;

    private List<Evaluate> getData() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Evaluate evaluate = new Evaluate();
            evaluate.setName(this.keywords + i);
            arrayList.add(evaluate);
        }
        return arrayList;
    }

    public static EvaluateFragment getInstance(String str) {
        EvaluateFragment evaluateFragment = 0 == 0 ? new EvaluateFragment() : null;
        evaluateFragment.keywords = str;
        return evaluateFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131492997, (ViewGroup) null);
    }
}
