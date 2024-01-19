package org.apache.pdfbox.pdmodel.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;

public class PDNameTreeNode implements COSObjectable {
    public final COSDictionary node;
    public PDNameTreeNode parent;
    public Class<? extends COSObjectable> valueType;

    public PDNameTreeNode(Class<? extends COSObjectable> cls) {
        this.valueType = null;
        this.parent = null;
        this.node = new COSDictionary();
        this.valueType = cls;
    }

    private void calculateLimits() {
        if (isRootNode()) {
            this.node.setItem(COSName.LIMITS, (COSBase) null);
            return;
        }
        List<PDNameTreeNode> kids = getKids();
        if (kids == null || kids.size() <= 0) {
            try {
                Map<String, COSObjectable> names = getNames();
                if (names == null || names.size() <= 0) {
                    this.node.setItem(COSName.LIMITS, (COSBase) null);
                    return;
                }
                Object[] array = names.keySet().toArray();
                setLowerLimit((String) array[0]);
                setUpperLimit((String) array[array.length - 1]);
            } catch (IOException unused) {
                this.node.setItem(COSName.LIMITS, (COSBase) null);
            }
        } else {
            setLowerLimit(kids.get(0).getLowerLimit());
            setUpperLimit(((PDNameTreeNode) GeneratedOutlineSupport.outline29(kids, -1)).getUpperLimit());
        }
    }

    private void setLowerLimit(String str) {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.add((COSBase) null);
            cOSArray.add((COSBase) null);
            this.node.setItem(COSName.LIMITS, (COSBase) cOSArray);
        }
        cOSArray.setString(0, str);
    }

    private void setUpperLimit(String str) {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.add((COSBase) null);
            cOSArray.add((COSBase) null);
            this.node.setItem(COSName.LIMITS, (COSBase) cOSArray);
        }
        cOSArray.setString(1, str);
    }

    public COSObjectable convertCOSToPD(COSBase cOSBase) throws IOException {
        return cOSBase;
    }

    public PDNameTreeNode createChildNode(COSDictionary cOSDictionary) {
        return new PDNameTreeNode(cOSDictionary, this.valueType);
    }

    public COSDictionary getCOSDictionary() {
        return this.node;
    }

    public COSBase getCOSObject() {
        return this.node;
    }

    public List<PDNameTreeNode> getKids() {
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

    public String getLowerLimit() {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray != null) {
            return cOSArray.getString(0);
        }
        return null;
    }

    public Map<String, COSObjectable> getNames() throws IOException {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.NAMES);
        if (cOSArray == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < cOSArray.size(); i += 2) {
            linkedHashMap.put(((COSString) cOSArray.getObject(i)).getString(), convertCOSToPD(cOSArray.getObject(i + 1)));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public PDNameTreeNode getParent() {
        return this.parent;
    }

    public String getUpperLimit() {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray != null) {
            return cOSArray.getString(1);
        }
        return null;
    }

    public Object getValue(String str) throws IOException {
        Map<String, COSObjectable> names = getNames();
        Object obj = null;
        if (names != null) {
            return names.get(str);
        }
        List<PDNameTreeNode> kids = getKids();
        if (kids == null) {
            return null;
        }
        for (int i = 0; i < kids.size() && obj == null; i++) {
            PDNameTreeNode pDNameTreeNode = kids.get(i);
            if (pDNameTreeNode.getLowerLimit().compareTo(str) <= 0 && pDNameTreeNode.getUpperLimit().compareTo(str) >= 0) {
                obj = pDNameTreeNode.getValue(str);
            }
        }
        return obj;
    }

    public boolean isRootNode() {
        return this.parent == null;
    }

    public void setKids(List<? extends PDNameTreeNode> list) {
        if (list == null || list.size() <= 0) {
            this.node.setItem(COSName.KIDS, (COSBase) null);
            this.node.setItem(COSName.LIMITS, (COSBase) null);
        } else {
            for (PDNameTreeNode parent2 : list) {
                parent2.setParent(this);
            }
            this.node.setItem(COSName.KIDS, (COSBase) COSArrayList.converterToCOSArray(list));
            if (isRootNode()) {
                this.node.setItem(COSName.NAMES, (COSBase) null);
            }
        }
        calculateLimits();
    }

    public void setNames(Map<String, ? extends COSObjectable> map) {
        if (map == null) {
            this.node.setItem(COSName.NAMES, (COSObjectable) null);
            this.node.setItem(COSName.LIMITS, (COSObjectable) null);
            return;
        }
        COSArray cOSArray = new COSArray();
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            cOSArray.add((COSBase) new COSString(str));
            cOSArray.add((COSObjectable) map.get(str));
        }
        this.node.setItem(COSName.NAMES, (COSBase) cOSArray);
        calculateLimits();
    }

    public void setParent(PDNameTreeNode pDNameTreeNode) {
        this.parent = pDNameTreeNode;
        calculateLimits();
    }

    public PDNameTreeNode(COSDictionary cOSDictionary, Class<? extends COSObjectable> cls) {
        this.valueType = null;
        this.parent = null;
        this.node = cOSDictionary;
        this.valueType = cls;
    }
}
