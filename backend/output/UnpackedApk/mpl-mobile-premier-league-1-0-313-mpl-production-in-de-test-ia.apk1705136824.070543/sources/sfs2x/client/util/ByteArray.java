package sfs2x.client.util;

import com.smartfoxserver.v2.entities.data.SFSDataType;
import com.smartfoxserver.v2.exceptions.SFSException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import sfs2x.client.entities.invitation.InvitationReply;

public class ByteArray {
    public byte[] buffer;
    public boolean compressed;
    public int position;

    public ByteArray() {
        this.position = 0;
        this.compressed = false;
        this.buffer = new byte[0];
    }

    private void checkCompressedRead() throws SFSException {
        if (this.compressed) {
            throw new SFSException((String) "Only raw bytes can be read from a compressed array.");
        }
    }

    private void checkCompressedWrite() throws SFSException {
        if (this.compressed) {
            throw new SFSException((String) "Only raw bytes can be written a compressed array. Call Uncompress first.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0062, code lost:
        throw new com.smartfoxserver.v2.exceptions.SFSException((java.lang.String) "Error closing buffer during packet compression!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0063, code lost:
        if (r2 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0065, code lost:
        r2.end();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x005b */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0057 A[Catch:{ IOException -> 0x005b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void compress() throws com.smartfoxserver.v2.exceptions.SFSException {
        /*
            r7 = this;
            boolean r0 = r7.compressed
            if (r0 != 0) goto L_0x0069
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x004d }
            r1.<init>()     // Catch:{ all -> 0x004d }
            java.util.zip.Deflater r2 = new java.util.zip.Deflater     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            r3 = 9
            r2.setLevel(r3)     // Catch:{ all -> 0x0041 }
            byte[] r3 = r7.buffer     // Catch:{ all -> 0x0041 }
            r2.setInput(r3)     // Catch:{ all -> 0x0041 }
            r2.finish()     // Catch:{ all -> 0x0041 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0041 }
        L_0x0020:
            boolean r4 = r2.finished()     // Catch:{ all -> 0x0041 }
            r5 = 0
            if (r4 == 0) goto L_0x0039
            byte[] r3 = r1.toByteArray()     // Catch:{ all -> 0x0041 }
            r7.buffer = r3     // Catch:{ all -> 0x0041 }
            r7.position = r5     // Catch:{ all -> 0x0041 }
            r3 = 1
            r7.compressed = r3     // Catch:{ all -> 0x0041 }
            r1.close()     // Catch:{ all -> 0x004b }
            r2.end()
            return
        L_0x0039:
            int r4 = r2.deflate(r3)     // Catch:{ all -> 0x0041 }
            r1.write(r3, r5, r4)     // Catch:{ all -> 0x0041 }
            goto L_0x0020
        L_0x0041:
            r0 = move-exception
            goto L_0x0047
        L_0x0043:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
        L_0x0047:
            r1.close()     // Catch:{ all -> 0x004b }
            throw r0     // Catch:{ all -> 0x004b }
        L_0x004b:
            r1 = move-exception
            goto L_0x004f
        L_0x004d:
            r1 = move-exception
            r2 = r0
        L_0x004f:
            if (r0 == 0) goto L_0x0057
            if (r0 == r1) goto L_0x0058
            r0.addSuppressed(r1)     // Catch:{ IOException -> 0x005b }
            goto L_0x0058
        L_0x0057:
            r0 = r1
        L_0x0058:
            throw r0     // Catch:{ IOException -> 0x005b }
        L_0x0059:
            r0 = move-exception
            goto L_0x0063
        L_0x005b:
            com.smartfoxserver.v2.exceptions.SFSException r0 = new com.smartfoxserver.v2.exceptions.SFSException     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "Error closing buffer during packet compression!"
            r0.<init>(r1)     // Catch:{ all -> 0x0059 }
            throw r0     // Catch:{ all -> 0x0059 }
        L_0x0063:
            if (r2 == 0) goto L_0x0068
            r2.end()
        L_0x0068:
            throw r0
        L_0x0069:
            com.smartfoxserver.v2.exceptions.SFSException r0 = new com.smartfoxserver.v2.exceptions.SFSException
            java.lang.String r1 = "Buffer is already compressed"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sfs2x.client.util.ByteArray.compress():void");
    }

    public byte[] getBytes() {
        return this.buffer;
    }

    public int getBytesAvailable() {
        byte[] bArr = this.buffer;
        int length = bArr.length - this.position;
        if (length > bArr.length || length < 0) {
            return 0;
        }
        return length;
    }

    public int getLength() {
        return this.buffer.length;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isCompressed() {
        return this.compressed;
    }

    public boolean readBool() throws SFSException {
        checkCompressedRead();
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] == 1;
    }

    public byte readByte() throws SFSException {
        checkCompressedRead();
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public byte[] readBytes(int i) {
        byte[] bArr = new byte[i];
        ByteBuffer wrap = ByteBuffer.wrap(this.buffer);
        wrap.position(this.position);
        wrap.get(bArr);
        this.position += i;
        return bArr;
    }

    public double readDouble() throws SFSException {
        checkCompressedRead();
        try {
            return new DataInputStream(new ByteArrayInputStream(reverseOrder(readBytes(8)))).readDouble();
        } catch (IOException unused) {
            throw new SFSException((String) "Error reading from data buffer");
        }
    }

    public float readFloat() throws SFSException {
        checkCompressedRead();
        try {
            return new DataInputStream(new ByteArrayInputStream(reverseOrder(readBytes(4)))).readFloat();
        } catch (IOException unused) {
            throw new SFSException((String) "Error reading from data buffer");
        }
    }

    public int readInt() throws SFSException {
        checkCompressedRead();
        try {
            return new DataInputStream(new ByteArrayInputStream(reverseOrder(readBytes(4)))).readInt();
        } catch (IOException unused) {
            throw new SFSException((String) "Error reading from data buffer");
        }
    }

    public long readLong() throws SFSException {
        checkCompressedRead();
        try {
            return new DataInputStream(new ByteArrayInputStream(reverseOrder(readBytes(8)))).readLong();
        } catch (IOException unused) {
            throw new SFSException((String) "Error reading from data buffer");
        }
    }

    public short readShort() throws SFSException {
        checkCompressedRead();
        try {
            return new DataInputStream(new ByteArrayInputStream(reverseOrder(readBytes(2)))).readShort();
        } catch (IOException unused) {
            throw new SFSException((String) "Error reading from data buffer");
        }
    }

    public int readUShort() throws SFSException {
        checkCompressedRead();
        byte[] reverseOrder = reverseOrder(readBytes(2));
        int intValue = new Integer(reverseOrder[0]).intValue();
        if (intValue < 0) {
            intValue = (reverseOrder[0] & 128) + (reverseOrder[0] & Byte.MAX_VALUE);
        }
        int intValue2 = new Integer(reverseOrder[1]).intValue();
        if (intValue2 < 0) {
            intValue2 = (reverseOrder[1] & 128) + (reverseOrder[1] & Byte.MAX_VALUE);
        }
        return (intValue * 256) + intValue2;
    }

    public String readUTF() throws SFSException {
        try {
            checkCompressedRead();
            return new String(readBytes(readShort()), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new SFSException((String) "Error reading from data buffer");
        }
    }

    public byte[] reverseOrder(byte[] bArr) {
        return bArr;
    }

    public void setBuffer(byte[] bArr) {
        this.buffer = bArr;
        this.compressed = false;
    }

    public void setCompressed(boolean z) {
        this.compressed = z;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x004e */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004a A[Catch:{ DataFormatException -> 0x0056, IOException -> 0x004e, all -> 0x004c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uncompress() throws com.smartfoxserver.v2.exceptions.SFSException {
        /*
            r7 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0040 }
            r1.<init>()     // Catch:{ all -> 0x0040 }
            java.util.zip.Inflater r2 = new java.util.zip.Inflater     // Catch:{ all -> 0x0036 }
            r2.<init>()     // Catch:{ all -> 0x0036 }
            byte[] r3 = r7.buffer     // Catch:{ all -> 0x0034 }
            r2.setInput(r3)     // Catch:{ all -> 0x0034 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0034 }
        L_0x0014:
            boolean r4 = r2.finished()     // Catch:{ all -> 0x0034 }
            r5 = 0
            if (r4 == 0) goto L_0x002c
            byte[] r3 = r1.toByteArray()     // Catch:{ all -> 0x0034 }
            r7.buffer = r3     // Catch:{ all -> 0x0034 }
            r7.position = r5     // Catch:{ all -> 0x0034 }
            r7.compressed = r5     // Catch:{ all -> 0x0034 }
            r1.close()     // Catch:{ all -> 0x003e }
            r2.end()
            return
        L_0x002c:
            int r4 = r2.inflate(r3)     // Catch:{ all -> 0x0034 }
            r1.write(r3, r5, r4)     // Catch:{ all -> 0x0034 }
            goto L_0x0014
        L_0x0034:
            r0 = move-exception
            goto L_0x003a
        L_0x0036:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
        L_0x003a:
            r1.close()     // Catch:{ all -> 0x003e }
            throw r0     // Catch:{ all -> 0x003e }
        L_0x003e:
            r1 = move-exception
            goto L_0x0042
        L_0x0040:
            r1 = move-exception
            r2 = r0
        L_0x0042:
            if (r0 == 0) goto L_0x004a
            if (r0 == r1) goto L_0x004b
            r0.addSuppressed(r1)     // Catch:{ DataFormatException -> 0x0056, IOException -> 0x004e }
            goto L_0x004b
        L_0x004a:
            r0 = r1
        L_0x004b:
            throw r0     // Catch:{ DataFormatException -> 0x0056, IOException -> 0x004e }
        L_0x004c:
            r0 = move-exception
            goto L_0x005e
        L_0x004e:
            com.smartfoxserver.v2.exceptions.SFSException r0 = new com.smartfoxserver.v2.exceptions.SFSException     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "Error decompressing data"
            r0.<init>(r1)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x0056:
            com.smartfoxserver.v2.exceptions.SFSException r0 = new com.smartfoxserver.v2.exceptions.SFSException     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "Data format exception decompressing buffer"
            r0.<init>(r1)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x005e:
            if (r2 == 0) goto L_0x0063
            r2.end()
        L_0x0063:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sfs2x.client.util.ByteArray.uncompress():void");
    }

    public void writeBool(boolean z) throws SFSException {
        checkCompressedWrite();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DataOutputStream(byteArrayOutputStream).writeByte(z ? 1 : 0);
            writeBytes(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new SFSException((String) "Error writing to data buffer");
        }
    }

    public void writeByte(SFSDataType sFSDataType) {
        writeByte((byte) sFSDataType.getTypeID());
    }

    public void writeBytes(byte[] bArr) {
        writeBytes(bArr, bArr.length);
    }

    public void writeDouble(double d2) throws SFSException {
        checkCompressedWrite();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DataOutputStream(byteArrayOutputStream).writeDouble(d2);
            writeBytes(reverseOrder(byteArrayOutputStream.toByteArray()));
        } catch (IOException unused) {
            throw new SFSException((String) "Error writing to data buffer");
        }
    }

    public void writeFloat(float f2) throws SFSException {
        checkCompressedWrite();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DataOutputStream(byteArrayOutputStream).writeFloat(f2);
            writeBytes(reverseOrder(byteArrayOutputStream.toByteArray()));
        } catch (IOException unused) {
            throw new SFSException((String) "Error writing to data buffer");
        }
    }

    public void writeInt(int i) throws SFSException {
        checkCompressedWrite();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DataOutputStream(byteArrayOutputStream).writeInt(i);
            writeBytes(reverseOrder(byteArrayOutputStream.toByteArray()));
        } catch (IOException unused) {
            throw new SFSException((String) "Error writing to data buffer");
        }
    }

    public void writeLong(long j) throws SFSException {
        checkCompressedWrite();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DataOutputStream(byteArrayOutputStream).writeLong(j);
            writeBytes(reverseOrder(byteArrayOutputStream.toByteArray()));
        } catch (IOException unused) {
            throw new SFSException((String) "Error writing to data buffer");
        }
    }

    public void writeShort(short s) throws SFSException {
        checkCompressedWrite();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DataOutputStream(byteArrayOutputStream).writeShort(s);
            writeBytes(reverseOrder(byteArrayOutputStream.toByteArray()));
        } catch (IOException unused) {
            throw new SFSException((String) "Error writing to data buffer");
        }
    }

    public void writeUShort(int i) throws SFSException {
        checkCompressedWrite();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i2 = i & InvitationReply.EXPIRED;
            dataOutputStream.writeByte((byte) ((65280 & i) >> 8));
            dataOutputStream.writeByte((byte) i2);
            writeBytes(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new SFSException((String) "Error writing to data buffer");
        }
    }

    public void writeUTF(String str) throws SFSException {
        checkCompressedWrite();
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            i = (charAt < 1 || charAt > 127) ? charAt > 2047 ? i + 3 : i + 2 : i + 1;
        }
        if (i <= 32768) {
            try {
                writeShort((short) i);
                writeBytes(str.getBytes("UTF8"));
            } catch (UnsupportedEncodingException unused) {
                throw new SFSException((String) "Error writing to data buffer");
            }
        } else {
            throw new SFSException((String) "String length cannot be greater then 32768 !");
        }
    }

    public void writeByte(byte b2) {
        writeBytes(new byte[]{b2});
    }

    public void writeBytes(byte[] bArr, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(this.buffer.length + i);
        allocate.put(this.buffer);
        byte[] bArr2 = new byte[i];
        ByteBuffer.wrap(bArr).get(bArr2, 0, i);
        allocate.put(bArr2);
        this.buffer = allocate.array();
    }

    public ByteArray(byte[] bArr) {
        this.position = 0;
        this.compressed = false;
        this.buffer = bArr;
    }
}
