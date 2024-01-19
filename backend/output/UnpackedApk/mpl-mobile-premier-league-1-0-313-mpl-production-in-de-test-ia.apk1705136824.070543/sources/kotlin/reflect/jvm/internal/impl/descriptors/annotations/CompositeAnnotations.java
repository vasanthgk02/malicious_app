package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.FilteringSequence$iterator$1;
import kotlin.sequences.FlatteningSequence;
import kotlin.sequences.FlatteningSequence$iterator$1;
import kotlin.sequences.Sequence;

/* compiled from: Annotations.kt */
public final class CompositeAnnotations implements Annotations {
    public final List<Annotations> delegates;

    public CompositeAnnotations(List<? extends Annotations> list) {
        Intrinsics.checkNotNullParameter(list, "delegates");
        this.delegates = list;
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Object obj;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Sequence mapNotNull = TypeUtilsKt.mapNotNull(ArraysKt___ArraysJvmKt.asSequence(this.delegates), new CompositeAnnotations$findAnnotation$1(fqName));
        Intrinsics.checkNotNullParameter(mapNotNull, "<this>");
        FilteringSequence$iterator$1 filteringSequence$iterator$1 = (FilteringSequence$iterator$1) ((FilteringSequence) mapNotNull).iterator();
        if (!filteringSequence$iterator$1.hasNext()) {
            obj = null;
        } else {
            obj = filteringSequence$iterator$1.next();
        }
        return (AnnotationDescriptor) obj;
    }

    public boolean hasAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterator it = ((CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1) ArraysKt___ArraysJvmKt.asSequence(this.delegates)).iterator();
        while (it.hasNext()) {
            if (((Annotations) it.next()).hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        List<Annotations> list = this.delegates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (Annotations isEmpty : list) {
            if (!isEmpty.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return new FlatteningSequence$iterator$1((FlatteningSequence) TypeUtilsKt.flatMap(ArraysKt___ArraysJvmKt.asSequence(this.delegates), CompositeAnnotations$iterator$1.INSTANCE));
    }

    public CompositeAnnotations(Annotations... annotationsArr) {
        Intrinsics.checkNotNullParameter(annotationsArr, "delegates");
        List<Annotations> list = TweetUtils.toList(annotationsArr);
        Intrinsics.checkNotNullParameter(list, "delegates");
        this.delegates = list;
    }
}
