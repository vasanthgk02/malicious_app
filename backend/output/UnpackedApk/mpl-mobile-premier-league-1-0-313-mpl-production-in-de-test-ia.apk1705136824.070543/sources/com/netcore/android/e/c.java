package com.netcore.android.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.netcore.android.utility.k.d;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTDataBaseWrapper.kt */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static SQLiteDatabase f1031c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f1032d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f1033e = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1034a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f1035b;

    /* compiled from: SMTDataBaseWrapper.kt */
    public static final class a {
        public a() {
        }

        private final c a(Context context) {
            return new c(new WeakReference(context), null);
        }

        public final c b(Context context) {
            c cVar;
            Intrinsics.checkNotNullParameter(context, "context");
            c a2 = c.f1032d;
            if (a2 != null) {
                return a2;
            }
            synchronized (c.class) {
                c a3 = c.f1032d;
                if (a3 != null) {
                    cVar = a3;
                } else {
                    cVar = c.f1033e.a(context);
                    c.f1032d = cVar;
                }
            }
            return cVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(WeakReference<Context> weakReference) {
        this.f1035b = weakReference;
        this.f1034a = c.class.getSimpleName();
    }

    public final void b() {
        SQLiteDatabase sQLiteDatabase = f1031c;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
        }
    }

    public final void c() {
        try {
            SQLiteDatabase sQLiteDatabase = f1031c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1034a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.e(str, "Database full, unable to endTransaction, error - " + e2);
        }
    }

    public final SQLiteDatabase d() {
        return f1031c;
    }

    public final Boolean e() {
        Context context = (Context) this.f1035b.get();
        if (context == null) {
            return null;
        }
        Companion companion = SMTPreferenceHelper.Companion;
        Intrinsics.checkNotNullExpressionValue(context, "it");
        return Boolean.valueOf(companion.getAppPreferenceInstance(context, null).getBoolean(SMTPreferenceConstants.SMT_ENCRYPT_DB, false));
    }

    public final void f() {
        SQLiteDatabase sQLiteDatabase = f1031c;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.setTransactionSuccessful();
        }
    }

    public byte[] b(byte[] bArr) {
        try {
            d a2 = d.a("AES/GCM/NoPadding");
            Intrinsics.checkNotNullExpressionValue(a2, "SMTEncryptionHelper.getI…nts.AES_CIPHER_ALGORITHM)");
            return a2.a().a(bArr);
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1034a;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
            return null;
        }
    }

    public /* synthetic */ c(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "mDb");
        f1031c = sQLiteDatabase;
    }

    public final Cursor a(String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "sql");
        SQLiteDatabase sQLiteDatabase = f1031c;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase.rawQuery(str, strArr);
        }
        return null;
    }

    public final int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        Intrinsics.checkNotNullParameter(str2, "selection");
        try {
            SQLiteDatabase sQLiteDatabase = f1031c;
            if (sQLiteDatabase != null) {
                return sQLiteDatabase.update(str, contentValues, str2, strArr);
            }
            return 0;
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str3 = this.f1034a;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger.e(str3, "Database full, unable to update, error - " + e2);
            return 0;
        }
    }

    public final int a(String str, String str2, String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        try {
            SQLiteDatabase sQLiteDatabase = f1031c;
            if (sQLiteDatabase != null) {
                return sQLiteDatabase.delete(str, str2, strArr);
            }
            return 0;
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str3 = this.f1034a;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger.e(str3, "Database full, unable to delete, error - " + e2);
            return 0;
        }
    }

    public final long a(String str, String str2, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        try {
            SQLiteDatabase sQLiteDatabase = f1031c;
            if (sQLiteDatabase != null) {
                return sQLiteDatabase.insert(str, str2, contentValues);
            }
            return -1;
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str3 = this.f1034a;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger.e(str3, "Database full, unable to insert, error " + e2);
            return -1;
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        try {
            SQLiteDatabase sQLiteDatabase = f1031c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL(str);
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = this.f1034a;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.e(str2, "Database full, unable to execSQL, error " + e2);
        }
    }

    public byte[] a(byte[] bArr) {
        try {
            d a2 = d.a("AES/GCM/NoPadding");
            Intrinsics.checkNotNullExpressionValue(a2, "SMTEncryptionHelper.getI…nts.AES_CIPHER_ALGORITHM)");
            return a2.a().b(bArr);
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1034a;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
            return null;
        }
    }
}
