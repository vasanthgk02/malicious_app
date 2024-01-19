package kotlin.reflect.jvm.internal.impl.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.OutputStream;
import sfs2x.client.entities.invitation.InvitationReply;

public final class CodedOutputStream {
    public final byte[] buffer;
    public final int limit;
    public final OutputStream output;
    public int position;
    public int totalBytesWritten = 0;

    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return byteString.size() + computeRawVarint32Size(byteString.size());
    }

    public static int computeEnumSize(int i, int i2) {
        return computeTagSize(i) + computeInt32SizeNoTag(i2);
    }

    public static int computeInt32Size(int i, int i2) {
        return computeInt32SizeNoTag(i2) + computeTagSize(i);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeRawVarint32Size(i);
        }
        return 10;
    }

    public static int computeMessageSize(int i, MessageLite messageLite) {
        int computeTagSize = computeTagSize(i);
        int serializedSize = messageLite.getSerializedSize();
        return computeTagSize + computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeRawVarint32Size(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int computeRawVarint64Size(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeTagSize(int i) {
        return computeRawVarint32Size((i << 3) | 0);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    public void flush() throws IOException {
        if (this.output != null) {
            refreshBuffer();
        }
    }

    public final void refreshBuffer() throws IOException {
        OutputStream outputStream = this.output;
        if (outputStream != null) {
            outputStream.write(this.buffer, 0, this.position);
            this.position = 0;
            return;
        }
        throw new OutOfSpaceException();
    }

    public void writeBytesNoTag(ByteString byteString) throws IOException {
        writeRawVarint32(byteString.size());
        writeRawBytes(byteString);
    }

    public void writeEnum(int i, int i2) throws IOException {
        writeRawVarint32((i << 3) | 0);
        if (i2 >= 0) {
            writeRawVarint32(i2);
        } else {
            writeRawVarint64((long) i2);
        }
    }

    public void writeEnumNoTag(int i) throws IOException {
        if (i >= 0) {
            writeRawVarint32(i);
        } else {
            writeRawVarint64((long) i);
        }
    }

    public void writeInt32(int i, int i2) throws IOException {
        writeRawVarint32((i << 3) | 0);
        if (i2 >= 0) {
            writeRawVarint32(i2);
        } else {
            writeRawVarint64((long) i2);
        }
    }

    public void writeInt32NoTag(int i) throws IOException {
        if (i >= 0) {
            writeRawVarint32(i);
        } else {
            writeRawVarint64((long) i);
        }
    }

    public void writeMessage(int i, MessageLite messageLite) throws IOException {
        writeRawVarint32((i << 3) | 2);
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeRawByte(int i) throws IOException {
        byte b2 = (byte) i;
        if (this.position == this.limit) {
            refreshBuffer();
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b2;
        this.totalBytesWritten++;
    }

    public void writeRawBytes(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i = this.limit;
        int i2 = this.position;
        int i3 = i - i2;
        if (i3 >= size) {
            byteString.copyTo(this.buffer, 0, i2, size);
            this.position += size;
            this.totalBytesWritten += size;
            return;
        }
        byteString.copyTo(this.buffer, 0, i2, i3);
        int i4 = i3 + 0;
        int i5 = size - i3;
        this.position = this.limit;
        this.totalBytesWritten += i3;
        refreshBuffer();
        if (i5 <= this.limit) {
            byteString.copyTo(this.buffer, i4, 0, i5);
            this.position = i5;
        } else {
            OutputStream outputStream = this.output;
            if (i4 < 0) {
                throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline31(30, "Source offset < 0: ", i4));
            } else if (i5 >= 0) {
                int i6 = i4 + i5;
                if (i6 > byteString.size()) {
                    throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline31(39, "Source end offset exceeded: ", i6));
                } else if (i5 > 0) {
                    byteString.writeToInternal(outputStream, i4, i5);
                }
            } else {
                throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline31(23, "Length < 0: ", i5));
            }
        }
        this.totalBytesWritten += i5;
    }

    public void writeRawLittleEndian32(int i) throws IOException {
        writeRawByte(i & InvitationReply.EXPIRED);
        writeRawByte((i >> 8) & InvitationReply.EXPIRED);
        writeRawByte((i >> 16) & InvitationReply.EXPIRED);
        writeRawByte((i >> 24) & InvitationReply.EXPIRED);
    }

    public void writeRawLittleEndian64(long j) throws IOException {
        writeRawByte(((int) j) & InvitationReply.EXPIRED);
        writeRawByte(((int) (j >> 8)) & InvitationReply.EXPIRED);
        writeRawByte(((int) (j >> 16)) & InvitationReply.EXPIRED);
        writeRawByte(((int) (j >> 24)) & InvitationReply.EXPIRED);
        writeRawByte(((int) (j >> 32)) & InvitationReply.EXPIRED);
        writeRawByte(((int) (j >> 40)) & InvitationReply.EXPIRED);
        writeRawByte(((int) (j >> 48)) & InvitationReply.EXPIRED);
        writeRawByte(((int) (j >> 56)) & InvitationReply.EXPIRED);
    }

    public void writeRawVarint32(int i) throws IOException {
        while ((i & -128) != 0) {
            writeRawByte((i & 127) | 128);
            i >>>= 7;
        }
        writeRawByte(i);
    }

    public void writeRawVarint64(long j) throws IOException {
        while ((-128 & j) != 0) {
            writeRawByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    public void writeTag(int i, int i2) throws IOException {
        writeRawVarint32((i << 3) | i2);
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = this.limit;
        int i2 = this.position;
        int i3 = i - i2;
        if (i3 >= length) {
            System.arraycopy(bArr, 0, this.buffer, i2, length);
            this.position += length;
            this.totalBytesWritten += length;
            return;
        }
        System.arraycopy(bArr, 0, this.buffer, i2, i3);
        int i4 = i3 + 0;
        int i5 = length - i3;
        this.position = this.limit;
        this.totalBytesWritten += i3;
        refreshBuffer();
        if (i5 <= this.limit) {
            System.arraycopy(bArr, i4, this.buffer, 0, i5);
            this.position = i5;
        } else {
            this.output.write(bArr, i4, i5);
        }
        this.totalBytesWritten += i5;
    }
}
