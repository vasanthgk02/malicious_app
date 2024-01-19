package com.facebook.react.bridge;

import android.util.JsonWriter;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JsonWriterHelper {

    /* renamed from: com.facebook.react.bridge.JsonWriterHelper$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002b */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                r1 = 1
                com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x002b }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.JsonWriterHelper.AnonymousClass1.<clinit>():void");
        }
    }

    public static void dynamicValue(JsonWriter jsonWriter, Dynamic dynamic) throws IOException {
        int ordinal = dynamic.getType().ordinal();
        if (ordinal == 0) {
            jsonWriter.nullValue();
        } else if (ordinal == 1) {
            jsonWriter.value(dynamic.asBoolean());
        } else if (ordinal == 2) {
            jsonWriter.value(dynamic.asDouble());
        } else if (ordinal == 3) {
            jsonWriter.value(dynamic.asString());
        } else if (ordinal == 4) {
            readableMapValue(jsonWriter, dynamic.asMap());
        } else if (ordinal == 5) {
            readableArrayValue(jsonWriter, dynamic.asArray());
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown data type: ");
            outline73.append(dynamic.getType());
            throw new IllegalArgumentException(outline73.toString());
        }
    }

    public static void listValue(JsonWriter jsonWriter, List<?> list) throws IOException {
        jsonWriter.beginArray();
        for (Object objectValue : list) {
            objectValue(jsonWriter, objectValue);
        }
        jsonWriter.endArray();
    }

    public static void mapValue(JsonWriter jsonWriter, Map<?, ?> map) throws IOException {
        jsonWriter.beginObject();
        for (Entry next : map.entrySet()) {
            jsonWriter.name(next.getKey().toString());
            value(jsonWriter, next.getValue());
        }
        jsonWriter.endObject();
    }

    public static void objectValue(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
        } else if (obj instanceof String) {
            jsonWriter.value((String) obj);
        } else if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
        } else if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("Unknown value: ", obj));
        }
    }

    public static void readableArrayValue(JsonWriter jsonWriter, ReadableArray readableArray) throws IOException {
        jsonWriter.beginArray();
        int i = 0;
        while (i < readableArray.size()) {
            try {
                int ordinal = readableArray.getType(i).ordinal();
                if (ordinal == 0) {
                    jsonWriter.nullValue();
                } else if (ordinal == 1) {
                    jsonWriter.value(readableArray.getBoolean(i));
                } else if (ordinal == 2) {
                    jsonWriter.value(readableArray.getDouble(i));
                } else if (ordinal == 3) {
                    jsonWriter.value(readableArray.getString(i));
                } else if (ordinal == 4) {
                    readableMapValue(jsonWriter, readableArray.getMap(i));
                } else if (ordinal == 5) {
                    readableArrayValue(jsonWriter, readableArray.getArray(i));
                } else {
                    throw new IllegalArgumentException("Unknown data type: " + readableArray.getType(i));
                }
                i++;
            } finally {
                jsonWriter.endArray();
            }
        }
    }

    public static void readableMapValue(JsonWriter jsonWriter, ReadableMap readableMap) throws IOException {
        jsonWriter.beginObject();
        try {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                jsonWriter.name(nextKey);
                int ordinal = readableMap.getType(nextKey).ordinal();
                if (ordinal == 0) {
                    jsonWriter.nullValue();
                } else if (ordinal == 1) {
                    jsonWriter.value(readableMap.getBoolean(nextKey));
                } else if (ordinal == 2) {
                    jsonWriter.value(readableMap.getDouble(nextKey));
                } else if (ordinal == 3) {
                    jsonWriter.value(readableMap.getString(nextKey));
                } else if (ordinal == 4) {
                    readableMapValue(jsonWriter, readableMap.getMap(nextKey));
                } else if (ordinal == 5) {
                    readableArrayValue(jsonWriter, readableMap.getArray(nextKey));
                } else {
                    throw new IllegalArgumentException("Unknown data type: " + readableMap.getType(nextKey));
                }
            }
        } finally {
            jsonWriter.endObject();
        }
    }

    public static void value(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj instanceof Map) {
            mapValue(jsonWriter, (Map) obj);
        } else if (obj instanceof List) {
            listValue(jsonWriter, (List) obj);
        } else if (obj instanceof ReadableMap) {
            readableMapValue(jsonWriter, (ReadableMap) obj);
        } else if (obj instanceof ReadableArray) {
            readableArrayValue(jsonWriter, (ReadableArray) obj);
        } else if (obj instanceof Dynamic) {
            dynamicValue(jsonWriter, (Dynamic) obj);
        } else {
            objectValue(jsonWriter, obj);
        }
    }
}
