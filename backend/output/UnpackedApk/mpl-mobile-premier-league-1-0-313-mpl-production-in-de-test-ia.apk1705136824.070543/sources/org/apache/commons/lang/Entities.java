package org.apache.commons.lang;

import com.netcore.android.notification.SMTNotificationConstants;
import in.juspay.hypersdk.core.PaymentConstants.ENVIRONMENT;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject;
import sfs2x.client.requests.CreateRoomRequest;
import sfs2x.client.requests.LoginRequest;

public class Entities {
    public static final String[][] APOS_ARRAY = {new String[]{"apos", "39"}};
    public static final String[][] BASIC_ARRAY = {new String[]{"quot", "34"}, new String[]{"amp", "38"}, new String[]{"lt", "60"}, new String[]{"gt", "62"}};
    public static final Entities HTML32;
    public static final Entities HTML40;
    public static final String[][] HTML40_ARRAY = {new String[]{"fnof", "402"}, new String[]{"Alpha", "913"}, new String[]{"Beta", "914"}, new String[]{"Gamma", "915"}, new String[]{"Delta", "916"}, new String[]{"Epsilon", "917"}, new String[]{"Zeta", "918"}, new String[]{"Eta", "919"}, new String[]{"Theta", "920"}, new String[]{"Iota", "921"}, new String[]{"Kappa", "922"}, new String[]{"Lambda", "923"}, new String[]{"Mu", "924"}, new String[]{"Nu", "925"}, new String[]{"Xi", "926"}, new String[]{"Omicron", "927"}, new String[]{"Pi", "928"}, new String[]{"Rho", "929"}, new String[]{"Sigma", "931"}, new String[]{"Tau", "932"}, new String[]{"Upsilon", "933"}, new String[]{"Phi", "934"}, new String[]{"Chi", "935"}, new String[]{"Psi", "936"}, new String[]{"Omega", "937"}, new String[]{"alpha", "945"}, new String[]{"beta", "946"}, new String[]{"gamma", "947"}, new String[]{"delta", "948"}, new String[]{"epsilon", "949"}, new String[]{"zeta", "950"}, new String[]{"eta", "951"}, new String[]{"theta", "952"}, new String[]{"iota", "953"}, new String[]{"kappa", "954"}, new String[]{"lambda", "955"}, new String[]{CreateRoomRequest.KEY_MAXUSERS, "956"}, new String[]{"nu", "957"}, new String[]{"xi", "958"}, new String[]{"omicron", "959"}, new String[]{LoginRequest.KEY_PRIVILEGE_ID, "960"}, new String[]{"rho", "961"}, new String[]{"sigmaf", "962"}, new String[]{"sigma", "963"}, new String[]{"tau", "964"}, new String[]{"upsilon", "965"}, new String[]{"phi", "966"}, new String[]{"chi", "967"}, new String[]{"psi", "968"}, new String[]{"omega", "969"}, new String[]{"thetasym", "977"}, new String[]{"upsih", "978"}, new String[]{"piv", "982"}, new String[]{"bull", "8226"}, new String[]{"hellip", "8230"}, new String[]{"prime", "8242"}, new String[]{"Prime", "8243"}, new String[]{"oline", "8254"}, new String[]{"frasl", "8260"}, new String[]{"weierp", "8472"}, new String[]{SMTNotificationConstants.NOTIF_IMAGE_URL_KEY, "8465"}, new String[]{"real", "8476"}, new String[]{"trade", "8482"}, new String[]{"alefsym", "8501"}, new String[]{"larr", "8592"}, new String[]{"uarr", "8593"}, new String[]{"rarr", "8594"}, new String[]{"darr", "8595"}, new String[]{"harr", "8596"}, new String[]{"crarr", "8629"}, new String[]{"lArr", "8656"}, new String[]{"uArr", "8657"}, new String[]{"rArr", "8658"}, new String[]{"dArr", "8659"}, new String[]{"hArr", "8660"}, new String[]{"forall", "8704"}, new String[]{"part", "8706"}, new String[]{"exist", "8707"}, new String[]{"empty", "8709"}, new String[]{"nabla", "8711"}, new String[]{"isin", "8712"}, new String[]{"notin", "8713"}, new String[]{"ni", "8715"}, new String[]{ENVIRONMENT.PRODUCTION, "8719"}, new String[]{"sum", "8721"}, new String[]{"minus", "8722"}, new String[]{"lowast", "8727"}, new String[]{"radic", "8730"}, new String[]{"prop", "8733"}, new String[]{"infin", "8734"}, new String[]{"ang", "8736"}, new String[]{"and", "8743"}, new String[]{"or", "8744"}, new String[]{"cap", "8745"}, new String[]{"cup", "8746"}, new String[]{"int", "8747"}, new String[]{"there4", "8756"}, new String[]{"sim", "8764"}, new String[]{"cong", "8773"}, new String[]{"asymp", "8776"}, new String[]{"ne", "8800"}, new String[]{"equiv", "8801"}, new String[]{"le", "8804"}, new String[]{"ge", "8805"}, new String[]{"sub", "8834"}, new String[]{"sup", "8835"}, new String[]{"sube", "8838"}, new String[]{"supe", "8839"}, new String[]{"oplus", "8853"}, new String[]{"otimes", "8855"}, new String[]{"perp", "8869"}, new String[]{"sdot", "8901"}, new String[]{"lceil", "8968"}, new String[]{"rceil", "8969"}, new String[]{"lfloor", "8970"}, new String[]{"rfloor", "8971"}, new String[]{"lang", "9001"}, new String[]{"rang", "9002"}, new String[]{"loz", "9674"}, new String[]{"spades", "9824"}, new String[]{"clubs", "9827"}, new String[]{"hearts", "9829"}, new String[]{"diams", "9830"}, new String[]{"OElig", "338"}, new String[]{"oelig", "339"}, new String[]{"Scaron", "352"}, new String[]{"scaron", "353"}, new String[]{"Yuml", "376"}, new String[]{"circ", "710"}, new String[]{"tilde", "732"}, new String[]{"ensp", "8194"}, new String[]{"emsp", "8195"}, new String[]{"thinsp", "8201"}, new String[]{"zwnj", "8204"}, new String[]{"zwj", "8205"}, new String[]{"lrm", "8206"}, new String[]{"rlm", "8207"}, new String[]{"ndash", "8211"}, new String[]{"mdash", "8212"}, new String[]{"lsquo", "8216"}, new String[]{"rsquo", "8217"}, new String[]{"sbquo", "8218"}, new String[]{"ldquo", "8220"}, new String[]{"rdquo", "8221"}, new String[]{"bdquo", "8222"}, new String[]{"dagger", "8224"}, new String[]{"Dagger", "8225"}, new String[]{"permil", "8240"}, new String[]{"lsaquo", "8249"}, new String[]{"rsaquo", "8250"}, new String[]{"euro", "8364"}};
    public static final String[][] ISO8859_1_ARRAY = {new String[]{"nbsp", "160"}, new String[]{"iexcl", "161"}, new String[]{"cent", "162"}, new String[]{"pound", "163"}, new String[]{"curren", "164"}, new String[]{"yen", "165"}, new String[]{"brvbar", "166"}, new String[]{"sect", "167"}, new String[]{"uml", "168"}, new String[]{"copy", "169"}, new String[]{"ordf", "170"}, new String[]{"laquo", "171"}, new String[]{HSLCriteriaBuilder.NOT, "172"}, new String[]{"shy", "173"}, new String[]{"reg", "174"}, new String[]{"macr", "175"}, new String[]{"deg", "176"}, new String[]{"plusmn", "177"}, new String[]{"sup2", "178"}, new String[]{"sup3", "179"}, new String[]{"acute", PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_180_DEGREES}, new String[]{"micro", "181"}, new String[]{"para", "182"}, new String[]{"middot", "183"}, new String[]{"cedil", "184"}, new String[]{"sup1", "185"}, new String[]{"ordm", "186"}, new String[]{"raquo", "187"}, new String[]{"frac14", "188"}, new String[]{"frac12", "189"}, new String[]{"frac34", "190"}, new String[]{"iquest", "191"}, new String[]{"Agrave", "192"}, new String[]{"Aacute", "193"}, new String[]{"Acirc", "194"}, new String[]{"Atilde", "195"}, new String[]{"Auml", "196"}, new String[]{"Aring", "197"}, new String[]{"AElig", "198"}, new String[]{"Ccedil", "199"}, new String[]{"Egrave", "200"}, new String[]{"Eacute", "201"}, new String[]{"Ecirc", "202"}, new String[]{"Euml", "203"}, new String[]{"Igrave", "204"}, new String[]{"Iacute", "205"}, new String[]{"Icirc", "206"}, new String[]{"Iuml", "207"}, new String[]{"ETH", "208"}, new String[]{"Ntilde", "209"}, new String[]{"Ograve", "210"}, new String[]{"Oacute", "211"}, new String[]{"Ocirc", "212"}, new String[]{"Otilde", "213"}, new String[]{"Ouml", "214"}, new String[]{"times", "215"}, new String[]{"Oslash", "216"}, new String[]{"Ugrave", "217"}, new String[]{"Uacute", "218"}, new String[]{"Ucirc", "219"}, new String[]{"Uuml", "220"}, new String[]{"Yacute", "221"}, new String[]{"THORN", "222"}, new String[]{"szlig", "223"}, new String[]{"agrave", "224"}, new String[]{"aacute", "225"}, new String[]{"acirc", "226"}, new String[]{"atilde", "227"}, new String[]{"auml", "228"}, new String[]{"aring", "229"}, new String[]{"aelig", "230"}, new String[]{"ccedil", "231"}, new String[]{"egrave", "232"}, new String[]{"eacute", "233"}, new String[]{"ecirc", "234"}, new String[]{"euml", "235"}, new String[]{"igrave", "236"}, new String[]{"iacute", "237"}, new String[]{"icirc", "238"}, new String[]{"iuml", "239"}, new String[]{"eth", "240"}, new String[]{"ntilde", "241"}, new String[]{"ograve", "242"}, new String[]{"oacute", "243"}, new String[]{"ocirc", "244"}, new String[]{"otilde", "245"}, new String[]{"ouml", "246"}, new String[]{"divide", "247"}, new String[]{"oslash", "248"}, new String[]{"ugrave", "249"}, new String[]{"uacute", "250"}, new String[]{"ucirc", "251"}, new String[]{"uuml", "252"}, new String[]{"yacute", "253"}, new String[]{"thorn", "254"}, new String[]{"yuml", "255"}};
    public static final Entities XML;
    public EntityMap map = new LookupEntityMap();

