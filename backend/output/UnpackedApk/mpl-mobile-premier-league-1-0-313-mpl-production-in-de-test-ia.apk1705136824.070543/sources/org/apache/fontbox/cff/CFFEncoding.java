package org.apache.fontbox.cff;

import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.encoding.Encoding;

public abstract class CFFEncoding extends Encoding {
    public final Map<Integer, String> codeToName = new HashMap();

    public void add(int i, int i2, String str) {
        this.codeToName.put(Integer.valueOf(i), str);
        addCharacterEncoding(i, str);
    }

    public String getName(int i) {
        String str = this.codeToName.get(Integer.valueOf(i));
        return str == null ? Encoding.NOTDEF : str;
    }

    public void add(int i, int i2) {
        String name = CFFStandardString.getName(i2);
        this.codeToName.put(Integer.valueOf(i), name);
        addCharacterEncoding(i, name);
    }
}
