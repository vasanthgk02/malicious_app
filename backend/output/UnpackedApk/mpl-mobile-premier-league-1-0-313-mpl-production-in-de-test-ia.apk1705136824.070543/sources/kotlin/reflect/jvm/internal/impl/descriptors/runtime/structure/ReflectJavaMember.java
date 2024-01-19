package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;

/* compiled from: ReflectJavaMember.kt */
public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaMember) && Intrinsics.areEqual(getMember(), ((ReflectJavaMember) obj).getMember());
    }

    public JavaAnnotation findAnnotation(FqName fqName) {
        return TweetUtils.findAnnotation((ReflectJavaAnnotationOwner) this, fqName);
    }

    public Collection getAnnotations() {
        return TweetUtils.getAnnotations((ReflectJavaAnnotationOwner) this);
    }

    public JavaClass getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }

    public AnnotatedElement getElement() {
        return (AnnotatedElement) getMember();
    }

    public abstract Member getMember();

    public int getModifiers() {
        return getMember().getModifiers();
    }

    public Name getName() {
        String name = getMember().getName();
        Name identifier = name == null ? null : Name.identifier(name);
        if (identifier != null) {
            return identifier;
        }
        Name name2 = SpecialNames.NO_NAME_PROVIDED;
        Intrinsics.checkNotNullExpressionValue(name2, "NO_NAME_PROVIDED");
        return name2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010f A[LOOP:1: B:32:0x00a4->B:59:0x010f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0155 A[EDGE_INSN: B:67:0x0155->B:62:0x0155 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> getValueParameters(java.lang.reflect.Type[] r13, java.lang.annotation.Annotation[][] r14, boolean r15) {
        /*
            r12 = this;
            java.lang.String r0 = "parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "parameterAnnotations"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r13.length
            r0.<init>(r1)
            java.lang.reflect.Member r1 = r12.getMember()
            java.lang.String r2 = "member"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader$Cache r3 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.cache
            r4 = 0
            r5 = 0
            if (r3 != 0) goto L_0x004f
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.Class r2 = r1.getClass()
            java.lang.String r3 = "getParameters"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0047 }
            java.lang.reflect.Method r3 = r2.getMethod(r3, r6)     // Catch:{ NoSuchMethodException -> 0x0047 }
            java.lang.ClassLoader r2 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getSafeClassLoader(r2)
            java.lang.String r6 = "java.lang.reflect.Parameter"
            java.lang.Class r2 = r2.loadClass(r6)
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader$Cache r6 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader$Cache
            java.lang.Class[] r7 = new java.lang.Class[r4]
            java.lang.String r8 = "getName"
            java.lang.reflect.Method r2 = r2.getMethod(r8, r7)
            r6.<init>(r3, r2)
            r3 = r6
            goto L_0x004d
        L_0x0047:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader$Cache r2 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader$Cache
            r2.<init>(r5, r5)
            r3 = r2
        L_0x004d:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.cache = r3
        L_0x004f:
            java.lang.reflect.Method r2 = r3.getParameters
            if (r2 != 0) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            java.lang.reflect.Method r3 = r3.getName
            if (r3 != 0) goto L_0x005a
        L_0x0058:
            r2 = r5
            goto L_0x0088
        L_0x005a:
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.Object r1 = r2.invoke(r1, r6)
            if (r1 == 0) goto L_0x0156
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = r1.length
            r2.<init>(r6)
            int r6 = r1.length
            r7 = 0
        L_0x006c:
            if (r7 >= r6) goto L_0x0088
            r8 = r1[r7]
            java.lang.Object[] r9 = new java.lang.Object[r4]
            java.lang.Object r8 = r3.invoke(r8, r9)
            if (r8 == 0) goto L_0x0080
            java.lang.String r8 = (java.lang.String) r8
            r2.add(r8)
            int r7 = r7 + 1
            goto L_0x006c
        L_0x0080:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            java.lang.String r14 = "null cannot be cast to non-null type kotlin.String"
            r13.<init>(r14)
            throw r13
        L_0x0088:
            if (r2 != 0) goto L_0x008c
            r1 = r5
            goto L_0x0094
        L_0x008c:
            int r1 = r2.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0094:
            if (r1 != 0) goto L_0x0098
            r1 = 0
            goto L_0x009e
        L_0x0098:
            int r1 = r1.intValue()
            int r3 = r13.length
            int r1 = r1 - r3
        L_0x009e:
            int r3 = r13.length
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x0155
            r6 = 0
        L_0x00a4:
            int r7 = r6 + 1
            r8 = r13[r6]
            java.lang.String r9 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r9)
            boolean r9 = r8 instanceof java.lang.Class
            if (r9 == 0) goto L_0x00c1
            r10 = r8
            java.lang.Class r10 = (java.lang.Class) r10
            boolean r11 = r10.isPrimitive()
            if (r11 == 0) goto L_0x00c1
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPrimitiveType r8 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPrimitiveType
            r8.<init>(r10)
            goto L_0x00e9
        L_0x00c1:
            boolean r10 = r8 instanceof java.lang.reflect.GenericArrayType
            if (r10 != 0) goto L_0x00e3
            if (r9 == 0) goto L_0x00d1
            r9 = r8
            java.lang.Class r9 = (java.lang.Class) r9
            boolean r9 = r9.isArray()
            if (r9 == 0) goto L_0x00d1
            goto L_0x00e3
        L_0x00d1:
            boolean r9 = r8 instanceof java.lang.reflect.WildcardType
            if (r9 == 0) goto L_0x00dd
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaWildcardType r9 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaWildcardType
            java.lang.reflect.WildcardType r8 = (java.lang.reflect.WildcardType) r8
            r9.<init>(r8)
            goto L_0x00e8
        L_0x00dd:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassifierType r9 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassifierType
            r9.<init>(r8)
            goto L_0x00e8
        L_0x00e3:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaArrayType r9 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaArrayType
            r9.<init>(r8)
        L_0x00e8:
            r8 = r9
        L_0x00e9:
            if (r2 != 0) goto L_0x00ed
            r9 = r5
            goto L_0x00f7
        L_0x00ed:
            int r9 = r6 + r1
            java.lang.Object r9 = kotlin.collections.ArraysKt___ArraysJvmKt.getOrNull(r2, r9)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0111
        L_0x00f7:
            if (r15 == 0) goto L_0x0101
            int r10 = com.twitter.sdk.android.tweetui.TweetUtils.getLastIndex((T[]) r13)
            if (r6 != r10) goto L_0x0101
            r10 = 1
            goto L_0x0102
        L_0x0101:
            r10 = 0
        L_0x0102:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaValueParameter r11 = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaValueParameter
            r6 = r14[r6]
            r11.<init>(r8, r6, r9, r10)
            r0.add(r11)
            if (r7 <= r3) goto L_0x010f
            goto L_0x0155
        L_0x010f:
            r6 = r7
            goto L_0x00a4
        L_0x0111:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "No parameter with index "
            r13.append(r14)
            r13.append(r6)
            r14 = 43
            r13.append(r14)
            r13.append(r1)
            java.lang.String r14 = " (name="
            r13.append(r14)
            kotlin.reflect.jvm.internal.impl.name.Name r14 = r12.getName()
            r13.append(r14)
            java.lang.String r14 = " type="
            r13.append(r14)
            r13.append(r8)
            java.lang.String r14 = ") in "
            r13.append(r14)
            r13.append(r2)
            java.lang.String r14 = "@ReflectJavaMember"
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r14.<init>(r13)
            throw r14
        L_0x0155:
            return r0
        L_0x0156:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            java.lang.String r14 = "null cannot be cast to non-null type kotlin.Array<*>"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember.getValueParameters(java.lang.reflect.Type[], java.lang.annotation.Annotation[][], boolean):java.util.List");
    }

    public Visibility getVisibility() {
        return TweetUtils.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    public boolean isAbstract() {
        Intrinsics.checkNotNullParameter(this, "this");
        return Modifier.isAbstract(getModifiers());
    }

    public boolean isDeprecatedInJavaDoc() {
        TweetUtils.isDeprecatedInJavaDoc(this);
        return false;
    }

    public boolean isFinal() {
        Intrinsics.checkNotNullParameter(this, "this");
        return Modifier.isFinal(getModifiers());
    }

    public boolean isStatic() {
        Intrinsics.checkNotNullParameter(this, "this");
        return Modifier.isStatic(getModifiers());
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }
}
