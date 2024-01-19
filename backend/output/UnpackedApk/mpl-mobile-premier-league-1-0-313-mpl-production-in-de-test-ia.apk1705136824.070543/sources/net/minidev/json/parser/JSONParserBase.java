package net.minidev.json.parser;

import com.badlogic.gdx.graphics.GL20;
import java.io.IOException;
import java.math.BigDecimal;
import net.minidev.json.writer.JsonReaderI;

public abstract class JSONParserBase {
    public static boolean[] stopAll;
    public static boolean[] stopArray;
    public static boolean[] stopKey;
    public static boolean[] stopValue;
    public static boolean[] stopX;
    public final boolean acceptLeadinZero;
    public final boolean acceptNaN;
    public final boolean acceptNonQuote;
    public final boolean acceptSimpleQuote;
    public final boolean acceptUselessComma;

    /* renamed from: c  reason: collision with root package name */
    public char f6145c;
    public final boolean checkTaillingData;
    public final boolean checkTaillingSpace;
    public final boolean ignoreControlChar;
    public String lastKey;
    public int pos;
    public final boolean reject127;
    public final MSB sb = new MSB(15);
    public final boolean useHiPrecisionFloat;
    public final boolean useIntegerStorage;
    public Object xo;
    public String xs;

    public static class MSB {

        /* renamed from: b  reason: collision with root package name */
        public char[] f6146b;
        public int p = -1;

        public MSB(int i) {
            this.f6146b = new char[i];
        }

        public void append(char c2) {
            int i = this.p + 1;
            this.p = i;
            char[] cArr = this.f6146b;
            if (cArr.length <= i) {
                char[] cArr2 = new char[((cArr.length * 2) + 1)];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.f6146b = cArr2;
            }
            this.f6146b[this.p] = c2;
        }

        public String toString() {
            return new String(this.f6146b, 0, this.p + 1);
        }
    }

    static {
        boolean[] zArr = new boolean[126];
        stopAll = zArr;
        boolean[] zArr2 = new boolean[126];
        stopArray = zArr2;
        boolean[] zArr3 = new boolean[126];
        stopKey = zArr3;
        boolean[] zArr4 = new boolean[126];
        stopValue = zArr4;
        boolean[] zArr5 = new boolean[126];
        stopX = zArr5;
        zArr3[26] = true;
        zArr3[58] = true;
        zArr4[26] = true;
        zArr4[125] = true;
        zArr4[44] = true;
        zArr2[26] = true;
        zArr2[93] = true;
        zArr2[44] = true;
        zArr5[26] = true;
        zArr[58] = true;
        zArr[44] = true;
        zArr[26] = true;
        zArr[125] = true;
        zArr[93] = true;
    }

    public JSONParserBase(int i) {
        boolean z = false;
        this.acceptNaN = (i & 4) > 0;
        this.acceptNonQuote = (i & 2) > 0;
        this.acceptSimpleQuote = (i & 1) > 0;
        this.ignoreControlChar = (i & 8) > 0;
        this.useIntegerStorage = (i & 16) > 0;
        this.acceptLeadinZero = (i & 32) > 0;
        this.acceptUselessComma = (i & 64) > 0;
        this.useHiPrecisionFloat = (i & 128) > 0;
        this.checkTaillingData = (i & GL20.GL_SRC_COLOR) != 768;
        this.checkTaillingSpace = (i & 512) == 0;
        this.reject127 = (i & 1024) > 0 ? true : z;
    }

    public void checkLeadinZero() throws ParseException {
        int length = this.xs.length();
        if (length != 1) {
            if (length != 2) {
                char charAt = this.xs.charAt(0);
                char charAt2 = this.xs.charAt(1);
                if (charAt == '-') {
                    char charAt3 = this.xs.charAt(2);
                    if (charAt2 == '0' && charAt3 >= '0' && charAt3 <= '9') {
                        throw new ParseException(this.pos, 6, this.xs);
                    }
                } else if (charAt == '0' && charAt2 >= '0' && charAt2 <= '9') {
                    throw new ParseException(this.pos, 6, this.xs);
                }
            } else if (this.xs.equals("00")) {
                throw new ParseException(this.pos, 6, this.xs);
            }
        }
    }

