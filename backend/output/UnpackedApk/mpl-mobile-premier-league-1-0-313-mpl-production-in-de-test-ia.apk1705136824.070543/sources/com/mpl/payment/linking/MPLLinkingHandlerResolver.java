package com.mpl.payment.linking;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.mpl.payment.gopay.models.GoPayLinkingPayload;
import com.mpl.payment.juspayhypersdk.amazon.linking.AmazonWalletLinkingHandler;
import com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonWalletMplPayload;
import com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonWalletReactPayload;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCase;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\f\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006!"}, d2 = {"Lcom/mpl/payment/linking/MPLLinkingHandlerResolver;", "Lcom/mpl/payment/linking/LinkingHandlerResolver;", "moshi", "Lcom/squareup/moshi/Moshi;", "reactPayloadString", "", "mplPayload", "activity", "Landroid/app/Activity;", "customerIdUseCase", "Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;", "(Lcom/squareup/moshi/Moshi;Ljava/lang/String;Ljava/lang/String;Landroid/app/Activity;Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "getCustomerIdUseCase", "()Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getMplPayload", "getReactPayloadString", "getAmazonWalletLinkingHandler", "Lcom/mpl/payment/juspayhypersdk/amazon/linking/AmazonWalletLinkingHandler;", "linkingListener", "Lcom/mpl/payment/linking/LinkingListener;", "getGopayLinkingHandler", "Lcom/mpl/payment/gopay/GopayLinkingHandler;", "resolveLinkingHandler", "Lcom/mpl/payment/linking/LinkingHandler;", "linkingType", "Lcom/mpl/payment/linking/LinkingType;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLLinkingHandlerResolver.kt */
public final class MPLLinkingHandlerResolver implements LinkingHandlerResolver {
    public final String TAG = "DefaultLinkingFlowResolver";
    public final Activity activity;
    public final FetchCustomerIdUseCase customerIdUseCase;
    public final Moshi moshi;
    public final String mplPayload;
    public final String reactPayloadString;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LinkingType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LinkingType linkingType = LinkingType.GOPAY;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            LinkingType linkingType2 = LinkingType.AMAZON;
            iArr2[1] = 2;
        }
    }

    public MPLLinkingHandlerResolver(Moshi moshi2, String str, String str2, Activity activity2, FetchCustomerIdUseCase fetchCustomerIdUseCase) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(str, "reactPayloadString");
        Intrinsics.checkNotNullParameter(str2, "mplPayload");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(fetchCustomerIdUseCase, "customerIdUseCase");
        this.moshi = moshi2;
        this.reactPayloadString = str;
        this.mplPayload = str2;
        this.activity = activity2;
        this.customerIdUseCase = fetchCustomerIdUseCase;
    }

    private final AmazonWalletLinkingHandler getAmazonWalletLinkingHandler(LinkingListener linkingListener) {
        JsonAdapter<AmazonWalletReactPayload> adapter = this.moshi.adapter(AmazonWalletReactPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(AmazonWall…ReactPayload::class.java)");
        AmazonWalletReactPayload amazonWalletReactPayload = (AmazonWalletReactPayload) adapter.fromJson(this.reactPayloadString);
        if (amazonWalletReactPayload != null) {
            JsonAdapter<AmazonWalletMplPayload> adapter2 = this.moshi.adapter(AmazonWalletMplPayload.class);
            Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(AmazonWalletMplPayload::class.java)");
            AmazonWalletMplPayload amazonWalletMplPayload = (AmazonWalletMplPayload) adapter2.fromJson(this.mplPayload);
            if (amazonWalletMplPayload != null) {
                Activity activity2 = this.activity;
                if (!(activity2 instanceof FragmentActivity)) {
                    activity2 = null;
                }
                FragmentActivity fragmentActivity = (FragmentActivity) activity2;
                if (fragmentActivity != null) {
                    AmazonWalletLinkingHandler amazonWalletLinkingHandler = new AmazonWalletLinkingHandler(amazonWalletReactPayload, amazonWalletMplPayload, fragmentActivity, this.moshi, linkingListener, this.customerIdUseCase);
                    return amazonWalletLinkingHandler;
                }
                throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " Activity has to be instance of fragment Activity"));
            }
            throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " parsed mplPayload should not be null"));
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " parsed react json should not be null"));
    }

    private final GopayLinkingHandler getGopayLinkingHandler(LinkingListener linkingListener) {
        JsonAdapter<GoPayLinkingPayload> adapter = this.moshi.adapter(GoPayLinkingPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(GoPayLinkingPayload::class.java)");
        GoPayLinkingPayload goPayLinkingPayload = (GoPayLinkingPayload) adapter.fromJson(this.reactPayloadString);
        if (goPayLinkingPayload != null) {
            return new GopayLinkingHandler(this.activity, goPayLinkingPayload, linkingListener);
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " parsed react json should not be null"));
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final FetchCustomerIdUseCase getCustomerIdUseCase() {
        return this.customerIdUseCase;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getMplPayload() {
        return this.mplPayload;
    }

    public final String getReactPayloadString() {
        return this.reactPayloadString;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public LinkingHandler resolveLinkingHandler(LinkingType linkingType, LinkingListener linkingListener) {
        Intrinsics.checkNotNullParameter(linkingType, "linkingType");
        Intrinsics.checkNotNullParameter(linkingListener, "linkingListener");
        int ordinal = linkingType.ordinal();
        if (ordinal == 0) {
            return getGopayLinkingHandler(linkingListener);
        }
        if (ordinal == 1) {
            return getAmazonWalletLinkingHandler(linkingListener);
        }
        throw new Exception("Linking type " + linkingType + " not handled in the linking flow resolver " + this.TAG);
    }
}
