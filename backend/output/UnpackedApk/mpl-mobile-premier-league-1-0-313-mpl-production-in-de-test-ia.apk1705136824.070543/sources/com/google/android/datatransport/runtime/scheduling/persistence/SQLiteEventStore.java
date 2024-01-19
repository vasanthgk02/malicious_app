package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped.Reason;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow.Builder;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {
    public static final Encoding PROTOBUF_ENCODING = new Encoding("proto");
    public final EventStoreConfig config;
    public final Clock monotonicClock;
    public final Lazy<String> packageName;
    public final SchemaManager schemaManager;
    public final Clock wallClock;

    public interface Function<T, U> {
        U apply(T t);
    }

    public static class Metadata {
        public final String key;
        public final String value;

        public Metadata(String str, String str2, AnonymousClass1 r3) {
            this.key = str;
            this.value = str2;
        }
    }

    public interface Producer<T> {
        T produce();
    }

    public SQLiteEventStore(Clock clock, Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager2, Lazy<String> lazy) {
        this.schemaManager = schemaManager2;
        this.wallClock = clock;
        this.monotonicClock = clock2;
        this.config = eventStoreConfig;
        this.packageName = lazy;
    }

    public static /* synthetic */ Object lambda$ensureBeginTransaction$25(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ SQLiteDatabase lambda$getDb$0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Long lambda$getNextCallTime$5(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return Long.valueOf(0);
    }

    public static TimeWindow lambda$getTimeWindow$21(long j, Cursor cursor) {
        cursor.moveToNext();
        long j2 = cursor.getLong(0);
        Builder newBuilder = TimeWindow.newBuilder();
        newBuilder.start_ms_ = j2;
        newBuilder.end_ms_ = j;
        return new TimeWindow(newBuilder.start_ms_, newBuilder.end_ms_);
    }

    public static TimeWindow lambda$getTimeWindow$22(long j, SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
        try {
            return lambda$getTimeWindow$21(j, rawQuery);
        } finally {
            rawQuery.close();
        }
    }

    public static /* synthetic */ Long lambda$getTransportContextId$2(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    public static List lambda$loadActiveContexts$10(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
        try {
            return lambda$loadActiveContexts$9(rawQuery);
        } finally {
            rawQuery.close();
        }
    }

    public static List lambda$loadActiveContexts$9(Cursor cursor) {
        byte[] bArr;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            TransportContext.Builder builder = TransportContext.builder();
            builder.setBackendName(cursor.getString(1));
            builder.setPriority(PriorityMapping.valueOf(cursor.getInt(2)));
            String string = cursor.getString(3);
            if (string == null) {
                bArr = null;
            } else {
                bArr = Base64.decode(string, 0);
            }
            AutoValue_TransportContext.Builder builder2 = (AutoValue_TransportContext.Builder) builder;
            builder2.extras = bArr;
            arrayList.add(builder2.build());
        }
        return arrayList;
    }

    public static /* synthetic */ Object lambda$loadMetadata$16(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new Metadata(cursor.getString(1), cursor.getString(2), null));
        }
        return null;
    }

    public static /* synthetic */ byte[] lambda$readPayload$15(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i += blob.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ Boolean lambda$recordLogEventDropped$17(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    /* JADX INFO: finally extract failed */
    public static Object lambda$recordLogEventDropped$18(String str, Reason reason, long j, SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
        try {
            Boolean lambda$recordLogEventDropped$17 = lambda$recordLogEventDropped$17(rawQuery);
            rawQuery.close();
            if (!lambda$recordLogEventDropped$17.booleanValue()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("log_source", str);
                contentValues.put("reason", Integer.valueOf(reason.getNumber()));
                contentValues.put("events_dropped_count", Long.valueOf(j));
                sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            } else {
                sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
            }
            return null;
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    public static Object lambda$recordNextCallTime$7(long j, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{((AutoValue_TransportContext) transportContext).backendName, String.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority))}) < 1) {
            contentValues.put("backend_name", autoValue_TransportContext.backendName);
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static Encoding toEncoding(String str) {
        if (str == null) {
            return PROTOBUF_ENCODING;
        }
        return new Encoding(str);
    }

    public static String toIdList(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((AutoValue_PersistedEvent) it.next()).id);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: finally extract failed */
    public int cleanUp() {
        long time = this.wallClock.getTime() - ((AutoValue_EventStoreConfig) this.config).eventCleanUpAge;
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            Integer lambda$cleanUp$12$SQLiteEventStore = lambda$cleanUp$12$SQLiteEventStore(time, db);
            db.setTransactionSuccessful();
            db.endTransaction();
            return lambda$cleanUp$12$SQLiteEventStore.intValue();
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    public void close() {
        this.schemaManager.close();
    }

    public final Reason convertToReason(int i) {
        if (i == Reason.REASON_UNKNOWN.getNumber()) {
            return Reason.REASON_UNKNOWN;
        }
        if (i == Reason.MESSAGE_TOO_OLD.getNumber()) {
            return Reason.MESSAGE_TOO_OLD;
        }
        if (i == Reason.CACHE_FULL.getNumber()) {
            return Reason.CACHE_FULL;
        }
        if (i == Reason.PAYLOAD_TOO_BIG.getNumber()) {
            return Reason.PAYLOAD_TOO_BIG;
        }
        if (i == Reason.MAX_RETRIES_REACHED.getNumber()) {
            return Reason.MAX_RETRIES_REACHED;
        }
        if (i == Reason.INVALID_PAYLOD.getNumber()) {
            return Reason.INVALID_PAYLOD;
        }
        if (i == Reason.SERVER_ERROR.getNumber()) {
            return Reason.SERVER_ERROR;
        }
        ImageOriginUtils.d("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i));
        return Reason.REASON_UNKNOWN;
    }

    public final long ensureTransportContext(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId != null) {
            return transportContextId.longValue();
        }
        ContentValues contentValues = new ContentValues();
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext;
        contentValues.put("backend_name", autoValue_TransportContext.backendName);
        contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority)));
        contentValues.put("next_request_ms", Integer.valueOf(0));
        byte[] bArr = autoValue_TransportContext.extras;
        if (bArr != null) {
            contentValues.put("extras", Base64.encodeToString(bArr, 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public SQLiteDatabase getDb() {
        SchemaManager schemaManager2 = this.schemaManager;
        Objects.requireNonNull(schemaManager2);
        return (SQLiteDatabase) retryIfDbLocked(new Producer() {
            public final Object produce() {
                return SchemaManager.this.getWritableDatabase();
            }
        }, $$Lambda$SQLiteEventStore$um25oEoA60fAOv07ztYlCvK_sgs.INSTANCE);
    }

    public final GlobalMetrics getGlobalMetrics() {
        GlobalMetrics.Builder newBuilder = GlobalMetrics.newBuilder();
        StorageMetrics.Builder newBuilder2 = StorageMetrics.newBuilder();
        newBuilder2.current_cache_size_bytes_ = getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
        newBuilder2.max_cache_size_bytes_ = ((AutoValue_EventStoreConfig) EventStoreConfig.DEFAULT).maxStorageSizeInBytes;
        newBuilder.storage_metrics_ = new StorageMetrics(newBuilder2.current_cache_size_bytes_, newBuilder2.max_cache_size_bytes_);
        return new GlobalMetrics(newBuilder.storage_metrics_);
    }

    /* JADX INFO: finally extract failed */
    public long getNextCallTime(TransportContext transportContext) {
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext;
        Cursor rawQuery = getDb().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{autoValue_TransportContext.backendName, String.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority))});
        try {
            Long lambda$getNextCallTime$5 = lambda$getNextCallTime$5(rawQuery);
            rawQuery.close();
            return lambda$getNextCallTime$5.longValue();
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    public final TimeWindow getTimeWindow() {
        long time = this.wallClock.getTime();
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            TimeWindow lambda$getTimeWindow$22 = lambda$getTimeWindow$22(time, db);
            db.setTransactionSuccessful();
            return lambda$getTimeWindow$22;
        } finally {
            db.endTransaction();
        }
    }

    public final Long getTransportContextId(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext;
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{((AutoValue_TransportContext) transportContext).backendName, String.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority))}));
        if (autoValue_TransportContext.extras != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(autoValue_TransportContext.extras, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return lambda$getTransportContextId$2(query);
        } finally {
            query.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean hasPendingEventsFor(TransportContext transportContext) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            Boolean lambda$hasPendingEventsFor$6$SQLiteEventStore = lambda$hasPendingEventsFor$6$SQLiteEventStore(transportContext, db);
            db.setTransactionSuccessful();
            db.endTransaction();
            return lambda$hasPendingEventsFor$6$SQLiteEventStore.booleanValue();
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    public final boolean isStorageAtLimit() {
        return getDb().compileStatement("PRAGMA page_count").simpleQueryForLong() * getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() >= ((AutoValue_EventStoreConfig) this.config).maxStorageSizeInBytes;
    }

    public final List<PersistedEvent> join(List<PersistedEvent> list, Map<Long, Set<Metadata>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) listIterator.next();
            if (map.containsKey(Long.valueOf(autoValue_PersistedEvent.id))) {
                EventInternal.Builder builder = autoValue_PersistedEvent.event.toBuilder();
                for (Metadata metadata : map.get(Long.valueOf(autoValue_PersistedEvent.id))) {
                    builder.addMetadata(metadata.key, metadata.value);
                }
                listIterator.set(new AutoValue_PersistedEvent(autoValue_PersistedEvent.id, autoValue_PersistedEvent.transportContext, builder.build()));
            }
        }
        return list;
    }

    public /* synthetic */ Object lambda$cleanUp$11$SQLiteEventStore(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i = cursor.getInt(0);
            recordLogEventDropped((long) i, Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    public Integer lambda$cleanUp$12$SQLiteEventStore(long j, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j)};
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
        try {
            lambda$cleanUp$11$SQLiteEventStore(rawQuery);
            rawQuery.close();
            return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    public Boolean lambda$hasPendingEventsFor$6$SQLiteEventStore(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return Boolean.FALSE;
        }
        Cursor rawQuery = getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()});
        try {
            return Boolean.valueOf(rawQuery.moveToNext());
        } finally {
            rawQuery.close();
        }
    }

    public /* synthetic */ List lambda$loadBatch$8$SQLiteEventStore(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> loadEvents = loadEvents(sQLiteDatabase, transportContext);
        return join(loadEvents, loadMetadata(sQLiteDatabase, loadEvents));
    }

    public ClientMetrics lambda$loadClientMetrics$19$SQLiteEventStore(Map map, ClientMetrics.Builder builder, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            Reason convertToReason = convertToReason(cursor.getInt(1));
            long j = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            LogEventDropped.Builder newBuilder = LogEventDropped.newBuilder();
            newBuilder.reason_ = convertToReason;
            newBuilder.events_dropped_count_ = j;
            ((List) map.get(string)).add(newBuilder.build());
        }
        populateLogSourcesMetrics(builder, map);
        builder.window_ = getTimeWindow();
        builder.global_metrics_ = getGlobalMetrics();
        builder.app_namespace_ = (String) this.packageName.get();
        return builder.build();
    }

    public ClientMetrics lambda$loadClientMetrics$20$SQLiteEventStore(String str, Map map, ClientMetrics.Builder builder, SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, new String[0]);
        try {
            return lambda$loadClientMetrics$19$SQLiteEventStore(map, builder, rawQuery);
        } finally {
            rawQuery.close();
        }
    }

    public Object lambda$loadEvents$14$SQLiteEventStore(List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z = false;
            long j = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z = true;
            }
            EventInternal.Builder builder = EventInternal.builder();
            builder.setTransportName(cursor.getString(1));
            builder.setEventMillis(cursor.getLong(2));
            builder.setUptimeMillis(cursor.getLong(3));
            if (z) {
                builder.setEncodedPayload(new EncodedPayload(toEncoding(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                builder.setEncodedPayload(new EncodedPayload(toEncoding(cursor.getString(4)), readPayload(j)));
            }
            if (!cursor.isNull(6)) {
                ((AutoValue_EventInternal.Builder) builder).code = Integer.valueOf(cursor.getInt(6));
            }
            list.add(new AutoValue_PersistedEvent(j, transportContext, builder.build()));
        }
        return null;
    }

    public Long lambda$persist$1$SQLiteEventStore(EventInternal eventInternal, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        if (isStorageAtLimit()) {
            recordLogEventDropped(1, Reason.CACHE_FULL, ((AutoValue_EventInternal) eventInternal).transportName);
            return Long.valueOf(-1);
        }
        long ensureTransportContext = ensureTransportContext(sQLiteDatabase, transportContext);
        int i = ((AutoValue_EventStoreConfig) this.config).maxBlobByteSizePerRow;
        byte[] bArr = ((AutoValue_EventInternal) eventInternal).encodedPayload.bytes;
        boolean z = bArr.length <= i;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(ensureTransportContext));
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) eventInternal;
        contentValues.put("transport_name", autoValue_EventInternal.transportName);
        contentValues.put("timestamp_ms", Long.valueOf(autoValue_EventInternal.eventMillis));
        contentValues.put("uptime_ms", Long.valueOf(autoValue_EventInternal.uptimeMillis));
        contentValues.put("payload_encoding", autoValue_EventInternal.encodedPayload.encoding.name);
        contentValues.put("code", autoValue_EventInternal.code);
        contentValues.put("num_attempts", Integer.valueOf(0));
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? bArr : new byte[0]);
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            int ceil = (int) Math.ceil(((double) bArr.length) / ((double) i));
            for (int i2 = 1; i2 <= ceil; i2++) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (i2 - 1) * i, Math.min(i2 * i, bArr.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i2));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Entry next : eventInternal.getMetadata().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) next.getKey());
            contentValues3.put(HSLCriteriaBuilder.VALUE, (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    public /* synthetic */ Object lambda$recordFailure$3$SQLiteEventStore(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i = cursor.getInt(0);
            recordLogEventDropped((long) i, Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    public Object lambda$recordFailure$4$SQLiteEventStore(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        Cursor rawQuery = sQLiteDatabase.rawQuery(str2, null);
        try {
            lambda$recordFailure$3$SQLiteEventStore(rawQuery);
            rawQuery.close();
            sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
            return null;
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    public /* synthetic */ Object lambda$resetClientMetrics$23$SQLiteEventStore(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.wallClock.getTime()).execute();
        return null;
    }

    public Iterable<TransportContext> loadActiveContexts() {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            List lambda$loadActiveContexts$10 = lambda$loadActiveContexts$10(db);
            db.setTransactionSuccessful();
            return lambda$loadActiveContexts$10;
        } finally {
            db.endTransaction();
        }
    }

    public Iterable<PersistedEvent> loadBatch(TransportContext transportContext) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            List lambda$loadBatch$8$SQLiteEventStore = lambda$loadBatch$8$SQLiteEventStore(transportContext, db);
            db.setTransactionSuccessful();
            return lambda$loadBatch$8$SQLiteEventStore;
        } finally {
            db.endTransaction();
        }
    }

    public ClientMetrics loadClientMetrics() {
        ClientMetrics.Builder newBuilder = ClientMetrics.newBuilder();
        HashMap hashMap = new HashMap();
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            ClientMetrics lambda$loadClientMetrics$20$SQLiteEventStore = lambda$loadClientMetrics$20$SQLiteEventStore("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", hashMap, newBuilder, db);
            db.setTransactionSuccessful();
            return lambda$loadClientMetrics$20$SQLiteEventStore;
        } finally {
            db.endTransaction();
        }
    }

    public final List<PersistedEvent> loadEvents(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        ArrayList arrayList = new ArrayList();
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{transportContextId.toString()}, null, null, null, String.valueOf(((AutoValue_EventStoreConfig) this.config).loadBatchSize));
        try {
            lambda$loadEvents$14$SQLiteEventStore(arrayList, transportContext, query);
            query.close();
            return arrayList;
        } catch (Throwable th) {
            Throwable th2 = th;
            query.close();
            throw th2;
        }
    }

    public final Map<Long, Set<Metadata>> loadMetadata(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(((AutoValue_PersistedEvent) list.get(i)).id);
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor query = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", HSLCriteriaBuilder.VALUE}, sb.toString(), null, null, null, null);
        try {
            lambda$loadMetadata$16(hashMap, query);
            return hashMap;
        } finally {
            query.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public PersistedEvent persist(TransportContext transportContext, EventInternal eventInternal) {
        Object[] objArr = {((AutoValue_TransportContext) transportContext).priority, ((AutoValue_EventInternal) eventInternal).transportName, ((AutoValue_TransportContext) transportContext).backendName};
        ImageOriginUtils.getTag("SQLiteEventStore");
        String.format("Storing event with priority=%s, name=%s for destination %s", objArr);
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            Long lambda$persist$1$SQLiteEventStore = lambda$persist$1$SQLiteEventStore(eventInternal, transportContext, db);
            db.setTransactionSuccessful();
            db.endTransaction();
            long longValue = lambda$persist$1$SQLiteEventStore.longValue();
            if (longValue < 1) {
                return null;
            }
            return new AutoValue_PersistedEvent(longValue, transportContext, eventInternal);
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    public final void populateLogSourcesMetrics(ClientMetrics.Builder builder, Map<String, List<LogEventDropped>> map) {
        for (Entry next : map.entrySet()) {
            LogSourceMetrics.Builder newBuilder = LogSourceMetrics.newBuilder();
            newBuilder.log_source_ = (String) next.getKey();
            newBuilder.log_event_dropped_ = (List) next.getValue();
            builder.log_source_metrics_.add(new LogSourceMetrics(newBuilder.log_source_, Collections.unmodifiableList(newBuilder.log_event_dropped_)));
        }
    }

    public final byte[] readPayload(long j) {
        Cursor query = getDb().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num");
        try {
            return lambda$readPayload$15(query);
        } finally {
            query.close();
        }
    }

    public void recordFailure(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            outline73.append(toIdList(iterable));
            String sb = outline73.toString();
            SQLiteDatabase db = getDb();
            db.beginTransaction();
            try {
                lambda$recordFailure$4$SQLiteEventStore(sb, "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", db);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }
    }

    public void recordLogEventDropped(long j, Reason reason, String str) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            lambda$recordLogEventDropped$18(str, reason, j, db);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public void recordNextCallTime(TransportContext transportContext, long j) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            lambda$recordNextCallTime$7(j, transportContext, db);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public void recordSuccess(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("DELETE FROM events WHERE _id in ");
            outline73.append(toIdList(iterable));
            getDb().compileStatement(outline73.toString()).execute();
        }
    }

    public void resetClientMetrics() {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            lambda$resetClientMetrics$23$SQLiteEventStore(db);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public final <T> T retryIfDbLocked(Producer<T> producer, Function<Throwable, T> function) {
        long time = this.monotonicClock.getTime();
        while (true) {
            try {
                return producer.produce();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.monotonicClock.getTime() >= ((long) ((AutoValue_EventStoreConfig) this.config).criticalSectionEnterTimeoutMs) + time) {
                    return function.apply(e2);
                }
                SystemClock.sleep(50);
            }
        }
    }

    public <T> T runCriticalSection(CriticalSection<T> criticalSection) {
        SQLiteDatabase db = getDb();
        retryIfDbLocked(new Producer(db) {
            public final /* synthetic */ SQLiteDatabase f$0;

            {
                this.f$0 = r1;
            }

            public final Object produce() {
                this.f$0.beginTransaction();
                return null;
            }
        }, $$Lambda$SQLiteEventStore$wiIHvRquvjAoMOT5r2q0O3rXLo4.INSTANCE);
        try {
            T execute = criticalSection.execute();
            db.setTransactionSuccessful();
            return execute;
        } finally {
            db.endTransaction();
        }
    }
}
