package org.apache.pdfbox.pdmodel.font;

import android.graphics.PointF;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cff.CFFCIDFont;
import org.apache.fontbox.cff.CFFFont;
import org.apache.fontbox.cff.CFFType1Font;
import org.apache.fontbox.cff.Type2CharString;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.awt.AffineTransform;

public class PDCIDFontType0 extends PDCIDFont {
    public Float avgWidth = null;
    public final CFFCIDFont cidFont;
    public Matrix fontMatrix;
    public AffineTransform fontMatrixTransform;
    public final Map<Integer, Float> glyphHeights = new HashMap();
    public final boolean isDamaged;
    public final boolean isEmbedded;
    public final CFFType1Font t1Font;

    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v21, types: [org.apache.fontbox.cff.CFFFont] */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v17
      assigns: []
      uses: []
      mth insns count: 76
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b9  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PDCIDFontType0(org.apache.pdfbox.cos.COSDictionary r6, org.apache.pdfbox.pdmodel.font.PDType0Font r7) throws java.io.IOException {
        /*
            r5 = this;
            r5.<init>(r6, r7)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r5.glyphHeights = r6
            r6 = 0
            r5.avgWidth = r6
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r7 = r5.getFontDescriptor()
            if (r7 == 0) goto L_0x0022
            org.apache.pdfbox.pdmodel.common.PDStream r0 = r7.getFontFile3()
            if (r0 == 0) goto L_0x0022
            java.io.InputStream r0 = r0.createInputStream()
            byte[] r0 = org.apache.pdfbox.io.IOUtils.toByteArray(r0)
            goto L_0x0023
        L_0x0022:
            r0 = r6
        L_0x0023:
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0036
            int r3 = r0.length
            if (r3 <= 0) goto L_0x0036
            byte r3 = r0[r2]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 37
            if (r3 != r4) goto L_0x0036
            r7.getFontName()
            goto L_0x004b
        L_0x0036:
            if (r0 == 0) goto L_0x004e
            org.apache.fontbox.cff.CFFParser r3 = new org.apache.fontbox.cff.CFFParser
            r3.<init>()
            java.util.List r0 = r3.parse(r0)     // Catch:{ IOException -> 0x0048 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ IOException -> 0x0048 }
            org.apache.fontbox.cff.CFFFont r0 = (org.apache.fontbox.cff.CFFFont) r0     // Catch:{ IOException -> 0x0048 }
            goto L_0x004f
        L_0x0048:
            r7.getFontName()
        L_0x004b:
            r7 = 1
            r0 = r6
            goto L_0x0050
        L_0x004e:
            r0 = r6
        L_0x004f:
            r7 = 0
        L_0x0050:
            if (r0 == 0) goto L_0x0068
            boolean r7 = r0 instanceof org.apache.fontbox.cff.CFFCIDFont
            if (r7 == 0) goto L_0x005d
            org.apache.fontbox.cff.CFFCIDFont r0 = (org.apache.fontbox.cff.CFFCIDFont) r0
            r5.cidFont = r0
            r5.t1Font = r6
            goto L_0x0063
        L_0x005d:
            r5.cidFont = r6
            org.apache.fontbox.cff.CFFType1Font r0 = (org.apache.fontbox.cff.CFFType1Font) r0
            r5.t1Font = r0
        L_0x0063:
            r5.isEmbedded = r1
            r5.isDamaged = r2
            goto L_0x00c0
        L_0x0068:
            java.lang.String r0 = r5.getBaseFont()
            org.apache.fontbox.cff.CFFCIDFont r0 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getCFFCIDFont(r0)
            if (r0 == 0) goto L_0x0077
            r5.cidFont = r0
            r5.t1Font = r6
            goto L_0x00bc
        L_0x0077:
            org.apache.pdfbox.cos.COSDictionary r0 = r5.dict
            org.apache.pdfbox.cos.COSName r1 = org.apache.pdfbox.cos.COSName.CIDSYSTEMINFO
            org.apache.pdfbox.cos.COSBase r0 = r0.getDictionaryObject(r1)
            org.apache.pdfbox.cos.COSDictionary r0 = (org.apache.pdfbox.cos.COSDictionary) r0
            if (r0 == 0) goto L_0x009a
            org.apache.pdfbox.cos.COSName r1 = org.apache.pdfbox.cos.COSName.REGISTRY
            java.lang.String r1 = r0.getNameAsString(r1)
            org.apache.pdfbox.cos.COSName r3 = org.apache.pdfbox.cos.COSName.ORDERING
            java.lang.String r0 = r0.getNameAsString(r3)
            if (r1 == 0) goto L_0x009a
            if (r0 == 0) goto L_0x009a
            java.lang.String r3 = "-"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r1, r3, r0)
            goto L_0x009b
        L_0x009a:
            r0 = r6
        L_0x009b:
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r1 = r5.getFontDescriptor()
            org.apache.fontbox.cff.CFFCIDFont r0 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getCFFCIDFontFallback(r0, r1)
            r5.cidFont = r0
            r5.t1Font = r6
            java.lang.String r6 = r0.getName()
            java.lang.String r0 = "AdobeBlank"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x00b9
            if (r7 != 0) goto L_0x00bc
            r5.getBaseFont()
            goto L_0x00bc
        L_0x00b9:
            r5.getBaseFont()
        L_0x00bc:
            r5.isEmbedded = r2
            r5.isDamaged = r7
        L_0x00c0:
            org.apache.pdfbox.util.Matrix r6 = r5.getFontMatrix()
            org.apache.pdfbox.util.awt.AffineTransform r6 = r6.createAffineTransform()
            r5.fontMatrixTransform = r6
            r0 = 4652007308841189376(0x408f400000000000, double:1000.0)
            r6.scale(r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.PDCIDFontType0.<init>(org.apache.pdfbox.cos.COSDictionary, org.apache.pdfbox.pdmodel.font.PDType0Font):void");
    }

    private float getAverageCharacterWidth() {
        return 500.0f;
    }

    public int codeToCID(int i) {
        return this.parent.getCMap().toCID(i);
    }

    public int codeToGID(int i) {
        int codeToCID = codeToCID(i);
        CFFCIDFont cFFCIDFont = this.cidFont;
        return cFFCIDFont != null ? cFFCIDFont.getCharset().getGIDForCID(codeToCID) : codeToCID;
    }

    public byte[] encode(int i) {
        throw new UnsupportedOperationException();
    }

    public float getAverageFontWidth() {
        if (this.avgWidth == null) {
            this.avgWidth = Float.valueOf(getAverageCharacterWidth());
        }
        return this.avgWidth.floatValue();
    }

    public BoundingBox getBoundingBox() {
        CFFCIDFont cFFCIDFont = this.cidFont;
        if (cFFCIDFont != null) {
            return cFFCIDFont.getFontBBox();
        }
        return this.t1Font.getFontBBox();
    }

    public CFFFont getCFFFont() {
        CFFCIDFont cFFCIDFont = this.cidFont;
        if (cFFCIDFont != null) {
            return cFFCIDFont;
        }
        return this.t1Font;
    }

    public Matrix getFontMatrix() {
        List<Number> list;
        if (this.fontMatrix == null) {
            CFFCIDFont cFFCIDFont = this.cidFont;
            if (cFFCIDFont != null) {
                list = cFFCIDFont.getFontMatrix();
            } else {
                list = this.t1Font.getFontMatrix();
            }
            if (list == null || list.size() != 6) {
                Matrix matrix = new Matrix(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
                this.fontMatrix = matrix;
            } else {
                Matrix matrix2 = new Matrix(list.get(0).floatValue(), list.get(1).floatValue(), list.get(2).floatValue(), list.get(3).floatValue(), list.get(4).floatValue(), list.get(5).floatValue());
                this.fontMatrix = matrix2;
            }
        }
        return this.fontMatrix;
    }

    public float getHeight(int i) throws IOException {
        int codeToCID = codeToCID(i);
        if (this.glyphHeights.containsKey(Integer.valueOf(codeToCID))) {
            return 0.0f;
        }
        float height = getType2CharString(codeToCID).getBounds().height();
        this.glyphHeights.put(Integer.valueOf(codeToCID), Float.valueOf(height));
        return height;
    }

    public Type2CharString getType2CharString(int i) throws IOException {
        CFFCIDFont cFFCIDFont = this.cidFont;
        if (cFFCIDFont != null) {
            return cFFCIDFont.getType2CharString(i);
        }
        return this.t1Font.getType2CharString(i);
    }

    public float getWidthFromFont(int i) throws IOException {
        PointF pointF = new PointF((float) getType2CharString(codeToCID(i)).getWidth(), 0.0f);
        this.fontMatrixTransform.transform(pointF, pointF);
        return pointF.x;
    }

    public boolean isDamaged() {
        return this.isDamaged;
    }

    public boolean isEmbedded() {
        return this.isEmbedded;
    }
}
