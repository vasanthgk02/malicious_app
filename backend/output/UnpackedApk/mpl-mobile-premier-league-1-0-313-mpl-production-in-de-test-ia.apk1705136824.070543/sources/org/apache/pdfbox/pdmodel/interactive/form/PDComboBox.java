package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public final class PDComboBox extends PDChoice {
    public static final int FLAG_EDIT = 262144;

    public PDComboBox(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
        setCombo(true);
    }

    public boolean isEdit() {
        return getDictionary().getFlag(COSName.FF, 262144);
    }

    public void setEdit(boolean z) {
        getDictionary().setFlag(COSName.FF, 262144, z);
    }

    public void setValue(String str) {
        if (str == null) {
            getDictionary().removeItem(COSName.V);
        } else if (isEdit() || getOptions().indexOf(str) != -1) {
            getDictionary().setString(COSName.V, str);
            setSelectedOptionsIndex(null);
        } else {
            throw new IllegalArgumentException("The list box does not contain the given value.");
        }
    }

    public PDComboBox(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }
}
