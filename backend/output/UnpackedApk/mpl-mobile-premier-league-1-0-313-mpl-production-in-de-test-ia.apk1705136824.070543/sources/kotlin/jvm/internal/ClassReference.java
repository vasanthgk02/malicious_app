package kotlin.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010F\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010N\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0014\u001a\u0004\b\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R(\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u0004\u0018\u0001018VX\u0004¢\u0006\u0006\u001a\u0004\b8\u00103R \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR \u0010=\u001a\b\u0012\u0004\u0012\u00020>0\b8VX\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u000bR\u001c\u0010A\u001a\u0004\u0018\u00010B8VX\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0014\u001a\u0004\bD\u0010E¨\u0006P"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ClassReference.kt */
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion(null);
    public static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    public static final HashMap<String, String> classFqNames;
    public static final HashMap<String, String> primitiveFqNames;
    public static final HashMap<String, String> primitiveWrapperFqNames;
    public static final Map<String, String> simpleNames;
    public final Class<?> jClass;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ClassReference.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        int i = 0;
        List listOf = TweetUtils.listOf((T[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(listOf, 10));
        for (Object next : listOf) {
            int i2 = i + 1;
            if (i >= 0) {
                arrayList.add(new Pair((Class) next, Integer.valueOf(i)));
                i = i2;
            } else {
                TweetUtils.throwIndexOverflow();
                throw null;
            }
        }
        FUNCTION_CLASSES = ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) arrayList);
        HashMap<String, String> outline88 = GeneratedOutlineSupport.outline88("boolean", "kotlin.Boolean", "char", "kotlin.Char");
        outline88.put("byte", "kotlin.Byte");
        outline88.put("short", "kotlin.Short");
        outline88.put("int", "kotlin.Int");
        outline88.put("float", "kotlin.Float");
        outline88.put("long", "kotlin.Long");
        outline88.put("double", "kotlin.Double");
        primitiveFqNames = outline88;
        HashMap<String, String> outline882 = GeneratedOutlineSupport.outline88("java.lang.Boolean", "kotlin.Boolean", "java.lang.Character", "kotlin.Char");
        outline882.put("java.lang.Byte", "kotlin.Byte");
        outline882.put("java.lang.Short", "kotlin.Short");
        outline882.put("java.lang.Integer", "kotlin.Int");
        outline882.put("java.lang.Float", "kotlin.Float");
        outline882.put("java.lang.Long", "kotlin.Long");
        outline882.put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = outline882;
        HashMap<String, String> outline883 = GeneratedOutlineSupport.outline88("java.lang.Object", "kotlin.Any", "java.lang.String", "kotlin.String");
        outline883.put("java.lang.CharSequence", "kotlin.CharSequence");
        outline883.put("java.lang.Throwable", "kotlin.Throwable");
        outline883.put("java.lang.Cloneable", "kotlin.Cloneable");
        outline883.put("java.lang.Number", "kotlin.Number");
        outline883.put("java.lang.Comparable", "kotlin.Comparable");
        outline883.put("java.lang.Enum", "kotlin.Enum");
        outline883.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        outline883.put("java.lang.Iterable", "kotlin.collections.Iterable");
        outline883.put("java.util.Iterator", "kotlin.collections.Iterator");
        outline883.put("java.util.Collection", "kotlin.collections.Collection");
        outline883.put("java.util.List", "kotlin.collections.List");
        outline883.put("java.util.Set", "kotlin.collections.Set");
        outline883.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        outline883.put("java.util.Map", "kotlin.collections.Map");
        outline883.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        outline883.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        outline883.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        outline883.putAll(primitiveFqNames);
        outline883.putAll(primitiveWrapperFqNames);
        Collection<String> values = primitiveFqNames.values();
        Intrinsics.checkNotNullExpressionValue(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics.checkNotNullExpressionValue(str, "kotlinName");
            sb.append(CharsKt__CharKt.substringAfterLast$default(str, '.', null, 2));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            outline883.put(sb2, str + ".Companion");
        }
        for (Entry next2 : FUNCTION_CLASSES.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            outline883.put(name, "kotlin.Function" + intValue);
        }
        classFqNames = outline883;
        LinkedHashMap linkedHashMap = new LinkedHashMap(TweetUtils.mapCapacity(outline883.size()));
        for (Entry entry : outline883.entrySet()) {
            linkedHashMap.put(entry.getKey(), CharsKt__CharKt.substringAfterLast$default((String) entry.getValue(), '.', null, 2));
        }
        simpleNames = linkedHashMap;
    }

    public ClassReference(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        this.jClass = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ClassReference) && Intrinsics.areEqual(TweetUtils.getJavaObjectType(this), TweetUtils.getJavaObjectType((KClass) obj));
    }

    public List<Annotation> getAnnotations() {
        throw new KotlinReflectionNotSupportedError();
    }

    public Class<?> getJClass() {
        return this.jClass;
    }

    public Object getObjectInstance() {
        throw new KotlinReflectionNotSupportedError();
    }

    public String getQualifiedName() {
        Class<?> cls = this.jClass;
        Intrinsics.checkNotNullParameter(cls, "jClass");
        String str = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive()) {
                String str2 = classFqNames.get(componentType.getName());
                if (str2 != null) {
                    str = GeneratedOutlineSupport.outline50(str2, "Array");
                }
            }
            if (str == null) {
                return "kotlin.Array";
            }
            return str;
        }
        String str3 = classFqNames.get(cls.getName());
        return str3 == null ? cls.getCanonicalName() : str3;
    }

    public String getSimpleName() {
        Class<?> cls = this.jClass;
        Intrinsics.checkNotNullParameter(cls, "jClass");
        String str = null;
        if (!cls.isAnonymousClass()) {
            if (cls.isLocalClass()) {
                String simpleName = cls.getSimpleName();
                Method enclosingMethod = cls.getEnclosingMethod();
                if (enclosingMethod != null) {
                    Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                    return CharsKt__CharKt.substringAfter$default(simpleName, enclosingMethod.getName() + '$', (String) null, 2);
                }
                Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                if (enclosingConstructor != null) {
                    Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                    return CharsKt__CharKt.substringAfter$default(simpleName, enclosingConstructor.getName() + '$', (String) null, 2);
                }
                Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                return CharsKt__CharKt.substringAfter$default(simpleName, '$', (String) null, 2);
            } else if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive()) {
                    String str2 = simpleNames.get(componentType.getName());
                    if (str2 != null) {
                        str = GeneratedOutlineSupport.outline50(str2, "Array");
                    }
                }
                if (str == null) {
                    return "Array";
                }
            } else {
                String str3 = simpleNames.get(cls.getName());
                return str3 == null ? cls.getSimpleName() : str3;
            }
        }
        return str;
    }

    public int hashCode() {
        return TweetUtils.getJavaObjectType(this).hashCode();
    }

    public boolean isAbstract() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean isInner() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean isSealed() {
        throw new KotlinReflectionNotSupportedError();
    }

    public String toString() {
        return this.jClass.toString() + " (Kotlin reflection is not available)";
    }
}
