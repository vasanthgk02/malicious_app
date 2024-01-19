package org.apache.fontbox.cff;

import java.util.HashMap;
import java.util.Map;

public abstract class CFFCharset {
    public final Map<Integer, Integer> gidToCid = new HashMap();
    public final Map<Integer, String> gidToName = new HashMap();
    public final Map<Integer, Integer> gidToSid = new HashMap();
    public final boolean isCIDFont;
    public final Map<String, Integer> nameToSid = new HashMap();
    public final Map<Integer, Integer> sidOrCidToGid = new HashMap();

    public CFFCharset(boolean z) {
        this.isCIDFont = z;
    }

    public void addCID(int i, int i2) {
        if (this.isCIDFont) {
            this.sidOrCidToGid.put(Integer.valueOf(i2), Integer.valueOf(i));
            this.gidToCid.put(Integer.valueOf(i), Integer.valueOf(i2));
            return;
        }
        throw new IllegalStateException("Not a CIDFont");
    }

    public void addSID(int i, int i2, String str) {
        if (!this.isCIDFont) {
            this.sidOrCidToGid.put(Integer.valueOf(i2), Integer.valueOf(i));
            this.gidToSid.put(Integer.valueOf(i), Integer.valueOf(i2));
            this.nameToSid.put(str, Integer.valueOf(i2));
            this.gidToName.put(Integer.valueOf(i), str);
            return;
        }
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    public int getCIDForGID(int i) {
        if (this.isCIDFont) {
            Integer num = this.gidToCid.get(Integer.valueOf(i));
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        throw new IllegalStateException("Not a CIDFont");
    }

    public int getGIDForCID(int i) {
        if (this.isCIDFont) {
            Integer num = this.sidOrCidToGid.get(Integer.valueOf(i));
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        throw new IllegalStateException("Not a CIDFont");
    }

    public int getGIDForSID(int i) {
        if (!this.isCIDFont) {
            Integer num = this.sidOrCidToGid.get(Integer.valueOf(i));
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    public String getNameForGID(int i) {
        if (!this.isCIDFont) {
            return this.gidToName.get(Integer.valueOf(i));
        }
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    public int getSID(String str) {
        if (!this.isCIDFont) {
            Integer num = this.nameToSid.get(str);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    public int getSIDForGID(int i) {
        if (!this.isCIDFont) {
            Integer num = this.gidToSid.get(Integer.valueOf(i));
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }
}
