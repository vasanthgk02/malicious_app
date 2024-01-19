package kotlin.reflect;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.Sequence;
import kotlin.text.CharsKt__CharKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypesJVM.kt */
public final class TypesJVMKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TypesJVM.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
        static {
            /*
                kotlin.reflect.KVariance[] r0 = kotlin.reflect.KVariance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.IN     // Catch:{ NoSuchFieldError -> 0x000c }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000c }
            L_0x000c:
                r1 = 2
                kotlin.reflect.KVariance r2 = kotlin.reflect.KVariance.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                kotlin.reflect.KVariance r2 = kotlin.reflect.KVariance.OUT     // Catch:{ NoSuchFieldError -> 0x0017 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.TypesJVMKt.WhenMappings.<clinit>():void");
        }
    }

    public static final String access$typeToString(Type type) {
        String str;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            Sequence generateSequence = TypeUtilsKt.generateSequence(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullParameter(generateSequence, "<this>");
            Iterator it = generateSequence.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = it.next();
                }
                sb.append(((Class) next).getName());
                sb.append(CharsKt__CharKt.repeat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, TypeUtilsKt.count(generateSequence)));
                str = sb.toString();
            } else {
                throw new NoSuchElementException("Sequence is empty.");
            }
        } else {
            str = cls.getName();
        }
        Intrinsics.checkNotNullExpressionValue(str, "{\n        if (type.isArr…   } else type.name\n    }");
        return str;
    }

    /* JADX WARNING: type inference failed for: r4v5, types: [kotlin.reflect.GenericArrayTypeImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.reflect.Type computeJavaType(kotlin.reflect.KType r3, boolean r4) {
        /*
            kotlin.reflect.KClassifier r0 = r3.getClassifier()
            boolean r1 = r0 instanceof kotlin.reflect.KTypeParameter
            if (r1 == 0) goto L_0x0010
            kotlin.reflect.TypeVariableImpl r3 = new kotlin.reflect.TypeVariableImpl
            kotlin.reflect.KTypeParameter r0 = (kotlin.reflect.KTypeParameter) r0
            r3.<init>(r0)
            return r3
        L_0x0010:
            boolean r1 = r0 instanceof kotlin.reflect.KClass
            if (r1 == 0) goto L_0x0097
            kotlin.reflect.KClass r0 = (kotlin.reflect.KClass) r0
            if (r4 == 0) goto L_0x001d
            java.lang.Class r4 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaObjectType(r0)
            goto L_0x0021
        L_0x001d:
            java.lang.Class r4 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaClass(r0)
        L_0x0021:
            java.util.List r0 = r3.getArguments()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002c
            return r4
        L_0x002c:
            boolean r1 = r4.isArray()
            if (r1 == 0) goto L_0x0092
            java.lang.Class r1 = r4.getComponentType()
            boolean r1 = r1.isPrimitive()
            if (r1 == 0) goto L_0x003d
            return r4
        L_0x003d:
            java.lang.Object r0 = kotlin.collections.ArraysKt___ArraysJvmKt.singleOrNull(r0)
            kotlin.reflect.KTypeProjection r0 = (kotlin.reflect.KTypeProjection) r0
            if (r0 == 0) goto L_0x007b
            kotlin.reflect.KVariance r3 = r0.variance
            kotlin.reflect.KType r0 = r0.type
            r1 = -1
            if (r3 != 0) goto L_0x004e
            r3 = -1
            goto L_0x0056
        L_0x004e:
            int[] r2 = kotlin.reflect.TypesJVMKt.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r2[r3]
        L_0x0056:
            if (r3 == r1) goto L_0x007a
            r1 = 1
            if (r3 == r1) goto L_0x007a
            r2 = 2
            if (r3 == r2) goto L_0x0068
            r2 = 3
            if (r3 != r2) goto L_0x0062
            goto L_0x0068
        L_0x0062:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L_0x0068:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r3 = 0
            java.lang.reflect.Type r3 = computeJavaType$default(r0, r3, r1)
            boolean r0 = r3 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0075
            goto L_0x007a
        L_0x0075:
            kotlin.reflect.GenericArrayTypeImpl r4 = new kotlin.reflect.GenericArrayTypeImpl
            r4.<init>(r3)
        L_0x007a:
            return r4
        L_0x007b:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "kotlin.Array must have exactly one type argument: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        L_0x0092:
            java.lang.reflect.Type r3 = createPossiblyInnerType(r4, r0)
            return r3
        L_0x0097:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unsupported type classifier: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.TypesJVMKt.computeJavaType(kotlin.reflect.KType, boolean):java.lang.reflect.Type");
    }

    public static /* synthetic */ Type computeJavaType$default(KType kType, boolean z, int i) {
        if ((i & 1) != 0) {
            z = false;
        }
        return computeJavaType(kType, z);
    }

    public static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (KTypeProjection javaType : list) {
                arrayList.add(getJavaType(javaType));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        } else if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (KTypeProjection javaType2 : list) {
                arrayList2.add(getJavaType(javaType2));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        } else {
            int length = cls.getTypeParameters().length;
            Type createPossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(length, list.size()));
            List<KTypeProjection> subList = list.subList(0, length);
            ArrayList arrayList3 = new ArrayList(TweetUtils.collectionSizeOrDefault(subList, 10));
            for (KTypeProjection javaType3 : subList) {
                arrayList3.add(getJavaType(javaType3));
            }
            return new ParameterizedTypeImpl(cls, createPossiblyInnerType, arrayList3);
        }
    }

    public static final Type getJavaType(KTypeProjection kTypeProjection) {
        Type type;
        KVariance kVariance = kTypeProjection.variance;
        if (kVariance == null) {
            return WildcardTypeImpl.STAR;
        }
        KType kType = kTypeProjection.type;
        Intrinsics.checkNotNull(kType);
        int ordinal = kVariance.ordinal();
        if (ordinal == 0) {
            type = computeJavaType(kType, true);
        } else if (ordinal == 1) {
            type = new WildcardTypeImpl(null, computeJavaType(kType, true));
        } else if (ordinal == 2) {
            type = new WildcardTypeImpl(computeJavaType(kType, true), null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return type;
    }

    public static final Type getJavaType(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        if (kType instanceof KTypeBase) {
            Type javaType = ((KTypeBase) kType).getJavaType();
            if (javaType != null) {
                return javaType;
            }
        }
        return computeJavaType(kType, false);
    }
}