    public static class ArrayEntityMap implements EntityMap {
        public int growBy;
        public String[] names;
        public int size;
        public int[] values;

        public ArrayEntityMap() {
            this.growBy = 100;
            this.size = 0;
            this.names = new String[100];
            this.values = new int[100];
        }

        public void add(String str, int i) {
            ensureCapacity(this.size + 1);
            String[] strArr = this.names;
            int i2 = this.size;
            strArr[i2] = str;
            this.values[i2] = i;
            this.size = i2 + 1;
        }

        public void ensureCapacity(int i) {
            if (i > this.names.length) {
                int max = Math.max(i, this.size + this.growBy);
                String[] strArr = new String[max];
                System.arraycopy(this.names, 0, strArr, 0, this.size);
                this.names = strArr;
                int[] iArr = new int[max];
                System.arraycopy(this.values, 0, iArr, 0, this.size);
                this.values = iArr;
            }
        }

        public String name(int i) {
            for (int i2 = 0; i2 < this.size; i2++) {
                if (this.values[i2] == i) {
                    return this.names[i2];
                }
            }
            return null;
        }

        public int value(String str) {
            for (int i = 0; i < this.size; i++) {
                if (this.names[i].equals(str)) {
                    return this.values[i];
                }
            }
            return -1;
        }

