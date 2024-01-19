package org.apache.pdfbox.pdmodel.common.function;

import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRange;

public class PDFunctionType3 extends PDFunction {
    public COSArray bounds = null;
    public COSArray encode = null;
    public COSArray functions = null;

    public PDFunctionType3(COSBase cOSBase) {
        super(cOSBase);
    }

    private PDRange getEncodeForParameter(int i) {
        return new PDRange(getEncode(), i);
    }

    public float[] eval(float[] fArr) throws IOException {
        PDFunction pDFunction;
        float f2 = fArr[0];
        PDRange domainForInput = getDomainForInput(0);
        float clipToRange = clipToRange(f2, domainForInput.getMin(), domainForInput.getMax());
        COSArray functions2 = getFunctions();
        if (functions2.size() != 1) {
            float[] floatArray = getBounds().toFloatArray();
            int length = floatArray.length;
            int i = length + 2;
            float[] fArr2 = new float[i];
            fArr2[0] = domainForInput.getMin();
            int i2 = i - 1;
            fArr2[i2] = domainForInput.getMax();
            System.arraycopy(floatArray, 0, fArr2, 1, length);
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    pDFunction = null;
                    break;
                }
                if (clipToRange >= fArr2[i3]) {
                    int i4 = i3 + 1;
                    if (clipToRange < fArr2[i4] || (i3 == i - 2 && clipToRange == fArr2[i4])) {
                        pDFunction = PDFunction.create(functions2.get(i3));
                        PDRange encodeForParameter = getEncodeForParameter(i3);
                        clipToRange = interpolate(clipToRange, fArr2[i3], fArr2[i4], encodeForParameter.getMin(), encodeForParameter.getMax());
                    }
                }
                i3++;
            }
        } else {
            pDFunction = PDFunction.create(functions2.get(0));
            PDRange encodeForParameter2 = getEncodeForParameter(0);
            clipToRange = interpolate(clipToRange, domainForInput.getMin(), domainForInput.getMax(), encodeForParameter2.getMin(), encodeForParameter2.getMax());
        }
        if (pDFunction != null) {
            return clipToRange(pDFunction.eval(new float[]{clipToRange}));
        }
        throw new IOException("partition not found in type 3 function");
    }

    public COSArray getBounds() {
        if (this.bounds == null) {
            this.bounds = (COSArray) getDictionary().getDictionaryObject(COSName.BOUNDS);
        }
        return this.bounds;
    }

    public COSArray getEncode() {
        if (this.encode == null) {
            this.encode = (COSArray) getDictionary().getDictionaryObject(COSName.ENCODE);
        }
        return this.encode;
    }

    public int getFunctionType() {
        return 3;
    }

    public COSArray getFunctions() {
        if (this.functions == null) {
            this.functions = (COSArray) getDictionary().getDictionaryObject(COSName.FUNCTIONS);
        }
        return this.functions;
    }
}
