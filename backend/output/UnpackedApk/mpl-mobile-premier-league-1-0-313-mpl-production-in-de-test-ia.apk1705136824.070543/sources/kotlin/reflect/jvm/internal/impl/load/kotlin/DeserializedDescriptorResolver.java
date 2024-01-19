package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;

/* compiled from: DeserializedDescriptorResolver.kt */
public final class DeserializedDescriptorResolver {
    public static final Companion Companion = new Companion(null);
    public static final JvmMetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION = new JvmMetadataVersion(1, 1, 2);
    public static final JvmMetadataVersion KOTLIN_1_3_M1_METADATA_VERSION = new JvmMetadataVersion(1, 1, 11);
    public static final JvmMetadataVersion KOTLIN_1_3_RC_METADATA_VERSION = new JvmMetadataVersion(1, 1, 13);
    public static final Set<Kind> KOTLIN_CLASS = TweetUtils.setOf(Kind.CLASS);
    public static final Set<Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = TweetUtils.setOf((T[]) new Kind[]{Kind.FILE_FACADE, Kind.MULTIFILE_CLASS_PART});
    public DeserializationComponents components;

    /* compiled from: DeserializedDescriptorResolver.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final MemberScope createKotlinPackagePartScope(PackageFragmentDescriptor packageFragmentDescriptor, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Pair pair;
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] readData = readData(kotlinJvmBinaryClass, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (readData == null) {
            return null;
        }
        String[] strArr = kotlinJvmBinaryClass.getClassHeader().strings;
        if (strArr == null) {
            return null;
        }
        try {
            JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
            pair = JvmProtoBufUtil.readPackageDataFrom(readData, strArr);
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalStateException(Intrinsics.stringPlus("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
        } catch (Throwable th) {
            if (getComponents().configuration.getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().metadataVersion.isCompatible()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        ProtoBuf$Package protoBuf$Package = (ProtoBuf$Package) pair.second;
        JvmNameResolver jvmNameResolver = (JvmNameResolver) pair.first;
        JvmPackagePartSource jvmPackagePartSource = new JvmPackagePartSource(kotlinJvmBinaryClass, protoBuf$Package, jvmNameResolver, getIncompatibility(kotlinJvmBinaryClass), isPreReleaseInvisible(kotlinJvmBinaryClass), getAbiStability(kotlinJvmBinaryClass));
        DeserializedPackageMemberScope deserializedPackageMemberScope = new DeserializedPackageMemberScope(packageFragmentDescriptor, protoBuf$Package, jvmNameResolver, kotlinJvmBinaryClass.getClassHeader().metadataVersion, jvmPackagePartSource, getComponents(), DeserializedDescriptorResolver$createKotlinPackagePartScope$2.INSTANCE);
        return deserializedPackageMemberScope;
    }

    public final DeserializedContainerAbiStability getAbiStability(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getComponents().configuration.getAllowUnstableDependencies()) {
            return DeserializedContainerAbiStability.STABLE;
        }
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        boolean z = false;
        if (classHeader.has(classHeader.extraInt, 64) && !classHeader.has(classHeader.extraInt, 32)) {
            return DeserializedContainerAbiStability.FIR_UNSTABLE;
        }
        KotlinClassHeader classHeader2 = kotlinJvmBinaryClass.getClassHeader();
        if (classHeader2.has(classHeader2.extraInt, 16) && !classHeader2.has(classHeader2.extraInt, 32)) {
            z = true;
        }
        if (z) {
            return DeserializedContainerAbiStability.IR_UNSTABLE;
        }
        return DeserializedContainerAbiStability.STABLE;
    }

    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        throw null;
    }

    public final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getComponents().configuration.getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().metadataVersion.isCompatible()) {
            return null;
        }
        return new IncompatibleVersionErrorData<>(kotlinJvmBinaryClass.getClassHeader().metadataVersion, JvmMetadataVersion.INSTANCE, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6.getClassHeader().metadataVersion, KOTLIN_1_1_EAP_METADATA_VERSION) == false) goto L_0x0029;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isPreReleaseInvisible(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r6) {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r0 = r5.getComponents()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration r0 = r0.configuration
            boolean r0 = r0.getReportErrorsOnPreReleaseDependencies()
            r1 = 0
            r2 = 1
            r3 = 2
            if (r0 == 0) goto L_0x0029
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r6.getClassHeader()
            int r4 = r0.extraInt
            boolean r0 = r0.has(r4, r3)
            if (r0 != 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r6.getClassHeader()
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion r0 = r0.metadataVersion
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion r4 = KOTLIN_1_1_EAP_METADATA_VERSION
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 != 0) goto L_0x0054
        L_0x0029:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r0 = r5.getComponents()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration r0 = r0.configuration
            boolean r0 = r0.getSkipPrereleaseCheck()
            if (r0 != 0) goto L_0x0051
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r6.getClassHeader()
            int r4 = r0.extraInt
            boolean r0 = r0.has(r4, r3)
            if (r0 == 0) goto L_0x0051
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r6 = r6.getClassHeader()
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion r6 = r6.metadataVersion
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion r0 = KOTLIN_1_3_M1_METADATA_VERSION
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
            if (r6 == 0) goto L_0x0051
            r6 = 1
            goto L_0x0052
        L_0x0051:
            r6 = 0
        L_0x0052:
            if (r6 == 0) goto L_0x0055
        L_0x0054:
            r1 = 1
        L_0x0055:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver.isPreReleaseInvisible(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass):boolean");
    }

    public final ClassData readClassData$descriptors_jvm(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Pair pair;
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] readData = readData(kotlinJvmBinaryClass, KOTLIN_CLASS);
        if (readData == null) {
            return null;
        }
        String[] strArr = kotlinJvmBinaryClass.getClassHeader().strings;
        if (strArr == null) {
            return null;
        }
        try {
            JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
            pair = JvmProtoBufUtil.readClassDataFrom(readData, strArr);
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalStateException(Intrinsics.stringPlus("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
        } catch (Throwable th) {
            if (getComponents().configuration.getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().metadataVersion.isCompatible()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        return new ClassData((JvmNameResolver) pair.first, (ProtoBuf$Class) pair.second, kotlinJvmBinaryClass.getClassHeader().metadataVersion, new KotlinJvmBinarySourceElement(kotlinJvmBinaryClass, getIncompatibility(kotlinJvmBinaryClass), isPreReleaseInvisible(kotlinJvmBinaryClass), getAbiStability(kotlinJvmBinaryClass)));
    }

    public final String[] readData(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends Kind> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] strArr = classHeader.data;
        if (strArr == null) {
            strArr = classHeader.incompatibleData;
        }
        if (strArr != null && set.contains(classHeader.kind)) {
            return strArr;
        }
        return null;
    }
}
