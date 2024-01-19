package org.apache.pdfbox.pdfparser;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.io.PushBackInputStream;

public abstract class BaseParser implements Closeable {
    public static final int A = 97;
    public static final byte ASCII_CR = 13;
    public static final byte ASCII_LF = 10;
    public static final byte ASCII_NINE = 57;
    public static final byte ASCII_SPACE = 32;
    public static final byte ASCII_ZERO = 48;
    public static final int B = 98;
    public static final int D = 100;
    public static final String DEF = "def";
    public static final int E = 101;
    public static final byte[] ENDOBJ = {101, 110, 100, 111, 98, 106};
    public static final String ENDOBJ_STRING = "endobj";
    public static final byte[] ENDSTREAM = {101, 110, 100, 115, 116, 114, 101, 97, 109};
    public static final String ENDSTREAM_STRING = "endstream";
    public static final String FALSE = "false";
    public static final long GENERATION_NUMBER_THRESHOLD = 65535;
    public static final String ISO_8859_1 = "ISO-8859-1";
    public static final int J = 106;
    public static final int M = 109;
    public static final int N = 110;
    public static final String NULL = "null";
    public static final int O = 111;
    public static final long OBJECT_NUMBER_THRESHOLD = 10000000000L;
    public static final String PROP_PUSHBACK_SIZE = "org.apache.pdfbox.baseParser.pushBackSize";
    public static final int R = 114;
    public static final int S = 115;
    public static final String STREAM_STRING = "stream";
    public static final int STRMBUFLEN = 2048;
    public static final int T = 116;
    public static final String TRUE = "true";
    public COSDocument document;
    public PushBackInputStream pdfSource;
    public final byte[] strmBuf;

    public BaseParser() {
        this.strmBuf = new byte[2048];
    }

    private int checkForMissingCloseParen(int i) throws IOException {
        byte[] bArr = new byte[3];
        int read = this.pdfSource.read(bArr);
        if ((read == 3 && bArr[0] == 13 && bArr[1] == 10 && bArr[2] == 47) || (bArr[0] == 13 && bArr[1] == 47)) {
            i = 0;
        }
        if (read > 0) {
            this.pdfSource.unread(bArr, 0, read);
        }
        return i;
    }

    private boolean isCR(int i) {
        return 13 == i;
    }

    public static boolean isHexDigit(char c2) {
        return (c2 >= '0' && c2 <= '9') || (c2 >= 'a' && c2 <= 'f') || (c2 >= 'A' && c2 <= 'F');
    }

    private boolean isLF(int i) {
        return 10 == i;
    }

    private COSBase parseCOSDictionaryValue() throws IOException {
        long offset = this.pdfSource.getOffset();
        COSBase parseDirObject = parseDirObject();
        skipSpaces();
        char peek = (char) this.pdfSource.peek();
        if (peek < '0' || peek > '9') {
            return parseDirObject;
        }
        long offset2 = this.pdfSource.getOffset();
        COSBase parseDirObject2 = parseDirObject();
        skipSpaces();
        readExpectedChar('R');
        if (!(parseDirObject instanceof COSInteger)) {
            throw new IOException("expected number, actual=" + parseDirObject + " at offset " + offset);
        } else if (parseDirObject2 instanceof COSInteger) {
            return this.document.getObjectFromPool(new COSObjectKey(((COSInteger) parseDirObject).longValue(), ((COSInteger) parseDirObject2).intValue()));
        } else {
            throw new IOException("expected number, actual=" + parseDirObject + " at offset " + offset2);
        }
    }

    private COSString parseCOSHexString() throws IOException {
        int read;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read2 = this.pdfSource.read();
            char c2 = (char) read2;
            if (!isHexDigit(c2)) {
                if (read2 == 62) {
                    break;
                } else if (read2 < 0) {
                    throw new IOException("Missing closing bracket for hex string. Reached EOS.");
                } else if (!(read2 == 32 || read2 == 10 || read2 == 9 || read2 == 13 || read2 == 8 || read2 == 12)) {
                    if (sb.length() % 2 != 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    do {
                        read = this.pdfSource.read();
                        if (read == 62) {
                            break;
                        }
                    } while (read >= 0);
                    if (read < 0) {
                        throw new IOException("Missing closing bracket for hex string. Reached EOS.");
                    }
                }
            } else {
                sb.append(c2);
            }
        }
        return COSString.parseHex(sb.toString());
    }

    public void close() throws IOException {
        PushBackInputStream pushBackInputStream = this.pdfSource;
        if (pushBackInputStream != null) {
            pushBackInputStream.close();
        }
    }

