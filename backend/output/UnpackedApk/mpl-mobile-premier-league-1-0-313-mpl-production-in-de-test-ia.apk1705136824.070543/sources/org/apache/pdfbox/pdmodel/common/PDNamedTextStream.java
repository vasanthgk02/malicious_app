package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;

public class PDNamedTextStream implements DualCOSObjectable {
    public PDTextStream stream;
    public COSName streamName;

    public PDNamedTextStream() {
    }

    public COSBase getFirstCOSObject() {
        return this.streamName;
    }

    public String getName() {
        COSName cOSName = this.streamName;
        if (cOSName != null) {
            return cOSName.getName();
        }
        return null;
    }

    public COSBase getSecondCOSObject() {
        PDTextStream pDTextStream = this.stream;
        if (pDTextStream != null) {
            return pDTextStream.getCOSObject();
        }
        return null;
    }

    public PDTextStream getStream() {
        return this.stream;
    }

    public void setName(String str) {
        this.streamName = COSName.getPDFName(str);
    }

    public void setStream(PDTextStream pDTextStream) {
        this.stream = pDTextStream;
    }

    public PDNamedTextStream(COSName cOSName, COSBase cOSBase) {
        this.streamName = cOSName;
        this.stream = PDTextStream.createTextStream(cOSBase);
    }
}
