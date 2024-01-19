package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForwardingImageOriginListener implements ImageOriginListener {
    public final List<ImageOriginListener> mImageOriginListeners;

    public ForwardingImageOriginListener(ImageOriginListener... imageOriginListenerArr) {
        ArrayList arrayList = new ArrayList(imageOriginListenerArr.length);
        this.mImageOriginListeners = arrayList;
        Collections.addAll(arrayList, imageOriginListenerArr);
    }

    public synchronized void onImageLoaded(String str, int i, boolean z, String str2) {
        int size = this.mImageOriginListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageOriginListener imageOriginListener = this.mImageOriginListeners.get(i2);
            if (imageOriginListener != null) {
                try {
                    imageOriginListener.onImageLoaded(str, i, z, str2);
                } catch (Exception e2) {
                    FLog.e((String) "ForwardingImageOriginListener", (String) "InternalListener exception in onImageLoaded", (Throwable) e2);
                }
            }
        }
    }
}
