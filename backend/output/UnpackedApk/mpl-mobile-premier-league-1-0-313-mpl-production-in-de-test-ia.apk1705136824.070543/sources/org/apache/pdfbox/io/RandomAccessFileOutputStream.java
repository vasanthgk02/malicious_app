package org.apache.pdfbox.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSBase;

public class RandomAccessFileOutputStream extends OutputStream {
    public COSBase expectedLength = null;
    public final RandomAccess file;
    public long lengthWritten = 0;
    public final long position;

    public RandomAccessFileOutputStream(RandomAccess randomAccess) throws IOException {
        this.file = randomAccess;
        this.position = randomAccess.length();
    }

    public COSBase getExpectedLength() {
        return this.expectedLength;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getLength() {
        /*
            r5 = this;
            org.apache.pdfbox.cos.COSBase r0 = r5.expectedLength
            boolean r1 = r0 instanceof org.apache.pdfbox.cos.COSNumber
            r2 = -1
            if (r1 == 0) goto L_0x0010
            org.apache.pdfbox.cos.COSNumber r0 = (org.apache.pdfbox.cos.COSNumber) r0
            int r0 = r0.intValue()
        L_0x000e:
            long r0 = (long) r0
            goto L_0x002e
        L_0x0010:
            boolean r1 = r0 instanceof org.apache.pdfbox.cos.COSObject
            if (r1 == 0) goto L_0x002d
            org.apache.pdfbox.cos.COSObject r0 = (org.apache.pdfbox.cos.COSObject) r0
            org.apache.pdfbox.cos.COSBase r0 = r0.getObject()
            boolean r0 = r0 instanceof org.apache.pdfbox.cos.COSNumber
            if (r0 == 0) goto L_0x002d
            org.apache.pdfbox.cos.COSBase r0 = r5.expectedLength
            org.apache.pdfbox.cos.COSObject r0 = (org.apache.pdfbox.cos.COSObject) r0
            org.apache.pdfbox.cos.COSBase r0 = r0.getObject()
            org.apache.pdfbox.cos.COSNumber r0 = (org.apache.pdfbox.cos.COSNumber) r0
            int r0 = r0.intValue()
            goto L_0x000e
        L_0x002d:
            r0 = r2
        L_0x002e:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0034
            long r0 = r5.lengthWritten
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.io.RandomAccessFileOutputStream.getLength():long");
    }

    public long getLengthWritten() {
        return this.lengthWritten;
    }

    public long getPosition() {
        return this.position;
    }

    public void setExpectedLength(COSBase cOSBase) {
        this.expectedLength = cOSBase;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.file.seek(this.position + this.lengthWritten);
        this.lengthWritten += (long) i2;
        this.file.write(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        this.file.seek(this.position + this.lengthWritten);
        this.lengthWritten++;
        this.file.write(i);
    }
}
