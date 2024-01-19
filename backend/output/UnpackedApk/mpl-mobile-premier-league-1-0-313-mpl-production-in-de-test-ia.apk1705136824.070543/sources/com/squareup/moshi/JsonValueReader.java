package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonReader.Token;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import okio.Buffer;
import okio.BufferedSource;

public final class JsonValueReader extends JsonReader {
    public static final Object JSON_READER_CLOSED = new Object();
    public Object[] stack;

    public static final class JsonIterator implements Iterator<Object>, Cloneable {
        public final Object[] array;
        public final Token endToken;
        public int next;

        public JsonIterator(Token token, Object[] objArr, int i) {
            this.endToken = token;
            this.array = objArr;
            this.next = i;
        }

        public boolean hasNext() {
            return this.next < this.array.length;
        }

        public Object next() {
            Object[] objArr = this.array;
            int i = this.next;
            this.next = i + 1;
            return objArr[i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public JsonIterator clone() {
            return new JsonIterator(this.endToken, this.array, this.next);
        }
    }

    public JsonValueReader(Object obj) {
        int[] iArr = this.scopes;
        int i = this.stackSize;
        iArr[i] = 7;
        Object[] objArr = new Object[32];
        this.stack = objArr;
        this.stackSize = i + 1;
        objArr[i] = obj;
    }

    private void push(Object obj) {
        int i = this.stackSize;
        if (i == this.stack.length) {
            if (i != 256) {
                int[] iArr = this.scopes;
                this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.pathNames;
                this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.pathIndices;
                this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
                Object[] objArr = this.stack;
                this.stack = Arrays.copyOf(objArr, objArr.length * 2);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Nesting too deep at ");
                outline73.append(getPath());
                throw new JsonDataException(outline73.toString());
            }
        }
        Object[] objArr2 = this.stack;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        objArr2[i2] = obj;
    }

    private void remove() {
        int i = this.stackSize - 1;
        this.stackSize = i;
        Object[] objArr = this.stack;
        objArr[i] = null;
        this.scopes[i] = 0;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
            Object obj = objArr[i - 1];
            if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                if (it.hasNext()) {
                    push(it.next());
                }
            }
        }
    }

