package kotlinx.serialization.json.internal;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.CharsKt__CharKt;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\n\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "canConsumeValue", "", "consumeKeyString", "consumeNextToken", "", "", "expected", "", "definitelyNotEof", "", "position", "skipWhitespaces", "tryConsumeComma", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StringJsonLexer.kt */
public final class StringJsonLexer extends AbstractJsonLexer {
    public final String source;

    public StringJsonLexer(String str) {
        Intrinsics.checkNotNullParameter(str, DefaultSettingsSpiCall.SOURCE_PARAM);
        this.source = str;
    }

    public boolean canConsumeValue() {
        int i = this.currentPosition;
        boolean z = false;
        if (i == -1) {
            return false;
        }
        while (i < this.source.length()) {
            char charAt = this.source.charAt(i);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i++;
            } else {
                this.currentPosition = i;
                if (((charAt == '}' || charAt == ']') || charAt == ':') || charAt == ',') {
                    z = true;
                }
                return !z;
            }
        }
        this.currentPosition = i;
        return false;
    }

    public String consumeKeyString() {
        int i;
        String str;
        int i2;
        consumeNextToken(StringEscapeUtils.CSV_QUOTE);
        int i3 = this.currentPosition;
        int indexOf$default = CharsKt__CharKt.indexOf$default((CharSequence) this.source, (char) StringEscapeUtils.CSV_QUOTE, i3, false, 4);
        if (indexOf$default != -1) {
            if (i3 < indexOf$default) {
                int i4 = i3;
                while (true) {
                    int i5 = i + 1;
                    if (this.source.charAt(i) == '\\') {
                        String str2 = this.source;
                        int i6 = this.currentPosition;
                        Intrinsics.checkNotNullParameter(str2, DefaultSettingsSpiCall.SOURCE_PARAM);
                        char charAt = str2.charAt(i);
                        boolean z = false;
                        while (charAt != '\"') {
                            if (charAt == '\\') {
                                this.escapedString.append(this.source, i6, i);
                                int i7 = i + 1;
                                if (i7 >= this.source.length()) {
                                    i7 = -1;
                                }
                                if (i7 != -1) {
                                    i2 = i7 + 1;
                                    char charAt2 = this.source.charAt(i7);
                                    if (charAt2 == 'u') {
                                        String str3 = this.source;
                                        int i8 = i2 + 4;
                                        if (i8 < str3.length()) {
                                            this.escapedString.append((char) (fromHexChar(str3, i2 + 3) + (fromHexChar(str3, i2) << 12) + (fromHexChar(str3, i2 + 1) << 8) + (fromHexChar(str3, i2 + 2) << 4)));
                                            i2 = i8;
                                        } else {
                                            AbstractJsonLexer.fail$default(this, "Unexpected EOF during unicode escape", 0, 2, null);
                                            throw null;
                                        }
                                    } else {
                                        char c2 = charAt2 < 'u' ? CharMappings.ESCAPE_2_CHAR[charAt2] : 0;
                                        if (c2 != 0) {
                                            this.escapedString.append(c2);
                                        } else {
                                            AbstractJsonLexer.fail$default(this, "Invalid escaped char '" + charAt2 + ExtendedMessageFormat.QUOTE, 0, 2, null);
                                            throw null;
                                        }
                                    }
                                } else {
                                    AbstractJsonLexer.fail$default(this, "Expected escape sequence to continue, got EOF", 0, 2, null);
                                    throw null;
                                }
                            } else {
                                i++;
                                if (i >= str2.length()) {
                                    appendRange(i6, i);
                                    i2 = definitelyNotEof(i);
                                    if (i2 == -1) {
                                        fail("EOF", i2);
                                        throw null;
                                    }
                                } else {
                                    continue;
                                    charAt = str2.charAt(i);
                                }
                            }
                            i6 = i2;
                            i = i6;
                            z = true;
                            charAt = str2.charAt(i);
                        }
                        if (!z) {
                            str = substring(i6, i);
                        } else {
                            str = decodedString(i6, i);
                        }
                        this.currentPosition = i + 1;
                        return str;
                    } else if (i5 >= indexOf$default) {
                        break;
                    } else {
                        i4 = i5;
                    }
                }
            }
            this.currentPosition = indexOf$default + 1;
            String str4 = this.source;
            if (str4 != null) {
                String substring = str4.substring(i3, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        fail(1);
        throw null;
    }

    public byte consumeNextToken() {
        byte charToTokenClass;
        String str = this.source;
        do {
            int i = this.currentPosition;
            if (i == -1 || i >= str.length()) {
                return 10;
            }
            int i2 = this.currentPosition;
            this.currentPosition = i2 + 1;
            charToTokenClass = TypeUtilsKt.charToTokenClass(str.charAt(i2));
        } while (charToTokenClass == 3);
        return charToTokenClass;
    }

    public int definitelyNotEof(int i) {
        if (i < this.source.length()) {
            return i;
        }
        return -1;
    }

    public int skipWhitespaces() {
        int i = this.currentPosition;
        if (i == -1) {
            return i;
        }
        while (i < this.source.length()) {
            char charAt = this.source.charAt(i);
            if (charAt != ' ' && charAt != 10 && charAt != 13 && charAt != 9) {
                break;
            }
            i++;
        }
        this.currentPosition = i;
        return i;
    }

    public boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces == this.source.length() || skipWhitespaces == -1 || this.source.charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    public void consumeNextToken(char c2) {
        if (this.currentPosition != -1) {
            String str = this.source;
            while (this.currentPosition < str.length()) {
                int i = this.currentPosition;
                this.currentPosition = i + 1;
                char charAt = str.charAt(i);
                if (charAt != ' ' && charAt != 10 && charAt != 13 && charAt != 9) {
                    if (charAt != c2) {
                        unexpectedToken(c2);
                        throw null;
                    }
                    return;
                }
            }
            unexpectedToken(c2);
            throw null;
        }
        unexpectedToken(c2);
        throw null;
    }
}
