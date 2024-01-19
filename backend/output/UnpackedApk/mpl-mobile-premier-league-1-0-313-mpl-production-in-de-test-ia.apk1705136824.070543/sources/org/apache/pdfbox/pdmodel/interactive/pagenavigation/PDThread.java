package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class PDThread implements COSObjectable {
    public COSDictionary thread;

    public PDThread(COSDictionary cOSDictionary) {
        this.thread = cOSDictionary;
    }

    public COSBase getCOSObject() {
        return this.thread;
    }

    public COSDictionary getDictionary() {
        return this.thread;
    }

    public PDThreadBead getFirstBead() {
        COSDictionary cOSDictionary = (COSDictionary) this.thread.getDictionaryObject((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
        if (cOSDictionary != null) {
            return new PDThreadBead(cOSDictionary);
        }
        return null;
    }

    public PDDocumentInformation getThreadInfo() {
        COSDictionary cOSDictionary = (COSDictionary) this.thread.getDictionaryObject((String) "I");
        if (cOSDictionary != null) {
            return new PDDocumentInformation(cOSDictionary);
        }
        return null;
    }

    public void setFirstBead(PDThreadBead pDThreadBead) {
        if (pDThreadBead != null) {
            pDThreadBead.setThread(this);
        }
        this.thread.setItem((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, (COSObjectable) pDThreadBead);
    }

    public void setThreadInfo(PDDocumentInformation pDDocumentInformation) {
        this.thread.setItem((String) "I", (COSObjectable) pDDocumentInformation);
    }

    public PDThread() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.thread = cOSDictionary;
        cOSDictionary.setName((String) "Type", (String) "Thread");
    }
}
