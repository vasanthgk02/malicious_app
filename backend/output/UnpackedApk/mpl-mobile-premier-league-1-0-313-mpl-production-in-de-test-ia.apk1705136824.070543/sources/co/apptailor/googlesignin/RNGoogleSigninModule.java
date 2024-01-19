package co.apptailor.googlesignin;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.core.widget.CompoundButtonCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.mpl.androidapp.utils.Constant;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;

public class RNGoogleSigninModule extends ReactContextBaseJavaModule {
    public static final String ERROR_USER_RECOVERABLE_AUTH = "ERROR_USER_RECOVERABLE_AUTH";
    public static final String MODULE_NAME = "RNGoogleSignin";
    public static final String PLAY_SERVICES_NOT_AVAILABLE = "PLAY_SERVICES_NOT_AVAILABLE";
    public static final int RC_SIGN_IN = 9001;
    public static final int REQUEST_CODE_RECOVER_AUTH = 53294;
    public static final String SHOULD_RECOVER = "SHOULD_RECOVER";
    public GoogleSignInClient _apiClient;
    public PendingAuthRecovery pendingAuthRecovery;
    public PromiseWrapper promiseWrapper = new PromiseWrapper();

    public static class AccessTokenRetrievalTask extends AsyncTask<WritableMap, Void, Void> {
        public WeakReference<RNGoogleSigninModule> weakModuleRef;

        public AccessTokenRetrievalTask(RNGoogleSigninModule rNGoogleSigninModule) {
            this.weakModuleRef = new WeakReference<>(rNGoogleSigninModule);
        }

        public Object doInBackground(Object[] objArr) {
            Intent intent;
            WritableMap[] writableMapArr = (WritableMap[]) objArr;
            boolean z = false;
            WritableMap writableMap = writableMapArr[0];
            RNGoogleSigninModule rNGoogleSigninModule = (RNGoogleSigninModule) this.weakModuleRef.get();
            if (rNGoogleSigninModule != null) {
                try {
                    insertAccessTokenIntoUserProperties(rNGoogleSigninModule, writableMap);
                    PromiseWrapper promiseWrapper = rNGoogleSigninModule.getPromiseWrapper();
                    Promise promise = promiseWrapper.promise;
                    if (promise != null) {
                        promiseWrapper.resetMembers();
                        promise.resolve(writableMap);
                    }
                } catch (Exception e2) {
                    WritableMap writableMap2 = writableMapArr.length >= 2 ? writableMapArr[1] : null;
                    if (e2 instanceof UserRecoverableAuthException) {
                        if (writableMap2 != null && writableMap2.hasKey(RNGoogleSigninModule.SHOULD_RECOVER) && writableMap2.getBoolean(RNGoogleSigninModule.SHOULD_RECOVER)) {
                            z = true;
                        }
                        if (z) {
                            Activity access$700 = rNGoogleSigninModule.getCurrentActivity();
                            if (access$700 == null) {
                                rNGoogleSigninModule.pendingAuthRecovery = null;
                                PromiseWrapper access$400 = rNGoogleSigninModule.promiseWrapper;
                                String outline38 = GeneratedOutlineSupport.outline38(e2, GeneratedOutlineSupport.outline73("Cannot attempt recovery auth because app is not in foreground. "));
                                Promise promise2 = access$400.promise;
                                if (promise2 != null) {
                                    access$400.resetMembers();
                                    promise2.reject((String) RNGoogleSigninModule.MODULE_NAME, outline38);
                                }
                            } else {
                                rNGoogleSigninModule.pendingAuthRecovery = new PendingAuthRecovery(writableMap);
                                Intent intent2 = ((UserRecoverableAuthException) e2).zza;
                                if (intent2 == null) {
                                    intent = null;
                                } else {
                                    intent = new Intent(intent2);
                                }
                                access$700.startActivityForResult(intent, RNGoogleSigninModule.REQUEST_CODE_RECOVER_AUTH);
                            }
                        } else {
                            rNGoogleSigninModule.promiseWrapper.reject((String) RNGoogleSigninModule.ERROR_USER_RECOVERABLE_AUTH, (Throwable) e2);
                        }
                    } else {
                        rNGoogleSigninModule.promiseWrapper.reject((String) RNGoogleSigninModule.MODULE_NAME, (Throwable) e2);
                    }
                }
            }
            return null;
        }

