package com.mpl.payment.juspayhypersdk;

import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.payment.common.MPLInstrumentationListener;
import com.mpl.payment.common.upi.UpiAppListProvider;
import com.mpl.payment.common.upi.UpiAppListener;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCase;
import com.mpl.payment.juspayhypersdk.models.UpiAppModel;
import com.mpl.payment.juspayhypersdk.models.UpiAppsJuspayPayload;
import com.mpl.payment.utils.Constants;
import com.squareup.moshi.Moshi;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.services.HyperServices;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001fB?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/mpl/payment/juspayhypersdk/JusPayUpiAppListProvider;", "Lcom/mpl/payment/common/upi/UpiAppListProvider;", "clientId", "", "merchantId", "environment", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "mplInstrumentationListener", "Lcom/mpl/payment/common/MPLInstrumentationListener;", "fetchCustomerIdUseCase", "Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;Lcom/mpl/payment/common/MPLInstrumentationListener;Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;Lcom/squareup/moshi/Moshi;)V", "upiAppListener", "Lcom/mpl/payment/common/upi/UpiAppListener;", "getUpiAppListener", "()Lcom/mpl/payment/common/upi/UpiAppListener;", "setUpiAppListener", "(Lcom/mpl/payment/common/upi/UpiAppListener;)V", "addUpiListener", "", "extractPackageList", "Ljava/util/ArrayList;", "payload", "getPayloadAsString", "Lorg/json/JSONObject;", "getRequestPayload", "requestId", "getValidUpiApps", "Builder", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: JusPayUpiApptListProvider.kt */
public final class JusPayUpiAppListProvider implements UpiAppListProvider {
    public final String clientId;
    public final String environment;
    public final FetchCustomerIdUseCase fetchCustomerIdUseCase;
    public final FragmentActivity fragmentActivity;
    public final String merchantId;
    public final Moshi moshi;
    public final MPLInstrumentationListener mplInstrumentationListener;
    public UpiAppListener upiAppListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00060"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/JusPayUpiAppListProvider$Builder;", "", "()V", "clientId", "", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "environment", "getEnvironment", "setEnvironment", "fetchCustomerIdUseCase", "Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;", "getFetchCustomerIdUseCase", "()Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;", "setFetchCustomerIdUseCase", "(Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;)V", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "getFragmentActivity", "()Landroidx/fragment/app/FragmentActivity;", "setFragmentActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "merchantId", "getMerchantId", "setMerchantId", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "setMoshi", "(Lcom/squareup/moshi/Moshi;)V", "mplInstrumentationListener", "Lcom/mpl/payment/common/MPLInstrumentationListener;", "getMplInstrumentationListener", "()Lcom/mpl/payment/common/MPLInstrumentationListener;", "setMplInstrumentationListener", "(Lcom/mpl/payment/common/MPLInstrumentationListener;)V", "build", "Lcom/mpl/payment/juspayhypersdk/JusPayUpiAppListProvider;", "withClientId", "withEnvironment", "withFetchCustomerIdUseCase", "withFragmentActivty", "withMPLInstrumentationListener", "withMerchantId", "withMoshi", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: JusPayUpiApptListProvider.kt */
    public static final class Builder {
        public String clientId;
        public String environment;
        public FetchCustomerIdUseCase fetchCustomerIdUseCase;
        public FragmentActivity fragmentActivity;
        public String merchantId;
        public Moshi moshi;
        public MPLInstrumentationListener mplInstrumentationListener;

