package com.mpl.androidapp.miniprofile.service.utils;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.network.modules.engine.MHeader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/utils/MplHeaders;", "", "()V", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "getHeaders", "()Ljava/util/List;", "setHeaders", "(Ljava/util/List;)V", "prepareHeader", "tolken", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MplHeaders.kt */
public final class MplHeaders {
    public List<MHeader> headers = new ArrayList();

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final List<MHeader> prepareHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "tolken");
        this.headers.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
        this.headers.add(new MHeader("Authorization", Intrinsics.stringPlus("Bearer ", str)));
        return this.headers;
    }

    public final void setHeaders(List<MHeader> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.headers = list;
    }
}
