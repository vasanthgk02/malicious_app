package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoomDatabase.kt */
public final class RoomDatabase$beginTransaction$1 extends Lambda implements Function1<SupportSQLiteDatabase, Object> {
    public final /* synthetic */ RoomDatabase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RoomDatabase$beginTransaction$1(RoomDatabase roomDatabase) {
        // this.this$0 = roomDatabase;
        super(1);
    }

    public Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) obj, "it");
        this.this$0.internalBeginTransaction();
        return null;
    }
}
