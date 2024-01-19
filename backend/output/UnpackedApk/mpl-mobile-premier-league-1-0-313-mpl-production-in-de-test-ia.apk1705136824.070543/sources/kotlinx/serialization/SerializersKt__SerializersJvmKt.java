package kotlinx.serialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a)\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\b\u000b\u001a\u0015\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u0004H\u0002¢\u0006\u0002\b\u000e\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a+\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\b\u0010\u001a\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a-\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\b\u0013¨\u0006\u0014"}, d2 = {"serializer", "Lkotlinx/serialization/KSerializer;", "", "type", "Ljava/lang/reflect/Type;", "serializerOrNull", "genericArraySerializer", "Lkotlinx/serialization/modules/SerializersModule;", "Ljava/lang/reflect/GenericArrayType;", "failOnMissingTypeArgSerializer", "", "genericArraySerializer$SerializersKt__SerializersJvmKt", "kclass", "Lkotlin/reflect/KClass;", "kclass$SerializersKt__SerializersJvmKt", "serializerByJavaTypeImpl", "serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt", "typeSerializer", "Ljava/lang/Class;", "typeSerializer$SerializersKt__SerializersJvmKt", "kotlinx-serialization-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
/* compiled from: SerializersJvm.kt */
public final /* synthetic */ class SerializersKt__SerializersJvmKt {
    public static final KClass<?> kclass$SerializersKt__SerializersJvmKt(Type type) {
        if (type instanceof KClass) {
            return (KClass) type;
        }
        if (type instanceof Class) {
            return TweetUtils.getKotlinClass((Class) type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            Intrinsics.checkNotNullExpressionValue(rawType, "it.rawType");
            return kclass$SerializersKt__SerializersJvmKt(rawType);
        } else if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "it.upperBounds");
            Object first = TweetUtils.first(upperBounds);
            Intrinsics.checkNotNullExpressionValue(first, "it.upperBounds.first()");
            return kclass$SerializersKt__SerializersJvmKt((Type) first);
        } else if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "it.genericComponentType");
            return kclass$SerializersKt__SerializersJvmKt(genericComponentType);
        } else {
            throw new IllegalArgumentException("typeToken should be an instance of Class<?>, GenericArray, ParametrizedType or WildcardType, but actual type is " + type + ' ' + Reflection.getOrCreateKotlinClass(type.getClass()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009e, code lost:
        if (r8 == null) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r8 == null) goto L_0x023c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlinx.serialization.KSerializer<java.lang.Object> serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(kotlinx.serialization.modules.SerializersModule r8, java.lang.reflect.Type r9, boolean r10) {
        /*
            boolean r0 = r9 instanceof java.lang.reflect.GenericArrayType
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.Class<*>"
            r2 = 0
            if (r0 == 0) goto L_0x0070
            java.lang.reflect.GenericArrayType r9 = (java.lang.reflect.GenericArrayType) r9
            java.lang.reflect.Type r9 = r9.getGenericComponentType()
            boolean r0 = r9 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x0022
            java.lang.reflect.WildcardType r9 = (java.lang.reflect.WildcardType) r9
            java.lang.reflect.Type[] r9 = r9.getUpperBounds()
            java.lang.String r0 = "it.upperBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            java.lang.Object r9 = com.twitter.sdk.android.tweetui.TweetUtils.first(r9)
            java.lang.reflect.Type r9 = (java.lang.reflect.Type) r9
        L_0x0022:
            java.lang.String r0 = "eType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            if (r10 == 0) goto L_0x002e
            kotlinx.serialization.KSerializer r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.serializer(r8, r9)
            goto L_0x0036
        L_0x002e:
            kotlinx.serialization.KSerializer r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.serializerOrNull(r8, r9)
            if (r8 != 0) goto L_0x0036
            goto L_0x023c
        L_0x0036:
            boolean r10 = r9 instanceof java.lang.reflect.ParameterizedType
            if (r10 == 0) goto L_0x004f
            java.lang.reflect.ParameterizedType r9 = (java.lang.reflect.ParameterizedType) r9
            java.lang.reflect.Type r9 = r9.getRawType()
            if (r9 == 0) goto L_0x0049
            java.lang.Class r9 = (java.lang.Class) r9
            kotlin.reflect.KClass r9 = com.twitter.sdk.android.tweetui.TweetUtils.getKotlinClass(r9)
            goto L_0x0055
        L_0x0049:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r1)
            throw r8
        L_0x004f:
            boolean r10 = r9 instanceof kotlin.reflect.KClass
            if (r10 == 0) goto L_0x005b
            kotlin.reflect.KClass r9 = (kotlin.reflect.KClass) r9
        L_0x0055:
            kotlinx.serialization.KSerializer r2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.ArraySerializer(r9, r8)
            goto L_0x023c
        L_0x005b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.Class r9 = r9.getClass()
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            java.lang.String r10 = "unsupported type in GenericArray: "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r9)
            r8.<init>(r9)
            throw r8
        L_0x0070:
            boolean r0 = r9 instanceof java.lang.Class
            if (r0 == 0) goto L_0x00ab
            java.lang.Class r9 = (java.lang.Class) r9
            boolean r0 = r9.isArray()
            if (r0 != 0) goto L_0x0089
            kotlin.reflect.KClass r9 = com.twitter.sdk.android.tweetui.TweetUtils.getKotlinClass(r9)
            kotlin.collections.EmptyList r10 = kotlin.collections.EmptyList.INSTANCE
            kotlinx.serialization.KSerializer r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.reflectiveOrContextual(r8, r9, r10)
        L_0x0086:
            r2 = r8
            goto L_0x023c
        L_0x0089:
            java.lang.Class r9 = r9.getComponentType()
            java.lang.String r0 = "type.componentType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            if (r10 == 0) goto L_0x009a
            kotlinx.serialization.KSerializer r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.serializer(r8, r9)
            goto L_0x00a2
        L_0x009a:
            kotlinx.serialization.KSerializer r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.serializerOrNull(r8, r9)
            if (r8 != 0) goto L_0x00a2
            goto L_0x023c
        L_0x00a2:
            kotlin.reflect.KClass r9 = com.twitter.sdk.android.tweetui.TweetUtils.getKotlinClass(r9)
            kotlinx.serialization.KSerializer r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.ArraySerializer(r9, r8)
            goto L_0x0086
        L_0x00ab:
            boolean r0 = r9 instanceof java.lang.reflect.ParameterizedType
            r3 = 1
            if (r0 == 0) goto L_0x021c
            java.lang.reflect.ParameterizedType r9 = (java.lang.reflect.ParameterizedType) r9
            java.lang.reflect.Type r0 = r9.getRawType()
            if (r0 == 0) goto L_0x0216
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.reflect.Type[] r9 = r9.getActualTypeArguments()
            java.lang.String r1 = "it"
            java.lang.String r4 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r4)
            r4 = 0
            if (r10 == 0) goto L_0x00e1
            java.util.ArrayList r10 = new java.util.ArrayList
            int r5 = r9.length
            r10.<init>(r5)
            int r5 = r9.length
            r6 = 0
        L_0x00d0:
            if (r6 >= r5) goto L_0x00fd
            r7 = r9[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            kotlinx.serialization.KSerializer r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.serializer(r8, r7)
            r10.add(r7)
            int r6 = r6 + 1
            goto L_0x00d0
        L_0x00e1:
            java.util.ArrayList r10 = new java.util.ArrayList
            int r5 = r9.length
            r10.<init>(r5)
            int r5 = r9.length
            r6 = 0
        L_0x00e9:
            if (r6 >= r5) goto L_0x00fd
            r7 = r9[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            kotlinx.serialization.KSerializer r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.serializerOrNull(r8, r7)
            if (r7 != 0) goto L_0x00f7
            return r2
        L_0x00f7:
            r10.add(r7)
            int r6 = r6 + 1
            goto L_0x00e9
        L_0x00fd:
            java.lang.Class<java.util.Set> r9 = java.util.Set.class
            boolean r9 = r9.isAssignableFrom(r0)
            if (r9 == 0) goto L_0x0117
            java.lang.Object r8 = r10.get(r4)
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            java.lang.String r9 = "elementSerializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r9)
            kotlinx.serialization.internal.LinkedHashSetSerializer r2 = new kotlinx.serialization.internal.LinkedHashSetSerializer
            r2.<init>(r8)
            goto L_0x023c
        L_0x0117:
            java.lang.Class<java.util.List> r9 = java.util.List.class
            boolean r9 = r9.isAssignableFrom(r0)
            if (r9 != 0) goto L_0x020b
            java.lang.Class<java.util.Collection> r9 = java.util.Collection.class
            boolean r9 = r9.isAssignableFrom(r0)
            if (r9 == 0) goto L_0x0129
            goto L_0x020b
        L_0x0129:
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            boolean r9 = r9.isAssignableFrom(r0)
            if (r9 == 0) goto L_0x0143
            java.lang.Object r8 = r10.get(r4)
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            java.lang.Object r9 = r10.get(r3)
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            kotlinx.serialization.KSerializer r2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.MapSerializer(r8, r9)
            goto L_0x023c
        L_0x0143:
            java.lang.Class<java.util.Map$Entry> r9 = java.util.Map.Entry.class
            boolean r9 = r9.isAssignableFrom(r0)
            java.lang.String r1 = "valueSerializer"
            java.lang.String r5 = "keySerializer"
            if (r9 == 0) goto L_0x0169
            java.lang.Object r8 = r10.get(r4)
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            java.lang.Object r9 = r10.get(r3)
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            kotlinx.serialization.internal.MapEntrySerializer r2 = new kotlinx.serialization.internal.MapEntrySerializer
            r2.<init>(r8, r9)
            goto L_0x023c
        L_0x0169:
            java.lang.Class<kotlin.Pair> r9 = kotlin.Pair.class
            boolean r9 = r9.isAssignableFrom(r0)
            if (r9 == 0) goto L_0x018a
            java.lang.Object r8 = r10.get(r4)
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            java.lang.Object r9 = r10.get(r3)
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            kotlinx.serialization.internal.PairSerializer r2 = new kotlinx.serialization.internal.PairSerializer
            r2.<init>(r8, r9)
            goto L_0x023c
        L_0x018a:
            java.lang.Class<kotlin.Triple> r9 = kotlin.Triple.class
            boolean r9 = r9.isAssignableFrom(r0)
            if (r9 == 0) goto L_0x01bb
            java.lang.Object r8 = r10.get(r4)
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            java.lang.Object r9 = r10.get(r3)
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            r0 = 2
            java.lang.Object r10 = r10.get(r0)
            kotlinx.serialization.KSerializer r10 = (kotlinx.serialization.KSerializer) r10
            java.lang.String r0 = "aSerializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "bSerializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "cSerializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlinx.serialization.internal.TripleSerializer r2 = new kotlinx.serialization.internal.TripleSerializer
            r2.<init>(r8, r9, r10)
            goto L_0x023c
        L_0x01bb:
            java.util.ArrayList r9 = new java.util.ArrayList
            r1 = 10
            int r1 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r10, r1)
            r9.<init>(r1)
            java.util.Iterator r10 = r10.iterator()
        L_0x01ca:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x01da
            java.lang.Object r1 = r10.next()
            kotlinx.serialization.KSerializer r1 = (kotlinx.serialization.KSerializer) r1
            r9.add(r1)
            goto L_0x01ca
        L_0x01da:
            kotlin.reflect.KClass r10 = com.twitter.sdk.android.tweetui.TweetUtils.getKotlinClass(r0)
            kotlinx.serialization.KSerializer[] r1 = new kotlinx.serialization.KSerializer[r4]
            java.lang.Object[] r1 = r9.toArray(r1)
            if (r1 == 0) goto L_0x0203
            kotlinx.serialization.KSerializer[] r1 = (kotlinx.serialization.KSerializer[]) r1
            int r3 = r1.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            kotlinx.serialization.KSerializer[] r1 = (kotlinx.serialization.KSerializer[]) r1
            kotlinx.serialization.KSerializer r10 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.constructSerializerForGivenTypeArgs(r10, r1)
            boolean r1 = r10 instanceof kotlinx.serialization.KSerializer
            if (r1 == 0) goto L_0x01f8
            r2 = r10
        L_0x01f8:
            if (r2 != 0) goto L_0x023c
            kotlin.reflect.KClass r10 = com.twitter.sdk.android.tweetui.TweetUtils.getKotlinClass(r0)
            kotlinx.serialization.KSerializer r2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.reflectiveOrContextual(r8, r10, r9)
            goto L_0x023c
        L_0x0203:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Array<T>"
            r8.<init>(r9)
            throw r8
        L_0x020b:
            java.lang.Object r8 = r10.get(r4)
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            kotlinx.serialization.KSerializer r2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.ListSerializer(r8)
            goto L_0x023c
        L_0x0216:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r1)
            throw r8
        L_0x021c:
            boolean r10 = r9 instanceof java.lang.reflect.WildcardType
            if (r10 == 0) goto L_0x023d
            java.lang.reflect.WildcardType r9 = (java.lang.reflect.WildcardType) r9
            java.lang.reflect.Type[] r9 = r9.getUpperBounds()
            java.lang.String r10 = "type.upperBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.Object r9 = com.twitter.sdk.android.tweetui.TweetUtils.first(r9)
            java.lang.String r10 = "type.upperBounds.first()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.reflect.Type r9 = (java.lang.reflect.Type) r9
            kotlinx.serialization.KSerializer r2 = serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(r8, r9, r3)
        L_0x023c:
            return r2
        L_0x023d:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "typeToken should be an instance of Class<?>, GenericArray, ParametrizedType or WildcardType, but actual type is "
            r10.append(r0)
            r10.append(r9)
            r0 = 32
            r10.append(r0)
            java.lang.Class r9 = r9.getClass()
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(kotlinx.serialization.modules.SerializersModule, java.lang.reflect.Type, boolean):kotlinx.serialization.KSerializer");
    }

    public static final KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt(SerializersModule serializersModule, KType kType, boolean z) {
        KSerializer kSerializer;
        ArrayList arrayList;
        KSerializer kSerializer2;
        KSerializer reflectiveOrContextual;
        KClass<Object> kclass = Platform_commonKt.kclass(kType);
        boolean isMarkedNullable = kType.isMarkedNullable();
        List<KTypeProjection> arguments = kType.getArguments();
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(arguments, 10));
        for (KTypeProjection kTypeProjection : arguments) {
            KType kType2 = kTypeProjection.type;
            if (kType2 != null) {
                arrayList2.add(kType2);
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Star projections in type arguments are not allowed, but had ", kType).toString());
            }
        }
        if (arrayList2.isEmpty()) {
            kSerializer = TypeUtilsKt.serializerOrNull(kclass);
            if (kSerializer == null) {
                kSerializer = SerializersModule.getContextual$default(serializersModule, kclass, null, 2, null);
            }
        } else {
            if (!z) {
                arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(arrayList2, 10));
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    KType kType3 = (KType) it.next();
                    Intrinsics.checkNotNullParameter(serializersModule, "<this>");
                    Intrinsics.checkNotNullParameter(kType3, "type");
                    KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt = serializerByKTypeImpl$SerializersKt__SerializersKt(serializersModule, kType3, false);
                    if (serializerByKTypeImpl$SerializersKt__SerializersKt == null) {
                        kSerializer = null;
                        break;
                    }
                    arrayList.add(serializerByKTypeImpl$SerializersKt__SerializersKt);
                }
            } else {
                arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(TypeUtilsKt.serializer(serializersModule, (KType) it2.next()));
                }
            }
            if (Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(Collection.class)) ? true : Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(List.class)) ? true : Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(List.class)) ? true : Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(ArrayList.class))) {
                reflectiveOrContextual = new ArrayListSerializer((KSerializer) arrayList.get(0));
            } else if (Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(HashSet.class))) {
                reflectiveOrContextual = new HashSetSerializer((KSerializer) arrayList.get(0));
            } else {
                if (Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(Set.class)) ? true : Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(Set.class)) ? true : Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(LinkedHashSet.class))) {
                    reflectiveOrContextual = new LinkedHashSetSerializer((KSerializer) arrayList.get(0));
                } else if (Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(HashMap.class))) {
                    reflectiveOrContextual = new HashMapSerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1));
                } else {
                    if (Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(Map.class)) ? true : Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(Map.class)) ? true : Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(LinkedHashMap.class))) {
                        reflectiveOrContextual = new LinkedHashMapSerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1));
                    } else {
                        if (Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(Entry.class))) {
                            KSerializer kSerializer3 = (KSerializer) arrayList.get(0);
                            KSerializer kSerializer4 = (KSerializer) arrayList.get(1);
                            Intrinsics.checkNotNullParameter(kSerializer3, "keySerializer");
                            Intrinsics.checkNotNullParameter(kSerializer4, "valueSerializer");
                            kSerializer2 = new MapEntrySerializer(kSerializer3, kSerializer4);
                        } else if (Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(Pair.class))) {
                            KSerializer kSerializer5 = (KSerializer) arrayList.get(0);
                            KSerializer kSerializer6 = (KSerializer) arrayList.get(1);
                            Intrinsics.checkNotNullParameter(kSerializer5, "keySerializer");
                            Intrinsics.checkNotNullParameter(kSerializer6, "valueSerializer");
                            kSerializer2 = new PairSerializer(kSerializer5, kSerializer6);
                        } else if (Intrinsics.areEqual(kclass, Reflection.getOrCreateKotlinClass(Triple.class))) {
                            KSerializer kSerializer7 = (KSerializer) arrayList.get(0);
                            KSerializer kSerializer8 = (KSerializer) arrayList.get(1);
                            KSerializer kSerializer9 = (KSerializer) arrayList.get(2);
                            Intrinsics.checkNotNullParameter(kSerializer7, "aSerializer");
                            Intrinsics.checkNotNullParameter(kSerializer8, "bSerializer");
                            Intrinsics.checkNotNullParameter(kSerializer9, "cSerializer");
                            kSerializer = new TripleSerializer(kSerializer7, kSerializer8, kSerializer9);
                        } else {
                            Intrinsics.checkNotNullParameter(kclass, "rootClass");
                            if (TweetUtils.getJavaClass(kclass).isArray()) {
                                KClassifier classifier = ((KType) arrayList2.get(0)).getClassifier();
                                if (classifier != null) {
                                    reflectiveOrContextual = TypeUtilsKt.ArraySerializer((KClass) classifier, (KSerializer) arrayList.get(0));
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                                }
                            } else {
                                Object[] array = arrayList.toArray(new KSerializer[0]);
                                if (array != null) {
                                    KSerializer[] kSerializerArr = (KSerializer[]) array;
                                    kSerializer = TypeUtilsKt.constructSerializerForGivenTypeArgs(kclass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
                                    if (kSerializer == null) {
                                        reflectiveOrContextual = TypeUtilsKt.reflectiveOrContextual(serializersModule, kclass, arrayList);
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                        }
                        kSerializer = kSerializer2;
                    }
                }
            }
            kSerializer = reflectiveOrContextual;
        }
        if (kSerializer == null) {
            kSerializer = null;
        }
        if (kSerializer == null) {
            return null;
        }
        return isMarkedNullable ? TypeUtilsKt.getNullable(kSerializer) : kSerializer;
    }
}
