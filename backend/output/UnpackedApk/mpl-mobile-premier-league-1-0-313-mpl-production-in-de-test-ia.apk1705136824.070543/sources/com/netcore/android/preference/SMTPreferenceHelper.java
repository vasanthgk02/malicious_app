package com.netcore.android.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0001=B\u0011\b\u0002\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010!J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010*J\u0015\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b,\u0010 J\u0015\u0010-\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b-\u0010 J#\u0010/\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020.¢\u0006\u0004\b/\u00100J\u001b\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020.2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006>"}, d2 = {"Lcom/netcore/android/preference/SMTPreferenceHelper;", "Lcom/netcore/android/preference/SMTPreferenceInterface;", "", "key", "", "getLong", "(Ljava/lang/String;)J", "defaultValue", "(Ljava/lang/String;J)J", "value", "", "setLong", "(Ljava/lang/String;J)V", "", "getDouble", "(Ljava/lang/String;)D", "setDouble", "(Ljava/lang/String;D)V", "", "setInt", "(Ljava/lang/String;I)V", "getInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "", "setBoolean", "(Ljava/lang/String;Z)V", "getBoolean", "(Ljava/lang/String;)Z", "setString", "(Ljava/lang/String;Ljava/lang/String;)V", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getObjectInString", "removePrefValue", "(Ljava/lang/String;)V", "", "setFloat", "(Ljava/lang/String;F)V", "getFloat", "(Ljava/lang/String;)F", "(Ljava/lang/String;Z)Z", "input", "encrypt", "decrypt", "", "setArray", "(Ljava/lang/String;Ljava/util/List;)V", "getArray", "(Ljava/lang/String;)Ljava/util/List;", "Landroid/content/SharedPreferences;", "mPrefs", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences$Editor;", "mEditor", "Landroid/content/SharedPreferences$Editor;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTPreferenceHelper.kt */
public final class SMTPreferenceHelper implements SMTPreferenceInterface {
    public static final Companion Companion = new Companion(null);
    public static SMTPreferenceHelper INSTANCE;
    public static final AtomicBoolean initialized = new AtomicBoolean();
    public static String mPrefFileName = "smartech";
    public final Editor mEditor;
    public final SharedPreferences mPrefs;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/netcore/android/preference/SMTPreferenceHelper$Companion;", "", "Landroid/content/Context;", "context", "", "prefFileName", "Lcom/netcore/android/preference/SMTPreferenceHelper;", "getAppPreferenceInstance", "(Landroid/content/Context;Ljava/lang/String;)Lcom/netcore/android/preference/SMTPreferenceHelper;", "INSTANCE", "Lcom/netcore/android/preference/SMTPreferenceHelper;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mPrefFileName", "Ljava/lang/String;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTPreferenceHelper.kt */
    public static final class Companion {
        public Companion() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0015 A[Catch:{ all -> 0x0039 }] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0023 A[Catch:{ all -> 0x0039 }] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[DONT_GENERATE] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized com.netcore.android.preference.SMTPreferenceHelper getAppPreferenceInstance(android.content.Context r3, java.lang.String r4) {
            /*
                r2 = this;
                monitor-enter(r2)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch:{ all -> 0x0039 }
                r0 = 1
                if (r4 == 0) goto L_0x0012
                int r1 = r4.length()     // Catch:{ all -> 0x0039 }
                if (r1 != 0) goto L_0x0010
                goto L_0x0012
            L_0x0010:
                r1 = 0
                goto L_0x0013
            L_0x0012:
                r1 = 1
            L_0x0013:
                if (r1 != 0) goto L_0x0018
                com.netcore.android.preference.SMTPreferenceHelper.mPrefFileName = r4     // Catch:{ all -> 0x0039 }
            L_0x0018:
                java.util.concurrent.atomic.AtomicBoolean r4 = com.netcore.android.preference.SMTPreferenceHelper.initialized     // Catch:{ all -> 0x0039 }
                boolean r4 = r4.getAndSet(r0)     // Catch:{ all -> 0x0039 }
                r0 = 0
                if (r4 != 0) goto L_0x002b
                com.netcore.android.preference.SMTPreferenceHelper r4 = new com.netcore.android.preference.SMTPreferenceHelper     // Catch:{ all -> 0x0039 }
                r4.<init>(r3, r0)     // Catch:{ all -> 0x0039 }
                com.netcore.android.preference.SMTPreferenceHelper.INSTANCE = r4     // Catch:{ all -> 0x0039 }
            L_0x002b:
                com.netcore.android.preference.SMTPreferenceHelper r3 = com.netcore.android.preference.SMTPreferenceHelper.INSTANCE     // Catch:{ all -> 0x0039 }
                if (r3 == 0) goto L_0x0033
                monitor-exit(r2)
                return r3
            L_0x0033:
                java.lang.String r3 = "INSTANCE"
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch:{ all -> 0x0039 }
                throw r0
            L_0x0039:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.preference.SMTPreferenceHelper.Companion.getAppPreferenceInstance(android.content.Context, java.lang.String):com.netcore.android.preference.SMTPreferenceHelper");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SMTPreferenceHelper(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mPrefFileName, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        this.mPrefs = sharedPreferences;
        Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "mPrefs.edit()");
        this.mEditor = edit;
    }

    public final String decrypt(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        return str;
    }

    public final String encrypt(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        return str;
    }

    public final List<String> getArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        String string = this.mPrefs.getString(str, "");
        if (!(string.length() > 0)) {
            return EmptyList.INSTANCE;
        }
        return CharsKt__CharKt.split$default((CharSequence) string, new char[]{','}, false, 0, 6);
    }

    public boolean getBoolean(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.mPrefs.getBoolean(str, false);
    }

    public double getDouble(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return Double.longBitsToDouble(getLong(str));
    }

    public float getFloat(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.mPrefs.getFloat(str, 0.0f);
    }

    public int getInt(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.mPrefs.getInt(str, 0);
    }

    public long getLong(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.mPrefs.getLong(str, 0);
    }

    public String getObjectInString(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        String string = this.mPrefs.getString(str, "");
        return string != null ? string : "";
    }

    public String getString(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        String str2 = "";
        String string = this.mPrefs.getString(encrypt(str), encrypt(str2));
        if (string != null) {
            str2 = string;
        }
        return decrypt(str2);
    }

    public void removePrefValue(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.mEditor.remove(str).commit();
    }

    public final void setArray(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(list, HSLCriteriaBuilder.VALUE);
        this.mEditor.putString(str, ArraysKt___ArraysJvmKt.joinToString$default(list, ",", null, null, 0, null, SMTPreferenceHelper$setArray$1.INSTANCE, 30));
        this.mEditor.apply();
    }

    public void setBoolean(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.mEditor.putBoolean(str, z);
        this.mEditor.apply();
    }

    public void setDouble(String str, double d2) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.mEditor.putLong(str, Double.doubleToRawLongBits(d2));
        this.mEditor.apply();
    }

    public void setFloat(String str, float f2) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.mEditor.putFloat(str, f2);
        this.mEditor.apply();
    }

    public void setInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.mEditor.putInt(str, i);
        this.mEditor.apply();
    }

    public void setLong(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.mEditor.putLong(str, j);
        this.mEditor.apply();
    }

    public void setString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, HSLCriteriaBuilder.VALUE);
        this.mEditor.putString(encrypt(str), encrypt(str2));
        this.mEditor.apply();
    }

    public boolean getBoolean(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.mPrefs.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.mPrefs.getInt(str, i);
    }

    public long getLong(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.mPrefs.getLong(str, j);
    }

    public String getString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, HSLCriteriaBuilder.VALUE);
        String string = this.mPrefs.getString(encrypt(str), encrypt(str2));
        if (string == null) {
            string = "";
        }
        return decrypt(string);
    }

    public /* synthetic */ SMTPreferenceHelper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }
}
