package com.facebook.appevents;

import com.facebook.appevents.AccessTokenAppIdPair.SerializationProxyV1;
import com.facebook.appevents.AppEvent.SerializationProxyV2;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "kotlin.jvm.PlatformType", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "", "eventsToPersist", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventDiskStore.kt */
public final class AppEventDiskStore {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventDiskStore.kt */
    public static final class MovedClassObjectInputStream extends ObjectInputStream {
        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual(readClassDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                readClassDescriptor = ObjectStreamClass.lookup(SerializationProxyV1.class);
            } else if (Intrinsics.areEqual(readClassDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2")) {
                readClassDescriptor = ObjectStreamClass.lookup(SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(readClassDescriptor, "resultClassDescriptor");
            return readClassDescriptor;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:21|24|25|26|27|28|29|30) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006c A[SYNTHETIC, Splitter:B:48:0x006c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:42:0x0060=Splitter:B:42:0x0060, B:24:0x0042=Splitter:B:24:0x0042, B:29:0x004e=Splitter:B:29:0x004e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventDiskStore> r0 = com.facebook.appevents.AppEventDiskStore.class
            monitor-enter(r0)
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0073 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0073 }
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x004f, all -> 0x003f }
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x004f, all -> 0x003f }
            com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x004f, all -> 0x003f }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x004f, all -> 0x003f }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x004f, all -> 0x003f }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x004f, all -> 0x003f }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x0050, all -> 0x003d }
            if (r3 == 0) goto L_0x0035
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x0050, all -> 0x003d }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch:{ Exception -> 0x0033 }
            r1.delete()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            r2 = r3
            goto L_0x006a
        L_0x0035:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x0050, all -> 0x003d }
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x0050, all -> 0x003d }
            throw r3     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x0050, all -> 0x003d }
        L_0x003d:
            r2 = move-exception
            goto L_0x0042
        L_0x003f:
            r3 = move-exception
            r4 = r2
            r2 = r3
        L_0x0042:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x004e }
            r1.delete()     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            throw r2     // Catch:{ all -> 0x0073 }
        L_0x004f:
            r4 = r2
        L_0x0050:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x005d }
        L_0x0059:
            r1.delete()     // Catch:{ Exception -> 0x005d }
            goto L_0x006a
        L_0x005d:
            goto L_0x006a
        L_0x005f:
            r4 = r2
        L_0x0060:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x005d }
            goto L_0x0059
        L_0x006a:
            if (r2 != 0) goto L_0x0071
            com.facebook.appevents.PersistedEvents r2 = new com.facebook.appevents.PersistedEvents     // Catch:{ all -> 0x0073 }
            r2.<init>()     // Catch:{ all -> 0x0073 }
        L_0x0071:
            monitor-exit(r0)
            return r2
        L_0x0073:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventDiskStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|7|8|12|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        com.facebook.internal.Utility.closeQuietly(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents r5) {
        /*
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x001b }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x001b }
            r4 = 0
            java.io.FileOutputStream r4 = r1.openFileOutput(r0, r4)     // Catch:{ all -> 0x001b }
            r3.<init>(r4)     // Catch:{ all -> 0x001b }
            r2.<init>(r3)     // Catch:{ all -> 0x001b }
            r2.writeObject(r5)     // Catch:{ all -> 0x001c }
            goto L_0x0029
        L_0x001b:
            r2 = 0
        L_0x001c:
            java.io.File r5 = r1.getFileStreamPath(r0)     // Catch:{ Exception -> 0x0029, all -> 0x0024 }
            r5.delete()     // Catch:{ Exception -> 0x0029, all -> 0x0024 }
            goto L_0x0029
        L_0x0024:
            r5 = move-exception
            com.facebook.internal.Utility.closeQuietly(r2)
            throw r5
        L_0x0029:
            com.facebook.internal.Utility.closeQuietly(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventDiskStore.saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents):void");
    }
}
