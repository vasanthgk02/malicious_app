package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl.Data;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KPackageImpl.kt */
public final class KPackageImpl$Data$kotlinClass$2 extends Lambda implements Function0<ReflectKotlinClass> {
    public final /* synthetic */ Data this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KPackageImpl$Data$kotlinClass$2(Data data) {
        // this.this$0 = data;
        super(0);
    }

    public Object invoke() {
        return ReflectKotlinClass.create(KPackageImpl.this.jClass);
    }
}
