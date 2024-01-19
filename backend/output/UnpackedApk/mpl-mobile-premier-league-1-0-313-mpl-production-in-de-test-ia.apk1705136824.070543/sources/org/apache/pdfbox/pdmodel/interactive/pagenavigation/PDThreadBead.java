package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PDThreadBead implements COSObjectable {
    public COSDictionary bead;

    public PDThreadBead(COSDictionary cOSDictionary) {
        this.bead = cOSDictionary;
    }

    public void appendBead(PDThreadBead pDThreadBead) {
        PDThreadBead nextBead = getNextBead();
        nextBead.setPreviousBead(pDThreadBead);
        pDThreadBead.setNextBead(nextBead);
        setNextBead(pDThreadBead);
        pDThreadBead.setPreviousBead(this);
    }

    public COSBase getCOSObject() {
        return this.bead;
    }

    public COSDictionary getDictionary() {
        return this.bead;
    }

    public PDThreadBead getNextBead() {
        return new PDThreadBead((COSDictionary) this.bead.getDictionaryObject((String) "N"));
    }

    public PDPage getPage() {
        COSDictionary cOSDictionary = (COSDictionary) this.bead.getDictionaryObject((String) "P");
        if (cOSDictionary != null) {
            return new PDPage(cOSDictionary);
        }
        return null;
    }

    public PDThreadBead getPreviousBead() {
        return new PDThreadBead((COSDictionary) this.bead.getDictionaryObject((String) DefaultSFSDataSerializer.FIELD_VALUE_KEY));
    }

    public PDRectangle getRectangle() {
        COSArray cOSArray = (COSArray) this.bead.getDictionaryObject(COSName.R);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    public PDThread getThread() {
        COSDictionary cOSDictionary = (COSDictionary) this.bead.getDictionaryObject((String) "T");
        if (cOSDictionary != null) {
            return new PDThread(cOSDictionary);
        }
        return null;
    }

    public void setNextBead(PDThreadBead pDThreadBead) {
        this.bead.setItem((String) "N", (COSObjectable) pDThreadBead);
    }

    public void setPage(PDPage pDPage) {
        this.bead.setItem((String) "P", (COSObjectable) pDPage);
    }

    public void setPreviousBead(PDThreadBead pDThreadBead) {
        this.bead.setItem((String) DefaultSFSDataSerializer.FIELD_VALUE_KEY, (COSObjectable) pDThreadBead);
    }

    public void setRectangle(PDRectangle pDRectangle) {
        this.bead.setItem(COSName.R, (COSObjectable) pDRectangle);
    }

    public void setThread(PDThread pDThread) {
        this.bead.setItem((String) "T", (COSObjectable) pDThread);
    }

    public PDThreadBead() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.bead = cOSDictionary;
        cOSDictionary.setName((String) "Type", (String) "Bead");
        setNextBead(this);
        setPreviousBead(this);
    }
}
