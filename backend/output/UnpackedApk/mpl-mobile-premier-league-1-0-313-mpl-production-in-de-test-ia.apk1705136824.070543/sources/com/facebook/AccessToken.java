package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 E2\u00020\u0001:\u0003CDEB\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011B\u000f\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0014\u0010.\u001a\u00020/2\n\u00100\u001a\u000601j\u0002`2H\u0002J\u001a\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u00105\u001a\u000206H\u0016J\u0013\u00107\u001a\u00020!2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\b\u0010:\u001a\u000206H\u0016J\r\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\b=J\b\u0010>\u001a\u00020\u0003H\u0016J\b\u0010?\u001a\u00020\u0003H\u0002J\u0018\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u000206H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b \u0010\"R\u0011\u0010#\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u0011\u0010$\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0011\u0010%\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010(\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0016¨\u0006F"}, d2 = {"Lcom/facebook/AccessToken;", "Landroid/os/Parcelable;", "accessToken", "", "applicationId", "userId", "permissions", "", "declinedPermissions", "expiredPermissions", "accessTokenSource", "Lcom/facebook/AccessTokenSource;", "expirationTime", "Ljava/util/Date;", "lastRefreshTime", "dataAccessExpirationTime", "graphDomain", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Lcom/facebook/AccessTokenSource;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getApplicationId", "()Ljava/lang/String;", "getDataAccessExpirationTime", "()Ljava/util/Date;", "", "getDeclinedPermissions", "()Ljava/util/Set;", "getExpiredPermissions", "expires", "getExpires", "getGraphDomain", "isDataAccessExpired", "", "()Z", "isExpired", "isInstagramToken", "lastRefresh", "getLastRefresh", "getPermissions", "source", "getSource", "()Lcom/facebook/AccessTokenSource;", "token", "getToken", "getUserId", "appendPermissions", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "convertTokenSourceForGraphDomain", "tokenSource", "describeContents", "", "equals", "other", "", "hashCode", "toJSONObject", "Lorg/json/JSONObject;", "toJSONObject$facebook_core_release", "toString", "tokenToString", "writeToParcel", "dest", "flags", "AccessTokenCreationCallback", "AccessTokenRefreshCallback", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AccessToken.kt */
public final class AccessToken implements Parcelable {
    public static final Creator<AccessToken> CREATOR = new AccessToken$Companion$CREATOR$1();
    public static final Companion Companion = null;
    public static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    public static final Date DEFAULT_EXPIRATION_TIME;
    public static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
    public static final Date MAX_DATE;
    public final String applicationId;
    public final Date dataAccessExpirationTime;
    public final Set<String> declinedPermissions;
    public final Set<String> expiredPermissions;
    public final Date expires;
    public final String graphDomain;
    public final Date lastRefresh;
    public final Set<String> permissions;
    public final AccessTokenSource source;
    public final String token;
    public final String userId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "", "OnTokenRefreshFailed", "", "exception", "Lcom/facebook/FacebookException;", "OnTokenRefreshed", "accessToken", "Lcom/facebook/AccessToken;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessToken.kt */
    public interface AccessTokenRefreshCallback {
    }

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0000¢\u0006\u0002\b J<\u0010!\u001a\u0004\u0018\u00010\b2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0015\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,J\u0017\u0010-\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b.J \u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\u00042\u0006\u00103\u001a\u000204H\u0007J\u001f\u00105\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b6J\b\u00107\u001a\u000200H\u0007J\n\u00108\u001a\u0004\u0018\u00010\bH\u0007J'\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040#2\u0006\u0010$\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b;J\b\u0010<\u001a\u00020=H\u0007J\b\u0010>\u001a\u00020=H\u0007J\b\u0010?\u001a\u00020=H\u0007J\b\u0010@\u001a\u000200H\u0007J\u0012\u0010@\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010BH\u0007J\u0012\u0010C\u001a\u0002002\b\u0010D\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/facebook/AccessToken$Companion;", "", "()V", "ACCESS_TOKEN_KEY", "", "APPLICATION_ID_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AccessToken;", "CURRENT_JSON_FORMAT", "", "DATA_ACCESS_EXPIRATION_TIME", "DECLINED_PERMISSIONS_KEY", "DEFAULT_ACCESS_TOKEN_SOURCE", "Lcom/facebook/AccessTokenSource;", "DEFAULT_EXPIRATION_TIME", "Ljava/util/Date;", "DEFAULT_GRAPH_DOMAIN", "DEFAULT_LAST_REFRESH_TIME", "EXPIRED_PERMISSIONS_KEY", "EXPIRES_AT_KEY", "EXPIRES_IN_KEY", "GRAPH_DOMAIN", "LAST_REFRESH_KEY", "MAX_DATE", "PERMISSIONS_KEY", "SOURCE_KEY", "TOKEN_KEY", "USER_ID_KEY", "VERSION_KEY", "createExpired", "current", "createExpired$facebook_core_release", "createFromBundle", "requestedPermissions", "", "bundle", "Landroid/os/Bundle;", "source", "expirationBase", "applicationId", "createFromJSONObject", "jsonObject", "Lorg/json/JSONObject;", "createFromJSONObject$facebook_core_release", "createFromLegacyCache", "createFromLegacyCache$facebook_core_release", "createFromNativeLinkingIntent", "", "intent", "Landroid/content/Intent;", "accessTokenCallback", "Lcom/facebook/AccessToken$AccessTokenCreationCallback;", "createFromRefresh", "createFromRefresh$facebook_core_release", "expireCurrentAccessToken", "getCurrentAccessToken", "getPermissionsFromBundle", "key", "getPermissionsFromBundle$facebook_core_release", "isCurrentAccessTokenActive", "", "isDataAccessActive", "isLoggedInWithInstagram", "refreshCurrentAccessTokenAsync", "callback", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "setCurrentAccessToken", "accessToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessToken.kt */
    public static final class Companion {
        public static final AccessToken createFromJSONObject$facebook_core_release(JSONObject jSONObject) throws JSONException {
            Collection collection;
            Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
            if (jSONObject.getInt("version") <= 1) {
                String string = jSONObject.getString("token");
                Date date = new Date(jSONObject.getLong(SettingsJsonConstants.EXPIRES_AT_KEY));
                JSONArray jSONArray = jSONObject.getJSONArray("permissions");
                JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
                JSONArray optJSONArray = jSONObject.optJSONArray("expired_permissions");
                Date date2 = new Date(jSONObject.getLong("last_refresh"));
                String string2 = jSONObject.getString(DefaultSettingsSpiCall.SOURCE_PARAM);
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(SOURCE_KEY)");
                AccessTokenSource valueOf = AccessTokenSource.valueOf(string2);
                String string3 = jSONObject.getString("application_id");
                String string4 = jSONObject.getString("user_id");
                Date date3 = new Date(jSONObject.optLong("data_access_expiration_time", 0));
                String optString = jSONObject.optString("graph_domain", null);
                Intrinsics.checkNotNullExpressionValue(string, "token");
                Intrinsics.checkNotNullExpressionValue(string3, "applicationId");
                Intrinsics.checkNotNullExpressionValue(string4, "userId");
                Intrinsics.checkNotNullExpressionValue(jSONArray, "permissionsArray");
                List<String> jsonArrayToStringList = Utility.jsonArrayToStringList(jSONArray);
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "declinedPermissionsArray");
                List<String> jsonArrayToStringList2 = Utility.jsonArrayToStringList(jSONArray2);
                if (optJSONArray == null) {
                    collection = new ArrayList();
                } else {
                    collection = Utility.jsonArrayToStringList(optJSONArray);
                }
                AccessToken accessToken = new AccessToken(string, string3, string4, jsonArrayToStringList, jsonArrayToStringList2, collection, valueOf, date, date2, date3, optString);
                return accessToken;
            }
            throw new FacebookException((String) "Unknown AccessToken serialization format.");
        }

        public static final AccessToken getCurrentAccessToken() {
            return AccessTokenManager.Companion.getInstance().currentAccessTokenField;
        }

        public static final boolean isCurrentAccessTokenActive() {
            AccessToken accessToken = AccessTokenManager.Companion.getInstance().currentAccessTokenField;
            return accessToken != null && !accessToken.isExpired();
        }

        public static final void setCurrentAccessToken(AccessToken accessToken) {
            AccessTokenManager.Companion.getInstance().setCurrentAccessToken(accessToken, true);
        }
    }

    static {
        Date date = new Date(Long.MAX_VALUE);
        MAX_DATE = date;
        DEFAULT_EXPIRATION_TIME = date;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        // GeneratedOutlineSupport.outline97(str, "accessToken", str2, "applicationId", str3, "userId");
        this(str, str2, str3, collection, collection2, collection3, accessTokenSource, date, date2, date3, null, 1024);
    }

    public /* synthetic */ AccessToken(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3, String str4, int i) {
        this(str, str2, str3, collection, collection2, collection3, accessTokenSource, date, date2, date3, (i & 1024) != 0 ? "facebook" : null);
    }

    public static final AccessToken getCurrentAccessToken() {
        return AccessTokenManager.Companion.getInstance().currentAccessTokenField;
    }

    public static final void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessTokenManager.Companion.getInstance().refreshCurrentAccessToken(accessTokenRefreshCallback);
    }

    public static final void setCurrentAccessToken(AccessToken accessToken) {
        AccessTokenManager.Companion.getInstance().setCurrentAccessToken(accessToken, true);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
        if ((r1 == null ? r5 == null : kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)) != false) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.facebook.AccessToken
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Date r1 = r4.expires
            com.facebook.AccessToken r5 = (com.facebook.AccessToken) r5
            java.util.Date r3 = r5.expires
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x007f
            java.util.Set<java.lang.String> r1 = r4.permissions
            java.util.Set<java.lang.String> r3 = r5.permissions
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x007f
            java.util.Set<java.lang.String> r1 = r4.declinedPermissions
            java.util.Set<java.lang.String> r3 = r5.declinedPermissions
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x007f
            java.util.Set<java.lang.String> r1 = r4.expiredPermissions
            java.util.Set<java.lang.String> r3 = r5.expiredPermissions
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x007f
            java.lang.String r1 = r4.token
            java.lang.String r3 = r5.token
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x007f
            com.facebook.AccessTokenSource r1 = r4.source
            com.facebook.AccessTokenSource r3 = r5.source
            if (r1 != r3) goto L_0x007f
            java.util.Date r1 = r4.lastRefresh
            java.util.Date r3 = r5.lastRefresh
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x007f
            java.lang.String r1 = r4.applicationId
            java.lang.String r3 = r5.applicationId
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x007f
            java.lang.String r1 = r4.userId
            java.lang.String r3 = r5.userId
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x007f
            java.util.Date r1 = r4.dataAccessExpirationTime
            java.util.Date r3 = r5.dataAccessExpirationTime
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x007f
            java.lang.String r1 = r4.graphDomain
            java.lang.String r5 = r5.graphDomain
            if (r1 != 0) goto L_0x0078
            if (r5 != 0) goto L_0x0076
            r5 = 1
            goto L_0x007c
        L_0x0076:
            r5 = 0
            goto L_0x007c
        L_0x0078:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
        L_0x007c:
            if (r5 == 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r0 = 0
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessToken.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = this.permissions.hashCode();
        int hashCode2 = this.declinedPermissions.hashCode();
        int outline11 = GeneratedOutlineSupport.outline11(this.token, (this.expiredPermissions.hashCode() + ((hashCode2 + ((hashCode + ((this.expires.hashCode() + 527) * 31)) * 31)) * 31)) * 31, 31);
        int hashCode3 = (this.dataAccessExpirationTime.hashCode() + GeneratedOutlineSupport.outline11(this.userId, GeneratedOutlineSupport.outline11(this.applicationId, (this.lastRefresh.hashCode() + ((this.source.hashCode() + outline11) * 31)) * 31, 31), 31)) * 31;
        String str = this.graphDomain;
        return hashCode3 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isExpired() {
        return new Date().after(this.expires);
    }

    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.token);
        jSONObject.put(SettingsJsonConstants.EXPIRES_AT_KEY, this.expires.getTime());
        jSONObject.put("permissions", new JSONArray(this.permissions));
        jSONObject.put("declined_permissions", new JSONArray(this.declinedPermissions));
        jSONObject.put("expired_permissions", new JSONArray(this.expiredPermissions));
        jSONObject.put("last_refresh", this.lastRefresh.getTime());
        jSONObject.put(DefaultSettingsSpiCall.SOURCE_PARAM, this.source.name());
        jSONObject.put("application_id", this.applicationId);
        jSONObject.put("user_id", this.userId);
        jSONObject.put("data_access_expiration_time", this.dataAccessExpirationTime.getTime());
        String str = this.graphDomain;
        if (str != null) {
            jSONObject.put("graph_domain", str);
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("{AccessToken", " token:");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        GeneratedOutlineSupport.outline102(outline78, FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS) ? this.token : "ACCESS_TOKEN_REMOVED", " permissions:", "[");
        outline78.append(TextUtils.join(", ", this.permissions));
        outline78.append(CMapParser.MARK_END_OF_ARRAY);
        outline78.append("}");
        String sb = outline78.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "builder.toString()");
        return sb;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(this.expires.getTime());
        parcel.writeStringList(new ArrayList(this.permissions));
        parcel.writeStringList(new ArrayList(this.declinedPermissions));
        parcel.writeStringList(new ArrayList(this.expiredPermissions));
        parcel.writeString(this.token);
        parcel.writeString(this.source.name());
        parcel.writeLong(this.lastRefresh.getTime());
        parcel.writeString(this.applicationId);
        parcel.writeString(this.userId);
        parcel.writeLong(this.dataAccessExpirationTime.getTime());
        parcel.writeString(this.graphDomain);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009d, code lost:
        r1 = com.facebook.AccessTokenSource.INSTAGRAM_CUSTOM_CHROME_TAB;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AccessToken(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.util.Collection<java.lang.String> r21, java.util.Collection<java.lang.String> r22, java.util.Collection<java.lang.String> r23, com.facebook.AccessTokenSource r24, java.util.Date r25, java.util.Date r26, java.util.Date r27, java.lang.String r28) {
        /*
            r17 = this;
            r0 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r28
            java.lang.String r14 = "accessToken"
            java.lang.String r15 = "applicationId"
            java.lang.String r6 = "userId"
            r1 = r18
            r2 = r14
            r3 = r19
            r4 = r15
            r5 = r20
            r16 = r6
            com.android.tools.r8.GeneratedOutlineSupport.outline97(r1, r2, r3, r4, r5, r6)
            r17.<init>()
            com.facebook.internal.Validate.notEmpty(r7, r14)
            com.facebook.internal.Validate.notEmpty(r8, r15)
            r1 = r16
            com.facebook.internal.Validate.notEmpty(r9, r1)
            if (r25 != 0) goto L_0x0036
            java.util.Date r1 = DEFAULT_EXPIRATION_TIME
            goto L_0x0038
        L_0x0036:
            r1 = r25
        L_0x0038:
            r0.expires = r1
            java.util.HashSet r1 = new java.util.HashSet
            if (r10 == 0) goto L_0x0042
            r1.<init>(r10)
            goto L_0x0045
        L_0x0042:
            r1.<init>()
        L_0x0045:
            java.util.Set r1 = java.util.Collections.unmodifiableSet(r1)
            java.lang.String r2 = "unmodifiableSet(if (permissions != null) HashSet(permissions) else HashSet())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.permissions = r1
            java.util.HashSet r1 = new java.util.HashSet
            if (r11 == 0) goto L_0x0058
            r1.<init>(r11)
            goto L_0x005b
        L_0x0058:
            r1.<init>()
        L_0x005b:
            java.util.Set r1 = java.util.Collections.unmodifiableSet(r1)
            java.lang.String r2 = "unmodifiableSet(\n            if (declinedPermissions != null) HashSet(declinedPermissions) else HashSet())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.declinedPermissions = r1
            java.util.HashSet r1 = new java.util.HashSet
            if (r12 == 0) goto L_0x006e
            r1.<init>(r12)
            goto L_0x0071
        L_0x006e:
            r1.<init>()
        L_0x0071:
            java.util.Set r1 = java.util.Collections.unmodifiableSet(r1)
            java.lang.String r2 = "unmodifiableSet(\n            if (expiredPermissions != null) HashSet(expiredPermissions) else HashSet())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.expiredPermissions = r1
            r0.token = r7
            if (r24 != 0) goto L_0x0083
            com.facebook.AccessTokenSource r1 = DEFAULT_ACCESS_TOKEN_SOURCE
            goto L_0x0085
        L_0x0083:
            r1 = r24
        L_0x0085:
            if (r13 == 0) goto L_0x00a5
            java.lang.String r2 = "instagram"
            boolean r2 = r13.equals(r2)
            if (r2 == 0) goto L_0x00a5
            int r2 = r1.ordinal()
            r3 = 1
            if (r2 == r3) goto L_0x00a3
            r3 = 4
            if (r2 == r3) goto L_0x00a0
            r3 = 5
            if (r2 == r3) goto L_0x009d
            goto L_0x00a5
        L_0x009d:
            com.facebook.AccessTokenSource r1 = com.facebook.AccessTokenSource.INSTAGRAM_CUSTOM_CHROME_TAB
            goto L_0x00a5
        L_0x00a0:
            com.facebook.AccessTokenSource r1 = com.facebook.AccessTokenSource.INSTAGRAM_WEB_VIEW
            goto L_0x00a5
        L_0x00a3:
            com.facebook.AccessTokenSource r1 = com.facebook.AccessTokenSource.INSTAGRAM_APPLICATION_WEB
        L_0x00a5:
            r0.source = r1
            if (r26 != 0) goto L_0x00ac
            java.util.Date r1 = DEFAULT_LAST_REFRESH_TIME
            goto L_0x00ae
        L_0x00ac:
            r1 = r26
        L_0x00ae:
            r0.lastRefresh = r1
            r0.applicationId = r8
            r0.userId = r9
            if (r27 == 0) goto L_0x00c3
            long r1 = r27.getTime()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00c3
            r1 = r27
            goto L_0x00c5
        L_0x00c3:
            java.util.Date r1 = DEFAULT_EXPIRATION_TIME
        L_0x00c5:
            r0.dataAccessExpirationTime = r1
            if (r13 != 0) goto L_0x00cc
            java.lang.String r1 = "facebook"
            r13 = r1
        L_0x00cc:
            r0.graphDomain = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessToken.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.util.Collection, java.util.Collection, com.facebook.AccessTokenSource, java.util.Date, java.util.Date, java.util.Date, java.lang.String):void");
    }

    public AccessToken(Parcel parcel) {
        AccessTokenSource accessTokenSource;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.expires = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        Set<String> unmodifiableSet = Collections.unmodifiableSet(new HashSet(arrayList));
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(HashSet(permissionsList))");
        this.permissions = unmodifiableSet;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set<String> unmodifiableSet2 = Collections.unmodifiableSet(new HashSet(arrayList));
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet2, "unmodifiableSet(HashSet(permissionsList))");
        this.declinedPermissions = unmodifiableSet2;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set<String> unmodifiableSet3 = Collections.unmodifiableSet(new HashSet(arrayList));
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet3, "unmodifiableSet(HashSet(permissionsList))");
        this.expiredPermissions = unmodifiableSet3;
        String readString = parcel.readString();
        Validate.notNullOrEmpty(readString, "token");
        this.token = readString;
        String readString2 = parcel.readString();
        if (readString2 != null) {
            accessTokenSource = AccessTokenSource.valueOf(readString2);
        } else {
            accessTokenSource = DEFAULT_ACCESS_TOKEN_SOURCE;
        }
        this.source = accessTokenSource;
        this.lastRefresh = new Date(parcel.readLong());
        String readString3 = parcel.readString();
        Validate.notNullOrEmpty(readString3, "applicationId");
        this.applicationId = readString3;
        String readString4 = parcel.readString();
        Validate.notNullOrEmpty(readString4, "userId");
        this.userId = readString4;
        this.dataAccessExpirationTime = new Date(parcel.readLong());
        this.graphDomain = parcel.readString();
    }
}
