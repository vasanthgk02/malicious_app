package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDAttributeObject;

public class PDTableAttributeObject extends PDStandardAttributeObject {
    public static final String COL_SPAN = "ColSpan";
    public static final String HEADERS = "Headers";
    public static final String OWNER_TABLE = "Table";
    public static final String ROW_SPAN = "RowSpan";
    public static final String SCOPE = "Scope";
    public static final String SCOPE_BOTH = "Both";
    public static final String SCOPE_COLUMN = "Column";
    public static final String SCOPE_ROW = "Row";
    public static final String SUMMARY = "Summary";

    public PDTableAttributeObject() {
        setOwner("Table");
    }

    public int getColSpan() {
        return getInteger(COL_SPAN, 1);
    }

    public String[] getHeaders() {
        return getArrayOfString(HEADERS);
    }

    public int getRowSpan() {
        return getInteger(ROW_SPAN, 1);
    }

    public String getScope() {
        return getName(SCOPE);
    }

    public String getSummary() {
        return getString(SUMMARY);
    }

    public void setColSpan(int i) {
        setInteger(COL_SPAN, i);
    }

    public void setHeaders(String[] strArr) {
        setArrayOfString(HEADERS, strArr);
    }

    public void setRowSpan(int i) {
        setInteger(ROW_SPAN, i);
    }

    public void setScope(String str) {
        setName(SCOPE, str);
    }

    public void setSummary(String str) {
        setString(SUMMARY, str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (isSpecified(ROW_SPAN)) {
            sb.append(", RowSpan=");
            sb.append(String.valueOf(getRowSpan()));
        }
        if (isSpecified(COL_SPAN)) {
            sb.append(", ColSpan=");
            sb.append(String.valueOf(getColSpan()));
        }
        if (isSpecified(HEADERS)) {
            sb.append(", Headers=");
            sb.append(PDAttributeObject.arrayToString((Object[]) getHeaders()));
        }
        if (isSpecified(SCOPE)) {
            sb.append(", Scope=");
            sb.append(getScope());
        }
        if (isSpecified(SUMMARY)) {
            sb.append(", Summary=");
            sb.append(getSummary());
        }
        return sb.toString();
    }

    public PDTableAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
