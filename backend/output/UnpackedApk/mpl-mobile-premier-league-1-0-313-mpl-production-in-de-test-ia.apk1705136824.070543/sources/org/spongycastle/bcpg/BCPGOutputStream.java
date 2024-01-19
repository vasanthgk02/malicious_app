package org.spongycastle.bcpg;

import java.io.IOException;
import java.io.OutputStream;
import sfs2x.client.entities.invitation.InvitationReply;

public class BCPGOutputStream extends OutputStream {
    public OutputStream out;
    public byte[] partialBuffer;
    public int partialOffset;

    public BCPGOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void close() throws IOException {
        if (this.partialBuffer != null) {
            partialFlush(true);
            this.partialBuffer = null;
        }
        this.out.flush();
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public final void partialFlush(boolean z) throws IOException {
        if (z) {
            long j = (long) this.partialOffset;
            if (j < 192) {
                this.out.write((byte) ((int) j));
            } else if (j <= 8383) {
                long j2 = j - 192;
                this.out.write((byte) ((int) (((j2 >> 8) & 255) + 192)));
                this.out.write((byte) ((int) j2));
            } else {
                this.out.write(InvitationReply.EXPIRED);
                this.out.write((byte) ((int) (j >> 24)));
                this.out.write((byte) ((int) (j >> 16)));
                this.out.write((byte) ((int) (j >> 8)));
                this.out.write((byte) ((int) j));
            }
            this.out.write(this.partialBuffer, 0, this.partialOffset);
        } else {
            this.out.write(224);
            this.out.write(this.partialBuffer, 0, 0);
        }
        this.partialOffset = 0;
    }

    public void write(int i) throws IOException {
        if (this.partialBuffer != null) {
            byte b2 = (byte) i;
            if (this.partialOffset == 0) {
                partialFlush(false);
            }
            byte[] bArr = this.partialBuffer;
            int i2 = this.partialOffset;
            this.partialOffset = i2 + 1;
            bArr[i2] = b2;
            return;
        }
        this.out.write(i);
    }

    public void writeObject(BCPGObject bCPGObject) throws IOException {
        bCPGObject.encode(this);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.partialBuffer != null) {
            if (this.partialOffset == 0) {
                partialFlush(false);
            }
            int i3 = this.partialOffset;
            int i4 = 0 - i3;
            if (i2 <= i4) {
                System.arraycopy(bArr, i, this.partialBuffer, i3, i2);
                this.partialOffset += i2;
                return;
            }
            System.arraycopy(bArr, i, this.partialBuffer, i3, i4);
            int i5 = 0 - this.partialOffset;
            int i6 = i + i5;
            int i7 = i2 - i5;
            partialFlush(false);
            while (i7 > 0) {
                System.arraycopy(bArr, i6, this.partialBuffer, 0, 0);
                i6 += 0;
                i7 += 0;
                partialFlush(false);
            }
            System.arraycopy(bArr, i6, this.partialBuffer, 0, i7);
            this.partialOffset += i7;
            return;
        }
        this.out.write(bArr, i, i2);
    }
}
