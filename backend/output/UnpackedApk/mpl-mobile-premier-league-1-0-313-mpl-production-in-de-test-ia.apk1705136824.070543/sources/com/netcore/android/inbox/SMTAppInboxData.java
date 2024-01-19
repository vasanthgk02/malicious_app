package com.netcore.android.inbox;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0010R\"\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u001f\u0010\u0010R\"\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000b¨\u0006&"}, d2 = {"Lcom/netcore/android/inbox/SMTAppInboxData;", "", "", "toString", "()Ljava/lang/String;", "", "e", "Z", "isSMTAppInboxEnabled", "()Z", "setSMTAppInboxEnabled", "(Z)V", "d", "Ljava/lang/String;", "getIdentity", "setIdentity", "(Ljava/lang/String;)V", "identity", "a", "getAppId", "setAppId", "appId", "c", "getGuid", "setGuid", "guid", "f", "isBaseSDKInitialized", "setBaseSDKInitialized", "b", "getBase_url", "setBase_url", "base_url", "g", "isSMTAppInboxEventEnabled", "setSMTAppInboxEventEnabled", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTAppInboxData.kt */
public final class SMTAppInboxData {

    /* renamed from: a  reason: collision with root package name */
    public String f1252a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f1253b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f1254c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f1255d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f1256e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1257f;
    public boolean g = true;

    public final String getAppId() {
        return this.f1252a;
    }

    public final String getBase_url() {
        return this.f1253b;
    }

    public final String getGuid() {
        return this.f1254c;
    }

    public final String getIdentity() {
        return this.f1255d;
    }

    public final boolean isBaseSDKInitialized() {
        return this.f1257f;
    }

    public final boolean isSMTAppInboxEnabled() {
        return this.f1256e;
    }

    public final boolean isSMTAppInboxEventEnabled() {
        return this.g;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1252a = str;
    }

    public final void setBaseSDKInitialized(boolean z) {
        this.f1257f = z;
    }

    public final void setBase_url(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1253b = str;
    }

    public final void setGuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1254c = str;
    }

    public final void setIdentity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1255d = str;
    }

    public final void setSMTAppInboxEnabled(boolean z) {
        this.f1256e = z;
    }

    public final void setSMTAppInboxEventEnabled(boolean z) {
        this.g = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SMTAppInboxData(appId='");
        outline73.append(this.f1252a);
        outline73.append("', base_url='");
        outline73.append(this.f1253b);
        outline73.append("', guid='");
        outline73.append(this.f1254c);
        outline73.append("', identity='");
        outline73.append(this.f1255d);
        outline73.append("', isSMTAppInboxEnabled=");
        outline73.append(this.f1256e);
        outline73.append(", isBaseSDKInitialized=");
        outline73.append(this.f1257f);
        outline73.append(", isSMTAppInboxEventEnabled=");
        return GeneratedOutlineSupport.outline65(outline73, this.g, ')');
    }
}
