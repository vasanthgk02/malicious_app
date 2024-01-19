package com.facebook.share.internal;

import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.AppCall;
import com.facebook.share.Sharer$Result;
import com.mpl.androidapp.login.LoginReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/facebook/share/internal/ShareInternalUtility$getShareResultProcessor$1", "Lcom/facebook/share/internal/ResultProcessor;", "onCancel", "", "appCall", "Lcom/facebook/internal/AppCall;", "onError", "error", "Lcom/facebook/FacebookException;", "onSuccess", "results", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareInternalUtility.kt */
public final class ShareInternalUtility$getShareResultProcessor$1 extends ResultProcessor {
    public final /* synthetic */ FacebookCallback<Sharer$Result> $callback;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ShareInternalUtility$getShareResultProcessor$1(FacebookCallback<Sharer$Result> facebookCallback) {
        // this.$callback = facebookCallback;
        super(facebookCallback);
    }

    public void onCancel(AppCall appCall) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        ShareInternalUtility.invokeOnCancelCallback(this.$callback);
    }

    public void onError(AppCall appCall, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(facebookException, "error");
        ShareInternalUtility.invokeOnErrorCallback(this.$callback, facebookException);
    }

    public void onSuccess(AppCall appCall, Bundle bundle) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        if (bundle != null) {
            Intrinsics.checkNotNullParameter(bundle, LoginReactModule.RESULT);
            if (bundle.containsKey("completionGesture")) {
                str = bundle.getString("completionGesture");
            } else {
                str = bundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
            }
            if (str == null || CharsKt__CharKt.equals((String) "post", str, true)) {
                FacebookCallback<Sharer$Result> facebookCallback = this.$callback;
                Intrinsics.checkNotNullParameter(bundle, LoginReactModule.RESULT);
                if (bundle.containsKey("postId")) {
                    str2 = bundle.getString("postId");
                } else if (bundle.containsKey("com.facebook.platform.extra.POST_ID")) {
                    str2 = bundle.getString("com.facebook.platform.extra.POST_ID");
                } else {
                    str2 = bundle.getString("post_id");
                }
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(FacebookSdk.getApplicationContext(), (String) null, (AccessToken) null);
                Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
                Bundle outline14 = GeneratedOutlineSupport.outline14("fb_share_dialog_outcome", "succeeded");
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    appEventsLoggerImpl.logEventImplicitly("fb_share_dialog_result", null, outline14);
                }
                if (facebookCallback != null) {
                    facebookCallback.onSuccess(new Sharer$Result(str2));
                }
            } else if (CharsKt__CharKt.equals((String) "cancel", str, true)) {
                ShareInternalUtility.invokeOnCancelCallback(this.$callback);
            } else {
                ShareInternalUtility.invokeOnErrorCallback(this.$callback, new FacebookException((String) "UnknownError"));
            }
        }
    }
}
