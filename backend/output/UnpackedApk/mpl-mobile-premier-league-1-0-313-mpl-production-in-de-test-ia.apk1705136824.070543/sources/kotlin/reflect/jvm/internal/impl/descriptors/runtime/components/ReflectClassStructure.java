package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: ReflectKotlinClass.kt */
public final class ReflectClassStructure {
    public static final ClassLiteralValue classLiteralValue(Class<?> cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            Intrinsics.checkNotNullExpressionValue(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            ClassId classId = ReflectClassUtilKt.getClassId(cls);
            JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
            FqName asSingleFqName = classId.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName, "javaClassId.asSingleFqName()");
            ClassId mapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(asSingleFqName);
            if (mapJavaToKotlin != null) {
                classId = mapJavaToKotlin;
            }
            return new ClassLiteralValue(classId, i);
        } else if (Intrinsics.areEqual(cls, Void.TYPE)) {
            ClassId classId2 = ClassId.topLevel(FqNames.unit.toSafe());
            Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new ClassLiteralValue(classId2, i);
        } else {
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "get(currentClass.name).primitiveType");
            if (i > 0) {
                ClassId classId3 = ClassId.topLevel(primitiveType.getArrayTypeFqName());
                Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(primitiveType.arrayTypeFqName)");
                return new ClassLiteralValue(classId3, i - 1);
            }
            ClassId classId4 = ClassId.topLevel(primitiveType.getTypeFqName());
            Intrinsics.checkNotNullExpressionValue(classId4, "topLevel(primitiveType.typeFqName)");
            return new ClassLiteralValue(classId4, i);
        }
    }

    public static final void loadClassAnnotations(Class<?> cls, AnnotationVisitor annotationVisitor) {
        Intrinsics.checkNotNullParameter(cls, "klass");
        Intrinsics.checkNotNullParameter(annotationVisitor, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = declaredAnnotations[i];
            i++;
            Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
            processAnnotation(annotationVisitor, annotation);
        }
        annotationVisitor.visitEnd();
    }

    public static final void processAnnotation(AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class javaClass = TweetUtils.getJavaClass(TweetUtils.getAnnotationClass(annotation));
        AnnotationArgumentVisitor visitAnnotation = annotationVisitor.visitAnnotation(ReflectClassUtilKt.getClassId(javaClass), new ReflectAnnotationSource(annotation));
        if (visitAnnotation != null) {
            processAnnotationArguments(visitAnnotation, annotation, javaClass);
        }
    }

    public static final void processAnnotationArguments(AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                Intrinsics.checkNotNull(invoke);
                Name identifier = Name.identifier(method.getName());
                Intrinsics.checkNotNullExpressionValue(identifier, "identifier(method.name)");
                Class<?> cls2 = invoke.getClass();
                if (Intrinsics.areEqual(cls2, Class.class)) {
                    annotationArgumentVisitor.visitClassLiteral(identifier, classLiteralValue((Class) invoke));
                } else if (ReflectKotlinClassKt.TYPES_ELIGIBLE_FOR_SIMPLE_VISIT.contains(cls2)) {
                    annotationArgumentVisitor.visit(identifier, invoke);
                } else if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(cls2)) {
                    if (!cls2.isEnum()) {
                        cls2 = cls2.getEnclosingClass();
                    }
                    Intrinsics.checkNotNullExpressionValue(cls2, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                    ClassId classId = ReflectClassUtilKt.getClassId(cls2);
                    Name identifier2 = Name.identifier(((Enum) invoke).name());
                    Intrinsics.checkNotNullExpressionValue(identifier2, "identifier((value as Enum<*>).name)");
                    annotationArgumentVisitor.visitEnum(identifier, classId, identifier2);
                } else if (Annotation.class.isAssignableFrom(cls2)) {
                    Class[] interfaces = cls2.getInterfaces();
                    Intrinsics.checkNotNullExpressionValue(interfaces, "clazz.interfaces");
                    Class cls3 = (Class) TweetUtils.single((T[]) interfaces);
                    Intrinsics.checkNotNullExpressionValue(cls3, "annotationClass");
                    AnnotationArgumentVisitor visitAnnotation = annotationArgumentVisitor.visitAnnotation(identifier, ReflectClassUtilKt.getClassId(cls3));
                    if (visitAnnotation != null) {
                        processAnnotationArguments(visitAnnotation, (Annotation) invoke, cls3);
                    }
                } else if (cls2.isArray()) {
                    AnnotationArrayArgumentVisitor visitArray = annotationArgumentVisitor.visitArray(identifier);
                    if (visitArray == null) {
                        continue;
                    } else {
                        Class<?> componentType = cls2.getComponentType();
                        if (componentType.isEnum()) {
                            Intrinsics.checkNotNullExpressionValue(componentType, "componentType");
                            ClassId classId2 = ReflectClassUtilKt.getClassId(componentType);
                            Object[] objArr = (Object[]) invoke;
                            int length2 = objArr.length;
                            int i2 = 0;
                            while (i2 < length2) {
                                Object obj = objArr[i2];
                                i2++;
                                if (obj != null) {
                                    Name identifier3 = Name.identifier(((Enum) obj).name());
                                    Intrinsics.checkNotNullExpressionValue(identifier3, "identifier((element as Enum<*>).name)");
                                    visitArray.visitEnum(classId2, identifier3);
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
                                }
                            }
                        } else if (Intrinsics.areEqual(componentType, Class.class)) {
                            Object[] objArr2 = (Object[]) invoke;
                            int length3 = objArr2.length;
                            int i3 = 0;
                            while (i3 < length3) {
                                Object obj2 = objArr2[i3];
                                i3++;
                                if (obj2 != null) {
                                    visitArray.visitClassLiteral(classLiteralValue((Class) obj2));
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
                                }
                            }
                        } else {
                            Object[] objArr3 = (Object[]) invoke;
                            int length4 = objArr3.length;
                            int i4 = 0;
                            while (i4 < length4) {
                                Object obj3 = objArr3[i4];
                                i4++;
                                visitArray.visit(obj3);
                            }
                        }
                        visitArray.visitEnd();
                    }
                } else {
                    throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls2 + "): " + invoke);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }
}
