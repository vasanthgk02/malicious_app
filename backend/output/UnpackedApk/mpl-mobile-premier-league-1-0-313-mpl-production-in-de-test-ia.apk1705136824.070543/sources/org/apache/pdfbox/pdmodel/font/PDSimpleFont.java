package org.apache.pdfbox.pdmodel.font;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.font.encoding.DictionaryEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.pdmodel.font.encoding.MacRomanEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

public abstract class PDSimpleFont extends PDFont {
    public Encoding encoding;
    public GlyphList glyphList;
    public Boolean isSymbolic;
    public final Set<Integer> noUnicode;

    public PDSimpleFont() {
        this.noUnicode = new HashSet();
    }

    public void addToSubset(int i) {
        throw new UnsupportedOperationException();
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public GlyphList getGlyphList() {
        return this.glyphList;
    }

    public final float getStandard14Width(int i) {
        if (getStandard14AFM() != null) {
            String name = getEncoding().getName(i);
            if (name.equals(org.apache.fontbox.encoding.Encoding.NOTDEF)) {
                return 250.0f;
            }
            return getStandard14AFM().getCharacterWidth(name);
        }
        throw new IllegalStateException("No AFM");
    }

    public final Boolean getSymbolicFlag() {
        if (getFontDescriptor() != null) {
            return Boolean.valueOf(getFontDescriptor().isSymbolic());
        }
        return null;
    }

    public Boolean isFontSymbolic() {
        Boolean symbolicFlag = getSymbolicFlag();
        if (symbolicFlag != null) {
            return symbolicFlag;
        }
        if (isStandard14()) {
            return Boolean.valueOf(getName().equals("Symbol") || getName().equals("ZapfDingbats"));
        }
        Encoding encoding2 = this.encoding;
        if (encoding2 == null) {
            if (this instanceof PDTrueTypeFont) {
                return Boolean.TRUE;
            }
            throw new IllegalStateException("PDFBox bug: encoding should not be null!");
        } else if ((encoding2 instanceof WinAnsiEncoding) || (encoding2 instanceof MacRomanEncoding) || (encoding2 instanceof StandardEncoding)) {
            return Boolean.FALSE;
        } else {
            if (!(encoding2 instanceof DictionaryEncoding)) {
                return null;
            }
            for (String next : ((DictionaryEncoding) encoding2).getDifferences().values()) {
                if (!next.equals(org.apache.fontbox.encoding.Encoding.NOTDEF) && (!WinAnsiEncoding.INSTANCE.contains(next) || !MacRomanEncoding.INSTANCE.contains(next) || !StandardEncoding.INSTANCE.contains(next))) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
    }

    public boolean isStandard14() {
        if (!(getEncoding() instanceof DictionaryEncoding) || ((DictionaryEncoding) getEncoding()).getDifferences().size() <= 0) {
            return super.isStandard14();
        }
        return false;
    }

    public final boolean isSymbolic() {
        if (this.isSymbolic == null) {
            Boolean isFontSymbolic = isFontSymbolic();
            if (isFontSymbolic != null) {
                this.isSymbolic = isFontSymbolic;
            } else {
                this.isSymbolic = Boolean.TRUE;
            }
        }
        return this.isSymbolic.booleanValue();
    }

    public boolean isVertical() {
        return false;
    }

    public final void readEncoding() throws IOException {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.ENCODING);
        if (dictionaryObject == null) {
            this.encoding = readEncodingFromFont();
        } else if (dictionaryObject instanceof COSName) {
            COSName cOSName = (COSName) dictionaryObject;
            Encoding instance = Encoding.getInstance(cOSName);
            this.encoding = instance;
            if (instance == null) {
                cOSName.getName();
                this.encoding = readEncodingFromFont();
            }
        } else if (dictionaryObject instanceof COSDictionary) {
            COSDictionary cOSDictionary = (COSDictionary) dictionaryObject;
            Boolean symbolicFlag = getSymbolicFlag();
            Encoding readEncodingFromFont = (cOSDictionary.containsKey(COSName.BASE_ENCODING) || !(symbolicFlag != null && symbolicFlag.booleanValue())) ? null : readEncodingFromFont();
            if (symbolicFlag == null) {
                symbolicFlag = Boolean.FALSE;
            }
            if (readEncodingFromFont != null || cOSDictionary.containsKey(COSName.BASE_ENCODING) || !symbolicFlag.booleanValue()) {
                this.encoding = new DictionaryEncoding(cOSDictionary, !symbolicFlag.booleanValue(), readEncodingFromFont);
            } else {
                this.encoding = null;
            }
        }
        if (this.encoding == null && getSymbolicFlag() != null && !getSymbolicFlag().booleanValue()) {
            this.encoding = StandardEncoding.INSTANCE;
        }
        if (this.encoding == null && isStandard14() && !getName().equals("Symbol") && !getName().equals("ZapfDingbats")) {
            this.encoding = StandardEncoding.INSTANCE;
        }
        if ("ZapfDingbats".equals(getName())) {
            this.glyphList = GlyphList.getZapfDingbats();
        } else {
            this.glyphList = GlyphList.getAdobeGlyphList();
        }
    }

    public abstract Encoding readEncodingFromFont() throws IOException;

    public void subset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public String toUnicode(int i) throws IOException {
        return toUnicode(i, GlyphList.getAdobeGlyphList());
    }

    public boolean willBeSubset() {
        return false;
    }

    public String toUnicode(int i, GlyphList glyphList2) throws IOException {
        String str;
        if (this.glyphList != GlyphList.getAdobeGlyphList()) {
            glyphList2 = this.glyphList;
        }
        String unicode = super.toUnicode(i);
        if (unicode != null) {
            return unicode;
        }
        Encoding encoding2 = this.encoding;
        if (encoding2 != null) {
            str = encoding2.getName(i);
            String unicode2 = glyphList2.toUnicode(str);
            if (unicode2 != null) {
                return unicode2;
            }
        } else {
            str = null;
        }
        if (!this.noUnicode.contains(Integer.valueOf(i))) {
            this.noUnicode.add(Integer.valueOf(i));
            if (str != null) {
                getName();
            } else {
                getName();
            }
        }
        return null;
    }

    public PDSimpleFont(String str) {
        super(str);
        this.noUnicode = new HashSet();
        this.encoding = WinAnsiEncoding.INSTANCE;
        if ("ZapfDingbats".equals(str)) {
            this.glyphList = GlyphList.getZapfDingbats();
        } else {
            this.glyphList = GlyphList.getAdobeGlyphList();
        }
    }

    public PDSimpleFont(COSDictionary cOSDictionary) throws IOException {
        super(cOSDictionary);
        this.noUnicode = new HashSet();
    }
}