        public ArrayEntityMap(int i) {
            this.growBy = 100;
            this.size = 0;
            this.growBy = i;
            this.names = new String[i];
            this.values = new int[i];
        }
    }

    public static class BinaryEntityMap extends ArrayEntityMap {
        public BinaryEntityMap() {
        }

        private int binarySearch(int i) {
            int i2 = this.size - 1;
            int i3 = 0;
            while (i3 <= i2) {
                int i4 = (i3 + i2) >>> 1;
                int i5 = this.values[i4];
                if (i5 < i) {
                    i3 = i4 + 1;
                } else if (i5 <= i) {
                    return i4;
                } else {
                    i2 = i4 - 1;
                }
            }
            return -(i3 + 1);
        }

        public void add(String str, int i) {
            ensureCapacity(this.size + 1);
            int binarySearch = binarySearch(i);
            if (binarySearch <= 0) {
                int i2 = -(binarySearch + 1);
                int[] iArr = this.values;
                int i3 = i2 + 1;
                System.arraycopy(iArr, i2, iArr, i3, this.size - i2);
                this.values[i2] = i;
                String[] strArr = this.names;
                System.arraycopy(strArr, i2, strArr, i3, this.size - i2);
                this.names[i2] = str;
                this.size++;
            }
        }

        public String name(int i) {
            int binarySearch = binarySearch(i);
            if (binarySearch < 0) {
                return null;
            }
            return this.names[binarySearch];
        }

