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

public final class ProtoBuf$VersionRequirementTable extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$VersionRequirementTable> PARSER = new AbstractParser<ProtoBuf$VersionRequirementTable>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$VersionRequirementTable(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$VersionRequirementTable defaultInstance;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public List<ProtoBuf$VersionRequirement> requirement_;
    public final ByteString unknownFields;

    public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<ProtoBuf$VersionRequirementTable, Builder> implements Object {
        public int bitField0_;
        public List<ProtoBuf$VersionRequirement> requirement_ = Collections.emptyList();

        public MessageLite build() {
            ProtoBuf$VersionRequirementTable buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$VersionRequirementTable buildPartial() {
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = new ProtoBuf$VersionRequirementTable(this, null);
            if ((this.bitField0_ & 1) == 1) {
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
                this.bitField0_ &= -2;
            }
            protoBuf$VersionRequirementTable.requirement_ = this.requirement_;
            return protoBuf$VersionRequirementTable;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$VersionRequirementTable.defaultInstance;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if (protoBuf$VersionRequirementTable == ProtoBuf$VersionRequirementTable.defaultInstance) {
                return this;
            }
            if (!protoBuf$VersionRequirementTable.requirement_.isEmpty()) {
                if (this.requirement_.isEmpty()) {
                    this.requirement_ = protoBuf$VersionRequirementTable.requirement_;
                    this.bitField0_ &= -2;
                } else {
                    if ((this.bitField0_ & 1) != 1) {
                        this.requirement_ = new ArrayList(this.requirement_);
                        this.bitField0_ |= 1;
                    }
                    this.requirement_.addAll(protoBuf$VersionRequirementTable.requirement_);
                }
            }
            this.unknownFields = this.unknownFields.concat(protoBuf$VersionRequirementTable.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m956getDefaultInstanceForType() {
            return ProtoBuf$VersionRequirementTable.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m955clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$VersionRequirementTable) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable;
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable2 = null;
            try {
                ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable3 = (ProtoBuf$VersionRequirementTable) ProtoBuf$VersionRequirementTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$VersionRequirementTable3 != null) {
                    mergeFrom(protoBuf$VersionRequirementTable3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$VersionRequirementTable = (ProtoBuf$VersionRequirementTable) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$VersionRequirementTable2 = protoBuf$VersionRequirementTable;
            }
            if (protoBuf$VersionRequirementTable2 != null) {
                mergeFrom(protoBuf$VersionRequirementTable2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = new ProtoBuf$VersionRequirementTable();
        defaultInstance = protoBuf$VersionRequirementTable;
        protoBuf$VersionRequirementTable.requirement_ = Collections.emptyList();
    }

    public ProtoBuf$VersionRequirementTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
        Builder builder = new Builder();
        builder.mergeFrom(protoBuf$VersionRequirementTable);
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
        for (int i3 = 0; i3 < this.requirement_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.requirement_.get(i3));
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
        for (int i = 0; i < this.requirement_.size(); i++) {
            codedOutputStream.writeMessage(1, this.requirement_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    /* renamed from: toBuilder  reason: collision with other method in class */
    public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder m954toBuilder() {
        return newBuilder(this);
    }

    public ProtoBuf$VersionRequirementTable() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$VersionRequirementTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.requirement_ = Collections.emptyList();
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
                            this.requirement_ = new ArrayList();
                            z2 |= true;
                        }
                        this.requirement_.add(codedInputStream.readMessage(ProtoBuf$VersionRequirement.PARSER, extensionRegistryLite));
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
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
