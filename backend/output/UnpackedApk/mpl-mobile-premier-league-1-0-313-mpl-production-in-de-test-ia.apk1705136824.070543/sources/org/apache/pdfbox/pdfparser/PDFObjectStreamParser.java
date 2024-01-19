package org.apache.pdfbox.pdfparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;

public class PDFObjectStreamParser extends BaseParser {
    public final COSStream stream;
    public List<COSObject> streamObjects = null;

    public PDFObjectStreamParser(COSStream cOSStream, COSDocument cOSDocument) throws IOException {
        super(cOSStream.getUnfilteredStream());
        this.document = cOSDocument;
        this.stream = cOSStream;
    }

    public List<COSObject> getObjects() {
        return this.streamObjects;
    }

    public void parse() throws IOException {
        try {
            int i = this.stream.getInt((String) "N");
            ArrayList arrayList = new ArrayList(i);
            this.streamObjects = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                readLong();
                arrayList.add(Long.valueOf((long) readObjectNumber()));
            }
            int i3 = 0;
            while (true) {
                COSBase parseDirObject = parseDirObject();
                if (parseDirObject == null) {
                    break;
                }
                COSObject cOSObject = new COSObject(parseDirObject);
                cOSObject.setGenerationNumber(0);
                if (i3 >= arrayList.size()) {
                    break;
                }
                cOSObject.setObjectNumber(((Long) arrayList.get(i3)).longValue());
                this.streamObjects.add(cOSObject);
                "parsed=" + cOSObject;
                if (!this.pdfSource.isEOF() && this.pdfSource.peek() == 101) {
                    readLine();
                }
                i3++;
            }
        } finally {
            this.pdfSource.close();
        }
    }
}
