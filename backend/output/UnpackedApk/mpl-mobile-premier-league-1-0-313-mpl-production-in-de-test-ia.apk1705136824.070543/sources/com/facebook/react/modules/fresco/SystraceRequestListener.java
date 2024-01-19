package com.facebook.react.modules.fresco;

import android.util.Pair;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;

public class SystraceRequestListener extends BaseRequestListener {
    public int mCurrentID = 0;
    public Map<String, Pair<Integer, String>> mProducerID = new HashMap();
    public Map<String, Pair<Integer, String>> mRequestsID = new HashMap();

    public void onProducerEvent(String str, String str2, String str3) {
    }

    public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
    }

    public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
    }

    public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
    }

    public void onProducerStart(String str, String str2) {
    }

    public void onRequestCancellation(String str) {
    }

    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
    }

    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
    }

    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
    }

    public boolean requiresExtraMap(String str) {
        return false;
    }
}
