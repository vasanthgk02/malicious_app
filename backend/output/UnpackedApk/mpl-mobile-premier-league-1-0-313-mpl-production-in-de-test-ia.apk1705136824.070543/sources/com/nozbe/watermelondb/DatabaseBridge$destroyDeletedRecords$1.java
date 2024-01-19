package com.nozbe.watermelondb;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReadableArray;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/nozbe/watermelondb/DatabaseDriver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseBridge.kt */
public final class DatabaseBridge$destroyDeletedRecords$1 extends Lambda implements Function1<DatabaseDriver, Unit> {
    public final /* synthetic */ ReadableArray $records;
    public final /* synthetic */ String $table;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseBridge$destroyDeletedRecords$1(String str, ReadableArray readableArray) {
        // this.$table = str;
        // this.$records = readableArray;
        super(1);
    }

    public Object invoke(Object obj) {
        DatabaseDriver databaseDriver = (DatabaseDriver) obj;
        Intrinsics.checkNotNullParameter(databaseDriver, "it");
        String str = this.$table;
        Object[] array = this.$records.toArrayList().toArray();
        Intrinsics.checkNotNullExpressionValue(array, "records.toArrayList().toArray()");
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(array, "records");
        Database database = databaseDriver.database;
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(array, "args");
        StringBuilder sb = new StringBuilder();
        sb.append("delete from `");
        sb.append(str);
        sb.append("` where id in ");
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('(');
        outline72.append(TweetUtils.joinToString$default(array, null, null, null, 0, null, Queries$preparePlaceholder$1.INSTANCE, 31));
        outline72.append(')');
        sb.append(outline72.toString());
        String sb2 = sb.toString();
        if (database != null) {
            Intrinsics.checkNotNullParameter(sb2, "query");
            Intrinsics.checkNotNullParameter(array, "args");
            database.getDb().execSQL(sb2, array);
            return Unit.INSTANCE;
        }
        throw null;
    }
}
