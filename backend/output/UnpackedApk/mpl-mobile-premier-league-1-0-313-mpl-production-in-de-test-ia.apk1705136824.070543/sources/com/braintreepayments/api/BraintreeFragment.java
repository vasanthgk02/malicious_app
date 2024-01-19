package com.braintreepayments.api;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.interfaces.AmericanExpressListener;
import com.braintreepayments.api.interfaces.BraintreeCancelListener;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.BraintreeListener;
import com.braintreepayments.api.interfaces.BraintreePaymentResultListener;
import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceDeletedListener;
import com.braintreepayments.api.interfaces.PaymentMethodNoncesUpdatedListener;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.interfaces.UnionPayListener;
import com.braintreepayments.api.internal.AnalyticsDatabase;
import com.braintreepayments.api.internal.AnalyticsDatabase.DatabaseTask;
import com.braintreepayments.api.internal.AnalyticsEvent;
import com.braintreepayments.api.internal.AnalyticsIntentService;
import com.braintreepayments.api.internal.BraintreeGraphQLHttpClient;
import com.braintreepayments.api.internal.BraintreeHttpClient;
import com.braintreepayments.api.models.Authorization;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.TokenizationKey;
import com.braintreepayments.browserswitch.BrowserSwitchFragment;
import com.braintreepayments.browserswitch.BrowserSwitchResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import org.json.JSONException;

