package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionFactory;
import org.apache.pdfbox.pdmodel.interactive.action.PDAnnotationAdditionalActions;

public class PDAnnotationWidget extends PDAnnotation {
    public static final String SUB_TYPE = "Widget";

    public PDAnnotationWidget() {
        getDictionary().setName(COSName.SUBTYPE, (String) SUB_TYPE);
    }

    public PDAction getAction() {
        return PDActionFactory.createAction((COSDictionary) getDictionary().getDictionaryObject(COSName.A));
    }

    public PDAnnotationAdditionalActions getActions() {
        COSDictionary cOSDictionary = (COSDictionary) getDictionary().getDictionaryObject((String) "AA");
        if (cOSDictionary != null) {
            return new PDAnnotationAdditionalActions(cOSDictionary);
        }
        return null;
    }

    public PDAppearanceCharacteristicsDictionary getAppearanceCharacteristics() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject(COSName.MK);
        if (dictionaryObject instanceof COSDictionary) {
            return new PDAppearanceCharacteristicsDictionary((COSDictionary) dictionaryObject);
        }
        return null;
    }

    public PDBorderStyleDictionary getBorderStyle() {
        COSDictionary cOSDictionary = (COSDictionary) getDictionary().getItem(COSName.BS);
        if (cOSDictionary != null) {
            return new PDBorderStyleDictionary(cOSDictionary);
        }
        return null;
    }

    public String getHighlightingMode() {
        return getDictionary().getNameAsString(COSName.H, (String) "I");
    }

    public void setAction(PDAction pDAction) {
        getDictionary().setItem(COSName.A, (COSObjectable) pDAction);
    }

    public void setActions(PDAnnotationAdditionalActions pDAnnotationAdditionalActions) {
        getDictionary().setItem((String) "AA", (COSObjectable) pDAnnotationAdditionalActions);
    }

    public void setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary pDAppearanceCharacteristicsDictionary) {
        getDictionary().setItem(COSName.MK, (COSObjectable) pDAppearanceCharacteristicsDictionary);
    }

    public void setBorderStyle(PDBorderStyleDictionary pDBorderStyleDictionary) {
        getDictionary().setItem((String) "BS", (COSObjectable) pDBorderStyleDictionary);
    }

    public void setHighlightingMode(String str) {
        if (str == null || "N".equals(str) || "I".equals(str) || PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE.equals(str) || "P".equals(str) || "T".equals(str)) {
            getDictionary().setName(COSName.H, str);
            return;
        }
        throw new IllegalArgumentException("Valid values for highlighting mode are 'N', 'N', 'O', 'P' or 'T'");
    }

    public PDAnnotationWidget(COSDictionary cOSDictionary) {
        super(cOSDictionary);
        getDictionary().setName(COSName.SUBTYPE, (String) SUB_TYPE);
    }
}
