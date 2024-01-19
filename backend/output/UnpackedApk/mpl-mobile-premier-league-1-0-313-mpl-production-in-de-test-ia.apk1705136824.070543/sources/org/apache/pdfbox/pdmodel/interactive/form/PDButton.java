package org.apache.pdfbox.pdmodel.interactive.form;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSArrayList;

public abstract class PDButton extends PDField {
    public static final int FLAG_PUSHBUTTON = 65536;
    public static final int FLAG_RADIO = 32768;
    public static final int FLAG_RADIOS_IN_UNISON = 33554432;
    public static final COSName OFF = COSName.getPDFName("Off");

    public PDButton(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
        getDictionary().setItem(COSName.FT, (COSBase) COSName.BTN);
    }

    public List<String> getOptions() {
        COSBase inheritableAttribute = getInheritableAttribute(COSName.OPT);
        if (inheritableAttribute instanceof COSString) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(((COSString) inheritableAttribute).getString());
            return arrayList;
        } else if (inheritableAttribute instanceof COSArray) {
            return COSArrayList.convertCOSStringCOSArrayToList((COSArray) inheritableAttribute);
        } else {
            return Collections.emptyList();
        }
    }

    public boolean isPushButton() {
        return getDictionary().getFlag(COSName.FF, 65536);
    }

    public boolean isRadioButton() {
        return getDictionary().getFlag(COSName.FF, 32768);
    }

    public void setDefaultValue(String str) {
        if (str == null) {
            getDictionary().removeItem(COSName.DV);
        } else {
            getDictionary().setItem(COSName.DV, (COSBase) COSName.getPDFName(str));
        }
    }

    public void setOptions(List<String> list) {
        if (list == null || list.isEmpty()) {
            removeInheritableAttribute(COSName.OPT);
        } else {
            setInheritableAttribute(COSName.OPT, COSArrayList.convertStringListToCOSStringCOSArray(list));
        }
    }

    public void setPushButton(boolean z) {
        getDictionary().setFlag(COSName.FF, 65536, z);
    }

    public void setRadioButton(boolean z) {
        getDictionary().setFlag(COSName.FF, 32768, z);
    }

    public String getDefaultValue() throws IOException {
        COSBase inheritableAttribute = getInheritableAttribute(COSName.DV);
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

    public PDButton(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }
}
