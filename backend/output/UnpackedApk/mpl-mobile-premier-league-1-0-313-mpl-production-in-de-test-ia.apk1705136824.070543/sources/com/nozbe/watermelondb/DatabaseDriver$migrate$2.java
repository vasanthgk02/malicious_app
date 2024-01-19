package com.nozbe.watermelondb;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseDriver.kt */
public final class DatabaseDriver$migrate$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MigrationSet $migrations;
    public final /* synthetic */ DatabaseDriver this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseDriver$migrate$2(DatabaseDriver databaseDriver, MigrationSet migrationSet) {
        // this.this$0 = databaseDriver;
        // this.$migrations = migrationSet;
        super(0);
    }

    public Object invoke() {
        Database database = this.this$0.database;
        String str = this.$migrations.sql;
        if (database != null) {
            Intrinsics.checkNotNullParameter(str, "statements");
            database.transaction(new Database$unsafeExecuteStatements$1(str, database));
            Database database2 = this.this$0.database;
            database2.getDb().setVersion(this.$migrations.to);
            return Unit.INSTANCE;
        }
        throw null;
    }
}
