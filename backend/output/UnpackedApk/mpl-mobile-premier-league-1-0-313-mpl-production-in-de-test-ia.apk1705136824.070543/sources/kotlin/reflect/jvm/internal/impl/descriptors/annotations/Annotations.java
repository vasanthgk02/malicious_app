package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Annotations.kt */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final Annotations EMPTY = new Annotations$Companion$EMPTY$1();

        public final Annotations create(List<? extends AnnotationDescriptor> list) {
            Intrinsics.checkNotNullParameter(list, "annotations");
            return list.isEmpty() ? EMPTY : new AnnotationsImpl(list);
        }
    }

    AnnotationDescriptor findAnnotation(FqName fqName);

    boolean hasAnnotation(FqName fqName);

    boolean isEmpty();
}
