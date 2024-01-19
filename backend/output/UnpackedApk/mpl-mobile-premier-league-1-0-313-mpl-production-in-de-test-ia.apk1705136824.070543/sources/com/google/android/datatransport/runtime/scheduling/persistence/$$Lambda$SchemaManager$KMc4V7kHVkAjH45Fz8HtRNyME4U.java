package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.-$$Lambda$SchemaManager$KMc4V7kHVkAjH45Fz8HtRNyME4U  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SchemaManager$KMc4V7kHVkAjH45Fz8HtRNyME4U implements Migration {
    public static final /* synthetic */ $$Lambda$SchemaManager$KMc4V7kHVkAjH45Fz8HtRNyME4U INSTANCE = new $$Lambda$SchemaManager$KMc4V7kHVkAjH45Fz8HtRNyME4U();

    private /* synthetic */ $$Lambda$SchemaManager$KMc4V7kHVkAjH45Fz8HtRNyME4U() {
    }

    public final void upgrade(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
