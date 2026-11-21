package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class ActLoginBinding extends ViewDataBinding {
    public final Button btnLogin;
    public final EditText etUserIdentity;
    public final EditText etUserPwd;
    public final TextView tv1;
    public final TextView tvForgetPwd;
    public final TextView tvTextLogin;
    public final TextView tvVersion;
    public final View viewBar;

    protected ActLoginBinding(Object obj, View view, int i, Button button, EditText editText, EditText editText2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.btnLogin = button;
        this.etUserIdentity = editText;
        this.etUserPwd = editText2;
        this.tv1 = textView;
        this.tvForgetPwd = textView2;
        this.tvTextLogin = textView3;
        this.tvVersion = textView4;
        this.viewBar = view2;
    }

    public static ActLoginBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActLoginBinding bind(View view, Object obj) {
        return (ActLoginBinding) bind(obj, view, 2131492892);
    }

    public static ActLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492892, viewGroup, z, obj);
    }

    @Deprecated
    public static ActLoginBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492892, (ViewGroup) null, false, obj);
    }
}
