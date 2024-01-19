package com.mpl.androidapp.updater.repo;

public interface ResponseListener {
    void onFailure(String str);

    void onSuccess(String str);
}
