package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDUserAttributeObject extends PDAttributeObject {
    public static final String OWNER_USER_PROPERTIES = "UserProperties";

    public PDUserAttributeObject() {
        setOwner(OWNER_USER_PROPERTIES);
    }

    public void addUserProperty(PDUserProperty pDUserProperty) {
        ((COSArray) getCOSDictionary().getDictionaryObject(COSName.P)).add((COSObjectable) pDUserProperty);
        notifyChanged();
    }

    public List<PDUserProperty> getOwnerUserProperties() {
        COSArray cOSArray = (COSArray) getCOSDictionary().getDictionaryObject(COSName.P);
        ArrayList arrayList = new ArrayList(cOSArray.size());
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(new PDUserProperty((COSDictionary) cOSArray.getObject(i), this));
        }
        return arrayList;
    }

    public void removeUserProperty(PDUserProperty pDUserProperty) {
        if (pDUserProperty != null) {
            ((COSArray) getCOSDictionary().getDictionaryObject(COSName.P)).remove(pDUserProperty.getCOSObject());
            notifyChanged();
        }
    }

    public void setUserProperties(List<PDUserProperty> list) {
        COSArray cOSArray = new COSArray();
        for (PDUserProperty add : list) {
            cOSArray.add((COSObjectable) add);
        }
        getCOSDictionary().setItem(COSName.P, (COSBase) cOSArray);
    }

    public String toString() {
        return super.toString() + ", userProperties=" + getOwnerUserProperties();
    }

    public void userPropertyChanged(PDUserProperty pDUserProperty) {
    }

    public PDUserAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
