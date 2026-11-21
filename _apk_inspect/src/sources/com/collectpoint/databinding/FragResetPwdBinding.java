package com.collectpoint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes12.dex */
public abstract class FragResetPwdBinding extends ViewDataBinding {
    public final Button btnReset;
    public final Button btnSendCode;
    public final EditText editConfirmPwd;
    public final EditText editImgCode;
    public final EditText editMobile;
    public final EditText editNewPwd;
    public final EditText editPhoneCode;
    public final ImageView imgCode;
    public final ImageView imgConfirmPwd;
    public final ImageView imgNewPwd;
    public final View v1;
    public final View v2;
    public final View v3;
    public final View v4;
    public final View v5;

    protected FragResetPwdBinding(Object obj, View view, int i, Button button, Button button2, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, ImageView imageView, ImageView imageView2, ImageView imageView3, View view2, View view3, View view4, View view5, View view6) {
        super(obj, view, i);
        this.btnReset = button;
        this.btnSendCode = button2;
        this.editConfirmPwd = editText;
        this.editImgCode = editText2;
        this.editMobile = editText3;
        this.editNewPwd = editText4;
        this.editPhoneCode = editText5;
        this.imgCode = imageView;
        this.imgConfirmPwd = imageView2;
        this.imgNewPwd = imageView3;
        this.v1 = view2;
        this.v2 = view3;
        this.v3 = view4;
        this.v4 = view5;
        this.v5 = view6;
    }

    public static FragResetPwdBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragResetPwdBinding bind(View view, Object obj) {
        return (FragResetPwdBinding) bind(obj, view, 2131492991);
    }

    public static FragResetPwdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragResetPwdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragResetPwdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragResetPwdBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492991, viewGroup, z, obj);
    }

    @Deprecated
    public static FragResetPwdBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragResetPwdBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131492991, (ViewGroup) null, false, obj);
    }
}
