package com.mpl.androidapp.utils.encryptedPrefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.mpl.androidapp.game.disconnection.Jumble;
import com.mpl.androidapp.utils.MLogger;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\fJ\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/utils/encryptedPrefs/MEncryptedPrefs;", "", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getBoolean", "", "key", "", "defValue", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "getInt", "", "(Ljava/lang/String;I)Ljava/lang/Integer;", "getString", "init", "", "context", "Landroid/content/Context;", "putBoolean", "value", "putInt", "putString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MEncryptedPrefs.kt */
public final class MEncryptedPrefs {
    public static final MEncryptedPrefs INSTANCE = new MEncryptedPrefs();
    public static SharedPreferences sharedPreferences;

    public final Boolean getBoolean(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        Boolean bool = null;
        if (VERSION.SDK_INT < 23) {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                bool = Boolean.valueOf(sharedPreferences2.getBoolean(str, z));
            }
            return Boolean.valueOf(Boolean.parseBoolean(Jumble.decrypt(String.valueOf(bool))));
        }
        SharedPreferences sharedPreferences3 = sharedPreferences;
        if (sharedPreferences3 == null) {
            return null;
        }
        return Boolean.valueOf(sharedPreferences3.getBoolean(str, z));
    }

    public final Integer getInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Integer num = null;
        if (VERSION.SDK_INT < 23) {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                num = Integer.valueOf(sharedPreferences2.getInt(str, i));
            }
            String decrypt = Jumble.decrypt(String.valueOf(num));
            Intrinsics.checkNotNullExpressionValue(decrypt, "decrypt(sharedPreference…ey, defValue).toString())");
            return Integer.valueOf(Integer.parseInt(decrypt));
        }
        SharedPreferences sharedPreferences3 = sharedPreferences;
        if (sharedPreferences3 == null) {
            return null;
        }
        return Integer.valueOf(sharedPreferences3.getInt(str, i));
    }

    public final String getString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "defValue");
        String str3 = null;
        if (VERSION.SDK_INT < 23) {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                str3 = sharedPreferences2.getString(str, str2);
            }
            return Jumble.decrypt(str3);
        }
        SharedPreferences sharedPreferences3 = sharedPreferences;
        if (sharedPreferences3 == null) {
            return null;
        }
        return sharedPreferences3.getString(str, str2);
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new MEncryptedPrefs$init$1(context, null), 3, null);
    }

    public final void putBoolean(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (VERSION.SDK_INT < 23) {
            z = Boolean.parseBoolean(Jumble.encrypt(String.valueOf(z)));
        }
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            Editor edit = sharedPreferences2.edit();
            edit.putBoolean(str, z);
            edit.commit();
            Intrinsics.checkNotNullExpressionValue(edit, "it.edit().apply {\n      …   commit()\n            }");
        }
    }

    public final void putInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            if (MEncryptedPrefsKt.isInteger(String.valueOf(i))) {
                if (VERSION.SDK_INT < 23) {
                    String encrypt = Jumble.encrypt(String.valueOf(i));
                    Intrinsics.checkNotNullExpressionValue(encrypt, "encrypt(value.toString())");
                    i = Integer.parseInt(encrypt);
                }
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    Editor edit = sharedPreferences2.edit();
                    edit.putInt(str, i);
                    edit.commit();
                    Intrinsics.checkNotNullExpressionValue(edit, "it.edit().apply {\n      …t()\n                    }");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            MLogger.e("Encrypted Preferences", Unit.INSTANCE);
        }
    }

    public final void putString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, HSLCriteriaBuilder.VALUE);
        if (VERSION.SDK_INT < 23) {
            str2 = Jumble.encrypt(str2);
            Intrinsics.checkNotNullExpressionValue(str2, "{\n            Jumble.encrypt(value)\n        }");
        }
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            Editor edit = sharedPreferences2.edit();
            edit.putString(str, str2);
            edit.commit();
            Intrinsics.checkNotNullExpressionValue(edit, "it.edit().apply {\n      …   commit()\n            }");
        }
    }
}
