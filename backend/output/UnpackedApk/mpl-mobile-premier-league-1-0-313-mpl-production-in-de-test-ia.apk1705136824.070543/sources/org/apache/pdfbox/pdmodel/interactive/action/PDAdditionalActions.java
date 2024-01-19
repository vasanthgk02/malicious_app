package org.apache.pdfbox.pdmodel.interactive.action;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class PDAdditionalActions implements COSObjectable {
    public COSDictionary actions;

    public PDAdditionalActions() {
        this.actions = new COSDictionary();
    }

    public COSDictionary getCOSDictionary() {
        return this.actions;
    }

    public COSBase getCOSObject() {
        return this.actions;
    }

    public PDAction getF() {
        return PDActionFactory.createAction((COSDictionary) this.actions.getDictionaryObject((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION));
    }

    public void setF(PDAction pDAction) {
        this.actions.setItem((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, (COSObjectable) pDAction);
    }

    public PDAdditionalActions(COSDictionary cOSDictionary) {
        this.actions = cOSDictionary;
    }
}
