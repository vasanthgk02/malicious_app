package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotation.kt */
public final class ReflectJavaAnnotation extends ReflectJavaElement implements JavaAnnotation {
    public final Annotation annotation;

    public ReflectJavaAnnotation(Annotation annotation2) {
        Intrinsics.checkNotNullParameter(annotation2, "annotation");
        this.annotation = annotation2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaAnnotation) && Intrinsics.areEqual(this.annotation, ((ReflectJavaAnnotation) obj).annotation);
    }

    public Collection<JavaAnnotationArgument> getArguments() {
        Object obj;
        Method[] declaredMethods = TweetUtils.getJavaClass(TweetUtils.getAnnotationClass(this.annotation)).getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            Object invoke = method.invoke(this.annotation, new Object[0]);
            Intrinsics.checkNotNullExpressionValue(invoke, "method.invoke(annotation)");
            Name identifier = Name.identifier(method.getName());
            Intrinsics.checkNotNullParameter(invoke, HSLCriteriaBuilder.VALUE);
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(invoke.getClass())) {
                obj = new ReflectJavaEnumValueAnnotationArgument(identifier, (Enum) invoke);
            } else if (invoke instanceof Annotation) {
                obj = new ReflectJavaAnnotationAsAnnotationArgument(identifier, (Annotation) invoke);
            } else if (invoke instanceof Object[]) {
                obj = new ReflectJavaArrayAnnotationArgument(identifier, (Object[]) invoke);
            } else if (invoke instanceof Class) {
                obj = new ReflectJavaClassObjectAnnotationArgument(identifier, (Class) invoke);
            } else {
                obj = new ReflectJavaLiteralAnnotationArgument(identifier, invoke);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(TweetUtils.getJavaClass(TweetUtils.getAnnotationClass(this.annotation)));
    }

    public int hashCode() {
        return this.annotation.hashCode();
    }

    public boolean isFreshlySupportedTypeUseAnnotation() {
        Intrinsics.checkNotNullParameter(this, "this");
        return false;
    }

    public boolean isIdeExternalAnnotation() {
        Intrinsics.checkNotNullParameter(this, "this");
        return false;
    }

    public JavaClass resolve() {
        return new ReflectJavaClass(TweetUtils.getJavaClass(TweetUtils.getAnnotationClass(this.annotation)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline94(ReflectJavaAnnotation.class, sb, ": ");
        sb.append(this.annotation);
        return sb.toString();
    }
}
