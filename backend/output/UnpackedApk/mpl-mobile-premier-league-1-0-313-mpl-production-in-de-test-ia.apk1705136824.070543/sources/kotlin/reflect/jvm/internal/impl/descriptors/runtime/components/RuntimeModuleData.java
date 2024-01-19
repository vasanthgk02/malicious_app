package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;

/* compiled from: RuntimeModuleData.kt */
public final class RuntimeModuleData {
    public final DeserializationComponents deserialization;
    public final PackagePartScopeCache packagePartScopeCache;

    public RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache2, DefaultConstructorMarker defaultConstructorMarker) {
        this.deserialization = deserializationComponents;
        this.packagePartScopeCache = packagePartScopeCache2;
    }
}
