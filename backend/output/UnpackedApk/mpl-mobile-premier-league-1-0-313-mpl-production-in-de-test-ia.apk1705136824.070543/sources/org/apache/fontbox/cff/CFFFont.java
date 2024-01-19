package org.apache.fontbox.cff;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.afm.AFMParser;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.fontbox.util.BoundingBox;

public abstract class CFFFont {
    public final List<byte[]> charStrings = new ArrayList();
    public CFFCharset charset;
    public String fontName;
    public IndexData globalSubrIndex;
    public final Map<String, Object> topDict = new LinkedHashMap();

    public void addValueToTopDict(String str, Object obj) {
        if (obj != null) {
            this.topDict.put(str, obj);
        }
    }

    public List<byte[]> getCharStringBytes() {
        return this.charStrings;
    }

    public CFFCharset getCharset() {
        return this.charset;
    }

    public BoundingBox getFontBBox() {
        return new BoundingBox((List) this.topDict.get(AFMParser.FONT_BBOX));
    }

    public abstract List<Number> getFontMatrix();

    public IndexData getGlobalSubrIndex() {
        return this.globalSubrIndex;
    }

    public String getName() {
        return this.fontName;
    }

    public int getNumCharStrings() {
        return this.charStrings.size();
    }

    public Map<String, Object> getTopDict() {
        return this.topDict;
    }

    public void setCharset(CFFCharset cFFCharset) {
        this.charset = cFFCharset;
    }

    public void setGlobalSubrIndex(IndexData indexData) {
        this.globalSubrIndex = indexData;
    }

    public void setName(String str) {
        this.fontName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[name=");
        sb.append(this.fontName);
        sb.append(", topDict=");
        sb.append(this.topDict);
        sb.append(", charset=");
        sb.append(this.charset);
        sb.append(", charStrings=");
        return GeneratedOutlineSupport.outline64(sb, this.charStrings, CMapParser.MARK_END_OF_ARRAY);
    }
}
