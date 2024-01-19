package kotlin.reflect.jvm.internal.impl.metadata;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$Property extends ExtendableMessage<ProtoBuf$Property> implements Object {
    public static Parser<ProtoBuf$Property> PARSER = new AbstractParser<ProtoBuf$Property>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Property(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$Property defaultInstance;
    public int bitField0_;
    public int flags_;
    public int getterFlags_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int name_;
    public int oldFlags_;
    public int receiverTypeId_;
    public ProtoBuf$Type receiverType_;
    public int returnTypeId_;
    public ProtoBuf$Type returnType_;
    public int setterFlags_;
    public ProtoBuf$ValueParameter setterValueParameter_;
    public List<ProtoBuf$TypeParameter> typeParameter_;
    public final ByteString unknownFields;
    public List<Integer> versionRequirement_;

    public static final class Builder extends ExtendableBuilder<ProtoBuf$Property, Builder> implements Object {
        public int bitField0_;
        public int flags_ = GL20.GL_GEQUAL;
        public int getterFlags_;
        public int name_;
        public int oldFlags_ = 2054;
        public int receiverTypeId_;
        public ProtoBuf$Type receiverType_ = ProtoBuf$Type.defaultInstance;
        public int returnTypeId_;
        public ProtoBuf$Type returnType_ = ProtoBuf$Type.defaultInstance;
        public int setterFlags_;
        public ProtoBuf$ValueParameter setterValueParameter_ = ProtoBuf$ValueParameter.defaultInstance;
        public List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        public List<Integer> versionRequirement_ = Collections.emptyList();

        public MessageLite build() {
            ProtoBuf$Property buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Property buildPartial() {
            ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Property.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Property.oldFlags_ = this.oldFlags_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Property.name_ = this.name_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$Property.returnType_ = this.returnType_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$Property.returnTypeId_ = this.returnTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            }
            protoBuf$Property.typeParameter_ = this.typeParameter_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$Property.receiverType_ = this.receiverType_;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            protoBuf$Property.receiverTypeId_ = this.receiverTypeId_;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            protoBuf$Property.setterValueParameter_ = this.setterValueParameter_;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            protoBuf$Property.getterFlags_ = this.getterFlags_;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            protoBuf$Property.setterFlags_ = this.setterFlags_;
            if ((this.bitField0_ & 2048) == 2048) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -2049;
            }
            protoBuf$Property.versionRequirement_ = this.versionRequirement_;
            protoBuf$Property.bitField0_ = i2;
            return protoBuf$Property;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Property.defaultInstance;
        }

        public final boolean isInitialized() {
            if (!((this.bitField0_ & 4) == 4)) {
                return false;
            }
            if (((this.bitField0_ & 8) == 8) && !this.returnType_.isInitialized()) {
                return false;
            }
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                if (!this.typeParameter_.get(i).isInitialized()) {
                    return false;
                }
            }
            if (((this.bitField0_ & 64) == 64) && !this.receiverType_.isInitialized()) {
                return false;
            }
            return (!((this.bitField0_ & 256) == 256) || this.setterValueParameter_.isInitialized()) && extensionsAreInitialized();
        }

        public Builder mergeFrom(ProtoBuf$Property protoBuf$Property) {
            if (protoBuf$Property == ProtoBuf$Property.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$Property.bitField0_ & 1) == 1) {
                int i = protoBuf$Property.flags_;
                this.bitField0_ |= 1;
                this.flags_ = i;
            }
            if ((protoBuf$Property.bitField0_ & 2) == 2) {
                int i2 = protoBuf$Property.oldFlags_;
                this.bitField0_ = 2 | this.bitField0_;
                this.oldFlags_ = i2;
            }
            if ((protoBuf$Property.bitField0_ & 4) == 4) {
                int i3 = protoBuf$Property.name_;
                this.bitField0_ = 4 | this.bitField0_;
                this.name_ = i3;
            }
            if (protoBuf$Property.hasReturnType()) {
                ProtoBuf$Type protoBuf$Type = protoBuf$Property.returnType_;
                if ((this.bitField0_ & 8) == 8) {
                    ProtoBuf$Type protoBuf$Type2 = this.returnType_;
                    if (protoBuf$Type2 != ProtoBuf$Type.defaultInstance) {
                        this.returnType_ = GeneratedOutlineSupport.outline90(protoBuf$Type2, protoBuf$Type);
                        this.bitField0_ |= 8;
                    }
                }
                this.returnType_ = protoBuf$Type;
                this.bitField0_ |= 8;
            }
            if ((protoBuf$Property.bitField0_ & 16) == 16) {
                int i4 = protoBuf$Property.returnTypeId_;
                this.bitField0_ = 16 | this.bitField0_;
                this.returnTypeId_ = i4;
            }
            if (!protoBuf$Property.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Property.typeParameter_;
                    this.bitField0_ &= -33;
                } else {
                    if ((this.bitField0_ & 32) != 32) {
                        this.typeParameter_ = new ArrayList(this.typeParameter_);
                        this.bitField0_ |= 32;
                    }
                    this.typeParameter_.addAll(protoBuf$Property.typeParameter_);
                }
            }
            if (protoBuf$Property.hasReceiverType()) {
                ProtoBuf$Type protoBuf$Type3 = protoBuf$Property.receiverType_;
                if ((this.bitField0_ & 64) == 64) {
                    ProtoBuf$Type protoBuf$Type4 = this.receiverType_;
                    if (protoBuf$Type4 != ProtoBuf$Type.defaultInstance) {
                        this.receiverType_ = GeneratedOutlineSupport.outline90(protoBuf$Type4, protoBuf$Type3);
                        this.bitField0_ |= 64;
                    }
                }
                this.receiverType_ = protoBuf$Type3;
                this.bitField0_ |= 64;
            }
            if (protoBuf$Property.hasReceiverTypeId()) {
                int i5 = protoBuf$Property.receiverTypeId_;
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i5;
            }
            if ((protoBuf$Property.bitField0_ & 128) == 128) {
                ProtoBuf$ValueParameter protoBuf$ValueParameter = protoBuf$Property.setterValueParameter_;
                if ((this.bitField0_ & 256) == 256) {
                    ProtoBuf$ValueParameter protoBuf$ValueParameter2 = this.setterValueParameter_;
                    if (protoBuf$ValueParameter2 != ProtoBuf$ValueParameter.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter.Builder builder = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter.Builder();
                        builder.mergeFrom(protoBuf$ValueParameter2);
                        builder.mergeFrom(protoBuf$ValueParameter);
                        this.setterValueParameter_ = builder.buildPartial();
                        this.bitField0_ |= 256;
                    }
                }
                this.setterValueParameter_ = protoBuf$ValueParameter;
                this.bitField0_ |= 256;
            }
            if ((protoBuf$Property.bitField0_ & 256) == 256) {
                int i6 = protoBuf$Property.getterFlags_;
                this.bitField0_ |= 512;
                this.getterFlags_ = i6;
            }
            if ((protoBuf$Property.bitField0_ & 512) != 512) {
                z = false;
            }
            if (z) {
                int i7 = protoBuf$Property.setterFlags_;
                this.bitField0_ |= 1024;
                this.setterFlags_ = i7;
            }
            if (!protoBuf$Property.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Property.versionRequirement_;
                    this.bitField0_ &= -2049;
                } else {
                    if ((this.bitField0_ & 2048) != 2048) {
                        this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                        this.bitField0_ |= 2048;
                    }
                    this.versionRequirement_.addAll(protoBuf$Property.versionRequirement_);
                }
            }
            mergeExtensionFields(protoBuf$Property);
            this.unknownFields = this.unknownFields.concat(protoBuf$Property.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m932getDefaultInstanceForType() {
            return ProtoBuf$Property.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m931clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$Property) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Property protoBuf$Property;
            ProtoBuf$Property protoBuf$Property2 = null;
            try {
                ProtoBuf$Property protoBuf$Property3 = (ProtoBuf$Property) ProtoBuf$Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Property3 != null) {
                    mergeFrom(protoBuf$Property3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Property = (ProtoBuf$Property) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Property2 = protoBuf$Property;
            }
            if (protoBuf$Property2 != null) {
                mergeFrom(protoBuf$Property2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property();
        defaultInstance = protoBuf$Property;
        protoBuf$Property.initFields();
    }

    public ProtoBuf$Property(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
        super(extendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.unknownFields;
    }

    public MessageLite getDefaultInstanceForType() {
        return defaultInstance;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0 : 0;
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            computeInt32Size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            computeInt32Size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            computeInt32Size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            computeInt32Size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            computeInt32Size += CodedOutputStream.computeInt32Size(11, this.flags_);
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
            i3 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i4).intValue());
        }
        int size = this.unknownFields.size() + extensionsSerializedSize() + (this.versionRequirement_.size() * 2) + computeInt32Size + i3;
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasReceiverType() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasReceiverTypeId() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasReturnType() {
        return (this.bitField0_ & 8) == 8;
    }

    public final void initFields() {
        this.flags_ = GL20.GL_GEQUAL;
        this.oldFlags_ = 2054;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.defaultInstance;
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = ProtoBuf$Type.defaultInstance;
        this.receiverTypeId_ = 0;
        this.setterValueParameter_ = ProtoBuf$ValueParameter.defaultInstance;
        this.getterFlags_ = 0;
        this.setterFlags_ = 0;
        this.versionRequirement_ = Collections.emptyList();
    }

    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!((this.bitField0_ & 4) == 4)) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!hasReturnType() || this.returnType_.isInitialized()) {
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                if (!this.typeParameter_.get(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!hasReceiverType() || this.receiverType_.isInitialized()) {
                if (((this.bitField0_ & 128) == 128) && !this.setterValueParameter_.isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = 1;
                    return true;
                }
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        } else {
            this.memoizedIsInitialized = 0;
            return false;
        }
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
        ExtensionWriter newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(1, this.oldFlags_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(3, this.returnType_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(4, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeMessage(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeInt32(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(11, this.flags_);
        }
        for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i2).intValue());
        }
        newExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$Property() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARNING: type inference failed for: r7v2, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARNING: type inference failed for: r7v5, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARNING: type inference failed for: r7v6, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARNING: type inference failed for: r7v7, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder] */
    /* JADX WARNING: type inference failed for: r7v8, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder] */
    /* JADX WARNING: type inference failed for: r7v16 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r7v18 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder]
      mth insns count: 202
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProtoBuf$Property(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r10, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r11, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1 r12) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
        /*
            r9 = this;
            r9.<init>()
            r12 = -1
            r9.memoizedIsInitialized = r12
            r9.memoizedSerializedSize = r12
            r9.initFields()
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r12 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
            r0 = 1
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r12, r0)
            r2 = 0
            r3 = 0
        L_0x0016:
            r4 = 32
            r5 = 2048(0x800, float:2.87E-42)
            if (r2 != 0) goto L_0x01bc
            int r6 = r10.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r7 = 0
            switch(r6) {
                case 0: goto L_0x0176;
                case 8: goto L_0x0166;
                case 16: goto L_0x0158;
                case 26: goto L_0x012f;
                case 34: goto L_0x0115;
                case 42: goto L_0x00ee;
                case 50: goto L_0x00bd;
                case 56: goto L_0x00af;
                case 64: goto L_0x00a1;
                case 72: goto L_0x0093;
                case 80: goto L_0x0086;
                case 88: goto L_0x007a;
                case 248: goto L_0x005f;
                case 250: goto L_0x002a;
                default: goto L_0x0024;
            }     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
        L_0x0024:
            boolean r4 = r9.parseUnknownField(r10, r1, r11, r6)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0174
        L_0x002a:
            int r6 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r6 = r10.pushLimit(r6)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r7 = r3 & 2048(0x800, float:2.87E-42)
            if (r7 == r5) goto L_0x0045
            int r7 = r10.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            if (r7 <= 0) goto L_0x0045
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.versionRequirement_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r3 = r3 | 2048(0x800, float:2.87E-42)
        L_0x0045:
            int r7 = r10.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            if (r7 <= 0) goto L_0x0059
            java.util.List<java.lang.Integer> r7 = r9.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r8 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0045
        L_0x0059:
            r10.currentLimit = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r10.recomputeBufferSizeAfterLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x005f:
            r6 = r3 & 2048(0x800, float:2.87E-42)
            if (r6 == r5) goto L_0x006c
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.versionRequirement_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r3 = r3 | 2048(0x800, float:2.87E-42)
        L_0x006c:
            java.util.List<java.lang.Integer> r6 = r9.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r7 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6.add(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x007a:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | r0
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r6 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.flags_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x0086:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | 64
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r6 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.receiverTypeId_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x0093:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | 16
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r6 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.returnTypeId_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x00a1:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | 512(0x200, float:7.17E-43)
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r6 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.setterFlags_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x00af:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | 256(0x100, float:3.59E-43)
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r6 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.getterFlags_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x00bd:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r8 = 128(0x80, float:1.8E-43)
            r6 = r6 & r8
            if (r6 != r8) goto L_0x00d2
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r6 = r9.setterValueParameter_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            if (r6 == 0) goto L_0x00d1
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder r7 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r7.mergeFrom(r6)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x00d2
        L_0x00d1:
            throw r7     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
        L_0x00d2:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, r11)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter) r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.setterValueParameter_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            if (r7 == 0) goto L_0x00e7
            r7.mergeFrom(r6)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r6 = r7.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.setterValueParameter_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
        L_0x00e7:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | r8
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x00ee:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 & r4
            if (r6 != r4) goto L_0x00f9
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r6 = r9.receiverType_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r7 = r6.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
        L_0x00f9:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, r11)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type) r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.receiverType_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            if (r7 == 0) goto L_0x010e
            r7.mergeFrom(r6)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r6 = r7.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.receiverType_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
        L_0x010e:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | r4
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x0115:
            r6 = r3 & 32
            if (r6 == r4) goto L_0x0122
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.typeParameter_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r3 = r3 | 32
        L_0x0122:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r6 = r9.typeParameter_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r10.readMessage(r7, r11)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6.add(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x012f:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r8 = 8
            r6 = r6 & r8
            if (r6 != r8) goto L_0x013c
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r6 = r9.returnType_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r7 = r6.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
        L_0x013c:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, r11)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type) r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.returnType_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            if (r7 == 0) goto L_0x0151
            r7.mergeFrom(r6)     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r6 = r7.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.returnType_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
        L_0x0151:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | r8
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x0158:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | 4
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r6 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.name_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x0166:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r6 = r6 | 2
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            int r6 = r10.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            r9.oldFlags_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x0188, IOException -> 0x017b }
            goto L_0x0016
        L_0x0174:
            if (r4 != 0) goto L_0x0016
        L_0x0176:
            r2 = 1
            goto L_0x0016
        L_0x0179:
            r10 = move-exception
            goto L_0x018c
        L_0x017b:
            r10 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r11 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0179 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0179 }
            r11.<init>(r10)     // Catch:{ all -> 0x0179 }
            r11.unfinishedMessage = r9     // Catch:{ all -> 0x0179 }
            throw r11     // Catch:{ all -> 0x0179 }
        L_0x0188:
            r10 = move-exception
            r10.unfinishedMessage = r9     // Catch:{ all -> 0x0179 }
            throw r10     // Catch:{ all -> 0x0179 }
        L_0x018c:
            r11 = r3 & 32
            if (r11 != r4) goto L_0x0198
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r11 = r9.typeParameter_
            java.util.List r11 = java.util.Collections.unmodifiableList(r11)
            r9.typeParameter_ = r11
        L_0x0198:
            r11 = r3 & 2048(0x800, float:2.87E-42)
            if (r11 != r5) goto L_0x01a4
            java.util.List<java.lang.Integer> r11 = r9.versionRequirement_
            java.util.List r11 = java.util.Collections.unmodifiableList(r11)
            r9.versionRequirement_ = r11
        L_0x01a4:
            r1.flush()     // Catch:{ IOException -> 0x01b0, all -> 0x01a8 }
            goto L_0x01b0
        L_0x01a8:
            r10 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r12.toByteString()
            r9.unknownFields = r11
            throw r10
        L_0x01b0:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r12.toByteString()
            r9.unknownFields = r11
            kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor> r11 = r9.extensions
            r11.makeImmutable()
            throw r10
        L_0x01bc:
            r10 = r3 & 32
            if (r10 != r4) goto L_0x01c8
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r10 = r9.typeParameter_
            java.util.List r10 = java.util.Collections.unmodifiableList(r10)
            r9.typeParameter_ = r10
        L_0x01c8:
            r10 = r3 & 2048(0x800, float:2.87E-42)
            if (r10 != r5) goto L_0x01d4
            java.util.List<java.lang.Integer> r10 = r9.versionRequirement_
            java.util.List r10 = java.util.Collections.unmodifiableList(r10)
            r9.versionRequirement_ = r10
        L_0x01d4:
            r1.flush()     // Catch:{ IOException -> 0x01e0, all -> 0x01d8 }
            goto L_0x01e0
        L_0x01d8:
            r10 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r12.toByteString()
            r9.unknownFields = r11
            throw r10
        L_0x01e0:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r10 = r12.toByteString()
            r9.unknownFields = r10
            kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor> r10 = r9.extensions
            r10.makeImmutable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1):void");
    }
}
