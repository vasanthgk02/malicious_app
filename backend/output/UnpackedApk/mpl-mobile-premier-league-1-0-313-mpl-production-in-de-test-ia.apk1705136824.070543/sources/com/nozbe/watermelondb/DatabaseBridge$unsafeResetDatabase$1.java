package com.nozbe.watermelondb;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/nozbe/watermelondb/DatabaseDriver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseBridge.kt */
public final class DatabaseBridge$unsafeResetDatabase$1 extends Lambda implements Function1<DatabaseDriver, Unit> {
    public final /* synthetic */ String $schema;
    public final /* synthetic */ int $schemaVersion;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseBridge$unsafeResetDatabase$1(int i, String str) {
        // this.$schemaVersion = i;
        // this.$schema = str;
        super(1);
    }

    public Object invoke(Object obj) {
        DatabaseDriver databaseDriver = (DatabaseDriver) obj;
        Intrinsics.checkNotNullParameter(databaseDriver, "it");
        databaseDriver.unsafeResetDatabase(new Schema(this.$schemaVersion, this.$schema));
        return Unit.INSTANCE;
    }
}
