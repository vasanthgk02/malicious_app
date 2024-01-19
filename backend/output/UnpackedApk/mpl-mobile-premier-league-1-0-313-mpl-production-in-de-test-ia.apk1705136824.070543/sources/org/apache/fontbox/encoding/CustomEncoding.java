package org.apache.fontbox.encoding;

import java.util.Map;
import java.util.Map.Entry;

public class CustomEncoding extends Encoding {
    public CustomEncoding(Map<Integer, String> map) {
        for (Entry next : map.entrySet()) {
            addCharacterEncoding(((Integer) next.getKey()).intValue(), (String) next.getValue());
        }
    }
}
