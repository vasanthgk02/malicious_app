package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedAnnotations.kt */
public class DeserializedAnnotations implements Annotations {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedAnnotations.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    public final NotNullLazyValue annotations$delegate;

    public DeserializedAnnotations(StorageManager storageManager, Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "compute");
        this.annotations$delegate = storageManager.createLazyValue(function0);
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        return TweetUtils.findAnnotation((Annotations) this, fqName);
    }

    public boolean hasAnnotation(FqName fqName) {
        return TweetUtils.hasAnnotation(this, fqName);
    }

    public boolean isEmpty() {
        return ((List) TweetUtils.getValue(this.annotations$delegate, $$delegatedProperties[0])).isEmpty();
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return ((List) TweetUtils.getValue(this.annotations$delegate, $$delegatedProperties[0])).iterator();
    }
}
