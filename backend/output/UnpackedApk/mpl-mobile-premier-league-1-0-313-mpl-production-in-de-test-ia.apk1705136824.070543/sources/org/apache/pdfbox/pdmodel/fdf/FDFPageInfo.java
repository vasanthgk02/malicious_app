package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class FDFPageInfo implements COSObjectable {
    public COSDictionary pageInfo;

    public FDFPageInfo() {
        this.pageInfo = new COSDictionary();
    }

    public COSDictionary getCOSDictionary() {
        return this.pageInfo;
    }

    public COSBase getCOSObject() {
        return this.pageInfo;
    }

    public FDFPageInfo(COSDictionary cOSDictionary) {
        this.pageInfo = cOSDictionary;
    }
}
