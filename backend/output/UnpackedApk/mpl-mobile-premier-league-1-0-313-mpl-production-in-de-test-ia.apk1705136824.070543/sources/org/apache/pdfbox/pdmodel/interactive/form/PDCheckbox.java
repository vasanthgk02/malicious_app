package org.apache.pdfbox.pdmodel.interactive.form;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public final class PDCheckbox extends PDButton {
    public PDCheckbox(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
    }

    public void check() {
        String onValue = getOnValue();
        setValue(onValue);
        getDictionary().setItem(COSName.AS, (COSBase) COSName.getPDFName(onValue));
    }

    public String getOffValue() {
        return PDButton.OFF.getName();
    }

    public String getOnValue() {
        COSBase dictionaryObject = ((COSDictionary) getDictionary().getDictionaryObject(COSName.AP)).getDictionaryObject(COSName.N);
        if (dictionaryObject instanceof COSDictionary) {
            for (COSName next : ((COSDictionary) dictionaryObject).keySet()) {
                if (!next.equals(PDButton.OFF)) {
                    return next.getName();
                }
            }
        }
        return "";
    }

    public boolean isChecked() throws IOException {
        String onValue = getOnValue();
        try {
            String value = getValue();
            COSName cOSName = (COSName) getDictionary().getDictionaryObject(COSName.AS);
            if (!(cOSName == null || value == null || !cOSName.getName().equals(onValue))) {
                return true;
            }
        } catch (IOException unused) {
        }
        return false;
    }

    public void setValue(String str) {
        if (str == null) {
            getDictionary().removeItem(COSName.V);
            getDictionary().setItem(COSName.AS, (COSBase) PDButton.OFF);
            return;
        }
        COSName pDFName = COSName.getPDFName(str);
        getDictionary().setItem(COSName.V, (COSBase) pDFName);
        getDictionary().setItem(COSName.AS, (COSBase) pDFName);
    }

    public void unCheck() {
        getDictionary().setItem(COSName.AS, (COSBase) PDButton.OFF);
    }

    public PDCheckbox(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }

    public String getValue() throws IOException {
        COSBase inheritableAttribute = getInheritableAttribute(COSName.V);
        if (inheritableAttribute == null) {
            return "";
        }
        if (inheritableAttribute instanceof COSName) {
            return ((COSName) inheritableAttribute).getName();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected a COSName entry but got ");
        outline73.append(inheritableAttribute.getClass().getName());
        throw new IOException(outline73.toString());
    }
}
