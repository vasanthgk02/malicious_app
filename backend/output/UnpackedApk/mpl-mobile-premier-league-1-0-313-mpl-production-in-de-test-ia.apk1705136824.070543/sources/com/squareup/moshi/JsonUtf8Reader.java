package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonReader.Token;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public final class JsonUtf8Reader extends JsonReader {
    public static final ByteString CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");
    public static final ByteString DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("\"\\");
    public static final ByteString LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8("\n\r");
    public static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    public static final int NUMBER_CHAR_DECIMAL = 3;
    public static final int NUMBER_CHAR_DIGIT = 2;
    public static final int NUMBER_CHAR_EXP_DIGIT = 7;
    public static final int NUMBER_CHAR_EXP_E = 5;
    public static final int NUMBER_CHAR_EXP_SIGN = 6;
    public static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    public static final int NUMBER_CHAR_NONE = 0;
    public static final int NUMBER_CHAR_SIGN = 1;
    public static final int PEEKED_BEGIN_ARRAY = 3;
    public static final int PEEKED_BEGIN_OBJECT = 1;
    public static final int PEEKED_BUFFERED = 11;
    public static final int PEEKED_BUFFERED_NAME = 15;
    public static final int PEEKED_DOUBLE_QUOTED = 9;
    public static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    public static final int PEEKED_END_ARRAY = 4;
    public static final int PEEKED_END_OBJECT = 2;
    public static final int PEEKED_EOF = 18;
    public static final int PEEKED_FALSE = 6;
    public static final int PEEKED_LONG = 16;
    public static final int PEEKED_NONE = 0;
    public static final int PEEKED_NULL = 7;
    public static final int PEEKED_NUMBER = 17;
    public static final int PEEKED_SINGLE_QUOTED = 8;
    public static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    public static final int PEEKED_TRUE = 5;
    public static final int PEEKED_UNQUOTED = 10;
    public static final int PEEKED_UNQUOTED_NAME = 14;
    public static final ByteString SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
    public static final ByteString UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public final Buffer buffer;
    public int peeked = 0;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public final BufferedSource source;
    public JsonValueSource valueSource;

    public JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.source = bufferedSource;
            this.buffer = bufferedSource.getBuffer();
            pushScope(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int doPeek() throws IOException {
        int[] iArr = this.scopes;
        int i = this.stackSize;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int nextNonWhitespace = nextNonWhitespace(true);
            this.buffer.readByte();
            if (nextNonWhitespace != 44) {
                if (nextNonWhitespace == 59) {
                    checkLenient();
                } else if (nextNonWhitespace == 93) {
                    this.peeked = 4;
                    return 4;
                } else {
                    throw syntaxError("Unterminated array");
                }
            }
        } else if (i2 == 3 || i2 == 5) {
            this.scopes[this.stackSize - 1] = 4;
            if (i2 == 5) {
                int nextNonWhitespace2 = nextNonWhitespace(true);
                this.buffer.readByte();
                if (nextNonWhitespace2 != 44) {
                    if (nextNonWhitespace2 == 59) {
                        checkLenient();
                    } else if (nextNonWhitespace2 == 125) {
                        this.peeked = 2;
                        return 2;
                    } else {
                        throw syntaxError("Unterminated object");
                    }
                }
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.buffer.readByte();
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                this.buffer.readByte();
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw syntaxError("Expected name");
            } else if (i2 != 5) {
                this.buffer.readByte();
                this.peeked = 2;
                return 2;
            } else {
                throw syntaxError("Expected name");
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            this.buffer.readByte();
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.source.request(1) && this.buffer.getByte(0) == 62) {
                        this.buffer.readByte();
                    }
                } else {
                    throw syntaxError("Expected ':'");
                }
            }
        } else if (i2 == 6) {
            iArr[i - 1] = 7;
        } else if (i2 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 18;
                return 18;
            }
            checkLenient();
        } else if (i2 == 9) {
            this.valueSource.discard();
            this.valueSource = null;
            this.stackSize--;
            return doPeek();
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.buffer.readByte();
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 != 39) {
            if (!(nextNonWhitespace5 == 44 || nextNonWhitespace5 == 59)) {
                if (nextNonWhitespace5 == 91) {
                    this.buffer.readByte();
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 != 123) {
                        int peekKeyword = peekKeyword();
                        if (peekKeyword != 0) {
                            return peekKeyword;
                        }
                        int peekNumber = peekNumber();
                        if (peekNumber != 0) {
                            return peekNumber;
                        }
                        if (isLiteral(this.buffer.getByte(0))) {
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                        throw syntaxError("Expected value");
                    }
                    this.buffer.readByte();
                    this.peeked = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.buffer.readByte();
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i2 == 1 || i2 == 2) {
                checkLenient();
                this.peeked = 7;
                return 7;
            }
            throw syntaxError("Unexpected value");
        } else {
            checkLenient();
            this.buffer.readByte();
            this.peeked = 8;
            return 8;
        }
    }

    private int findName(String str, Options options) {
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

    private int findString(String str, Options options) {
        int length = options.strings.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(options.strings[i])) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i2 = this.stackSize - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
        }
        return -1;
    }

    private boolean isLiteral(int i) throws IOException {
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
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.buffer.skip((long) (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r1 != 47) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.source.request(2) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        checkLenient();
        r3 = r6.buffer.getByte(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r3 == 42) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r3 == 47) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r6.buffer.readByte();
        r6.buffer.readByte();
        skipToEndOfLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r6.buffer.readByte();
        r6.buffer.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (skipToEndOfBlockComment() == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r1 != 35) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        checkLenient();
        skipToEndOfLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextNonWhitespace(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = 0
        L_0x0002:
            okio.BufferedSource r2 = r6.source
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L_0x0082
            okio.Buffer r2 = r6.buffer
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L_0x0080
            r2 = 32
            if (r1 == r2) goto L_0x0080
            r2 = 13
            if (r1 == r2) goto L_0x0080
            r2 = 9
            if (r1 != r2) goto L_0x0025
            goto L_0x0080
        L_0x0025:
            okio.Buffer r2 = r6.buffer
            int r3 = r3 + -1
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L_0x0074
            okio.BufferedSource r3 = r6.source
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L_0x003c
            return r1
        L_0x003c:
            r6.checkLenient()
            okio.Buffer r3 = r6.buffer
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005c
            if (r3 == r2) goto L_0x004e
            return r1
        L_0x004e:
            okio.Buffer r1 = r6.buffer
            r1.readByte()
            okio.Buffer r1 = r6.buffer
            r1.readByte()
            r6.skipToEndOfLine()
            goto L_0x0001
        L_0x005c:
            okio.Buffer r1 = r6.buffer
            r1.readByte()
            okio.Buffer r1 = r6.buffer
            r1.readByte()
            boolean r1 = r6.skipToEndOfBlockComment()
            if (r1 == 0) goto L_0x006d
            goto L_0x0001
        L_0x006d:
            java.lang.String r7 = "Unterminated comment"
            com.squareup.moshi.JsonEncodingException r7 = r6.syntaxError(r7)
            throw r7
        L_0x0074:
            r2 = 35
            if (r1 != r2) goto L_0x007f
            r6.checkLenient()
            r6.skipToEndOfLine()
            goto L_0x0001
        L_0x007f:
            return r1
        L_0x0080:
            r1 = r3
            goto L_0x0002
        L_0x0082:
            if (r7 != 0) goto L_0x0086
            r7 = -1
            return r7
        L_0x0086:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.nextNonWhitespace(boolean):int");
    }

    private String nextQuotedValue(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw syntaxError("Unterminated string");
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

    private String nextUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        return indexOfElement != -1 ? this.buffer.readUtf8(indexOfElement) : this.buffer.readUtf8();
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i;
        byte b2 = this.buffer.getByte(0);
        if (b2 == 116 || b2 == 84) {
            i = 5;
            str2 = BaseParser.TRUE;
            str = "TRUE";
        } else if (b2 == 102 || b2 == 70) {
            i = 6;
            str2 = BaseParser.FALSE;
            str = "FALSE";
        } else if (b2 != 110 && b2 != 78) {
            return 0;
        } else {
            i = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.source.request((long) i3)) {
                return 0;
            }
            byte b3 = this.buffer.getByte((long) i2);
            if (b3 != str2.charAt(i2) && b3 != str.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.source.request((long) (length + 1)) && isLiteral(this.buffer.getByte((long) length))) {
            return 0;
        }
        this.buffer.skip((long) length);
        this.peeked = i;
        return i;
    }

    private int peekNumber() throws IOException {
        byte b2;
        boolean z = true;
        int i = 0;
        long j = 0;
        int i2 = 0;
        char c2 = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            int i3 = i2 + 1;
            if (!this.source.request((long) i3)) {
                break;
            }
            b2 = this.buffer.getByte((long) i2);
            if (b2 != 43) {
                if (b2 != 69 && b2 != 101) {
                    if (b2 != 45) {
                        if (b2 != 46) {
                            if (b2 >= 48 && b2 <= 57) {
                                if (c2 == z || c2 == 0) {
                                    j = (long) (-(b2 - 48));
                                    i = 0;
                                    c2 = 2;
                                } else {
                                    if (c2 == 2) {
                                        if (j == 0) {
                                            return i;
                                        }
                                        long j2 = (10 * j) - ((long) (b2 - 48));
                                        int i4 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
                                        z2 &= i4 > 0 || (i4 == 0 && j2 < j);
                                        j = j2;
                                    } else if (c2 == 3) {
                                        i = 0;
                                        c2 = 4;
                                    } else if (c2 == 5 || c2 == 6) {
                                        i = 0;
                                        c2 = 7;
                                    }
                                    i = 0;
                                }
                            }
                        } else if (c2 != 2) {
                            return i;
                        } else {
                            c2 = 3;
                        }
                    } else if (c2 == 0) {
                        c2 = 1;
                        z3 = true;
                    } else if (c2 != 5) {
                        return i;
                    }
                    i2 = i3;
                    z = true;
                } else if (c2 != 2 && c2 != 4) {
                    return i;
                } else {
                    c2 = 5;
                    i2 = i3;
                    z = true;
                }
            } else if (c2 != 5) {
                return i;
            }
            c2 = 6;
            i2 = i3;
            z = true;
        }
        if (isLiteral(b2)) {
            return 0;
        }
        if (c2 == 2 && z2 && ((j != Long.MIN_VALUE || z3) && (j != 0 || !z3))) {
            if (!z3) {
                j = -j;
            }
            this.peekedLong = j;
            this.buffer.skip((long) i2);
            this.peeked = 16;
            return 16;
        } else if (c2 != 2 && c2 != 4 && c2 != 7) {
            return 0;
        } else {
            this.peekedNumberLength = i2;
            this.peeked = 17;
            return 17;
        }
    }

    private char readEscapeCharacter() throws IOException {
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
                if (this.lenient) {
                    return (char) readByte;
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid escape sequence: \\");
                outline73.append((char) readByte);
                throw syntaxError(outline73.toString());
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
                            throw syntaxError(outline732.toString());
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
            throw syntaxError("Unterminated escape sequence");
        }
    }

    private void skipQuotedValue(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw syntaxError("Unterminated string");
            } else if (this.buffer.getByte(indexOfElement) == 92) {
                this.buffer.skip(indexOfElement + 1);
                readEscapeCharacter();
            } else {
                this.buffer.skip(indexOfElement + 1);
                return;
            }
        }
    }

    private boolean skipToEndOfBlockComment() throws IOException {
        long indexOf = this.source.indexOf(CLOSING_BLOCK_COMMENT);
        boolean z = indexOf != -1;
        Buffer buffer2 = this.buffer;
        buffer2.skip(z ? indexOf + ((long) CLOSING_BLOCK_COMMENT.size()) : buffer2.size());
        return z;
    }

    private void skipToEndOfLine() throws IOException {
        long indexOfElement = this.source.indexOfElement(LINEFEED_OR_CARRIAGE_RETURN);
        Buffer buffer2 = this.buffer;
        buffer2.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer2.size());
    }

    private void skipUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer2 = this.buffer;
        if (indexOfElement == -1) {
            indexOfElement = buffer2.size();
        }
        buffer2.skip(indexOfElement);
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

    public void close() throws IOException {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.clear();
        this.source.close();
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

    public boolean hasNext() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
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
            if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
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

    public long nextLong() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 16) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
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
                long parseLong = Long.parseLong(str);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a long but was ");
            outline73.append(peek());
            outline73.append(" at path ");
            outline73.append(getPath());
            throw new JsonDataException(outline73.toString());
        }
        this.peeked = 11;
        try {
            long longValueExact = new BigDecimal(this.peekedString).longValueExact();
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return longValueExact;
        } catch (ArithmeticException | NumberFormatException unused2) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Expected a long but was ");
            outline732.append(this.peekedString);
            outline732.append(" at path ");
            outline732.append(getPath());
            throw new JsonDataException(outline732.toString());
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
            this.peekedString = null;
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

    public <T> T nextNull() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected null but was ");
        outline73.append(peek());
        outline73.append(" at path ");
        outline73.append(getPath());
        throw new JsonDataException(outline73.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.BufferedSource nextSource() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.peeked
            if (r0 != 0) goto L_0x0008
            int r0 = r9.doPeek()
        L_0x0008:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.ByteString r2 = com.squareup.moshi.JsonValueSource.STATE_END_OF_JSON
            r3 = 3
            r4 = 9
            r5 = 0
            r6 = 1
            if (r0 != r3) goto L_0x001e
            java.lang.String r0 = "["
            r1.writeUtf8(r0)
            okio.ByteString r0 = com.squareup.moshi.JsonValueSource.STATE_JSON
            goto L_0x0027
        L_0x001e:
            if (r0 != r6) goto L_0x002a
            java.lang.String r0 = "{"
            r1.writeUtf8(r0)
            okio.ByteString r0 = com.squareup.moshi.JsonValueSource.STATE_JSON
        L_0x0027:
            r2 = 1
            goto L_0x00b6
        L_0x002a:
            if (r0 != r4) goto L_0x0035
            java.lang.String r0 = "\""
            r1.writeUtf8(r0)
            okio.ByteString r2 = com.squareup.moshi.JsonValueSource.STATE_DOUBLE_QUOTED
            goto L_0x00b3
        L_0x0035:
            r3 = 8
            if (r0 != r3) goto L_0x0042
            java.lang.String r0 = "'"
            r1.writeUtf8(r0)
            okio.ByteString r2 = com.squareup.moshi.JsonValueSource.STATE_SINGLE_QUOTED
            goto L_0x00b3
        L_0x0042:
            r3 = 17
            if (r0 == r3) goto L_0x00ac
            r3 = 16
            if (r0 == r3) goto L_0x00ac
            r3 = 10
            if (r0 != r3) goto L_0x004f
            goto L_0x00ac
        L_0x004f:
            r3 = 5
            if (r0 != r3) goto L_0x0058
            java.lang.String r0 = "true"
            r1.writeUtf8(r0)
            goto L_0x00b3
        L_0x0058:
            r3 = 6
            if (r0 != r3) goto L_0x0061
            java.lang.String r0 = "false"
            r1.writeUtf8(r0)
            goto L_0x00b3
        L_0x0061:
            r3 = 7
            if (r0 != r3) goto L_0x006a
            java.lang.String r0 = "null"
            r1.writeUtf8(r0)
            goto L_0x00b3
        L_0x006a:
            r3 = 11
            if (r0 != r3) goto L_0x0089
            java.lang.String r0 = r9.nextString()
            com.squareup.moshi.JsonWriter r3 = com.squareup.moshi.JsonWriter.of(r1)
            r3.value(r0)     // Catch:{ all -> 0x007d }
            r3.close()
            goto L_0x00b3
        L_0x007d:
            r0 = move-exception
            if (r3 == 0) goto L_0x0088
            r3.close()     // Catch:{ all -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0088:
            throw r0
        L_0x0089:
            com.squareup.moshi.JsonDataException r0 = new com.squareup.moshi.JsonDataException
            java.lang.String r1 = "Expected a value but was "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            com.squareup.moshi.JsonReader$Token r2 = r9.peek()
            r1.append(r2)
            java.lang.String r2 = " at path "
            r1.append(r2)
            java.lang.String r2 = r9.getPath()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ac:
            java.lang.String r0 = r9.nextString()
            r1.writeUtf8(r0)
        L_0x00b3:
            r0 = 0
            r0 = r2
            r2 = 0
        L_0x00b6:
            int r3 = r9.peeked
            if (r3 == 0) goto L_0x00c6
            int[] r3 = r9.pathIndices
            int r7 = r9.stackSize
            int r7 = r7 - r6
            r8 = r3[r7]
            int r8 = r8 + r6
            r3[r7] = r8
            r9.peeked = r5
        L_0x00c6:
            com.squareup.moshi.JsonValueSource r3 = new com.squareup.moshi.JsonValueSource
            okio.BufferedSource r5 = r9.source
            r3.<init>(r5, r1, r0, r2)
            r9.valueSource = r3
            r9.pushScope(r4)
            com.squareup.moshi.JsonValueSource r0 = r9.valueSource
            okio.BufferedSource r0 = okio.Okio.buffer(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.nextSource():okio.BufferedSource");
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

    public JsonReader peekJson() {
        return new JsonUtf8Reader(this);
    }

    public void promoteNameToValue() throws IOException {
        if (hasNext()) {
            this.peekedString = nextName();
            this.peeked = 11;
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

    public int selectString(Options options) throws IOException {
        int[] iArr;
        int i;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 < 8 || i2 > 11) {
            return -1;
        }
        if (i2 == 11) {
            return findString(this.peekedString, options);
        }
        int select = this.source.select(options.doubleQuoteSuffix);
        if (select != -1) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return select;
        }
        String nextString = nextString();
        int findString = findString(nextString, options);
        if (findString == -1) {
            this.peeked = 11;
            this.peekedString = nextString;
            iArr[i] = this.pathIndices[this.stackSize - 1] - 1;
        }
        return findString;
    }

    public void skipName() throws IOException {
        if (!this.failOnUnknown) {
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
            return;
        }
        Token peek = peek();
        nextName();
        throw new JsonDataException("Cannot skip unexpected " + peek + " at " + getPath());
    }

    public void skipValue() throws IOException {
        if (!this.failOnUnknown) {
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
            return;
        }
        StringBuilder outline734 = GeneratedOutlineSupport.outline73("Cannot skip unexpected ");
        outline734.append(peek());
        outline734.append(" at ");
        outline734.append(getPath());
        throw new JsonDataException(outline734.toString());
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JsonReader(");
        outline73.append(this.source);
        outline73.append(")");
        return outline73.toString();
    }

    public JsonUtf8Reader(JsonUtf8Reader jsonUtf8Reader) {
        super(jsonUtf8Reader);
        BufferedSource peek = jsonUtf8Reader.source.peek();
        this.source = peek;
        this.buffer = peek.getBuffer();
        this.peeked = jsonUtf8Reader.peeked;
        this.peekedLong = jsonUtf8Reader.peekedLong;
        this.peekedNumberLength = jsonUtf8Reader.peekedNumberLength;
        this.peekedString = jsonUtf8Reader.peekedString;
        try {
            peek.require(jsonUtf8Reader.buffer.size());
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }
}
