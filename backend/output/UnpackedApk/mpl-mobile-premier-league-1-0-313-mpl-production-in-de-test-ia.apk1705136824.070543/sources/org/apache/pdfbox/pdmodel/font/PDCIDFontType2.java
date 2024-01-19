package org.apache.pdfbox.pdmodel.font;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.util.Matrix;

public class PDCIDFontType2 extends PDCIDFont {
    public final int[] cid2gid;
    public final CmapSubtable cmap;
    public Matrix fontMatrix;
    public final Map<Integer, Integer> gid2cid;
    public final boolean hasIdentityCid2Gid;
    public final boolean isDamaged;
    public final boolean isEmbedded;
    public final TrueTypeFont ttf;

    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4, types: [org.apache.fontbox.ttf.TrueTypeFont] */
    /* JADX WARNING: type inference failed for: r5v14, types: [org.apache.fontbox.ttf.TrueTypeFont] */
    /* JADX WARNING: type inference failed for: r5v16, types: [org.apache.fontbox.ttf.TrueTypeFont, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18, types: [org.apache.fontbox.ttf.OpenTypeFont] */
    /* JADX WARNING: type inference failed for: r5v19, types: [org.apache.fontbox.ttf.TrueTypeFont] */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        r6 = r5.getFontFile();
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v2
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], org.apache.fontbox.ttf.OpenTypeFont, org.apache.fontbox.ttf.TrueTypeFont]
      uses: [org.apache.fontbox.ttf.OpenTypeFont, ?[int, boolean, OBJECT, ARRAY, byte, short, char], org.apache.fontbox.ttf.TrueTypeFont, java.lang.Object]
      mth insns count: 78
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PDCIDFontType2(org.apache.pdfbox.cos.COSDictionary r5, org.apache.pdfbox.pdmodel.font.PDType0Font r6) throws java.io.IOException {
        /*
            r4 = this;
            r4.<init>(r5, r6)
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r5 = r4.getFontDescriptor()
            org.apache.pdfbox.pdmodel.common.PDStream r6 = r5.getFontFile2()
            org.apache.pdfbox.pdmodel.common.PDStream r0 = r5.getFontFile3()
            if (r6 != 0) goto L_0x0017
            if (r0 != 0) goto L_0x0017
            org.apache.pdfbox.pdmodel.common.PDStream r6 = r5.getFontFile()
        L_0x0017:
            r5 = 0
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0033
            org.apache.fontbox.ttf.TTFParser r0 = new org.apache.fontbox.ttf.TTFParser     // Catch:{ NullPointerException -> 0x002e, IOException -> 0x002a }
            r0.<init>(r2)     // Catch:{ NullPointerException -> 0x002e, IOException -> 0x002a }
            java.io.InputStream r6 = r6.createInputStream()     // Catch:{ NullPointerException -> 0x002e, IOException -> 0x002a }
            org.apache.fontbox.ttf.TrueTypeFont r5 = r0.parse(r6)     // Catch:{ NullPointerException -> 0x002e, IOException -> 0x002a }
            goto L_0x0075
        L_0x002a:
            r4.getBaseFont()
            goto L_0x0031
        L_0x002e:
            r4.getBaseFont()
        L_0x0031:
            r6 = 1
            goto L_0x0076
        L_0x0033:
            if (r0 == 0) goto L_0x0075
            org.apache.fontbox.ttf.OTFParser r6 = new org.apache.fontbox.ttf.OTFParser     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            r6.<init>(r2)     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            java.io.InputStream r0 = r0.createInputStream()     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            org.apache.fontbox.ttf.OpenTypeFont r5 = r6.parse(r0)     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            boolean r6 = r5.isPostScript()     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            if (r6 != 0) goto L_0x0052
            boolean r6 = r5.hasLayoutTables()     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            if (r6 == 0) goto L_0x0075
            r4.getBaseFont()     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            goto L_0x0075
        L_0x0052:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            r0.<init>()     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            java.lang.String r3 = "Not implemented: OpenType font with CFF table "
            r0.append(r3)     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            java.lang.String r3 = r4.getBaseFont()     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            r0.append(r3)     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            java.lang.String r0 = r0.toString()     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            r6.<init>(r0)     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
            throw r6     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006d }
        L_0x006d:
            r4.getBaseFont()
            goto L_0x0031
        L_0x0071:
            r4.getBaseFont()
            goto L_0x0031
        L_0x0075:
            r6 = 0
        L_0x0076:
            if (r5 == 0) goto L_0x007a
            r0 = 1
            goto L_0x007b
        L_0x007a:
            r0 = 0
        L_0x007b:
            r4.isEmbedded = r0
            r4.isDamaged = r6
            if (r5 != 0) goto L_0x00b5
            java.lang.String r5 = r4.getBaseFont()
            org.apache.fontbox.ttf.TrueTypeFont r5 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getTrueTypeFont(r5)
            if (r5 == 0) goto L_0x008c
            goto L_0x00b5
        L_0x008c:
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r5 = r4.getFontDescriptor()
            org.apache.fontbox.ttf.TrueTypeFont r5 = org.apache.pdfbox.pdmodel.font.ExternalFonts.getTrueTypeFallbackFont(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Using fallback font '"
            r6.append(r0)
            r6.append(r5)
            java.lang.String r0 = "' for '"
            r6.append(r0)
            java.lang.String r0 = r4.getBaseFont()
            r6.append(r0)
            java.lang.String r0 = "'"
            r6.append(r0)
            r6.toString()
        L_0x00b5:
            r4.ttf = r5
            org.apache.fontbox.ttf.CmapSubtable r5 = r5.getUnicodeCmap(r1)
            r4.cmap = r5
            int[] r5 = r4.readCIDToGIDMap()
            r4.cid2gid = r5
            java.util.Map r5 = r4.invert(r5)
            r4.gid2cid = r5
            org.apache.pdfbox.cos.COSDictionary r5 = r4.dict
            org.apache.pdfbox.cos.COSName r6 = org.apache.pdfbox.cos.COSName.CID_TO_GID_MAP
            org.apache.pdfbox.cos.COSBase r5 = r5.getDictionaryObject(r6)
            boolean r6 = r5 instanceof org.apache.pdfbox.cos.COSName
            if (r6 == 0) goto L_0x00e4
            org.apache.pdfbox.cos.COSName r5 = (org.apache.pdfbox.cos.COSName) r5
            java.lang.String r5 = r5.getName()
            java.lang.String r6 = "Identity"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x00e4
            r1 = 1
        L_0x00e4:
            r4.hasIdentityCid2Gid = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.PDCIDFontType2.<init>(org.apache.pdfbox.cos.COSDictionary, org.apache.pdfbox.pdmodel.font.PDType0Font):void");
    }

    private Map<Integer, Integer> invert(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < iArr.length; i++) {
            hashMap.put(Integer.valueOf(iArr[i]), Integer.valueOf(i));
        }
        return hashMap;
    }

    private int[] readCIDToGIDMap() throws IOException {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.CID_TO_GID_MAP);
        if (!(dictionaryObject instanceof COSStream)) {
            return null;
        }
        InputStream unfilteredStream = ((COSStream) dictionaryObject).getUnfilteredStream();
        byte[] byteArray = IOUtils.toByteArray(unfilteredStream);
        IOUtils.closeQuietly(unfilteredStream);
        int length = byteArray.length / 2;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = ((byteArray[i] & 255) << 8) | (byteArray[i + 1] & 255);
            i += 2;
        }
        return iArr;
    }

    public int codeToCID(int i) {
        CMap cMap = this.parent.getCMap();
        if (cMap.hasCIDMappings() || !cMap.hasUnicodeMappings()) {
            return cMap.toCID(i);
        }
        return cMap.toUnicode(i).codePointAt(0);
    }

    public int codeToGID(int i) throws IOException {
        if (!this.isEmbedded) {
            boolean z = this.parent.getCMapUCS2() != null;
            if (this.cid2gid != null) {
                return this.cid2gid[codeToCID(i)];
            } else if (this.hasIdentityCid2Gid || !z) {
                return codeToCID(i);
            } else {
                String unicode = this.parent.toUnicode(i);
                if (unicode == null) {
                    getName();
                    return 0;
                }
                int length = unicode.length();
                return this.cmap.getGlyphId(unicode.codePointAt(0));
            }
        } else {
            int codeToCID = codeToCID(i);
            int[] iArr = this.cid2gid;
            if (iArr != null) {
                if (codeToCID < iArr.length) {
                    return iArr[codeToCID];
                }
                return 0;
            } else if (codeToCID < this.ttf.getNumberOfGlyphs()) {
                return codeToCID;
            } else {
                return 0;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] encode(int r5) {
        /*
            r4 = this;
            boolean r0 = r4.isEmbedded
            r1 = 0
            if (r0 == 0) goto L_0x0039
            org.apache.pdfbox.pdmodel.font.PDType0Font r0 = r4.parent
            org.apache.fontbox.cmap.CMap r0 = r0.getCMap()
            java.lang.String r0 = r0.getName()
            java.lang.String r2 = "Identity-"
            boolean r0 = r0.startsWith(r2)
            r2 = -1
            if (r0 == 0) goto L_0x0021
            org.apache.fontbox.ttf.CmapSubtable r0 = r4.cmap
            if (r0 == 0) goto L_0x0034
            int r0 = r0.getGlyphId(r5)
            goto L_0x0035
        L_0x0021:
            org.apache.pdfbox.pdmodel.font.PDType0Font r0 = r4.parent
            org.apache.fontbox.cmap.CMap r0 = r0.getCMapUCS2()
            if (r0 == 0) goto L_0x0034
            org.apache.pdfbox.pdmodel.font.PDType0Font r0 = r4.parent
            org.apache.fontbox.cmap.CMap r0 = r0.getCMapUCS2()
            int r0 = r0.toCID(r5)
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 != r2) goto L_0x003f
            r0 = 0
            goto L_0x003f
        L_0x0039:
            org.apache.fontbox.ttf.CmapSubtable r0 = r4.cmap
            int r0 = r0.getGlyphId(r5)
        L_0x003f:
            r2 = 1
            r3 = 2
            if (r0 == 0) goto L_0x0052
            byte[] r5 = new byte[r3]
            int r3 = r0 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r5[r1] = r3
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r5[r2] = r0
            return r5
        L_0x0052:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r1] = r5
            java.lang.String r5 = r4.getName()
            r3[r2] = r5
            java.lang.String r5 = "No glyph for U+%04X in font %s"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.PDCIDFontType2.encode(int):byte[]");
    }

    public BoundingBox getBoundingBox() throws IOException {
        return this.ttf.getFontBBox();
    }

    public Matrix getFontMatrix() {
        if (this.fontMatrix == null) {
            Matrix matrix = new Matrix(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
            this.fontMatrix = matrix;
        }
        return this.fontMatrix;
    }

    public float getHeight(int i) throws IOException {
        return (float) ((this.ttf.getHorizontalHeader().getAscender() + (-this.ttf.getHorizontalHeader().getDescender())) / this.ttf.getUnitsPerEm());
    }

    public TrueTypeFont getTrueTypeFont() {
        return this.ttf;
    }

    public float getWidthFromFont(int i) throws IOException {
        int advanceWidth = this.ttf.getAdvanceWidth(codeToGID(i));
        int unitsPerEm = this.ttf.getUnitsPerEm();
        if (unitsPerEm != 1000) {
            advanceWidth = (int) ((1000.0f / ((float) unitsPerEm)) * ((float) advanceWidth));
        }
        return (float) advanceWidth;
    }

    public boolean isDamaged() {
        return this.isDamaged;
    }

    public boolean isEmbedded() {
        return this.isEmbedded;
    }
}
