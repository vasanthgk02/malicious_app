package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public final class JsonUtf8Reader extends JsonReader {
    public static final ByteString CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");
    public static final ByteString DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("\"\\");
    public static final ByteString LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8("\n\r");
    public static final ByteString SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
    public static final ByteString UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public final Buffer buffer;
    public int peeked = 0;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public final BufferedSource source;

    public JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.source = bufferedSource;
            this.buffer = bufferedSource.buffer();
            pushScope(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    public void beginArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 3) {
            pushScope(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected BEGIN_ARRAY but was ");
        outline73.append(peek());
        outline73.append(" at path ");
        outline73.append(getPath());
        throw new JsonDataException(outline73.toString());
    }

    public void beginObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 1) {
            pushScope(3);
            this.peeked = 0;
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected BEGIN_OBJECT but was ");
        outline73.append(peek());
        outline73.append(" at path ");
        outline73.append(getPath());
        throw new JsonDataException(outline73.toString());
    }

    public final void checkLenient() throws IOException {
        syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.clear();
        this.source.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01a8, code lost:
        if (isLiteral(r2) != false) goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01ab, code lost:
        if (r1 != 2) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01ad, code lost:
        if (r6 == false) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01b3, code lost:
        if (r7 != Long.MIN_VALUE) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01b5, code lost:
        if (r9 == false) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01bb, code lost:
        if (r7 != 0) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01bd, code lost:
        if (r9 != false) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01bf, code lost:
        if (r9 == false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01c2, code lost:
        r7 = -r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01c3, code lost:
        r0.peekedLong = r7;
        r0.buffer.skip((long) r5);
        r15 = 16;
        r0.peeked = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01d0, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01d1, code lost:
        if (r1 == r2) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01d4, code lost:
        if (r1 == 4) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01d7, code lost:
        if (r1 != 7) goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01d9, code lost:
        r0.peekedNumberLength = r5;
        r15 = 17;
        r0.peeked = 17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0131, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0120 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int doPeek() throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            int[] r1 = r0.scopes
            int r2 = r0.stackSize
            int r3 = r2 + -1
            r3 = r1[r3]
            r5 = 34
            r6 = 93
            r7 = 59
            r8 = 44
            r9 = 6
            r10 = 3
            r11 = 7
            r12 = 5
            r13 = 4
            r14 = 2
            r15 = 0
            r16 = 0
            r4 = 1
            if (r3 != r4) goto L_0x0022
            int r2 = r2 - r4
            r1[r2] = r14
            goto L_0x0082
        L_0x0022:
            if (r3 != r14) goto L_0x0040
            int r1 = r0.nextNonWhitespace(r4)
            okio.Buffer r2 = r0.buffer
            r2.readByte()
            if (r1 == r8) goto L_0x0082
            if (r1 == r7) goto L_0x003c
            if (r1 != r6) goto L_0x0036
            r0.peeked = r13
            return r13
        L_0x0036:
            java.lang.String r1 = "Unterminated array"
            r0.syntaxError(r1)
            throw r16
        L_0x003c:
            r17.checkLenient()
            throw r16
        L_0x0040:
            if (r3 == r10) goto L_0x026c
            if (r3 != r12) goto L_0x0046
            goto L_0x026c
        L_0x0046:
            if (r3 != r13) goto L_0x0066
            int r2 = r2 - r4
            r1[r2] = r12
            int r1 = r0.nextNonWhitespace(r4)
            okio.Buffer r2 = r0.buffer
            r2.readByte()
            r2 = 58
            if (r1 == r2) goto L_0x0082
            r2 = 61
            if (r1 == r2) goto L_0x0062
            java.lang.String r1 = "Expected ':'"
            r0.syntaxError(r1)
            throw r16
        L_0x0062:
            r17.checkLenient()
            throw r16
        L_0x0066:
            if (r3 != r9) goto L_0x006c
            int r2 = r2 - r4
            r1[r2] = r11
            goto L_0x0082
        L_0x006c:
            if (r3 != r11) goto L_0x007e
            int r1 = r0.nextNonWhitespace(r15)
            r2 = -1
            if (r1 != r2) goto L_0x007a
            r1 = 18
            r0.peeked = r1
            return r1
        L_0x007a:
            r17.checkLenient()
            throw r16
        L_0x007e:
            r1 = 8
            if (r3 == r1) goto L_0x0264
        L_0x0082:
            int r1 = r0.nextNonWhitespace(r4)
            if (r1 == r5) goto L_0x025a
            r2 = 39
            if (r1 == r2) goto L_0x0256
            if (r1 == r8) goto L_0x0246
            if (r1 == r7) goto L_0x0246
            r2 = 91
            if (r1 == r2) goto L_0x023d
            if (r1 == r6) goto L_0x0232
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x022a
            okio.Buffer r1 = r0.buffer
            r2 = 0
            byte r1 = r1.getByte(r2)
            r5 = 116(0x74, float:1.63E-43)
            if (r1 == r5) goto L_0x00c8
            r5 = 84
            if (r1 != r5) goto L_0x00ab
            goto L_0x00c8
        L_0x00ab:
            r5 = 102(0x66, float:1.43E-43)
            if (r1 == r5) goto L_0x00c2
            r5 = 70
            if (r1 != r5) goto L_0x00b4
            goto L_0x00c2
        L_0x00b4:
            r5 = 110(0x6e, float:1.54E-43)
            if (r1 == r5) goto L_0x00bc
            r5 = 78
            if (r1 != r5) goto L_0x00df
        L_0x00bc:
            java.lang.String r1 = "null"
            java.lang.String r5 = "NULL"
            r6 = 7
            goto L_0x00cd
        L_0x00c2:
            java.lang.String r1 = "false"
            java.lang.String r5 = "FALSE"
            r6 = 6
            goto L_0x00cd
        L_0x00c8:
            java.lang.String r1 = "true"
            java.lang.String r5 = "TRUE"
            r6 = 5
        L_0x00cd:
            int r7 = r1.length()
            r8 = 1
        L_0x00d2:
            if (r8 >= r7) goto L_0x00fd
            okio.BufferedSource r15 = r0.source
            int r11 = r8 + 1
            long r12 = (long) r11
            boolean r12 = r15.request(r12)
            if (r12 != 0) goto L_0x00e1
        L_0x00df:
            r6 = 0
            goto L_0x011e
        L_0x00e1:
            okio.Buffer r12 = r0.buffer
            long r9 = (long) r8
            byte r9 = r12.getByte(r9)
            char r10 = r1.charAt(r8)
            if (r9 == r10) goto L_0x00f5
            char r8 = r5.charAt(r8)
            if (r9 == r8) goto L_0x00f5
            goto L_0x00df
        L_0x00f5:
            r8 = r11
            r9 = 6
            r10 = 3
            r11 = 7
            r12 = 5
            r13 = 4
            r15 = 0
            goto L_0x00d2
        L_0x00fd:
            okio.BufferedSource r1 = r0.source
            int r5 = r7 + 1
            long r8 = (long) r5
            boolean r1 = r1.request(r8)
            if (r1 == 0) goto L_0x0116
            okio.Buffer r1 = r0.buffer
            long r8 = (long) r7
            byte r1 = r1.getByte(r8)
            boolean r1 = r0.isLiteral(r1)
            if (r1 == 0) goto L_0x0116
            goto L_0x00df
        L_0x0116:
            okio.Buffer r1 = r0.buffer
            long r7 = (long) r7
            r1.skip(r7)
            r0.peeked = r6
        L_0x011e:
            if (r6 == 0) goto L_0x0121
            return r6
        L_0x0121:
            r7 = r2
            r1 = 0
            r5 = 0
            r6 = 1
            r9 = 0
        L_0x0126:
            okio.BufferedSource r10 = r0.source
            int r11 = r5 + 1
            long r2 = (long) r11
            boolean r2 = r10.request(r2)
            if (r2 != 0) goto L_0x0134
        L_0x0131:
            r2 = 2
            goto L_0x01ab
        L_0x0134:
            okio.Buffer r2 = r0.buffer
            long r13 = (long) r5
            byte r2 = r2.getByte(r13)
            r12 = 43
            if (r2 == r12) goto L_0x0201
            r12 = 69
            if (r2 == r12) goto L_0x01f5
            r12 = 101(0x65, float:1.42E-43)
            if (r2 == r12) goto L_0x01f5
            r12 = 45
            if (r2 == r12) goto L_0x01e8
            r12 = 46
            if (r2 == r12) goto L_0x01e0
            r12 = 48
            if (r2 < r12) goto L_0x01a4
            r12 = 57
            if (r2 <= r12) goto L_0x0158
            goto L_0x01a4
        L_0x0158:
            if (r1 == r4) goto L_0x019a
            if (r1 != 0) goto L_0x015d
            goto L_0x019a
        L_0x015d:
            r5 = 2
            if (r1 != r5) goto L_0x0189
            r12 = 0
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x0168
            goto L_0x020e
        L_0x0168:
            r12 = 10
            long r12 = r12 * r7
            int r2 = r2 + -48
            r14 = r11
            long r10 = (long) r2
            long r12 = r12 - r10
            r10 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 > 0) goto L_0x0183
            if (r2 != 0) goto L_0x0181
            int r2 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x0181
            goto L_0x0183
        L_0x0181:
            r2 = 0
            goto L_0x0184
        L_0x0183:
            r2 = 1
        L_0x0184:
            r2 = r2 & r6
            r6 = r2
            r7 = r12
            r3 = 6
            goto L_0x01a1
        L_0x0189:
            r14 = r11
            r2 = 3
            if (r1 != r2) goto L_0x0192
            r1 = 4
            r2 = 7
            r3 = 6
            goto L_0x0208
        L_0x0192:
            r2 = 5
            r3 = 6
            if (r1 == r2) goto L_0x0198
            if (r1 != r3) goto L_0x01a1
        L_0x0198:
            r1 = 7
            goto L_0x01a1
        L_0x019a:
            r14 = r11
            r3 = 6
            int r2 = r2 + -48
            int r1 = -r2
            long r7 = (long) r1
            r1 = 2
        L_0x01a1:
            r2 = 7
            goto L_0x0208
        L_0x01a4:
            boolean r2 = r0.isLiteral(r2)
            if (r2 != 0) goto L_0x020e
            goto L_0x0131
        L_0x01ab:
            if (r1 != r2) goto L_0x01d1
            if (r6 == 0) goto L_0x01d0
            r2 = -9223372036854775808
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x01b7
            if (r9 == 0) goto L_0x01d0
        L_0x01b7:
            r2 = 0
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x01bf
            if (r9 != 0) goto L_0x01d0
        L_0x01bf:
            if (r9 == 0) goto L_0x01c2
            goto L_0x01c3
        L_0x01c2:
            long r7 = -r7
        L_0x01c3:
            r0.peekedLong = r7
            okio.Buffer r1 = r0.buffer
            long r2 = (long) r5
            r1.skip(r2)
            r15 = 16
            r0.peeked = r15
            goto L_0x020f
        L_0x01d0:
            r2 = 2
        L_0x01d1:
            if (r1 == r2) goto L_0x01d9
            r2 = 4
            if (r1 == r2) goto L_0x01d9
            r2 = 7
            if (r1 != r2) goto L_0x020e
        L_0x01d9:
            r0.peekedNumberLength = r5
            r15 = 17
            r0.peeked = r15
            goto L_0x020f
        L_0x01e0:
            r14 = r11
            r2 = 7
            r3 = 6
            r5 = 2
            if (r1 != r5) goto L_0x020e
            r1 = 3
            goto L_0x0208
        L_0x01e8:
            r14 = r11
            r2 = 7
            r3 = 6
            r5 = 2
            if (r1 != 0) goto L_0x01f1
            r1 = 1
            r9 = 1
            goto L_0x0208
        L_0x01f1:
            r11 = 5
            if (r1 != r11) goto L_0x020e
            goto L_0x0207
        L_0x01f5:
            r14 = r11
            r2 = 7
            r3 = 6
            r5 = 2
            r11 = 5
            if (r1 == r5) goto L_0x01ff
            r5 = 4
            if (r1 != r5) goto L_0x020e
        L_0x01ff:
            r1 = 5
            goto L_0x0208
        L_0x0201:
            r14 = r11
            r2 = 7
            r3 = 6
            r11 = 5
            if (r1 != r11) goto L_0x020e
        L_0x0207:
            r1 = 6
        L_0x0208:
            r5 = r14
            r2 = 0
            r14 = 2
            goto L_0x0126
        L_0x020e:
            r15 = 0
        L_0x020f:
            if (r15 == 0) goto L_0x0212
            return r15
        L_0x0212:
            okio.Buffer r1 = r0.buffer
            r2 = 0
            byte r1 = r1.getByte(r2)
            boolean r1 = r0.isLiteral(r1)
            if (r1 != 0) goto L_0x0226
            java.lang.String r1 = "Expected value"
            r0.syntaxError(r1)
            throw r16
        L_0x0226:
            r17.checkLenient()
            throw r16
        L_0x022a:
            okio.Buffer r1 = r0.buffer
            r1.readByte()
            r0.peeked = r4
            return r4
        L_0x0232:
            if (r3 != r4) goto L_0x0246
            okio.Buffer r1 = r0.buffer
            r1.readByte()
            r1 = 4
            r0.peeked = r1
            return r1
        L_0x023d:
            okio.Buffer r1 = r0.buffer
            r1.readByte()
            r1 = 3
            r0.peeked = r1
            return r1
        L_0x0246:
            if (r3 == r4) goto L_0x0252
            r1 = 2
            if (r3 != r1) goto L_0x024c
            goto L_0x0252
        L_0x024c:
            java.lang.String r1 = "Unexpected value"
            r0.syntaxError(r1)
            throw r16
        L_0x0252:
            r17.checkLenient()
            throw r16
        L_0x0256:
            r17.checkLenient()
            throw r16
        L_0x025a:
            okio.Buffer r1 = r0.buffer
            r1.readByte()
            r1 = 9
            r0.peeked = r1
            return r1
        L_0x0264:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "JsonReader is closed"
            r1.<init>(r2)
            throw r1
        L_0x026c:
            int[] r1 = r0.scopes
            int r2 = r0.stackSize
            int r2 = r2 - r4
            r6 = 4
            r1[r2] = r6
            r1 = 125(0x7d, float:1.75E-43)
            r2 = 5
            if (r3 != r2) goto L_0x0296
            int r2 = r0.nextNonWhitespace(r4)
            okio.Buffer r6 = r0.buffer
            r6.readByte()
            if (r2 == r8) goto L_0x0296
            if (r2 == r7) goto L_0x0292
            if (r2 != r1) goto L_0x028c
            r1 = 2
            r0.peeked = r1
            return r1
        L_0x028c:
            java.lang.String r1 = "Unterminated object"
            r0.syntaxError(r1)
            throw r16
        L_0x0292:
            r17.checkLenient()
            throw r16
        L_0x0296:
            int r2 = r0.nextNonWhitespace(r4)
            if (r2 == r5) goto L_0x02c1
            r4 = 39
            if (r2 == r4) goto L_0x02b8
            if (r2 != r1) goto L_0x02b4
            r1 = 5
            if (r3 == r1) goto L_0x02ae
            okio.Buffer r1 = r0.buffer
            r1.readByte()
            r1 = 2
            r0.peeked = r1
            return r1
        L_0x02ae:
            java.lang.String r1 = "Expected name"
            r0.syntaxError(r1)
            throw r16
        L_0x02b4:
            r17.checkLenient()
            throw r16
        L_0x02b8:
            okio.Buffer r1 = r0.buffer
            r1.readByte()
            r17.checkLenient()
            throw r16
        L_0x02c1:
            okio.Buffer r1 = r0.buffer
            r1.readByte()
            r1 = 13
            r0.peeked = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.doPeek():int");
    }

    public void endArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 4) {
            int i2 = this.stackSize - 1;
            this.stackSize = i2;
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected END_ARRAY but was ");
        outline73.append(peek());
        outline73.append(" at path ");
        outline73.append(getPath());
        throw new JsonDataException(outline73.toString());
    }

    public void endObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 2) {
            int i2 = this.stackSize - 1;
            this.stackSize = i2;
            this.pathNames[i2] = null;
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected END_OBJECT but was ");
        outline73.append(peek());
        outline73.append(" at path ");
        outline73.append(getPath());
        throw new JsonDataException(outline73.toString());
    }

    public final int findName(String str, Options options) {
        int length = options.strings.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(options.strings[i])) {
                this.peeked = 0;
                this.pathNames[this.stackSize - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public boolean hasNext() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
    }

    public final boolean isLiteral(int i) throws IOException {
        if (!(i == 9 || i == 10 || i == 12 || i == 13 || i == 32)) {
            if (i != 35) {
                if (i != 44) {
                    if (!(i == 47 || i == 61)) {
                        if (!(i == 123 || i == 125 || i == 58)) {
                            if (i != 59) {
                                switch (i) {
                                    case 91:
                                    case 93:
                                        break;
                                    case 92:
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        }
                    }
                }
            }
            checkLenient();
            throw null;
        }
        return false;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a boolean but was ");
            outline73.append(peek());
            outline73.append(" at path ");
            outline73.append(getPath());
            throw new JsonDataException(outline73.toString());
        }
    }

    public double nextDouble() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 16) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.peekedLong;
        }
        if (i == 17) {
            this.peekedString = this.buffer.readUtf8((long) this.peekedNumberLength);
        } else if (i == 9) {
            this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i == 8) {
            this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i != 11) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a double but was ");
            outline73.append(peek());
            outline73.append(" at path ");
            outline73.append(getPath());
            throw new JsonDataException(outline73.toString());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            if (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble)) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Expected a double but was ");
            outline732.append(this.peekedString);
            outline732.append(" at path ");
            outline732.append(getPath());
            throw new JsonDataException(outline732.toString());
        }
    }

    public int nextInt() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 16) {
            long j = this.peekedLong;
            int i2 = (int) j;
            if (j == ((long) i2)) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected an int but was ");
            outline73.append(this.peekedLong);
            outline73.append(" at path ");
            outline73.append(getPath());
            throw new JsonDataException(outline73.toString());
        }
        if (i == 17) {
            this.peekedString = this.buffer.readUtf8((long) this.peekedNumberLength);
        } else if (i == 9 || i == 8) {
            if (i == 9) {
                str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else {
                str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            }
            this.peekedString = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Expected an int but was ");
            outline732.append(peek());
            outline732.append(" at path ");
            outline732.append(getPath());
            throw new JsonDataException(outline732.toString());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            int i5 = (int) parseDouble;
            if (((double) i5) == parseDouble) {
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr3 = this.pathIndices;
                int i6 = this.stackSize - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Expected an int but was ");
            outline733.append(this.peekedString);
            outline733.append(" at path ");
            outline733.append(getPath());
            throw new JsonDataException(outline733.toString());
        } catch (NumberFormatException unused2) {
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("Expected an int but was ");
            outline734.append(this.peekedString);
            outline734.append(" at path ");
            outline734.append(getPath());
            throw new JsonDataException(outline734.toString());
        }
    }

    public String nextName() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            str = nextUnquotedValue();
        } else if (i == 13) {
            str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i == 12) {
            str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i == 15) {
            str = this.peekedString;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a name but was ");
            outline73.append(peek());
            outline73.append(" at path ");
            outline73.append(getPath());
            throw new JsonDataException(outline73.toString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public final int nextNonWhitespace(boolean z) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (this.source.request((long) i2)) {
                byte b2 = this.buffer.getByte((long) i);
                if (b2 == 10 || b2 == 32 || b2 == 13 || b2 == 9) {
                    i = i2;
                } else {
                    this.buffer.skip((long) (i2 - 1));
                    if (b2 == 47) {
                        if (!this.source.request(2)) {
                            return b2;
                        }
                        checkLenient();
                        throw null;
                    } else if (b2 != 35) {
                        return b2;
                    } else {
                        checkLenient();
                        throw null;
                    }
                }
            } else if (!z) {
                return -1;
            } else {
                throw new EOFException("End of input");
            }
        }
    }

    public final String nextQuotedValue(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                syntaxError("Unterminated string");
                throw null;
            } else if (this.buffer.getByte(indexOfElement) == 92) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.buffer.readUtf8(indexOfElement));
                this.buffer.readByte();
                sb.append(readEscapeCharacter());
            } else if (sb == null) {
                String readUtf8 = this.buffer.readUtf8(indexOfElement);
                this.buffer.readByte();
                return readUtf8;
            } else {
                sb.append(this.buffer.readUtf8(indexOfElement));
                this.buffer.readByte();
                return sb.toString();
            }
        }
    }

    public String nextString() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 10) {
            str = nextUnquotedValue();
        } else if (i == 9) {
            str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i == 8) {
            str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i == 16) {
            str = Long.toString(this.peekedLong);
        } else if (i == 17) {
            str = this.buffer.readUtf8((long) this.peekedNumberLength);
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a string but was ");
            outline73.append(peek());
            outline73.append(" at path ");
            outline73.append(getPath());
            throw new JsonDataException(outline73.toString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final String nextUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        return indexOfElement != -1 ? this.buffer.readUtf8(indexOfElement) : this.buffer.readUtf8();
    }

    public Token peek() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        switch (i) {
            case 1:
                return Token.BEGIN_OBJECT;
            case 2:
                return Token.END_OBJECT;
            case 3:
                return Token.BEGIN_ARRAY;
            case 4:
                return Token.END_ARRAY;
            case 5:
            case 6:
                return Token.BOOLEAN;
            case 7:
                return Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return Token.NAME;
            case 16:
            case 17:
                return Token.NUMBER;
            case 18:
                return Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final char readEscapeCharacter() throws IOException {
        int i;
        int i2;
        if (this.source.request(1)) {
            byte readByte = this.buffer.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return Tokenizer.FF;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return 13;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid escape sequence: \\");
                outline73.append((char) readByte);
                syntaxError(outline73.toString());
                throw null;
            } else if (this.source.request(4)) {
                char c2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    byte b2 = this.buffer.getByte((long) i3);
                    char c3 = (char) (c2 << 4);
                    if (b2 < 48 || b2 > 57) {
                        if (b2 >= 97 && b2 <= 102) {
                            i2 = b2 - 97;
                        } else if (b2 < 65 || b2 > 70) {
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("\\u");
                            outline732.append(this.buffer.readUtf8(4));
                            syntaxError(outline732.toString());
                            throw null;
                        } else {
                            i2 = b2 - 65;
                        }
                        i = i2 + 10;
                    } else {
                        i = b2 - 48;
                    }
                    c2 = (char) (i + c3);
                }
                this.buffer.skip(4);
                return c2;
            } else {
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("Unterminated escape sequence at path ");
                outline733.append(getPath());
                throw new EOFException(outline733.toString());
            }
        } else {
            syntaxError("Unterminated escape sequence");
            throw null;
        }
    }

    public int selectName(Options options) throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return findName(this.peekedString, options);
        }
        int select = this.source.select(options.doubleQuoteSuffix);
        if (select != -1) {
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = options.strings[select];
            return select;
        }
        String str = this.pathNames[this.stackSize - 1];
        String nextName = nextName();
        int findName = findName(nextName, options);
        if (findName == -1) {
            this.peeked = 15;
            this.peekedString = nextName;
            this.pathNames[this.stackSize - 1] = str;
        }
        return findName;
    }

    public void skipName() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            skipUnquotedValue();
        } else if (i == 13) {
            skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i == 12) {
            skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i != 15) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a name but was ");
            outline73.append(peek());
            outline73.append(" at path ");
            outline73.append(getPath());
            throw new JsonDataException(outline73.toString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = "null";
    }

    public final void skipQuotedValue(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                syntaxError("Unterminated string");
                throw null;
            } else if (this.buffer.getByte(indexOfElement) == 92) {
                this.buffer.skip(indexOfElement + 1);
                readEscapeCharacter();
            } else {
                this.buffer.skip(indexOfElement + 1);
                return;
            }
        }
    }

    public final void skipUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer2 = this.buffer;
        if (indexOfElement == -1) {
            indexOfElement = buffer2.size();
        }
        buffer2.skip(indexOfElement);
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 3) {
                pushScope(1);
            } else if (i2 == 1) {
                pushScope(3);
            } else {
                if (i2 == 4) {
                    i--;
                    if (i >= 0) {
                        this.stackSize--;
                    } else {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a value but was ");
                        outline73.append(peek());
                        outline73.append(" at path ");
                        outline73.append(getPath());
                        throw new JsonDataException(outline73.toString());
                    }
                } else if (i2 == 2) {
                    i--;
                    if (i >= 0) {
                        this.stackSize--;
                    } else {
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Expected a value but was ");
                        outline732.append(peek());
                        outline732.append(" at path ");
                        outline732.append(getPath());
                        throw new JsonDataException(outline732.toString());
                    }
                } else if (i2 == 14 || i2 == 10) {
                    skipUnquotedValue();
                } else if (i2 == 9 || i2 == 13) {
                    skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                } else if (i2 == 8 || i2 == 12) {
                    skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                } else if (i2 == 17) {
                    this.buffer.skip((long) this.peekedNumberLength);
                } else if (i2 == 18) {
                    StringBuilder outline733 = GeneratedOutlineSupport.outline73("Expected a value but was ");
                    outline733.append(peek());
                    outline733.append(" at path ");
                    outline733.append(getPath());
                    throw new JsonDataException(outline733.toString());
                }
                this.peeked = 0;
            }
            i++;
            this.peeked = 0;
        } while (i != 0);
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.pathNames[i3 - 1] = "null";
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JsonReader(");
        outline73.append(this.source);
        outline73.append(")");
        return outline73.toString();
    }
}
