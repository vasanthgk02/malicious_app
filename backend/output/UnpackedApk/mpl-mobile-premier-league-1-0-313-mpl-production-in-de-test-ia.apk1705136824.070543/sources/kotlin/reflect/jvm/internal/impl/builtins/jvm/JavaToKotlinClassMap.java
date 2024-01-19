package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.CharsKt__CharKt;

/* compiled from: JavaToKotlinClassMap.kt */
public final class JavaToKotlinClassMap {
    public static final ClassId FUNCTION_N_CLASS_ID;
    public static final FqName FUNCTION_N_FQ_NAME;
    public static final JavaToKotlinClassMap INSTANCE = new JavaToKotlinClassMap();
    public static final ClassId K_FUNCTION_CLASS_ID;
    public static final String NUMBERED_FUNCTION_PREFIX = (FunctionClassKind.Function.getPackageFqName().toString() + '.' + FunctionClassKind.Function.getClassNamePrefix());
    public static final String NUMBERED_K_FUNCTION_PREFIX = (FunctionClassKind.KFunction.getPackageFqName().toString() + '.' + FunctionClassKind.KFunction.getClassNamePrefix());
    public static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX = (FunctionClassKind.KSuspendFunction.getPackageFqName().toString() + '.' + FunctionClassKind.KSuspendFunction.getClassNamePrefix());
    public static final String NUMBERED_SUSPEND_FUNCTION_PREFIX = (FunctionClassKind.SuspendFunction.getPackageFqName().toString() + '.' + FunctionClassKind.SuspendFunction.getClassNamePrefix());
    public static final HashMap<FqNameUnsafe, ClassId> javaToKotlin = new HashMap<>();
    public static final HashMap<FqNameUnsafe, ClassId> kotlinToJava = new HashMap<>();
    public static final List<PlatformMutabilityMapping> mutabilityMappings;
    public static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly = new HashMap<>();
    public static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable = new HashMap<>();

    /* compiled from: JavaToKotlinClassMap.kt */
    public static final class PlatformMutabilityMapping {
        public final ClassId javaClass;
        public final ClassId kotlinMutable;
        public final ClassId kotlinReadOnly;

        public PlatformMutabilityMapping(ClassId classId, ClassId classId2, ClassId classId3) {
            Intrinsics.checkNotNullParameter(classId, "javaClass");
            Intrinsics.checkNotNullParameter(classId2, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(classId3, "kotlinMutable");
            this.javaClass = classId;
            this.kotlinReadOnly = classId2;
            this.kotlinMutable = classId3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlatformMutabilityMapping)) {
                return false;
            }
            PlatformMutabilityMapping platformMutabilityMapping = (PlatformMutabilityMapping) obj;
            return Intrinsics.areEqual(this.javaClass, platformMutabilityMapping.javaClass) && Intrinsics.areEqual(this.kotlinReadOnly, platformMutabilityMapping.kotlinReadOnly) && Intrinsics.areEqual(this.kotlinMutable, platformMutabilityMapping.kotlinMutable);
        }

