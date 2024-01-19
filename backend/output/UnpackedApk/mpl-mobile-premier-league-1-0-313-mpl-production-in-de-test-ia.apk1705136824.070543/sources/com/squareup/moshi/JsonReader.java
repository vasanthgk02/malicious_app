package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public abstract class JsonReader implements Closeable {
    public boolean failOnUnknown;
    public boolean lenient;
    public int[] pathIndices;
    public String[] pathNames;
    public int[] scopes;
    public int stackSize;
    public Map<Class<?>, Object> tags;

    /* renamed from: com.squareup.moshi.JsonReader$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonReader.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Options {
        public final okio.Options doubleQuoteSuffix;
        public final String[] strings;

        public Options(String[] strArr, okio.Options options) {
            this.strings = strArr;
            this.doubleQuoteSuffix = options;
        }

        public static Options of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonUtf8Writer.string(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), okio.Options.of(byteStringArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public List<String> strings() {
            return Collections.unmodifiableList(Arrays.asList(this.strings));
        }
    }

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public JsonReader() {
        this.scopes = new int[32];
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
    }

    public static JsonReader of(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final boolean failOnUnknown() {
        return this.failOnUnknown;
    }

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public abstract boolean hasNext() throws IOException;

    public final boolean isLenient() {
        return this.lenient;
    }

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract long nextLong() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract <T> T nextNull() throws IOException;

    public abstract BufferedSource nextSource() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public abstract JsonReader peekJson();

    public abstract void promoteNameToValue() throws IOException;

    public final void pushScope(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.scopes;
        if (i2 == iArr.length) {
            if (i2 != 256) {
                this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.pathNames;
                this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.pathIndices;
                this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Nesting too deep at ");
                outline73.append(getPath());
                throw new JsonDataException(outline73.toString());
            }
        }
        int[] iArr3 = this.scopes;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        iArr3[i3] = i;
    }

    public final Object readJsonValue() throws IOException {
        int ordinal = peek().ordinal();
        if (ordinal == 0) {
            ArrayList arrayList = new ArrayList();
            beginArray();
            while (hasNext()) {
                arrayList.add(readJsonValue());
            }
            endArray();
            return arrayList;
        } else if (ordinal == 2) {
            LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
            beginObject();
            while (hasNext()) {
                String nextName = nextName();
                Object readJsonValue = readJsonValue();
                Object put = linkedHashTreeMap.put(nextName, readJsonValue);
                if (put != null) {
                    StringBuilder outline80 = GeneratedOutlineSupport.outline80("Map key '", nextName, "' has multiple values at path ");
                    outline80.append(getPath());
                    outline80.append(": ");
                    outline80.append(put);
                    outline80.append(" and ");
                    outline80.append(readJsonValue);
                    throw new JsonDataException(outline80.toString());
                }
            }
            endObject();
            return linkedHashTreeMap;
        } else if (ordinal == 5) {
            return nextString();
        } else {
            if (ordinal == 6) {
                return Double.valueOf(nextDouble());
            }
            if (ordinal == 7) {
                return Boolean.valueOf(nextBoolean());
            }
            if (ordinal == 8) {
                return nextNull();
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a value but was ");
            outline73.append(peek());
            outline73.append(" at path ");
            outline73.append(getPath());
            throw new IllegalStateException(outline73.toString());
        }
    }

    public abstract int selectName(Options options) throws IOException;

    public abstract int selectString(Options options) throws IOException;

    public final void setFailOnUnknown(boolean z) {
        this.failOnUnknown = z;
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final <T> void setTag(Class<T> cls, T t) {
        if (cls.isAssignableFrom(t.getClass())) {
            if (this.tags == null) {
                this.tags = new LinkedHashMap();
            }
            this.tags.put(cls, t);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Tag value must be of type ")));
    }

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    public final JsonEncodingException syntaxError(String str) throws JsonEncodingException {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, " at path ");
        outline78.append(getPath());
        throw new JsonEncodingException(outline78.toString());
    }

    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return map.get(cls);
    }

    public final JsonDataException typeMismatch(Object obj, Object obj2) {
        if (obj == null) {
            return new JsonDataException("Expected " + obj2 + " but was null at path " + getPath());
        }
        return new JsonDataException("Expected " + obj2 + " but was " + obj + ", a " + obj.getClass().getName() + ", at path " + getPath());
    }

    public JsonReader(JsonReader jsonReader) {
        this.stackSize = jsonReader.stackSize;
        this.scopes = (int[]) jsonReader.scopes.clone();
        this.pathNames = (String[]) jsonReader.pathNames.clone();
        this.pathIndices = (int[]) jsonReader.pathIndices.clone();
        this.lenient = jsonReader.lenient;
        this.failOnUnknown = jsonReader.failOnUnknown;
    }
}
