package org.apache.pdfbox.pdmodel.common.function.type4;

public final class Parser {

    /* renamed from: org.apache.pdfbox.pdmodel.common.function.type4.Parser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$apache$pdfbox$pdmodel$common$function$type4$Parser$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                org.apache.pdfbox.pdmodel.common.function.type4.Parser$State[] r0 = org.apache.pdfbox.pdmodel.common.function.type4.Parser.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$pdfbox$pdmodel$common$function$type4$Parser$State = r0
                r1 = 1
                org.apache.pdfbox.pdmodel.common.function.type4.Parser$State r2 = org.apache.pdfbox.pdmodel.common.function.type4.Parser.State.NEWLINE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$org$apache$pdfbox$pdmodel$common$function$type4$Parser$State     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.apache.pdfbox.pdmodel.common.function.type4.Parser$State r3 = org.apache.pdfbox.pdmodel.common.function.type4.Parser.State.WHITESPACE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = $SwitchMap$org$apache$pdfbox$pdmodel$common$function$type4$Parser$State     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.pdfbox.pdmodel.common.function.type4.Parser$State r2 = org.apache.pdfbox.pdmodel.common.function.type4.Parser.State.COMMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.common.function.type4.Parser.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class AbstractSyntaxHandler implements SyntaxHandler {
        public void comment(CharSequence charSequence) {
        }

        public void newLine(CharSequence charSequence) {
        }

        public void whitespace(CharSequence charSequence) {
        }
    }

    public enum State {
        NEWLINE,
        WHITESPACE,
        COMMENT,
        TOKEN
    }

    public interface SyntaxHandler {
        void comment(CharSequence charSequence);

        void newLine(CharSequence charSequence);

        void token(CharSequence charSequence);

        void whitespace(CharSequence charSequence);
    }

    public static final class Tokenizer {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final char CR = '\r';
        public static final char EOT = '\u0004';
        public static final char FF = '\f';
        public static final char LF = '\n';
        public static final char NUL = '\u0000';
        public static final char SPACE = ' ';
        public static final char TAB = '\t';
        public final StringBuilder buffer;
        public final SyntaxHandler handler;
        public int index;
        public final CharSequence input;
        public State state;

        public /* synthetic */ Tokenizer(CharSequence charSequence, SyntaxHandler syntaxHandler, AnonymousClass1 r3) {
            this(charSequence, syntaxHandler);
        }

        private char currentChar() {
            return this.input.charAt(this.index);
        }

        private boolean hasMore() {
            return this.index < this.input.length();
        }

        private char nextChar() {
            this.index++;
            if (!hasMore()) {
                return 4;
            }
            return currentChar();
        }

        private State nextState() {
            char currentChar = currentChar();
            if (!(currentChar == 0 || currentChar == ' ')) {
                if (currentChar == '%') {
                    this.state = State.COMMENT;
                } else if (currentChar != 9) {
                    if (currentChar == 10 || currentChar == 12 || currentChar == 13) {
                        this.state = State.NEWLINE;
                    } else {
                        this.state = State.TOKEN;
                    }
                }
                return this.state;
            }
            this.state = State.WHITESPACE;
            return this.state;
        }

        private char peek() {
            if (this.index < this.input.length() - 1) {
                return this.input.charAt(this.index + 1);
            }
            return 4;
        }

        private void scanComment() {
            this.buffer.append(currentChar());
            while (hasMore()) {
                char nextChar = nextChar();
                if (nextChar == 10 || nextChar == 12 || nextChar == 13) {
                    break;
                }
                this.buffer.append(nextChar);
            }
            this.handler.comment(this.buffer);
        }

        private void scanNewLine() {
            char currentChar = currentChar();
            this.buffer.append(currentChar);
            if (currentChar == 13 && peek() == 10) {
                this.buffer.append(nextChar());
            }
            this.handler.newLine(this.buffer);
            nextChar();
        }

        private void scanToken() {
            char currentChar = currentChar();
            this.buffer.append(currentChar);
            if (currentChar == '{' || currentChar == '}') {
                this.handler.token(this.buffer);
                nextChar();
                return;
            }
            while (hasMore()) {
                char nextChar = nextChar();
                if (nextChar == 0 || nextChar == 4 || nextChar == ' ' || nextChar == '{' || nextChar == '}' || nextChar == 9 || nextChar == 10 || nextChar == 12 || nextChar == 13) {
                    break;
                }
                this.buffer.append(nextChar);
            }
            this.handler.token(this.buffer);
        }

        private void scanWhitespace() {
            this.buffer.append(currentChar());
            while (hasMore()) {
                char nextChar = nextChar();
                if (nextChar != 0 && nextChar != 9 && nextChar != ' ') {
                    break;
                }
                this.buffer.append(nextChar);
            }
            this.handler.whitespace(this.buffer);
        }

        /* access modifiers changed from: private */
        public void tokenize() {
            while (hasMore()) {
                this.buffer.setLength(0);
                nextState();
                int ordinal = this.state.ordinal();
                if (ordinal == 0) {
                    scanNewLine();
                } else if (ordinal == 1) {
                    scanWhitespace();
                } else if (ordinal != 2) {
                    scanToken();
                } else {
                    scanComment();
                }
            }
        }

        public Tokenizer(CharSequence charSequence, SyntaxHandler syntaxHandler) {
            this.state = State.WHITESPACE;
            this.buffer = new StringBuilder();
            this.input = charSequence;
            this.handler = syntaxHandler;
        }
    }

    public static void parse(CharSequence charSequence, SyntaxHandler syntaxHandler) {
        new Tokenizer(charSequence, syntaxHandler, null).tokenize();
    }
}
