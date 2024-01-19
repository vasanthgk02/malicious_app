package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BuiltInsPackageFragmentImpl.kt */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf$PackageFragment protoBuf$PackageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        super(fqName, storageManager, moduleDescriptor, protoBuf$PackageFragment, builtInsBinaryVersion, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0072, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0073, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r12, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0076, code lost:
        throw r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl create(kotlin.reflect.jvm.internal.impl.name.FqName r9, kotlin.reflect.jvm.internal.impl.storage.StorageManager r10, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r11, java.io.InputStream r12, boolean r13) {
        /*
            java.lang.String r0 = "fqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "storageManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "module"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion$Companion r0 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.Companion     // Catch:{ all -> 0x0070 }
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion r6 = r0.readFrom(r12)     // Catch:{ all -> 0x0070 }
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion r0 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.INSTANCE     // Catch:{ all -> 0x0070 }
            boolean r0 = r6.isCompatibleTo(r0)     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x004a
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE     // Catch:{ all -> 0x0070 }
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r0 = r0.extensionRegistry     // Catch:{ all -> 0x0070 }
            kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment.PARSER     // Catch:{ all -> 0x0070 }
            kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser r1 = (kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser) r1     // Catch:{ all -> 0x0070 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r1.parsePartialFrom(r12, r0)     // Catch:{ all -> 0x0070 }
            r1.checkMessageInitialized(r0)     // Catch:{ all -> 0x0070 }
            r5 = r0
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment) r5     // Catch:{ all -> 0x0070 }
            r0 = 0
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r12, r0)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl r12 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r8 = 0
            r1 = r12
            r2 = r9
            r3 = r10
            r4 = r11
            r7 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r12
        L_0x004a:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r10.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r11 = "Kotlin built-in definition format version is not supported: expected "
            r10.append(r11)     // Catch:{ all -> 0x0070 }
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion r11 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.INSTANCE     // Catch:{ all -> 0x0070 }
            r10.append(r11)     // Catch:{ all -> 0x0070 }
            java.lang.String r11 = ", actual "
            r10.append(r11)     // Catch:{ all -> 0x0070 }
            r10.append(r6)     // Catch:{ all -> 0x0070 }
            java.lang.String r11 = ". Please update Kotlin"
            r10.append(r11)     // Catch:{ all -> 0x0070 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0070 }
            r9.<init>(r10)     // Catch:{ all -> 0x0070 }
            throw r9     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r10 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r12, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl.create(kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, java.io.InputStream, boolean):kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl");
    }
}