public class BraintreeFragment extends BrowserSwitchFragment {
    public AmericanExpressListener mAmericanExpressListener;
    public AnalyticsDatabase mAnalyticsDatabase;
    public Authorization mAuthorization;
    public BraintreePaymentResultListener mBraintreePaymentResultListener;
    public final List<PaymentMethodNonce> mCachedPaymentMethodNonces = new ArrayList();
    public final Queue<QueuedCallback> mCallbackQueue = new ArrayDeque();
    public BraintreeCancelListener mCancelListener;
    public Configuration mConfiguration;
    public BraintreeResponseListener<Exception> mConfigurationErrorListener;
    public ConfigurationListener mConfigurationListener;
    public int mConfigurationRequestAttempts = 0;
    public Context mContext;
    public CrashReporter mCrashReporter;
    public BraintreeErrorListener mErrorListener;
    public GoogleApiClient mGoogleApiClient;
    public BraintreeGraphQLHttpClient mGraphQLHttpClient;
    public boolean mHasFetchedPaymentMethodNonces = false;
    public BraintreeHttpClient mHttpClient;
    public String mIntegrationType;
    public boolean mNewActivityNeedsConfiguration;
    public PaymentMethodNonceCreatedListener mPaymentMethodNonceCreatedListener;
    public PaymentMethodNonceDeletedListener mPaymentMethodNonceDeletedListener;
    public PaymentMethodNoncesUpdatedListener mPaymentMethodNoncesUpdatedListener;
    public String mReturnUrlScheme;
    public String mSessionId;
    public UnionPayListener mUnionPayListener;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:28|29|30|31|32|33) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0083 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077 A[SYNTHETIC, Splitter:B:28:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092 A[SYNTHETIC, Splitter:B:34:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.braintreepayments.api.BraintreeFragment newInstance(androidx.appcompat.app.AppCompatActivity r5, java.lang.String r6) throws com.braintreepayments.api.exceptions.InvalidArgumentException {
        /*
            if (r5 == 0) goto L_0x00cb
            androidx.fragment.app.FragmentManager r0 = r5.getSupportFragmentManager()
            if (r0 == 0) goto L_0x00c3
            if (r6 == 0) goto L_0x00bb
            java.lang.String r1 = "BraintreeFragment."
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            byte[] r2 = r6.getBytes()
            java.util.UUID r2 = java.util.UUID.nameUUIDFromBytes(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            androidx.fragment.app.Fragment r2 = r0.findFragmentByTag(r1)
            if (r2 == 0) goto L_0x002d
            androidx.fragment.app.Fragment r5 = r0.findFragmentByTag(r1)
            com.braintreepayments.api.BraintreeFragment r5 = (com.braintreepayments.api.BraintreeFragment) r5
            goto L_0x00a7
        L_0x002d:
            com.braintreepayments.api.BraintreeFragment r2 = new com.braintreepayments.api.BraintreeFragment
            r2.<init>()
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            com.braintreepayments.api.models.Authorization r6 = com.braintreepayments.api.models.Authorization.fromString(r6)     // Catch:{ InvalidArgumentException -> 0x00b3 }
            java.lang.String r4 = "com.braintreepayments.api.EXTRA_AUTHORIZATION_TOKEN"
            r3.putParcelable(r4, r6)     // Catch:{ InvalidArgumentException -> 0x00b3 }
            java.lang.String r6 = com.braintreepayments.api.internal.ManifestValidator.getFormattedUUID()
            java.lang.String r4 = "com.braintreepayments.api.EXTRA_SESSION_ID"
            r3.putString(r4, r6)
            java.lang.String r6 = "com.braintreepayments.api.BraintreePaymentActivity"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0058 }
            boolean r6 = r6.isInstance(r5)     // Catch:{ ClassNotFoundException -> 0x0058 }
            if (r6 == 0) goto L_0x0058
            java.lang.String r6 = "dropin"
            goto L_0x0069
        L_0x0058:
            java.lang.String r6 = "com.braintreepayments.api.dropin.DropInActivity"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0067 }
            boolean r6 = r6.isInstance(r5)     // Catch:{ ClassNotFoundException -> 0x0067 }
            if (r6 == 0) goto L_0x0067
            java.lang.String r6 = "dropin2"
            goto L_0x0069
        L_0x0067:
            java.lang.String r6 = "custom"
        L_0x0069:
            java.lang.String r4 = "com.braintreepayments.api.EXTRA_INTEGRATION_TYPE"
            r3.putString(r4, r6)
            r2.setArguments(r3)
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalStateException -> 0x00a8 }
            r3 = 24
            if (r6 < r3) goto L_0x0092
            androidx.fragment.app.FragmentTransaction r6 = r0.beginTransaction()     // Catch:{ IllegalStateException | NullPointerException -> 0x0083 }
            androidx.fragment.app.FragmentTransaction r6 = r6.add(r2, r1)     // Catch:{ IllegalStateException | NullPointerException -> 0x0083 }
            r6.commitNow()     // Catch:{ IllegalStateException | NullPointerException -> 0x0083 }
            goto L_0x00a0
        L_0x0083:
            androidx.fragment.app.FragmentTransaction r6 = r0.beginTransaction()     // Catch:{ IllegalStateException -> 0x00a8 }
            androidx.fragment.app.FragmentTransaction r6 = r6.add(r2, r1)     // Catch:{ IllegalStateException -> 0x00a8 }
            r6.commit()     // Catch:{ IllegalStateException -> 0x00a8 }
            r0.executePendingTransactions()     // Catch:{ IllegalStateException -> 0x00a0 }
            goto L_0x00a0
        L_0x0092:
            androidx.fragment.app.FragmentTransaction r6 = r0.beginTransaction()     // Catch:{ IllegalStateException -> 0x00a8 }
            androidx.fragment.app.FragmentTransaction r6 = r6.add(r2, r1)     // Catch:{ IllegalStateException -> 0x00a8 }
            r6.commit()     // Catch:{ IllegalStateException -> 0x00a8 }
            r0.executePendingTransactions()     // Catch:{ IllegalStateException -> 0x00a0 }
        L_0x00a0:
            android.content.Context r5 = r5.getApplicationContext()
            r2.mContext = r5
            r5 = r2
        L_0x00a7:
            return r5
        L_0x00a8:
            r5 = move-exception
            com.braintreepayments.api.exceptions.InvalidArgumentException r6 = new com.braintreepayments.api.exceptions.InvalidArgumentException
            java.lang.String r5 = r5.getMessage()
            r6.<init>(r5)
            throw r6
        L_0x00b3:
            com.braintreepayments.api.exceptions.InvalidArgumentException r5 = new com.braintreepayments.api.exceptions.InvalidArgumentException
            java.lang.String r6 = "Tokenization Key or client token was invalid."
            r5.<init>(r6)
            throw r5
        L_0x00bb:
            com.braintreepayments.api.exceptions.InvalidArgumentException r5 = new com.braintreepayments.api.exceptions.InvalidArgumentException
            java.lang.String r6 = "Tokenization Key or Client Token is null."
            r5.<init>(r6)
            throw r5
        L_0x00c3:
            com.braintreepayments.api.exceptions.InvalidArgumentException r5 = new com.braintreepayments.api.exceptions.InvalidArgumentException
            java.lang.String r6 = "FragmentManager is null"
            r5.<init>(r6)
            throw r5
        L_0x00cb:
            com.braintreepayments.api.exceptions.InvalidArgumentException r5 = new com.braintreepayments.api.exceptions.InvalidArgumentException
            java.lang.String r6 = "Activity is null"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.BraintreeFragment.newInstance(androidx.appcompat.app.AppCompatActivity, java.lang.String):com.braintreepayments.api.BraintreeFragment");
    }

    public <T extends BraintreeListener> void addListener(T t) {
        if (t instanceof ConfigurationListener) {
            this.mConfigurationListener = (ConfigurationListener) t;
        }
        if (t instanceof BraintreeCancelListener) {
            this.mCancelListener = (BraintreeCancelListener) t;
        }
        if (t instanceof PaymentMethodNoncesUpdatedListener) {
            this.mPaymentMethodNoncesUpdatedListener = (PaymentMethodNoncesUpdatedListener) t;
        }
        if (t instanceof PaymentMethodNonceCreatedListener) {
            this.mPaymentMethodNonceCreatedListener = (PaymentMethodNonceCreatedListener) t;
        }
        if (t instanceof PaymentMethodNonceDeletedListener) {
            this.mPaymentMethodNonceDeletedListener = (PaymentMethodNonceDeletedListener) t;
        }
        if (t instanceof BraintreePaymentResultListener) {
            this.mBraintreePaymentResultListener = (BraintreePaymentResultListener) t;
        }
        if (t instanceof BraintreeErrorListener) {
            this.mErrorListener = (BraintreeErrorListener) t;
        }
        if (t instanceof UnionPayListener) {
            this.mUnionPayListener = (UnionPayListener) t;
        }
        if (t instanceof AmericanExpressListener) {
            this.mAmericanExpressListener = (AmericanExpressListener) t;
        }
        flushCallbacks();
    }

    public void fetchConfiguration() {
        if (this.mConfiguration == null && !ConfigurationManager.sFetchingConfiguration && this.mAuthorization != null && this.mHttpClient != null) {
            int i = this.mConfigurationRequestAttempts;
            if (i >= 3) {
                final ConfigurationException configurationException = new ConfigurationException("Configuration retry limit has been exceeded. Create a new BraintreeFragment and try again.");
                postOrQueueCallback(new QueuedCallback() {
                    public void run() {
                        BraintreeFragment.this.mErrorListener.onError(r2);
                    }

                    public boolean shouldRun() {
                        return BraintreeFragment.this.mErrorListener != null;
                    }
                });
                return;
            }
            this.mConfigurationRequestAttempts = i + 1;
            AnonymousClass12 r0 = new ConfigurationListener() {
                public void onConfigurationFetched(Configuration configuration) {
                    BraintreeFragment.this.setConfiguration(configuration);
                    BraintreeFragment braintreeFragment = BraintreeFragment.this;
                    braintreeFragment.postOrQueueCallback(new QueuedCallback() {
                        public void run() {
                            BraintreeFragment braintreeFragment = BraintreeFragment.this;
                            braintreeFragment.mConfigurationListener.onConfigurationFetched(braintreeFragment.mConfiguration);
                        }

                        public boolean shouldRun() {
                            return BraintreeFragment.this.mConfigurationListener != null;
                        }
                    });
                    BraintreeFragment.this.flushCallbacks();
                }
            };
            AnonymousClass13 r2 = new BraintreeResponseListener<Exception>() {
                public void onResponse(Object obj) {
                    Exception exc = (Exception) obj;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Request for configuration has failed: ");
                    outline73.append(exc.getMessage());
                    outline73.append(". Future requests will retry up to 3 times");
                    final ConfigurationException configurationException = new ConfigurationException(outline73.toString(), exc);
                    BraintreeFragment.this.postCallback(configurationException);
                    BraintreeFragment.this.postOrQueueCallback(new QueuedCallback() {
                        public void run() {
                            BraintreeFragment.this.mConfigurationErrorListener.onResponse(configurationException);
                        }

                        public boolean shouldRun() {
                            return BraintreeFragment.this.mConfigurationErrorListener != null;
                        }
                    });
                    BraintreeFragment.this.flushCallbacks();
                }
            };
            String uri = Uri.parse(this.mAuthorization.getConfigUrl()).buildUpon().appendQueryParameter("configVersion", "3").build().toString();
            Context context = this.mContext;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(uri);
            outline73.append(this.mAuthorization.getBearer());
            String sb = outline73.toString();
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("BraintreeApi", 0);
            String encodeToString = Base64.encodeToString(sb.getBytes(), 0);
            Configuration configuration = null;
            if (System.currentTimeMillis() - sharedPreferences.getLong(GeneratedOutlineSupport.outline50(encodeToString, "_timestamp"), 0) <= ConfigurationManager.TTL) {
                try {
                    configuration = new Configuration(sharedPreferences.getString(encodeToString, ""));
                } catch (JSONException unused) {
                }
            }
            if (configuration != null) {
                r0.onConfigurationFetched(configuration);
            } else {
                ConfigurationManager.sFetchingConfiguration = true;
                this.mHttpClient.get(uri, new HttpResponseCallback(uri, r0, r2) {
                    public final /* synthetic */ String val$configUrl;
                    public final /* synthetic */ BraintreeResponseListener val$errorListener;
                    public final /* synthetic */ ConfigurationListener val$listener;

                    {
                        this.val$configUrl = r2;
                        this.val$listener = r3;
                        this.val$errorListener = r4;
                    }

                    public void failure(Exception exc) {
                        ConfigurationManager.sFetchingConfiguration = false;
                        this.val$errorListener.onResponse(exc);
                    }

                    public void success(String str) {
                        try {
                            Configuration configuration = new Configuration(str);
                            Context context = BraintreeFragment.this.mContext;
                            ConfigurationManager.access$000(context, this.val$configUrl + BraintreeFragment.this.mAuthorization.getBearer(), configuration);
                            ConfigurationManager.sFetchingConfiguration = false;
                            this.val$listener.onConfigurationFetched(configuration);
                        } catch (JSONException e2) {
                            ConfigurationManager.sFetchingConfiguration = false;
                            this.val$errorListener.onResponse(e2);
                        }
                    }
                });
            }
        }
    }

    public void flushCallbacks() {
        synchronized (this.mCallbackQueue) {
            Iterator it = new ArrayDeque(this.mCallbackQueue).iterator();
            while (it.hasNext()) {
                QueuedCallback queuedCallback = (QueuedCallback) it.next();
                if (queuedCallback.shouldRun()) {
                    queuedCallback.run();
                    this.mCallbackQueue.remove(queuedCallback);
                }
            }
        }
    }

    public List<BraintreeListener> getListeners() {
        ArrayList arrayList = new ArrayList();
        ConfigurationListener configurationListener = this.mConfigurationListener;
        if (configurationListener != null) {
            arrayList.add(configurationListener);
        }
        BraintreeCancelListener braintreeCancelListener = this.mCancelListener;
        if (braintreeCancelListener != null) {
            arrayList.add(braintreeCancelListener);
        }
        PaymentMethodNoncesUpdatedListener paymentMethodNoncesUpdatedListener = this.mPaymentMethodNoncesUpdatedListener;
        if (paymentMethodNoncesUpdatedListener != null) {
            arrayList.add(paymentMethodNoncesUpdatedListener);
        }
        PaymentMethodNonceCreatedListener paymentMethodNonceCreatedListener = this.mPaymentMethodNonceCreatedListener;
        if (paymentMethodNonceCreatedListener != null) {
            arrayList.add(paymentMethodNonceCreatedListener);
        }
        PaymentMethodNonceDeletedListener paymentMethodNonceDeletedListener = this.mPaymentMethodNonceDeletedListener;
        if (paymentMethodNonceDeletedListener != null) {
            arrayList.add(paymentMethodNonceDeletedListener);
        }
        BraintreePaymentResultListener braintreePaymentResultListener = this.mBraintreePaymentResultListener;
        if (braintreePaymentResultListener != null) {
            arrayList.add(braintreePaymentResultListener);
        }
        BraintreeErrorListener braintreeErrorListener = this.mErrorListener;
        if (braintreeErrorListener != null) {
            arrayList.add(braintreeErrorListener);
        }
        UnionPayListener unionPayListener = this.mUnionPayListener;
        if (unionPayListener != null) {
            arrayList.add(unionPayListener);
        }
        AmericanExpressListener americanExpressListener = this.mAmericanExpressListener;
        if (americanExpressListener != null) {
            arrayList.add(americanExpressListener);
        }
        return arrayList;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0698, code lost:
        if (r8 != 5) goto L_0x06fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c1, code lost:
        r15.edit().remove("com.braintreepayments.api.PayPal.REQUEST_KEY").remove("com.braintreepayments.api.PayPal.REQUEST_TYPE_KEY").apply();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d0, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0494  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x04b7  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0700  */
    /* JADX WARNING: Removed duplicated region for block: B:260:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c0 A[ExcHandler: all (r0v97 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:16:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0214  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r25, int r26, android.content.Intent r27) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r0 = 3
            r5 = 13487(0x34af, float:1.89E-41)
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == r5) goto L_0x0624
            r5 = 13488(0x34b0, float:1.8901E-41)
            java.lang.String r9 = "BraintreeApi"
            if (r2 == r5) goto L_0x05c7
            java.lang.String r5 = "response"
            java.lang.String r10 = "client"
            java.lang.String r11 = "response_type"
            java.lang.String r12 = "webURL"
            java.lang.String r13 = "unknown"
            r14 = 13596(0x351c, float:1.9052E-41)
            if (r2 == r14) goto L_0x04e8
            java.lang.String r14 = ""
            r15 = 13597(0x351d, float:1.9053E-41)
            if (r2 == r15) goto L_0x0421
            switch(r2) {
                case 13591: goto L_0x005f;
                case 13592: goto L_0x0034;
                case 13593: goto L_0x0030;
                default: goto L_0x002d;
            }
        L_0x002d:
            r2 = r3
            goto L_0x06fe
        L_0x0030:
            co.hyperverge.hypersnapsdk.c.k.onActivityResult(r1, r3, r4)
            goto L_0x002d
        L_0x0034:
            java.lang.String r5 = "com.braintreepayments.api.VisaCheckout"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            java.lang.String r9 = "onActivityResult"
            java.lang.Class[] r10 = new java.lang.Class[r0]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            java.lang.Class<com.braintreepayments.api.BraintreeFragment> r11 = com.braintreepayments.api.BraintreeFragment.class
            r10[r8] = r11     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            r10[r7] = r11     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            java.lang.Class<android.content.Intent> r11 = android.content.Intent.class
            r10[r6] = r11     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r9, r10)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            r0[r8] = r1     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r26)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            r0[r7] = r8     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            r0[r6] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            r4 = 0
            r5.invoke(r4, r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException -> 0x002d }
            goto L_0x002d
        L_0x005f:
            android.content.Context r0 = r1.mContext
            java.lang.String r6 = "com.braintreepayments.api.PayPal.REQUEST_TYPE_KEY"
            java.lang.String r7 = "com.braintreepayments.api.PayPal.REQUEST_KEY"
            android.content.Context r0 = r0.getApplicationContext()
            android.content.SharedPreferences r15 = r0.getSharedPreferences(r9, r8)
            java.lang.String r0 = r15.getString(r7, r14)     // Catch:{ Exception -> 0x00d1, all -> 0x00c0 }
            byte[] r0 = android.util.Base64.decode(r0, r8)     // Catch:{ Exception -> 0x00d1, all -> 0x00c0 }
            android.os.Parcel r8 = android.os.Parcel.obtain()     // Catch:{ Exception -> 0x00d1, all -> 0x00c0 }
            int r2 = r0.length     // Catch:{ Exception -> 0x00d1, all -> 0x00c0 }
            r16 = r13
            r13 = 0
            r8.unmarshall(r0, r13, r2)     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            r8.setDataPosition(r13)     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            java.lang.String r0 = r15.getString(r6, r14)     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            java.lang.Class<com.paypal.android.sdk.onetouch.core.BillingAgreementRequest> r2 = com.paypal.android.sdk.onetouch.core.BillingAgreementRequest.class
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            boolean r2 = r2.equals(r0)     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            if (r2 == 0) goto L_0x009c
            android.os.Parcelable$Creator<com.paypal.android.sdk.onetouch.core.BillingAgreementRequest> r0 = com.paypal.android.sdk.onetouch.core.BillingAgreementRequest.CREATOR     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            java.lang.Object r0 = r0.createFromParcel(r8)     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            com.paypal.android.sdk.onetouch.core.Request r0 = (com.paypal.android.sdk.onetouch.core.Request) r0     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            goto L_0x00b0
        L_0x009c:
            java.lang.Class<com.paypal.android.sdk.onetouch.core.CheckoutRequest> r2 = com.paypal.android.sdk.onetouch.core.CheckoutRequest.class
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            if (r0 == 0) goto L_0x00d3
            android.os.Parcelable$Creator<com.paypal.android.sdk.onetouch.core.CheckoutRequest> r0 = com.paypal.android.sdk.onetouch.core.CheckoutRequest.CREATOR     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            java.lang.Object r0 = r0.createFromParcel(r8)     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
            com.paypal.android.sdk.onetouch.core.Request r0 = (com.paypal.android.sdk.onetouch.core.Request) r0     // Catch:{ Exception -> 0x00d3, all -> 0x00c0 }
        L_0x00b0:
            android.content.SharedPreferences$Editor r2 = r15.edit()
            android.content.SharedPreferences$Editor r2 = r2.remove(r7)
            android.content.SharedPreferences$Editor r2 = r2.remove(r6)
            r2.apply()
            goto L_0x00e3
        L_0x00c0:
            r0 = move-exception
            android.content.SharedPreferences$Editor r2 = r15.edit()
            android.content.SharedPreferences$Editor r2 = r2.remove(r7)
            android.content.SharedPreferences$Editor r2 = r2.remove(r6)
            r2.apply()
            throw r0
        L_0x00d1:
            r16 = r13
        L_0x00d3:
            android.content.SharedPreferences$Editor r0 = r15.edit()
            android.content.SharedPreferences$Editor r0 = r0.remove(r7)
            android.content.SharedPreferences$Editor r0 = r0.remove(r6)
            r0.apply()
            r0 = 0
        L_0x00e3:
            r2 = r0
            boolean r0 = r2 instanceof com.paypal.android.sdk.onetouch.core.BillingAgreementRequest
            if (r0 == 0) goto L_0x00ec
            java.lang.String r0 = "paypal.billing-agreement"
            goto L_0x00f5
        L_0x00ec:
            boolean r0 = r2 instanceof com.paypal.android.sdk.onetouch.core.CheckoutRequest
            if (r0 == 0) goto L_0x00f3
            java.lang.String r0 = "paypal.single-payment"
            goto L_0x00f5
        L_0x00f3:
            java.lang.String r0 = "paypal.unknown"
        L_0x00f5:
            if (r4 == 0) goto L_0x010d
            android.net.Uri r6 = r27.getData()
            if (r6 != 0) goto L_0x010a
            java.lang.String r6 = "com.braintreepayments.api.WAS_BROWSER_SWITCH_RESULT"
            r7 = 0
            boolean r6 = r4.getBooleanExtra(r6, r7)
            if (r6 == 0) goto L_0x0107
            goto L_0x010a
        L_0x0107:
            java.lang.String r13 = "app-switch"
            goto L_0x010f
        L_0x010a:
            java.lang.String r13 = "browser-switch"
            goto L_0x010f
        L_0x010d:
            r13 = r16
        L_0x010f:
            java.lang.String r6 = "."
            java.lang.String r6 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r0, r6, r13)
            java.lang.String r7 = ".canceled"
            r0 = -1
            if (r3 != r0) goto L_0x0403
            if (r4 == 0) goto L_0x0403
            if (r2 == 0) goto L_0x0403
            android.content.Context r0 = r1.mContext
            com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.initService(r0)
            android.net.Uri r8 = r27.getData()
            java.lang.String r13 = "environment"
            if (r8 == 0) goto L_0x01d0
            com.paypal.android.sdk.onetouch.core.base.ContextInspector r8 = com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.sContextInspector
            android.net.Uri r0 = r27.getData()
            r15 = r2
            com.paypal.android.sdk.onetouch.core.CheckoutRequest r15 = (com.paypal.android.sdk.onetouch.core.CheckoutRequest) r15
            java.lang.String r4 = r0.getLastPathSegment()
            java.lang.String r3 = r15.mSuccessUrl
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r3 = r3.getLastPathSegment()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x015c
            com.paypal.android.sdk.onetouch.core.Result r0 = new com.paypal.android.sdk.onetouch.core.Result
            com.paypal.android.sdk.onetouch.core.enums.ResultType r17 = com.paypal.android.sdk.onetouch.core.enums.ResultType.Cancel
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r16 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22)
            goto L_0x01a4
        L_0x015c:
            java.lang.String r3 = r15.mApprovalUrl
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r4 = r15.mTokenQueryParamKey
            java.lang.String r3 = r3.getQueryParameter(r4)
            java.lang.String r4 = r15.mTokenQueryParamKey
            java.lang.String r4 = r0.getQueryParameter(r4)
            if (r4 == 0) goto L_0x0198
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L_0x0198
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x018b }
            r3.<init>()     // Catch:{ JSONException -> 0x018b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x018b }
            r3.put(r12, r0)     // Catch:{ JSONException -> 0x018b }
            com.paypal.android.sdk.onetouch.core.Result r0 = new com.paypal.android.sdk.onetouch.core.Result     // Catch:{ JSONException -> 0x018b }
            com.paypal.android.sdk.onetouch.core.enums.ResponseType r4 = com.paypal.android.sdk.onetouch.core.enums.ResponseType.web     // Catch:{ JSONException -> 0x018b }
            r12 = 0
            r0.<init>(r12, r4, r3, r12)     // Catch:{ JSONException -> 0x018b }
            goto L_0x01a4
        L_0x018b:
            r0 = move-exception
            com.paypal.android.sdk.onetouch.core.Result r3 = new com.paypal.android.sdk.onetouch.core.Result
            com.paypal.android.sdk.onetouch.core.exception.ResponseParsingException r4 = new com.paypal.android.sdk.onetouch.core.exception.ResponseParsingException
            r4.<init>(r0)
            r3.<init>(r4)
            r0 = r3
            goto L_0x01a4
        L_0x0198:
            com.paypal.android.sdk.onetouch.core.Result r0 = new com.paypal.android.sdk.onetouch.core.Result
            com.paypal.android.sdk.onetouch.core.exception.BrowserSwitchException r3 = new com.paypal.android.sdk.onetouch.core.exception.BrowserSwitchException
            java.lang.String r4 = "The response contained inconsistent data."
            r3.<init>(r4)
            r0.<init>(r3)
        L_0x01a4:
            com.paypal.android.sdk.onetouch.core.enums.ResultType r3 = r0.mResultType
            int r3 = r3.ordinal()
            if (r3 == 0) goto L_0x01c7
            r4 = 1
            if (r3 == r4) goto L_0x01be
            r4 = 2
            if (r3 == r4) goto L_0x01b4
            goto L_0x0231
        L_0x01b4:
            android.content.Context r3 = r8.mContext
            com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r4 = com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint.Return
            r8 = 0
            r2.trackFpti(r3, r4, r8)
            goto L_0x0231
        L_0x01be:
            r3 = 0
            android.content.Context r4 = r8.mContext
            com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r8 = com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint.Error
            r2.trackFpti(r4, r8, r3)
            goto L_0x0231
        L_0x01c7:
            r3 = 0
            android.content.Context r4 = r8.mContext
            com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r8 = com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint.Cancel
            r2.trackFpti(r4, r8, r3)
            goto L_0x0231
        L_0x01d0:
            android.os.Bundle r3 = r27.getExtras()
            if (r3 == 0) goto L_0x02cf
            android.os.Bundle r3 = r27.getExtras()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x02cf
            com.paypal.android.sdk.onetouch.core.base.ContextInspector r0 = com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.sContextInspector
            android.os.Bundle r3 = r27.getExtras()
            r4 = r2
            com.paypal.android.sdk.onetouch.core.CheckoutRequest r4 = (com.paypal.android.sdk.onetouch.core.CheckoutRequest) r4
            java.lang.String r8 = r4.mApprovalUrl
            android.net.Uri r8 = android.net.Uri.parse(r8)
            java.lang.String r15 = r4.mTokenQueryParamKey
            java.lang.String r8 = r8.getQueryParameter(r15)
            java.lang.String r15 = r3.getString(r12)
            if (r15 == 0) goto L_0x020f
            android.net.Uri r15 = android.net.Uri.parse(r15)
            java.lang.String r4 = r4.mTokenQueryParamKey
            java.lang.String r4 = r15.getQueryParameter(r4)
            if (r4 == 0) goto L_0x020f
            boolean r4 = android.text.TextUtils.equals(r8, r4)
            if (r4 == 0) goto L_0x020f
            r4 = 1
            goto L_0x0210
        L_0x020f:
            r4 = 0
        L_0x0210:
            java.lang.String r8 = "error"
            if (r4 == 0) goto L_0x029b
            android.content.Context r0 = r0.mContext
            com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r4 = com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint.Return
            r15 = 0
            r2.trackFpti(r0, r4, r15)
            java.lang.String r0 = r3.getString(r8)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x0235
            com.paypal.android.sdk.onetouch.core.Result r3 = new com.paypal.android.sdk.onetouch.core.Result
            com.paypal.android.sdk.onetouch.core.exception.WalletSwitchException r4 = new com.paypal.android.sdk.onetouch.core.exception.WalletSwitchException
            r4.<init>(r0)
            r3.<init>(r4)
            r0 = r3
        L_0x0231:
            r16 = r7
            goto L_0x02ea
        L_0x0235:
            java.lang.String r0 = r3.getString(r13)
            java.lang.String r4 = r3.getString(r11)
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r4 = r4.toLowerCase(r8)
            java.lang.String r8 = "code"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x024e
            com.paypal.android.sdk.onetouch.core.enums.ResponseType r4 = com.paypal.android.sdk.onetouch.core.enums.ResponseType.authorization_code
            goto L_0x0250
        L_0x024e:
            com.paypal.android.sdk.onetouch.core.enums.ResponseType r4 = com.paypal.android.sdk.onetouch.core.enums.ResponseType.web
        L_0x0250:
            com.paypal.android.sdk.onetouch.core.enums.ResponseType r15 = com.paypal.android.sdk.onetouch.core.enums.ResponseType.web     // Catch:{ JSONException -> 0x028c }
            if (r15 != r4) goto L_0x026c
            java.lang.String r3 = r3.getString(r12)     // Catch:{ JSONException -> 0x028c }
            com.paypal.android.sdk.onetouch.core.Result r8 = new com.paypal.android.sdk.onetouch.core.Result     // Catch:{ JSONException -> 0x028c }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x028c }
            r15.<init>()     // Catch:{ JSONException -> 0x028c }
            org.json.JSONObject r3 = r15.put(r12, r3)     // Catch:{ JSONException -> 0x028c }
            r12 = 0
            r8.<init>(r0, r4, r3, r12)     // Catch:{ JSONException -> 0x028c }
            r16 = r7
            r0 = r8
            goto L_0x02ea
        L_0x026c:
            java.lang.String r12 = "authorization_code"
            java.lang.String r12 = r3.getString(r12)     // Catch:{ JSONException -> 0x028c }
            java.lang.String r15 = "email"
            java.lang.String r3 = r3.getString(r15)     // Catch:{ JSONException -> 0x028c }
            com.paypal.android.sdk.onetouch.core.Result r15 = new com.paypal.android.sdk.onetouch.core.Result     // Catch:{ JSONException -> 0x028c }
            r16 = r7
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x028a }
            r7.<init>()     // Catch:{ JSONException -> 0x028a }
            org.json.JSONObject r7 = r7.put(r8, r12)     // Catch:{ JSONException -> 0x028a }
            r15.<init>(r0, r4, r7, r3)     // Catch:{ JSONException -> 0x028a }
            r0 = r15
            goto L_0x02ea
        L_0x028a:
            r0 = move-exception
            goto L_0x028f
        L_0x028c:
            r0 = move-exception
            r16 = r7
        L_0x028f:
            com.paypal.android.sdk.onetouch.core.Result r3 = new com.paypal.android.sdk.onetouch.core.Result
            com.paypal.android.sdk.onetouch.core.exception.ResponseParsingException r4 = new com.paypal.android.sdk.onetouch.core.exception.ResponseParsingException
            r4.<init>(r0)
            r3.<init>(r4)
            r0 = r3
            goto L_0x02ea
        L_0x029b:
            r16 = r7
            boolean r4 = r3.containsKey(r8)
            if (r4 == 0) goto L_0x02ba
            android.content.Context r0 = r0.mContext
            com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r4 = com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint.Error
            r7 = 0
            r2.trackFpti(r0, r4, r7)
            com.paypal.android.sdk.onetouch.core.Result r0 = new com.paypal.android.sdk.onetouch.core.Result
            com.paypal.android.sdk.onetouch.core.exception.WalletSwitchException r4 = new com.paypal.android.sdk.onetouch.core.exception.WalletSwitchException
            java.lang.String r3 = r3.getString(r8)
            r4.<init>(r3)
            r0.<init>(r4)
            goto L_0x02ea
        L_0x02ba:
            r3 = 0
            android.content.Context r0 = r0.mContext
            com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r4 = com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint.Error
            r2.trackFpti(r0, r4, r3)
            com.paypal.android.sdk.onetouch.core.Result r0 = new com.paypal.android.sdk.onetouch.core.Result
            com.paypal.android.sdk.onetouch.core.exception.ResponseParsingException r3 = new com.paypal.android.sdk.onetouch.core.exception.ResponseParsingException
            java.lang.String r4 = "invalid wallet response"
            r3.<init>(r4)
            r0.<init>(r3)
            goto L_0x02ea
        L_0x02cf:
            r16 = r7
            r3 = 0
            com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r4 = com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint.Cancel
            r2.trackFpti(r0, r4, r3)
            com.paypal.android.sdk.onetouch.core.Result r0 = new com.paypal.android.sdk.onetouch.core.Result
            com.paypal.android.sdk.onetouch.core.enums.ResultType r18 = com.paypal.android.sdk.onetouch.core.enums.ResultType.Cancel
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r17 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23)
        L_0x02ea:
            com.paypal.android.sdk.onetouch.core.enums.ResultType r3 = r0.mResultType
            int r3 = r3.ordinal()
            if (r3 == 0) goto L_0x03e6
            r4 = 1
            if (r3 == r4) goto L_0x03be
            r4 = 2
            if (r3 == r4) goto L_0x02fa
            goto L_0x03ff
        L_0x02fa:
            android.content.Context r3 = r1.mContext
            java.lang.String r4 = "com.braintreepayments.api.PayPal.PAYPAL_REQUEST_KEY"
            android.content.Context r3 = r3.getApplicationContext()
            r7 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r9, r7)
            java.lang.String r8 = r3.getString(r4, r14)     // Catch:{ Exception -> 0x032b, all -> 0x0326 }
            byte[] r8 = android.util.Base64.decode(r8, r7)     // Catch:{ Exception -> 0x032b, all -> 0x0326 }
            android.os.Parcel r9 = android.os.Parcel.obtain()     // Catch:{ Exception -> 0x032b, all -> 0x0326 }
            int r12 = r8.length     // Catch:{ Exception -> 0x032b, all -> 0x0326 }
            r9.unmarshall(r8, r7, r12)     // Catch:{ Exception -> 0x032b, all -> 0x0326 }
            r9.setDataPosition(r7)     // Catch:{ Exception -> 0x032b, all -> 0x0326 }
            android.os.Parcelable$Creator<com.braintreepayments.api.models.PayPalRequest> r7 = com.braintreepayments.api.models.PayPalRequest.CREATOR     // Catch:{ Exception -> 0x032b, all -> 0x0326 }
            java.lang.Object r7 = r7.createFromParcel(r9)     // Catch:{ Exception -> 0x032b, all -> 0x0326 }
            com.braintreepayments.api.models.PayPalRequest r7 = (com.braintreepayments.api.models.PayPalRequest) r7     // Catch:{ Exception -> 0x032b, all -> 0x0326 }
            com.android.tools.r8.GeneratedOutlineSupport.outline93(r3, r4)
            goto L_0x032f
        L_0x0326:
            r0 = move-exception
            com.android.tools.r8.GeneratedOutlineSupport.outline93(r3, r4)
            throw r0
        L_0x032b:
            com.android.tools.r8.GeneratedOutlineSupport.outline93(r3, r4)
            r7 = 0
        L_0x032f:
            com.braintreepayments.api.models.PayPalAccountBuilder r3 = new com.braintreepayments.api.models.PayPalAccountBuilder
            r3.<init>()
            java.lang.String r4 = r2.mClientMetadataId
            r3.mClientMetadataId = r4
            if (r7 == 0) goto L_0x0340
            java.lang.String r4 = r7.mMerchantAccountId
            if (r4 == 0) goto L_0x0340
            r3.mMerchantAccountId = r4
        L_0x0340:
            boolean r2 = r2 instanceof com.paypal.android.sdk.onetouch.core.CheckoutRequest
            if (r2 == 0) goto L_0x034a
            if (r7 == 0) goto L_0x034a
            java.lang.String r2 = r7.mIntent
            r3.mIntent = r2
        L_0x034a:
            android.net.Uri r2 = r27.getData()
            if (r2 != 0) goto L_0x0352
            r2 = 1
            goto L_0x0353
        L_0x0352:
            r2 = 0
        L_0x0353:
            if (r2 == 0) goto L_0x035a
            java.lang.String r2 = "paypal-app"
            r3.mSource = r2
            goto L_0x035e
        L_0x035a:
            java.lang.String r2 = "paypal-browser"
            r3.mSource = r2
        L_0x035e:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x039c }
            r2.<init>()     // Catch:{ JSONException -> 0x039c }
            java.lang.String r4 = r0.mEnvironment     // Catch:{ JSONException -> 0x039c }
            r2.put(r13, r4)     // Catch:{ JSONException -> 0x039c }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x039c }
            r4.<init>()     // Catch:{ JSONException -> 0x039c }
            r4.put(r10, r2)     // Catch:{ JSONException -> 0x039c }
            org.json.JSONObject r2 = r0.mResponse     // Catch:{ JSONException -> 0x039c }
            if (r2 == 0) goto L_0x0379
            org.json.JSONObject r2 = r0.mResponse     // Catch:{ JSONException -> 0x039c }
            r4.put(r5, r2)     // Catch:{ JSONException -> 0x039c }
        L_0x0379:
            com.paypal.android.sdk.onetouch.core.enums.ResponseType r2 = r0.mResponseType     // Catch:{ JSONException -> 0x039c }
            if (r2 == 0) goto L_0x0386
            com.paypal.android.sdk.onetouch.core.enums.ResponseType r2 = r0.mResponseType     // Catch:{ JSONException -> 0x039c }
            java.lang.String r2 = r2.name()     // Catch:{ JSONException -> 0x039c }
            r4.put(r11, r2)     // Catch:{ JSONException -> 0x039c }
        L_0x0386:
            java.lang.String r2 = r0.mUserEmail     // Catch:{ JSONException -> 0x039c }
            if (r2 == 0) goto L_0x039d
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x039c }
            r2.<init>()     // Catch:{ JSONException -> 0x039c }
            java.lang.String r5 = "display_string"
            java.lang.String r0 = r0.mUserEmail     // Catch:{ JSONException -> 0x039c }
            r2.put(r5, r0)     // Catch:{ JSONException -> 0x039c }
            java.lang.String r0 = "user"
            r4.put(r0, r2)     // Catch:{ JSONException -> 0x039c }
            goto L_0x039d
        L_0x039c:
            r4 = 0
        L_0x039d:
            if (r4 == 0) goto L_0x03a1
            r3.mOneTouchCoreData = r4
        L_0x03a1:
            com.braintreepayments.api.PayPal$5 r0 = new com.braintreepayments.api.PayPal$5
            r0.<init>(r1)
            co.hyperverge.hypersnapsdk.c.k.tokenize(r1, r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r2 = ".succeeded"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.sendAnalyticsEvent(r0)
            goto L_0x03ff
        L_0x03be:
            com.braintreepayments.api.exceptions.BrowserSwitchException r2 = new com.braintreepayments.api.exceptions.BrowserSwitchException
            java.lang.Throwable r0 = r0.mError
            java.lang.String r0 = r0.getMessage()
            r2.<init>(r0)
            com.braintreepayments.api.BraintreeFragment$11 r0 = new com.braintreepayments.api.BraintreeFragment$11
            r0.<init>(r2)
            r1.postOrQueueCallback(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r2 = ".failed"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.sendAnalyticsEvent(r0)
            goto L_0x03ff
        L_0x03e6:
            r0 = 13591(0x3517, float:1.9045E-41)
            r1.postCancelCallback(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            r2 = r16
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.sendAnalyticsEvent(r0)
        L_0x03ff:
            r2 = r26
            goto L_0x06fe
        L_0x0403:
            r2 = r7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.sendAnalyticsEvent(r0)
            r2 = r26
            if (r2 == 0) goto L_0x06fe
            r0 = 13591(0x3517, float:1.9045E-41)
            r1.postCancelCallback(r0)
            goto L_0x06fe
        L_0x0421:
            r2 = r3
            java.lang.String r3 = "com.braintreepayments.api.PayPalTwoFactorAuth.PAYPAL_TWO_FACTOR_AUTH_REQUEST_KEY"
            android.content.Context r0 = r1.mContext
            android.content.SharedPreferences r4 = co.hyperverge.hypersnapsdk.c.k.getSharedPreferences(r0)
            java.lang.String r0 = r4.getString(r3, r14)     // Catch:{ Exception -> 0x044f, all -> 0x044a }
            r5 = 0
            byte[] r0 = android.util.Base64.decode(r0, r5)     // Catch:{ Exception -> 0x044f, all -> 0x044a }
            android.os.Parcel r6 = android.os.Parcel.obtain()     // Catch:{ Exception -> 0x044f, all -> 0x044a }
            int r7 = r0.length     // Catch:{ Exception -> 0x044f, all -> 0x044a }
            r6.unmarshall(r0, r5, r7)     // Catch:{ Exception -> 0x044f, all -> 0x044a }
            r6.setDataPosition(r5)     // Catch:{ Exception -> 0x044f, all -> 0x044a }
            android.os.Parcelable$Creator<com.braintreepayments.api.models.PayPalAccountNonce> r0 = com.braintreepayments.api.models.PayPalAccountNonce.CREATOR     // Catch:{ Exception -> 0x044f, all -> 0x044a }
            java.lang.Object r0 = r0.createFromParcel(r6)     // Catch:{ Exception -> 0x044f, all -> 0x044a }
            com.braintreepayments.api.models.PayPalAccountNonce r0 = (com.braintreepayments.api.models.PayPalAccountNonce) r0     // Catch:{ Exception -> 0x044f, all -> 0x044a }
            com.android.tools.r8.GeneratedOutlineSupport.outline93(r4, r3)
            goto L_0x0453
        L_0x044a:
            r0 = move-exception
            com.android.tools.r8.GeneratedOutlineSupport.outline93(r4, r3)
            throw r0
        L_0x044f:
            com.android.tools.r8.GeneratedOutlineSupport.outline93(r4, r3)
            r0 = 0
        L_0x0453:
            java.lang.String r3 = "paypal-two-factor.browser-switch.canceled"
            r4 = -1
            if (r2 != r4) goto L_0x04e0
            r4 = r27
            if (r4 == 0) goto L_0x04e0
            if (r0 == 0) goto L_0x04e0
            android.net.Uri r4 = r27.getData()
            if (r4 == 0) goto L_0x0469
            java.lang.String r4 = r4.getHost()
            goto L_0x046a
        L_0x0469:
            r4 = 0
        L_0x046a:
            java.lang.String r5 = "paypal-two-factor.browser-switch.failed"
            if (r4 == 0) goto L_0x04cc
            int r6 = r4.hashCode()
            r7 = -1867169789(0xffffffff90b54003, float:-7.149054E-29)
            if (r6 == r7) goto L_0x0487
            r7 = -1367724422(0xffffffffae7a2e7a, float:-5.68847E-11)
            if (r6 == r7) goto L_0x047d
            goto L_0x0491
        L_0x047d:
            java.lang.String r6 = "cancel"
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0491
            r6 = 1
            goto L_0x0492
        L_0x0487:
            java.lang.String r6 = "success"
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0491
            r6 = 0
            goto L_0x0492
        L_0x0491:
            r6 = -1
        L_0x0492:
            if (r6 == 0) goto L_0x04b7
            r0 = 1
            if (r6 == r0) goto L_0x04af
            r1.sendAnalyticsEvent(r5)
            com.braintreepayments.api.exceptions.BraintreeException r0 = new com.braintreepayments.api.exceptions.BraintreeException
            java.lang.String r3 = "Host path unknown: "
            java.lang.String r3 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r3, r4)
            r0.<init>(r3)
            com.braintreepayments.api.BraintreeFragment$11 r3 = new com.braintreepayments.api.BraintreeFragment$11
            r3.<init>(r0)
            r1.postOrQueueCallback(r3)
            goto L_0x06fe
        L_0x04af:
            r1.sendAnalyticsEvent(r3)
            r1.postCancelCallback(r15)
            goto L_0x06fe
        L_0x04b7:
            java.lang.String r3 = "paypal-two-factor.browser-switch.succeeded"
            r1.sendAnalyticsEvent(r3)
            java.util.List<com.braintreepayments.api.models.PaymentMethodNonce> r3 = r1.mCachedPaymentMethodNonces
            r4 = 0
            r3.add(r4, r0)
            com.braintreepayments.api.BraintreeFragment$4 r3 = new com.braintreepayments.api.BraintreeFragment$4
            r3.<init>(r0)
            r1.postOrQueueCallback(r3)
            goto L_0x06fe
        L_0x04cc:
            r1.sendAnalyticsEvent(r5)
            com.braintreepayments.api.exceptions.BraintreeException r0 = new com.braintreepayments.api.exceptions.BraintreeException
            java.lang.String r3 = "Host missing from browser switch response."
            r0.<init>(r3)
            com.braintreepayments.api.BraintreeFragment$11 r3 = new com.braintreepayments.api.BraintreeFragment$11
            r3.<init>(r0)
            r1.postOrQueueCallback(r3)
            goto L_0x06fe
        L_0x04e0:
            r1.sendAnalyticsEvent(r3)
            r1.postCancelCallback(r15)
            goto L_0x06fe
        L_0x04e8:
            r2 = r3
            r16 = r13
            java.lang.String r0 = "unknown.local-payment.webswitch.canceled"
            if (r2 != 0) goto L_0x04f7
            r1.sendAnalyticsEvent(r0)
            r1.postCancelCallback(r14)
            goto L_0x06fe
        L_0x04f7:
            if (r4 != 0) goto L_0x04fb
            r3 = 0
            goto L_0x04ff
        L_0x04fb:
            android.net.Uri r3 = r27.getData()
        L_0x04ff:
            if (r3 != 0) goto L_0x0528
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r3 = r16
            r0.append(r3)
            java.lang.String r3 = ".local-payment.webswitch-response.invalid"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1.sendAnalyticsEvent(r0)
            com.braintreepayments.api.exceptions.BraintreeException r0 = new com.braintreepayments.api.exceptions.BraintreeException
            java.lang.String r3 = "LocalPayment encountered an error, return URL is invalid."
            r0.<init>(r3)
            com.braintreepayments.api.BraintreeFragment$11 r3 = new com.braintreepayments.api.BraintreeFragment$11
            r3.<init>(r0)
            r1.postOrQueueCallback(r3)
            goto L_0x06fe
        L_0x0528:
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = r3.toLowerCase()
            java.lang.String r6 = "local-payment-cancel"
            java.lang.String r6 = r6.toLowerCase()
            boolean r4 = r4.contains(r6)
            if (r4 == 0) goto L_0x0544
            r1.sendAnalyticsEvent(r0)
            r1.postCancelCallback(r14)
            goto L_0x06fe
        L_0x0544:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r4 = "merchant_account_id"
            r6 = 0
            r0.put(r4, r6)     // Catch:{ JSONException -> 0x05c4 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x05c4 }
            r4.<init>()     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r6 = "intent"
            java.lang.String r7 = "sale"
            org.json.JSONObject r4 = r4.put(r6, r7)     // Catch:{ JSONException -> 0x05c4 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x05c4 }
            r6.<init>()     // Catch:{ JSONException -> 0x05c4 }
            org.json.JSONObject r3 = r6.put(r12, r3)     // Catch:{ JSONException -> 0x05c4 }
            org.json.JSONObject r3 = r4.put(r5, r3)     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r4 = "options"
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x05c4 }
            r5.<init>()     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r6 = "validate"
            r7 = 0
            org.json.JSONObject r5 = r5.put(r6, r7)     // Catch:{ JSONException -> 0x05c4 }
            org.json.JSONObject r3 = r3.put(r4, r5)     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r4 = "web"
            org.json.JSONObject r3 = r3.put(r11, r4)     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r4 = "correlation_id"
            android.content.Context r5 = r1.mContext     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r5 = com.paypal.android.sdk.data.collector.PayPalDataCollector.getClientMetadataId(r5)     // Catch:{ JSONException -> 0x05c4 }
            org.json.JSONObject r3 = r3.put(r4, r5)     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r4 = "paypal_account"
            r0.put(r4, r3)     // Catch:{ JSONException -> 0x05c4 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x05c4 }
            r3.<init>()     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r4 = "source"
            org.json.JSONObject r3 = r3.put(r4, r10)     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r4 = "integration"
            java.lang.String r5 = r1.mIntegrationType     // Catch:{ JSONException -> 0x05c4 }
            org.json.JSONObject r3 = r3.put(r4, r5)     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r4 = "sessionId"
            java.lang.String r5 = r1.mSessionId     // Catch:{ JSONException -> 0x05c4 }
            org.json.JSONObject r3 = r3.put(r4, r5)     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r4 = "_meta"
            r0.put(r4, r3)     // Catch:{ JSONException -> 0x05c4 }
            com.braintreepayments.api.internal.BraintreeHttpClient r3 = r1.mHttpClient     // Catch:{ JSONException -> 0x05c4 }
            java.lang.String r4 = "/v1/payment_methods/paypal_accounts"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x05c4 }
            com.braintreepayments.api.LocalPayment$2 r5 = new com.braintreepayments.api.LocalPayment$2     // Catch:{ JSONException -> 0x05c4 }
            r5.<init>(r1)     // Catch:{ JSONException -> 0x05c4 }
            r3.post(r4, r0, r5)     // Catch:{ JSONException -> 0x05c4 }
            goto L_0x06fe
        L_0x05c4:
            goto L_0x06fe
        L_0x05c7:
            r2 = r3
            r0 = -1
            if (r2 != r0) goto L_0x061b
            java.lang.String r0 = "pay-with-venmo.app-switch.success"
            r1.sendAnalyticsEvent(r0)
            java.lang.String r0 = "com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCE"
            java.lang.String r0 = r4.getStringExtra(r0)
            android.content.Context r3 = r1.mContext
            android.content.Context r3 = r3.getApplicationContext()
            r5 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r9, r5)
            java.lang.String r6 = "com.braintreepayments.api.Venmo.VAULT_VENMO_KEY"
            boolean r3 = r3.getBoolean(r6, r5)
            if (r3 == 0) goto L_0x0600
            com.braintreepayments.api.models.Authorization r3 = r1.mAuthorization
            boolean r3 = r3 instanceof com.braintreepayments.api.models.ClientToken
            if (r3 == 0) goto L_0x0600
            com.braintreepayments.api.models.VenmoAccountBuilder r3 = new com.braintreepayments.api.models.VenmoAccountBuilder
            r3.<init>()
            r3.mNonce = r0
            com.braintreepayments.api.Venmo$2 r0 = new com.braintreepayments.api.Venmo$2
            r0.<init>(r1)
            co.hyperverge.hypersnapsdk.c.k.tokenize(r1, r3, r0)
            goto L_0x06fe
        L_0x0600:
            java.lang.String r3 = "com.braintreepayments.api.EXTRA_USER_NAME"
            java.lang.String r3 = r4.getStringExtra(r3)
            com.braintreepayments.api.models.VenmoAccountNonce r4 = new com.braintreepayments.api.models.VenmoAccountNonce
            r4.<init>(r0, r3, r3)
            java.util.List<com.braintreepayments.api.models.PaymentMethodNonce> r0 = r1.mCachedPaymentMethodNonces
            r3 = 0
            r0.add(r3, r4)
            com.braintreepayments.api.BraintreeFragment$4 r0 = new com.braintreepayments.api.BraintreeFragment$4
            r0.<init>(r4)
            r1.postOrQueueCallback(r0)
            goto L_0x06fe
        L_0x061b:
            if (r2 != 0) goto L_0x06fe
            java.lang.String r0 = "pay-with-venmo.app-switch.canceled"
            r1.sendAnalyticsEvent(r0)
            goto L_0x06fe
        L_0x0624:
            r2 = r3
            r3 = -1
            if (r2 == r3) goto L_0x062a
            goto L_0x06fe
        L_0x062a:
            android.net.Uri r3 = r27.getData()
            if (r3 == 0) goto L_0x0656
            java.lang.String r0 = "auth_response"
            java.lang.String r0 = r3.getQueryParameter(r0)
            com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse r3 = com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse.fromJson(r0)
            boolean r4 = r3.mSuccess
            if (r4 == 0) goto L_0x0645
            com.braintreepayments.api.models.CardNonce r0 = r3.mCardNonce
            co.hyperverge.hypersnapsdk.c.k.completeVerificationFlowWithNoncePayload(r1, r0)
            goto L_0x06fe
        L_0x0645:
            com.braintreepayments.api.exceptions.ErrorWithResponse r3 = new com.braintreepayments.api.exceptions.ErrorWithResponse
            r4 = 422(0x1a6, float:5.91E-43)
            r3.<init>(r4, r0)
            com.braintreepayments.api.BraintreeFragment$11 r0 = new com.braintreepayments.api.BraintreeFragment$11
            r0.<init>(r3)
            r1.postOrQueueCallback(r0)
            goto L_0x06fe
        L_0x0656:
            java.lang.String r3 = "com.braintreepayments.api.ThreeDSecureActivity.EXTRA_THREE_D_SECURE_LOOKUP"
            android.os.Parcelable r3 = r4.getParcelableExtra(r3)
            com.braintreepayments.api.models.ThreeDSecureLookup r3 = (com.braintreepayments.api.models.ThreeDSecureLookup) r3
            java.lang.String r6 = "com.braintreepayments.api.ThreeDSecureActivity.EXTRA_VALIDATION_RESPONSE"
            java.io.Serializable r6 = r4.getSerializableExtra(r6)
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r6 = (com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse) r6
            java.lang.String r7 = "com.braintreepayments.api.ThreeDSecureActivity.EXTRA_JWT"
            java.lang.String r4 = r4.getStringExtra(r7)
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r9 = r6.f1900c
            java.lang.String r9 = r9.name()
            java.lang.String r9 = r9.toLowerCase()
            r10 = 0
            r8[r10] = r9
            java.lang.String r9 = "three-d-secure.verification-flow.cardinal-sdk.action-code.%s"
            java.lang.String r8 = java.lang.String.format(r9, r8)
            r1.sendAnalyticsEvent(r8)
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r8 = r6.f1900c
            int r8 = r8.ordinal()
            if (r8 == 0) goto L_0x06ea
            if (r8 == r7) goto L_0x06a4
            r7 = 2
            if (r8 == r7) goto L_0x06a4
            if (r8 == r0) goto L_0x06a4
            r0 = 4
            if (r8 == r0) goto L_0x069b
            r0 = 5
            if (r8 == r0) goto L_0x06ea
            goto L_0x06fe
        L_0x069b:
            r1.postCancelCallback(r5)
            java.lang.String r0 = "three-d-secure.verification-flow.canceled"
            r1.sendAnalyticsEvent(r0)
            goto L_0x06fe
        L_0x06a4:
            com.braintreepayments.api.models.CardNonce r0 = r3.mCardNonce
            java.lang.String r3 = "three-d-secure.verification-flow.upgrade-payment-method.started"
            r1.sendAnalyticsEvent(r3)
            java.lang.String r3 = r0.mNonce
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r6 = "jwt"
            r5.put(r6, r4)     // Catch:{ JSONException -> 0x06bc }
            java.lang.String r4 = "paymentMethodNonce"
            r5.put(r4, r3)     // Catch:{ JSONException -> 0x06bc }
        L_0x06bc:
            com.braintreepayments.api.internal.BraintreeHttpClient r4 = r1.mHttpClient
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "payment_methods/"
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = "/three_d_secure/authenticate_from_jwt"
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.lang.String r3 = co.hyperverge.hypersnapsdk.c.k.versionedPath(r3)
            java.lang.String r5 = r5.toString()
            com.braintreepayments.api.ThreeDSecure$6 r6 = new com.braintreepayments.api.ThreeDSecure$6
            r6.<init>(r0, r1)
            r4.post(r3, r5, r6)
            java.lang.String r0 = "three-d-secure.verification-flow.completed"
            r1.sendAnalyticsEvent(r0)
            goto L_0x06fe
        L_0x06ea:
            com.braintreepayments.api.exceptions.BraintreeException r0 = new com.braintreepayments.api.exceptions.BraintreeException
            java.lang.String r3 = r6.f1901e
            r0.<init>(r3)
            com.braintreepayments.api.BraintreeFragment$11 r3 = new com.braintreepayments.api.BraintreeFragment$11
            r3.<init>(r0)
            r1.postOrQueueCallback(r3)
            java.lang.String r0 = "three-d-secure.verification-flow.failed"
            r1.sendAnalyticsEvent(r0)
        L_0x06fe:
            if (r2 != 0) goto L_0x070a
            com.braintreepayments.api.BraintreeFragment$3 r0 = new com.braintreepayments.api.BraintreeFragment$3
            r2 = r25
            r0.<init>(r2)
            r1.postOrQueueCallback(r0)
        L_0x070a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.BraintreeFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    @TargetApi(23)
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttach((Activity) getActivity());
    }

    public void onBrowserSwitchResult(int i, BrowserSwitchResult browserSwitchResult, Uri uri) {
        int i2 = 1;
        Intent putExtra = new Intent().putExtra("com.braintreepayments.api.WAS_BROWSER_SWITCH_RESULT", true);
        String str = i != 13487 ? i != 13591 ? i != 13596 ? "" : "local-payment" : "paypal" : "three-d-secure";
        int i3 = browserSwitchResult.status;
        if (i3 == 1) {
            i2 = -1;
            sendAnalyticsEvent(str + ".browser-switch.succeeded");
        } else if (i3 == 2) {
            i2 = 0;
            sendAnalyticsEvent(str + ".browser-switch.canceled");
        } else if (i3 == 3) {
            String str2 = browserSwitchResult.errorMessage;
            if (str2 == null || !str2.startsWith("No installed activities")) {
                sendAnalyticsEvent(str + ".browser-switch.failed.not-setup");
            } else {
                sendAnalyticsEvent(str + ".browser-switch.failed.no-browser-installed");
            }
        }
        onActivityResult(i, i2, putExtra.setData(uri));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.mNewActivityNeedsConfiguration = false;
        this.mCrashReporter = new CrashReporter(this);
        this.mSessionId = getArguments().getString("com.braintreepayments.api.EXTRA_SESSION_ID");
        this.mIntegrationType = getArguments().getString("com.braintreepayments.api.EXTRA_INTEGRATION_TYPE");
        this.mAuthorization = (Authorization) getArguments().getParcelable("com.braintreepayments.api.EXTRA_AUTHORIZATION_TOKEN");
        this.mAnalyticsDatabase = new AnalyticsDatabase(this.mContext, null);
        if (this.mHttpClient == null) {
            this.mHttpClient = new BraintreeHttpClient(this.mAuthorization);
        }
        if (bundle != null) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("com.braintreepayments.api.EXTRA_CACHED_PAYMENT_METHOD_NONCES");
            if (parcelableArrayList != null) {
                this.mCachedPaymentMethodNonces.addAll(parcelableArrayList);
            }
            this.mHasFetchedPaymentMethodNonces = bundle.getBoolean("com.braintreepayments.api.EXTRA_FETCHED_PAYMENT_METHOD_NONCES");
            try {
                setConfiguration(new Configuration(bundle.getString("com.braintreepayments.api.EXTRA_CONFIGURATION")));
            } catch (JSONException unused) {
            }
        } else if (this.mAuthorization instanceof TokenizationKey) {
            sendAnalyticsEvent("started.client-key");
        } else {
            sendAnalyticsEvent("started.client-token");
        }
        fetchConfiguration();
    }

    public void onDestroy() {
        super.onDestroy();
        Thread.setDefaultUncaughtExceptionHandler(this.mCrashReporter.mDefaultExceptionHandler);
    }

    public void onDetach() {
        super.onDetach();
        GoogleApiClient googleApiClient = this.mGoogleApiClient;
        if (googleApiClient != null) {
            googleApiClient.disconnect();
            this.mGoogleApiClient = null;
        }
    }

    public void onPause() {
        super.onPause();
        if (getActivity() instanceof BraintreeListener) {
            removeListener((BraintreeListener) getActivity());
        }
    }

    public void onResume() {
        super.onResume();
        if (getActivity() instanceof BraintreeListener) {
            addListener((BraintreeListener) getActivity());
            if (this.mNewActivityNeedsConfiguration && this.mConfiguration != null) {
                this.mNewActivityNeedsConfiguration = false;
                postOrQueueCallback(new QueuedCallback() {
                    public void run() {
                        BraintreeFragment braintreeFragment = BraintreeFragment.this;
                        braintreeFragment.mConfigurationListener.onConfigurationFetched(braintreeFragment.mConfiguration);
                    }

                    public boolean shouldRun() {
                        return BraintreeFragment.this.mConfigurationListener != null;
                    }
                });
            }
        }
        flushCallbacks();
        GoogleApiClient googleApiClient = this.mGoogleApiClient;
        if (googleApiClient != null && !googleApiClient.isConnected() && !this.mGoogleApiClient.isConnecting()) {
            this.mGoogleApiClient.connect();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("com.braintreepayments.api.EXTRA_CACHED_PAYMENT_METHOD_NONCES", (ArrayList) this.mCachedPaymentMethodNonces);
        bundle.putBoolean("com.braintreepayments.api.EXTRA_FETCHED_PAYMENT_METHOD_NONCES", this.mHasFetchedPaymentMethodNonces);
        Configuration configuration = this.mConfiguration;
        if (configuration != null) {
            bundle.putString("com.braintreepayments.api.EXTRA_CONFIGURATION", configuration.mConfigurationString);
        }
    }

    public void onStop() {
        super.onStop();
        GoogleApiClient googleApiClient = this.mGoogleApiClient;
        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
        Configuration configuration = this.mConfiguration;
        if (configuration != null && configuration.mConfigurationString != null && (!TextUtils.isEmpty(configuration.mAnalyticsConfiguration.mUrl))) {
            try {
                this.mContext.startService(new Intent(this.mContext, AnalyticsIntentService.class).putExtra("com.braintreepayments.api.internal.AnalyticsIntentService.EXTRA_AUTHORIZATION", this.mAuthorization.mRawValue).putExtra("com.braintreepayments.api.internal.AnalyticsIntentService.EXTRA_CONFIGURATION", this.mConfiguration.mConfigurationString));
            } catch (RuntimeException unused) {
                k.send(this.mContext, this.mAuthorization, this.mHttpClient, this.mConfiguration.mAnalyticsConfiguration.mUrl, false);
            }
        }
    }

    public void postCallback(final Exception exc) {
        postOrQueueCallback(new QueuedCallback() {
            public void run() {
                BraintreeFragment.this.mErrorListener.onError(exc);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mErrorListener != null;
            }
        });
    }

    public void postCancelCallback(final int i) {
        postOrQueueCallback(new QueuedCallback() {
            public void run() {
                BraintreeFragment.this.mCancelListener.onCancel(i);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mCancelListener != null;
            }
        });
    }

    public void postOrQueueCallback(QueuedCallback queuedCallback) {
        if (!queuedCallback.shouldRun()) {
            synchronized (this.mCallbackQueue) {
                this.mCallbackQueue.add(queuedCallback);
            }
            return;
        }
        queuedCallback.run();
    }

    public <T extends BraintreeListener> void removeListener(T t) {
        if (t instanceof ConfigurationListener) {
            this.mConfigurationListener = null;
        }
        if (t instanceof BraintreeCancelListener) {
            this.mCancelListener = null;
        }
        if (t instanceof PaymentMethodNoncesUpdatedListener) {
            this.mPaymentMethodNoncesUpdatedListener = null;
        }
        if (t instanceof PaymentMethodNonceCreatedListener) {
            this.mPaymentMethodNonceCreatedListener = null;
        }
        if (t instanceof PaymentMethodNonceDeletedListener) {
            this.mPaymentMethodNonceDeletedListener = null;
        }
        if (t instanceof BraintreePaymentResultListener) {
            this.mBraintreePaymentResultListener = null;
        }
        if (t instanceof BraintreeErrorListener) {
            this.mErrorListener = null;
        }
        if (t instanceof UnionPayListener) {
            this.mUnionPayListener = null;
        }
        if (t instanceof AmericanExpressListener) {
            this.mAmericanExpressListener = null;
        }
    }

    public void sendAnalyticsEvent(String str) {
        final AnalyticsEvent analyticsEvent = new AnalyticsEvent(this.mContext, this.mSessionId, this.mIntegrationType, str);
        final AnonymousClass1 r5 = new ConfigurationListener() {
            public void onConfigurationFetched(Configuration configuration) {
                if (!TextUtils.isEmpty(configuration.mAnalyticsConfiguration.mUrl)) {
                    AnalyticsDatabase analyticsDatabase = BraintreeFragment.this.mAnalyticsDatabase;
                    AnalyticsEvent analyticsEvent = analyticsEvent;
                    if (analyticsDatabase != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("event", analyticsEvent.event);
                        contentValues.put("timestamp", Long.valueOf(analyticsEvent.timestamp));
                        contentValues.put("meta_json", analyticsEvent.metadata.toString());
                        analyticsDatabase.queueTask(new DatabaseTask(new Runnable(contentValues) {
                            public final /* synthetic */ ContentValues val$values;

                            {
                                this.val$values = r2;
                            }

                            /* JADX WARNING: Removed duplicated region for block: B:13:0x001c  */
                            /* JADX WARNING: Removed duplicated region for block: B:17:0x0023  */
                            /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public void run() {
                                /*
                                    r5 = this;
                                    r0 = 0
                                    com.braintreepayments.api.internal.AnalyticsDatabase r1 = com.braintreepayments.api.internal.AnalyticsDatabase.this     // Catch:{ SQLiteException -> 0x0020, all -> 0x0016 }
                                    android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0020, all -> 0x0016 }
                                    java.lang.String r2 = "analytics"
                                    android.content.ContentValues r3 = r5.val$values     // Catch:{ SQLiteException -> 0x0014, all -> 0x0012 }
                                    r1.insert(r2, r0, r3)     // Catch:{ SQLiteException -> 0x0014, all -> 0x0012 }
                                    r1.close()
                                    goto L_0x0026
                                L_0x0012:
                                    r0 = move-exception
                                    goto L_0x001a
                                L_0x0014:
                                    r0 = r1
                                    goto L_0x0021
                                L_0x0016:
                                    r1 = move-exception
                                    r4 = r1
                                    r1 = r0
                                    r0 = r4
                                L_0x001a:
                                    if (r1 == 0) goto L_0x001f
                                    r1.close()
                                L_0x001f:
                                    throw r0
                                L_0x0020:
                                L_0x0021:
                                    if (r0 == 0) goto L_0x0026
                                    r0.close()
                                L_0x0026:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.internal.AnalyticsDatabase.AnonymousClass1.run():void");
                            }
                        }));
                        return;
                    }
                    throw null;
                }
            }
        };
        fetchConfiguration();
        postOrQueueCallback(new QueuedCallback() {
            public void run() {
                r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
            }

            public boolean shouldRun() {
                BraintreeFragment braintreeFragment = BraintreeFragment.this;
                return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
            }
        });
    }

    public void setConfiguration(Configuration configuration) {
        this.mConfiguration = configuration;
        BraintreeHttpClient braintreeHttpClient = this.mHttpClient;
        String str = configuration.mClientApiUrl;
        if (str == null) {
            str = "";
        }
        braintreeHttpClient.mBaseUrl = str;
        if (!TextUtils.isEmpty(configuration.mGraphQLConfiguration.mUrl)) {
            this.mGraphQLHttpClient = new BraintreeGraphQLHttpClient(configuration.mGraphQLConfiguration.mUrl, this.mAuthorization.getBearer());
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!isAdded()) {
            postCallback(new BraintreeException("BraintreeFragment is not attached to an Activity. Please ensure it is attached and try again."));
        } else {
            super.startActivityForResult(intent, i);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mNewActivityNeedsConfiguration = true;
        if (this.mContext == null) {
            this.mContext = activity.getApplicationContext();
        }
        this.mReturnUrlScheme = this.mContext.getPackageName().toLowerCase(Locale.ROOT).replace("_", "") + ".braintree";
    }
}
