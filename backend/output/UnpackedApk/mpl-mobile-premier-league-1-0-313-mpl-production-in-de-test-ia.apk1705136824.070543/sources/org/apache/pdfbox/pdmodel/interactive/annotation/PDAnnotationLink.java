package org.apache.pdfbox.pdmodel.interactive.annotation;

import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionFactory;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;

public class PDAnnotationLink extends PDAnnotation {
    public static final String HIGHLIGHT_MODE_INVERT = "I";
    public static final String HIGHLIGHT_MODE_NONE = "N";
    public static final String HIGHLIGHT_MODE_OUTLINE = "O";
    public static final String HIGHLIGHT_MODE_PUSH = "P";
    public static final String SUB_TYPE = "Link";

    public PDAnnotationLink() {
        getDictionary().setItem(COSName.SUBTYPE, (COSBase) COSName.getPDFName("Link"));
    }

    public PDAction getAction() {
        return PDActionFactory.createAction((COSDictionary) getDictionary().getDictionaryObject(COSName.A));
    }

    public PDBorderStyleDictionary getBorderStyle() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject(COSName.BS);
        if (dictionaryObject instanceof COSDictionary) {
            return new PDBorderStyleDictionary((COSDictionary) dictionaryObject);
        }
        return null;
    }

    public PDDestination getDestination() throws IOException {
        return PDDestination.create(getDictionary().getDictionaryObject(COSName.DEST));
    }

    public String getHighlightMode() {
        return getDictionary().getNameAsString(COSName.H, (String) "I");
    }

    public PDActionURI getPreviousURI() {
        COSDictionary cOSDictionary = (COSDictionary) getDictionary().getDictionaryObject((String) "PA");
        if (cOSDictionary != null) {
            return new PDActionURI(cOSDictionary);
        }
        return null;
    }

    public float[] getQuadPoints() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "QuadPoints");
        if (cOSArray != null) {
            return cOSArray.toFloatArray();
        }
        return null;
    }

    public void setAction(PDAction pDAction) {
        getDictionary().setItem(COSName.A, (COSObjectable) pDAction);
    }

    public void setBorderStyle(PDBorderStyleDictionary pDBorderStyleDictionary) {
        getDictionary().setItem(COSName.BS, (COSObjectable) pDBorderStyleDictionary);
    }

    public void setDestination(PDDestination pDDestination) {
        getDictionary().setItem(COSName.DEST, (COSObjectable) pDDestination);
    }

    public void setHighlightMode(String str) {
        getDictionary().setName(COSName.H, str);
    }

    public void setPreviousURI(PDActionURI pDActionURI) {
        getDictionary().setItem((String) "PA", (COSObjectable) pDActionURI);
    }

    public void setQuadPoints(float[] fArr) {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(fArr);
        getDictionary().setItem((String) "QuadPoints", (COSBase) cOSArray);
    }

    public PDAnnotationLink(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
