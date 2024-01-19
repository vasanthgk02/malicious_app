package org.apache.fontbox.encoding;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Encoding {
    public static final Map<String, String> CHARACTER_TO_NAME = new HashMap();
    public static final Map<String, String> NAME_TO_CHARACTER = new HashMap();
    public static final String NOTDEF = ".notdef";
    public Map<Integer, String> codeToName = new HashMap();
    public Map<String, Integer> nameToCode = new HashMap();

    public void addCharacterEncoding(int i, String str) {
        this.codeToName.put(Integer.valueOf(i), str);
        this.nameToCode.put(str, Integer.valueOf(i));
    }

    public String getCharacter(int i) throws IOException {
        return getCharacter(getName(i));
    }

    public Integer getCode(String str) {
        return this.nameToCode.get(str);
    }

    public Map<Integer, String> getCodeToNameMap() {
        return Collections.unmodifiableMap(this.codeToName);
    }

    public String getName(int i) {
        String str = this.codeToName.get(Integer.valueOf(i));
        return str == null ? NOTDEF : str;
    }

    public String getNameFromCharacter(char c2) throws IOException {
        String str = CHARACTER_TO_NAME.get(Character.valueOf(c2));
        if (str != null) {
            return str;
        }
        throw new IOException("No name for character '" + c2 + "'");
    }

    public static String getCharacter(String str) {
        String str2 = NAME_TO_CHARACTER.get(str);
        return str2 == null ? str : str2;
    }
}