        public final JusPayUpiAppListProvider build() {
            String str = this.clientId;
            if (str != null) {
                String str2 = this.merchantId;
                if (str2 != null) {
                    String str3 = this.environment;
                    if (str3 != null) {
                        FragmentActivity fragmentActivity2 = this.fragmentActivity;
                        if (fragmentActivity2 != null) {
                            MPLInstrumentationListener mPLInstrumentationListener = this.mplInstrumentationListener;
                            if (mPLInstrumentationListener != null) {
                                FetchCustomerIdUseCase fetchCustomerIdUseCase2 = this.fetchCustomerIdUseCase;
                                if (fetchCustomerIdUseCase2 != null) {
                                    Moshi moshi2 = this.moshi;
                                    if (moshi2 != null) {
                                        JusPayUpiAppListProvider jusPayUpiAppListProvider = new JusPayUpiAppListProvider(str, str2, str3, fragmentActivity2, mPLInstrumentationListener, fetchCustomerIdUseCase2, moshi2, null);
                                        return jusPayUpiAppListProvider;
                                    }
                                    throw new Exception(GeneratedOutlineSupport.outline50("moshi can't be null when instantiating ", JusPayUpiApptListProviderKt.TAG));
                                }
                                throw new Exception(GeneratedOutlineSupport.outline50("fetchCustomerIdUseCase can't be null when instantiating ", JusPayUpiApptListProviderKt.TAG));
                            }
                            throw new Exception(GeneratedOutlineSupport.outline50("mplInstrumentationListener can't be null when instantiating ", JusPayUpiApptListProviderKt.TAG));
                        }
                        throw new Exception(GeneratedOutlineSupport.outline50("fragmentActivity can't be null when instantiating ", JusPayUpiApptListProviderKt.TAG));
                    }
                    throw new Exception(GeneratedOutlineSupport.outline50("environment can't be null when instantiating ", JusPayUpiApptListProviderKt.TAG));
                }
                throw new Exception(GeneratedOutlineSupport.outline50("merchantId can't be null when instantiating ", JusPayUpiApptListProviderKt.TAG));
            }
            throw new Exception(GeneratedOutlineSupport.outline50("clientId can't be null when instantiating ", JusPayUpiApptListProviderKt.TAG));
        }

        public final String getClientId() {
            return this.clientId;
        }

        public final String getEnvironment() {
            return this.environment;
        }

        public final FetchCustomerIdUseCase getFetchCustomerIdUseCase() {
            return this.fetchCustomerIdUseCase;
        }

        public final FragmentActivity getFragmentActivity() {
            return this.fragmentActivity;
        }

        public final String getMerchantId() {
            return this.merchantId;
        }

        public final Moshi getMoshi() {
            return this.moshi;
        }

        public final MPLInstrumentationListener getMplInstrumentationListener() {
            return this.mplInstrumentationListener;
        }

        public final void setClientId(String str) {
            this.clientId = str;
        }

        public final void setEnvironment(String str) {
            this.environment = str;
        }

        public final void setFetchCustomerIdUseCase(FetchCustomerIdUseCase fetchCustomerIdUseCase2) {
            this.fetchCustomerIdUseCase = fetchCustomerIdUseCase2;
        }

        public final void setFragmentActivity(FragmentActivity fragmentActivity2) {
            this.fragmentActivity = fragmentActivity2;
        }

        public final void setMerchantId(String str) {
            this.merchantId = str;
        }

        public final void setMoshi(Moshi moshi2) {
            this.moshi = moshi2;
        }

        public final void setMplInstrumentationListener(MPLInstrumentationListener mPLInstrumentationListener) {
            this.mplInstrumentationListener = mPLInstrumentationListener;
        }

        public final Builder withClientId(String str) {
            Intrinsics.checkNotNullParameter(str, PaymentConstants.CLIENT_ID_CAMEL);
            this.clientId = str;
            return this;
        }

        public final Builder withEnvironment(String str) {
            Intrinsics.checkNotNullParameter(str, PaymentConstants.ENV);
            this.environment = str;
            return this;
        }

        public final Builder withFetchCustomerIdUseCase(FetchCustomerIdUseCase fetchCustomerIdUseCase2) {
            Intrinsics.checkNotNullParameter(fetchCustomerIdUseCase2, "fetchCustomerIdUseCase");
            this.fetchCustomerIdUseCase = fetchCustomerIdUseCase2;
            return this;
        }

        public final Builder withFragmentActivty(FragmentActivity fragmentActivity2) {
            Intrinsics.checkNotNullParameter(fragmentActivity2, "fragmentActivity");
            this.fragmentActivity = fragmentActivity2;
            return this;
        }

        public final Builder withMPLInstrumentationListener(MPLInstrumentationListener mPLInstrumentationListener) {
            Intrinsics.checkNotNullParameter(mPLInstrumentationListener, "mplInstrumentationListener");
            this.mplInstrumentationListener = mPLInstrumentationListener;
            return this;
        }

        public final Builder withMerchantId(String str) {
            Intrinsics.checkNotNullParameter(str, PaymentConstants.MERCHANT_ID_CAMEL);
            this.merchantId = str;
            return this;
        }

