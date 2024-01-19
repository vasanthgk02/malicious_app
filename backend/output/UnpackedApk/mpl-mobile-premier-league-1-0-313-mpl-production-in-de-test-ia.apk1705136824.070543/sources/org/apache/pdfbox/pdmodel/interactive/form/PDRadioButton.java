package org.apache.pdfbox.pdmodel.interactive.form;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;

public final class PDRadioButton extends PDButton {
    public static final int FLAG_NO_TOGGLE_TO_OFF = 16384;

    public PDRadioButton(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
        setRadioButton(true);
    }

    public String getExportValue() throws IOException {
        List<String> options = getOptions();
        if (options.isEmpty()) {
            return getValue();
        }
        String value = getValue();
        int i = 0;
        for (COSObjectable next : getKids()) {
            if (next instanceof PDCheckbox) {
                if (((PDCheckbox) next).getOnValue().equals(value)) {
                    break;
                }
                i++;
            }
        }
        return i <= options.size() ? options.get(i) : "";
    }

    public boolean isRadiosInUnison() {
        return getDictionary().getFlag(COSName.FF, 33554432);
    }

    public void setRadiosInUnison(boolean z) {
        getDictionary().setFlag(COSName.FF, 33554432, z);
    }

    public void setValue(String str) {
        if (str == null) {
            removeInheritableAttribute(COSName.V);
            return;
        }
        COSName pDFName = COSName.getPDFName(str);
        setInheritableAttribute(COSName.V, pDFName);
        for (COSObjectable next : getKids()) {
            if (next instanceof PDAnnotationWidget) {
                if (((COSDictionary) ((PDAnnotationWidget) next).getAppearance().getNormalAppearance().getCOSObject()).containsKey(pDFName)) {
                    ((COSDictionary) next.getCOSObject()).setName(COSName.AS, str);
                } else {
                    ((COSDictionary) next.getCOSObject()).setName(COSName.AS, (String) "Off");
                }
            }
        }
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

    public PDRadioButton(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }
}
