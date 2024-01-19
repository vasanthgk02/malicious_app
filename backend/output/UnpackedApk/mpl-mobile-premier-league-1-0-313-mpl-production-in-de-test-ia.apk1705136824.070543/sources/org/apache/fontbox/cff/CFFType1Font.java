package org.apache.fontbox.cff;

import android.graphics.Path;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.fontbox.ttf.Type1Equivalent;
import org.apache.fontbox.type1.Type1CharStringReader;

public class CFFType1Font extends CFFFont implements Type1Equivalent {
    public final Map<Integer, Type2CharString> charStringCache = new ConcurrentHashMap();
    public CFFEncoding encoding;
    public final Map<String, Object> privateDict = new LinkedHashMap();
    public final PrivateType1CharStringReader reader = new PrivateType1CharStringReader();

    public class PrivateType1CharStringReader implements Type1CharStringReader {
        public PrivateType1CharStringReader() {
        }

        public Type1CharString getType1CharString(String str) throws IOException {
            return CFFType1Font.this.getType1CharString(str);
        }
    }

    private int getDefaultWidthX() {
        Number number = (Number) getProperty("defaultWidthX");
        if (number == null) {
            return 1000;
        }
        return number.intValue();
    }

    private IndexData getLocalSubrIndex() {
        return (IndexData) this.privateDict.get("Subrs");
    }

    private int getNominalWidthX() {
        Number number = (Number) getProperty("nominalWidthX");
        if (number == null) {
            return 0;
        }
        return number.intValue();
    }

    private Object getProperty(String str) {
        Object obj = this.topDict.get(str);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.privateDict.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return null;
    }

    public void addToPrivateDict(String str, Object obj) {
        if (obj != null) {
            this.privateDict.put(str, obj);
        }
    }

    public List<Number> getFontMatrix() {
        return (List) this.topDict.get("FontMatrix");
    }

    public Path getPath(String str) throws IOException {
        return getType1CharString(str).getPath();
    }

    public Map<String, Object> getPrivateDict() {
        return this.privateDict;
    }

    public Type1CharString getType1CharString(String str) throws IOException {
        return getType2CharString(this.charset.getGIDForSID(this.charset.getSID(str)), str);
    }

    public Type2CharString getType2CharString(int i) throws IOException {
        return getType2CharString(i, GeneratedOutlineSupport.outline41("GID+", i));
    }

    public float getWidth(String str) throws IOException {
        return (float) getType1CharString(str).getWidth();
    }

    public boolean hasGlyph(String str) {
        return this.charset.getGIDForSID(this.charset.getSID(str)) != 0;
    }

    public void setEncoding(CFFEncoding cFFEncoding) {
        this.encoding = cFFEncoding;
    }

    public CFFEncoding getEncoding() {
        return this.encoding;
    }

    private Type2CharString getType2CharString(int i, String str) throws IOException {
        Type2CharString type2CharString = this.charStringCache.get(Integer.valueOf(i));
        if (type2CharString != null) {
            return type2CharString;
        }
        byte[] bArr = this.charStrings.get(i);
        if (bArr == null) {
            bArr = this.charStrings.get(0);
        }
        String str2 = str;
        int i2 = i;
        Type2CharString type2CharString2 = new Type2CharString(this.reader, this.fontName, str2, i2, new Type2CharStringParser(this.fontName, str).parse(bArr, this.globalSubrIndex, getLocalSubrIndex()), getDefaultWidthX(), getNominalWidthX());
        this.charStringCache.put(Integer.valueOf(i), type2CharString2);
        return type2CharString2;
    }
}
