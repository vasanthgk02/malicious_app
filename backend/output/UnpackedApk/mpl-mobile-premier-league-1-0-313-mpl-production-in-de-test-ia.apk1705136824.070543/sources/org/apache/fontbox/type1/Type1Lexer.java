package org.apache.fontbox.type1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public class Type1Lexer {
    public Token aheadToken;
    public final ByteBuffer buffer;
    public int openParens = 0;

    public Type1Lexer(byte[] bArr) throws IOException {
        this.buffer = ByteBuffer.wrap(bArr);
        this.aheadToken = readToken(null);
    }

    private char getChar() {
        return (char) this.buffer.get();
    }

    private Token readCharString(int i) {
        this.buffer.get();
        byte[] bArr = new byte[i];
        this.buffer.get(bArr);
        return new Token(bArr, Token.CHARSTRING);
    }

    private String readComment() {
        StringBuilder sb = new StringBuilder();
        while (this.buffer.hasRemaining()) {
            char c2 = getChar();
            if (c2 == 13 || c2 == 10) {
                break;
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    private String readRegular() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!this.buffer.hasRemaining()) {
                break;
            }
            this.buffer.mark();
            char c2 = getChar();
            if (Character.isWhitespace(c2) || c2 == '(' || c2 == ')' || c2 == '<' || c2 == '>' || c2 == '[' || c2 == ']' || c2 == '{' || c2 == '}' || c2 == '/' || c2 == '%') {
                this.buffer.reset();
            } else {
                sb.append(c2);
            }
        }
        this.buffer.reset();
        String sb2 = sb.toString();
        if (sb2.length() == 0) {
            return null;
        }
        return sb2;
    }

    private Token readString() {
        StringBuilder sb = new StringBuilder();
        while (this.buffer.hasRemaining()) {
            char c2 = getChar();
            if (c2 == '(') {
                this.openParens++;
                sb.append('(');
            } else if (c2 == ')') {
                if (this.openParens == 0) {
                    return new Token(sb.toString(), Token.STRING);
                }
                sb.append(')');
                this.openParens--;
            } else if (c2 == '\\') {
                char c3 = getChar();
                if (c3 == '(') {
                    sb.append('(');
                } else if (c3 == ')') {
                    sb.append(')');
                } else if (c3 == '\\') {
                    sb.append('\\');
                } else if (c3 == 'b') {
                    sb.append(8);
                } else if (c3 == 'f') {
                    sb.append(Tokenizer.FF);
                } else if (c3 == 'n' || c3 == 'r') {
                    sb.append("\n");
                } else if (c3 == 't') {
                    sb.append(9);
                }
                if (Character.isDigit(c3)) {
                    sb.append((char) Integer.valueOf(Integer.parseInt(String.valueOf(new char[]{c3, getChar(), getChar()}), 8)).intValue());
                }
            } else if (c2 == 13 || c2 == 10) {
                sb.append("\n");
            } else {
                sb.append(c2);
            }
        }
        return null;
    }

    private Token readToken(Token token) throws IOException {
        boolean z;
        do {
            z = false;
            while (this.buffer.hasRemaining()) {
                char c2 = getChar();
                if (c2 == '%') {
                    readComment();
                } else if (c2 == '(') {
                    return readString();
                } else {
                    if (c2 == ')') {
                        throw new IOException("unexpected closing parenthesis");
                    } else if (c2 == '[') {
                        return new Token(c2, Token.START_ARRAY);
                    } else {
                        if (c2 == '{') {
                            return new Token(c2, Token.START_PROC);
                        }
                        if (c2 == ']') {
                            return new Token(c2, Token.END_ARRAY);
                        }
                        if (c2 == '}') {
                            return new Token(c2, Token.END_PROC);
                        }
                        if (c2 == '/') {
                            return new Token(readRegular(), Token.LITERAL);
                        }
                        if (!Character.isWhitespace(c2) && c2 != 0) {
                            ByteBuffer byteBuffer = this.buffer;
                            byteBuffer.position(byteBuffer.position() - 1);
                            Token tryReadNumber = tryReadNumber();
                            if (tryReadNumber != null) {
                                return tryReadNumber;
                            }
                            String readRegular = readRegular();
                            if (readRegular == null) {
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Could not read token at position ");
                                outline73.append(this.buffer.position());
                                throw new DamagedFontException(outline73.toString());
                            } else if (!readRegular.equals("RD") && !readRegular.equals("-|")) {
                                return new Token(readRegular, Token.NAME);
                            } else {
                                if (token.getKind() == Token.INTEGER) {
                                    return readCharString(token.intValue());
                                }
                                throw new IOException("expected INTEGER before -| or RD");
                            }
                        } else {
                            z = true;
                        }
                    }
                }
            }
        } while (z);
        return null;
    }

    private Token tryReadNumber() {
        char c2;
        StringBuilder sb;
        this.buffer.mark();
        StringBuilder sb2 = new StringBuilder();
        char c3 = getChar();
        boolean z = false;
        if (c3 == '+' || c3 == '-') {
            sb2.append(c3);
            c3 = getChar();
        }
        while (Character.isDigit(c3)) {
            sb2.append(c3);
            c3 = getChar();
            z = true;
        }
        if (c3 == '.') {
            sb2.append(c3);
            c2 = getChar();
            sb = null;
        } else if (c3 == '#') {
            StringBuilder sb3 = new StringBuilder();
            c2 = getChar();
            StringBuilder sb4 = sb3;
            sb = sb2;
            sb2 = sb4;
        } else if (sb2.length() == 0 || !z) {
            this.buffer.reset();
            return null;
        } else {
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.position(byteBuffer.position() - 1);
            return new Token(sb2.toString(), Token.INTEGER);
        }
        if (Character.isDigit(c2)) {
            sb2.append(c2);
            char c4 = getChar();
            while (Character.isDigit(c4)) {
                sb2.append(c4);
                c4 = getChar();
            }
            if (c4 == 'E') {
                sb2.append(c4);
                char c5 = getChar();
                if (c5 == '-') {
                    sb2.append(c5);
                    c5 = getChar();
                }
                if (Character.isDigit(c5)) {
                    sb2.append(c5);
                    char c6 = getChar();
                    while (Character.isDigit(c6)) {
                        sb2.append(c6);
                        c6 = getChar();
                    }
                } else {
                    this.buffer.reset();
                    return null;
                }
            }
            ByteBuffer byteBuffer2 = this.buffer;
            byteBuffer2.position(byteBuffer2.position() - 1);
            if (sb != null) {
                return new Token(Integer.valueOf(Integer.parseInt(sb2.toString(), Integer.parseInt(sb.toString()))).toString(), Token.INTEGER);
            }
            return new Token(sb2.toString(), Token.REAL);
        }
        this.buffer.reset();
        return null;
    }

    public Token nextToken() throws IOException {
        Token token = this.aheadToken;
        this.aheadToken = readToken(token);
        return token;
    }

    public Token peekToken() {
        return this.aheadToken;
    }
}
