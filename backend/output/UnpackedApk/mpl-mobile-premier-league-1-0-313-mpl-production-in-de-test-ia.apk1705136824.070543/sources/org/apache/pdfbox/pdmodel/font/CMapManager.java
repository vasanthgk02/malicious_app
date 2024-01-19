package org.apache.pdfbox.pdmodel.font;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;

/* compiled from: CmapManager */
public final class CMapManager {
    public static Map<String, CMap> cMapCache = Collections.synchronizedMap(new HashMap());

    public static CMap getPredefinedCMap(String str) throws IOException {
        CMap cMap = cMapCache.get(str);
        if (cMap != null) {
            return cMap;
        }
        CMap parsePredefined = new CMapParser().parsePredefined(str);
        cMapCache.put(parsePredefined.getName(), parsePredefined);
        return parsePredefined;
    }

    public static CMap parseCMap(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            return new CMapParser().parse(inputStream);
        }
        return null;
    }
}
