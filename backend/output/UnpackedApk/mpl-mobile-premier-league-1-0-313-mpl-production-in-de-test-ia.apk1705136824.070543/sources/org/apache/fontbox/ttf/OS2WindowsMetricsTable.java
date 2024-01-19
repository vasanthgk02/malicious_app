package org.apache.fontbox.ttf;

import java.io.IOException;

public class OS2WindowsMetricsTable extends TTFTable {
    public static final int FAMILY_CLASS_CLAREDON_SERIFS = 4;
    public static final int FAMILY_CLASS_FREEFORM_SERIFS = 7;
    public static final int FAMILY_CLASS_MODERN_SERIFS = 3;
    public static final int FAMILY_CLASS_NO_CLASSIFICATION = 0;
    public static final int FAMILY_CLASS_OLDSTYLE_SERIFS = 1;
    public static final int FAMILY_CLASS_ORNAMENTALS = 9;
    public static final int FAMILY_CLASS_SANS_SERIF = 8;
    public static final int FAMILY_CLASS_SCRIPTS = 10;
    public static final int FAMILY_CLASS_SLAB_SERIFS = 5;
    public static final int FAMILY_CLASS_SYMBOLIC = 12;
    public static final int FAMILY_CLASS_TRANSITIONAL_SERIFS = 2;
    public static final short FSTYPE_BITMAP_ONLY = 512;
    public static final short FSTYPE_EDITIBLE = 4;
    public static final short FSTYPE_NO_SUBSETTING = 256;
    public static final short FSTYPE_PREVIEW_AND_PRINT = 4;
    public static final short FSTYPE_RESTRICTED = 1;
    public static final String TAG = "OS/2";
    public static final int WEIGHT_CLASS_BLACK = 900;
    public static final int WEIGHT_CLASS_BOLD = 700;
    public static final int WEIGHT_CLASS_EXTRA_BOLD = 800;
    public static final int WEIGHT_CLASS_LIGHT = 300;
    public static final int WEIGHT_CLASS_MEDIUM = 500;
    public static final int WEIGHT_CLASS_NORMAL = 400;
    public static final int WEIGHT_CLASS_SEMI_BOLD = 600;
    public static final int WEIGHT_CLASS_THIN = 100;
    public static final int WEIGHT_CLASS_ULTRA_LIGHT = 200;
    public static final int WIDTH_CLASS_CONDENSED = 3;
    public static final int WIDTH_CLASS_EXPANDED = 7;
    public static final int WIDTH_CLASS_EXTRA_CONDENSED = 2;
    public static final int WIDTH_CLASS_EXTRA_EXPANDED = 8;
    public static final int WIDTH_CLASS_MEDIUM = 5;
    public static final int WIDTH_CLASS_SEMI_CONDENSED = 4;
    public static final int WIDTH_CLASS_SEMI_EXPANDED = 6;
    public static final int WIDTH_CLASS_ULTRA_CONDENSED = 1;
    public static final int WIDTH_CLASS_ULTRA_EXPANDED = 9;
    public String achVendId = "XXXX";
    public short averageCharWidth;
    public long codePageRange1 = -1;
    public long codePageRange2 = -1;
    public int familyClass;
    public int familySubClass;
    public int firstCharIndex;
    public int fsSelection;
    public short fsType;
    public int lastCharIndex;
    public byte[] panose = new byte[10];
    public int sCapHeight;
    public short strikeoutPosition;
    public short strikeoutSize;
    public short subscriptXOffset;
    public short subscriptXSize;
    public short subscriptYOffset;
    public short subscriptYSize;
    public short superscriptXOffset;
    public short superscriptXSize;
    public short superscriptYOffset;
    public short superscriptYSize;
    public int sxHeight;
    public int typoAscender;
    public int typoDescender;
    public int typoLineGap;
    public long unicodeRange1;
    public long unicodeRange2;
    public long unicodeRange3;
    public long unicodeRange4;
    public int usBreakChar;
    public int usDefaultChar;
    public int usMaxContext;
    public int version;
    public int weightClass;
    public int widthClass;
    public int winAscent;
    public int winDescent;

