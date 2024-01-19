package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;

public class PDUserProperty extends PDDictionaryWrapper {
    public final PDUserAttributeObject userAttributeObject;

    public PDUserProperty(PDUserAttributeObject pDUserAttributeObject) {
        this.userAttributeObject = pDUserAttributeObject;
    }

    public static boolean isEntryChanged(Object obj, Object obj2) {
        boolean z = true;
        if (obj != null) {
            return !obj.equals(obj2);
        }
        if (obj2 == null) {
            z = false;
        }
        return z;
    }

    private void potentiallyNotifyChanged(Object obj, Object obj2) {
        if (isEntryChanged(obj, obj2)) {
            this.userAttributeObject.userPropertyChanged(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || PDUserProperty.class != obj.getClass()) {
            return false;
        }
        PDUserProperty pDUserProperty = (PDUserProperty) obj;
        PDUserAttributeObject pDUserAttributeObject = this.userAttributeObject;
        if (pDUserAttributeObject == null) {
            if (pDUserProperty.userAttributeObject != null) {
                return false;
            }
        } else if (!pDUserAttributeObject.equals(pDUserProperty.userAttributeObject)) {
            return false;
        }
        return true;
    }

    public String getFormattedValue() {
        return getCOSDictionary().getString(COSName.F);
    }

    public String getName() {
        return getCOSDictionary().getNameAsString(COSName.N);
    }

    public COSBase getValue() {
        return getCOSDictionary().getDictionaryObject(COSName.V);
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        PDUserAttributeObject pDUserAttributeObject = this.userAttributeObject;
        return hashCode + (pDUserAttributeObject == null ? 0 : pDUserAttributeObject.hashCode());
    }

    public boolean isHidden() {
        return getCOSDictionary().getBoolean(COSName.H, false);
    }

    public void setFormattedValue(String str) {
        potentiallyNotifyChanged(getFormattedValue(), str);
        getCOSDictionary().setString(COSName.F, str);
    }

    public void setHidden(boolean z) {
        potentiallyNotifyChanged(Boolean.valueOf(isHidden()), Boolean.valueOf(z));
        getCOSDictionary().setBoolean(COSName.H, z);
    }

    public void setName(String str) {
        potentiallyNotifyChanged(getName(), str);
        getCOSDictionary().setName(COSName.N, str);
    }

    public void setValue(COSBase cOSBase) {
        potentiallyNotifyChanged(getValue(), cOSBase);
        getCOSDictionary().setItem(COSName.V, cOSBase);
    }

    public String toString() {
        return "Name=" + getName() + ", Value=" + getValue() + ", FormattedValue=" + getFormattedValue() + ", Hidden=" + isHidden();
    }

    public PDUserProperty(COSDictionary cOSDictionary, PDUserAttributeObject pDUserAttributeObject) {
        super(cOSDictionary);
        this.userAttributeObject = pDUserAttributeObject;
    }
}
