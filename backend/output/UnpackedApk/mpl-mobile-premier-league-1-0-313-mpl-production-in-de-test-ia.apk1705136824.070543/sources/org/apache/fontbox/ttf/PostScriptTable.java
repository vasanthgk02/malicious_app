package org.apache.fontbox.ttf;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.IOException;

public class PostScriptTable extends TTFTable {
    public static final String TAG = "post";
    public float formatType;
    public String[] glyphNames = null;
    public long isFixedPitch;
    public float italicAngle;
    public long maxMemType1;
    public long maxMemType42;
    public long minMemType1;
    public long minMemType42;
    public short underlinePosition;
    public short underlineThickness;

    public float getFormatType() {
        return this.formatType;
    }

    public String[] getGlyphNames() {
        return this.glyphNames;
    }

    public long getIsFixedPitch() {
        return this.isFixedPitch;
    }

    public float getItalicAngle() {
        return this.italicAngle;
    }

    public long getMaxMemType1() {
        return this.maxMemType1;
    }

    public long getMaxMemType42() {
        return this.maxMemType42;
    }

    public long getMinMemType1() {
        return this.minMemType1;
    }

    public long getMinMemType42() {
        return this.minMemType42;
    }

    public String getName(int i) {
        if (i >= 0) {
            String[] strArr = this.glyphNames;
            if (strArr != null && i <= strArr.length) {
                return strArr[i];
            }
        }
        return null;
    }

    public short getUnderlinePosition() {
        return this.underlinePosition;
    }

    public short getUnderlineThickness() {
        return this.underlineThickness;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.formatType = tTFDataStream.read32Fixed();
        this.italicAngle = tTFDataStream.read32Fixed();
        this.underlinePosition = tTFDataStream.readSignedShort();
        this.underlineThickness = tTFDataStream.readSignedShort();
        this.isFixedPitch = tTFDataStream.readUnsignedInt();
        this.minMemType42 = tTFDataStream.readUnsignedInt();
        this.maxMemType42 = tTFDataStream.readUnsignedInt();
        this.minMemType1 = tTFDataStream.readUnsignedInt();
        this.maxMemType1 = tTFDataStream.readUnsignedInt();
        float f2 = this.formatType;
        int i = 0;
        if (f2 == 1.0f) {
            String[] strArr = new String[258];
            this.glyphNames = strArr;
            System.arraycopy(WGL4Names.MAC_GLYPH_NAMES, 0, strArr, 0, 258);
        } else if (f2 == 2.0f) {
            int readUnsignedShort = tTFDataStream.readUnsignedShort();
            int[] iArr = new int[readUnsignedShort];
            this.glyphNames = new String[readUnsignedShort];
            int i2 = LinearLayoutManager.INVALID_OFFSET;
            for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                int readUnsignedShort2 = tTFDataStream.readUnsignedShort();
                iArr[i3] = readUnsignedShort2;
                if (readUnsignedShort2 <= 32767) {
                    i2 = Math.max(i2, readUnsignedShort2);
                }
            }
            String[] strArr2 = null;
            if (i2 >= 258) {
                int i4 = (i2 - 258) + 1;
                strArr2 = new String[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    strArr2[i5] = tTFDataStream.readString(tTFDataStream.readUnsignedByte());
                }
            }
            while (i < readUnsignedShort) {
                int i6 = iArr[i];
                if (i6 < 258) {
                    this.glyphNames[i] = WGL4Names.MAC_GLYPH_NAMES[i6];
                } else if (i6 < 258 || i6 > 32767) {
                    this.glyphNames[i] = ".undefined";
                } else {
                    this.glyphNames[i] = strArr2[i6 - 258];
                }
                i++;
            }
        } else if (f2 == 2.5f) {
            int numberOfGlyphs = trueTypeFont.getNumberOfGlyphs();
            int[] iArr2 = new int[numberOfGlyphs];
            int i7 = 0;
            while (i7 < numberOfGlyphs) {
                int i8 = i7 + 1;
                iArr2[i7] = tTFDataStream.readSignedByte() + i8;
                i7 = i8;
            }
            this.glyphNames = new String[numberOfGlyphs];
            while (true) {
                String[] strArr3 = this.glyphNames;
                if (i >= strArr3.length) {
                    break;
                }
                String str = WGL4Names.MAC_GLYPH_NAMES[iArr2[i]];
                if (str != null) {
                    strArr3[i] = str;
                }
                i++;
            }
        }
        this.initialized = true;
    }

    public void setFormatType(float f2) {
        this.formatType = f2;
    }

    public void setGlyphNames(String[] strArr) {
        this.glyphNames = strArr;
    }

    public void setIsFixedPitch(long j) {
        this.isFixedPitch = j;
    }

    public void setItalicAngle(float f2) {
        this.italicAngle = f2;
    }

    public void setMaxMemType1(long j) {
        this.maxMemType1 = j;
    }

    public void setMaxMemType42(long j) {
        this.maxMemType42 = j;
    }

    public void setMimMemType1(long j) {
        this.minMemType1 = j;
    }

    public void setMinMemType42(long j) {
        this.minMemType42 = j;
    }

    public void setUnderlinePosition(short s) {
        this.underlinePosition = s;
    }

    public void setUnderlineThickness(short s) {
        this.underlineThickness = s;
    }
}
