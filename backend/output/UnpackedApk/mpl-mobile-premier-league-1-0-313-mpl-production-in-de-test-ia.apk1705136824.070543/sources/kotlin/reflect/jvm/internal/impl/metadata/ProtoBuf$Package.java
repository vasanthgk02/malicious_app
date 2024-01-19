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
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$Package extends ExtendableMessage<ProtoBuf$Package> implements Object {
    public static Parser<ProtoBuf$Package> PARSER = new AbstractParser<ProtoBuf$Package>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Package(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$Package defaultInstance;
    public int bitField0_;
    public List<ProtoBuf$Function> function_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public List<ProtoBuf$Property> property_;
    public List<ProtoBuf$TypeAlias> typeAlias_;
    public ProtoBuf$TypeTable typeTable_;
    public final ByteString unknownFields;
    public ProtoBuf$VersionRequirementTable versionRequirementTable_;

    public static final class Builder extends ExtendableBuilder<ProtoBuf$Package, Builder> implements Object {
        public int bitField0_;
        public List<ProtoBuf$Function> function_ = Collections.emptyList();
        public List<ProtoBuf$Property> property_ = Collections.emptyList();
        public List<ProtoBuf$TypeAlias> typeAlias_ = Collections.emptyList();
        public ProtoBuf$TypeTable typeTable_ = ProtoBuf$TypeTable.defaultInstance;
        public ProtoBuf$VersionRequirementTable versionRequirementTable_ = ProtoBuf$VersionRequirementTable.defaultInstance;

        public MessageLite build() {
            ProtoBuf$Package buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Package buildPartial() {
            ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) == 1) {
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -2;
            }
            protoBuf$Package.function_ = this.function_;
            if ((this.bitField0_ & 2) == 2) {
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -3;
            }
            protoBuf$Package.property_ = this.property_;
            if ((this.bitField0_ & 4) == 4) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -5;
            }
            protoBuf$Package.typeAlias_ = this.typeAlias_;
            if ((i & 8) != 8) {
                i2 = 0;
            }
            protoBuf$Package.typeTable_ = this.typeTable_;
            if ((i & 16) == 16) {
                i2 |= 2;
            }
            protoBuf$Package.versionRequirementTable_ = this.versionRequirementTable_;
            protoBuf$Package.bitField0_ = i2;
            return protoBuf$Package;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Package.defaultInstance;
        }

        public final boolean isInitialized() {
            for (int i = 0; i < this.function_.size(); i++) {
                if (!this.function_.get(i).isInitialized()) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < this.property_.size(); i2++) {
                if (!this.property_.get(i2).isInitialized()) {
                    return false;
                }
            }
            for (int i3 = 0; i3 < this.typeAlias_.size(); i3++) {
                if (!this.typeAlias_.get(i3).isInitialized()) {
                    return false;
                }
            }
            if ((!((this.bitField0_ & 8) == 8) || this.typeTable_.isInitialized()) && extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeFrom(ProtoBuf$Package protoBuf$Package) {
            if (protoBuf$Package == ProtoBuf$Package.defaultInstance) {
                return this;
            }
            boolean z = true;
            if (!protoBuf$Package.function_.isEmpty()) {
                if (this.function_.isEmpty()) {
                    this.function_ = protoBuf$Package.function_;
                    this.bitField0_ &= -2;
                } else {
                    if ((this.bitField0_ & 1) != 1) {
                        this.function_ = new ArrayList(this.function_);
                        this.bitField0_ |= 1;
                    }
                    this.function_.addAll(protoBuf$Package.function_);
                }
            }
            if (!protoBuf$Package.property_.isEmpty()) {
                if (this.property_.isEmpty()) {
                    this.property_ = protoBuf$Package.property_;
                    this.bitField0_ &= -3;
                } else {
                    if ((this.bitField0_ & 2) != 2) {
                        this.property_ = new ArrayList(this.property_);
                        this.bitField0_ |= 2;
                    }
                    this.property_.addAll(protoBuf$Package.property_);
                }
            }
            if (!protoBuf$Package.typeAlias_.isEmpty()) {
                if (this.typeAlias_.isEmpty()) {
                    this.typeAlias_ = protoBuf$Package.typeAlias_;
                    this.bitField0_ &= -5;
                } else {
                    if ((this.bitField0_ & 4) != 4) {
                        this.typeAlias_ = new ArrayList(this.typeAlias_);
                        this.bitField0_ |= 4;
                    }
                    this.typeAlias_.addAll(protoBuf$Package.typeAlias_);
                }
            }
            if ((protoBuf$Package.bitField0_ & 1) == 1) {
                ProtoBuf$TypeTable protoBuf$TypeTable = protoBuf$Package.typeTable_;
                if ((this.bitField0_ & 8) == 8) {
                    ProtoBuf$TypeTable protoBuf$TypeTable2 = this.typeTable_;
                    if (protoBuf$TypeTable2 != ProtoBuf$TypeTable.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.Builder newBuilder = ProtoBuf$TypeTable.newBuilder(protoBuf$TypeTable2);
                        newBuilder.mergeFrom(protoBuf$TypeTable);
                        this.typeTable_ = newBuilder.buildPartial();
                        this.bitField0_ |= 8;
                    }
                }
                this.typeTable_ = protoBuf$TypeTable;
                this.bitField0_ |= 8;
            }
            if ((protoBuf$Package.bitField0_ & 2) != 2) {
                z = false;
            }
            if (z) {
                ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = protoBuf$Package.versionRequirementTable_;
                if ((this.bitField0_ & 16) == 16) {
                    ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable2 = this.versionRequirementTable_;
                    if (protoBuf$VersionRequirementTable2 != ProtoBuf$VersionRequirementTable.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.Builder newBuilder2 = ProtoBuf$VersionRequirementTable.newBuilder(protoBuf$VersionRequirementTable2);
                        newBuilder2.mergeFrom(protoBuf$VersionRequirementTable);
                        this.versionRequirementTable_ = newBuilder2.buildPartial();
                        this.bitField0_ |= 16;
                    }
                }
                this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
                this.bitField0_ |= 16;
            }
            mergeExtensionFields(protoBuf$Package);
            this.unknownFields = this.unknownFields.concat(protoBuf$Package.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m928getDefaultInstanceForType() {
            return ProtoBuf$Package.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m927clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$Package) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Package protoBuf$Package;
            ProtoBuf$Package protoBuf$Package2 = null;
            try {
                ProtoBuf$Package protoBuf$Package3 = (ProtoBuf$Package) ProtoBuf$Package.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Package3 != null) {
                    mergeFrom(protoBuf$Package3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Package = (ProtoBuf$Package) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Package2 = protoBuf$Package;
            }
            if (protoBuf$Package2 != null) {
                mergeFrom(protoBuf$Package2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package();
        defaultInstance = protoBuf$Package;
        protoBuf$Package.initFields();
    }

    public ProtoBuf$Package(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
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
        int i2 = 0;
        for (int i3 = 0; i3 < this.function_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(3, this.function_.get(i3));
        }
        for (int i4 = 0; i4 < this.property_.size(); i4++) {
            i2 += CodedOutputStream.computeMessageSize(4, this.property_.get(i4));
        }
        for (int i5 = 0; i5 < this.typeAlias_.size(); i5++) {
            i2 += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i5));
        }
        if ((this.bitField0_ & 1) == 1) {
            i2 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int size = this.unknownFields.size() + extensionsSerializedSize() + i2;
        this.memoizedSerializedSize = size;
        return size;
    }

    public final void initFields() {
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.defaultInstance;
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
        for (int i = 0; i < this.function_.size(); i++) {
            if (!this.function_.get(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < this.property_.size(); i2++) {
            if (!this.property_.get(i2).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < this.typeAlias_.size(); i3++) {
            if (!this.typeAlias_.get(i3).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (((this.bitField0_ & 1) == 1) && !this.typeTable_.isInitialized()) {
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
        for (int i = 0; i < this.function_.size(); i++) {
            codedOutputStream.writeMessage(3, this.function_.get(i));
        }
        for (int i2 = 0; i2 < this.property_.size(); i2++) {
            codedOutputStream.writeMessage(4, this.property_.get(i2));
        }
        for (int i3 = 0; i3 < this.typeAlias_.size(); i3++) {
            codedOutputStream.writeMessage(5, this.typeAlias_.get(i3));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$Package() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder] */
    /* JADX WARNING: type inference failed for: r8v2, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder] */
    /* JADX WARNING: type inference failed for: r8v3, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder] */
    /* JADX WARNING: type inference failed for: r8v4, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder]
      mth insns count: 150
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProtoBuf$Package(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r10, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r11, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1 r12) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
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
            r4 = 2
            r5 = 4
            if (r2 != 0) goto L_0x0131
            int r6 = r10.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            if (r6 == 0) goto L_0x00df
            r7 = 26
            if (r6 == r7) goto L_0x00c5
            r7 = 34
            if (r6 == r7) goto L_0x00ab
            r7 = 42
            if (r6 == r7) goto L_0x0091
            r7 = 242(0xf2, float:3.39E-43)
            r8 = 0
            if (r6 == r7) goto L_0x0067
            r7 = 258(0x102, float:3.62E-43)
            if (r6 == r7) goto L_0x003d
            boolean r4 = r9.parseUnknownField(r10, r1, r11, r6)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            if (r4 != 0) goto L_0x0016
            goto L_0x00df
        L_0x003d:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6 = r6 & r4
            if (r6 != r4) goto L_0x004c
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r6 = r9.versionRequirementTable_     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            if (r6 == 0) goto L_0x004b
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.newBuilder(r6)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            goto L_0x004c
        L_0x004b:
            throw r8     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
        L_0x004c:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, r11)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable) r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r9.versionRequirementTable_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            if (r8 == 0) goto L_0x0061
            r8.mergeFrom(r6)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r6 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r9.versionRequirementTable_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
        L_0x0061:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6 = r6 | r4
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            goto L_0x0016
        L_0x0067:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6 = r6 & r0
            if (r6 != r0) goto L_0x0076
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r6 = r9.typeTable_     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            if (r6 == 0) goto L_0x0075
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.newBuilder(r6)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            goto L_0x0076
        L_0x0075:
            throw r8     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
        L_0x0076:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, r11)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable) r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r9.typeTable_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            if (r8 == 0) goto L_0x008b
            r8.mergeFrom(r6)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r6 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r9.typeTable_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
        L_0x008b:
            int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6 = r6 | r0
            r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            goto L_0x0016
        L_0x0091:
            r6 = r3 & 4
            if (r6 == r5) goto L_0x009e
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r9.typeAlias_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r3 = r3 | 4
        L_0x009e:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r6 = r9.typeAlias_     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r10.readMessage(r7, r11)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6.add(r7)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            goto L_0x0016
        L_0x00ab:
            r6 = r3 & 2
            if (r6 == r4) goto L_0x00b8
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r9.property_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r3 = r3 | 2
        L_0x00b8:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r6 = r9.property_     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r10.readMessage(r7, r11)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6.add(r7)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            goto L_0x0016
        L_0x00c5:
            r6 = r3 & 1
            if (r6 == r0) goto L_0x00d2
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r9.function_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r3 = r3 | 1
        L_0x00d2:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r6 = r9.function_     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r10.readMessage(r7, r11)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            r6.add(r7)     // Catch:{ InvalidProtocolBufferException -> 0x00f1, IOException -> 0x00e4 }
            goto L_0x0016
        L_0x00df:
            r2 = 1
            goto L_0x0016
        L_0x00e2:
            r10 = move-exception
            goto L_0x00f5
        L_0x00e4:
            r10 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r11 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00e2 }
            r11.<init>(r10)     // Catch:{ all -> 0x00e2 }
            r11.unfinishedMessage = r9     // Catch:{ all -> 0x00e2 }
            throw r11     // Catch:{ all -> 0x00e2 }
        L_0x00f1:
            r10 = move-exception
            r10.unfinishedMessage = r9     // Catch:{ all -> 0x00e2 }
            throw r10     // Catch:{ all -> 0x00e2 }
        L_0x00f5:
            r11 = r3 & 1
            if (r11 != r0) goto L_0x0101
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r11 = r9.function_
            java.util.List r11 = java.util.Collections.unmodifiableList(r11)
            r9.function_ = r11
        L_0x0101:
            r11 = r3 & 2
            if (r11 != r4) goto L_0x010d
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r11 = r9.property_
            java.util.List r11 = java.util.Collections.unmodifiableList(r11)
            r9.property_ = r11
        L_0x010d:
            r11 = r3 & 4
            if (r11 != r5) goto L_0x0119
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r11 = r9.typeAlias_
            java.util.List r11 = java.util.Collections.unmodifiableList(r11)
            r9.typeAlias_ = r11
        L_0x0119:
            r1.flush()     // Catch:{ IOException -> 0x0125, all -> 0x011d }
            goto L_0x0125
        L_0x011d:
            r10 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r12.toByteString()
            r9.unknownFields = r11
            throw r10
        L_0x0125:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r12.toByteString()
            r9.unknownFields = r11
            kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor> r11 = r9.extensions
            r11.makeImmutable()
            throw r10
        L_0x0131:
            r10 = r3 & 1
            if (r10 != r0) goto L_0x013d
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r10 = r9.function_
            java.util.List r10 = java.util.Collections.unmodifiableList(r10)
            r9.function_ = r10
        L_0x013d:
            r10 = r3 & 2
            if (r10 != r4) goto L_0x0149
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r10 = r9.property_
            java.util.List r10 = java.util.Collections.unmodifiableList(r10)
            r9.property_ = r10
        L_0x0149:
            r10 = r3 & 4
            if (r10 != r5) goto L_0x0155
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r10 = r9.typeAlias_
            java.util.List r10 = java.util.Collections.unmodifiableList(r10)
            r9.typeAlias_ = r10
        L_0x0155:
            r1.flush()     // Catch:{ IOException -> 0x0161, all -> 0x0159 }
            goto L_0x0161
        L_0x0159:
            r10 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r12.toByteString()
            r9.unknownFields = r11
            throw r10
        L_0x0161:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r10 = r12.toByteString()
            r9.unknownFields = r10
            kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor> r10 = r9.extensions
            r10.makeImmutable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1):void");
    }
}
