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
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$QualifiedNameTable extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$QualifiedNameTable> PARSER = new AbstractParser<ProtoBuf$QualifiedNameTable>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$QualifiedNameTable(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$QualifiedNameTable defaultInstance;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public List<QualifiedName> qualifiedName_;
    public final ByteString unknownFields;

    public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<ProtoBuf$QualifiedNameTable, Builder> implements Object {
        public int bitField0_;
        public List<QualifiedName> qualifiedName_ = Collections.emptyList();

        public MessageLite build() {
            ProtoBuf$QualifiedNameTable buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$QualifiedNameTable buildPartial() {
            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = new ProtoBuf$QualifiedNameTable(this, null);
            if ((this.bitField0_ & 1) == 1) {
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                this.bitField0_ &= -2;
            }
            protoBuf$QualifiedNameTable.qualifiedName_ = this.qualifiedName_;
            return protoBuf$QualifiedNameTable;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$QualifiedNameTable.defaultInstance;
        }

        public final boolean isInitialized() {
            for (int i = 0; i < this.qualifiedName_.size(); i++) {
                if (!this.qualifiedName_.get(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public Builder mergeFrom(ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
            if (protoBuf$QualifiedNameTable == ProtoBuf$QualifiedNameTable.defaultInstance) {
                return this;
            }
            if (!protoBuf$QualifiedNameTable.qualifiedName_.isEmpty()) {
                if (this.qualifiedName_.isEmpty()) {
                    this.qualifiedName_ = protoBuf$QualifiedNameTable.qualifiedName_;
                    this.bitField0_ &= -2;
                } else {
                    if ((this.bitField0_ & 1) != 1) {
                        this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                        this.bitField0_ |= 1;
                    }
                    this.qualifiedName_.addAll(protoBuf$QualifiedNameTable.qualifiedName_);
                }
            }
            this.unknownFields = this.unknownFields.concat(protoBuf$QualifiedNameTable.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m934getDefaultInstanceForType() {
            return ProtoBuf$QualifiedNameTable.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m933clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$QualifiedNameTable) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable;
            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable2 = null;
            try {
                ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable3 = (ProtoBuf$QualifiedNameTable) ProtoBuf$QualifiedNameTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$QualifiedNameTable3 != null) {
                    mergeFrom(protoBuf$QualifiedNameTable3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$QualifiedNameTable = (ProtoBuf$QualifiedNameTable) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$QualifiedNameTable2 = protoBuf$QualifiedNameTable;
            }
            if (protoBuf$QualifiedNameTable2 != null) {
                mergeFrom(protoBuf$QualifiedNameTable2);
            }
            throw th;
        }
    }

    public static final class QualifiedName extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<QualifiedName> PARSER = new AbstractParser<QualifiedName>() {
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new QualifiedName(codedInputStream, extensionRegistryLite, null);
            }
        };
        public static final QualifiedName defaultInstance;
        public int bitField0_;
        public Kind kind_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public int parentQualifiedName_;
        public int shortName_;
        public final ByteString unknownFields;

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<QualifiedName, Builder> implements Object {
            public int bitField0_;
            public Kind kind_ = Kind.PACKAGE;
            public int parentQualifiedName_ = -1;
            public int shortName_;

            public MessageLite build() {
                QualifiedName buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw new UninitializedMessageException();
            }

            public QualifiedName buildPartial() {
                QualifiedName qualifiedName = new QualifiedName(this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                qualifiedName.parentQualifiedName_ = this.parentQualifiedName_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                qualifiedName.shortName_ = this.shortName_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                qualifiedName.kind_ = this.kind_;
                qualifiedName.bitField0_ = i2;
                return qualifiedName;
            }

            public Object clone() throws CloneNotSupportedException {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public GeneratedMessageLite getDefaultInstanceForType() {
                return QualifiedName.defaultInstance;
            }

            public final boolean isInitialized() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder mergeFrom(QualifiedName qualifiedName) {
                if (qualifiedName == QualifiedName.defaultInstance) {
                    return this;
                }
                boolean z = true;
                if ((qualifiedName.bitField0_ & 1) == 1) {
                    int i = qualifiedName.parentQualifiedName_;
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = i;
                }
                if ((qualifiedName.bitField0_ & 2) == 2) {
                    int i2 = qualifiedName.shortName_;
                    this.bitField0_ = 2 | this.bitField0_;
                    this.shortName_ = i2;
                }
                if ((qualifiedName.bitField0_ & 4) != 4) {
                    z = false;
                }
                if (z) {
                    Kind kind = qualifiedName.kind_;
                    if (kind != null) {
                        this.bitField0_ |= 4;
                        this.kind_ = kind;
                    } else {
                        throw null;
                    }
                }
                this.unknownFields = this.unknownFields.concat(qualifiedName.unknownFields);
                return this;
            }

            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public MessageLite m936getDefaultInstanceForType() {
                return QualifiedName.defaultInstance;
            }

            /* renamed from: clone  reason: collision with other method in class */
            public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m935clone() {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
                mergeFrom((QualifiedName) generatedMessageLite);
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                QualifiedName qualifiedName;
                QualifiedName qualifiedName2 = null;
                try {
                    QualifiedName qualifiedName3 = (QualifiedName) QualifiedName.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (qualifiedName3 != null) {
                        mergeFrom(qualifiedName3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    qualifiedName = (QualifiedName) e2.unfinishedMessage;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    qualifiedName2 = qualifiedName;
                }
                if (qualifiedName2 != null) {
                    mergeFrom(qualifiedName2);
                }
                throw th;
            }
        }

        public enum Kind implements EnumLite {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);
            
            public static EnumLiteMap<Kind> internalValueMap;
            public final int value;

            /* access modifiers changed from: public */
            static {
                internalValueMap = new EnumLiteMap<Kind>() {
                    public EnumLite findValueByNumber(int i) {
                        return Kind.valueOf(i);
                    }
                };
            }

            /* access modifiers changed from: public */
            Kind(int i, int i2) {
                this.value = i2;
            }

            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i) {
                if (i == 0) {
                    return CLASS;
                }
                if (i == 1) {
                    return PACKAGE;
                }
                if (i != 2) {
                    return null;
                }
                return LOCAL;
            }
        }

        static {
            QualifiedName qualifiedName = new QualifiedName();
            defaultInstance = qualifiedName;
            qualifiedName.parentQualifiedName_ = -1;
            qualifiedName.shortName_ = 0;
            qualifiedName.kind_ = Kind.PACKAGE;
        }

        public QualifiedName(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
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
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
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
            if (!((this.bitField0_ & 2) == 2)) {
                this.memoizedIsInitialized = 0;
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.parentQualifiedName_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.kind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public QualifiedName() {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public QualifiedName(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.parentQualifiedName_ = -1;
            boolean z = false;
            this.shortName_ = 0;
            this.kind_ = Kind.PACKAGE;
            Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.parentQualifiedName_ = codedInputStream.readRawVarint32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.shortName_ = codedInputStream.readRawVarint32();
                        } else if (readTag == 24) {
                            int readRawVarint32 = codedInputStream.readRawVarint32();
                            Kind valueOf = Kind.valueOf(readRawVarint32);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readRawVarint32);
                            } else {
                                this.bitField0_ |= 4;
                                this.kind_ = valueOf;
                            }
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

    static {
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = new ProtoBuf$QualifiedNameTable();
        defaultInstance = protoBuf$QualifiedNameTable;
        protoBuf$QualifiedNameTable.qualifiedName_ = Collections.emptyList();
    }

    public ProtoBuf$QualifiedNameTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
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
        for (int i3 = 0; i3 < this.qualifiedName_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i3));
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
        for (int i = 0; i < this.qualifiedName_.size(); i++) {
            if (!this.qualifiedName_.get(i).isInitialized()) {
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

    public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder toBuilder() {
        Builder builder = new Builder();
        builder.mergeFrom(this);
        return builder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.qualifiedName_.size(); i++) {
            codedOutputStream.writeMessage(1, this.qualifiedName_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$QualifiedNameTable() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$QualifiedNameTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.qualifiedName_ = Collections.emptyList();
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
                            this.qualifiedName_ = new ArrayList();
                            z2 |= true;
                        }
                        this.qualifiedName_.add(codedInputStream.readMessage(QualifiedName.PARSER, extensionRegistryLite));
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
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
