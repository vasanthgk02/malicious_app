package defpackage;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;

/* renamed from: -$$LambdaGroup$ks$bezrvfPA73iKNfJnnTgzXLdXaLY  reason: invalid class name and default package */
/* compiled from: com.android.tools.r8.jetbrains.kotlin-style lambda group */
public final class $$LambdaGroup$ks$bezrvfPA73iKNfJnnTgzXLdXaLY extends Lambda implements Function0<ParameterDescriptor> {
    public final /* synthetic */ Object $capture$0;
    public final /* synthetic */ int $id$;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public $$LambdaGroup$ks$bezrvfPA73iKNfJnnTgzXLdXaLY(int i, Object obj) {
        // this.$id$ = i;
        // this.$capture$0 = obj;
        super(0);
    }

    public final Object invoke() {
        int i = this.$id$;
        if (i == 0) {
            return (ReceiverParameterDescriptor) this.$capture$0;
        }
        if (i == 1) {
            return (ReceiverParameterDescriptor) this.$capture$0;
        }
        throw null;
    }
}
