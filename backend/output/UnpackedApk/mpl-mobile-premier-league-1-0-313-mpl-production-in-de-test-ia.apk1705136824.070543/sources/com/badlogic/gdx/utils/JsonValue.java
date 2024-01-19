package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.JsonWriter.OutputType;
import java.util.Iterator;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;

public class JsonValue implements Iterable<JsonValue> {
    public JsonValue child;
    public double doubleValue;
    public long longValue;
    public String name;
    public JsonValue next;
    public JsonValue parent;
    public JsonValue prev;
    public int size;
    public String stringValue;
    public ValueType type;

    public class JsonIterator implements Iterator<JsonValue>, Iterable<JsonValue> {
        public JsonValue current;
        public JsonValue entry = JsonValue.this.child;

        public JsonIterator() {
        }

        public boolean hasNext() {
            return this.entry != null;
        }

        public Iterator<JsonValue> iterator() {
            return this;
        }

        public Object next() {
            JsonValue jsonValue = this.entry;
            this.current = jsonValue;
            if (jsonValue != null) {
                this.entry = jsonValue.next;
                return jsonValue;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            JsonValue jsonValue = this.current;
            JsonValue jsonValue2 = jsonValue.prev;
            if (jsonValue2 == null) {
                JsonValue jsonValue3 = JsonValue.this;
                JsonValue jsonValue4 = jsonValue.next;
                jsonValue3.child = jsonValue4;
                if (jsonValue4 != null) {
                    jsonValue4.prev = null;
                }
            } else {
                jsonValue2.next = jsonValue.next;
                JsonValue jsonValue5 = jsonValue.next;
                if (jsonValue5 != null) {
                    jsonValue5.prev = jsonValue2;
                }
            }
            JsonValue jsonValue6 = JsonValue.this;
            jsonValue6.size--;
        }
    }

    public static class PrettyPrintSettings {
        public OutputType outputType;
        public int singleLineColumns;
        public boolean wrapNumericArrays;
    }

    public enum ValueType {
        object,
        array,
        stringValue,
        doubleValue,
        longValue,
        booleanValue,
        nullValue
    }

    public JsonValue(ValueType valueType) {
        this.type = valueType;
    }

