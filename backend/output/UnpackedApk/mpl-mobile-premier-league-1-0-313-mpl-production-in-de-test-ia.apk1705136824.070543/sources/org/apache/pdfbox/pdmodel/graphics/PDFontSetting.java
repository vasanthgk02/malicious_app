package org.apache.pdfbox.pdmodel.graphics;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;

public class PDFontSetting implements COSObjectable {
    public COSArray fontSetting = null;

    public PDFontSetting() {
        COSArray cOSArray = new COSArray();
        this.fontSetting = cOSArray;
        cOSArray.add((COSBase) null);
        GeneratedOutlineSupport.outline91(1.0f, this.fontSetting);
    }

    public COSBase getCOSObject() {
        return this.fontSetting;
    }

    public PDFont getFont() throws IOException {
        COSBase cOSBase = this.fontSetting.get(0);
        if (cOSBase instanceof COSDictionary) {
            return PDFontFactory.createFont((COSDictionary) cOSBase);
        }
        return null;
    }

    public float getFontSize() {
        return ((COSNumber) this.fontSetting.get(1)).floatValue();
    }

    public void setFont(PDFont pDFont) {
        this.fontSetting.set(0, (COSObjectable) pDFont);
    }

    public void setFontSize(float f2) {
        this.fontSetting.set(1, (COSBase) new COSFloat(f2));
    }

    public PDFontSetting(COSArray cOSArray) {
        this.fontSetting = cOSArray;
    }
}
