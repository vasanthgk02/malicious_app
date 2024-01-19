package com.mpl.androidapp.webview.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/webview/models/SessionRoot;", "", "token", "", "redirectionUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getRedirectionUrl", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowRoot.kt */
public final class SessionRoot {
    @SerializedName("redirectionUrl")
    public final String redirectionUrl;
    @SerializedName("token")
    public final String token;

    public SessionRoot(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_REDIRECTION_URL);
        this.token = str;
        this.redirectionUrl = str2;
    }

    public static /* synthetic */ SessionRoot copy$default(SessionRoot sessionRoot, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sessionRoot.token;
        }
        if ((i & 2) != 0) {
            str2 = sessionRoot.redirectionUrl;
        }
        return sessionRoot.copy(str, str2);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.redirectionUrl;
    }

    public final SessionRoot copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_REDIRECTION_URL);
        return new SessionRoot(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionRoot)) {
            return false;
        }
        SessionRoot sessionRoot = (SessionRoot) obj;
        return Intrinsics.areEqual(this.token, sessionRoot.token) && Intrinsics.areEqual(this.redirectionUrl, sessionRoot.redirectionUrl);
    }

    public final String getRedirectionUrl() {
        return this.redirectionUrl;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return this.redirectionUrl.hashCode() + (this.token.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SessionRoot(token=");
        outline73.append(this.token);
        outline73.append(", redirectionUrl=");
        return GeneratedOutlineSupport.outline59(outline73, this.redirectionUrl, ')');
    }
}