        public BinaryEntityMap(int i) {
            super(i);
        }
    }

    public interface EntityMap {
        void add(String str, int i);

        String name(int i);

        int value(String str);
    }

    public static class HashEntityMap extends MapIntMap {
        public HashEntityMap() {
            this.mapNameToValue = new HashMap();
            this.mapValueToName = new HashMap();
        }
    }

    public static class LookupEntityMap extends PrimitiveEntityMap {
        public int LOOKUP_TABLE_SIZE = 256;
        public String[] lookupTable;

        private void createLookupTable() {
            this.lookupTable = new String[this.LOOKUP_TABLE_SIZE];
            for (int i = 0; i < this.LOOKUP_TABLE_SIZE; i++) {
                this.lookupTable[i] = super.name(i);
            }
        }

        private String[] lookupTable() {
            if (this.lookupTable == null) {
                createLookupTable();
            }
            return this.lookupTable;
        }

        public String name(int i) {
            if (i < this.LOOKUP_TABLE_SIZE) {
                return lookupTable()[i];
            }
            return super.name(i);
        }
    }

    public static abstract class MapIntMap implements EntityMap {
        public Map mapNameToValue;
        public Map mapValueToName;

        public void add(String str, int i) {
            this.mapNameToValue.put(str, new Integer(i));
            this.mapValueToName.put(new Integer(i), str);
        }

        public String name(int i) {
            return (String) this.mapValueToName.get(new Integer(i));
        }

        public int value(String str) {
            Object obj = this.mapNameToValue.get(str);
            if (obj == null) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }
    }

    public static class PrimitiveEntityMap implements EntityMap {
        public Map mapNameToValue = new HashMap();
        public IntHashMap mapValueToName = new IntHashMap();

        public void add(String str, int i) {
            this.mapNameToValue.put(str, new Integer(i));
            this.mapValueToName.put(i, str);
        }

        public String name(int i) {
            return (String) this.mapValueToName.get(i);
        }

        public int value(String str) {
            Object obj = this.mapNameToValue.get(str);
            if (obj == null) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }
    }

    public static class TreeEntityMap extends MapIntMap {
        public TreeEntityMap() {
            this.mapNameToValue = new TreeMap();
            this.mapValueToName = new TreeMap();
        }
    }

    static {
        Entities entities = new Entities();
        XML = entities;
        entities.addEntities(BASIC_ARRAY);
        XML.addEntities(APOS_ARRAY);
        Entities entities2 = new Entities();
        HTML32 = entities2;
        entities2.addEntities(BASIC_ARRAY);
        HTML32.addEntities(ISO8859_1_ARRAY);
        Entities entities3 = new Entities();
        HTML40 = entities3;
        fillWithHtml40Entities(entities3);
    }

