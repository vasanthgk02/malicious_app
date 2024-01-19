package org.apache.pdfbox.pdmodel.font;

import android.graphics.Path;
import android.graphics.RectF;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.encoding.Encoding;
import org.apache.fontbox.ttf.Type1Equivalent;
import org.apache.fontbox.type1.Type1Font;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Type1Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.util.Matrix;

public class PDType1Font extends PDSimpleFont implements PDType1Equivalent {
    public static final Map<String, String> ALT_NAMES;
    public static final PDType1Font COURIER = new PDType1Font((String) "Courier");
    public static final PDType1Font COURIER_BOLD = new PDType1Font((String) "Courier-Bold");
    public static final PDType1Font COURIER_BOLD_OBLIQUE = new PDType1Font((String) "Courier-BoldOblique");
    public static final PDType1Font COURIER_OBLIQUE = new PDType1Font((String) "Courier-Oblique");
    public static final PDType1Font HELVETICA = new PDType1Font((String) "Helvetica");
    public static final PDType1Font HELVETICA_BOLD = new PDType1Font((String) "Helvetica-Bold");
    public static final PDType1Font HELVETICA_BOLD_OBLIQUE = new PDType1Font((String) "Helvetica-BoldOblique");
    public static final PDType1Font HELVETICA_OBLIQUE = new PDType1Font((String) "Helvetica-Oblique");
    public static final int PFB_START_MARKER = 128;
    public static final PDType1Font SYMBOL = new PDType1Font((String) "Symbol");
    public static final PDType1Font TIMES_BOLD = new PDType1Font((String) "Times-Bold");
    public static final PDType1Font TIMES_BOLD_ITALIC = new PDType1Font((String) "Times-BoldItalic");
    public static final PDType1Font TIMES_ITALIC = new PDType1Font((String) "Times-Italic");
    public static final PDType1Font TIMES_ROMAN = new PDType1Font((String) "Times-Roman");
    public static final PDType1Font ZAPF_DINGBATS = new PDType1Font((String) "ZapfDingbats");
    public Matrix fontMatrix;
    public Map<String, Integer> invertedEncoding;
    public final boolean isDamaged;
    public final boolean isEmbedded;
    public final Type1Equivalent type1Equivalent;
    public final Type1Font type1font;

    static {
        HashMap hashMap = new HashMap();
        ALT_NAMES = hashMap;
        hashMap.put("ff", "f_f");
        ALT_NAMES.put("ffi", "f_f_i");
        ALT_NAMES.put("ffl", "f_f_l");
        ALT_NAMES.put("fi", "f_i");
        ALT_NAMES.put("fl", "f_l");
        ALT_NAMES.put("st", "s_t");
        ALT_NAMES.put("IJ", "I_J");
        ALT_NAMES.put("ij", "i_j");
        ALT_NAMES.put("ellipsis", "elipsis");
    }

    public PDType1Font(String str) {
        super(str);
        this.dict.setItem(COSName.SUBTYPE, (COSBase) COSName.TYPE1);
        this.dict.setName(COSName.BASE_FONT, str);
        this.encoding = new WinAnsiEncoding();
        this.dict.setItem(COSName.ENCODING, (COSBase) COSName.WIN_ANSI_ENCODING);
        this.type1font = null;
        this.type1Equivalent = ExternalFonts.getType1EquivalentFont(getBaseFont());
        this.isEmbedded = false;
        this.isDamaged = false;
    }

    private Map<String, Integer> getInvertedEncoding() {
        Map<String, Integer> map = this.invertedEncoding;
        if (map != null) {
            return map;
        }
        this.invertedEncoding = new HashMap();
        for (Entry next : this.encoding.getCodeToNameMap().entrySet()) {
            if (!this.invertedEncoding.containsKey(next.getValue())) {
                this.invertedEncoding.put(next.getValue(), next.getKey());
            }
        }
        return this.invertedEncoding;
    }

    private String getNameInFont(String str) throws IOException {
        if (isEmbedded() || this.type1Equivalent.hasGlyph(str)) {
            return str;
        }
        String str2 = ALT_NAMES.get(str);
        if (str2 != null && !str.equals(Encoding.NOTDEF) && this.type1Equivalent.hasGlyph(str2)) {
            return str2;
        }
        String unicode = getGlyphList().toUnicode(str);
        if (unicode != null && unicode.length() == 1) {
            String format = String.format("uni%04X", new Object[]{Integer.valueOf(unicode.codePointAt(0))});
            if (this.type1Equivalent.hasGlyph(format)) {
                return format;
            }
        }
        return Encoding.NOTDEF;
    }

