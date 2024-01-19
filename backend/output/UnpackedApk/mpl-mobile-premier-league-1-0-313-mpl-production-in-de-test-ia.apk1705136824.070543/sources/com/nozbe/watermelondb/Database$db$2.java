package com.nozbe.watermelondb;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/database/sqlite/SQLiteDatabase;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Database.kt */
public final class Database$db$2 extends Lambda implements Function0<SQLiteDatabase> {
    public final /* synthetic */ Database this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Database$db$2(Database database) {
        // this.this$0 = database;
        super(0);
    }

    public Object invoke() {
        String str;
        if (Intrinsics.areEqual(this.this$0.name, ":memory:") || CharsKt__CharKt.contains$default((CharSequence) this.this$0.name, (CharSequence) "mode=memory", false, 2)) {
            this.this$0.context.getCacheDir().delete();
            str = new File(this.this$0.context.getCacheDir(), this.this$0.name).getPath();
        } else {
            Database database = this.this$0;
            String path = database.context.getDatabasePath(Intrinsics.stringPlus(database.name, ".db")).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "context.getDatabasePath(\"$name.db\").path");
            str = CharsKt__CharKt.replace$default(path, (String) "/databases", (String) "", false, 4);
        }
        return SQLiteDatabase.openOrCreateDatabase(str, null);
    }
}
