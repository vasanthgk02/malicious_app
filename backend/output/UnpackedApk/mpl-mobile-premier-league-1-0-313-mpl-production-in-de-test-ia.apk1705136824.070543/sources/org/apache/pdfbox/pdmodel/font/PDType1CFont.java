package org.apache.pdfbox.pdmodel.font;

import android.graphics.Path;
import android.graphics.PointF;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cff.CFFType1Font;
import org.apache.fontbox.encoding.Encoding;
import org.apache.fontbox.ttf.Type1Equivalent;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.font.encoding.Type1Encoding;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.awt.AffineTransform;

public class PDType1CFont extends PDSimpleFont implements PDType1Equivalent {
    public Float avgWidth;
    public final CFFType1Font cffFont;
    public Matrix fontMatrix;
    public final AffineTransform fontMatrixTransform;
    public final Map<String, Float> glyphHeights = new HashMap();
    public final boolean isDamaged;
    public final boolean isEmbedded;
    public final Type1Equivalent type1Equivalent;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c A[SYNTHETIC, Splitter:B:10:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PDType1CFont(org.apache.pdfbox.cos.COSDictionary r5) throws java.io.IOException {
        /*
            r4 = this;
            r4.<init>(r5)
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r4.glyphHeights = r5
            r5 = 0
            r4.avgWidth = r5
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r0 = r4.getFontDescriptor()
            if (r0 == 0) goto L_0x0027
            org.apache.pdfbox.pdmodel.common.PDStream r0 = r0.getFontFile3()
            if (r0 == 0) goto L_0x0027
            java.io.InputStream r0 = r0.createInputStream()
            byte[] r0 = org.apache.pdfbox.io.IOUtils.toByteArray(r0)
            int r1 = r0.length
            if (r1 != 0) goto L_0x0028
            r4.getName()
        L_0x0027:
            r0 = r5
        L_0x0028:
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0042
            org.apache.fontbox.cff.CFFParser r3 = new org.apache.fontbox.cff.CFFParser     // Catch:{ IOException -> 0x003d }
            r3.<init>()     // Catch:{ IOException -> 0x003d }
            java.util.List r0 = r3.parse(r0)     // Catch:{ IOException -> 0x003d }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ IOException -> 0x003d }
            org.apache.fontbox.cff.CFFType1Font r0 = (org.apache.fontbox.cff.CFFType1Font) r0     // Catch:{ IOException -> 0x003d }
            r5 = r0
            goto L_0x0042
        L_0x003d:
            r4.getName()
            r0 = 1
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            r4.isDamaged = r0
            r4.cffFont = r5
            if (r5 == 0) goto L_0x004e
            r4.type1Equivalent = r5
            r4.isEmbedded = r1
            goto L_0x006d
        L_0x004e:
            java.lang.String r5 = r4.getBaseFont()
            org.apache.fontbox.ttf.Type1Equivalent r5 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getType1EquivalentFont(r5)
            if (r5 == 0) goto L_0x005b
            r4.type1Equivalent = r5
            goto L_0x006b
        L_0x005b:
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r5 = r4.getFontDescriptor()
            org.apache.fontbox.ttf.Type1Equivalent r5 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getType1FallbackFont(r5)
            r4.type1Equivalent = r5
            r5.getName()
            r4.getBaseFont()
        L_0x006b:
            r4.isEmbedded = r2
        L_0x006d:
            r4.readEncoding()
            org.apache.pdfbox.util.Matrix r5 = r4.getFontMatrix()
            org.apache.pdfbox.util.awt.AffineTransform r5 = r5.createAffineTransform()
            r4.fontMatrixTransform = r5
            r0 = 4652007308841189376(0x408f400000000000, double:1000.0)
            r5.scale(r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.PDType1CFont.<init>(org.apache.pdfbox.cos.COSDictionary):void");
    }

    private float getAverageCharacterWidth() {
        return 500.0f;
    }

    public String codeToName(int i) {
        return getEncoding().getName(i);
    }

    public byte[] encode(int i) throws IOException {
        throw new UnsupportedOperationException("Not implemented: Type1C");
    }

    public float getAverageFontWidth() {
        if (this.avgWidth == null) {
            this.avgWidth = Float.valueOf(getAverageCharacterWidth());
        }
        return this.avgWidth.floatValue();
    }

    public String getBaseFont() {
        return this.dict.getNameAsString(COSName.BASE_FONT);
    }

    public BoundingBox getBoundingBox() throws IOException {
        return this.type1Equivalent.getFontBBox();
    }

    public CFFType1Font getCFFType1Font() {
        return this.cffFont;
    }

    public Matrix getFontMatrix() {
        if (this.fontMatrix == null) {
            CFFType1Font cFFType1Font = this.cffFont;
            if (cFFType1Font != null) {
                List<Number> fontMatrix2 = cFFType1Font.getFontMatrix();
                if (fontMatrix2 != null && fontMatrix2.size() == 6) {
                    Matrix matrix = new Matrix(fontMatrix2.get(0).floatValue(), fontMatrix2.get(1).floatValue(), fontMatrix2.get(2).floatValue(), fontMatrix2.get(3).floatValue(), fontMatrix2.get(4).floatValue(), fontMatrix2.get(5).floatValue());
                    this.fontMatrix = matrix;
                    return matrix;
                }
            }
        }
        return this.fontMatrix;
    }

    public float getHeight(int i) throws IOException {
        String codeToName = codeToName(i);
        if (this.glyphHeights.containsKey(codeToName)) {
            return 0.0f;
        }
        float height = this.cffFont.getType1CharString(codeToName).getBounds().height();
        this.glyphHeights.put(codeToName, Float.valueOf(height));
        return height;
    }

    public String getName() {
        return getBaseFont();
    }

    public Path getPath(String str) throws IOException {
        if (!isEmbedded() || !str.equals(Encoding.NOTDEF) || isEmbedded() || isStandard14()) {
            return this.type1Equivalent.getPath(str);
        }
        return new Path();
    }

    public float getStringWidth(String str) throws IOException {
        float f2 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            f2 += (float) this.cffFont.getType1CharString(getGlyphList().codePointToName(str.codePointAt(i))).getWidth();
        }
        return f2;
    }

    public Type1Equivalent getType1Equivalent() {
        return this.type1Equivalent;
    }

    public float getWidthFromFont(int i) throws IOException {
        if (getStandard14AFM() != null) {
            return getStandard14Width(i);
        }
        PointF pointF = new PointF(this.type1Equivalent.getWidth(codeToName(i)), 0.0f);
        this.fontMatrixTransform.transform(pointF, pointF);
        return pointF.x;
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
        return Type1Encoding.fromFontBox(this.type1Equivalent.getEncoding());
    }
}
