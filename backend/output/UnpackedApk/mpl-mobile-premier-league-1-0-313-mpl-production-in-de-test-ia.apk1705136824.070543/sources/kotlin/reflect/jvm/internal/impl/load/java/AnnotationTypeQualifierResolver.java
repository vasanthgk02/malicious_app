package kotlin.reflect.jvm.internal.impl.load.java;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* compiled from: AnnotationTypeQualifierResolver.kt */
public final class AnnotationTypeQualifierResolver {
    public final JavaTypeEnhancementState javaTypeEnhancementState;
    public final MemoizedFunctionToNullable<ClassDescriptor, AnnotationDescriptor> resolvedNicknames;

    /* compiled from: AnnotationTypeQualifierResolver.kt */
    public static final class TypeQualifierWithApplicability {
        public final int applicability;
        public final AnnotationDescriptor typeQualifier;

        public TypeQualifierWithApplicability(AnnotationDescriptor annotationDescriptor, int i) {
            Intrinsics.checkNotNullParameter(annotationDescriptor, "typeQualifier");
            this.typeQualifier = annotationDescriptor;
            this.applicability = i;
        }

        public final List<AnnotationQualifierApplicabilityType> component2() {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            ArrayList arrayList = new ArrayList();
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : values) {
                boolean z = true;
                if (!((this.applicability & (1 << annotationQualifierApplicabilityType.ordinal())) != 0)) {
                    AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = AnnotationQualifierApplicabilityType.TYPE_USE;
                    if (!((this.applicability & 8) != 0) || annotationQualifierApplicabilityType == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(annotationQualifierApplicabilityType);
                }
            }
            return arrayList;
        }
    }

    public AnnotationTypeQualifierResolver(StorageManager storageManager, JavaTypeEnhancementState javaTypeEnhancementState2) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState2, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = javaTypeEnhancementState2;
        this.resolvedNicknames = storageManager.createMemoizedFunctionWithNullableValues(new AnnotationTypeQualifierResolver$resolvedNicknames$1(this));
    }

    public final List<AnnotationQualifierApplicabilityType> mapConstantToQualifierApplicabilityTypes(ConstantValue<?> constantValue, Function2<? super EnumValue, ? super AnnotationQualifierApplicabilityType, Boolean> function2) {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        if (constantValue instanceof ArrayValue) {
            ArrayList arrayList = new ArrayList();
            for (ConstantValue mapConstantToQualifierApplicabilityTypes : (Iterable) ((ArrayValue) constantValue).value) {
                TweetUtils.addAll(arrayList, mapConstantToQualifierApplicabilityTypes(mapConstantToQualifierApplicabilityTypes, function2));
            }
            return arrayList;
        } else if (!(constantValue instanceof EnumValue)) {
            return EmptyList.INSTANCE;
        } else {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    annotationQualifierApplicabilityType = null;
                    break;
                }
                annotationQualifierApplicabilityType = values[i];
                if (((Boolean) function2.invoke(constantValue, annotationQualifierApplicabilityType)).booleanValue()) {
                    break;
                }
                i++;
            }
            return TweetUtils.listOfNotNull(annotationQualifierApplicabilityType);
        }
    }

    public final ReportLevel resolveJsr305AnnotationState(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        ReportLevel resolveJsr305CustomState = resolveJsr305CustomState(annotationDescriptor);
        return resolveJsr305CustomState == null ? this.javaTypeEnhancementState.globalJsr305Level : resolveJsr305CustomState;
    }

    public final ReportLevel resolveJsr305CustomState(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        Map<String, ReportLevel> map = this.javaTypeEnhancementState.userDefinedLevelForSpecificJsr305Annotation;
        FqName fqName = annotationDescriptor.getFqName();
        ReportLevel reportLevel = null;
        ReportLevel reportLevel2 = map.get(fqName == null ? null : fqName.asString());
        if (reportLevel2 != null) {
            return reportLevel2;
        }
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass != null) {
            AnnotationDescriptor findAnnotation = annotationClass.getAnnotations().findAnnotation(AnnotationQualifiersFqNamesKt.MIGRATION_ANNOTATION_FQNAME);
            ConstantValue<?> firstArgument = findAnnotation == null ? null : DescriptorUtilsKt.firstArgument(findAnnotation);
            EnumValue enumValue = firstArgument instanceof EnumValue ? (EnumValue) firstArgument : null;
            if (enumValue != null) {
                ReportLevel reportLevel3 = this.javaTypeEnhancementState.migrationLevelForJsr305;
                if (reportLevel3 == null) {
                    String asString = enumValue.enumEntryName.asString();
                    int hashCode = asString.hashCode();
                    if (hashCode != -2137067054) {
                        if (hashCode != -1838656823) {
                            if (hashCode == 2656902 && asString.equals("WARN")) {
                                reportLevel = ReportLevel.WARN;
                            }
                        } else if (asString.equals("STRICT")) {
                            reportLevel = ReportLevel.STRICT;
                        }
                    } else if (asString.equals("IGNORE")) {
                        reportLevel = ReportLevel.IGNORE;
                    }
                } else {
                    reportLevel = reportLevel3;
                }
            }
        }
        return reportLevel;
    }

    public final AnnotationDescriptor resolveTypeQualifierAnnotation(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        AnnotationDescriptor annotationDescriptor2 = null;
        if (this.javaTypeEnhancementState.disabledJsr305) {
            return null;
        }
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null) {
            return null;
        }
        if (AnnotationQualifiersFqNamesKt.BUILT_IN_TYPE_QUALIFIER_FQ_NAMES.contains(DescriptorUtilsKt.getFqNameSafe(annotationClass)) || annotationClass.getAnnotations().hasAnnotation(AnnotationQualifiersFqNamesKt.TYPE_QUALIFIER_FQNAME)) {
            return annotationDescriptor;
        }
        if (annotationClass.getKind() == ClassKind.ANNOTATION_CLASS) {
            annotationDescriptor2 = (AnnotationDescriptor) this.resolvedNicknames.invoke(annotationClass);
        }
        return annotationDescriptor2;
    }
}
