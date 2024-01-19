package org.apache.pdfbox.pdmodel.fdf;

import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class FDFPage implements COSObjectable {
    public COSDictionary page;

    public FDFPage() {
        this.page = new COSDictionary();
    }

    public COSDictionary getCOSDictionary() {
        return this.page;
    }

    public COSBase getCOSObject() {
        return this.page;
    }

    public FDFPageInfo getPageInfo() {
        COSDictionary cOSDictionary = (COSDictionary) this.page.getDictionaryObject(COSName.INFO);
        if (cOSDictionary != null) {
            return new FDFPageInfo(cOSDictionary);
        }
        return null;
    }

    public List<FDFTemplate> getTemplates() {
        COSArray cOSArray = (COSArray) this.page.getDictionaryObject(COSName.TEMPLATES);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(new FDFTemplate((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public void setPageInfo(FDFPageInfo fDFPageInfo) {
        this.page.setItem(COSName.INFO, (COSObjectable) fDFPageInfo);
    }

    public void setTemplates(List<FDFTemplate> list) {
        this.page.setItem(COSName.TEMPLATES, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public FDFPage(COSDictionary cOSDictionary) {
        this.page = cOSDictionary;
    }
}
