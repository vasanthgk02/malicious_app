package com.inmobi.androidsdk.ai.controller.util;

public interface AVPlayerListener {
    void onComplete(AVPlayer aVPlayer);

    void onError(AVPlayer aVPlayer);

    void onPrepared(AVPlayer aVPlayer);
}
