package com.squareup.moshi.kotlin.reflect;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.internal.Util;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002 !BU\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0006\u0012\u001a\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R'\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "constructor", "Lkotlin/reflect/KFunction;", "allBindings", "", "Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "", "nonTransientBindings", "options", "Lcom/squareup/moshi/JsonReader$Options;", "(Lkotlin/reflect/KFunction;Ljava/util/List;Ljava/util/List;Lcom/squareup/moshi/JsonReader$Options;)V", "getAllBindings", "()Ljava/util/List;", "getConstructor", "()Lkotlin/reflect/KFunction;", "getNonTransientBindings", "getOptions", "()Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "(Lcom/squareup/moshi/JsonReader;)Ljava/lang/Object;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "(Lcom/squareup/moshi/JsonWriter;Ljava/lang/Object;)V", "toString", "", "Binding", "IndexedParameterMap", "reflect"}, k = 1, mv = {1, 4, 2})
/* compiled from: KotlinJsonAdapter.kt */
public final class KotlinJsonAdapter<T> extends JsonAdapter<T> {
    public final List<Binding<T, Object>> allBindings;
    public final KFunction<T> constructor;
    public final List<Binding<T, Object>> nonTransientBindings;
    public final Options options;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u0003BK\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\bHÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010 \u001a\u00020\u000eHÆ\u0003Jg\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\u0013\u0010%\u001a\u00028\u00022\u0006\u0010&\u001a\u00028\u0001¢\u0006\u0002\u0010'J\t\u0010(\u001a\u00020\u000eHÖ\u0001J\u001b\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00012\u0006\u0010&\u001a\u00028\u0002¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "K", "P", "", "name", "", "jsonName", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "property", "Lkotlin/reflect/KProperty1;", "parameter", "Lkotlin/reflect/KParameter;", "propertyIndex", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/squareup/moshi/JsonAdapter;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KParameter;I)V", "getAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "getJsonName", "()Ljava/lang/String;", "getName", "getParameter", "()Lkotlin/reflect/KParameter;", "getProperty", "()Lkotlin/reflect/KProperty1;", "getPropertyIndex", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "get", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "set", "", "result", "(Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "reflect"}, k = 1, mv = {1, 4, 2})
    /* compiled from: KotlinJsonAdapter.kt */
    public static final class Binding<K, P> {
        public final JsonAdapter<P> adapter;
        public final String jsonName;
        public final String name;
        public final KParameter parameter;
        public final KProperty1<K, P> property;
        public final int propertyIndex;

        public Binding(String str, String str2, JsonAdapter<P> jsonAdapter, KProperty1<K, ? extends P> kProperty1, KParameter kParameter, int i) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(jsonAdapter, "adapter");
            Intrinsics.checkNotNullParameter(kProperty1, "property");
            this.name = str;
            this.jsonName = str2;
            this.adapter = jsonAdapter;
            this.property = kProperty1;
            this.parameter = kParameter;
            this.propertyIndex = i;
        }