        public final void insertAccessTokenIntoUserProperties(RNGoogleSigninModule rNGoogleSigninModule, WritableMap writableMap) throws IOException, GoogleAuthException {
            String string = writableMap.getMap(Action.USER).getString("email");
            ReactApplicationContext access$600 = rNGoogleSigninModule.getReactApplicationContext();
            Account account = new Account(string, "com.google");
            ReadableArray array = writableMap.getArray("scopes");
            StringBuilder sb = new StringBuilder("oauth2:");
            for (int i = 0; i < array.size(); i++) {
                sb.append(array.getString(i));
                sb.append(CMap.SPACE);
            }
            writableMap.putString("accessToken", GoogleAuthUtil.getToken(access$600, account, sb.toString().trim()));
        }
    }

    public class RNGoogleSigninActivityEventListener extends BaseActivityEventListener {
        public RNGoogleSigninActivityEventListener(AnonymousClass1 r2) {
        }

        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            Task task;
            if (i == 9001) {
                GoogleSignInResult zbd = zbm.zbd(intent);
                GoogleSignInAccount googleSignInAccount = zbd.zbb;
                if (!zbd.zba.isSuccess() || googleSignInAccount == null) {
                    task = Tasks.forException(ApiExceptionUtil.fromStatus(zbd.zba));
                } else {
                    task = Tasks.forResult(googleSignInAccount);
                }
                RNGoogleSigninModule.this.handleSignInTaskResult(task);
            } else if (i != 53294) {
            } else {
                if (i2 == -1) {
                    RNGoogleSigninModule.this.rerunFailedAuthTokenTask();
                    return;
                }
                PromiseWrapper access$400 = RNGoogleSigninModule.this.promiseWrapper;
                Promise promise = access$400.promise;
                if (promise != null) {
                    access$400.resetMembers();
                    promise.reject((String) RNGoogleSigninModule.MODULE_NAME, (String) "Failed authentication recovery attempt, probably user-rejected.");
                }
            }
        }
    }

    public static class TokenClearingTask extends AsyncTask<String, Void, Void> {
        public WeakReference<RNGoogleSigninModule> weakModuleRef;

        public TokenClearingTask(RNGoogleSigninModule rNGoogleSigninModule) {
            this.weakModuleRef = new WeakReference<>(rNGoogleSigninModule);
        }

        public Object doInBackground(Object[] objArr) {
            String[] strArr = (String[]) objArr;
            RNGoogleSigninModule rNGoogleSigninModule = (RNGoogleSigninModule) this.weakModuleRef.get();
            if (rNGoogleSigninModule != null) {
                try {
                    GoogleAuthUtil.clearToken(rNGoogleSigninModule.getReactApplicationContext(), strArr[0]);
                    rNGoogleSigninModule.getPromiseWrapper().resolve(null);
                } catch (Exception e2) {
                    rNGoogleSigninModule.promiseWrapper.reject((String) RNGoogleSigninModule.MODULE_NAME, (Throwable) e2);
                }
            }
            return null;
        }
    }

    public RNGoogleSigninModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new RNGoogleSigninActivityEventListener(null));
    }

    /* access modifiers changed from: private */
    public void handleSignInTaskResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) task.getResult(ApiException.class);
            if (googleSignInAccount == null) {
                PromiseWrapper promiseWrapper2 = this.promiseWrapper;
                Promise promise = promiseWrapper2.promise;
                if (promise != null) {
                    promiseWrapper2.resetMembers();
                    promise.reject((String) MODULE_NAME, (String) "GoogleSignInAccount instance was null");
                    return;
                }
                return;
            }
            WritableMap userProperties = CompoundButtonCompat.getUserProperties(googleSignInAccount);
            PromiseWrapper promiseWrapper3 = this.promiseWrapper;
            Promise promise2 = promiseWrapper3.promise;
            if (promise2 != null) {
                promiseWrapper3.resetMembers();
                promise2.resolve(userProperties);
            }
        } catch (ApiException e2) {
            int i = e2.mStatus.zzc;
            this.promiseWrapper.reject(String.valueOf(i), GoogleSignInStatusCodes.getStatusCodeString(i));
        }
    }

    /* access modifiers changed from: private */
    public void handleSignOutOrRevokeAccessTask(Task<Void> task, Promise promise) {
        if (task.isSuccessful()) {
            promise.resolve(null);
            return;
        }
        Exception exception = task.getException();
        int i = exception instanceof ApiException ? ((ApiException) exception).mStatus.zzc : 8;
        promise.reject(String.valueOf(i), GoogleSignInStatusCodes.getStatusCodeString(i));
    }

    private void rejectWithNullClientError(Promise promise) {
        promise.reject((String) MODULE_NAME, (String) "apiClient is null - call configure first");
    }

    /* access modifiers changed from: private */
    public void rerunFailedAuthTokenTask() {
        WritableMap writableMap = this.pendingAuthRecovery.userProperties;
        if (writableMap != null) {
            new AccessTokenRetrievalTask(this).execute(new WritableMap[]{writableMap, null});
            return;
        }
        PromiseWrapper promiseWrapper2 = this.promiseWrapper;
        Promise promise = promiseWrapper2.promise;
        if (promise != null) {
            promiseWrapper2.resetMembers();
            promise.reject((String) MODULE_NAME, (String) "rerunFailedAuthTokenTask: recovery failed");
        }
    }

    private void startTokenRetrievalTaskWithRecovery(GoogleSignInAccount googleSignInAccount) {
        WritableMap userProperties = CompoundButtonCompat.getUserProperties(googleSignInAccount);
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean(SHOULD_RECOVER, true);
        new AccessTokenRetrievalTask(this).execute(new WritableMap[]{userProperties, createMap});
    }

    @ReactMethod
    public void clearCachedAccessToken(String str, Promise promise) {
        this.promiseWrapper.setPromiseWithInProgressCheck(promise, "clearCachedAccessToken");
        new TokenClearingTask(this).execute(new String[]{str});
    }

    @ReactMethod
    public void configure(ReadableMap readableMap, Promise promise) {
        ReadableArray array = readableMap.hasKey("scopes") ? readableMap.getArray("scopes") : Arguments.createArray();
        String string = readableMap.hasKey(Constant.WEB_CLIENT_ID) ? readableMap.getString(Constant.WEB_CLIENT_ID) : null;
        boolean z = readableMap.hasKey("offlineAccess") && readableMap.getBoolean("offlineAccess");
        boolean z2 = readableMap.hasKey("forceCodeForRefreshToken") && readableMap.getBoolean("forceCodeForRefreshToken");
        String string2 = readableMap.hasKey("accountName") ? readableMap.getString("accountName") : null;
        String string3 = readableMap.hasKey("hostedDomain") ? readableMap.getString("hostedDomain") : null;
        int size = array.size();
        Scope[] scopeArr = new Scope[size];
        for (int i = 0; i < size; i++) {
            scopeArr[i] = new Scope(array.getString(i));
        }
        Builder builder = new Builder(GoogleSignInOptions.DEFAULT_SIGN_IN);
        builder.zaa.add(new Scope("email"));
        builder.zaa.addAll(Arrays.asList(scopeArr));
        if (string != null && !string.isEmpty()) {
            builder.zad = true;
            builder.zaa(string);
            builder.zae = string;
            if (z) {
                builder.zab = true;
                builder.zaa(string);
                builder.zae = string;
                builder.zac = z2;
            }
        }
        if (string2 != null && !string2.isEmpty()) {
            Preconditions.checkNotEmpty(string2);
            builder.zaf = new Account(string2, "com.google");
        }
        if (string3 != null && !string3.isEmpty()) {
            Preconditions.checkNotEmpty(string3);
            builder.zag = string3;
        }
        GoogleSignInOptions build = builder.build();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Preconditions.checkNotNull(build);
        this._apiClient = new GoogleSignInClient(reactApplicationContext, build);
        promise.resolve(null);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        Integer valueOf = Integer.valueOf(2);
        hashMap.put("BUTTON_SIZE_ICON", valueOf);
        Integer valueOf2 = Integer.valueOf(0);
        hashMap.put("BUTTON_SIZE_STANDARD", valueOf2);
        Integer valueOf3 = Integer.valueOf(1);
        hashMap.put("BUTTON_SIZE_WIDE", valueOf3);
        hashMap.put("BUTTON_COLOR_AUTO", valueOf);
        hashMap.put("BUTTON_COLOR_LIGHT", valueOf3);
        hashMap.put("BUTTON_COLOR_DARK", valueOf2);
        hashMap.put("SIGN_IN_CANCELLED", String.valueOf(12501));
        hashMap.put("SIGN_IN_REQUIRED", String.valueOf(4));
        hashMap.put("IN_PROGRESS", "ASYNC_OP_IN_PROGRESS");
        hashMap.put(PLAY_SERVICES_NOT_AVAILABLE, PLAY_SERVICES_NOT_AVAILABLE);
        return hashMap;
    }

    @ReactMethod
    public void getCurrentUser(Promise promise) {
        WritableMap writableMap;
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getReactApplicationContext());
        if (lastSignedInAccount == null) {
            writableMap = null;
        } else {
            writableMap = CompoundButtonCompat.getUserProperties(lastSignedInAccount);
        }
        promise.resolve(writableMap);
    }

    public String getName() {
        return MODULE_NAME;
    }

    public PromiseWrapper getPromiseWrapper() {
        return this.promiseWrapper;
    }

    @ReactMethod
    public void getTokens(Promise promise) {
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getReactApplicationContext());
        if (lastSignedInAccount == null) {
            promise.reject((String) MODULE_NAME, (String) "getTokens requires a user to be signed in");
            return;
        }
        this.promiseWrapper.setPromiseWithInProgressCheck(promise, "getTokens");
        startTokenRetrievalTaskWithRecovery(lastSignedInAccount);
    }

    @ReactMethod
    public void isSignedIn(Promise promise) {
        promise.resolve(Boolean.valueOf(GoogleSignIn.getLastSignedInAccount(getReactApplicationContext()) != null));
    }

    @ReactMethod
    public void playServicesAvailable(boolean z, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject((String) MODULE_NAME, (String) "activity is null");
            return;
        }
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(currentActivity, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (isGooglePlayServicesAvailable != 0) {
            if (z && GooglePlayServicesUtilLight.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                googleApiAvailability.getErrorDialog(currentActivity, isGooglePlayServicesAvailable, 2404, null).show();
            }
            promise.reject((String) PLAY_SERVICES_NOT_AVAILABLE, (String) "Play services not available");
        } else {
            promise.resolve(Boolean.TRUE);
        }
    }

    @ReactMethod
    public void revokeAccess(final Promise promise) {
        GoogleSignInClient googleSignInClient = this._apiClient;
        if (googleSignInClient == null) {
            rejectWithNullClientError(promise);
        } else {
            googleSignInClient.revokeAccess().addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                    RNGoogleSigninModule.this.handleSignOutOrRevokeAccessTask(task, promise);
                }
            });
        }
    }

    @ReactMethod
    public void signIn(Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
            return;
        }
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject((String) MODULE_NAME, (String) "activity is null");
            return;
        }
        this.promiseWrapper.setPromiseWithInProgressCheck(promise, "signIn");
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Intent intent;
                GoogleSignInClient access$100 = RNGoogleSigninModule.this._apiClient;
                Context applicationContext = access$100.getApplicationContext();
                int zba = access$100.zba();
                int i = zba - 1;
                if (zba != 0) {
                    if (i == 2) {
                        zbm.zba.d("getFallbackSignInIntent()", new Object[0]);
                        intent = zbm.zbc(applicationContext, (GoogleSignInOptions) access$100.getApiOptions());
                        intent.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
                    } else if (i != 3) {
                        zbm.zba.d("getNoImplementationSignInIntent()", new Object[0]);
                        intent = zbm.zbc(applicationContext, (GoogleSignInOptions) access$100.getApiOptions());
                        intent.setAction("com.google.android.gms.auth.NO_IMPL");
                    } else {
                        intent = zbm.zbc(applicationContext, (GoogleSignInOptions) access$100.getApiOptions());
                    }
                    currentActivity.startActivityForResult(intent, RNGoogleSigninModule.RC_SIGN_IN);
                    return;
                }
                throw null;
            }
        });
    }

    @ReactMethod
    public void signInSilently(Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
            return;
        }
        this.promiseWrapper.setPromiseWithInProgressCheck(promise, "signInSilently");
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00af  */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x00cb  */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x010e  */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x0114  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r15 = this;
                    co.apptailor.googlesignin.RNGoogleSigninModule r0 = co.apptailor.googlesignin.RNGoogleSigninModule.this
                    com.google.android.gms.auth.api.signin.GoogleSignInClient r0 = r0._apiClient
                    com.google.android.gms.common.api.GoogleApiClient r1 = r0.asGoogleApiClient()
                    android.content.Context r2 = r0.getApplicationContext()
                    com.google.android.gms.common.api.Api$ApiOptions r3 = r0.getApiOptions()
                    com.google.android.gms.auth.api.signin.GoogleSignInOptions r3 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r3
                    int r0 = r0.zba()
                    r4 = 3
                    r5 = 1
                    r6 = 0
                    if (r0 != r4) goto L_0x001f
                    r0 = 1
                    goto L_0x0020
                L_0x001f:
                    r0 = 0
                L_0x0020:
                    com.google.android.gms.common.logging.Logger r4 = com.google.android.gms.auth.api.signin.internal.zbm.zba
                    java.lang.String r7 = "silentSignIn()"
                    java.lang.Object[] r8 = new java.lang.Object[r6]
                    r4.d(r7, r8)
                    com.google.android.gms.common.logging.Logger r4 = com.google.android.gms.auth.api.signin.internal.zbm.zba
                    java.lang.String r7 = "getEligibleSavedSignInResult()"
                    java.lang.Object[] r8 = new java.lang.Object[r6]
                    r4.d(r7, r8)
                    com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
                    com.google.android.gms.auth.api.signin.internal.zbn r4 = com.google.android.gms.auth.api.signin.internal.zbn.zbc(r2)
                    monitor-enter(r4)
                    com.google.android.gms.auth.api.signin.GoogleSignInOptions r7 = r4.zbc     // Catch:{ all -> 0x0120 }
                    monitor-exit(r4)
                    r4 = 0
                    if (r7 != 0) goto L_0x0042
                    goto L_0x00ac
                L_0x0042:
                    android.accounts.Account r8 = r7.zai
                    android.accounts.Account r9 = r3.zai
                    if (r8 != 0) goto L_0x004b
                    if (r9 != 0) goto L_0x00ac
                    goto L_0x0052
                L_0x004b:
                    boolean r8 = r8.equals(r9)
                    if (r8 != 0) goto L_0x0052
                    goto L_0x00ac
                L_0x0052:
                    boolean r8 = r3.zak
                    if (r8 == 0) goto L_0x0057
                    goto L_0x00ac
                L_0x0057:
                    boolean r8 = r3.zaj
                    if (r8 == 0) goto L_0x006b
                    boolean r8 = r7.zaj
                    if (r8 != 0) goto L_0x0060
                    goto L_0x00ac
                L_0x0060:
                    java.lang.String r8 = r3.zam
                    java.lang.String r9 = r7.zam
                    boolean r8 = com.google.android.gms.common.internal.Objects.equal(r8, r9)
                    if (r8 != 0) goto L_0x006b
                    goto L_0x00ac
                L_0x006b:
                    java.util.HashSet r8 = new java.util.HashSet
                    java.util.ArrayList r7 = r7.getScopes()
                    r8.<init>(r7)
                    java.util.HashSet r7 = new java.util.HashSet
                    java.util.ArrayList r9 = r3.getScopes()
                    r7.<init>(r9)
                    boolean r7 = r8.containsAll(r7)
                    if (r7 != 0) goto L_0x0084
                    goto L_0x00ac
                L_0x0084:
                    com.google.android.gms.auth.api.signin.internal.zbn r7 = com.google.android.gms.auth.api.signin.internal.zbn.zbc(r2)
                    monitor-enter(r7)
                    com.google.android.gms.auth.api.signin.GoogleSignInAccount r8 = r7.zbb     // Catch:{ all -> 0x011d }
                    monitor-exit(r7)
                    if (r8 == 0) goto L_0x00ac
                    com.google.android.gms.common.util.Clock r7 = com.google.android.gms.auth.api.signin.GoogleSignInAccount.zaa
                    long r9 = r7.currentTimeMillis()
                    r11 = 1000(0x3e8, double:4.94E-321)
                    long r9 = r9 / r11
                    long r11 = r8.zaj
                    r13 = -300(0xfffffffffffffed4, double:NaN)
                    long r11 = r11 + r13
                    int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                    if (r7 < 0) goto L_0x00a1
                    goto L_0x00a2
                L_0x00a1:
                    r5 = 0
                L_0x00a2:
                    if (r5 != 0) goto L_0x00ac
                    com.google.android.gms.auth.api.signin.GoogleSignInResult r5 = new com.google.android.gms.auth.api.signin.GoogleSignInResult
                    com.google.android.gms.common.api.Status r7 = com.google.android.gms.common.api.Status.RESULT_SUCCESS
                    r5.<init>(r8, r7)
                    goto L_0x00ad
                L_0x00ac:
                    r5 = r4
                L_0x00ad:
                    if (r5 == 0) goto L_0x00cb
                    com.google.android.gms.common.logging.Logger r0 = com.google.android.gms.auth.api.signin.internal.zbm.zba
                    java.lang.String r2 = "Eligible saved sign in result found"
                    java.lang.Object[] r3 = new java.lang.Object[r6]
                    r0.d(r2, r3)
                    java.lang.String r0 = "Result must not be null"
                    com.google.android.gms.common.internal.Preconditions.checkNotNull(r5, r0)
                    com.google.android.gms.common.api.zah r0 = new com.google.android.gms.common.api.zah
                    r0.<init>(r1)
                    r0.setResult(r5)
                    com.google.android.gms.common.api.internal.OptionalPendingResultImpl r1 = new com.google.android.gms.common.api.internal.OptionalPendingResultImpl
                    r1.<init>(r0)
                    goto L_0x0102
                L_0x00cb:
                    if (r0 == 0) goto L_0x00eb
                    com.google.android.gms.auth.api.signin.GoogleSignInResult r0 = new com.google.android.gms.auth.api.signin.GoogleSignInResult
                    com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
                    r3 = 4
                    r2.<init>(r3, r4)
                    r0.<init>(r4, r2)
                    java.lang.String r2 = "Result must not be null"
                    com.google.android.gms.common.internal.Preconditions.checkNotNull(r0, r2)
                    com.google.android.gms.common.api.zah r2 = new com.google.android.gms.common.api.zah
                    r2.<init>(r1)
                    r2.setResult(r0)
                    com.google.android.gms.common.api.internal.OptionalPendingResultImpl r1 = new com.google.android.gms.common.api.internal.OptionalPendingResultImpl
                    r1.<init>(r2)
                    goto L_0x0102
                L_0x00eb:
                    com.google.android.gms.common.logging.Logger r0 = com.google.android.gms.auth.api.signin.internal.zbm.zba
                    java.lang.String r4 = "trySilentSignIn()"
                    java.lang.Object[] r5 = new java.lang.Object[r6]
                    r0.d(r4, r5)
                    com.google.android.gms.auth.api.signin.internal.zbg r0 = new com.google.android.gms.auth.api.signin.internal.zbg
                    r0.<init>(r1, r2, r3)
                    com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl r0 = r1.enqueue(r0)
                    com.google.android.gms.common.api.internal.OptionalPendingResultImpl r1 = new com.google.android.gms.common.api.internal.OptionalPendingResultImpl
                    r1.<init>(r0)
                L_0x0102:
                    com.google.android.gms.auth.api.signin.zbb r0 = com.google.android.gms.auth.api.signin.GoogleSignInClient.zbb
                    com.google.android.gms.tasks.Task r0 = com.google.android.gms.common.internal.PendingResultUtil.toTask(r1, r0)
                    boolean r1 = r0.isSuccessful()
                    if (r1 == 0) goto L_0x0114
                    co.apptailor.googlesignin.RNGoogleSigninModule r1 = co.apptailor.googlesignin.RNGoogleSigninModule.this
                    r1.handleSignInTaskResult(r0)
                    goto L_0x011c
                L_0x0114:
                    co.apptailor.googlesignin.RNGoogleSigninModule$1$1 r1 = new co.apptailor.googlesignin.RNGoogleSigninModule$1$1
                    r1.<init>()
                    r0.addOnCompleteListener(r1)
                L_0x011c:
                    return
                L_0x011d:
                    r0 = move-exception
                    monitor-exit(r7)
                    throw r0
                L_0x0120:
                    r0 = move-exception
                    monitor-exit(r4)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: co.apptailor.googlesignin.RNGoogleSigninModule.AnonymousClass1.run():void");
            }
        });
    }

    @ReactMethod
    public void signOut(final Promise promise) {
        GoogleSignInClient googleSignInClient = this._apiClient;
        if (googleSignInClient == null) {
            rejectWithNullClientError(promise);
        } else {
            googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                    RNGoogleSigninModule.this.handleSignOutOrRevokeAccessTask(task, promise);
                }
            });
        }
    }
}
