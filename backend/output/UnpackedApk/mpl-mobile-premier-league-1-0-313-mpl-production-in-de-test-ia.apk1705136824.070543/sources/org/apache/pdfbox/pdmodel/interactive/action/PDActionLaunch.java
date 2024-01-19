package org.apache.pdfbox.pdmodel.interactive.action;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class PDActionLaunch extends PDAction {
    public static final String SUB_TYPE = "Launch";

    public PDActionLaunch() {
        setSubType(SUB_TYPE);
    }

    public String getD() {
        return this.action.getString((String) "D");
    }

    public String getF() {
        return this.action.getString((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
    }

    public PDFileSpecification getFile() throws IOException {
        return PDFileSpecification.createFS(getCOSDictionary().getDictionaryObject((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION));
    }

    public String getO() {
        return this.action.getString((String) PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
    }

    public String getP() {
        return this.action.getString((String) "P");
    }

    public PDWindowsLaunchParams getWinLaunchParams() {
        COSDictionary cOSDictionary = (COSDictionary) this.action.getDictionaryObject((String) "Win");
        if (cOSDictionary != null) {
            return new PDWindowsLaunchParams(cOSDictionary);
        }
        return null;
    }

    public void setD(String str) {
        this.action.setString((String) "D", str);
    }

    public void setF(String str) {
        this.action.setString((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, str);
    }

    public void setFile(PDFileSpecification pDFileSpecification) {
        getCOSDictionary().setItem((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, (COSObjectable) pDFileSpecification);
    }

    public void setO(String str) {
        this.action.setString((String) PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, str);
    }

    public void setOpenInNewWindow(boolean z) {
        this.action.setBoolean((String) "NewWindow", z);
    }

    public void setP(String str) {
        this.action.setString((String) "P", str);
    }

    public void setWinLaunchParams(PDWindowsLaunchParams pDWindowsLaunchParams) {
        this.action.setItem((String) "Win", (COSObjectable) pDWindowsLaunchParams);
    }

    public boolean shouldOpenInNewWindow() {
        return this.action.getBoolean((String) "NewWindow", true);
    }

    public PDActionLaunch(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
