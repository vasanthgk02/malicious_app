package org.apache.pdfbox.pdfparser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDStream;

public class PDFStreamParser extends BaseParser {
    public static final int MAX_BIN_CHAR_TEST_LENGTH = 10;
    public final byte[] binCharTestArr;
    public final List<Object> streamObjects;

    public PDFStreamParser(InputStream inputStream) throws IOException {
        super(inputStream);
        this.streamObjects = new ArrayList(100);
        this.binCharTestArr = new byte[10];
    }

    private boolean hasNextSpaceOrReturn() throws IOException {
        return isSpaceOrReturn(this.pdfSource.peek());
    }

    private boolean hasNoFollowingBinData(PushbackInputStream pushbackInputStream) throws IOException {
        int i = 10;
        int read = pushbackInputStream.read(this.binCharTestArr, 0, 10);
        boolean z = true;
        if (read > 0) {
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            while (true) {
                if (i2 >= read) {
                    break;
                }
                byte b2 = this.binCharTestArr[i2];
                if (b2 < 9 || (b2 > 10 && b2 < 32 && b2 != 13)) {
                    z = false;
                } else {
                    if (i3 == -1 && b2 != 9 && b2 != 32 && b2 != 10 && b2 != 13) {
                        i3 = i2;
                    } else if (i3 != -1 && i4 == -1 && (b2 == 9 || b2 == 32 || b2 == 10 || b2 == 13)) {
                        i4 = i2;
                    }
                    i2++;
                }
            }
            z = false;
            if (read == 10) {
                if (i3 == -1 || i4 != -1) {
                    i = i4;
                }
                if (!(i == -1 || i3 == -1 || i - i3 <= 3)) {
                    z = false;
                }
            }
            pushbackInputStream.unread(this.binCharTestArr, 0, read);
        }
        return z;
    }

