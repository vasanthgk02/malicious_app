package org.apache.pdfbox.pdmodel.font;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.encoding.Encoding;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.CmapTable;
import org.apache.fontbox.ttf.GlyphData;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.pdmodel.font.encoding.MacOSRomanEncoding;

public class PDTrueTypeFont extends PDSimpleFont {
    public static final Map<String, Integer> INVERTED_MACOS_ROMAN = new HashMap();
    public static final int START_RANGE_F000 = 61440;
    public static final int START_RANGE_F100 = 61696;
    public static final int START_RANGE_F200 = 61952;
    public boolean cmapInitialized;
    public CmapSubtable cmapMacRoman;
    public CmapSubtable cmapWinSymbol;
    public CmapSubtable cmapWinUnicode;
    public final boolean isDamaged;
    public final boolean isEmbedded;
    public final TrueTypeFont ttf;

    static {
        for (Entry next : MacOSRomanEncoding.INSTANCE.getCodeToNameMap().entrySet()) {
            if (!INVERTED_MACOS_ROMAN.containsKey(next.getValue())) {
                INVERTED_MACOS_ROMAN.put(next.getValue(), next.getKey());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PDTrueTypeFont(org.apache.pdfbox.cos.COSDictionary r5) throws java.io.IOException {
        /*
            r4 = this;
            r4.<init>(r5)
            r5 = 0
            r4.cmapWinUnicode = r5
            r4.cmapWinSymbol = r5
            r4.cmapMacRoman = r5
            r0 = 0
            r4.cmapInitialized = r0
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r1 = r4.getFontDescriptor()
            r2 = 1
            if (r1 == 0) goto L_0x0035
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r1 = super.getFontDescriptor()
            org.apache.pdfbox.pdmodel.common.PDStream r1 = r1.getFontFile2()
            if (r1 == 0) goto L_0x0035
            org.apache.fontbox.ttf.TTFParser r3 = new org.apache.fontbox.ttf.TTFParser     // Catch:{ NullPointerException -> 0x0030, IOException -> 0x002c }
            r3.<init>(r2)     // Catch:{ NullPointerException -> 0x0030, IOException -> 0x002c }
            java.io.InputStream r1 = r1.createInputStream()     // Catch:{ NullPointerException -> 0x0030, IOException -> 0x002c }
            org.apache.fontbox.ttf.TrueTypeFont r5 = r3.parse(r1)     // Catch:{ NullPointerException -> 0x0030, IOException -> 0x002c }
            goto L_0x0035
        L_0x002c:
            r4.getBaseFont()
            goto L_0x0033
        L_0x0030:
            r4.getBaseFont()
        L_0x0033:
            r1 = 1
            goto L_0x0036
        L_0x0035:
            r1 = 0
        L_0x0036:
            if (r5 == 0) goto L_0x0039
            r0 = 1
        L_0x0039:
            r4.isEmbedded = r0
            r4.isDamaged = r1
            if (r5 != 0) goto L_0x0072
            java.lang.String r5 = r4.getBaseFont()
            org.apache.fontbox.ttf.TrueTypeFont r5 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getTrueTypeFont(r5)
            if (r5 != 0) goto L_0x0072
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r5 = r4.getFontDescriptor()
            org.apache.fontbox.ttf.TrueTypeFont r5 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getTrueTypeFallbackFont(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Using fallback font '"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = "' for '"
            r0.append(r1)
            java.lang.String r1 = r4.getBaseFont()
            r0.append(r1)
            java.lang.String r1 = "'"
            r0.append(r1)
            r0.toString()
        L_0x0072:
            r4.ttf = r5
            r4.readEncoding()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.PDTrueTypeFont.<init>(org.apache.pdfbox.cos.COSDictionary):void");
    }

    private void extractCmapTable() throws IOException {
        if (!this.cmapInitialized) {
            CmapTable cmap = this.ttf.getCmap();
            if (cmap != null) {
                for (CmapSubtable cmapSubtable : cmap.getCmaps()) {
                    if (3 == cmapSubtable.getPlatformId()) {
                        if (1 == cmapSubtable.getPlatformEncodingId()) {
                            this.cmapWinUnicode = cmapSubtable;
                        } else if (cmapSubtable.getPlatformEncodingId() == 0) {
                            this.cmapWinSymbol = cmapSubtable;
                        }
                    } else if (1 == cmapSubtable.getPlatformId() && cmapSubtable.getPlatformEncodingId() == 0) {
                        this.cmapMacRoman = cmapSubtable;
                    }
                }
            }
            this.cmapInitialized = true;
        }
    }

    @Deprecated
    public static PDTrueTypeFont loadTTF(PDDocument pDDocument, File file) throws IOException {
        return new PDTrueTypeFont(pDDocument, new FileInputStream(file));
    }

    public int codeToGID(int i) throws IOException {
        extractCmapTable();
        int i2 = 0;
        if (!isSymbolic()) {
            String name = this.encoding.getName(i);
            if (name.equals(Encoding.NOTDEF)) {
                return 0;
            }
            if (this.cmapWinUnicode != null) {
                String unicode = GlyphList.getAdobeGlyphList().toUnicode(name);
                if (unicode != null) {
                    i2 = this.cmapWinUnicode.getGlyphId(unicode.codePointAt(0));
                }
            }
            if (i2 == 0 && this.cmapMacRoman != null) {
                Integer num = INVERTED_MACOS_ROMAN.get(name);
                if (num != null) {
                    i2 = this.cmapMacRoman.getGlyphId(num.intValue());
                }
            }
            if (i2 == 0) {
                i2 = this.ttf.nameToGID(name);
            }
        } else {
            CmapSubtable cmapSubtable = this.cmapWinSymbol;
            if (cmapSubtable != null) {
                i2 = cmapSubtable.getGlyphId(i);
                if (i >= 0 && i <= 255) {
                    if (i2 == 0) {
                        i2 = this.cmapWinSymbol.getGlyphId(START_RANGE_F000 + i);
                    }
                    if (i2 == 0) {
                        i2 = this.cmapWinSymbol.getGlyphId(START_RANGE_F100 + i);
                    }
                    if (i2 == 0) {
                        i2 = this.cmapWinSymbol.getGlyphId(START_RANGE_F200 + i);
                    }
                }
            }
            if (i2 == 0) {
                CmapSubtable cmapSubtable2 = this.cmapMacRoman;
                if (cmapSubtable2 != null) {
                    i2 = cmapSubtable2.getGlyphId(i);
                }
            }
        }
        if (i2 == 0) {
            getBaseFont();
        }
        return i2;
    }

    public byte[] encode(int i) throws IOException {
        if (!getEncoding().contains(getGlyphList().codePointToName(i))) {
            throw new IllegalArgumentException("This font type only supports 8-bit code points");
        } else if (codeToGID(i) != 0) {
            return new byte[]{(byte) i};
        } else {
            throw new IllegalArgumentException(String.format("U+%04X is not available in this font's Encoding", new Object[]{Integer.valueOf(i)}));
        }
    }

    public String getBaseFont() {
        return this.dict.getNameAsString(COSName.BASE_FONT);
    }

    public BoundingBox getBoundingBox() throws IOException {
        return this.ttf.getFontBBox();
    }

    public float getHeight(int i) throws IOException {
        GlyphData glyph = this.ttf.getGlyph().getGlyph(codeToGID(i));
        if (glyph != null) {
            return glyph.getBoundingBox().getHeight();
        }
        return 0.0f;
    }

    public String getName() {
        return getBaseFont();
    }

    public TrueTypeFont getTrueTypeFont() {
        return this.ttf;
    }

    public float getWidthFromFont(int i) throws IOException {
        if (getStandard14AFM() != null && getEncoding() != null) {
            return getStandard14Width(i);
        }
        float advanceWidth = (float) this.ttf.getAdvanceWidth(codeToGID(i));
        float unitsPerEm = (float) this.ttf.getUnitsPerEm();
        if (unitsPerEm != 1000.0f) {
            advanceWidth *= 1000.0f / unitsPerEm;
        }
        return advanceWidth;
    }

    public boolean isDamaged() {
        return this.isDamaged;
    }

    public boolean isEmbedded() {
        return this.isEmbedded;
    }

    public int readCode(InputStream inputStream) throws IOException {
        return inputStream.read();
    }

    public org.apache.pdfbox.pdmodel.font.encoding.Encoding readEncodingFromFont() throws IOException {
        return null;
    }

    @Deprecated
    public static PDTrueTypeFont loadTTF(PDDocument pDDocument, InputStream inputStream) throws IOException {
        return new PDTrueTypeFont(pDDocument, inputStream);
    }

    public PDTrueTypeFont(PDDocument pDDocument, InputStream inputStream) throws IOException {
        this.cmapWinUnicode = null;
        this.cmapWinSymbol = null;
        this.cmapMacRoman = null;
        this.cmapInitialized = false;
        PDTrueTypeFontEmbedder pDTrueTypeFontEmbedder = new PDTrueTypeFontEmbedder(pDDocument, this.dict, inputStream);
        this.encoding = pDTrueTypeFontEmbedder.getFontEncoding();
        this.ttf = pDTrueTypeFontEmbedder.getTrueTypeFont();
        setFontDescriptor(pDTrueTypeFontEmbedder.getFontDescriptor());
        this.isEmbedded = true;
        this.isDamaged = false;
        this.glyphList = GlyphList.getAdobeGlyphList();
    }
}
