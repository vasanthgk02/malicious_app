package com.netcore.android.webview;

import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JA\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/netcore/android/webview/SMTAppWebViewListener;", "", "", "eventName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "eventPayLoad", "", "handleWebEvent", "(Ljava/lang/String;Ljava/util/HashMap;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTAppWebViewListener.kt */
public interface SMTAppWebViewListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    /* compiled from: SMTAppWebViewListener.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void handleWebEvent$default(SMTAppWebViewListener sMTAppWebViewListener, String str, HashMap hashMap, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    hashMap = null;
                }
                sMTAppWebViewListener.handleWebEvent(str, hashMap);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleWebEvent");
        }
    }

    void handleWebEvent(String str, HashMap<String, Object> hashMap);
}
