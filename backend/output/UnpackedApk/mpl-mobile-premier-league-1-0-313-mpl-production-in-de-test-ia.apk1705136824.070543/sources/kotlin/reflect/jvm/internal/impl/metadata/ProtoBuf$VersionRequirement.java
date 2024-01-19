package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
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

public final class ProtoBuf$VersionRequirement extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$VersionRequirement> PARSER = new AbstractParser<ProtoBuf$VersionRequirement>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$VersionRequirement(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$VersionRequirement defaultInstance;
    public int bitField0_;
    public int errorCode_;
    public Level level_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int message_;
    public final ByteString unknownFields;
    public int versionFull_;
    public VersionKind versionKind_;
    public int version_;

    public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<ProtoBuf$VersionRequirement, Builder> implements Object {
        public int bitField0_;
        public int errorCode_;
        public Level level_ = Level.ERROR;
        public int message_;
        public int versionFull_;
        public VersionKind versionKind_ = VersionKind.LANGUAGE_VERSION;
        public int version_;

        public MessageLite build() {
            ProtoBuf$VersionRequirement buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$VersionRequirement buildPartial() {
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$VersionRequirement.version_ = this.version_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$VersionRequirement.versionFull_ = this.versionFull_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$VersionRequirement.level_ = this.level_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$VersionRequirement.errorCode_ = this.errorCode_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$VersionRequirement.message_ = this.message_;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            protoBuf$VersionRequirement.versionKind_ = this.versionKind_;
            protoBuf$VersionRequirement.bitField0_ = i2;
            return protoBuf$VersionRequirement;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$VersionRequirement.defaultInstance;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ProtoBuf$VersionRequirement protoBuf$VersionRequirement) {
            if (protoBuf$VersionRequirement == ProtoBuf$VersionRequirement.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$VersionRequirement.bitField0_ & 1) == 1) {
                int i = protoBuf$VersionRequirement.version_;
                this.bitField0_ |= 1;
                this.version_ = i;
            }
            if ((protoBuf$VersionRequirement.bitField0_ & 2) == 2) {
                int i2 = protoBuf$VersionRequirement.versionFull_;
                this.bitField0_ = 2 | this.bitField0_;
                this.versionFull_ = i2;
            }
            if ((protoBuf$VersionRequirement.bitField0_ & 4) == 4) {
                Level level = protoBuf$VersionRequirement.level_;
                if (level != null) {
                    this.bitField0_ = 4 | this.bitField0_;
                    this.level_ = level;
                } else {
                    throw null;
                }
            }
            if ((protoBuf$VersionRequirement.bitField0_ & 8) == 8) {
                int i3 = protoBuf$VersionRequirement.errorCode_;
                this.bitField0_ = 8 | this.bitField0_;
                this.errorCode_ = i3;
            }
            if ((protoBuf$VersionRequirement.bitField0_ & 16) == 16) {
                int i4 = protoBuf$VersionRequirement.message_;
                this.bitField0_ = 16 | this.bitField0_;
                this.message_ = i4;
            }
            if ((protoBuf$VersionRequirement.bitField0_ & 32) != 32) {
                z = false;
            }
            if (z) {
                VersionKind versionKind = protoBuf$VersionRequirement.versionKind_;
                if (versionKind != null) {
                    this.bitField0_ |= 32;
                    this.versionKind_ = versionKind;
                } else {
                    throw null;
                }
            }
            this.unknownFields = this.unknownFields.concat(protoBuf$VersionRequirement.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m953getDefaultInstanceForType() {
            return ProtoBuf$VersionRequirement.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m952clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$VersionRequirement) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement;
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement2 = null;
            try {
                ProtoBuf$VersionRequirement protoBuf$VersionRequirement3 = (ProtoBuf$VersionRequirement) ProtoBuf$VersionRequirement.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$VersionRequirement3 != null) {
                    mergeFrom(protoBuf$VersionRequirement3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$VersionRequirement = (ProtoBuf$VersionRequirement) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$VersionRequirement2 = protoBuf$VersionRequirement;
            }
            if (protoBuf$VersionRequirement2 != null) {
                mergeFrom(protoBuf$VersionRequirement2);
            }
            throw th;
        }
    }

    public enum Level implements EnumLite {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);
        
        public static EnumLiteMap<Level> internalValueMap;
        public final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<Level>() {
                public EnumLite findValueByNumber(int i) {
                    return Level.valueOf(i);
                }
            };
        }

        /* access modifiers changed from: public */
        Level(int i, int i2) {
            this.value = i2;
        }

        public final int getNumber() {
            return this.value;
        }

        public static Level valueOf(int i) {
            if (i == 0) {
                return WARNING;
            }
            if (i == 1) {
                return ERROR;
            }
            if (i != 2) {
                return null;
            }
            return HIDDEN;
        }
    }

    public enum VersionKind implements EnumLite {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);
        
        public static EnumLiteMap<VersionKind> internalValueMap;
        public final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<VersionKind>() {
                public EnumLite findValueByNumber(int i) {
                    return VersionKind.valueOf(i);
                }
            };
        }

        /* access modifiers changed from: public */
        VersionKind(int i, int i2) {
            this.value = i2;
        }

        public final int getNumber() {
            return this.value;
        }

        public static VersionKind valueOf(int i) {
            if (i == 0) {
                return LANGUAGE_VERSION;
            }
            if (i == 1) {
                return COMPILER_VERSION;
            }
            if (i != 2) {
                return null;
            }
            return API_VERSION;
        }
    }

    static {
        ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement();
        defaultInstance = protoBuf$VersionRequirement;
        protoBuf$VersionRequirement.version_ = 0;
        protoBuf$VersionRequirement.versionFull_ = 0;
        protoBuf$VersionRequirement.level_ = Level.ERROR;
        protoBuf$VersionRequirement.errorCode_ = 0;
        protoBuf$VersionRequirement.message_ = 0;
        protoBuf$VersionRequirement.versionKind_ = VersionKind.LANGUAGE_VERSION;
    }

    public ProtoBuf$VersionRequirement(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
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
            i2 = 0 + CodedOutputStream.computeInt32Size(1, this.version_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.computeInt32Size(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i2 += CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            i2 += CodedOutputStream.computeInt32Size(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            i2 += CodedOutputStream.computeInt32Size(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            i2 += CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
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

    public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder toBuilder() {
        Builder builder = new Builder();
        builder.mergeFrom(this);
        return builder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.version_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.level_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeEnum(6, this.versionKind_.getNumber());
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$VersionRequirement() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$VersionRequirement(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        boolean z = false;
        this.version_ = 0;
        this.versionFull_ = 0;
        this.level_ = Level.ERROR;
        this.errorCode_ = 0;
        this.message_ = 0;
        this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 8) {
                        this.bitField0_ |= 1;
                        this.version_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 16) {
                        this.bitField0_ |= 2;
                        this.versionFull_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 24) {
                        int readRawVarint32 = codedInputStream.readRawVarint32();
                        Level valueOf = Level.valueOf(readRawVarint32);
                        if (valueOf == null) {
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readRawVarint32);
                        } else {
                            this.bitField0_ |= 4;
                            this.level_ = valueOf;
                        }
                    } else if (readTag == 32) {
                        this.bitField0_ |= 8;
                        this.errorCode_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 40) {
                        this.bitField0_ |= 16;
                        this.message_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 48) {
                        int readRawVarint322 = codedInputStream.readRawVarint32();
                        VersionKind valueOf2 = VersionKind.valueOf(readRawVarint322);
                        if (valueOf2 == null) {
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readRawVarint322);
                        } else {
                            this.bitField0_ |= 32;
                            this.versionKind_ = valueOf2;
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
