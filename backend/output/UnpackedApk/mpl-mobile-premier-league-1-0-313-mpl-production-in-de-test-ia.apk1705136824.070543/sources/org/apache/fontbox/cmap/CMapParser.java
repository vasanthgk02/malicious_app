package org.apache.fontbox.cmap;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.URL;
import java.util.List;
import org.apache.commons.lang.CharEncoding;
import org.apache.pdfbox.util.PDFBoxResourceLoader;

public class CMapParser {
    public static final String MARK_END_OF_ARRAY = "]";
    public static final String MARK_END_OF_DICTIONARY = ">>";
    public final byte[] tokenParserByteBuffer = new byte[512];

    public final class LiteralName {
        public String name;

        public LiteralName(String str) {
            this.name = str;
        }
    }

    public final class Operator {
        public String op;

        public Operator(String str) {
            this.op = str;
        }
    }

    public static int compare(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            if (bArr[i] == bArr2[i]) {
                i++;
            } else if ((bArr[i] + 256) % 256 < (bArr2[i] + 256) % 256) {
                return -1;
            } else {
                return 1;
            }
        }
        return 1;
    }

    public static int createIntFromBytes(byte[] bArr) {
        int i = (bArr[0] + 256) % 256;
        return bArr.length == 2 ? (i << 8) + ((bArr[1] + 256) % 256) : i;
    }

    public static String createStringFromBytes(byte[] bArr) throws IOException {
        if (bArr.length == 1) {
            return new String(bArr, "ISO-8859-1");
        }
        return new String(bArr, CharEncoding.UTF_16BE);
    }

    private void increment(byte[] bArr) {
        increment(bArr, bArr.length - 1);
    }

    public static boolean isDelimiter(int i) {
        return i == 37 || i == 47 || i == 60 || i == 62 || i == 91 || i == 93 || i == 123 || i == 125 || i == 40 || i == 41;
    }

    public static boolean isWhitespaceOrEOF(int i) {
        return i == -1 || i == 32 || i == 13 || i == 10;
    }

    private void parseBeginbfchar(Object obj, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        Number number = (Number) obj;
        for (int i = 0; i < number.intValue(); i++) {
            Object parseNextToken = parseNextToken(pushbackInputStream);
            if (parseNextToken instanceof Operator) {
                Operator operator = (Operator) parseNextToken;
                if (!operator.op.equals("endbfchar")) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error : ~bfchar contains an unexpected operator : ");
                    outline73.append(operator.op);
                    throw new IOException(outline73.toString());
                }
                return;
            }
            byte[] bArr = (byte[]) parseNextToken;
            Object parseNextToken2 = parseNextToken(pushbackInputStream);
            if (parseNextToken2 instanceof byte[]) {
                cMap.addCharMapping(bArr, createStringFromBytes((byte[]) parseNextToken2));
            } else if (parseNextToken2 instanceof LiteralName) {
                cMap.addCharMapping(bArr, ((LiteralName) parseNextToken2).name);
            } else {
                throw new IOException(GeneratedOutlineSupport.outline48("Error parsing CMap beginbfchar, expected{COSString or COSName} and not ", parseNextToken2));
            }
        }
    }

    private void parseBeginbfrange(Object obj, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        byte[] bArr;
        Number number = (Number) obj;
        for (int i = 0; i < number.intValue(); i++) {
            Object parseNextToken = parseNextToken(pushbackInputStream);
            if (parseNextToken instanceof Operator) {
                Operator operator = (Operator) parseNextToken;
                if (!operator.op.equals("endbfrange")) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error : ~bfrange contains an unexpected operator : ");
                    outline73.append(operator.op);
                    throw new IOException(outline73.toString());
                }
                return;
            }
            byte[] bArr2 = (byte[]) parseNextToken;
            byte[] bArr3 = (byte[]) parseNextToken(pushbackInputStream);
            Object parseNextToken2 = parseNextToken(pushbackInputStream);
            List list = null;
            if (parseNextToken2 instanceof List) {
                list = (List) parseNextToken2;
                bArr = (byte[]) list.get(0);
            } else {
                bArr = (byte[]) parseNextToken2;
            }
            boolean z = false;
            int i2 = 0;
            while (!z) {
                if (compare(bArr2, bArr3) >= 0) {
                    z = true;
                }
                cMap.addCharMapping(bArr2, createStringFromBytes(bArr));
                increment(bArr2);
                if (list == null) {
                    increment(bArr);
                } else {
                    i2++;
                    if (i2 < list.size()) {
                        bArr = (byte[]) list.get(i2);
                    }
                }
            }
        }
    }

    private void parseBegincidchar(Object obj, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        Number number = (Number) obj;
        for (int i = 0; i < number.intValue(); i++) {
            Object parseNextToken = parseNextToken(pushbackInputStream);
            if (parseNextToken instanceof Operator) {
                Operator operator = (Operator) parseNextToken;
                if (!operator.op.equals("endcidchar")) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error : ~cidchar contains an unexpected operator : ");
                    outline73.append(operator.op);
                    throw new IOException(outline73.toString());
                }
                return;
            }
            cMap.addCIDMapping(((Integer) parseNextToken(pushbackInputStream)).intValue(), createIntFromBytes((byte[]) parseNextToken));
        }
    }

    private void parseBegincidrange(Object obj, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        int intValue = ((Integer) obj).intValue();
        for (int i = 0; i < intValue; i++) {
            Object parseNextToken = parseNextToken(pushbackInputStream);
            if (parseNextToken instanceof Operator) {
                Operator operator = (Operator) parseNextToken;
                if (!operator.op.equals("endcidrange")) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error : ~cidrange contains an unexpected operator : ");
                    outline73.append(operator.op);
                    throw new IOException(outline73.toString());
                }
                return;
            }
            byte[] bArr = (byte[]) parseNextToken;
            int createIntFromBytes = createIntFromBytes(bArr);
            byte[] bArr2 = (byte[]) parseNextToken(pushbackInputStream);
            int createIntFromBytes2 = createIntFromBytes(bArr2);
            int intValue2 = ((Integer) parseNextToken(pushbackInputStream)).intValue();
            if (bArr.length > 2 || bArr2.length > 2) {
                int i2 = (createIntFromBytes2 + intValue2) - createIntFromBytes;
                while (intValue2 <= i2) {
                    cMap.addCIDMapping(intValue2, createIntFromBytes(bArr));
                    increment(bArr);
                    intValue2++;
                }
            } else {
                cMap.addCIDRange((char) createIntFromBytes, (char) createIntFromBytes2, intValue2);
            }
        }
    }

    private void parseBegincodespacerange(Object obj, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        Number number = (Number) obj;
        for (int i = 0; i < number.intValue(); i++) {
            Object parseNextToken = parseNextToken(pushbackInputStream);
            if (parseNextToken instanceof Operator) {
                Operator operator = (Operator) parseNextToken;
                if (!operator.op.equals("endcodespacerange")) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error : ~codespacerange contains an unexpected operator : ");
                    outline73.append(operator.op);
                    throw new IOException(outline73.toString());
                }
                return;
            }
            CodespaceRange codespaceRange = new CodespaceRange();
            codespaceRange.setStart((byte[]) parseNextToken);
            codespaceRange.setEnd((byte[]) parseNextToken(pushbackInputStream));
            cMap.addCodespaceRange(codespaceRange);
        }
    }

    private void parseLiteralName(Object obj, PushbackInputStream pushbackInputStream, CMap cMap) throws IOException {
        LiteralName literalName = (LiteralName) obj;
        if ("WMode".equals(literalName.name)) {
            Object parseNextToken = parseNextToken(pushbackInputStream);
            if (parseNextToken instanceof Integer) {
                cMap.setWMode(((Integer) parseNextToken).intValue());
            }
        } else if ("CMapName".equals(literalName.name)) {
            Object parseNextToken2 = parseNextToken(pushbackInputStream);
            if (parseNextToken2 instanceof LiteralName) {
                cMap.setName(((LiteralName) parseNextToken2).name);
            }
        } else if ("CMapVersion".equals(literalName.name)) {
            Object parseNextToken3 = parseNextToken(pushbackInputStream);
            if (parseNextToken3 instanceof Number) {
                cMap.setVersion(parseNextToken3.toString());
            } else if (parseNextToken3 instanceof String) {
                cMap.setVersion((String) parseNextToken3);
            }
        } else if ("CMapType".equals(literalName.name)) {
            Object parseNextToken4 = parseNextToken(pushbackInputStream);
            if (parseNextToken4 instanceof Integer) {
                cMap.setType(((Integer) parseNextToken4).intValue());
            }
        } else if ("Registry".equals(literalName.name)) {
            Object parseNextToken5 = parseNextToken(pushbackInputStream);
            if (parseNextToken5 instanceof String) {
                cMap.setRegistry((String) parseNextToken5);
            }
        } else if ("Ordering".equals(literalName.name)) {
            Object parseNextToken6 = parseNextToken(pushbackInputStream);
            if (parseNextToken6 instanceof String) {
                cMap.setOrdering((String) parseNextToken6);
            }
        } else if ("Supplement".equals(literalName.name)) {
            Object parseNextToken7 = parseNextToken(pushbackInputStream);
            if (parseNextToken7 instanceof Integer) {
                cMap.setSupplement(((Integer) parseNextToken7).intValue());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object parseNextToken(java.io.PushbackInputStream r10) throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r10.read()
        L_0x0004:
            r1 = 9
            if (r0 == r1) goto L_0x01ea
            r1 = 32
            if (r0 == r1) goto L_0x01ea
            r1 = 13
            if (r0 == r1) goto L_0x01ea
            r1 = 10
            if (r0 != r1) goto L_0x0016
            goto L_0x01ea
        L_0x0016:
            java.lang.String r1 = ">>"
            java.lang.String r2 = "]"
            r3 = 0
            r4 = -1
            if (r0 == r4) goto L_0x01e8
            r5 = 37
            if (r0 == r5) goto L_0x01d7
            r5 = 40
            if (r0 == r5) goto L_0x01ba
            r5 = 60
            r6 = 62
            if (r0 == r5) goto L_0x0119
            if (r0 == r6) goto L_0x0109
            r1 = 91
            if (r0 == r1) goto L_0x00f4
            r1 = 93
            if (r0 == r1) goto L_0x00f1
            switch(r0) {
                case 47: goto L_0x0089;
                case 48: goto L_0x0048;
                case 49: goto L_0x0048;
                case 50: goto L_0x0048;
                case 51: goto L_0x0048;
                case 52: goto L_0x0048;
                case 53: goto L_0x0048;
                case 54: goto L_0x0048;
                case 55: goto L_0x0048;
                case 56: goto L_0x0048;
                case 57: goto L_0x0048;
                default: goto L_0x0039;
            }
        L_0x0039:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            char r0 = (char) r0
            r1.append(r0)
            int r0 = r10.read()
            goto L_0x00bb
        L_0x0048:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            char r0 = (char) r0
            r1.append(r0)
            int r0 = r10.read()
        L_0x0055:
            boolean r2 = isWhitespaceOrEOF(r0)
            r3 = 46
            if (r2 != 0) goto L_0x006e
            char r2 = (char) r0
            boolean r4 = java.lang.Character.isDigit(r2)
            if (r4 != 0) goto L_0x0066
            if (r0 != r3) goto L_0x006e
        L_0x0066:
            r1.append(r2)
            int r0 = r10.read()
            goto L_0x0055
        L_0x006e:
            r10.unread(r0)
            java.lang.String r10 = r1.toString()
            int r0 = r10.indexOf(r3)
            if (r0 < 0) goto L_0x0082
            java.lang.Double r1 = new java.lang.Double
            r1.<init>(r10)
            goto L_0x01e9
        L_0x0082:
            java.lang.Integer r1 = new java.lang.Integer
            r1.<init>(r10)
            goto L_0x01e9
        L_0x0089:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r1 = r10.read()
        L_0x0092:
            boolean r2 = isWhitespaceOrEOF(r1)
            if (r2 != 0) goto L_0x00a7
            boolean r2 = isDelimiter(r1)
            if (r2 != 0) goto L_0x00a7
            char r1 = (char) r1
            r0.append(r1)
            int r1 = r10.read()
            goto L_0x0092
        L_0x00a7:
            boolean r2 = isDelimiter(r1)
            if (r2 == 0) goto L_0x00b0
            r10.unread(r1)
        L_0x00b0:
            org.apache.fontbox.cmap.CMapParser$LiteralName r1 = new org.apache.fontbox.cmap.CMapParser$LiteralName
            java.lang.String r10 = r0.toString()
            r1.<init>(r10)
            goto L_0x01e9
        L_0x00bb:
            boolean r2 = isWhitespaceOrEOF(r0)
            if (r2 != 0) goto L_0x00d6
            boolean r2 = isDelimiter(r0)
            if (r2 != 0) goto L_0x00d6
            boolean r2 = java.lang.Character.isDigit(r0)
            if (r2 != 0) goto L_0x00d6
            char r0 = (char) r0
            r1.append(r0)
            int r0 = r10.read()
            goto L_0x00bb
        L_0x00d6:
            boolean r2 = isDelimiter(r0)
            if (r2 != 0) goto L_0x00e2
            boolean r2 = java.lang.Character.isDigit(r0)
            if (r2 == 0) goto L_0x00e5
        L_0x00e2:
            r10.unread(r0)
        L_0x00e5:
            org.apache.fontbox.cmap.CMapParser$Operator r10 = new org.apache.fontbox.cmap.CMapParser$Operator
            java.lang.String r0 = r1.toString()
            r10.<init>(r0)
            r1 = r10
            goto L_0x01e9
        L_0x00f1:
            r1 = r2
            goto L_0x01e9
        L_0x00f4:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.Object r0 = r9.parseNextToken(r10)
        L_0x00fd:
            if (r0 == 0) goto L_0x01e9
            if (r0 == r2) goto L_0x01e9
            r1.add(r0)
            java.lang.Object r0 = r9.parseNextToken(r10)
            goto L_0x00fd
        L_0x0109:
            int r10 = r10.read()
            if (r10 != r6) goto L_0x0111
            goto L_0x01e9
        L_0x0111:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r0 = "Error: expected the end of a dictionary."
            r10.<init>(r0)
            throw r10
        L_0x0119:
            int r0 = r10.read()
            if (r0 != r5) goto L_0x0145
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Object r2 = r9.parseNextToken(r10)
        L_0x0128:
            boolean r3 = r2 instanceof org.apache.fontbox.cmap.CMapParser.LiteralName
            if (r3 == 0) goto L_0x0142
            if (r2 == r1) goto L_0x0142
            java.lang.Object r3 = r9.parseNextToken(r10)
            org.apache.fontbox.cmap.CMapParser$LiteralName r2 = (org.apache.fontbox.cmap.CMapParser.LiteralName) r2
            java.lang.String r2 = r2.name
            r0.put(r2, r3)
            java.lang.Object r2 = r9.parseNextToken(r10)     // Catch:{ all -> 0x0140 }
            goto L_0x0128
        L_0x0140:
            r10 = move-exception
            throw r10
        L_0x0142:
            r1 = r0
            goto L_0x01e9
        L_0x0145:
            r1 = 16
            r2 = -1
            r3 = 16
        L_0x014a:
            r5 = 0
            if (r0 == r4) goto L_0x01b0
            if (r0 == r6) goto L_0x01b0
            r7 = 48
            if (r0 < r7) goto L_0x015a
            r7 = 57
            if (r0 > r7) goto L_0x015a
            int r0 = r0 + -48
            goto L_0x016e
        L_0x015a:
            r7 = 65
            if (r0 < r7) goto L_0x0163
            r8 = 70
            if (r0 > r8) goto L_0x0163
            goto L_0x016b
        L_0x0163:
            r7 = 97
            if (r0 < r7) goto L_0x0189
            r8 = 102(0x66, float:1.43E-43)
            if (r0 > r8) goto L_0x0189
        L_0x016b:
            int r0 = r0 + 10
            int r0 = r0 - r7
        L_0x016e:
            int r0 = r0 * r3
            if (r3 != r1) goto L_0x017a
            int r2 = r2 + 1
            byte[] r3 = r9.tokenParserByteBuffer
            r3[r2] = r5
            r3 = 1
            goto L_0x017c
        L_0x017a:
            r3 = 16
        L_0x017c:
            byte[] r5 = r9.tokenParserByteBuffer
            byte r7 = r5[r2]
            int r7 = r7 + r0
            byte r0 = (byte) r7
            r5[r2] = r0
            int r0 = r10.read()
            goto L_0x014a
        L_0x0189:
            boolean r5 = isWhitespaceOrEOF(r0)
            if (r5 == 0) goto L_0x0194
            int r0 = r10.read()
            goto L_0x014a
        L_0x0194:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r1 = "Error: expected hex character and not "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            char r2 = (char) r0
            r1.append(r2)
            java.lang.String r2 = ":"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r10.<init>(r0)
            throw r10
        L_0x01b0:
            int r2 = r2 + 1
            byte[] r1 = new byte[r2]
            byte[] r10 = r9.tokenParserByteBuffer
            java.lang.System.arraycopy(r10, r5, r1, r5, r2)
            goto L_0x01e9
        L_0x01ba:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r1 = r10.read()
        L_0x01c3:
            if (r1 == r4) goto L_0x01d2
            r2 = 41
            if (r1 == r2) goto L_0x01d2
            char r1 = (char) r1
            r0.append(r1)
            int r1 = r10.read()
            goto L_0x01c3
        L_0x01d2:
            java.lang.String r1 = r0.toString()
            goto L_0x01e9
        L_0x01d7:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            char r0 = (char) r0
            r1.append(r0)
            readUntilEndOfLine(r10, r1)
            java.lang.String r1 = r1.toString()
            goto L_0x01e9
        L_0x01e8:
            r1 = r3
        L_0x01e9:
            return r1
        L_0x01ea:
            int r0 = r10.read()
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.fontbox.cmap.CMapParser.parseNextToken(java.io.PushbackInputStream):java.lang.Object");
    }

    private void parseUsecmap(Object obj, CMap cMap) throws IOException {
        cMap.useCmap(parse(getExternalCMap(((LiteralName) obj).name)));
    }

    public static void readUntilEndOfLine(InputStream inputStream, StringBuffer stringBuffer) throws IOException {
        int read = inputStream.read();
        while (read != -1 && read != 13 && read != 10) {
            stringBuffer.append((char) read);
            read = inputStream.read();
        }
    }

    public InputStream getExternalCMap(String str) throws IOException {
        if (PDFBoxResourceLoader.isReady()) {
            return PDFBoxResourceLoader.getStream("/org/apache/fontbox/resources/cmap/" + str);
        }
        URL resource = CMapParser.class.getResource("/org/apache/fontbox/resources/cmap/" + str);
        if (resource != null) {
            return FirebasePerfUrlConnection.openStream(resource);
        }
        throw new IOException(GeneratedOutlineSupport.outline50("Error: Could not find referenced cmap stream ", str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.fontbox.cmap.CMap parse(java.io.File r3) throws java.io.IOException {
        /*
            r2 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0011 }
            r1.<init>(r3)     // Catch:{ all -> 0x0011 }
            org.apache.fontbox.cmap.CMap r3 = r2.parse(r1)     // Catch:{ all -> 0x000e }
            r1.close()
            return r3
        L_0x000e:
            r3 = move-exception
            r0 = r1
            goto L_0x0012
        L_0x0011:
            r3 = move-exception
        L_0x0012:
            if (r0 == 0) goto L_0x0017
            r0.close()
        L_0x0017:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.fontbox.cmap.CMapParser.parse(java.io.File):org.apache.fontbox.cmap.CMap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.fontbox.cmap.CMap parsePredefined(java.lang.String r2) throws java.io.IOException {
        /*
            r1 = this;
            java.io.InputStream r2 = r1.getExternalCMap(r2)     // Catch:{ all -> 0x0010 }
            org.apache.fontbox.cmap.CMap r0 = r1.parse(r2)     // Catch:{ all -> 0x000e }
            if (r2 == 0) goto L_0x000d
            r2.close()
        L_0x000d:
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            r2 = 0
        L_0x0012:
            if (r2 == 0) goto L_0x0017
            r2.close()
        L_0x0017:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.fontbox.cmap.CMapParser.parsePredefined(java.lang.String):org.apache.fontbox.cmap.CMap");
    }

    private void increment(byte[] bArr, int i) {
        if (i <= 0 || (bArr[i] + 256) % 256 != 255) {
            bArr[i] = (byte) (bArr[i] + 1);
            return;
        }
        bArr[i] = 0;
        increment(bArr, i - 1);
    }

    public CMap parse(InputStream inputStream) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        CMap cMap = new CMap();
        Object obj = null;
        while (true) {
            Object parseNextToken = parseNextToken(pushbackInputStream);
            if (parseNextToken == null) {
                break;
            }
            if (parseNextToken instanceof Operator) {
                Operator operator = (Operator) parseNextToken;
                if (operator.op.equals("usecmap")) {
                    parseUsecmap(obj, cMap);
                } else if (operator.op.equals("endcmap")) {
                    break;
                } else if (operator.op.equals("begincodespacerange")) {
                    parseBegincodespacerange(obj, pushbackInputStream, cMap);
                } else if (operator.op.equals("beginbfchar")) {
                    parseBeginbfchar(obj, pushbackInputStream, cMap);
                } else if (operator.op.equals("beginbfrange")) {
                    parseBeginbfrange(obj, pushbackInputStream, cMap);
                } else if (operator.op.equals("begincidchar")) {
                    parseBegincidchar(obj, pushbackInputStream, cMap);
                } else if (operator.op.equals("begincidrange")) {
                    parseBegincidrange(obj, pushbackInputStream, cMap);
                }
            } else if (parseNextToken instanceof LiteralName) {
                parseLiteralName(parseNextToken, pushbackInputStream, cMap);
            }
            obj = parseNextToken;
        }
        return cMap;
    }
}
