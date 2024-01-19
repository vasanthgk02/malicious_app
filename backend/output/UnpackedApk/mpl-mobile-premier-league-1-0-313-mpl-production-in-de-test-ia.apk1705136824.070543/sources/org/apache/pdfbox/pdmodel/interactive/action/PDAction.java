package org.apache.pdfbox.pdmodel.interactive.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.PDDestinationOrAction;

public abstract class PDAction implements PDDestinationOrAction {
    public static final String TYPE = "Action";
    public COSDictionary action;

    public PDAction() {
        this.action = new COSDictionary();
        setType("Action");
    }

    public COSDictionary getCOSDictionary() {
        return this.action;
    }

    public COSBase getCOSObject() {
        return this.action;
    }

    public List<PDAction> getNext() {
        COSBase dictionaryObject = this.action.getDictionaryObject(COSName.NEXT);
        if (dictionaryObject instanceof COSDictionary) {
            return new COSArrayList(PDActionFactory.createAction((COSDictionary) dictionaryObject), dictionaryObject, this.action, COSName.NEXT);
        }
        if (!(dictionaryObject instanceof COSArray)) {
            return null;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(PDActionFactory.createAction((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public String getSubType() {
        return this.action.getNameAsString((String) "S");
    }

    public String getType() {
        return this.action.getNameAsString(COSName.TYPE);
    }

    public void setNext(List<?> list) {
        this.action.setItem(COSName.NEXT, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setSubType(String str) {
        this.action.setName((String) "S", str);
    }

    public final void setType(String str) {
        this.action.setName(COSName.TYPE, str);
    }

    public PDAction(COSDictionary cOSDictionary) {
        this.action = cOSDictionary;
    }
}
