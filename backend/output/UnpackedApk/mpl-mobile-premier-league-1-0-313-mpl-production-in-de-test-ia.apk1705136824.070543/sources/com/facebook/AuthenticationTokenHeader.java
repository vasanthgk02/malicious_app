package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001f\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0007J\r\u0010\u001d\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0014H\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006%"}, d2 = {"Lcom/facebook/AuthenticationTokenHeader;", "Landroid/os/Parcelable;", "encodedHeaderString", "", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "alg", "typ", "kid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlg", "()Ljava/lang/String;", "getKid", "getTyp", "describeContents", "", "equals", "", "other", "", "hashCode", "isValidHeader", "headerString", "toEnCodedString", "toJSONObject", "toJSONObject$facebook_core_release", "toString", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuthenticationTokenHeader.kt */
public final class AuthenticationTokenHeader implements Parcelable {
    public static final Creator<AuthenticationTokenHeader> CREATOR = new AuthenticationTokenHeader$Companion$CREATOR$1();
    public final String alg;
    public final String kid;
    public final String typ;

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        if (r7 != false) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenHeader(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "typ"
            java.lang.String r1 = "kid"
            java.lang.String r2 = "alg"
            java.lang.String r3 = "encodedHeaderString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r3)
            r10.<init>()
            com.facebook.internal.Validate.notEmpty(r11, r3)
            r3 = 0
            byte[] r4 = android.util.Base64.decode(r11, r3)
            java.lang.String r5 = "decodedBytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8
            r6.<init>(r4, r7)
            r4 = 1
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0070 }
            r7.<init>(r6)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r6 = r7.optString(r2)     // Catch:{ JSONException -> 0x0070 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch:{ JSONException -> 0x0070 }
            int r8 = r6.length()     // Catch:{ JSONException -> 0x0070 }
            if (r8 <= 0) goto L_0x0037
            r8 = 1
            goto L_0x0038
        L_0x0037:
            r8 = 0
        L_0x0038:
            if (r8 == 0) goto L_0x0044
            java.lang.String r8 = "RS256"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r8)     // Catch:{ JSONException -> 0x0070 }
            if (r6 == 0) goto L_0x0044
            r6 = 1
            goto L_0x0045
        L_0x0044:
            r6 = 0
        L_0x0045:
            java.lang.String r8 = r7.optString(r1)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r9 = "jsonObj.optString(\"kid\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ JSONException -> 0x0070 }
            int r8 = r8.length()     // Catch:{ JSONException -> 0x0070 }
            if (r8 <= 0) goto L_0x0056
            r8 = 1
            goto L_0x0057
        L_0x0056:
            r8 = 0
        L_0x0057:
            java.lang.String r7 = r7.optString(r0)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r9 = "jsonObj.optString(\"typ\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)     // Catch:{ JSONException -> 0x0070 }
            int r7 = r7.length()     // Catch:{ JSONException -> 0x0070 }
            if (r7 <= 0) goto L_0x0068
            r7 = 1
            goto L_0x0069
        L_0x0068:
            r7 = 0
        L_0x0069:
            if (r6 == 0) goto L_0x0070
            if (r8 == 0) goto L_0x0070
            if (r7 == 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r4 = 0
        L_0x0071:
            if (r4 == 0) goto L_0x00a8
            byte[] r11 = android.util.Base64.decode(r11, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
            r3.<init>(r11, r4)
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>(r3)
            java.lang.String r2 = r11.getString(r2)
            java.lang.String r3 = "jsonObj.getString(\"alg\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r10.alg = r2
            java.lang.String r0 = r11.getString(r0)
            java.lang.String r2 = "jsonObj.getString(\"typ\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r10.typ = r0
            java.lang.String r11 = r11.getString(r1)
            java.lang.String r0 = "jsonObj.getString(\"kid\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            r10.kid = r11
            return
        L_0x00a8:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Invalid Header"
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenHeader.<init>(java.lang.String):void");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) obj;
        if (!Intrinsics.areEqual(this.alg, authenticationTokenHeader.alg) || !Intrinsics.areEqual(this.typ, authenticationTokenHeader.typ) || !Intrinsics.areEqual(this.kid, authenticationTokenHeader.kid)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.kid.hashCode() + GeneratedOutlineSupport.outline11(this.typ, GeneratedOutlineSupport.outline11(this.alg, 527, 31), 31);
    }

    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.alg);
        jSONObject.put("typ", this.typ);
        jSONObject.put("kid", this.kid);
        return jSONObject;
    }

    public String toString() {
        String jSONObject = toJSONObject$facebook_core_release().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "headerJsonObject.toString()");
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.alg);
        parcel.writeString(this.typ);
        parcel.writeString(this.kid);
    }

    public AuthenticationTokenHeader(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Validate.notNullOrEmpty(readString, "alg");
        this.alg = readString;
        String readString2 = parcel.readString();
        Validate.notNullOrEmpty(readString2, "typ");
        this.typ = readString2;
        String readString3 = parcel.readString();
        Validate.notNullOrEmpty(readString3, "kid");
        this.kid = readString3;
    }
}
