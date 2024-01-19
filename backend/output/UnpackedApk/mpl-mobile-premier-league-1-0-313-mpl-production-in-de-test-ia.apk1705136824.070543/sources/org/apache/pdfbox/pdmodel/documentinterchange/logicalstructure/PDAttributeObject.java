package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDExportFormatAttributeObject;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDListAttributeObject;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDTableAttributeObject;

public abstract class PDAttributeObject extends PDDictionaryWrapper {
    public PDStructureElement structureElement;

    public PDAttributeObject() {
    }

    public static String arrayToString(Object[] objArr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < objArr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(objArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public static PDAttributeObject create(COSDictionary cOSDictionary) {
        String nameAsString = cOSDictionary.getNameAsString(COSName.O);
        if (PDUserAttributeObject.OWNER_USER_PROPERTIES.equals(nameAsString)) {
            return new PDUserAttributeObject(cOSDictionary);
        }
        if (PDListAttributeObject.OWNER_LIST.equals(nameAsString)) {
            return new PDListAttributeObject(cOSDictionary);
        }
        if (PDPrintFieldAttributeObject.OWNER_PRINT_FIELD.equals(nameAsString)) {
            return new PDPrintFieldAttributeObject(cOSDictionary);
        }
        if ("Table".equals(nameAsString)) {
            return new PDTableAttributeObject(cOSDictionary);
        }
        if (PDLayoutAttributeObject.OWNER_LAYOUT.equals(nameAsString)) {
            return new PDLayoutAttributeObject(cOSDictionary);
        }
        if (PDExportFormatAttributeObject.OWNER_XML_1_00.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_HTML_3_20.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_HTML_4_01.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_OEB_1_00.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_RTF_1_05.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_CSS_1_00.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_CSS_2_00.equals(nameAsString)) {
            return new PDExportFormatAttributeObject(cOSDictionary);
        }
        return new PDDefaultAttributeObject(cOSDictionary);
    }

    private PDStructureElement getStructureElement() {
        return this.structureElement;
    }

    public static boolean isValueChanged(COSBase cOSBase, COSBase cOSBase2) {
        boolean z = true;
        if (cOSBase != null) {
            return !cOSBase.equals(cOSBase2);
        }
        if (cOSBase2 == null) {
            z = false;
        }
        return z;
    }

    public String getOwner() {
        return getCOSDictionary().getNameAsString(COSName.O);
    }

    public boolean isEmpty() {
        return getCOSDictionary().size() == 1 && getOwner() != null;
    }

    public void notifyChanged() {
        if (getStructureElement() != null) {
            getStructureElement().attributeChanged(this);
        }
    }

    public void potentiallyNotifyChanged(COSBase cOSBase, COSBase cOSBase2) {
        if (isValueChanged(cOSBase, cOSBase2)) {
            notifyChanged();
        }
    }

    public void setOwner(String str) {
        getCOSDictionary().setName(COSName.O, str);
    }

    public void setStructureElement(PDStructureElement pDStructureElement) {
        this.structureElement = pDStructureElement;
    }

    public String toString() {
        return "O=" + getOwner();
    }

    public PDAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public static String arrayToString(float[] fArr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < fArr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(fArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
