package org.apache.commons.lang.text;

import in.juspay.hypersdk.core.InflateView;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    public char escapeChar;
    public StrMatcher prefixMatcher;
    public StrMatcher suffixMatcher;
    public StrLookup variableResolver;

    public StrSubstitutor() {
        this((StrLookup) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    private void checkCyclicSubstitution(String str, List list) {
        if (list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append((String) "Infinite loop in property interpolation of ");
            strBuilder.append(list.remove(0));
            strBuilder.append((String) ": ");
            strBuilder.appendWithSeparators((Collection) list, (String) InflateView.KEYWORD_SPLIT);
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    public static String replace(Object obj, Map map) {
        return new StrSubstitutor(map).replace(obj);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(obj);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrLookup getVariableResolver() {
        return this.variableResolver;
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public String resolveVariable(String str, StrBuilder strBuilder, int i, int i2) {
        StrLookup variableResolver2 = getVariableResolver();
        if (variableResolver2 == null) {
            return null;
        }
        return variableResolver2.lookup(str);
    }

    public void setEscapeChar(char c2) {
        this.escapeChar = c2;
    }

    public StrSubstitutor setVariablePrefix(char c2) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c2));
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.prefixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable prefix matcher must not be null!");
    }

    public void setVariableResolver(StrLookup strLookup) {
        this.variableResolver = strLookup;
    }

    public StrSubstitutor setVariableSuffix(char c2) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c2));
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.suffixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable suffix matcher must not be null!");
    }

    public boolean substitute(StrBuilder strBuilder, int i, int i2) {
        return substitute(strBuilder, i, i2, null) > 0;
    }

    public StrSubstitutor(Map map) {
        this(StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public static String replace(Object obj, Map map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    /* JADX WARNING: type inference failed for: r24v0, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r7v4, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r7v5, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v3
      assigns: []
      uses: []
      mth insns count: 83
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int substitute(org.apache.commons.lang.text.StrBuilder r21, int r22, int r23, java.util.List r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            org.apache.commons.lang.text.StrMatcher r4 = r20.getVariablePrefixMatcher()
            org.apache.commons.lang.text.StrMatcher r5 = r20.getVariableSuffixMatcher()
            char r6 = r20.getEscapeChar()
            r7 = 0
            if (r24 != 0) goto L_0x0019
            r9 = 1
            goto L_0x001a
        L_0x0019:
            r9 = 0
        L_0x001a:
            char[] r10 = r1.buffer
            int r11 = r2 + r3
            r7 = r24
            r14 = r2
            r12 = r10
            r13 = r11
            r10 = 0
            r11 = 0
        L_0x0025:
            if (r14 >= r13) goto L_0x00b3
            int r15 = r4.isMatch(r12, r14, r2, r13)
            if (r15 != 0) goto L_0x0036
            int r14 = r14 + 1
            r16 = r4
            r18 = r5
            r5 = 1
            goto L_0x00ad
        L_0x0036:
            if (r14 <= r2) goto L_0x004f
            int r8 = r14 + -1
            r16 = r4
            char r4 = r12[r8]
            if (r4 != r6) goto L_0x0051
            r1.deleteCharAt(r8)
            char[] r4 = r1.buffer
            int r10 = r10 + -1
            int r13 = r13 + -1
            r12 = r4
            r18 = r5
            r5 = 1
            r11 = 1
            goto L_0x00ad
        L_0x004f:
            r16 = r4
        L_0x0051:
            int r4 = r14 + r15
            r8 = r4
        L_0x0054:
            if (r8 >= r13) goto L_0x00a9
            int r17 = r5.isMatch(r12, r8, r2, r13)
            if (r17 != 0) goto L_0x005f
            int r8 = r8 + 1
            goto L_0x0054
        L_0x005f:
            r18 = r5
            java.lang.String r5 = new java.lang.String
            int r19 = r8 - r14
            int r15 = r19 - r15
            r5.<init>(r12, r4, r15)
            int r8 = r8 + r17
            if (r7 != 0) goto L_0x007b
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.lang.String r4 = new java.lang.String
            r4.<init>(r12, r2, r3)
            r7.add(r4)
        L_0x007b:
            r0.checkCyclicSubstitution(r5, r7)
            r7.add(r5)
            java.lang.String r4 = r0.resolveVariable(r5, r1, r14, r8)
            if (r4 == 0) goto L_0x009e
            int r5 = r4.length()
            r1.replace(r14, r8, r4)
            int r4 = r0.substitute(r1, r14, r5, r7)
            int r11 = r8 - r14
            int r5 = r5 - r11
            int r5 = r5 + r4
            int r8 = r8 + r5
            int r13 = r13 + r5
            int r10 = r10 + r5
            char[] r12 = r1.buffer
            r14 = r8
            r11 = 1
            goto L_0x009f
        L_0x009e:
            r14 = r8
        L_0x009f:
            int r4 = r7.size()
            r5 = 1
            int r4 = r4 - r5
            r7.remove(r4)
            goto L_0x00ad
        L_0x00a9:
            r18 = r5
            r5 = 1
            r14 = r8
        L_0x00ad:
            r4 = r16
            r5 = r18
            goto L_0x0025
        L_0x00b3:
            if (r9 == 0) goto L_0x00b6
            return r11
        L_0x00b6:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.text.StrSubstitutor.substitute(org.apache.commons.lang.text.StrBuilder, int, int, java.util.List):int");
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        if (!substitute(append, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, append.toString());
        return true;
    }

    public StrSubstitutor setVariablePrefix(String str) {
        if (str != null) {
            return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable prefix must not be null!");
    }

    public StrSubstitutor setVariableSuffix(String str) {
        if (str != null) {
            return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable suffix must not be null!");
    }

    public StrSubstitutor(Map map, String str, String str2) {
        this(StrLookup.mapLookup(map), str, str2, '$');
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        if (!substitute(strBuilder, 0, str.length())) {
            return str;
        }
        return strBuilder.toString();
    }

    public StrSubstitutor(Map map, String str, String str2, char c2) {
        this(StrLookup.mapLookup(map), str, str2, c2);
    }

    public StrSubstitutor(StrLookup strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    public StrSubstitutor(StrLookup strLookup, String str, String str2, char c2) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c2);
    }

    public String replace(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(str, i, i2);
        if (!substitute(append, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return append.toString();
    }

    public boolean replaceIn(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i, i2);
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        substitute(append, 0, cArr.length);
        return append.toString();
    }

    public StrSubstitutor(StrLookup strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c2) {
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c2);
    }

    public String replace(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(cArr, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(strBuilder, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        substitute(append, 0, append.length());
        return append.toString();
    }
}
