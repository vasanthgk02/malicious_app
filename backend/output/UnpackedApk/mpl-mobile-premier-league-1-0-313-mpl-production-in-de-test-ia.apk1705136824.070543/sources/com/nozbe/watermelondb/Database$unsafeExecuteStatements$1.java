package com.nozbe.watermelondb;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Database.kt */
public final class Database$unsafeExecuteStatements$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ String $statements;
    public final /* synthetic */ Database this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Database$unsafeExecuteStatements$1(String str, Database database) {
        // this.$statements = str;
        // this.this$0 = database;
        super(0);
    }

    public Object invoke() {
        List<String> split$default = CharsKt__CharKt.split$default((CharSequence) this.$statements, new String[]{";"}, false, 0, 6);
        Database database = this.this$0;
        for (String str : split$default) {
            if (!CharsKt__CharKt.isBlank(str)) {
                Database.execute$default(database, str, null, 2);
            }
        }
        return Unit.INSTANCE;
    }
}
