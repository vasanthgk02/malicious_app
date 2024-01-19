package org.apache.pdfbox.pdmodel.common.function;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.pdmodel.common.PDStream;

public abstract class PDFunction implements COSObjectable {
    public COSArray domain = null;
    public COSDictionary functionDictionary = null;
    public PDStream functionStream = null;
    public int numberOfInputValues = -1;
    public int numberOfOutputValues = -1;
    public COSArray range = null;

    public PDFunction(COSBase cOSBase) {
        if (cOSBase instanceof COSStream) {
            PDStream pDStream = new PDStream((COSStream) cOSBase);
            this.functionStream = pDStream;
            pDStream.getStream().setItem(COSName.TYPE, (COSBase) COSName.FUNCTION);
        } else if (cOSBase instanceof COSDictionary) {
            this.functionDictionary = (COSDictionary) cOSBase;
        }
    }

    public static PDFunction create(COSBase cOSBase) throws IOException {
        PDFunction pDFunction = null;
        if (cOSBase == COSName.IDENTITY) {
            return new PDFunctionTypeIdentity(null);
        }
        if (cOSBase instanceof COSObject) {
            cOSBase = ((COSObject) cOSBase).getObject();
        }
        COSDictionary cOSDictionary = (COSDictionary) cOSBase;
        int i = cOSDictionary.getInt(COSName.FUNCTION_TYPE);
        if (i != 0) {
            if (i == 2) {
                pDFunction = new PDFunctionType2(cOSDictionary);
            } else if (i == 3) {
                pDFunction = new PDFunctionType3(cOSDictionary);
            } else if (i == 4) {
                pDFunction = new PDFunctionType4(cOSDictionary);
            } else {
                throw new IOException(GeneratedOutlineSupport.outline41("Error: Unknown function type ", i));
            }
        }
        return pDFunction;
    }

    private COSArray getDomainValues() {
        if (this.domain == null) {
            this.domain = (COSArray) getDictionary().getDictionaryObject(COSName.DOMAIN);
        }
        return this.domain;
    }

    public float clipToRange(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public float[] clipToRange(float[] fArr) {
        COSArray rangeValues = getRangeValues();
        if (rangeValues == null) {
            return fArr;
        }
        float[] floatArray = rangeValues.toFloatArray();
        int length = floatArray.length / 2;
        float[] fArr2 = new float[length];
        for (int i = 0; i < length; i++) {
            int i2 = i << 1;
            fArr2[i] = clipToRange(fArr[i], floatArray[i2], floatArray[i2 + 1]);
        }
        return fArr2;
    }

    public COSArray eval(COSArray cOSArray) throws IOException {
        float[] eval = eval(cOSArray.toFloatArray());
        COSArray cOSArray2 = new COSArray();
        cOSArray2.setFloatArray(eval);
        return cOSArray2;
    }

    public abstract float[] eval(float[] fArr) throws IOException;

    public COSBase getCOSObject() {
        PDStream pDStream = this.functionStream;
        if (pDStream != null) {
            return pDStream.getCOSObject();
        }
        return this.functionDictionary;
    }

    public COSDictionary getDictionary() {
        PDStream pDStream = this.functionStream;
        if (pDStream != null) {
            return pDStream.getStream();
        }
        return this.functionDictionary;
    }

    public PDRange getDomainForInput(int i) {
        return new PDRange(getDomainValues(), i);
    }

    public abstract int getFunctionType();

    public int getNumberOfInputParameters() {
        if (this.numberOfInputValues == -1) {
            this.numberOfInputValues = getDomainValues().size() / 2;
        }
        return this.numberOfInputValues;
    }

    public int getNumberOfOutputParameters() {
        if (this.numberOfOutputValues == -1) {
            this.numberOfOutputValues = getRangeValues().size() / 2;
        }
        return this.numberOfOutputValues;
    }

    public PDStream getPDStream() {
        return this.functionStream;
    }

    public PDRange getRangeForOutput(int i) {
        return new PDRange(getRangeValues(), i);
    }

    public COSArray getRangeValues() {
        if (this.range == null) {
            this.range = (COSArray) getDictionary().getDictionaryObject(COSName.RANGE);
        }
        return this.range;
    }

    public float interpolate(float f2, float f3, float f4, float f5, float f6) {
        return (((f6 - f5) * (f2 - f3)) / (f4 - f3)) + f5;
    }

    public void setDomainValues(COSArray cOSArray) {
        this.domain = cOSArray;
        getDictionary().setItem(COSName.DOMAIN, (COSBase) cOSArray);
    }

    public void setRangeValues(COSArray cOSArray) {
        this.range = cOSArray;
        getDictionary().setItem(COSName.RANGE, (COSBase) cOSArray);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FunctionType");
        outline73.append(getFunctionType());
        return outline73.toString();
    }
}
