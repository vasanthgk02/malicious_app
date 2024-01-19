package org.apache.commons.lang;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class StringEscapeUtils {
    public static final char CSV_DELIMITER = ',';
    public static final char CSV_QUOTE = '\"';
    public static final String CSV_QUOTE_STR = String.valueOf(CSV_QUOTE);
    public static final char[] CSV_SEARCH_CHARS = {',', CSV_QUOTE, 13, 10};

    public static String escapeCsv(String str) {
        if (StringUtils.containsNone(str, CSV_SEARCH_CHARS)) {
            return str;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            escapeCsv(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String escapeHtml(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter((int) (((double) str.length()) * 1.5d));
            escapeHtml(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String escapeJava(String str) {
        return escapeJavaStyleString(str, false);
    }

    public static String escapeJavaScript(String str) {
        return escapeJavaStyleString(str, true);
    }

    public static String escapeJavaStyleString(String str, boolean z) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(str.length() * 2);
            escapeJavaStyleString(stringWriter, str, z);
            return stringWriter.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String escapeSql(String str) {
        if (str == null) {
            return null;
        }
        return StringUtils.replace(str, "'", ExtendedMessageFormat.ESCAPED_QUOTE);
    }

    public static void escapeXml(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        } else if (str != null) {
            Entities.XML.escape(writer, str);
        }
    }

    public static String hex(char c2) {
        return Integer.toHexString(c2).toUpperCase();
    }

    public static String unescapeCsv(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            unescapeCsv(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String unescapeHtml(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter((int) (((double) str.length()) * 1.5d));
            unescapeHtml(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String unescapeJava(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(str.length());
            unescapeJava(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String unescapeJavaScript(String str) {
        return unescapeJava(str);
    }

    public static void unescapeXml(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        } else if (str != null) {
            Entities.XML.unescape(writer, str);
        }
    }

    public static void escapeJava(Writer writer, String str) throws IOException {
        escapeJavaStyleString(writer, str, false);
    }

    public static void escapeJavaScript(Writer writer, String str) throws IOException {
        escapeJavaStyleString(writer, str, true);
    }

    public static void unescapeJavaScript(Writer writer, String str) throws IOException {
        unescapeJava(writer, str);
    }

    public static String escapeXml(String str) {
        if (str == null) {
            return null;
        }
        return Entities.XML.escape(str);
    }

    public static String unescapeXml(String str) {
        if (str == null) {
            return null;
        }
        return Entities.XML.unescape(str);
    }

    public static void escapeHtml(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        } else if (str != null) {
            Entities.HTML40.escape(writer, str);
        }
    }

    public static void escapeJavaStyleString(Writer writer, String str, boolean z) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt > 4095) {
                    StringBuffer outline71 = GeneratedOutlineSupport.outline71("\\u");
                    outline71.append(hex(charAt));
                    writer.write(outline71.toString());
                } else if (charAt > 255) {
                    StringBuffer outline712 = GeneratedOutlineSupport.outline71("\\u0");
                    outline712.append(hex(charAt));
                    writer.write(outline712.toString());
                } else if (charAt > 127) {
                    StringBuffer outline713 = GeneratedOutlineSupport.outline71("\\u00");
                    outline713.append(hex(charAt));
                    writer.write(outline713.toString());
                } else if (charAt < ' ') {
                    switch (charAt) {
                        case 8:
                            writer.write(92);
                            writer.write(98);
                            break;
                        case 9:
                            writer.write(92);
                            writer.write(116);
                            break;
                        case 10:
                            writer.write(92);
                            writer.write(110);
                            break;
                        case 12:
                            writer.write(92);
                            writer.write(102);
                            break;
                        case 13:
                            writer.write(92);
                            writer.write(114);
                            break;
                        default:
                            if (charAt <= 15) {
                                StringBuffer outline714 = GeneratedOutlineSupport.outline71("\\u000");
                                outline714.append(hex(charAt));
                                writer.write(outline714.toString());
                                break;
                            } else {
                                StringBuffer outline715 = GeneratedOutlineSupport.outline71("\\u00");
                                outline715.append(hex(charAt));
                                writer.write(outline715.toString());
                                break;
                            }
                    }
                } else if (charAt == '\"') {
                    writer.write(92);
                    writer.write(34);
                } else if (charAt == '\'') {
                    if (z) {
                        writer.write(92);
                    }
                    writer.write(39);
                } else if (charAt == '/') {
                    writer.write(92);
                    writer.write(47);
                } else if (charAt != '\\') {
                    writer.write(charAt);
                } else {
                    writer.write(92);
                    writer.write(92);
                }
            }
        }
    }

    public static void unescapeCsv(Writer writer, String str) throws IOException {
        if (str != null) {
            if (str.length() < 2) {
                writer.write(str);
            } else if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                String substring = str.substring(1, str.length() - 1);
                if (StringUtils.containsAny(substring, CSV_SEARCH_CHARS)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(CSV_QUOTE_STR);
                    stringBuffer.append(CSV_QUOTE_STR);
                    str = StringUtils.replace(substring, stringBuffer.toString(), CSV_QUOTE_STR);
                }
                writer.write(str);
            } else {
                writer.write(str);
            }
        }
    }

    public static void unescapeHtml(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        } else if (str != null) {
            Entities.HTML40.unescape(writer, str);
        }
    }

    public static void unescapeJava(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (str != null) {
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer(4);
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (z2) {
                    stringBuffer.append(charAt);
                    if (stringBuffer.length() == 4) {
                        try {
                            writer.write((char) Integer.parseInt(stringBuffer.toString(), 16));
                            stringBuffer.setLength(0);
                            z = false;
                            z2 = false;
                        } catch (NumberFormatException e2) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Unable to parse unicode value: ");
                            stringBuffer2.append(stringBuffer);
                            throw new NestableRuntimeException(stringBuffer2.toString(), e2);
                        }
                    }
                } else if (z) {
                    if (charAt == '\"') {
                        writer.write(34);
                    } else if (charAt == '\'') {
                        writer.write(39);
                    } else if (charAt == '\\') {
                        writer.write(92);
                    } else if (charAt == 'b') {
                        writer.write(8);
                    } else if (charAt == 'f') {
                        writer.write(12);
                    } else if (charAt == 'n') {
                        writer.write(10);
                    } else if (charAt == 'r') {
                        writer.write(13);
                    } else if (charAt == 't') {
                        writer.write(9);
                    } else if (charAt != 'u') {
                        writer.write(charAt);
                    } else {
                        z = false;
                        z2 = true;
                    }
                    z = false;
                } else if (charAt == '\\') {
                    z = true;
                } else {
                    writer.write(charAt);
                }
            }
            if (z) {
                writer.write(92);
            }
        }
    }

    public static void escapeCsv(Writer writer, String str) throws IOException {
        if (StringUtils.containsNone(str, CSV_SEARCH_CHARS)) {
            if (str != null) {
                writer.write(str);
            }
            return;
        }
        writer.write(34);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                writer.write(34);
            }
            writer.write(charAt);
        }
        writer.write(34);
    }
}
