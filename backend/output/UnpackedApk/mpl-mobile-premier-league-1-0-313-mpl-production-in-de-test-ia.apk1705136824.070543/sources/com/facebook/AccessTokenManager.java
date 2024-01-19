package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AccessToken.AccessTokenRefreshCallback;
import com.facebook.AccessTokenManager.RefreshResult;
import com.facebook.GraphRequest.Callback;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.internal.Utility;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.paynimo.android.payment.util.Constant;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u001c\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\f\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/AccessTokenManager;", "", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "accessTokenCache", "Lcom/facebook/AccessTokenCache;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/facebook/AccessTokenCache;)V", "value", "Lcom/facebook/AccessToken;", "currentAccessToken", "getCurrentAccessToken", "()Lcom/facebook/AccessToken;", "setCurrentAccessToken", "(Lcom/facebook/AccessToken;)V", "currentAccessTokenField", "lastAttemptedTokenExtendDate", "Ljava/util/Date;", "tokenRefreshInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentAccessTokenChanged", "", "extendAccessTokenIfNeeded", "loadCurrentAccessToken", "", "refreshCurrentAccessToken", "callback", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "refreshCurrentAccessTokenImpl", "sendCurrentAccessTokenChangedBroadcastIntent", "oldAccessToken", "saveToCache", "setTokenExpirationBroadcastAlarm", "shouldExtendAccessToken", "Companion", "FacebookRefreshTokenInfo", "InstagramRefreshTokenInfo", "RefreshResult", "RefreshTokenInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AccessTokenManager.kt */
public final class AccessTokenManager {
    public static final Companion Companion = new Companion(null);
    public static AccessTokenManager instanceField;
    public final AccessTokenCache accessTokenCache;
    public AccessToken currentAccessTokenField;
    public Date lastAttemptedTokenExtendDate = new Date(0);
    public final LocalBroadcastManager localBroadcastManager;
    public final AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/AccessTokenManager$Companion;", "", "()V", "ACTION_CURRENT_ACCESS_TOKEN_CHANGED", "", "EXTRA_NEW_ACCESS_TOKEN", "EXTRA_OLD_ACCESS_TOKEN", "ME_PERMISSIONS_GRAPH_PATH", "SHARED_PREFERENCES_NAME", "TAG", "TOKEN_EXTEND_RETRY_SECONDS", "", "TOKEN_EXTEND_THRESHOLD_SECONDS", "instanceField", "Lcom/facebook/AccessTokenManager;", "createExtendAccessTokenRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "callback", "Lcom/facebook/GraphRequest$Callback;", "createGrantedPermissionsRequest", "getInstance", "getRefreshTokenInfoForToken", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessTokenManager.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AccessTokenManager getInstance() {
            AccessTokenManager accessTokenManager;
            AccessTokenManager accessTokenManager2 = AccessTokenManager.instanceField;
            if (accessTokenManager2 != null) {
                return accessTokenManager2;
            }
            synchronized (this) {
                try {
                    accessTokenManager = AccessTokenManager.instanceField;
                    if (accessTokenManager == null) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                        AccessTokenManager accessTokenManager3 = new AccessTokenManager(instance, new AccessTokenCache());
                        AccessTokenManager.instanceField = accessTokenManager3;
                        accessTokenManager = accessTokenManager3;
                    }
                }
            }
            return accessTokenManager;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$FacebookRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessTokenManager.kt */
    public static final class FacebookRefreshTokenInfo implements RefreshTokenInfo {
        public final String grantType = "fb_extend_sso_token";
        public final String graphPath = "oauth/access_token";

        public String getGrantType() {
            return this.grantType;
        }

