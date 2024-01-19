package org.apache.pdfbox.pdmodel.graphics.color;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;

public final class PDColor {
    public final PDColorSpace colorSpace;
    public final float[] components;
    public final COSName patternName;

    public PDColor(COSArray cOSArray, PDColorSpace pDColorSpace) {
        int i = 0;
        if (cOSArray.size() <= 0 || !(cOSArray.get(cOSArray.size() - 1) instanceof COSName)) {
            this.components = new float[cOSArray.size()];
            while (i < cOSArray.size()) {
                this.components[i] = ((COSNumber) cOSArray.get(i)).floatValue();
                i++;
            }
            this.patternName = null;
        } else {
            this.components = new float[(cOSArray.size() - 1)];
            while (i < cOSArray.size() - 1) {
                this.components[i] = ((COSNumber) cOSArray.get(i)).floatValue();
                i++;
            }
            this.patternName = (COSName) cOSArray.get(cOSArray.size() - 1);
        }
        this.colorSpace = pDColorSpace;
    }

    public PDColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public float[] getComponents() {
        return (float[]) this.components.clone();
    }

    public COSName getPatternName() {
        return this.patternName;
    }

    public boolean isPattern() {
        return this.patternName != null;
    }

    public COSArray toCOSArray() {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(this.components);
        cOSArray.add((COSBase) this.patternName);
        return cOSArray;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PDColor{components=");
        outline73.append(Arrays.toString(this.components));
        outline73.append(", patternName=");
        outline73.append(this.patternName);
        outline73.append("}");
        return outline73.toString();
    }

    public PDColor(float[] fArr, PDColorSpace pDColorSpace) {
        this.components = (float[]) fArr.clone();
        this.patternName = null;
        this.colorSpace = pDColorSpace;
    }

    public PDColor(COSName cOSName, PDColorSpace pDColorSpace) {
        this.components = new float[0];
        this.patternName = cOSName;
        this.colorSpace = pDColorSpace;
    }

    public PDColor(float[] fArr, COSName cOSName, PDColorSpace pDColorSpace) {
        this.components = (float[]) fArr.clone();
        this.patternName = cOSName;
        this.colorSpace = pDColorSpace;
    }
}
