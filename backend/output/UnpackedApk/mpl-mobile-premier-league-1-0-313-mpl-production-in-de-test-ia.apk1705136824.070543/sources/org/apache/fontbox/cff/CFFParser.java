package org.apache.fontbox.cff;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.paynimo.android.payment.util.Constant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.afm.AFMParser;
import org.apache.fontbox.cff.CFFOperator.Key;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.fontbox.encoding.Encoding;
import org.apache.fontbox.ttf.CFFTable;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;

public class CFFParser {
    public static final String TAG_OTTO = "OTTO";
    public static final String TAG_TTCF = "ttcf";
    public static final String TAG_TTFONLY = "\u0000\u0001\u0000\u0000";
    public String debugFontName;
    public Header header = null;
    public CFFDataInput input = null;
    public IndexData nameIndex = null;
    public IndexData stringIndex = null;
    public IndexData topDictIndex = null;

    public static class DictData {
        public List<Entry> entries;

        public static class Entry {
            public List<Number> operands;
            public CFFOperator operator;

            public Entry() {
                this.operands = new ArrayList();
                this.operator = null;
            }

            public List<Number> getArray() {
                return this.operands;
            }

            public Boolean getBoolean(int i) {
                Number number = this.operands.get(i);
                if (number instanceof Integer) {
                    int intValue = number.intValue();
                    if (intValue == 0) {
                        return Boolean.FALSE;
                    }
                    if (intValue == 1) {
                        return Boolean.TRUE;
                    }
                }
                throw new IllegalArgumentException();
            }

            public List<Number> getDelta() {
                return this.operands;
            }

            public Number getNumber(int i) {
                return this.operands.get(i);
            }

            public Integer getSID(int i) {
                Number number = this.operands.get(i);
                if (number instanceof Integer) {
                    return (Integer) number;
                }
                throw new IllegalArgumentException();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                GeneratedOutlineSupport.outline94(Entry.class, sb, "[operands=");
                sb.append(this.operands);
                sb.append(", operator=");
                sb.append(this.operator);
                sb.append(CMapParser.MARK_END_OF_ARRAY);
                return sb.toString();
            }
        }

        public DictData() {
            this.entries = null;
        }

        public Entry getEntry(Key key) {
            return getEntry(CFFOperator.getOperator(key));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(DictData.class, sb, "[entries=");
            return GeneratedOutlineSupport.outline64(sb, this.entries, CMapParser.MARK_END_OF_ARRAY);
        }

        public Entry getEntry(String str) {
            return getEntry(CFFOperator.getOperator(str));
        }

        private Entry getEntry(CFFOperator cFFOperator) {
            for (Entry next : this.entries) {
                if (next != null && next.operator != null && next.operator.equals(cFFOperator)) {
                    return next;
                }
            }
            return null;
        }
    }

    public static abstract class EmbeddedCharset extends CFFCharset {
        public EmbeddedCharset(boolean z) {
            super(z);
        }
    }

    public static abstract class EmbeddedEncoding extends CFFEncoding {
        public int nSups;
        public Supplement[] supplement;

        public static class Supplement {
            public int code;
            public String name;
            public int sid;

            public int getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            public int getSID() {
                return this.sid;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                GeneratedOutlineSupport.outline94(Supplement.class, sb, "[code=");
                sb.append(this.code);
                sb.append(", sid=");
                return GeneratedOutlineSupport.outline57(sb, this.sid, CMapParser.MARK_END_OF_ARRAY);
            }
        }
    }

    public static class EmptyCharset extends EmbeddedCharset {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public EmptyCharset(int i) {
            super(true);
            addCID(0, 0);
            for (int i2 = 1; i2 <= i; i2++) {
                addCID(i2, i2);
            }
        }

        public String toString() {
            return EmptyCharset.class.getName();
        }
    }

    public static class Format0Charset extends EmbeddedCharset {
        public int format;
        public int[] glyph;

        public Format0Charset(boolean z) {
            super(z);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(Format0Charset.class, sb, "[format=");
            sb.append(this.format);
            sb.append(", glyph=");
            sb.append(Arrays.toString(this.glyph));
            sb.append(CMapParser.MARK_END_OF_ARRAY);
            return sb.toString();
        }
    }

    public static class Format0Encoding extends EmbeddedEncoding {
        public int[] code;
        public int format;
        public int nCodes;

