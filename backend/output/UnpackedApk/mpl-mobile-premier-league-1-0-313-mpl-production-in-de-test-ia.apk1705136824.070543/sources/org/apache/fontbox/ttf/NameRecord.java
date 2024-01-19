package org.apache.fontbox.ttf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.fontbox.cmap.CMap;

public class NameRecord {
    public static final int ENCODING_MACINTOSH_ROMAN = 0;
    public static final int ENCODING_UNICODE_1_0 = 0;
    public static final int ENCODING_UNICODE_1_1 = 1;
    public static final int ENCODING_UNICODE_2_0_BMP = 3;
    public static final int ENCODING_UNICODE_2_0_FULL = 4;
    public static final int ENCODING_WINDOWS_SYMBOL = 0;
    public static final int ENCODING_WINDOWS_UNICODE_BMP = 1;
    public static final int ENCODING_WINDOWS_UNICODE_UCS4 = 10;
    public static final int LANGUGAE_MACINTOSH_ENGLISH = 0;
    public static final int LANGUGAE_UNICODE = 0;
    public static final int LANGUGAE_WINDOWS_EN_US = 1033;
    public static final int NAME_COPYRIGHT = 0;
    public static final int NAME_FONT_FAMILY_NAME = 1;
    public static final int NAME_FONT_SUB_FAMILY_NAME = 2;
    public static final int NAME_FULL_FONT_NAME = 4;
    public static final int NAME_POSTSCRIPT_NAME = 6;
    public static final int NAME_TRADEMARK = 7;
    public static final int NAME_UNIQUE_FONT_ID = 3;
    public static final int NAME_VERSION = 5;
    public static final int PLATFORM_ISO = 2;
    public static final int PLATFORM_MACINTOSH = 1;
    public static final int PLATFORM_UNICODE = 0;
    public static final int PLATFORM_WINDOWS = 3;
    public int languageId;
    public int nameId;
    public int platformEncodingId;
    public int platformId;
    public String string;
    public int stringLength;
    public int stringOffset;

    public int getLanguageId() {
        return this.languageId;
    }

    public int getNameId() {
        return this.nameId;
    }

    public int getPlatformEncodingId() {
        return this.platformEncodingId;
    }

    public int getPlatformId() {
        return this.platformId;
    }

    public String getString() {
        return this.string;
    }

    public int getStringLength() {
        return this.stringLength;
    }

    public int getStringOffset() {
        return this.stringOffset;
    }

    public void initData(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.platformId = tTFDataStream.readUnsignedShort();
        this.platformEncodingId = tTFDataStream.readUnsignedShort();
        this.languageId = tTFDataStream.readUnsignedShort();
        this.nameId = tTFDataStream.readUnsignedShort();
        this.stringLength = tTFDataStream.readUnsignedShort();
        this.stringOffset = tTFDataStream.readUnsignedShort();
    }

    public void setLanguageId(int i) {
        this.languageId = i;
    }

    public void setNameId(int i) {
        this.nameId = i;
    }

    public void setPlatformEncodingId(int i) {
        this.platformEncodingId = i;
    }

    public void setPlatformId(int i) {
        this.platformId = i;
    }

    public void setString(String str) {
        this.string = str;
    }

    public void setStringLength(int i) {
        this.stringLength = i;
    }

    public void setStringOffset(int i) {
        this.stringOffset = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("platform=");
        outline73.append(this.platformId);
        outline73.append(" pEncoding=");
        outline73.append(this.platformEncodingId);
        outline73.append(" language=");
        outline73.append(this.languageId);
        outline73.append(" name=");
        outline73.append(this.nameId);
        outline73.append(CMap.SPACE);
        outline73.append(this.string);
        return outline73.toString();
    }
}
