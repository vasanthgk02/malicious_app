package com.google.zxing.datamatrix.encoder;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import sfs2x.client.entities.invitation.InvitationReply;

public final class Base256Encoder implements Encoder {
    public void encode(EncoderContext encoderContext) {
        StringBuilder outline72 = GeneratedOutlineSupport.outline72(0);
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            outline72.append(encoderContext.getCurrentChar());
            int i = encoderContext.pos + 1;
            encoderContext.pos = i;
            int lookAheadTest = TextAppearanceConfig.lookAheadTest(encoderContext.msg, i, 5);
            if (lookAheadTest != 5) {
                encoderContext.newEncoding = lookAheadTest;
                break;
            }
        }
        int length = outline72.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        boolean z = encoderContext.symbolInfo.dataCapacity - codewordCount > 0;
        if (encoderContext.hasMoreCharacters() || z) {
            if (length <= 249) {
                outline72.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                outline72.setCharAt(0, (char) ((length / 250) + 249));
                outline72.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException(GeneratedOutlineSupport.outline40("Message length not in valid ranges: ", length));
            }
        }
        int length2 = outline72.length();
        for (int i2 = 0; i2 < length2; i2++) {
            int codewordCount2 = (((encoderContext.getCodewordCount() + 1) * 149) % InvitationReply.EXPIRED) + 1 + outline72.charAt(i2);
            if (codewordCount2 > 255) {
                codewordCount2 -= 256;
            }
            encoderContext.codewords.append((char) codewordCount2);
        }
    }
}
