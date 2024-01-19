package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;

public class PDObjectReference implements COSObjectable {
    public static final String TYPE = "OBJR";
    public COSDictionary dictionary;

    public PDObjectReference() {
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

    public COSObjectable getReferencedObject() {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(COSName.OBJ);
        if (!(dictionaryObject instanceof COSDictionary)) {
            return null;
        }
        try {
            PDXObject createXObject = PDXObject.createXObject(dictionaryObject, null, null);
            if (createXObject != null) {
                return createXObject;
            }
            COSDictionary cOSDictionary = (COSDictionary) dictionaryObject;
            PDAnnotation createAnnotation = PDAnnotation.createAnnotation(dictionaryObject);
            if (!(createAnnotation instanceof PDAnnotationUnknown) || COSName.ANNOT.equals(cOSDictionary.getDictionaryObject(COSName.TYPE))) {
                return createAnnotation;
            }
            return null;
        } catch (IOException unused) {
        }
    }

    public void setReferencedObject(PDAnnotation pDAnnotation) {
        getCOSDictionary().setItem(COSName.OBJ, (COSObjectable) pDAnnotation);
    }

    public void setReferencedObject(PDXObject pDXObject) {
        getCOSDictionary().setItem(COSName.OBJ, (COSObjectable) pDXObject);
    }

    public PDObjectReference(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
