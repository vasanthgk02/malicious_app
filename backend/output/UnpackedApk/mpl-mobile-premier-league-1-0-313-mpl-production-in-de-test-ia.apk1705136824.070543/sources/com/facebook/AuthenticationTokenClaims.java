package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 L2\u00020\u0001:\u0001LB\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0002\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001eB\u000f\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\b\u0010;\u001a\u00020\u0019H\u0016J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\b\u0010@\u001a\u00020\u0019H\u0016J\u0018\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020C2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010D\u001a\u00020\u0003H\u0007J\r\u0010E\u001a\u00020CH\u0001¢\u0006\u0002\bFJ\b\u0010G\u001a\u00020\u0003H\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020\u0019H\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u001f\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b:\u00102¨\u0006M"}, d2 = {"Lcom/facebook/AuthenticationTokenClaims;", "Landroid/os/Parcelable;", "encodedClaims", "", "expectedNonce", "(Ljava/lang/String;Ljava/lang/String;)V", "jti", "iss", "aud", "nonce", "exp", "", "iat", "sub", "name", "givenName", "middleName", "familyName", "email", "picture", "userFriends", "", "userBirthday", "userAgeRange", "", "", "userHometown", "userLocation", "userGender", "userLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAud", "()Ljava/lang/String;", "getEmail", "getExp", "()J", "getFamilyName", "getGivenName", "getIat", "getIss", "getJti", "getMiddleName", "getName", "getNonce", "getPicture", "getSub", "getUserAgeRange", "()Ljava/util/Map;", "getUserBirthday", "", "getUserFriends", "()Ljava/util/Set;", "getUserGender", "getUserHometown", "getUserLink", "getUserLocation", "describeContents", "equals", "", "other", "", "hashCode", "isValidClaims", "claimsJson", "Lorg/json/JSONObject;", "toEnCodedString", "toJSONObject", "toJSONObject$facebook_core_release", "toString", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuthenticationTokenClaims.kt */
public final class AuthenticationTokenClaims implements Parcelable {
    public static final Creator<AuthenticationTokenClaims> CREATOR = new AuthenticationTokenClaims$Companion$CREATOR$1();
    public final String aud;
    public final String email;
    public final long exp;
    public final String familyName;
    public final String givenName;
    public final long iat;
    public final String iss;
    public final String jti;
    public final String middleName;
    public final String name;
    public final String nonce;
    public final String picture;
    public final String sub;
    public final Map<String, Integer> userAgeRange;
    public final String userBirthday;
    public final Set<String> userFriends;
    public final String userGender;
    public final Map<String, String> userHometown;
    public final String userLink;
    public final Map<String, String> userLocation;

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.String r3 = "encodedClaims"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r4 = "expectedNonce"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            r16.<init>()
            com.facebook.internal.Validate.notEmpty(r1, r3)
            r3 = 8
            byte[] r1 = android.util.Base64.decode(r1, r3)
            java.lang.String r3 = "decodedBytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
            r3.<init>(r1, r4)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r3)
            java.lang.String r3 = "jti"
            java.lang.String r4 = r1.optString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            int r4 = r4.length()
            if (r4 != 0) goto L_0x003e
            r4 = 1
            goto L_0x003f
        L_0x003e:
            r4 = 0
        L_0x003f:
            java.lang.String r7 = "nonce"
            java.lang.String r8 = "sub"
            java.lang.String r9 = "iat"
            java.lang.String r10 = "exp"
            java.lang.String r11 = "aud"
            java.lang.String r12 = "iss"
            if (r4 == 0) goto L_0x004f
            goto L_0x0107
        L_0x004f:
            java.lang.String r4 = r1.optString(r12)     // Catch:{ MalformedURLException -> 0x0107 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r12)     // Catch:{ MalformedURLException -> 0x0107 }
            int r13 = r4.length()     // Catch:{ MalformedURLException -> 0x0107 }
            if (r13 != 0) goto L_0x005e
            r13 = 1
            goto L_0x005f
        L_0x005e:
            r13 = 0
        L_0x005f:
            if (r13 != 0) goto L_0x0107
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0107 }
            r13.<init>(r4)     // Catch:{ MalformedURLException -> 0x0107 }
            java.lang.String r13 = r13.getHost()     // Catch:{ MalformedURLException -> 0x0107 }
            java.lang.String r14 = "facebook.com"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)     // Catch:{ MalformedURLException -> 0x0107 }
            if (r13 != 0) goto L_0x0085
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0107 }
            r13.<init>(r4)     // Catch:{ MalformedURLException -> 0x0107 }
            java.lang.String r4 = r13.getHost()     // Catch:{ MalformedURLException -> 0x0107 }
            java.lang.String r13 = "www.facebook.com"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r13)     // Catch:{ MalformedURLException -> 0x0107 }
            if (r4 != 0) goto L_0x0085
            goto L_0x0107
        L_0x0085:
            java.lang.String r4 = r1.optString(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r11)
            int r13 = r4.length()
            if (r13 != 0) goto L_0x0094
            r13 = 1
            goto L_0x0095
        L_0x0094:
            r13 = 0
        L_0x0095:
            if (r13 != 0) goto L_0x0107
            com.facebook.FacebookSdk r13 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r13 = com.facebook.FacebookSdk.getApplicationId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r13)
            if (r4 != 0) goto L_0x00a4
            goto L_0x0107
        L_0x00a4:
            java.util.Date r4 = new java.util.Date
            long r13 = r1.optLong(r10)
            r15 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r15
            long r13 = r13 * r5
            r4.<init>(r13)
            java.util.Date r13 = new java.util.Date
            r13.<init>()
            boolean r4 = r13.after(r4)
            if (r4 == 0) goto L_0x00be
            goto L_0x0107
        L_0x00be:
            long r13 = r1.optLong(r9)
            java.util.Date r4 = new java.util.Date
            long r13 = r13 * r5
            r5 = 600000(0x927c0, double:2.964394E-318)
            long r13 = r13 + r5
            r4.<init>(r13)
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            boolean r4 = r5.after(r4)
            if (r4 == 0) goto L_0x00d9
            goto L_0x0107
        L_0x00d9:
            java.lang.String r4 = r1.optString(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            int r4 = r4.length()
            if (r4 != 0) goto L_0x00e8
            r4 = 1
            goto L_0x00e9
        L_0x00e8:
            r4 = 0
        L_0x00e9:
            if (r4 == 0) goto L_0x00ec
            goto L_0x0107
        L_0x00ec:
            java.lang.String r4 = r1.optString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            int r5 = r4.length()
            if (r5 != 0) goto L_0x00fb
            r5 = 1
            goto L_0x00fc
        L_0x00fb:
            r5 = 0
        L_0x00fc:
            if (r5 != 0) goto L_0x0107
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r2)
            if (r2 != 0) goto L_0x0105
            goto L_0x0107
        L_0x0105:
            r5 = 1
            goto L_0x0108
        L_0x0107:
            r5 = 0
        L_0x0108:
            if (r5 == 0) goto L_0x0285
            java.lang.String r2 = r1.getString(r3)
            java.lang.String r3 = "jsonObj.getString(JSON_KEY_JIT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.jti = r2
            java.lang.String r2 = r1.getString(r12)
            java.lang.String r3 = "jsonObj.getString(JSON_KEY_ISS)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.iss = r2
            java.lang.String r2 = r1.getString(r11)
            java.lang.String r3 = "jsonObj.getString(JSON_KEY_AUD)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.aud = r2
            java.lang.String r2 = r1.getString(r7)
            java.lang.String r3 = "jsonObj.getString(JSON_KEY_NONCE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.nonce = r2
            long r2 = r1.getLong(r10)
            r0.exp = r2
            long r2 = r1.getLong(r9)
            r0.iat = r2
            java.lang.String r2 = r1.getString(r8)
            java.lang.String r3 = "jsonObj.getString(JSON_KEY_SUB)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.sub = r2
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r3 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r3)
            boolean r4 = r1.has(r3)
            r5 = 0
            if (r4 == 0) goto L_0x0163
            java.lang.String r4 = r1.getString(r3)
            goto L_0x0164
        L_0x0163:
            r4 = r5
        L_0x0164:
            r0.name = r4
            java.lang.String r4 = "given_name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            boolean r6 = r1.has(r4)
            if (r6 == 0) goto L_0x0179
            java.lang.String r4 = r1.getString(r4)
            goto L_0x017a
        L_0x0179:
            r4 = r5
        L_0x017a:
            r0.givenName = r4
            java.lang.String r4 = "middle_name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            boolean r6 = r1.has(r4)
            if (r6 == 0) goto L_0x018f
            java.lang.String r4 = r1.getString(r4)
            goto L_0x0190
        L_0x018f:
            r4 = r5
        L_0x0190:
            r0.middleName = r4
            java.lang.String r4 = "family_name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            boolean r6 = r1.has(r4)
            if (r6 == 0) goto L_0x01a5
            java.lang.String r4 = r1.getString(r4)
            goto L_0x01a6
        L_0x01a5:
            r4 = r5
        L_0x01a6:
            r0.familyName = r4
            java.lang.String r4 = "email"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            boolean r6 = r1.has(r4)
            if (r6 == 0) goto L_0x01bb
            java.lang.String r4 = r1.getString(r4)
            goto L_0x01bc
        L_0x01bb:
            r4 = r5
        L_0x01bc:
            r0.email = r4
            java.lang.String r4 = "picture"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            boolean r6 = r1.has(r4)
            if (r6 == 0) goto L_0x01d1
            java.lang.String r4 = r1.getString(r4)
            goto L_0x01d2
        L_0x01d1:
            r4 = r5
        L_0x01d2:
            r0.picture = r4
            java.lang.String r4 = "user_friends"
            org.json.JSONArray r4 = r1.optJSONArray(r4)
            if (r4 != 0) goto L_0x01de
            r4 = r5
            goto L_0x0206
        L_0x01de:
            java.lang.String r6 = "jsonArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            int r7 = r4.length()
            if (r7 <= 0) goto L_0x0202
            r8 = 0
        L_0x01ef:
            int r9 = r8 + 1
            java.lang.String r8 = r4.getString(r8)
            java.lang.String r10 = "jsonArray.getString(i)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            r6.add(r8)
            if (r9 < r7) goto L_0x0200
            goto L_0x0202
        L_0x0200:
            r8 = r9
            goto L_0x01ef
        L_0x0202:
            java.util.Set r4 = java.util.Collections.unmodifiableSet(r6)
        L_0x0206:
            r0.userFriends = r4
            java.lang.String r4 = "user_birthday"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            boolean r6 = r1.has(r4)
            if (r6 == 0) goto L_0x021b
            java.lang.String r4 = r1.getString(r4)
            goto L_0x021c
        L_0x021b:
            r4 = r5
        L_0x021c:
            r0.userBirthday = r4
            java.lang.String r4 = "user_age_range"
            org.json.JSONObject r4 = r1.optJSONObject(r4)
            if (r4 != 0) goto L_0x0228
            r4 = r5
            goto L_0x0230
        L_0x0228:
            java.util.Map r4 = com.facebook.internal.Utility.convertJSONObjectToHashMap(r4)
            java.util.Map r4 = java.util.Collections.unmodifiableMap(r4)
        L_0x0230:
            r0.userAgeRange = r4
            java.lang.String r4 = "user_hometown"
            org.json.JSONObject r4 = r1.optJSONObject(r4)
            if (r4 != 0) goto L_0x023c
            r4 = r5
            goto L_0x0244
        L_0x023c:
            java.util.Map r4 = com.facebook.internal.Utility.convertJSONObjectToStringMap(r4)
            java.util.Map r4 = java.util.Collections.unmodifiableMap(r4)
        L_0x0244:
            r0.userHometown = r4
            java.lang.String r4 = "user_location"
            org.json.JSONObject r4 = r1.optJSONObject(r4)
            if (r4 != 0) goto L_0x0250
            r4 = r5
            goto L_0x0258
        L_0x0250:
            java.util.Map r4 = com.facebook.internal.Utility.convertJSONObjectToStringMap(r4)
            java.util.Map r4 = java.util.Collections.unmodifiableMap(r4)
        L_0x0258:
            r0.userLocation = r4
            java.lang.String r4 = "user_gender"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            boolean r6 = r1.has(r4)
            if (r6 == 0) goto L_0x026d
            java.lang.String r4 = r1.getString(r4)
            goto L_0x026e
        L_0x026d:
            r4 = r5
        L_0x026e:
            r0.userGender = r4
            java.lang.String r4 = "user_link"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            boolean r2 = r1.has(r4)
            if (r2 == 0) goto L_0x0282
            java.lang.String r5 = r1.getString(r4)
        L_0x0282:
            r0.userLink = r5
            return
        L_0x0285:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid claims"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String):void");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims = (AuthenticationTokenClaims) obj;
        if (!Intrinsics.areEqual(this.jti, authenticationTokenClaims.jti) || !Intrinsics.areEqual(this.iss, authenticationTokenClaims.iss) || !Intrinsics.areEqual(this.aud, authenticationTokenClaims.aud) || !Intrinsics.areEqual(this.nonce, authenticationTokenClaims.nonce) || this.exp != authenticationTokenClaims.exp || this.iat != authenticationTokenClaims.iat || !Intrinsics.areEqual(this.sub, authenticationTokenClaims.sub) || !Intrinsics.areEqual(this.name, authenticationTokenClaims.name) || !Intrinsics.areEqual(this.givenName, authenticationTokenClaims.givenName) || !Intrinsics.areEqual(this.middleName, authenticationTokenClaims.middleName) || !Intrinsics.areEqual(this.familyName, authenticationTokenClaims.familyName) || !Intrinsics.areEqual(this.email, authenticationTokenClaims.email) || !Intrinsics.areEqual(this.picture, authenticationTokenClaims.picture) || !Intrinsics.areEqual(this.userFriends, authenticationTokenClaims.userFriends) || !Intrinsics.areEqual(this.userBirthday, authenticationTokenClaims.userBirthday) || !Intrinsics.areEqual(this.userAgeRange, authenticationTokenClaims.userAgeRange) || !Intrinsics.areEqual(this.userHometown, authenticationTokenClaims.userHometown) || !Intrinsics.areEqual(this.userLocation, authenticationTokenClaims.userLocation) || !Intrinsics.areEqual(this.userGender, authenticationTokenClaims.userGender) || !Intrinsics.areEqual(this.userLink, authenticationTokenClaims.userLink)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.sub, (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.iat) + ((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.exp) + GeneratedOutlineSupport.outline11(this.nonce, GeneratedOutlineSupport.outline11(this.aud, GeneratedOutlineSupport.outline11(this.iss, GeneratedOutlineSupport.outline11(this.jti, 527, 31), 31), 31), 31)) * 31)) * 31, 31);
        String str = this.name;
        int i = 0;
        int hashCode = (outline11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.givenName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.middleName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.familyName;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.email;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.picture;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Set<String> set = this.userFriends;
        int hashCode7 = (hashCode6 + (set == null ? 0 : set.hashCode())) * 31;
        String str7 = this.userBirthday;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Map<String, Integer> map = this.userAgeRange;
        int hashCode9 = (hashCode8 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, String> map2 = this.userHometown;
        int hashCode10 = (hashCode9 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, String> map3 = this.userLocation;
        int hashCode11 = (hashCode10 + (map3 == null ? 0 : map3.hashCode())) * 31;
        String str8 = this.userGender;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.userLink;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode12 + i;
    }

    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("jti", this.jti);
        jSONObject.put("iss", this.iss);
        jSONObject.put("aud", this.aud);
        jSONObject.put("nonce", this.nonce);
        jSONObject.put("exp", this.exp);
        jSONObject.put("iat", this.iat);
        String str = this.sub;
        if (str != null) {
            jSONObject.put("sub", str);
        }
        String str2 = this.name;
        if (str2 != null) {
            jSONObject.put("name", str2);
        }
        String str3 = this.givenName;
        if (str3 != null) {
            jSONObject.put("given_name", str3);
        }
        String str4 = this.middleName;
        if (str4 != null) {
            jSONObject.put("middle_name", str4);
        }
        String str5 = this.familyName;
        if (str5 != null) {
            jSONObject.put("family_name", str5);
        }
        String str6 = this.email;
        if (str6 != null) {
            jSONObject.put("email", str6);
        }
        String str7 = this.picture;
        if (str7 != null) {
            jSONObject.put("picture", str7);
        }
        if (this.userFriends != null) {
            jSONObject.put("user_friends", new JSONArray(this.userFriends));
        }
        String str8 = this.userBirthday;
        if (str8 != null) {
            jSONObject.put("user_birthday", str8);
        }
        if (this.userAgeRange != null) {
            jSONObject.put("user_age_range", new JSONObject(this.userAgeRange));
        }
        if (this.userHometown != null) {
            jSONObject.put("user_hometown", new JSONObject(this.userHometown));
        }
        if (this.userLocation != null) {
            jSONObject.put("user_location", new JSONObject(this.userLocation));
        }
        String str9 = this.userGender;
        if (str9 != null) {
            jSONObject.put("user_gender", str9);
        }
        String str10 = this.userLink;
        if (str10 != null) {
            jSONObject.put("user_link", str10);
        }
        return jSONObject;
    }

    public String toString() {
        String jSONObject = toJSONObject$facebook_core_release().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "claimsJsonObject.toString()");
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.jti);
        parcel.writeString(this.iss);
        parcel.writeString(this.aud);
        parcel.writeString(this.nonce);
        parcel.writeLong(this.exp);
        parcel.writeLong(this.iat);
        parcel.writeString(this.sub);
        parcel.writeString(this.name);
        parcel.writeString(this.givenName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.familyName);
        parcel.writeString(this.email);
        parcel.writeString(this.picture);
        if (this.userFriends == null) {
            parcel.writeStringList(null);
        } else {
            parcel.writeStringList(new ArrayList(this.userFriends));
        }
        parcel.writeString(this.userBirthday);
        parcel.writeMap(this.userAgeRange);
        parcel.writeMap(this.userHometown);
        parcel.writeMap(this.userLocation);
        parcel.writeString(this.userGender);
        parcel.writeString(this.userLink);
    }

    public AuthenticationTokenClaims(Parcel parcel) {
        Class<StringCompanionObject> cls = StringCompanionObject.class;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Validate.notNullOrEmpty(readString, "jti");
        this.jti = readString;
        String readString2 = parcel.readString();
        Validate.notNullOrEmpty(readString2, "iss");
        this.iss = readString2;
        String readString3 = parcel.readString();
        Validate.notNullOrEmpty(readString3, "aud");
        this.aud = readString3;
        String readString4 = parcel.readString();
        Validate.notNullOrEmpty(readString4, "nonce");
        this.nonce = readString4;
        this.exp = parcel.readLong();
        this.iat = parcel.readLong();
        String readString5 = parcel.readString();
        Validate.notNullOrEmpty(readString5, "sub");
        this.sub = readString5;
        this.name = parcel.readString();
        this.givenName = parcel.readString();
        this.middleName = parcel.readString();
        this.familyName = parcel.readString();
        this.email = parcel.readString();
        this.picture = parcel.readString();
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        Map<String, String> map = null;
        this.userFriends = createStringArrayList != null ? Collections.unmodifiableSet(new HashSet(createStringArrayList)) : null;
        this.userBirthday = parcel.readString();
        HashMap readHashMap = parcel.readHashMap(IntCompanionObject.class.getClassLoader());
        readHashMap = !(readHashMap instanceof HashMap) ? null : readHashMap;
        this.userAgeRange = readHashMap != null ? Collections.unmodifiableMap(readHashMap) : null;
        HashMap readHashMap2 = parcel.readHashMap(cls.getClassLoader());
        readHashMap2 = !(readHashMap2 instanceof HashMap) ? null : readHashMap2;
        this.userHometown = readHashMap2 != null ? Collections.unmodifiableMap(readHashMap2) : null;
        HashMap readHashMap3 = parcel.readHashMap(cls.getClassLoader());
        readHashMap3 = !(readHashMap3 instanceof HashMap) ? null : readHashMap3;
        this.userLocation = readHashMap3 != null ? Collections.unmodifiableMap(readHashMap3) : map;
        this.userGender = parcel.readString();
        this.userLink = parcel.readString();
    }
}
