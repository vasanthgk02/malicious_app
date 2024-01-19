package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol.NativeAppInfo;
import com.facebook.internal.NativeProtocol.ProtocolVersionQueryResult;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.razorpay.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J$\u0010#\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0007J\u001a\u0010'\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J \u0010*\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010-\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010)H\u0007J$\u0010/\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0007J\"\u00100\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J*\u00101\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0007¨\u00067"}, d2 = {"Lcom/facebook/internal/DialogPresenter;", "", "()V", "canPresentNativeDialogWithFeature", "", "feature", "Lcom/facebook/internal/DialogFeature;", "canPresentWebFallbackDialogWithFeature", "getDialogWebFallbackUri", "Landroid/net/Uri;", "getProtocolVersionForNativeDialog", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "getVersionSpecForFeature", "", "applicationId", "", "actionName", "logDialogActivity", "", "context", "Landroid/content/Context;", "eventName", "outcome", "present", "appCall", "Lcom/facebook/internal/AppCall;", "activity", "Landroid/app/Activity;", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "callbackManager", "Lcom/facebook/CallbackManager;", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "setupAppCallForCannotShowError", "setupAppCallForCustomTabDialog", "action", "parameters", "Landroid/os/Bundle;", "setupAppCallForErrorResult", "exception", "Lcom/facebook/FacebookException;", "setupAppCallForNativeDialog", "parameterProvider", "Lcom/facebook/internal/DialogPresenter$ParameterProvider;", "setupAppCallForValidationError", "validationError", "setupAppCallForWebDialog", "setupAppCallForWebFallbackDialog", "startActivityForResultWithAndroidX", "intent", "Landroid/content/Intent;", "requestCode", "", "ParameterProvider", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DialogPresenter.kt */
public final class DialogPresenter {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/internal/DialogPresenter$ParameterProvider;", "", "legacyParameters", "Landroid/os/Bundle;", "getLegacyParameters", "()Landroid/os/Bundle;", "parameters", "getParameters", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DialogPresenter.kt */
    public interface ParameterProvider {
        Bundle getLegacyParameters();

        Bundle getParameters();
    }

