package com.collectpoint.utils;

import com.blankj.utilcode.util.NetworkUtils;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class NetworkManager {

    public interface OnNetworkStatusListener<T> {
        void onNetworkConnected();

        void onNetworkDisconnected();
    }

    public static NetworkUtils.OnNetworkStatusChangedListener registerNetworkListener(final OnNetworkStatusListener onNetworkStatusListener) {
        NetworkUtils.OnNetworkStatusChangedListener onNetworkStatusChangedListener = new NetworkUtils.OnNetworkStatusChangedListener() { // from class: com.collectpoint.utils.NetworkManager.1
            public void onConnected(NetworkUtils.NetworkType networkType) {
                onNetworkStatusListener.onNetworkConnected();
            }

            public void onDisconnected() {
                onNetworkStatusListener.onNetworkDisconnected();
            }
        };
        NetworkUtils.registerNetworkStatusChangedListener(onNetworkStatusChangedListener);
        return onNetworkStatusChangedListener;
    }

    public static void unRegisterNetworkListener(NetworkUtils.OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        if (onNetworkStatusChangedListener == null || !NetworkUtils.isRegisteredNetworkStatusChangedListener(onNetworkStatusChangedListener)) {
            return;
        }
        NetworkUtils.unregisterNetworkStatusChangedListener(onNetworkStatusChangedListener);
    }
}