    private int repairLength1(byte[] bArr, int i) {
        int i2;
        int max = Math.max(0, i - 4);
        while (true) {
            if (i2 <= 0) {
                break;
            } else if (bArr[i2 + 0] == 101 && bArr[i2 + 1] == 120 && bArr[i2 + 2] == 101 && bArr[i2 + 3] == 99) {
                i2 += 4;
                while (i2 < i && (bArr[i2] == 13 || bArr[i2] == 10 || bArr[i2] == 32)) {
                    i2++;
                }
            } else {
                max = i2 - 1;
            }
        }
        if (i - i2 == 0 || i2 <= 0) {
            return i;
        }
        getName();
        return i2;
    }

    public String codeToName(int i) throws IOException {
        return getNameInFont(getEncoding().getName(i));
    }

    public byte[] encode(int i) throws IOException {
        if (i <= 255) {
            String codePointToName = getGlyphList().codePointToName(i);
            String nameInFont = getNameInFont(codePointToName);
            Map<String, Integer> invertedEncoding2 = getInvertedEncoding();
            if (nameInFont.equals(Encoding.NOTDEF) || !this.type1Equivalent.hasGlyph(nameInFont)) {
                throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", new Object[]{Integer.valueOf(i), getName()}));
            }
            return new byte[]{(byte) invertedEncoding2.get(codePointToName).intValue()};
        }
        throw new IllegalArgumentException("This font type only supports 8-bit code points");
    }

    public float getAverageFontWidth() {
        if (getStandard14AFM() != null) {
            return getStandard14AFM().getAverageCharacterWidth();
        }
        return super.getAverageFontWidth();
    }

    public String getBaseFont() {
        return this.dict.getNameAsString(COSName.BASE_FONT);
    }

    public BoundingBox getBoundingBox() throws IOException {
        return this.type1Equivalent.getFontBBox();
    }

    public Matrix getFontMatrix() {
        if (this.fontMatrix == null) {
            Type1Font type1Font = this.type1font;
            if (type1Font != null) {
                List<Number> fontMatrix2 = type1Font.getFontMatrix();
                if (fontMatrix2 == null || fontMatrix2.size() != 6) {
                    return super.getFontMatrix();
                }
                Matrix matrix = new Matrix(fontMatrix2.get(0).floatValue(), fontMatrix2.get(1).floatValue(), fontMatrix2.get(2).floatValue(), fontMatrix2.get(3).floatValue(), fontMatrix2.get(4).floatValue(), fontMatrix2.get(5).floatValue());
                this.fontMatrix = matrix;
            } else {
                this.fontMatrix = PDFont.DEFAULT_FONT_MATRIX;
            }
        }
        return this.fontMatrix;
    }

    public float getHeight(int i) throws IOException {
        String codeToName = codeToName(i);
        if (getStandard14AFM() != null) {
            return getStandard14AFM().getCharacterHeight(getEncoding().getName(i));
        }
        RectF rectF = new RectF();
        this.type1Equivalent.getPath(codeToName).computeBounds(rectF, true);
        return rectF.height();
    }

    public String getName() {
        return getBaseFont();
    }

    public Path getPath(String str) throws IOException {
        if (!str.equals(Encoding.NOTDEF) || this.isEmbedded) {
            return this.type1Equivalent.getPath(str);
        }
        return new Path();
    }

    public Type1Equivalent getType1Equivalent() {
        return this.type1Equivalent;
    }

    public Type1Font getType1Font() {
        return this.type1font;
    }

    public float getWidthFromFont(int i) throws IOException {
        String codeToName = codeToName(i);
        if (getStandard14AFM() != null) {
            return getStandard14Width(i);
        }
        return this.type1Equivalent.getWidth(codeToName);
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
        if (getStandard14AFM() != null) {
            return new Type1Encoding(getStandard14AFM());
        }
        if (this.type1Equivalent.getEncoding() != null) {
            return Type1Encoding.fromFontBox(this.type1Equivalent.getEncoding());
        }
        return StandardEncoding.INSTANCE;
    }

