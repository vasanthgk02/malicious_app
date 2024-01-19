package org.apache.commons.lang.text;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang.Validate;

public class ExtendedMessageFormat extends MessageFormat {
    public static final String DUMMY_PATTERN = "";
    public static final char END_FE = '}';
    public static final String ESCAPED_QUOTE = "''";
    public static final char QUOTE = '\'';
    public static final char START_FE = '{';
    public static final char START_FMT = ',';
    public static final long serialVersionUID = -2362048321261811743L;
    public Map registry;
    public String toPattern;

    public ExtendedMessageFormat(String str) {
        this(str, Locale.getDefault());
    }

    private StringBuffer appendQuotedString(String str, ParsePosition parsePosition, StringBuffer stringBuffer, boolean z) {
        int index = parsePosition.getIndex();
        char[] charArray = str.toCharArray();
        if (!z || charArray[index] != '\'') {
            int i = index;
            for (int index2 = parsePosition.getIndex(); index2 < str.length(); index2++) {
                if (z && str.substring(index2).startsWith(ESCAPED_QUOTE)) {
                    stringBuffer.append(charArray, i, parsePosition.getIndex() - i);
                    stringBuffer.append(QUOTE);
                    parsePosition.setIndex(index2 + 2);
                    i = parsePosition.getIndex();
                } else if (charArray[parsePosition.getIndex()] != '\'') {
                    next(parsePosition);
                } else {
                    next(parsePosition);
                    if (stringBuffer == null) {
                        stringBuffer = null;
                    } else {
                        stringBuffer.append(charArray, i, parsePosition.getIndex() - i);
                    }
                    return stringBuffer;
                }
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unterminated quoted string at position ");
            stringBuffer2.append(index);
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
        if (stringBuffer == null) {
            stringBuffer = null;
        } else {
            stringBuffer.append(QUOTE);
        }
        return stringBuffer;
    }

    private boolean containsElements(Collection<Object> collection) {
        if (!(collection == null || collection.size() == 0)) {
            for (Object obj : collection) {
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Format getFormat(String str) {
        String str2;
        if (this.registry != null) {
            int indexOf = str.indexOf(44);
            if (indexOf > 0) {
                String trim = str.substring(0, indexOf).trim();
                str2 = str.substring(indexOf + 1).trim();
                str = trim;
            } else {
                str2 = null;
            }
            FormatFactory formatFactory = (FormatFactory) this.registry.get(str);
            if (formatFactory != null) {
                return formatFactory.getFormat(str, str2, getLocale());
            }
        }
        return null;
    }

    private void getQuotedString(String str, ParsePosition parsePosition, boolean z) {
        appendQuotedString(str, parsePosition, null, z);
    }

    private String insertFormats(String str, ArrayList arrayList) {
        if (!containsElements(arrayList)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() * 2);
        ParsePosition parsePosition = new ParsePosition(0);
        int i = -1;
        int i2 = 0;
        while (parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (charAt == '\'') {
                appendQuotedString(str, parsePosition, stringBuffer, false);
            } else if (charAt != '{') {
                if (charAt == '}') {
                    i2--;
                }
                stringBuffer.append(charAt);
                next(parsePosition);
            } else {
                i2++;
                if (i2 == 1) {
                    i++;
                    stringBuffer.append('{');
                    stringBuffer.append(readArgumentIndex(str, next(parsePosition)));
                    String str2 = (String) arrayList.get(i);
                    if (str2 != null) {
                        stringBuffer.append(',');
                        stringBuffer.append(str2);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    private ParsePosition next(ParsePosition parsePosition) {
        parsePosition.setIndex(parsePosition.getIndex() + 1);
        return parsePosition;
    }

    private String parseFormatDescription(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        seekNonWs(str, parsePosition);
        int index2 = parsePosition.getIndex();
        int i = 1;
        while (parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (charAt == '\'') {
                getQuotedString(str, parsePosition, false);
            } else if (charAt == '{') {
                i++;
            } else if (charAt != '}') {
                continue;
            } else {
                i--;
                if (i == 0) {
                    return str.substring(index2, parsePosition.getIndex());
                }
            }
            next(parsePosition);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unterminated format element at position ");
        stringBuffer.append(index);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    private int readArgumentIndex(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        seekNonWs(str, parsePosition);
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        while (!z && parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (Character.isWhitespace(charAt)) {
                seekNonWs(str, parsePosition);
                charAt = str.charAt(parsePosition.getIndex());
                if (!(charAt == ',' || charAt == '}')) {
                    z = true;
                    next(parsePosition);
                }
            }
            if ((charAt == ',' || charAt == '}') && stringBuffer.length() > 0) {
                try {
                    return Integer.parseInt(stringBuffer.toString());
                } catch (NumberFormatException unused) {
                }
            }
            stringBuffer.append(charAt);
            z = !Character.isDigit(charAt);
            next(parsePosition);
        }
        if (z) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Invalid format argument index at position ");
            stringBuffer2.append(index);
            stringBuffer2.append(": ");
            stringBuffer2.append(str.substring(index, parsePosition.getIndex()));
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Unterminated format element at position ");
        stringBuffer3.append(index);
        throw new IllegalArgumentException(stringBuffer3.toString());
    }

    private void seekNonWs(String str, ParsePosition parsePosition) {
        char[] charArray = str.toCharArray();
        do {
            int isMatch = StrMatcher.splitMatcher().isMatch(charArray, parsePosition.getIndex());
            parsePosition.setIndex(parsePosition.getIndex() + isMatch);
            if (isMatch <= 0) {
                return;
            }
        } while (parsePosition.getIndex() < str.length());
    }

    public final void applyPattern(String str) {
        Object obj;
        String str2;
        if (this.registry == null) {
            super.applyPattern(str);
            this.toPattern = super.toPattern();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer(str.length());
        int i = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        char[] charArray = str.toCharArray();
        int i2 = 0;
        while (parsePosition.getIndex() < str.length()) {
            char c2 = charArray[parsePosition.getIndex()];
            boolean z = true;
            if (c2 != '\'') {
                if (c2 == '{') {
                    i2++;
                    seekNonWs(str, parsePosition);
                    int index = parsePosition.getIndex();
                    int readArgumentIndex = readArgumentIndex(str, next(parsePosition));
                    stringBuffer.append('{');
                    stringBuffer.append(readArgumentIndex);
                    seekNonWs(str, parsePosition);
                    String str3 = null;
                    if (charArray[parsePosition.getIndex()] == ',') {
                        str2 = parseFormatDescription(str, next(parsePosition));
                        obj = getFormat(str2);
                        if (obj == null) {
                            stringBuffer.append(',');
                            stringBuffer.append(str2);
                        }
                    } else {
                        str2 = null;
                        obj = null;
                    }
                    arrayList.add(obj);
                    if (obj != null) {
                        str3 = str2;
                    }
                    arrayList2.add(str3);
                    Validate.isTrue(arrayList.size() == i2);
                    if (arrayList2.size() != i2) {
                        z = false;
                    }
                    Validate.isTrue(z);
                    if (charArray[parsePosition.getIndex()] != '}') {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Unreadable format element at position ");
                        stringBuffer2.append(index);
                        throw new IllegalArgumentException(stringBuffer2.toString());
                    }
                }
                stringBuffer.append(charArray[parsePosition.getIndex()]);
                next(parsePosition);
            } else {
                appendQuotedString(str, parsePosition, stringBuffer, true);
            }
        }
        super.applyPattern(stringBuffer.toString());
        this.toPattern = insertFormats(super.toPattern(), arrayList2);
        if (containsElements(arrayList)) {
            Format[] formats = getFormats();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Format format = (Format) it.next();
                if (format != null) {
                    formats[i] = format;
                }
                i++;
            }
            super.setFormats(formats);
        }
    }

    public void setFormat(int i, Format format) {
        throw new UnsupportedOperationException();
    }

    public void setFormatByArgumentIndex(int i, Format format) {
        throw new UnsupportedOperationException();
    }

    public void setFormats(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    public void setFormatsByArgumentIndex(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    public String toPattern() {
        return this.toPattern;
    }

    public ExtendedMessageFormat(String str, Locale locale) {
        this(str, locale, null);
    }

    public ExtendedMessageFormat(String str, Map map) {
        this(str, Locale.getDefault(), map);
    }

    public ExtendedMessageFormat(String str, Locale locale, Map map) {
        super("");
        setLocale(locale);
        this.registry = map;
        applyPattern(str);
    }
}
