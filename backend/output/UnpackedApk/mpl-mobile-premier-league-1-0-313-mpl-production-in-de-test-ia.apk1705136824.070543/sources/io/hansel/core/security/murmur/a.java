package io.hansel.core.security.murmur;

import java.util.zip.Checksum;
import sfs2x.client.entities.invitation.InvitationReply;

public class a implements Checksum {

    /* renamed from: f  reason: collision with root package name */
    public static b f5218f = b.a();

    /* renamed from: a  reason: collision with root package name */
    public final int f5219a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f5220b;

    /* renamed from: c  reason: collision with root package name */
    public int f5221c;

    /* renamed from: d  reason: collision with root package name */
    public int f5222d;

    /* renamed from: e  reason: collision with root package name */
    public int f5223e;

    private void a(int i) {
        int i2 = i * -862048943;
        int i3 = (((i2 >>> 17) | (i2 << 15)) * 461845907) ^ this.f5220b;
        this.f5220b = i3;
        int i4 = (i3 >>> 19) | (i3 << 13);
        this.f5220b = i4;
        this.f5220b = (i4 * 5) - 430675100;
    }

    public void a(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public long getValue() {
        int i = this.f5220b;
        if (this.f5223e > 0) {
            int i2 = this.f5222d * -862048943;
            i ^= ((i2 >>> 17) | (i2 << 15)) * 461845907;
        }
        int i3 = i ^ this.f5221c;
        int i4 = (i3 ^ (i3 >>> 16)) * -2048144789;
        int i5 = (i4 ^ (i4 >>> 13)) * -1028477387;
        return ((long) (i5 ^ (i5 >>> 16))) & 4294967295L;
    }

    public void reset() {
        this.f5220b = this.f5219a;
        this.f5221c = 0;
        this.f5223e = 0;
    }

    public void update(int i) {
        int i2 = this.f5223e;
        if (i2 == 0) {
            this.f5222d = i & InvitationReply.EXPIRED;
            this.f5223e = 1;
        } else if (i2 == 1) {
            this.f5222d = ((i & InvitationReply.EXPIRED) << 8) | this.f5222d;
            this.f5223e = 2;
        } else if (i2 == 2) {
            this.f5222d = ((i & InvitationReply.EXPIRED) << 16) | this.f5222d;
            this.f5223e = 3;
        } else if (i2 == 3) {
            int i3 = ((i & InvitationReply.EXPIRED) << 24) | this.f5222d;
            this.f5222d = i3;
            a(i3);
            this.f5223e = 0;
        }
        this.f5221c++;
    }

    public void update(byte[] bArr, int i, int i2) {
        while (this.f5223e != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        int i3 = i2 & 3;
        int i4 = (i2 + i) - i3;
        for (int i5 = i; i5 < i4; i5 += 4) {
            a(f5218f.a(bArr, i5));
        }
        this.f5221c = (i4 - i) + this.f5221c;
        for (int i6 = 0; i6 < i3; i6++) {
            update(bArr[i4 + i6]);
        }
    }
}
