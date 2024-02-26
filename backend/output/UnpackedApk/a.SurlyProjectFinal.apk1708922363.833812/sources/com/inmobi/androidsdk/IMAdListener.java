package com.inmobi.androidsdk;

import com.inmobi.androidsdk.IMAdRequest.ErrorCode;

public interface IMAdListener {
    void onAdRequestCompleted(IMAdView iMAdView);

    void onAdRequestFailed(IMAdView iMAdView, ErrorCode errorCode);

    void onDismissAdScreen(IMAdView iMAdView);

    void onLeaveApplication(IMAdView iMAdView);

    void onShowAdScreen(IMAdView iMAdView);
}
