package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.interfaces.ThreeDSecureLookupListener;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import org.json.JSONException;

public final class ThreeDSecure$7 implements HttpResponseCallback {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ ThreeDSecureLookupListener val$lookupListener;
    public final /* synthetic */ ThreeDSecureRequest val$request;

    public ThreeDSecure$7(ThreeDSecureLookupListener threeDSecureLookupListener, ThreeDSecureRequest threeDSecureRequest, BraintreeFragment braintreeFragment) {
        this.val$lookupListener = threeDSecureLookupListener;
        this.val$request = threeDSecureRequest;
        this.val$fragment = braintreeFragment;
    }

    public void failure(Exception exc) {
        BraintreeFragment braintreeFragment = this.val$fragment;
        braintreeFragment.postOrQueueCallback(new QueuedCallback(exc) {
            public void run() {
                BraintreeFragment.this.mErrorListener.onError(exc);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mErrorListener != null;
            }
        });
    }

    public void success(String str) {
        try {
            this.val$lookupListener.onLookupComplete(this.val$request, ThreeDSecureLookup.fromJson(str));
        } catch (JSONException e2) {
            BraintreeFragment braintreeFragment = this.val$fragment;
            braintreeFragment.postOrQueueCallback(new QueuedCallback(e2) {
                public void run() {
                    BraintreeFragment.this.mErrorListener.onError(exc);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mErrorListener != null;
                }
            });
        }
    }
}