    public final COSStream createCOSStream(COSDictionary cOSDictionary) {
        COSDocument cOSDocument = this.document;
        if (cOSDocument != null) {
            return cOSDocument.createCOSStream(cOSDictionary);
        }
        return null;
    }

    public boolean isClosing() throws IOException {
        return isClosing(this.pdfSource.peek());
    }

    public boolean isClosing(int i) {
        return i == 93;
    }

    public boolean isDigit() throws IOException {
        return isDigit(this.pdfSource.peek());
    }

    public boolean isDigit(int i) {
        return i >= 48 && i <= 57;
    }

    public boolean isEOL() throws IOException {
        return isEOL(this.pdfSource.peek());
    }

    public boolean isEndOfName(char c2) {
        return c2 == ' ' || c2 == 13 || c2 == 10 || c2 == 9 || c2 == '>' || c2 == '<' || c2 == '[' || c2 == '/' || c2 == ']' || c2 == ')' || c2 == '(';
    }

    public boolean isSpace() throws IOException {
        return isSpace(this.pdfSource.peek());
    }

    public boolean isSpace(int i) {
        return 32 == i;
    }

    public boolean isString(byte[] bArr) throws IOException {
        if (this.pdfSource.peek() != bArr[0]) {
            return false;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int read = this.pdfSource.read(bArr2, 0, length);
        while (read < length) {
            int read2 = this.pdfSource.read(bArr2, read, length - read);
            if (read2 < 0) {
                break;
            }
            read += read2;
        }
        boolean equals = Arrays.equals(bArr, bArr2);
        this.pdfSource.unread(bArr2, 0, read);
        return equals;
    }

    public boolean isWhitespace() throws IOException {
        return isWhitespace(this.pdfSource.peek());
    }

    public boolean isWhitespace(int i) {
        return i == 0 || i == 9 || i == 12 || i == 10 || i == 13 || i == 32;
    }

    public COSBoolean parseBoolean() throws IOException {
        char peek = (char) this.pdfSource.peek();
        if (peek == 't') {
            String str = new String(this.pdfSource.readFully(4), "ISO-8859-1");
            if (str.equals(TRUE)) {
                return COSBoolean.TRUE;
            }
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("Error parsing boolean: expected='true' actual='", str, "' at offset ");
            outline80.append(this.pdfSource.getOffset());
            throw new IOException(outline80.toString());
        } else if (peek == 'f') {
            String str2 = new String(this.pdfSource.readFully(5), "ISO-8859-1");
            if (str2.equals(FALSE)) {
                return COSBoolean.FALSE;
            }
            StringBuilder outline802 = GeneratedOutlineSupport.outline80("Error parsing boolean: expected='true' actual='", str2, "' at offset ");
            outline802.append(this.pdfSource.getOffset());
            throw new IOException(outline802.toString());
        } else {
            throw new IOException("Error parsing boolean expected='t or f' actual='" + peek + "' at offset " + this.pdfSource.getOffset());
        }
    }

    public COSArray parseCOSArray() throws IOException {
        readExpectedChar('[');
        COSArray cOSArray = new COSArray();
        skipSpaces();
        while (true) {
            int peek = this.pdfSource.peek();
            if (peek <= 0 || ((char) peek) == ']') {
                this.pdfSource.read();
                skipSpaces();
            } else {
                COSBase parseDirObject = parseDirObject();
                if (parseDirObject instanceof COSObject) {
                    if (cOSArray.get(cOSArray.size() - 1) instanceof COSInteger) {
                        COSInteger cOSInteger = (COSInteger) cOSArray.remove(cOSArray.size() - 1);
                        if (cOSArray.get(cOSArray.size() - 1) instanceof COSInteger) {
                            parseDirObject = this.document.getObjectFromPool(new COSObjectKey(((COSInteger) cOSArray.remove(cOSArray.size() - 1)).longValue(), cOSInteger.intValue()));
                        }
                    }
                    parseDirObject = null;
                }
                if (parseDirObject != null) {
                    cOSArray.add(parseDirObject);
                } else {
                    this.pdfSource.getOffset();
                    String readString = readString();
                    this.pdfSource.unread(readString.getBytes("ISO-8859-1"));
                    if (ENDOBJ_STRING.equals(readString) || ENDSTREAM_STRING.equals(readString)) {
                        return cOSArray;
                    }
                }
                skipSpaces();
            }
        }
        this.pdfSource.read();
        skipSpaces();
        return cOSArray;
    }

    public COSDictionary parseCOSDictionary() throws IOException {
        readExpectedChar('<');
        readExpectedChar('<');
        skipSpaces();
        COSDictionary cOSDictionary = new COSDictionary();
        boolean z = false;
        while (!z) {
            skipSpaces();
            char peek = (char) this.pdfSource.peek();
            if (peek == '>') {
                z = true;
            } else if (peek != '/') {
                int read = this.pdfSource.read();
                while (read != -1 && read != 47 && read != 62) {
                    if (read == 101 && this.pdfSource.read() == 110) {
                        int read2 = this.pdfSource.read();
                        if (read2 != 100) {
                            continue;
                        } else {
                            boolean z2 = read2 == 115 && this.pdfSource.read() == 116 && this.pdfSource.read() == 114 && this.pdfSource.read() == 101 && this.pdfSource.read() == 97 && this.pdfSource.read() == 109;
                            boolean z3 = !z2 && read2 == 111 && this.pdfSource.read() == 98 && this.pdfSource.read() == 106;
                            if (z2 || z3) {
                                return cOSDictionary;
                            }
                        }
                    }
                    read = this.pdfSource.read();
                }
                if (read == -1) {
                    return cOSDictionary;
                }
                this.pdfSource.unread(read);
            } else {
                COSName parseCOSName = parseCOSName();
                COSBase parseCOSDictionaryValue = parseCOSDictionaryValue();
                skipSpaces();
                if (((char) this.pdfSource.peek()) == 'd') {
                    String readString = readString();
                    if (!readString.equals(DEF)) {
                        this.pdfSource.unread(readString.getBytes("ISO-8859-1"));
                    } else {
                        skipSpaces();
                    }
                }
                if (parseCOSDictionaryValue == null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bad Dictionary Declaration ");
                    outline73.append(this.pdfSource);
                    outline73.toString();
                } else {
                    parseCOSDictionaryValue.setDirect(true);
                    cOSDictionary.setItem(parseCOSName, parseCOSDictionaryValue);
                }
            }
        }
        readExpectedChar('>');
        readExpectedChar('>');
        return cOSDictionary;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [int] */
    /* JADX WARNING: type inference failed for: r1v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v5, types: [int] */
    /* JADX WARNING: type inference failed for: r1v8, types: [char] */
    /* JADX WARNING: type inference failed for: r1v12, types: [int] */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v3
      assigns: []
      uses: []
      mth insns count: 50
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.pdfbox.cos.COSName parseCOSName() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 47
            r5.readExpectedChar(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            org.apache.pdfbox.io.PushBackInputStream r1 = r5.pdfSource
            int r1 = r1.read()
        L_0x0010:
            r2 = -1
            if (r1 == r2) goto L_0x0080
            char r3 = (char) r1
            r4 = 35
            if (r3 != r4) goto L_0x006f
            org.apache.pdfbox.io.PushBackInputStream r1 = r5.pdfSource
            int r1 = r1.read()
            char r1 = (char) r1
            org.apache.pdfbox.io.PushBackInputStream r2 = r5.pdfSource
            int r2 = r2.read()
            char r2 = (char) r2
            boolean r4 = isHexDigit(r1)
            if (r4 == 0) goto L_0x0066
            boolean r4 = isHexDigit(r2)
            if (r4 == 0) goto L_0x0066
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ""
            r3.append(r4)
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            r2 = 16
            int r2 = java.lang.Integer.parseInt(r1, r2)     // Catch:{ NumberFormatException -> 0x0057 }
            char r2 = (char) r2     // Catch:{ NumberFormatException -> 0x0057 }
            r0.append(r2)     // Catch:{ NumberFormatException -> 0x0057 }
            org.apache.pdfbox.io.PushBackInputStream r1 = r5.pdfSource
            int r1 = r1.read()
            goto L_0x0010
        L_0x0057:
            r0 = move-exception
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Error: expected hex number, actual='"
            java.lang.String r4 = "'"
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r3, r1, r4)
            r2.<init>(r1, r0)
            throw r2
        L_0x0066:
            org.apache.pdfbox.io.PushBackInputStream r4 = r5.pdfSource
            r4.unread(r2)
            r0.append(r3)
            goto L_0x0010
        L_0x006f:
            boolean r4 = r5.isEndOfName(r3)
            if (r4 == 0) goto L_0x0076
            goto L_0x0080
        L_0x0076:
            r0.append(r3)
            org.apache.pdfbox.io.PushBackInputStream r1 = r5.pdfSource
            int r1 = r1.read()
            goto L_0x0010
        L_0x0080:
            if (r1 == r2) goto L_0x0087
            org.apache.pdfbox.io.PushBackInputStream r2 = r5.pdfSource
            r2.unread(r1)
        L_0x0087:
            java.lang.String r0 = r0.toString()
            org.apache.pdfbox.cos.COSName r0 = org.apache.pdfbox.cos.COSName.getPDFName(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.BaseParser.parseCOSName():org.apache.pdfbox.cos.COSName");
    }

    public COSStream parseCOSStream(COSDictionary cOSDictionary) throws IOException {
        boolean z;
        ByteArrayOutputStream byteArrayOutputStream;
        COSStream createCOSStream = createCOSStream(cOSDictionary);
        OutputStream outputStream = null;
        try {
            readExpectedString(STREAM_STRING);
            int read = this.pdfSource.read();
            while (32 == read) {
                read = this.pdfSource.read();
            }
            if (13 == read) {
                int read2 = this.pdfSource.read();
                if (10 != read2) {
                    this.pdfSource.unread(read2);
                }
            } else if (10 != read) {
                this.pdfSource.unread(read);
            }
            COSBase item = cOSDictionary.getItem(COSName.LENGTH);
            outputStream = createCOSStream.createFilteredStream(item);
            int intValue = item instanceof COSNumber ? ((COSNumber) item).intValue() : -1;
            if (intValue == -1) {
                readUntilEndStream(new EndstreamOutputStream(outputStream));
            } else {
                int i = intValue;
                while (true) {
                    if (i <= 0) {
                        break;
                    }
                    int read3 = this.pdfSource.read(this.strmBuf, 0, Math.min(i, 2048));
                    if (read3 == -1) {
                        break;
                    }
                    outputStream.write(this.strmBuf, 0, read3);
                    i -= read3;
                }
                int read4 = this.pdfSource.read(this.strmBuf, 0, 20);
                if (read4 > 0) {
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        if (i2 >= read4) {
                            break;
                        }
                        byte b2 = this.strmBuf[i2] & 255;
                        if (b2 == ENDSTREAM[i3]) {
                            i3++;
                            if (i3 >= ENDSTREAM.length) {
                                z = true;
                                break;
                            }
                        } else if (i3 > 0) {
                            break;
                        } else if (!isWhitespace(b2)) {
                            break;
                        }
                        i2++;
                    }
                    z = false;
                    this.pdfSource.unread(this.strmBuf, 0, read4);
                    if (!z) {
                        outputStream.flush();
                        InputStream filteredStream = createCOSStream.getFilteredStream();
                        byteArrayOutputStream = new ByteArrayOutputStream(intValue);
                        IOUtils.copy(filteredStream, byteArrayOutputStream);
                        IOUtils.closeQuietly(filteredStream);
                        this.pdfSource.unread(byteArrayOutputStream.toByteArray());
                        IOUtils.closeQuietly(outputStream);
                        outputStream = createCOSStream.createFilteredStream();
                        readUntilEndStream(new EndstreamOutputStream(outputStream));
                    }
                }
            }
            skipSpaces();
            String readString = readString();
            if (!readString.equals(ENDSTREAM_STRING)) {
                if (readString.startsWith(ENDOBJ_STRING)) {
                    this.pdfSource.unread(readString.getBytes("ISO-8859-1"));
                } else if (readString.startsWith(ENDSTREAM_STRING)) {
                    this.pdfSource.unread(readString.substring(9, readString.length()).getBytes("ISO-8859-1"));
                } else {
                    readUntilEndStream(new EndstreamOutputStream(outputStream));
                    readExpectedString(ENDSTREAM_STRING);
                }
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return createCOSStream;
        } catch (IOException e2) {
            throw new IOException("Could not push back " + byteArrayOutputStream.size() + " bytes in order to reparse stream. Try increasing push back buffer using system property " + PROP_PUSHBACK_SIZE, e2);
        } catch (Throwable th) {
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0017 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.pdfbox.cos.COSString parseCOSString() throws java.io.IOException {
        /*
            r11 = this;
            org.apache.pdfbox.io.PushBackInputStream r0 = r11.pdfSource
            int r0 = r0.read()
            char r0 = (char) r0
            r1 = 40
            if (r0 != r1) goto L_0x0129
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            org.apache.pdfbox.io.PushBackInputStream r2 = r11.pdfSource
            int r2 = r2.read()
            r3 = 1
        L_0x0017:
            r4 = -1
            if (r3 <= 0) goto L_0x0118
            if (r2 == r4) goto L_0x0118
            char r2 = (char) r2
            r5 = -2
            r6 = 41
            if (r2 != r6) goto L_0x0030
            int r3 = r3 + -1
            int r3 = r11.checkForMissingCloseParen(r3)
            if (r3 == 0) goto L_0x002d
            r0.write(r2)
        L_0x002d:
            r2 = -2
            goto L_0x010c
        L_0x0030:
            if (r2 != r1) goto L_0x0038
            int r3 = r3 + 1
            r0.write(r2)
            goto L_0x002d
        L_0x0038:
            r7 = 92
            if (r2 != r7) goto L_0x0107
            org.apache.pdfbox.io.PushBackInputStream r2 = r11.pdfSource
            int r2 = r2.read()
            char r2 = (char) r2
            r8 = 10
            if (r2 == r8) goto L_0x00f2
            r9 = 13
            if (r2 == r9) goto L_0x00f2
            if (r2 == r7) goto L_0x00ed
            r4 = 98
            r10 = 8
            if (r2 == r4) goto L_0x00e8
            r4 = 102(0x66, float:1.43E-43)
            if (r2 == r4) goto L_0x00e1
            r4 = 110(0x6e, float:1.54E-43)
            if (r2 == r4) goto L_0x00dc
            r4 = 114(0x72, float:1.6E-43)
            if (r2 == r4) goto L_0x00d7
            r4 = 116(0x74, float:1.63E-43)
            if (r2 == r4) goto L_0x00d0
            if (r2 == r1) goto L_0x00ed
            if (r2 == r6) goto L_0x00c0
            switch(r2) {
                case 48: goto L_0x006e;
                case 49: goto L_0x006e;
                case 50: goto L_0x006e;
                case 51: goto L_0x006e;
                case 52: goto L_0x006e;
                case 53: goto L_0x006e;
                case 54: goto L_0x006e;
                case 55: goto L_0x006e;
                default: goto L_0x006a;
            }
        L_0x006a:
            r0.write(r2)
            goto L_0x002d
        L_0x006e:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            r4.append(r2)
            org.apache.pdfbox.io.PushBackInputStream r2 = r11.pdfSource
            int r2 = r2.read()
            char r6 = (char) r2
            r7 = 48
            if (r6 < r7) goto L_0x0097
            r8 = 55
            if (r6 > r8) goto L_0x0097
            r4.append(r6)
            org.apache.pdfbox.io.PushBackInputStream r2 = r11.pdfSource
            int r2 = r2.read()
            char r6 = (char) r2
            if (r6 < r7) goto L_0x0097
            if (r6 > r8) goto L_0x0097
            r4.append(r6)
            r2 = -2
        L_0x0097:
            java.lang.String r6 = r4.toString()     // Catch:{ NumberFormatException -> 0x00a3 }
            int r4 = java.lang.Integer.parseInt(r6, r10)     // Catch:{ NumberFormatException -> 0x00a3 }
            r0.write(r4)
            goto L_0x010c
        L_0x00a3:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error: Expected octal character, actual='"
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = "'"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00c0:
            int r3 = r11.checkForMissingCloseParen(r3)
            if (r3 == 0) goto L_0x00cb
            r0.write(r2)
            goto L_0x002d
        L_0x00cb:
            r0.write(r7)
            goto L_0x002d
        L_0x00d0:
            r2 = 9
            r0.write(r2)
            goto L_0x002d
        L_0x00d7:
            r0.write(r9)
            goto L_0x002d
        L_0x00dc:
            r0.write(r8)
            goto L_0x002d
        L_0x00e1:
            r2 = 12
            r0.write(r2)
            goto L_0x002d
        L_0x00e8:
            r0.write(r10)
            goto L_0x002d
        L_0x00ed:
            r0.write(r2)
            goto L_0x002d
        L_0x00f2:
            org.apache.pdfbox.io.PushBackInputStream r2 = r11.pdfSource
            int r2 = r2.read()
        L_0x00f8:
            boolean r6 = r11.isEOL(r2)
            if (r6 == 0) goto L_0x010c
            if (r2 == r4) goto L_0x010c
            org.apache.pdfbox.io.PushBackInputStream r2 = r11.pdfSource
            int r2 = r2.read()
            goto L_0x00f8
        L_0x0107:
            r0.write(r2)
            goto L_0x002d
        L_0x010c:
            if (r2 == r5) goto L_0x0110
            goto L_0x0017
        L_0x0110:
            org.apache.pdfbox.io.PushBackInputStream r2 = r11.pdfSource
            int r2 = r2.read()
            goto L_0x0017
        L_0x0118:
            if (r2 == r4) goto L_0x011f
            org.apache.pdfbox.io.PushBackInputStream r1 = r11.pdfSource
            r1.unread(r2)
        L_0x011f:
            org.apache.pdfbox.cos.COSString r1 = new org.apache.pdfbox.cos.COSString
            byte[] r0 = r0.toByteArray()
            r1.<init>(r0)
            return r1
        L_0x0129:
            r1 = 60
            if (r0 != r1) goto L_0x0132
            org.apache.pdfbox.cos.COSString r0 = r11.parseCOSHexString()
            return r0
        L_0x0132:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "parseCOSString string should start with '(' or '<' and not '"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "' "
            r2.append(r0)
            org.apache.pdfbox.io.PushBackInputStream r0 = r11.pdfSource
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.BaseParser.parseCOSString():org.apache.pdfbox.cos.COSString");
    }

    public COSBase parseDirObject() throws IOException {
        skipSpaces();
        char peek = (char) this.pdfSource.peek();
        COSBase cOSBase = null;
        if (peek == '(') {
            cOSBase = parseCOSString();
        } else if (peek == '/') {
            cOSBase = parseCOSName();
        } else if (peek == '<') {
            int read = this.pdfSource.read();
            char peek2 = (char) this.pdfSource.peek();
            this.pdfSource.unread(read);
            if (peek2 == '<') {
                cOSBase = parseCOSDictionary();
                skipSpaces();
            } else {
                cOSBase = parseCOSString();
            }
        } else if (peek == 'R') {
            this.pdfSource.read();
            cOSBase = new COSObject(null);
        } else if (peek == '[') {
            cOSBase = parseCOSArray();
        } else if (peek == 'f') {
            String str = new String(this.pdfSource.readFully(5), "ISO-8859-1");
            if (str.equals(FALSE)) {
                cOSBase = COSBoolean.FALSE;
            } else {
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("expected false actual='", str, "' ");
                outline80.append(this.pdfSource);
                throw new IOException(outline80.toString());
            }
        } else if (peek == 'n') {
            readExpectedString("null");
            cOSBase = COSNull.NULL;
        } else if (peek == 't') {
            String str2 = new String(this.pdfSource.readFully(4), "ISO-8859-1");
            if (str2.equals(TRUE)) {
                cOSBase = COSBoolean.TRUE;
            } else {
                StringBuilder outline802 = GeneratedOutlineSupport.outline80("expected true actual='", str2, "' ");
                outline802.append(this.pdfSource);
                throw new IOException(outline802.toString());
            }
        } else if (peek == 65535) {
            return null;
        } else {
            if (Character.isDigit(peek) || peek == '-' || peek == '+' || peek == '.') {
                StringBuilder sb = new StringBuilder();
                int read2 = this.pdfSource.read();
                while (true) {
                    char c2 = (char) read2;
                    if (!Character.isDigit(c2) && c2 != '-' && c2 != '+' && c2 != '.' && c2 != 'E' && c2 != 'e') {
                        break;
                    }
                    sb.append(c2);
                    read2 = this.pdfSource.read();
                }
                if (read2 != -1) {
                    this.pdfSource.unread(read2);
                }
                cOSBase = COSNumber.get(sb.toString());
            } else {
                String readString = readString();
                if (readString == null || readString.length() == 0) {
                    int peek3 = this.pdfSource.peek();
                    throw new IOException("Unknown dir object c='" + peek + "' cInt=" + peek + " peek='" + ((char) peek3) + "' peekInt=" + peek3 + CMap.SPACE + this.pdfSource.getOffset());
                } else if (ENDOBJ_STRING.equals(readString) || ENDSTREAM_STRING.equals(readString)) {
                    this.pdfSource.unread(readString.getBytes("ISO-8859-1"));
                }
            }
        }
        return cOSBase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.pdfbox.cos.COSObjectKey parseObjectKey(boolean r6) throws java.io.IOException {
        /*
            r5 = this;
            r0 = -1
            r2 = 0
            org.apache.pdfbox.io.PushBackInputStream r3 = r5.pdfSource     // Catch:{ IOException -> 0x0016 }
            int r3 = r3.peek()     // Catch:{ IOException -> 0x0016 }
            char r3 = (char) r3     // Catch:{ IOException -> 0x0016 }
            r4 = 60
            if (r3 != r4) goto L_0x0011
            r2 = 1
            r3 = r0
            goto L_0x001b
        L_0x0011:
            int r3 = r5.readObjectNumber()     // Catch:{ IOException -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            int r3 = r5.readObjectNumber()
        L_0x001a:
            long r3 = (long) r3
        L_0x001b:
            if (r2 != 0) goto L_0x0056
            r5.skipSpaces()
            int r0 = r5.readGenerationNumber()
            r1 = 3
            java.lang.String r1 = r5.readString(r1)
            java.lang.String r2 = "obj"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0053
            if (r6 == 0) goto L_0x0053
            java.lang.String r6 = "o"
            boolean r6 = r1.equals(r6)
            if (r6 != 0) goto L_0x003c
            goto L_0x0053
        L_0x003c:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r0 = "expected='obj' actual='"
            java.lang.String r2 = "' "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r0, r1, r2)
            org.apache.pdfbox.io.PushBackInputStream r1 = r5.pdfSource
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0053:
            r6 = r0
            r0 = r3
            goto L_0x0057
        L_0x0056:
            r6 = -1
        L_0x0057:
            org.apache.pdfbox.cos.COSObjectKey r2 = new org.apache.pdfbox.cos.COSObjectKey
            r2.<init>(r0, r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.BaseParser.parseObjectKey(boolean):org.apache.pdfbox.cos.COSObjectKey");
    }

    public void readExpectedChar(char c2) throws IOException {
        char read = (char) this.pdfSource.read();
        if (read != c2) {
            throw new IOException("expected='" + c2 + "' actual='" + read + "' at offset " + this.pdfSource.getOffset());
        }
    }

    public void readExpectedString(String str) throws IOException {
        readExpectedString(str.toCharArray(), false);
    }

    public int readGenerationNumber() throws IOException {
        int readInt = readInt();
        if (readInt >= 0 && ((long) readInt) <= 65535) {
            return readInt;
        }
        throw new IOException(GeneratedOutlineSupport.outline42("Generation Number '", readInt, "' has more than 5 digits"));
    }

    public int readInt() throws IOException {
        skipSpaces();
        StringBuilder readStringNumber = readStringNumber();
        try {
            return Integer.parseInt(readStringNumber.toString());
        } catch (NumberFormatException e2) {
            this.pdfSource.unread(readStringNumber.toString().getBytes("ISO-8859-1"));
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error: Expected an integer type at offset ");
            outline73.append(this.pdfSource.getOffset());
            throw new IOException(outline73.toString(), e2);
        }
    }

    public String readLine() throws IOException {
        int read;
        if (!this.pdfSource.isEOF()) {
            StringBuilder sb = new StringBuilder(11);
            while (true) {
                read = this.pdfSource.read();
                if (read != -1 && !isEOL(read)) {
                    sb.append((char) read);
                }
            }
            if (isCR(read) && isLF(this.pdfSource.peek())) {
                this.pdfSource.read();
            }
            return sb.toString();
        }
        throw new IOException("Error: End-of-File, expected line");
    }

    public long readLong() throws IOException {
        skipSpaces();
        StringBuilder readStringNumber = readStringNumber();
        try {
            return Long.parseLong(readStringNumber.toString());
        } catch (NumberFormatException e2) {
            this.pdfSource.unread(readStringNumber.toString().getBytes("ISO-8859-1"));
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error: Expected a long type at offset ");
            outline73.append(this.pdfSource.getOffset());
            outline73.append(", instead got '");
            outline73.append(readStringNumber);
            outline73.append("'");
            throw new IOException(outline73.toString(), e2);
        }
    }

    public int readObjectNumber() throws IOException {
        int readInt = readInt();
        if (readInt >= 0 && ((long) readInt) < 10000000000L) {
            return readInt;
        }
        throw new IOException(GeneratedOutlineSupport.outline42("Object Number '", readInt, "' has more than 10 digits or is negative"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String readString() throws java.io.IOException {
        /*
            r5 = this;
            r5.skipSpaces()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            org.apache.pdfbox.io.PushBackInputStream r1 = r5.pdfSource
            int r1 = r1.read()
        L_0x000e:
            char r2 = (char) r1
            boolean r3 = r5.isEndOfName(r2)
            r4 = -1
            if (r3 != 0) goto L_0x0022
            if (r1 == r4) goto L_0x0022
            r0.append(r2)
            org.apache.pdfbox.io.PushBackInputStream r1 = r5.pdfSource
            int r1 = r1.read()
            goto L_0x000e
        L_0x0022:
            if (r1 == r4) goto L_0x0029
            org.apache.pdfbox.io.PushBackInputStream r2 = r5.pdfSource
            r2.unread(r1)
        L_0x0029:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.BaseParser.readString():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.StringBuilder readStringNumber() throws java.io.IOException {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            org.apache.pdfbox.io.PushBackInputStream r1 = r4.pdfSource
            int r1 = r1.read()
            r2 = 32
            r3 = -1
            if (r1 == r2) goto L_0x002d
            r2 = 10
            if (r1 == r2) goto L_0x002d
            r2 = 13
            if (r1 == r2) goto L_0x002d
            r2 = 60
            if (r1 == r2) goto L_0x002d
            r2 = 91
            if (r1 == r2) goto L_0x002d
            r2 = 40
            if (r1 == r2) goto L_0x002d
            if (r1 == 0) goto L_0x002d
            if (r1 == r3) goto L_0x002d
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0005
        L_0x002d:
            if (r1 == r3) goto L_0x0034
            org.apache.pdfbox.io.PushBackInputStream r2 = r4.pdfSource
            r2.unread(r1)
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.BaseParser.readStringNumber():java.lang.StringBuilder");
    }

    public void readUntilEndStream(OutputStream outputStream) throws IOException {
        byte[] bArr = ENDSTREAM;
        int i = 0;
        while (true) {
            int read = this.pdfSource.read(this.strmBuf, i, 2048 - i);
            if (read <= 0) {
                break;
            }
            int i2 = read + i;
            int i3 = i2 - 5;
            int i4 = i;
            while (true) {
                if (i >= i2) {
                    break;
                }
                if (i4 == 0) {
                    int i5 = i + 5;
                    if (i5 < i3) {
                        byte b2 = this.strmBuf[i5];
                        if (b2 > 116 || b2 < 97) {
                            i = i5;
                            i++;
                        }
                    }
                }
                byte b3 = this.strmBuf[i];
                if (b3 == bArr[i4]) {
                    i4++;
                    if (i4 == bArr.length) {
                        i++;
                        break;
                    }
                } else {
                    if (i4 == 3) {
                        bArr = ENDOBJ;
                        if (b3 == bArr[i4]) {
                            i4++;
                        }
                    }
                    i4 = b3 == 101 ? 1 : (b3 == 110 && i4 == 7) ? 2 : 0;
                    bArr = ENDSTREAM;
                }
                i++;
            }
            int max = Math.max(0, i - i4);
            if (max > 0) {
                outputStream.write(this.strmBuf, 0, max);
            }
            if (i4 == bArr.length) {
                this.pdfSource.unread(this.strmBuf, max, i2 - max);
                break;
            } else {
                System.arraycopy(bArr, 0, this.strmBuf, 0, i4);
                i = i4;
            }
        }
        outputStream.flush();
    }

    public void skipSpaces() throws IOException {
        int read = this.pdfSource.read();
        while (true) {
            if (!isWhitespace(read) && read != 37) {
                break;
            } else if (read == 37) {
                read = this.pdfSource.read();
                while (!isEOL(read) && read != -1) {
                    read = this.pdfSource.read();
                }
            } else {
                read = this.pdfSource.read();
            }
        }
        if (read != -1) {
            this.pdfSource.unread(read);
        }
    }

    public void skipToNextObj() throws IOException {
        byte[] bArr = new byte[16];
        Pattern compile = Pattern.compile("\\d+\\s+\\d+\\s+obj.*", 32);
        while (!this.pdfSource.isEOF()) {
            int read = this.pdfSource.read(bArr);
            if (read >= 1) {
                String str = new String(bArr, "US-ASCII");
                if (str.startsWith("trailer") || str.startsWith("xref") || str.startsWith("startxref") || str.startsWith(STREAM_STRING) || compile.matcher(str).matches()) {
                    this.pdfSource.unread(bArr);
                    return;
                }
                this.pdfSource.unread(bArr, 1, read - 1);
            } else {
                return;
            }
        }
    }

    public boolean isEOL(int i) {
        return isLF(i) || isCR(i);
    }

    public final void readExpectedString(char[] cArr, boolean z) throws IOException {
        skipSpaces();
        int length = cArr.length;
        int i = 0;
        while (i < length) {
            char c2 = cArr[i];
            if (this.pdfSource.read() == c2) {
                i++;
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected string '");
                outline73.append(new String(cArr));
                outline73.append("' but missed at character '");
                outline73.append(c2);
                outline73.append("' at offset ");
                outline73.append(this.pdfSource.getOffset());
                throw new IOException(outline73.toString());
            }
        }
        skipSpaces();
    }

    public BaseParser(InputStream inputStream) throws IOException {
        this.strmBuf = new byte[2048];
        int i = 65536;
        try {
            i = Integer.getInteger(PROP_PUSHBACK_SIZE, 65536).intValue();
        } catch (SecurityException unused) {
        }
        this.pdfSource = new PushBackInputStream(new BufferedInputStream(inputStream, 16384), i);
    }

    public BaseParser(byte[] bArr) throws IOException {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    public boolean isString(char[] cArr) throws IOException {
        long offset = this.pdfSource.getOffset();
        boolean z = true;
        for (char c2 : cArr) {
            if (this.pdfSource.read() != c2) {
                z = false;
            }
        }
        this.pdfSource.seek(offset);
        return z;
    }

    public String readString(int i) throws IOException {
        skipSpaces();
        int read = this.pdfSource.read();
        StringBuilder sb = new StringBuilder(i);
        while (!isWhitespace(read) && !isClosing(read) && read != -1 && sb.length() < i && read != 91 && read != 60 && read != 40 && read != 47) {
            sb.append((char) read);
            read = this.pdfSource.read();
        }
        if (read != -1) {
            this.pdfSource.unread(read);
        }
        return sb.toString();
    }
}
