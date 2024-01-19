package kotlin.reflect.jvm.internal.impl.load.java;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JvmAnnotationNames.kt */
public final class JvmAnnotationNamesKt {
    public static final FqName ANDROIDX_RECENTLY_NON_NULL_ANNOTATION = new FqName((String) "androidx.annotation.RecentlyNonNull");
    public static final FqName ANDROIDX_RECENTLY_NULLABLE_ANNOTATION = new FqName((String) "androidx.annotation.RecentlyNullable");
    public static final FqName COMPATQUAL_NONNULL_ANNOTATION = new FqName((String) "org.checkerframework.checker.nullness.compatqual.NonNullDecl");
    public static final FqName COMPATQUAL_NULLABLE_ANNOTATION = new FqName((String) "org.checkerframework.checker.nullness.compatqual.NullableDecl");
    public static final FqName JAVAX_CHECKFORNULL_ANNOTATION = new FqName((String) "javax.annotation.CheckForNull");
    public static final FqName JAVAX_NONNULL_ANNOTATION = new FqName((String) "javax.annotation.Nonnull");
    public static final FqName JSPECIFY_DEFAULT_NOT_NULL = new FqName((String) "org.jspecify.annotations.DefaultNonNull");
    public static final FqName JSPECIFY_NULLABLE = new FqName((String) "org.jspecify.annotations.Nullable");
    public static final FqName JSPECIFY_NULLNESS_UNKNOWN = new FqName((String) "org.jspecify.annotations.NullnessUnspecified");
    public static final List<FqName> MUTABLE_ANNOTATIONS = TweetUtils.listOf((T[]) new FqName[]{JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION});
    public static final List<FqName> NOT_NULL_ANNOTATIONS = TweetUtils.listOf((T[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, new FqName((String) "edu.umd.cs.findbugs.annotations.NonNull"), new FqName((String) "androidx.annotation.NonNull"), new FqName((String) "androidx.annotation.NonNull"), new FqName((String) "android.annotation.NonNull"), new FqName((String) "com.android.annotations.NonNull"), new FqName((String) "org.eclipse.jdt.annotation.NonNull"), new FqName((String) "org.checkerframework.checker.nullness.qual.NonNull"), new FqName((String) "lombok.NonNull"), new FqName((String) "io.reactivex.annotations.NonNull")});
    public static final List<FqName> NULLABLE_ANNOTATIONS = TweetUtils.listOf((T[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName((String) "androidx.annotation.Nullable"), new FqName((String) "androidx.annotation.Nullable"), new FqName((String) "android.annotation.Nullable"), new FqName((String) "com.android.annotations.Nullable"), new FqName((String) "org.eclipse.jdt.annotation.Nullable"), new FqName((String) "org.checkerframework.checker.nullness.qual.Nullable"), new FqName((String) "javax.annotation.Nullable"), new FqName((String) "javax.annotation.CheckForNull"), new FqName((String) "edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName((String) "edu.umd.cs.findbugs.annotations.Nullable"), new FqName((String) "edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName((String) "io.reactivex.annotations.Nullable")});
    public static final List<FqName> READ_ONLY_ANNOTATIONS = TweetUtils.listOf((T[]) new FqName[]{JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION});

    static {
        ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus((Set<? extends T>) new LinkedHashSet<Object>(), (Iterable<? extends T>) NULLABLE_ANNOTATIONS), JAVAX_NONNULL_ANNOTATION), (Iterable<? extends T>) NOT_NULL_ANNOTATIONS), COMPATQUAL_NULLABLE_ANNOTATION), COMPATQUAL_NONNULL_ANNOTATION), ANDROIDX_RECENTLY_NULLABLE_ANNOTATION), ANDROIDX_RECENTLY_NON_NULL_ANNOTATION), JSPECIFY_NULLABLE), JSPECIFY_NULLNESS_UNKNOWN), JSPECIFY_DEFAULT_NOT_NULL);
    }
}
