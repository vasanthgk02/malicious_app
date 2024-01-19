package org.apache.commons.lang.text;

import java.util.Map;

public abstract class StrLookup {
    public static final StrLookup NONE_LOOKUP = new MapStrLookup(null);
    public static final StrLookup SYSTEM_PROPERTIES_LOOKUP;

    public static class MapStrLookup extends StrLookup {
        public final Map map;

        public MapStrLookup(Map map2) {
            this.map = map2;
        }

        public String lookup(String str) {
            Map map2 = this.map;
            if (map2 == null) {
                return null;
            }
            Object obj = map2.get(str);
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
    }

    static {
        StrLookup strLookup;
        try {
            strLookup = new MapStrLookup(System.getProperties());
        } catch (SecurityException unused) {
            strLookup = NONE_LOOKUP;
        }
        SYSTEM_PROPERTIES_LOOKUP = strLookup;
    }

    public static StrLookup mapLookup(Map map) {
        return new MapStrLookup(map);
    }

    public static StrLookup noneLookup() {
        return NONE_LOOKUP;
    }

    public static StrLookup systemPropertiesLookup() {
        return SYSTEM_PROPERTIES_LOOKUP;
    }

    public abstract String lookup(String str);
}
