package org.apache.pdfbox.pdmodel.font;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;

public abstract class PDFont implements COSObjectable, PDFontLike {
    public static final Matrix DEFAULT_FONT_MATRIX;
    public final FontMetrics afmStandard14;
    public float avgFontWidth;
    public final COSDictionary dict;
    public PDFontDescriptor fontDescriptor;
    public float fontWidthOfSpace;
    public final CMap toUnicodeCMap;
    public List<Integer> widths;

    static {
        Matrix matrix = new Matrix(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
        DEFAULT_FONT_MATRIX = matrix;
    }

    public PDFont() {
        this.fontWidthOfSpace = -1.0f;
        COSDictionary cOSDictionary = new COSDictionary();
        this.dict = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.FONT);
        this.toUnicodeCMap = null;
        this.fontDescriptor = null;
        this.afmStandard14 = null;
    }

    public abstract void addToSubset(int i);

    public abstract byte[] encode(int i) throws IOException;

    public final byte[] encode(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            byteArrayOutputStream.write(encode(codePointAt));
            i += Character.charCount(codePointAt);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public boolean equals(Object obj) {
        return (obj instanceof PDFont) && ((PDFont) obj).getCOSObject() == getCOSObject();
    }

    public float getAverageFontWidth() {
        float f2;
        float f3;
        float f4 = this.avgFontWidth;
        if (f4 == 0.0f) {
            COSArray cOSArray = (COSArray) this.dict.getDictionaryObject(COSName.WIDTHS);
            if (cOSArray != null) {
                f3 = 0.0f;
                f2 = 0.0f;
                for (int i = 0; i < cOSArray.size(); i++) {
                    COSNumber cOSNumber = (COSNumber) cOSArray.getObject(i);
                    if (cOSNumber.floatValue() > 0.0f) {
                        f3 += cOSNumber.floatValue();
                        f2 += 1.0f;
                    }
                }
            } else {
                f3 = 0.0f;
                f2 = 0.0f;
            }
            f4 = f3 > 0.0f ? f3 / f2 : 0.0f;
            this.avgFontWidth = f4;
        }
        return f4;
    }

    public abstract BoundingBox getBoundingBox() throws IOException;

    public Vector getDisplacement(int i) throws IOException {
        return new Vector(getWidth(i) / 1000.0f, 0.0f);
    }

    public PDFontDescriptor getFontDescriptor() {
        return this.fontDescriptor;
    }

    public Matrix getFontMatrix() {
        return DEFAULT_FONT_MATRIX;
    }

    public abstract String getName();

    public Vector getPositionVector(int i) {
        throw new UnsupportedOperationException("Horizontal fonts have no position vector");
    }

    public float getSpaceWidth() {
        if (this.fontWidthOfSpace == -1.0f) {
            if (this.dict.getDictionaryObject(COSName.TO_UNICODE) != null) {
                try {
                    int spaceMapping = this.toUnicodeCMap.getSpaceMapping();
                    if (spaceMapping > -1) {
                        this.fontWidthOfSpace = getWidth(spaceMapping);
                    }
                } catch (Exception unused) {
                    this.fontWidthOfSpace = 250.0f;
                }
            } else {
                this.fontWidthOfSpace = getWidth(32);
            }
            if (this.fontWidthOfSpace <= 0.0f) {
                this.fontWidthOfSpace = getAverageFontWidth();
            }
        }
        return this.fontWidthOfSpace;
    }

    public final FontMetrics getStandard14AFM() {
        return this.afmStandard14;
    }

    public float getStringWidth(String str) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encode(str));
        float f2 = 0.0f;
        while (byteArrayInputStream.available() > 0) {
            f2 += getWidth(readCode(byteArrayInputStream));
        }
        return f2;
    }

    public String getSubType() {
        return this.dict.getNameAsString(COSName.SUBTYPE);
    }

    public String getType() {
        return this.dict.getNameAsString(COSName.TYPE);
    }

    public float getWidth(int i) throws IOException {
        if (this.dict.containsKey(COSName.WIDTHS) || this.dict.containsKey(COSName.MISSING_WIDTH)) {
            int i2 = this.dict.getInt(COSName.FIRST_CHAR, -1);
            int i3 = this.dict.getInt(COSName.LAST_CHAR, -1);
            if (getWidths().size() > 0 && i >= i2 && i <= i3) {
                return getWidths().get(i - i2).floatValue();
            }
            PDFontDescriptor fontDescriptor2 = getFontDescriptor();
            if (fontDescriptor2 != null) {
                return fontDescriptor2.getMissingWidth();
            }
        }
        return getWidthFromFont(i);
    }

    public final List<Integer> getWidths() {
        if (this.widths == null) {
            COSArray cOSArray = (COSArray) this.dict.getDictionaryObject(COSName.WIDTHS);
            if (cOSArray != null) {
                this.widths = COSArrayList.convertIntegerCOSArrayToList(cOSArray);
            } else {
                this.widths = Collections.emptyList();
            }
        }
        return this.widths;
    }

    public int hashCode() {
        return getCOSObject().hashCode();
    }

    public abstract boolean isDamaged();

    public abstract boolean isEmbedded();

    public boolean isStandard14() {
        if (isEmbedded()) {
            return false;
        }
        return Standard14Fonts.containsName(getName());
    }

    public abstract boolean isVertical();

    public final CMap readCMap(COSBase cOSBase) throws IOException {
        if (cOSBase instanceof COSName) {
            return CMapManager.getPredefinedCMap(((COSName) cOSBase).getName());
        }
        if (cOSBase instanceof COSStream) {
            InputStream inputStream = null;
            try {
                inputStream = ((COSStream) cOSBase).getUnfilteredStream();
                return CMapManager.parseCMap(inputStream);
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        } else {
            throw new IOException("Expected Name or Stream");
        }
    }

    public abstract int readCode(InputStream inputStream) throws IOException;

    public final void setFontDescriptor(PDFontDescriptor pDFontDescriptor) {
        this.fontDescriptor = pDFontDescriptor;
    }

    public abstract void subset() throws IOException;

    public String toString() {
        return getClass().getSimpleName() + CMap.SPACE + getName();
    }

    public String toUnicode(int i, GlyphList glyphList) throws IOException {
        return toUnicode(i);
    }

    public abstract boolean willBeSubset();

    public COSDictionary getCOSObject() {
        return this.dict;
    }

    public String toUnicode(int i) throws IOException {
        CMap cMap = this.toUnicodeCMap;
        if (cMap == null) {
            return null;
        }
        if (cMap.getName() == null || !this.toUnicodeCMap.getName().startsWith("Identity-")) {
            return this.toUnicodeCMap.toUnicode(i);
        }
        return new String(new char[]{(char) i});
    }

    public PDFont(String str) {
        this.fontWidthOfSpace = -1.0f;
        this.dict = new COSDictionary();
        this.toUnicodeCMap = null;
        FontMetrics afm = Standard14Fonts.getAFM(str);
        this.afmStandard14 = afm;
        if (afm != null) {
            this.fontDescriptor = PDType1FontEmbedder.buildFontDescriptor(afm);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("No AFM for font ", str));
    }

    public PDFont(COSDictionary cOSDictionary) throws IOException {
        this.fontWidthOfSpace = -1.0f;
        this.dict = cOSDictionary;
        this.afmStandard14 = Standard14Fonts.getAFM(getName());
        COSDictionary cOSDictionary2 = (COSDictionary) this.dict.getDictionaryObject(COSName.FONT_DESC);
        if (cOSDictionary2 != null) {
            this.fontDescriptor = new PDFontDescriptor(cOSDictionary2);
        } else {
            FontMetrics fontMetrics = this.afmStandard14;
            if (fontMetrics != null) {
                this.fontDescriptor = PDType1FontEmbedder.buildFontDescriptor(fontMetrics);
            } else {
                this.fontDescriptor = null;
            }
        }
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.TO_UNICODE);
        if (dictionaryObject != null) {
            CMap readCMap = readCMap(dictionaryObject);
            this.toUnicodeCMap = readCMap;
            if (readCMap != null && !readCMap.hasUnicodeMappings()) {
                getName();
                return;
            }
            return;
        }
        this.toUnicodeCMap = null;
    }
}
