package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDAttributeObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;

public abstract class PDStandardAttributeObject extends PDAttributeObject {
    public static final float UNSPECIFIED = -1.0f;

    public PDStandardAttributeObject() {
    }

    public String[] getArrayOfString(String str) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        if (!(dictionaryObject instanceof COSArray)) {
            return null;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        String[] strArr = new String[cOSArray.size()];
        for (int i = 0; i < cOSArray.size(); i++) {
            strArr[i] = ((COSName) cOSArray.getObject(i)).getName();
        }
        return strArr;
    }

    public PDGamma getColor(String str) {
        COSArray cOSArray = (COSArray) getCOSDictionary().getDictionaryObject(str);
        if (cOSArray != null) {
            return new PDGamma(cOSArray);
        }
        return null;
    }

    public Object getColorOrFourColors(String str) {
        COSArray cOSArray = (COSArray) getCOSDictionary().getDictionaryObject(str);
        PDFourColours pDFourColours = null;
        if (cOSArray == null) {
            return null;
        }
        if (cOSArray.size() == 3) {
            return new PDGamma(cOSArray);
        }
        if (cOSArray.size() == 4) {
            pDFourColours = new PDFourColours(cOSArray);
        }
        return pDFourColours;
    }

    public int getInteger(String str, int i) {
        return getCOSDictionary().getInt(str, i);
    }

    public String getName(String str) {
        return getCOSDictionary().getNameAsString(str);
    }

    public Object getNameOrArrayOfName(String str, String str2) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        if (!(dictionaryObject instanceof COSArray)) {
            return dictionaryObject instanceof COSName ? ((COSName) dictionaryObject).getName() : str2;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        String[] strArr = new String[cOSArray.size()];
        for (int i = 0; i < cOSArray.size(); i++) {
            COSBase object = cOSArray.getObject(i);
            if (object instanceof COSName) {
                strArr[i] = ((COSName) object).getName();
            }
        }
        return strArr;
    }

    public float getNumber(String str, float f2) {
        return getCOSDictionary().getFloat(str, f2);
    }

    public Object getNumberOrArrayOfNumber(String str, float f2) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            float[] fArr = new float[cOSArray.size()];
            for (int i = 0; i < cOSArray.size(); i++) {
                COSBase object = cOSArray.getObject(i);
                if (object instanceof COSNumber) {
                    fArr[i] = ((COSNumber) object).floatValue();
                }
            }
            return fArr;
        } else if (dictionaryObject instanceof COSNumber) {
            return Float.valueOf(((COSNumber) dictionaryObject).floatValue());
        } else {
            if (f2 == -1.0f) {
                return null;
            }
            return Float.valueOf(f2);
        }
    }

    public Object getNumberOrName(String str, String str2) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        if (dictionaryObject instanceof COSNumber) {
            return Float.valueOf(((COSNumber) dictionaryObject).floatValue());
        }
        return dictionaryObject instanceof COSName ? ((COSName) dictionaryObject).getName() : str2;
    }

    public String getString(String str) {
        return getCOSDictionary().getString(str);
    }

    public boolean isSpecified(String str) {
        return getCOSDictionary().getDictionaryObject(str) != null;
    }

    public void setArrayOfName(String str, String[] strArr) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        COSArray cOSArray = new COSArray();
        for (String pDFName : strArr) {
            cOSArray.add((COSBase) COSName.getPDFName(pDFName));
        }
        getCOSDictionary().setItem(str, (COSBase) cOSArray);
        potentiallyNotifyChanged(dictionaryObject, getCOSDictionary().getDictionaryObject(str));
    }

    public void setArrayOfNumber(String str, float[] fArr) {
        COSArray cOSArray = new COSArray();
        for (float cOSFloat : fArr) {
            cOSArray.add((COSBase) new COSFloat(cOSFloat));
        }
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        getCOSDictionary().setItem(str, (COSBase) cOSArray);
        potentiallyNotifyChanged(dictionaryObject, getCOSDictionary().getDictionaryObject(str));
    }

    public void setArrayOfString(String str, String[] strArr) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        COSArray cOSArray = new COSArray();
        for (String cOSString : strArr) {
            cOSArray.add((COSBase) new COSString(cOSString));
        }
        getCOSDictionary().setItem(str, (COSBase) cOSArray);
        potentiallyNotifyChanged(dictionaryObject, getCOSDictionary().getDictionaryObject(str));
    }

    public void setColor(String str, PDGamma pDGamma) {
        COSBase cOSBase;
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        getCOSDictionary().setItem(str, (COSObjectable) pDGamma);
        if (pDGamma == null) {
            cOSBase = null;
        } else {
            cOSBase = pDGamma.getCOSObject();
        }
        potentiallyNotifyChanged(dictionaryObject, cOSBase);
    }

    public void setFourColors(String str, PDFourColours pDFourColours) {
        COSBase cOSBase;
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        getCOSDictionary().setItem(str, (COSObjectable) pDFourColours);
        if (pDFourColours == null) {
            cOSBase = null;
        } else {
            cOSBase = pDFourColours.getCOSObject();
        }
        potentiallyNotifyChanged(dictionaryObject, cOSBase);
    }

    public void setInteger(String str, int i) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        getCOSDictionary().setInt(str, i);
        potentiallyNotifyChanged(dictionaryObject, getCOSDictionary().getDictionaryObject(str));
    }

    public void setName(String str, String str2) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        getCOSDictionary().setName(str, str2);
        potentiallyNotifyChanged(dictionaryObject, getCOSDictionary().getDictionaryObject(str));
    }

    public void setNumber(String str, float f2) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        getCOSDictionary().setFloat(str, f2);
        potentiallyNotifyChanged(dictionaryObject, getCOSDictionary().getDictionaryObject(str));
    }

    public void setString(String str, String str2) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        getCOSDictionary().setString(str, str2);
        potentiallyNotifyChanged(dictionaryObject, getCOSDictionary().getDictionaryObject(str));
    }

    public PDStandardAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public String getName(String str, String str2) {
        return getCOSDictionary().getNameAsString(str, str2);
    }

    public float getNumber(String str) {
        return getCOSDictionary().getFloat(str);
    }

    public void setNumber(String str, int i) {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(str);
        getCOSDictionary().setInt(str, i);
        potentiallyNotifyChanged(dictionaryObject, getCOSDictionary().getDictionaryObject(str));
    }
}
