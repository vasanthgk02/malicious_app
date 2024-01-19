package kotlin.reflect.jvm.internal.impl.metadata;

import com.android.tools.r8.GeneratedOutlineSupport;
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

public final class ProtoBuf$Function extends ExtendableMessage<ProtoBuf$Function> implements Object {
    public static Parser<ProtoBuf$Function> PARSER = new AbstractParser<ProtoBuf$Function>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Function(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$Function defaultInstance;
    public int bitField0_;
    public ProtoBuf$Contract contract_;
    public int flags_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int name_;
    public int oldFlags_;
    public int receiverTypeId_;
    public ProtoBuf$Type receiverType_;
    public int returnTypeId_;
    public ProtoBuf$Type returnType_;
    public List<ProtoBuf$TypeParameter> typeParameter_;
    public ProtoBuf$TypeTable typeTable_;
    public final ByteString unknownFields;
    public List<ProtoBuf$ValueParameter> valueParameter_;
    public List<Integer> versionRequirement_;

    public static final class Builder extends ExtendableBuilder<ProtoBuf$Function, Builder> implements Object {
        public int bitField0_;
        public ProtoBuf$Contract contract_ = ProtoBuf$Contract.defaultInstance;
        public int flags_ = 6;
        public int name_;
        public int oldFlags_ = 6;
        public int receiverTypeId_;
        public ProtoBuf$Type receiverType_ = ProtoBuf$Type.defaultInstance;
        public int returnTypeId_;
        public ProtoBuf$Type returnType_ = ProtoBuf$Type.defaultInstance;
        public List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        public ProtoBuf$TypeTable typeTable_ = ProtoBuf$TypeTable.defaultInstance;
        public List<ProtoBuf$ValueParameter> valueParameter_ = Collections.emptyList();
        public List<Integer> versionRequirement_ = Collections.emptyList();

        public MessageLite build() {
            ProtoBuf$Function buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Function buildPartial() {
            ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Function.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Function.oldFlags_ = this.oldFlags_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Function.name_ = this.name_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$Function.returnType_ = this.returnType_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$Function.returnTypeId_ = this.returnTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            }
            protoBuf$Function.typeParameter_ = this.typeParameter_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$Function.receiverType_ = this.receiverType_;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            protoBuf$Function.receiverTypeId_ = this.receiverTypeId_;
            if ((this.bitField0_ & 256) == 256) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -257;
            }
            protoBuf$Function.valueParameter_ = this.valueParameter_;
            if ((i & 512) == 512) {
                i2 |= 128;
            }
            protoBuf$Function.typeTable_ = this.typeTable_;
            if ((this.bitField0_ & 1024) == 1024) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -1025;
            }
            protoBuf$Function.versionRequirement_ = this.versionRequirement_;
            if ((i & 2048) == 2048) {
                i2 |= 256;
            }
            protoBuf$Function.contract_ = this.contract_;
            protoBuf$Function.bitField0_ = i2;
            return protoBuf$Function;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Function.defaultInstance;
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
            for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
                if (!this.valueParameter_.get(i2).isInitialized()) {
                    return false;
                }
            }
            if (((this.bitField0_ & 512) == 512) && !this.typeTable_.isInitialized()) {
                return false;
            }
            return (!((this.bitField0_ & 2048) == 2048) || this.contract_.isInitialized()) && extensionsAreInitialized();
        }

        public Builder mergeFrom(ProtoBuf$Function protoBuf$Function) {
            if (protoBuf$Function == ProtoBuf$Function.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$Function.bitField0_ & 1) == 1) {
                int i = protoBuf$Function.flags_;
                this.bitField0_ |= 1;
                this.flags_ = i;
            }
            if ((protoBuf$Function.bitField0_ & 2) == 2) {
                int i2 = protoBuf$Function.oldFlags_;
                this.bitField0_ = 2 | this.bitField0_;
                this.oldFlags_ = i2;
            }
            if ((protoBuf$Function.bitField0_ & 4) == 4) {
                int i3 = protoBuf$Function.name_;
                this.bitField0_ = 4 | this.bitField0_;
                this.name_ = i3;
            }
            if (protoBuf$Function.hasReturnType()) {
                ProtoBuf$Type protoBuf$Type = protoBuf$Function.returnType_;
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
            if ((protoBuf$Function.bitField0_ & 16) == 16) {
                int i4 = protoBuf$Function.returnTypeId_;
                this.bitField0_ = 16 | this.bitField0_;
                this.returnTypeId_ = i4;
            }
            if (!protoBuf$Function.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Function.typeParameter_;
                    this.bitField0_ &= -33;
                } else {
                    if ((this.bitField0_ & 32) != 32) {
                        this.typeParameter_ = new ArrayList(this.typeParameter_);
                        this.bitField0_ |= 32;
                    }
                    this.typeParameter_.addAll(protoBuf$Function.typeParameter_);
                }
            }
            if (protoBuf$Function.hasReceiverType()) {
                ProtoBuf$Type protoBuf$Type3 = protoBuf$Function.receiverType_;
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
            if (protoBuf$Function.hasReceiverTypeId()) {
                int i5 = protoBuf$Function.receiverTypeId_;
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i5;
            }
            if (!protoBuf$Function.valueParameter_.isEmpty()) {
                if (this.valueParameter_.isEmpty()) {
                    this.valueParameter_ = protoBuf$Function.valueParameter_;
                    this.bitField0_ &= -257;
                } else {
                    if ((this.bitField0_ & 256) != 256) {
                        this.valueParameter_ = new ArrayList(this.valueParameter_);
                        this.bitField0_ |= 256;
                    }
                    this.valueParameter_.addAll(protoBuf$Function.valueParameter_);
                }
            }
            if ((protoBuf$Function.bitField0_ & 128) == 128) {
                ProtoBuf$TypeTable protoBuf$TypeTable = protoBuf$Function.typeTable_;
                if ((this.bitField0_ & 512) == 512) {
                    ProtoBuf$TypeTable protoBuf$TypeTable2 = this.typeTable_;
                    if (protoBuf$TypeTable2 != ProtoBuf$TypeTable.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.Builder newBuilder = ProtoBuf$TypeTable.newBuilder(protoBuf$TypeTable2);
                        newBuilder.mergeFrom(protoBuf$TypeTable);
                        this.typeTable_ = newBuilder.buildPartial();
                        this.bitField0_ |= 512;
                    }
                }
                this.typeTable_ = protoBuf$TypeTable;
                this.bitField0_ |= 512;
            }
            if (!protoBuf$Function.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Function.versionRequirement_;
                    this.bitField0_ &= -1025;
                } else {
                    if ((this.bitField0_ & 1024) != 1024) {
                        this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                        this.bitField0_ |= 1024;
                    }
                    this.versionRequirement_.addAll(protoBuf$Function.versionRequirement_);
                }
            }
            if ((protoBuf$Function.bitField0_ & 256) != 256) {
                z = false;
            }
            if (z) {
                ProtoBuf$Contract protoBuf$Contract = protoBuf$Function.contract_;
                if ((this.bitField0_ & 2048) == 2048) {
                    ProtoBuf$Contract protoBuf$Contract2 = this.contract_;
                    if (protoBuf$Contract2 != ProtoBuf$Contract.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract.Builder builder = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract.Builder();
                        builder.mergeFrom(protoBuf$Contract2);
                        builder.mergeFrom(protoBuf$Contract);
                        this.contract_ = builder.buildPartial();
                        this.bitField0_ |= 2048;
                    }
                }
                this.contract_ = protoBuf$Contract;
                this.bitField0_ |= 2048;
            }
            mergeExtensionFields(protoBuf$Function);
            this.unknownFields = this.unknownFields.concat(protoBuf$Function.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m926getDefaultInstanceForType() {
            return ProtoBuf$Function.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m925clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$Function) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Function protoBuf$Function;
            ProtoBuf$Function protoBuf$Function2 = null;
            try {
                ProtoBuf$Function protoBuf$Function3 = (ProtoBuf$Function) ProtoBuf$Function.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Function3 != null) {
                    mergeFrom(protoBuf$Function3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Function = (ProtoBuf$Function) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Function2 = protoBuf$Function;
            }
            if (protoBuf$Function2 != null) {
                mergeFrom(protoBuf$Function2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function();
        defaultInstance = protoBuf$Function;
        protoBuf$Function.initFields();
    }

    public ProtoBuf$Function(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
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
        for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i3));
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            computeInt32Size += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            computeInt32Size += CodedOutputStream.computeInt32Size(9, this.flags_);
        }
        if ((this.bitField0_ & 128) == 128) {
            computeInt32Size += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
            i4 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i5).intValue());
        }
        int size = (this.versionRequirement_.size() * 2) + computeInt32Size + i4;
        if ((this.bitField0_ & 256) == 256) {
            size += CodedOutputStream.computeMessageSize(32, this.contract_);
        }
        int size2 = this.unknownFields.size() + extensionsSerializedSize() + size;
        this.memoizedSerializedSize = size2;
        return size2;
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
        this.flags_ = 6;
        this.oldFlags_ = 6;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.defaultInstance;
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = ProtoBuf$Type.defaultInstance;
        this.receiverTypeId_ = 0;
        this.valueParameter_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.defaultInstance;
        this.versionRequirement_ = Collections.emptyList();
        this.contract_ = ProtoBuf$Contract.defaultInstance;
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
                for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
                    if (!this.valueParameter_.get(i2).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!((this.bitField0_ & 128) == 128) || this.typeTable_.isInitialized()) {
                    if (((this.bitField0_ & 256) == 256) && !this.contract_.isInitialized()) {
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
        for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
            codedOutputStream.writeMessage(6, this.valueParameter_.get(i2));
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(9, this.flags_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i3).intValue());
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeMessage(32, this.contract_);
        }
        newExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$Function() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARNING: type inference failed for: r8v2, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARNING: type inference failed for: r8v5, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARNING: type inference failed for: r8v6, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARNING: type inference failed for: r8v9, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder] */
    /* JADX WARNING: type inference failed for: r8v10, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder] */
    /* JADX WARNING: type inference failed for: r8v18, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder] */
    /* JADX WARNING: type inference failed for: r8v19, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder] */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder]
      mth insns count: 231
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProtoBuf$Function(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r11, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r12, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1 r13) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
        /*
            r10 = this;
            r10.<init>()
            r13 = -1
            r10.memoizedIsInitialized = r13
            r10.memoizedSerializedSize = r13
            r10.initFields()
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r13 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
            r0 = 1
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r13, r0)
            r2 = 0
            r3 = 0
        L_0x0016:
            r4 = 32
            r5 = 256(0x100, float:3.59E-43)
            r6 = 1024(0x400, float:1.435E-42)
            if (r2 != 0) goto L_0x01f5
            int r7 = r11.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r8 = 0
            switch(r7) {
                case 0: goto L_0x01a3;
                case 8: goto L_0x0193;
                case 16: goto L_0x0185;
                case 26: goto L_0x015c;
                case 34: goto L_0x0142;
                case 42: goto L_0x011b;
                case 50: goto L_0x0101;
                case 56: goto L_0x00f3;
                case 64: goto L_0x00e5;
                case 72: goto L_0x00d8;
                case 242: goto L_0x00ab;
                case 248: goto L_0x008f;
                case 250: goto L_0x005a;
                case 258: goto L_0x002c;
                default: goto L_0x0026;
            }     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
        L_0x0026:
            boolean r4 = r10.parseUnknownField(r11, r1, r12, r7)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x01a1
        L_0x002c:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 & r5
            if (r7 != r5) goto L_0x003f
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r7 = r10.contract_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            if (r7 == 0) goto L_0x003e
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder r8 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r8.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r8.mergeFrom(r7)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x003f
        L_0x003e:
            throw r8     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
        L_0x003f:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r11.readMessage(r7, r12)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract) r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.contract_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            if (r8 == 0) goto L_0x0054
            r8.mergeFrom(r7)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r7 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.contract_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
        L_0x0054:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 | r5
            r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x005a:
            int r7 = r11.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            int r7 = r11.pushLimit(r7)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r8 = r3 & 1024(0x400, float:1.435E-42)
            if (r8 == r6) goto L_0x0075
            int r8 = r11.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            if (r8 <= 0) goto L_0x0075
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r8.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.versionRequirement_ = r8     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r3 = r3 | 1024(0x400, float:1.435E-42)
        L_0x0075:
            int r8 = r11.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            if (r8 <= 0) goto L_0x0089
            java.util.List<java.lang.Integer> r8 = r10.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            int r9 = r11.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r8.add(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0075
        L_0x0089:
            r11.currentLimit = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r11.recomputeBufferSizeAfterLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x008f:
            r7 = r3 & 1024(0x400, float:1.435E-42)
            if (r7 == r6) goto L_0x009c
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.versionRequirement_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r3 = r3 | 1024(0x400, float:1.435E-42)
        L_0x009c:
            java.util.List<java.lang.Integer> r7 = r10.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            int r8 = r11.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x00ab:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r9 = 128(0x80, float:1.8E-43)
            r7 = r7 & r9
            if (r7 != r9) goto L_0x00bc
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r7 = r10.typeTable_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            if (r7 == 0) goto L_0x00bb
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.newBuilder(r7)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x00bc
        L_0x00bb:
            throw r8     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
        L_0x00bc:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r11.readMessage(r7, r12)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable) r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.typeTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            if (r8 == 0) goto L_0x00d1
            r8.mergeFrom(r7)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r7 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.typeTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
        L_0x00d1:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 | r9
            r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x00d8:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 | r0
            r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            int r7 = r11.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.flags_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x00e5:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 | 64
            r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            int r7 = r11.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.receiverTypeId_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x00f3:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 | 16
            r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            int r7 = r11.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.returnTypeId_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x0101:
            r7 = r3 & 256(0x100, float:3.59E-43)
            if (r7 == r5) goto L_0x010e
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.valueParameter_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r3 = r3 | 256(0x100, float:3.59E-43)
        L_0x010e:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r7 = r10.valueParameter_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r11.readMessage(r8, r12)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x011b:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 & r4
            if (r7 != r4) goto L_0x0126
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r7 = r10.receiverType_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r8 = r7.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
        L_0x0126:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r11.readMessage(r7, r12)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type) r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.receiverType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            if (r8 == 0) goto L_0x013b
            r8.mergeFrom(r7)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r7 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.receiverType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
        L_0x013b:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 | r4
            r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x0142:
            r7 = r3 & 32
            if (r7 == r4) goto L_0x014f
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.typeParameter_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r3 = r3 | 32
        L_0x014f:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r7 = r10.typeParameter_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r11.readMessage(r8, r12)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x015c:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r9 = 8
            r7 = r7 & r9
            if (r7 != r9) goto L_0x0169
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r7 = r10.returnType_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r8 = r7.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
        L_0x0169:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r11.readMessage(r7, r12)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type) r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.returnType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            if (r8 == 0) goto L_0x017e
            r8.mergeFrom(r7)     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r7 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.returnType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
        L_0x017e:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 | r9
            r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x0185:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 | 4
            r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            int r7 = r11.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.name_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x0193:
            int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r7 = r7 | 2
            r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            int r7 = r11.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            r10.oldFlags_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x01b5, IOException -> 0x01a8 }
            goto L_0x0016
        L_0x01a1:
            if (r4 != 0) goto L_0x0016
        L_0x01a3:
            r2 = 1
            goto L_0x0016
        L_0x01a6:
            r11 = move-exception
            goto L_0x01b9
        L_0x01a8:
            r11 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r12 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x01a6 }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01a6 }
            r12.<init>(r11)     // Catch:{ all -> 0x01a6 }
            r12.unfinishedMessage = r10     // Catch:{ all -> 0x01a6 }
            throw r12     // Catch:{ all -> 0x01a6 }
        L_0x01b5:
            r11 = move-exception
            r11.unfinishedMessage = r10     // Catch:{ all -> 0x01a6 }
            throw r11     // Catch:{ all -> 0x01a6 }
        L_0x01b9:
            r12 = r3 & 32
            if (r12 != r4) goto L_0x01c5
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r12 = r10.typeParameter_
            java.util.List r12 = java.util.Collections.unmodifiableList(r12)
            r10.typeParameter_ = r12
        L_0x01c5:
            r12 = r3 & 256(0x100, float:3.59E-43)
            if (r12 != r5) goto L_0x01d1
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r12 = r10.valueParameter_
            java.util.List r12 = java.util.Collections.unmodifiableList(r12)
            r10.valueParameter_ = r12
        L_0x01d1:
            r12 = r3 & 1024(0x400, float:1.435E-42)
            if (r12 != r6) goto L_0x01dd
            java.util.List<java.lang.Integer> r12 = r10.versionRequirement_
            java.util.List r12 = java.util.Collections.unmodifiableList(r12)
            r10.versionRequirement_ = r12
        L_0x01dd:
            r1.flush()     // Catch:{ IOException -> 0x01e9, all -> 0x01e1 }
            goto L_0x01e9
        L_0x01e1:
            r11 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r12 = r13.toByteString()
            r10.unknownFields = r12
            throw r11
        L_0x01e9:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r12 = r13.toByteString()
            r10.unknownFields = r12
            kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor> r12 = r10.extensions
            r12.makeImmutable()
            throw r11
        L_0x01f5:
            r11 = r3 & 32
            if (r11 != r4) goto L_0x0201
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r11 = r10.typeParameter_
            java.util.List r11 = java.util.Collections.unmodifiableList(r11)
            r10.typeParameter_ = r11
        L_0x0201:
            r11 = r3 & 256(0x100, float:3.59E-43)
            if (r11 != r5) goto L_0x020d
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r11 = r10.valueParameter_
            java.util.List r11 = java.util.Collections.unmodifiableList(r11)
            r10.valueParameter_ = r11
        L_0x020d:
            r11 = r3 & 1024(0x400, float:1.435E-42)
            if (r11 != r6) goto L_0x0219
            java.util.List<java.lang.Integer> r11 = r10.versionRequirement_
            java.util.List r11 = java.util.Collections.unmodifiableList(r11)
            r10.versionRequirement_ = r11
        L_0x0219:
            r1.flush()     // Catch:{ IOException -> 0x0225, all -> 0x021d }
            goto L_0x0225
        L_0x021d:
            r11 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r12 = r13.toByteString()
            r10.unknownFields = r12
            throw r11
        L_0x0225:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r13.toByteString()
            r10.unknownFields = r11
            kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor> r11 = r10.extensions
            r11.makeImmutable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1):void");
    }
}
