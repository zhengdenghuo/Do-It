package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragTextLoginBinding extends ViewDataBinding {
    public final Button btnLogin;
    public final Button btnSendCode;
    public final EditText editImgCode;
    public final EditText editMobile;
    public final EditText editPhoneCode;
    public final ImageView imgClose;
    public final ImageView imgCode;
    public final TextView tv1;
    public final TextView tvAccountPwd;
    public final View viewBar;

    protected FragTextLoginBinding(Object obj, View view, int i, Button button, Button button2, EditText editText, EditText editText2, EditText editText3, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.btnLogin = button;
        this.btnSendCode = button2;
        this.editImgCode = editText;
        this.editMobile = editText2;
        this.editPhoneCode = editText3;
        this.imgClose = imageView;
        this.imgCode = imageView2;
        this.tv1 = textView;
        this.tvAccountPwd = textView2;
        this.viewBar = view2;
    }

    public static FragTextLoginBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragTextLoginBinding bind(View view, Object obj) {
        return (FragTextLoginBinding) bind(obj, view, 2131492995);
    }

    public static FragTextLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragTextLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragTextLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragTextLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492995, viewGroup, z, obj);
    }

    @Deprecated
    public static FragTextLoginBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragTextLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492995, (ViewGroup) null, false, obj);
    }
}
