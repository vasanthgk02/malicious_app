package org.apache.pdfbox.pdmodel.interactive.action;

import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

public class PDFormFieldAdditionalActions implements COSObjectable {
    public final COSDictionary actions;

    public PDFormFieldAdditionalActions() {
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

    public PDAction getF() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getK() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) "K");
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public PDAction getV() {
        COSDictionary cOSDictionary = (COSDictionary) this.actions.getDictionaryObject((String) DefaultSFSDataSerializer.FIELD_VALUE_KEY);
        if (cOSDictionary != null) {
            return PDActionFactory.createAction(cOSDictionary);
        }
        return null;
    }

    public void setC(PDAction pDAction) {
        this.actions.setItem((String) "C", (COSObjectable) pDAction);
    }

    public void setF(PDAction pDAction) {
        this.actions.setItem((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, (COSObjectable) pDAction);
    }

    public void setK(PDAction pDAction) {
        this.actions.setItem((String) "K", (COSObjectable) pDAction);
    }

    public void setV(PDAction pDAction) {
        this.actions.setItem((String) DefaultSFSDataSerializer.FIELD_VALUE_KEY, (COSObjectable) pDAction);
    }

    public PDFormFieldAdditionalActions(COSDictionary cOSDictionary) {
        this.actions = cOSDictionary;
    }
}
