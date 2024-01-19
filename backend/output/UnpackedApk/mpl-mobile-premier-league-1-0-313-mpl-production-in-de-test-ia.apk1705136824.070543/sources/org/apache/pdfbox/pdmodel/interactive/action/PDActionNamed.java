package org.apache.pdfbox.pdmodel.interactive.action;

import org.apache.pdfbox.cos.COSDictionary;

public class PDActionNamed extends PDAction {
    public static final String SUB_TYPE = "Named";

    public PDActionNamed() {
        this.action = new COSDictionary();
        setSubType(SUB_TYPE);
    }

    public String getN() {
        return this.action.getNameAsString((String) "N");
    }

    public void setN(String str) {
        this.action.setName((String) "N", str);
    }

    public PDActionNamed(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
