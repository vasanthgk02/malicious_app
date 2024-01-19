package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/sqlite/db/SupportSQLiteStatement;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SharedSQLiteStatement.kt */
public final class SharedSQLiteStatement$stmt$2 extends Lambda implements Function0<SupportSQLiteStatement> {
    public final /* synthetic */ SharedSQLiteStatement this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SharedSQLiteStatement$stmt$2(SharedSQLiteStatement sharedSQLiteStatement) {
        // this.this$0 = sharedSQLiteStatement;
        super(0);
    }

    public Object invoke() {
        return this.this$0.createNewStatement();
    }
}
