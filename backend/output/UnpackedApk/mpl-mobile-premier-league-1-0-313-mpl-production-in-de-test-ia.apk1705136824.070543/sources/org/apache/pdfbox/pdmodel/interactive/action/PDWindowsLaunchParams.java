package org.apache.pdfbox.pdmodel.interactive.action;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class PDWindowsLaunchParams implements COSObjectable {
    public static final String OPERATION_OPEN = "open";
    public static final String OPERATION_PRINT = "print";
    public COSDictionary params;

    public PDWindowsLaunchParams() {
        this.params = new COSDictionary();
    }

    public COSDictionary getCOSDictionary() {
        return this.params;
    }

    public COSBase getCOSObject() {
        return this.params;
    }

    public String getDirectory() {
        return this.params.getString((String) "D");
    }

    public String getExecuteParam() {
        return this.params.getString((String) "P");
    }

    public String getFilename() {
        return this.params.getString((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
    }

    public String getOperation() {
        return this.params.getString((String) PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, (String) OPERATION_OPEN);
    }

    public void setDirectory(String str) {
        this.params.setString((String) "D", str);
    }

    public void setExecuteParam(String str) {
        this.params.setString((String) "P", str);
    }

    public void setFilename(String str) {
        this.params.setString((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, str);
    }

    public void setOperation(String str) {
        this.params.setString((String) "D", str);
    }

    public PDWindowsLaunchParams(COSDictionary cOSDictionary) {
        this.params = cOSDictionary;
    }
}
