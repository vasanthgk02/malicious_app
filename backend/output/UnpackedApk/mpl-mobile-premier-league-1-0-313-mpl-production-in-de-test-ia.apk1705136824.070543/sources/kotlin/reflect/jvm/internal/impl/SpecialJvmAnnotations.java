package kotlin.reflect.jvm.internal.impl;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: SpecialJvmAnnotations.kt */
public final class SpecialJvmAnnotations {
    public static final SpecialJvmAnnotations INSTANCE = null;
    public static final Set<ClassId> SPECIAL_ANNOTATIONS;

    static {
        List<FqName> listOf = TweetUtils.listOf((T[]) new FqName[]{JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, JvmAnnotationNames.TARGET_ANNOTATION, JvmAnnotationNames.RETENTION_ANNOTATION, JvmAnnotationNames.DOCUMENTED_ANNOTATION});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (FqName fqName : listOf) {
            linkedHashSet.add(ClassId.topLevel(fqName));
        }
        SPECIAL_ANNOTATIONS = linkedHashSet;
    }
}
