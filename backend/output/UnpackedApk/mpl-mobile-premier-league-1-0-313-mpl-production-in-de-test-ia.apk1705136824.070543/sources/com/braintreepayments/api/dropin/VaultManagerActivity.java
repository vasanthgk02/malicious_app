package com.braintreepayments.api.dropin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog.Builder;
import com.braintreepayments.api.dropin.adapters.VaultManagerPaymentMethodsAdapter;
import com.braintreepayments.api.dropin.view.PaymentMethodItemView;
import com.braintreepayments.api.exceptions.PaymentMethodDeleteException;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceDeletedListener;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.google.android.material.snackbar.Snackbar;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class VaultManagerActivity extends BaseActivity implements PaymentMethodNonceDeletedListener, BraintreeErrorListener, OnClickListener {
    public VaultManagerPaymentMethodsAdapter mAdapter = new VaultManagerPaymentMethodsAdapter(this);
    public ViewSwitcher mLoadingViewSwitcher;

    public void onBackPressed() {
        if (this.mLoadingViewSwitcher.getDisplayedChild() == 0) {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view instanceof PaymentMethodItemView) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final PaymentMethodNonce paymentMethodNonce = ((PaymentMethodItemView) view).getPaymentMethodNonce();
            PaymentMethodItemView paymentMethodItemView = new PaymentMethodItemView(this);
            paymentMethodItemView.setPaymentMethod(paymentMethodNonce, false);
            Builder builder = new Builder(this, R$style.Theme_AppCompat_Light_Dialog_Alert);
            int i = R$string.bt_delete_confirmation_title;
            AlertParams alertParams = builder.P;
            alertParams.mTitle = alertParams.mContext.getText(i);
            int i2 = R$string.bt_delete_confirmation_description;
            AlertParams alertParams2 = builder.P;
            alertParams2.mMessage = alertParams2.mContext.getText(i2);
            AlertParams alertParams3 = builder.P;
            alertParams3.mView = paymentMethodItemView;
            alertParams3.mViewLayoutResId = 0;
            alertParams3.mViewSpacingSpecified = false;
            builder.setPositiveButton(R$string.bt_delete, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
                    r9.postOrQueueCallback(new com.braintreepayments.api.BraintreeFragment.AnonymousClass11(new com.braintreepayments.api.exceptions.BraintreeException("Unable to read GraphQL query")));
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0056 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005d */
                /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0048 */
                /* JADX WARNING: Removed duplicated region for block: B:26:? A[ExcHandler: NotFoundException | IOException | JSONException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:9:0x0048] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onClick(android.content.DialogInterface r9, int r10) {
                    /*
                        r8 = this;
                        java.util.concurrent.atomic.AtomicBoolean r9 = r0
                        r10 = 1
                        r9.set(r10)
                        com.braintreepayments.api.dropin.VaultManagerActivity r9 = com.braintreepayments.api.dropin.VaultManagerActivity.this
                        com.braintreepayments.api.BraintreeFragment r9 = r9.mBraintreeFragment
                        java.lang.String r0 = "manager.delete.confirmation.positive"
                        r9.sendAnalyticsEvent(r0)
                        com.braintreepayments.api.dropin.VaultManagerActivity r9 = com.braintreepayments.api.dropin.VaultManagerActivity.this
                        com.braintreepayments.api.BraintreeFragment r9 = r9.mBraintreeFragment
                        com.braintreepayments.api.models.PaymentMethodNonce r0 = r8
                        com.braintreepayments.api.models.Authorization r1 = r9.mAuthorization
                        boolean r1 = r1 instanceof com.braintreepayments.api.models.ClientToken
                        if (r1 != 0) goto L_0x002b
                        com.braintreepayments.api.exceptions.BraintreeException r0 = new com.braintreepayments.api.exceptions.BraintreeException
                        java.lang.String r1 = "A client token with a customer id must be used to delete a payment method nonce."
                        r0.<init>(r1)
                        com.braintreepayments.api.BraintreeFragment$11 r1 = new com.braintreepayments.api.BraintreeFragment$11
                        r1.<init>(r0)
                        r9.postOrQueueCallback(r1)
                        goto L_0x00a3
                    L_0x002b:
                        org.json.JSONObject r1 = new org.json.JSONObject
                        r1.<init>()
                        org.json.JSONObject r2 = new org.json.JSONObject
                        r2.<init>()
                        org.json.JSONObject r3 = new org.json.JSONObject
                        r3.<init>()
                        java.lang.String r4 = "clientSdkMetadata"
                        org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        r5.<init>()     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        java.lang.String r6 = "platform"
                        java.lang.String r7 = "android"
                        r5.put(r6, r7)     // Catch:{ JSONException -> 0x0048, NotFoundException | IOException | JSONException -> 0x0086 }
                    L_0x0048:
                        java.lang.String r6 = r9.mSessionId     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        java.lang.String r7 = "sessionId"
                        r5.put(r7, r6)     // Catch:{ JSONException -> 0x004f, NotFoundException | IOException | JSONException -> 0x0086 }
                    L_0x004f:
                        java.lang.String r6 = "client"
                        java.lang.String r7 = "source"
                        r5.put(r7, r6)     // Catch:{ JSONException -> 0x0056, NotFoundException | IOException | JSONException -> 0x0086 }
                    L_0x0056:
                        java.lang.String r6 = r9.mIntegrationType     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        java.lang.String r7 = "integration"
                        r5.put(r7, r6)     // Catch:{ JSONException -> 0x005d, NotFoundException | IOException | JSONException -> 0x0086 }
                    L_0x005d:
                        r1.put(r4, r5)     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        java.lang.String r4 = "query"
                        android.content.Context r5 = r9.mContext     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        int r6 = com.braintreepayments.api.R$raw.delete_payment_method_mutation     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        java.lang.String r5 = co.hyperverge.hypersnapsdk.c.k.getQuery(r5, r6)     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        r1.put(r4, r5)     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        java.lang.String r4 = "singleUseTokenId"
                        java.lang.String r5 = r0.mNonce     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        r3.put(r4, r5)     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        java.lang.String r4 = "input"
                        r2.put(r4, r3)     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        java.lang.String r3 = "variables"
                        r1.put(r3, r2)     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        java.lang.String r2 = "operationName"
                        java.lang.String r3 = "DeletePaymentMethodFromSingleUseToken"
                        r1.put(r2, r3)     // Catch:{ NotFoundException | IOException | JSONException -> 0x0086 }
                        goto L_0x0095
                    L_0x0086:
                        com.braintreepayments.api.exceptions.BraintreeException r2 = new com.braintreepayments.api.exceptions.BraintreeException
                        java.lang.String r3 = "Unable to read GraphQL query"
                        r2.<init>(r3)
                        com.braintreepayments.api.BraintreeFragment$11 r3 = new com.braintreepayments.api.BraintreeFragment$11
                        r3.<init>(r2)
                        r9.postOrQueueCallback(r3)
                    L_0x0095:
                        com.braintreepayments.api.internal.BraintreeGraphQLHttpClient r2 = r9.mGraphQLHttpClient
                        java.lang.String r1 = r1.toString()
                        com.braintreepayments.api.PaymentMethod$2 r3 = new com.braintreepayments.api.PaymentMethod$2
                        r3.<init>(r9, r0)
                        r2.post(r1, r3)
                    L_0x00a3:
                        com.braintreepayments.api.dropin.VaultManagerActivity r9 = com.braintreepayments.api.dropin.VaultManagerActivity.this
                        android.widget.ViewSwitcher r9 = r9.mLoadingViewSwitcher
                        r9.setDisplayedChild(r10)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.dropin.VaultManagerActivity.AnonymousClass4.onClick(android.content.DialogInterface, int):void");
                }
            });
            builder.P.mOnDismissListener = new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!atomicBoolean.get()) {
                        VaultManagerActivity.this.mBraintreeFragment.sendAnalyticsEvent("manager.delete.confirmation.negative");
                    }
                }
            };
            builder.setNegativeButton(R$string.bt_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -50575820, bundle);
    }

    public void onError(Exception exc) {
        if (exc instanceof PaymentMethodDeleteException) {
            Snackbar.make(findViewById(R$id.bt_base_view), R$string.bt_vault_manager_delete_failure, 0).show();
            this.mBraintreeFragment.sendAnalyticsEvent("manager.delete.failed");
            this.mLoadingViewSwitcher.setDisplayedChild(0);
            return;
        }
        this.mBraintreeFragment.sendAnalyticsEvent("manager.unknown.failed");
        finish(exc);
    }

    public void onPaymentMethodNonceDeleted(PaymentMethodNonce paymentMethodNonce) {
        VaultManagerPaymentMethodsAdapter vaultManagerPaymentMethodsAdapter = this.mAdapter;
        int indexOf = vaultManagerPaymentMethodsAdapter.mPaymentMethodNonces.indexOf(paymentMethodNonce);
        vaultManagerPaymentMethodsAdapter.mPaymentMethodNonces.remove(indexOf);
        vaultManagerPaymentMethodsAdapter.notifyItemRemoved(indexOf);
        this.mBraintreeFragment.sendAnalyticsEvent("manager.delete.succeeded");
        Intent intent = new Intent();
        VaultManagerPaymentMethodsAdapter vaultManagerPaymentMethodsAdapter2 = this.mAdapter;
        if (vaultManagerPaymentMethodsAdapter2 != null) {
            setResult(-1, intent.putExtra("com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCES", new ArrayList(vaultManagerPaymentMethodsAdapter2.mPaymentMethodNonces)));
            this.mLoadingViewSwitcher.setDisplayedChild(0);
            return;
        }
        throw null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        VaultManagerPaymentMethodsAdapter vaultManagerPaymentMethodsAdapter = this.mAdapter;
        if (vaultManagerPaymentMethodsAdapter != null) {
            bundle.putParcelableArrayList("com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCES", new ArrayList(vaultManagerPaymentMethodsAdapter.mPaymentMethodNonces));
            return;
        }
        throw null;
    }
}
