package org.apache.pdfbox.pdmodel.interactive.measurement;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

public class PDRectlinearMeasureDictionary extends PDMeasureDictionary {
    public static final String SUBTYPE = "RL";

    public PDRectlinearMeasureDictionary() {
        setSubtype(SUBTYPE);
    }

    public PDNumberFormatDictionary[] getAngles() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "T");
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i = 0; i < cOSArray.size(); i++) {
            pDNumberFormatDictionaryArr[i] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i));
        }
        return pDNumberFormatDictionaryArr;
    }

    public PDNumberFormatDictionary[] getAreas() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject(COSName.A);
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i = 0; i < cOSArray.size(); i++) {
            pDNumberFormatDictionaryArr[i] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i));
        }
        return pDNumberFormatDictionaryArr;
    }

    public float getCYX() {
        return getDictionary().getFloat((String) "CYX");
    }

    public PDNumberFormatDictionary[] getChangeXs() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "X");
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i = 0; i < cOSArray.size(); i++) {
            pDNumberFormatDictionaryArr[i] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i));
        }
        return pDNumberFormatDictionaryArr;
    }

    public PDNumberFormatDictionary[] getChangeYs() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "Y");
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i = 0; i < cOSArray.size(); i++) {
            pDNumberFormatDictionaryArr[i] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i));
        }
        return pDNumberFormatDictionaryArr;
    }

    public float[] getCoordSystemOrigin() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
        if (cOSArray != null) {
            return cOSArray.toFloatArray();
        }
        return null;
    }

    public PDNumberFormatDictionary[] getDistances() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "D");
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i = 0; i < cOSArray.size(); i++) {
            pDNumberFormatDictionaryArr[i] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i));
        }
        return pDNumberFormatDictionaryArr;
    }

    public PDNumberFormatDictionary[] getLineSloaps() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "S");
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i = 0; i < cOSArray.size(); i++) {
            pDNumberFormatDictionaryArr[i] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i));
        }
        return pDNumberFormatDictionaryArr;
    }

    public String getScaleRatio() {
        return getDictionary().getString(COSName.R);
    }

    public void setAngles(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary add : pDNumberFormatDictionaryArr) {
            cOSArray.add((COSObjectable) add);
        }
        getDictionary().setItem((String) "T", (COSBase) cOSArray);
    }

    public void setAreas(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary add : pDNumberFormatDictionaryArr) {
            cOSArray.add((COSObjectable) add);
        }
        getDictionary().setItem(COSName.A, (COSBase) cOSArray);
    }

    public void setCYX(float f2) {
        getDictionary().setFloat((String) "CYX", f2);
    }

    public void setChangeXs(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary add : pDNumberFormatDictionaryArr) {
            cOSArray.add((COSObjectable) add);
        }
        getDictionary().setItem((String) "X", (COSBase) cOSArray);
    }

    public void setChangeYs(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary add : pDNumberFormatDictionaryArr) {
            cOSArray.add((COSObjectable) add);
        }
        getDictionary().setItem((String) "Y", (COSBase) cOSArray);
    }

    public void setCoordSystemOrigin(float[] fArr) {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(fArr);
        getDictionary().setItem((String) PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, (COSBase) cOSArray);
    }

    public void setDistances(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary add : pDNumberFormatDictionaryArr) {
            cOSArray.add((COSObjectable) add);
        }
        getDictionary().setItem((String) "D", (COSBase) cOSArray);
    }

    public void setLineSloaps(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary add : pDNumberFormatDictionaryArr) {
            cOSArray.add((COSObjectable) add);
        }
        getDictionary().setItem((String) "S", (COSBase) cOSArray);
    }

    public void setScaleRatio(String str) {
        getDictionary().setString(COSName.R, str);
    }

    public PDRectlinearMeasureDictionary(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
