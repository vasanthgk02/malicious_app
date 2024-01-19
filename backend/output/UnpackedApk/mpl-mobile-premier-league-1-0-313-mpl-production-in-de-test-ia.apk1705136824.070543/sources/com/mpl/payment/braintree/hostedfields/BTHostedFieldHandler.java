package com.mpl.payment.braintree.hostedfields;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.mpl.payment.braintree.WebRedirectActivity;
import com.mpl.payment.common.MPLInstrumentationListener;
import com.mpl.payment.common.OnActivityResultConsumer;
import com.mpl.payment.common.cardinput.CardTokenizationResultListener;
import com.mpl.payment.common.cardinput.HostedFieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010#\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016R\u0014\u0010\u000f\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011¨\u0006'"}, d2 = {"Lcom/mpl/payment/braintree/hostedfields/BTHostedFieldHandler;", "Lcom/mpl/payment/common/cardinput/HostedFieldHandler;", "Lcom/mpl/payment/common/OnActivityResultConsumer;", "hostedFieldsParams", "Lcom/mpl/payment/braintree/hostedfields/BtHostedFieldsParams;", "activity", "Landroid/app/Activity;", "requestCode", "", "showCardSavingMessage", "", "isCardVerificationEnabled", "mplInstrumentationListener", "Lcom/mpl/payment/common/MPLInstrumentationListener;", "(Lcom/mpl/payment/braintree/hostedfields/BtHostedFieldsParams;Landroid/app/Activity;ILjava/lang/String;Ljava/lang/String;Lcom/mpl/payment/common/MPLInstrumentationListener;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "cardTokenizationResultListener", "Lcom/mpl/payment/common/cardinput/CardTokenizationResultListener;", "getCardTokenizationResultListener", "()Lcom/mpl/payment/common/cardinput/CardTokenizationResultListener;", "setCardTokenizationResultListener", "(Lcom/mpl/payment/common/cardinput/CardTokenizationResultListener;)V", "getHostedFieldsParams", "()Lcom/mpl/payment/braintree/hostedfields/BtHostedFieldsParams;", "getMplInstrumentationListener", "()Lcom/mpl/payment/common/MPLInstrumentationListener;", "getRequestCode", "()I", "getShowCardSavingMessage", "collectAndTokenizeCard", "", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: BTHostedFieldHandler.kt */
public final class BTHostedFieldHandler implements HostedFieldHandler, OnActivityResultConsumer {
    public final String TAG = "BTHostedFieldHandler";
    public final Activity activity;
    public CardTokenizationResultListener cardTokenizationResultListener;
    public final BtHostedFieldsParams hostedFieldsParams;
    public final String isCardVerificationEnabled;
    public final MPLInstrumentationListener mplInstrumentationListener;
    public final int requestCode;
    public final String showCardSavingMessage;

    public BTHostedFieldHandler(BtHostedFieldsParams btHostedFieldsParams, Activity activity2, int i, String str, String str2, MPLInstrumentationListener mPLInstrumentationListener) {
        Intrinsics.checkNotNullParameter(btHostedFieldsParams, "hostedFieldsParams");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(str, "showCardSavingMessage");
        Intrinsics.checkNotNullParameter(str2, "isCardVerificationEnabled");
        Intrinsics.checkNotNullParameter(mPLInstrumentationListener, "mplInstrumentationListener");
        this.hostedFieldsParams = btHostedFieldsParams;
        this.activity = activity2;
        this.requestCode = i;
        this.showCardSavingMessage = str;
        this.isCardVerificationEnabled = str2;
        this.mplInstrumentationListener = mPLInstrumentationListener;
    }

