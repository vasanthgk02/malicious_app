package org.apache.pdfbox.pdmodel.interactive.action;

import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class PDActionRemoteGoTo extends PDAction {
    public static final String SUB_TYPE = "GoToR";

    public PDActionRemoteGoTo() {
        this.action = new COSDictionary();
        setSubType(SUB_TYPE);
    }

    public COSBase getD() {
        return this.action.getDictionaryObject((String) "D");
    }

    public PDFileSpecification getFile() throws IOException {
        return PDFileSpecification.createFS(this.action.getDictionaryObject((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION));
    }

    public String getS() {
        return this.action.getNameAsString((String) "S");
    }

    public void setD(COSBase cOSBase) {
        this.action.setItem((String) "D", cOSBase);
    }

    public void setFile(PDFileSpecification pDFileSpecification) {
        this.action.setItem((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, (COSObjectable) pDFileSpecification);
    }

    public void setOpenInNewWindow(boolean z) {
        this.action.setBoolean((String) "NewWindow", z);
    }

    public void setS(String str) {
        this.action.setName((String) "S", str);
    }

    public boolean shouldOpenInNewWindow() {
        return this.action.getBoolean((String) "NewWindow", true);
    }

    public PDActionRemoteGoTo(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
