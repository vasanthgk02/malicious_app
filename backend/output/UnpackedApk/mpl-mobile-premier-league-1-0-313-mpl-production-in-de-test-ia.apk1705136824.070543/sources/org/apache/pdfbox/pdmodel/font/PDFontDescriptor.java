package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;

public final class PDFontDescriptor implements COSObjectable {
    public static final int FLAG_ALL_CAP = 65536;
    public static final int FLAG_FIXED_PITCH = 1;
    public static final int FLAG_FORCE_BOLD = 262144;
    public static final int FLAG_ITALIC = 64;
    public static final int FLAG_NON_SYMBOLIC = 32;
    public static final int FLAG_SCRIPT = 8;
    public static final int FLAG_SERIF = 2;
    public static final int FLAG_SMALL_CAP = 131072;
    public static final int FLAG_SYMBOLIC = 4;
    public float capHeight = Float.NEGATIVE_INFINITY;
    public final COSDictionary dic;
    public int flags = -1;
    public float xHeight = Float.NEGATIVE_INFINITY;

    public PDFontDescriptor() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dic = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.FONT_DESC);
    }

    private boolean isFlagBitOn(int i) {
        return (i & getFlags()) != 0;
    }

    private void setFlagBit(int i, boolean z) {
        int flags2 = getFlags();
        setFlags(z ? i | flags2 : (i ^ -1) & flags2);
    }

    public float getAscent() {
        return this.dic.getFloat(COSName.ASCENT, 0.0f);
    }

    public float getAverageWidth() {
        return this.dic.getFloat(COSName.AVG_WIDTH, 0.0f);
    }

    public float getCapHeight() {
        if (this.capHeight == Float.NEGATIVE_INFINITY) {
            this.capHeight = Math.abs(this.dic.getFloat(COSName.CAP_HEIGHT, 0.0f));
        }
        return this.capHeight;
    }

    public String getCharSet() {
        COSString cOSString = (COSString) this.dic.getDictionaryObject(COSName.CHAR_SET);
        if (cOSString != null) {
            return cOSString.getString();
        }
        return null;
    }

    public float getDescent() {
        return this.dic.getFloat(COSName.DESCENT, 0.0f);
    }

    public int getFlags() {
        if (this.flags == -1) {
            this.flags = this.dic.getInt(COSName.FLAGS, 0);
        }
        return this.flags;
    }

    public PDRectangle getFontBoundingBox() {
        COSArray cOSArray = (COSArray) this.dic.getDictionaryObject(COSName.FONT_BBOX);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    public String getFontFamily() {
        COSString cOSString = (COSString) this.dic.getDictionaryObject(COSName.FONT_FAMILY);
        if (cOSString != null) {
            return cOSString.getString();
        }
        return null;
    }

    public PDStream getFontFile() {
        COSBase dictionaryObject = this.dic.getDictionaryObject(COSName.FONT_FILE);
        if (dictionaryObject instanceof COSStream) {
            return new PDStream((COSStream) dictionaryObject);
        }
        return null;
    }

    public PDStream getFontFile2() {
        COSBase dictionaryObject = this.dic.getDictionaryObject(COSName.FONT_FILE2);
        if (dictionaryObject instanceof COSStream) {
            return new PDStream((COSStream) dictionaryObject);
        }
        return null;
    }

    public PDStream getFontFile3() {
        COSBase dictionaryObject = this.dic.getDictionaryObject(COSName.FONT_FILE3);
        if (dictionaryObject instanceof COSStream) {
            return new PDStream((COSStream) dictionaryObject);
        }
        return null;
    }

    public String getFontName() {
        COSName cOSName = (COSName) this.dic.getDictionaryObject(COSName.FONT_NAME);
        if (cOSName != null) {
            return cOSName.getName();
        }
        return null;
    }

    public String getFontStretch() {
        COSName cOSName = (COSName) this.dic.getDictionaryObject(COSName.FONT_STRETCH);
        if (cOSName != null) {
            return cOSName.getName();
        }
        return null;
    }

    public float getFontWeight() {
        return this.dic.getFloat(COSName.FONT_WEIGHT, 0.0f);
    }

    public float getItalicAngle() {
        return this.dic.getFloat(COSName.ITALIC_ANGLE, 0.0f);
    }

    public float getLeading() {
        return this.dic.getFloat(COSName.LEADING, 0.0f);
    }

    public float getMaxWidth() {
        return this.dic.getFloat(COSName.MAX_WIDTH, 0.0f);
    }

    public float getMissingWidth() {
        return this.dic.getFloat(COSName.MISSING_WIDTH, 0.0f);
    }

    public float getStemH() {
        return this.dic.getFloat(COSName.STEM_H, 0.0f);
    }

    public float getStemV() {
        return this.dic.getFloat(COSName.STEM_V, 0.0f);
    }

    public float getXHeight() {
        if (this.xHeight == Float.NEGATIVE_INFINITY) {
            this.xHeight = Math.abs(this.dic.getFloat(COSName.XHEIGHT, 0.0f));
        }
        return this.xHeight;
    }

    public boolean hasWidths() {
        return this.dic.containsKey(COSName.WIDTHS) || this.dic.containsKey(COSName.MISSING_WIDTH);
    }

    public boolean isAllCap() {
        return isFlagBitOn(65536);
    }

    public boolean isFixedPitch() {
        return isFlagBitOn(1);
    }

    public boolean isForceBold() {
        return isFlagBitOn(262144);
    }

    public boolean isItalic() {
        return isFlagBitOn(64);
    }

    public boolean isNonSymbolic() {
        return isFlagBitOn(32);
    }

    public boolean isScript() {
        return isFlagBitOn(8);
    }

    public boolean isSerif() {
        return isFlagBitOn(2);
    }

    public boolean isSmallCap() {
        return isFlagBitOn(131072);
    }

    public boolean isSymbolic() {
        return isFlagBitOn(4);
    }

    public void setAllCap(boolean z) {
        setFlagBit(65536, z);
    }

    public void setAscent(float f2) {
        this.dic.setFloat(COSName.ASCENT, f2);
    }

    public void setAverageWidth(float f2) {
        this.dic.setFloat(COSName.AVG_WIDTH, f2);
    }

    public void setCIDSet(PDStream pDStream) {
        this.dic.setItem(COSName.CID_SET, (COSObjectable) pDStream);
    }

    public void setCapHeight(float f2) {
        this.dic.setFloat(COSName.CAP_HEIGHT, f2);
        this.capHeight = f2;
    }

    public void setCharacterSet(String str) {
        this.dic.setItem(COSName.CHAR_SET, (COSBase) str != null ? new COSString(str) : null);
    }

    public void setDescent(float f2) {
        this.dic.setFloat(COSName.DESCENT, f2);
    }

    public void setFixedPitch(boolean z) {
        setFlagBit(1, z);
    }

    public void setFlags(int i) {
        this.dic.setInt(COSName.FLAGS, i);
        this.flags = i;
    }

    public void setFontBoundingBox(PDRectangle pDRectangle) {
        this.dic.setItem(COSName.FONT_BBOX, (COSBase) pDRectangle != null ? pDRectangle.getCOSArray() : null);
    }

    public void setFontFamily(String str) {
        this.dic.setItem(COSName.FONT_FAMILY, (COSBase) str != null ? new COSString(str) : null);
    }

    public void setFontFile(PDStream pDStream) {
        this.dic.setItem(COSName.FONT_FILE, (COSObjectable) pDStream);
    }

    public void setFontFile2(PDStream pDStream) {
        this.dic.setItem(COSName.FONT_FILE2, (COSObjectable) pDStream);
    }

    public void setFontFile3(PDStream pDStream) {
        this.dic.setItem(COSName.FONT_FILE3, (COSObjectable) pDStream);
    }

    public void setFontName(String str) {
        this.dic.setItem(COSName.FONT_NAME, (COSBase) str != null ? COSName.getPDFName(str) : null);
    }

    public void setFontStretch(String str) {
        this.dic.setItem(COSName.FONT_STRETCH, (COSBase) str != null ? COSName.getPDFName(str) : null);
    }

    public void setFontWeight(float f2) {
        this.dic.setFloat(COSName.FONT_WEIGHT, f2);
    }

    public void setForceBold(boolean z) {
        setFlagBit(262144, z);
    }

    public void setItalic(boolean z) {
        setFlagBit(64, z);
    }

    public void setItalicAngle(float f2) {
        this.dic.setFloat(COSName.ITALIC_ANGLE, f2);
    }

    public void setLeading(float f2) {
        this.dic.setFloat(COSName.LEADING, f2);
    }

    public void setMaxWidth(float f2) {
        this.dic.setFloat(COSName.MAX_WIDTH, f2);
    }

    public void setMissingWidth(float f2) {
        this.dic.setFloat(COSName.MISSING_WIDTH, f2);
    }

    public void setNonSymbolic(boolean z) {
        setFlagBit(32, z);
    }

    public void setScript(boolean z) {
        setFlagBit(8, z);
    }

    public void setSerif(boolean z) {
        setFlagBit(2, z);
    }

    public void setSmallCap(boolean z) {
        setFlagBit(131072, z);
    }

    public void setStemH(float f2) {
        this.dic.setFloat(COSName.STEM_H, f2);
    }

    public void setStemV(float f2) {
        this.dic.setFloat(COSName.STEM_V, f2);
    }

    public void setSymbolic(boolean z) {
        setFlagBit(4, z);
    }

    public void setXHeight(float f2) {
        this.dic.setFloat(COSName.XHEIGHT, f2);
        this.xHeight = f2;
    }

    public COSDictionary getCOSObject() {
        return this.dic;
    }

    public PDFontDescriptor(COSDictionary cOSDictionary) {
        this.dic = cOSDictionary;
    }
}
