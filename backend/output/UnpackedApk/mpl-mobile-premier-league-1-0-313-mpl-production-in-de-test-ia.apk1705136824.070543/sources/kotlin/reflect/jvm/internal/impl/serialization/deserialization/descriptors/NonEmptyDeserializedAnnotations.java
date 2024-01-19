package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedAnnotations.kt */
public final class NonEmptyDeserializedAnnotations extends DeserializedAnnotations {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NonEmptyDeserializedAnnotations(StorageManager storageManager, Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        // Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        // Intrinsics.checkNotNullParameter(function0, "compute");
        super(storageManager, function0);
    }

    public boolean isEmpty() {
        return false;
    }
}
