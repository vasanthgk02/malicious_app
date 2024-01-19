package defpackage;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess;

/* renamed from: -$$LambdaGroup$ks$4ux1Dlyu29FNe4P802ak6fi6ngo  reason: invalid class name and default package */
/* compiled from: com.android.tools.r8.jetbrains.kotlin-style lambda group */
public final class $$LambdaGroup$ks$4ux1Dlyu29FNe4P802ak6fi6ngo extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
    public final /* synthetic */ Object $capture$0;
    public final /* synthetic */ int $id$;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public $$LambdaGroup$ks$4ux1Dlyu29FNe4P802ak6fi6ngo(int i, Object obj) {
        // this.$id$ = i;
        // this.$capture$0 = obj;
        super(0);
    }

    public final Object invoke() {
        int i = this.$id$;
        if (i == 0) {
            KClassImpl kClassImpl = KClassImpl.this;
            return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), MemberBelonginess.DECLARED);
        } else if (i == 1) {
            KClassImpl kClassImpl2 = KClassImpl.this;
            return kClassImpl2.getMembers(kClassImpl2.getStaticScope$kotlin_reflection(), MemberBelonginess.DECLARED);
        } else if (i == 2) {
            KClassImpl kClassImpl3 = KClassImpl.this;
            return kClassImpl3.getMembers(kClassImpl3.getMemberScope$kotlin_reflection(), MemberBelonginess.INHERITED);
        } else if (i == 3) {
            KClassImpl kClassImpl4 = KClassImpl.this;
            return kClassImpl4.getMembers(kClassImpl4.getStaticScope$kotlin_reflection(), MemberBelonginess.INHERITED);
        } else {
            throw null;
        }
    }
}
