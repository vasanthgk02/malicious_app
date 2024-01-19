package kotlin.reflect.jvm.internal.impl.metadata;

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
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$Class extends ExtendableMessage<ProtoBuf$Class> implements Object {
    public static Parser<ProtoBuf$Class> PARSER = new AbstractParser<ProtoBuf$Class>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Class(codedInputStream, extensionRegistryLite);
        }
    };
    public static final ProtoBuf$Class defaultInstance;
    public int bitField0_;
    public int companionObjectName_;
    public List<ProtoBuf$Constructor> constructor_;
    public List<ProtoBuf$EnumEntry> enumEntry_;
    public int flags_;
    public int fqName_;
    public List<ProtoBuf$Function> function_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int nestedClassNameMemoizedSerializedSize;
    public List<Integer> nestedClassName_;
    public List<ProtoBuf$Property> property_;
    public int sealedSubclassFqNameMemoizedSerializedSize;
    public List<Integer> sealedSubclassFqName_;
    public int supertypeIdMemoizedSerializedSize;
    public List<Integer> supertypeId_;
    public List<ProtoBuf$Type> supertype_;
    public List<ProtoBuf$TypeAlias> typeAlias_;
    public List<ProtoBuf$TypeParameter> typeParameter_;
    public ProtoBuf$TypeTable typeTable_;
    public final ByteString unknownFields;
    public ProtoBuf$VersionRequirementTable versionRequirementTable_;
    public List<Integer> versionRequirement_;

    public static final class Builder extends ExtendableBuilder<ProtoBuf$Class, Builder> implements Object {
        public int bitField0_;
        public int companionObjectName_;
        public List<ProtoBuf$Constructor> constructor_ = Collections.emptyList();
        public List<ProtoBuf$EnumEntry> enumEntry_ = Collections.emptyList();
        public int flags_ = 6;
        public int fqName_;
        public List<ProtoBuf$Function> function_ = Collections.emptyList();
        public List<Integer> nestedClassName_ = Collections.emptyList();
        public List<ProtoBuf$Property> property_ = Collections.emptyList();
        public List<Integer> sealedSubclassFqName_ = Collections.emptyList();
        public List<Integer> supertypeId_ = Collections.emptyList();
        public List<ProtoBuf$Type> supertype_ = Collections.emptyList();
        public List<ProtoBuf$TypeAlias> typeAlias_ = Collections.emptyList();
        public List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        public ProtoBuf$TypeTable typeTable_ = ProtoBuf$TypeTable.defaultInstance;
        public ProtoBuf$VersionRequirementTable versionRequirementTable_ = ProtoBuf$VersionRequirementTable.defaultInstance;
        public List<Integer> versionRequirement_ = Collections.emptyList();

        public MessageLite build() {
            ProtoBuf$Class buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Class buildPartial() {
            ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class((ExtendableBuilder) this, (ProtoBuf$1) null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Class.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Class.fqName_ = this.fqName_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Class.companionObjectName_ = this.companionObjectName_;
            if ((this.bitField0_ & 8) == 8) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -9;
            }
            protoBuf$Class.typeParameter_ = this.typeParameter_;
            if ((this.bitField0_ & 16) == 16) {
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
                this.bitField0_ &= -17;
            }
            protoBuf$Class.supertype_ = this.supertype_;
            if ((this.bitField0_ & 32) == 32) {
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                this.bitField0_ &= -33;
            }
            protoBuf$Class.supertypeId_ = this.supertypeId_;
            if ((this.bitField0_ & 64) == 64) {
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                this.bitField0_ &= -65;
            }
            protoBuf$Class.nestedClassName_ = this.nestedClassName_;
            if ((this.bitField0_ & 128) == 128) {
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
                this.bitField0_ &= -129;
            }
            protoBuf$Class.constructor_ = this.constructor_;
            if ((this.bitField0_ & 256) == 256) {
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -257;
            }
            protoBuf$Class.function_ = this.function_;
            if ((this.bitField0_ & 512) == 512) {
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -513;
            }
            protoBuf$Class.property_ = this.property_;
            if ((this.bitField0_ & 1024) == 1024) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -1025;
            }
            protoBuf$Class.typeAlias_ = this.typeAlias_;
            if ((this.bitField0_ & 2048) == 2048) {
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                this.bitField0_ &= -2049;
            }
            protoBuf$Class.enumEntry_ = this.enumEntry_;
            if ((this.bitField0_ & 4096) == 4096) {
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                this.bitField0_ &= -4097;
            }
            protoBuf$Class.sealedSubclassFqName_ = this.sealedSubclassFqName_;
            if ((i & 8192) == 8192) {
                i2 |= 8;
            }
            protoBuf$Class.typeTable_ = this.typeTable_;
            if ((this.bitField0_ & 16384) == 16384) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -16385;
            }
            protoBuf$Class.versionRequirement_ = this.versionRequirement_;
            if ((i & 32768) == 32768) {
                i2 |= 16;
            }
            protoBuf$Class.versionRequirementTable_ = this.versionRequirementTable_;
            protoBuf$Class.bitField0_ = i2;
            return protoBuf$Class;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Class.defaultInstance;
        }

        public final boolean isInitialized() {
            if (!((this.bitField0_ & 2) == 2)) {
                return false;
            }
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                if (!this.typeParameter_.get(i).isInitialized()) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < this.supertype_.size(); i2++) {
                if (!this.supertype_.get(i2).isInitialized()) {
                    return false;
                }
            }
            for (int i3 = 0; i3 < this.constructor_.size(); i3++) {
                if (!this.constructor_.get(i3).isInitialized()) {
                    return false;
                }
            }
            for (int i4 = 0; i4 < this.function_.size(); i4++) {
                if (!this.function_.get(i4).isInitialized()) {
                    return false;
                }
            }
            for (int i5 = 0; i5 < this.property_.size(); i5++) {
                if (!this.property_.get(i5).isInitialized()) {
                    return false;
                }
            }
            for (int i6 = 0; i6 < this.typeAlias_.size(); i6++) {
                if (!this.typeAlias_.get(i6).isInitialized()) {
                    return false;
                }
            }
            for (int i7 = 0; i7 < this.enumEntry_.size(); i7++) {
                if (!this.enumEntry_.get(i7).isInitialized()) {
                    return false;
                }
            }
            return (!((this.bitField0_ & 8192) == 8192) || this.typeTable_.isInitialized()) && extensionsAreInitialized();
        }

        public Builder mergeFrom(ProtoBuf$Class protoBuf$Class) {
            if (protoBuf$Class == ProtoBuf$Class.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$Class.bitField0_ & 1) == 1) {
                int i = protoBuf$Class.flags_;
                this.bitField0_ |= 1;
                this.flags_ = i;
            }
            if ((protoBuf$Class.bitField0_ & 2) == 2) {
                int i2 = protoBuf$Class.fqName_;
                this.bitField0_ = 2 | this.bitField0_;
                this.fqName_ = i2;
            }
            if ((protoBuf$Class.bitField0_ & 4) == 4) {
                int i3 = protoBuf$Class.companionObjectName_;
                this.bitField0_ = 4 | this.bitField0_;
                this.companionObjectName_ = i3;
            }
            if (!protoBuf$Class.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Class.typeParameter_;
                    this.bitField0_ &= -9;
                } else {
                    if ((this.bitField0_ & 8) != 8) {
                        this.typeParameter_ = new ArrayList(this.typeParameter_);
                        this.bitField0_ |= 8;
                    }
                    this.typeParameter_.addAll(protoBuf$Class.typeParameter_);
                }
            }
            if (!protoBuf$Class.supertype_.isEmpty()) {
                if (this.supertype_.isEmpty()) {
                    this.supertype_ = protoBuf$Class.supertype_;
                    this.bitField0_ &= -17;
                } else {
                    if ((this.bitField0_ & 16) != 16) {
                        this.supertype_ = new ArrayList(this.supertype_);
                        this.bitField0_ |= 16;
                    }
                    this.supertype_.addAll(protoBuf$Class.supertype_);
                }
            }
            if (!protoBuf$Class.supertypeId_.isEmpty()) {
                if (this.supertypeId_.isEmpty()) {
                    this.supertypeId_ = protoBuf$Class.supertypeId_;
                    this.bitField0_ &= -33;
                } else {
                    if ((this.bitField0_ & 32) != 32) {
                        this.supertypeId_ = new ArrayList(this.supertypeId_);
                        this.bitField0_ |= 32;
                    }
                    this.supertypeId_.addAll(protoBuf$Class.supertypeId_);
                }
            }
            if (!protoBuf$Class.nestedClassName_.isEmpty()) {
                if (this.nestedClassName_.isEmpty()) {
                    this.nestedClassName_ = protoBuf$Class.nestedClassName_;
                    this.bitField0_ &= -65;
                } else {
                    if ((this.bitField0_ & 64) != 64) {
                        this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                        this.bitField0_ |= 64;
                    }
                    this.nestedClassName_.addAll(protoBuf$Class.nestedClassName_);
                }
            }
            if (!protoBuf$Class.constructor_.isEmpty()) {
                if (this.constructor_.isEmpty()) {
                    this.constructor_ = protoBuf$Class.constructor_;
                    this.bitField0_ &= -129;
                } else {
                    if ((this.bitField0_ & 128) != 128) {
                        this.constructor_ = new ArrayList(this.constructor_);
                        this.bitField0_ |= 128;
                    }
                    this.constructor_.addAll(protoBuf$Class.constructor_);
                }
            }
            if (!protoBuf$Class.function_.isEmpty()) {
                if (this.function_.isEmpty()) {
                    this.function_ = protoBuf$Class.function_;
                    this.bitField0_ &= -257;
                } else {
                    if ((this.bitField0_ & 256) != 256) {
                        this.function_ = new ArrayList(this.function_);
                        this.bitField0_ |= 256;
                    }
                    this.function_.addAll(protoBuf$Class.function_);
                }
            }
            if (!protoBuf$Class.property_.isEmpty()) {
                if (this.property_.isEmpty()) {
                    this.property_ = protoBuf$Class.property_;
                    this.bitField0_ &= -513;
                } else {
                    if ((this.bitField0_ & 512) != 512) {
                        this.property_ = new ArrayList(this.property_);
                        this.bitField0_ |= 512;
                    }
                    this.property_.addAll(protoBuf$Class.property_);
                }
            }
            if (!protoBuf$Class.typeAlias_.isEmpty()) {
                if (this.typeAlias_.isEmpty()) {
                    this.typeAlias_ = protoBuf$Class.typeAlias_;
                    this.bitField0_ &= -1025;
                } else {
                    if ((this.bitField0_ & 1024) != 1024) {
                        this.typeAlias_ = new ArrayList(this.typeAlias_);
                        this.bitField0_ |= 1024;
                    }
                    this.typeAlias_.addAll(protoBuf$Class.typeAlias_);
                }
            }
            if (!protoBuf$Class.enumEntry_.isEmpty()) {
                if (this.enumEntry_.isEmpty()) {
                    this.enumEntry_ = protoBuf$Class.enumEntry_;
                    this.bitField0_ &= -2049;
                } else {
                    if ((this.bitField0_ & 2048) != 2048) {
                        this.enumEntry_ = new ArrayList(this.enumEntry_);
                        this.bitField0_ |= 2048;
                    }
                    this.enumEntry_.addAll(protoBuf$Class.enumEntry_);
                }
            }
            if (!protoBuf$Class.sealedSubclassFqName_.isEmpty()) {
                if (this.sealedSubclassFqName_.isEmpty()) {
                    this.sealedSubclassFqName_ = protoBuf$Class.sealedSubclassFqName_;
                    this.bitField0_ &= -4097;
                } else {
                    if ((this.bitField0_ & 4096) != 4096) {
                        this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                        this.bitField0_ |= 4096;
                    }
                    this.sealedSubclassFqName_.addAll(protoBuf$Class.sealedSubclassFqName_);
                }
            }
            if ((protoBuf$Class.bitField0_ & 8) == 8) {
                ProtoBuf$TypeTable protoBuf$TypeTable = protoBuf$Class.typeTable_;
                if ((this.bitField0_ & 8192) == 8192) {
                    ProtoBuf$TypeTable protoBuf$TypeTable2 = this.typeTable_;
                    if (protoBuf$TypeTable2 != ProtoBuf$TypeTable.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.Builder newBuilder = ProtoBuf$TypeTable.newBuilder(protoBuf$TypeTable2);
                        newBuilder.mergeFrom(protoBuf$TypeTable);
                        this.typeTable_ = newBuilder.buildPartial();
                        this.bitField0_ |= 8192;
                    }
                }
                this.typeTable_ = protoBuf$TypeTable;
                this.bitField0_ |= 8192;
            }
            if (!protoBuf$Class.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Class.versionRequirement_;
                    this.bitField0_ &= -16385;
                } else {
                    if ((this.bitField0_ & 16384) != 16384) {
                        this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                        this.bitField0_ |= 16384;
                    }
                    this.versionRequirement_.addAll(protoBuf$Class.versionRequirement_);
                }
            }
            if ((protoBuf$Class.bitField0_ & 16) != 16) {
                z = false;
            }
            if (z) {
                ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = protoBuf$Class.versionRequirementTable_;
                if ((this.bitField0_ & 32768) == 32768) {
                    ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable2 = this.versionRequirementTable_;
                    if (protoBuf$VersionRequirementTable2 != ProtoBuf$VersionRequirementTable.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.Builder newBuilder2 = ProtoBuf$VersionRequirementTable.newBuilder(protoBuf$VersionRequirementTable2);
                        newBuilder2.mergeFrom(protoBuf$VersionRequirementTable);
                        this.versionRequirementTable_ = newBuilder2.buildPartial();
                        this.bitField0_ |= 32768;
                    }
                }
                this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
                this.bitField0_ |= 32768;
            }
            mergeExtensionFields(protoBuf$Class);
            this.unknownFields = this.unknownFields.concat(protoBuf$Class.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m914getDefaultInstanceForType() {
            return ProtoBuf$Class.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m913clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$Class) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Class protoBuf$Class;
            ProtoBuf$Class protoBuf$Class2 = null;
            try {
                ProtoBuf$Class protoBuf$Class3 = (ProtoBuf$Class) ProtoBuf$Class.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Class3 != null) {
                    mergeFrom(protoBuf$Class3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Class = (ProtoBuf$Class) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Class2 = protoBuf$Class;
            }
            if (protoBuf$Class2 != null) {
                mergeFrom(protoBuf$Class2);
            }
            throw th;
        }
    }

    public enum Kind implements EnumLite {
        CLASS(0, 0),
        INTERFACE(1, 1),
        ENUM_CLASS(2, 2),
        ENUM_ENTRY(3, 3),
        ANNOTATION_CLASS(4, 4),
        OBJECT(5, 5),
        COMPANION_OBJECT(6, 6);
        
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
            switch (i) {
                case 0:
                    return CLASS;
                case 1:
                    return INTERFACE;
                case 2:
                    return ENUM_CLASS;
                case 3:
                    return ENUM_ENTRY;
                case 4:
                    return ANNOTATION_CLASS;
                case 5:
                    return OBJECT;
                case 6:
                    return COMPANION_OBJECT;
                default:
                    return null;
            }
        }
    }

    static {
        ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class();
        defaultInstance = protoBuf$Class;
        protoBuf$Class.initFields();
    }

    public ProtoBuf$Class(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
        super(extendableBuilder);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
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
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.supertypeId_.size(); i3++) {
            i2 += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i3).intValue());
        }
        int i4 = computeInt32Size + i2;
        if (!this.supertypeId_.isEmpty()) {
            i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
        }
        this.supertypeIdMemoizedSerializedSize = i2;
        if ((this.bitField0_ & 2) == 2) {
            i4 += CodedOutputStream.computeInt32Size(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i4 += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        }
        for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
            i4 += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i5));
        }
        for (int i6 = 0; i6 < this.supertype_.size(); i6++) {
            i4 += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i6));
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.nestedClassName_.size(); i8++) {
            i7 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i8).intValue());
        }
        int i9 = i4 + i7;
        if (!this.nestedClassName_.isEmpty()) {
            i9 = i9 + 1 + CodedOutputStream.computeInt32SizeNoTag(i7);
        }
        this.nestedClassNameMemoizedSerializedSize = i7;
        for (int i10 = 0; i10 < this.constructor_.size(); i10++) {
            i9 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i10));
        }
        for (int i11 = 0; i11 < this.function_.size(); i11++) {
            i9 += CodedOutputStream.computeMessageSize(9, this.function_.get(i11));
        }
        for (int i12 = 0; i12 < this.property_.size(); i12++) {
            i9 += CodedOutputStream.computeMessageSize(10, this.property_.get(i12));
        }
        for (int i13 = 0; i13 < this.typeAlias_.size(); i13++) {
            i9 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i13));
        }
        for (int i14 = 0; i14 < this.enumEntry_.size(); i14++) {
            i9 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i14));
        }
        int i15 = 0;
        for (int i16 = 0; i16 < this.sealedSubclassFqName_.size(); i16++) {
            i15 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i16).intValue());
        }
        int i17 = i9 + i15;
        if (!this.sealedSubclassFqName_.isEmpty()) {
            i17 = i17 + 2 + CodedOutputStream.computeInt32SizeNoTag(i15);
        }
        this.sealedSubclassFqNameMemoizedSerializedSize = i15;
        if ((this.bitField0_ & 8) == 8) {
            i17 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int i18 = 0;
        for (int i19 = 0; i19 < this.versionRequirement_.size(); i19++) {
            i18 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i19).intValue());
        }
        int size = (this.versionRequirement_.size() * 2) + i17 + i18;
        if ((this.bitField0_ & 16) == 16) {
            size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int size2 = this.unknownFields.size() + extensionsSerializedSize() + size;
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public final void initFields() {
        this.flags_ = 6;
        this.fqName_ = 0;
        this.companionObjectName_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.supertype_ = Collections.emptyList();
        this.supertypeId_ = Collections.emptyList();
        this.nestedClassName_ = Collections.emptyList();
        this.constructor_ = Collections.emptyList();
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.enumEntry_ = Collections.emptyList();
        this.sealedSubclassFqName_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.defaultInstance;
        this.versionRequirement_ = Collections.emptyList();
        this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.defaultInstance;
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
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            if (!this.typeParameter_.get(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < this.supertype_.size(); i2++) {
            if (!this.supertype_.get(i2).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < this.constructor_.size(); i3++) {
            if (!this.constructor_.get(i3).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < this.function_.size(); i4++) {
            if (!this.function_.get(i4).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < this.property_.size(); i5++) {
            if (!this.property_.get(i5).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < this.typeAlias_.size(); i6++) {
            if (!this.typeAlias_.get(i6).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < this.enumEntry_.size(); i7++) {
            if (!this.enumEntry_.get(i7).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (((this.bitField0_ & 8) == 8) && !this.typeTable_.isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!extensionsAreInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else {
            this.memoizedIsInitialized = 1;
            return true;
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if (this.supertypeId_.size() > 0) {
            codedOutputStream.writeRawVarint32(18);
            codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        }
        for (int i = 0; i < this.supertypeId_.size(); i++) {
            codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i).intValue());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(4, this.companionObjectName_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            codedOutputStream.writeMessage(5, this.typeParameter_.get(i2));
        }
        for (int i3 = 0; i3 < this.supertype_.size(); i3++) {
            codedOutputStream.writeMessage(6, this.supertype_.get(i3));
        }
        if (this.nestedClassName_.size() > 0) {
            codedOutputStream.writeRawVarint32(58);
            codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        }
        for (int i4 = 0; i4 < this.nestedClassName_.size(); i4++) {
            codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i4).intValue());
        }
        for (int i5 = 0; i5 < this.constructor_.size(); i5++) {
            codedOutputStream.writeMessage(8, this.constructor_.get(i5));
        }
        for (int i6 = 0; i6 < this.function_.size(); i6++) {
            codedOutputStream.writeMessage(9, this.function_.get(i6));
        }
        for (int i7 = 0; i7 < this.property_.size(); i7++) {
            codedOutputStream.writeMessage(10, this.property_.get(i7));
        }
        for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
            codedOutputStream.writeMessage(11, this.typeAlias_.get(i8));
        }
        for (int i9 = 0; i9 < this.enumEntry_.size(); i9++) {
            codedOutputStream.writeMessage(13, this.enumEntry_.get(i9));
        }
        if (this.sealedSubclassFqName_.size() > 0) {
            codedOutputStream.writeRawVarint32(130);
            codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        }
        for (int i10 = 0; i10 < this.sealedSubclassFqName_.size(); i10++) {
            codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i10).intValue());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i11 = 0; i11 < this.versionRequirement_.size(); i11++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i11).intValue());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        newExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$Class() {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARNING: type inference failed for: r16v0 */
    /* JADX WARNING: type inference failed for: r16v1 */
    /* JADX WARNING: type inference failed for: r16v2, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder] */
    /* JADX WARNING: type inference failed for: r16v4 */
    /* JADX WARNING: type inference failed for: r16v5, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder] */
    /* JADX WARNING: type inference failed for: r16v6 */
    /* JADX WARNING: type inference failed for: r16v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02c0, code lost:
        r6 = true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProtoBuf$Class(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r18, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r19) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r17.<init>()
            r3 = -1
            r1.supertypeIdMemoizedSerializedSize = r3
            r1.nestedClassNameMemoizedSerializedSize = r3
            r1.sealedSubclassFqNameMemoizedSerializedSize = r3
            r1.memoizedIsInitialized = r3
            r1.memoizedSerializedSize = r3
            r17.initFields()
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r3 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
            r4 = 1
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r5 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r3, r4)
            r6 = 0
            r7 = 0
        L_0x0022:
            r8 = 2048(0x800, float:2.87E-42)
            r9 = 1024(0x400, float:1.435E-42)
            r10 = 512(0x200, float:7.17E-43)
            r13 = 16384(0x4000, float:2.2959E-41)
            r14 = 4096(0x1000, float:5.74E-42)
            r4 = 16
            r15 = 8
            if (r6 != 0) goto L_0x0382
            int r12 = r18.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r16 = 0
            switch(r12) {
                case 0: goto L_0x02bf;
                case 8: goto L_0x02b2;
                case 16: goto L_0x0294;
                case 18: goto L_0x025f;
                case 24: goto L_0x0252;
                case 32: goto L_0x0245;
                case 42: goto L_0x022c;
                case 50: goto L_0x0210;
                case 56: goto L_0x01f2;
                case 58: goto L_0x01bc;
                case 66: goto L_0x01a0;
                case 74: goto L_0x0184;
                case 82: goto L_0x016a;
                case 90: goto L_0x0150;
                case 106: goto L_0x0136;
                case 128: goto L_0x011a;
                case 130: goto L_0x00e6;
                case 242: goto L_0x00bd;
                case 248: goto L_0x00a1;
                case 250: goto L_0x006b;
                case 258: goto L_0x0042;
                default: goto L_0x003b;
            }     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
        L_0x003b:
            r11 = 1
            boolean r4 = r1.parseUnknownField(r0, r5, r2, r12)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02c2
        L_0x0042:
            int r12 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r12 = r12 & r4
            if (r12 != r4) goto L_0x004d
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r12 = r1.versionRequirementTable_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder r16 = r12.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
        L_0x004d:
            r12 = r16
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r0.readMessage(r11, r2)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r11 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable) r11     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.versionRequirementTable_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r12 == 0) goto L_0x0064
            r12.mergeFrom(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r11 = r12.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.versionRequirementTable_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
        L_0x0064:
            int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11 = r11 | r4
            r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x006b:
            int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r11 = r0.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r12 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r12 == r13) goto L_0x0086
            int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r12 <= 0) goto L_0x0086
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.versionRequirement_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 16384(0x4000, float:2.2959E-41)
        L_0x0086:
            int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r12 <= 0) goto L_0x009c
            java.util.List<java.lang.Integer> r12 = r1.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r16 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r12.add(r4)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4 = 16
            goto L_0x0086
        L_0x009c:
            r0.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x00a1:
            r4 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r4 == r13) goto L_0x00ae
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.versionRequirement_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 16384(0x4000, float:2.2959E-41)
        L_0x00ae:
            java.util.List<java.lang.Integer> r4 = r1.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x00bd:
            int r4 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4 = r4 & r15
            if (r4 != r15) goto L_0x00c8
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r4 = r1.typeTable_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder r16 = r4.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
        L_0x00c8:
            r4 = r16
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r0.readMessage(r11, r2)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r11 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable) r11     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.typeTable_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r4 == 0) goto L_0x00df
            r4.mergeFrom(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r4 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.typeTable_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
        L_0x00df:
            int r4 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4 = r4 | r15
            r1.bitField0_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x00e6:
            int r4 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r4 = r0.pushLimit(r4)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11 = r7 & 4096(0x1000, float:5.74E-42)
            if (r11 == r14) goto L_0x0101
            int r11 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r11 <= 0) goto L_0x0101
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.sealedSubclassFqName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 4096(0x1000, float:5.74E-42)
        L_0x0101:
            int r11 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r11 <= 0) goto L_0x0115
            java.util.List<java.lang.Integer> r11 = r1.sealedSubclassFqName_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x0101
        L_0x0115:
            r0.popLimit(r4)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x011a:
            r4 = r7 & 4096(0x1000, float:5.74E-42)
            if (r4 == r14) goto L_0x0127
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.sealedSubclassFqName_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 4096(0x1000, float:5.74E-42)
        L_0x0127:
            java.util.List<java.lang.Integer> r4 = r1.sealedSubclassFqName_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x0136:
            r4 = r7 & 2048(0x800, float:2.87E-42)
            if (r4 == r8) goto L_0x0143
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.enumEntry_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 2048(0x800, float:2.87E-42)
        L_0x0143:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r4 = r1.enumEntry_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r0.readMessage(r11, r2)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x0150:
            r4 = r7 & 1024(0x400, float:1.435E-42)
            if (r4 == r9) goto L_0x015d
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.typeAlias_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 1024(0x400, float:1.435E-42)
        L_0x015d:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r4 = r1.typeAlias_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r0.readMessage(r11, r2)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x016a:
            r4 = r7 & 512(0x200, float:7.17E-43)
            if (r4 == r10) goto L_0x0177
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.property_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 512(0x200, float:7.17E-43)
        L_0x0177:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r4 = r1.property_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r0.readMessage(r11, r2)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x0184:
            r4 = r7 & 256(0x100, float:3.59E-43)
            r11 = 256(0x100, float:3.59E-43)
            if (r4 == r11) goto L_0x0193
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.function_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 256(0x100, float:3.59E-43)
        L_0x0193:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r4 = r1.function_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r0.readMessage(r11, r2)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x01a0:
            r4 = r7 & 128(0x80, float:1.8E-43)
            r11 = 128(0x80, float:1.8E-43)
            if (r4 == r11) goto L_0x01af
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.constructor_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 128(0x80, float:1.8E-43)
        L_0x01af:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r4 = r1.constructor_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r0.readMessage(r11, r2)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x01bc:
            int r4 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r4 = r0.pushLimit(r4)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11 = r7 & 64
            r12 = 64
            if (r11 == r12) goto L_0x01d9
            int r11 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r11 <= 0) goto L_0x01d9
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.nestedClassName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 64
        L_0x01d9:
            int r11 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r11 <= 0) goto L_0x01ed
            java.util.List<java.lang.Integer> r11 = r1.nestedClassName_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x01d9
        L_0x01ed:
            r0.popLimit(r4)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x01f2:
            r4 = r7 & 64
            r11 = 64
            if (r4 == r11) goto L_0x0201
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.nestedClassName_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 64
        L_0x0201:
            java.util.List<java.lang.Integer> r4 = r1.nestedClassName_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x0210:
            r4 = r7 & 16
            r11 = 16
            if (r4 == r11) goto L_0x021f
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.supertype_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 16
        L_0x021f:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r4 = r1.supertype_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r0.readMessage(r11, r2)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x022c:
            r4 = r7 & 8
            if (r4 == r15) goto L_0x0239
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.typeParameter_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 8
        L_0x0239:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r4 = r1.typeParameter_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r0.readMessage(r11, r2)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x0245:
            int r4 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4 = r4 | 4
            r1.bitField0_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r4 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.companionObjectName_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x0252:
            int r4 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4 = r4 | 2
            r1.bitField0_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r4 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.fqName_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x025f:
            int r4 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r4 = r0.pushLimit(r4)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11 = r7 & 32
            r12 = 32
            if (r11 == r12) goto L_0x027c
            int r11 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r11 <= 0) goto L_0x027c
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.supertypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 32
        L_0x027c:
            int r11 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            if (r11 <= 0) goto L_0x0290
            java.util.List<java.lang.Integer> r11 = r1.supertypeId_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x027c
        L_0x0290:
            r0.popLimit(r4)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02b0
        L_0x0294:
            r4 = r7 & 32
            r11 = 32
            if (r4 == r11) goto L_0x02a3
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.supertypeId_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r7 = r7 | 32
        L_0x02a3:
            java.util.List<java.lang.Integer> r4 = r1.supertypeId_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r4.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
        L_0x02b0:
            r11 = 1
            goto L_0x02c5
        L_0x02b2:
            int r4 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r11 = 1
            r4 = r4 | r11
            r1.bitField0_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            int r4 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            r1.flags_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x02d8, IOException -> 0x02ca }
            goto L_0x02c5
        L_0x02bf:
            r11 = 1
        L_0x02c0:
            r6 = 1
            goto L_0x02c5
        L_0x02c2:
            if (r4 != 0) goto L_0x02c5
            goto L_0x02c0
        L_0x02c5:
            r4 = 1
            goto L_0x0022
        L_0x02c8:
            r0 = move-exception
            goto L_0x02dd
        L_0x02ca:
            r0 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r2 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x02c8 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02c8 }
            r2.<init>(r0)     // Catch:{ all -> 0x02c8 }
            r2.setUnfinishedMessage(r1)     // Catch:{ all -> 0x02c8 }
            throw r2     // Catch:{ all -> 0x02c8 }
        L_0x02d8:
            r0 = move-exception
            r0.setUnfinishedMessage(r1)     // Catch:{ all -> 0x02c8 }
            throw r0     // Catch:{ all -> 0x02c8 }
        L_0x02dd:
            r2 = r7 & 32
            r4 = 32
            if (r2 != r4) goto L_0x02eb
            java.util.List<java.lang.Integer> r2 = r1.supertypeId_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.supertypeId_ = r2
        L_0x02eb:
            r2 = r7 & 8
            if (r2 != r15) goto L_0x02f7
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r2 = r1.typeParameter_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.typeParameter_ = r2
        L_0x02f7:
            r2 = r7 & 16
            r4 = 16
            if (r2 != r4) goto L_0x0305
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r2 = r1.supertype_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.supertype_ = r2
        L_0x0305:
            r2 = r7 & 64
            r4 = 64
            if (r2 != r4) goto L_0x0313
            java.util.List<java.lang.Integer> r2 = r1.nestedClassName_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.nestedClassName_ = r2
        L_0x0313:
            r2 = r7 & 128(0x80, float:1.8E-43)
            r4 = 128(0x80, float:1.8E-43)
            if (r2 != r4) goto L_0x0321
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r2 = r1.constructor_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.constructor_ = r2
        L_0x0321:
            r2 = r7 & 256(0x100, float:3.59E-43)
            r4 = 256(0x100, float:3.59E-43)
            if (r2 != r4) goto L_0x032f
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r2 = r1.function_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.function_ = r2
        L_0x032f:
            r2 = r7 & 512(0x200, float:7.17E-43)
            if (r2 != r10) goto L_0x033b
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r2 = r1.property_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.property_ = r2
        L_0x033b:
            r2 = r7 & 1024(0x400, float:1.435E-42)
            if (r2 != r9) goto L_0x0347
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r2 = r1.typeAlias_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.typeAlias_ = r2
        L_0x0347:
            r2 = r7 & 2048(0x800, float:2.87E-42)
            if (r2 != r8) goto L_0x0353
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r2 = r1.enumEntry_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.enumEntry_ = r2
        L_0x0353:
            r2 = r7 & 4096(0x1000, float:5.74E-42)
            if (r2 != r14) goto L_0x035f
            java.util.List<java.lang.Integer> r2 = r1.sealedSubclassFqName_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.sealedSubclassFqName_ = r2
        L_0x035f:
            r2 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r2 != r13) goto L_0x036b
            java.util.List<java.lang.Integer> r2 = r1.versionRequirement_
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.versionRequirement_ = r2
        L_0x036b:
            r5.flush()     // Catch:{ IOException -> 0x036e, all -> 0x0375 }
        L_0x036e:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r2 = r3.toByteString()
            r1.unknownFields = r2
            goto L_0x037e
        L_0x0375:
            r0 = move-exception
            r2 = r0
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r3.toByteString()
            r1.unknownFields = r0
            throw r2
        L_0x037e:
            r17.makeExtensionsImmutable()
            throw r0
        L_0x0382:
            r0 = r7 & 32
            r2 = 32
            if (r0 != r2) goto L_0x0390
            java.util.List<java.lang.Integer> r0 = r1.supertypeId_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.supertypeId_ = r0
        L_0x0390:
            r0 = r7 & 8
            if (r0 != r15) goto L_0x039c
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r0 = r1.typeParameter_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.typeParameter_ = r0
        L_0x039c:
            r0 = r7 & 16
            r2 = 16
            if (r0 != r2) goto L_0x03aa
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r0 = r1.supertype_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.supertype_ = r0
        L_0x03aa:
            r0 = r7 & 64
            r2 = 64
            if (r0 != r2) goto L_0x03b8
            java.util.List<java.lang.Integer> r0 = r1.nestedClassName_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.nestedClassName_ = r0
        L_0x03b8:
            r0 = r7 & 128(0x80, float:1.8E-43)
            r2 = 128(0x80, float:1.8E-43)
            if (r0 != r2) goto L_0x03c6
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r0 = r1.constructor_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.constructor_ = r0
        L_0x03c6:
            r0 = r7 & 256(0x100, float:3.59E-43)
            r2 = 256(0x100, float:3.59E-43)
            if (r0 != r2) goto L_0x03d4
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r0 = r1.function_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.function_ = r0
        L_0x03d4:
            r0 = r7 & 512(0x200, float:7.17E-43)
            if (r0 != r10) goto L_0x03e0
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r0 = r1.property_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.property_ = r0
        L_0x03e0:
            r0 = r7 & 1024(0x400, float:1.435E-42)
            if (r0 != r9) goto L_0x03ec
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r0 = r1.typeAlias_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.typeAlias_ = r0
        L_0x03ec:
            r0 = r7 & 2048(0x800, float:2.87E-42)
            if (r0 != r8) goto L_0x03f8
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r0 = r1.enumEntry_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.enumEntry_ = r0
        L_0x03f8:
            r0 = r7 & 4096(0x1000, float:5.74E-42)
            if (r0 != r14) goto L_0x0404
            java.util.List<java.lang.Integer> r0 = r1.sealedSubclassFqName_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.sealedSubclassFqName_ = r0
        L_0x0404:
            r0 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r0 != r13) goto L_0x0410
            java.util.List<java.lang.Integer> r0 = r1.versionRequirement_
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r1.versionRequirement_ = r0
        L_0x0410:
            r5.flush()     // Catch:{ IOException -> 0x0413, all -> 0x041a }
        L_0x0413:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r3.toByteString()
            r1.unknownFields = r0
            goto L_0x0423
        L_0x041a:
            r0 = move-exception
            r2 = r0
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r3.toByteString()
            r1.unknownFields = r0
            throw r2
        L_0x0423:
            r17.makeExtensionsImmutable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
    }
}
