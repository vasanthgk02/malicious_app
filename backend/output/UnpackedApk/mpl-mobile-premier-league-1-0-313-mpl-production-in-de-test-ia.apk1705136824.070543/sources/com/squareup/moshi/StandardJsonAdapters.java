package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringEscapeUtils;
import sfs2x.client.entities.invitation.InvitationReply;

public final class StandardJsonAdapters {
    public static final JsonAdapter<Boolean> BOOLEAN_JSON_ADAPTER = new JsonAdapter<Boolean>() {
        public String toString() {
            return "JsonAdapter(Boolean)";
        }

        public Boolean fromJson(JsonReader jsonReader) throws IOException {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }

        public void toJson(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool.booleanValue());
        }
    };
    public static final JsonAdapter<Byte> BYTE_JSON_ADAPTER = new JsonAdapter<Byte>() {
        public String toString() {
            return "JsonAdapter(Byte)";
        }

        public Byte fromJson(JsonReader jsonReader) throws IOException {
            return Byte.valueOf((byte) StandardJsonAdapters.rangeCheckNextInt(jsonReader, "a byte", -128, InvitationReply.EXPIRED));
        }

        public void toJson(JsonWriter jsonWriter, Byte b2) throws IOException {
            jsonWriter.value((long) (b2.intValue() & InvitationReply.EXPIRED));
        }
    };
    public static final JsonAdapter<Character> CHARACTER_JSON_ADAPTER = new JsonAdapter<Character>() {
        public String toString() {
            return "JsonAdapter(Character)";
        }

        public Character fromJson(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            if (nextString.length() <= 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new JsonDataException(String.format(StandardJsonAdapters.ERROR_FORMAT, new Object[]{"a char", StringEscapeUtils.CSV_QUOTE + nextString + StringEscapeUtils.CSV_QUOTE, jsonReader.getPath()}));
        }

        public void toJson(JsonWriter jsonWriter, Character ch) throws IOException {
            jsonWriter.value(ch.toString());
        }
    };
    public static final JsonAdapter<Double> DOUBLE_JSON_ADAPTER = new JsonAdapter<Double>() {
        public String toString() {
            return "JsonAdapter(Double)";
        }

        public Double fromJson(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }

        public void toJson(JsonWriter jsonWriter, Double d2) throws IOException {
            jsonWriter.value(d2.doubleValue());
        }
    };
    public static final String ERROR_FORMAT = "Expected %s but was %s at path %s";
    public static final Factory FACTORY = new Factory() {
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return StandardJsonAdapters.BOOLEAN_JSON_ADAPTER;
            }
            if (type == Byte.TYPE) {
                return StandardJsonAdapters.BYTE_JSON_ADAPTER;
            }
            if (type == Character.TYPE) {
                return StandardJsonAdapters.CHARACTER_JSON_ADAPTER;
            }
            if (type == Double.TYPE) {
                return StandardJsonAdapters.DOUBLE_JSON_ADAPTER;
            }
            if (type == Float.TYPE) {
                return StandardJsonAdapters.FLOAT_JSON_ADAPTER;
            }
            if (type == Integer.TYPE) {
                return StandardJsonAdapters.INTEGER_JSON_ADAPTER;
            }
            if (type == Long.TYPE) {
                return StandardJsonAdapters.LONG_JSON_ADAPTER;
            }
            if (type == Short.TYPE) {
                return StandardJsonAdapters.SHORT_JSON_ADAPTER;
            }
            if (type == Boolean.class) {
                return StandardJsonAdapters.BOOLEAN_JSON_ADAPTER.nullSafe();
            }
            if (type == Byte.class) {
                return StandardJsonAdapters.BYTE_JSON_ADAPTER.nullSafe();
            }
            if (type == Character.class) {
                return StandardJsonAdapters.CHARACTER_JSON_ADAPTER.nullSafe();
            }
            if (type == Double.class) {
                return StandardJsonAdapters.DOUBLE_JSON_ADAPTER.nullSafe();
            }
            if (type == Float.class) {
                return StandardJsonAdapters.FLOAT_JSON_ADAPTER.nullSafe();
            }
            if (type == Integer.class) {
                return StandardJsonAdapters.INTEGER_JSON_ADAPTER.nullSafe();
            }
            if (type == Long.class) {
                return StandardJsonAdapters.LONG_JSON_ADAPTER.nullSafe();
            }
            if (type == Short.class) {
                return StandardJsonAdapters.SHORT_JSON_ADAPTER.nullSafe();
            }
            if (type == String.class) {
                return StandardJsonAdapters.STRING_JSON_ADAPTER.nullSafe();
            }
            if (type == Object.class) {
                return new ObjectJsonAdapter(moshi).nullSafe();
            }
            Class<?> rawType = Types.getRawType(type);
            JsonAdapter<?> generatedAdapter = Util.generatedAdapter(moshi, type, rawType);
            if (generatedAdapter != null) {
                return generatedAdapter;
            }
            if (rawType.isEnum()) {
                return new EnumJsonAdapter(rawType).nullSafe();
            }
            return null;
        }
    };
    public static final JsonAdapter<Float> FLOAT_JSON_ADAPTER = new JsonAdapter<Float>() {
        public String toString() {
            return "JsonAdapter(Float)";
        }

        public Float fromJson(JsonReader jsonReader) throws IOException {
            float nextDouble = (float) jsonReader.nextDouble();
            if (jsonReader.isLenient() || !Float.isInfinite(nextDouble)) {
                return Float.valueOf(nextDouble);
            }
            throw new JsonDataException("JSON forbids NaN and infinities: " + nextDouble + " at path " + jsonReader.getPath());
        }

        public void toJson(JsonWriter jsonWriter, Float f2) throws IOException {
            if (f2 != null) {
                jsonWriter.value((Number) f2);
                return;
            }
            throw null;
        }
    };
    public static final JsonAdapter<Integer> INTEGER_JSON_ADAPTER = new JsonAdapter<Integer>() {
        public String toString() {
            return "JsonAdapter(Integer)";
        }

        public Integer fromJson(JsonReader jsonReader) throws IOException {
            return Integer.valueOf(jsonReader.nextInt());
        }

        public void toJson(JsonWriter jsonWriter, Integer num) throws IOException {
            jsonWriter.value((long) num.intValue());
        }
    };
    public static final JsonAdapter<Long> LONG_JSON_ADAPTER = new JsonAdapter<Long>() {
        public String toString() {
            return "JsonAdapter(Long)";
        }

        public Long fromJson(JsonReader jsonReader) throws IOException {
            return Long.valueOf(jsonReader.nextLong());
        }

        public void toJson(JsonWriter jsonWriter, Long l) throws IOException {
            jsonWriter.value(l.longValue());
        }
    };
    public static final JsonAdapter<Short> SHORT_JSON_ADAPTER = new JsonAdapter<Short>() {
        public String toString() {
            return "JsonAdapter(Short)";
        }

        public Short fromJson(JsonReader jsonReader) throws IOException {
            return Short.valueOf((short) StandardJsonAdapters.rangeCheckNextInt(jsonReader, "a short", -32768, 32767));
        }

        public void toJson(JsonWriter jsonWriter, Short sh) throws IOException {
            jsonWriter.value((long) sh.intValue());
        }
    };
    public static final JsonAdapter<String> STRING_JSON_ADAPTER = new JsonAdapter<String>() {
        public String toString() {
            return "JsonAdapter(String)";
        }

        public String fromJson(JsonReader jsonReader) throws IOException {
            return jsonReader.nextString();
        }

        public void toJson(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    };

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$11  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass11 {
        public static final /* synthetic */ int[] $SwitchMap$com$squareup$moshi$JsonReader$Token;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|7|8|9|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.squareup.moshi.JsonReader$Token[] r0 = com.squareup.moshi.JsonReader.Token.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$squareup$moshi$JsonReader$Token = r0
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 0
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$squareup$moshi$JsonReader$Token     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 5
                int[] r1 = $SwitchMap$com$squareup$moshi$JsonReader$Token     // Catch:{ NoSuchFieldError -> 0x001e }
                com.squareup.moshi.JsonReader$Token r2 = com.squareup.moshi.JsonReader.Token.STRING     // Catch:{ NoSuchFieldError -> 0x001e }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                r1 = 6
                int[] r2 = $SwitchMap$com$squareup$moshi$JsonReader$Token     // Catch:{ NoSuchFieldError -> 0x0026 }
                com.squareup.moshi.JsonReader$Token r3 = com.squareup.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0026 }
                r3 = 4
                r2[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                int[] r2 = $SwitchMap$com$squareup$moshi$JsonReader$Token     // Catch:{ NoSuchFieldError -> 0x002d }
                com.squareup.moshi.JsonReader$Token r3 = com.squareup.moshi.JsonReader.Token.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x002d }
                r3 = 7
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x002d }
            L_0x002d:
                int[] r0 = $SwitchMap$com$squareup$moshi$JsonReader$Token     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.squareup.moshi.JsonReader$Token r2 = com.squareup.moshi.JsonReader.Token.NULL     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 8
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.StandardJsonAdapters.AnonymousClass11.<clinit>():void");
        }
    }

    public static final class EnumJsonAdapter<T extends Enum<T>> extends JsonAdapter<T> {
        public final T[] constants;
        public final Class<T> enumType;
        public final String[] nameStrings;
        public final Options options;

        public EnumJsonAdapter(Class<T> cls) {
            this.enumType = cls;
            try {
                T[] tArr = (Enum[]) cls.getEnumConstants();
                this.constants = tArr;
                this.nameStrings = new String[tArr.length];
                for (int i = 0; i < this.constants.length; i++) {
                    T t = this.constants[i];
                    Json json = (Json) cls.getField(t.name()).getAnnotation(Json.class);
                    this.nameStrings[i] = json != null ? json.name() : t.name();
                }
                this.options = Options.of(this.nameStrings);
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Missing field in ")), e2);
            }
        }

        public String toString() {
            return GeneratedOutlineSupport.outline36(this.enumType, GeneratedOutlineSupport.outline73("JsonAdapter("), ")");
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            int selectString = jsonReader.selectString(this.options);
            if (selectString != -1) {
                return this.constants[selectString];
            }
            String path = jsonReader.getPath();
            String nextString = jsonReader.nextString();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected one of ");
            outline73.append(Arrays.asList(this.nameStrings));
            outline73.append(" but was ");
            outline73.append(nextString);
            outline73.append(" at path ");
            outline73.append(path);
            throw new JsonDataException(outline73.toString());
        }

        public void toJson(JsonWriter jsonWriter, T t) throws IOException {
            jsonWriter.value(this.nameStrings[t.ordinal()]);
        }
    }

    public static final class ObjectJsonAdapter extends JsonAdapter<Object> {
        public final JsonAdapter<Boolean> booleanAdapter;
        public final JsonAdapter<Double> doubleAdapter;
        public final JsonAdapter<List> listJsonAdapter;
        public final JsonAdapter<Map> mapAdapter;
        public final Moshi moshi;
        public final JsonAdapter<String> stringAdapter;

        public ObjectJsonAdapter(Moshi moshi2) {
            this.moshi = moshi2;
            this.listJsonAdapter = moshi2.adapter(List.class);
            this.mapAdapter = moshi2.adapter(Map.class);
            this.stringAdapter = moshi2.adapter(String.class);
            this.doubleAdapter = moshi2.adapter(Double.class);
            this.booleanAdapter = moshi2.adapter(Boolean.class);
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r2v0, types: [java.lang.Class<?>, java.lang.Class] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.Class<?> toJsonType(java.lang.Class r2) {
            /*
                r1 = this;
                java.lang.Class<java.util.Map> r0 = java.util.Map.class
                boolean r0 = r0.isAssignableFrom(r2)
                if (r0 == 0) goto L_0x000b
                java.lang.Class<java.util.Map> r2 = java.util.Map.class
                return r2
            L_0x000b:
                java.lang.Class<java.util.Collection> r0 = java.util.Collection.class
                boolean r0 = r0.isAssignableFrom(r2)
                if (r0 == 0) goto L_0x0015
                java.lang.Class<java.util.Collection> r2 = java.util.Collection.class
            L_0x0015:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.StandardJsonAdapters.ObjectJsonAdapter.toJsonType(java.lang.Class):java.lang.Class");
        }

        public Object fromJson(JsonReader jsonReader) throws IOException {
            int ordinal = jsonReader.peek().ordinal();
            if (ordinal == 0) {
                return this.listJsonAdapter.fromJson(jsonReader);
            }
            if (ordinal == 2) {
                return this.mapAdapter.fromJson(jsonReader);
            }
            if (ordinal == 5) {
                return this.stringAdapter.fromJson(jsonReader);
            }
            if (ordinal == 6) {
                return this.doubleAdapter.fromJson(jsonReader);
            }
            if (ordinal == 7) {
                return this.booleanAdapter.fromJson(jsonReader);
            }
            if (ordinal == 8) {
                return jsonReader.nextNull();
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a value but was ");
            outline73.append(jsonReader.peek());
            outline73.append(" at path ");
            outline73.append(jsonReader.getPath());
            throw new IllegalStateException(outline73.toString());
        }

        public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            Class<?> cls = obj.getClass();
            if (cls == Object.class) {
                jsonWriter.beginObject();
                jsonWriter.endObject();
                return;
            }
            this.moshi.adapter((Type) toJsonType(cls), Util.NO_ANNOTATIONS).toJson(jsonWriter, obj);
        }

        public String toString() {
            return "JsonAdapter(Object)";
        }
    }

    public static int rangeCheckNextInt(JsonReader jsonReader, String str, int i, int i2) throws IOException {
        int nextInt = jsonReader.nextInt();
        if (nextInt >= i && nextInt <= i2) {
            return nextInt;
        }
        throw new JsonDataException(String.format(ERROR_FORMAT, new Object[]{str, Integer.valueOf(nextInt), jsonReader.getPath()}));
    }
}