    public static void indent(int i, StringBuilder stringBuilder) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append0(9);
        }
    }

    public static boolean isFlat(JsonValue jsonValue) {
        for (JsonValue jsonValue2 = jsonValue.child; jsonValue2 != null; jsonValue2 = jsonValue2.next) {
            if (jsonValue2.isObject() || jsonValue2.isArray()) {
                return false;
            }
        }
        return true;
    }

    public boolean asBoolean() {
        int ordinal = this.type.ordinal();
        if (ordinal == 2) {
            return this.stringValue.equalsIgnoreCase(BaseParser.TRUE);
        }
        boolean z = true;
        if (ordinal == 3) {
            if (this.doubleValue == 0.0d) {
                z = false;
            }
            return z;
        } else if (ordinal == 4) {
            if (this.longValue == 0) {
                z = false;
            }
            return z;
        } else if (ordinal == 5) {
            if (this.longValue == 0) {
                z = false;
            }
            return z;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value cannot be converted to boolean: ");
            outline73.append(this.type);
            throw new IllegalStateException(outline73.toString());
        }
    }

    public byte asByte() {
        int ordinal = this.type.ordinal();
        if (ordinal == 2) {
            return Byte.parseByte(this.stringValue);
        }
        if (ordinal == 3) {
            return (byte) ((int) this.doubleValue);
        }
        if (ordinal == 4) {
            return (byte) ((int) this.longValue);
        }
        if (ordinal == 5) {
            return this.longValue != 0 ? (byte) 1 : 0;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value cannot be converted to byte: ");
        outline73.append(this.type);
        throw new IllegalStateException(outline73.toString());
    }

    public double asDouble() {
        int ordinal = this.type.ordinal();
        if (ordinal == 2) {
            return Double.parseDouble(this.stringValue);
        }
        if (ordinal == 3) {
            return this.doubleValue;
        }
        if (ordinal == 4) {
            return (double) this.longValue;
        }
        if (ordinal == 5) {
            return this.longValue != 0 ? 1.0d : 0.0d;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value cannot be converted to double: ");
        outline73.append(this.type);
        throw new IllegalStateException(outline73.toString());
    }

    public float asFloat() {
        int ordinal = this.type.ordinal();
        if (ordinal == 2) {
            return Float.parseFloat(this.stringValue);
        }
        if (ordinal == 3) {
            return (float) this.doubleValue;
        }
        if (ordinal == 4) {
            return (float) this.longValue;
        }
        if (ordinal == 5) {
            return this.longValue != 0 ? 1.0f : 0.0f;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value cannot be converted to float: ");
        outline73.append(this.type);
        throw new IllegalStateException(outline73.toString());
    }

    public int asInt() {
        int ordinal = this.type.ordinal();
        if (ordinal == 2) {
            return Integer.parseInt(this.stringValue);
        }
        if (ordinal == 3) {
            return (int) this.doubleValue;
        }
        if (ordinal == 4) {
            return (int) this.longValue;
        }
        if (ordinal == 5) {
            return this.longValue != 0 ? 1 : 0;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value cannot be converted to int: ");
        outline73.append(this.type);
        throw new IllegalStateException(outline73.toString());
    }

    public long asLong() {
        int ordinal = this.type.ordinal();
        if (ordinal == 2) {
            return Long.parseLong(this.stringValue);
        }
        if (ordinal == 3) {
            return (long) this.doubleValue;
        }
        if (ordinal == 4) {
            return this.longValue;
        }
        if (ordinal == 5) {
            long j = 0;
            if (this.longValue != 0) {
                j = 1;
            }
            return j;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value cannot be converted to long: ");
        outline73.append(this.type);
        throw new IllegalStateException(outline73.toString());
    }

    public short asShort() {
        int ordinal = this.type.ordinal();
        if (ordinal == 2) {
            return Short.parseShort(this.stringValue);
        }
        if (ordinal == 3) {
            return (short) ((int) this.doubleValue);
        }
        if (ordinal == 4) {
            return (short) ((int) this.longValue);
        }
        if (ordinal == 5) {
            return this.longValue != 0 ? (short) 1 : 0;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value cannot be converted to short: ");
        outline73.append(this.type);
        throw new IllegalStateException(outline73.toString());
    }

    public String asString() {
        int ordinal = this.type.ordinal();
        if (ordinal == 2) {
            return this.stringValue;
        }
        if (ordinal == 3) {
            String str = this.stringValue;
            if (str == null) {
                str = Double.toString(this.doubleValue);
            }
            return str;
        } else if (ordinal == 4) {
            String str2 = this.stringValue;
            if (str2 == null) {
                str2 = Long.toString(this.longValue);
            }
            return str2;
        } else if (ordinal == 5) {
            return this.longValue != 0 ? BaseParser.TRUE : BaseParser.FALSE;
        } else if (ordinal == 6) {
            return null;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value cannot be converted to string: ");
            outline73.append(this.type);
            throw new IllegalStateException(outline73.toString());
        }
    }

    public JsonValue get(String str) {
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            String str2 = jsonValue.name;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                break;
            }
            jsonValue = jsonValue.next;
        }
        return jsonValue;
    }

    public float getFloat(int i) {
        JsonValue jsonValue = this.child;
        while (jsonValue != null && i > 0) {
            i--;
            jsonValue = jsonValue.next;
        }
        if (jsonValue != null) {
            return jsonValue.asFloat();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Indexed value not found: ");
        outline73.append(this.name);
        throw new IllegalArgumentException(outline73.toString());
    }

    public short getShort(int i) {
        JsonValue jsonValue = this.child;
        while (jsonValue != null && i > 0) {
            i--;
            jsonValue = jsonValue.next;
        }
        if (jsonValue != null) {
            return jsonValue.asShort();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Indexed value not found: ");
        outline73.append(this.name);
        throw new IllegalArgumentException(outline73.toString());
    }

    public String getString(String str, String str2) {
        JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue() || jsonValue.isNull()) ? str2 : jsonValue.asString();
    }

    public boolean isArray() {
        return this.type == ValueType.array;
    }

    public boolean isNull() {
        return this.type == ValueType.nullValue;
    }

    public boolean isObject() {
        return this.type == ValueType.object;
    }

    public boolean isValue() {
        int ordinal = this.type.ordinal();
        return ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5 || ordinal == 6;
    }

    public Iterator iterator() {
        return new JsonIterator();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b1, code lost:
        if (r7 == false) goto L_0x00b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void prettyPrint(com.badlogic.gdx.utils.JsonValue r12, com.badlogic.gdx.utils.StringBuilder r13, int r14, com.badlogic.gdx.utils.JsonValue.PrettyPrintSettings r15) {
        /*
            r11 = this;
            com.badlogic.gdx.utils.JsonWriter$OutputType r0 = r15.outputType
            boolean r1 = r12.isObject()
            r2 = 10
            r3 = 32
            r4 = 1
            r5 = 44
            if (r1 == 0) goto L_0x007c
            com.badlogic.gdx.utils.JsonValue r1 = r12.child
            if (r1 != 0) goto L_0x001a
            java.lang.String r12 = "{}"
            r13.append0(r12)
            goto L_0x02f1
        L_0x001a:
            boolean r1 = isFlat(r12)
            r1 = r1 ^ r4
            int r6 = r13.length
        L_0x0021:
            if (r1 == 0) goto L_0x0026
            java.lang.String r7 = "{\n"
            goto L_0x0028
        L_0x0026:
            java.lang.String r7 = "{ "
        L_0x0028:
            r13.append0(r7)
            com.badlogic.gdx.utils.JsonValue r7 = r12.child
        L_0x002d:
            if (r7 == 0) goto L_0x006f
            if (r1 == 0) goto L_0x0034
            indent(r14, r13)
        L_0x0034:
            java.lang.String r8 = r7.name
            java.lang.String r8 = r0.quoteName(r8)
            r13.append0(r8)
            java.lang.String r8 = ": "
            r13.append0(r8)
            int r8 = r14 + 1
            r11.prettyPrint(r7, r13, r8, r15)
            if (r1 == 0) goto L_0x004d
            com.badlogic.gdx.utils.JsonWriter$OutputType r8 = com.badlogic.gdx.utils.JsonWriter.OutputType.minimal
            if (r0 == r8) goto L_0x0054
        L_0x004d:
            com.badlogic.gdx.utils.JsonValue r8 = r7.next
            if (r8 == 0) goto L_0x0054
            r13.append0(r5)
        L_0x0054:
            if (r1 == 0) goto L_0x0059
            r8 = 10
            goto L_0x005b
        L_0x0059:
            r8 = 32
        L_0x005b:
            r13.append0(r8)
            if (r1 != 0) goto L_0x006c
            int r8 = r13.length
            int r8 = r8 - r6
            int r9 = r15.singleLineColumns
            if (r8 <= r9) goto L_0x006c
            r13.setLength(r6)
            r1 = 1
            goto L_0x0021
        L_0x006c:
            com.badlogic.gdx.utils.JsonValue r7 = r7.next
            goto L_0x002d
        L_0x006f:
            if (r1 == 0) goto L_0x0075
            int r14 = r14 - r4
            indent(r14, r13)
        L_0x0075:
            r12 = 125(0x7d, float:1.75E-43)
            r13.append0(r12)
            goto L_0x02f1
        L_0x007c:
            boolean r1 = r12.isArray()
            r6 = 0
            if (r1 == 0) goto L_0x0105
            com.badlogic.gdx.utils.JsonValue r1 = r12.child
            if (r1 != 0) goto L_0x008e
            java.lang.String r12 = "[]"
            r13.append0(r12)
            goto L_0x02f1
        L_0x008e:
            boolean r1 = isFlat(r12)
            r1 = r1 ^ r4
            boolean r7 = r15.wrapNumericArrays
            if (r7 != 0) goto L_0x00b3
            com.badlogic.gdx.utils.JsonValue r7 = r12.child
        L_0x0099:
            if (r7 == 0) goto L_0x00b0
            com.badlogic.gdx.utils.JsonValue$ValueType r8 = r7.type
            com.badlogic.gdx.utils.JsonValue$ValueType r9 = com.badlogic.gdx.utils.JsonValue.ValueType.doubleValue
            if (r8 == r9) goto L_0x00a8
            com.badlogic.gdx.utils.JsonValue$ValueType r9 = com.badlogic.gdx.utils.JsonValue.ValueType.longValue
            if (r8 != r9) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r8 = 0
            goto L_0x00a9
        L_0x00a8:
            r8 = 1
        L_0x00a9:
            if (r8 != 0) goto L_0x00ad
            r7 = 0
            goto L_0x00b1
        L_0x00ad:
            com.badlogic.gdx.utils.JsonValue r7 = r7.next
            goto L_0x0099
        L_0x00b0:
            r7 = 1
        L_0x00b1:
            if (r7 != 0) goto L_0x00b4
        L_0x00b3:
            r6 = 1
        L_0x00b4:
            int r7 = r13.length
        L_0x00b6:
            if (r1 == 0) goto L_0x00bb
            java.lang.String r8 = "[\n"
            goto L_0x00bd
        L_0x00bb:
            java.lang.String r8 = "[ "
        L_0x00bd:
            r13.append0(r8)
            com.badlogic.gdx.utils.JsonValue r8 = r12.child
        L_0x00c2:
            if (r8 == 0) goto L_0x00f8
            if (r1 == 0) goto L_0x00c9
            indent(r14, r13)
        L_0x00c9:
            int r9 = r14 + 1
            r11.prettyPrint(r8, r13, r9, r15)
            if (r1 == 0) goto L_0x00d4
            com.badlogic.gdx.utils.JsonWriter$OutputType r9 = com.badlogic.gdx.utils.JsonWriter.OutputType.minimal
            if (r0 == r9) goto L_0x00db
        L_0x00d4:
            com.badlogic.gdx.utils.JsonValue r9 = r8.next
            if (r9 == 0) goto L_0x00db
            r13.append0(r5)
        L_0x00db:
            if (r1 == 0) goto L_0x00e0
            r9 = 10
            goto L_0x00e2
        L_0x00e0:
            r9 = 32
        L_0x00e2:
            r13.append0(r9)
            if (r6 == 0) goto L_0x00f5
            if (r1 != 0) goto L_0x00f5
            int r9 = r13.length
            int r9 = r9 - r7
            int r10 = r15.singleLineColumns
            if (r9 <= r10) goto L_0x00f5
            r13.setLength(r7)
            r1 = 1
            goto L_0x00b6
        L_0x00f5:
            com.badlogic.gdx.utils.JsonValue r8 = r8.next
            goto L_0x00c2
        L_0x00f8:
            if (r1 == 0) goto L_0x00fe
            int r14 = r14 - r4
            indent(r14, r13)
        L_0x00fe:
            r12 = 93
            r13.append0(r12)
            goto L_0x02f1
        L_0x0105:
            com.badlogic.gdx.utils.JsonValue$ValueType r14 = r12.type
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = com.badlogic.gdx.utils.JsonValue.ValueType.stringValue
            if (r14 != r15) goto L_0x010d
            r14 = 1
            goto L_0x010e
        L_0x010d:
            r14 = 0
        L_0x010e:
            if (r14 == 0) goto L_0x011d
            java.lang.String r12 = r12.asString()
            java.lang.String r12 = r0.quoteValue(r12)
            r13.append0(r12)
            goto L_0x02f1
        L_0x011d:
            com.badlogic.gdx.utils.JsonValue$ValueType r14 = r12.type
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = com.badlogic.gdx.utils.JsonValue.ValueType.doubleValue
            if (r14 != r15) goto L_0x0125
            r14 = 1
            goto L_0x0126
        L_0x0125:
            r14 = 0
        L_0x0126:
            if (r14 == 0) goto L_0x013f
            double r14 = r12.asDouble()
            long r0 = r12.asLong()
            double r0 = (double) r0
            int r12 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r12 != 0) goto L_0x0136
            r14 = r0
        L_0x0136:
            java.lang.String r12 = java.lang.Double.toString(r14)
            r13.append0(r12)
            goto L_0x02f1
        L_0x013f:
            com.badlogic.gdx.utils.JsonValue$ValueType r14 = r12.type
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = com.badlogic.gdx.utils.JsonValue.ValueType.longValue
            if (r14 != r15) goto L_0x0147
            r14 = 1
            goto L_0x0148
        L_0x0147:
            r14 = 0
        L_0x0148:
            if (r14 == 0) goto L_0x02cd
            long r14 = r12.asLong()
            r0 = -9223372036854775808
            int r12 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r12 != 0) goto L_0x015b
            java.lang.String r12 = "-9223372036854775808"
            r13.append0(r12)
            goto L_0x02f1
        L_0x015b:
            r0 = 0
            int r12 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r12 >= 0) goto L_0x0167
            r12 = 45
            r13.append0(r12)
            long r14 = -r14
        L_0x0167:
            r0 = 10000(0x2710, double:4.9407E-320)
            int r12 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r12 < 0) goto L_0x0290
            r2 = 1000000000000000000(0xde0b6b3a7640000, double:7.832953389245686E-242)
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x018b
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            double r4 = (double) r14
            r6 = 4891288408196988160(0x43e158e460913d00, double:1.0E19)
            double r4 = r4 % r6
            r6 = 4876203697187506176(0x43abc16d674ec800, double:1.0E18)
            double r4 = r4 / r6
            int r4 = (int) r4
            char r12 = r12[r4]
            r13.append0(r12)
        L_0x018b:
            r4 = 100000000000000000(0x16345785d8a0000, double:5.620395787888205E-302)
            int r12 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x019f
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r2 = r14 % r2
            long r2 = r2 / r4
            int r3 = (int) r2
            char r12 = r12[r3]
            r13.append0(r12)
        L_0x019f:
            r2 = 10000000000000000(0x2386f26fc10000, double:5.431165199810528E-308)
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x01b3
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r4 = r14 % r4
            long r4 = r4 / r2
            int r5 = (int) r4
            char r12 = r12[r5]
            r13.append0(r12)
        L_0x01b3:
            r4 = 1000000000000000(0x38d7ea4c68000, double:4.940656458412465E-309)
            int r12 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x01c7
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r2 = r14 % r2
            long r2 = r2 / r4
            int r3 = (int) r2
            char r12 = r12[r3]
            r13.append0(r12)
        L_0x01c7:
            r2 = 100000000000000(0x5af3107a4000, double:4.94065645841247E-310)
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x01db
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r4 = r14 % r4
            long r4 = r4 / r2
            int r5 = (int) r4
            char r12 = r12[r5]
            r13.append0(r12)
        L_0x01db:
            r4 = 10000000000000(0x9184e72a000, double:4.9406564584125E-311)
            int r12 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x01ef
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r2 = r14 % r2
            long r2 = r2 / r4
            int r3 = (int) r2
            char r12 = r12[r3]
            r13.append0(r12)
        L_0x01ef:
            r2 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x0203
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r4 = r14 % r4
            long r4 = r4 / r2
            int r5 = (int) r4
            char r12 = r12[r5]
            r13.append0(r12)
        L_0x0203:
            r4 = 100000000000(0x174876e800, double:4.9406564584E-313)
            int r12 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x0217
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r2 = r14 % r2
            long r2 = r2 / r4
            int r3 = (int) r2
            char r12 = r12[r3]
            r13.append0(r12)
        L_0x0217:
            r2 = 10000000000(0x2540be400, double:4.9406564584E-314)
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x022b
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r4 = r14 % r4
            long r4 = r4 / r2
            int r5 = (int) r4
            char r12 = r12[r5]
            r13.append0(r12)
        L_0x022b:
            r4 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            int r12 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x023d
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r2 = r14 % r2
            long r2 = r2 / r4
            int r3 = (int) r2
            char r12 = r12[r3]
            r13.append0(r12)
        L_0x023d:
            r2 = 100000000(0x5f5e100, double:4.94065646E-316)
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x024f
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r4 = r14 % r4
            long r4 = r4 / r2
            int r5 = (int) r4
            char r12 = r12[r5]
            r13.append0(r12)
        L_0x024f:
            r4 = 10000000(0x989680, double:4.9406565E-317)
            int r12 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x0261
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r2 = r14 % r2
            long r2 = r2 / r4
            int r3 = (int) r2
            char r12 = r12[r3]
            r13.append0(r12)
        L_0x0261:
            r2 = 1000000(0xf4240, double:4.940656E-318)
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x0273
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r4 = r14 % r4
            long r4 = r4 / r2
            int r5 = (int) r4
            char r12 = r12[r5]
            r13.append0(r12)
        L_0x0273:
            r4 = 100000(0x186a0, double:4.94066E-319)
            int r12 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x0285
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r2 = r14 % r2
            long r2 = r2 / r4
            int r3 = (int) r2
            char r12 = r12[r3]
            r13.append0(r12)
        L_0x0285:
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r2 = r14 % r4
            long r2 = r2 / r0
            int r3 = (int) r2
            char r12 = r12[r3]
            r13.append0(r12)
        L_0x0290:
            r2 = 1000(0x3e8, double:4.94E-321)
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x02a1
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r0 = r14 % r0
            long r0 = r0 / r2
            int r1 = (int) r0
            char r12 = r12[r1]
            r13.append0(r12)
        L_0x02a1:
            r0 = 100
            int r12 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r12 < 0) goto L_0x02b2
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r2 = r14 % r2
            long r2 = r2 / r0
            int r3 = (int) r2
            char r12 = r12[r3]
            r13.append0(r12)
        L_0x02b2:
            r2 = 10
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x02c3
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r0 = r14 % r0
            long r0 = r0 / r2
            int r1 = (int) r0
            char r12 = r12[r1]
            r13.append0(r12)
        L_0x02c3:
            char[] r12 = com.badlogic.gdx.utils.StringBuilder.digits
            long r14 = r14 % r2
            int r15 = (int) r14
            char r12 = r12[r15]
            r13.append0(r12)
            goto L_0x02f1
        L_0x02cd:
            com.badlogic.gdx.utils.JsonValue$ValueType r14 = r12.type
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = com.badlogic.gdx.utils.JsonValue.ValueType.booleanValue
            if (r14 != r15) goto L_0x02d4
            goto L_0x02d5
        L_0x02d4:
            r4 = 0
        L_0x02d5:
            if (r4 == 0) goto L_0x02e6
            boolean r12 = r12.asBoolean()
            if (r12 == 0) goto L_0x02e0
            java.lang.String r12 = "true"
            goto L_0x02e2
        L_0x02e0:
            java.lang.String r12 = "false"
        L_0x02e2:
            r13.append0(r12)
            goto L_0x02f1
        L_0x02e6:
            boolean r14 = r12.isNull()
            if (r14 == 0) goto L_0x02f2
            java.lang.String r12 = "null"
            r13.append0(r12)
        L_0x02f1:
            return
        L_0x02f2:
            com.badlogic.gdx.utils.SerializationException r13 = new com.badlogic.gdx.utils.SerializationException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Unknown object type: "
            r14.append(r15)
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            r13.<init>(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.JsonValue.prettyPrint(com.badlogic.gdx.utils.JsonValue, com.badlogic.gdx.utils.StringBuilder, int, com.badlogic.gdx.utils.JsonValue$PrettyPrintSettings):void");
    }

    public JsonValue require(String str) {
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            String str2 = jsonValue.name;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                break;
            }
            jsonValue = jsonValue.next;
        }
        if (jsonValue != null) {
            return jsonValue;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Child not found with name: ", str));
    }

    public String toString() {
        String str;
        if (isValue()) {
            if (this.name == null) {
                str = asString();
            } else {
                str = this.name + ": " + asString();
            }
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.name == null ? "" : GeneratedOutlineSupport.outline62(new StringBuilder(), this.name, ": "));
        OutputType outputType = OutputType.minimal;
        PrettyPrintSettings prettyPrintSettings = new PrettyPrintSettings();
        prettyPrintSettings.outputType = outputType;
        prettyPrintSettings.singleLineColumns = 0;
        StringBuilder stringBuilder = new StringBuilder(512);
        prettyPrint(this, stringBuilder, 0, prettyPrintSettings);
        sb.append(stringBuilder.toString());
        return sb.toString();
    }

    public String trace() {
        JsonValue jsonValue = this.parent;
        String str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        if (jsonValue == null) {
            ValueType valueType = this.type;
            if (valueType == ValueType.array) {
                return str;
            }
            return valueType == ValueType.object ? "{}" : "";
        }
        if (jsonValue.type == ValueType.array) {
            int i = 0;
            JsonValue jsonValue2 = jsonValue.child;
            while (true) {
                if (jsonValue2 == null) {
                    break;
                } else if (jsonValue2 == this) {
                    str = GeneratedOutlineSupport.outline42("[", i, CMapParser.MARK_END_OF_ARRAY);
                    break;
                } else {
                    jsonValue2 = jsonValue2.next;
                    i++;
                }
            }
        } else if (this.name.indexOf(46) != -1) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(".\"");
            outline73.append(this.name.replace("\"", "\\\""));
            outline73.append("\"");
            str = outline73.toString();
        } else {
            StringBuilder outline72 = GeneratedOutlineSupport.outline72('.');
            outline72.append(this.name);
            str = outline72.toString();
        }
        return this.parent.trace() + str;
    }

    public JsonValue(String str) {
        this.stringValue = str;
        this.type = str == null ? ValueType.nullValue : ValueType.stringValue;
    }

    public String getString(String str) {
        JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue.asString();
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Named value not found: ", str));
    }

    public float getFloat(String str, float f2) {
        JsonValue jsonValue = get(str);
        return (jsonValue == null || !jsonValue.isValue() || jsonValue.isNull()) ? f2 : jsonValue.asFloat();
    }

    public JsonValue(double d2, String str) {
        this.doubleValue = d2;
        this.longValue = (long) d2;
        this.stringValue = str;
        this.type = ValueType.doubleValue;
    }

    public JsonValue(long j, String str) {
        this.longValue = j;
        this.doubleValue = (double) j;
        this.stringValue = str;
        this.type = ValueType.longValue;
    }

    public JsonValue(boolean z) {
        this.longValue = z ? 1 : 0;
        this.type = ValueType.booleanValue;
    }
}
