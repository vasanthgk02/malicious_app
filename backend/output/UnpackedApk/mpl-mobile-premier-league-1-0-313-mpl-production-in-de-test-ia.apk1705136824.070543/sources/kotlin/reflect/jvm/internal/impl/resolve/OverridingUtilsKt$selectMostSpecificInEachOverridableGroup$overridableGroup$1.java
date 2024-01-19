package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: overridingUtils.kt */
public final class OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1 extends Lambda implements Function1<H, Unit> {
    public final /* synthetic */ SmartSet<H> $conflictedHandles;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(SmartSet<H> smartSet) {
        // this.$conflictedHandles = smartSet;
        super(1);
    }

    public Object invoke(Object obj) {
        SmartSet<H> smartSet = this.$conflictedHandles;
        Intrinsics.checkNotNullExpressionValue(obj, "it");
        smartSet.add(obj);
        return Unit.INSTANCE;
    }
}
