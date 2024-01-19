package org.apache.pdfbox.pdmodel.common;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;

public class COSDictionaryMap<K, V> implements Map<K, V> {
    public final Map<K, V> actuals;
    public final COSDictionary map;

    public COSDictionaryMap(Map<K, V> map2, COSDictionary cOSDictionary) {
        this.actuals = map2;
        this.map = cOSDictionary;
    }

    public static COSDictionary convert(Map<String, ?> map2) {
        map2.keySet().iterator();
        COSDictionary cOSDictionary = new COSDictionary();
        for (Entry next : map2.entrySet()) {
            cOSDictionary.setItem(COSName.getPDFName((String) next.getKey()), ((COSObjectable) next.getValue()).getCOSObject());
        }
        return cOSDictionary;
    }

    public static COSDictionaryMap<String, Object> convertBasicTypesToMap(COSDictionary cOSDictionary) throws IOException {
        Object obj;
        if (cOSDictionary == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (COSName next : cOSDictionary.keySet()) {
            COSBase dictionaryObject = cOSDictionary.getDictionaryObject(next);
            if (dictionaryObject instanceof COSString) {
                obj = ((COSString) dictionaryObject).getString();
            } else if (dictionaryObject instanceof COSInteger) {
                obj = Integer.valueOf(((COSInteger) dictionaryObject).intValue());
            } else if (dictionaryObject instanceof COSName) {
                obj = ((COSName) dictionaryObject).getName();
            } else if (dictionaryObject instanceof COSFloat) {
                obj = Float.valueOf(((COSFloat) dictionaryObject).floatValue());
            } else if (dictionaryObject instanceof COSBoolean) {
                obj = ((COSBoolean) dictionaryObject).getValue() ? Boolean.TRUE : Boolean.FALSE;
            } else {
                throw new IOException("Error:unknown type of object to convert:" + dictionaryObject);
            }
            hashMap.put(next.getName(), obj);
        }
        return new COSDictionaryMap<>(hashMap, cOSDictionary);
    }

    public void clear() {
        this.map.clear();
        this.actuals.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.keySet().contains(obj);
    }

    public boolean containsValue(Object obj) {
        return this.actuals.containsValue(obj);
    }

    public Set<Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(this.actuals.entrySet());
    }

    public boolean equals(Object obj) {
        if (obj instanceof COSDictionaryMap) {
            return ((COSDictionaryMap) obj).map.equals(this.map);
        }
        return false;
    }

    public V get(Object obj) {
        return this.actuals.get(obj);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set<K> keySet() {
        return this.actuals.keySet();
    }

    public V put(K k, V v) {
        this.map.setItem(COSName.getPDFName((String) k), ((COSObjectable) v).getCOSObject());
        return this.actuals.put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map2) {
        throw new RuntimeException("Not yet implemented");
    }

    public V remove(Object obj) {
        this.map.removeItem(COSName.getPDFName((String) obj));
        return this.actuals.remove(obj);
    }

    public int size() {
        return this.map.size();
    }

    public String toString() {
        return this.actuals.toString();
    }

    public Collection<V> values() {
        return this.actuals.values();
    }
}
