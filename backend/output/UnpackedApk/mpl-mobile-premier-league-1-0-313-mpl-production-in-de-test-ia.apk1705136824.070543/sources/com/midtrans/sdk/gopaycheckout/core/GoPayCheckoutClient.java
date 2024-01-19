package com.midtrans.sdk.gopaycheckout.core;

import android.app.Activity;
import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.midtrans.sdk.gopaycheckout.analytics.AnalyticsEvent;
import com.midtrans.sdk.gopaycheckout.analytics.AnalyticsTracker;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError.ClientError;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError.NoContent;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError.UnknownError;
import com.midtrans.sdk.gopaycheckout.core.account.AccountResponse;
import com.midtrans.sdk.gopaycheckout.core.account.GoPayPartnerDetails;
import com.midtrans.sdk.gopaycheckout.core.account.LinkAccountRequest;
import com.midtrans.sdk.gopaycheckout.core.server.GoPayCheckoutHttpApi;
import com.midtrans.sdk.gopaycheckout.core.transaction.CustomerDetails;
import com.midtrans.sdk.gopaycheckout.core.transaction.GoPayDetails;
import com.midtrans.sdk.gopaycheckout.core.transaction.ItemDetail;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionDetails;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionRequest;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse;
import com.midtrans.sdk.gopaycheckout.core.utils.ErrorResponseUtils;
import com.midtrans.sdk.gopaycheckout.di.DaggerGoPayCheckoutComponent;
import com.midtrans.sdk.gopaycheckout.di.GoPayCheckoutComponent.Builder;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 A2\u00020\u0001:\u0001AB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0000\u0010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001eH\u0002J`\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020-0\u001e2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010/H\u0007J6\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u0002020\u001e2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010/H\u0007J\u001c\u00103\u001a\u00020\"2\u0006\u00101\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u0002020\u001eJ>\u00104\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u00105\u001a\u0002062\f\u0010 \u001a\b\u0012\u0004\u0012\u0002020\u001e2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010/H\u0007J\u001c\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050/2\u0006\u00108\u001a\u000209H\u0002J]\u0010:\u001a\u00020\"\"\u0006\b\u0000\u0010\u001f\u0018\u00012\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H\u001f0<2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u00020\"0>2\u001a\u0010?\u001a\u0016\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u0001H\u001f\u0012\u0004\u0012\u00020\"0@2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001eH\bR\u001e\u0010\u000b\u001a\u00020\f8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutClient;", "", "context", "Landroid/content/Context;", "merchantId", "", "callbackUrl", "merchantUrl", "loggingEnabled", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "analyticsTracker", "Lcom/midtrans/sdk/gopaycheckout/analytics/AnalyticsTracker;", "getAnalyticsTracker$gopay_checkout_release", "()Lcom/midtrans/sdk/gopaycheckout/analytics/AnalyticsTracker;", "setAnalyticsTracker$gopay_checkout_release", "(Lcom/midtrans/sdk/gopaycheckout/analytics/AnalyticsTracker;)V", "errorResponseUtils", "Lcom/midtrans/sdk/gopaycheckout/core/utils/ErrorResponseUtils;", "getErrorResponseUtils$gopay_checkout_release", "()Lcom/midtrans/sdk/gopaycheckout/core/utils/ErrorResponseUtils;", "setErrorResponseUtils$gopay_checkout_release", "(Lcom/midtrans/sdk/gopaycheckout/core/utils/ErrorResponseUtils;)V", "goPayCheckoutHttpApi", "Lcom/midtrans/sdk/gopaycheckout/core/server/GoPayCheckoutHttpApi;", "getGoPayCheckoutHttpApi$gopay_checkout_release", "()Lcom/midtrans/sdk/gopaycheckout/core/server/GoPayCheckoutHttpApi;", "setGoPayCheckoutHttpApi$gopay_checkout_release", "(Lcom/midtrans/sdk/gopaycheckout/core/server/GoPayCheckoutHttpApi;)V", "createInternalCallback", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutCallback;", "T", "callback", "createTransaction", "", "activity", "Landroid/app/Activity;", "goPayDetails", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/GoPayDetails;", "transactionDetails", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetails;", "phone", "itemDetails", "", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/ItemDetail;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionResponse;", "metadata", "", "disableAccount", "accountId", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "enquireAccount", "linkAccount", "goPayPartnerDetails", "Lcom/midtrans/sdk/gopaycheckout/core/account/GoPayPartnerDetails;", "mapAnalyticsProperties", "throwable", "", "processResponse", "response", "Lretrofit2/Response;", "succeededAction", "Lkotlin/Function1;", "failureAction", "Lkotlin/Function2;", "Companion", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutClient {
    public static final Companion Companion = new Companion(null);
    public static final String MERCHANT_SERVER_URL = "MerchantServerUrl";
    public static final String PAYMENT_TYPE_GOPAY = "gopay";
    public AnalyticsTracker analyticsTracker;
    public final String callbackUrl;
    public ErrorResponseUtils errorResponseUtils;
    public GoPayCheckoutHttpApi goPayCheckoutHttpApi;
    public final String merchantId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutClient$Companion;", "", "()V", "MERCHANT_SERVER_URL", "", "PAYMENT_TYPE_GOPAY", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GoPayCheckoutClient(Context context, String str, String str2, String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkParameterIsNotNull(str2, "callbackUrl");
        Intrinsics.checkParameterIsNotNull(str3, "merchantUrl");
        this.merchantId = str;
        this.callbackUrl = str2;
        Builder builder = DaggerGoPayCheckoutComponent.builder();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
        builder.setApplicationContext(applicationContext).setEnableLogging(z).setMerchantUrl(str3).build().inject(this);
        AnalyticsTracker analyticsTracker2 = this.analyticsTracker;
        if (analyticsTracker2 != null) {
            analyticsTracker2.setIdentity(this.merchantId, TweetUtils.mapOf(new Pair(MERCHANT_SERVER_URL, str3)));
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
            throw null;
        }
    }

    public /* synthetic */ GoPayCheckoutClient(Context context, String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, str3, (i & 16) != 0 ? false : z);
    }

    private final <T> GoPayCheckoutCallback<T> createInternalCallback(GoPayCheckoutCallback<T> goPayCheckoutCallback) {
        return new GoPayCheckoutClient$createInternalCallback$1(goPayCheckoutCallback);
    }

    public static /* synthetic */ void createTransaction$default(GoPayCheckoutClient goPayCheckoutClient, Activity activity, GoPayDetails goPayDetails, TransactionDetails transactionDetails, String str, List list, GoPayCheckoutCallback goPayCheckoutCallback, Map map, int i, Object obj) {
        goPayCheckoutClient.createTransaction(activity, goPayDetails, transactionDetails, str, (i & 16) != 0 ? null : list, goPayCheckoutCallback, (i & 64) != 0 ? null : map);
    }

    public static /* synthetic */ void disableAccount$default(GoPayCheckoutClient goPayCheckoutClient, String str, GoPayCheckoutCallback goPayCheckoutCallback, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        goPayCheckoutClient.disableAccount(str, goPayCheckoutCallback, map);
    }

    public static /* synthetic */ void linkAccount$default(GoPayCheckoutClient goPayCheckoutClient, Activity activity, GoPayPartnerDetails goPayPartnerDetails, GoPayCheckoutCallback goPayCheckoutCallback, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = null;
        }
        goPayCheckoutClient.linkAccount(activity, goPayPartnerDetails, goPayCheckoutCallback, map);
    }

    /* access modifiers changed from: private */
    public final Map<String, String> mapAnalyticsProperties(Throwable th) {
        int code;
        if (th != null) {
            GoPayCheckoutError goPayCheckoutError = (GoPayCheckoutError) th;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (goPayCheckoutError instanceof ClientError) {
                linkedHashMap.put(AnalyticsEvent.HTTP_ERROR_MESSAGE_KEY, AnalyticsEvent.HTTP_ERROR_MESSAGE_CLIENT_ERROR);
                code = ((ClientError) goPayCheckoutError).getErrorCode();
            } else if (goPayCheckoutError instanceof NoContent) {
                linkedHashMap.put(AnalyticsEvent.HTTP_ERROR_MESSAGE_KEY, AnalyticsEvent.HTTP_ERROR_MESSAGE_NO_CONTENT_ERROR);
                code = ((NoContent) goPayCheckoutError).getCode();
            } else {
                if (goPayCheckoutError instanceof UnknownError) {
                    UnknownError unknownError = (UnknownError) goPayCheckoutError;
                    String message = unknownError.getThrowable().getMessage();
                    if (message == null) {
                        message = "";
                    }
                    linkedHashMap.put(AnalyticsEvent.ERROR_MESSAGE, message);
                    String simpleName = unknownError.getThrowable().getClass().getSimpleName();
                    Intrinsics.checkExpressionValueIsNotNull(simpleName, "error.throwable::class.java.simpleName");
                    linkedHashMap.put(AnalyticsEvent.ERROR_CLASS, simpleName);
                }
                return linkedHashMap;
            }
            linkedHashMap.put(AnalyticsEvent.HTTP_ERROR_CODE, String.valueOf(code));
            return linkedHashMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError");
    }

    /* access modifiers changed from: private */
    public final <T> void processResponse(Response<T> response, Function1<? super T, Unit> function1, Function2<? super Throwable, ? super T, Unit> function2, GoPayCheckoutCallback<T> goPayCheckoutCallback) {
        if (response.isSuccessful()) {
            T t = response.body;
            if (t != null) {
                function1.invoke(t);
            } else {
                NoContent noContent = new NoContent(response.code());
                function2.invoke(noContent, null);
                goPayCheckoutCallback.onFailure(noContent, null);
            }
            GoPayCheckoutState.INSTANCE.setExecutable(true);
            return;
        }
        ErrorResponseUtils errorResponseUtils$gopay_checkout_release = getErrorResponseUtils$gopay_checkout_release();
        ResponseBody responseBody = response.errorBody;
        if (responseBody != null) {
            responseBody.string();
        }
        errorResponseUtils$gopay_checkout_release.getMoshi();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public final void createTransaction(Activity activity, GoPayDetails goPayDetails, TransactionDetails transactionDetails, String str, GoPayCheckoutCallback<TransactionResponse> goPayCheckoutCallback) {
        createTransaction$default(this, activity, goPayDetails, transactionDetails, str, null, goPayCheckoutCallback, null, 80, null);
    }

    public final void createTransaction(Activity activity, GoPayDetails goPayDetails, TransactionDetails transactionDetails, String str, List<ItemDetail> list, GoPayCheckoutCallback<TransactionResponse> goPayCheckoutCallback) {
        createTransaction$default(this, activity, goPayDetails, transactionDetails, str, list, goPayCheckoutCallback, null, 64, null);
    }

    public final void createTransaction(Activity activity, GoPayDetails goPayDetails, TransactionDetails transactionDetails, String str, List<ItemDetail> list, GoPayCheckoutCallback<TransactionResponse> goPayCheckoutCallback, Map<String, String> map) {
        int i;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList;
        Activity activity2 = activity;
        String str5 = str;
        List<ItemDetail> list2 = list;
        GoPayCheckoutCallback<TransactionResponse> goPayCheckoutCallback2 = goPayCheckoutCallback;
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        Intrinsics.checkParameterIsNotNull(goPayDetails, "goPayDetails");
        Intrinsics.checkParameterIsNotNull(transactionDetails, "transactionDetails");
        Intrinsics.checkParameterIsNotNull(str5, "phone");
        Intrinsics.checkParameterIsNotNull(goPayCheckoutCallback2, "callback");
        if (GoPayCheckoutState.INSTANCE.checkExecutable()) {
            boolean z = false;
            GoPayCheckoutState.INSTANCE.setExecutable(false);
            GoPayCheckoutCallback createInternalCallback = createInternalCallback(goPayCheckoutCallback2);
            TransactionDetails copy$default = TransactionDetails.copy$default(transactionDetails, null, null, null, 7, null);
            if (this.callbackUrl.length() > 0) {
                z = true;
            }
            if (z) {
                str4 = null;
                str3 = null;
                str2 = this.callbackUrl;
                i = 3;
            } else {
                str2 = null;
                i = 7;
                str3 = null;
                str4 = null;
            }
            GoPayDetails copy$default2 = GoPayDetails.copy$default(goPayDetails, str4, str3, str2, i, null);
            copy$default2.setEnableCallback(Boolean.TRUE);
            CustomerDetails customerDetails = new CustomerDetails(str5);
            if (list2 != null) {
                ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(list2, 10));
                for (ItemDetail copy$default3 : list) {
                    arrayList2.add(ItemDetail.copy$default(copy$default3, null, null, null, null, null, 31, null));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            TransactionRequest transactionRequest = new TransactionRequest(null, copy$default2, copy$default, customerDetails, arrayList, map, 1, null);
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Charge-");
            outline73.append(transactionDetails.getOrderId());
            outline73.append('-');
            outline73.append(this.merchantId);
            String sb = outline73.toString();
            GoPayCheckoutHttpApi goPayCheckoutHttpApi2 = this.goPayCheckoutHttpApi;
            if (goPayCheckoutHttpApi2 != null) {
                goPayCheckoutHttpApi2.createTransaction(transactionRequest, sb, new GoPayCheckoutClient$createTransaction$1(this, createInternalCallback, activity2));
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("goPayCheckoutHttpApi");
                throw null;
            }
        }
    }

    public final void disableAccount(String str, GoPayCheckoutCallback<AccountResponse> goPayCheckoutCallback) {
        disableAccount$default(this, str, goPayCheckoutCallback, null, 4, null);
    }

    public final void disableAccount(String str, GoPayCheckoutCallback<AccountResponse> goPayCheckoutCallback, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "accountId");
        Intrinsics.checkParameterIsNotNull(goPayCheckoutCallback, "callback");
        if (GoPayCheckoutState.INSTANCE.checkExecutable()) {
            GoPayCheckoutState.INSTANCE.setExecutable(false);
            GoPayCheckoutCallback createInternalCallback = createInternalCallback(goPayCheckoutCallback);
            GoPayCheckoutHttpApi goPayCheckoutHttpApi2 = this.goPayCheckoutHttpApi;
            if (goPayCheckoutHttpApi2 != null) {
                goPayCheckoutHttpApi2.disableAccount(str, new GoPayCheckoutClient$disableAccount$1(this, createInternalCallback), map);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("goPayCheckoutHttpApi");
                throw null;
            }
        }
    }

    public final void enquireAccount(String str, GoPayCheckoutCallback<AccountResponse> goPayCheckoutCallback) {
        Intrinsics.checkParameterIsNotNull(str, "accountId");
        Intrinsics.checkParameterIsNotNull(goPayCheckoutCallback, "callback");
        if (GoPayCheckoutState.INSTANCE.checkExecutable()) {
            GoPayCheckoutState.INSTANCE.setExecutable(false);
            GoPayCheckoutCallback createInternalCallback = createInternalCallback(goPayCheckoutCallback);
            GoPayCheckoutHttpApi goPayCheckoutHttpApi2 = this.goPayCheckoutHttpApi;
            if (goPayCheckoutHttpApi2 != null) {
                goPayCheckoutHttpApi2.enquireAccount(str, new GoPayCheckoutClient$enquireAccount$1(this, createInternalCallback));
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("goPayCheckoutHttpApi");
                throw null;
            }
        }
    }

    public final AnalyticsTracker getAnalyticsTracker$gopay_checkout_release() {
        AnalyticsTracker analyticsTracker2 = this.analyticsTracker;
        if (analyticsTracker2 != null) {
            return analyticsTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
        throw null;
    }

    public final ErrorResponseUtils getErrorResponseUtils$gopay_checkout_release() {
        ErrorResponseUtils errorResponseUtils2 = this.errorResponseUtils;
        if (errorResponseUtils2 != null) {
            return errorResponseUtils2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("errorResponseUtils");
        throw null;
    }

    public final GoPayCheckoutHttpApi getGoPayCheckoutHttpApi$gopay_checkout_release() {
        GoPayCheckoutHttpApi goPayCheckoutHttpApi2 = this.goPayCheckoutHttpApi;
        if (goPayCheckoutHttpApi2 != null) {
            return goPayCheckoutHttpApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("goPayCheckoutHttpApi");
        throw null;
    }

    public final void linkAccount(Activity activity, GoPayPartnerDetails goPayPartnerDetails, GoPayCheckoutCallback<AccountResponse> goPayCheckoutCallback) {
        linkAccount$default(this, activity, goPayPartnerDetails, goPayCheckoutCallback, null, 8, null);
    }

    public final void linkAccount(Activity activity, GoPayPartnerDetails goPayPartnerDetails, GoPayCheckoutCallback<AccountResponse> goPayCheckoutCallback, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(goPayPartnerDetails, "goPayPartnerDetails");
        Intrinsics.checkParameterIsNotNull(goPayCheckoutCallback, "callback");
        if (GoPayCheckoutState.INSTANCE.checkExecutable()) {
            GoPayCheckoutState.INSTANCE.setExecutable(false);
            GoPayCheckoutCallback createInternalCallback = createInternalCallback(goPayCheckoutCallback);
            GoPayCheckoutHttpApi goPayCheckoutHttpApi2 = this.goPayCheckoutHttpApi;
            if (goPayCheckoutHttpApi2 != null) {
                goPayPartnerDetails.setRedirectUrl(this.callbackUrl);
                LinkAccountRequest linkAccountRequest = new LinkAccountRequest(goPayPartnerDetails, null, map, 2, null);
                goPayCheckoutHttpApi2.linkAccount(linkAccountRequest, new GoPayCheckoutClient$linkAccount$2(this, createInternalCallback, activity));
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("goPayCheckoutHttpApi");
            throw null;
        }
    }

    public final void setAnalyticsTracker$gopay_checkout_release(AnalyticsTracker analyticsTracker2) {
        Intrinsics.checkParameterIsNotNull(analyticsTracker2, "<set-?>");
        this.analyticsTracker = analyticsTracker2;
    }

    public final void setErrorResponseUtils$gopay_checkout_release(ErrorResponseUtils errorResponseUtils2) {
        Intrinsics.checkParameterIsNotNull(errorResponseUtils2, "<set-?>");
        this.errorResponseUtils = errorResponseUtils2;
    }

    public final void setGoPayCheckoutHttpApi$gopay_checkout_release(GoPayCheckoutHttpApi goPayCheckoutHttpApi2) {
        Intrinsics.checkParameterIsNotNull(goPayCheckoutHttpApi2, "<set-?>");
        this.goPayCheckoutHttpApi = goPayCheckoutHttpApi2;
    }
}
