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

public final class ProtoBuf$PackageFragment extends ExtendableMessage<ProtoBuf$PackageFragment> implements Object {
    public static Parser<ProtoBuf$PackageFragment> PARSER = new AbstractParser<ProtoBuf$PackageFragment>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$PackageFragment(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$PackageFragment defaultInstance;
    public int bitField0_;
    public List<ProtoBuf$Class> class__;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public ProtoBuf$Package package_;
    public ProtoBuf$QualifiedNameTable qualifiedNames_;
    public ProtoBuf$StringTable strings_;
    public final ByteString unknownFields;

    public static final class Builder extends ExtendableBuilder<ProtoBuf$PackageFragment, Builder> implements Object {
        public int bitField0_;
        public List<ProtoBuf$Class> class__ = Collections.emptyList();
        public ProtoBuf$Package package_ = ProtoBuf$Package.defaultInstance;
        public ProtoBuf$QualifiedNameTable qualifiedNames_ = ProtoBuf$QualifiedNameTable.defaultInstance;
        public ProtoBuf$StringTable strings_ = ProtoBuf$StringTable.defaultInstance;

        public MessageLite build() {
            ProtoBuf$PackageFragment buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$PackageFragment buildPartial() {
            ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$PackageFragment.strings_ = this.strings_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$PackageFragment.qualifiedNames_ = this.qualifiedNames_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$PackageFragment.package_ = this.package_;
            if ((this.bitField0_ & 8) == 8) {
                this.class__ = Collections.unmodifiableList(this.class__);
                this.bitField0_ &= -9;
            }
            protoBuf$PackageFragment.class__ = this.class__;
            protoBuf$PackageFragment.bitField0_ = i2;
            return protoBuf$PackageFragment;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$PackageFragment.defaultInstance;
        }

        public final boolean isInitialized() {
            if (((this.bitField0_ & 2) == 2) && !this.qualifiedNames_.isInitialized()) {
                return false;
            }
            if (((this.bitField0_ & 4) == 4) && !this.package_.isInitialized()) {
                return false;
            }
            for (int i = 0; i < this.class__.size(); i++) {
                if (!this.class__.get(i).isInitialized()) {
                    return false;
                }
            }
            return extensionsAreInitialized();
        }

        public Builder mergeFrom(ProtoBuf$PackageFragment protoBuf$PackageFragment) {
            if (protoBuf$PackageFragment == ProtoBuf$PackageFragment.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$PackageFragment.bitField0_ & 1) == 1) {
                ProtoBuf$StringTable protoBuf$StringTable = protoBuf$PackageFragment.strings_;
                if ((this.bitField0_ & 1) == 1) {
                    ProtoBuf$StringTable protoBuf$StringTable2 = this.strings_;
                    if (protoBuf$StringTable2 != ProtoBuf$StringTable.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable.Builder builder = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable.Builder();
                        builder.mergeFrom(protoBuf$StringTable2);
                        builder.mergeFrom(protoBuf$StringTable);
                        this.strings_ = builder.buildPartial();
                        this.bitField0_ |= 1;
                    }
                }
                this.strings_ = protoBuf$StringTable;
                this.bitField0_ |= 1;
            }
            if ((protoBuf$PackageFragment.bitField0_ & 2) == 2) {
                ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = protoBuf$PackageFragment.qualifiedNames_;
                if ((this.bitField0_ & 2) == 2) {
                    ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable2 = this.qualifiedNames_;
                    if (protoBuf$QualifiedNameTable2 != ProtoBuf$QualifiedNameTable.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.Builder builder2 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.Builder();
                        builder2.mergeFrom(protoBuf$QualifiedNameTable2);
                        builder2.mergeFrom(protoBuf$QualifiedNameTable);
                        this.qualifiedNames_ = builder2.buildPartial();
                        this.bitField0_ |= 2;
                    }
                }
                this.qualifiedNames_ = protoBuf$QualifiedNameTable;
                this.bitField0_ |= 2;
            }
            if ((protoBuf$PackageFragment.bitField0_ & 4) != 4) {
                z = false;
            }
            if (z) {
                ProtoBuf$Package protoBuf$Package = protoBuf$PackageFragment.package_;
                if ((this.bitField0_ & 4) == 4) {
                    ProtoBuf$Package protoBuf$Package2 = this.package_;
                    if (protoBuf$Package2 != ProtoBuf$Package.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.Builder builder3 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.Builder();
                        builder3.mergeFrom(protoBuf$Package2);
                        builder3.mergeFrom(protoBuf$Package);
                        this.package_ = builder3.buildPartial();
                        this.bitField0_ |= 4;
                    }
                }
                this.package_ = protoBuf$Package;
                this.bitField0_ |= 4;
            }
            if (!protoBuf$PackageFragment.class__.isEmpty()) {
                if (this.class__.isEmpty()) {
                    this.class__ = protoBuf$PackageFragment.class__;
                    this.bitField0_ &= -9;
                } else {
                    if ((this.bitField0_ & 8) != 8) {
                        this.class__ = new ArrayList(this.class__);
                        this.bitField0_ |= 8;
                    }
                    this.class__.addAll(protoBuf$PackageFragment.class__);
                }
            }
            mergeExtensionFields(protoBuf$PackageFragment);
            this.unknownFields = this.unknownFields.concat(protoBuf$PackageFragment.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m930getDefaultInstanceForType() {
            return ProtoBuf$PackageFragment.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m929clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$PackageFragment) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$PackageFragment protoBuf$PackageFragment;
            ProtoBuf$PackageFragment protoBuf$PackageFragment2 = null;
            try {
                ProtoBuf$PackageFragment protoBuf$PackageFragment3 = (ProtoBuf$PackageFragment) ProtoBuf$PackageFragment.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$PackageFragment3 != null) {
                    mergeFrom(protoBuf$PackageFragment3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$PackageFragment = (ProtoBuf$PackageFragment) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$PackageFragment2 = protoBuf$PackageFragment;
            }
            if (protoBuf$PackageFragment2 != null) {
                mergeFrom(protoBuf$PackageFragment2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment();
        defaultInstance = protoBuf$PackageFragment;
        protoBuf$PackageFragment.strings_ = ProtoBuf$StringTable.defaultInstance;
        protoBuf$PackageFragment.qualifiedNames_ = ProtoBuf$QualifiedNameTable.defaultInstance;
        protoBuf$PackageFragment.package_ = ProtoBuf$Package.defaultInstance;
        protoBuf$PackageFragment.class__ = Collections.emptyList();
    }

    public ProtoBuf$PackageFragment(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
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
        int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.strings_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, this.package_);
        }
        for (int i2 = 0; i2 < this.class__.size(); i2++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, this.class__.get(i2));
        }
        int size = this.unknownFields.size() + extensionsSerializedSize() + computeMessageSize;
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
        if (!((this.bitField0_ & 2) == 2) || this.qualifiedNames_.isInitialized()) {
            if (!((this.bitField0_ & 4) == 4) || this.package_.isInitialized()) {
                for (int i = 0; i < this.class__.size(); i++) {
                    if (!this.class__.get(i).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 0;
        return false;
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
            codedOutputStream.writeMessage(1, this.strings_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.package_);
        }
        for (int i = 0; i < this.class__.size(); i++) {
            codedOutputStream.writeMessage(4, this.class__.get(i));
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$PackageFragment() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder] */
    /* JADX WARNING: type inference failed for: r7v2, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder] */
    /* JADX WARNING: type inference failed for: r7v3, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder] */
    /* JADX WARNING: type inference failed for: r7v4, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder] */
    /* JADX WARNING: type inference failed for: r7v5, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder] */
    /* JADX WARNING: type inference failed for: r7v6, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder] */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder]
      mth insns count: 140
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProtoBuf$PackageFragment(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r9, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r10, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1 r11) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
        /*
            r8 = this;
            r8.<init>()
            r11 = -1
            r8.memoizedIsInitialized = r11
            r8.memoizedSerializedSize = r11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable.defaultInstance
            r8.strings_ = r11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.defaultInstance
            r8.qualifiedNames_ = r11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.defaultInstance
            r8.package_ = r11
            java.util.List r11 = java.util.Collections.emptyList()
            r8.class__ = r11
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r11 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
            r0 = 1
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r11, r0)
            r2 = 0
            r3 = 0
        L_0x0025:
            r4 = 8
            if (r2 != 0) goto L_0x0129
            int r5 = r9.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            if (r5 == 0) goto L_0x00ef
            r6 = 10
            r7 = 0
            if (r5 == r6) goto L_0x00c0
            r6 = 18
            if (r5 == r6) goto L_0x0090
            r6 = 26
            if (r5 == r6) goto L_0x0061
            r6 = 34
            if (r5 == r6) goto L_0x0048
            boolean r4 = r8.parseUnknownField(r9, r1, r10, r5)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            if (r4 != 0) goto L_0x0025
            goto L_0x00ef
        L_0x0048:
            r5 = r3 & 8
            if (r5 == r4) goto L_0x0055
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r5.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r8.class__ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r3 = r3 | 8
        L_0x0055:
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r5 = r8.class__     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r9.readMessage(r6, r10)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r5.add(r6)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            goto L_0x0025
        L_0x0061:
            int r5 = r8.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r6 = 4
            r5 = r5 & r6
            if (r5 != r6) goto L_0x0075
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r5 = r8.package_     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            if (r5 == 0) goto L_0x0074
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder r7 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r7.mergeFrom(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            goto L_0x0075
        L_0x0074:
            throw r7     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
        L_0x0075:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package> r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r5 = r9.readMessage(r5, r10)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package) r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r8.package_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            if (r7 == 0) goto L_0x008a
            r7.mergeFrom(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r5 = r7.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r8.package_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
        L_0x008a:
            int r5 = r8.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r5 = r5 | r6
            r8.bitField0_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            goto L_0x0025
        L_0x0090:
            int r5 = r8.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r6 = 2
            r5 = r5 & r6
            if (r5 != r6) goto L_0x00a4
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r5 = r8.qualifiedNames_     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            if (r5 == 0) goto L_0x00a3
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder r7 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r7.mergeFrom(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            goto L_0x00a4
        L_0x00a3:
            throw r7     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
        L_0x00a4:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable> r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r5 = r9.readMessage(r5, r10)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable) r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r8.qualifiedNames_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            if (r7 == 0) goto L_0x00b9
            r7.mergeFrom(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r5 = r7.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r8.qualifiedNames_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
        L_0x00b9:
            int r5 = r8.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r5 = r5 | r6
            r8.bitField0_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            goto L_0x0025
        L_0x00c0:
            int r5 = r8.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r5 = r5 & r0
            if (r5 != r0) goto L_0x00d3
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r5 = r8.strings_     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            if (r5 == 0) goto L_0x00d2
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder r7 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r7.mergeFrom(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            goto L_0x00d3
        L_0x00d2:
            throw r7     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
        L_0x00d3:
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable> r5 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r5 = r9.readMessage(r5, r10)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable) r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r8.strings_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            if (r7 == 0) goto L_0x00e8
            r7.mergeFrom(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r5 = r7.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r8.strings_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
        L_0x00e8:
            int r5 = r8.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            r5 = r5 | r0
            r8.bitField0_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x0101, IOException -> 0x00f4 }
            goto L_0x0025
        L_0x00ef:
            r2 = 1
            goto L_0x0025
        L_0x00f2:
            r9 = move-exception
            goto L_0x0105
        L_0x00f4:
            r9 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r10 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00f2 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00f2 }
            r10.<init>(r9)     // Catch:{ all -> 0x00f2 }
            r10.unfinishedMessage = r8     // Catch:{ all -> 0x00f2 }
            throw r10     // Catch:{ all -> 0x00f2 }
        L_0x0101:
            r9 = move-exception
            r9.unfinishedMessage = r8     // Catch:{ all -> 0x00f2 }
            throw r9     // Catch:{ all -> 0x00f2 }
        L_0x0105:
            r10 = r3 & 8
            if (r10 != r4) goto L_0x0111
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r10 = r8.class__
            java.util.List r10 = java.util.Collections.unmodifiableList(r10)
            r8.class__ = r10
        L_0x0111:
            r1.flush()     // Catch:{ IOException -> 0x011d, all -> 0x0115 }
            goto L_0x011d
        L_0x0115:
            r9 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r10 = r11.toByteString()
            r8.unknownFields = r10
            throw r9
        L_0x011d:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r10 = r11.toByteString()
            r8.unknownFields = r10
            kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor> r10 = r8.extensions
            r10.makeImmutable()
            throw r9
        L_0x0129:
            r9 = r3 & 8
            if (r9 != r4) goto L_0x0135
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r9 = r8.class__
            java.util.List r9 = java.util.Collections.unmodifiableList(r9)
            r8.class__ = r9
        L_0x0135:
            r1.flush()     // Catch:{ IOException -> 0x0141, all -> 0x0139 }
            goto L_0x0141
        L_0x0139:
            r9 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r10 = r11.toByteString()
            r8.unknownFields = r10
            throw r9
        L_0x0141:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r9 = r11.toByteString()
            r8.unknownFields = r9
            kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor> r9 = r8.extensions
            r9.makeImmutable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1):void");
    }
}
