package org.apache.pdfbox.cos;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;

public class COSObject extends COSBase implements COSUpdateInfo {
    public COSBase baseObject;
    public int generationNumber;
    public boolean needToBeUpdated;
    public long objectNumber;

    public COSObject(COSBase cOSBase) throws IOException {
        setObject(cOSBase);
    }

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return getObject() != null ? getObject().accept(iCOSVisitor) : COSNull.NULL.accept(iCOSVisitor);
    }

    public COSBase getDictionaryObject(COSName cOSName) {
        COSBase cOSBase = this.baseObject;
        if (cOSBase instanceof COSDictionary) {
            return ((COSDictionary) cOSBase).getDictionaryObject(cOSName);
        }
        return null;
    }

    public int getGenerationNumber() {
        return this.generationNumber;
    }

    public COSBase getItem(COSName cOSName) {
        COSBase cOSBase = this.baseObject;
        if (cOSBase instanceof COSDictionary) {
            return ((COSDictionary) cOSBase).getItem(cOSName);
        }
        return null;
    }

    public COSBase getObject() {
        return this.baseObject;
    }

    public long getObjectNumber() {
        return this.objectNumber;
    }

    public boolean isNeedToBeUpdated() {
        return this.needToBeUpdated;
    }

    public void setGenerationNumber(int i) {
        this.generationNumber = i;
    }

    public void setNeedToBeUpdated(boolean z) {
        this.needToBeUpdated = z;
    }

    public final void setObject(COSBase cOSBase) throws IOException {
        this.baseObject = cOSBase;
    }

    public void setObjectNumber(long j) {
        this.objectNumber = j;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("COSObject{");
        outline73.append(Long.toString(this.objectNumber));
        outline73.append(", ");
        outline73.append(Integer.toString(this.generationNumber));
        outline73.append("}");
        return outline73.toString();
    }
}
