package com.freshchat.consumer.sdk.j.b;

import android.os.SystemClock;
import com.freshchat.consumer.sdk.j.ai;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class a {
    public long km;
    public long kn;
    public long ko;
    public long offset = -2147483648L;

    private void a(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + 2208988800L;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) (j4 >> 24));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j4 >> 16));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) (j4 >> 8));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) (j4 >> 0));
        long j5 = (j3 * 4294967296L) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) (j5 >> 24));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) (j5 >> 16));
        bArr[i7] = (byte) ((int) (j5 >> 8));
        bArr[i7 + 1] = (byte) ((int) (Math.random() * 255.0d));
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v0, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r1v1, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v1, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r6v1, types: [byte] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long b(byte[] r6, int r7) {
        /*
            r5 = this;
            byte r0 = r6[r7]
            int r1 = r7 + 1
            byte r1 = r6[r1]
            int r2 = r7 + 2
            byte r2 = r6[r2]
            int r7 = r7 + 3
            byte r6 = r6[r7]
            r7 = r0 & 128(0x80, float:1.8E-43)
            r3 = 128(0x80, float:1.8E-43)
            if (r7 != r3) goto L_0x0018
            r7 = r0 & 127(0x7f, float:1.78E-43)
            int r0 = r7 + 128
        L_0x0018:
            r7 = r1 & 128(0x80, float:1.8E-43)
            if (r7 != r3) goto L_0x0020
            r7 = r1 & 127(0x7f, float:1.78E-43)
            int r1 = r7 + 128
        L_0x0020:
            r7 = r2 & 128(0x80, float:1.8E-43)
            if (r7 != r3) goto L_0x0028
            r7 = r2 & 127(0x7f, float:1.78E-43)
            int r2 = r7 + 128
        L_0x0028:
            r7 = r6 & 128(0x80, float:1.8E-43)
            if (r7 != r3) goto L_0x002f
            r6 = r6 & 127(0x7f, float:1.78E-43)
            int r6 = r6 + r3
        L_0x002f:
            long r3 = (long) r0
            r7 = 24
            long r3 = r3 << r7
            long r0 = (long) r1
            r7 = 16
            long r0 = r0 << r7
            long r3 = r3 + r0
            long r0 = (long) r2
            r7 = 8
            long r0 = r0 << r7
            long r3 = r3 + r0
            long r6 = (long) r6
            long r3 = r3 + r6
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.b.a.b(byte[], int):long");
    }

    private long c(byte[] bArr, int i) {
        long b2 = b(bArr, i);
        return ((b(bArr, i + 4) * 1000) / 4294967296L) + ((b2 - 2208988800L) * 1000);
    }

    public boolean c(String str, int i) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.setSoTimeout(i);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, InetAddress.getByName(str), 123);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            a(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j = elapsedRealtime2 - elapsedRealtime;
            long j2 = currentTimeMillis + j;
            datagramSocket.close();
            long c2 = c(bArr, 24);
            long c3 = c(bArr, 32);
            long c4 = c(bArr, 40);
            long j3 = ((c4 - j2) + (c3 - c2)) / 2;
            this.offset = j3;
            this.km = j2 + j3;
            this.kn = elapsedRealtime2;
            this.ko = j - (c4 - c3);
            return true;
        } catch (Exception e2) {
            ai.e("SntpClient", "request time failed: " + e2);
            return false;
        }
    }

    public long fB() {
        return this.offset;
    }
}
