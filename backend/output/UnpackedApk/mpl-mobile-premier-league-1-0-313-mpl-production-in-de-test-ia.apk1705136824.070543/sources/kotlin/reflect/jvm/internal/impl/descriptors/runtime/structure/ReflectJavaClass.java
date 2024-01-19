package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: ReflectJavaClass.kt */
public final class ReflectJavaClass extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {
    public final Class<?> klass;

    public ReflectJavaClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "klass");
        this.klass = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaClass) && Intrinsics.areEqual(this.klass, ((ReflectJavaClass) obj).klass);
    }

    public JavaAnnotation findAnnotation(FqName fqName) {
        return TweetUtils.findAnnotation((ReflectJavaAnnotationOwner) this, fqName);
    }

    public Collection getAnnotations() {
        return TweetUtils.getAnnotations((ReflectJavaAnnotationOwner) this);
    }

    public Collection getConstructors() {
        Constructor[] declaredConstructors = this.klass.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        return TypeUtilsKt.toList(TypeUtilsKt.map(TypeUtilsKt.filterNot(TweetUtils.asSequence(declaredConstructors), ReflectJavaClass$constructors$1.INSTANCE), ReflectJavaClass$constructors$2.INSTANCE));
    }

    public AnnotatedElement getElement() {
        return this.klass;
    }

    public Collection getFields() {
        Field[] declaredFields = this.klass.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        return TypeUtilsKt.toList(TypeUtilsKt.map(TypeUtilsKt.filterNot(TweetUtils.asSequence(declaredFields), ReflectJavaClass$fields$1.INSTANCE), ReflectJavaClass$fields$2.INSTANCE));
    }

    public FqName getFqName() {
        FqName asSingleFqName = ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "klass.classId.asSingleFqName()");
        return asSingleFqName;
    }

    public Collection getInnerClassNames() {
        Class[] declaredClasses = this.klass.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "klass.declaredClasses");
        return TypeUtilsKt.toList(TypeUtilsKt.mapNotNull(TypeUtilsKt.filterNot(TweetUtils.asSequence(declaredClasses), ReflectJavaClass$innerClassNames$1.INSTANCE), ReflectJavaClass$innerClassNames$2.INSTANCE));
    }

    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    public Collection getMethods() {
        Method[] declaredMethods = this.klass.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        return TypeUtilsKt.toList(TypeUtilsKt.map(TypeUtilsKt.filter(TweetUtils.asSequence(declaredMethods), new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.INSTANCE));
    }

    public int getModifiers() {
        return this.klass.getModifiers();
    }

    public Name getName() {
        Name identifier = Name.identifier(this.klass.getSimpleName());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(klass.simpleName)");
        return identifier;
    }

    public JavaClass getOuterClass() {
        Class<?> declaringClass = this.klass.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new ReflectJavaClass(declaringClass);
    }

    public Collection<JavaClassifierType> getPermittedTypes() {
        return EmptyList.INSTANCE;
    }

    public Collection<JavaRecordComponent> getRecordComponents() {
        return EmptyList.INSTANCE;
    }

    public Collection<JavaClassifierType> getSupertypes() {
        Type type = Object.class;
        if (Intrinsics.areEqual(this.klass, type)) {
            return EmptyList.INSTANCE;
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        Type genericSuperclass = this.klass.getGenericSuperclass();
        if (genericSuperclass != null) {
            type = genericSuperclass;
        }
        spreadBuilder.list.add(type);
        Type[] genericInterfaces = this.klass.getGenericInterfaces();
        Intrinsics.checkNotNullExpressionValue(genericInterfaces, "klass.genericInterfaces");
        spreadBuilder.addSpread(genericInterfaces);
        List<Type> listOf = TweetUtils.listOf((T[]) spreadBuilder.list.toArray(new Type[spreadBuilder.size()]));
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(listOf, 10));
        for (Type reflectJavaClassifierType : listOf) {
            arrayList.add(new ReflectJavaClassifierType(reflectJavaClassifierType));
        }
        return arrayList;
    }

    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable[] typeParameters = this.klass.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable reflectJavaTypeParameter : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(reflectJavaTypeParameter));
        }
        return arrayList;
    }

    public Visibility getVisibility() {
        return TweetUtils.getVisibility(this);
    }

    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public boolean isAbstract() {
        Intrinsics.checkNotNullParameter(this, "this");
        return Modifier.isAbstract(getModifiers());
    }

    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    public boolean isDeprecatedInJavaDoc() {
        TweetUtils.isDeprecatedInJavaDoc(this);
        return false;
    }

    public boolean isEnum() {
        return this.klass.isEnum();
    }

    public boolean isFinal() {
        Intrinsics.checkNotNullParameter(this, "this");
        return Modifier.isFinal(getModifiers());
    }

    public boolean isInterface() {
        return this.klass.isInterface();
    }

    public boolean isRecord() {
        return false;
    }

    public boolean isSealed() {
        return false;
    }

    public boolean isStatic() {
        Intrinsics.checkNotNullParameter(this, "this");
        return Modifier.isStatic(getModifiers());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline94(ReflectJavaClass.class, sb, ": ");
        sb.append(this.klass);
        return sb.toString();
    }
}
