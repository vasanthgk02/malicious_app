package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.io.InputStream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
public final class AbstractDeserializedPackageFragmentProvider$fragments$1 extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {
    public final /* synthetic */ AbstractDeserializedPackageFragmentProvider this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractDeserializedPackageFragmentProvider$fragments$1(AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider) {
        // this.this$0 = abstractDeserializedPackageFragmentProvider;
        super(1);
    }

    public Object invoke(Object obj) {
        DeserializedPackageFragment deserializedPackageFragment;
        FqName fqName = (FqName) obj;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = (JvmBuiltInsPackageFragmentProvider) this.this$0;
        if (jvmBuiltInsPackageFragmentProvider != null) {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            InputStream findBuiltInsData = jvmBuiltInsPackageFragmentProvider.finder.findBuiltInsData(fqName);
            if (findBuiltInsData == null) {
                deserializedPackageFragment = null;
            } else {
                deserializedPackageFragment = BuiltInsPackageFragmentImpl.create(fqName, jvmBuiltInsPackageFragmentProvider.storageManager, jvmBuiltInsPackageFragmentProvider.moduleDescriptor, findBuiltInsData, false);
            }
            if (deserializedPackageFragment == null) {
                return null;
            }
            DeserializationComponents deserializationComponents = this.this$0.components;
            if (deserializationComponents != null) {
                deserializedPackageFragment.initialize(deserializationComponents);
                return deserializedPackageFragment;
            }
            Intrinsics.throwUninitializedPropertyAccessException("components");
            throw null;
        }
        throw null;
    }
}
