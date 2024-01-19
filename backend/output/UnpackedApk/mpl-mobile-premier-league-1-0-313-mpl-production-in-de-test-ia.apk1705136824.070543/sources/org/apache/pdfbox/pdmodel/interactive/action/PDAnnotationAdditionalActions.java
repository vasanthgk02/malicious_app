package org.apache.pdfbox.pdmodel.interactive.action;

import com.paynimo.android.payment.util.Constant;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;

public class PDAnnotationAdditionalActions implements COSObjectable {
    public COSDictionary actions;

    public PDAnnotationAdditionalActions() {
        this.actions = new COSDictionary();
    }

    public PDAction getBl() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "Bl");
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

    public PDAction getD() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "D");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getE() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) Constant.PAYMENT_METHOD_TYPE_EMI);
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getFo() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "Fo");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getPC() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "PC");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getPI() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "PI");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getPO() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "PO");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getPV() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "PV");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getU() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) PDBorderStyleDictionary.STYLE_UNDERLINE);
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getX() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "X");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public void setBl(PDAction pDAction) {
        this.actions.setItem((String) "Bl", (COSObjectable) pDAction);
    }

    public void setD(PDAction pDAction) {
        this.actions.setItem((String) "D", (COSObjectable) pDAction);
    }

    public void setE(PDAction pDAction) {
        this.actions.setItem((String) Constant.PAYMENT_METHOD_TYPE_EMI, (COSObjectable) pDAction);
    }

    public void setFo(PDAction pDAction) {
        this.actions.setItem((String) "Fo", (COSObjectable) pDAction);
    }

    public void setPC(PDAction pDAction) {
        this.actions.setItem((String) "PC", (COSObjectable) pDAction);
    }

    public void setPI(PDAction pDAction) {
        this.actions.setItem((String) "PI", (COSObjectable) pDAction);
    }

    public void setPO(PDAction pDAction) {
        this.actions.setItem((String) "PO", (COSObjectable) pDAction);
    }

    public void setPV(PDAction pDAction) {
        this.actions.setItem((String) "PV", (COSObjectable) pDAction);
    }

    public void setU(PDAction pDAction) {
        this.actions.setItem((String) PDBorderStyleDictionary.STYLE_UNDERLINE, (COSObjectable) pDAction);
    }

    public void setX(PDAction pDAction) {
        this.actions.setItem((String) "X", (COSObjectable) pDAction);
    }

    public PDAnnotationAdditionalActions(COSDictionary cOSDictionary) {
        this.actions = cOSDictionary;
    }
}
