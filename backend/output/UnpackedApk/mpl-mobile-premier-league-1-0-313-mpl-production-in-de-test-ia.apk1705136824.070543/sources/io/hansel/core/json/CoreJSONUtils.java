package io.hansel.core.json;

import android.util.JsonReader;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.logger.HSLLogger;
import java.io.IOException;

public class CoreJSONUtils {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5173a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.util.JsonToken[] r0 = android.util.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5173a = r0
                android.util.JsonToken r1 = android.util.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5173a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.util.JsonToken r1 = android.util.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5173a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.util.JsonToken r1 = android.util.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5173a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.util.JsonToken r1 = android.util.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5173a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.util.JsonToken r1 = android.util.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5173a     // Catch:{ NoSuchFieldError -> 0x0049 }
                android.util.JsonToken r1 = android.util.JsonToken.NAME     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f5173a     // Catch:{ NoSuchFieldError -> 0x0054 }
                android.util.JsonToken r1 = android.util.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.json.CoreJSONUtils.a.<clinit>():void");
        }
    }

    public static boolean containsObject(CoreJSONArray coreJSONArray, String str, String str2) {
        if (coreJSONArray != null && coreJSONArray.length() != 0 && !HSLInternalUtils.isEmpty(str) && !HSLInternalUtils.isEmpty(str2)) {
            int length = coreJSONArray.length();
            for (int i = 0; i < length; i++) {
                CoreJSONObject optJSONObject = coreJSONArray.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.optString(str).equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static CoreJSONArray mergeJSONObjectArray(CoreJSONArray coreJSONArray, CoreJSONArray coreJSONArray2, String str) {
        if (coreJSONArray == null || coreJSONArray.length() == 0) {
            return coreJSONArray2;
        }
        if (!(coreJSONArray2 == null || coreJSONArray2.length() == 0)) {
            int length = coreJSONArray2.length();
            for (int i = 0; i < length; i++) {
                CoreJSONObject optJSONObject = coreJSONArray2.optJSONObject(i);
                if (optJSONObject != null && !containsObject(coreJSONArray, str, optJSONObject.optString(str))) {
                    coreJSONArray.put((Object) optJSONObject);
                }
            }
        }
        return coreJSONArray;
    }

    public static CoreJSONArray nullSafeArrayFromReader(JsonReader jsonReader, CoreJSONArray coreJSONArray) {
        try {
            int i = a.f5173a[jsonReader.peek().ordinal()];
            if (i != 2) {
                return i != 3 ? coreJSONArray : readAllInArray(jsonReader);
            }
            jsonReader.skipValue();
            return coreJSONArray;
        } catch (IOException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public static CoreJSONObject nullSafeObjectFromReader(JsonReader jsonReader, CoreJSONObject coreJSONObject) {
        try {
            int i = a.f5173a[jsonReader.peek().ordinal()];
            if (i != 2) {
                return i != 3 ? coreJSONObject : readAllInObject(jsonReader);
            }
            jsonReader.skipValue();
            return coreJSONObject;
        } catch (IOException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public static String nullSafeStringFromReader(JsonReader jsonReader, String str) {
        try {
            int i = a.f5173a[jsonReader.peek().ordinal()];
            if (i == 1) {
                return jsonReader.nextString();
            }
            if (i != 2) {
                return str;
            }
            jsonReader.skipValue();
            return str;
        } catch (IOException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public static CoreJSONArray readAllInArray(JsonReader jsonReader) {
        if (jsonReader == null) {
            return null;
        }
        jsonReader.beginArray();
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        while (jsonReader.hasNext()) {
            coreJSONArray.put((Object) jsonReader.nextString());
        }
        jsonReader.endArray();
        return coreJSONArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r1.put(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        r5.skipValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.hansel.core.json.CoreJSONObject readAllInObject(android.util.JsonReader r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0054
            r5.beginObject()     // Catch:{ Exception -> 0x0054 }
            io.hansel.core.json.CoreJSONObject r1 = new io.hansel.core.json.CoreJSONObject     // Catch:{ Exception -> 0x0054 }
            r1.<init>()     // Catch:{ Exception -> 0x0054 }
            r2 = r0
        L_0x000c:
            boolean r3 = r5.hasNext()     // Catch:{ Exception -> 0x0053 }
            if (r3 == 0) goto L_0x0050
            android.util.JsonToken r3 = r5.peek()     // Catch:{ Exception -> 0x0053 }
            int[] r4 = io.hansel.core.json.CoreJSONUtils.a.f5173a     // Catch:{ Exception -> 0x0053 }
            int r3 = r3.ordinal()     // Catch:{ Exception -> 0x0053 }
            r3 = r4[r3]     // Catch:{ Exception -> 0x0053 }
            switch(r3) {
                case 1: goto L_0x004b;
                case 2: goto L_0x0044;
                case 3: goto L_0x003f;
                case 4: goto L_0x0037;
                case 5: goto L_0x002f;
                case 6: goto L_0x002a;
                case 7: goto L_0x0022;
                default: goto L_0x0021;
            }     // Catch:{ Exception -> 0x0053 }
        L_0x0021:
            goto L_0x0047
        L_0x0022:
            double r3 = r5.nextDouble()     // Catch:{ Exception -> 0x0053 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0053 }
            goto L_0x000c
        L_0x002a:
            java.lang.String r2 = r5.nextName()     // Catch:{ Exception -> 0x0053 }
            goto L_0x000c
        L_0x002f:
            boolean r3 = r5.nextBoolean()     // Catch:{ Exception -> 0x0053 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0053 }
            goto L_0x000c
        L_0x0037:
            io.hansel.core.json.CoreJSONArray r3 = readAllInArray(r5)     // Catch:{ Exception -> 0x0053 }
        L_0x003b:
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0053 }
            goto L_0x000c
        L_0x003f:
            io.hansel.core.json.CoreJSONObject r3 = readAllInObject(r5)     // Catch:{ Exception -> 0x0053 }
            goto L_0x003b
        L_0x0044:
            r1.put(r2, r0)     // Catch:{ Exception -> 0x0053 }
        L_0x0047:
            r5.skipValue()     // Catch:{ Exception -> 0x0053 }
            goto L_0x000c
        L_0x004b:
            java.lang.String r3 = r5.nextString()     // Catch:{ Exception -> 0x0053 }
            goto L_0x003b
        L_0x0050:
            r5.endObject()     // Catch:{ Exception -> 0x0053 }
        L_0x0053:
            r0 = r1
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.json.CoreJSONUtils.readAllInObject(android.util.JsonReader):io.hansel.core.json.CoreJSONObject");
    }
}
