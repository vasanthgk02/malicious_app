package com.inmobi.androidsdk;

import com.inmobi.androidsdk.IMAdRequest.ErrorCode;

public interface IMAdInterstitialListener {
    void onAdRequestFailed(IMAdInterstitial iMAdInterstitial, ErrorCode errorCode);

    void onAdRequestLoaded(IMAdInterstitial iMAdInterstitial);

    void onDismissAdScreen(IMAdInterstitial iMAdInterstitial);

    void onLeaveApplication(IMAdInterstitial iMAdInterstitial);

    void onShowAdScreen(IMAdInterstitial iMAdInterstitial);
}
