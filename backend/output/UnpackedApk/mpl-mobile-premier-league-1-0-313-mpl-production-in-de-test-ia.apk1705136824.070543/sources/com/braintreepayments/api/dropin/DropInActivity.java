package com.braintreepayments.api.dropin;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.recyclerview.widget.RecyclerView;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.DataCollector$1;
import com.braintreepayments.api.GooglePayment$3;
import com.braintreepayments.api.GooglePaymentActivity;
import com.braintreepayments.api.PaymentMethod$1;
import com.braintreepayments.api.ThreeDSecure$3;
import com.braintreepayments.api.Venmo$1;
import com.braintreepayments.api.dropin.adapters.SupportedPaymentMethodsAdapter;
import com.braintreepayments.api.dropin.adapters.SupportedPaymentMethodsAdapter.PaymentMethodSelectedListener;
import com.braintreepayments.api.dropin.adapters.VaultedPaymentMethodsAdapter;
import com.braintreepayments.api.dropin.interfaces.AnimationFinishedListener;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.exceptions.AuthenticationException;
import com.braintreepayments.api.exceptions.AuthorizationException;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.exceptions.DownForMaintenanceException;
import com.braintreepayments.api.exceptions.GoogleApiClientException;
import com.braintreepayments.api.exceptions.ServerException;
import com.braintreepayments.api.exceptions.UnexpectedException;
import com.braintreepayments.api.exceptions.UpgradeRequiredException;
import com.braintreepayments.api.googlepayment.R$style;
import com.braintreepayments.api.interfaces.BraintreeCancelListener;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.interfaces.PaymentMethodNoncesUpdatedListener;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.internal.ManifestValidator;
import com.braintreepayments.api.models.CardNonce;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.GooglePaymentCardNonce;
import com.braintreepayments.api.models.GooglePaymentRequest;
import com.braintreepayments.api.models.PayPalRequest;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class DropInActivity extends BaseActivity implements ConfigurationListener, BraintreeCancelListener, BraintreeErrorListener, PaymentMethodSelectedListener, PaymentMethodNoncesUpdatedListener, PaymentMethodNonceCreatedListener {
    public View mBottomSheet;
    public String mDeviceData;
    public ViewSwitcher mLoadingViewSwitcher;
    public boolean mPerformedThreeDSecureVerification;
    public boolean mSheetSlideDownPerformed;
    public boolean mSheetSlideUpPerformed;
    public ListView mSupportedPaymentMethodListView;
    public TextView mSupportedPaymentMethodsHeader;
    public Button mVaultManagerButton;
    public View mVaultedPaymentMethodsContainer;
    public RecyclerView mVaultedPaymentMethodsView;

    public final void fetchPaymentMethodNonces(final boolean z) {
        if (this.mClientTokenPresent) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (!DropInActivity.this.isFinishing()) {
                        DropInActivity dropInActivity = DropInActivity.this;
                        BraintreeFragment braintreeFragment = dropInActivity.mBraintreeFragment;
                        if (!braintreeFragment.mHasFetchedPaymentMethodNonces || z) {
                            BraintreeFragment braintreeFragment2 = DropInActivity.this.mBraintreeFragment;
                            PaymentMethod$1 paymentMethod$1 = new PaymentMethod$1(braintreeFragment2, Uri.parse(k.versionedPath("payment_methods")).buildUpon().appendQueryParameter("default_first", String.valueOf(true)).appendQueryParameter("session_id", braintreeFragment2.mSessionId).build());
                            braintreeFragment2.fetchConfiguration();
                            braintreeFragment2.postOrQueueCallback(new QueuedCallback(paymentMethod$1) {
                                public void run() {
                                    r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
                                }

                                public boolean shouldRun() {
                                    BraintreeFragment braintreeFragment = BraintreeFragment.this;
                                    return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
                                }
                            });
                            return;
                        }
                        dropInActivity.onPaymentMethodNoncesUpdated(Collections.unmodifiableList(braintreeFragment.mCachedPaymentMethodNonces));
                    }
                }
            }, (long) getResources().getInteger(17694720));
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(17432576, 17432577);
    }

    public void onActivityResult(int i, final int i2, final Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            if (i == 1) {
                this.mLoadingViewSwitcher.setDisplayedChild(0);
                fetchPaymentMethodNonces(true);
            }
            this.mLoadingViewSwitcher.setDisplayedChild(1);
        } else if (i == 1) {
            if (i2 == -1) {
                this.mLoadingViewSwitcher.setDisplayedChild(0);
                DropInResult dropInResult = (DropInResult) intent.getParcelableExtra("com.braintreepayments.api.dropin.EXTRA_DROP_IN_RESULT");
                DropInResult.setLastUsedPaymentMethodType(this, dropInResult.mPaymentMethodNonce);
                dropInResult.mDeviceData = this.mDeviceData;
                intent = new Intent().putExtra("com.braintreepayments.api.dropin.EXTRA_DROP_IN_RESULT", dropInResult);
            }
            slideDown(new AnimationFinishedListener() {
                public void onAnimationFinished() {
                    DropInActivity.this.setResult(i2, intent);
                    DropInActivity.this.finish();
                }
            });
        } else if (i == 2) {
            if (i2 == -1) {
                this.mLoadingViewSwitcher.setDisplayedChild(0);
                if (intent != null) {
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCES");
                    if (parcelableArrayListExtra != null) {
                        onPaymentMethodNoncesUpdated(parcelableArrayListExtra);
                    }
                }
                fetchPaymentMethodNonces(true);
            }
            this.mLoadingViewSwitcher.setDisplayedChild(1);
        }
    }

    public void onBackPressed() {
        if (!this.mSheetSlideDownPerformed) {
            this.mSheetSlideDownPerformed = true;
            this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.canceled");
            slideDown(new AnimationFinishedListener() {
                public void onAnimationFinished() {
                    DropInActivity.this.finish();
                }
            });
        }
    }

    public void onBackgroundClicked(View view) {
        onBackPressed();
    }

    public void onCancel(int i) {
        if (this.mPerformedThreeDSecureVerification) {
            this.mPerformedThreeDSecureVerification = false;
            fetchPaymentMethodNonces(true);
        }
        this.mLoadingViewSwitcher.setDisplayedChild(1);
    }

    public void onConfigurationFetched(Configuration configuration) {
        this.mConfiguration = configuration;
        if (this.mDropInRequest.mCollectDeviceData && TextUtils.isEmpty(this.mDeviceData)) {
            BraintreeFragment braintreeFragment = this.mBraintreeFragment;
            DataCollector$1 dataCollector$1 = new DataCollector$1(braintreeFragment, null, new BraintreeResponseListener<String>() {
                public void onResponse(Object obj) {
                    DropInActivity.this.mDeviceData = (String) obj;
                }
            });
            braintreeFragment.fetchConfiguration();
            braintreeFragment.postOrQueueCallback(new QueuedCallback(dataCollector$1) {
                public void run() {
                    r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
                }

                public boolean shouldRun() {
                    BraintreeFragment braintreeFragment = BraintreeFragment.this;
                    return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
                }
            });
        }
        if (this.mDropInRequest.mGooglePaymentEnabled) {
            k.isReadyToPay(this.mBraintreeFragment, null, new BraintreeResponseListener<Boolean>() {
                public void onResponse(Object obj) {
                    DropInActivity.this.showSupportedPaymentMethods(((Boolean) obj).booleanValue());
                }
            });
        } else {
            showSupportedPaymentMethods(false);
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1476138204, bundle);
    }

    public void onError(final Exception exc) {
        if (this.mPerformedThreeDSecureVerification) {
            this.mPerformedThreeDSecureVerification = false;
            fetchPaymentMethodNonces(true);
        }
        if (exc instanceof GoogleApiClientException) {
            showSupportedPaymentMethods(false);
        } else {
            slideDown(new AnimationFinishedListener() {
                public void onAnimationFinished() {
                    Exception exc = exc;
                    if ((exc instanceof AuthenticationException) || (exc instanceof AuthorizationException) || (exc instanceof UpgradeRequiredException)) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.developer-error");
                    } else if (exc instanceof ConfigurationException) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.configuration-exception");
                    } else if ((exc instanceof ServerException) || (exc instanceof UnexpectedException)) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.server-error");
                    } else if (exc instanceof DownForMaintenanceException) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.server-unavailable");
                    } else {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.sdk-error");
                    }
                    DropInActivity.this.finish(exc);
                }
            });
        }
    }

    public void onPaymentMethodNonceCreated(final PaymentMethodNonce paymentMethodNonce) {
        boolean z;
        if (!this.mPerformedThreeDSecureVerification) {
            if (paymentMethodNonce instanceof CardNonce) {
                z = true;
            } else {
                z = paymentMethodNonce instanceof GooglePaymentCardNonce ? !((GooglePaymentCardNonce) paymentMethodNonce).mIsNetworkTokenized.booleanValue() : false;
            }
            if (z && shouldRequestThreeDSecureVerification()) {
                this.mPerformedThreeDSecureVerification = true;
                this.mLoadingViewSwitcher.setDisplayedChild(0);
                if (this.mDropInRequest.mThreeDSecureRequest == null) {
                    ThreeDSecureRequest threeDSecureRequest = new ThreeDSecureRequest();
                    DropInRequest dropInRequest = this.mDropInRequest;
                    threeDSecureRequest.mAmount = dropInRequest.mAmount;
                    dropInRequest.mThreeDSecureRequest = threeDSecureRequest;
                }
                DropInRequest dropInRequest2 = this.mDropInRequest;
                ThreeDSecureRequest threeDSecureRequest2 = dropInRequest2.mThreeDSecureRequest;
                if (threeDSecureRequest2.mAmount == null) {
                    String str = dropInRequest2.mAmount;
                    if (str != null) {
                        threeDSecureRequest2.mAmount = str;
                    }
                }
                ThreeDSecureRequest threeDSecureRequest3 = this.mDropInRequest.mThreeDSecureRequest;
                threeDSecureRequest3.mNonce = paymentMethodNonce.mNonce;
                BraintreeFragment braintreeFragment = this.mBraintreeFragment;
                k.performVerification(braintreeFragment, threeDSecureRequest3, new ThreeDSecure$3(braintreeFragment));
                return;
            }
        }
        slideDown(new AnimationFinishedListener() {
            public void onAnimationFinished() {
                DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.success");
                DropInResult.setLastUsedPaymentMethodType(DropInActivity.this, paymentMethodNonce);
                DropInActivity dropInActivity = DropInActivity.this;
                dropInActivity.finish(paymentMethodNonce, dropInActivity.mDeviceData);
            }
        });
    }

    public void onPaymentMethodNoncesUpdated(List<PaymentMethodNonce> list) {
        if (list.size() > 0) {
            this.mSupportedPaymentMethodsHeader.setText(R$string.bt_other);
            this.mVaultedPaymentMethodsContainer.setVisibility(0);
            this.mVaultedPaymentMethodsView.setAdapter(new VaultedPaymentMethodsAdapter(new PaymentMethodNonceCreatedListener() {
                public void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
                    if (paymentMethodNonce instanceof CardNonce) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("vaulted-card.select");
                    }
                    DropInActivity.this.onPaymentMethodNonceCreated(paymentMethodNonce);
                }
            }, list));
            if (this.mDropInRequest.mVaultManagerEnabled) {
                this.mVaultManagerButton.setVisibility(0);
            }
            for (PaymentMethodNonce paymentMethodNonce : list) {
                if (paymentMethodNonce instanceof CardNonce) {
                    this.mBraintreeFragment.sendAnalyticsEvent("vaulted-card.appear");
                    return;
                }
            }
            return;
        }
        this.mSupportedPaymentMethodsHeader.setText(R$string.bt_select_payment_method);
        this.mVaultedPaymentMethodsContainer.setVisibility(8);
    }

    public void onPaymentMethodSelected(PaymentMethodType paymentMethodType) {
        boolean z = false;
        this.mLoadingViewSwitcher.setDisplayedChild(0);
        int ordinal = paymentMethodType.ordinal();
        if (ordinal == 1) {
            BraintreeFragment braintreeFragment = this.mBraintreeFragment;
            GooglePaymentRequest googlePaymentRequest = this.mDropInRequest.mGooglePaymentRequest;
            braintreeFragment.sendAnalyticsEvent("google-payment.selected");
            ActivityInfo activityInfo = ManifestValidator.getActivityInfo(braintreeFragment.mContext, GooglePaymentActivity.class);
            if (activityInfo != null && activityInfo.getThemeResource() == R$style.bt_transparent_activity) {
                z = true;
            }
            if (!z) {
                braintreeFragment.postOrQueueCallback(new QueuedCallback(new BraintreeException("GooglePaymentActivity was not found in the Android manifest, or did not have a theme of R.style.bt_transparent_activity")) {
                    public void run() {
                        BraintreeFragment.this.mErrorListener.onError(exc);
                    }

                    public boolean shouldRun() {
                        return BraintreeFragment.this.mErrorListener != null;
                    }
                });
                braintreeFragment.sendAnalyticsEvent("google-payment.failed");
            } else if (googlePaymentRequest == null) {
                braintreeFragment.postOrQueueCallback(new QueuedCallback(new BraintreeException("Cannot pass null GooglePaymentRequest to requestPayment")) {
                    public void run() {
                        BraintreeFragment.this.mErrorListener.onError(exc);
                    }

                    public boolean shouldRun() {
                        return BraintreeFragment.this.mErrorListener != null;
                    }
                });
                braintreeFragment.sendAnalyticsEvent("google-payment.failed");
            } else if (googlePaymentRequest.mTransactionInfo == null) {
                braintreeFragment.postOrQueueCallback(new QueuedCallback(new BraintreeException("Cannot pass null TransactionInfo to requestPayment")) {
                    public void run() {
                        BraintreeFragment.this.mErrorListener.onError(exc);
                    }

                    public boolean shouldRun() {
                        return BraintreeFragment.this.mErrorListener != null;
                    }
                });
                braintreeFragment.sendAnalyticsEvent("google-payment.failed");
            } else {
                GooglePayment$3 googlePayment$3 = new GooglePayment$3(braintreeFragment, googlePaymentRequest);
                braintreeFragment.fetchConfiguration();
                braintreeFragment.postOrQueueCallback(new QueuedCallback(googlePayment$3) {
                    public void run() {
                        r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
                    }

                    public boolean shouldRun() {
                        BraintreeFragment braintreeFragment = BraintreeFragment.this;
                        return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
                    }
                });
            }
        } else if (ordinal == 7) {
            PayPalRequest payPalRequest = this.mDropInRequest.mPayPalRequest;
            if (payPalRequest == null) {
                payPalRequest = new PayPalRequest();
            }
            if (payPalRequest.mAmount != null) {
                k.requestOneTimePayment(this.mBraintreeFragment, payPalRequest);
            } else {
                k.requestBillingAgreement(this.mBraintreeFragment, payPalRequest);
            }
        } else if (ordinal == 9) {
            BraintreeFragment braintreeFragment2 = this.mBraintreeFragment;
            Venmo$1 venmo$1 = new Venmo$1(braintreeFragment2, null, false);
            braintreeFragment2.fetchConfiguration();
            braintreeFragment2.postOrQueueCallback(new QueuedCallback(venmo$1) {
                public void run() {
                    r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
                }

                public boolean shouldRun() {
                    BraintreeFragment braintreeFragment = BraintreeFragment.this;
                    return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
                }
            });
        } else if (ordinal == 13) {
            startActivityForResult(new Intent(this, AddCardActivity.class).putExtra("com.braintreepayments.api.EXTRA_CHECKOUT_REQUEST", this.mDropInRequest), 1);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.braintreepayments.api.EXTRA_SHEET_SLIDE_UP_PERFORMED", this.mSheetSlideUpPerformed);
        bundle.putString("com.braintreepayments.api.EXTRA_DEVICE_DATA", this.mDeviceData);
    }

    public void onVaultEditButtonClick(View view) {
        startActivityForResult(new Intent(this, VaultManagerActivity.class).putExtra("com.braintreepayments.api.EXTRA_CHECKOUT_REQUEST", this.mDropInRequest).putParcelableArrayListExtra("com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCES", new ArrayList(Collections.unmodifiableList(this.mBraintreeFragment.mCachedPaymentMethodNonces))), 2);
        this.mBraintreeFragment.sendAnalyticsEvent("manager.appeared");
    }

    public final void showSupportedPaymentMethods(boolean z) {
        SupportedPaymentMethodsAdapter supportedPaymentMethodsAdapter = new SupportedPaymentMethodsAdapter(this, this);
        Configuration configuration = this.mConfiguration;
        DropInRequest dropInRequest = this.mDropInRequest;
        boolean z2 = this.mClientTokenPresent;
        if (dropInRequest.mPayPalEnabled && configuration.mPaypalEnabled) {
            supportedPaymentMethodsAdapter.mAvailablePaymentMethods.add(PaymentMethodType.PAYPAL);
        }
        if (dropInRequest.mVenmoEnabled) {
            if ((TextUtils.isEmpty(configuration.mVenmoConfiguration.mAccessToken) ^ true) && k.isVenmoInstalled(supportedPaymentMethodsAdapter.mContext)) {
                supportedPaymentMethodsAdapter.mAvailablePaymentMethods.add(PaymentMethodType.PAY_WITH_VENMO);
            }
        }
        if (dropInRequest.mCardEnabled) {
            HashSet hashSet = new HashSet(configuration.mCardConfiguration.getSupportedCardTypes());
            if (!z2) {
                hashSet.remove(PaymentMethodType.UNIONPAY.getCanonicalName());
            }
            if (hashSet.size() > 0) {
                supportedPaymentMethodsAdapter.mAvailablePaymentMethods.add(PaymentMethodType.UNKNOWN);
            }
        }
        if (z && dropInRequest.mGooglePaymentEnabled) {
            supportedPaymentMethodsAdapter.mAvailablePaymentMethods.add(PaymentMethodType.GOOGLE_PAYMENT);
        }
        this.mSupportedPaymentMethodListView.setAdapter(supportedPaymentMethodsAdapter);
        this.mLoadingViewSwitcher.setDisplayedChild(1);
        fetchPaymentMethodNonces(false);
    }

    public final void slideDown(final AnimationFinishedListener animationFinishedListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.bt_slide_out_down);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                animationFinishedListener.onAnimationFinished();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.mBottomSheet.startAnimation(loadAnimation);
    }
}
