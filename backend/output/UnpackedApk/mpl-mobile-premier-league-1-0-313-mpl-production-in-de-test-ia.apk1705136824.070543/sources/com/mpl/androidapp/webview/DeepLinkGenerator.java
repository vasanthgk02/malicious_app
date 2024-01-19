package com.mpl.androidapp.webview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/webview/DeepLinkGenerator;", "", "()V", "context", "Lcom/mpl/androidapp/MPLApplication;", "reactContainer", "Ljava/lang/Class;", "Lcom/mpl/androidapp/react/MPLReactContainerActivity;", "helpDeskDeepLink", "", "mGameId", "", "redirectToHelpDesk", "Landroid/content/Intent;", "redirectToPayment", "", "value", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeepLinkGenerator.kt */
public final class DeepLinkGenerator {
    public static final String ACTION_KEY = "action";
    public static final String ACTION_PARAMS_KEY = "actionParams";
    public static final String ACTION_TAKEN_KEY = "actionTaken";
    public static final String ACTION_TAKEN_PAYMENT_VALUE = "payment";
    public static final String ACTION_VALUE = "OPEN_DEEP_LINK";
    public static final Companion Companion = new Companion(null);
    public final MPLApplication context;
    public final Class<MPLReactContainerActivity> reactContainer = MPLReactContainerActivity.class;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/webview/DeepLinkGenerator$Companion;", "", "()V", "ACTION_KEY", "", "ACTION_PARAMS_KEY", "ACTION_TAKEN_KEY", "ACTION_TAKEN_PAYMENT_VALUE", "ACTION_VALUE", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DeepLinkGenerator.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DeepLinkGenerator() {
        MPLApplication instance = MPLApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        this.context = instance;
    }

    private final String helpDeskDeepLink(int i) {
        return GeneratedOutlineSupport.outline42("{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Support\",\"param\":{\"supportType\":\"CHAT\",\"isDeepLink\":true,\"isPoker\":true,\"pokerGameId\":", i, "}}}");
    }

    public final Intent redirectToHelpDesk(int i) {
        Intent intent = new Intent(this.context, this.reactContainer);
        intent.putExtra("actionTaken", "payment");
        Bundle bundle = new Bundle();
        bundle.putString("action", "OPEN_DEEP_LINK");
        bundle.putString("actionParams", helpDeskDeepLink(i));
        intent.putExtras(bundle);
        return intent;
    }

    public final void redirectToPayment(String str) {
        Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        TextUtils.isDigitsOnly(CharsKt__CharKt.replace$default(str, (String) "addMoney_", (String) "", false, 4));
    }
}
