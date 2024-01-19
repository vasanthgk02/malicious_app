package org.apache.commons.lang;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharSet implements Serializable {
    public static final CharSet ASCII_ALPHA = new CharSet((String) "a-zA-Z");
    public static final CharSet ASCII_ALPHA_LOWER = new CharSet((String) "a-z");
    public static final CharSet ASCII_ALPHA_UPPER = new CharSet((String) "A-Z");
    public static final CharSet ASCII_NUMERIC = new CharSet((String) "0-9");
    public static final Map COMMON;
    public static final CharSet EMPTY = new CharSet((String) null);
    public static final long serialVersionUID = 5947847346149275958L;
    public Set set = new HashSet();

    static {
        HashMap hashMap = new HashMap();
        COMMON = hashMap;
        hashMap.put(null, EMPTY);
        COMMON.put("", EMPTY);
        COMMON.put("a-zA-Z", ASCII_ALPHA);
        COMMON.put("A-Za-z", ASCII_ALPHA);
        COMMON.put("a-z", ASCII_ALPHA_LOWER);
        COMMON.put("A-Z", ASCII_ALPHA_UPPER);
        COMMON.put("0-9", ASCII_NUMERIC);
    }

    public CharSet(String str) {
        add(str);
    }

    public static CharSet getInstance(String str) {
        Object obj = COMMON.get(str);
        if (obj != null) {
            return (CharSet) obj;
        }
        return new CharSet(str);
    }

    public void add(String str) {
        if (str != null) {
            int length = str.length();
            int i = 0;
            while (i < length) {
                int i2 = length - i;
                if (i2 >= 4 && str.charAt(i) == '^' && str.charAt(i + 2) == '-') {
                    this.set.add(new CharRange(str.charAt(i + 1), str.charAt(i + 3), true));
                    i += 4;
                } else if (i2 >= 3 && str.charAt(i + 1) == '-') {
                    this.set.add(new CharRange(str.charAt(i), str.charAt(i + 2)));
                    i += 3;
                } else if (i2 < 2 || str.charAt(i) != '^') {
                    this.set.add(new CharRange(str.charAt(i)));
                    i++;
                } else {
                    this.set.add(new CharRange(str.charAt(i + 1), true));
                    i += 2;
                }
            }
        }
    }

    public boolean contains(char c2) {
        for (CharRange contains : this.set) {
            if (contains.contains(c2)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharSet)) {
            return false;
        }
        return this.set.equals(((CharSet) obj).set);
    }

    public CharRange[] getCharRanges() {
        Set set2 = this.set;
        return (CharRange[]) set2.toArray(new CharRange[set2.size()]);
    }

    public int hashCode() {
        return this.set.hashCode() + 89;
    }

    public String toString() {
        return this.set.toString();
    }

    public CharSet(String[] strArr) {
        for (String add : strArr) {
            add(add);
        }
    }

    public static CharSet getInstance(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        return new CharSet(strArr);
    }
}
