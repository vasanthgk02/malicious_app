package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Iterator;
import kotlin.collections.EmptyIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
public final class Annotations$Companion$EMPTY$1 implements Annotations {
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    public boolean hasAnnotation(FqName fqName) {
        return TweetUtils.hasAnnotation(this, fqName);
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return EmptyIterator.INSTANCE;
    }

    public String toString() {
        return "EMPTY";
    }
}
