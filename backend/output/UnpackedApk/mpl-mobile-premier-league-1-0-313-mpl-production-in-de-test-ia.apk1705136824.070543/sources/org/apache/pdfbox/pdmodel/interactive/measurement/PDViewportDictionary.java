package org.apache.pdfbox.pdmodel.interactive.measurement;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject;

public class PDViewportDictionary implements COSObjectable {
    public static final String TYPE = "Viewport";
    public COSDictionary viewportDictionary;

    public PDViewportDictionary() {
        this.viewportDictionary = new COSDictionary();
    }

    public PDRectangle getBBox() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) PDLayoutAttributeObject.BBOX);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    public COSBase getCOSObject() {
        return this.viewportDictionary;
    }

    public COSDictionary getDictionary() {
        return this.viewportDictionary;
    }

    public PDMeasureDictionary getMeasure() {
        COSDictionary cOSDictionary = (COSDictionary) getDictionary().getDictionaryObject((String) PDMeasureDictionary.TYPE);
        if (cOSDictionary != null) {
            return new PDMeasureDictionary(cOSDictionary);
        }
        return null;
    }

    public String getName() {
        return getDictionary().getNameAsString(COSName.NAME);
    }

    public String getType() {
        return TYPE;
    }

    public void setBBox(PDRectangle pDRectangle) {
        getDictionary().setItem((String) PDLayoutAttributeObject.BBOX, (COSObjectable) pDRectangle);
    }

    public void setMeasure(PDMeasureDictionary pDMeasureDictionary) {
        getDictionary().setItem((String) PDMeasureDictionary.TYPE, (COSObjectable) pDMeasureDictionary);
    }

    public void setName(String str) {
        getDictionary().setName(COSName.NAME, str);
    }

    public PDViewportDictionary(COSDictionary cOSDictionary) {
        this.viewportDictionary = cOSDictionary;
    }
}
