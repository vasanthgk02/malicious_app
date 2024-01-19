package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDMarkedContentReference implements COSObjectable {
    public static final String TYPE = "MCR";
    public COSDictionary dictionary;

    public PDMarkedContentReference() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setName(COSName.TYPE, (String) TYPE);
    }

    public COSDictionary getCOSDictionary() {
        return this.dictionary;
    }

    public COSBase getCOSObject() {
        return this.dictionary;
    }

    public int getMCID() {
        return getCOSDictionary().getInt(COSName.MCID);
    }

    public PDPage getPage() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(COSName.PG);
        if (cOSDictionary != null) {
            return new PDPage(cOSDictionary);
        }
        return null;
    }

    public void setMCID(int i) {
        getCOSDictionary().setInt(COSName.MCID, i);
    }

    public void setPage(PDPage pDPage) {
        getCOSDictionary().setItem(COSName.PG, (COSObjectable) pDPage);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("mcid=");
        outline73.append(getMCID());
        return outline73.toString();
    }

    public PDMarkedContentReference(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
