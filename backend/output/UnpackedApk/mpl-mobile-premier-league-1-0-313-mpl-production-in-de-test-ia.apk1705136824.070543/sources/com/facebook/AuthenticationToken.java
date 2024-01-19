package com.facebook;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AuthenticationTokenManager.Companion;
import com.facebook.AuthenticationTokenManager.CurrentAuthenticationTokenChangedBroadcastReceiver;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.IOException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J(\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002J\r\u0010%\u001a\u00020\nH\u0000¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u001aH\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006,"}, d2 = {"Lcom/facebook/AuthenticationToken;", "Landroid/os/Parcelable;", "token", "", "expectedNonce", "(Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "claims", "Lcom/facebook/AuthenticationTokenClaims;", "getClaims", "()Lcom/facebook/AuthenticationTokenClaims;", "getExpectedNonce", "()Ljava/lang/String;", "header", "Lcom/facebook/AuthenticationTokenHeader;", "getHeader", "()Lcom/facebook/AuthenticationTokenHeader;", "signature", "getSignature", "getToken", "describeContents", "", "equals", "", "other", "", "hashCode", "isValidSignature", "headerString", "claimsString", "sigString", "kid", "toJSONObject", "toJSONObject$facebook_core_release", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuthenticationToken.kt */
public final class AuthenticationToken implements Parcelable {
    public static final Creator<AuthenticationToken> CREATOR = new AuthenticationToken$Companion$CREATOR$1();
    public final AuthenticationTokenClaims claims;
    public final String expectedNonce;
    public final AuthenticationTokenHeader header;
    public final String signature;
    public final String token;

    public AuthenticationToken(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "expectedNonce");
        Validate.notEmpty(str, "token");
        Validate.notEmpty(str2, "expectedNonce");
        boolean z = false;
        List split$default = CharsKt__CharKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6);
        if (split$default.size() == 3) {
            String str3 = (String) split$default.get(0);
            String str4 = (String) split$default.get(1);
            String str5 = (String) split$default.get(2);
            this.token = str;
            this.expectedNonce = str2;
            this.header = new AuthenticationTokenHeader(str3);
            this.claims = new AuthenticationTokenClaims(str4, str2);
            try {
                String rawKeyFromEndPoint = OidcSecurityUtil.getRawKeyFromEndPoint(this.header.kid);
                if (rawKeyFromEndPoint != null) {
                    PublicKey publicKeyFromString = OidcSecurityUtil.getPublicKeyFromString(rawKeyFromEndPoint);
                    z = OidcSecurityUtil.verify(publicKeyFromString, str3 + '.' + str4, str5);
                }
            } catch (IOException | InvalidKeySpecException unused) {
            }
            if (z) {
                this.signature = str5;
                return;
            }
            throw new IllegalArgumentException("Invalid Signature".toString());
        }
        throw new IllegalArgumentException("Invalid IdToken string".toString());
    }

    public static final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken) {
        Companion companion = AuthenticationTokenManager.Companion;
        AuthenticationTokenManager authenticationTokenManager = AuthenticationTokenManager.instanceField;
        if (authenticationTokenManager == null) {
            synchronized (companion) {
                authenticationTokenManager = AuthenticationTokenManager.instanceField;
                if (authenticationTokenManager == null) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                    AuthenticationTokenManager authenticationTokenManager2 = new AuthenticationTokenManager(instance, new AuthenticationTokenCache());
                    AuthenticationTokenManager.instanceField = authenticationTokenManager2;
                    authenticationTokenManager = authenticationTokenManager2;
                }
            }
        }
        AuthenticationToken authenticationToken2 = authenticationTokenManager.currentAuthenticationTokenField;
        authenticationTokenManager.currentAuthenticationTokenField = authenticationToken;
        if (authenticationToken != null) {
            AuthenticationTokenCache authenticationTokenCache = authenticationTokenManager.authenticationTokenCache;
            if (authenticationTokenCache != null) {
                Intrinsics.checkNotNullParameter(authenticationToken, "authenticationToken");
                try {
                    authenticationTokenCache.sharedPreferences.edit().putString("com.facebook.AuthenticationManager.CachedAuthenticationToken", authenticationToken.toJSONObject$facebook_core_release().toString()).apply();
                } catch (JSONException unused) {
                }
            } else {
                throw null;
            }
        } else {
            GeneratedOutlineSupport.outline93(authenticationTokenManager.authenticationTokenCache.sharedPreferences, "com.facebook.AuthenticationManager.CachedAuthenticationToken");
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
        }
        if (!Utility.areObjectsEqual(authenticationToken2, authenticationToken)) {
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
            Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAuthenticationTokenChangedBroadcastReceiver.class);
            intent.setAction("com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED");
            intent.putExtra("com.facebook.sdk.EXTRA_OLD_AUTHENTICATION_TOKEN", authenticationToken2);
            intent.putExtra("com.facebook.sdk.EXTRA_NEW_AUTHENTICATION_TOKEN", authenticationToken);
            authenticationTokenManager.localBroadcastManager.sendBroadcast(intent);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationToken)) {
            return false;
        }
        AuthenticationToken authenticationToken = (AuthenticationToken) obj;
        if (!Intrinsics.areEqual(this.token, authenticationToken.token) || !Intrinsics.areEqual(this.expectedNonce, authenticationToken.expectedNonce) || !Intrinsics.areEqual(this.header, authenticationToken.header) || !Intrinsics.areEqual(this.claims, authenticationToken.claims) || !Intrinsics.areEqual(this.signature, authenticationToken.signature)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.expectedNonce, GeneratedOutlineSupport.outline11(this.token, 527, 31), 31);
        int hashCode = this.claims.hashCode();
        return this.signature.hashCode() + ((hashCode + ((this.header.hashCode() + outline11) * 31)) * 31);
    }

    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token_string", this.token);
        jSONObject.put("expected_nonce", this.expectedNonce);
        jSONObject.put("header", this.header.toJSONObject$facebook_core_release());
        jSONObject.put("claims", this.claims.toJSONObject$facebook_core_release());
        jSONObject.put("signature", this.signature);
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.token);
        parcel.writeString(this.expectedNonce);
        parcel.writeParcelable(this.header, i);
        parcel.writeParcelable(this.claims, i);
        parcel.writeString(this.signature);
    }

    public AuthenticationToken(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Validate.notNullOrEmpty(readString, "token");
        this.token = readString;
        String readString2 = parcel.readString();
        Validate.notNullOrEmpty(readString2, "expectedNonce");
        this.expectedNonce = readString2;
        Parcelable readParcelable = parcel.readParcelable(AuthenticationTokenHeader.class.getClassLoader());
        if (readParcelable != null) {
            this.header = (AuthenticationTokenHeader) readParcelable;
            Parcelable readParcelable2 = parcel.readParcelable(AuthenticationTokenClaims.class.getClassLoader());
            if (readParcelable2 != null) {
                this.claims = (AuthenticationTokenClaims) readParcelable2;
                String readString3 = parcel.readString();
                Validate.notNullOrEmpty(readString3, "signature");
                this.signature = readString3;
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
