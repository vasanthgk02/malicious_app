package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import org.apache.pdfbox.cos.COSDictionary;

public class PDPrintFieldAttributeObject extends PDStandardAttributeObject {
    public static final String CHECKED = "checked";
    public static final String CHECKED_STATE_NEUTRAL = "neutral";
    public static final String CHECKED_STATE_OFF = "off";
    public static final String CHECKED_STATE_ON = "on";
    public static final String DESC = "Desc";
    public static final String OWNER_PRINT_FIELD = "PrintField";
    public static final String ROLE = "Role";
    public static final String ROLE_CB = "cb";
    public static final String ROLE_PB = "pb";
    public static final String ROLE_RB = "rb";
    public static final String ROLE_TV = "tv";

    public PDPrintFieldAttributeObject() {
        setOwner(OWNER_PRINT_FIELD);
    }

    public String getAlternateName() {
        return getString(DESC);
    }

    public String getCheckedState() {
        return getName("checked", CHECKED_STATE_OFF);
    }

    public String getRole() {
        return getName(ROLE);
    }

    public void setAlternateName(String str) {
        setString(DESC, str);
    }

    public void setCheckedState(String str) {
        setName("checked", str);
    }

    public void setRole(String str) {
        setName(ROLE, str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (isSpecified(ROLE)) {
            sb.append(", Role=");
            sb.append(getRole());
        }
        if (isSpecified("checked")) {
            sb.append(", Checked=");
            sb.append(getCheckedState());
        }
        if (isSpecified(DESC)) {
            sb.append(", Desc=");
            sb.append(getAlternateName());
        }
        return sb.toString();
    }

    public PDPrintFieldAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
