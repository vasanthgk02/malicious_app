package org.apache.pdfbox.pdmodel.interactive.measurement;

import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;

public class PDNumberFormatDictionary implements COSObjectable {
    public static final String FRACTIONAL_DISPLAY_DECIMAL = "D";
    public static final String FRACTIONAL_DISPLAY_FRACTION = "F";
    public static final String FRACTIONAL_DISPLAY_ROUND = "R";
    public static final String FRACTIONAL_DISPLAY_TRUNCATE = "T";
    public static final String LABEL_PREFIX_TO_VALUE = "P";
    public static final String LABEL_SUFFIX_TO_VALUE = "S";
    public static final String TYPE = "NumberFormat";
    public COSDictionary numberFormatDictionary;

    public PDNumberFormatDictionary() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.numberFormatDictionary = cOSDictionary;
        cOSDictionary.setName(COSName.TYPE, (String) TYPE);
    }

    public COSBase getCOSObject() {
        return this.numberFormatDictionary;
    }

    public float getConversionFactor() {
        return getDictionary().getFloat((String) "C");
    }

    public String getDecimalSeparator() {
        return getDictionary().getString((String) "RD", (String) ".");
    }

    public int getDenominator() {
        return getDictionary().getInt((String) "D");
    }

    public COSDictionary getDictionary() {
        return this.numberFormatDictionary;
    }

    public String getFractionalDisplay() {
        return getDictionary().getString((String) FRACTIONAL_DISPLAY_FRACTION, (String) "D");
    }

    public String getLabelPositionToValue() {
        return getDictionary().getString((String) PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, (String) "S");
    }

    public String getLabelPrefixString() {
        return getDictionary().getString((String) "PS", (String) CMap.SPACE);
    }

    public String getLabelSuffixString() {
        return getDictionary().getString((String) "SS", (String) CMap.SPACE);
    }

    public String getThousandsSeparator() {
        return getDictionary().getString((String) StandardStructureTypes.RT, (String) ",");
    }

    public String getType() {
        return TYPE;
    }

    public String getUnits() {
        return getDictionary().getString((String) PDBorderStyleDictionary.STYLE_UNDERLINE);
    }

    public boolean isFD() {
        return getDictionary().getBoolean((String) "FD", false);
    }

    public void setConversionFactor(float f2) {
        getDictionary().setFloat((String) "C", f2);
    }

    public void setDecimalSeparator(String str) {
        getDictionary().setString((String) "RD", str);
    }

    public void setDenominator(int i) {
        getDictionary().setInt((String) "D", i);
    }

    public void setFD(boolean z) {
        getDictionary().setBoolean((String) "FD", z);
    }

    public void setFractionalDisplay(String str) {
        if (str == null || "D".equals(str) || FRACTIONAL_DISPLAY_FRACTION.equals(str) || "R".equals(str) || "T".equals(str)) {
            getDictionary().setString((String) FRACTIONAL_DISPLAY_FRACTION, str);
            return;
        }
        throw new IllegalArgumentException("Value must be \"D\", \"F\", \"R\", or \"T\", (or null).");
    }

    public void setLabelPositionToValue(String str) {
        if (str == null || "P".equals(str) || "S".equals(str)) {
            getDictionary().setString((String) PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, str);
            return;
        }
        throw new IllegalArgumentException("Value must be \"S\", or \"P\" (or null).");
    }

    public void setLabelPrefixString(String str) {
        getDictionary().setString((String) "PS", str);
    }

    public void setLabelSuffixString(String str) {
        getDictionary().setString((String) "SS", str);
    }

    public void setThousandsSeparator(String str) {
        getDictionary().setString((String) StandardStructureTypes.RT, str);
    }

    public void setUnits(String str) {
        getDictionary().setString((String) PDBorderStyleDictionary.STYLE_UNDERLINE, str);
    }

    public PDNumberFormatDictionary(COSDictionary cOSDictionary) {
        this.numberFormatDictionary = cOSDictionary;
    }
}
