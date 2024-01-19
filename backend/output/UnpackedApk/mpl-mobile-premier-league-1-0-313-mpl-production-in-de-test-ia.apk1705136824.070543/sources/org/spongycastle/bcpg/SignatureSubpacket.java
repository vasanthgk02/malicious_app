package org.spongycastle.bcpg;

import java.io.IOException;
import java.io.OutputStream;
import sfs2x.client.entities.invitation.InvitationReply;

public class SignatureSubpacket {
    public boolean critical;
    public byte[] data;
    public boolean isLongLength;
    public int type;

    public SignatureSubpacket(int i, boolean z, boolean z2, byte[] bArr) {
        this.type = i;
        this.critical = z;
        this.isLongLength = z2;
        this.data = bArr;
    }

    public void encode(OutputStream outputStream) throws IOException {
        int length = this.data.length + 1;
        if (this.isLongLength) {
            outputStream.write(InvitationReply.EXPIRED);
            outputStream.write((byte) (length >> 24));
            outputStream.write((byte) (length >> 16));
            outputStream.write((byte) (length >> 8));
            outputStream.write((byte) length);
        } else if (length < 192) {
            outputStream.write((byte) length);
        } else if (length <= 8383) {
            int i = length - 192;
            outputStream.write((byte) ((255 & (i >> 8)) + 192));
            outputStream.write((byte) i);
        } else {
            outputStream.write(InvitationReply.EXPIRED);
            outputStream.write((byte) (length >> 24));
            outputStream.write((byte) (length >> 16));
            outputStream.write((byte) (length >> 8));
            outputStream.write((byte) length);
        }
        if (this.critical) {
            outputStream.write(this.type | 128);
        } else {
            outputStream.write(this.type);
        }
        outputStream.write(this.data);
    }
}
