package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mpl.androidapp.utils.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Optional, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new zae();
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    @VisibleForTesting
    public static final Scope zaa = new Scope(Constant.PROFILE);
    @VisibleForTesting
    public static final Scope zac = new Scope("openid");
    @VisibleForTesting
    public static final Scope zad = new Scope("https://www.googleapis.com/auth/games_lite");
    @VisibleForTesting
    public static final Scope zae = new Scope("https://www.googleapis.com/auth/games");
    public static Comparator zag = new zac();
    @VersionField
    public final int zaf;
    @Field
    public final ArrayList zah;
    @Field
    public Account zai;
    @Field
    public boolean zaj;
    @Field
    public final boolean zak;
    @Field
    public final boolean zal;
    @Field
    public String zam;
    @Field
    public String zan;
    @Field
    public ArrayList zao;
    @Field
    public String zap;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static final class Builder {
        public Set zaa = new HashSet();
        public boolean zab;
        public boolean zac;
        public boolean zad;
        public String zae;
        public Account zaf;
        public String zag;
        public Map zah = new HashMap();
        public String zai;

        public Builder() {
        }

        public GoogleSignInOptions build() {
            if (this.zaa.contains(GoogleSignInOptions.zae) && this.zaa.contains(GoogleSignInOptions.zad)) {
                this.zaa.remove(GoogleSignInOptions.zad);
            }
            if (this.zad && (this.zaf == null || !this.zaa.isEmpty())) {
                this.zaa.add(GoogleSignInOptions.zac);
            }
            GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions(3, new ArrayList(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai);
            return googleSignInOptions;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.zaa.add(scope);
            this.zaa.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final String zaa(String str) {
            Preconditions.checkNotEmpty(str);
            String str2 = this.zae;
            boolean z = true;
            if (str2 != null && !str2.equals(str)) {
                z = false;
            }
            Preconditions.checkArgument(z, "two different server client ids provided");
            return str;
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            Preconditions.checkNotNull(googleSignInOptions);
            this.zaa = new HashSet(googleSignInOptions.zah);
            this.zab = googleSignInOptions.zak;
            this.zac = googleSignInOptions.zal;
            this.zad = googleSignInOptions.zaj;
            this.zae = googleSignInOptions.zam;
            this.zaf = googleSignInOptions.zai;
            this.zag = googleSignInOptions.zan;
            this.zah = GoogleSignInOptions.zam(googleSignInOptions.zao);
            this.zai = googleSignInOptions.zap;
        }
    }

    static {
        new Scope("email");
        Builder builder = new Builder();
        builder.zaa.add(zac);
        builder.zaa.add(zaa);
        DEFAULT_SIGN_IN = builder.build();
        Builder builder2 = new Builder();
        builder2.requestScopes(zad, new Scope[0]);
        DEFAULT_GAMES_SIGN_IN = builder2.build();
    }

    public GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3) {
        this.zaf = i;
        this.zah = arrayList;
        this.zai = account;
        this.zaj = z;
        this.zak = z2;
        this.zal = z3;
        this.zam = str;
        this.zan = str2;
        this.zao = new ArrayList(map.values());
        this.zap = str3;
    }

    public static GoogleSignInOptions zab(String str) throws JSONException {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        Account account = !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null;
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z = jSONObject.getBoolean("idTokenRequested");
        boolean z2 = jSONObject.getBoolean("serverAuthRequested");
        boolean z3 = jSONObject.getBoolean("forceCodeForRefreshToken");
        String optString2 = jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null;
        if (jSONObject.has("hostedDomain")) {
            str2 = jSONObject.optString("hostedDomain");
        }
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions(3, arrayList, account, z, z2, z3, optString2, str2, new HashMap(), null);
        return googleSignInOptions;
    }

    public static Map zam(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.zab), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r1.equals(r4.zai) != false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x007f }
            java.util.ArrayList r1 = r3.zao     // Catch:{ ClassCastException -> 0x007f }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x007f }
            if (r1 > 0) goto L_0x007f
            java.util.ArrayList r1 = r4.zao     // Catch:{ ClassCastException -> 0x007f }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x007f }
            if (r1 <= 0) goto L_0x0017
            goto L_0x007f
        L_0x0017:
            java.util.ArrayList r1 = r3.zah     // Catch:{ ClassCastException -> 0x007f }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x007f }
            java.util.ArrayList r2 = r4.getScopes()     // Catch:{ ClassCastException -> 0x007f }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x007f }
            if (r1 != r2) goto L_0x007f
            java.util.ArrayList r1 = r3.zah     // Catch:{ ClassCastException -> 0x007f }
            java.util.ArrayList r2 = r4.getScopes()     // Catch:{ ClassCastException -> 0x007f }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x007f }
            if (r1 != 0) goto L_0x0034
            goto L_0x007f
        L_0x0034:
            android.accounts.Account r1 = r3.zai     // Catch:{ ClassCastException -> 0x007f }
            if (r1 != 0) goto L_0x003d
            android.accounts.Account r1 = r4.zai     // Catch:{ ClassCastException -> 0x007f }
            if (r1 != 0) goto L_0x007f
            goto L_0x0045
        L_0x003d:
            android.accounts.Account r2 = r4.zai     // Catch:{ ClassCastException -> 0x007f }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x007f }
            if (r1 == 0) goto L_0x007f
        L_0x0045:
            java.lang.String r1 = r3.zam     // Catch:{ ClassCastException -> 0x007f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x007f }
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = r4.zam     // Catch:{ ClassCastException -> 0x007f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x007f }
            if (r1 == 0) goto L_0x007f
            goto L_0x0061
        L_0x0056:
            java.lang.String r1 = r3.zam     // Catch:{ ClassCastException -> 0x007f }
            java.lang.String r2 = r4.zam     // Catch:{ ClassCastException -> 0x007f }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x007f }
            if (r1 != 0) goto L_0x0061
            goto L_0x007f
        L_0x0061:
            boolean r1 = r3.zal     // Catch:{ ClassCastException -> 0x007f }
            boolean r2 = r4.zal     // Catch:{ ClassCastException -> 0x007f }
            if (r1 != r2) goto L_0x007f
            boolean r1 = r3.zaj     // Catch:{ ClassCastException -> 0x007f }
            boolean r2 = r4.zaj     // Catch:{ ClassCastException -> 0x007f }
            if (r1 != r2) goto L_0x007f
            boolean r1 = r3.zak     // Catch:{ ClassCastException -> 0x007f }
            boolean r2 = r4.zak     // Catch:{ ClassCastException -> 0x007f }
            if (r1 != r2) goto L_0x007f
            java.lang.String r1 = r3.zap     // Catch:{ ClassCastException -> 0x007f }
            java.lang.String r4 = r4.zap     // Catch:{ ClassCastException -> 0x007f }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x007f }
            if (r4 == 0) goto L_0x007f
            r4 = 1
            return r4
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.zah);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.zah;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Scope) arrayList2.get(i)).zzb);
        }
        Collections.sort(arrayList);
        HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.addObject(arrayList);
        hashAccumulator.addObject(this.zai);
        hashAccumulator.addObject(this.zam);
        hashAccumulator.zaa(this.zal);
        hashAccumulator.zaa(this.zaj);
        hashAccumulator.zaa(this.zak);
        hashAccumulator.addObject(this.zap);
        return hashAccumulator.zab;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaf;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zai, i, false);
        boolean z = this.zaj;
        parcel.writeInt(262148);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zak;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.zal;
        parcel.writeInt(262150);
        parcel.writeInt(z3 ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 7, this.zam, false);
        SafeParcelWriter.writeString(parcel, 8, this.zan, false);
        SafeParcelWriter.writeTypedList(parcel, 9, this.zao, false);
        SafeParcelWriter.writeString(parcel, 10, this.zap, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
