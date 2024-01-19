package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ew extends ey {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f4779a = null;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f759a = null;

    public ew() {
    }

    public ew(OutputStream outputStream) {
        this.f759a = outputStream;
    }

    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.f4779a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new ez(4);
            } catch (IOException e2) {
                throw new ez(0, (Throwable) e2);
            }
        } else {
            throw new ez(1, (String) "Cannot read from null inputStream");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m742a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f759a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e2) {
                throw new ez(0, (Throwable) e2);
            }
        } else {
            throw new ez(1, (String) "Cannot write to null outputStream");
        }
    }
}
