package org.apache.pdfbox.pdfparser;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EndstreamOutputStream extends BufferedOutputStream {
    public boolean hasCR = false;
    public boolean hasLF = false;
    public boolean mustFilter = true;
    public int pos = 0;

    public EndstreamOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void flush() throws IOException {
        if (this.hasCR && !this.hasLF) {
            super.write(13);
            this.pos++;
        }
        this.hasCR = false;
        this.hasLF = false;
        super.flush();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.pos == 0 && i2 > 10) {
            this.mustFilter = false;
            int i3 = 0;
            while (true) {
                if (i3 >= 10) {
                    break;
                } else if (bArr[i3] < 9 || (bArr[i3] > 10 && bArr[i3] < 32 && bArr[i3] != 13)) {
                    this.mustFilter = true;
                } else {
                    i3++;
                }
            }
            this.mustFilter = true;
        }
        if (this.mustFilter) {
            if (this.hasCR) {
                if (!this.hasLF && i2 == 1 && bArr[i] == 10) {
                    this.hasCR = false;
                    return;
                } else {
                    super.write(13);
                    this.hasCR = false;
                }
            }
            if (this.hasLF) {
                super.write(10);
                this.hasLF = false;
            }
            if (i2 > 0) {
                int i4 = (i + i2) - 1;
                if (bArr[i4] == 13) {
                    this.hasCR = true;
                } else if (bArr[i4] == 10) {
                    this.hasLF = true;
                    i2--;
                    if (i2 > 0 && bArr[(i + i2) - 1] == 13) {
                        this.hasCR = true;
                    }
                }
                i2--;
            }
        }
        super.write(bArr, i, i2);
        this.pos += i2;
    }
}
