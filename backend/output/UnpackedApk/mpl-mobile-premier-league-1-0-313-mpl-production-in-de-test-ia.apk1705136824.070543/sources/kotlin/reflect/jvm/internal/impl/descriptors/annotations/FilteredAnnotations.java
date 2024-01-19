package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
public final class FilteredAnnotations implements Annotations {
    public final Annotations delegate;
    public final Function1<FqName, Boolean> fqNameFilter;
    public final boolean isDefinitelyNewInference = false;

    public FilteredAnnotations(Annotations annotations, Function1<? super FqName, Boolean> function1) {
        Intrinsics.checkNotNullParameter(annotations, "delegate");
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
        Intrinsics.checkNotNullParameter(annotations, "delegate");
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
        this.delegate = annotations;
        this.fqNameFilter = function1;
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (((Boolean) this.fqNameFilter.invoke(fqName)).booleanValue()) {
            return this.delegate.findAnnotation(fqName);
        }
        return null;
    }

    public boolean hasAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (((Boolean) this.fqNameFilter.invoke(fqName)).booleanValue()) {
            return this.delegate.hasAnnotation(fqName);
        }
        return false;
    }

    public boolean isEmpty() {
        boolean z;
        Annotations annotations = this.delegate;
        if (!(annotations instanceof Collection) || !((Collection) annotations).isEmpty()) {
            Iterator it = annotations.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (shouldBeReturned((AnnotationDescriptor) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (!this.isDefinitelyNewInference) {
            return z;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    public Iterator<AnnotationDescriptor> iterator() {
        Annotations annotations = this.delegate;
        ArrayList arrayList = new ArrayList();
        for (Object next : annotations) {
            if (shouldBeReturned((AnnotationDescriptor) next)) {
                arrayList.add(next);
            }
        }
        return arrayList.iterator();
    }

    public final boolean shouldBeReturned(AnnotationDescriptor annotationDescriptor) {
        FqName fqName = annotationDescriptor.getFqName();
        return fqName != null && ((Boolean) this.fqNameFilter.invoke(fqName)).booleanValue();
    }
}
