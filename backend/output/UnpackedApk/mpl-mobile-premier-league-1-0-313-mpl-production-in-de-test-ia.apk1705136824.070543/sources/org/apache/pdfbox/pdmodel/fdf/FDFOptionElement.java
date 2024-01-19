package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class FDFOptionElement implements COSObjectable {
    public COSArray option;

    public FDFOptionElement() {
        COSArray cOSArray = new COSArray();
        this.option = cOSArray;
        cOSArray.add((COSBase) new COSString((String) ""));
        this.option.add((COSBase) new COSString((String) ""));
    }

    public COSArray getCOSArray() {
        return this.option;
    }

    public COSBase getCOSObject() {
        return this.option;
    }

    public String getDefaultAppearanceString() {
        return ((COSString) this.option.getObject(1)).getString();
    }

    public String getOption() {
        return ((COSString) this.option.getObject(0)).getString();
    }

    public void setDefaultAppearanceString(String str) {
        this.option.set(1, (COSBase) new COSString(str));
    }

    public void setOption(String str) {
        this.option.set(0, (COSBase) new COSString(str));
    }

    public FDFOptionElement(COSArray cOSArray) {
        this.option = cOSArray;
    }
}
