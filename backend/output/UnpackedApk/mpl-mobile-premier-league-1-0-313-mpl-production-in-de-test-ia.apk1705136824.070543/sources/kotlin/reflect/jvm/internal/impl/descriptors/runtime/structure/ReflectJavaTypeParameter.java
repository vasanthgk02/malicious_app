package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaTypeParameter.kt */
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    public final TypeVariable<?> typeVariable;

    public ReflectJavaTypeParameter(TypeVariable<?> typeVariable2) {
        Intrinsics.checkNotNullParameter(typeVariable2, "typeVariable");
        this.typeVariable = typeVariable2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaTypeParameter) && Intrinsics.areEqual(this.typeVariable, ((ReflectJavaTypeParameter) obj).typeVariable);
    }

    public JavaAnnotation findAnnotation(FqName fqName) {
        return TweetUtils.findAnnotation((ReflectJavaAnnotationOwner) this, fqName);
    }

    public Collection getAnnotations() {
        return TweetUtils.getAnnotations((ReflectJavaAnnotationOwner) this);
    }

    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable2 = this.typeVariable;
        if (typeVariable2 instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable2;
        }
        return null;
    }

    public Name getName() {
        Name identifier = Name.identifier(this.typeVariable.getName());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(typeVariable.name)");
        return identifier;
    }

    public Collection getUpperBounds() {
        Type type;
        Type[] bounds = this.typeVariable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type reflectJavaClassifierType : bounds) {
            arrayList.add(new ReflectJavaClassifierType(reflectJavaClassifierType));
        }
        ReflectJavaClassifierType reflectJavaClassifierType2 = (ReflectJavaClassifierType) ArraysKt___ArraysJvmKt.singleOrNull((List<? extends T>) arrayList);
        if (reflectJavaClassifierType2 == null) {
            type = null;
        } else {
            type = reflectJavaClassifierType2.reflectType;
        }
        return Intrinsics.areEqual(type, Object.class) ? EmptyList.INSTANCE : arrayList;
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    public boolean isDeprecatedInJavaDoc() {
        TweetUtils.isDeprecatedInJavaDoc(this);
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline94(ReflectJavaTypeParameter.class, sb, ": ");
        sb.append(this.typeVariable);
        return sb.toString();
    }
}
