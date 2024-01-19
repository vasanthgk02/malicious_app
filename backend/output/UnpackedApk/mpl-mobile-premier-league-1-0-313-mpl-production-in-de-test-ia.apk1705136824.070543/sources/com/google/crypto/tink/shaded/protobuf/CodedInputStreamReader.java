package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.CodedInputStream.ArrayDecoder;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite.Metadata;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class CodedInputStreamReader implements Reader {
    public int endGroupTag;
    public final CodedInputStream input;
    public int nextTag = 0;
    public int tag;

    public CodedInputStreamReader(CodedInputStream codedInputStream) {
        Internal.checkNotNull(codedInputStream, "input");
        this.input = codedInputStream;
        codedInputStream.wrapper = this;
    }

    public int getFieldNumber() throws IOException {
        int i = this.nextTag;
        if (i != 0) {
            this.tag = i;
            this.nextTag = 0;
        } else {
            this.tag = this.input.readTag();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.endGroupTag) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public int getTag() {
        return this.tag;
    }

    public boolean readBool() throws IOException {
        requireWireType(0);
        return this.input.readBool();
    }

    public void readBoolList(List<Boolean> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof BooleanArrayList) {
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    booleanArrayList.addBoolean(this.input.readBool());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int totalBytesRead = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    booleanArrayList.addBoolean(this.input.readBool());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.input.readBool()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int totalBytesRead2 = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    list.add(Boolean.valueOf(this.input.readBool()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public ByteString readBytes() throws IOException {
        byte[] bArr;
        requireWireType(2);
        ArrayDecoder arrayDecoder = (ArrayDecoder) this.input;
        int readRawVarint32 = arrayDecoder.readRawVarint32();
        if (readRawVarint32 > 0) {
            int i = arrayDecoder.limit;
            int i2 = arrayDecoder.pos;
            if (readRawVarint32 <= i - i2) {
                ByteString copyFrom = ByteString.copyFrom(arrayDecoder.buffer, i2, readRawVarint32);
                arrayDecoder.pos += readRawVarint32;
                return copyFrom;
            }
        }
        if (readRawVarint32 == 0) {
            return ByteString.EMPTY;
        }
        if (readRawVarint32 > 0) {
            int i3 = arrayDecoder.limit;
            int i4 = arrayDecoder.pos;
            if (readRawVarint32 <= i3 - i4) {
                int i5 = readRawVarint32 + i4;
                arrayDecoder.pos = i5;
                bArr = Arrays.copyOfRange(arrayDecoder.buffer, i4, i5);
                return ByteString.wrap(bArr);
            }
        }
        if (readRawVarint32 > 0) {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (readRawVarint32 == 0) {
            bArr = Internal.EMPTY_BYTE_ARRAY;
            return ByteString.wrap(bArr);
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    public void readBytesList(List<ByteString> list) throws IOException {
        int readTag;
        if ((this.tag & 7) == 2) {
            do {
                list.add(readBytes());
                if (!this.input.isAtEnd()) {
                    readTag = this.input.readTag();
                } else {
                    return;
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public double readDouble() throws IOException {
        requireWireType(1);
        return this.input.readDouble();
    }

    public void readDoubleList(List<Double> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof DoubleArrayList) {
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    doubleArrayList.addDouble(this.input.readDouble());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int readRawVarint32 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed64Length(readRawVarint32);
                int totalBytesRead = this.input.getTotalBytesRead() + readRawVarint32;
                do {
                    doubleArrayList.addDouble(this.input.readDouble());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.input.readDouble()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int readRawVarint322 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed64Length(readRawVarint322);
                int totalBytesRead2 = this.input.getTotalBytesRead() + readRawVarint322;
                do {
                    list.add(Double.valueOf(this.input.readDouble()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readEnum() throws IOException {
        requireWireType(0);
        return ((ArrayDecoder) this.input).readRawVarint32();
    }

    public void readEnumList(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawVarint32());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int totalBytesRead = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawVarint32());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawVarint32()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int totalBytesRead2 = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawVarint32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readFixed32() throws IOException {
        requireWireType(5);
        return ((ArrayDecoder) this.input).readRawLittleEndian32();
    }

    public void readFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i = this.tag & 7;
            if (i == 2) {
                int readRawVarint32 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed32Length(readRawVarint32);
                int totalBytesRead = this.input.getTotalBytesRead() + readRawVarint32;
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawLittleEndian32());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
            } else if (i == 5) {
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawLittleEndian32());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int readRawVarint322 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed32Length(readRawVarint322);
                int totalBytesRead2 = this.input.getTotalBytesRead() + readRawVarint322;
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawLittleEndian32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawLittleEndian32()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readFixed64() throws IOException {
        requireWireType(1);
        return ((ArrayDecoder) this.input).readRawLittleEndian64();
    }

    public void readFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    longArrayList.addLong(((ArrayDecoder) this.input).readRawLittleEndian64());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int readRawVarint32 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed64Length(readRawVarint32);
                int totalBytesRead = this.input.getTotalBytesRead() + readRawVarint32;
                do {
                    longArrayList.addLong(((ArrayDecoder) this.input).readRawLittleEndian64());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((ArrayDecoder) this.input).readRawLittleEndian64()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int readRawVarint322 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed64Length(readRawVarint322);
                int totalBytesRead2 = this.input.getTotalBytesRead() + readRawVarint322;
                do {
                    list.add(Long.valueOf(((ArrayDecoder) this.input).readRawLittleEndian64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public float readFloat() throws IOException {
        requireWireType(5);
        return this.input.readFloat();
    }

    public void readFloatList(List<Float> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof FloatArrayList) {
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int i = this.tag & 7;
            if (i == 2) {
                int readRawVarint32 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed32Length(readRawVarint32);
                int totalBytesRead = this.input.getTotalBytesRead() + readRawVarint32;
                do {
                    floatArrayList.addFloat(this.input.readFloat());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
            } else if (i == 5) {
                do {
                    floatArrayList.addFloat(this.input.readFloat());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int readRawVarint322 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed32Length(readRawVarint322);
                int totalBytesRead2 = this.input.getTotalBytesRead() + readRawVarint322;
                do {
                    list.add(Float.valueOf(this.input.readFloat()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.input.readFloat()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public final <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i = this.endGroupTag;
        this.endGroupTag = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = schema.newInstance();
            schema.mergeFrom(newInstance, this, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            if (this.tag == this.endGroupTag) {
                return newInstance;
            }
            throw InvalidProtocolBufferException.parseFailure();
        } finally {
            this.endGroupTag = i;
        }
    }

    public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        requireWireType(3);
        return readGroup(schema, extensionRegistryLite);
    }

    public <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readTag;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(readGroup(schema, extensionRegistryLite));
                if (!this.input.isAtEnd() && this.nextTag == 0) {
                    readTag = this.input.readTag();
                } else {
                    return;
                }
            } while (readTag == i);
            this.nextTag = readTag;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public int readInt32() throws IOException {
        requireWireType(0);
        return ((ArrayDecoder) this.input).readRawVarint32();
    }

    public void readInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawVarint32());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int totalBytesRead = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawVarint32());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawVarint32()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int totalBytesRead2 = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawVarint32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readInt64() throws IOException {
        requireWireType(0);
        return ((ArrayDecoder) this.input).readRawVarint64();
    }

    public void readInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    longArrayList.addLong(((ArrayDecoder) this.input).readRawVarint64());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int totalBytesRead = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    longArrayList.addLong(((ArrayDecoder) this.input).readRawVarint64());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((ArrayDecoder) this.input).readRawVarint64()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int totalBytesRead2 = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    list.add(Long.valueOf(((ArrayDecoder) this.input).readRawVarint64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public <K, V> void readMap(Map<K, V> map, Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        requireWireType(2);
        this.input.pushLimit(((ArrayDecoder) this.input).readRawVarint32());
        throw null;
    }

    public final <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = ((ArrayDecoder) this.input).readRawVarint32();
        CodedInputStream codedInputStream = this.input;
        if (codedInputStream.recursionDepth < codedInputStream.recursionLimit) {
            int pushLimit = codedInputStream.pushLimit(readRawVarint32);
            T newInstance = schema.newInstance();
            this.input.recursionDepth++;
            schema.mergeFrom(newInstance, this, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            this.input.checkLastTagWas(0);
            this.input.recursionDepth--;
            ArrayDecoder arrayDecoder = (ArrayDecoder) this.input;
            arrayDecoder.currentLimit = pushLimit;
            arrayDecoder.recomputeBufferSizeAfterLimit();
            return newInstance;
        }
        throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        requireWireType(2);
        return readMessage(schema, extensionRegistryLite);
    }

    public <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readTag;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(readMessage(schema, extensionRegistryLite));
                if (!this.input.isAtEnd() && this.nextTag == 0) {
                    readTag = this.input.readTag();
                } else {
                    return;
                }
            } while (readTag == i);
            this.nextTag = readTag;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public int readSFixed32() throws IOException {
        requireWireType(5);
        return ((ArrayDecoder) this.input).readRawLittleEndian32();
    }

    public void readSFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i = this.tag & 7;
            if (i == 2) {
                int readRawVarint32 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed32Length(readRawVarint32);
                int totalBytesRead = this.input.getTotalBytesRead() + readRawVarint32;
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawLittleEndian32());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
            } else if (i == 5) {
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawLittleEndian32());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int readRawVarint322 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed32Length(readRawVarint322);
                int totalBytesRead2 = this.input.getTotalBytesRead() + readRawVarint322;
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawLittleEndian32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawLittleEndian32()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readSFixed64() throws IOException {
        requireWireType(1);
        return ((ArrayDecoder) this.input).readRawLittleEndian64();
    }

    public void readSFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    longArrayList.addLong(((ArrayDecoder) this.input).readRawLittleEndian64());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int readRawVarint32 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed64Length(readRawVarint32);
                int totalBytesRead = this.input.getTotalBytesRead() + readRawVarint32;
                do {
                    longArrayList.addLong(((ArrayDecoder) this.input).readRawLittleEndian64());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((ArrayDecoder) this.input).readRawLittleEndian64()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int readRawVarint322 = ((ArrayDecoder) this.input).readRawVarint32();
                verifyPackedFixed64Length(readRawVarint322);
                int totalBytesRead2 = this.input.getTotalBytesRead() + readRawVarint322;
                do {
                    list.add(Long.valueOf(((ArrayDecoder) this.input).readRawLittleEndian64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public int readSInt32() throws IOException {
        requireWireType(0);
        return this.input.readSInt32();
    }

    public void readSInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    intArrayList.addInt(this.input.readSInt32());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int totalBytesRead = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    intArrayList.addInt(this.input.readSInt32());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.input.readSInt32()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int totalBytesRead2 = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    list.add(Integer.valueOf(this.input.readSInt32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readSInt64() throws IOException {
        requireWireType(0);
        return this.input.readSInt64();
    }

    public void readSInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    longArrayList.addLong(this.input.readSInt64());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int totalBytesRead = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    longArrayList.addLong(this.input.readSInt64());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.input.readSInt64()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int totalBytesRead2 = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    list.add(Long.valueOf(this.input.readSInt64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public String readString() throws IOException {
        requireWireType(2);
        ArrayDecoder arrayDecoder = (ArrayDecoder) this.input;
        int readRawVarint32 = arrayDecoder.readRawVarint32();
        if (readRawVarint32 > 0 && readRawVarint32 <= arrayDecoder.limit - arrayDecoder.pos) {
            String str = new String(arrayDecoder.buffer, arrayDecoder.pos, readRawVarint32, Internal.UTF_8);
            arrayDecoder.pos += readRawVarint32;
            return str;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public void readStringList(List<String> list) throws IOException {
        readStringListInternal(list, false);
    }

    public void readStringListInternal(List<String> list, boolean z) throws IOException {
        int readTag;
        int readTag2;
        if ((this.tag & 7) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        } else if (!(list instanceof LazyStringList) || z) {
            do {
                list.add(z ? readStringRequireUtf8() : readString());
                if (!this.input.isAtEnd()) {
                    readTag = this.input.readTag();
                } else {
                    return;
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            do {
                lazyStringList.add(readBytes());
                if (!this.input.isAtEnd()) {
                    readTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
        }
    }

    public void readStringListRequireUtf8(List<String> list) throws IOException {
        readStringListInternal(list, true);
    }

    public String readStringRequireUtf8() throws IOException {
        requireWireType(2);
        ArrayDecoder arrayDecoder = (ArrayDecoder) this.input;
        int readRawVarint32 = arrayDecoder.readRawVarint32();
        if (readRawVarint32 > 0) {
            int i = arrayDecoder.limit;
            int i2 = arrayDecoder.pos;
            if (readRawVarint32 <= i - i2) {
                String decodeUtf8 = Utf8.processor.decodeUtf8(arrayDecoder.buffer, i2, readRawVarint32);
                arrayDecoder.pos += readRawVarint32;
                return decodeUtf8;
            }
        }
        if (readRawVarint32 == 0) {
            return "";
        }
        if (readRawVarint32 <= 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public int readUInt32() throws IOException {
        requireWireType(0);
        return ((ArrayDecoder) this.input).readRawVarint32();
    }

    public void readUInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawVarint32());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int totalBytesRead = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    intArrayList.addInt(((ArrayDecoder) this.input).readRawVarint32());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawVarint32()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int totalBytesRead2 = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    list.add(Integer.valueOf(((ArrayDecoder) this.input).readRawVarint32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public long readUInt64() throws IOException {
        requireWireType(0);
        return ((ArrayDecoder) this.input).readRawVarint64();
    }

    public void readUInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    longArrayList.addLong(((ArrayDecoder) this.input).readRawVarint64());
                    if (!this.input.isAtEnd()) {
                        readTag2 = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
            } else if (i == 2) {
                int totalBytesRead = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    longArrayList.addLong(((ArrayDecoder) this.input).readRawVarint64());
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((ArrayDecoder) this.input).readRawVarint64()));
                    if (!this.input.isAtEnd()) {
                        readTag = this.input.readTag();
                    } else {
                        return;
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
            } else if (i2 == 2) {
                int totalBytesRead2 = this.input.getTotalBytesRead() + ((ArrayDecoder) this.input).readRawVarint32();
                do {
                    list.add(Long.valueOf(((ArrayDecoder) this.input).readRawVarint64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public final void requirePosition(int i) throws IOException {
        if (this.input.getTotalBytesRead() != i) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public final void requireWireType(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public boolean skipField() throws IOException {
        if (!this.input.isAtEnd()) {
            int i = this.tag;
            if (i != this.endGroupTag) {
                return this.input.skipField(i);
            }
        }
        return false;
    }

    public final void verifyPackedFixed32Length(int i) throws IOException {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    public final void verifyPackedFixed64Length(int i) throws IOException {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }
}
