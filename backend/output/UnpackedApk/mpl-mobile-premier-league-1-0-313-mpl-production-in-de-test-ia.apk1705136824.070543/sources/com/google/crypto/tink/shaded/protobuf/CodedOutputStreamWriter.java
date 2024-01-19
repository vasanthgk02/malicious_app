package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.CodedOutputStream.ArrayEncoder;
import java.io.IOException;

public final class CodedOutputStreamWriter implements Writer {
    public final CodedOutputStream output;

    public CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream;
        codedOutputStream.wrapper = this;
    }

    public void writeBool(int i, boolean z) throws IOException {
        ArrayEncoder arrayEncoder = (ArrayEncoder) this.output;
        arrayEncoder.writeUInt32NoTag((i << 3) | 0);
        arrayEncoder.write(z ? (byte) 1 : 0);
    }

    public void writeBytes(int i, ByteString byteString) throws IOException {
        ArrayEncoder arrayEncoder = (ArrayEncoder) this.output;
        arrayEncoder.writeUInt32NoTag((i << 3) | 2);
        arrayEncoder.writeBytesNoTag(byteString);
    }

    public void writeDouble(int i, double d2) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        if (codedOutputStream != null) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
            ArrayEncoder arrayEncoder = (ArrayEncoder) codedOutputStream;
            arrayEncoder.writeUInt32NoTag((i << 3) | 1);
            arrayEncoder.writeFixed64NoTag(doubleToRawLongBits);
            return;
        }
        throw null;
    }

    public void writeFixed32(int i, int i2) throws IOException {
        ArrayEncoder arrayEncoder = (ArrayEncoder) this.output;
        arrayEncoder.writeUInt32NoTag((i << 3) | 5);
        arrayEncoder.writeFixed32NoTag(i2);
    }

    public void writeFixed64(int i, long j) throws IOException {
        ArrayEncoder arrayEncoder = (ArrayEncoder) this.output;
        arrayEncoder.writeUInt32NoTag((i << 3) | 1);
        arrayEncoder.writeFixed64NoTag(j);
    }

    public void writeFloat(int i, float f2) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        if (codedOutputStream != null) {
            int floatToRawIntBits = Float.floatToRawIntBits(f2);
            ArrayEncoder arrayEncoder = (ArrayEncoder) codedOutputStream;
            arrayEncoder.writeUInt32NoTag((i << 3) | 5);
            arrayEncoder.writeFixed32NoTag(floatToRawIntBits);
            return;
        }
        throw null;
    }

    public void writeGroup(int i, Object obj, Schema schema) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        MessageLite messageLite = (MessageLite) obj;
        if (codedOutputStream != null) {
            ArrayEncoder arrayEncoder = (ArrayEncoder) codedOutputStream;
            int i2 = i << 3;
            arrayEncoder.writeUInt32NoTag(i2 | 3);
            schema.writeTo(messageLite, codedOutputStream.wrapper);
            arrayEncoder.writeUInt32NoTag(i2 | 4);
            return;
        }
        throw null;
    }

    public void writeInt64(int i, long j) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        if (codedOutputStream != null) {
            ArrayEncoder arrayEncoder = (ArrayEncoder) codedOutputStream;
            arrayEncoder.writeUInt32NoTag((i << 3) | 0);
            arrayEncoder.writeUInt64NoTag(j);
            return;
        }
        throw null;
    }

    public void writeMessage(int i, Object obj, Schema schema) throws IOException {
        MessageLite messageLite = (MessageLite) obj;
        ArrayEncoder arrayEncoder = (ArrayEncoder) this.output;
        arrayEncoder.writeUInt32NoTag((i << 3) | 2);
        arrayEncoder.writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
        schema.writeTo(messageLite, arrayEncoder.wrapper);
    }

    public final void writeMessageSetItem(int i, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            ArrayEncoder arrayEncoder = (ArrayEncoder) this.output;
            arrayEncoder.writeTag(1, 3);
            arrayEncoder.writeUInt32(2, i);
            arrayEncoder.writeBytes(3, (ByteString) obj);
            arrayEncoder.writeTag(1, 4);
            return;
        }
        MessageLite messageLite = (MessageLite) obj;
        ArrayEncoder arrayEncoder2 = (ArrayEncoder) this.output;
        arrayEncoder2.writeTag(1, 3);
        arrayEncoder2.writeUInt32(2, i);
        arrayEncoder2.writeUInt32NoTag(26);
        arrayEncoder2.writeUInt32NoTag(messageLite.getSerializedSize());
        messageLite.writeTo(arrayEncoder2);
        arrayEncoder2.writeTag(1, 4);
    }

    public void writeSFixed32(int i, int i2) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        if (codedOutputStream != null) {
            ArrayEncoder arrayEncoder = (ArrayEncoder) codedOutputStream;
            arrayEncoder.writeUInt32NoTag((i << 3) | 5);
            arrayEncoder.writeFixed32NoTag(i2);
            return;
        }
        throw null;
    }

    public void writeSFixed64(int i, long j) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        if (codedOutputStream != null) {
            ArrayEncoder arrayEncoder = (ArrayEncoder) codedOutputStream;
            arrayEncoder.writeUInt32NoTag((i << 3) | 1);
            arrayEncoder.writeFixed64NoTag(j);
            return;
        }
        throw null;
    }

    public void writeSInt32(int i, int i2) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        if (codedOutputStream != null) {
            int encodeZigZag32 = CodedOutputStream.encodeZigZag32(i2);
            ArrayEncoder arrayEncoder = (ArrayEncoder) codedOutputStream;
            arrayEncoder.writeUInt32NoTag((i << 3) | 0);
            arrayEncoder.writeUInt32NoTag(encodeZigZag32);
            return;
        }
        throw null;
    }

    public void writeSInt64(int i, long j) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        if (codedOutputStream != null) {
            long encodeZigZag64 = CodedOutputStream.encodeZigZag64(j);
            ArrayEncoder arrayEncoder = (ArrayEncoder) codedOutputStream;
            arrayEncoder.writeUInt32NoTag((i << 3) | 0);
            arrayEncoder.writeUInt64NoTag(encodeZigZag64);
            return;
        }
        throw null;
    }

    public void writeUInt32(int i, int i2) throws IOException {
        ArrayEncoder arrayEncoder = (ArrayEncoder) this.output;
        arrayEncoder.writeUInt32NoTag((i << 3) | 0);
        arrayEncoder.writeUInt32NoTag(i2);
    }

    public void writeUInt64(int i, long j) throws IOException {
        ArrayEncoder arrayEncoder = (ArrayEncoder) this.output;
        arrayEncoder.writeUInt32NoTag((i << 3) | 0);
        arrayEncoder.writeUInt64NoTag(j);
    }
}
