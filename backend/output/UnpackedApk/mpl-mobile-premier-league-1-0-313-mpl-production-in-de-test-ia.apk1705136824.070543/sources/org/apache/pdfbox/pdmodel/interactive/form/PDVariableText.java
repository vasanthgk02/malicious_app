package org.apache.pdfbox.pdmodel.interactive.form;

import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.PDTextStream;

public abstract class PDVariableText extends PDField {
    public static final int QUADDING_CENTERED = 1;
    public static final int QUADDING_LEFT = 0;
    public static final int QUADDING_RIGHT = 2;

    public PDVariableText(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
    }

    public String getDefaultAppearance() {
        return ((COSString) getInheritableAttribute(COSName.DA)).getString();
    }

    public String getDefaultStyleString() {
        return ((COSString) getDictionary().getDictionaryObject(COSName.DS)).getString();
    }

    public int getQ() {
        COSNumber cOSNumber = (COSNumber) getInheritableAttribute(COSName.Q);
        if (cOSNumber != null) {
            return cOSNumber.intValue();
        }
        return 0;
    }

    public String getRichTextValue() throws IOException {
        PDTextStream asTextStream = getAsTextStream(getInheritableAttribute(COSName.RV));
        return asTextStream != null ? asTextStream.getAsString() : "";
    }

    public PDTextStream getRichTextValueAsStream() throws IOException {
        return getAsTextStream(getInheritableAttribute(COSName.RV));
    }

    public void setDefaultAppearance(String str) {
        if (str != null) {
            setInheritableAttribute(COSName.DA, new COSString(str));
        } else {
            removeInheritableAttribute(COSName.DA);
        }
    }

    public void setDefaultStyleString(String str) {
        if (str != null) {
            getDictionary().setItem(COSName.DS, (COSBase) new COSString(str));
        } else {
            getDictionary().removeItem(COSName.DS);
        }
    }

    public void setQ(int i) {
        getDictionary().setInt(COSName.Q, i);
    }

    public void setRichTextValue(String str) {
        if (str != null) {
            getDictionary().setItem(COSName.RV, (COSBase) new COSString(str));
        } else {
            getDictionary().removeItem(COSName.RV);
        }
    }

    public PDVariableText(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }

    public void setRichTextValue(PDTextStream pDTextStream) {
        if (pDTextStream != null) {
            getDictionary().setItem(COSName.RV, pDTextStream.getCOSObject());
        } else {
            getDictionary().removeItem(COSName.RV);
        }
    }
}
