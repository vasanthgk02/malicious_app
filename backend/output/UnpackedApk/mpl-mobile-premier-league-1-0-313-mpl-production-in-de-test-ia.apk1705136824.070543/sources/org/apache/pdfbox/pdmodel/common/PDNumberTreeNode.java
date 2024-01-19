package org.apache.pdfbox.pdmodel.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;

public class PDNumberTreeNode implements COSObjectable {
    public final COSDictionary node;
    public Class<? extends COSObjectable> valueType;

    public PDNumberTreeNode(Class<? extends COSObjectable> cls) {
        this.valueType = null;
        this.node = new COSDictionary();
        this.valueType = cls;
    }

    private void setLowerLimit(Integer num) {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.add((COSBase) null);
            cOSArray.add((COSBase) null);
            this.node.setItem(COSName.LIMITS, (COSBase) cOSArray);
        }
        if (num != null) {
            cOSArray.setInt(0, num.intValue());
        } else {
            cOSArray.set(0, (COSBase) null);
        }
    }

    private void setUpperLimit(Integer num) {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.add((COSBase) null);
            cOSArray.add((COSBase) null);
            this.node.setItem(COSName.LIMITS, (COSBase) cOSArray);
        }
        if (num != null) {
            cOSArray.setInt(1, num.intValue());
        } else {
            cOSArray.set(1, (COSBase) null);
        }
    }

    public COSObjectable convertCOSToPD(COSBase cOSBase) throws IOException {
        try {
            return (COSObjectable) this.valueType.getConstructor(new Class[]{cOSBase.getClass()}).newInstance(new Object[]{cOSBase});
        } catch (Throwable th) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while trying to create value in number tree:");
            outline73.append(th.getMessage());
            throw new IOException(outline73.toString(), th);
        }
    }

    public PDNumberTreeNode createChildNode(COSDictionary cOSDictionary) {
        return new PDNumberTreeNode(cOSDictionary, this.valueType);
    }

    public COSDictionary getCOSDictionary() {
        return this.node;
    }

    public COSBase getCOSObject() {
        return this.node;
    }

    public List<PDNumberTreeNode> getKids() {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.KIDS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(createChildNode((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public Integer getLowerLimit() {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray == null || cOSArray.get(0) == null) {
            return null;
        }
        return Integer.valueOf(cOSArray.getInt(0));
    }

    public Map<Integer, COSObjectable> getNumbers() throws IOException {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.NUMS);
        if (cOSArray == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < cOSArray.size(); i += 2) {
            hashMap.put(Integer.valueOf(((COSInteger) cOSArray.getObject(i)).intValue()), convertCOSToPD(cOSArray.getObject(i + 1)));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public Integer getUpperLimit() {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray == null || cOSArray.get(0) == null) {
            return null;
        }
        return Integer.valueOf(cOSArray.getInt(1));
    }

    public Object getValue(Integer num) throws IOException {
        Map<Integer, COSObjectable> numbers = getNumbers();
        Object obj = null;
        if (numbers != null) {
            return numbers.get(num);
        }
        List<PDNumberTreeNode> kids = getKids();
        if (kids == null) {
            return null;
        }
        for (int i = 0; i < kids.size() && obj == null; i++) {
            PDNumberTreeNode pDNumberTreeNode = kids.get(i);
            if (pDNumberTreeNode.getLowerLimit().compareTo(num) <= 0 && pDNumberTreeNode.getUpperLimit().compareTo(num) >= 0) {
                obj = pDNumberTreeNode.getValue(num);
            }
        }
        return obj;
    }

    public void setKids(List<? extends PDNumberTreeNode> list) {
        if (list != null && list.size() > 0) {
            setLowerLimit(((PDNumberTreeNode) list.get(0)).getLowerLimit());
            setUpperLimit(((PDNumberTreeNode) GeneratedOutlineSupport.outline29(list, -1)).getUpperLimit());
        } else if (this.node.getDictionaryObject(COSName.NUMS) == null) {
            this.node.setItem(COSName.LIMITS, (COSBase) null);
        }
        this.node.setItem(COSName.KIDS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setNumbers(Map<Integer, ? extends COSObjectable> map) {
        Integer num;
        Integer num2 = null;
        if (map == null) {
            this.node.setItem(COSName.NUMS, (COSObjectable) null);
            this.node.setItem(COSName.LIMITS, (COSObjectable) null);
            return;
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        COSArray cOSArray = new COSArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num3 = (Integer) it.next();
            cOSArray.add((COSBase) COSInteger.get((long) num3.intValue()));
            cOSArray.add((COSObjectable) map.get(num3));
        }
        if (arrayList.size() > 0) {
            Integer num4 = (Integer) arrayList.get(0);
            num2 = (Integer) arrayList.get(arrayList.size() - 1);
            num = num4;
        } else {
            num = null;
        }
        setUpperLimit(num2);
        setLowerLimit(num);
        this.node.setItem(COSName.NUMS, (COSBase) cOSArray);
    }

    public PDNumberTreeNode(COSDictionary cOSDictionary, Class<? extends COSObjectable> cls) {
        this.valueType = null;
        this.node = cOSDictionary;
        this.valueType = cls;
    }
}