    private StringWriter createStringWriter(String str) {
        return new StringWriter((int) ((((double) str.length()) * 0.1d) + ((double) str.length())));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
        if (r2 > 65535) goto L_0x006f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doUnescape(java.io.Writer r11, java.lang.String r12, int r13) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            r11.write(r12, r0, r13)
            int r1 = r12.length()
        L_0x0008:
            if (r13 >= r1) goto L_0x0086
            char r2 = r12.charAt(r13)
            r3 = 38
            r4 = 1
            if (r2 != r3) goto L_0x0081
            int r5 = r13 + 1
            r6 = 59
            int r7 = r12.indexOf(r6, r5)
            r8 = -1
            if (r7 != r8) goto L_0x0022
            r11.write(r2)
            goto L_0x0084
        L_0x0022:
            int r9 = r12.indexOf(r3, r5)
            if (r9 == r8) goto L_0x002e
            if (r9 >= r7) goto L_0x002e
            r11.write(r2)
            goto L_0x0084
        L_0x002e:
            java.lang.String r13 = r12.substring(r5, r7)
            int r2 = r13.length()
            if (r2 <= 0) goto L_0x006f
            char r5 = r13.charAt(r0)
            r9 = 35
            if (r5 != r9) goto L_0x006a
            if (r2 <= r4) goto L_0x006f
            char r2 = r13.charAt(r4)
            r5 = 88
            if (r2 == r5) goto L_0x0059
            r5 = 120(0x78, float:1.68E-43)
            if (r2 == r5) goto L_0x0059
            java.lang.String r2 = r13.substring(r4)     // Catch:{ NumberFormatException -> 0x006f }
            r5 = 10
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch:{ NumberFormatException -> 0x006f }
            goto L_0x0064
        L_0x0059:
            r2 = 2
            java.lang.String r2 = r13.substring(r2)     // Catch:{ NumberFormatException -> 0x006f }
            r5 = 16
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch:{ NumberFormatException -> 0x006f }
        L_0x0064:
            r5 = 65535(0xffff, float:9.1834E-41)
            if (r2 <= r5) goto L_0x0070
            goto L_0x006f
        L_0x006a:
            int r2 = r10.entityValue(r13)
            goto L_0x0070
        L_0x006f:
            r2 = -1
        L_0x0070:
            if (r2 != r8) goto L_0x007c
            r11.write(r3)
            r11.write(r13)
            r11.write(r6)
            goto L_0x007f
        L_0x007c:
            r11.write(r2)
        L_0x007f:
            r13 = r7
            goto L_0x0084
        L_0x0081:
            r11.write(r2)
        L_0x0084:
            int r13 = r13 + r4
            goto L_0x0008
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.Entities.doUnescape(java.io.Writer, java.lang.String, int):void");
    }

    public static void fillWithHtml40Entities(Entities entities) {
        entities.addEntities(BASIC_ARRAY);
        entities.addEntities(ISO8859_1_ARRAY);
        entities.addEntities(HTML40_ARRAY);
    }

    public void addEntities(String[][] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            addEntity(strArr[i][0], Integer.parseInt(strArr[i][1]));
        }
    }

    public void addEntity(String str, int i) {
        this.map.add(str, i);
    }

    public String entityName(int i) {
        return this.map.name(i);
    }

    public int entityValue(String str) {
        return this.map.value(str);
    }

    public String escape(String str) {
        StringWriter createStringWriter = createStringWriter(str);
        try {
            escape(createStringWriter, str);
            return createStringWriter.toString();
        } catch (IOException e2) {
            throw new UnhandledException(e2);
        }
    }

    public String unescape(String str) {
        int indexOf = str.indexOf(38);
        if (indexOf < 0) {
            return str;
        }
        StringWriter createStringWriter = createStringWriter(str);
        try {
            doUnescape(createStringWriter, str, indexOf);
            return createStringWriter.toString();
        } catch (IOException e2) {
            throw new UnhandledException(e2);
        }
    }

    public void escape(Writer writer, String str) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            String entityName = entityName(charAt);
            if (entityName != null) {
                writer.write(38);
                writer.write(entityName);
                writer.write(59);
            } else if (charAt > 127) {
                writer.write("&#");
                writer.write(Integer.toString(charAt, 10));
                writer.write(59);
            } else {
                writer.write(charAt);
            }
        }
    }

    public void unescape(Writer writer, String str) throws IOException {
        int indexOf = str.indexOf(38);
        if (indexOf < 0) {
            writer.write(str);
        } else {
            doUnescape(writer, str, indexOf);
        }
    }
}
