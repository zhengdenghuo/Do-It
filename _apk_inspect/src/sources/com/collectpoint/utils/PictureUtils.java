package com.collectpoint.utils;

import android.R;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.yanzhenjie.album.api.widget.Widget;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class PictureUtils {
    public static Widget getAlbumUI(Context context, int i) {
        return Widget.newDarkBuilder(context).title(i).statusBarColor(ContextCompat.getColor(context, 2131099838)).toolBarColor(ContextCompat.getColor(context, 2131099838)).mediaItemCheckSelector(ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, 2131099838)).bucketItemCheckSelector(ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, 2131099838)).buttonStyle(Widget.ButtonStyle.newLightBuilder(context).build()).build();
    }
}
