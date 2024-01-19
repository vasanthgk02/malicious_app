package org.apache.fontbox.ttf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamingTable extends TTFTable {
    public static final String TAG = "name";
    public String fontFamily = null;
    public String fontSubFamily = null;
    public Map<Integer, Map<Integer, Map<Integer, Map<Integer, String>>>> lookupTable = new HashMap();
    public List<NameRecord> nameRecords = new ArrayList();
    public String psName = null;

    private String getEnglishName(int i) {
        String name = getName(i, 3, 1, 1033);
        if (name != null) {
            return name;
        }
        String name2 = getName(i, 1, 0, 0);
        if (name2 != null) {
            return name2;
        }
        return null;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public String getFontSubFamily() {
        return this.fontSubFamily;
    }

    public String getName(int i, int i2, int i3, int i4) {
        Map map = this.lookupTable.get(Integer.valueOf(i));
        if (map == null) {
            return null;
        }
        Map map2 = (Map) map.get(Integer.valueOf(i2));
        if (map2 == null) {
            return null;
        }
        Map map3 = (Map) map2.get(Integer.valueOf(i3));
        if (map3 == null) {
            return null;
        }
        return (String) map3.get(Integer.valueOf(i4));
    }

    public List<NameRecord> getNameRecords() {
        return this.nameRecords;
    }

    public String getPostScriptName() {
        return this.psName;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        tTFDataStream.readUnsignedShort();
        int readUnsignedShort = tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        for (int i = 0; i < readUnsignedShort; i++) {
            NameRecord nameRecord = new NameRecord();
            nameRecord.initData(trueTypeFont, tTFDataStream);
            this.nameRecords.add(nameRecord);
        }
        for (int i2 = 0; i2 < readUnsignedShort; i2++) {
            NameRecord nameRecord2 = this.nameRecords.get(i2);
            if (((long) nameRecord2.getStringOffset()) > getLength()) {
                nameRecord2.setString(null);
            } else {
                tTFDataStream.seek(getOffset() + 6 + ((long) (readUnsignedShort * 2 * 6)) + ((long) nameRecord2.getStringOffset()));
                int platformId = nameRecord2.getPlatformId();
                int platformEncodingId = nameRecord2.getPlatformEncodingId();
                String str = "ISO-8859-1";
                if (platformId == 3 && (platformEncodingId == 1 || platformEncodingId == 0)) {
                    str = "UTF-16";
                } else if (platformId == 2) {
                    if (platformEncodingId == 0) {
                        str = "US-ASCII";
                    } else if (platformEncodingId == 1) {
                        str = "ISO-10646-1";
                    }
                }
                nameRecord2.setString(tTFDataStream.readString(nameRecord2.getStringLength(), str));
            }
        }
        for (NameRecord next : this.nameRecords) {
            if (!this.lookupTable.containsKey(Integer.valueOf(next.getNameId()))) {
                this.lookupTable.put(Integer.valueOf(next.getNameId()), new HashMap());
            }
            Map map = this.lookupTable.get(Integer.valueOf(next.getNameId()));
            if (!map.containsKey(Integer.valueOf(next.getPlatformId()))) {
                map.put(Integer.valueOf(next.getPlatformId()), new HashMap());
            }
            Map map2 = (Map) map.get(Integer.valueOf(next.getPlatformId()));
            if (!map2.containsKey(Integer.valueOf(next.getPlatformEncodingId()))) {
                map2.put(Integer.valueOf(next.getPlatformEncodingId()), new HashMap());
            }
            ((Map) map2.get(Integer.valueOf(next.getPlatformEncodingId()))).put(Integer.valueOf(next.getLanguageId()), next.getString());
        }
        this.fontFamily = getEnglishName(1);
        this.fontSubFamily = getEnglishName(2);
        String name = getName(6, 1, 0, 0);
        this.psName = name;
        if (name == null) {
            this.psName = getName(6, 3, 1, 1033);
        }
        this.initialized = true;
    }
}
