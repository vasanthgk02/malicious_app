package org.apache.pdfbox.pdmodel.font;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.GlyphTable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.IndexToLocationTable;
import org.apache.fontbox.ttf.MaximumProfileTable;
import org.apache.fontbox.ttf.TTFParser;
import org.apache.fontbox.ttf.TTFSubsetter;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;

public abstract class TrueTypeEmbedder implements Subsetter {
    public static final String BASE25 = "BCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ITALIC = 1;
    public static final int OBLIQUE = 256;
    public final CmapSubtable cmap;
    public final PDDocument document;
    public final boolean embedSubset;
    public PDFontDescriptor fontDescriptor;
    public final Set<Integer> subsetCodePoints = new HashSet();
    public TrueTypeFont ttf;

    public TrueTypeEmbedder(PDDocument pDDocument, COSDictionary cOSDictionary, InputStream inputStream, boolean z) throws IOException {
        this.document = pDDocument;
        this.embedSubset = z;
        buildFontFile2(inputStream);
        cOSDictionary.setName(COSName.BASE_FONT, this.ttf.getName());
        this.cmap = this.ttf.getUnicodeCmap();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r3 != 5) goto L_0x0062;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.pdfbox.pdmodel.font.PDFontDescriptor createFontDescriptor(org.apache.fontbox.ttf.TrueTypeFont r11) throws java.io.IOException {
        /*
            r10 = this;
            org.apache.pdfbox.pdmodel.font.PDFontDescriptor r0 = new org.apache.pdfbox.pdmodel.font.PDFontDescriptor
            r0.<init>()
            java.lang.String r1 = r11.getName()
            r0.setFontName(r1)
            org.apache.fontbox.ttf.OS2WindowsMetricsTable r1 = r11.getOS2Windows()
            org.apache.fontbox.ttf.PostScriptTable r2 = r11.getPostScript()
            long r3 = r2.getIsFixedPitch()
            r5 = 0
            r6 = 1
            r7 = 0
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x002d
            org.apache.fontbox.ttf.HorizontalHeaderTable r3 = r11.getHorizontalHeader()
            int r3 = r3.getNumberOfHMetrics()
            if (r3 != r6) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r3 = 0
            goto L_0x002e
        L_0x002d:
            r3 = 1
        L_0x002e:
            r0.setFixedPitch(r3)
            int r3 = r1.getFsSelection()
            r4 = r3 & 1
            if (r4 == r3) goto L_0x0040
            r4 = r3 & 256(0x100, float:3.59E-43)
            if (r4 != r3) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r3 = 0
            goto L_0x0041
        L_0x0040:
            r3 = 1
        L_0x0041:
            r0.setItalic(r3)
            int r3 = r1.getFamilyClass()
            if (r3 == r6) goto L_0x005f
            r4 = 7
            if (r3 == r4) goto L_0x005f
            r4 = 10
            if (r3 == r4) goto L_0x005b
            r4 = 3
            if (r3 == r4) goto L_0x005f
            r4 = 4
            if (r3 == r4) goto L_0x005f
            r4 = 5
            if (r3 == r4) goto L_0x005f
            goto L_0x0062
        L_0x005b:
            r0.setScript(r6)
            goto L_0x0062
        L_0x005f:
            r0.setSerif(r6)
        L_0x0062:
            int r3 = r1.getWeightClass()
            float r3 = (float) r3
            r0.setFontWeight(r3)
            r0.setSymbolic(r6)
            r0.setNonSymbolic(r5)
            float r2 = r2.getItalicAngle()
            r0.setItalicAngle(r2)
            org.apache.fontbox.ttf.HeaderTable r2 = r11.getHeader()
            org.apache.pdfbox.pdmodel.common.PDRectangle r3 = new org.apache.pdfbox.pdmodel.common.PDRectangle
            r3.<init>()
            r4 = 1148846080(0x447a0000, float:1000.0)
            int r5 = r2.getUnitsPerEm()
            float r5 = (float) r5
            float r4 = r4 / r5
            short r5 = r2.getXMin()
            float r5 = (float) r5
            float r5 = r5 * r4
            r3.setLowerLeftX(r5)
            short r5 = r2.getYMin()
            float r5 = (float) r5
            float r5 = r5 * r4
            r3.setLowerLeftY(r5)
            short r5 = r2.getXMax()
            float r5 = (float) r5
            float r5 = r5 * r4
            r3.setUpperRightX(r5)
            short r2 = r2.getYMax()
            float r2 = (float) r2
            float r2 = r2 * r4
            r3.setUpperRightY(r2)
            r0.setFontBoundingBox(r3)
            org.apache.fontbox.ttf.HorizontalHeaderTable r11 = r11.getHorizontalHeader()
            short r2 = r11.getAscender()
            float r2 = (float) r2
            float r2 = r2 * r4
            r0.setAscent(r2)
            short r11 = r11.getDescender()
            float r11 = (float) r11
            float r11 = r11 * r4
            r0.setDescent(r11)
            int r11 = r1.getVersion()
            double r2 = (double) r11
            r5 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            int r11 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x00ec
            int r11 = r1.getCapHeight()
            float r11 = (float) r11
            float r11 = r11 / r4
            r0.setCapHeight(r11)
            int r11 = r1.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r4
            r0.setXHeight(r11)
            goto L_0x0106
        L_0x00ec:
            int r11 = r1.getTypoAscender()
            int r2 = r1.getTypoDescender()
            int r2 = r2 + r11
            float r11 = (float) r2
            float r11 = r11 / r4
            r0.setCapHeight(r11)
            int r11 = r1.getTypoAscender()
            float r11 = (float) r11
            r1 = 1073741824(0x40000000, float:2.0)
            float r11 = r11 / r1
            float r11 = r11 / r4
            r0.setXHeight(r11)
        L_0x0106:
            org.apache.pdfbox.pdmodel.common.PDRectangle r11 = r0.getFontBoundingBox()
            float r11 = r11.getWidth()
            r1 = 1040522936(0x3e051eb8, float:0.13)
            float r11 = r11 * r1
            r0.setStemV(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.TrueTypeEmbedder.createFontDescriptor(org.apache.fontbox.ttf.TrueTypeFont):org.apache.pdfbox.pdmodel.font.PDFontDescriptor");
    }

    private boolean isEmbeddingPermitted(TrueTypeFont trueTypeFont) throws IOException {
        if (trueTypeFont.getOS2Windows() != null) {
            short fsType = trueTypeFont.getOS2Windows().getFsType() & 8;
            if ((fsType & 1) == 1 || (fsType & 512) == 512) {
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean isSubsettingPermitted(TrueTypeFont trueTypeFont) throws IOException {
        return trueTypeFont.getOS2Windows() == null || (trueTypeFont.getOS2Windows().getFsType() & 256) != 256;
    }

    public void addToSubset(int i) {
        this.subsetCodePoints.add(Integer.valueOf(i));
    }

    public void buildFontFile2(InputStream inputStream) throws IOException {
        InputStream inputStream2;
        PDStream pDStream = new PDStream(this.document, inputStream, false);
        pDStream.getStream().setInt(COSName.LENGTH1, pDStream.getByteArray().length);
        pDStream.addCompression();
        try {
            inputStream2 = pDStream.createInputStream();
            try {
                TrueTypeFont parseEmbedded = new TTFParser().parseEmbedded(inputStream2);
                this.ttf = parseEmbedded;
                if (isEmbeddingPermitted(parseEmbedded)) {
                    if (this.fontDescriptor == null) {
                        this.fontDescriptor = createFontDescriptor(this.ttf);
                    }
                    IOUtils.closeQuietly(inputStream2);
                    this.fontDescriptor.setFontFile2(pDStream);
                    return;
                }
                throw new IOException("This font does not permit embedding");
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(inputStream2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = null;
            IOUtils.closeQuietly(inputStream2);
            throw th;
        }
    }

    public abstract void buildSubset(InputStream inputStream, String str, Map<Integer, Integer> map) throws IOException;

    public PDFontDescriptor getFontDescriptor() {
        return this.fontDescriptor;
    }

    public String getTag(Map<Integer, Integer> map) {
        long hashCode = (long) map.hashCode();
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j = hashCode / 25;
            sb.append(BASE25.charAt((int) (hashCode % 25)));
            if (j != 0 && sb.length() < 6) {
                hashCode = j;
            }
        }
        while (sb.length() < 6) {
            sb.insert(0, 'A');
        }
        sb.append('+');
        return sb.toString();
    }

    public TrueTypeFont getTrueTypeFont() {
        return this.ttf;
    }

    public boolean needsSubset() {
        return this.embedSubset;
    }

    public void subset() throws IOException {
        if (!isSubsettingPermitted(this.ttf)) {
            throw new IOException("This font does not permit subsetting");
        } else if (this.embedSubset) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(HeaderTable.TAG);
            arrayList.add(HorizontalHeaderTable.TAG);
            arrayList.add(IndexToLocationTable.TAG);
            arrayList.add(MaximumProfileTable.TAG);
            arrayList.add("cvt ");
            arrayList.add("prep");
            arrayList.add(GlyphTable.TAG);
            arrayList.add(HorizontalMetricsTable.TAG);
            arrayList.add("fpgm");
            arrayList.add("gasp");
            TTFSubsetter tTFSubsetter = new TTFSubsetter(getTrueTypeFont(), arrayList);
            tTFSubsetter.addAll(this.subsetCodePoints);
            Map<Integer, Integer> gIDMap = tTFSubsetter.getGIDMap();
            String tag = getTag(gIDMap);
            tTFSubsetter.setPrefix(tag);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            tTFSubsetter.writeToStream(byteArrayOutputStream);
            buildSubset(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), tag, gIDMap);
        } else {
            throw new IllegalStateException("Subsetting is disabled");
        }
    }
}
