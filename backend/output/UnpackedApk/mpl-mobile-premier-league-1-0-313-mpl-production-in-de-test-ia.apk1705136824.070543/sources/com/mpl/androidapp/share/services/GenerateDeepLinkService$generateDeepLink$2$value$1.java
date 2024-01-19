package com.mpl.androidapp.share.services;

import com.mpl.androidapp.react.util.ShortPromise;
import com.mpl.androidapp.utils.MLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/mpl/androidapp/share/services/GenerateDeepLinkService$generateDeepLink$2$value$1", "Lcom/mpl/androidapp/react/util/ShortPromise;", "onFailure", "", "errorCode", "", "message", "throwable", "", "onSuccess", "description", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GenerateDeepLinkService.kt */
public final class GenerateDeepLinkService$generateDeepLink$2$value$1 extends ShortPromise {
    public final /* synthetic */ Continuation<Pair<Boolean, String>> $it;

    public GenerateDeepLinkService$generateDeepLink$2$value$1(Continuation<? super Pair<Boolean, String>> continuation) {
        this.$it = continuation;
    }

    public void onFailure(String str, String str2, Throwable th) {
        String access$getTAG$cp = GenerateDeepLinkService.TAG;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("Failure: ");
        sb.append(str);
        sb.append("::");
        sb.append(str2);
        sb.append("::");
        sb.append(th == null ? null : th.getMessage());
        objArr[0] = sb.toString();
        MLogger.e(access$getTAG$cp, objArr);
        this.$it.resumeWith(new Pair(Boolean.FALSE, String.valueOf(str2)));
    }

    public void onSuccess(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "description");
        MLogger.i(GenerateDeepLinkService.TAG, Intrinsics.stringPlus(" Success: ", obj));
        this.$it.resumeWith(new Pair(Boolean.TRUE, obj.toString()));
    }
}
