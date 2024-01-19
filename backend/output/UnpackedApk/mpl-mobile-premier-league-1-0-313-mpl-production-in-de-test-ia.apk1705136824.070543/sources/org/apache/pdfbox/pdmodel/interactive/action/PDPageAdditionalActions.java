package org.apache.pdfbox.pdmodel.interactive.action;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

public class PDPageAdditionalActions implements COSObjectable {
    public final COSDictionary actions;

    public PDPageAdditionalActions() {
        this.actions = new COSDictionary();
    }

    public PDAction getC() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "C");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public COSDictionary getCOSDictionary() {
        return this.actions;
    }

    public COSBase getCOSObject() {
        return this.actions;
    }

    public PDAction getO() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public void setC(PDAction pDAction) {
        this.actions.setItem((String) "C", (COSObjectable) pDAction);
    }

    public void setO(PDAction pDAction) {
        this.actions.setItem((String) PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, (COSObjectable) pDAction);
    }

    public PDPageAdditionalActions(COSDictionary cOSDictionary) {
        this.actions = cOSDictionary;
    }
}