    public static final boolean canPresentNativeDialogWithFeature(DialogFeature dialogFeature) {
        Intrinsics.checkNotNullParameter(dialogFeature, "feature");
        return getProtocolVersionForNativeDialog(dialogFeature).protocolVersion != -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.facebook.internal.NativeProtocol.ProtocolVersionQueryResult getProtocolVersionForNativeDialog(com.facebook.internal.DialogFeature r7) {
        /*
            java.lang.String r0 = "feature"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r0 = com.facebook.FacebookSdk.getApplicationId()
            java.lang.String r1 = r7.getAction()
            java.lang.String r2 = r7.name()
            java.lang.String r3 = "applicationId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "actionName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "featureName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            int r3 = r1.length()
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x002c
            r3 = 1
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            r6 = 0
            if (r3 != 0) goto L_0x0057
            int r3 = r2.length()
            if (r3 != 0) goto L_0x0038
            r3 = 1
            goto L_0x0039
        L_0x0038:
            r3 = 0
        L_0x0039:
            if (r3 == 0) goto L_0x003c
            goto L_0x0057
        L_0x003c:
            com.facebook.internal.FetchedAppSettingsManager r3 = com.facebook.internal.FetchedAppSettingsManager.INSTANCE
            com.facebook.internal.FetchedAppSettings r0 = com.facebook.internal.FetchedAppSettingsManager.getAppSettingsWithoutQuery(r0)
            if (r0 != 0) goto L_0x0046
            r0 = r6
            goto L_0x004e
        L_0x0046:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.facebook.internal.FetchedAppSettings$DialogFeatureConfig>> r0 = r0.dialogConfigurations
            java.lang.Object r0 = r0.get(r1)
            java.util.Map r0 = (java.util.Map) r0
        L_0x004e:
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r0.get(r2)
            com.facebook.internal.FetchedAppSettings$DialogFeatureConfig r0 = (com.facebook.internal.FetchedAppSettings.DialogFeatureConfig) r0
            goto L_0x0058
        L_0x0057:
            r0 = r6
        L_0x0058:
            if (r0 != 0) goto L_0x005c
            r0 = r6
            goto L_0x005e
        L_0x005c:
            int[] r0 = r0.versionSpec
        L_0x005e:
            if (r0 != 0) goto L_0x0068
            int[] r0 = new int[r5]
            int r7 = r7.getMinVersion()
            r0[r4] = r7
        L_0x0068:
            com.facebook.internal.NativeProtocol r7 = com.facebook.internal.NativeProtocol.INSTANCE
            java.lang.Class<com.facebook.internal.NativeProtocol> r7 = com.facebook.internal.NativeProtocol.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)
            if (r2 == 0) goto L_0x0073
            goto L_0x0094
        L_0x0073:
            java.lang.String r2 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "versionSpec"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)     // Catch:{ all -> 0x0090 }
            java.util.Map<java.lang.String, java.util.List<com.facebook.internal.NativeProtocol$NativeAppInfo>> r2 = com.facebook.internal.NativeProtocol.actionToAppInfoMap     // Catch:{ all -> 0x0090 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x0090 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0089
            kotlin.collections.EmptyList r1 = kotlin.collections.EmptyList.INSTANCE     // Catch:{ all -> 0x0090 }
        L_0x0089:
            com.facebook.internal.NativeProtocol r2 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x0090 }
            com.facebook.internal.NativeProtocol$ProtocolVersionQueryResult r6 = r2.getLatestAvailableProtocolVersionForAppInfoList(r1, r0)     // Catch:{ all -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r7)
        L_0x0094:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.DialogPresenter.getProtocolVersionForNativeDialog(com.facebook.internal.DialogFeature):com.facebook.internal.NativeProtocol$ProtocolVersionQueryResult");
    }

    public static final void setupAppCallForNativeDialog(AppCall appCall, ParameterProvider parameterProvider, DialogFeature dialogFeature) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(parameterProvider, "parameterProvider");
        Intrinsics.checkNotNullParameter(dialogFeature, "feature");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String action = dialogFeature.getAction();
        ProtocolVersionQueryResult protocolVersionForNativeDialog = getProtocolVersionForNativeDialog(dialogFeature);
        int i = protocolVersionForNativeDialog.protocolVersion;
        if (i != -1) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            if (NativeProtocol.isVersionCompatibleWithBucketedIntent(i)) {
                bundle = parameterProvider.getParameters();
            } else {
                bundle = parameterProvider.getLegacyParameters();
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
            String uuid = appCall.getCallId().toString();
            Class<NativeProtocol> cls = NativeProtocol.class;
            Intent intent = null;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    Intrinsics.checkNotNullParameter(applicationContext, "context");
                    NativeAppInfo nativeAppInfo = protocolVersionForNativeDialog.appInfo;
                    if (nativeAppInfo != null) {
                        Intent validateActivityIntent = NativeProtocol.validateActivityIntent(applicationContext, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"));
                        if (validateActivityIntent != null) {
                            NativeProtocol.setupProtocolRequestIntent(validateActivityIntent, uuid, action, protocolVersionForNativeDialog.protocolVersion, bundle);
                            intent = validateActivityIntent;
                        }
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
            if (intent != null) {
                appCall.setRequestIntent(intent);
                return;
            }
            throw new FacebookException((String) "Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        throw new FacebookException((String) "Cannot present this dialog. This likely means that the Facebook app is not installed.");
    }

    public static final void setupAppCallForValidationError(AppCall appCall, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        Intrinsics.checkNotNullParameter(applicationContext, "context");
        Validate.hasFacebookActivity(applicationContext, true);
        Intent intent = new Intent();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction("PassThrough");
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        String uuid = appCall.getCallId().toString();
        NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
        int latestKnownVersion = NativeProtocol.getLatestKnownVersion();
        NativeProtocol nativeProtocol3 = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, uuid, null, latestKnownVersion, NativeProtocol.createBundleForException(facebookException));
        appCall.setRequestIntent(intent);
    }

    public static final void setupAppCallForWebDialog(AppCall appCall, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        Intrinsics.checkNotNullParameter(applicationContext, "context");
        Validate.hasFacebookActivity(applicationContext, true);
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        Context applicationContext2 = FacebookSdk.getApplicationContext();
        Intrinsics.checkNotNullParameter(applicationContext2, "context");
        Validate.hasInternetPermissions(applicationContext2, true);
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        bundle2.putBundle(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, bundle);
        Intent intent = new Intent();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        String uuid = appCall.getCallId().toString();
        NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, uuid, str, NativeProtocol.getLatestKnownVersion(), bundle2);
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction("FacebookDialogFragment");
        appCall.setRequestIntent(intent);
    }

    public static final void startActivityForResultWithAndroidX(ActivityResultRegistry activityResultRegistry, CallbackManager callbackManager, Intent intent, int i) {
        Intrinsics.checkNotNullParameter(activityResultRegistry, "registry");
        Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        T register = activityResultRegistry.register(Intrinsics.stringPlus("facebook-dialog-request-", Integer.valueOf(i)), new DialogPresenter$startActivityForResultWithAndroidX$1(), new ActivityResultCallback(i, ref$ObjectRef) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ Ref$ObjectRef f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onActivityResult(Object obj) {
                DialogPresenter.m190startActivityForResultWithAndroidX$lambda2(CallbackManager.this, this.f$1, this.f$2, (Pair) obj);
            }
        });
        ref$ObjectRef.element = register;
        register.launch(intent);
    }

    /* renamed from: startActivityForResultWithAndroidX$lambda-2  reason: not valid java name */
    public static final void m190startActivityForResultWithAndroidX$lambda2(CallbackManager callbackManager, int i, Ref$ObjectRef ref$ObjectRef, Pair pair) {
        Intrinsics.checkNotNullParameter(ref$ObjectRef, "$launcher");
        if (callbackManager == null) {
            callbackManager = new CallbackManagerImpl();
        }
        Object obj = pair.first;
        Intrinsics.checkNotNullExpressionValue(obj, "result.first");
        callbackManager.onActivityResult(i, ((Number) obj).intValue(), (Intent) pair.second);
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) ref$ObjectRef.element;
        if (activityResultLauncher != null) {
            synchronized (activityResultLauncher) {
                activityResultLauncher.unregister();
                ref$ObjectRef.element = null;
            }
        }
    }
}
