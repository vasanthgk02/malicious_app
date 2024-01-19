package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDPropBuild implements COSObjectable {
    public COSDictionary dictionary;

    public PDPropBuild() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setDirect(true);
    }

    public PDPropBuildDataDict getApp() {
        COSDictionary cOSDictionary = (COSDictionary) this.dictionary.getDictionaryObject(COSName.APP);
        if (cOSDictionary != null) {
            return new PDPropBuildDataDict(cOSDictionary);
        }
        return null;
    }

    public COSBase getCOSObject() {
        return getDictionary();
    }

    public COSDictionary getDictionary() {
        return this.dictionary;
    }

    public PDPropBuildDataDict getFilter() {
        COSDictionary cOSDictionary = (COSDictionary) this.dictionary.getDictionaryObject(COSName.FILTER);
        if (cOSDictionary != null) {
            return new PDPropBuildDataDict(cOSDictionary);
        }
        return null;
    }

    public PDPropBuildDataDict getPubSec() {
        COSDictionary cOSDictionary = (COSDictionary) this.dictionary.getDictionaryObject(COSName.PUB_SEC);
        if (cOSDictionary != null) {
            return new PDPropBuildDataDict(cOSDictionary);
        }
        return null;
    }

    public void setPDPropBuildApp(PDPropBuildDataDict pDPropBuildDataDict) {
        this.dictionary.setItem(COSName.APP, (COSObjectable) pDPropBuildDataDict);
    }

    public void setPDPropBuildFilter(PDPropBuildDataDict pDPropBuildDataDict) {
        this.dictionary.setItem(COSName.FILTER, (COSObjectable) pDPropBuildDataDict);
    }

    public void setPDPropBuildPubSec(PDPropBuildDataDict pDPropBuildDataDict) {
        this.dictionary.setItem(COSName.PUB_SEC, (COSObjectable) pDPropBuildDataDict);
    }

    public PDPropBuild(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
        cOSDictionary.setDirect(true);
    }
}