    public String getAchVendId() {
        return this.achVendId;
    }

    public short getAverageCharWidth() {
        return this.averageCharWidth;
    }

    public int getBreakChar() {
        return this.usBreakChar;
    }

    public int getCapHeight() {
        return this.sCapHeight;
    }

    public long getCodePageRange1() {
        return this.codePageRange1;
    }

    public long getCodePageRange2() {
        return this.codePageRange2;
    }

    public int getDefaultChar() {
        return this.usDefaultChar;
    }

    public int getFamilyClass() {
        return this.familyClass;
    }

    public int getFamilySubClass() {
        return this.familySubClass;
    }

    public int getFirstCharIndex() {
        return this.firstCharIndex;
    }

    public int getFsSelection() {
        return this.fsSelection;
    }

    public short getFsType() {
        return this.fsType;
    }

    public int getHeight() {
        return this.sxHeight;
    }

    public int getLastCharIndex() {
        return this.lastCharIndex;
    }

    public int getMaxContext() {
        return this.usMaxContext;
    }

    public byte[] getPanose() {
        return this.panose;
    }

    public short getStrikeoutPosition() {
        return this.strikeoutPosition;
    }

    public short getStrikeoutSize() {
        return this.strikeoutSize;
    }

    public short getSubscriptXOffset() {
        return this.subscriptXOffset;
    }

    public short getSubscriptXSize() {
        return this.subscriptXSize;
    }

    public short getSubscriptYOffset() {
        return this.subscriptYOffset;
    }

    public short getSubscriptYSize() {
        return this.subscriptYSize;
    }

    public short getSuperscriptXOffset() {
        return this.superscriptXOffset;
    }

    public short getSuperscriptXSize() {
        return this.superscriptXSize;
    }

    public short getSuperscriptYOffset() {
        return this.superscriptYOffset;
    }

    public short getSuperscriptYSize() {
        return this.superscriptYSize;
    }

    public int getTypoAscender() {
        return this.typoAscender;
    }

    public int getTypoDescender() {
        return this.typoDescender;
    }

    public int getTypoLineGap() {
        return this.typoLineGap;
    }

    public long getUnicodeRange1() {
        return this.unicodeRange1;
    }

    public long getUnicodeRange2() {
        return this.unicodeRange2;
    }

    public long getUnicodeRange3() {
        return this.unicodeRange3;
    }

    public long getUnicodeRange4() {
        return this.unicodeRange4;
    }

    public int getVersion() {
        return this.version;
    }

    public int getWeightClass() {
        return this.weightClass;
    }

    public int getWidthClass() {
        return this.widthClass;
    }

    public int getWinAscent() {
        return this.winAscent;
    }

