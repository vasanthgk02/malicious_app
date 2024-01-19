package org.apache.pdfbox.pdmodel.interactive.action;

import in.juspay.hypersdk.core.PaymentConstants.Category;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDTextStream;

public class PDActionJavaScript extends PDAction {
    public static final String SUB_TYPE = "JavaScript";

    public PDActionJavaScript() {
        setSubType(SUB_TYPE);
    }

    public PDTextStream getAction() {
        return PDTextStream.createTextStream(this.action.getDictionaryObject((String) Category.JS));
    }

    public void setAction(PDTextStream pDTextStream) {
        this.action.setItem((String) Category.JS, (COSObjectable) pDTextStream);
    }

    public void setAction(String str) {
        this.action.setString((String) Category.JS, str);
    }

    public PDActionJavaScript(String str) {
        this();
        setAction(str);
    }

    public PDActionJavaScript(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
