package org.apache.pdfbox.pdmodel.interactive.action;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;

public class PDDocumentCatalogAdditionalActions implements COSObjectable {
    public final COSDictionary actions;

    public PDDocumentCatalogAdditionalActions() {
        this.actions = new COSDictionary();
    }

    public COSDictionary getCOSDictionary() {
        return this.actions;
    }

    public COSBase getCOSObject() {
        return this.actions;
    }

    public PDAction getDP() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "DP");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getDS() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "DS");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getWC() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "WC");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getWP() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) StandardStructureTypes.WP);
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getWS() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "WS");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public void setDP(PDAction pDAction) {
        this.actions.setItem((String) "DP", (COSObjectable) pDAction);
    }

    public void setDS(PDAction pDAction) {
        this.actions.setItem((String) "DS", (COSObjectable) pDAction);
    }

    public void setWC(PDAction pDAction) {
        this.actions.setItem((String) "WC", (COSObjectable) pDAction);
    }

    public void setWP(PDAction pDAction) {
        this.actions.setItem((String) StandardStructureTypes.WP, (COSObjectable) pDAction);
    }

    public void setWS(PDAction pDAction) {
        this.actions.setItem((String) "WS", (COSObjectable) pDAction);
    }

    public PDDocumentCatalogAdditionalActions(COSDictionary cOSDictionary) {
        this.actions = cOSDictionary;
    }
}
