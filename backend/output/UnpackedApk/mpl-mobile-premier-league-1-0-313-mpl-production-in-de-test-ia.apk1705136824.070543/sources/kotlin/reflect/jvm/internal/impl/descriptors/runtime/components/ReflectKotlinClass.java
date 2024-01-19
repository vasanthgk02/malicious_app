package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.CharsKt__CharKt;

/* compiled from: ReflectKotlinClass.kt */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public final KotlinClassHeader classHeader;
    public final Class<?> klass;

    public ReflectKotlinClass(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this.klass = cls;
        this.classHeader = kotlinClassHeader;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r0.data == null) goto L_0x006a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass create(java.lang.Class<?> r14) {
        /*
            java.lang.String r0 = "klass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor r0 = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor
            r0.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectClassStructure.loadClassAnnotations(r14, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass r1 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r2 = r0.headerKind
            r3 = 0
            if (r2 == 0) goto L_0x006a
            int[] r2 = r0.metadataVersionArray
            if (r2 != 0) goto L_0x0019
            goto L_0x006a
        L_0x0019:
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion r6 = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion
            int[] r2 = r0.metadataVersionArray
            int r4 = r0.extraInt
            r4 = r4 & 8
            r5 = 0
            if (r4 == 0) goto L_0x0026
            r4 = 1
            goto L_0x0027
        L_0x0026:
            r4 = 0
        L_0x0027:
            r6.<init>(r2, r4)
            boolean r2 = r6.isCompatible()
            if (r2 != 0) goto L_0x0037
            java.lang.String[] r2 = r0.data
            r0.incompatibleData = r2
            r0.data = r3
            goto L_0x004d
        L_0x0037:
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r2 = r0.headerKind
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r4 = kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.CLASS
            if (r2 == r4) goto L_0x0045
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r4 = kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.FILE_FACADE
            if (r2 == r4) goto L_0x0045
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r4 = kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS_PART
            if (r2 != r4) goto L_0x0046
        L_0x0045:
            r5 = 1
        L_0x0046:
            if (r5 == 0) goto L_0x004d
            java.lang.String[] r2 = r0.data
            if (r2 != 0) goto L_0x004d
            goto L_0x006a
        L_0x004d:
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r2 = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r5 = r0.headerKind
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion r4 = r0.bytecodeVersion
            if (r4 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion r4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion.INSTANCE
        L_0x0058:
            r7 = r4
            java.lang.String[] r8 = r0.data
            java.lang.String[] r9 = r0.incompatibleData
            java.lang.String[] r10 = r0.strings
            java.lang.String r11 = r0.extraString
            int r12 = r0.extraInt
            java.lang.String r13 = r0.packageName
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            goto L_0x006b
        L_0x006a:
            r2 = r3
        L_0x006b:
            if (r2 != 0) goto L_0x006e
            return r3
        L_0x006e:
            r1.<init>(r14, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.create(java.lang.Class):kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass");
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectKotlinClass) && Intrinsics.areEqual(this.klass, ((ReflectKotlinClass) obj).klass);
    }

    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    public String getLocation() {
        String name = this.klass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "klass.name");
        return Intrinsics.stringPlus(CharsKt__CharKt.replace$default(name, '.', '/', false, 4), ".class");
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public void loadClassAnnotations(AnnotationVisitor annotationVisitor, byte[] bArr) {
        Intrinsics.checkNotNullParameter(annotationVisitor, "visitor");
        ReflectClassStructure.loadClassAnnotations(this.klass, annotationVisitor);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline94(ReflectKotlinClass.class, sb, ": ");
        sb.append(this.klass);
        return sb.toString();
    }

    public void visitMembers(MemberVisitor memberVisitor, byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        Method[] methodArr;
        int i3;
        int i4;
        MemberVisitor memberVisitor2 = memberVisitor;
        Intrinsics.checkNotNullParameter(memberVisitor2, "visitor");
        Class<?> cls = this.klass;
        Intrinsics.checkNotNullParameter(cls, "klass");
        Intrinsics.checkNotNullParameter(memberVisitor2, "memberVisitor");
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i5 = 0;
        while (true) {
            str = "annotations";
            str2 = "parameterType";
            if (i5 >= length) {
                break;
            }
            Method method = declaredMethods[i5];
            int i6 = i5 + 1;
            Name identifier = Name.identifier(method.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(method.name)");
            Intrinsics.checkNotNullExpressionValue(method, AnalyticsConstants.METHOD);
            Intrinsics.checkNotNullParameter(method, AnalyticsConstants.METHOD);
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            Class[] parameterTypes = method.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            int length2 = parameterTypes.length;
            int i7 = 0;
            while (i7 < length2) {
                Class cls2 = parameterTypes[i7];
                i7++;
                Intrinsics.checkNotNullExpressionValue(cls2, str2);
                sb.append(ReflectClassUtilKt.getDesc(cls2));
            }
            sb.append(")");
            Class<?> returnType = method.getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
            sb.append(ReflectClassUtilKt.getDesc(returnType));
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            MethodAnnotationVisitor visitMethod = memberVisitor2.visitMethod(identifier, sb2);
            if (visitMethod == null) {
                methodArr = declaredMethods;
                i4 = length;
                i3 = i6;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "method.declaredAnnotations");
                int length3 = declaredAnnotations.length;
                int i8 = 0;
                while (i8 < length3) {
                    Annotation annotation = declaredAnnotations[i8];
                    i8++;
                    Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
                    ReflectClassStructure.processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "method.parameterAnnotations");
                int length4 = parameterAnnotations.length;
                int i9 = 0;
                while (i9 < length4) {
                    Annotation[] annotationArr = parameterAnnotations[i9];
                    int i10 = i9 + 1;
                    Intrinsics.checkNotNullExpressionValue(annotationArr, str);
                    int length5 = annotationArr.length;
                    int i11 = 0;
                    while (i11 < length5) {
                        Annotation annotation2 = annotationArr[i11];
                        i11++;
                        Method[] methodArr2 = declaredMethods;
                        Class javaClass = TweetUtils.getJavaClass(TweetUtils.getAnnotationClass(annotation2));
                        int i12 = length;
                        ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                        int i13 = i6;
                        Intrinsics.checkNotNullExpressionValue(annotation2, "annotation");
                        AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i9, classId, new ReflectAnnotationSource(annotation2));
                        if (visitParameterAnnotation != null) {
                            ReflectClassStructure.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                        }
                        declaredMethods = methodArr2;
                        length = i12;
                        i6 = i13;
                    }
                    i9 = i10;
                }
                methodArr = declaredMethods;
                i4 = length;
                i3 = i6;
                visitMethod.visitEnd();
            }
            declaredMethods = methodArr;
            length = i4;
            i5 = i3;
        }
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        int length6 = declaredConstructors.length;
        int i14 = 0;
        while (i14 < length6) {
            Constructor constructor = declaredConstructors[i14];
            int i15 = i14 + 1;
            Name special = Name.special("<init>");
            Intrinsics.checkNotNullExpressionValue(special, "special(\"<init>\")");
            Intrinsics.checkNotNullExpressionValue(constructor, "constructor");
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(");
            Class[] parameterTypes2 = constructor.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes2, "constructor.parameterTypes");
            int length7 = parameterTypes2.length;
            int i16 = 0;
            while (i16 < length7) {
                Constructor[] constructorArr = declaredConstructors;
                Class cls3 = parameterTypes2[i16];
                i16++;
                Intrinsics.checkNotNullExpressionValue(cls3, str2);
                sb3.append(ReflectClassUtilKt.getDesc(cls3));
                declaredConstructors = constructorArr;
            }
            Constructor[] constructorArr2 = declaredConstructors;
            sb3.append(")V");
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "sb.toString()");
            MethodAnnotationVisitor visitMethod2 = memberVisitor2.visitMethod(special, sb4);
            if (visitMethod2 == null) {
                i2 = length6;
                i = i15;
                str4 = str;
                str3 = str2;
            } else {
                Annotation[] declaredAnnotations2 = constructor.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations2, "constructor.declaredAnnotations");
                int length8 = declaredAnnotations2.length;
                int i17 = 0;
                while (i17 < length8) {
                    Annotation annotation3 = declaredAnnotations2[i17];
                    i17++;
                    Intrinsics.checkNotNullExpressionValue(annotation3, "annotation");
                    ReflectClassStructure.processAnnotation(visitMethod2, annotation3);
                }
                Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations2, "parameterAnnotations");
                if (!(parameterAnnotations2.length == 0)) {
                    int length9 = constructor.getParameterTypes().length - parameterAnnotations2.length;
                    int length10 = parameterAnnotations2.length;
                    int i18 = 0;
                    while (i18 < length10) {
                        Annotation[] annotationArr2 = parameterAnnotations2[i18];
                        int i19 = i18 + 1;
                        Intrinsics.checkNotNullExpressionValue(annotationArr2, str);
                        int i20 = length6;
                        int length11 = annotationArr2.length;
                        int i21 = i15;
                        int i22 = 0;
                        while (i22 < length11) {
                            int i23 = length11;
                            Annotation annotation4 = annotationArr2[i22];
                            int i24 = i22 + 1;
                            Class javaClass2 = TweetUtils.getJavaClass(TweetUtils.getAnnotationClass(annotation4));
                            String str5 = str;
                            int i25 = i18 + length9;
                            int i26 = length9;
                            ClassId classId2 = ReflectClassUtilKt.getClassId(javaClass2);
                            String str6 = str2;
                            Intrinsics.checkNotNullExpressionValue(annotation4, "annotation");
                            AnnotationArgumentVisitor visitParameterAnnotation2 = visitMethod2.visitParameterAnnotation(i25, classId2, new ReflectAnnotationSource(annotation4));
                            if (visitParameterAnnotation2 != null) {
                                ReflectClassStructure.processAnnotationArguments(visitParameterAnnotation2, annotation4, javaClass2);
                            }
                            length11 = i23;
                            str = str5;
                            i22 = i24;
                            length9 = i26;
                            str2 = str6;
                        }
                        i18 = i19;
                        length6 = i20;
                        i15 = i21;
                    }
                }
                i2 = length6;
                i = i15;
                str4 = str;
                str3 = str2;
                visitMethod2.visitEnd();
            }
            declaredConstructors = constructorArr2;
            length6 = i2;
            i14 = i;
            str = str4;
            str2 = str3;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        int length12 = declaredFields.length;
        int i27 = 0;
        while (i27 < length12) {
            Field field = declaredFields[i27];
            i27++;
            Name identifier2 = Name.identifier(field.getName());
            Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(field.name)");
            Intrinsics.checkNotNullExpressionValue(field, HSLCriteriaBuilder.FIELD);
            Intrinsics.checkNotNullParameter(field, HSLCriteriaBuilder.FIELD);
            Class<?> type = field.getType();
            Intrinsics.checkNotNullExpressionValue(type, "field.type");
            AnnotationVisitor visitField = memberVisitor2.visitField(identifier2, ReflectClassUtilKt.getDesc(type), null);
            if (visitField != null) {
                Annotation[] declaredAnnotations3 = field.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations3, "field.declaredAnnotations");
                int length13 = declaredAnnotations3.length;
                int i28 = 0;
                while (i28 < length13) {
                    Annotation annotation5 = declaredAnnotations3[i28];
                    i28++;
                    Intrinsics.checkNotNullExpressionValue(annotation5, "annotation");
                    ReflectClassStructure.processAnnotation(visitField, annotation5);
                }
                visitField.visitEnd();
            }
        }
    }
}