    public int getWinDescent() {
        return this.winDescent;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.version = tTFDataStream.readUnsignedShort();
        this.averageCharWidth = tTFDataStream.readSignedShort();
        this.weightClass = tTFDataStream.readUnsignedShort();
        this.widthClass = tTFDataStream.readUnsignedShort();
        this.fsType = tTFDataStream.readSignedShort();
        this.subscriptXSize = tTFDataStream.readSignedShort();
        this.subscriptYSize = tTFDataStream.readSignedShort();
        this.subscriptXOffset = tTFDataStream.readSignedShort();
        this.subscriptYOffset = tTFDataStream.readSignedShort();
        this.superscriptXSize = tTFDataStream.readSignedShort();
        this.superscriptYSize = tTFDataStream.readSignedShort();
        this.superscriptXOffset = tTFDataStream.readSignedShort();
        this.superscriptYOffset = tTFDataStream.readSignedShort();
        this.strikeoutSize = tTFDataStream.readSignedShort();
        this.strikeoutPosition = tTFDataStream.readSignedShort();
        this.familyClass = tTFDataStream.readUnsignedByte();
        this.familySubClass = tTFDataStream.readUnsignedByte();
        this.panose = tTFDataStream.read(10);
        this.unicodeRange1 = tTFDataStream.readUnsignedInt();
        this.unicodeRange2 = tTFDataStream.readUnsignedInt();
        this.unicodeRange3 = tTFDataStream.readUnsignedInt();
        this.unicodeRange4 = tTFDataStream.readUnsignedInt();
        this.achVendId = tTFDataStream.readString(4);
        this.fsSelection = tTFDataStream.readUnsignedShort();
        this.firstCharIndex = tTFDataStream.readUnsignedShort();
        this.lastCharIndex = tTFDataStream.readUnsignedShort();
        this.typoAscender = tTFDataStream.readSignedShort();
        this.typoDescender = tTFDataStream.readSignedShort();
        this.typoLineGap = tTFDataStream.readSignedShort();
        this.winAscent = tTFDataStream.readUnsignedShort();
        this.winDescent = tTFDataStream.readUnsignedShort();
        if (this.version >= 1) {
            this.codePageRange1 = tTFDataStream.readUnsignedInt();
            this.codePageRange2 = tTFDataStream.readUnsignedInt();
        }
        if (((double) this.version) >= 1.2d) {
            this.sxHeight = tTFDataStream.readSignedShort();
            this.sCapHeight = tTFDataStream.readSignedShort();
            this.usDefaultChar = tTFDataStream.readUnsignedShort();
            this.usBreakChar = tTFDataStream.readUnsignedShort();
            this.usMaxContext = tTFDataStream.readUnsignedShort();
        }
        this.initialized = true;
    }

    public void setAchVendId(String str) {
        this.achVendId = str;
    }

    public void setAverageCharWidth(short s) {
        this.averageCharWidth = s;
    }

    public void setCodePageRange1(long j) {
        this.codePageRange1 = j;
    }

    public void setCodePageRange2(long j) {
        this.codePageRange2 = j;
    }

    public void setFamilyClass(int i) {
        this.familyClass = i;
    }

    public void setFamilySubClass(int i) {
        this.familySubClass = i;
    }

    public void setFirstCharIndex(int i) {
        this.firstCharIndex = i;
    }

    public void setFsSelection(int i) {
        this.fsSelection = i;
    }

    public void setFsType(short s) {
        this.fsType = s;
    }

    public void setLastCharIndex(int i) {
        this.lastCharIndex = i;
    }

    public void setPanose(byte[] bArr) {
        this.panose = bArr;
    }

    public void setStrikeoutPosition(short s) {
        this.strikeoutPosition = s;
    }

    public void setStrikeoutSize(short s) {
        this.strikeoutSize = s;
    }

    public void setSubscriptXOffset(short s) {
        this.subscriptXOffset = s;
    }

    public void setSubscriptXSize(short s) {
        this.subscriptXSize = s;
    }

    public void setSubscriptYOffset(short s) {
        this.subscriptYOffset = s;
    }

    public void setSubscriptYSize(short s) {
        this.subscriptYSize = s;
    }

    public void setSuperscriptXOffset(short s) {
        this.superscriptXOffset = s;
    }

    public void setSuperscriptXSize(short s) {
        this.superscriptXSize = s;
    }

    public void setSuperscriptYOffset(short s) {
        this.superscriptYOffset = s;
    }

    public void setSuperscriptYSize(short s) {
        this.superscriptYSize = s;
    }

    public void setTypeLineGap(int i) {
        this.typoLineGap = i;
    }

    public void setTypoAscender(int i) {
        this.typoAscender = i;
    }

    public void setTypoDescender(int i) {
        this.typoDescender = i;
    }

    public void setUnicodeRange1(long j) {
        this.unicodeRange1 = j;
    }

    public void setUnicodeRange2(long j) {
        this.unicodeRange2 = j;
    }

    public void setUnicodeRange3(long j) {
        this.unicodeRange3 = j;
    }

    public void setUnicodeRange4(long j) {
        this.unicodeRange4 = j;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setWeightClass(int i) {
        this.weightClass = i;
    }

    public void setWidthClass(int i) {
        this.widthClass = i;
    }

    public void setWinAscent(int i) {
        this.winAscent = i;
    }

    public void setWinDescent(int i) {
        this.winDescent = i;
    }
}
