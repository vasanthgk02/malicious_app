package androidx.datastore.preferences.protobuf;

import java.io.IOException;

public final class CodedOutputStreamWriter implements Writer {
    public final CodedOutputStream output;

    public CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream;
        codedOutputStream.wrapper = this;
    }

    public void writeDouble(int i, double d2) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        if (codedOutputStream != null) {
            codedOutputStream.writeFixed64(i, Double.doubleToRawLongBits(d2));
            return;
        }
        throw null;
    }

    public void writeFloat(int i, float f2) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        if (codedOutputStream != null) {
            codedOutputStream.writeFixed32(i, Float.floatToRawIntBits(f2));
            return;
        }
        throw null;
    }

    public void writeGroup(int i, Object obj, Schema schema) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        codedOutputStream.writeTag(i, 3);
        schema.writeTo((MessageLite) obj, codedOutputStream.wrapper);
        codedOutputStream.writeTag(i, 4);
    }

    public void writeMessage(int i, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(i, (MessageLite) obj, schema);
    }

    public final void writeMessageSetItem(int i, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i, (MessageLite) obj);
        }
    }

    public void writeSInt32(int i, int i2) throws IOException {
        this.output.writeUInt32(i, CodedOutputStream.encodeZigZag32(i2));
    }

    public void writeSInt64(int i, long j) throws IOException {
        this.output.writeUInt64(i, CodedOutputStream.encodeZigZag64(j));
    }
}
