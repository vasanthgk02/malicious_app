package org.apache.fontbox.cff;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DataOutput {
    public ByteArrayOutputStream outputBuffer;
    public String outputEncoding;

    public DataOutput() {
        this("ISO-8859-1");
    }

    public byte[] getBytes() {
        return this.outputBuffer.toByteArray();
    }

    public void print(String str) throws IOException {
        write(str.getBytes(this.outputEncoding));
    }

    public void println(String str) throws IOException {
        write(str.getBytes(this.outputEncoding));
        write(10);
    }

    public void write(int i) {
        this.outputBuffer.write(i);
    }

    public DataOutput(String str) {
        this.outputBuffer = new ByteArrayOutputStream();
        this.outputEncoding = null;
        this.outputEncoding = str;
    }

    public void write(byte[] bArr) {
        this.outputBuffer.write(bArr, 0, bArr.length);
    }

    public void println() {
        write(10);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.outputBuffer.write(bArr, i, i2);
    }
}
