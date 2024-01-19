package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$StringTable extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$StringTable> PARSER = new AbstractParser<ProtoBuf$StringTable>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$StringTable(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$StringTable defaultInstance;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public LazyStringList string_;
    public final ByteString unknownFields;

    public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<ProtoBuf$StringTable, Builder> implements Object {
        public int bitField0_;
        public LazyStringList string_ = LazyStringArrayList.EMPTY;

        public MessageLite build() {
            ProtoBuf$StringTable buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$StringTable buildPartial() {
            ProtoBuf$StringTable protoBuf$StringTable = new ProtoBuf$StringTable(this, null);
            if ((this.bitField0_ & 1) == 1) {
                this.string_ = this.string_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            protoBuf$StringTable.string_ = this.string_;
            return protoBuf$StringTable;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$StringTable.defaultInstance;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ProtoBuf$StringTable protoBuf$StringTable) {
            if (protoBuf$StringTable == ProtoBuf$StringTable.defaultInstance) {
                return this;
            }
            if (!protoBuf$StringTable.string_.isEmpty()) {
                if (this.string_.isEmpty()) {
                    this.string_ = protoBuf$StringTable.string_;
                    this.bitField0_ &= -2;
                } else {
                    if ((this.bitField0_ & 1) != 1) {
                        this.string_ = new LazyStringArrayList(this.string_);
                        this.bitField0_ |= 1;
                    }
                    this.string_.addAll(protoBuf$StringTable.string_);
                }
            }
            this.unknownFields = this.unknownFields.concat(protoBuf$StringTable.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m938getDefaultInstanceForType() {
            return ProtoBuf$StringTable.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m937clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$StringTable) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$StringTable protoBuf$StringTable;
            ProtoBuf$StringTable protoBuf$StringTable2 = null;
            try {
                ProtoBuf$StringTable protoBuf$StringTable3 = (ProtoBuf$StringTable) ProtoBuf$StringTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$StringTable3 != null) {
                    mergeFrom(protoBuf$StringTable3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$StringTable = (ProtoBuf$StringTable) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$StringTable2 = protoBuf$StringTable;
            }
            if (protoBuf$StringTable2 != null) {
                mergeFrom(protoBuf$StringTable2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$StringTable protoBuf$StringTable = new ProtoBuf$StringTable();
        defaultInstance = protoBuf$StringTable;
        protoBuf$StringTable.string_ = LazyStringArrayList.EMPTY;
    }

    public ProtoBuf$StringTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.unknownFields;
    }

    public MessageLite getDefaultInstanceForType() {
        return defaultInstance;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.string_.size(); i3++) {
            i2 += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i3));
        }
        int size = this.unknownFields.size() + (this.string_.size() * 1) + 0 + i2;
        this.memoizedSerializedSize = size;
        return size;
    }

    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder newBuilderForType() {
        return new Builder();
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder toBuilder() {
        Builder builder = new Builder();
        builder.mergeFrom(this);
        return builder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.string_.size(); i++) {
            ByteString byteString = this.string_.getByteString(i);
            codedOutputStream.writeRawVarint32(10);
            codedOutputStream.writeBytesNoTag(byteString);
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$StringTable() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$StringTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.string_ = LazyStringArrayList.EMPTY;
        Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 10) {
                        ByteString readBytes = codedInputStream.readBytes();
                        if (!z2 || !true) {
                            this.string_ = new LazyStringArrayList();
                            z2 |= true;
                        }
                        this.string_.add(readBytes);
                    } else if (!codedInputStream.skipField(readTag, newInstance)) {
                    }
                }
                z = true;
            } catch (InvalidProtocolBufferException e2) {
                e2.unfinishedMessage = this;
                throw e2;
            } catch (IOException e3) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e3.getMessage());
                invalidProtocolBufferException.unfinishedMessage = this;
                throw invalidProtocolBufferException;
            } catch (Throwable th) {
                if (z2 && true) {
                    this.string_ = this.string_.getUnmodifiableView();
                }
                try {
                    newInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = newOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = newOutput.toByteString();
                throw th;
            }
        }
        if (z2 && true) {
            this.string_ = this.string_.getUnmodifiableView();
        }
        try {
            newInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = newOutput.toByteString();
            throw th3;
        }
        this.unknownFields = newOutput.toByteString();
    }
}