        public static /* synthetic */ Binding copy$default(Binding binding, String str, String str2, JsonAdapter<P> jsonAdapter, KProperty1<K, P> kProperty1, KParameter kParameter, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = binding.name;
            }
            if ((i2 & 2) != 0) {
                str2 = binding.jsonName;
            }
            String str3 = str2;
            if ((i2 & 4) != 0) {
                jsonAdapter = binding.adapter;
            }
            JsonAdapter jsonAdapter2 = jsonAdapter;
            if ((i2 & 8) != 0) {
                kProperty1 = binding.property;
            }
            KProperty1 kProperty12 = kProperty1;
            if ((i2 & 16) != 0) {
                kParameter = binding.parameter;
            }
            KParameter kParameter2 = kParameter;
            if ((i2 & 32) != 0) {
                i = binding.propertyIndex;
            }
            return binding.copy(str, str3, jsonAdapter2, kProperty12, kParameter2, i);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.jsonName;
        }

        public final JsonAdapter<P> component3() {
            return this.adapter;
        }

        public final KProperty1<K, P> component4() {
            return this.property;
        }

        public final KParameter component5() {
            return this.parameter;
        }

        public final int component6() {
            return this.propertyIndex;
        }

        public final Binding<K, P> copy(String str, String str2, JsonAdapter<P> jsonAdapter, KProperty1<K, ? extends P> kProperty1, KParameter kParameter, int i) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(jsonAdapter, "adapter");
            Intrinsics.checkNotNullParameter(kProperty1, "property");
            Binding binding = new Binding(str, str2, jsonAdapter, kProperty1, kParameter, i);
            return binding;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
            if (r2.propertyIndex == r3.propertyIndex) goto L_0x0043;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x0043
                boolean r0 = r3 instanceof com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding
                if (r0 == 0) goto L_0x0041
                com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r3 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r3
                java.lang.String r0 = r2.name
                java.lang.String r1 = r3.name
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0041
                java.lang.String r0 = r2.jsonName
                java.lang.String r1 = r3.jsonName
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0041
                com.squareup.moshi.JsonAdapter<P> r0 = r2.adapter
                com.squareup.moshi.JsonAdapter<P> r1 = r3.adapter
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0041
                kotlin.reflect.KProperty1<K, P> r0 = r2.property
                kotlin.reflect.KProperty1<K, P> r1 = r3.property
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0041
                kotlin.reflect.KParameter r0 = r2.parameter
                kotlin.reflect.KParameter r1 = r3.parameter
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0041
                int r0 = r2.propertyIndex
                int r3 = r3.propertyIndex
                if (r0 != r3) goto L_0x0041
                goto L_0x0043
            L_0x0041:
                r3 = 0
                return r3
            L_0x0043:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding.equals(java.lang.Object):boolean");
        }

        public final P get(K k) {
            return this.property.get(k);
        }

        public final JsonAdapter<P> getAdapter() {
            return this.adapter;
        }

        public final String getJsonName() {
            return this.jsonName;
        }

        public final String getName() {
            return this.name;
        }

        public final KParameter getParameter() {
            return this.parameter;
        }

        public final KProperty1<K, P> getProperty() {
            return this.property;
        }

        public final int getPropertyIndex() {
            return this.propertyIndex;
        }

        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.jsonName;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            JsonAdapter<P> jsonAdapter = this.adapter;
            int hashCode3 = (hashCode2 + (jsonAdapter != null ? jsonAdapter.hashCode() : 0)) * 31;
            KProperty1<K, P> kProperty1 = this.property;
            int hashCode4 = (hashCode3 + (kProperty1 != null ? kProperty1.hashCode() : 0)) * 31;
            KParameter kParameter = this.parameter;
            if (kParameter != null) {
                i = kParameter.hashCode();
            }
            return ((hashCode4 + i) * 31) + this.propertyIndex;
        }

        public final void set(K k, P p) {
            if (p != KotlinJsonAdapterKt.ABSENT_VALUE) {
                KProperty1<K, P> kProperty1 = this.property;
                if (kProperty1 != null) {
                    ((KMutableProperty1) kProperty1).set(k, p);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.KMutableProperty1<K, P>");
            }
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Binding(name=");
            outline73.append(this.name);
            outline73.append(", jsonName=");
            outline73.append(this.jsonName);
            outline73.append(", adapter=");
            outline73.append(this.adapter);
            outline73.append(", property=");
            outline73.append(this.property);
            outline73.append(", parameter=");
            outline73.append(this.parameter);
            outline73.append(", propertyIndex=");
            return GeneratedOutlineSupport.outline57(outline73, this.propertyIndex, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016R(\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$IndexedParameterMap;", "Lkotlin/collections/AbstractMutableMap;", "Lkotlin/reflect/KParameter;", "", "parameterKeys", "", "parameterValues", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "[Ljava/lang/Object;", "containsKey", "", "key", "get", "put", "value", "reflect"}, k = 1, mv = {1, 4, 2})
    /* compiled from: KotlinJsonAdapter.kt */
    public static final class IndexedParameterMap extends AbstractMutableMap<KParameter, Object> {
        public final List<KParameter> parameterKeys;
        public final Object[] parameterValues;

        public IndexedParameterMap(List<? extends KParameter> list, Object[] objArr) {
            Intrinsics.checkNotNullParameter(list, "parameterKeys");
            Intrinsics.checkNotNullParameter(objArr, "parameterValues");
            this.parameterKeys = list;
            this.parameterValues = objArr;
        }

        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof KParameter) {
                return containsKey((KParameter) obj);
            }
            return false;
        }

        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof KParameter) {
                return get((KParameter) obj);
            }
            return null;
        }

        public Set<Entry<KParameter, Object>> getEntries() {
            List<KParameter> list = this.parameterKeys;
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (T next : list) {
                int i2 = i + 1;
                if (i >= 0) {
                    arrayList.add(new SimpleEntry((KParameter) next, this.parameterValues[i]));
                    i = i2;
                } else {
                    TweetUtils.throwIndexOverflow();
                    throw null;
                }
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Object next2 : arrayList) {
                if (((SimpleEntry) next2).getValue() != KotlinJsonAdapterKt.ABSENT_VALUE) {
                    linkedHashSet.add(next2);
                }
            }
            return linkedHashSet;
        }

        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return obj instanceof KParameter ? getOrDefault((KParameter) obj, obj2) : obj2;
        }

        public Object put(KParameter kParameter, Object obj) {
            Intrinsics.checkNotNullParameter(kParameter, "key");
            return null;
        }

        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof KParameter) {
                return remove((KParameter) obj);
            }
            return null;
        }

        public boolean containsKey(KParameter kParameter) {
            Intrinsics.checkNotNullParameter(kParameter, "key");
            return this.parameterValues[kParameter.getIndex()] != KotlinJsonAdapterKt.ABSENT_VALUE;
        }

        public Object get(KParameter kParameter) {
            Intrinsics.checkNotNullParameter(kParameter, "key");
            Object obj = this.parameterValues[kParameter.getIndex()];
            if (obj != KotlinJsonAdapterKt.ABSENT_VALUE) {
                return obj;
            }
            return null;
        }

        public /* bridge */ Object getOrDefault(KParameter kParameter, Object obj) {
            return super.getOrDefault(kParameter, obj);
        }

        public /* bridge */ Object remove(KParameter kParameter) {
            return super.remove(kParameter);
        }

        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (obj instanceof KParameter) {
                return remove((KParameter) obj, obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(KParameter kParameter, Object obj) {
            return super.remove(kParameter, obj);
        }
    }

    public KotlinJsonAdapter(KFunction<? extends T> kFunction, List<Binding<T, Object>> list, List<Binding<T, Object>> list2, Options options2) {
        Intrinsics.checkNotNullParameter(kFunction, "constructor");
        Intrinsics.checkNotNullParameter(list, "allBindings");
        Intrinsics.checkNotNullParameter(list2, "nonTransientBindings");
        Intrinsics.checkNotNullParameter(options2, "options");
        this.constructor = kFunction;
        this.allBindings = list;
        this.nonTransientBindings = list2;
        this.options = options2;
    }

    public T fromJson(JsonReader jsonReader) {
        T t;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        int size = this.constructor.getParameters().size();
        int size2 = this.allBindings.size();
        Object[] objArr = new Object[size2];
        for (int i = 0; i < size2; i++) {
            objArr[i] = KotlinJsonAdapterKt.ABSENT_VALUE;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                Binding binding = this.nonTransientBindings.get(selectName);
                int propertyIndex = binding.getPropertyIndex();
                if (objArr[propertyIndex] == KotlinJsonAdapterKt.ABSENT_VALUE) {
                    objArr[propertyIndex] = binding.getAdapter().fromJson(jsonReader);
                    if (objArr[propertyIndex] == null && !binding.getProperty().getReturnType().isMarkedNullable()) {
                        JsonDataException unexpectedNull = Util.unexpectedNull(binding.getProperty().getName(), binding.getJsonName(), jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\n   …         reader\n        )");
                        throw unexpectedNull;
                    }
                } else {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Multiple values for '");
                    outline73.append(binding.getProperty().getName());
                    outline73.append("' at ");
                    outline73.append(jsonReader.getPath());
                    throw new JsonDataException(outline73.toString());
                }
            }
        }
        jsonReader.endObject();
        boolean z = this.allBindings.size() == size;
        for (int i2 = 0; i2 < size; i2++) {
            if (objArr[i2] == KotlinJsonAdapterKt.ABSENT_VALUE) {
                if (this.constructor.getParameters().get(i2).isOptional()) {
                    z = false;
                } else {
                    String str = null;
                    if (this.constructor.getParameters().get(i2).getType().isMarkedNullable()) {
                        objArr[i2] = null;
                    } else {
                        String name = this.constructor.getParameters().get(i2).getName();
                        Binding binding2 = this.allBindings.get(i2);
                        if (binding2 != null) {
                            str = binding2.getJsonName();
                        }
                        JsonDataException missingProperty = Util.missingProperty(name, str, jsonReader);
                        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\n  …       reader\n          )");
                        throw missingProperty;
                    }
                }
            }
        }
        if (z) {
            t = this.constructor.call(Arrays.copyOf(objArr, size2));
        } else {
            t = this.constructor.callBy(new IndexedParameterMap(this.constructor.getParameters(), objArr));
        }
        int size3 = this.allBindings.size();
        while (size < size3) {
            Binding<T, Object> binding3 = this.allBindings.get(size);
            Intrinsics.checkNotNull(binding3);
            binding3.set(t, objArr[size]);
            size++;
        }
        return t;
    }

    public final List<Binding<T, Object>> getAllBindings() {
        return this.allBindings;
    }

    public final KFunction<T> getConstructor() {
        return this.constructor;
    }

    public final List<Binding<T, Object>> getNonTransientBindings() {
        return this.nonTransientBindings;
    }

    public final Options getOptions() {
        return this.options;
    }

    public void toJson(JsonWriter jsonWriter, T t) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (t != null) {
            jsonWriter.beginObject();
            for (Binding next : this.allBindings) {
                if (next != null) {
                    jsonWriter.name(next.getName());
                    next.getAdapter().toJson(jsonWriter, next.get(t));
                }
            }
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value == null");
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("KotlinJsonAdapter(");
        outline73.append(this.constructor.getReturnType());
        outline73.append(')');
        return outline73.toString();
    }
}
