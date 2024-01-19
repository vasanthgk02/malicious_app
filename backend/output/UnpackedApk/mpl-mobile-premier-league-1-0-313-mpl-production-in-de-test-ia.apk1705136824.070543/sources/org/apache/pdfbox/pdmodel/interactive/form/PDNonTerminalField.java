package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;

public class PDNonTerminalField extends PDFieldTreeNode {
    public PDNonTerminalField(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
    }

    public Object getDefaultValue() {
        return getDictionary().getNameAsString(COSName.V);
    }

    public int getFieldFlags() {
        COSInteger cOSInteger = (COSInteger) getDictionary().getDictionaryObject(COSName.FF);
        if (cOSInteger != null) {
            return cOSInteger.intValue();
        }
        return 0;
    }

    public String getFieldType() {
        return getDictionary().getNameAsString(COSName.FT);
    }

    public Object getValue() {
        return getDictionary().getNameAsString(COSName.V);
    }

    public void setDefaultValue(String str) {
        getDictionary().setString(COSName.V, str);
    }

    public void setValue(String str) {
        getDictionary().setString(COSName.V, str);
    }

    public PDNonTerminalField(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }
}
