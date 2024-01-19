package com.mpl.payment.gopay;

import android.app.Activity;
import android.content.Context;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutClient;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError;
import com.midtrans.sdk.gopaycheckout.core.account.AccountResponse;
import com.midtrans.sdk.gopaycheckout.core.account.GoPayPartnerDetails;
import com.mpl.payment.gopay.models.GoPayLinkingPayload;
import com.mpl.payment.linking.LinkingHandler;
import com.mpl.payment.linking.LinkingListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u00020\u0001:\u0001(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u0018H\u0016J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002J \u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/mpl/payment/gopay/GopayLinkingHandler;", "Lcom/mpl/payment/linking/LinkingHandler;", "activity", "Landroid/app/Activity;", "gpopayLinkingPayload", "Lcom/mpl/payment/gopay/models/GoPayLinkingPayload;", "linkingListener", "Lcom/mpl/payment/linking/LinkingListener;", "(Landroid/app/Activity;Lcom/mpl/payment/gopay/models/GoPayLinkingPayload;Lcom/mpl/payment/linking/LinkingListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "getGpopayLinkingPayload", "()Lcom/mpl/payment/gopay/models/GoPayLinkingPayload;", "getLinkingListener", "()Lcom/mpl/payment/linking/LinkingListener;", "getGoPayClient", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutClient;", "context", "Landroid/content/Context;", "handleLinkingFailure", "", "error", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "errorResponse", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "handleNulls", "response", "handleOnResponse", "performLinking", "sendLinkingFailedStatus", "failureStatus", "reason", "sendLinkingStatus", "status", "accountStatus", "accountId", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GopayLinkingHandler.kt */
public final class GopayLinkingHandler implements LinkingHandler {
    public static final String AS_DISABLED = "DISABLED";
    public static final String AS_EMPTY = "";
    public static final String AS_ENABLED = "ENABLED";
    public static final String AS_PENDING = "PENDING";
    public static final String CRC_NO_GOPAY_ACCOUNT = "105";
    public static final String CRC_NO_GOPAY_PIN = "120";
    public static final Companion Companion = new Companion(null);
    public static final String FS_NO_GOPAY_ACCOUNT = "NO_GOPAY_ACCOUNT";
    public static final String FS_NO_GOPAY_PIN = "NO_GOPAY_PIN";
    public static final String STATUS_FAIL = "FAIL";
    public static final String STATUS_FAILED = "FAILED";
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_SUCCESS = "SUCCESS";
    public final String TAG = "GopayLinkingHandler";
    public final Activity activity;
    public final GoPayLinkingPayload gpopayLinkingPayload;
    public final LinkingListener linkingListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mpl/payment/gopay/GopayLinkingHandler$Companion;", "", "()V", "AS_DISABLED", "", "AS_EMPTY", "AS_ENABLED", "AS_PENDING", "CRC_NO_GOPAY_ACCOUNT", "CRC_NO_GOPAY_PIN", "FS_NO_GOPAY_ACCOUNT", "FS_NO_GOPAY_PIN", "STATUS_FAIL", "STATUS_FAILED", "STATUS_PENDING", "STATUS_SUCCESS", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GopayLinkingHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GopayLinkingHandler(Activity activity2, GoPayLinkingPayload goPayLinkingPayload, LinkingListener linkingListener2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(goPayLinkingPayload, "gpopayLinkingPayload");
        Intrinsics.checkNotNullParameter(linkingListener2, "linkingListener");
        this.activity = activity2;
        this.gpopayLinkingPayload = goPayLinkingPayload;
        this.linkingListener = linkingListener2;
    }

    private final GoPayCheckoutClient getGoPayClient(Context context) {
        GoPayCheckoutClient goPayCheckoutClient = new GoPayCheckoutClient(context, this.gpopayLinkingPayload.getMerchantId(), this.gpopayLinkingPayload.getCallBackUrl(), this.gpopayLinkingPayload.getMerchantServerUrl(), false);
        return goPayCheckoutClient;
    }

    /* access modifiers changed from: private */
    public final void handleLinkingFailure(GoPayCheckoutError goPayCheckoutError, AccountResponse accountResponse) {
        this.linkingListener.onLinkingError(GoPayUtils.Companion.getErrorMessage(goPayCheckoutError, accountResponse));
    }

    private final void handleNulls(AccountResponse accountResponse) {
        String channelResponseCode = accountResponse.getChannelResponseCode();
        if (channelResponseCode != null) {
            int hashCode = channelResponseCode.hashCode();
            if (hashCode != 48630) {
                if (hashCode == 48687 && channelResponseCode.equals(CRC_NO_GOPAY_PIN)) {
                    sendLinkingFailedStatus(FS_NO_GOPAY_PIN, "User needs to setup gopay pin");
                    return;
                }
            } else if (channelResponseCode.equals(CRC_NO_GOPAY_ACCOUNT)) {
                sendLinkingFailedStatus(FS_NO_GOPAY_ACCOUNT, "User did not have an active gopay account");
                return;
            }
        }
        sendLinkingFailedStatus("", this.TAG + " Either AccntSts->null or AccntID->Null unknown channelRsponsecode-> " + accountResponse.getChannelResponseCode() + " channelResponseMessage-> " + accountResponse.getChannelResponseMessage());
    }

    /* access modifiers changed from: private */
    public final void handleOnResponse(AccountResponse accountResponse) {
        if (accountResponse.getAccountId() == null) {
            handleNulls(accountResponse);
            return;
        }
        String accountStatus = accountResponse.getAccountStatus();
        if (accountStatus == null) {
            handleNulls(accountResponse);
        } else {
            int hashCode = accountStatus.hashCode();
            if (hashCode != -891611359) {
                if (hashCode != 0) {
                    if (hashCode != 35394935) {
                        if (hashCode == 1053567612 && accountStatus.equals("DISABLED")) {
                            String accountStatus2 = accountResponse.getAccountStatus();
                            Intrinsics.checkNotNull(accountStatus2);
                            String accountId = accountResponse.getAccountId();
                            Intrinsics.checkNotNull(accountId);
                            sendLinkingStatus(STATUS_FAIL, accountStatus2, accountId);
                        }
                    } else if (accountStatus.equals("PENDING")) {
                        String accountStatus3 = accountResponse.getAccountStatus();
                        Intrinsics.checkNotNull(accountStatus3);
                        String accountId2 = accountResponse.getAccountId();
                        Intrinsics.checkNotNull(accountId2);
                        sendLinkingStatus("PENDING", accountStatus3, accountId2);
                    }
                } else if (accountStatus.equals("")) {
                    sendLinkingStatus(STATUS_FAIL, "", "");
                }
            } else if (accountStatus.equals(AS_ENABLED)) {
                String accountStatus4 = accountResponse.getAccountStatus();
                Intrinsics.checkNotNull(accountStatus4);
                String accountId3 = accountResponse.getAccountId();
                Intrinsics.checkNotNull(accountId3);
                sendLinkingStatus("SUCCESS", accountStatus4, accountId3);
            }
            LinkingListener linkingListener2 = this.linkingListener;
            linkingListener2.onLinkingError(this.TAG + " accountStatus unknown it was---> " + accountResponse.getAccountStatus());
        }
    }

    private final void sendLinkingFailedStatus(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "FAILED");
        if (str.length() > 0) {
            jSONObject.put("failureStatus", str);
        }
        jSONObject.put("reason", str2);
        LinkingListener linkingListener2 = this.linkingListener;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "failedJson.toString()");
        linkingListener2.onLinkingFailed(jSONObject2);
    }

    private final void sendLinkingStatus(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", str);
        jSONObject.put("accountStatus", str2);
        jSONObject.put("accountId", str3);
        LinkingListener linkingListener2 = this.linkingListener;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "successJson.toString()");
        linkingListener2.onLinkingSuccessful(jSONObject2);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final GoPayLinkingPayload getGpopayLinkingPayload() {
        return this.gpopayLinkingPayload;
    }

    public final LinkingListener getLinkingListener() {
        return this.linkingListener;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public void performLinking() {
        Context baseContext = this.activity.getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "activity.baseContext");
        GoPayCheckoutClient.linkAccount$default(getGoPayClient(baseContext), this.activity, new GoPayPartnerDetails(this.gpopayLinkingPayload.getPhoneNoToLink(), this.gpopayLinkingPayload.getCountryCode()), new GopayLinkingHandler$performLinking$gopayCheckOutCallback$1(this), null, 8, null);
    }
}
