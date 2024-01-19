package net.minidev.json.parser;

import java.io.IOException;
import java.math.BigInteger;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public abstract class JSONParserMemory extends JSONParserBase {
    public int len;

    public JSONParserMemory(int i) {
        super(i);
    }

    public abstract void extractStringTrim(int i, int i2);

    public void readNQString(boolean[] zArr) throws IOException {
        int i = this.pos;
        skipNQString(zArr);
        extractStringTrim(i, this.pos);
    }

    public Object readNumber(boolean[] zArr) throws ParseException, IOException {
        boolean z;
        int i;
        int i2;
        Object obj;
        boolean z2;
        int i3;
        int i4 = this.pos;
        read();
        skipDigits();
        char c2 = this.f6145c;
        boolean z3 = true;
        if (c2 == '.' || c2 == 'E' || c2 == 'e') {
            if (this.f6145c == '.') {
                read();
                skipDigits();
            }
            char c3 = this.f6145c;
            if (c3 == 'E' || c3 == 'e') {
                this.sb.append('E');
                read();
                char c4 = this.f6145c;
                if (c4 == '+' || c4 == '-' || (c4 >= '0' && c4 <= '9')) {
                    this.sb.append(this.f6145c);
                    read();
                    skipDigits();
                    skipSpace();
                    char c5 = this.f6145c;
                    if (c5 < 0 || c5 >= '~' || zArr[c5] || c5 == 26) {
                        extractStringTrim(i4, this.pos);
                        return extractFloat();
                    }
                    skipNQString(zArr);
                    extractStringTrim(i4, this.pos);
                    if (this.acceptNonQuote) {
                        return this.xs;
                    }
                    throw new ParseException(this.pos, 1, this.xs);
                }
                skipNQString(zArr);
                extractStringTrim(i4, this.pos);
                if (this.acceptNonQuote) {
                    if (!this.acceptLeadinZero) {
                        checkLeadinZero();
                    }
                    return this.xs;
                }
                throw new ParseException(this.pos, 1, this.xs);
            }
            skipSpace();
            char c6 = this.f6145c;
            if (c6 < 0 || c6 >= '~' || zArr[c6] || c6 == 26) {
                extractStringTrim(i4, this.pos);
                return extractFloat();
            }
            skipNQString(zArr);
            extractStringTrim(i4, this.pos);
            if (this.acceptNonQuote) {
                return this.xs;
            }
            throw new ParseException(this.pos, 1, this.xs);
        }
        skipSpace();
        char c7 = this.f6145c;
        if (c7 < 0 || c7 >= '~' || zArr[c7] || c7 == 26) {
            extractStringTrim(i4, this.pos);
            String str = this.xs;
            int length = str.length();
            if (str.charAt(0) == '-') {
                i2 = 20;
                if (this.acceptLeadinZero || length < 3 || str.charAt(1) != '0') {
                    i = 1;
                    z = true;
                } else {
                    throw new ParseException(this.pos, 6, str);
                }
            } else if (this.acceptLeadinZero || length < 2 || str.charAt(0) != '0') {
                i2 = 19;
                i = 0;
                z = false;
            } else {
                throw new ParseException(this.pos, 6, str);
            }
            if (length < i2) {
                i3 = length;
                z2 = false;
            } else if (length > i2) {
                obj = new BigInteger(str, 10);
                return obj;
            } else {
                i3 = length - 1;
                z2 = true;
            }
            long j = 0;
            while (i < i3) {
                j = (j * 10) + ((long) ('0' - str.charAt(i)));
                i++;
            }
            if (z2) {
                int i5 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
                if (i5 > 0 || (i5 >= 0 && (!z ? str.charAt(i) <= '7' : str.charAt(i) <= '8'))) {
                    z3 = false;
                }
                if (z3) {
                    obj = new BigInteger(str, 10);
                    return obj;
                }
                j = (j * 10) + ((long) ('0' - str.charAt(i)));
            }
            if (!z) {
                long j2 = -j;
                if (!this.useIntegerStorage || j2 > 2147483647L) {
                    obj = Long.valueOf(j2);
                } else {
                    obj = Integer.valueOf((int) j2);
                }
            } else if (!this.useIntegerStorage || j < -2147483648L) {
                obj = Long.valueOf(j);
            } else {
                obj = Integer.valueOf((int) j);
            }
            return obj;
        }
        skipNQString(zArr);
        extractStringTrim(i4, this.pos);
        if (this.acceptNonQuote) {
            return this.xs;
        }
        throw new ParseException(this.pos, 1, this.xs);
    }

    public void readString() throws ParseException, IOException {
        if (this.acceptSimpleQuote || this.f6145c != '\'') {
            JSONParserString jSONParserString = (JSONParserString) this;
            int indexOf = jSONParserString.f6147in.indexOf(this.f6145c, this.pos + 1);
            if (indexOf != -1) {
                jSONParserString.xs = jSONParserString.f6147in.substring(this.pos + 1, indexOf);
                if (this.xs.indexOf(92) == -1) {
                    if (!this.ignoreControlChar) {
                        int length = this.xs.length();
                        for (int i = 0; i < length; i++) {
                            char charAt = this.xs.charAt(i);
                            if (charAt >= 0) {
                                if (charAt <= 31) {
                                    throw new ParseException(this.pos + i, 0, Character.valueOf(charAt));
                                } else if (charAt == 127 && this.reject127) {
                                    throw new ParseException(this.pos + i, 0, Character.valueOf(charAt));
                                }
                            }
                        }
                    }
                    this.pos = indexOf;
                    read();
                    return;
                }
                this.sb.p = -1;
                char c2 = this.f6145c;
                while (true) {
                    read();
                    char c3 = this.f6145c;
                    if (c3 == '\"' || c3 == '\'') {
                        char c4 = this.f6145c;
                        if (c2 == c4) {
                            read();
                            this.xs = this.sb.toString();
                            return;
                        }
                        this.sb.append(c4);
                    } else if (c3 != '\\') {
                        if (c3 != 127) {
                            switch (c3) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                    if (this.ignoreControlChar) {
                                        continue;
                                    } else {
                                        throw new ParseException(this.pos, 0, Character.valueOf(this.f6145c));
                                    }
                                case 26:
                                    throw new ParseException(this.pos - 1, 3, null);
                            }
                        } else if (this.ignoreControlChar) {
                            continue;
                        } else if (this.reject127) {
                            throw new ParseException(this.pos, 0, Character.valueOf(this.f6145c));
                        }
                        this.sb.append(this.f6145c);
                    } else {
                        read();
                        char c5 = this.f6145c;
                        if (c5 == '\"') {
                            this.sb.append(StringEscapeUtils.CSV_QUOTE);
                        } else if (c5 == '\'') {
                            this.sb.append(ExtendedMessageFormat.QUOTE);
                        } else if (c5 == '/') {
                            this.sb.append('/');
                        } else if (c5 == '\\') {
                            this.sb.append('\\');
                        } else if (c5 == 'b') {
                            this.sb.append(8);
                        } else if (c5 == 'f') {
                            this.sb.append(Tokenizer.FF);
                        } else if (c5 == 'n') {
                            this.sb.append(10);
                        } else if (c5 == 'r') {
                            this.sb.append(13);
                        } else if (c5 == 'x') {
                            this.sb.append(readUnicode(2));
                        } else if (c5 == 't') {
                            this.sb.append(9);
                        } else if (c5 == 'u') {
                            this.sb.append(readUnicode(4));
                        }
                    }
                }
            } else {
                throw new ParseException(this.len, 3, null);
            }
        } else if (this.acceptNonQuote) {
            readNQString(JSONParserBase.stopAll);
        } else {
            throw new ParseException(this.pos, 0, Character.valueOf(this.f6145c));
        }
    }
}
