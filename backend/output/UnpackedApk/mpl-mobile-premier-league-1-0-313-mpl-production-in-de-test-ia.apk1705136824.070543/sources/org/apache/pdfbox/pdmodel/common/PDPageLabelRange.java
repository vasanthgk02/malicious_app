package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class PDPageLabelRange implements COSObjectable {
    public static final COSName KEY_PREFIX = COSName.P;
    public static final COSName KEY_START = COSName.ST;
    public static final COSName KEY_STYLE = COSName.S;
    public static final String STYLE_DECIMAL = "D";
    public static final String STYLE_LETTERS_LOWER = "a";
    public static final String STYLE_LETTERS_UPPER = "A";
    public static final String STYLE_ROMAN_LOWER = "r";
    public static final String STYLE_ROMAN_UPPER = "R";
    public COSDictionary root;

    public PDPageLabelRange() {
        this(new COSDictionary());
    }

    public COSDictionary getCOSDictionary() {
        return this.root;
    }

    public COSBase getCOSObject() {
        return this.root;
    }

    public String getPrefix() {
        return this.root.getString(KEY_PREFIX);
    }

    public int getStart() {
        return this.root.getInt(KEY_START, 1);
    }

    public String getStyle() {
        return this.root.getNameAsString(KEY_STYLE);
    }

    public void setPrefix(String str) {
        if (str != null) {
            this.root.setString(KEY_PREFIX, str);
        } else {
            this.root.removeItem(KEY_PREFIX);
        }
    }

    public void setStart(int i) {
        if (i > 0) {
            this.root.setInt(KEY_START, i);
            return;
        }
        throw new IllegalArgumentException("The page numbering start value must be a positive integer");
    }

    public void setStyle(String str) {
        if (str != null) {
            this.root.setName(KEY_STYLE, str);
        } else {
            this.root.removeItem(KEY_STYLE);
        }
    }

    public PDPageLabelRange(COSDictionary cOSDictionary) {
        this.root = cOSDictionary;
    }
}
