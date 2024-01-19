package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontRequestWorker.TypefaceResult;

public class CallbackWithHandler {
    public final FontsContractCompat$FontRequestCallback mCallback;
    public final Handler mCallbackHandler;

    public CallbackWithHandler(FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback, Handler handler) {
        this.mCallback = fontsContractCompat$FontRequestCallback;
        this.mCallbackHandler = handler;
    }

    public void onTypefaceResult(TypefaceResult typefaceResult) {
        if (typefaceResult.mResult == 0) {
            final Typeface typeface = typefaceResult.mTypeface;
            final FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback = this.mCallback;
            this.mCallbackHandler.post(new Runnable(this) {
                public void run() {
                    fontsContractCompat$FontRequestCallback.onTypefaceRetrieved(typeface);
                }
            });
            return;
        }
        final int i = typefaceResult.mResult;
        final FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback2 = this.mCallback;
        this.mCallbackHandler.post(new Runnable(this) {
            public void run() {
                fontsContractCompat$FontRequestCallback2.onTypefaceRequestFailed(i);
            }
        });
    }
}
