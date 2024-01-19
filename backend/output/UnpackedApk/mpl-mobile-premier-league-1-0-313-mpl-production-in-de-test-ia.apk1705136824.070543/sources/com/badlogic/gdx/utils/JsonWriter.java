package com.badlogic.gdx.utils;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.pdfbox.pdfparser.BaseParser;

public class JsonWriter extends Writer {
    public JsonObject current;
    public boolean named;
    public OutputType outputType = OutputType.json;
    public boolean quoteLongValues = false;
    public final Array<JsonObject> stack = new Array<>();
    public final Writer writer;

    public class JsonObject {
        public final boolean array;
        public boolean needsComma;

        public JsonObject(boolean z) throws IOException {
            this.array = z;
            JsonWriter.this.writer.write(z ? 91 : 123);
        }
    }

    public enum OutputType {
        json,
        javascript,
        minimal;
        
        public static Pattern javascriptPattern;
        public static Pattern minimalNamePattern;
        public static Pattern minimalValuePattern;

        /* access modifiers changed from: public */
        static {
            javascriptPattern = Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*$");
            minimalNamePattern = Pattern.compile("^[^\":,}/ ][^:]*$");
            minimalValuePattern = Pattern.compile("^[^\":,{\\[\\]/ ][^}\\],]*$");
        }

        public String quoteName(String str) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.replace('\\', "\\\\");
            stringBuilder.replace(13, "\\r");
            stringBuilder.replace(10, "\\n");
            stringBuilder.replace(9, "\\t");
            int ordinal = ordinal();
            if (ordinal != 1) {
                if (ordinal == 2) {
                    if (!str.contains("//") && !str.contains("/*") && minimalNamePattern.matcher(stringBuilder).matches()) {
                        return stringBuilder.toString();
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(StringEscapeUtils.CSV_QUOTE);
                stringBuilder.replace(StringEscapeUtils.CSV_QUOTE, "\\\"");
                sb.append(stringBuilder.toString());
                sb.append(StringEscapeUtils.CSV_QUOTE);
                return sb.toString();
            }
            if (javascriptPattern.matcher(stringBuilder).matches()) {
                return stringBuilder.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(StringEscapeUtils.CSV_QUOTE);
            stringBuilder.replace(StringEscapeUtils.CSV_QUOTE, "\\\"");
            sb2.append(stringBuilder.toString());
            sb2.append(StringEscapeUtils.CSV_QUOTE);
            return sb2.toString();
        }

        public String quoteValue(Object obj) {
            if (obj == null) {
                return "null";
            }
            String obj2 = obj.toString();
            if ((obj instanceof Number) || (obj instanceof Boolean)) {
                return obj2;
            }
            StringBuilder stringBuilder = new StringBuilder(obj2);
            stringBuilder.replace('\\', "\\\\");
            stringBuilder.replace(13, "\\r");
            stringBuilder.replace(10, "\\n");
            stringBuilder.replace(9, "\\t");
            if (this == minimal && !obj2.equals(BaseParser.TRUE) && !obj2.equals(BaseParser.FALSE) && !obj2.equals("null") && !obj2.contains("//") && !obj2.contains("/*")) {
                int i = stringBuilder.length;
                if (i > 0 && stringBuilder.charAt(i - 1) != ' ' && minimalValuePattern.matcher(stringBuilder).matches()) {
                    return stringBuilder.toString();
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(StringEscapeUtils.CSV_QUOTE);
            stringBuilder.replace(StringEscapeUtils.CSV_QUOTE, "\\\"");
            sb.append(stringBuilder.toString());
            sb.append(StringEscapeUtils.CSV_QUOTE);
            return sb.toString();
        }
    }

    public JsonWriter(Writer writer2) {
        this.writer = writer2;
    }

    public void close() throws IOException {
        while (this.stack.size > 0) {
            pop();
        }
        this.writer.close();
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public JsonWriter name(String str) throws IOException {
        JsonObject jsonObject = this.current;
        if (jsonObject == null || jsonObject.array) {
            throw new IllegalStateException("Current item must be an object.");
        }
        if (!jsonObject.needsComma) {
            jsonObject.needsComma = true;
        } else {
            this.writer.write(44);
        }
        this.writer.write(this.outputType.quoteName(str));
        this.writer.write(58);
        this.named = true;
        return this;
    }

    public JsonWriter pop() throws IOException {
        if (!this.named) {
            JsonObject jsonObject = (JsonObject) this.stack.pop();
            JsonWriter.this.writer.write(jsonObject.array ? 93 : 125);
            Array<JsonObject> array = this.stack;
            this.current = array.size == 0 ? null : (JsonObject) array.peek();
            return this;
        }
        throw new IllegalStateException("Expected an object, array, or value since a name was set.");
    }

    public final void requireCommaOrName() throws IOException {
        JsonObject jsonObject = this.current;
        if (jsonObject != null) {
            if (jsonObject.array) {
                if (!jsonObject.needsComma) {
                    jsonObject.needsComma = true;
                } else {
                    this.writer.write(44);
                }
            } else if (this.named) {
                this.named = false;
            } else {
                throw new IllegalStateException("Name must be set.");
            }
        }
    }

    public JsonWriter value(Object obj) throws IOException {
        if (this.quoteLongValues && ((obj instanceof Long) || (obj instanceof Double) || (obj instanceof BigDecimal) || (obj instanceof BigInteger))) {
            obj = obj.toString();
        } else if (obj instanceof Number) {
            Number number = (Number) obj;
            long longValue = number.longValue();
            if (number.doubleValue() == ((double) longValue)) {
                obj = Long.valueOf(longValue);
            }
        }
        requireCommaOrName();
        this.writer.write(this.outputType.quoteValue(obj));
        return this;
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        this.writer.write(cArr, i, i2);
    }
}
