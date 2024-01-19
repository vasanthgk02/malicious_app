package io.hansel.core.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public class CoreJSONTokener {

    /* renamed from: in  reason: collision with root package name */
    public final String f5172in;
    public int pos;

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r2 = r2.substring(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CoreJSONTokener(java.lang.String r2) {
        /*
            r1 = this;
            r1.<init>()
            if (r2 == 0) goto L_0x0013
            java.lang.String r0 = "﻿"
            boolean r0 = r2.startsWith(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 1
            java.lang.String r2 = r2.substring(r0)
        L_0x0013:
            r1.f5172in = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.json.CoreJSONTokener.<init>(java.lang.String):void");
    }

    public static int dehexchar(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'A';
        if (c2 < 'A' || c2 > 'F') {
            c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    private int nextCleanInternal() {
        int length = this.f5172in.length();
        while (true) {
            int i = this.pos;
            if (i >= length) {
                return -1;
            }
            String str = this.f5172in;
            this.pos = i + 1;
            char charAt = str.charAt(i);
            if (!(charAt == 9 || charAt == 10 || charAt == 13 || charAt == ' ')) {
                if (charAt != '#') {
                    if (charAt != '/' || this.pos == this.f5172in.length()) {
                        return charAt;
                    }
                    char charAt2 = this.f5172in.charAt(this.pos);
                    if (charAt2 == '*') {
                        int i2 = this.pos + 1;
                        this.pos = i2;
                        int indexOf = this.f5172in.indexOf("*/", i2);
                        if (indexOf != -1) {
                            this.pos = indexOf + 2;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (charAt2 != '/') {
                        return charAt;
                    } else {
                        this.pos++;
                    }
                }
                skipToEndOfLine();
            }
        }
    }

    private String nextToInternal(String str) {
        int i = this.pos;
        int length = this.f5172in.length();
        while (true) {
            int i2 = this.pos;
            if (i2 >= length) {
                return this.f5172in.substring(i);
            }
            char charAt = this.f5172in.charAt(i2);
            if (charAt != 13 && charAt != 10 && str.indexOf(charAt) == -1) {
                this.pos++;
            }
        }
        return this.f5172in.substring(i, this.pos);
    }

    private CoreJSONArray readArray() {
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        boolean z = false;
        while (true) {
            int nextCleanInternal = nextCleanInternal();
            if (nextCleanInternal != -1) {
                if (nextCleanInternal == 44 || nextCleanInternal == 59) {
                    coreJSONArray.put((Object) null);
                } else if (nextCleanInternal != 93) {
                    this.pos--;
                    coreJSONArray.put(nextValue());
                    int nextCleanInternal2 = nextCleanInternal();
                    if (!(nextCleanInternal2 == 44 || nextCleanInternal2 == 59)) {
                        if (nextCleanInternal2 == 93) {
                            return coreJSONArray;
                        }
                        throw syntaxError("Unterminated array");
                    }
                } else {
                    if (z) {
                        coreJSONArray.put((Object) null);
                    }
                    return coreJSONArray;
                }
                z = true;
            } else {
                throw syntaxError("Unterminated array");
            }
        }
    }

    private char readEscapeCharacter() {
        String str = this.f5172in;
        int i = this.pos;
        this.pos = i + 1;
        char charAt = str.charAt(i);
        if (charAt == 'b') {
            return 8;
        }
        if (charAt == 'f') {
            return Tokenizer.FF;
        }
        if (charAt == 'n') {
            return 10;
        }
        if (charAt == 'r') {
            return 13;
        }
        if (charAt == 't') {
            return 9;
        }
        if (charAt != 'u') {
            return charAt;
        }
        if (this.pos + 4 <= this.f5172in.length()) {
            String str2 = this.f5172in;
            int i2 = this.pos;
            String substring = str2.substring(i2, i2 + 4);
            this.pos += 4;
            try {
                return (char) Integer.parseInt(substring, 16);
            } catch (NumberFormatException unused) {
                throw syntaxError("Invalid escape sequence: " + substring);
            }
        } else {
            throw syntaxError("Unterminated escape sequence");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|(7:16|(1:26)(2:20|(1:25)(1:24))|27|28|(1:32)|33|34)|35|36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008f, code lost:
        return new java.lang.String(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0085 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object readLiteral() {
        /*
            r6 = this;
            java.lang.String r0 = "{}[]/\\:,=;# \t\f"
            java.lang.String r0 = r6.nextToInternal(r0)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0090
            java.lang.String r1 = "null"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x0018
            java.lang.Object r0 = io.hansel.core.json.CoreJSONObject.NULL
            return r0
        L_0x0018:
            java.lang.String r1 = "true"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x0024
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x0024:
            java.lang.String r1 = "false"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x002f
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            return r0
        L_0x002f:
            r1 = 46
            int r1 = r0.indexOf(r1)
            r2 = -1
            if (r1 != r2) goto L_0x0085
            r1 = 10
            java.lang.String r2 = "0x"
            boolean r2 = r0.startsWith(r2)
            if (r2 != 0) goto L_0x0065
            java.lang.String r2 = "0X"
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L_0x004b
            goto L_0x0065
        L_0x004b:
            java.lang.String r2 = "0"
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L_0x0061
            int r2 = r0.length()
            r3 = 1
            if (r2 <= r3) goto L_0x0061
            java.lang.String r1 = r0.substring(r3)
            r2 = 8
            goto L_0x006c
        L_0x0061:
            r1 = r0
            r2 = 10
            goto L_0x006c
        L_0x0065:
            r1 = 2
            java.lang.String r1 = r0.substring(r1)
            r2 = 16
        L_0x006c:
            long r1 = java.lang.Long.parseLong(r1, r2)     // Catch:{ NumberFormatException -> 0x0085 }
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0080
            r3 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0080
            int r2 = (int) r1     // Catch:{ NumberFormatException -> 0x0085 }
            long r1 = (long) r2     // Catch:{ NumberFormatException -> 0x0085 }
        L_0x0080:
            java.lang.Long r0 = java.lang.Long.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0085 }
            return r0
        L_0x0085:
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ NumberFormatException -> 0x008a }
            return r0
        L_0x008a:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            return r1
        L_0x0090:
            java.lang.String r0 = "Expected literal value"
            io.hansel.core.json.CoreJSONException r0 = r6.syntaxError(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.json.CoreJSONTokener.readLiteral():java.lang.Object");
    }

    private CoreJSONObject readObject() {
        CoreJSONObject coreJSONObject = new CoreJSONObject();
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == 125) {
            return coreJSONObject;
        }
        if (nextCleanInternal != -1) {
            this.pos--;
        }
        while (true) {
            Object nextValue = nextValue();
            if (nextValue instanceof String) {
                int nextCleanInternal2 = nextCleanInternal();
                if (nextCleanInternal2 == 58 || nextCleanInternal2 == 61) {
                    if (this.pos < this.f5172in.length() && this.f5172in.charAt(this.pos) == '>') {
                        this.pos++;
                    }
                    coreJSONObject.put((String) nextValue, nextValue());
                    int nextCleanInternal3 = nextCleanInternal();
                    if (nextCleanInternal3 != 44 && nextCleanInternal3 != 59) {
                        if (nextCleanInternal3 == 125) {
                            return coreJSONObject;
                        }
                        throw syntaxError("Unterminated object");
                    }
                } else {
                    throw syntaxError("Expected ':' after " + nextValue);
                }
            } else if (nextValue == null) {
                throw syntaxError("Names cannot be null");
            } else {
                throw syntaxError("Names must be strings, but " + nextValue + " is of type " + nextValue.getClass().getName());
            }
        }
    }

    private void skipToEndOfLine() {
        int length = this.f5172in.length();
        while (true) {
            int i = this.pos;
            if (i < length) {
                char charAt = this.f5172in.charAt(i);
                if (charAt == 13 || charAt == 10) {
                    this.pos++;
                } else {
                    this.pos++;
                }
            } else {
                return;
            }
        }
        this.pos++;
    }

    public void back() {
        int i = this.pos - 1;
        this.pos = i;
        if (i == -1) {
            this.pos = 0;
        }
    }

    public boolean more() {
        return this.pos < this.f5172in.length();
    }

    public char next() {
        if (this.pos >= this.f5172in.length()) {
            return 0;
        }
        String str = this.f5172in;
        int i = this.pos;
        this.pos = i + 1;
        return str.charAt(i);
    }

    public char next(char c2) {
        char next = next();
        if (next == c2) {
            return next;
        }
        throw syntaxError("Expected " + c2 + " but was " + next);
    }

    public String next(int i) {
        if (this.pos + i <= this.f5172in.length()) {
            String str = this.f5172in;
            int i2 = this.pos;
            String substring = str.substring(i2, i2 + i);
            this.pos += i;
            return substring;
        }
        throw syntaxError(i + " is out of bounds");
    }

    public char nextClean() {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            return 0;
        }
        return (char) nextCleanInternal;
    }

    public String nextString(char c2) {
        int i = this.pos;
        int length = this.f5172in.length();
        StringBuilder sb = null;
        while (true) {
            int i2 = this.pos;
            if (i2 < length) {
                String str = this.f5172in;
                this.pos = i2 + 1;
                char charAt = str.charAt(i2);
                if (charAt == c2) {
                    if (sb == null) {
                        return new String(this.f5172in.substring(i, this.pos - 1));
                    }
                    sb.append(this.f5172in, i, this.pos - 1);
                    return sb.toString();
                } else if (charAt == '\\') {
                    if (this.pos != this.f5172in.length()) {
                        if (sb == null) {
                            sb = new StringBuilder();
                        }
                        sb.append(this.f5172in, i, this.pos - 1);
                        sb.append(readEscapeCharacter());
                        i = this.pos;
                    } else {
                        throw syntaxError("Unterminated escape sequence");
                    }
                }
            } else {
                throw syntaxError("Unterminated string");
            }
        }
    }

    public String nextTo(char c2) {
        return nextToInternal(String.valueOf(c2)).trim();
    }

    public String nextTo(String str) {
        if (str != null) {
            return nextToInternal(str).trim();
        }
        throw new NullPointerException("excluded == null");
    }

    public Object nextValue() {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            throw syntaxError("End of input");
        } else if (nextCleanInternal == 34 || nextCleanInternal == 39) {
            return nextString((char) nextCleanInternal);
        } else {
            if (nextCleanInternal == 91) {
                return readArray();
            }
            if (nextCleanInternal == 123) {
                return readObject();
            }
            this.pos--;
            return readLiteral();
        }
    }

    public void skipPast(String str) {
        int indexOf = this.f5172in.indexOf(str, this.pos);
        this.pos = indexOf == -1 ? this.f5172in.length() : str.length() + indexOf;
    }

    public char skipTo(char c2) {
        int indexOf = this.f5172in.indexOf(c2, this.pos);
        if (indexOf == -1) {
            return 0;
        }
        this.pos = indexOf;
        return c2;
    }

    public CoreJSONException syntaxError(String str) {
        return new CoreJSONException(str + this);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" at character ");
        outline73.append(this.pos);
        outline73.append(" of ");
        outline73.append(this.f5172in);
        return outline73.toString();
    }
}
