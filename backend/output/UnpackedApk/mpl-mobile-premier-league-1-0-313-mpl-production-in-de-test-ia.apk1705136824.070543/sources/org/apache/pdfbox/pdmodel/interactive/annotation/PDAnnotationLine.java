package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;

public class PDAnnotationLine extends PDAnnotationMarkup {
    public static final String IT_LINE_ARROW = "LineArrow";
    public static final String IT_LINE_DIMENSION = "LineDimension";
    public static final String LE_BUTT = "Butt";
    public static final String LE_CIRCLE = "Circle";
    public static final String LE_CLOSED_ARROW = "ClosedArrow";
    public static final String LE_DIAMOND = "Diamond";
    public static final String LE_NONE = "None";
    public static final String LE_OPEN_ARROW = "OpenArrow";
    public static final String LE_R_CLOSED_ARROW = "RClosedArrow";
    public static final String LE_R_OPEN_ARROW = "ROpenArrow";
    public static final String LE_SLASH = "Slash";
    public static final String LE_SQUARE = "Square";
    public static final String SUB_TYPE = "Line";

    public PDAnnotationLine() {
        getDictionary().setItem(COSName.SUBTYPE, (COSBase) COSName.getPDFName("Line"));
        setLine(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
    }

    public PDBorderStyleDictionary getBorderStyle() {
        COSDictionary cOSDictionary = (COSDictionary) getDictionary().getItem(COSName.BS);
        if (cOSDictionary != null) {
            return new PDBorderStyleDictionary(cOSDictionary);
        }
        return null;
    }

    public boolean getCaption() {
        return getDictionary().getBoolean((String) "Cap", false);
    }

    public float getCaptionHorizontalOffset() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "CO");
        if (cOSArray != null) {
            return cOSArray.toFloatArray()[0];
        }
        return 0.0f;
    }

    public String getCaptionPositioning() {
        return getDictionary().getString((String) "CP");
    }

    public float getCaptionVerticalOffset() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "CO");
        if (cOSArray != null) {
            return cOSArray.toFloatArray()[1];
        }
        return 0.0f;
    }

    public String getEndPointEndingStyle() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "LE");
        return cOSArray != null ? cOSArray.getName(1) : "None";
    }

    public PDColor getInteriorColor() {
        return getColor(COSName.IC);
    }

    public float getLeaderLineExtensionLength() {
        return getDictionary().getFloat((String) "LLE");
    }

    public float getLeaderLineLength() {
        return getDictionary().getFloat((String) "LL");
    }

    public float getLeaderLineOffsetLength() {
        return getDictionary().getFloat((String) "LLO");
    }

    public float[] getLine() {
        return ((COSArray) getDictionary().getDictionaryObject((String) "L")).toFloatArray();
    }

    public String getStartPointEndingStyle() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "LE");
        return cOSArray != null ? cOSArray.getName(0) : "None";
    }

    public void setBorderStyle(PDBorderStyleDictionary pDBorderStyleDictionary) {
        getDictionary().setItem((String) "BS", (COSObjectable) pDBorderStyleDictionary);
    }

    public void setCaption(boolean z) {
        getDictionary().setBoolean((String) "Cap", z);
    }

    public void setCaptionHorizontalOffset(float f2) {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "CO");
        if (cOSArray == null) {
            COSArray cOSArray2 = new COSArray();
            cOSArray2.setFloatArray(new float[]{f2, 0.0f});
            getDictionary().setItem((String) "CO", (COSBase) cOSArray2);
            return;
        }
        cOSArray.set(0, (COSBase) new COSFloat(f2));
    }

    public void setCaptionPositioning(String str) {
        getDictionary().setString((String) "CP", str);
    }

    public void setCaptionVerticalOffset(float f2) {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "CO");
        if (cOSArray == null) {
            COSArray cOSArray2 = new COSArray();
            cOSArray2.setFloatArray(new float[]{0.0f, f2});
            getDictionary().setItem((String) "CO", (COSBase) cOSArray2);
            return;
        }
        cOSArray.set(1, (COSBase) new COSFloat(f2));
    }

    public void setEndPointEndingStyle(String str) {
        if (str == null) {
            str = "None";
        }
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "LE");
        if (cOSArray == null) {
            COSArray cOSArray2 = new COSArray();
            cOSArray2.add((COSBase) COSName.getPDFName("None"));
            cOSArray2.add((COSBase) COSName.getPDFName(str));
            getDictionary().setItem((String) "LE", (COSBase) cOSArray2);
            return;
        }
        cOSArray.setName(1, str);
    }

    public void setInteriorColor(PDColor pDColor) {
        getDictionary().setItem(COSName.IC, (COSBase) pDColor.toCOSArray());
    }

    public void setLeaderLineExtensionLength(float f2) {
        getDictionary().setFloat((String) "LLE", f2);
    }

    public void setLeaderLineLength(float f2) {
        getDictionary().setFloat((String) "LL", f2);
    }

    public void setLeaderLineOffsetLength(float f2) {
        getDictionary().setFloat((String) "LLO", f2);
    }

    public void setLine(float[] fArr) {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(fArr);
        getDictionary().setItem((String) "L", (COSBase) cOSArray);
    }

    public void setStartPointEndingStyle(String str) {
        if (str == null) {
            str = "None";
        }
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "LE");
        if (cOSArray == null) {
            COSArray cOSArray2 = new COSArray();
            cOSArray2.add((COSBase) COSName.getPDFName(str));
            cOSArray2.add((COSBase) COSName.getPDFName("None"));
            getDictionary().setItem((String) "LE", (COSBase) cOSArray2);
            return;
        }
        cOSArray.setName(0, str);
    }

    public PDAnnotationLine(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
