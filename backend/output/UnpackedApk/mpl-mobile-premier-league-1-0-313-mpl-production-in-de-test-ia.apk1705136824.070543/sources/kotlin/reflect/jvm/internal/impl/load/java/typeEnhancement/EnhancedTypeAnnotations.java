package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Iterator;
import kotlin.collections.EmptyIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: typeEnhancement.kt */
public final class EnhancedTypeAnnotations implements Annotations {
    public final FqName fqNameToMatch;

    public EnhancedTypeAnnotations(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqNameToMatch");
        this.fqNameToMatch = fqName;
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (Intrinsics.areEqual(fqName, this.fqNameToMatch)) {
            return EnhancedTypeAnnotationDescriptor.INSTANCE;
        }
        return null;
    }

    public boolean hasAnnotation(FqName fqName) {
        return TweetUtils.hasAnnotation(this, fqName);
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return EmptyIterator.INSTANCE;
    }
}
