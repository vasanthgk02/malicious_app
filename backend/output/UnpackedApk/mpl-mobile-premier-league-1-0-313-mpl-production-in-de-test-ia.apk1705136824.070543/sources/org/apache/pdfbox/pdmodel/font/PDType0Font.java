package org.apache.pdfbox.pdmodel.font;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;

public class PDType0Font extends PDFont {
    public CMap cMap;
    public CMap cMapUCS2;
    public final PDCIDFont descendantFont;
    public PDCIDFontType2Embedder embedder;
    public boolean isCMapPredefined;

    public PDType0Font(COSDictionary cOSDictionary) throws IOException {
        super(cOSDictionary);
        COSDictionary cOSDictionary2 = (COSDictionary) ((COSArray) this.dict.getDictionaryObject(COSName.DESCENDANT_FONTS)).getObject(0);
        if (cOSDictionary2 != null) {
            readEncoding();
            fetchCMapUCS2();
            this.descendantFont = PDFontFactory.createDescendantFont(cOSDictionary2, this);
            return;
        }
        throw new IOException("Missing descendant font dictionary");
    }

    private void fetchCMapUCS2() throws IOException {
        if (this.isCMapPredefined) {
            String str = null;
            COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.ENCODING);
            if (dictionaryObject instanceof COSName) {
                str = ((COSName) dictionaryObject).getName();
            }
            if (str != null && !str.equals("Identity-H") && !str.equals("Identity-V")) {
                CMap predefinedCMap = CMapManager.getPredefinedCMap(str);
                if (predefinedCMap != null) {
                    CMap predefinedCMap2 = CMapManager.getPredefinedCMap(predefinedCMap.getRegistry() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + predefinedCMap.getOrdering() + "-UCS2");
                    if (predefinedCMap2 != null) {
                        this.cMapUCS2 = predefinedCMap2;
                    }
                }
            }
        }
    }

    public static PDType0Font load(PDDocument pDDocument, File file) throws IOException {
        return new PDType0Font(pDDocument, new FileInputStream(file), true);
    }

    private void readEncoding() throws IOException {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.ENCODING);
        if (dictionaryObject instanceof COSName) {
            CMap predefinedCMap = CMapManager.getPredefinedCMap(((COSName) dictionaryObject).getName());
            this.cMap = predefinedCMap;
            if (predefinedCMap != null) {
                this.isCMapPredefined = true;
                return;
            }
            throw new IOException("Missing required CMap");
        } else if (dictionaryObject != null) {
            CMap readCMap = readCMap(dictionaryObject);
            this.cMap = readCMap;
            if (readCMap == null) {
                throw new IOException("Missing required CMap");
            } else if (!readCMap.hasCIDMappings()) {
                getName();
            }
        }
    }

    public void addToSubset(int i) {
        if (willBeSubset()) {
            this.embedder.addToSubset(i);
            return;
        }
        throw new IllegalStateException("This font was created with subsetting disabled");
    }

    public int codeToCID(int i) {
        return this.descendantFont.codeToCID(i);
    }

    public int codeToGID(int i) throws IOException {
        return this.descendantFont.codeToGID(i);
    }

    public byte[] encode(int i) throws IOException {
        return this.descendantFont.encode(i);
    }

    public float getAverageFontWidth() {
        return this.descendantFont.getAverageFontWidth();
    }

    public String getBaseFont() {
        return this.dict.getNameAsString(COSName.BASE_FONT);
    }

    public BoundingBox getBoundingBox() throws IOException {
        return this.descendantFont.getBoundingBox();
    }

    public CMap getCMap() {
        return this.cMap;
    }

    public CMap getCMapUCS2() {
        return this.cMapUCS2;
    }

    public PDCIDFont getDescendantFont() {
        return this.descendantFont;
    }

    public Vector getDisplacement(int i) throws IOException {
        if (isVertical()) {
            return new Vector(0.0f, this.descendantFont.getVerticalDisplacementVectorY(i) / 1000.0f);
        }
        return super.getDisplacement(i);
    }

    public PDFontDescriptor getFontDescriptor() {
        return this.descendantFont.getFontDescriptor();
    }

    public Matrix getFontMatrix() {
        return this.descendantFont.getFontMatrix();
    }

    public float getHeight(int i) throws IOException {
        return this.descendantFont.getHeight(i);
    }

    public String getName() {
        return getBaseFont();
    }

    public Vector getPositionVector(int i) {
        return this.descendantFont.getPositionVector(i).scale(-0.001f);
    }

    public float getWidth(int i) throws IOException {
        return this.descendantFont.getWidth(i);
    }

    public float getWidthFromFont(int i) throws IOException {
        return this.descendantFont.getWidthFromFont(i);
    }

    public boolean isDamaged() {
        return this.descendantFont.isDamaged();
    }

    public boolean isEmbedded() {
        return this.descendantFont.isEmbedded();
    }

    public boolean isStandard14() {
        return false;
    }

    public boolean isVertical() {
        return this.cMap.getWMode() == 1;
    }

    public int readCode(InputStream inputStream) throws IOException {
        return this.cMap.readCode(inputStream);
    }

    public void subset() throws IOException {
        if (willBeSubset()) {
            this.embedder.subset();
            return;
        }
        throw new IllegalStateException("This font was created with subsetting disabled");
    }

    public String toString() {
        String simpleName = getDescendantFont() != null ? getDescendantFont().getClass().getSimpleName() : null;
        return PDType0Font.class.getSimpleName() + "/" + simpleName + CMap.SPACE + getBaseFont();
    }

    public String toUnicode(int i) throws IOException {
        String unicode = super.toUnicode(i);
        if (unicode != null) {
            return unicode;
        }
        if (!this.isCMapPredefined || this.cMapUCS2 == null) {
            return null;
        }
        return this.cMapUCS2.toUnicode(codeToCID(i));
    }

    public boolean willBeSubset() {
        return this.embedder.needsSubset();
    }

    public static PDType0Font load(PDDocument pDDocument, InputStream inputStream) throws IOException {
        return new PDType0Font(pDDocument, inputStream, true);
    }

    public static PDType0Font load(PDDocument pDDocument, InputStream inputStream, boolean z) throws IOException {
        return new PDType0Font(pDDocument, inputStream, z);
    }

    public PDType0Font(PDDocument pDDocument, InputStream inputStream, boolean z) throws IOException {
        PDCIDFontType2Embedder pDCIDFontType2Embedder = new PDCIDFontType2Embedder(pDDocument, this.dict, inputStream, z, this);
        this.embedder = pDCIDFontType2Embedder;
        this.descendantFont = pDCIDFontType2Embedder.getCIDFont();
        readEncoding();
        fetchCMapUCS2();
    }
}
