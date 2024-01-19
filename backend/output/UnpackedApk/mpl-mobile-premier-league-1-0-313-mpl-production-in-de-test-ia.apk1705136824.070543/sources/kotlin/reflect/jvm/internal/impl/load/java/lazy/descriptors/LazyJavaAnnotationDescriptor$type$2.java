package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
public final class LazyJavaAnnotationDescriptor$type$2 extends Lambda implements Function0<SimpleType> {
    public final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaAnnotationDescriptor$type$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        // this.this$0 = lazyJavaAnnotationDescriptor;
        super(0);
    }

    public Object invoke() {
        FqName fqName = this.this$0.getFqName();
        if (fqName == null) {
            return ErrorUtils.createErrorType(Intrinsics.stringPlus("No fqName: ", this.this$0.javaAnnotation));
        }
        KotlinBuiltIns builtIns = this.this$0.f5940c.components.module.getBuiltIns();
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        ClassDescriptor classDescriptor = null;
        ClassId mapJavaToKotlin = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(fqName);
        ClassDescriptor builtInClassByFqName = mapJavaToKotlin != null ? builtIns.getBuiltInClassByFqName(mapJavaToKotlin.asSingleFqName()) : null;
        if (builtInClassByFqName == null) {
            JavaClass resolve = this.this$0.javaAnnotation.resolve();
            if (resolve != null) {
                classDescriptor = this.this$0.f5940c.components.moduleClassResolver.resolveClass(resolve);
            }
            if (classDescriptor == null) {
                LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = this.this$0;
                ModuleDescriptor moduleDescriptor = lazyJavaAnnotationDescriptor.f5940c.components.module;
                ClassId classId = ClassId.topLevel(fqName);
                Intrinsics.checkNotNullExpressionValue(classId, "topLevel(fqName)");
                builtInClassByFqName = TweetUtils.findNonGenericClassAcrossDependencies(moduleDescriptor, classId, lazyJavaAnnotationDescriptor.f5940c.components.deserializedDescriptorResolver.getComponents().notFoundClasses);
            } else {
                builtInClassByFqName = classDescriptor;
            }
        }
        return builtInClassByFqName.getDefaultType();
    }
}
