package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.-$$Lambda$SchemaManager$V2XpHOEqNs-xjZeHRKfPgpBoXd8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SchemaManager$V2XpHOEqNsxjZeHRKfPgpBoXd8 implements Migration {
    public static final /* synthetic */ $$Lambda$SchemaManager$V2XpHOEqNsxjZeHRKfPgpBoXd8 INSTANCE = new $$Lambda$SchemaManager$V2XpHOEqNsxjZeHRKfPgpBoXd8();

    private /* synthetic */ $$Lambda$SchemaManager$V2XpHOEqNsxjZeHRKfPgpBoXd8() {
    }

    public final void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$1(sQLiteDatabase);
    }
}
