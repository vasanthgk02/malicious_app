package com.mpl.androidapp.react;

public interface AddsListener {
    boolean onAddsAvailable();

    void onAddsError(String str);

    void onAddsUnavailable();
}