        public int hashCode() {
            int hashCode = this.kotlinReadOnly.hashCode();
            return this.kotlinMutable.hashCode() + ((hashCode + (this.javaClass.hashCode() * 31)) * 31);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("PlatformMutabilityMapping(javaClass=");
            outline73.append(this.javaClass);
            outline73.append(", kotlinReadOnly=");
            outline73.append(this.kotlinReadOnly);
            outline73.append(", kotlinMutable=");
            outline73.append(this.kotlinMutable);
            outline73.append(')');
            return outline73.toString();
        }
    }

    static {
        ClassId classId = ClassId.topLevel(new FqName((String) "kotlin.jvm.functions.FunctionN"));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        FUNCTION_N_CLASS_ID = classId;
        FqName asSingleFqName = classId.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        FUNCTION_N_FQ_NAME = asSingleFqName;
        ClassId classId2 = ClassId.topLevel(new FqName((String) "kotlin.reflect.KFunction"));
        Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        K_FUNCTION_CLASS_ID = classId2;
        Intrinsics.checkNotNullExpressionValue(ClassId.topLevel(new FqName((String) "kotlin.reflect.KClass")), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        INSTANCE.classId(Class.class);
        JavaToKotlinClassMap javaToKotlinClassMap = INSTANCE;
        ClassId classId3 = ClassId.topLevel(FqNames.iterable);
        Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(FqNames.iterable)");
        FqName fqName = FqNames.mutableIterable;
        FqName packageFqName = classId3.getPackageFqName();
        FqName packageFqName2 = classId3.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName2, "kotlinReadOnly.packageFqName");
        FqName tail = TweetUtils.tail(fqName, packageFqName2);
        int i = 0;
        ClassId classId4 = new ClassId(packageFqName, tail, false);
        JavaToKotlinClassMap javaToKotlinClassMap2 = INSTANCE;
        ClassId classId5 = ClassId.topLevel(FqNames.iterator);
        Intrinsics.checkNotNullExpressionValue(classId5, "topLevel(FqNames.iterator)");
        FqName fqName2 = FqNames.mutableIterator;
        FqName packageFqName3 = classId5.getPackageFqName();
        FqName packageFqName4 = classId5.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName4, "kotlinReadOnly.packageFqName");
        ClassId classId6 = new ClassId(packageFqName3, TweetUtils.tail(fqName2, packageFqName4), false);
        JavaToKotlinClassMap javaToKotlinClassMap3 = INSTANCE;
        ClassId classId7 = ClassId.topLevel(FqNames.collection);
        Intrinsics.checkNotNullExpressionValue(classId7, "topLevel(FqNames.collection)");
        FqName fqName3 = FqNames.mutableCollection;
        FqName packageFqName5 = classId7.getPackageFqName();
        FqName packageFqName6 = classId7.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName6, "kotlinReadOnly.packageFqName");
        ClassId classId8 = new ClassId(packageFqName5, TweetUtils.tail(fqName3, packageFqName6), false);
        JavaToKotlinClassMap javaToKotlinClassMap4 = INSTANCE;
        ClassId classId9 = ClassId.topLevel(FqNames.list);
        Intrinsics.checkNotNullExpressionValue(classId9, "topLevel(FqNames.list)");
        FqName fqName4 = FqNames.mutableList;
        FqName packageFqName7 = classId9.getPackageFqName();
        FqName packageFqName8 = classId9.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName8, "kotlinReadOnly.packageFqName");
        ClassId classId10 = new ClassId(packageFqName7, TweetUtils.tail(fqName4, packageFqName8), false);
        JavaToKotlinClassMap javaToKotlinClassMap5 = INSTANCE;
        ClassId classId11 = ClassId.topLevel(FqNames.set);
        Intrinsics.checkNotNullExpressionValue(classId11, "topLevel(FqNames.set)");
        FqName fqName5 = FqNames.mutableSet;
        FqName packageFqName9 = classId11.getPackageFqName();
        FqName packageFqName10 = classId11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName10, "kotlinReadOnly.packageFqName");
        ClassId classId12 = new ClassId(packageFqName9, TweetUtils.tail(fqName5, packageFqName10), false);
        JavaToKotlinClassMap javaToKotlinClassMap6 = INSTANCE;
        ClassId classId13 = ClassId.topLevel(FqNames.listIterator);
        Intrinsics.checkNotNullExpressionValue(classId13, "topLevel(FqNames.listIterator)");
        FqName fqName6 = FqNames.mutableListIterator;
        FqName packageFqName11 = classId13.getPackageFqName();
        FqName packageFqName12 = classId13.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName12, "kotlinReadOnly.packageFqName");
        ClassId classId14 = new ClassId(packageFqName11, TweetUtils.tail(fqName6, packageFqName12), false);
        JavaToKotlinClassMap javaToKotlinClassMap7 = INSTANCE;
        ClassId classId15 = ClassId.topLevel(FqNames.map);
        Intrinsics.checkNotNullExpressionValue(classId15, "topLevel(FqNames.map)");
        FqName fqName7 = FqNames.mutableMap;
        FqName packageFqName13 = classId15.getPackageFqName();
        FqName packageFqName14 = classId15.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName14, "kotlinReadOnly.packageFqName");
        ClassId classId16 = new ClassId(packageFqName13, TweetUtils.tail(fqName7, packageFqName14), false);
        JavaToKotlinClassMap javaToKotlinClassMap8 = INSTANCE;
        ClassId createNestedClassId = ClassId.topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName());
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        FqName fqName8 = FqNames.mutableMapEntry;
        FqName packageFqName15 = createNestedClassId.getPackageFqName();
        FqName packageFqName16 = createNestedClassId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName16, "kotlinReadOnly.packageFqName");
        mutabilityMappings = TweetUtils.listOf((T[]) new PlatformMutabilityMapping[]{new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Iterable.class), classId3, classId4), new PlatformMutabilityMapping(javaToKotlinClassMap2.classId(Iterator.class), classId5, classId6), new PlatformMutabilityMapping(javaToKotlinClassMap3.classId(Collection.class), classId7, classId8), new PlatformMutabilityMapping(javaToKotlinClassMap4.classId(List.class), classId9, classId10), new PlatformMutabilityMapping(javaToKotlinClassMap5.classId(Set.class), classId11, classId12), new PlatformMutabilityMapping(javaToKotlinClassMap6.classId(ListIterator.class), classId13, classId14), new PlatformMutabilityMapping(javaToKotlinClassMap7.classId(Map.class), classId15, classId16), new PlatformMutabilityMapping(javaToKotlinClassMap8.classId(Entry.class), createNestedClassId, new ClassId(packageFqName15, TweetUtils.tail(fqName8, packageFqName16), false))});
        INSTANCE.addTopLevel(Object.class, FqNames.any);
        INSTANCE.addTopLevel(String.class, FqNames.string);
        INSTANCE.addTopLevel(CharSequence.class, FqNames.charSequence);
        INSTANCE.addTopLevel(Throwable.class, FqNames.throwable);
        INSTANCE.addTopLevel(Cloneable.class, FqNames.cloneable);
        INSTANCE.addTopLevel(Number.class, FqNames.number);
        INSTANCE.addTopLevel(Comparable.class, FqNames.comparable);
        INSTANCE.addTopLevel(Enum.class, FqNames._enum);
        INSTANCE.addTopLevel(Annotation.class, FqNames.annotation);
        for (PlatformMutabilityMapping next : mutabilityMappings) {
            ClassId classId17 = next.javaClass;
            ClassId classId18 = next.kotlinReadOnly;
            ClassId classId19 = next.kotlinMutable;
            HashMap<FqNameUnsafe, ClassId> hashMap = javaToKotlin;
            FqNameUnsafe unsafe = classId17.asSingleFqName().toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
            hashMap.put(unsafe, classId18);
            FqName asSingleFqName2 = classId18.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName2, "kotlinClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, ClassId> hashMap2 = kotlinToJava;
            FqNameUnsafe unsafe2 = asSingleFqName2.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe2, "kotlinFqNameUnsafe.toUnsafe()");
            hashMap2.put(unsafe2, classId17);
            FqName asSingleFqName3 = classId19.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName3, "mutableClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, ClassId> hashMap3 = kotlinToJava;
            FqNameUnsafe unsafe3 = asSingleFqName3.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe3, "kotlinFqNameUnsafe.toUnsafe()");
            hashMap3.put(unsafe3, classId17);
            FqName asSingleFqName4 = classId18.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName4, "readOnlyClassId.asSingleFqName()");
            FqName asSingleFqName5 = classId19.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName5, "mutableClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, FqName> hashMap4 = mutableToReadOnly;
            FqNameUnsafe unsafe4 = classId19.asSingleFqName().toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe4, "mutableClassId.asSingleFqName().toUnsafe()");
            hashMap4.put(unsafe4, asSingleFqName4);
            HashMap<FqNameUnsafe, FqName> hashMap5 = readOnlyToMutable;
            FqNameUnsafe unsafe5 = asSingleFqName4.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe5, "readOnlyFqName.toUnsafe()");
            hashMap5.put(unsafe5, asSingleFqName5);
        }
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            JvmPrimitiveType jvmPrimitiveType = values[i2];
            i2++;
            ClassId classId20 = ClassId.topLevel(jvmPrimitiveType.getWrapperFqName());
            Intrinsics.checkNotNullExpressionValue(classId20, "topLevel(jvmType.wrapperFqName)");
            StandardNames standardNames = StandardNames.INSTANCE;
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "jvmType.primitiveType");
            Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
            Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.typeName)");
            ClassId classId21 = ClassId.topLevel(child);
            Intrinsics.checkNotNullExpressionValue(classId21, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            HashMap<FqNameUnsafe, ClassId> hashMap6 = javaToKotlin;
            FqNameUnsafe unsafe6 = classId20.asSingleFqName().toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe6, "javaClassId.asSingleFqName().toUnsafe()");
            hashMap6.put(unsafe6, classId21);
            FqName asSingleFqName6 = classId21.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName6, "kotlinClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, ClassId> hashMap7 = kotlinToJava;
            FqNameUnsafe unsafe7 = asSingleFqName6.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe7, "kotlinFqNameUnsafe.toUnsafe()");
            hashMap7.put(unsafe7, classId20);
        }
        CompanionObjectMapping companionObjectMapping = CompanionObjectMapping.INSTANCE;
        for (ClassId next2 : CompanionObjectMapping.classIds) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("kotlin.jvm.internal.");
            outline73.append(next2.getShortClassName().asString());
            outline73.append("CompanionObject");
            ClassId classId22 = ClassId.topLevel(new FqName(outline73.toString()));
            Intrinsics.checkNotNullExpressionValue(classId22, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            ClassId createNestedClassId2 = next2.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId2, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            HashMap<FqNameUnsafe, ClassId> hashMap8 = javaToKotlin;
            FqNameUnsafe unsafe8 = classId22.asSingleFqName().toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe8, "javaClassId.asSingleFqName().toUnsafe()");
            hashMap8.put(unsafe8, createNestedClassId2);
            FqName asSingleFqName7 = createNestedClassId2.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName7, "kotlinClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, ClassId> hashMap9 = kotlinToJava;
            FqNameUnsafe unsafe9 = asSingleFqName7.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe9, "kotlinFqNameUnsafe.toUnsafe()");
            hashMap9.put(unsafe9, classId22);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            ClassId classId23 = ClassId.topLevel(new FqName(Intrinsics.stringPlus("kotlin.jvm.functions.Function", Integer.valueOf(i3))));
            Intrinsics.checkNotNullExpressionValue(classId23, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            StandardNames standardNames2 = StandardNames.INSTANCE;
            ClassId functionClassId = StandardNames.getFunctionClassId(i3);
            HashMap<FqNameUnsafe, ClassId> hashMap10 = javaToKotlin;
            FqNameUnsafe unsafe10 = classId23.asSingleFqName().toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe10, "javaClassId.asSingleFqName().toUnsafe()");
            hashMap10.put(unsafe10, functionClassId);
            FqName asSingleFqName8 = functionClassId.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName8, "kotlinClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, ClassId> hashMap11 = kotlinToJava;
            FqNameUnsafe unsafe11 = asSingleFqName8.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe11, "kotlinFqNameUnsafe.toUnsafe()");
            hashMap11.put(unsafe11, classId23);
            FqName fqName9 = new FqName(Intrinsics.stringPlus(NUMBERED_K_FUNCTION_PREFIX, Integer.valueOf(i3)));
            ClassId classId24 = K_FUNCTION_CLASS_ID;
            HashMap<FqNameUnsafe, ClassId> hashMap12 = kotlinToJava;
            FqNameUnsafe unsafe12 = fqName9.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe12, "kotlinFqNameUnsafe.toUnsafe()");
            hashMap12.put(unsafe12, classId24);
            if (i4 >= 23) {
                break;
            }
            i3 = i4;
        }
        while (true) {
            int i5 = i + 1;
            FunctionClassKind functionClassKind = FunctionClassKind.KSuspendFunction;
            FqName fqName10 = new FqName(Intrinsics.stringPlus(functionClassKind.getPackageFqName().toString() + '.' + functionClassKind.getClassNamePrefix(), Integer.valueOf(i)));
            ClassId classId25 = K_FUNCTION_CLASS_ID;
            HashMap<FqNameUnsafe, ClassId> hashMap13 = kotlinToJava;
            FqNameUnsafe unsafe13 = fqName10.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe13, "kotlinFqNameUnsafe.toUnsafe()");
            hashMap13.put(unsafe13, classId25);
            if (i5 >= 22) {
                FqName safe = FqNames.nothing.toSafe();
                Intrinsics.checkNotNullExpressionValue(safe, "nothing.toSafe()");
                ClassId classId26 = INSTANCE.classId(Void.class);
                HashMap<FqNameUnsafe, ClassId> hashMap14 = kotlinToJava;
                FqNameUnsafe unsafe14 = safe.toUnsafe();
                Intrinsics.checkNotNullExpressionValue(unsafe14, "kotlinFqNameUnsafe.toUnsafe()");
                hashMap14.put(unsafe14, classId26);
                return;
            }
            i = i5;
        }
    }

    public final void add(ClassId classId, ClassId classId2) {
        HashMap<FqNameUnsafe, ClassId> hashMap = javaToKotlin;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
        hashMap.put(unsafe, classId2);
        FqName asSingleFqName = classId2.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "kotlinClassId.asSingleFqName()");
        HashMap<FqNameUnsafe, ClassId> hashMap2 = kotlinToJava;
        FqNameUnsafe unsafe2 = asSingleFqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe2, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap2.put(unsafe2, classId);
    }

    public final void addTopLevel(Class<?> cls, FqNameUnsafe fqNameUnsafe) {
        FqName safe = fqNameUnsafe.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "kotlinFqName.toSafe()");
        addTopLevel(cls, safe);
    }

    public final ClassId classId(Class<?> cls) {
        boolean z = !cls.isPrimitive() && !cls.isArray();
        if (!_Assertions.ENABLED || z) {
            Class<?> declaringClass = cls.getDeclaringClass();
            if (declaringClass == null) {
                ClassId classId = ClassId.topLevel(new FqName(cls.getCanonicalName()));
                Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(clazz.canonicalName))");
                return classId;
            }
            ClassId createNestedClassId = classId(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
            Intrinsics.checkNotNullExpressionValue(createNestedClassId, "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
            return createNestedClassId;
        }
        throw new AssertionError(Intrinsics.stringPlus("Invalid class: ", cls));
    }

    public final boolean isKotlinFunctionWithBigArity(FqNameUnsafe fqNameUnsafe, String str) {
        String asString = fqNameUnsafe.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "kotlinFqName.asString()");
        String substringAfter = CharsKt__CharKt.substringAfter(asString, str, "");
        boolean z = true;
        if (substringAfter.length() > 0) {
            Intrinsics.checkNotNullParameter(substringAfter, "<this>");
            if (!(substringAfter.length() > 0 && CharsKt__CharKt.equals(substringAfter.charAt(0), '0', false))) {
                Integer intOrNull = CharsKt__CharKt.toIntOrNull(substringAfter);
                if (intOrNull == null || intOrNull.intValue() < 23) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public final ClassId mapJavaToKotlin(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return javaToKotlin.get(fqName.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "kotlinFqName");
        if (isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_FUNCTION_PREFIX)) {
            return FUNCTION_N_CLASS_ID;
        }
        if (isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_SUSPEND_FUNCTION_PREFIX)) {
            return FUNCTION_N_CLASS_ID;
        }
        if (isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_K_FUNCTION_PREFIX)) {
            return K_FUNCTION_CLASS_ID;
        }
        if (isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_K_SUSPEND_FUNCTION_PREFIX)) {
            return K_FUNCTION_CLASS_ID;
        }
        return kotlinToJava.get(fqNameUnsafe);
    }

    public final void addTopLevel(Class<?> cls, FqName fqName) {
        ClassId classId = classId(cls);
        ClassId classId2 = ClassId.topLevel(fqName);
        Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(kotlinFqName)");
        add(classId, classId2);
    }
}
