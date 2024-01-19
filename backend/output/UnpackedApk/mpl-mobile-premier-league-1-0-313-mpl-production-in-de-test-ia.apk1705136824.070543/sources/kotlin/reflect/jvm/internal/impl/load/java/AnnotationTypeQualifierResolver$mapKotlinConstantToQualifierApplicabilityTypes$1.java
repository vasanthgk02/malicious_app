package kotlin.reflect.jvm.internal.impl.load.java;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;

/* compiled from: AnnotationTypeQualifierResolver.kt */
public final class AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1 extends Lambda implements Function2<EnumValue, AnnotationQualifierApplicabilityType, Boolean> {
    public final /* synthetic */ AnnotationTypeQualifierResolver this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
        // this.this$0 = annotationTypeQualifierResolver;
        super(2);
    }

    public Object invoke(Object obj, Object obj2) {
        EnumValue enumValue = (EnumValue) obj;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = (AnnotationQualifierApplicabilityType) obj2;
        Intrinsics.checkNotNullParameter(enumValue, "<this>");
        Intrinsics.checkNotNullParameter(annotationQualifierApplicabilityType, "it");
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = this.this$0;
        String javaTarget = annotationQualifierApplicabilityType.getJavaTarget();
        if (annotationTypeQualifierResolver != null) {
            JavaAnnotationTargetMapper javaAnnotationTargetMapper = JavaAnnotationTargetMapper.INSTANCE;
            Iterable<KotlinTarget> iterable = JavaAnnotationTargetMapper.targetNameLists.get(javaTarget);
            if (iterable == null) {
                iterable = EmptySet.INSTANCE;
            }
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
            for (KotlinTarget name : iterable) {
                arrayList.add(name.name());
            }
            return Boolean.valueOf(arrayList.contains(enumValue.enumEntryName.getIdentifier()));
        }
        throw null;
    }
}
