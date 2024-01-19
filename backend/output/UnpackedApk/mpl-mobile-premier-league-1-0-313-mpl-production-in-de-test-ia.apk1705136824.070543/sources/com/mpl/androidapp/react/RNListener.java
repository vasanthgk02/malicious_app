package com.mpl.androidapp.react;

public interface RNListener {
    boolean isHasRequiredPermission();

    void publishResult(String str);
}
