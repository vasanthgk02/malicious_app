package org.apache.fontbox.cff;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.fontbox.type1.Type1CharStringReader;

public class CFFCIDFont extends CFFFont {
    public final Map<Integer, CIDKeyedType2CharString> charStringCache = new ConcurrentHashMap();
    public FDSelect fdSelect;
    public List<Map<String, Object>> fontDictionaries = new LinkedList();
    public String ordering;
    public List<Map<String, Object>> privateDictionaries = new LinkedList();
    public final PrivateType1CharStringReader reader = new PrivateType1CharStringReader();
    public String registry;
    public int supplement;

    public class PrivateType1CharStringReader implements Type1CharStringReader {
        public PrivateType1CharStringReader() {
        }

        public Type1CharString getType1CharString(String str) throws IOException {
            return CFFCIDFont.this.getType2CharString(0);
        }
    }

    private int getDefaultWidthX(int i) {
        int fDIndex = this.fdSelect.getFDIndex(i);
        int i2 = 1000;
        if (fDIndex == -1) {
            return 1000;
        }
        Map map = this.privateDictionaries.get(fDIndex);
        if (map.containsKey("defaultWidthX")) {
            i2 = ((Number) map.get("defaultWidthX")).intValue();
        }
        return i2;
    }

    private IndexData getLocalSubrIndex(int i) {
        int fDIndex = this.fdSelect.getFDIndex(i);
        if (fDIndex == -1) {
            return new IndexData(0);
        }
        return (IndexData) this.privateDictionaries.get(fDIndex).get("Subrs");
    }

    private int getNominalWidthX(int i) {
        int fDIndex = this.fdSelect.getFDIndex(i);
        int i2 = 0;
        if (fDIndex == -1) {
            return 0;
        }
        Map map = this.privateDictionaries.get(fDIndex);
        if (map.containsKey("nominalWidthX")) {
            i2 = ((Number) map.get("nominalWidthX")).intValue();
        }
        return i2;
    }

    public FDSelect getFdSelect() {
        return this.fdSelect;
    }

    public List<Map<String, Object>> getFontDicts() {
        return this.fontDictionaries;
    }

    public List<Number> getFontMatrix() {
        return (List) this.topDict.get("FontMatrix");
    }

    public String getOrdering() {
        return this.ordering;
    }

    public List<Map<String, Object>> getPrivDicts() {
        return this.privateDictionaries;
    }

    public String getRegistry() {
        return this.registry;
    }

    public int getSupplement() {
        return this.supplement;
    }

    public CIDKeyedType2CharString getType2CharString(int i) throws IOException {
        CIDKeyedType2CharString cIDKeyedType2CharString = this.charStringCache.get(Integer.valueOf(i));
        if (cIDKeyedType2CharString != null) {
            return cIDKeyedType2CharString;
        }
        int gIDForCID = this.charset.getGIDForCID(i);
        byte[] bArr = this.charStrings.get(gIDForCID);
        if (bArr == null) {
            bArr = this.charStrings.get(0);
        }
        int i2 = i;
        CIDKeyedType2CharString cIDKeyedType2CharString2 = new CIDKeyedType2CharString(this.reader, this.fontName, i2, gIDForCID, new Type2CharStringParser(this.fontName, i).parse(bArr, this.globalSubrIndex, getLocalSubrIndex(gIDForCID)), getDefaultWidthX(i), getNominalWidthX(i));
        this.charStringCache.put(Integer.valueOf(i), cIDKeyedType2CharString2);
        return cIDKeyedType2CharString2;
    }

    public void setFdSelect(FDSelect fDSelect) {
        this.fdSelect = fDSelect;
    }

    public void setFontDict(List<Map<String, Object>> list) {
        this.fontDictionaries = list;
    }

    public void setOrdering(String str) {
        this.ordering = str;
    }

    public void setPrivDict(List<Map<String, Object>> list) {
        this.privateDictionaries = list;
    }

    public void setRegistry(String str) {
        this.registry = str;
    }

    public void setSupplement(int i) {
        this.supplement = i;
    }
}
