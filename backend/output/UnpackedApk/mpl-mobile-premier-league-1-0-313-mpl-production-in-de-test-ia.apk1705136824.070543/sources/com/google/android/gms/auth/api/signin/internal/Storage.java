package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.zaa;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class Storage {
    public static final Lock zaa = new ReentrantLock();
    public static Storage zab;
    public final Lock zac = new ReentrantLock();
    public final SharedPreferences zad;

    @VisibleForTesting
    public Storage(Context context) {
        this.zad = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @KeepForSdk
    public static Storage getInstance(Context context) {
        Preconditions.checkNotNull(context);
        zaa.lock();
        try {
            if (zab == null) {
                zab = new Storage(context.getApplicationContext());
            }
            return zab;
        } finally {
            zaa.unlock();
        }
    }

    public static final String zae(String str, String str2) {
        return GeneratedOutlineSupport.outline52(str, ":", str2);
    }

    @KeepForSdk
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String zaa2 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zaa2)) {
            return null;
        }
        String zaa3 = zaa(zae("googleSignInAccount", zaa2));
        if (zaa3 == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zab(zaa3);
        } catch (JSONException unused) {
            return null;
        }
    }

    @KeepForSdk
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        String zaa2 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zaa2)) {
            return null;
        }
        String zaa3 = zaa(zae("googleSignInOptions", zaa2));
        if (zaa3 == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zab(zaa3);
        } catch (JSONException unused) {
            return null;
        }
    }

    @KeepForSdk
    public void saveDefaultGoogleSignInAccount(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        zad("defaultGoogleSignInAccount", googleSignInAccount.zak);
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String str = googleSignInAccount.zak;
        String zae = zae("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            if (googleSignInAccount.zad != null) {
                jSONObject.put("id", googleSignInAccount.zad);
            }
            if (googleSignInAccount.zae != null) {
                jSONObject.put("tokenId", googleSignInAccount.zae);
            }
            if (googleSignInAccount.zaf != null) {
                jSONObject.put("email", googleSignInAccount.zaf);
            }
            if (googleSignInAccount.zag != null) {
                jSONObject.put("displayName", googleSignInAccount.zag);
            }
            if (googleSignInAccount.zal != null) {
                jSONObject.put("givenName", googleSignInAccount.zal);
            }
            if (googleSignInAccount.zam != null) {
                jSONObject.put("familyName", googleSignInAccount.zam);
            }
            Uri uri = googleSignInAccount.zah;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            if (googleSignInAccount.zai != null) {
                jSONObject.put("serverAuthCode", googleSignInAccount.zai);
            }
            jSONObject.put("expirationTime", googleSignInAccount.zaj);
            jSONObject.put("obfuscatedIdentifier", googleSignInAccount.zak);
            JSONArray jSONArray = new JSONArray();
            List list = googleSignInAccount.zac;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, zaa.zaa);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.zzb);
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            zad(zae, jSONObject.toString());
            String zae2 = zae("googleSignInOptions", str);
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(googleSignInOptions.zah, GoogleSignInOptions.zag);
                Iterator it = googleSignInOptions.zah.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(((Scope) it.next()).zzb);
                }
                jSONObject2.put("scopes", jSONArray2);
                Account account = googleSignInOptions.zai;
                if (account != null) {
                    jSONObject2.put("accountName", account.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.zaj);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.zal);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.zak);
                if (!TextUtils.isEmpty(googleSignInOptions.zam)) {
                    jSONObject2.put("serverClientId", googleSignInOptions.zam);
                }
                if (!TextUtils.isEmpty(googleSignInOptions.zan)) {
                    jSONObject2.put("hostedDomain", googleSignInOptions.zan);
                }
                zad(zae2, jSONObject2.toString());
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final String zaa(String str) {
        this.zac.lock();
        try {
            return this.zad.getString(str, null);
        } finally {
            this.zac.unlock();
        }
    }

    public final void zad(String str, String str2) {
        this.zac.lock();
        try {
            this.zad.edit().putString(str, str2).apply();
        } finally {
            this.zac.unlock();
        }
    }
}