        public final Builder withMoshi(Moshi moshi2) {
            Intrinsics.checkNotNullParameter(moshi2, "moshi");
            this.moshi = moshi2;
            return this;
        }
    }

    public JusPayUpiAppListProvider(String str, String str2, String str3, FragmentActivity fragmentActivity2, MPLInstrumentationListener mPLInstrumentationListener, FetchCustomerIdUseCase fetchCustomerIdUseCase2, Moshi moshi2) {
        this.clientId = str;
        this.merchantId = str2;
        this.environment = str3;
        this.fragmentActivity = fragmentActivity2;
        this.mplInstrumentationListener = mPLInstrumentationListener;
        this.fetchCustomerIdUseCase = fetchCustomerIdUseCase2;
        this.moshi = moshi2;
    }

    /* access modifiers changed from: private */
    public final ArrayList<String> extractPackageList(String str) {
        UpiAppsJuspayPayload upiAppsJuspayPayload = (UpiAppsJuspayPayload) this.moshi.adapter(UpiAppsJuspayPayload.class).fromJson(str);
        if (upiAppsJuspayPayload != null) {
            Intrinsics.checkNotNullExpressionValue(upiAppsJuspayPayload, "moshiAdapter.fromJson(pa…pi app list from Juspay\")");
            List<UpiAppModel> availableApps = upiAppsJuspayPayload.getAvailableApps();
            ArrayList<String> arrayList = new ArrayList<>();
            for (UpiAppModel packageName : availableApps) {
                arrayList.add(packageName.getPackageName());
            }
            return arrayList;
        }
        throw new Exception("Moshi returned null when parsing upi app list from Juspay");
    }

    /* access modifiers changed from: private */
    public final String getPayloadAsString(JSONObject jSONObject) {
        if (jSONObject != null) {
            String jSONObject2 = jSONObject.toString();
            if (jSONObject2 != null) {
                return jSONObject2;
            }
        }
        throw new Exception("JusPayUpiAppListProvider Null payload returned from HyperServiceWrappper when querying upi app list");
    }

    private final JSONObject getRequestPayload(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HyperServices.REQUEST_ID, str);
        jSONObject.put("service", Constants.JUSPAY_SERVICE_NAME);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("action", "upiTxn");
        jSONObject2.put("orderId", "");
        jSONObject2.put("getAvailableApps", true);
        jSONObject2.put("showLoader", false);
        jSONObject.put("payload", jSONObject2);
        MLog.d(JusPayUpiApptListProviderKt.TAG, "juspayUpiApplist Playload Prepared---> " + jSONObject);
        return jSONObject;
    }

    public void addUpiListener(UpiAppListener upiAppListener2) {
        Intrinsics.checkNotNullParameter(upiAppListener2, "upiAppListener");
        this.upiAppListener = upiAppListener2;
    }

    public final UpiAppListener getUpiAppListener() {
        UpiAppListener upiAppListener2 = this.upiAppListener;
        if (upiAppListener2 != null) {
            return upiAppListener2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("upiAppListener");
        throw null;
    }

    public void getValidUpiApps() {
        UpiAppListener upiAppListener2 = this.upiAppListener;
        if (upiAppListener2 == null) {
            throw new Exception("JusPayUpiAppListProvider upiAppListener not set");
        } else if (upiAppListener2 != null) {
            this.upiAppListener = upiAppListener2;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
            HyperServiceWrapper.process(getRequestPayload(uuid), new JusPayUpiAppListProvider$getValidUpiApps$2(this), uuid, this.fragmentActivity, this.merchantId, this.clientId, this.environment, this.fetchCustomerIdUseCase);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("upiAppListener");
            throw null;
        }
    }

    public final void setUpiAppListener(UpiAppListener upiAppListener2) {
        Intrinsics.checkNotNullParameter(upiAppListener2, "<set-?>");
        this.upiAppListener = upiAppListener2;
    }

    public /* synthetic */ JusPayUpiAppListProvider(String str, String str2, String str3, FragmentActivity fragmentActivity2, MPLInstrumentationListener mPLInstrumentationListener, FetchCustomerIdUseCase fetchCustomerIdUseCase2, Moshi moshi2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, fragmentActivity2, mPLInstrumentationListener, fetchCustomerIdUseCase2, moshi2);
    }
}
