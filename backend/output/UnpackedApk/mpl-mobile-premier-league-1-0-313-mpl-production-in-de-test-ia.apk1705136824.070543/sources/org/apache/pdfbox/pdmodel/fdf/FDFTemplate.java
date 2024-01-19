package org.apache.pdfbox.pdmodel.fdf;

import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class FDFTemplate implements COSObjectable {
    public COSDictionary template;

    public FDFTemplate() {
        this.template = new COSDictionary();
    }

    public COSDictionary getCOSDictionary() {
        return this.template;
    }

    public COSBase getCOSObject() {
        return this.template;
    }

    public List<FDFField> getFields() {
        COSArray cOSArray = (COSArray) this.template.getDictionaryObject(COSName.FIELDS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(new FDFField((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public FDFNamedPageReference getTemplateReference() {
        COSDictionary cOSDictionary = (COSDictionary) this.template.getDictionaryObject(COSName.TREF);
        if (cOSDictionary != null) {
            return new FDFNamedPageReference(cOSDictionary);
        }
        return null;
    }

    public void setFields(List<FDFField> list) {
        this.template.setItem(COSName.FIELDS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setRename(boolean z) {
        this.template.setBoolean(COSName.RENAME, z);
    }

    public void setTemplateReference(FDFNamedPageReference fDFNamedPageReference) {
        this.template.setItem(COSName.TREF, (COSObjectable) fDFNamedPageReference);
    }

    public boolean shouldRename() {
        return this.template.getBoolean(COSName.RENAME, false);
    }

    public FDFTemplate(COSDictionary cOSDictionary) {
        this.template = cOSDictionary;
    }
}
