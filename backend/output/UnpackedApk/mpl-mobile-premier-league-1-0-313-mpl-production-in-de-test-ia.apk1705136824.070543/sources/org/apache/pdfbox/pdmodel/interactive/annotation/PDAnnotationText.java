package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class PDAnnotationText extends PDAnnotationMarkup {
    public static final String NAME_COMMENT = "Comment";
    public static final String NAME_HELP = "Help";
    public static final String NAME_INSERT = "Insert";
    public static final String NAME_KEY = "Key";
    public static final String NAME_NEW_PARAGRAPH = "NewParagraph";
    public static final String NAME_NOTE = "Note";
    public static final String NAME_PARAGRAPH = "Paragraph";
    public static final String SUB_TYPE = "Text";

    public PDAnnotationText() {
        getDictionary().setItem(COSName.SUBTYPE, (COSBase) COSName.getPDFName("Text"));
    }

    public String getName() {
        return getDictionary().getNameAsString(COSName.NAME, (String) "Note");
    }

    public boolean getOpen() {
        return getDictionary().getBoolean(COSName.getPDFName("Open"), false);
    }

    public String getState() {
        return getDictionary().getString((String) "State");
    }

    public String getStateModel() {
        return getDictionary().getString((String) "StateModel");
    }

    public void setName(String str) {
        getDictionary().setName(COSName.NAME, str);
    }

    public void setOpen(boolean z) {
        getDictionary().setBoolean(COSName.getPDFName("Open"), z);
    }

    public void setState(String str) {
        getDictionary().setString((String) "State", str);
    }

    public void setStateModel(String str) {
        getDictionary().setString((String) "StateModel", str);
    }

    public PDAnnotationText(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
