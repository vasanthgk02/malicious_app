package org.apache.pdfbox.cos;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class COSArray extends COSBase implements Iterable<COSBase> {
    public final List<COSBase> objects = new ArrayList();

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromArray(this);
    }

    public void add(COSBase cOSBase) {
        this.objects.add(cOSBase);
    }

    public void addAll(Collection<COSBase> collection) {
        this.objects.addAll(collection);
    }

    public void clear() {
        this.objects.clear();
    }

    public COSBase get(int i) {
        return this.objects.get(i);
    }

    public int getInt(int i) {
        return getInt(i, -1);
    }

    public String getName(int i) {
        return getName(i, null);
    }

    public COSBase getObject(int i) {
        COSBase cOSBase = this.objects.get(i);
        if (cOSBase instanceof COSObject) {
            cOSBase = ((COSObject) cOSBase).getObject();
        } else if (cOSBase instanceof COSNull) {
            cOSBase = null;
        }
        return cOSBase;
    }

    public String getString(int i) {
        return getString(i, null);
    }

    public void growToSize(int i) {
        growToSize(i, null);
    }

    public int indexOf(COSBase cOSBase) {
        int i = -1;
        int i2 = 0;
        while (i < 0 && i2 < size()) {
            if (get(i2).equals(cOSBase)) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    public int indexOfObject(COSBase cOSBase) {
        for (int i = 0; i < size(); i++) {
            COSBase cOSBase2 = get(i);
            if (cOSBase2.equals(cOSBase)) {
                return i;
            }
            if ((cOSBase2 instanceof COSObject) && ((COSObject) cOSBase2).getObject().equals(cOSBase)) {
                return i;
            }
        }
        return -1;
    }

    public Iterator<COSBase> iterator() {
        return this.objects.iterator();
    }

    public COSBase remove(int i) {
        return this.objects.remove(i);
    }

    public void removeAll(Collection<COSBase> collection) {
        this.objects.removeAll(collection);
    }

    public boolean removeObject(COSBase cOSBase) {
        boolean remove = remove(cOSBase);
        if (!remove) {
            for (int i = 0; i < size(); i++) {
                COSBase cOSBase2 = get(i);
                if ((cOSBase2 instanceof COSObject) && ((COSObject) cOSBase2).getObject().equals(cOSBase)) {
                    return remove(cOSBase2);
                }
            }
        }
        return remove;
    }

    public void retainAll(Collection<COSBase> collection) {
        this.objects.retainAll(collection);
    }

    public void set(int i, COSBase cOSBase) {
        this.objects.set(i, cOSBase);
    }

    public void setFloatArray(float[] fArr) {
        clear();
        for (float cOSFloat : fArr) {
            add((COSBase) new COSFloat(cOSFloat));
        }
    }

    public void setInt(int i, int i2) {
        set(i, (COSBase) COSInteger.get((long) i2));
    }

    public void setName(int i, String str) {
        set(i, (COSBase) COSName.getPDFName(str));
    }

    public void setString(int i, String str) {
        if (str != null) {
            set(i, (COSBase) new COSString(str));
        } else {
            set(i, (COSBase) null);
        }
    }

    public int size() {
        return this.objects.size();
    }

    public float[] toFloatArray() {
        float[] fArr = new float[size()];
        for (int i = 0; i < size(); i++) {
            fArr[i] = ((COSNumber) getObject(i)).floatValue();
        }
        return fArr;
    }

    public List<?> toList() {
        ArrayList arrayList = new ArrayList(size());
        for (int i = 0; i < size(); i++) {
            arrayList.add(get(i));
        }
        return arrayList;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline64(GeneratedOutlineSupport.outline73("COSArray{"), this.objects, "}");
    }

    public void add(COSObjectable cOSObjectable) {
        this.objects.add(cOSObjectable.getCOSObject());
    }

    public void addAll(COSArray cOSArray) {
        if (cOSArray != null) {
            this.objects.addAll(cOSArray.objects);
        }
    }

    public int getInt(int i, int i2) {
        if (i >= size()) {
            return i2;
        }
        COSBase cOSBase = this.objects.get(i);
        return cOSBase instanceof COSNumber ? ((COSNumber) cOSBase).intValue() : i2;
    }

    public String getName(int i, String str) {
        if (i >= size()) {
            return str;
        }
        COSBase cOSBase = this.objects.get(i);
        return cOSBase instanceof COSName ? ((COSName) cOSBase).getName() : str;
    }

    public String getString(int i, String str) {
        if (i >= size()) {
            return str;
        }
        COSBase cOSBase = this.objects.get(i);
        return cOSBase instanceof COSString ? ((COSString) cOSBase).getString() : str;
    }

    public void growToSize(int i, COSBase cOSBase) {
        while (size() < i) {
            add(cOSBase);
        }
    }

    public boolean remove(COSBase cOSBase) {
        return this.objects.remove(cOSBase);
    }

    public void set(int i, int i2) {
        this.objects.set(i, COSInteger.get((long) i2));
    }

    public void add(int i, COSBase cOSBase) {
        this.objects.add(i, cOSBase);
    }

    public void addAll(int i, Collection<COSBase> collection) {
        this.objects.addAll(i, collection);
    }

    public void set(int i, COSObjectable cOSObjectable) {
        this.objects.set(i, cOSObjectable != null ? cOSObjectable.getCOSObject() : null);
    }
}
