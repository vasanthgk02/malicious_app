package kotlinx.serialization.json.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0014J\b\u0010\u001d\u001a\u00020\u001eH&J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0004H\u0003J\u0006\u0010!\u001a\u00020\u001eJ\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\rH&J\b\u0010%\u001a\u00020&H&J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\rJ \u0010+\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0005J\u0006\u0010,\u001a\u00020\rJ\u0006\u0010-\u001a\u00020\rJ\u0018\u0010.\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H&J\b\u00101\u001a\u00020\u001aH\u0016J\u0006\u00102\u001a\u00020\u001aJ\u0010\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020&H\u0004J\u0018\u00103\u001a\u0002052\u0006\u00106\u001a\u00020\r2\b\b\u0002\u00100\u001a\u00020\u0004J\u000e\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\rJ\u0018\u00109\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020(H\u0004J\u0006\u0010>\u001a\u00020&J\u0010\u0010?\u001a\u0004\u0018\u00010\r2\u0006\u0010@\u001a\u00020\u001eJ1\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u001e2\b\b\u0002\u00100\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\r0CH\bø\u0001\u0000¢\u0006\u0002\bDJ\u000e\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u001eJ\b\u0010G\u001a\u00020\u0004H\u0016J\u0018\u0010H\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0004H\u0016J\b\u0010J\u001a\u00020\rH\u0002J\b\u0010K\u001a\u00020\rH\u0016J\b\u0010L\u001a\u00020\u001eH&J\u0006\u0010M\u001a\u00020\u001eJ\u0010\u0010N\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0004J\b\u0010O\u001a\u00020\u001eH\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u0007\n\u0005\b20\u0001¨\u0006P"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "()V", "currentPosition", "", "escapedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "peekedString", "", "source", "", "getSource", "()Ljava/lang/CharSequence;", "appendEsc", "startPosition", "appendEscape", "lastPosition", "current", "appendHex", "startPos", "appendRange", "", "fromIndex", "toIndex", "canConsumeValue", "", "consumeBoolean", "start", "consumeBooleanLenient", "consumeBooleanLiteral", "literalSuffix", "consumeKeyString", "consumeNextToken", "", "expected", "", "consumeNumericLiteral", "", "consumeString", "consumeStringLenient", "consumeStringLenientNotNull", "decodedString", "definitelyNotEof", "position", "ensureHaveChars", "expectEof", "fail", "expectedToken", "", "message", "failOnUnknownKey", "key", "fromHexChar", "indexOf", "char", "isValidValueStart", "c", "peekNextToken", "peekString", "isLenient", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_json", "skipElement", "allowLenientStrings", "skipWhitespaces", "substring", "endPos", "takePeeked", "toString", "tryConsumeComma", "tryConsumeNotNull", "unexpectedToken", "wasUnquotedString", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AbstractJsonLexer.kt */
public abstract class AbstractJsonLexer {
    public int currentPosition;
    public StringBuilder escapedString = new StringBuilder();
    public String peekedString;

    public static /* synthetic */ Void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = abstractJsonLexer.currentPosition;
        }
        abstractJsonLexer.fail(str, i);
        throw null;
    }

    public void appendRange(int i, int i2) {
        this.escapedString.append(((StringJsonLexer) this).source, i, i2);
    }

    public abstract boolean canConsumeValue();

    public final boolean consumeBoolean(int i) {
        StringJsonLexer stringJsonLexer = (StringJsonLexer) this;
        if (i >= stringJsonLexer.source.length()) {
            i = -1;
        }
        if (i >= stringJsonLexer.source.length() || i == -1) {
            fail$default(this, "EOF", 0, 2, null);
            throw null;
        }
        int i2 = i + 1;
        char charAt = stringJsonLexer.source.charAt(i) | ' ';
        if (charAt == 't') {
            consumeBooleanLiteral("rue", i2);
            return true;
        } else if (charAt == 'f') {
            consumeBooleanLiteral("alse", i2);
            return false;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected valid boolean literal prefix, but had '");
            outline73.append(consumeStringLenient());
            outline73.append(ExtendedMessageFormat.QUOTE);
            fail$default(this, outline73.toString(), 0, 2, null);
            throw null;
        }
    }

    public final void consumeBooleanLiteral(String str, int i) {
        StringJsonLexer stringJsonLexer = (StringJsonLexer) this;
        if (stringJsonLexer.source.length() - i >= str.length()) {
            int length = str.length() - 1;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (str.charAt(i2) != (stringJsonLexer.source.charAt(i2 + i) | ' ')) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected valid boolean literal prefix, but had '");
                        outline73.append(consumeStringLenient());
                        outline73.append(ExtendedMessageFormat.QUOTE);
                        fail$default(this, outline73.toString(), 0, 2, null);
                        throw null;
                    } else if (i3 > length) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            this.currentPosition = str.length() + i;
            return;
        }
        fail$default(this, "Unexpected end of boolean literal", 0, 2, null);
        throw null;
    }

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public final byte consumeNextToken(byte b2) {
        byte consumeNextToken = consumeNextToken();
        if (consumeNextToken == b2) {
            return consumeNextToken;
        }
        fail(b2);
        throw null;
    }

    public abstract void consumeNextToken(char c2);

    public final long consumeNumericLiteral() {
        boolean z;
        int definitelyNotEof = definitelyNotEof(skipWhitespaces());
        StringJsonLexer stringJsonLexer = (StringJsonLexer) this;
        int i = 2;
        int i2 = 0;
        Throwable th = null;
        if (definitelyNotEof >= stringJsonLexer.source.length() || definitelyNotEof == -1) {
            fail$default(this, "EOF", 0, 2, null);
            throw null;
        }
        if (stringJsonLexer.source.charAt(definitelyNotEof) == '\"') {
            definitelyNotEof++;
            if (definitelyNotEof != stringJsonLexer.source.length()) {
                z = true;
            } else {
                fail$default(this, "EOF", 0, 2, null);
                throw null;
            }
        } else {
            z = false;
        }
        int i3 = definitelyNotEof;
        long j = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (z2) {
            char charAt = stringJsonLexer.source.charAt(i3);
            if (charAt == '-') {
                if (i3 == definitelyNotEof) {
                    i3++;
                    z3 = true;
                } else {
                    fail$default(this, "Unexpected symbol '-' in numeric literal", i2, i, th);
                    throw th;
                }
            } else if (TypeUtilsKt.charToTokenClass(charAt) != 0) {
                break;
            } else {
                i3++;
                z2 = i3 != stringJsonLexer.source.length();
                int i4 = charAt - '0';
                if (i4 >= 0 && i4 <= 9) {
                    j = (j * ((long) 10)) - ((long) i4);
                    if (j <= 0) {
                        i = 2;
                        i2 = 0;
                        th = null;
                    } else {
                        fail$default(this, "Numeric value overflow", 0, 2, null);
                        throw null;
                    }
                } else {
                    Throwable th2 = th;
                    fail$default(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, 2, th2);
                    throw th2;
                }
            }
        }
        if (definitelyNotEof == i3 || (z3 && definitelyNotEof == i3 - 1)) {
            fail$default(this, "Expected numeric literal", 0, 2, null);
            throw null;
        }
        if (z) {
            if (!z2) {
                fail$default(this, "EOF", 0, 2, null);
                throw null;
            } else if (stringJsonLexer.source.charAt(i3) == '\"') {
                i3++;
            } else {
                fail$default(this, "Expected closing quotation mark", 0, 2, null);
                throw null;
            }
        }
        this.currentPosition = i3;
        if (z3) {
            return j;
        }
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        fail$default(this, "Numeric value overflow", 0, 2, null);
        throw null;
    }

    public final String consumeString() {
        String str = this.peekedString;
        if (str == null) {
            return consumeKeyString();
        }
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    public final String consumeStringLenient() {
        String str;
        String str2 = this.peekedString;
        if (str2 != null) {
            Intrinsics.checkNotNull(str2);
            this.peekedString = null;
            return str2;
        }
        int skipWhitespaces = skipWhitespaces();
        StringJsonLexer stringJsonLexer = (StringJsonLexer) this;
        if (skipWhitespaces >= stringJsonLexer.source.length() || skipWhitespaces == -1) {
            fail("EOF", skipWhitespaces);
            throw null;
        }
        byte charToTokenClass = TypeUtilsKt.charToTokenClass(stringJsonLexer.source.charAt(skipWhitespaces));
        if (charToTokenClass == 1) {
            return consumeString();
        }
        if (charToTokenClass == 0) {
            boolean z = false;
            while (TypeUtilsKt.charToTokenClass(stringJsonLexer.source.charAt(skipWhitespaces)) == 0) {
                skipWhitespaces++;
                if (skipWhitespaces >= stringJsonLexer.source.length()) {
                    appendRange(this.currentPosition, skipWhitespaces);
                    int definitelyNotEof = definitelyNotEof(skipWhitespaces);
                    if (definitelyNotEof == -1) {
                        this.currentPosition = skipWhitespaces;
                        return decodedString(0, 0);
                    }
                    skipWhitespaces = definitelyNotEof;
                    z = true;
                }
            }
            if (!z) {
                str = substring(this.currentPosition, skipWhitespaces);
            } else {
                str = decodedString(this.currentPosition, skipWhitespaces);
            }
            this.currentPosition = skipWhitespaces;
            return str;
        }
        fail$default(this, Intrinsics.stringPlus("Expected beginning of the string, but got ", Character.valueOf(stringJsonLexer.source.charAt(skipWhitespaces))), 0, 2, null);
        throw null;
    }

    public final String consumeStringLenientNotNull() {
        String consumeStringLenient = consumeStringLenient();
        if (Intrinsics.areEqual(consumeStringLenient, "null")) {
            boolean z = true;
            if (((StringJsonLexer) this).source.charAt(this.currentPosition - 1) == '\"') {
                z = false;
            }
            if (z) {
                fail$default(this, "Unexpected 'null' value instead of string literal", 0, 2, null);
                throw null;
            }
        }
        return consumeStringLenient;
    }

    public final String decodedString(int i, int i2) {
        this.escapedString.append(((StringJsonLexer) this).source, i, i2);
        String sb = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "escapedString.toString()");
        this.escapedString.setLength(0);
        return sb;
    }

    public abstract int definitelyNotEof(int i);

    public final void fail(byte b2) {
        String str;
        String str2 = b2 == 1 ? "quotation mark '\"'" : b2 == 4 ? "comma ','" : b2 == 5 ? "semicolon ':'" : b2 == 6 ? "start of the object '{'" : b2 == 7 ? "end of the object '}'" : b2 == 8 ? "start of the array '['" : b2 == 9 ? "end of the array ']'" : "valid token";
        StringJsonLexer stringJsonLexer = (StringJsonLexer) this;
        if (this.currentPosition != stringJsonLexer.source.length()) {
            int i = this.currentPosition;
            if (i > 0) {
                str = String.valueOf(stringJsonLexer.source.charAt(i - 1));
                fail(GeneratedOutlineSupport.outline54("Expected ", str2, ", but had '", str, "' instead"), this.currentPosition - 1);
                throw null;
            }
        }
        str = "EOF";
        fail(GeneratedOutlineSupport.outline54("Expected ", str2, ", but had '", str, "' instead"), this.currentPosition - 1);
        throw null;
    }

    public final int fromHexChar(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        boolean z = true;
        if ('0' <= charAt && charAt <= '9') {
            return charAt - '0';
        }
        char c2 = 'a';
        if (!('a' <= charAt && charAt <= 'f')) {
            c2 = 'A';
            if ('A' > charAt || charAt > 'F') {
                z = false;
            }
            if (!z) {
                fail$default(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, 2, null);
                throw null;
            }
        }
        return (charAt - c2) + 10;
    }

    public final byte peekNextToken() {
        String str = ((StringJsonLexer) this).source;
        int i = this.currentPosition;
        while (true) {
            int definitelyNotEof = definitelyNotEof(i);
            if (definitelyNotEof == -1) {
                this.currentPosition = definitelyNotEof;
                return 10;
            }
            char charAt = str.charAt(definitelyNotEof);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i = definitelyNotEof + 1;
            } else {
                this.currentPosition = definitelyNotEof;
                return TypeUtilsKt.charToTokenClass(charAt);
            }
        }
    }

    public abstract int skipWhitespaces();

    public String substring(int i, int i2) {
        return ((StringJsonLexer) this).source.subSequence(i, i2).toString();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JsonReader(source='");
        outline73.append(((StringJsonLexer) this).source);
        outline73.append("', currentPosition=");
        return GeneratedOutlineSupport.outline56(outline73, this.currentPosition, ')');
    }

    public abstract boolean tryConsumeComma();

    public final boolean tryConsumeNotNull() {
        int definitelyNotEof = definitelyNotEof(skipWhitespaces());
        StringJsonLexer stringJsonLexer = (StringJsonLexer) this;
        int length = stringJsonLexer.source.length() - definitelyNotEof;
        if (length < 4 || definitelyNotEof == -1) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if ("null".charAt(i) != stringJsonLexer.source.charAt(i + definitelyNotEof)) {
                return true;
            }
            if (i2 <= 3) {
                i = i2;
            } else if (length > 4 && TypeUtilsKt.charToTokenClass(stringJsonLexer.source.charAt(definitelyNotEof + 4)) == 0) {
                return true;
            } else {
                this.currentPosition = definitelyNotEof + 4;
                return false;
            }
        }
    }

    public final void unexpectedToken(char c2) {
        int i = this.currentPosition - 1;
        this.currentPosition = i;
        if (i < 0 || c2 != '\"' || !Intrinsics.areEqual(consumeStringLenient(), "null")) {
            fail(TypeUtilsKt.charToTokenClass(c2));
            throw null;
        } else {
            fail("Expected string literal but 'null' literal was found.\nUse 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.", this.currentPosition - 4);
            throw null;
        }
    }

    public final Void fail(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "message");
        throw TypeUtilsKt.JsonDecodingException(i, str, ((StringJsonLexer) this).source);
    }
}