    public Number extractFloat() throws ParseException {
        if (!this.acceptLeadinZero) {
            checkLeadinZero();
        }
        if (!this.useHiPrecisionFloat) {
            return Float.valueOf(Float.parseFloat(this.xs));
        }
        if (this.xs.length() > 18) {
            return new BigDecimal(this.xs);
        }
        return Double.valueOf(Double.parseDouble(this.xs));
    }

    public abstract void read() throws IOException;

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (r5 == ':') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r5 == ']') goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if (r5 == '}') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (r4 == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        if (r7.acceptUselessComma == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        throw new net.minidev.json.parser.ParseException(r7.pos, 0, java.lang.Character.valueOf(r7.f6145c));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
        read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
        return r8.convert(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T readArray(net.minidev.json.writer.JsonReaderI<T> r8) throws net.minidev.json.parser.ParseException, java.io.IOException {
        /*
            r7 = this;
            java.lang.Object r0 = r8.createArray()
            char r1 = r7.f6145c
            r2 = 91
            if (r1 != r2) goto L_0x00ad
            r7.read()
            char r1 = r7.f6145c
            r2 = 44
            r3 = 0
            if (r1 != r2) goto L_0x0027
            boolean r1 = r7.acceptUselessComma
            if (r1 == 0) goto L_0x0019
            goto L_0x0027
        L_0x0019:
            net.minidev.json.parser.ParseException r8 = new net.minidev.json.parser.ParseException
            int r0 = r7.pos
            char r1 = r7.f6145c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0027:
            r1 = 1
        L_0x0028:
            r4 = 0
        L_0x0029:
            char r5 = r7.f6145c
            r6 = 9
            if (r5 == r6) goto L_0x00a8
            r6 = 10
            if (r5 == r6) goto L_0x00a8
            r6 = 13
            if (r5 == r6) goto L_0x00a8
            r6 = 26
            if (r5 == r6) goto L_0x009c
            r6 = 32
            if (r5 == r6) goto L_0x00a8
            if (r5 == r2) goto L_0x0082
            r6 = 58
            if (r5 == r6) goto L_0x0074
            r6 = 93
            if (r5 == r6) goto L_0x0057
            r4 = 125(0x7d, float:1.75E-43)
            if (r5 == r4) goto L_0x0074
            boolean[] r4 = stopArray
            java.lang.Object r4 = r7.readMain(r8, r4)
            r8.addValue(r0, r4)
            goto L_0x0028
        L_0x0057:
            if (r4 == 0) goto L_0x006c
            boolean r1 = r7.acceptUselessComma
            if (r1 == 0) goto L_0x005e
            goto L_0x006c
        L_0x005e:
            net.minidev.json.parser.ParseException r8 = new net.minidev.json.parser.ParseException
            int r0 = r7.pos
            char r1 = r7.f6145c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x006c:
            r7.read()
            java.lang.Object r8 = r8.convert(r0)
            return r8
        L_0x0074:
            net.minidev.json.parser.ParseException r8 = new net.minidev.json.parser.ParseException
            int r0 = r7.pos
            char r1 = r7.f6145c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0082:
            if (r4 == 0) goto L_0x0097
            boolean r4 = r7.acceptUselessComma
            if (r4 == 0) goto L_0x0089
            goto L_0x0097
        L_0x0089:
            net.minidev.json.parser.ParseException r8 = new net.minidev.json.parser.ParseException
            int r0 = r7.pos
            char r1 = r7.f6145c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0097:
            r7.read()
            r4 = 1
            goto L_0x0029
        L_0x009c:
            net.minidev.json.parser.ParseException r8 = new net.minidev.json.parser.ParseException
            int r0 = r7.pos
            int r0 = r0 - r1
            r1 = 3
            java.lang.String r2 = "EOF"
            r8.<init>(r0, r1, r2)
            throw r8
        L_0x00a8:
            r7.read()
            goto L_0x0029
        L_0x00ad:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Internal Error"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.minidev.json.parser.JSONParserBase.readArray(net.minidev.json.writer.JsonReaderI):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bb, code lost:
        throw new net.minidev.json.parser.ParseException(r3.pos, 0, java.lang.Character.valueOf(r3.f6145c));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T readFirst(net.minidev.json.writer.JsonReaderI<T> r4) throws net.minidev.json.parser.ParseException, java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            char r0 = r3.f6145c
            r1 = 9
            if (r0 == r1) goto L_0x0115
            r1 = 10
            if (r0 == r1) goto L_0x0115
            r1 = 1
            switch(r0) {
                case 13: goto L_0x0115;
                case 32: goto L_0x0115;
                case 34: goto L_0x010b;
                case 39: goto L_0x010b;
                case 45: goto L_0x00fe;
                case 78: goto L_0x00c1;
                case 91: goto L_0x00bc;
                case 93: goto L_0x00ad;
                case 102: goto L_0x0082;
                case 110: goto L_0x005c;
                case 116: goto L_0x0030;
                case 123: goto L_0x002b;
                case 125: goto L_0x00ad;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r0) {
                case 48: goto L_0x00fe;
                case 49: goto L_0x00fe;
                case 50: goto L_0x00fe;
                case 51: goto L_0x00fe;
                case 52: goto L_0x00fe;
                case 53: goto L_0x00fe;
                case 54: goto L_0x00fe;
                case 55: goto L_0x00fe;
                case 56: goto L_0x00fe;
                case 57: goto L_0x00fe;
                case 58: goto L_0x00ad;
                default: goto L_0x0011;
            }
        L_0x0011:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0021:
            net.minidev.json.parser.ParseException r4 = new net.minidev.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x002b:
            java.lang.Object r4 = r3.readObject(r4)
            return r4
        L_0x0030:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            java.lang.String r0 = r3.xs
            java.lang.String r2 = "true"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0047
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0047:
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x0052
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0052:
            net.minidev.json.parser.ParseException r4 = new net.minidev.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x005c:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            java.lang.String r0 = r3.xs
            java.lang.String r2 = "null"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x006d
            r4 = 0
            return r4
        L_0x006d:
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x0078
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0078:
            net.minidev.json.parser.ParseException r4 = new net.minidev.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x0082:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            java.lang.String r0 = r3.xs
            java.lang.String r2 = "false"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0098
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0098:
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x00a3
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x00a3:
            net.minidev.json.parser.ParseException r4 = new net.minidev.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00ad:
            net.minidev.json.parser.ParseException r4 = new net.minidev.json.parser.ParseException
            int r0 = r3.pos
            r1 = 0
            char r2 = r3.f6145c
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00bc:
            java.lang.Object r4 = r3.readArray(r4)
            return r4
        L_0x00c1:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            boolean r0 = r3.acceptNaN
            if (r0 == 0) goto L_0x00f4
            java.lang.String r0 = r3.xs
            java.lang.String r2 = "NaN"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00df
            r0 = 2143289344(0x7fc00000, float:NaN)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x00df:
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x00ea
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x00ea:
            net.minidev.json.parser.ParseException r4 = new net.minidev.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00f4:
            net.minidev.json.parser.ParseException r4 = new net.minidev.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00fe:
            boolean[] r0 = stopX
            java.lang.Object r0 = r3.readNumber(r0)
            r3.xo = r0
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x010b:
            r3.readString()
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0115:
            r3.read()
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: net.minidev.json.parser.JSONParserBase.readFirst(net.minidev.json.writer.JsonReaderI):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010d, code lost:
        throw new net.minidev.json.parser.ParseException(r2.pos, 0, java.lang.Character.valueOf(r2.f6145c));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object readMain(net.minidev.json.writer.JsonReaderI<?> r3, boolean[] r4) throws net.minidev.json.parser.ParseException, java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            char r0 = r2.f6145c
            r1 = 9
            if (r0 == r1) goto L_0x011d
            r1 = 10
            if (r0 == r1) goto L_0x011d
            r1 = 1
            switch(r0) {
                case 13: goto L_0x011d;
                case 32: goto L_0x011d;
                case 34: goto L_0x00f9;
                case 39: goto L_0x00f9;
                case 45: goto L_0x010e;
                case 78: goto L_0x00bc;
                case 91: goto L_0x00b1;
                case 93: goto L_0x00ff;
                case 102: goto L_0x0086;
                case 110: goto L_0x005c;
                case 116: goto L_0x0030;
                case 123: goto L_0x0025;
                case 125: goto L_0x00ff;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r0) {
                case 48: goto L_0x010e;
                case 49: goto L_0x010e;
                case 50: goto L_0x010e;
                case 51: goto L_0x010e;
                case 52: goto L_0x010e;
                case 53: goto L_0x010e;
                case 54: goto L_0x010e;
                case 55: goto L_0x010e;
                case 56: goto L_0x010e;
                case 57: goto L_0x010e;
                case 58: goto L_0x00ff;
                default: goto L_0x0011;
            }
        L_0x0011:
            r3 = r2
            net.minidev.json.parser.JSONParserMemory r3 = (net.minidev.json.parser.JSONParserMemory) r3
            int r0 = r3.pos
            r3.skipNQString(r4)
            int r4 = r3.pos
            r3.extractStringTrim(r0, r4)
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x0113
            java.lang.String r3 = r2.xs
            return r3
        L_0x0025:
            java.lang.String r4 = r2.lastKey
            net.minidev.json.writer.JsonReaderI r3 = r3.startObject(r4)
            java.lang.Object r3 = r2.readObject(r3)
            return r3
        L_0x0030:
            r3 = r2
            net.minidev.json.parser.JSONParserMemory r3 = (net.minidev.json.parser.JSONParserMemory) r3
            int r0 = r3.pos
            r3.skipNQString(r4)
            int r4 = r3.pos
            r3.extractStringTrim(r0, r4)
            java.lang.String r3 = r2.xs
            java.lang.String r4 = "true"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x004b
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            return r3
        L_0x004b:
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x0052
            java.lang.String r3 = r2.xs
            return r3
        L_0x0052:
            net.minidev.json.parser.ParseException r3 = new net.minidev.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x005c:
            r3 = r2
            net.minidev.json.parser.JSONParserMemory r3 = (net.minidev.json.parser.JSONParserMemory) r3
            int r0 = r3.pos
            r3.skipNQString(r4)
            int r4 = r3.pos
            r3.extractStringTrim(r0, r4)
            java.lang.String r3 = r2.xs
            java.lang.String r4 = "null"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0075
            r3 = 0
            return r3
        L_0x0075:
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x007c
            java.lang.String r3 = r2.xs
            return r3
        L_0x007c:
            net.minidev.json.parser.ParseException r3 = new net.minidev.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0086:
            r3 = r2
            net.minidev.json.parser.JSONParserMemory r3 = (net.minidev.json.parser.JSONParserMemory) r3
            int r0 = r3.pos
            r3.skipNQString(r4)
            int r4 = r3.pos
            r3.extractStringTrim(r0, r4)
            java.lang.String r3 = r2.xs
            java.lang.String r4 = "false"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a0
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            return r3
        L_0x00a0:
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x00a7
            java.lang.String r3 = r2.xs
            return r3
        L_0x00a7:
            net.minidev.json.parser.ParseException r3 = new net.minidev.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00b1:
            java.lang.String r4 = r2.lastKey
            net.minidev.json.writer.JsonReaderI r3 = r3.startArray(r4)
            java.lang.Object r3 = r2.readArray(r3)
            return r3
        L_0x00bc:
            r3 = r2
            net.minidev.json.parser.JSONParserMemory r3 = (net.minidev.json.parser.JSONParserMemory) r3
            int r0 = r3.pos
            r3.skipNQString(r4)
            int r4 = r3.pos
            r3.extractStringTrim(r0, r4)
            boolean r3 = r2.acceptNaN
            if (r3 == 0) goto L_0x00ef
            java.lang.String r3 = r2.xs
            java.lang.String r4 = "NaN"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00de
            r3 = 2143289344(0x7fc00000, float:NaN)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            return r3
        L_0x00de:
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x00e5
            java.lang.String r3 = r2.xs
            return r3
        L_0x00e5:
            net.minidev.json.parser.ParseException r3 = new net.minidev.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00ef:
            net.minidev.json.parser.ParseException r3 = new net.minidev.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00f9:
            r2.readString()
            java.lang.String r3 = r2.xs
            return r3
        L_0x00ff:
            net.minidev.json.parser.ParseException r3 = new net.minidev.json.parser.ParseException
            int r4 = r2.pos
            r0 = 0
            char r1 = r2.f6145c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r3.<init>(r4, r0, r1)
            throw r3
        L_0x010e:
            java.lang.Object r3 = r2.readNumber(r4)
            return r3
        L_0x0113:
            net.minidev.json.parser.ParseException r3 = new net.minidev.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x011d:
            r2.read()
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: net.minidev.json.parser.JSONParserBase.readMain(net.minidev.json.writer.JsonReaderI, boolean[]):java.lang.Object");
    }

    public abstract void readNQString(boolean[] zArr) throws IOException;

    public abstract Object readNumber(boolean[] zArr) throws ParseException, IOException;

    public <T> T readObject(JsonReaderI<T> jsonReaderI) throws ParseException, IOException {
        if (this.f6145c == '{') {
            Object createObject = jsonReaderI.createObject();
            boolean z = false;
            while (true) {
                read();
                char c2 = this.f6145c;
                if (!(c2 == 9 || c2 == 10 || c2 == 13 || c2 == ' ')) {
                    if (c2 != ',') {
                        if (c2 != ':' && c2 != '[' && c2 != ']' && c2 != '{') {
                            if (c2 != '}') {
                                if (c2 == '\"' || c2 == '\'') {
                                    readString();
                                } else {
                                    readNQString(stopKey);
                                    if (!this.acceptNonQuote) {
                                        throw new ParseException(this.pos, 1, this.xs);
                                    }
                                }
                                String str = this.xs;
                                skipSpace();
                                char c3 = this.f6145c;
                                if (c3 == ':') {
                                    JSONParserString jSONParserString = (JSONParserString) this;
                                    int i = jSONParserString.pos + 1;
                                    jSONParserString.pos = i;
                                    if (i < jSONParserString.len) {
                                        jSONParserString.f6145c = jSONParserString.f6147in.charAt(i);
                                        this.lastKey = str;
                                        jsonReaderI.setValue(createObject, str, readMain(jsonReaderI, stopValue));
                                        this.lastKey = null;
                                        skipSpace();
                                        char c4 = this.f6145c;
                                        if (c4 == '}') {
                                            read();
                                            return jsonReaderI.convert(createObject);
                                        } else if (c4 == 26) {
                                            throw new ParseException(this.pos - 1, 3, null);
                                        } else if (c4 != ',') {
                                            throw new ParseException(this.pos - 1, 1, Character.valueOf(this.f6145c));
                                        }
                                    } else {
                                        jSONParserString.f6145c = 26;
                                        throw new ParseException(jSONParserString.pos - 1, 3, "EOF");
                                    }
                                } else if (c3 == 26) {
                                    throw new ParseException(this.pos - 1, 3, null);
                                } else {
                                    throw new ParseException(this.pos - 1, 0, Character.valueOf(this.f6145c));
                                }
                            } else if (!z || this.acceptUselessComma) {
                                read();
                                return jsonReaderI.convert(createObject);
                            } else {
                                throw new ParseException(this.pos, 0, Character.valueOf(this.f6145c));
                            }
                        }
                    } else if (z && !this.acceptUselessComma) {
                        throw new ParseException(this.pos, 0, Character.valueOf(this.f6145c));
                    }
                    z = true;
                }
            }
            throw new ParseException(this.pos, 0, Character.valueOf(this.f6145c));
        }
        throw new RuntimeException("Internal Error");
    }

    public abstract void readS() throws IOException;

    public abstract void readString() throws ParseException, IOException;

    public char readUnicode(int i) throws ParseException, IOException {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 * 16;
            read();
            char c2 = this.f6145c;
            if (c2 > '9' || c2 < '0') {
                char c3 = this.f6145c;
                if (c3 > 'F' || c3 < 'A') {
                    char c4 = this.f6145c;
                    if (c4 >= 'a' && c4 <= 'f') {
                        i2 = c4 - 'a';
                    } else if (this.f6145c == 26) {
                        throw new ParseException(this.pos, 3, "EOF");
                    } else {
                        throw new ParseException(this.pos, 4, Character.valueOf(this.f6145c));
                    }
                } else {
                    i2 = c3 - 'A';
                }
                i3 = i2 + 10;
            } else {
                i3 = c2 - '0';
            }
            i4 = i3 + i6;
        }
        return (char) i4;
    }

    public void skipDigits() throws IOException {
        while (true) {
            char c2 = this.f6145c;
            if (c2 >= '0' && c2 <= '9') {
                readS();
            } else {
                return;
            }
        }
    }

    public void skipNQString(boolean[] zArr) throws IOException {
        while (true) {
            char c2 = this.f6145c;
            if (c2 == 26) {
                return;
            }
            if (c2 < 0 || c2 >= '~' || !zArr[c2]) {
                readS();
            } else {
                return;
            }
        }
    }

    public void skipSpace() throws IOException {
        while (true) {
            char c2 = this.f6145c;
            if (c2 <= ' ' && c2 != 26) {
                readS();
            } else {
                return;
            }
        }
    }
}
