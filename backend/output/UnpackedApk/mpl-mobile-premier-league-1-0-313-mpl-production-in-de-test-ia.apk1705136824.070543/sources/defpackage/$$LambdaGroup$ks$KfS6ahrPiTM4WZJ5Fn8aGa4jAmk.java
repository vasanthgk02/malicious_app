package defpackage;

import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal;

/* renamed from: -$$LambdaGroup$ks$KfS6ahrPiTM4WZJ5Fn8aGa4jAmk  reason: invalid class name and default package */
/* compiled from: com.android.tools.r8.jetbrains.kotlin-style lambda group */
public final class $$LambdaGroup$ks$KfS6ahrPiTM4WZJ5Fn8aGa4jAmk extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
    public final /* synthetic */ Object $capture$0;
    public final /* synthetic */ int $id$;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public $$LambdaGroup$ks$KfS6ahrPiTM4WZJ5Fn8aGa4jAmk(int i, Object obj) {
        // this.$id$ = i;
        // this.$capture$0 = obj;
        super(0);
    }

    public final Object invoke() {
        int i = this.$id$;
        if (i == 0) {
            ReflectProperties$LazySoftVal reflectProperties$LazySoftVal = ((Data) this.$capture$0).allNonStaticMembers$delegate;
            KProperty kProperty = Data.$$delegatedProperties[14];
            ReflectProperties$LazySoftVal reflectProperties$LazySoftVal2 = ((Data) this.$capture$0).allStaticMembers$delegate;
            KProperty kProperty2 = Data.$$delegatedProperties[15];
            return ArraysKt___ArraysJvmKt.plus((Collection) reflectProperties$LazySoftVal.invoke(), (Iterable<? extends T>) (Collection) reflectProperties$LazySoftVal2.invoke());
        } else if (i == 1) {
            ReflectProperties$LazySoftVal reflectProperties$LazySoftVal3 = ((Data) this.$capture$0).declaredNonStaticMembers$delegate;
            KProperty kProperty3 = Data.$$delegatedProperties[10];
            ReflectProperties$LazySoftVal reflectProperties$LazySoftVal4 = ((Data) this.$capture$0).inheritedNonStaticMembers$delegate;
            KProperty kProperty4 = Data.$$delegatedProperties[12];
            return ArraysKt___ArraysJvmKt.plus((Collection) reflectProperties$LazySoftVal3.invoke(), (Iterable<? extends T>) (Collection) reflectProperties$LazySoftVal4.invoke());
        } else if (i == 2) {
            ReflectProperties$LazySoftVal reflectProperties$LazySoftVal5 = ((Data) this.$capture$0).declaredStaticMembers$delegate;
            KProperty kProperty5 = Data.$$delegatedProperties[11];
            ReflectProperties$LazySoftVal reflectProperties$LazySoftVal6 = ((Data) this.$capture$0).inheritedStaticMembers$delegate;
            KProperty kProperty6 = Data.$$delegatedProperties[13];
            return ArraysKt___ArraysJvmKt.plus((Collection) reflectProperties$LazySoftVal5.invoke(), (Iterable<? extends T>) (Collection) reflectProperties$LazySoftVal6.invoke());
        } else if (i == 3) {
            ReflectProperties$LazySoftVal reflectProperties$LazySoftVal7 = ((Data) this.$capture$0).declaredNonStaticMembers$delegate;
            KProperty kProperty7 = Data.$$delegatedProperties[10];
            ReflectProperties$LazySoftVal reflectProperties$LazySoftVal8 = ((Data) this.$capture$0).declaredStaticMembers$delegate;
            KProperty kProperty8 = Data.$$delegatedProperties[11];
            return ArraysKt___ArraysJvmKt.plus((Collection) reflectProperties$LazySoftVal7.invoke(), (Iterable<? extends T>) (Collection) reflectProperties$LazySoftVal8.invoke());
        } else {
            throw null;
        }
    }
}
