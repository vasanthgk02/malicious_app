package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import sfs2x.client.entities.invitation.InvitationReply;

public class WebSocketFrame {
    public static final int frameLengthOverhead = 6;
    public boolean closeFlag = false;
    public boolean fin;
    public byte opcode;
    public byte[] payload;

    public WebSocketFrame(byte b2, boolean z, byte[] bArr) {
        this.opcode = b2;
        this.fin = z;
        this.payload = bArr;
    }

    public static void appendFinAndOpCode(ByteBuffer byteBuffer, byte b2, boolean z) {
        byteBuffer.put((byte) ((b2 & 15) | (z ? (byte) 128 : 0)));
    }

    public static void appendLength(ByteBuffer byteBuffer, int i, boolean z) {
        if (i >= 0) {
            int i2 = z ? -128 : 0;
            if (i > 65535) {
                byteBuffer.put((byte) (i2 | 127));
                byteBuffer.put(0);
                byteBuffer.put(0);
                byteBuffer.put(0);
                byteBuffer.put(0);
                byteBuffer.put((byte) ((i >> 24) & InvitationReply.EXPIRED));
                byteBuffer.put((byte) ((i >> 16) & InvitationReply.EXPIRED));
                byteBuffer.put((byte) ((i >> 8) & InvitationReply.EXPIRED));
                byteBuffer.put((byte) (i & InvitationReply.EXPIRED));
            } else if (i >= 126) {
                byteBuffer.put((byte) (i2 | 126));
                byteBuffer.put((byte) (i >> 8));
                byteBuffer.put((byte) (i & InvitationReply.EXPIRED));
            } else {
                byteBuffer.put((byte) (i | i2));
            }
        } else {
            throw new IllegalArgumentException("Length cannot be negative");
        }
    }

    public static void appendLengthAndMask(ByteBuffer byteBuffer, int i, byte[] bArr) {
        if (bArr != null) {
            appendLength(byteBuffer, i, true);
            byteBuffer.put(bArr);
            return;
        }
        appendLength(byteBuffer, i, false);
    }

    public static byte[] generateMaskingKey() {
        SecureRandom secureRandom = new SecureRandom();
        return new byte[]{(byte) secureRandom.nextInt(InvitationReply.EXPIRED), (byte) secureRandom.nextInt(InvitationReply.EXPIRED), (byte) secureRandom.nextInt(InvitationReply.EXPIRED), (byte) secureRandom.nextInt(InvitationReply.EXPIRED)};
    }

    private void setFinAndOpCode(byte b2) {
        this.fin = (b2 & 128) != 0;
        this.opcode = (byte) (b2 & 15);
    }

    public byte[] encodeFrame() {
        byte[] bArr = this.payload;
        int length = bArr.length + 6;
        if (bArr.length > 65535) {
            length += 8;
        } else if (bArr.length >= 126) {
            length += 2;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        appendFinAndOpCode(allocate, this.opcode, this.fin);
        byte[] generateMaskingKey = generateMaskingKey();
        appendLengthAndMask(allocate, this.payload.length, generateMaskingKey);
        int i = 0;
        while (true) {
            byte[] bArr2 = this.payload;
            if (i >= bArr2.length) {
                allocate.flip();
                return allocate.array();
            }
            byte b2 = (byte) (bArr2[i] ^ generateMaskingKey[i % 4]);
            bArr2[i] = b2;
            allocate.put(b2);
            i++;
        }
    }

    public byte getOpcode() {
        return this.opcode;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public boolean isCloseFlag() {
        return this.closeFlag;
    }

    public boolean isFin() {
        return this.fin;
    }

    public WebSocketFrame(byte[] bArr) {
        int i = 0;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        setFinAndOpCode(wrap.get());
        byte b2 = wrap.get();
        boolean z = (b2 & 128) != 0;
        byte b3 = (byte) (b2 & Byte.MAX_VALUE);
        int i2 = b3 == Byte.MAX_VALUE ? 8 : b3 == 126 ? 2 : 0;
        while (true) {
            i2--;
            if (i2 <= 0) {
                break;
            }
            b3 |= (wrap.get() & 255) << (i2 * 8);
        }
        byte[] bArr2 = null;
        if (z) {
            byte[] bArr3 = new byte[4];
            wrap.get(bArr3, 0, 4);
            bArr2 = bArr3;
        }
        byte[] bArr4 = new byte[b3];
        this.payload = bArr4;
        wrap.get(bArr4, 0, b3);
        if (z) {
            while (true) {
                byte[] bArr5 = this.payload;
                if (i < bArr5.length) {
                    bArr5[i] = (byte) (bArr5[i] ^ bArr2[i % 4]);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        r2 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WebSocketFrame(java.io.InputStream r8) throws java.io.IOException {
        /*
            r7 = this;
            r7.<init>()
            r0 = 0
            r7.closeFlag = r0
            int r1 = r8.read()
            byte r1 = (byte) r1
            r7.setFinAndOpCode(r1)
            byte r1 = r7.opcode
            r2 = 2
            r3 = 1
            r4 = 8
            if (r1 != r2) goto L_0x0076
            int r1 = r8.read()
            byte r1 = (byte) r1
            r5 = r1 & 128(0x80, float:1.8E-43)
            if (r5 == 0) goto L_0x0021
            r5 = 1
            goto L_0x0022
        L_0x0021:
            r5 = 0
        L_0x0022:
            r3 = 127(0x7f, float:1.78E-43)
            r1 = r1 & r3
            byte r1 = (byte) r1
            if (r1 != r3) goto L_0x002b
            r2 = 8
            goto L_0x0031
        L_0x002b:
            r3 = 126(0x7e, float:1.77E-43)
            if (r1 != r3) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            if (r2 <= 0) goto L_0x0034
            r1 = 0
        L_0x0034:
            int r2 = r2 + -1
            if (r2 >= 0) goto L_0x006a
            r2 = 0
            if (r5 == 0) goto L_0x0042
            r2 = 4
            byte[] r3 = new byte[r2]
            r8.read(r3, r0, r2)
            goto L_0x0043
        L_0x0042:
            r3 = r2
        L_0x0043:
            byte[] r2 = new byte[r1]
            r7.payload = r2
            r4 = r1
            r2 = 0
        L_0x0049:
            if (r2 != r1) goto L_0x0061
            if (r5 == 0) goto L_0x0060
        L_0x004d:
            byte[] r8 = r7.payload
            int r1 = r8.length
            if (r0 < r1) goto L_0x0053
            goto L_0x0060
        L_0x0053:
            byte r1 = r8[r0]
            int r2 = r0 % 4
            byte r2 = r3[r2]
            r1 = r1 ^ r2
            byte r1 = (byte) r1
            r8[r0] = r1
            int r0 = r0 + 1
            goto L_0x004d
        L_0x0060:
            return
        L_0x0061:
            byte[] r6 = r7.payload
            int r6 = r8.read(r6, r2, r4)
            int r2 = r2 + r6
            int r4 = r4 - r6
            goto L_0x0049
        L_0x006a:
            int r3 = r8.read()
            byte r3 = (byte) r3
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r4 = r2 * 8
            int r3 = r3 << r4
            r1 = r1 | r3
            goto L_0x0034
        L_0x0076:
            if (r1 != r4) goto L_0x007b
            r7.closeFlag = r3
            return
        L_0x007b:
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid Frame: Opcode: "
            r0.<init>(r1)
            byte r1 = r7.opcode
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketFrame.<init>(java.io.InputStream):void");
    }
}
