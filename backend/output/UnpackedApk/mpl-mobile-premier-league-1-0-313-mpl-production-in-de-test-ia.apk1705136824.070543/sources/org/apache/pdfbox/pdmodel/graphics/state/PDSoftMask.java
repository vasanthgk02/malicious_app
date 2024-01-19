package org.apache.pdfbox.pdmodel.graphics.state;

import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;

public final class PDSoftMask implements COSObjectable {
    public COSArray backdropColor = null;
    public COSDictionary dictionary;
    public PDFormXObject group = null;
    public COSName subType = null;
    public PDFunction transferFunction = null;

    public PDSoftMask(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }

    public static PDSoftMask create(COSBase cOSBase) {
        if (cOSBase instanceof COSName) {
            if (COSName.NONE.equals(cOSBase)) {
                return null;
            }
            "Invalid SMask " + cOSBase;
            return null;
        } else if (cOSBase instanceof COSDictionary) {
            return new PDSoftMask((COSDictionary) cOSBase);
        } else {
            "Invalid SMask " + cOSBase;
            return null;
        }
    }

    public COSArray getBackdropColor() {
        if (this.backdropColor == null) {
            this.backdropColor = (COSArray) getCOSDictionary().getDictionaryObject(COSName.BC);
        }
        return this.backdropColor;
    }

    public COSDictionary getCOSDictionary() {
        return this.dictionary;
    }

    public COSBase getCOSObject() {
        return this.dictionary;
    }

    public PDFormXObject getGroup() throws IOException {
        if (this.group == null) {
            COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(COSName.G);
            if (dictionaryObject != null) {
                this.group = (PDFormXObject) PDXObject.createXObject(dictionaryObject, COSName.G.getName(), null);
            }
        }
        return this.group;
    }

    public COSName getSubType() {
        if (this.subType == null) {
            this.subType = (COSName) getCOSDictionary().getDictionaryObject(COSName.S);
        }
        return this.subType;
    }

    public PDFunction getTransferFunction() throws IOException {
        if (this.transferFunction == null) {
            COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(COSName.TR);
            if (dictionaryObject != null) {
                this.transferFunction = PDFunction.create(dictionaryObject);
            }
        }
        return this.transferFunction;
    }
}
