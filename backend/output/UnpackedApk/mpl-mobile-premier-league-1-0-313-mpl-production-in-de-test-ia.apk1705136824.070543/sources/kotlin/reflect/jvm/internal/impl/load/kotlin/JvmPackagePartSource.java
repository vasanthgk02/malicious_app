package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.CharsKt__CharKt;
import org.apache.commons.lang.text.ExtendedMessageFormat;

/* compiled from: JvmPackagePartSource.kt */
public final class JvmPackagePartSource implements DeserializedContainerSource {
    public final JvmClassName className;
    public final JvmClassName facadeClassName;
    public final KotlinJvmBinaryClass knownJvmBinaryClass;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JvmPackagePartSource(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r5, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r6, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r7, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion> r8, boolean r9, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r10) {
        /*
            r4 = this;
            java.lang.String r8 = "kotlinClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r8)
            java.lang.String r8 = "packageProto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            java.lang.String r9 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r9)
            java.lang.String r0 = "abiStability"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.reflect.jvm.internal.impl.name.ClassId r1 = r5.getClassId()
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r1 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byClassId(r1)
            java.lang.String r2 = "byClassId(kotlinClass.classId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r2 = r5.getClassHeader()
            java.lang.String r2 = r2.getMultifileClassName()
            if (r2 != 0) goto L_0x002c
            goto L_0x003c
        L_0x002c:
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0034
            r3 = 1
            goto L_0x0035
        L_0x0034:
            r3 = 0
        L_0x0035:
            if (r3 == 0) goto L_0x003c
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r2 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byInternalName(r2)
            goto L_0x003d
        L_0x003c:
            r2 = 0
        L_0x003d:
            java.lang.String r3 = "className"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r4.<init>()
            r4.className = r1
            r4.facadeClassName = r2
            r4.knownJvmBinaryClass = r5
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, java.lang.Integer> r5 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.packageModuleName
            java.lang.String r8 = "packageModuleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            java.lang.Object r5 = com.twitter.sdk.android.tweetui.TweetUtils.getExtensionOrNull(r6, r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 != 0) goto L_0x0064
            goto L_0x006b
        L_0x0064:
            int r5 = r5.intValue()
            r7.getString(r5)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource.<init>(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData, boolean, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability):void");
    }

    public final ClassId getClassId() {
        FqName fqName;
        JvmClassName jvmClassName = this.className;
        int lastIndexOf = jvmClassName.internalName.lastIndexOf("/");
        if (lastIndexOf == -1) {
            fqName = FqName.ROOT;
            if (fqName == null) {
                JvmClassName.$$$reportNull$$$0(7);
                throw null;
            }
        } else {
            fqName = new FqName(jvmClassName.internalName.substring(0, lastIndexOf).replace('/', '.'));
        }
        return new ClassId(fqName, getSimpleName());
    }

    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkNotNullExpressionValue(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }

    public String getPresentableString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Class '");
        outline73.append(getClassId().asSingleFqName().asString());
        outline73.append(ExtendedMessageFormat.QUOTE);
        return outline73.toString();
    }

    public final Name getSimpleName() {
        String internalName = this.className.getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "className.internalName");
        Name identifier = Name.identifier(CharsKt__CharKt.substringAfterLast$default(internalName, '/', null, 2));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(className.internalName.substringAfterLast('/'))");
        return identifier;
    }

    public String toString() {
        return JvmPackagePartSource.class.getSimpleName() + ": " + this.className;
    }
}
