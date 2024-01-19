package com.mpl.androidapp.miniprofile.service.utils;

import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkCallParams.Builder;
import com.mpl.network.modules.engine.MHeader;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nB1\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0002\u0010\rB\u0005¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/utils/MplNetworkCallParams;", "", "request", "Lorg/json/JSONObject;", "url", "", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/util/List;)V", "queryParams", "Ljava/util/IdentityHashMap;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/IdentityHashMap;)V", "()V", "getHeaders", "()Ljava/util/List;", "setHeaders", "(Ljava/util/List;)V", "getQueryParams", "()Ljava/util/IdentityHashMap;", "setQueryParams", "(Ljava/util/IdentityHashMap;)V", "getRequest", "()Lorg/json/JSONObject;", "setRequest", "(Lorg/json/JSONObject;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "buildNetWorkParams", "Lcom/mpl/androidapp/utils/NetworkCallParams;", "buildNetWorkParamsNoRequestBody", "buildNetWorkParamsWithQuery", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MplNetworkCallParams.kt */
public final class MplNetworkCallParams {
    public static final Companion Companion = new Companion(null);
    public static final String TAG;
    public List<MHeader> headers;
    public IdentityHashMap<String, String> queryParams;
    public JSONObject request;
    public String url;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/utils/MplNetworkCallParams$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MplNetworkCallParams.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = MplNetworkCallParams.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "MplNetworkCallParams::class.java.simpleName");
        TAG = simpleName;
    }

    public MplNetworkCallParams() {
        this.request = new JSONObject();
        this.url = "";
        this.headers = new ArrayList();
    }

    public final NetworkCallParams buildNetWorkParams() {
        NetworkCallParams build = new Builder().setUrl(this.url).setMRequestBody(this.request.toString()).setMHeaders(this.headers).setRetryOption(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        return build;
    }

    public final NetworkCallParams buildNetWorkParamsNoRequestBody() {
        NetworkCallParams build = new Builder().setUrl(this.url).setMHeaders(this.headers).setRetryOption(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        return build;
    }

    public final NetworkCallParams buildNetWorkParamsWithQuery() {
        NetworkCallParams build = new Builder().setUrl(this.url).setMHeaders(this.headers).setMQueryParams(getQueryParams()).setRetryOption(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        return build;
    }

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final IdentityHashMap<String, String> getQueryParams() {
        IdentityHashMap<String, String> identityHashMap = this.queryParams;
        if (identityHashMap != null) {
            return identityHashMap;
        }
        Intrinsics.throwUninitializedPropertyAccessException("queryParams");
        throw null;
    }

    public final JSONObject getRequest() {
        return this.request;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setHeaders(List<MHeader> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.headers = list;
    }

    public final void setQueryParams(IdentityHashMap<String, String> identityHashMap) {
        Intrinsics.checkNotNullParameter(identityHashMap, "<set-?>");
        this.queryParams = identityHashMap;
    }

    public final void setRequest(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.request = jSONObject;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplNetworkCallParams(JSONObject jSONObject, String str, List<MHeader> list) {
        // Intrinsics.checkNotNullParameter(jSONObject, "request");
        // Intrinsics.checkNotNullParameter(str, "url");
        // Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        this();
        this.request = jSONObject;
        this.url = str;
        this.headers = list;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplNetworkCallParams(String str, List<MHeader> list) {
        // Intrinsics.checkNotNullParameter(str, "url");
        // Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        this();
        this.url = str;
        this.headers = list;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplNetworkCallParams(String str, List<MHeader> list, IdentityHashMap<String, String> identityHashMap) {
        // Intrinsics.checkNotNullParameter(str, "url");
        // Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        // Intrinsics.checkNotNullParameter(identityHashMap, "queryParams");
        this();
        this.url = str;
        this.headers = list;
        setQueryParams(identityHashMap);
    }
}
