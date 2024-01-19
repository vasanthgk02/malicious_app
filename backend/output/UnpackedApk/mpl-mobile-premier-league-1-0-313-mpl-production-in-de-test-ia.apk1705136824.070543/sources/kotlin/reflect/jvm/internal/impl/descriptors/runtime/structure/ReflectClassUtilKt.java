package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.CharsKt__CharKt;

/* compiled from: reflectClassUtil.kt */
public final class ReflectClassUtilKt {
    public static final List<KClass<? extends Object>> PRIMITIVE_CLASSES;
    public static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER;
    public static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE;

    static {
        int i = 0;
        List<KClass<? extends Object>> listOf = TweetUtils.listOf((T[]) new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        PRIMITIVE_CLASSES = listOf;
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(listOf, 10));
        for (KClass kClass : listOf) {
            arrayList.add(new Pair(TweetUtils.getJavaObjectType(kClass), TweetUtils.getJavaPrimitiveType(kClass)));
        }
        WRAPPER_TO_PRIMITIVE = ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) arrayList);
        List<KClass<? extends Object>> list = PRIMITIVE_CLASSES;
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
        for (KClass kClass2 : list) {
            arrayList2.add(new Pair(TweetUtils.getJavaPrimitiveType(kClass2), TweetUtils.getJavaObjectType(kClass2)));
        }
        PRIMITIVE_TO_WRAPPER = ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) arrayList2);
        List listOf2 = TweetUtils.listOf((T[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList3 = new ArrayList(TweetUtils.collectionSizeOrDefault(listOf2, 10));
        for (Object next : listOf2) {
            int i2 = i + 1;
            if (i >= 0) {
                arrayList3.add(new Pair((Class) next, Integer.valueOf(i)));
                i = i2;
            } else {
                TweetUtils.throwIndexOverflow();
                throw null;
            }
        }
        ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) arrayList3);
    }

    public static final Class<?> createArrayType(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final ClassId getClassId(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Can't compute ClassId for primitive type: ", cls));
        } else if (!cls.isArray()) {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "simpleName");
                if (!(simpleName.length() == 0)) {
                    Class<?> declaringClass = cls.getDeclaringClass();
                    ClassId createNestedClassId = declaringClass == null ? null : getClassId(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
                    if (createNestedClassId == null) {
                        createNestedClassId = ClassId.topLevel(new FqName(cls.getName()));
                    }
                    Intrinsics.checkNotNullExpressionValue(createNestedClassId, "declaringClass?.classId?.createNestedClassId(Name.identifier(simpleName)) ?: ClassId.topLevel(FqName(name))");
                    return createNestedClassId;
                }
            }
            FqName fqName = new FqName(cls.getName());
            return new ClassId(fqName.parent(), FqName.topLevel(fqName.shortName()), true);
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Can't compute ClassId for array type: ", cls));
        }
    }

    public static final String getDesc(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (Intrinsics.areEqual(cls, Void.TYPE)) {
            return DefaultSFSDataSerializer.FIELD_VALUE_KEY;
        }
        String name = createArrayType(cls).getName();
        Intrinsics.checkNotNullExpressionValue(name, "createArrayType().name");
        String substring = name.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        return CharsKt__CharKt.replace$default(substring, '.', '/', false, 4);
    }

    public static final List<Type> getParameterizedTypeArguments(Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return EmptyList.INSTANCE;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return TypeUtilsKt.toList(TypeUtilsKt.flatMap(TypeUtilsKt.generateSequence(type, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE), ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "actualTypeArguments");
        return TweetUtils.toList(actualTypeArguments);
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(cls);
    }

    public static final ClassLoader getSafeClassLoader(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Intrinsics.checkNotNullExpressionValue(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(cls);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
