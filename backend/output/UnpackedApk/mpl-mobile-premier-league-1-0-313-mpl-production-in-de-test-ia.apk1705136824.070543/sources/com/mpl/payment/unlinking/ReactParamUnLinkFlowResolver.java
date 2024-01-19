package com.mpl.payment.unlinking;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.gopay.GoPayUnlinkingHandler;
import com.mpl.payment.gopay.models.GoPayUnlinkingPayload;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\t\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/mpl/payment/unlinking/ReactParamUnLinkFlowResolver;", "Lcom/mpl/payment/unlinking/UnLinkingFlowResolver;", "context", "Landroid/content/Context;", "reactPayloadString", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Landroid/content/Context;Ljava/lang/String;Lcom/squareup/moshi/Moshi;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getReactPayloadString", "resolveLinkingHandler", "", "unlinkingType", "Lcom/mpl/payment/unlinking/UnlinkingType;", "unlinkingListener", "Lcom/mpl/payment/unlinking/UnlinkingListener;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReactParamUnLinkFlowResolver.kt */
public final class ReactParamUnLinkFlowResolver implements UnLinkingFlowResolver {
    public final String TAG = "ReactParamUnLinkFlowResolver";
    public final Context context;
    public final Moshi moshi;
    public final String reactPayloadString;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UnlinkingType.values().length];
            $EnumSwitchMapping$0 = iArr;
            UnlinkingType unlinkingType = UnlinkingType.GOPAY;
            iArr[0] = 1;
        }
    }

    public ReactParamUnLinkFlowResolver(Context context2, String str, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "reactPayloadString");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.context = context2;
        this.reactPayloadString = str;
        this.moshi = moshi2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getReactPayloadString() {
        return this.reactPayloadString;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public Object resolveLinkingHandler(UnlinkingType unlinkingType, UnlinkingListener unlinkingListener) {
        Intrinsics.checkNotNullParameter(unlinkingType, "unlinkingType");
        Intrinsics.checkNotNullParameter(unlinkingListener, "unlinkingListener");
        if (unlinkingType.ordinal() == 0) {
            JsonAdapter<GoPayUnlinkingPayload> adapter = this.moshi.adapter(GoPayUnlinkingPayload.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(GoPayUnlinkingPayload::class.java)");
            GoPayUnlinkingPayload goPayUnlinkingPayload = (GoPayUnlinkingPayload) adapter.fromJson(this.reactPayloadString);
            if (goPayUnlinkingPayload != null) {
                return new GoPayUnlinkingHandler(this.context, goPayUnlinkingPayload, unlinkingListener);
            }
            throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " parsed react json should not be null"));
        }
        throw new Exception("Unlinking type " + unlinkingType + " not handled in the unlinking flow resolver " + this.TAG);
    }
}
