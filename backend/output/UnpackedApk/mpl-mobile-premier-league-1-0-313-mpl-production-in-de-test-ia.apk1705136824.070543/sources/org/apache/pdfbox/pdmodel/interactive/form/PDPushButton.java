package org.apache.pdfbox.pdmodel.interactive.form;

import java.util.Collections;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;

public class PDPushButton extends PDButton {
    public PDPushButton(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
        setPushButton(true);
    }

    public String getDefaultValue() {
        return "";
    }

    public List<String> getOptions() {
        return Collections.emptyList();
    }

    public String getValue() {
        return "";
    }

    public void setDefaultValue(String str) {
        if (str != null && !str.isEmpty()) {
            throw new IllegalArgumentException("A PDPushButton shall not use the DV entry in the field dictionary");
        }
    }

    public void setOptions(List<String> list) {
        if (list != null && !list.isEmpty()) {
            throw new IllegalArgumentException("A PDPushButton shall not use the Opt entry in the field dictionary");
        }
    }

    public void setValue(String str) {
        if (str != null && !str.isEmpty()) {
            throw new IllegalArgumentException("A PDPushButton shall not use the V entry in the field dictionary");
        }
    }

    public PDPushButton(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }
}
