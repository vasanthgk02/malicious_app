package org.apache.pdfbox.pdmodel.interactive.form;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;

public abstract class PDField extends PDFieldTreeNode {
    public PDField(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
    }

    public int getFieldFlags() {
        COSInteger cOSInteger = (COSInteger) getDictionary().getDictionaryObject(COSName.FF);
        if (cOSInteger != null) {
            return cOSInteger.intValue();
        }
        if (getParent() != null) {
            return getParent().getFieldFlags();
        }
        return 0;
    }

    public String getFieldType() {
        String nameAsString = getDictionary().getNameAsString(COSName.FT);
        return (nameAsString != null || getParent() == null) ? nameAsString : getParent().getFieldType();
    }

    public void setActions(PDFormFieldAdditionalActions pDFormFieldAdditionalActions) {
        getDictionary().setItem(COSName.AA, (COSObjectable) pDFormFieldAdditionalActions);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
        outline73.append(getDictionary().getDictionaryObject(COSName.V));
        return outline73.toString();
    }

    public void updateFieldAppearances() throws IOException {
        if (!getAcroForm().isNeedAppearances()) {
            AppearanceGenerator.generateFieldAppearances(this);
        }
    }

    public PDField(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }
}
