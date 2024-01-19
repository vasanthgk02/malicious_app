package com.nozbe.watermelondb;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseDriver.kt */
public final class DatabaseDriver$setUpSchema$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Schema $schema;
    public final /* synthetic */ DatabaseDriver this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseDriver$setUpSchema$1(DatabaseDriver databaseDriver, Schema schema) {
        // this.this$0 = databaseDriver;
        // this.$schema = schema;
        super(0);
    }

    public Object invoke() {
        Database database = this.this$0.database;
        String stringPlus = Intrinsics.stringPlus(this.$schema.sql, "\n        create table local_storage (\n        key varchar(16) primary key not null,\n        value text not null\n        );\n\n        create index local_storage_key_index on local_storage (key);\n    ");
        if (database != null) {
            Intrinsics.checkNotNullParameter(stringPlus, "statements");
            database.transaction(new Database$unsafeExecuteStatements$1(stringPlus, database));
            Database database2 = this.this$0.database;
            database2.getDb().setVersion(this.$schema.version);
            return Unit.INSTANCE;
        }
        throw null;
    }
}
