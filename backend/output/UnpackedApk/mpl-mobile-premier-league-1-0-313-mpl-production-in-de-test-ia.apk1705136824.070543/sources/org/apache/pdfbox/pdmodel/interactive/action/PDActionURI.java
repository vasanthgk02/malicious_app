package org.apache.pdfbox.pdmodel.interactive.action;

import org.apache.pdfbox.cos.COSDictionary;

public class PDActionURI extends PDAction {
    public static final String SUB_TYPE = "URI";

    public PDActionURI() {
        this.action = new COSDictionary();
        setSubType(SUB_TYPE);
    }

    public String getS() {
        return this.action.getNameAsString((String) "S");
    }

    public String getURI() {
        return this.action.getString((String) SUB_TYPE);
    }

    public void setS(String str) {
        this.action.setName((String) "S", str);
    }

    public void setTrackMousePosition(boolean z) {
        this.action.setBoolean((String) "IsMap", z);
    }

    public void setURI(String str) {
        this.action.setString((String) SUB_TYPE, str);
    }

    public boolean shouldTrackMousePosition() {
        return this.action.getBoolean((String) "IsMap", false);
    }

    public PDActionURI(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
