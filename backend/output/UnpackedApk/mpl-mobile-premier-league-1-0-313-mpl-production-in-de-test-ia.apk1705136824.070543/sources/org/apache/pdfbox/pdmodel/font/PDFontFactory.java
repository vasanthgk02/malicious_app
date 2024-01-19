package org.apache.pdfbox.pdmodel.font;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public final class PDFontFactory {
    public static PDFont createDefaultFont() throws IOException {
        COSDictionary cOSDictionary = new COSDictionary();
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.FONT);
        cOSDictionary.setItem(COSName.SUBTYPE, (COSBase) COSName.TRUE_TYPE);
        cOSDictionary.setString(COSName.BASE_FONT, (String) "Arial");
        return createFont(cOSDictionary);
    }

    public static PDCIDFont createDescendantFont(COSDictionary cOSDictionary, PDType0Font pDType0Font) throws IOException {
        COSName cOSName = cOSDictionary.getCOSName(COSName.TYPE, COSName.FONT);
        if (COSName.FONT.equals(cOSName)) {
            COSName cOSName2 = cOSDictionary.getCOSName(COSName.SUBTYPE);
            if (COSName.CID_FONT_TYPE0.equals(cOSName2)) {
                return new PDCIDFontType0(cOSDictionary, pDType0Font);
            }
            if (COSName.CID_FONT_TYPE2.equals(cOSName2)) {
                return new PDCIDFontType2(cOSDictionary, pDType0Font);
            }
            throw new IOException("Invalid font type: " + cOSName);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected 'Font' dictionary but found '");
        outline73.append(cOSName.getName());
        outline73.append("'");
        throw new IllegalArgumentException(outline73.toString());
    }

    public static PDFont createFont(COSDictionary cOSDictionary) throws IOException {
        COSName cOSName = cOSDictionary.getCOSName(COSName.TYPE, COSName.FONT);
        if (!COSName.FONT.equals(cOSName)) {
            cOSName.getName();
        }
        COSName cOSName2 = cOSDictionary.getCOSName(COSName.SUBTYPE);
        if (COSName.TYPE1.equals(cOSName2)) {
            COSBase dictionaryObject = cOSDictionary.getDictionaryObject(COSName.FONT_DESC);
            if (!(dictionaryObject instanceof COSDictionary) || !((COSDictionary) dictionaryObject).containsKey(COSName.FONT_FILE3)) {
                return new PDType1Font(cOSDictionary);
            }
            return new PDType1CFont(cOSDictionary);
        } else if (COSName.MM_TYPE1.equals(cOSName2)) {
            COSBase dictionaryObject2 = cOSDictionary.getDictionaryObject(COSName.FONT_DESC);
            if (!(dictionaryObject2 instanceof COSDictionary) || !((COSDictionary) dictionaryObject2).containsKey(COSName.FONT_FILE3)) {
                return new PDMMType1Font(cOSDictionary);
            }
            return new PDType1CFont(cOSDictionary);
        } else if (COSName.TRUE_TYPE.equals(cOSName2)) {
            return new PDTrueTypeFont(cOSDictionary);
        } else {
            if (COSName.TYPE3.equals(cOSName2)) {
                return new PDType3Font(cOSDictionary);
            }
            if (COSName.TYPE0.equals(cOSName2)) {
                return new PDType0Font(cOSDictionary);
            }
            if (COSName.CID_FONT_TYPE0.equals(cOSName2)) {
                throw new IllegalArgumentException("Type 0 descendant font not allowed");
            } else if (!COSName.CID_FONT_TYPE2.equals(cOSName2)) {
                "Invalid font subtype '" + cOSName2 + "'";
                return new PDType1Font(cOSDictionary);
            } else {
                throw new IllegalArgumentException("Type 2 descendant font not allowed");
            }
        }
    }
}
