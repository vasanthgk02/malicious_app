package com.appsflyer.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.fontbox.ttf.GlyfDescript;

public final class di extends FilterInputStream {
    public byte[] AFInAppEventParameterName;
    public final int AFInAppEventType;
    public byte[] AFKeystoreWrapper;
    public int AFLogger$LogLevel;
    public int[] AFVersionDeclaration;
    public int AppsFlyer2dXConversionCallback = Integer.MAX_VALUE;
    public int getLevel;
    public int init;
    public dj valueOf;
    public byte[] values;

    public di(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2) throws IOException {
        super(inputStream);
        this.AFInAppEventType = Math.min(Math.max(i, 3), 16);
        this.AFInAppEventParameterName = new byte[8];
        byte[] bArr2 = new byte[8];
        this.values = bArr2;
        this.AFKeystoreWrapper = new byte[8];
        this.AFVersionDeclaration = new int[2];
        this.AFLogger$LogLevel = 8;
        this.getLevel = 8;
        this.init = i2;
        if (i2 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.valueOf = new dj(iArr, this.AFInAppEventType, true, false);
    }

    private int AFInAppEventType() throws IOException {
        if (this.AppsFlyer2dXConversionCallback == Integer.MAX_VALUE) {
            this.AppsFlyer2dXConversionCallback = this.in.read();
        }
        int i = 8;
        if (this.AFLogger$LogLevel == 8) {
            byte[] bArr = this.AFInAppEventParameterName;
            int i2 = this.AppsFlyer2dXConversionCallback;
            bArr[0] = (byte) i2;
            if (i2 >= 0) {
                int i3 = 1;
                do {
                    int read = this.in.read(this.AFInAppEventParameterName, i3, 8 - i3);
                    if (read <= 0) {
                        break;
                    }
                    i3 += read;
                } while (i3 < 8);
                if (i3 >= 8) {
                    AFKeystoreWrapper();
                    int read2 = this.in.read();
                    this.AppsFlyer2dXConversionCallback = read2;
                    this.AFLogger$LogLevel = 0;
                    if (read2 < 0) {
                        i = 8 - (this.AFInAppEventParameterName[7] & 255);
                    }
                    this.getLevel = i;
                } else {
                    throw new IllegalStateException("unexpected block size");
                }
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.getLevel;
    }

    private void AFKeystoreWrapper() {
        if (this.init == 2) {
            byte[] bArr = this.AFInAppEventParameterName;
            System.arraycopy(bArr, 0, this.AFKeystoreWrapper, 0, bArr.length);
        }
        byte[] bArr2 = this.AFInAppEventParameterName;
        int i = ((bArr2[0] << 24) & -16777216) + ((bArr2[1] << GlyfDescript.X_DUAL) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255);
        int i2 = (-16777216 & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << GlyfDescript.X_DUAL)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i3 = this.AFInAppEventType;
        dj djVar = this.valueOf;
        dk.values(i, i2, false, i3, djVar.AFInAppEventParameterName, djVar.AFInAppEventType, this.AFVersionDeclaration);
        int[] iArr = this.AFVersionDeclaration;
        int i4 = iArr[0];
        int i5 = iArr[1];
        byte[] bArr3 = this.AFInAppEventParameterName;
        bArr3[0] = (byte) (i4 >> 24);
        bArr3[1] = (byte) (i4 >> 16);
        bArr3[2] = (byte) (i4 >> 8);
        bArr3[3] = (byte) i4;
        bArr3[4] = (byte) (i5 >> 24);
        bArr3[5] = (byte) (i5 >> 16);
        bArr3[6] = (byte) (i5 >> 8);
        bArr3[7] = (byte) i5;
        if (this.init == 2) {
            for (int i6 = 0; i6 < 8; i6++) {
                byte[] bArr4 = this.AFInAppEventParameterName;
                bArr4[i6] = (byte) (bArr4[i6] ^ this.values[i6]);
            }
            byte[] bArr5 = this.AFKeystoreWrapper;
            System.arraycopy(bArr5, 0, this.values, 0, bArr5.length);
        }
    }

    public final int available() throws IOException {
        AFInAppEventType();
        return this.getLevel - this.AFLogger$LogLevel;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        AFInAppEventType();
        int i = this.AFLogger$LogLevel;
        if (i >= this.getLevel) {
            return -1;
        }
        byte[] bArr = this.AFInAppEventParameterName;
        this.AFLogger$LogLevel = i + 1;
        return bArr[i] & 255;
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            AFInAppEventType();
            int i5 = this.AFLogger$LogLevel;
            if (i5 < this.getLevel) {
                byte[] bArr2 = this.AFInAppEventParameterName;
                this.AFLogger$LogLevel = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4++;
            } else if (i4 == i) {
                return -1;
            } else {
                return i2 - (i3 - i4);
            }
        }
        return i2;
    }
}
