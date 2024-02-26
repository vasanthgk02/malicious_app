package com.cauly.android.ad;

public interface AdListener {
    void onCloseInterstitialAd();

    void onFailedToReceiveAd(boolean z);

    void onReceiveAd();
}