    private <T> T require(Class<T> cls, Token token) throws IOException {
        int i = this.stackSize;
        Object obj = i != 0 ? this.stack[i - 1] : null;
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        if (obj == null && token == Token.NULL) {
            return null;
        }
        if (obj == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw typeMismatch(obj, token);
    }

    private String stringKey(Entry<?, ?> entry) {
        Object key = entry.getKey();
        if (key instanceof String) {
            return (String) key;
        }
        throw typeMismatch(key, Token.NAME);
    }

    public void beginArray() throws IOException {
        List list = (List) require(List.class, Token.BEGIN_ARRAY);
        JsonIterator jsonIterator = new JsonIterator(Token.END_ARRAY, list.toArray(new Object[list.size()]), 0);
        Object[] objArr = this.stack;
        int i = this.stackSize;
        objArr[i - 1] = jsonIterator;
        this.scopes[i - 1] = 1;
        this.pathIndices[i - 1] = 0;
        if (jsonIterator.hasNext()) {
            push(jsonIterator.next());
        }
    }

    public void beginObject() throws IOException {
        Map map = (Map) require(Map.class, Token.BEGIN_OBJECT);
        JsonIterator jsonIterator = new JsonIterator(Token.END_OBJECT, map.entrySet().toArray(new Object[map.size()]), 0);
        Object[] objArr = this.stack;
        int i = this.stackSize;
        objArr[i - 1] = jsonIterator;
        this.scopes[i - 1] = 3;
        if (jsonIterator.hasNext()) {
            push(jsonIterator.next());
        }
    }

    public void close() throws IOException {
        Arrays.fill(this.stack, 0, this.stackSize, null);
        this.stack[0] = JSON_READER_CLOSED;
        this.scopes[0] = 8;
        this.stackSize = 1;
    }

    public void endArray() throws IOException {
        JsonIterator jsonIterator = (JsonIterator) require(JsonIterator.class, Token.END_ARRAY);
        if (jsonIterator.endToken != Token.END_ARRAY || jsonIterator.hasNext()) {
            throw typeMismatch(jsonIterator, Token.END_ARRAY);
        }
        remove();
    }

    public void endObject() throws IOException {
        JsonIterator jsonIterator = (JsonIterator) require(JsonIterator.class, Token.END_OBJECT);
        if (jsonIterator.endToken != Token.END_OBJECT || jsonIterator.hasNext()) {
            throw typeMismatch(jsonIterator, Token.END_OBJECT);
        }
        this.pathNames[this.stackSize - 1] = null;
        remove();
    }

    public boolean hasNext() throws IOException {
        int i = this.stackSize;
        boolean z = false;
        if (i == 0) {
            return false;
        }
        Object obj = this.stack[i - 1];
        if (!(obj instanceof Iterator) || ((Iterator) obj).hasNext()) {
            z = true;
        }
        return z;
    }

    public boolean nextBoolean() throws IOException {
        remove();
        return ((Boolean) require(Boolean.class, Token.BOOLEAN)).booleanValue();
    }

    public double nextDouble() throws IOException {
        double d2;
        Object require = require(Object.class, Token.NUMBER);
        if (require instanceof Number) {
            d2 = ((Number) require).doubleValue();
        } else if (require instanceof String) {
            try {
                d2 = Double.parseDouble((String) require);
            } catch (NumberFormatException unused) {
                throw typeMismatch(require, Token.NUMBER);
            }
        } else {
            throw typeMismatch(require, Token.NUMBER);
        }
        if (this.lenient || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
            remove();
            return d2;
        }
        throw new JsonEncodingException("JSON forbids NaN and infinities: " + d2 + " at path " + getPath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        throw typeMismatch(r0, com.squareup.moshi.JsonReader.Token.NUMBER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = new java.math.BigDecimal((java.lang.String) r0).intValueExact();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int nextInt() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            java.lang.Object r0 = r3.require(r0, r1)
            boolean r1 = r0 instanceof java.lang.Number
            if (r1 == 0) goto L_0x0013
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            goto L_0x002b
        L_0x0013:
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x0036
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x001f }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x002b
        L_0x001f:
            java.math.BigDecimal r1 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x002f }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x002f }
            r1.<init>(r2)     // Catch:{ NumberFormatException -> 0x002f }
            int r0 = r1.intValueExact()     // Catch:{ NumberFormatException -> 0x002f }
        L_0x002b:
            r3.remove()
            return r0
        L_0x002f:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.typeMismatch(r0, r1)
            throw r0
        L_0x0036:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.typeMismatch(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonValueReader.nextInt():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        throw typeMismatch(r0, com.squareup.moshi.JsonReader.Token.NUMBER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = new java.math.BigDecimal((java.lang.String) r0).longValueExact();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long nextLong() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            java.lang.Object r0 = r3.require(r0, r1)
            boolean r1 = r0 instanceof java.lang.Number
            if (r1 == 0) goto L_0x0013
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            goto L_0x002b
        L_0x0013:
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x0036
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x001f }
            long r0 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x002b
        L_0x001f:
            java.math.BigDecimal r1 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x002f }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x002f }
            r1.<init>(r2)     // Catch:{ NumberFormatException -> 0x002f }
            long r0 = r1.longValueExact()     // Catch:{ NumberFormatException -> 0x002f }
        L_0x002b:
            r3.remove()
            return r0
        L_0x002f:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.typeMismatch(r0, r1)
            throw r0
        L_0x0036:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.typeMismatch(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonValueReader.nextLong():long");
    }

    public String nextName() throws IOException {
        Entry entry = (Entry) require(Entry.class, Token.NAME);
        String stringKey = stringKey(entry);
        this.stack[this.stackSize - 1] = entry.getValue();
        this.pathNames[this.stackSize - 2] = stringKey;
        return stringKey;
    }

    public <T> T nextNull() throws IOException {
        require(Void.class, Token.NULL);
        remove();
        return null;
    }

