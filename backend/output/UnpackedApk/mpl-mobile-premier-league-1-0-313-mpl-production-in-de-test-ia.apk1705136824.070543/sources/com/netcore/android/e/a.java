package com.netcore.android.e;

import android.database.Cursor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTDBTable.kt */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final c f1027a;

    public a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "dbWrapper");
        this.f1027a = cVar;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "tableName");
        this.f1027a.a(str, (String) null, (String[]) null);
    }

    public final Cursor b(String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        return this.f1027a.a(str, null);
    }
}
