package org.apache.pdfbox.pdmodel.font.encoding;

import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.afm.CharMetric;
import org.apache.fontbox.afm.FontMetrics;
import org.apache.fontbox.encoding.Encoding;
import org.apache.pdfbox.cos.COSBase;

public class Type1Encoding extends Encoding {
    public Type1Encoding() {
    }

    public static Type1Encoding fromFontBox(Encoding encoding) {
        Map<Integer, String> codeToNameMap = encoding.getCodeToNameMap();
        Type1Encoding type1Encoding = new Type1Encoding();
        for (Entry next : codeToNameMap.entrySet()) {
            type1Encoding.add(((Integer) next.getKey()).intValue(), (String) next.getValue());
        }
        return type1Encoding;
    }

    public COSBase getCOSObject() {
        return null;
    }

    public Type1Encoding(FontMetrics fontMetrics) {
        for (CharMetric next : fontMetrics.getCharMetrics()) {
            add(next.getCharacterCode(), next.getName());
        }
    }
}
