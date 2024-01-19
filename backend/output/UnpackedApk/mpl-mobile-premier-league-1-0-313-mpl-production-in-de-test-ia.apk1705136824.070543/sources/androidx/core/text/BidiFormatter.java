package androidx.core.text;

import android.text.SpannableStringBuilder;
import androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public final class BidiFormatter {
    public static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    public static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    public static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    public static final String LRM_STRING = Character.toString(8206);
    public static final String RLM_STRING = Character.toString(8207);
    public final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    public final int mFlags;
    public final boolean mIsRtlContext;

    public static class DirectionalityEstimator {
        public static final byte[] DIR_TYPE_CACHE = new byte[1792];
        public int charIndex;
        public final boolean isHtml;
        public char lastChar;
        public final int length;
        public final CharSequence text;

        static {
            for (int i = 0; i < 1792; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.isHtml = z;
            this.length = charSequence.length();
        }

        public byte dirTypeBackward() {
            char charAt;
            char charAt2;
            char charAt3 = this.text.charAt(this.charIndex - 1);
            this.lastChar = charAt3;
            if (Character.isLowSurrogate(charAt3)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            char c2 = this.lastChar;
            byte directionality = c2 < 1792 ? DIR_TYPE_CACHE[c2] : Character.getDirectionality(c2);
            if (this.isHtml) {
                char c3 = this.lastChar;
                if (c3 == '>') {
                    int i = this.charIndex;
                    while (true) {
                        int i2 = this.charIndex;
                        if (i2 <= 0) {
                            break;
                        }
                        CharSequence charSequence = this.text;
                        int i3 = i2 - 1;
                        this.charIndex = i3;
                        char charAt4 = charSequence.charAt(i3);
                        this.lastChar = charAt4;
                        if (charAt4 == '<') {
                            break;
                        } else if (charAt4 == '>') {
                            break;
                        } else if (charAt4 == '\"' || charAt4 == '\'') {
                            char c4 = this.lastChar;
                            do {
                                int i4 = this.charIndex;
                                if (i4 <= 0) {
                                    break;
                                }
                                CharSequence charSequence2 = this.text;
                                int i5 = i4 - 1;
                                this.charIndex = i5;
                                charAt2 = charSequence2.charAt(i5);
                                this.lastChar = charAt2;
                            } while (charAt2 != c4);
                        }
                    }
                    this.charIndex = i;
                    this.lastChar = '>';
                    directionality = 13;
                } else if (c3 == ';') {
                    int i6 = this.charIndex;
                    do {
                        int i7 = this.charIndex;
                        if (i7 <= 0) {
                            break;
                        }
                        CharSequence charSequence3 = this.text;
                        int i8 = i7 - 1;
                        this.charIndex = i8;
                        charAt = charSequence3.charAt(i8);
                        this.lastChar = charAt;
                        if (charAt == '&') {
                        }
                    } while (charAt != ';');
                    this.charIndex = i6;
                    this.lastChar = DefaultObjectDumpFormatter.TOKEN_DIVIDER;
                    directionality = 13;
                }
                directionality = MqttWireMessage.MESSAGE_TYPE_PINGREQ;
            }
            return directionality;
        }
    }

    public BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f9, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getEntryDir(java.lang.CharSequence r12) {
        /*
            androidx.core.text.BidiFormatter$DirectionalityEstimator r0 = new androidx.core.text.BidiFormatter$DirectionalityEstimator
            r1 = 0
            r0.<init>(r12, r1)
            r0.charIndex = r1
            r12 = -1
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000d:
            int r6 = r0.charIndex
            int r7 = r0.length
            if (r6 >= r7) goto L_0x00db
            if (r3 != 0) goto L_0x00db
            java.lang.CharSequence r7 = r0.text
            char r6 = r7.charAt(r6)
            r0.lastChar = r6
            boolean r6 = java.lang.Character.isHighSurrogate(r6)
            if (r6 == 0) goto L_0x003a
            java.lang.CharSequence r6 = r0.text
            int r7 = r0.charIndex
            int r6 = java.lang.Character.codePointAt(r6, r7)
            int r7 = r0.charIndex
            int r8 = java.lang.Character.charCount(r6)
            int r8 = r8 + r7
            r0.charIndex = r8
            byte r6 = java.lang.Character.getDirectionality(r6)
            goto L_0x00b4
        L_0x003a:
            int r6 = r0.charIndex
            int r6 = r6 + r2
            r0.charIndex = r6
            char r6 = r0.lastChar
            r7 = 1792(0x700, float:2.511E-42)
            if (r6 >= r7) goto L_0x004a
            byte[] r7 = androidx.core.text.BidiFormatter.DirectionalityEstimator.DIR_TYPE_CACHE
            byte r6 = r7[r6]
            goto L_0x004e
        L_0x004a:
            byte r6 = java.lang.Character.getDirectionality(r6)
        L_0x004e:
            boolean r7 = r0.isHtml
            if (r7 == 0) goto L_0x00b4
            char r7 = r0.lastChar
            r8 = 60
            if (r7 != r8) goto L_0x0097
            int r6 = r0.charIndex
        L_0x005a:
            int r7 = r0.charIndex
            int r9 = r0.length
            if (r7 >= r9) goto L_0x0090
            java.lang.CharSequence r9 = r0.text
            int r10 = r7 + 1
            r0.charIndex = r10
            char r7 = r9.charAt(r7)
            r0.lastChar = r7
            r9 = 62
            if (r7 != r9) goto L_0x0071
            goto L_0x00b2
        L_0x0071:
            r9 = 34
            if (r7 == r9) goto L_0x0079
            r9 = 39
            if (r7 != r9) goto L_0x005a
        L_0x0079:
            char r7 = r0.lastChar
        L_0x007b:
            int r9 = r0.charIndex
            int r10 = r0.length
            if (r9 >= r10) goto L_0x005a
            java.lang.CharSequence r10 = r0.text
            int r11 = r9 + 1
            r0.charIndex = r11
            char r9 = r10.charAt(r9)
            r0.lastChar = r9
            if (r9 == r7) goto L_0x005a
            goto L_0x007b
        L_0x0090:
            r0.charIndex = r6
            r0.lastChar = r8
            r6 = 13
            goto L_0x00b4
        L_0x0097:
            r8 = 38
            if (r7 != r8) goto L_0x00b4
        L_0x009b:
            int r6 = r0.charIndex
            int r7 = r0.length
            if (r6 >= r7) goto L_0x00b2
            java.lang.CharSequence r7 = r0.text
            int r8 = r6 + 1
            r0.charIndex = r8
            char r6 = r7.charAt(r6)
            r0.lastChar = r6
            r7 = 59
            if (r6 == r7) goto L_0x00b2
            goto L_0x009b
        L_0x00b2:
            r6 = 12
        L_0x00b4:
            if (r6 == 0) goto L_0x00d5
            if (r6 == r2) goto L_0x00d2
            r7 = 2
            if (r6 == r7) goto L_0x00d2
            r7 = 9
            if (r6 == r7) goto L_0x000d
            switch(r6) {
                case 14: goto L_0x00cd;
                case 15: goto L_0x00cd;
                case 16: goto L_0x00c8;
                case 17: goto L_0x00c8;
                case 18: goto L_0x00c3;
                default: goto L_0x00c2;
            }
        L_0x00c2:
            goto L_0x00d8
        L_0x00c3:
            int r5 = r5 + -1
            r4 = 0
            goto L_0x000d
        L_0x00c8:
            int r5 = r5 + 1
            r4 = 1
            goto L_0x000d
        L_0x00cd:
            int r5 = r5 + 1
            r4 = -1
            goto L_0x000d
        L_0x00d2:
            if (r5 != 0) goto L_0x00d8
            goto L_0x00f3
        L_0x00d5:
            if (r5 != 0) goto L_0x00d8
            goto L_0x00f7
        L_0x00d8:
            r3 = r5
            goto L_0x000d
        L_0x00db:
            if (r3 != 0) goto L_0x00de
            goto L_0x00fc
        L_0x00de:
            if (r4 == 0) goto L_0x00e2
            r1 = r4
            goto L_0x00fc
        L_0x00e2:
            int r4 = r0.charIndex
            if (r4 <= 0) goto L_0x00fc
            byte r4 = r0.dirTypeBackward()
            switch(r4) {
                case 14: goto L_0x00f5;
                case 15: goto L_0x00f5;
                case 16: goto L_0x00f1;
                case 17: goto L_0x00f1;
                case 18: goto L_0x00ee;
                default: goto L_0x00ed;
            }
        L_0x00ed:
            goto L_0x00e2
        L_0x00ee:
            int r5 = r5 + 1
            goto L_0x00e2
        L_0x00f1:
            if (r3 != r5) goto L_0x00f9
        L_0x00f3:
            r1 = 1
            goto L_0x00fc
        L_0x00f5:
            if (r3 != r5) goto L_0x00f9
        L_0x00f7:
            r1 = -1
            goto L_0x00fc
        L_0x00f9:
            int r5 = r5 + -1
            goto L_0x00e2
        L_0x00fc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.BidiFormatter.getEntryDir(java.lang.CharSequence):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r6 = r6 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getExitDir(java.lang.CharSequence r6) {
        /*
            androidx.core.text.BidiFormatter$DirectionalityEstimator r0 = new androidx.core.text.BidiFormatter$DirectionalityEstimator
            r1 = 0
            r0.<init>(r6, r1)
            int r6 = r0.length
            r0.charIndex = r6
            r6 = 0
            r2 = 0
        L_0x000c:
            int r3 = r0.charIndex
            r4 = 1
            if (r3 <= 0) goto L_0x0041
            byte r3 = r0.dirTypeBackward()
            if (r3 == 0) goto L_0x0039
            if (r3 == r4) goto L_0x0032
            r5 = 2
            if (r3 == r5) goto L_0x0032
            r5 = 9
            if (r3 == r5) goto L_0x000c
            switch(r3) {
                case 14: goto L_0x002c;
                case 15: goto L_0x002c;
                case 16: goto L_0x0029;
                case 17: goto L_0x0029;
                case 18: goto L_0x0026;
                default: goto L_0x0023;
            }
        L_0x0023:
            if (r2 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0026:
            int r6 = r6 + 1
            goto L_0x000c
        L_0x0029:
            if (r2 != r6) goto L_0x002f
            goto L_0x0034
        L_0x002c:
            if (r2 != r6) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            int r6 = r6 + -1
            goto L_0x000c
        L_0x0032:
            if (r6 != 0) goto L_0x0036
        L_0x0034:
            r1 = 1
            goto L_0x0041
        L_0x0036:
            if (r2 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0039:
            if (r6 != 0) goto L_0x003d
        L_0x003b:
            r1 = -1
            goto L_0x0041
        L_0x003d:
            if (r2 != 0) goto L_0x000c
        L_0x003f:
            r2 = r6
            goto L_0x000c
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.BidiFormatter.getExitDir(java.lang.CharSequence):int");
    }

    public static BidiFormatter getInstance() {
        boolean z = true;
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            z = false;
        }
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = DEFAULT_TEXT_DIRECTION_HEURISTIC;
        if (textDirectionHeuristicCompat == DEFAULT_TEXT_DIRECTION_HEURISTIC) {
            return z ? DEFAULT_RTL_INSTANCE : DEFAULT_LTR_INSTANCE;
        }
        return new BidiFormatter(z, 2, textDirectionHeuristicCompat);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = ((TextDirectionHeuristicImpl) textDirectionHeuristicCompat).isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = "";
        if (((this.mFlags & 2) != 0) && z) {
            boolean isRtl2 = ((TextDirectionHeuristicImpl) (isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR)).isRtl(charSequence, 0, charSequence.length());
            if (this.mIsRtlContext || (!isRtl2 && getEntryDir(charSequence) != 1)) {
                str = (!this.mIsRtlContext || (isRtl2 && getEntryDir(charSequence) != -1)) ? str2 : RLM_STRING;
            } else {
                str = LRM_STRING;
            }
            spannableStringBuilder.append(str);
        }
        if (isRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            boolean isRtl3 = ((TextDirectionHeuristicImpl) (isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR)).isRtl(charSequence, 0, charSequence.length());
            if (!this.mIsRtlContext && (isRtl3 || getExitDir(charSequence) == 1)) {
                str2 = LRM_STRING;
            } else if (this.mIsRtlContext && (!isRtl3 || getExitDir(charSequence) == -1)) {
                str2 = RLM_STRING;
            }
            spannableStringBuilder.append(str2);
        }
        return spannableStringBuilder;
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }
}
