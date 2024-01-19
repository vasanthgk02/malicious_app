package org.apache.pdfbox.pdmodel.graphics.optionalcontent;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;

public class PDOptionalContentGroup extends PDPropertyList {
    public PDOptionalContentGroup(String str) {
        this.dict.setItem(COSName.TYPE, (COSBase) COSName.OCG);
        setName(str);
    }

    public String getName() {
        return this.dict.getString(COSName.NAME);
    }

    public void setName(String str) {
        this.dict.setString(COSName.NAME, str);
    }

    public String toString() {
        return super.toString() + " (" + getName() + ")";
    }

    public PDOptionalContentGroup(COSDictionary cOSDictionary) {
        super(cOSDictionary);
        if (!cOSDictionary.getItem(COSName.TYPE).equals(COSName.OCG)) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Provided dictionary is not of type '");
            outline73.append(COSName.OCG);
            outline73.append("'");
            throw new IllegalArgumentException(outline73.toString());
        }
    }
}
