package com.nozbe.watermelondb;

import com.facebook.react.bridge.ReadableArray;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseDriver.kt */
public final class DatabaseDriver$batch$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ArrayList<Pair<String, String>> $newIds;
    public final /* synthetic */ ReadableArray $operations;
    public final /* synthetic */ ArrayList<Pair<String, String>> $removedIds;
    public final /* synthetic */ DatabaseDriver this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseDriver$batch$1(ReadableArray readableArray, DatabaseDriver databaseDriver, ArrayList<Pair<String, String>> arrayList, ArrayList<Pair<String, String>> arrayList2) {
        // this.$operations = readableArray;
        // this.this$0 = databaseDriver;
        // this.$newIds = arrayList;
        // this.$removedIds = arrayList2;
        super(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x013e, code lost:
        r2 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r14 = this;
            com.facebook.react.bridge.ReadableArray r0 = r14.$operations
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x0008:
            if (r2 >= r0) goto L_0x015b
            int r3 = r2 + 1
            com.facebook.react.bridge.ReadableArray r4 = r14.$operations
            com.facebook.react.bridge.ReadableArray r2 = r4.getArray(r2)
            if (r2 != 0) goto L_0x0016
            r4 = 0
            goto L_0x001a
        L_0x0016:
            java.lang.String r4 = r2.getString(r1)
        L_0x001a:
            if (r4 == 0) goto L_0x0153
            int r5 = r4.hashCode()
            java.lang.String r6 = "table"
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.String{ com.nozbe.watermelondb.DatabaseUtilsKt.SQL }"
            java.lang.String r8 = "args"
            r9 = 3
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.String{ com.nozbe.watermelondb.DatabaseUtilsKt.RecordID }"
            java.lang.String r11 = "null cannot be cast to non-null type kotlin.String{ com.nozbe.watermelondb.DatabaseUtilsKt.TableName }"
            r12 = 2
            r13 = 1
            switch(r5) {
                case -1352294148: goto L_0x0100;
                case -1319569547: goto L_0x00d2;
                case -271749318: goto L_0x0082;
                case 1090393697: goto L_0x0032;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0153
        L_0x0032:
            java.lang.String r5 = "destroyPermanently"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0153
            java.lang.String r4 = r2.getString(r13)
            if (r4 == 0) goto L_0x007c
            java.lang.String r2 = r2.getString(r12)
            if (r2 == 0) goto L_0x0076
            com.nozbe.watermelondb.DatabaseDriver r5 = r14.this$0
            com.nozbe.watermelondb.Database r5 = r5.database
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "delete from `"
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = "` where id == ?"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r7 = new java.lang.Object[r13]
            r7[r1] = r2
            r5.execute(r6, r7)
            java.util.ArrayList<kotlin.Pair<java.lang.String, java.lang.String>> r5 = r14.$removedIds
            kotlin.Pair r6 = new kotlin.Pair
            r6.<init>(r4, r2)
            r5.add(r6)
            goto L_0x013e
        L_0x0076:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r10)
            throw r0
        L_0x007c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r11)
            throw r0
        L_0x0082:
            java.lang.String r5 = "markAsDeleted"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0153
            java.lang.String r4 = r2.getString(r13)
            if (r4 == 0) goto L_0x00cc
            java.lang.String r2 = r2.getString(r12)
            if (r2 == 0) goto L_0x00c6
            com.nozbe.watermelondb.DatabaseDriver r5 = r14.this$0
            com.nozbe.watermelondb.Database r5 = r5.database
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "update `"
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = "` set _status='deleted' where id == ?"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r7 = new java.lang.Object[r13]
            r7[r1] = r2
            r5.execute(r6, r7)
            java.util.ArrayList<kotlin.Pair<java.lang.String, java.lang.String>> r5 = r14.$removedIds
            kotlin.Pair r6 = new kotlin.Pair
            r6.<init>(r4, r2)
            r5.add(r6)
            goto L_0x013e
        L_0x00c6:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r10)
            throw r0
        L_0x00cc:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r11)
            throw r0
        L_0x00d2:
            java.lang.String r5 = "execute"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0153
            java.lang.String r4 = r2.getString(r12)
            if (r4 == 0) goto L_0x00fa
            com.facebook.react.bridge.ReadableArray r2 = r2.getArray(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.util.ArrayList r2 = r2.toArrayList()
            java.lang.Object[] r2 = r2.toArray()
            com.nozbe.watermelondb.DatabaseDriver r5 = r14.this$0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            com.nozbe.watermelondb.Database r5 = r5.database
            r5.execute(r4, r2)
            goto L_0x013e
        L_0x00fa:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r7)
            throw r0
        L_0x0100:
            java.lang.String r5 = "create"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0153
            java.lang.String r4 = r2.getString(r13)
            if (r4 == 0) goto L_0x014d
            java.lang.String r5 = r2.getString(r12)
            if (r5 == 0) goto L_0x0147
            java.lang.String r6 = r2.getString(r9)
            if (r6 == 0) goto L_0x0141
            r7 = 4
            com.facebook.react.bridge.ReadableArray r2 = r2.getArray(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.util.ArrayList r2 = r2.toArrayList()
            java.lang.Object[] r2 = r2.toArray()
            com.nozbe.watermelondb.DatabaseDriver r7 = r14.this$0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            com.nozbe.watermelondb.Database r7 = r7.database
            r7.execute(r6, r2)
            java.util.ArrayList<kotlin.Pair<java.lang.String, java.lang.String>> r2 = r14.$newIds
            kotlin.Pair r6 = new kotlin.Pair
            r6.<init>(r4, r5)
            r2.add(r6)
        L_0x013e:
            r2 = r3
            goto L_0x0008
        L_0x0141:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r7)
            throw r0
        L_0x0147:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r10)
            throw r0
        L_0x014d:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r11)
            throw r0
        L_0x0153:
            java.lang.Throwable r0 = new java.lang.Throwable
            java.lang.String r1 = "Bad operation name in batch"
            r0.<init>(r1)
            throw r0
        L_0x015b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nozbe.watermelondb.DatabaseDriver$batch$1.invoke():java.lang.Object");
    }
}