    public BufferedSource nextSource() throws IOException {
        Object readJsonValue = readJsonValue();
        Buffer buffer = new Buffer();
        JsonWriter of = JsonWriter.of(buffer);
        try {
            of.jsonValue(readJsonValue);
            of.close();
            return buffer;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String nextString() throws IOException {
        int i = this.stackSize;
        String str = i != 0 ? this.stack[i - 1] : null;
        if (str instanceof String) {
            remove();
            return str;
        } else if (str instanceof Number) {
            remove();
            return str.toString();
        } else if (str == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        } else {
            throw typeMismatch(str, Token.STRING);
        }
    }

    public Token peek() throws IOException {
        int i = this.stackSize;
        if (i == 0) {
            return Token.END_DOCUMENT;
        }
        Object obj = this.stack[i - 1];
        if (obj instanceof JsonIterator) {
            return ((JsonIterator) obj).endToken;
        }
        if (obj instanceof List) {
            return Token.BEGIN_ARRAY;
        }
        if (obj instanceof Map) {
            return Token.BEGIN_OBJECT;
        }
        if (obj instanceof Entry) {
            return Token.NAME;
        }
        if (obj instanceof String) {
            return Token.STRING;
        }
        if (obj instanceof Boolean) {
            return Token.BOOLEAN;
        }
        if (obj instanceof Number) {
            return Token.NUMBER;
        }
        if (obj == null) {
            return Token.NULL;
        }
        if (obj == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw typeMismatch(obj, "a JSON value");
    }

    public JsonReader peekJson() {
        return new JsonValueReader(this);
    }

    public void promoteNameToValue() throws IOException {
        if (hasNext()) {
            push(nextName());
        }
    }

    public int selectName(Options options) throws IOException {
        Entry entry = (Entry) require(Entry.class, Token.NAME);
        String stringKey = stringKey(entry);
        int length = options.strings.length;
        for (int i = 0; i < length; i++) {
            if (options.strings[i].equals(stringKey)) {
                this.stack[this.stackSize - 1] = entry.getValue();
                this.pathNames[this.stackSize - 2] = stringKey;
                return i;
            }
        }
        return -1;
    }

    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int selectString(com.squareup.moshi.JsonReader.Options r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.stackSize
            if (r0 == 0) goto L_0x000b
            java.lang.Object[] r1 = r5.stack
            int r0 = r0 + -1
            r0 = r1[r0]
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            boolean r1 = r0 instanceof java.lang.String
            r2 = -1
            if (r1 != 0) goto L_0x001e
            java.lang.Object r6 = JSON_READER_CLOSED
            if (r0 == r6) goto L_0x0016
            return r2
        L_0x0016:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "JsonReader is closed"
            r6.<init>(r0)
            throw r6
        L_0x001e:
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            java.lang.String[] r3 = r6.strings
            int r3 = r3.length
        L_0x0024:
            if (r1 >= r3) goto L_0x0037
            java.lang.String[] r4 = r6.strings
            r4 = r4[r1]
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r5.remove()
            return r1
        L_0x0034:
            int r1 = r1 + 1
            goto L_0x0024
        L_0x0037:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonValueReader.selectString(com.squareup.moshi.JsonReader$Options):int");
    }

    public void skipName() throws IOException {
        if (!this.failOnUnknown) {
            this.stack[this.stackSize - 1] = ((Entry) require(Entry.class, Token.NAME)).getValue();
            this.pathNames[this.stackSize - 2] = "null";
            return;
        }
        Token peek = peek();
        nextName();
        throw new JsonDataException("Cannot skip unexpected " + peek + " at " + getPath());
    }

    public void skipValue() throws IOException {
        if (!this.failOnUnknown) {
            int i = this.stackSize;
            if (i > 1) {
                this.pathNames[i - 2] = "null";
            }
            int i2 = this.stackSize;
            Object obj = i2 != 0 ? this.stack[i2 - 1] : null;
            if (obj instanceof JsonIterator) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a value but was ");
                outline73.append(peek());
                outline73.append(" at path ");
                outline73.append(getPath());
                throw new JsonDataException(outline73.toString());
            } else if (obj instanceof Entry) {
                Object[] objArr = this.stack;
                int i3 = this.stackSize;
                objArr[i3 - 1] = ((Entry) objArr[i3 - 1]).getValue();
            } else if (this.stackSize > 0) {
                remove();
            } else {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Expected a value but was ");
                outline732.append(peek());
                outline732.append(" at path ");
                outline732.append(getPath());
                throw new JsonDataException(outline732.toString());
            }
        } else {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Cannot skip unexpected ");
            outline733.append(peek());
            outline733.append(" at ");
            outline733.append(getPath());
            throw new JsonDataException(outline733.toString());
        }
    }

    public JsonValueReader(JsonValueReader jsonValueReader) {
        super(jsonValueReader);
        this.stack = (Object[]) jsonValueReader.stack.clone();
        for (int i = 0; i < this.stackSize; i++) {
            Object[] objArr = this.stack;
            if (objArr[i] instanceof JsonIterator) {
                objArr[i] = ((JsonIterator) objArr[i]).clone();
            }
        }
    }
}