    private boolean hasPrecedingAscii85Data(ByteArrayOutputStream byteArrayOutputStream) {
        if (byteArrayOutputStream.size() < 70) {
            return false;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        for (int length = byteArray.length - 1; length >= byteArray.length - 70; length--) {
            if (byteArray[length] < 33 || byteArray[length] > 117) {
                return false;
            }
        }
        return true;
    }

    private boolean isSpaceOrReturn(int i) {
        return i == 10 || i == 13 || i == 32;
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [org.apache.pdfbox.cos.COSNumber] */
    /* JADX WARNING: type inference failed for: r2v5, types: [org.apache.pdfbox.cos.COSString] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r2v8, types: [org.apache.pdfbox.cos.COSString] */
    /* JADX WARNING: type inference failed for: r0v26, types: [org.apache.pdfbox.cos.COSObject] */
    /* JADX WARNING: type inference failed for: r2v23, types: [org.apache.pdfbox.cos.COSArray] */
    /* JADX WARNING: type inference failed for: r2v24, types: [org.apache.pdfbox.cos.COSNull] */
    /* JADX WARNING: type inference failed for: r2v26, types: [org.apache.pdfbox.cos.COSBoolean] */
    /* JADX WARNING: type inference failed for: r2v27, types: [org.apache.pdfbox.cos.COSBoolean] */
    /* JADX WARNING: type inference failed for: r2v29, types: [org.apache.pdfbox.cos.COSNull] */
    /* JADX WARNING: type inference failed for: r2v30, types: [org.apache.pdfbox.cos.COSName] */
    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:128)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01a7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01bf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x019a A[ADDED_TO_REGION, SYNTHETIC] */
    public java.lang.Object parseNextToken() throws java.io.IOException {
        /*
            r7 = this;
            r7.skipSpaces()
            org.apache.pdfbox.io.PushBackInputStream r0 = r7.pdfSource
            int r0 = r0.peek()
            byte r1 = (byte) r0
            r2 = 0
            r3 = -1
            if (r1 != r3) goto L_0x000f
            return r2
        L_0x000f:
            char r0 = (char) r0
            switch(r0) {
                case 40: goto L_0x0179;
                case 43: goto L_0x0183;
                case 60: goto L_0x0146;
                case 66: goto L_0x010f;
                case 73: goto L_0x0087;
                case 82: goto L_0x006e;
                case 91: goto L_0x0068;
                case 93: goto L_0x005f;
                case 102: goto L_0x003c;
                case 110: goto L_0x0026;
                case 116: goto L_0x003c;
                default: goto L_0x0013;
            }
        L_0x0013:
            switch(r0) {
                case 45: goto L_0x0183;
                case 46: goto L_0x0183;
                case 47: goto L_0x017e;
                case 48: goto L_0x0183;
                case 49: goto L_0x0183;
                case 50: goto L_0x0183;
                case 51: goto L_0x0183;
                case 52: goto L_0x0183;
                case 53: goto L_0x0183;
                case 54: goto L_0x0183;
                case 55: goto L_0x0183;
                case 56: goto L_0x0183;
                case 57: goto L_0x0183;
                default: goto L_0x0016;
            }
        L_0x0016:
            java.lang.String r0 = r7.readOperator()
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01c2
            goto L_0x01c6
        L_0x0026:
            java.lang.String r0 = r7.readString()
            java.lang.String r1 = "null"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0036
            org.apache.pdfbox.cos.COSNull r2 = org.apache.pdfbox.cos.COSNull.NULL
            goto L_0x01c6
        L_0x0036:
            org.apache.pdfbox.contentstream.operator.Operator r2 = org.apache.pdfbox.contentstream.operator.Operator.getOperator(r0)
            goto L_0x01c6
        L_0x003c:
            java.lang.String r0 = r7.readString()
            java.lang.String r1 = "true"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004d
            org.apache.pdfbox.cos.COSBoolean r2 = org.apache.pdfbox.cos.COSBoolean.TRUE
            goto L_0x01c6
        L_0x004d:
            java.lang.String r1 = "false"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0059
            org.apache.pdfbox.cos.COSBoolean r2 = org.apache.pdfbox.cos.COSBoolean.FALSE
            goto L_0x01c6
        L_0x0059:
            org.apache.pdfbox.contentstream.operator.Operator r2 = org.apache.pdfbox.contentstream.operator.Operator.getOperator(r0)
            goto L_0x01c6
        L_0x005f:
            org.apache.pdfbox.io.PushBackInputStream r0 = r7.pdfSource
            r0.read()
            org.apache.pdfbox.cos.COSNull r2 = org.apache.pdfbox.cos.COSNull.NULL
            goto L_0x01c6
        L_0x0068:
            org.apache.pdfbox.cos.COSArray r2 = r7.parseCOSArray()
            goto L_0x01c6
        L_0x006e:
            java.lang.String r0 = r7.readString()
            java.lang.String r1 = "R"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0081
            org.apache.pdfbox.cos.COSObject r0 = new org.apache.pdfbox.cos.COSObject
            r0.<init>(r2)
            goto L_0x0172
        L_0x0081:
            org.apache.pdfbox.contentstream.operator.Operator r2 = org.apache.pdfbox.contentstream.operator.Operator.getOperator(r0)
            goto L_0x01c6
        L_0x0087:
            java.lang.String r0 = ""
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            org.apache.pdfbox.io.PushBackInputStream r1 = r7.pdfSource
            int r1 = r1.read()
            char r1 = (char) r1
            r0.append(r1)
            org.apache.pdfbox.io.PushBackInputStream r1 = r7.pdfSource
            int r1 = r1.read()
            char r1 = (char) r1
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ID"
            boolean r2 = r0.equals(r1)
            if (r2 == 0) goto L_0x0101
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            boolean r2 = r7.isWhitespace()
            if (r2 == 0) goto L_0x00bd
            org.apache.pdfbox.io.PushBackInputStream r2 = r7.pdfSource
            r2.read()
        L_0x00bd:
            org.apache.pdfbox.io.PushBackInputStream r2 = r7.pdfSource
            int r2 = r2.read()
            org.apache.pdfbox.io.PushBackInputStream r3 = r7.pdfSource
            int r3 = r3.read()
        L_0x00c9:
            r4 = 69
            if (r2 != r4) goto L_0x00df
            r4 = 73
            if (r3 != r4) goto L_0x00df
            boolean r4 = r7.hasNextSpaceOrReturn()
            if (r4 == 0) goto L_0x00df
            org.apache.pdfbox.io.PushBackInputStream r4 = r7.pdfSource
            boolean r4 = r7.hasNoFollowingBinData(r4)
            if (r4 != 0) goto L_0x00f4
        L_0x00df:
            org.apache.pdfbox.io.PushBackInputStream r4 = r7.pdfSource
            boolean r4 = r4.isEOF()
            if (r4 != 0) goto L_0x00f4
            r0.write(r2)
            org.apache.pdfbox.io.PushBackInputStream r2 = r7.pdfSource
            int r2 = r2.read()
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x00c9
        L_0x00f4:
            org.apache.pdfbox.contentstream.operator.Operator r2 = org.apache.pdfbox.contentstream.operator.Operator.getOperator(r1)
            byte[] r0 = r0.toByteArray()
            r2.setImageData(r0)
            goto L_0x01c6
        L_0x0101:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Error: Expected operator 'ID' actual='"
            java.lang.String r3 = "'"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r2, r0, r3)
            r1.<init>(r0)
            throw r1
        L_0x010f:
            java.lang.String r0 = r7.readString()
            org.apache.pdfbox.contentstream.operator.Operator r2 = org.apache.pdfbox.contentstream.operator.Operator.getOperator(r0)
            java.lang.String r1 = "BI"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01c6
            org.apache.pdfbox.cos.COSDictionary r0 = new org.apache.pdfbox.cos.COSDictionary
            r0.<init>()
            r2.setImageParameters(r0)
        L_0x0127:
            java.lang.Object r1 = r7.parseNextToken()
            boolean r3 = r1 instanceof org.apache.pdfbox.cos.COSName
            if (r3 == 0) goto L_0x013b
            java.lang.Object r3 = r7.parseNextToken()
            org.apache.pdfbox.cos.COSName r1 = (org.apache.pdfbox.cos.COSName) r1
            org.apache.pdfbox.cos.COSBase r3 = (org.apache.pdfbox.cos.COSBase) r3
            r0.setItem(r1, r3)
            goto L_0x0127
        L_0x013b:
            org.apache.pdfbox.contentstream.operator.Operator r1 = (org.apache.pdfbox.contentstream.operator.Operator) r1
            byte[] r0 = r1.getImageData()
            r2.setImageData(r0)
            goto L_0x01c6
        L_0x0146:
            org.apache.pdfbox.io.PushBackInputStream r0 = r7.pdfSource
            int r0 = r0.read()
            org.apache.pdfbox.io.PushBackInputStream r1 = r7.pdfSource
            int r1 = r1.peek()
            char r1 = (char) r1
            org.apache.pdfbox.io.PushBackInputStream r2 = r7.pdfSource
            r2.unread(r0)
            r0 = 60
            if (r1 != r0) goto L_0x0174
            org.apache.pdfbox.cos.COSDictionary r0 = r7.parseCOSDictionary()
            r7.skipSpaces()
            org.apache.pdfbox.io.PushBackInputStream r1 = r7.pdfSource
            int r1 = r1.peek()
            char r1 = (char) r1
            r2 = 115(0x73, float:1.61E-43)
            if (r1 != r2) goto L_0x0172
            org.apache.pdfbox.cos.COSStream r0 = r7.parseCOSStream(r0)
        L_0x0172:
            r2 = r0
            goto L_0x01c6
        L_0x0174:
            org.apache.pdfbox.cos.COSString r2 = r7.parseCOSString()
            goto L_0x01c6
        L_0x0179:
            org.apache.pdfbox.cos.COSString r2 = r7.parseCOSString()
            goto L_0x01c6
        L_0x017e:
            org.apache.pdfbox.cos.COSName r2 = r7.parseCOSName()
            goto L_0x01c6
        L_0x0183:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r1.append(r0)
            org.apache.pdfbox.io.PushBackInputStream r2 = r7.pdfSource
            r2.read()
            r2 = 46
            if (r0 == r2) goto L_0x0198
            r0 = 1
            r3 = 1
            r0 = r7
            goto L_0x019a
        L_0x0198:
            r0 = r7
        L_0x0199:
            r3 = 0
        L_0x019a:
            org.apache.pdfbox.io.PushBackInputStream r4 = r0.pdfSource
            int r4 = r4.peek()
            char r4 = (char) r4
            boolean r5 = java.lang.Character.isDigit(r4)
            if (r5 != 0) goto L_0x01b5
            if (r3 == 0) goto L_0x01ac
            if (r4 != r2) goto L_0x01ac
            goto L_0x01b5
        L_0x01ac:
            java.lang.String r0 = r1.toString()
            org.apache.pdfbox.cos.COSNumber r2 = org.apache.pdfbox.cos.COSNumber.get(r0)
            goto L_0x01c6
        L_0x01b5:
            r1.append(r4)
            org.apache.pdfbox.io.PushBackInputStream r5 = r0.pdfSource
            r5.read()
            if (r3 == 0) goto L_0x019a
            if (r4 != r2) goto L_0x019a
            goto L_0x0199
        L_0x01c2:
            org.apache.pdfbox.contentstream.operator.Operator r2 = org.apache.pdfbox.contentstream.operator.Operator.getOperator(r0)
        L_0x01c6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.PDFStreamParser.parseNextToken():java.lang.Object");
    }

    public Iterator<Object> getTokenIterator() {
        return new Iterator<Object>() {
            public Object token;

            private void tryNext() {
                try {
                    if (this.token == null) {
                        this.token = PDFStreamParser.this.parseNextToken();
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }

            public boolean hasNext() {
                tryNext();
                return this.token != null;
            }

            public Object next() {
                tryNext();
                Object obj = this.token;
                if (obj != null) {
                    this.token = null;
                    return obj;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public List<Object> getTokens() {
        return this.streamObjects;
    }

    public void parse() throws IOException {
        while (true) {
            try {
                Object parseNextToken = parseNextToken();
                if (parseNextToken != null) {
                    this.streamObjects.add(parseNextToken);
                } else {
                    return;
                }
            } finally {
                this.pdfSource.close();
            }
        }
    }

    public String readOperator() throws IOException {
        skipSpaces();
        StringBuffer stringBuffer = new StringBuffer(4);
        int peek = this.pdfSource.peek();
        while (peek != -1 && !isWhitespace(peek) && !isClosing(peek) && peek != 91 && peek != 60 && peek != 40 && peek != 47 && (peek < 48 || peek > 57)) {
            char read = (char) this.pdfSource.read();
            int peek2 = this.pdfSource.peek();
            stringBuffer.append(read);
            if (read == 'd' && (peek2 == 48 || peek2 == 49)) {
                stringBuffer.append((char) this.pdfSource.read());
                peek = this.pdfSource.peek();
            } else {
                peek = peek2;
            }
        }
        return stringBuffer.toString();
    }

    public PDFStreamParser(PDStream pDStream) throws IOException {
        this(pDStream.createInputStream());
    }

    public PDFStreamParser(COSStream cOSStream) throws IOException {
        this(cOSStream.getUnfilteredStream());
    }
}
