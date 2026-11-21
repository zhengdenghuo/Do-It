package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.collectpoint.global.image.GlideRequests;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
final class GeneratedRequestManagerFactory implements RequestManagerRetriever.RequestManagerFactory {
    GeneratedRequestManagerFactory() {
    }

    public RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode treeNode, Context context) {
        return new GlideRequests(glide, lifecycle, treeNode, context);
    }
}
