package net.sf.json.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import net.sf.json.JSONException;

public class JSONTokener {
    public int myIndex = 0;
    public String mySource;

    public JSONTokener(String str) {
        String trim = str != null ? str.trim() : "";
        if (trim.length() > 0) {
            char charAt = trim.charAt(0);
            char charAt2 = trim.charAt(trim.length() - 1);
            if (charAt == '[' && charAt2 != ']') {
                throw syntaxError("Found starting '[' but missing ']' at the end.");
            } else if (charAt == '{' && charAt2 != '}') {
                throw syntaxError("Found starting '{' but missing '}' at the end.");
            }
        }
        this.mySource = trim;
    }

    public void back() {
        int i = this.myIndex;
        if (i > 0) {
            this.myIndex = i - 1;
        }
    }

    public char next() {
        if (!(this.myIndex < this.mySource.length())) {
            return 0;
        }
        char charAt = this.mySource.charAt(this.myIndex);
        this.myIndex++;
        return charAt;
    }

    public char nextClean() {
        char next;
        char next2;
        char next3;
        while (true) {
            next = next();
            if (next == '/') {
                char next4 = next();
                if (next4 != '*') {
                    if (next4 == '/') {
                        do {
                            next3 = next();
                            if (next3 == 10 || next3 == 13) {
                                break;
                            }
                        } while (next3 != 0);
                    } else {
                        back();
                        return '/';
                    }
                } else {
                    while (true) {
                        char next5 = next();
                        if (next5 == 0) {
                            throw syntaxError("Unclosed comment.");
                        } else if (next5 == '*') {
                            if (next() == '/') {
                                break;
                            }
                            back();
                        }
                    }
                }
            } else if (next == '#') {
                do {
                    next2 = next();
                    if (next2 == 10 || next2 == 13) {
                        break;
                    }
                } while (next2 != 0);
            } else if (next == 0 || next > ' ') {
                return next;
            }
        }
        return next;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:53|(2:62|63)(3:59|60|61))|64|65|66) */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r10 = r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x00ea */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object nextValue(net.sf.json.JsonConfig r10) {
        /*
            r9 = this;
            char r0 = r9.nextClean()
            r1 = 34
            r2 = 16
            r3 = 120(0x78, float:1.68E-43)
            r4 = 8
            r5 = 2
            if (r0 == r1) goto L_0x0109
            r1 = 39
            if (r0 == r1) goto L_0x0109
            r1 = 91
            if (r0 == r1) goto L_0x0101
            r6 = 123(0x7b, float:1.72E-43)
            if (r0 == r6) goto L_0x00f9
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            r7 = r0
        L_0x0021:
            r8 = 32
            if (r7 < r8) goto L_0x0035
            java.lang.String r8 = ",:]}/\\\"[{;=#"
            int r8 = r8.indexOf(r7)
            if (r8 >= 0) goto L_0x0035
            r10.append(r7)
            char r7 = r9.next()
            goto L_0x0021
        L_0x0035:
            r9.back()
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = r10.trim()
            java.lang.String r7 = ""
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x00f2
            java.lang.String r7 = "true"
            boolean r7 = r10.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0054
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            return r10
        L_0x0054:
            java.lang.String r7 = "false"
            boolean r7 = r10.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x005f
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            return r10
        L_0x005f:
            java.lang.String r7 = "null"
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x00ef
            r7 = 48
            if (r0 < r7) goto L_0x006f
            r8 = 57
            if (r0 <= r8) goto L_0x00bb
        L_0x006f:
            r8 = 46
            if (r0 == r8) goto L_0x00bb
            r8 = 45
            if (r0 == r8) goto L_0x00bb
            r8 = 43
            if (r0 != r8) goto L_0x007c
            goto L_0x00bb
        L_0x007c:
            boolean r0 = net.sf.json.util.JSONUtils.isFunctionHeader(r10)
            if (r0 != 0) goto L_0x00ba
            boolean r0 = net.sf.json.util.JSONUtils.isFunction(r10)
            if (r0 == 0) goto L_0x0089
            goto L_0x00ba
        L_0x0089:
            char r0 = r9.peek()
            r2 = 44
            if (r0 == r2) goto L_0x009e
            if (r0 == r1) goto L_0x009e
            r1 = 93
            if (r0 == r1) goto L_0x009e
            if (r0 == r6) goto L_0x009e
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 == r1) goto L_0x009e
            return r10
        L_0x009e:
            net.sf.json.JSONException r0 = new net.sf.json.JSONException
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = "Unquotted string '"
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = "'"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10)
            throw r0
        L_0x00ba:
            return r10
        L_0x00bb:
            if (r0 != r7) goto L_0x00ea
            int r0 = r10.length()
            if (r0 <= r5) goto L_0x00e0
            r0 = 1
            char r1 = r10.charAt(r0)
            if (r1 == r3) goto L_0x00d2
            char r0 = r10.charAt(r0)
            r1 = 88
            if (r0 != r1) goto L_0x00e0
        L_0x00d2:
            java.lang.Integer r0 = new java.lang.Integer     // Catch:{ Exception -> 0x00ea }
            java.lang.String r1 = r10.substring(r5)     // Catch:{ Exception -> 0x00ea }
            int r1 = java.lang.Integer.parseInt(r1, r2)     // Catch:{ Exception -> 0x00ea }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ea }
            return r0
        L_0x00e0:
            java.lang.Integer r0 = new java.lang.Integer     // Catch:{ Exception -> 0x00ea }
            int r1 = java.lang.Integer.parseInt(r10, r4)     // Catch:{ Exception -> 0x00ea }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ea }
            return r0
        L_0x00ea:
            java.lang.Number r10 = org.apache.commons.lang.math.NumberUtils.createNumber(r10)     // Catch:{ Exception -> 0x00ee }
        L_0x00ee:
            return r10
        L_0x00ef:
            net.sf.json.JSONNull r10 = net.sf.json.JSONNull.instance
            return r10
        L_0x00f2:
            java.lang.String r10 = "Missing value."
            net.sf.json.JSONException r10 = r9.syntaxError(r10)
            throw r10
        L_0x00f9:
            r9.back()
            net.sf.json.JSONObject r10 = net.sf.json.JSONObject.fromObject(r9, r10)
            return r10
        L_0x0101:
            r9.back()
            net.sf.json.JSONArray r10 = net.sf.json.JSONArray.fromObject(r9, r10)
            return r10
        L_0x0109:
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
        L_0x010e:
            char r1 = r9.next()
            if (r1 == 0) goto L_0x0180
            r6 = 10
            if (r1 == r6) goto L_0x0180
            r7 = 13
            if (r1 == r7) goto L_0x0180
            r8 = 92
            if (r1 == r8) goto L_0x012b
            if (r1 != r0) goto L_0x0127
            java.lang.String r10 = r10.toString()
            return r10
        L_0x0127:
            r10.append(r1)
            goto L_0x010e
        L_0x012b:
            char r1 = r9.next()
            r8 = 98
            if (r1 == r8) goto L_0x017c
            r8 = 102(0x66, float:1.43E-43)
            if (r1 == r8) goto L_0x0176
            r8 = 110(0x6e, float:1.54E-43)
            if (r1 == r8) goto L_0x0172
            r6 = 114(0x72, float:1.6E-43)
            if (r1 == r6) goto L_0x016e
            if (r1 == r3) goto L_0x0161
            r6 = 116(0x74, float:1.63E-43)
            if (r1 == r6) goto L_0x015b
            r6 = 117(0x75, float:1.64E-43)
            if (r1 == r6) goto L_0x014d
            r10.append(r1)
            goto L_0x010e
        L_0x014d:
            r1 = 4
            java.lang.String r1 = r9.next(r1)
            int r1 = java.lang.Integer.parseInt(r1, r2)
            char r1 = (char) r1
            r10.append(r1)
            goto L_0x010e
        L_0x015b:
            r1 = 9
            r10.append(r1)
            goto L_0x010e
        L_0x0161:
            java.lang.String r1 = r9.next(r5)
            int r1 = java.lang.Integer.parseInt(r1, r2)
            char r1 = (char) r1
            r10.append(r1)
            goto L_0x010e
        L_0x016e:
            r10.append(r7)
            goto L_0x010e
        L_0x0172:
            r10.append(r6)
            goto L_0x010e
        L_0x0176:
            r1 = 12
            r10.append(r1)
            goto L_0x010e
        L_0x017c:
            r10.append(r4)
            goto L_0x010e
        L_0x0180:
            java.lang.String r10 = "Unterminated string"
            net.sf.json.JSONException r10 = r9.syntaxError(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sf.json.util.JSONTokener.nextValue(net.sf.json.JsonConfig):java.lang.Object");
    }

    public char peek() {
        if (this.myIndex < this.mySource.length()) {
            return this.mySource.charAt(this.myIndex);
        }
        return 0;
    }

    public JSONException syntaxError(String str) {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71(str);
        outline71.append(toString());
        return new JSONException(outline71.toString());
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71(" at character ");
        outline71.append(this.myIndex);
        outline71.append(" of ");
        outline71.append(this.mySource);
        return outline71.toString();
    }

    public String next(int i) {
        int i2 = this.myIndex;
        int i3 = i2 + i;
        if (i3 < this.mySource.length()) {
            this.myIndex += i;
            return this.mySource.substring(i2, i3);
        }
        throw syntaxError("Substring bounds error");
    }
}