        public String getGraphPath() {
            return this.graphPath;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$InstagramRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessTokenManager.kt */
    public static final class InstagramRefreshTokenInfo implements RefreshTokenInfo {
        public final String grantType = "ig_refresh_token";
        public final String graphPath = "refresh_access_token";

        public String getGrantType() {
            return this.grantType;
        }

        public String getGraphPath() {
            return this.graphPath;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshResult;", "", "()V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "dataAccessExpirationTime", "", "getDataAccessExpirationTime", "()Ljava/lang/Long;", "setDataAccessExpirationTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expiresAt", "", "getExpiresAt", "()I", "setExpiresAt", "(I)V", "expiresIn", "getExpiresIn", "setExpiresIn", "graphDomain", "getGraphDomain", "setGraphDomain", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessTokenManager.kt */
    public static final class RefreshResult {
        public String accessToken;
        public Long dataAccessExpirationTime;
        public int expiresAt;
        public int expiresIn;
        public String graphDomain;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessTokenManager.kt */
    public interface RefreshTokenInfo {
        String getGrantType();

        String getGraphPath();
    }

    public AccessTokenManager(LocalBroadcastManager localBroadcastManager2, AccessTokenCache accessTokenCache2) {
        Intrinsics.checkNotNullParameter(localBroadcastManager2, "localBroadcastManager");
        Intrinsics.checkNotNullParameter(accessTokenCache2, "accessTokenCache");
        this.localBroadcastManager = localBroadcastManager2;
        this.accessTokenCache = accessTokenCache2;
    }

    /* renamed from: refreshCurrentAccessToken$lambda-0  reason: not valid java name */
    public static final void m116refreshCurrentAccessToken$lambda0(AccessTokenManager accessTokenManager, AccessTokenRefreshCallback accessTokenRefreshCallback) {
        Intrinsics.checkNotNullParameter(accessTokenManager, "this$0");
        accessTokenManager.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
    }

    /* renamed from: refreshCurrentAccessTokenImpl$lambda-1  reason: not valid java name */
    public static final void m117refreshCurrentAccessTokenImpl$lambda1(AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "$permissionsCallSucceeded");
        Intrinsics.checkNotNullParameter(set, "$permissions");
        Intrinsics.checkNotNullParameter(set2, "$declinedPermissions");
        Intrinsics.checkNotNullParameter(set3, "$expiredPermissions");
        Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
        JSONObject jSONObject = graphResponse.jsonObject;
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                atomicBoolean.set(true);
                int i = 0;
                int length = optJSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i2 = i + 1;
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString(System.PERMISSION);
                            String optString2 = optJSONObject.optString("status");
                            if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                                Intrinsics.checkNotNullExpressionValue(optString2, "status");
                                Locale locale = Locale.US;
                                Intrinsics.checkNotNullExpressionValue(locale, "US");
                                String lowerCase = optString2.toLowerCase(locale);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "status");
                                int hashCode = lowerCase.hashCode();
                                if (hashCode != -1309235419) {
                                    if (hashCode != 280295099) {
                                        if (hashCode == 568196142 && lowerCase.equals("declined")) {
                                            set2.add(optString);
                                        }
                                    } else if (lowerCase.equals("granted")) {
                                        set.add(optString);
                                    }
                                } else if (lowerCase.equals("expired")) {
                                    set3.add(optString);
                                }
                                Intrinsics.stringPlus("Unexpected status: ", lowerCase);
                            }
                        }
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    }
                }
            }
        }
    }

    /* renamed from: refreshCurrentAccessTokenImpl$lambda-2  reason: not valid java name */
    public static final void m118refreshCurrentAccessTokenImpl$lambda2(RefreshResult refreshResult, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(refreshResult, "$refreshResult");
        Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
        JSONObject jSONObject = graphResponse.jsonObject;
        if (jSONObject != null) {
            refreshResult.accessToken = jSONObject.optString("access_token");
            refreshResult.expiresAt = jSONObject.optInt(SettingsJsonConstants.EXPIRES_AT_KEY);
            refreshResult.expiresIn = jSONObject.optInt("expires_in");
            refreshResult.dataAccessExpirationTime = Long.valueOf(jSONObject.optLong("data_access_expiration_time"));
            refreshResult.graphDomain = jSONObject.optString("graph_domain", null);
        }
    }

    /* renamed from: refreshCurrentAccessTokenImpl$lambda-3  reason: not valid java name */
    public static final void m119refreshCurrentAccessTokenImpl$lambda3(RefreshResult refreshResult, AccessToken accessToken, AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, AccessTokenManager accessTokenManager, GraphRequestBatch graphRequestBatch) {
        AccessToken accessToken2;
        String str;
        Set set4;
        Set set5;
        Set set6;
        Date date;
        RefreshResult refreshResult2 = refreshResult;
        AccessToken accessToken3 = accessToken;
        AccessTokenManager accessTokenManager2 = accessTokenManager;
        Intrinsics.checkNotNullParameter(refreshResult2, "$refreshResult");
        Intrinsics.checkNotNullParameter(atomicBoolean, "$permissionsCallSucceeded");
        Intrinsics.checkNotNullParameter(set, "$permissions");
        Set set7 = set2;
        Intrinsics.checkNotNullParameter(set7, "$declinedPermissions");
        Set set8 = set3;
        Intrinsics.checkNotNullParameter(set8, "$expiredPermissions");
        Intrinsics.checkNotNullParameter(accessTokenManager2, "this$0");
        Intrinsics.checkNotNullParameter(graphRequestBatch, "it");
        String str2 = refreshResult2.accessToken;
        int i = refreshResult2.expiresAt;
        Long l = refreshResult2.dataAccessExpirationTime;
        String str3 = refreshResult2.graphDomain;
        try {
            if (Companion.getInstance().currentAccessTokenField != null) {
                AccessToken accessToken4 = Companion.getInstance().currentAccessTokenField;
                if (accessToken4 == null) {
                    str = null;
                } else {
                    str = accessToken4.userId;
                }
                if (str == accessToken3.userId) {
                    if (!atomicBoolean.get() && str2 == null && i == 0) {
                        if (accessTokenRefreshCallback != null) {
                            promise.reject((Throwable) new FacebookException((String) "Failed to refresh access token"));
                        }
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        return;
                    }
                    Date date2 = accessToken3.expires;
                    if (refreshResult2.expiresAt != 0) {
                        date2 = new Date(((long) refreshResult2.expiresAt) * 1000);
                    } else if (refreshResult2.expiresIn != 0) {
                        date2 = new Date((((long) refreshResult2.expiresIn) * 1000) + new Date().getTime());
                    }
                    Date date3 = date2;
                    if (str2 == null) {
                        str2 = accessToken3.token;
                    }
                    String str4 = str2;
                    String str5 = accessToken3.applicationId;
                    String str6 = accessToken3.userId;
                    if (atomicBoolean.get()) {
                        set4 = set;
                    } else {
                        set4 = accessToken3.permissions;
                    }
                    if (atomicBoolean.get()) {
                        set5 = set7;
                    } else {
                        set5 = accessToken3.declinedPermissions;
                    }
                    if (atomicBoolean.get()) {
                        set6 = set8;
                    } else {
                        set6 = accessToken3.expiredPermissions;
                    }
                    AccessTokenSource accessTokenSource = accessToken3.source;
                    Date date4 = new Date();
                    if (l != null) {
                        date = new Date(l.longValue() * 1000);
                    } else {
                        date = accessToken3.dataAccessExpirationTime;
                    }
                    Date date5 = date;
                    if (str3 == null) {
                        str3 = accessToken3.graphDomain;
                    }
                    AccessToken accessToken5 = new AccessToken(str4, str5, str6, set4, set5, set6, accessTokenSource, date3, date4, date5, str3);
                    try {
                        Companion.getInstance().setCurrentAccessToken(accessToken5, true);
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        if (accessTokenRefreshCallback != null) {
                            promise.resolve(ImageOriginUtils.accessTokenToReactMap(accessToken5));
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        accessToken2 = accessToken5;
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        promise.resolve(ImageOriginUtils.accessTokenToReactMap(accessToken2));
                        throw th;
                    }
                }
            }
            if (accessTokenRefreshCallback != null) {
                promise.reject((Throwable) new FacebookException((String) "No current access token to refresh"));
            }
            accessTokenManager2.tokenRefreshInProgress.set(false);
        } catch (Throwable th2) {
            th = th2;
            accessToken2 = null;
            accessTokenManager2.tokenRefreshInProgress.set(false);
            if (!(accessTokenRefreshCallback == null || accessToken2 == null)) {
                promise.resolve(ImageOriginUtils.accessTokenToReactMap(accessToken2));
            }
            throw th;
        }
    }

    public final void refreshCurrentAccessToken(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(accessTokenRefreshCallback) {
                public final /* synthetic */ AccessTokenRefreshCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AccessTokenManager.m116refreshCurrentAccessToken$lambda0(AccessTokenManager.this, this.f$1);
                }
            });
        }
    }

    public final void refreshCurrentAccessTokenImpl(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        RefreshTokenInfo refreshTokenInfo;
        AccessToken accessToken = this.currentAccessTokenField;
        if (accessToken == null) {
            if (accessTokenRefreshCallback != null) {
                promise.reject((Throwable) new FacebookException((String) "No current access token to refresh"));
            }
        } else if (!this.tokenRefreshInProgress.compareAndSet(false, true)) {
            if (accessTokenRefreshCallback != null) {
                promise.reject((Throwable) new FacebookException((String) "Refresh already in progress"));
            }
        } else {
            this.lastAttemptedTokenExtendDate = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            RefreshResult refreshResult = new RefreshResult();
            GraphRequest[] graphRequestArr = new GraphRequest[2];
            $$Lambda$qr58hoCj3b9aeCjc5NtNFJ6VtD0 r11 = new Callback(atomicBoolean, hashSet, hashSet2, hashSet3) {
                public final /* synthetic */ AtomicBoolean f$0;
                public final /* synthetic */ Set f$1;
                public final /* synthetic */ Set f$2;
                public final /* synthetic */ Set f$3;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onCompleted(GraphResponse graphResponse) {
                    AccessTokenManager.m117refreshCurrentAccessTokenImpl$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, graphResponse);
                }
            };
            Bundle outline14 = GeneratedOutlineSupport.outline14("fields", "permission,status");
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, "me/permissions", r11);
            newGraphPathRequest.setParameters(outline14);
            newGraphPathRequest.setHttpMethod(HttpMethod.GET);
            graphRequestArr[0] = newGraphPathRequest;
            $$Lambda$7xgZAkCcHWtoSy0BWsKds83ld_0 r1 = new Callback() {
                public final void onCompleted(GraphResponse graphResponse) {
                    AccessTokenManager.m118refreshCurrentAccessTokenImpl$lambda2(RefreshResult.this, graphResponse);
                }
            };
            String str = accessToken.graphDomain;
            if (str == null) {
                str = "facebook";
            }
            if (Intrinsics.areEqual(str, "instagram")) {
                refreshTokenInfo = new InstagramRefreshTokenInfo();
            } else {
                refreshTokenInfo = new FacebookRefreshTokenInfo();
            }
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", refreshTokenInfo.getGrantType());
            bundle.putString(PaymentConstants.CLIENT_ID, accessToken.applicationId);
            bundle.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest newGraphPathRequest2 = GraphRequest.Companion.newGraphPathRequest(accessToken, refreshTokenInfo.getGraphPath(), r1);
            newGraphPathRequest2.setParameters(bundle);
            newGraphPathRequest2.setHttpMethod(HttpMethod.GET);
            graphRequestArr[1] = newGraphPathRequest2;
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(graphRequestArr);
            $$Lambda$1e08RsfxcSZVS7wtNV0wPmpXMU r0 = new GraphRequestBatch.Callback(accessToken, accessTokenRefreshCallback, atomicBoolean, hashSet, hashSet2, hashSet3, this) {
                public final /* synthetic */ AccessToken f$1;
                public final /* synthetic */ AccessTokenRefreshCallback f$2;
                public final /* synthetic */ AtomicBoolean f$3;
                public final /* synthetic */ Set f$4;
                public final /* synthetic */ Set f$5;
                public final /* synthetic */ Set f$6;
                public final /* synthetic */ AccessTokenManager f$7;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                    this.f$7 = r8;
                }

                public final void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                    AccessTokenManager.m119refreshCurrentAccessTokenImpl$lambda3(RefreshResult.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, graphRequestBatch);
                }
            };
            Intrinsics.checkNotNullParameter(r0, "callback");
            if (!graphRequestBatch.callbacks.contains(r0)) {
                graphRequestBatch.callbacks.add(r0);
            }
            graphRequestBatch.executeAsync();
        }
    }

    public final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    public final void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        Date date;
        PendingIntent pendingIntent;
        AccessToken accessToken2 = this.currentAccessTokenField;
        this.currentAccessTokenField = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                GeneratedOutlineSupport.outline93(this.accessTokenCache.sharedPreferences, "com.facebook.AccessTokenManager.CachedAccessToken");
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            com.facebook.AccessToken.Companion companion = AccessToken.Companion;
            AccessToken currentAccessToken = com.facebook.AccessToken.Companion.getCurrentAccessToken();
            AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
            com.facebook.AccessToken.Companion companion2 = AccessToken.Companion;
            if (com.facebook.AccessToken.Companion.isCurrentAccessTokenActive()) {
                if (currentAccessToken == null) {
                    date = null;
                } else {
                    date = currentAccessToken.expires;
                }
                if (date != null && alarmManager != null) {
                    Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
                    intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
                    if (VERSION.SDK_INT >= 23) {
                        pendingIntent = PendingIntent.getBroadcast(applicationContext, 0, intent, PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
                    } else {
                        pendingIntent = PendingIntent.getBroadcast(applicationContext, 0, intent, 0);
                    }
                    try {
                        alarmManager.set(1, currentAccessToken.expires.getTime(), pendingIntent);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
