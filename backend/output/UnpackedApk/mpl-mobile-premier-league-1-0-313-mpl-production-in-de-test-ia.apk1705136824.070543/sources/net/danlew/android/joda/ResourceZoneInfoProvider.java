package net.danlew.android.joda;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.Provider;

public class ResourceZoneInfoProvider implements Provider {
    public final Map<String, Object> iZoneInfoMap;
    public Context mAppContext;

    public ResourceZoneInfoProvider(Context context) throws IOException {
        if (context != null) {
            this.mAppContext = context.getApplicationContext();
            InputStream openResource = openResource("ZoneInfoMap");
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            DataInputStream dataInputStream = new DataInputStream(openResource);
            try {
                readZoneInfoMap(dataInputStream, concurrentHashMap);
                concurrentHashMap.put("UTC", new SoftReference(DateTimeZone.UTC));
                this.iZoneInfoMap = concurrentHashMap;
            } finally {
                try {
                    dataInputStream.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IllegalArgumentException("Context must not be null");
        }
    }

    public static void readZoneInfoMap(DataInputStream dataInputStream, Map<String, Object> map) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        String[] strArr = new String[readUnsignedShort];
        int i = 0;
        for (int i2 = 0; i2 < readUnsignedShort; i2++) {
            strArr[i2] = dataInputStream.readUTF().intern();
        }
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        while (i < readUnsignedShort2) {
            try {
                map.put(strArr[dataInputStream.readUnsignedShort()], strArr[dataInputStream.readUnsignedShort()]);
                i++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IOException("Corrupt zone info map");
            }
        }
    }

    public Set<String> getAvailableIDs() {
        return new TreeSet(this.iZoneInfoMap.keySet());
    }

    public DateTimeZone getZone(String str) {
        Object obj = this.iZoneInfoMap.get(str);
        if (obj == null) {
            return null;
        }
        if (str.equals(obj)) {
            return loadZoneData(str);
        }
        if (!(obj instanceof SoftReference)) {
            return getZone((String) obj);
        }
        DateTimeZone dateTimeZone = (DateTimeZone) ((SoftReference) obj).get();
        if (dateTimeZone != null) {
            return dateTimeZone;
        }
        return loadZoneData(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[SYNTHETIC, Splitter:B:19:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[SYNTHETIC, Splitter:B:24:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.joda.time.DateTimeZone loadZoneData(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.InputStream r1 = r5.openResource(r6)     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            org.joda.time.DateTimeZone r2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.readFrom(r1, r6)     // Catch:{ IOException -> 0x001c }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.iZoneInfoMap     // Catch:{ IOException -> 0x001c }
            java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch:{ IOException -> 0x001c }
            r4.<init>(r2)     // Catch:{ IOException -> 0x001c }
            r3.put(r6, r4)     // Catch:{ IOException -> 0x001c }
            if (r1 == 0) goto L_0x0018
            r1.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            return r2
        L_0x0019:
            r6 = move-exception
            r0 = r1
            goto L_0x0030
        L_0x001c:
            r2 = move-exception
            goto L_0x0022
        L_0x001e:
            r6 = move-exception
            goto L_0x0030
        L_0x0020:
            r2 = move-exception
            r1 = r0
        L_0x0022:
            r2.printStackTrace()     // Catch:{ all -> 0x0019 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = r5.iZoneInfoMap     // Catch:{ all -> 0x0019 }
            r2.remove(r6)     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r0
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.danlew.android.joda.ResourceZoneInfoProvider.loadZoneData(java.lang.String):org.joda.time.DateTimeZone");
    }

    public final InputStream openResource(String str) throws IOException {
        Map map;
        int i;
        if (this.mAppContext != null) {
            String tzResource = ResUtils.getTzResource(str);
            Class<R$raw> cls = R$raw.class;
            if (!ResUtils.sIdentifierCache.containsKey(cls)) {
                map = new ConcurrentHashMap();
                ResUtils.sIdentifierCache.put(cls, map);
            } else {
                map = ResUtils.sIdentifierCache.get(cls);
            }
            if (map.containsKey(tzResource)) {
                i = ((Integer) map.get(tzResource)).intValue();
            } else {
                try {
                    int i2 = cls.getField(tzResource).getInt(null);
                    if (i2 != 0) {
                        map.put(tzResource, Integer.valueOf(i2));
                    }
                    i = i2;
                } catch (Exception unused) {
                    "Failed to retrieve identifier: type=" + cls + " name=" + tzResource;
                    i = 0;
                }
            }
            if (i != 0) {
                return this.mAppContext.getResources().openRawResource(i);
            }
            throw new IOException(GeneratedOutlineSupport.outline54("Resource not found: \"", str, "\" (resName: \"", tzResource, "\")"));
        }
        throw new RuntimeException("Need to call JodaTimeAndroid.init() before using joda-time-android");
    }
}
