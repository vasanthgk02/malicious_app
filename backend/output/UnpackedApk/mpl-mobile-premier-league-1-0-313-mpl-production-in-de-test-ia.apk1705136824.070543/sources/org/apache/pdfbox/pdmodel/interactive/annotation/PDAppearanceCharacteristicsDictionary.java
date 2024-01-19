package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;

public class PDAppearanceCharacteristicsDictionary implements COSObjectable {
    public final COSDictionary dictionary;

    public PDAppearanceCharacteristicsDictionary(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }

    private PDColor getColor(COSName cOSName) {
        COSBase item = getDictionary().getItem(cOSName);
        PDColorSpace pDColorSpace = null;
        if (!(item instanceof COSArray)) {
            return null;
        }
        COSArray cOSArray = (COSArray) item;
        int size = cOSArray.size();
        if (size == 1) {
            pDColorSpace = PDDeviceGray.INSTANCE;
        } else if (size == 3) {
            pDColorSpace = PDDeviceRGB.INSTANCE;
        }
        return new PDColor(cOSArray, pDColorSpace);
    }

    public String getAlternateCaption() {
        return getDictionary().getString((String) "AC");
    }

    public PDFormXObject getAlternateIcon() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject((String) "IX");
        if (dictionaryObject instanceof COSStream) {
            return new PDFormXObject(new PDStream((COSStream) dictionaryObject), "IX");
        }
        return null;
    }

    public PDColor getBackground() {
        return getColor(COSName.BG);
    }

    public PDColor getBorderColour() {
        return getColor(COSName.BC);
    }

    public COSBase getCOSObject() {
        return this.dictionary;
    }

    public COSDictionary getDictionary() {
        return this.dictionary;
    }

    public String getNormalCaption() {
        return getDictionary().getString((String) "CA");
    }

    public PDFormXObject getNormalIcon() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject((String) "I");
        if (dictionaryObject instanceof COSStream) {
            return new PDFormXObject(new PDStream((COSStream) dictionaryObject), "I");
        }
        return null;
    }

    public String getRolloverCaption() {
        return getDictionary().getString((String) "RC");
    }

    public PDFormXObject getRolloverIcon() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject((String) "RI");
        if (dictionaryObject instanceof COSStream) {
            return new PDFormXObject(new PDStream((COSStream) dictionaryObject), "RI");
        }
        return null;
    }

    public int getRotation() {
        return getDictionary().getInt(COSName.R, 0);
    }

    public void setAlternateCaption(String str) {
        getDictionary().setString((String) "AC", str);
    }

    public void setBackground(PDColor pDColor) {
        getDictionary().setItem(COSName.BG, (COSBase) pDColor.toCOSArray());
    }

    public void setBorderColour(PDColor pDColor) {
        getDictionary().setItem(COSName.BC, (COSBase) pDColor.toCOSArray());
    }

    public void setNormalCaption(String str) {
        getDictionary().setString((String) "CA", str);
    }

    public void setRolloverCaption(String str) {
        getDictionary().setString((String) "RC", str);
    }

    public void setRotation(int i) {
        getDictionary().setInt(COSName.R, i);
    }
}
