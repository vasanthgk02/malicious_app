package org.apache.pdfbox.pdfparser;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateInfo;
import org.apache.pdfbox.pdfwriter.COSWriter;

public class VisualSignatureParser extends BaseParser {
    public VisualSignatureParser(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    private boolean parseObject() throws IOException {
        char c2;
        skipSpaces();
        int peek = this.pdfSource.peek();
        while (true) {
            c2 = (char) peek;
            if (c2 != 'e') {
                break;
            }
            readString();
            skipSpaces();
            peek = this.pdfSource.peek();
        }
        boolean z = false;
        if (!this.pdfSource.isEOF()) {
            if (c2 == 'x') {
                return true;
            }
            if (c2 != 't' && c2 != 's') {
                COSObjectKey parseObjectKey = parseObjectKey(false);
                skipSpaces();
                COSBase parseDirObject = parseDirObject();
                String readString = readString();
                if (readString.equals(BaseParser.STREAM_STRING)) {
                    this.pdfSource.unread(readString.getBytes());
                    this.pdfSource.unread(32);
                    if (parseDirObject instanceof COSDictionary) {
                        parseDirObject = parseCOSStream((COSDictionary) parseDirObject);
                        readString = readString();
                    } else {
                        throw new IOException("stream not preceded by dictionary");
                    }
                }
                COSObject objectFromPool = this.document.getObjectFromPool(parseObjectKey);
                if (parseDirObject instanceof COSUpdateInfo) {
                    ((COSUpdateInfo) parseDirObject).setNeedToBeUpdated(true);
                }
                objectFromPool.setObject(parseDirObject);
                if (!readString.equals(BaseParser.ENDOBJ_STRING)) {
                    if (readString.startsWith(BaseParser.ENDOBJ_STRING)) {
                        this.pdfSource.unread(readString.substring(6).getBytes());
                    } else if (!this.pdfSource.isEOF()) {
                        try {
                            Float.parseFloat(readString);
                            this.pdfSource.unread(COSWriter.SPACE);
                            this.pdfSource.unread(readString.getBytes());
                        } catch (NumberFormatException e2) {
                            String readString2 = readString();
                            if (!readString2.equals(BaseParser.ENDOBJ_STRING)) {
                                if (isClosing()) {
                                    this.pdfSource.read();
                                }
                                skipSpaces();
                                if (!readString().equals(BaseParser.ENDOBJ_STRING)) {
                                    StringBuilder outline82 = GeneratedOutlineSupport.outline82("expected='endobj' firstReadAttempt='", readString, "' secondReadAttempt='", readString2, "' ");
                                    outline82.append(this.pdfSource);
                                    throw new IOException(outline82.toString(), e2);
                                }
                            }
                        }
                    }
                }
                skipSpaces();
            } else if (c2 == 't') {
                return true;
            } else {
                if (c2 == 's') {
                    skipToNextObj();
                    String readExpectedStringUntilEOL = readExpectedStringUntilEOL("%%EOF");
                    if (readExpectedStringUntilEOL.contains("%%EOF") || this.pdfSource.isEOF()) {
                        z = true;
                    } else {
                        StringBuilder outline80 = GeneratedOutlineSupport.outline80("expected='%%EOF' actual='", readExpectedStringUntilEOL, "' next=");
                        outline80.append(readString());
                        outline80.append(" next=");
                        outline80.append(readString());
                        throw new IOException(outline80.toString());
                    }
                }
            }
        }
        return z;
    }

    public COSDocument getDocument() throws IOException {
        COSDocument cOSDocument = this.document;
        if (cOSDocument != null) {
            return cOSDocument;
        }
        throw new IOException("You must call parse() before calling getDocument()");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        skipToNextObj();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse() throws java.io.IOException {
        /*
            r2 = this;
            org.apache.pdfbox.cos.COSDocument r0 = new org.apache.pdfbox.cos.COSDocument
            r0.<init>()
            r2.document = r0
            r2.skipToNextObj()
            r0 = 0
        L_0x000b:
            if (r0 != 0) goto L_0x0027
            org.apache.pdfbox.io.PushBackInputStream r1 = r2.pdfSource     // Catch:{ IOException -> 0x0022 }
            boolean r1 = r1.isEOF()     // Catch:{ IOException -> 0x0022 }
            if (r1 == 0) goto L_0x0016
            goto L_0x0027
        L_0x0016:
            boolean r0 = r2.parseObject()     // Catch:{ IOException -> 0x001b }
            goto L_0x001e
        L_0x001b:
            r2.skipToNextObj()     // Catch:{ IOException -> 0x0022 }
        L_0x001e:
            r2.skipSpaces()     // Catch:{ IOException -> 0x0022 }
            goto L_0x000b
        L_0x0022:
            r1 = move-exception
            if (r0 == 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            throw r1
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdfparser.VisualSignatureParser.parse():void");
    }

    public String readExpectedStringUntilEOL(String str) throws IOException {
        int read = this.pdfSource.read();
        while (isWhitespace(read) && read != -1) {
            read = this.pdfSource.read();
        }
        StringBuilder sb = new StringBuilder(str.length());
        int i = 0;
        while (!isEOL(read) && read != -1 && i < str.length()) {
            char c2 = (char) read;
            sb.append(c2);
            if (str.charAt(i) == c2) {
                i++;
                read = this.pdfSource.read();
            } else {
                this.pdfSource.unread(sb.toString().getBytes("ISO-8859-1"));
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("Error: Expected to read '", str, "' instead started reading '");
                outline80.append(sb.toString());
                outline80.append("'");
                throw new IOException(outline80.toString());
            }
        }
        while (isEOL(read) && read != -1) {
            read = this.pdfSource.read();
        }
        if (read != -1) {
            this.pdfSource.unread(read);
        }
        return sb.toString();
    }
}