        public Format0Encoding() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(Format0Encoding.class, sb, "[format=");
            sb.append(this.format);
            sb.append(", nCodes=");
            sb.append(this.nCodes);
            sb.append(", code=");
            sb.append(Arrays.toString(this.code));
            sb.append(", supplement=");
            sb.append(Arrays.toString(this.supplement));
            sb.append(CMapParser.MARK_END_OF_ARRAY);
            return sb.toString();
        }
    }

    public static class Format0FDSelect extends FDSelect {
        public int[] fds;
        public int format;

        public int getFDIndex(int i) {
            int[] iArr = this.fds;
            if (i < iArr.length) {
                return iArr[i];
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(Format0FDSelect.class, sb, "[fds=");
            sb.append(Arrays.toString(this.fds));
            sb.append(CMapParser.MARK_END_OF_ARRAY);
            return sb.toString();
        }

        public Format0FDSelect(CFFCIDFont cFFCIDFont) {
            super(cFFCIDFont);
        }
    }

    public static class Format1Charset extends EmbeddedCharset {
        public int format;
        public Range1[] range;

        public static class Range1 {
            public int first;
            public int nLeft;

            public Range1() {
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                GeneratedOutlineSupport.outline94(Range1.class, sb, "[first=");
                sb.append(this.first);
                sb.append(", nLeft=");
                return GeneratedOutlineSupport.outline57(sb, this.nLeft, CMapParser.MARK_END_OF_ARRAY);
            }
        }

        public Format1Charset(boolean z) {
            super(z);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(Format1Charset.class, sb, "[format=");
            sb.append(this.format);
            sb.append(", range=");
            sb.append(Arrays.toString(this.range));
            sb.append(CMapParser.MARK_END_OF_ARRAY);
            return sb.toString();
        }
    }

    public static class Format1Encoding extends EmbeddedEncoding {
        public int format;
        public int nRanges;
        public Range1[] range;

        public static class Range1 {
            public int first;
            public int nLeft;

            public Range1() {
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                GeneratedOutlineSupport.outline94(Range1.class, sb, "[first=");
                sb.append(this.first);
                sb.append(", nLeft=");
                return GeneratedOutlineSupport.outline57(sb, this.nLeft, CMapParser.MARK_END_OF_ARRAY);
            }
        }

        public Format1Encoding() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(Format1Encoding.class, sb, "[format=");
            sb.append(this.format);
            sb.append(", nRanges=");
            sb.append(this.nRanges);
            sb.append(", range=");
            sb.append(Arrays.toString(this.range));
            sb.append(", supplement=");
            sb.append(Arrays.toString(this.supplement));
            sb.append(CMapParser.MARK_END_OF_ARRAY);
            return sb.toString();
        }
    }

    public static class Format2Charset extends EmbeddedCharset {
        public int format;
        public Range2[] range;

        public static class Range2 {
            public int first;
            public int nLeft;

            public Range2() {
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                GeneratedOutlineSupport.outline94(Range2.class, sb, "[first=");
                sb.append(this.first);
                sb.append(", nLeft=");
                return GeneratedOutlineSupport.outline57(sb, this.nLeft, CMapParser.MARK_END_OF_ARRAY);
            }
        }

        public Format2Charset(boolean z) {
            super(z);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(Format2Charset.class, sb, "[format=");
            sb.append(this.format);
            sb.append(", range=");
            sb.append(Arrays.toString(this.range));
            sb.append(CMapParser.MARK_END_OF_ARRAY);
            return sb.toString();
        }
    }

    public static final class Format3FDSelect extends FDSelect {
        public int format;
        public int nbRanges;
        public Range3[] range3;
        public int sentinel;

        public int getFDIndex(int i) {
            for (int i2 = 0; i2 < this.nbRanges; i2++) {
                if (this.range3[i2].first <= i) {
                    int i3 = i2 + 1;
                    if (i3 < this.nbRanges) {
                        if (this.range3[i3].first > i) {
                            return this.range3[i2].fd;
                        }
                    } else if (this.sentinel > i) {
                        return this.range3[i2].fd;
                    } else {
                        return -1;
                    }
                }
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(Format3FDSelect.class, sb, "[format=");
            sb.append(this.format);
            sb.append(" nbRanges=");
            sb.append(this.nbRanges);
            sb.append(", range3=");
            sb.append(Arrays.toString(this.range3));
            sb.append(" sentinel=");
            return GeneratedOutlineSupport.outline57(sb, this.sentinel, CMapParser.MARK_END_OF_ARRAY);
        }

        public Format3FDSelect(CFFCIDFont cFFCIDFont) {
            super(cFFCIDFont);
        }
    }

    public static class Header {
        public int hdrSize;
        public int major;
        public int minor;
        public int offSize;

        public Header() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(Header.class, sb, "[major=");
            sb.append(this.major);
            sb.append(", minor=");
            sb.append(this.minor);
            sb.append(", hdrSize=");
            sb.append(this.hdrSize);
            sb.append(", offSize=");
            return GeneratedOutlineSupport.outline57(sb, this.offSize, CMapParser.MARK_END_OF_ARRAY);
        }
    }

    public static final class Range3 {
        public int fd;
        public int first;

        public Range3() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline94(Range3.class, sb, "[first=");
            sb.append(this.first);
            sb.append(", fd=");
            return GeneratedOutlineSupport.outline57(sb, this.fd, CMapParser.MARK_END_OF_ARRAY);
        }
    }

    public static List<Number> getArray(DictData dictData, String str, List<Number> list) {
        Entry entry = dictData.getEntry(str);
        return entry != null ? entry.getArray() : list;
    }

    public static Boolean getBoolean(DictData dictData, String str, boolean z) {
        Entry entry = dictData.getEntry(str);
        if (entry != null) {
            z = entry.getBoolean(0).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    public static List<Number> getDelta(DictData dictData, String str, List<Number> list) {
        Entry entry = dictData.getEntry(str);
        return entry != null ? entry.getArray() : list;
    }

    public static Number getNumber(DictData dictData, String str, Number number) {
        Entry entry = dictData.getEntry(str);
        return entry != null ? entry.getNumber(0) : number;
    }

    private String getString(DictData dictData, String str) throws IOException {
        Entry entry = dictData.getEntry(str);
        if (entry != null) {
            return readString(entry.getNumber(0).intValue());
        }
        return null;
    }

    private void parseCIDFontDicts(DictData dictData, CFFCIDFont cFFCIDFont, IndexData indexData) throws IOException {
        Entry entry = dictData.getEntry((String) "FDArray");
        if (entry != null) {
            this.input.setPosition(entry.getNumber(0).intValue());
            IndexData readIndexData = readIndexData(this.input);
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            int i = 0;
            while (i < readIndexData.getCount()) {
                DictData readDictData = readDictData(new CFFDataInput(readIndexData.getBytes(i)));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(AFMParser.FONT_NAME, getString(readDictData, AFMParser.FONT_NAME));
                linkedHashMap.put("FontType", getNumber(readDictData, "FontType", Integer.valueOf(0)));
                linkedHashMap.put(AFMParser.FONT_BBOX, getDelta(readDictData, AFMParser.FONT_BBOX, null));
                linkedHashMap.put("FontMatrix", getDelta(readDictData, "FontMatrix", null));
                linkedList2.add(linkedHashMap);
                Entry entry2 = readDictData.getEntry((String) StandardStructureTypes.PRIVATE);
                if (entry2 != null) {
                    int intValue = entry2.getNumber(1).intValue();
                    this.input.setPosition(intValue);
                    DictData readDictData2 = readDictData(new CFFDataInput(this.input.readBytes(entry2.getNumber(0).intValue())));
                    Map<String, Object> readPrivateDict = readPrivateDict(readDictData2);
                    linkedList.add(readPrivateDict);
                    int intValue2 = ((Integer) getNumber(readDictData2, "Subrs", Integer.valueOf(0))).intValue();
                    if (intValue2 == 0) {
                        readPrivateDict.put("Subrs", new IndexData(0));
                    } else {
                        this.input.setPosition(intValue + intValue2);
                        readPrivateDict.put("Subrs", readIndexData(this.input));
                    }
                    i++;
                } else {
                    throw new IOException("Font DICT invalid without \"Private\" entry");
                }
            }
            this.input.setPosition(dictData.getEntry((String) "FDSelect").getNumber(0).intValue());
            FDSelect readFDSelect = readFDSelect(this.input, indexData.getCount(), cFFCIDFont);
            cFFCIDFont.setFontDict(linkedList2);
            cFFCIDFont.setPrivDict(linkedList);
            cFFCIDFont.setFdSelect(readFDSelect);
            return;
        }
        throw new IOException("FDArray is missing for a CIDKeyed Font.");
    }

    private CFFFont parseFont(int i) throws IOException {
        CFFFont cFFFont;
        CFFCharset cFFCharset;
        int i2 = i;
        String string = new DataInput(this.nameIndex.getBytes(i2)).getString();
        DictData readDictData = readDictData(new CFFDataInput(this.topDictIndex.getBytes(i2)));
        if (readDictData.getEntry((String) "SyntheticBase") == null) {
            boolean z = readDictData.getEntry((String) "ROS") != null;
            if (z) {
                CFFCIDFont cFFCIDFont = new CFFCIDFont();
                Entry entry = readDictData.getEntry((String) "ROS");
                cFFCIDFont.setRegistry(readString(entry.getNumber(0).intValue()));
                cFFCIDFont.setOrdering(readString(entry.getNumber(1).intValue()));
                cFFCIDFont.setSupplement(entry.getNumber(2).intValue());
                cFFFont = cFFCIDFont;
            } else {
                cFFFont = new CFFType1Font();
            }
            this.debugFontName = string;
            cFFFont.setName(string);
            cFFFont.addValueToTopDict("version", getString(readDictData, "version"));
            cFFFont.addValueToTopDict(AFMParser.NOTICE, getString(readDictData, AFMParser.NOTICE));
            cFFFont.addValueToTopDict("Copyright", getString(readDictData, "Copyright"));
            cFFFont.addValueToTopDict(AFMParser.FULL_NAME, getString(readDictData, AFMParser.FULL_NAME));
            cFFFont.addValueToTopDict(AFMParser.FAMILY_NAME, getString(readDictData, AFMParser.FAMILY_NAME));
            cFFFont.addValueToTopDict(AFMParser.WEIGHT, getString(readDictData, AFMParser.WEIGHT));
            cFFFont.addValueToTopDict("isFixedPitch", getBoolean(readDictData, "isFixedPitch", false));
            cFFFont.addValueToTopDict(AFMParser.ITALIC_ANGLE, getNumber(readDictData, AFMParser.ITALIC_ANGLE, Integer.valueOf(0)));
            cFFFont.addValueToTopDict(AFMParser.UNDERLINE_POSITION, getNumber(readDictData, AFMParser.UNDERLINE_POSITION, Integer.valueOf(-100)));
            cFFFont.addValueToTopDict(AFMParser.UNDERLINE_THICKNESS, getNumber(readDictData, AFMParser.UNDERLINE_THICKNESS, Integer.valueOf(50)));
            cFFFont.addValueToTopDict("PaintType", getNumber(readDictData, "PaintType", Integer.valueOf(0)));
            cFFFont.addValueToTopDict("CharstringType", getNumber(readDictData, "CharstringType", Integer.valueOf(2)));
            cFFFont.addValueToTopDict("FontMatrix", getArray(readDictData, "FontMatrix", Arrays.asList(new Number[]{Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d)})));
            cFFFont.addValueToTopDict("UniqueID", getNumber(readDictData, "UniqueID", null));
            cFFFont.addValueToTopDict(AFMParser.FONT_BBOX, getArray(readDictData, AFMParser.FONT_BBOX, Arrays.asList(new Number[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)})));
            cFFFont.addValueToTopDict("StrokeWidth", getNumber(readDictData, "StrokeWidth", Integer.valueOf(0)));
            cFFFont.addValueToTopDict("XUID", getArray(readDictData, "XUID", null));
            this.input.setPosition(readDictData.getEntry((String) "CharStrings").getNumber(0).intValue());
            IndexData readIndexData = readIndexData(this.input);
            Entry entry2 = readDictData.getEntry((String) "charset");
            if (entry2 != null) {
                int intValue = entry2.getNumber(0).intValue();
                if (!z && intValue == 0) {
                    cFFCharset = CFFISOAdobeCharset.getInstance();
                } else if (!z && intValue == 1) {
                    cFFCharset = CFFExpertCharset.getInstance();
                } else if (z || intValue != 2) {
                    this.input.setPosition(intValue);
                    cFFCharset = readCharset(this.input, readIndexData.getCount(), z);
                } else {
                    cFFCharset = CFFExpertSubsetCharset.getInstance();
                }
            } else if (z) {
                cFFCharset = new EmptyCharset(readIndexData.getCount());
            } else {
                cFFCharset = CFFISOAdobeCharset.getInstance();
            }
            cFFFont.setCharset(cFFCharset);
            cFFFont.getCharStringBytes().add(readIndexData.getBytes(0));
            for (int i3 = 1; i3 < readIndexData.getCount(); i3++) {
                cFFFont.getCharStringBytes().add(readIndexData.getBytes(i3));
            }
            if (z) {
                CFFCIDFont cFFCIDFont2 = (CFFCIDFont) cFFFont;
                parseCIDFontDicts(readDictData, cFFCIDFont2, readIndexData);
                if (readDictData.getEntry((String) "FontMatrix") == null) {
                    List<Map<String, Object>> fontDicts = cFFCIDFont2.getFontDicts();
                    if (fontDicts.size() <= 0 || !fontDicts.get(0).containsKey("FontMatrix")) {
                        cFFFont.addValueToTopDict("FontMatrix", getArray(readDictData, "FontMatrix", Arrays.asList(new Number[]{Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d)})));
                    } else {
                        cFFFont.addValueToTopDict("FontMatrix", (List) fontDicts.get(0).get("FontMatrix"));
                    }
                }
            } else {
                parseType1Dicts(readDictData, (CFFType1Font) cFFFont, cFFCharset);
            }
            return cFFFont;
        }
        throw new IOException("Synthetic Fonts are not supported");
    }

    private void parseType1Dicts(DictData dictData, CFFType1Font cFFType1Font, CFFCharset cFFCharset) throws IOException {
        CFFEncoding cFFEncoding;
        Entry entry = dictData.getEntry((String) "Encoding");
        int intValue = entry != null ? entry.getNumber(0).intValue() : 0;
        if (intValue == 0) {
            cFFEncoding = CFFStandardEncoding.getInstance();
        } else if (intValue == 1) {
            cFFEncoding = CFFExpertEncoding.getInstance();
        } else {
            this.input.setPosition(intValue);
            cFFEncoding = readEncoding(this.input, cFFCharset);
        }
        cFFType1Font.setEncoding(cFFEncoding);
        Entry entry2 = dictData.getEntry((String) StandardStructureTypes.PRIVATE);
        int intValue2 = entry2.getNumber(1).intValue();
        this.input.setPosition(intValue2);
        DictData readDictData = readDictData(new CFFDataInput(this.input.readBytes(entry2.getNumber(0).intValue())));
        for (Entry next : readPrivateDict(readDictData).entrySet()) {
            cFFType1Font.addToPrivateDict((String) next.getKey(), next.getValue());
        }
        int intValue3 = ((Integer) getNumber(readDictData, "Subrs", Integer.valueOf(0))).intValue();
        if (intValue3 == 0) {
            cFFType1Font.addToPrivateDict("Subrs", new IndexData(0));
            return;
        }
        this.input.setPosition(intValue2 + intValue3);
        cFFType1Font.addToPrivateDict("Subrs", readIndexData(this.input));
    }

    private CFFCharset readCharset(CFFDataInput cFFDataInput, int i, boolean z) throws IOException {
        int readCard8 = cFFDataInput.readCard8();
        if (readCard8 == 0) {
            return readFormat0Charset(cFFDataInput, readCard8, i, z);
        }
        if (readCard8 == 1) {
            return readFormat1Charset(cFFDataInput, readCard8, i, z);
        }
        if (readCard8 == 2) {
            return readFormat2Charset(cFFDataInput, readCard8, i, z);
        }
        throw new IllegalArgumentException();
    }

    public static DictData readDictData(CFFDataInput cFFDataInput) throws IOException {
        DictData dictData = new DictData();
        dictData.entries = new ArrayList();
        while (cFFDataInput.hasRemaining()) {
            dictData.entries.add(readEntry(cFFDataInput));
        }
        return dictData;
    }

    private CFFEncoding readEncoding(CFFDataInput cFFDataInput, CFFCharset cFFCharset) throws IOException {
        int readCard8 = cFFDataInput.readCard8();
        int i = readCard8 & 127;
        if (i == 0) {
            return readFormat0Encoding(cFFDataInput, cFFCharset, readCard8);
        }
        if (i == 1) {
            return readFormat1Encoding(cFFDataInput, cFFCharset, readCard8);
        }
        throw new IllegalArgumentException();
    }

    public static Entry readEntry(CFFDataInput cFFDataInput) throws IOException {
        Entry entry = new Entry();
        while (true) {
            int readUnsignedByte = cFFDataInput.readUnsignedByte();
            if (readUnsignedByte >= 0 && readUnsignedByte <= 21) {
                entry.operator = readOperator(cFFDataInput, readUnsignedByte);
                return entry;
            } else if (readUnsignedByte == 28 || readUnsignedByte == 29) {
                entry.operands.add(readIntegerNumber(cFFDataInput, readUnsignedByte));
            } else if (readUnsignedByte == 30) {
                entry.operands.add(readRealNumber(cFFDataInput, readUnsignedByte));
            } else if (readUnsignedByte >= 32 && readUnsignedByte <= 254) {
                entry.operands.add(readIntegerNumber(cFFDataInput, readUnsignedByte));
            }
        }
        throw new IllegalArgumentException();
    }

    public static FDSelect readFDSelect(CFFDataInput cFFDataInput, int i, CFFCIDFont cFFCIDFont) throws IOException {
        int readCard8 = cFFDataInput.readCard8();
        if (readCard8 == 0) {
            return readFormat0FDSelect(cFFDataInput, readCard8, i, cFFCIDFont);
        }
        if (readCard8 == 3) {
            return readFormat3FDSelect(cFFDataInput, readCard8, i, cFFCIDFont);
        }
        throw new IllegalArgumentException();
    }

    private Format0Charset readFormat0Charset(CFFDataInput cFFDataInput, int i, int i2, boolean z) throws IOException {
        Format0Charset format0Charset = new Format0Charset(z);
        format0Charset.format = i;
        format0Charset.glyph = new int[i2];
        format0Charset.glyph[0] = 0;
        if (z) {
            format0Charset.addCID(0, 0);
        } else {
            format0Charset.addSID(0, 0, Encoding.NOTDEF);
        }
        for (int i3 = 1; i3 < format0Charset.glyph.length; i3++) {
            int readSID = cFFDataInput.readSID();
            format0Charset.glyph[i3] = readSID;
            if (z) {
                format0Charset.addCID(i3, readSID);
            } else {
                format0Charset.addSID(i3, readSID, readString(readSID));
            }
        }
        return format0Charset;
    }

    private Format0Encoding readFormat0Encoding(CFFDataInput cFFDataInput, CFFCharset cFFCharset, int i) throws IOException {
        Format0Encoding format0Encoding = new Format0Encoding();
        format0Encoding.format = i;
        format0Encoding.nCodes = cFFDataInput.readCard8();
        format0Encoding.code = new int[format0Encoding.nCodes];
        format0Encoding.add(0, 0, Encoding.NOTDEF);
        for (int i2 = 1; i2 <= format0Encoding.nCodes; i2++) {
            int readCard8 = cFFDataInput.readCard8();
            format0Encoding.code[i2 - 1] = readCard8;
            int sIDForGID = cFFCharset.getSIDForGID(i2);
            format0Encoding.add(readCard8, sIDForGID, readString(sIDForGID));
        }
        if ((i & 128) != 0) {
            readSupplement(cFFDataInput, format0Encoding);
        }
        return format0Encoding;
    }

    public static Format0FDSelect readFormat0FDSelect(CFFDataInput cFFDataInput, int i, int i2, CFFCIDFont cFFCIDFont) throws IOException {
        Format0FDSelect format0FDSelect = new Format0FDSelect(cFFCIDFont);
        format0FDSelect.format = i;
        format0FDSelect.fds = new int[i2];
        for (int i3 = 0; i3 < format0FDSelect.fds.length; i3++) {
            format0FDSelect.fds[i3] = cFFDataInput.readCard8();
        }
        return format0FDSelect;
    }

    private Format1Charset readFormat1Charset(CFFDataInput cFFDataInput, int i, int i2, boolean z) throws IOException {
        Format1Charset format1Charset = new Format1Charset(z);
        format1Charset.format = i;
        ArrayList arrayList = new ArrayList();
        if (z) {
            format1Charset.addCID(0, 0);
        } else {
            format1Charset.addSID(0, 0, Encoding.NOTDEF);
        }
        int i3 = 1;
        while (i3 < i2) {
            Range1 range1 = new Range1();
            range1.first = cFFDataInput.readSID();
            range1.nLeft = cFFDataInput.readCard8();
            arrayList.add(range1);
            for (int i4 = 0; i4 < range1.nLeft + 1; i4++) {
                int access$4100 = range1.first + i4;
                if (z) {
                    format1Charset.addCID(i3 + i4, access$4100);
                } else {
                    format1Charset.addSID(i3 + i4, access$4100, readString(access$4100));
                }
            }
            i3 = range1.nLeft + i3 + 1;
        }
        format1Charset.range = (Range1[]) arrayList.toArray(new Range1[0]);
        return format1Charset;
    }

    private Format1Encoding readFormat1Encoding(CFFDataInput cFFDataInput, CFFCharset cFFCharset, int i) throws IOException {
        Format1Encoding format1Encoding = new Format1Encoding();
        format1Encoding.format = i;
        format1Encoding.nRanges = cFFDataInput.readCard8();
        format1Encoding.range = new Range1[format1Encoding.nRanges];
        format1Encoding.add(0, 0, Encoding.NOTDEF);
        int i2 = 1;
        for (int i3 = 0; i3 < format1Encoding.range.length; i3++) {
            Range1 range1 = new Range1();
            range1.first = cFFDataInput.readCard8();
            range1.nLeft = cFFDataInput.readCard8();
            format1Encoding.range[i3] = range1;
            for (int i4 = 0; i4 < range1.nLeft + 1; i4++) {
                int sIDForGID = cFFCharset.getSIDForGID(i2);
                format1Encoding.add(range1.first + i4, sIDForGID, readString(sIDForGID));
                i2++;
            }
        }
        if ((i & 128) != 0) {
            readSupplement(cFFDataInput, format1Encoding);
        }
        return format1Encoding;
    }

    private Format2Charset readFormat2Charset(CFFDataInput cFFDataInput, int i, int i2, boolean z) throws IOException {
        Format2Charset format2Charset = new Format2Charset(z);
        format2Charset.format = i;
        format2Charset.range = new Range2[0];
        if (z) {
            format2Charset.addCID(0, 0);
        } else {
            format2Charset.addSID(0, 0, Encoding.NOTDEF);
        }
        int i3 = 1;
        while (i3 < i2) {
            Range2[] range2Arr = new Range2[(format2Charset.range.length + 1)];
            System.arraycopy(format2Charset.range, 0, range2Arr, 0, format2Charset.range.length);
            format2Charset.range = range2Arr;
            Range2 range2 = new Range2();
            range2.first = cFFDataInput.readSID();
            range2.nLeft = cFFDataInput.readCard16();
            format2Charset.range[format2Charset.range.length - 1] = range2;
            for (int i4 = 0; i4 < range2.nLeft + 1; i4++) {
                int access$4700 = range2.first + i4;
                if (z) {
                    format2Charset.addCID(i3 + i4, access$4700);
                } else {
                    format2Charset.addSID(i3 + i4, access$4700, readString(access$4700));
                }
            }
            i3 = range2.nLeft + i3 + 1;
        }
        return format2Charset;
    }

    public static Format3FDSelect readFormat3FDSelect(CFFDataInput cFFDataInput, int i, int i2, CFFCIDFont cFFCIDFont) throws IOException {
        Format3FDSelect format3FDSelect = new Format3FDSelect(cFFCIDFont);
        format3FDSelect.format = i;
        format3FDSelect.nbRanges = cFFDataInput.readCard16();
        format3FDSelect.range3 = new Range3[format3FDSelect.nbRanges];
        for (int i3 = 0; i3 < format3FDSelect.nbRanges; i3++) {
            Range3 range3 = new Range3();
            range3.first = cFFDataInput.readCard16();
            range3.fd = cFFDataInput.readCard8();
            format3FDSelect.range3[i3] = range3;
        }
        format3FDSelect.sentinel = cFFDataInput.readCard16();
        return format3FDSelect;
    }

    public static Header readHeader(CFFDataInput cFFDataInput) throws IOException {
        Header header2 = new Header();
        header2.major = cFFDataInput.readCard8();
        header2.minor = cFFDataInput.readCard8();
        header2.hdrSize = cFFDataInput.readCard8();
        header2.offSize = cFFDataInput.readOffSize();
        return header2;
    }

    public static IndexData readIndexData(CFFDataInput cFFDataInput) throws IOException {
        int readCard16 = cFFDataInput.readCard16();
        IndexData indexData = new IndexData(readCard16);
        if (readCard16 == 0) {
            return indexData;
        }
        int readOffSize = cFFDataInput.readOffSize();
        int i = 0;
        while (i <= readCard16) {
            int readOffset = cFFDataInput.readOffset(readOffSize);
            if (readOffset <= cFFDataInput.length()) {
                indexData.setOffset(i, readOffset);
                i++;
            } else {
                throw new IOException(GeneratedOutlineSupport.outline42("illegal offset value ", readOffset, " in CFF font"));
            }
        }
        int offset = indexData.getOffset(readCard16) - indexData.getOffset(0);
        indexData.initData(offset);
        for (int i2 = 0; i2 < offset; i2++) {
            indexData.setData(i2, cFFDataInput.readCard8());
        }
        return indexData;
    }

    public static Integer readIntegerNumber(CFFDataInput cFFDataInput, int i) throws IOException {
        if (i == 28) {
            return Integer.valueOf((short) (cFFDataInput.readUnsignedByte() | (cFFDataInput.readUnsignedByte() << 8)));
        } else if (i == 29) {
            return Integer.valueOf(cFFDataInput.readUnsignedByte() | (cFFDataInput.readUnsignedByte() << 24) | (cFFDataInput.readUnsignedByte() << 16) | (cFFDataInput.readUnsignedByte() << 8));
        } else if (i >= 32 && i <= 246) {
            return Integer.valueOf(i - 139);
        } else {
            if (i >= 247 && i <= 250) {
                return Integer.valueOf(((i - 247) * 256) + cFFDataInput.readUnsignedByte() + 108);
            } else if (i < 251 || i > 254) {
                throw new IllegalArgumentException();
            } else {
                return Integer.valueOf((((-(i - 251)) * 256) - cFFDataInput.readUnsignedByte()) - 108);
            }
        }
    }

    public static long readLong(CFFDataInput cFFDataInput) throws IOException {
        return (long) (cFFDataInput.readCard16() | (cFFDataInput.readCard16() << 16));
    }

    public static CFFOperator readOperator(CFFDataInput cFFDataInput, int i) throws IOException {
        return CFFOperator.getOperator(readOperatorKey(cFFDataInput, i));
    }

    public static Key readOperatorKey(CFFDataInput cFFDataInput, int i) throws IOException {
        if (i == 12) {
            return new Key(i, cFFDataInput.readUnsignedByte());
        }
        return new Key(i);
    }

    private Map<String, Object> readPrivateDict(DictData dictData) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BlueValues", getDelta(dictData, "BlueValues", null));
        linkedHashMap.put("OtherBlues", getDelta(dictData, "OtherBlues", null));
        linkedHashMap.put("FamilyBlues", getDelta(dictData, "FamilyBlues", null));
        linkedHashMap.put("FamilyOtherBlues", getDelta(dictData, "FamilyOtherBlues", null));
        linkedHashMap.put("BlueScale", getNumber(dictData, "BlueScale", Double.valueOf(0.039625d)));
        linkedHashMap.put("BlueShift", getNumber(dictData, "BlueShift", Integer.valueOf(7)));
        linkedHashMap.put("BlueFuzz", getNumber(dictData, "BlueFuzz", Integer.valueOf(1)));
        linkedHashMap.put(AFMParser.STD_HW, getNumber(dictData, AFMParser.STD_HW, null));
        linkedHashMap.put(AFMParser.STD_VW, getNumber(dictData, AFMParser.STD_VW, null));
        linkedHashMap.put("StemSnapH", getDelta(dictData, "StemSnapH", null));
        linkedHashMap.put("StemSnapV", getDelta(dictData, "StemSnapV", null));
        Integer valueOf = Integer.valueOf(0);
        linkedHashMap.put("ForceBold", getBoolean(dictData, "ForceBold", false));
        linkedHashMap.put("LanguageGroup", getNumber(dictData, "LanguageGroup", valueOf));
        linkedHashMap.put("ExpansionFactor", getNumber(dictData, "ExpansionFactor", Double.valueOf(0.06d)));
        linkedHashMap.put("initialRandomSeed", getNumber(dictData, "initialRandomSeed", valueOf));
        linkedHashMap.put("defaultWidthX", getNumber(dictData, "defaultWidthX", valueOf));
        linkedHashMap.put("nominalWidthX", getNumber(dictData, "nominalWidthX", valueOf));
        return linkedHashMap;
    }

    public static Double readRealNumber(CFFDataInput cFFDataInput, int i) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int readUnsignedByte = cFFDataInput.readUnsignedByte();
            int[] iArr = {readUnsignedByte / 16, readUnsignedByte % 16};
            int i2 = 0;
            while (true) {
                if (i2 < 2) {
                    int i3 = iArr[i2];
                    switch (i3) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            stringBuffer.append(i3);
                            z2 = false;
                            break;
                        case 10:
                            stringBuffer.append(".");
                            break;
                        case 11:
                            stringBuffer.append(Constant.PAYMENT_METHOD_TYPE_EMI);
                            break;
                        case 12:
                            stringBuffer.append("E-");
                            break;
                        case 13:
                            break;
                        case 14:
                            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            break;
                        case 15:
                            z = true;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    z2 = true;
                    i2++;
                }
            }
        }
        if (z2) {
            stringBuffer.append("0");
        }
        return Double.valueOf(stringBuffer.toString());
    }

    private String readString(int i) throws IOException {
        if (i >= 0 && i <= 390) {
            return CFFStandardString.getName(i);
        }
        int i2 = i - 391;
        if (i2 < this.stringIndex.getCount()) {
            return new DataInput(this.stringIndex.getBytes(i2)).getString();
        }
        return GeneratedOutlineSupport.outline41("SID", i);
    }

    private void readSupplement(CFFDataInput cFFDataInput, EmbeddedEncoding embeddedEncoding) throws IOException {
        embeddedEncoding.nSups = cFFDataInput.readCard8();
        embeddedEncoding.supplement = new Supplement[embeddedEncoding.nSups];
        for (int i = 0; i < embeddedEncoding.supplement.length; i++) {
            Supplement supplement = new Supplement();
            supplement.code = cFFDataInput.readCard8();
            supplement.sid = cFFDataInput.readSID();
            supplement.name = readString(supplement.sid);
            embeddedEncoding.supplement[i] = supplement;
            embeddedEncoding.add(supplement.code, supplement.sid, readString(supplement.sid));
        }
    }

    public static String readTagName(CFFDataInput cFFDataInput) throws IOException {
        return new String(cFFDataInput.readBytes(4), "ISO-8859-1");
    }

    public List<CFFFont> parse(byte[] bArr) throws IOException {
        boolean z;
        CFFDataInput cFFDataInput = new CFFDataInput(bArr);
        this.input = cFFDataInput;
        String readTagName = readTagName(cFFDataInput);
        if (TAG_OTTO.equals(readTagName)) {
            short readShort = this.input.readShort();
            this.input.readShort();
            this.input.readShort();
            this.input.readShort();
            int i = 0;
            while (true) {
                if (i >= readShort) {
                    z = false;
                    break;
                }
                String readTagName2 = readTagName(this.input);
                readLong(this.input);
                long readLong = readLong(this.input);
                long readLong2 = readLong(this.input);
                if (readTagName2.equals(CFFTable.TAG)) {
                    int i2 = (int) readLong2;
                    byte[] bArr2 = new byte[i2];
                    System.arraycopy(bArr, (int) readLong, bArr2, 0, i2);
                    this.input = new CFFDataInput(bArr2);
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                throw new IOException("CFF tag not found in this OpenType font.");
            }
        } else if (TAG_TTCF.equals(readTagName)) {
            throw new IOException("True Type Collection fonts are not supported.");
        } else if (!TAG_TTFONLY.equals(readTagName)) {
            this.input.setPosition(0);
        } else {
            throw new IOException("OpenType fonts containing a true type font are not supported.");
        }
        this.header = readHeader(this.input);
        this.nameIndex = readIndexData(this.input);
        this.topDictIndex = readIndexData(this.input);
        this.stringIndex = readIndexData(this.input);
        IndexData readIndexData = readIndexData(this.input);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.nameIndex.getCount(); i3++) {
            CFFFont parseFont = parseFont(i3);
            parseFont.setGlobalSubrIndex(readIndexData);
            arrayList.add(parseFont);
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CFFParser.class.getSimpleName());
        sb.append("[");
        return GeneratedOutlineSupport.outline62(sb, this.debugFontName, CMapParser.MARK_END_OF_ARRAY);
    }
}
