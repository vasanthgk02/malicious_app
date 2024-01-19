package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;

public class PDFourColours implements COSObjectable {
    public final COSArray array;

    public PDFourColours() {
        COSArray cOSArray = new COSArray();
        this.array = cOSArray;
        cOSArray.add((COSBase) COSNull.NULL);
        this.array.add((COSBase) COSNull.NULL);
        this.array.add((COSBase) COSNull.NULL);
        this.array.add((COSBase) COSNull.NULL);
    }

    private PDGamma getColourByIndex(int i) {
        COSBase object = this.array.getObject(i);
        if (object instanceof COSArray) {
            return new PDGamma((COSArray) object);
        }
        return null;
    }

    private void setColourByIndex(int i, PDGamma pDGamma) {
        COSBase cOSBase;
        if (pDGamma == null) {
            cOSBase = COSNull.NULL;
        } else {
            cOSBase = pDGamma.getCOSArray();
        }
        this.array.set(i, cOSBase);
    }

    public PDGamma getAfterColour() {
        return getColourByIndex(1);
    }

    public PDGamma getBeforeColour() {
        return getColourByIndex(0);
    }

    public COSBase getCOSObject() {
        return this.array;
    }

    public PDGamma getEndColour() {
        return getColourByIndex(3);
    }

    public PDGamma getStartColour() {
        return getColourByIndex(2);
    }

    public void setAfterColour(PDGamma pDGamma) {
        setColourByIndex(1, pDGamma);
    }

    public void setBeforeColour(PDGamma pDGamma) {
        setColourByIndex(0, pDGamma);
    }

    public void setEndColour(PDGamma pDGamma) {
        setColourByIndex(3, pDGamma);
    }

    public void setStartColour(PDGamma pDGamma) {
        setColourByIndex(2, pDGamma);
    }

    public PDFourColours(COSArray cOSArray) {
        this.array = cOSArray;
        if (cOSArray.size() < 4) {
            for (int size = this.array.size() - 1; size < 4; size++) {
                this.array.add((COSBase) COSNull.NULL);
            }
        }
    }
}
