package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaAnnotationTargetMapper$mapJavaTargetArguments$1 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
    public static final JavaAnnotationTargetMapper$mapJavaTargetArguments$1 INSTANCE = new JavaAnnotationTargetMapper$mapJavaTargetArguments$1();

    public JavaAnnotationTargetMapper$mapJavaTargetArguments$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        KotlinType kotlinType;
        ModuleDescriptor moduleDescriptor = (ModuleDescriptor) obj;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.INSTANCE;
        ValueParameterDescriptor annotationParameterByName = TweetUtils.getAnnotationParameterByName(JavaAnnotationMapper.TARGET_ANNOTATION_ALLOWED_TARGETS, moduleDescriptor.getBuiltIns().getBuiltInClassByFqName(FqNames.target));
        if (annotationParameterByName == null) {
            kotlinType = null;
        } else {
            kotlinType = annotationParameterByName.getType();
        }
        if (kotlinType != null) {
            return kotlinType;
        }
        SimpleType createErrorType = ErrorUtils.createErrorType("Error: AnnotationTarget[]");
        Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Error: AnnotationTarget[]\")");
        return createErrorType;
    }
}
