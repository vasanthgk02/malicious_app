package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: AnnotationsImpl.kt */
public final class AnnotationsImpl implements Annotations {
    public final List<AnnotationDescriptor> annotations;

    public AnnotationsImpl(List<? extends AnnotationDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, "annotations");
        this.annotations = list;
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        return TweetUtils.findAnnotation((Annotations) this, fqName);
    }

    public boolean hasAnnotation(FqName fqName) {
        return TweetUtils.hasAnnotation(this, fqName);
    }

    public boolean isEmpty() {
        return this.annotations.isEmpty();
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return this.annotations.iterator();
    }

    public String toString() {
        return this.annotations.toString();
    }
}
