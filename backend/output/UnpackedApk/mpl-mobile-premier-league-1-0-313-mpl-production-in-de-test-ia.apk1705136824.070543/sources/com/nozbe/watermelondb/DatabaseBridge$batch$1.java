package com.nozbe.watermelondb;

import android.os.Trace;
import com.facebook.react.bridge.ReadableArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/nozbe/watermelondb/DatabaseDriver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseBridge.kt */
public final class DatabaseBridge$batch$1 extends Lambda implements Function1<DatabaseDriver, Unit> {
    public final /* synthetic */ ReadableArray $operations;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseBridge$batch$1(ReadableArray readableArray) {
        // this.$operations = readableArray;
        super(1);
    }

    /* JADX INFO: finally extract failed */
    public Object invoke(Object obj) {
        DatabaseDriver databaseDriver = (DatabaseDriver) obj;
        Intrinsics.checkNotNullParameter(databaseDriver, "it");
        ReadableArray readableArray = this.$operations;
        Intrinsics.checkNotNullParameter(readableArray, "operations");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Trace.beginSection("Batch");
        try {
            databaseDriver.database.transaction(new DatabaseDriver$batch$1(readableArray, databaseDriver, arrayList, arrayList2));
            Trace.endSection();
            Trace.beginSection("updateCaches");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                databaseDriver.markAsCached((String) pair.first, (String) pair.second);
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Pair pair2 = (Pair) it2.next();
                String str = (String) pair2.second;
                List list = databaseDriver.cachedRecords.get((String) pair2.first);
                if (list != null) {
                    list.remove(str);
                }
            }
            Trace.endSection();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
