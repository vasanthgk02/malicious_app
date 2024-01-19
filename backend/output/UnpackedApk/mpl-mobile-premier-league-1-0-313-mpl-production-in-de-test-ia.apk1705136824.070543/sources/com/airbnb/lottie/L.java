package com.airbnb.lottie;

import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;

public class L {
    public static int depthPastMaxDepth;
    public static volatile NetworkCache networkCache;
    public static volatile NetworkFetcher networkFetcher;

    public static float endSection(String str) {
        int i = depthPastMaxDepth;
        if (i > 0) {
            depthPastMaxDepth = i - 1;
        }
        return 0.0f;
    }
}
