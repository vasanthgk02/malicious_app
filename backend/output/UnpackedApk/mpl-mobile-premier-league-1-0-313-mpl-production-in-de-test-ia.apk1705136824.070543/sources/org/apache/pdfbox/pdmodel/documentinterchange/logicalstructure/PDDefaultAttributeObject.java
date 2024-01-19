package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class PDDefaultAttributeObject extends PDAttributeObject {
    public PDDefaultAttributeObject() {
    }

    public List<String> getAttributeNames() {
        ArrayList arrayList = new ArrayList();
        for (Entry<COSName, COSBase> key : getCOSDictionary().entrySet()) {
            COSName cOSName = (COSName) key.getKey();
            if (!COSName.O.equals(cOSName)) {
                arrayList.add(cOSName.getName());
            }
        }
        return arrayList;
    }

    public COSBase getAttributeValue(String str) {
        return getCOSDictionary().getDictionaryObject(str);
    }

    public void setAttribute(String str, COSBase cOSBase) {
        COSBase attributeValue = getAttributeValue(str);
        getCOSDictionary().setItem(COSName.getPDFName(str), cOSBase);
        potentiallyNotifyChanged(attributeValue, cOSBase);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", attributes={");
        Iterator<String> it = getAttributeNames().iterator();
        while (it.hasNext()) {
            String next = it.next();
            sb.append(next);
            sb.append('=');
            sb.append(getAttributeValue(next));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public PDDefaultAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public COSBase getAttributeValue(String str, COSBase cOSBase) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        return dictionaryObject == null ? cOSBase : dictionaryObject;
    }
}
