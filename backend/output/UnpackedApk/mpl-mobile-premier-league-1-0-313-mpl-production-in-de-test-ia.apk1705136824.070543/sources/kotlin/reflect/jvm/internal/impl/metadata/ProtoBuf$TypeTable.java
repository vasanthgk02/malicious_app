package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$TypeTable extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$TypeTable> PARSER = new AbstractParser<ProtoBuf$TypeTable>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$TypeTable(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$TypeTable defaultInstance;
    public int bitField0_;
    public int firstNullable_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public List<ProtoBuf$Type> type_;
    public final ByteString unknownFields;

    public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<ProtoBuf$TypeTable, Builder> implements Object {
        public int bitField0_;
        public int firstNullable_ = -1;
        public List<ProtoBuf$Type> type_ = Collections.emptyList();

        public MessageLite build() {
            ProtoBuf$TypeTable buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$TypeTable buildPartial() {
            ProtoBuf$TypeTable protoBuf$TypeTable = new ProtoBuf$TypeTable(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) == 1) {
                this.type_ = Collections.unmodifiableList(this.type_);
                this.bitField0_ &= -2;
            }
            protoBuf$TypeTable.type_ = this.type_;
            if ((i & 2) != 2) {
                i2 = 0;
            }
            protoBuf$TypeTable.firstNullable_ = this.firstNullable_;
            protoBuf$TypeTable.bitField0_ = i2;
            return protoBuf$TypeTable;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$TypeTable.defaultInstance;
        }

        public final boolean isInitialized() {
            for (int i = 0; i < this.type_.size(); i++) {
                if (!this.type_.get(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public Builder mergeFrom(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if (protoBuf$TypeTable == ProtoBuf$TypeTable.defaultInstance) {
                return this;
            }
            boolean z = true;
            if (!protoBuf$TypeTable.type_.isEmpty()) {
                if (this.type_.isEmpty()) {
                    this.type_ = protoBuf$TypeTable.type_;
                    this.bitField0_ &= -2;
                } else {
                    if ((this.bitField0_ & 1) != 1) {
                        this.type_ = new ArrayList(this.type_);
                        this.bitField0_ |= 1;
                    }
                    this.type_.addAll(protoBuf$TypeTable.type_);
                }
            }
            if ((protoBuf$TypeTable.bitField0_ & 1) != 1) {
                z = false;
            }
            if (z) {
                int i = protoBuf$TypeTable.firstNullable_;
                this.bitField0_ |= 2;
                this.firstNullable_ = i;
            }
            this.unknownFields = this.unknownFields.concat(protoBuf$TypeTable.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m949getDefaultInstanceForType() {
            return ProtoBuf$TypeTable.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m948clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$TypeTable) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$TypeTable protoBuf$TypeTable;
            ProtoBuf$TypeTable protoBuf$TypeTable2 = null;
            try {
                ProtoBuf$TypeTable protoBuf$TypeTable3 = (ProtoBuf$TypeTable) ProtoBuf$TypeTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$TypeTable3 != null) {
                    mergeFrom(protoBuf$TypeTable3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$TypeTable = (ProtoBuf$TypeTable) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$TypeTable2 = protoBuf$TypeTable;
            }
            if (protoBuf$TypeTable2 != null) {
                mergeFrom(protoBuf$TypeTable2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$TypeTable protoBuf$TypeTable = new ProtoBuf$TypeTable();
        defaultInstance = protoBuf$TypeTable;
        protoBuf$TypeTable.type_ = Collections.emptyList();
        protoBuf$TypeTable.firstNullable_ = -1;
    }

    public ProtoBuf$TypeTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$TypeTable protoBuf$TypeTable) {
        Builder builder = new Builder();
        builder.mergeFrom(protoBuf$TypeTable);
        return builder;
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
        for (int i3 = 0; i3 < this.type_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.type_.get(i3));
        }
        if ((this.bitField0_ & 1) == 1) {
            i2 += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
        }
        int size = this.unknownFields.size() + i2;
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
        for (int i = 0; i < this.type_.size(); i++) {
            if (!this.type_.get(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder newBuilderForType() {
        return new Builder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.type_.size(); i++) {
            codedOutputStream.writeMessage(1, this.type_.get(i));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(2, this.firstNullable_);
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    /* renamed from: toBuilder  reason: collision with other method in class */
    public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder m947toBuilder() {
        return newBuilder(this);
    }

    public ProtoBuf$TypeTable() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$TypeTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.type_ = Collections.emptyList();
        this.firstNullable_ = -1;
        Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 10) {
                        if (!z2 || !true) {
                            this.type_ = new ArrayList();
                            z2 |= true;
                        }
                        this.type_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                    } else if (readTag == 16) {
                        this.bitField0_ |= 1;
                        this.firstNullable_ = codedInputStream.readRawVarint32();
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
                    this.type_ = Collections.unmodifiableList(this.type_);
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
            this.type_ = Collections.unmodifiableList(this.type_);
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
