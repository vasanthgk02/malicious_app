package com.squareup.moshi.kotlin.reflect;

import com.squareup.moshi.JsonAdapter.Factory;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "reflect"}, k = 1, mv = {1, 4, 2})
/* compiled from: KotlinJsonAdapter.kt */
public final class KotlinJsonAdapterFactory implements Factory {
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0230, code lost:
        if (r10 != null) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0266, code lost:
        if (r4 != null) goto L_0x026a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.squareup.moshi.JsonAdapter<?> create(java.lang.reflect.Type r22, java.util.Set<? extends java.lang.annotation.Annotation> r23, com.squareup.moshi.Moshi r24) {
        /*
            r21 = this;
            r1 = r22
            r2 = r24
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "annotations"
            r3 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "moshi"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r23.isEmpty()
            r3 = 1
            r0 = r0 ^ r3
            r4 = 0
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            java.lang.Class r5 = com.squareup.moshi._MoshiKotlinTypesExtensionsKt.getRawType(r22)
            boolean r0 = r5.isInterface()
            if (r0 == 0) goto L_0x002a
            return r4
        L_0x002a:
            boolean r0 = r5.isEnum()
            if (r0 == 0) goto L_0x0031
            return r4
        L_0x0031:
            java.lang.Class r0 = com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterKt.KOTLIN_METADATA
            boolean r0 = r5.isAnnotationPresent(r0)
            if (r0 != 0) goto L_0x003c
            return r4
        L_0x003c:
            boolean r0 = com.squareup.moshi.internal.Util.isPlatformType(r5)
            if (r0 == 0) goto L_0x0043
            return r4
        L_0x0043:
            com.squareup.moshi.JsonAdapter r0 = com.squareup.moshi.internal.Util.generatedAdapter(r2, r1, r5)     // Catch:{ RuntimeException -> 0x004a }
            if (r0 == 0) goto L_0x0054
            return r0
        L_0x004a:
            r0 = move-exception
            r6 = r0
            java.lang.Throwable r0 = r6.getCause()
            boolean r0 = r0 instanceof java.lang.ClassNotFoundException
            if (r0 == 0) goto L_0x0414
        L_0x0054:
            boolean r0 = r5.isLocalClass()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0400
            kotlin.reflect.KClass r0 = com.twitter.sdk.android.tweetui.TweetUtils.getKotlinClass(r5)
            boolean r6 = r0.isAbstract()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x03ec
            boolean r6 = r0.isInner()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x03d8
            java.lang.Object r6 = r0.getObjectInstance()
            r7 = 0
            if (r6 != 0) goto L_0x0076
            r6 = 1
            goto L_0x0077
        L_0x0076:
            r6 = 0
        L_0x0077:
            if (r6 == 0) goto L_0x03c4
            boolean r6 = r0.isSealed()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x03ae
            java.lang.String r6 = "$this$primaryConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
            r6 = r0
            kotlin.reflect.jvm.internal.KClassImpl r6 = (kotlin.reflect.jvm.internal.KClassImpl) r6
            kotlin.reflect.jvm.internal.ReflectProperties$LazyVal<kotlin.reflect.jvm.internal.KClassImpl$Data<>> r8 = r6.data
            java.lang.Object r8 = r8.invoke()
            kotlin.reflect.jvm.internal.KClassImpl$Data r8 = (kotlin.reflect.jvm.internal.KClassImpl.Data) r8
            kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal r8 = r8.constructors$delegate
            kotlin.reflect.KProperty[] r9 = kotlin.reflect.jvm.internal.KClassImpl.Data.$$delegatedProperties
            r10 = 4
            r9 = r9[r10]
            java.lang.Object r8 = r8.invoke()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x00a1:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00d1
            java.lang.Object r9 = r8.next()
            r10 = r9
            kotlin.reflect.KFunction r10 = (kotlin.reflect.KFunction) r10
            if (r10 == 0) goto L_0x00c9
            kotlin.reflect.jvm.internal.KFunctionImpl r10 = (kotlin.reflect.jvm.internal.KFunctionImpl) r10
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r10 = r10.getDescriptor()
            if (r10 == 0) goto L_0x00c1
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r10
            boolean r10 = r10.isPrimary()
            if (r10 == 0) goto L_0x00a1
            goto L_0x00d2
        L_0x00c1:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor"
            r0.<init>(r1)
            throw r0
        L_0x00c9:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl"
            r0.<init>(r1)
            throw r0
        L_0x00d1:
            r9 = r4
        L_0x00d2:
            kotlin.reflect.KFunction r9 = (kotlin.reflect.KFunction) r9
            if (r9 == 0) goto L_0x03ad
            java.util.List r8 = r9.getParameters()
            r10 = 10
            int r11 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r8, r10)
            int r11 = com.twitter.sdk.android.tweetui.TweetUtils.mapCapacity(r11)
            r12 = 16
            if (r11 >= r12) goto L_0x00ea
            r11 = 16
        L_0x00ea:
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>(r11)
            java.util.Iterator r8 = r8.iterator()
        L_0x00f3:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x0108
            java.lang.Object r11 = r8.next()
            r13 = r11
            kotlin.reflect.KParameter r13 = (kotlin.reflect.KParameter) r13
            java.lang.String r13 = r13.getName()
            r12.put(r13, r11)
            goto L_0x00f3
        L_0x0108:
            com.twitter.sdk.android.tweetui.TweetUtils.setAccessible(r9, r3)
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            java.lang.String r11 = "$this$memberProperties"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r11)
            kotlin.reflect.jvm.internal.ReflectProperties$LazyVal<kotlin.reflect.jvm.internal.KClassImpl$Data<>> r0 = r6.data
            java.lang.Object r0 = r0.invoke()
            kotlin.reflect.jvm.internal.KClassImpl$Data r0 = (kotlin.reflect.jvm.internal.KClassImpl.Data) r0
            kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal r0 = r0.allNonStaticMembers$delegate
            kotlin.reflect.KProperty[] r6 = kotlin.reflect.jvm.internal.KClassImpl.Data.$$delegatedProperties
            r11 = 14
            r6 = r6[r11]
            java.lang.Object r0 = r0.invoke()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0134:
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x015e
            java.lang.Object r11 = r0.next()
            r13 = r11
            kotlin.reflect.jvm.internal.KCallableImpl r13 = (kotlin.reflect.jvm.internal.KCallableImpl) r13
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r14 = r13.getDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r14 = r14.getExtensionReceiverParameter()
            if (r14 == 0) goto L_0x014d
            r14 = 1
            goto L_0x014e
        L_0x014d:
            r14 = 0
        L_0x014e:
            r14 = r14 ^ r3
            if (r14 == 0) goto L_0x0157
            boolean r13 = r13 instanceof kotlin.reflect.KProperty1
            if (r13 == 0) goto L_0x0157
            r13 = 1
            goto L_0x0158
        L_0x0157:
            r13 = 0
        L_0x0158:
            if (r13 == 0) goto L_0x0134
            r6.add(r11)
            goto L_0x0134
        L_0x015e:
            java.util.Iterator r0 = r6.iterator()
        L_0x0162:
            boolean r6 = r0.hasNext()
            java.lang.String r11 = "null cannot be cast to non-null type kotlin.Array<T>"
            if (r6 == 0) goto L_0x02d2
            java.lang.Object r6 = r0.next()
            kotlin.reflect.KProperty1 r6 = (kotlin.reflect.KProperty1) r6
            java.lang.String r13 = r6.getName()
            java.lang.Object r13 = r12.get(r13)
            r15 = r13
            kotlin.reflect.KParameter r15 = (kotlin.reflect.KParameter) r15
            java.lang.reflect.Field r13 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaField(r6)
            if (r13 == 0) goto L_0x0186
            int r13 = r13.getModifiers()
            goto L_0x0187
        L_0x0186:
            r13 = 0
        L_0x0187:
            boolean r13 = java.lang.reflect.Modifier.isTransient(r13)
            if (r13 == 0) goto L_0x01b8
            if (r15 == 0) goto L_0x0198
            boolean r3 = r15.isOptional()
            if (r3 == 0) goto L_0x0196
            goto L_0x0198
        L_0x0196:
            r3 = 0
            goto L_0x0199
        L_0x0198:
            r3 = 1
        L_0x0199:
            if (r3 == 0) goto L_0x019d
            goto L_0x0289
        L_0x019d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No default value for transient constructor "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x01b8:
            if (r15 == 0) goto L_0x01cb
            kotlin.reflect.KType r13 = r15.getType()
            kotlin.reflect.KType r14 = r6.getReturnType()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
            if (r13 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01c9:
            r13 = 0
            goto L_0x01cc
        L_0x01cb:
            r13 = 1
        L_0x01cc:
            if (r13 == 0) goto L_0x0295
            boolean r13 = r6 instanceof kotlin.reflect.KMutableProperty1
            if (r13 != 0) goto L_0x01d6
            if (r15 != 0) goto L_0x01d6
            goto L_0x0289
        L_0x01d6:
            com.twitter.sdk.android.tweetui.TweetUtils.setAccessible(r6, r3)
            java.util.List r3 = r6.getAnnotations()
            java.util.List r3 = kotlin.collections.ArraysKt___ArraysJvmKt.toMutableList(r3)
            java.util.List r13 = r6.getAnnotations()
            java.util.Iterator r13 = r13.iterator()
        L_0x01e9:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x01ff
            java.lang.Object r14 = r13.next()
            r10 = r14
            java.lang.annotation.Annotation r10 = (java.lang.annotation.Annotation) r10
            boolean r10 = r10 instanceof com.squareup.moshi.Json
            if (r10 == 0) goto L_0x01fc
            r4 = r14
            goto L_0x01ff
        L_0x01fc:
            r10 = 10
            goto L_0x01e9
        L_0x01ff:
            com.squareup.moshi.Json r4 = (com.squareup.moshi.Json) r4
            if (r15 == 0) goto L_0x022a
            java.util.List r10 = r15.getAnnotations()
            com.twitter.sdk.android.tweetui.TweetUtils.addAll(r3, r10)
            if (r4 != 0) goto L_0x022a
            java.util.List r4 = r15.getAnnotations()
            java.util.Iterator r4 = r4.iterator()
        L_0x0214:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x0226
            java.lang.Object r10 = r4.next()
            r13 = r10
            java.lang.annotation.Annotation r13 = (java.lang.annotation.Annotation) r13
            boolean r13 = r13 instanceof com.squareup.moshi.Json
            if (r13 == 0) goto L_0x0214
            goto L_0x0227
        L_0x0226:
            r10 = 0
        L_0x0227:
            r4 = r10
            com.squareup.moshi.Json r4 = (com.squareup.moshi.Json) r4
        L_0x022a:
            if (r4 == 0) goto L_0x0233
            java.lang.String r10 = r4.name()
            if (r10 == 0) goto L_0x0233
            goto L_0x0237
        L_0x0233:
            java.lang.String r10 = r6.getName()
        L_0x0237:
            r14 = r10
            kotlin.reflect.KType r10 = r6.getReturnType()
            java.lang.reflect.Type r10 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaType(r10)
            java.lang.reflect.Type r10 = com.squareup.moshi.internal.Util.resolve(r1, r5, r10)
            java.lang.annotation.Annotation[] r13 = new java.lang.annotation.Annotation[r7]
            java.lang.Object[] r3 = r3.toArray(r13)
            if (r3 == 0) goto L_0x028f
            java.lang.annotation.Annotation[] r3 = (java.lang.annotation.Annotation[]) r3
            java.util.Set r3 = com.squareup.moshi.internal.Util.jsonAnnotations(r3)
            java.lang.String r11 = r6.getName()
            com.squareup.moshi.JsonAdapter r3 = r2.adapter(r10, r3, r11)
            java.lang.String r10 = r6.getName()
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r11 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding
            if (r4 == 0) goto L_0x0269
            java.lang.String r4 = r4.name()
            if (r4 == 0) goto L_0x0269
            goto L_0x026a
        L_0x0269:
            r4 = r14
        L_0x026a:
            java.lang.String r13 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            if (r15 == 0) goto L_0x0278
            int r13 = r15.getIndex()
            r19 = r13
            goto L_0x027b
        L_0x0278:
            r13 = -1
            r19 = -1
        L_0x027b:
            r13 = r11
            r18 = r15
            r15 = r4
            r16 = r3
            r17 = r6
            r13.<init>(r14, r15, r16, r17, r18, r19)
            r8.put(r10, r11)
        L_0x0289:
            r3 = 1
            r4 = 0
            r10 = 10
            goto L_0x0162
        L_0x028f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r11)
            throw r0
        L_0x0295:
            r18 = r15
            r0 = 39
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline72(r0)
            java.lang.String r1 = r6.getName()
            r0.append(r1)
            java.lang.String r1 = "' has a constructor parameter of type "
            r0.append(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r18)
            kotlin.reflect.KType r1 = r18.getType()
            r0.append(r1)
            java.lang.String r1 = " but a property of type "
            r0.append(r1)
            kotlin.reflect.KType r1 = r6.getReturnType()
            r0.append(r1)
            r1 = 46
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x02d2:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r1 = r9.getParameters()
            java.util.Iterator r1 = r1.iterator()
        L_0x02df:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0326
            java.lang.Object r2 = r1.next()
            kotlin.reflect.KParameter r2 = (kotlin.reflect.KParameter) r2
            java.lang.String r3 = r2.getName()
            java.util.Map r4 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r8)
            java.lang.Object r3 = r4.remove(r3)
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r3 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r3
            if (r3 != 0) goto L_0x0304
            boolean r4 = r2.isOptional()
            if (r4 == 0) goto L_0x0302
            goto L_0x0304
        L_0x0302:
            r4 = 0
            goto L_0x0305
        L_0x0304:
            r4 = 1
        L_0x0305:
            if (r4 == 0) goto L_0x030b
            r0.add(r3)
            goto L_0x02df
        L_0x030b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No property for required constructor "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0326:
            int r1 = r0.size()
            java.util.Set r2 = r8.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0332:
            r18 = r1
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x035c
            java.lang.Object r1 = r2.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            r12 = r1
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r12 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r12
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            int r1 = r18 + 1
            r19 = 31
            r20 = 0
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r3 = com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding.copy$default(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r0.add(r3)
            goto L_0x0332
        L_0x035c:
            java.util.List r1 = kotlin.collections.ArraysKt___ArraysJvmKt.filterNotNull(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r3 = r1.iterator()
        L_0x036f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0383
            java.lang.Object r4 = r3.next()
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r4 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r4
            java.lang.String r4 = r4.getName()
            r2.add(r4)
            goto L_0x036f
        L_0x0383:
            java.lang.String[] r3 = new java.lang.String[r7]
            java.lang.Object[] r2 = r2.toArray(r3)
            if (r2 == 0) goto L_0x03a7
            java.lang.String[] r2 = (java.lang.String[]) r2
            int r3 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String[] r2 = (java.lang.String[]) r2
            com.squareup.moshi.JsonReader$Options r2 = com.squareup.moshi.JsonReader.Options.of(r2)
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter r3 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter
            java.lang.String r4 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r3.<init>(r9, r0, r1, r2)
            com.squareup.moshi.JsonAdapter r0 = r3.nullSafe()
            return r0
        L_0x03a7:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r11)
            throw r0
        L_0x03ad:
            return r4
        L_0x03ae:
            java.lang.String r0 = "Cannot reflectively serialize sealed class "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = ". Please register an adapter."
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline36(r5, r0, r1)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x03c4:
            java.lang.String r0 = "Cannot serialize object declaration "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline35(r5, r0)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x03d8:
            java.lang.String r0 = "Cannot serialize inner class "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline35(r5, r0)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x03ec:
            java.lang.String r0 = "Cannot serialize abstract class "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline35(r5, r0)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0400:
            java.lang.String r0 = "Cannot serialize local class or object expression "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline35(r5, r0)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0414:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory.create(java.lang.reflect.Type, java.util.Set, com.squareup.moshi.Moshi):com.squareup.moshi.JsonAdapter");
    }
}
