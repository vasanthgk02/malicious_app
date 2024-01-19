package org.apache.fontbox.cmap;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CMap {
    public static final String SPACE = " ";
    public final Map<Integer, String> charToUnicode = new HashMap();
    public String cmapName = null;
    public int cmapType = -1;
    public String cmapVersion = null;
    public final Map<Integer, Integer> codeToCid = new HashMap();
    public final List<CIDRange> codeToCidRanges = new LinkedList();
    public final List<CodespaceRange> codespaceRanges = new ArrayList();
    public String ordering = null;
    public String registry = null;
    public int spaceMapping = -1;
    public int supplement = 0;
    public int wmode = 0;

    public static int getCodeFromArray(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 << 8) | ((bArr[i + i4] + 256) % 256);
        }
        return i3;
    }

    public static int toInt(List<Byte> list) {
        int i = 0;
        for (Byte byteValue : list) {
            i = (i << 8) | ((byteValue.byteValue() + 256) % 256);
        }
        return i;
    }

    public void addCIDMapping(int i, int i2) {
        this.codeToCid.put(Integer.valueOf(i2), Integer.valueOf(i));
    }

    public void addCIDRange(char c2, char c3, int i) {
        this.codeToCidRanges.add(0, new CIDRange(c2, c3, i));
    }

    public void addCharMapping(byte[] bArr, String str) {
        int codeFromArray = getCodeFromArray(bArr, 0, bArr.length);
        this.charToUnicode.put(Integer.valueOf(codeFromArray), str);
        if (SPACE.equals(str)) {
            this.spaceMapping = codeFromArray;
        }
    }

    public void addCodespaceRange(CodespaceRange codespaceRange) {
        this.codespaceRanges.add(codespaceRange);
    }

    public String getName() {
        return this.cmapName;
    }

    public String getOrdering() {
        return this.ordering;
    }

    public String getRegistry() {
        return this.registry;
    }

    public int getSpaceMapping() {
        return this.spaceMapping;
    }

    public int getSupplement() {
        return this.supplement;
    }

    public int getType() {
        return this.cmapType;
    }

    public String getVersion() {
        return this.cmapVersion;
    }

    public int getWMode() {
        return this.wmode;
    }

    public boolean hasCIDMappings() {
        return !this.codeToCid.isEmpty() || !this.codeToCidRanges.isEmpty();
    }

    public boolean hasUnicodeMappings() {
        return !this.charToUnicode.isEmpty();
    }

    public int readCode(InputStream inputStream) throws IOException {
        inputStream.mark(4);
        ArrayList arrayList = new ArrayList(4);
        for (int i = 0; i < 4; i++) {
            arrayList.add(Byte.valueOf((byte) inputStream.read()));
            for (CodespaceRange isFullMatch : this.codespaceRanges) {
                if (isFullMatch.isFullMatch(arrayList)) {
                    return toInt(arrayList);
                }
            }
        }
        inputStream.reset();
        ArrayList arrayList2 = new ArrayList(4);
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList2.add(Byte.valueOf((byte) inputStream.read()));
            CodespaceRange codespaceRange = null;
            CodespaceRange codespaceRange2 = null;
            for (CodespaceRange next : this.codespaceRanges) {
                if (next.isPartialMatch(((Byte) arrayList2.get(i2)).byteValue(), i2) && (codespaceRange == null || next.getStart().length < codespaceRange.getStart().length)) {
                    codespaceRange = next;
                }
                if (codespaceRange2 == null || next.getStart().length < codespaceRange2.getStart().length) {
                    codespaceRange2 = next;
                }
            }
            if (codespaceRange == null) {
                codespaceRange = codespaceRange2;
            }
            if (codespaceRange != null && codespaceRange.getStart().length == arrayList2.size()) {
                return toInt(arrayList2);
            }
        }
        throw new IOException("CMap is invalid");
    }

    public void setName(String str) {
        this.cmapName = str;
    }

    public void setOrdering(String str) {
        this.ordering = str;
    }

    public void setRegistry(String str) {
        this.registry = str;
    }

    public void setSupplement(int i) {
        this.supplement = i;
    }

    public void setType(int i) {
        this.cmapType = i;
    }

    public void setVersion(String str) {
        this.cmapVersion = str;
    }

    public void setWMode(int i) {
        this.wmode = i;
    }

    public int toCID(int i) {
        if (this.codeToCid.containsKey(Integer.valueOf(i))) {
            return this.codeToCid.get(Integer.valueOf(i)).intValue();
        }
        for (CIDRange map : this.codeToCidRanges) {
            int map2 = map.map((char) i);
            if (map2 != -1) {
                return map2;
            }
        }
        return 0;
    }

    public String toString() {
        return this.cmapName;
    }

    public String toUnicode(int i) {
        return this.charToUnicode.get(Integer.valueOf(i));
    }

    public void useCmap(CMap cMap) {
        this.codespaceRanges.addAll(cMap.codespaceRanges);
        this.charToUnicode.putAll(cMap.charToUnicode);
        this.codeToCid.putAll(cMap.codeToCid);
        this.codeToCidRanges.addAll(cMap.codeToCidRanges);
    }
}
