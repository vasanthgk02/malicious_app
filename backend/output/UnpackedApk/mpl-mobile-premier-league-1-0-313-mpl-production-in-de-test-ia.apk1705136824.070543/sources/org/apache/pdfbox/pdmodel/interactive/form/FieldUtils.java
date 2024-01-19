package org.apache.pdfbox.pdmodel.interactive.form;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSArrayList;

public final class FieldUtils {

    public static class KeyValue {
        public final String key;
        public final String value;

        public KeyValue(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("(");
            outline73.append(this.key);
            outline73.append(", ");
            return GeneratedOutlineSupport.outline62(outline73, this.value, ")");
        }
    }

    public static class KeyValueKeyComparator implements Serializable, Comparator<KeyValue> {
        public static final long serialVersionUID = 6715364290007167694L;

        public int compare(KeyValue keyValue, KeyValue keyValue2) {
            return keyValue.key.compareTo(keyValue2.key);
        }
    }

    public static class KeyValueValueComparator implements Serializable, Comparator<KeyValue> {
        public static final long serialVersionUID = -3984095679894798265L;

        public int compare(KeyValue keyValue, KeyValue keyValue2) {
            return keyValue.value.compareTo(keyValue2.value);
        }
    }

    public static List<String> getItemsFromPair(COSBase cOSBase, int i) {
        ArrayList arrayList = new ArrayList();
        COSArray cOSArray = (COSArray) cOSBase;
        int size = cOSArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((COSString) ((COSArray) cOSArray.get(i2)).get(i)).getString());
        }
        return arrayList;
    }

    public static List<String> getPairableItems(COSBase cOSBase, int i) {
        if (i < 0 || i > 1) {
            throw new IllegalArgumentException("Only 0 and 1 are allowed as an index into two-element arrays");
        } else if (cOSBase instanceof COSString) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(((COSString) cOSBase).getString());
            return arrayList;
        } else if (!(cOSBase instanceof COSArray)) {
            return Collections.emptyList();
        } else {
            COSArray cOSArray = (COSArray) cOSBase;
            if (cOSArray.get(0) instanceof COSString) {
                return COSArrayList.convertCOSStringCOSArrayToList(cOSArray);
            }
            return getItemsFromPair(cOSBase, i);
        }
    }

    public static void sortByKey(List<KeyValue> list) {
        Collections.sort(list, new KeyValueKeyComparator());
    }

    public static void sortByValue(List<KeyValue> list) {
        Collections.sort(list, new KeyValueValueComparator());
    }

    public static List<KeyValue> toKeyValueList(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new KeyValue(list.get(i), list2.get(i)));
        }
        return arrayList;
    }
}
