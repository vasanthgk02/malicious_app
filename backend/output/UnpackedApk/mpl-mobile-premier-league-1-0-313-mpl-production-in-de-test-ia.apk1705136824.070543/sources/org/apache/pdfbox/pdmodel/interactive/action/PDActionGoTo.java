package org.apache.pdfbox.pdmodel.interactive.action;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;

public class PDActionGoTo extends PDAction {
    public static final String SUB_TYPE = "GoTo";

    public PDActionGoTo() {
        setSubType(SUB_TYPE);
    }

    public PDDestination getDestination() throws IOException {
        return PDDestination.create(getCOSDictionary().getDictionaryObject((String) "D"));
    }

    public void setDestination(PDDestination pDDestination) {
        getCOSDictionary().setItem((String) "D", (COSObjectable) pDDestination);
    }

    public PDActionGoTo(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
