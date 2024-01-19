package org.apache.pdfbox.pdmodel.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSString;

public class COSArrayList<E> implements List<E> {
    public final List<E> actual;
    public final COSArray array;
    public COSName dictKey;
    public COSDictionary parentDict;

    public COSArrayList() {
        this.array = new COSArray();
        this.actual = new ArrayList();
    }

    public static List<String> convertCOSNameCOSArrayToList(COSArray cOSArray) {
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(((COSName) cOSArray.getObject(i)).getName());
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public static List<String> convertCOSStringCOSArrayToList(COSArray cOSArray) {
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(((COSString) cOSArray.getObject(i)).getString());
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public static List<Float> convertFloatCOSArrayToList(COSArray cOSArray) {
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(Float.valueOf(((COSNumber) cOSArray.get(i)).floatValue()));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public static List<Integer> convertIntegerCOSArrayToList(COSArray cOSArray) {
        COSBase cOSBase;
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            if (cOSArray.get(i) instanceof COSObject) {
                cOSBase = ((COSObject) cOSArray.get(i)).getObject();
            } else {
                cOSBase = cOSArray.get(i);
            }
            arrayList.add(Integer.valueOf(((COSNumber) cOSBase).intValue()));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public static COSArray convertStringListToCOSNameCOSArray(List<String> list) {
        COSArray cOSArray = new COSArray();
        for (String pDFName : list) {
            cOSArray.add((COSBase) COSName.getPDFName(pDFName));
        }
        return cOSArray;
    }

    public static COSArray convertStringListToCOSStringCOSArray(List<String> list) {
        COSArray cOSArray = new COSArray();
        for (String cOSString : list) {
            cOSArray.add((COSBase) new COSString(cOSString));
        }
        return cOSArray;
    }

    public static COSArray converterToCOSArray(List<?> list) {
        if (list == null) {
            return null;
        }
        if (list instanceof COSArrayList) {
            return ((COSArrayList) list).array;
        }
        COSArray cOSArray = new COSArray();
        for (Object next : list) {
            if (next instanceof String) {
                cOSArray.add((COSBase) new COSString((String) next));
            } else if ((next instanceof Integer) || (next instanceof Long)) {
                cOSArray.add((COSBase) COSInteger.get(((Number) next).longValue()));
            } else if ((next instanceof Float) || (next instanceof Double)) {
                cOSArray.add((COSBase) new COSFloat(((Number) next).floatValue()));
            } else if (next instanceof COSObjectable) {
                cOSArray.add(((COSObjectable) next).getCOSObject());
            } else if (next instanceof DualCOSObjectable) {
                DualCOSObjectable dualCOSObjectable = (DualCOSObjectable) next;
                cOSArray.add(dualCOSObjectable.getFirstCOSObject());
                cOSArray.add(dualCOSObjectable.getSecondCOSObject());
            } else if (next == null) {
                cOSArray.add((COSBase) COSNull.NULL);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error: Don't know how to convert type to COSBase '");
                outline73.append(next.getClass().getName());
                outline73.append("'");
                throw new RuntimeException(outline73.toString());
            }
        }
        return cOSArray;
    }

    private List<COSBase> toCOSObjectList(Collection<?> collection) {
        ArrayList arrayList = new ArrayList();
        for (Object next : collection) {
            if (next instanceof String) {
                arrayList.add(new COSString((String) next));
            } else if (next instanceof DualCOSObjectable) {
                DualCOSObjectable dualCOSObjectable = (DualCOSObjectable) next;
                this.array.add(dualCOSObjectable.getFirstCOSObject());
                this.array.add(dualCOSObjectable.getSecondCOSObject());
            } else {
                arrayList.add(((COSObjectable) next).getCOSObject());
            }
        }
        return arrayList;
    }

    public boolean add(E e2) {
        COSDictionary cOSDictionary = this.parentDict;
        if (cOSDictionary != null) {
            cOSDictionary.setItem(this.dictKey, (COSBase) this.array);
            this.parentDict = null;
        }
        if (e2 instanceof String) {
            this.array.add((COSBase) new COSString((String) e2));
        } else if (e2 instanceof DualCOSObjectable) {
            DualCOSObjectable dualCOSObjectable = (DualCOSObjectable) e2;
            this.array.add(dualCOSObjectable.getFirstCOSObject());
            this.array.add(dualCOSObjectable.getSecondCOSObject());
        } else {
            COSArray cOSArray = this.array;
            if (cOSArray != null) {
                cOSArray.add(((COSObjectable) e2).getCOSObject());
            }
        }
        return this.actual.add(e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (this.parentDict != null && collection.size() > 0) {
            this.parentDict.setItem(this.dictKey, (COSBase) this.array);
            this.parentDict = null;
        }
        this.array.addAll((Collection<COSBase>) toCOSObjectList(collection));
        return this.actual.addAll(collection);
    }

    public void clear() {
        COSDictionary cOSDictionary = this.parentDict;
        if (cOSDictionary != null) {
            cOSDictionary.setItem(this.dictKey, (COSBase) null);
        }
        this.actual.clear();
        this.array.clear();
    }

    public boolean contains(Object obj) {
        return this.actual.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.actual.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.actual.equals(obj);
    }

    public E get(int i) {
        return this.actual.get(i);
    }

    public int hashCode() {
        return this.actual.hashCode();
    }

    public int indexOf(Object obj) {
        return this.actual.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.actual.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.actual.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.actual.indexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return this.actual.listIterator();
    }

    public boolean remove(Object obj) {
        int indexOf = this.actual.indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        this.actual.remove(indexOf);
        this.array.remove(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        this.array.removeAll(toCOSObjectList(collection));
        return this.actual.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        this.array.retainAll(toCOSObjectList(collection));
        return this.actual.retainAll(collection);
    }

    public E set(int i, E e2) {
        if (e2 instanceof String) {
            COSString cOSString = new COSString((String) e2);
            COSDictionary cOSDictionary = this.parentDict;
            if (cOSDictionary != null && i == 0) {
                cOSDictionary.setItem(this.dictKey, (COSBase) cOSString);
            }
            this.array.set(i, (COSBase) cOSString);
        } else if (e2 instanceof DualCOSObjectable) {
            DualCOSObjectable dualCOSObjectable = (DualCOSObjectable) e2;
            int i2 = i * 2;
            this.array.set(i2, dualCOSObjectable.getFirstCOSObject());
            this.array.set(i2 + 1, dualCOSObjectable.getSecondCOSObject());
        } else {
            COSDictionary cOSDictionary2 = this.parentDict;
            if (cOSDictionary2 != null && i == 0) {
                cOSDictionary2.setItem(this.dictKey, ((COSObjectable) e2).getCOSObject());
            }
            this.array.set(i, ((COSObjectable) e2).getCOSObject());
        }
        return this.actual.set(i, e2);
    }

    public int size() {
        return this.actual.size();
    }

    public List<E> subList(int i, int i2) {
        return this.actual.subList(i, i2);
    }

    public Object[] toArray() {
        return this.actual.toArray();
    }

    public COSArray toList() {
        return this.array;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("COSArrayList{");
        outline73.append(this.array.toString());
        outline73.append("}");
        return outline73.toString();
    }

    public ListIterator<E> listIterator(int i) {
        return this.actual.listIterator(i);
    }

    public <X> X[] toArray(X[] xArr) {
        return this.actual.toArray(xArr);
    }

    public COSArrayList(List<E> list, COSArray cOSArray) {
        this.actual = list;
        this.array = cOSArray;
    }

    public E remove(int i) {
        if (this.array.size() <= i || !(this.array.get(i) instanceof DualCOSObjectable)) {
            this.array.remove(i);
        } else {
            this.array.remove(i);
            this.array.remove(i);
        }
        return this.actual.remove(i);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        if (this.parentDict != null && collection.size() > 0) {
            this.parentDict.setItem(this.dictKey, (COSBase) this.array);
            this.parentDict = null;
        }
        if (collection.size() <= 0 || !(collection.toArray()[0] instanceof DualCOSObjectable)) {
            this.array.addAll(i, toCOSObjectList(collection));
        } else {
            this.array.addAll(i * 2, toCOSObjectList(collection));
        }
        return this.actual.addAll(i, collection);
    }

    public COSArrayList(E e2, COSBase cOSBase, COSDictionary cOSDictionary, COSName cOSName) {
        COSArray cOSArray = new COSArray();
        this.array = cOSArray;
        cOSArray.add(cOSBase);
        ArrayList arrayList = new ArrayList();
        this.actual = arrayList;
        arrayList.add(e2);
        this.parentDict = cOSDictionary;
        this.dictKey = cOSName;
    }

    public void add(int i, E e2) {
        COSDictionary cOSDictionary = this.parentDict;
        if (cOSDictionary != null) {
            cOSDictionary.setItem(this.dictKey, (COSBase) this.array);
            this.parentDict = null;
        }
        this.actual.add(i, e2);
        if (e2 instanceof String) {
            this.array.add(i, new COSString((String) e2));
        } else if (e2 instanceof DualCOSObjectable) {
            DualCOSObjectable dualCOSObjectable = (DualCOSObjectable) e2;
            int i2 = i * 2;
            this.array.add(i2, dualCOSObjectable.getFirstCOSObject());
            this.array.add(i2 + 1, dualCOSObjectable.getSecondCOSObject());
        } else {
            this.array.add(i, ((COSObjectable) e2).getCOSObject());
        }
    }
}
