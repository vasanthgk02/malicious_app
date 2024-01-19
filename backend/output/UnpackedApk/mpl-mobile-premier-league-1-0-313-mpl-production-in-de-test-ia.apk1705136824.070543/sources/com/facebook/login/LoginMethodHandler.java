package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient.Request;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.utils.Constant;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 52\u00020\u0001:\u00015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0014J\b\u0010\u001d\u001a\u00020\rH\u0014J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010 \u001a\u00020!H\u0016J\"\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0014J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020!H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u0010*\u001a\u00020+H&J\u0018\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020$H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R,\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00066"}, d2 = {"Lcom/facebook/login/LoginMethodHandler;", "Landroid/os/Parcelable;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "setLoginClient", "methodLoggingExtras", "", "", "getMethodLoggingExtras", "()Ljava/util/Map;", "setMethodLoggingExtras", "(Ljava/util/Map;)V", "nameForLogging", "getNameForLogging", "()Ljava/lang/String;", "addLoggingExtra", "", "key", "value", "", "cancel", "getClientState", "authId", "getRedirectUrl", "logWebLoginCompleted", "e2e", "needsInternetPermission", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "processCodeExchange", "Landroid/os/Bundle;", "request", "Lcom/facebook/login/LoginClient$Request;", "values", "putChallengeParam", "param", "Lorg/json/JSONObject;", "shouldKeepTrackOfMultipleIntents", "tryAuthorize", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginMethodHandler.kt */
public abstract class LoginMethodHandler implements Parcelable {
    public LoginClient loginClient;
    public Map<String, String> methodLoggingExtras;

    public LoginMethodHandler(LoginClient loginClient2) {
        Intrinsics.checkNotNullParameter(loginClient2, "loginClient");
        Intrinsics.checkNotNullParameter(loginClient2, "<set-?>");
        this.loginClient = loginClient2;
    }

    public static final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Bundle bundle2 = bundle;
        Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0));
        ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0));
        if (string != null) {
            boolean z = false;
            if (!(string.length() == 0)) {
                String string2 = bundle.getString("com.facebook.platform.extra.USER_ID");
                if (string2 != null) {
                    if (string2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        AccessToken accessToken = new AccessToken(string, str, string2, stringArrayList, null, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
                        return accessToken;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.facebook.AccessToken createAccessTokenFromWebBundle(java.util.Collection<java.lang.String> r16, android.os.Bundle r17, com.facebook.AccessTokenSource r18, java.lang.String r19) throws com.facebook.FacebookException {
        /*
            r0 = r17
            java.lang.String r1 = "bundle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "applicationId"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            java.lang.String r2 = "expires_in"
            java.util.Date r10 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r2, r1)
            java.lang.String r1 = "access_token"
            java.lang.String r3 = r0.getString(r1)
            r1 = 0
            if (r3 != 0) goto L_0x0023
            return r1
        L_0x0023:
            java.util.Date r2 = new java.util.Date
            r5 = 0
            r2.<init>(r5)
            java.lang.String r5 = "data_access_expiration_time"
            java.util.Date r12 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r5, r2)
            java.lang.String r2 = "granted_scopes"
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r5 = ","
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Array<T>"
            r7 = 6
            r8 = 0
            r9 = 1
            if (r2 == 0) goto L_0x006d
            int r11 = r2.length()
            if (r11 <= 0) goto L_0x0047
            r11 = 1
            goto L_0x0048
        L_0x0047:
            r11 = 0
        L_0x0048:
            if (r11 == 0) goto L_0x006d
            java.lang.String[] r11 = new java.lang.String[]{r5}
            java.util.List r2 = kotlin.text.CharsKt__CharKt.split$default(r2, r11, r8, r8, r7)
            java.lang.String[] r11 = new java.lang.String[r8]
            java.lang.Object[] r2 = r2.toArray(r11)
            if (r2 == 0) goto L_0x0067
            java.lang.String[] r2 = (java.lang.String[]) r2
            int r11 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r11)
            java.util.ArrayList r2 = com.twitter.sdk.android.tweetui.TweetUtils.arrayListOf(r2)
            r11 = r2
            goto L_0x006f
        L_0x0067:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r6)
            throw r0
        L_0x006d:
            r11 = r16
        L_0x006f:
            java.lang.String r2 = "denied_scopes"
            java.lang.String r2 = r0.getString(r2)
            if (r2 == 0) goto L_0x00a5
            int r13 = r2.length()
            if (r13 <= 0) goto L_0x007f
            r13 = 1
            goto L_0x0080
        L_0x007f:
            r13 = 0
        L_0x0080:
            if (r13 == 0) goto L_0x00a5
            java.lang.String[] r13 = new java.lang.String[]{r5}
            java.util.List r2 = kotlin.text.CharsKt__CharKt.split$default(r2, r13, r8, r8, r7)
            java.lang.String[] r13 = new java.lang.String[r8]
            java.lang.Object[] r2 = r2.toArray(r13)
            if (r2 == 0) goto L_0x009f
            java.lang.String[] r2 = (java.lang.String[]) r2
            int r13 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r13)
            java.util.ArrayList r2 = com.twitter.sdk.android.tweetui.TweetUtils.arrayListOf(r2)
            r13 = r2
            goto L_0x00a6
        L_0x009f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r6)
            throw r0
        L_0x00a5:
            r13 = r1
        L_0x00a6:
            java.lang.String r2 = "expired_scopes"
            java.lang.String r2 = r0.getString(r2)
            if (r2 == 0) goto L_0x00dc
            int r14 = r2.length()
            if (r14 <= 0) goto L_0x00b6
            r14 = 1
            goto L_0x00b7
        L_0x00b6:
            r14 = 0
        L_0x00b7:
            if (r14 == 0) goto L_0x00dc
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.util.List r2 = kotlin.text.CharsKt__CharKt.split$default(r2, r5, r8, r8, r7)
            java.lang.String[] r5 = new java.lang.String[r8]
            java.lang.Object[] r2 = r2.toArray(r5)
            if (r2 == 0) goto L_0x00d6
            java.lang.String[] r2 = (java.lang.String[]) r2
            int r5 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r5)
            java.util.ArrayList r2 = com.twitter.sdk.android.tweetui.TweetUtils.arrayListOf(r2)
            r14 = r2
            goto L_0x00dd
        L_0x00d6:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r6)
            throw r0
        L_0x00dc:
            r14 = r1
        L_0x00dd:
            boolean r2 = com.facebook.internal.Utility.isNullOrEmpty(r3)
            if (r2 == 0) goto L_0x00e4
            return r1
        L_0x00e4:
            java.lang.String r1 = "graph_domain"
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "signed_request"
            java.lang.String r0 = r0.getString(r2)
            if (r0 == 0) goto L_0x015a
            int r2 = r0.length()
            if (r2 != 0) goto L_0x00fa
            r2 = 1
            goto L_0x00fb
        L_0x00fa:
            r2 = 0
        L_0x00fb:
            if (r2 != 0) goto L_0x015a
            java.lang.String r2 = "."
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            java.util.List r0 = kotlin.text.CharsKt__CharKt.split$default(r0, r2, r8, r8, r7)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            java.lang.String[] r2 = new java.lang.String[r8]     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            java.lang.Object[] r0 = r0.toArray(r2)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            if (r0 == 0) goto L_0x014c
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            int r2 = r0.length     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            r5 = 2
            if (r2 != r5) goto L_0x0152
            r0 = r0[r9]     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            byte[] r0 = android.util.Base64.decode(r0, r8)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            java.lang.String r2 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            r5.<init>(r0, r2)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            r0.<init>(r5)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            java.lang.String r2 = "user_id"
            java.lang.String r5 = r0.getString(r2)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            java.lang.String r0 = "jsonObject.getString(\"user_id\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            com.facebook.AccessToken r0 = new com.facebook.AccessToken
            java.util.Date r15 = new java.util.Date
            r15.<init>()
            r2 = r0
            r4 = r19
            r6 = r11
            r7 = r13
            r8 = r14
            r9 = r18
            r11 = r15
            r13 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x014c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            r0.<init>(r6)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
            throw r0     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0152 }
        L_0x0152:
            com.facebook.FacebookException r0 = new com.facebook.FacebookException
            java.lang.String r1 = "Failed to retrieve user_id from signed_request"
            r0.<init>(r1)
            throw r0
        L_0x015a:
            com.facebook.FacebookException r0 = new com.facebook.FacebookException
            java.lang.String r1 = "Authorization response does not contain the signed_request"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginMethodHandler.createAccessTokenFromWebBundle(java.util.Collection, android.os.Bundle, com.facebook.AccessTokenSource, java.lang.String):com.facebook.AccessToken");
    }

    public void addLoggingExtra(String str, Object obj) {
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        Map<String, String> map = this.methodLoggingExtras;
        if (map != null) {
            String put = map.put(str, obj == null ? null : obj.toString());
        }
    }

    public void cancel() {
    }

    public String getClientState(String str) {
        Intrinsics.checkNotNullParameter(str, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e2) {
            Intrinsics.stringPlus("Error creating client state json: ", e2.getMessage());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "param.toString()");
        return jSONObject2;
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient2 = this.loginClient;
        if (loginClient2 != null) {
            return loginClient2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loginClient");
        throw null;
    }

    public abstract String getNameForLogging();

    public String getRedirectUrl() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("fb");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        outline73.append(FacebookSdk.getApplicationId());
        outline73.append("://authorize/");
        return outline73.toString();
    }

    public void logWebLoginCompleted(String str) {
        String str2;
        Request request = getLoginClient().pendingRequest;
        if (request == null) {
            str2 = null;
        } else {
            str2 = request.applicationId;
        }
        if (str2 == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str2 = FacebookSdk.getApplicationId();
        }
        AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl((Context) getLoginClient().getActivity(), str2, (AccessToken) null);
        Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
        Bundle outline14 = GeneratedOutlineSupport.outline14("fb_web_login_e2e", str);
        outline14.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        outline14.putString("app_id", str2);
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            appEventsLoggerImpl.logEventImplicitly("fb_dialogs_web_login_dialog_complete", null, outline14);
        }
    }

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    public Bundle processCodeExchange(Request request, Bundle bundle) throws FacebookException {
        GraphRequest graphRequest;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, "values");
        String string = bundle.getString("code");
        if (!Utility.isNullOrEmpty(string)) {
            String str = null;
            if (string == null) {
                graphRequest = null;
            } else {
                String redirectUrl = getRedirectUrl();
                String str2 = request.codeVerifier;
                if (str2 == null) {
                    str2 = "";
                }
                Intrinsics.checkNotNullParameter(string, "authorizationCode");
                Intrinsics.checkNotNullParameter(redirectUrl, "redirectUri");
                Intrinsics.checkNotNullParameter(str2, "codeVerifier");
                Bundle bundle2 = new Bundle();
                bundle2.putString("code", string);
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                bundle2.putString(PaymentConstants.CLIENT_ID, FacebookSdk.getApplicationId());
                bundle2.putString("redirect_uri", redirectUrl);
                bundle2.putString("code_verifier", str2);
                graphRequest = GraphRequest.Companion.newGraphPathRequest(null, "oauth/access_token", null);
                graphRequest.setHttpMethod(HttpMethod.GET);
                graphRequest.setParameters(bundle2);
            }
            if (graphRequest != null) {
                GraphResponse executeAndWait = graphRequest.executeAndWait();
                FacebookRequestError facebookRequestError = executeAndWait.error;
                if (facebookRequestError == null) {
                    try {
                        JSONObject jSONObject = executeAndWait.graphObject;
                        if (jSONObject != null) {
                            str = jSONObject.getString("access_token");
                        }
                        if (jSONObject == null || Utility.isNullOrEmpty(str)) {
                            throw new FacebookException((String) "No access token found from result");
                        }
                        bundle.putString("access_token", str);
                        if (jSONObject.has("id_token")) {
                            bundle.putString("id_token", jSONObject.getString("id_token"));
                        }
                        return bundle;
                    } catch (JSONException e2) {
                        throw new FacebookException(Intrinsics.stringPlus("Fail to process code exchange response: ", e2.getMessage()));
                    }
                } else {
                    throw new FacebookServiceException(facebookRequestError, facebookRequestError.getErrorMessage());
                }
            } else {
                throw new FacebookException((String) "Failed to create code exchange request");
            }
        } else {
            throw new FacebookException((String) "No code param found from the request");
        }
    }

    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "param");
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    public abstract int tryAuthorize(Request request);

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        Map<String, String> map = this.methodLoggingExtras;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public LoginMethodHandler(Parcel parcel) {
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(parcel, DefaultSettingsSpiCall.SOURCE_PARAM);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        Map<String, String> map = null;
        if (readInt < 0) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            int i = 0;
            if (readInt > 0) {
                do {
                    i++;
                    hashMap.put(parcel.readString(), parcel.readString());
                } while (i < readInt);
            }
        }
        this.methodLoggingExtras = hashMap != null ? ArraysKt___ArraysJvmKt.toMutableMap(hashMap) : map;
    }
}