    public void collectAndTokenizeCard(CardTokenizationResultListener cardTokenizationResultListener2) {
        Intrinsics.checkNotNullParameter(cardTokenizationResultListener2, "cardTokenizationResultListener");
        this.cardTokenizationResultListener = cardTokenizationResultListener2;
        String hostedFieldUrl = this.hostedFieldsParams.getData().getHostedFieldUrl();
        String redirectPath = this.hostedFieldsParams.getData().getRedirectPath();
        String clientToken = this.hostedFieldsParams.getData().getClientToken();
        if (CharsKt__CharKt.isBlank(hostedFieldUrl) || CharsKt__CharKt.isBlank(redirectPath) || CharsKt__CharKt.isBlank(clientToken) || CharsKt__CharKt.isBlank(this.showCardSavingMessage) || CharsKt__CharKt.isBlank(this.isCardVerificationEnabled)) {
            cardTokenizationResultListener2.onError(this.TAG + " check sdk init params, something came empty");
            return;
        }
        Uri build = Uri.parse(hostedFieldUrl).buildUpon().appendQueryParameter("token", clientToken).appendQueryParameter("showCardSavingMessage", this.showCardSavingMessage).appendQueryParameter("isCardVerificationEnabled", this.isCardVerificationEnabled).build();
        Intrinsics.checkNotNullExpressionValue(build, "hostedFieldUri");
        String authority = build.getAuthority();
        Intent intent = new Intent(this.activity, WebRedirectActivity.class);
        intent.putExtra(WebRedirectActivity.WEB_REDIRECT_ACTIVITY_EXTRA_HOST, authority);
        intent.putExtra(WebRedirectActivity.WEB_REDIRECT_ACTIVITY_EXTRA_URL, build.toString());
        intent.putExtra(WebRedirectActivity.WEB_REDIRECT_ACTIVITY_EXTRA_REDIRECT_PATH, redirectPath);
        this.activity.startActivityForResult(intent, this.requestCode);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final CardTokenizationResultListener getCardTokenizationResultListener() {
        return this.cardTokenizationResultListener;
    }

    public final BtHostedFieldsParams getHostedFieldsParams() {
        return this.hostedFieldsParams;
    }

    public final MPLInstrumentationListener getMplInstrumentationListener() {
        return this.mplInstrumentationListener;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final String getShowCardSavingMessage() {
        return this.showCardSavingMessage;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final String isCardVerificationEnabled() {
        return this.isCardVerificationEnabled;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.mpl.payment.common.cardinput.CardTokenizationResultListener r0 = r7.cardTokenizationResultListener
            if (r0 == 0) goto L_0x00fb
            if (r8 != r8) goto L_0x00e2
            r8 = -1
            if (r9 != r8) goto L_0x00be
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r9 = "Verification Flow"
            r0 = 1
            r8.put(r9, r0)
            com.mpl.payment.common.MPLInstrumentationListener r9 = r7.mplInstrumentationListener
            java.lang.String r8 = r8.toString()
            java.lang.String r1 = "eventProprJSON.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            java.lang.String r1 = "New Card Detail Submitted"
            r9.onClevertapEvent(r1, r8)
            android.os.Bundle r8 = r10.getExtras()
            java.lang.String r9 = "nonce"
            java.lang.String r10 = ""
            r1 = 0
            if (r8 == 0) goto L_0x0039
            java.lang.String r2 = r8.getString(r9, r10)
            goto L_0x003a
        L_0x0039:
            r2 = r1
        L_0x003a:
            if (r8 == 0) goto L_0x004e
            java.lang.String r3 = "cardType"
            java.lang.String r3 = r8.getString(r3, r10)
            if (r3 == 0) goto L_0x004e
            java.lang.String r3 = r3.toUpperCase()
            java.lang.String r4 = "(this as java.lang.String).toUpperCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            goto L_0x004f
        L_0x004e:
            r3 = r1
        L_0x004f:
            java.lang.String r4 = "bin"
            if (r8 == 0) goto L_0x0058
            java.lang.String r5 = r8.getString(r4, r10)
            goto L_0x0059
        L_0x0058:
            r5 = r1
        L_0x0059:
            java.lang.String r6 = "lastFour"
            if (r8 == 0) goto L_0x0061
            java.lang.String r1 = r8.getString(r6, r10)
        L_0x0061:
            if (r2 == 0) goto L_0x006c
            int r8 = r2.length()
            if (r8 != 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            r8 = 0
            goto L_0x006d
        L_0x006c:
            r8 = 1
        L_0x006d:
            if (r8 != 0) goto L_0x00a3
            if (r3 == 0) goto L_0x0079
            int r8 = r3.length()
            if (r8 != 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r0 = 0
        L_0x0079:
            if (r0 == 0) goto L_0x007c
            goto L_0x00a3
        L_0x007c:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            r8.put(r9, r2)
            java.lang.String r9 = "paymentMode"
            r8.put(r9, r3)
            r8.put(r4, r5)
            r8.put(r6, r1)
            com.mpl.payment.common.cardinput.CardTokenizationResultListener r9 = r7.cardTokenizationResultListener
            if (r9 == 0) goto L_0x00fa
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r8 = r8.toString()
            java.lang.String r10 = "params.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            r9.onTokenizationSuccess(r2, r8)
            goto L_0x00fa
        L_0x00a3:
            com.mpl.payment.common.cardinput.CardTokenizationResultListener r8 = r7.cardTokenizationResultListener
            if (r8 == 0) goto L_0x00fa
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r7.TAG
            r9.append(r10)
            java.lang.String r10 = " query params on redirect were null or empty"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.onError(r9)
            goto L_0x00fa
        L_0x00be:
            if (r9 != 0) goto L_0x00c6
            if (r0 == 0) goto L_0x00fa
            r0.onUserCancelled()
            goto L_0x00fa
        L_0x00c6:
            if (r0 == 0) goto L_0x00fa
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = r7.TAG
            r8.append(r10)
            java.lang.String r10 = " result code was "
            r8.append(r10)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r0.onError(r8)
            goto L_0x00fa
        L_0x00e2:
            if (r0 == 0) goto L_0x00fa
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r7.TAG
            r8.append(r9)
            java.lang.String r9 = " wrong request code"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r0.onError(r8)
        L_0x00fa:
            return
        L_0x00fb:
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r7.TAG
            java.lang.String r0 = " cardTokenizationResultListener not set"
            java.lang.String r9 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r9, r10, r0)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.braintree.hostedfields.BTHostedFieldHandler.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void setCardTokenizationResultListener(CardTokenizationResultListener cardTokenizationResultListener2) {
        this.cardTokenizationResultListener = cardTokenizationResultListener2;
    }
}
