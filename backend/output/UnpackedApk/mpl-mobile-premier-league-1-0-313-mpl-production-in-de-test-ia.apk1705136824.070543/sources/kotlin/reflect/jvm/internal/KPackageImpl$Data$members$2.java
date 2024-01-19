package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess;
import kotlin.reflect.jvm.internal.KPackageImpl.Data;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KPackageImpl.kt */
public final class KPackageImpl$Data$members$2 extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
    public final /* synthetic */ Data this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KPackageImpl$Data$members$2(Data data) {
        // this.this$0 = data;
        super(0);
    }

    public Object invoke() {
        Data data = this.this$0;
        KPackageImpl kPackageImpl = KPackageImpl.this;
        ReflectProperties$LazySoftVal reflectProperties$LazySoftVal = data.scope$delegate;
        KProperty kProperty = Data.$$delegatedProperties[1];
        return kPackageImpl.getMembers((MemberScope) reflectProperties$LazySoftVal.invoke(), MemberBelonginess.DECLARED);
    }
}
