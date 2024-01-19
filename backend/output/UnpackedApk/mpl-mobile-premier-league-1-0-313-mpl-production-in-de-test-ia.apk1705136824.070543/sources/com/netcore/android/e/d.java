package com.netcore.android.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.netcore.android.Smartech;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.smartechbase.communication.SmartechPushInterface;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTDatabase.kt */
public final class d extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static e f1036b;

    /* renamed from: c  reason: collision with root package name */
    public static h f1037c;

    /* renamed from: d  reason: collision with root package name */
    public static f f1038d;

    /* renamed from: e  reason: collision with root package name */
    public static g f1039e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile d f1040f;
    public static volatile SQLiteDatabase g;
    public static final String h = d.class.getSimpleName();
    public static final a i = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f1041a;

    /* compiled from: SMTDatabase.kt */
    public static final class a {
        public a() {
        }

        /* access modifiers changed from: private */
        public final void c(Context context) {
            c b2 = c.f1033e.b(context);
            SQLiteDatabase b3 = d.g;
            if (b3 != null) {
                b2.a(b3);
            }
            SmartechPushInterface smartechPNInterface$smartech_release = Smartech.Companion.getInstance(new WeakReference(context)).getSmartechPNInterface$smartech_release();
            if (smartechPNInterface$smartech_release != null) {
                smartechPNInterface$smartech_release.createTable(context, d.g);
            }
            d.f1036b = new e(b2);
            d.f1037c = new h(b2);
            d.f1038d = new f(b2);
            d.f1039e = new g(b2);
        }

        public final d b(Context context) {
            d dVar;
            Intrinsics.checkNotNullParameter(context, "context");
            d a2 = d.f1040f;
            if (a2 != null) {
                return a2;
            }
            synchronized (d.class) {
                try {
                    d a3 = d.f1040f;
                    if (a3 != null) {
                        dVar = a3;
                    } else {
                        dVar = d.i.a(context);
                        d.f1040f = dVar;
                    }
                }
            }
            return dVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final d a(Context context) {
            d dVar = new d(new WeakReference(context), null);
            a(dVar);
            c(context);
            c b2 = c.f1033e.b(context);
            SQLiteDatabase b3 = d.g;
            Intrinsics.checkNotNull(b3);
            b2.a(b3);
            return dVar;
        }

        private final void a(d dVar) {
            if (d.g == null) {
                d.g = dVar.getWritableDatabase();
            }
            SQLiteDatabase b2 = d.g;
            if (b2 != null && !b2.isOpen()) {
                d.g = dVar.getWritableDatabase();
            }
        }
    }

    public /* synthetic */ d(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    public final e c() {
        e eVar = f1036b;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEventTable");
        throw null;
    }

    public void close() {
        f1040f = null;
        SQLiteDatabase sQLiteDatabase = g;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        g = null;
    }

    public final f d() {
        f fVar = f1038d;
        if (fVar != null) {
            return fVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGeoFenceGroupTable");
        throw null;
    }

    public final g e() {
        g gVar = f1039e;
        if (gVar != null) {
            return gVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGeoFenceTable");
        throw null;
    }

    public final h f() {
        h hVar = f1037c;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mInAppRulesTable");
        throw null;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = h;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "onCreate()");
        if (sQLiteDatabase != null) {
            Context context = (Context) this.f1041a.get();
            if (context != null) {
                com.netcore.android.e.c.a aVar = c.f1033e;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                c b2 = aVar.b(context);
                b2.a(sQLiteDatabase);
                f1036b = new e(b2);
                f1037c = new h(b2);
                e eVar = f1036b;
                if (eVar != null) {
                    eVar.a();
                    h hVar = f1037c;
                    if (hVar != null) {
                        hVar.b();
                        Context context2 = (Context) this.f1041a.get();
                        if (context2 != null) {
                            SmartechPushInterface smartechPNInterface$smartech_release = Smartech.Companion.getInstance(this.f1041a).getSmartechPNInterface$smartech_release();
                            if (smartechPNInterface$smartech_release != null) {
                                Intrinsics.checkNotNullExpressionValue(context2, "it");
                                smartechPNInterface$smartech_release.createTable(context2, sQLiteDatabase);
                            }
                        }
                        f1038d = new f(b2);
                        f1039e = new g(b2);
                        f fVar = f1038d;
                        if (fVar != null) {
                            fVar.a();
                            g gVar = f1039e;
                            if (gVar != null) {
                                gVar.a();
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("mGeoFenceTable");
                                throw null;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("mGeoFenceGroupTable");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mInAppRulesTable");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mEventTable");
                    throw null;
                }
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = h;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "onUpgrade() old db version " + i2 + " & new db version " + i3);
        if (sQLiteDatabase != null) {
            Context context = (Context) this.f1041a.get();
            if (context != null) {
                com.netcore.android.e.c.a aVar = c.f1033e;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                aVar.b(context).a(sQLiteDatabase);
                i.c(context);
                e eVar = f1036b;
                if (eVar != null) {
                    eVar.b(i2, i3);
                    h hVar = f1037c;
                    if (hVar != null) {
                        hVar.a(i2, i3);
                        Context context2 = (Context) this.f1041a.get();
                        if (context2 != null) {
                            SmartechPushInterface smartechPNInterface$smartech_release = Smartech.Companion.getInstance(this.f1041a).getSmartechPNInterface$smartech_release();
                            if (smartechPNInterface$smartech_release != null) {
                                Intrinsics.checkNotNullExpressionValue(context2, "it");
                                smartechPNInterface$smartech_release.upgradeTable(context2, sQLiteDatabase, i2, i3);
                            }
                        }
                        f fVar = f1038d;
                        if (fVar != null) {
                            fVar.a(i2, i3);
                            g gVar = f1039e;
                            if (gVar != null) {
                                gVar.a(i2, i3);
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("mGeoFenceTable");
                                throw null;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("mGeoFenceGroupTable");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mInAppRulesTable");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mEventTable");
                    throw null;
                }
            }
        }
    }

    public d(WeakReference<Context> weakReference) {
        super((Context) weakReference.get(), "NCSmartech", null, 7);
        this.f1041a = weakReference;
    }
}
