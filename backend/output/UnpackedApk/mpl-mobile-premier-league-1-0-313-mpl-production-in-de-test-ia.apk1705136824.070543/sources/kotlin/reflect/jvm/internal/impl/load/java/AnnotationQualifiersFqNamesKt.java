package kotlin.reflect.jvm.internal.impl.load.java;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: AnnotationQualifiersFqNames.kt */
public final class AnnotationQualifiersFqNamesKt {
    public static final Map<FqName, JavaDefaultQualifiers> BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    public static final Set<FqName> BUILT_IN_TYPE_QUALIFIER_FQ_NAMES = TweetUtils.setOf((T[]) new FqName[]{JvmAnnotationNamesKt.JAVAX_NONNULL_ANNOTATION, JvmAnnotationNamesKt.JAVAX_CHECKFORNULL_ANNOTATION});
    public static final List<AnnotationQualifierApplicabilityType> DEFAULT_JSPECIFY_APPLICABILITY = TweetUtils.listOf((T[]) new AnnotationQualifierApplicabilityType[]{AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE});
    public static final Map<FqName, JavaDefaultQualifiers> JSPECIFY_DEFAULT_ANNOTATIONS = TweetUtils.mapOf(new Pair(JvmAnnotationNamesKt.JSPECIFY_DEFAULT_NOT_NULL, new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2), DEFAULT_JSPECIFY_APPLICABILITY, false)));
    public static final FqName MIGRATION_ANNOTATION_FQNAME = new FqName((String) "kotlin.annotations.jvm.UnderMigration");
    public static final FqName TYPE_QUALIFIER_DEFAULT_FQNAME = new FqName((String) "javax.annotation.meta.TypeQualifierDefault");
    public static final FqName TYPE_QUALIFIER_FQNAME = new FqName((String) "javax.annotation.meta.TypeQualifier");
    public static final FqName TYPE_QUALIFIER_NICKNAME_FQNAME = new FqName((String) "javax.annotation.meta.TypeQualifierNickname");

    static {
        Map mapOf = ArraysKt___ArraysJvmKt.mapOf(new Pair(new FqName((String) "javax.annotation.ParametersAreNullableByDefault"), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2), TweetUtils.listOf(AnnotationQualifierApplicabilityType.VALUE_PARAMETER), false, 4)), new Pair(new FqName((String) "javax.annotation.ParametersAreNonnullByDefault"), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2), TweetUtils.listOf(AnnotationQualifierApplicabilityType.VALUE_PARAMETER), false, 4)));
        Map<FqName, JavaDefaultQualifiers> map = JSPECIFY_DEFAULT_ANNOTATIONS;
        Intrinsics.checkNotNullParameter(mapOf, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapOf);
        linkedHashMap.putAll(map);
        BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS = linkedHashMap;
    }
}
