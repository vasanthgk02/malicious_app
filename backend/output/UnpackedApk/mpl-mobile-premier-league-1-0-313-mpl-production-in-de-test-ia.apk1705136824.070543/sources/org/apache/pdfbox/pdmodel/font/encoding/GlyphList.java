package org.apache.pdfbox.pdmodel.font.encoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.encoding.Encoding;
import org.apache.pdfbox.util.PDFBoxResourceLoader;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public final class GlyphList {
    public static final GlyphList DEFAULT;
    public static final GlyphList ZAPF_DINGBATS;
    public final Map<String, String> nameToUnicode;
    public final Map<String, String> unicodeToName;

    static {
        Class<GlyphList> cls = GlyphList.class;
        try {
            if (PDFBoxResourceLoader.isReady()) {
                DEFAULT = new GlyphList(PDFBoxResourceLoader.getStream("org/apache/pdfbox/resources/glyphlist/" + "glyphlist.txt"));
            } else {
                ClassLoader classLoader = cls.getClassLoader();
                DEFAULT = new GlyphList(classLoader.getResourceAsStream("org/apache/pdfbox/resources/glyphlist/" + "glyphlist.txt"));
            }
            if (PDFBoxResourceLoader.isReady()) {
                ZAPF_DINGBATS = new GlyphList(PDFBoxResourceLoader.getStream("org/apache/pdfbox/resources/glyphlist/" + "zapfdingbats.txt"));
            } else {
                ClassLoader classLoader2 = cls.getClassLoader();
                ZAPF_DINGBATS = new GlyphList(classLoader2.getResourceAsStream("org/apache/pdfbox/resources/glyphlist/" + "zapfdingbats.txt"));
            }
            try {
                if (System.getProperty("glyphlist_ext") != null) {
                    throw new UnsupportedOperationException("glyphlist_ext is no longer supported, use GlyphList.DEFAULT.addGlyphs(Properties) instead");
                }
            } catch (SecurityException unused) {
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public GlyphList(InputStream inputStream) throws IOException {
        this.nameToUnicode = new HashMap();
        this.unicodeToName = new HashMap();
        loadList(inputStream);
    }

    public static GlyphList getAdobeGlyphList() {
        return DEFAULT;
    }

    public static GlyphList getZapfDingbats() {
        return ZAPF_DINGBATS;
    }

    private void loadList(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (bufferedReader.ready()) {
            try {
                String readLine = bufferedReader.readLine();
                if (!readLine.startsWith(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                    String[] split = readLine.split(";");
                    if (split.length >= 2) {
                        String str = split[0];
                        String[] split2 = split[1].split(CMap.SPACE);
                        if (this.nameToUnicode.containsKey(str)) {
                            String str2 = split[1];
                            String str3 = this.nameToUnicode.get(str);
                        }
                        int length = split2.length;
                        int[] iArr = new int[length];
                        int length2 = split2.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length2) {
                            iArr[i2] = Integer.parseInt(split2[i], 16);
                            i++;
                            i2++;
                        }
                        String str4 = new String(iArr, 0, length);
                        this.nameToUnicode.put(str, str4);
                        if (!this.unicodeToName.containsKey(str4)) {
                            this.unicodeToName.put(str4, str);
                        }
                    } else {
                        throw new IOException("Invalid glyph list entry: " + readLine);
                    }
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    public String codePointToName(int i) {
        String str = this.unicodeToName.get(new String(new int[]{i}, 0, 1));
        return str == null ? Encoding.NOTDEF : str;
    }

    public String sequenceToName(String str) {
        String str2 = this.unicodeToName.get(str);
        return str2 == null ? Encoding.NOTDEF : str2;
    }

    public String toUnicode(String str) {
        if (str == null) {
            return null;
        }
        String str2 = this.nameToUnicode.get(str);
        if (str2 == null) {
            if (str.indexOf(46) > 0) {
                str2 = toUnicode(str.substring(0, str.indexOf(46)));
            } else if (str.startsWith("uni") && str.length() == 7) {
                int length = str.length();
                StringBuilder sb = new StringBuilder();
                int i = 3;
                while (true) {
                    int i2 = i + 4;
                    if (i2 > length) {
                        break;
                    }
                    try {
                        int parseInt = Integer.parseInt(str.substring(i, i2), 16);
                        if (parseInt <= 55295 || parseInt >= 57344) {
                            sb.append((char) parseInt);
                        }
                        i = i2;
                    } catch (NumberFormatException unused) {
                    }
                }
                str2 = sb.toString();
            } else if (str.startsWith("u") && str.length() == 5) {
                int parseInt2 = Integer.parseInt(str.substring(1), 16);
                if (parseInt2 <= 55295 || parseInt2 >= 57344) {
                    str2 = String.valueOf((char) parseInt2);
                }
            }
            this.nameToUnicode.put(str, str2);
        }
        return str2;
    }

    public GlyphList(GlyphList glyphList, InputStream inputStream) throws IOException {
        this.nameToUnicode = new HashMap(glyphList.nameToUnicode);
        this.unicodeToName = new HashMap(glyphList.unicodeToName);
        loadList(inputStream);
    }
}
