package org.apache.pdfbox.pdmodel.common.filespecification;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSString;

public class PDSimpleFileSpecification extends PDFileSpecification {
    public COSString file;

    public PDSimpleFileSpecification() {
        this.file = new COSString((String) "");
    }

    public COSBase getCOSObject() {
        return this.file;
    }

    public String getFile() {
        return this.file.getString();
    }

    public void setFile(String str) {
        this.file = new COSString(str);
    }

    public PDSimpleFileSpecification(COSString cOSString) {
        this.file = cOSString;
    }
}