    public PDType1Font(PDDocument pDDocument, InputStream inputStream, InputStream inputStream2) throws IOException {
        PDType1FontEmbedder pDType1FontEmbedder = new PDType1FontEmbedder(pDDocument, this.dict, inputStream, inputStream2);
        this.encoding = pDType1FontEmbedder.getFontEncoding();
        this.type1font = pDType1FontEmbedder.getType1Font();
        this.type1Equivalent = pDType1FontEmbedder.getType1Font();
        this.isEmbedded = true;
        this.isDamaged = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PDType1Font(org.apache.pdfbox.cos.COSDictionary r9) throws java.io.IOException {
        /*
            r8 = this;
            r8.<init>(r9)
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r9 = r8.getFontDescriptor()
            r0 = 1
            r1 = 0
            r2 = 0
            if (r9 == 0) goto L_0x0065
            org.apache.pdfbox.pdmodel.common.PDStream r3 = r9.getFontFile3()
            if (r3 != 0) goto L_0x005d
            org.apache.pdfbox.pdmodel.common.PDStream r3 = r9.getFontFile()
            if (r3 == 0) goto L_0x0065
            org.apache.pdfbox.cos.COSStream r4 = r3.getStream()     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            org.apache.pdfbox.cos.COSName r5 = org.apache.pdfbox.cos.COSName.LENGTH1     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            int r5 = r4.getInt(r5)     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            org.apache.pdfbox.cos.COSName r6 = org.apache.pdfbox.cos.COSName.LENGTH2     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            int r4 = r4.getInt(r6)     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            byte[] r3 = r3.getByteArray()     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            int r5 = r8.repairLength1(r3, r5)     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            int r6 = r3.length     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            if (r6 <= 0) goto L_0x0041
            byte r6 = r3[r1]     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 != r7) goto L_0x0041
            org.apache.fontbox.type1.Type1Font r9 = org.apache.fontbox.type1.Type1Font.createWithPFB(r3)     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
        L_0x003f:
            r2 = r9
            goto L_0x0065
        L_0x0041:
            byte[] r6 = java.util.Arrays.copyOfRange(r3, r1, r5)     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            int r7 = r5 + r4
            byte[] r3 = java.util.Arrays.copyOfRange(r3, r5, r7)     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            if (r5 <= 0) goto L_0x0065
            if (r4 <= 0) goto L_0x0065
            org.apache.fontbox.type1.Type1Font r9 = org.apache.fontbox.type1.Type1Font.createWithSegments(r6, r3)     // Catch:{ DamagedFontException -> 0x0058, IOException -> 0x0054 }
            goto L_0x003f
        L_0x0054:
            r9.getFontName()
            goto L_0x005b
        L_0x0058:
            r9.getFontName()
        L_0x005b:
            r9 = 1
            goto L_0x0066
        L_0x005d:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Use PDType1CFont for FontFile3"
            r9.<init>(r0)
            throw r9
        L_0x0065:
            r9 = 0
        L_0x0066:
            if (r2 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            r8.isEmbedded = r0
            r8.isDamaged = r9
            if (r2 != 0) goto L_0x0078
            java.lang.String r9 = r8.getBaseFont()
            org.apache.fontbox.type1.Type1Font r2 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getType1Font(r9)
        L_0x0078:
            r8.type1font = r2
            if (r2 == 0) goto L_0x007f
            r8.type1Equivalent = r2
            goto L_0x009c
        L_0x007f:
            java.lang.String r9 = r8.getBaseFont()
            org.apache.fontbox.ttf.Type1Equivalent r9 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getType1EquivalentFont(r9)
            if (r9 == 0) goto L_0x008c
            r8.type1Equivalent = r9
            goto L_0x009c
        L_0x008c:
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r9 = r8.getFontDescriptor()
            org.apache.fontbox.ttf.Type1Equivalent r9 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getType1FallbackFont(r9)
            r8.type1Equivalent = r9
            r9.getName()
            r8.getBaseFont()
        L_0x009c:
            r8.readEncoding()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.PDType1Font.<init>(org.apache.pdfbox.cos.COSDictionary):void");
    }
}
