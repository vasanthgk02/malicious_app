package com.google.zxing.datamatrix.encoder;

import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;
import sfs2x.client.entities.invitation.InvitationReply;

public final class EdifactEncoder implements Encoder {
    public static String encodeToCodewords(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            char charAt = charSequence.charAt(i);
            char c2 = 0;
            char charAt2 = length >= 2 ? charSequence.charAt(i + 1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(i + 2) : 0;
            if (length >= 4) {
                c2 = charSequence.charAt(i + 3);
            }
            int i2 = (charAt << 18) + (charAt2 << Tokenizer.FF) + (charAt3 << 6) + c2;
            char c3 = (char) ((i2 >> 8) & InvitationReply.EXPIRED);
            char c4 = (char) (i2 & InvitationReply.EXPIRED);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i2 >> 16) & InvitationReply.EXPIRED));
            if (length >= 2) {
                sb.append(c3);
            }
            if (length >= 3) {
                sb.append(c4);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        throw null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(com.google.zxing.datamatrix.encoder.EncoderContext r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            boolean r1 = r10.hasMoreCharacters()
            r2 = 1
            r3 = 4
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L_0x0055
            char r1 = r10.getCurrentChar()
            r6 = 32
            if (r1 < r6) goto L_0x001f
            r6 = 63
            if (r1 > r6) goto L_0x001f
            r0.append(r1)
            goto L_0x002d
        L_0x001f:
            r6 = 64
            if (r1 < r6) goto L_0x0051
            r6 = 94
            if (r1 > r6) goto L_0x0051
            int r1 = r1 + -64
            char r1 = (char) r1
            r0.append(r1)
        L_0x002d:
            int r1 = r10.pos
            int r1 = r1 + r2
            r10.pos = r1
            int r1 = r0.length()
            if (r1 < r3) goto L_0x0005
            java.lang.String r1 = encodeToCodewords(r0, r5)
            java.lang.StringBuilder r6 = r10.codewords
            r6.append(r1)
            r0.delete(r5, r3)
            java.lang.String r1 = r10.msg
            int r6 = r10.pos
            int r1 = com.google.android.material.resources.TextAppearanceConfig.lookAheadTest(r1, r6, r3)
            if (r1 == r3) goto L_0x0005
            r10.newEncoding = r5
            goto L_0x0055
        L_0x0051:
            com.google.android.material.resources.TextAppearanceConfig.illegalCharacter(r1)
            throw r4
        L_0x0055:
            r1 = 31
            r0.append(r1)
            int r1 = r0.length()     // Catch:{ all -> 0x00c8 }
            if (r1 != 0) goto L_0x0061
            goto L_0x00bd
        L_0x0061:
            r6 = 2
            if (r1 != r2) goto L_0x0079
            r10.updateSymbolInfo()     // Catch:{ all -> 0x00c8 }
            com.google.zxing.datamatrix.encoder.SymbolInfo r7 = r10.symbolInfo     // Catch:{ all -> 0x00c8 }
            int r7 = r7.dataCapacity     // Catch:{ all -> 0x00c8 }
            int r8 = r10.getCodewordCount()     // Catch:{ all -> 0x00c8 }
            int r7 = r7 - r8
            int r8 = r10.getRemainingCharacters()     // Catch:{ all -> 0x00c8 }
            if (r8 != 0) goto L_0x0079
            if (r7 > r6) goto L_0x0079
            goto L_0x00bd
        L_0x0079:
            if (r1 > r3) goto L_0x00c0
            int r1 = r1 - r2
            java.lang.String r0 = encodeToCodewords(r0, r5)     // Catch:{ all -> 0x00c8 }
            boolean r3 = r10.hasMoreCharacters()     // Catch:{ all -> 0x00c8 }
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x008a
            if (r1 > r6) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r2 = 0
        L_0x008b:
            if (r1 > r6) goto L_0x00ae
            int r3 = r10.getCodewordCount()     // Catch:{ all -> 0x00c8 }
            int r3 = r3 + r1
            r10.updateSymbolInfo(r3)     // Catch:{ all -> 0x00c8 }
            com.google.zxing.datamatrix.encoder.SymbolInfo r3 = r10.symbolInfo     // Catch:{ all -> 0x00c8 }
            int r3 = r3.dataCapacity     // Catch:{ all -> 0x00c8 }
            int r6 = r10.getCodewordCount()     // Catch:{ all -> 0x00c8 }
            int r3 = r3 - r6
            r6 = 3
            if (r3 < r6) goto L_0x00ae
            int r2 = r10.getCodewordCount()     // Catch:{ all -> 0x00c8 }
            int r3 = r0.length()     // Catch:{ all -> 0x00c8 }
            int r2 = r2 + r3
            r10.updateSymbolInfo(r2)     // Catch:{ all -> 0x00c8 }
            r2 = 0
        L_0x00ae:
            if (r2 == 0) goto L_0x00b8
            r10.symbolInfo = r4     // Catch:{ all -> 0x00c8 }
            int r0 = r10.pos     // Catch:{ all -> 0x00c8 }
            int r0 = r0 - r1
            r10.pos = r0     // Catch:{ all -> 0x00c8 }
            goto L_0x00bd
        L_0x00b8:
            java.lang.StringBuilder r1 = r10.codewords     // Catch:{ all -> 0x00c8 }
            r1.append(r0)     // Catch:{ all -> 0x00c8 }
        L_0x00bd:
            r10.newEncoding = r5
            return
        L_0x00c0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c8 }
            java.lang.String r1 = "Count must not exceed 4"
            r0.<init>(r1)     // Catch:{ all -> 0x00c8 }
            throw r0     // Catch:{ all -> 0x00c8 }
        L_0x00c8:
            r0 = move-exception
            r10.newEncoding = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.EdifactEncoder.encode(com.google.zxing.datamatrix.encoder.EncoderContext):void");
    }
}
