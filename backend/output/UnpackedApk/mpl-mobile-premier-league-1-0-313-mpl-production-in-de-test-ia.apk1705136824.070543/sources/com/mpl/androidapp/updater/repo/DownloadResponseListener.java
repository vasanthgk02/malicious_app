package com.mpl.androidapp.updater.repo;

public interface DownloadResponseListener {
    void onFailure(String str);

    void onSuccess(String str, String str2);
}
