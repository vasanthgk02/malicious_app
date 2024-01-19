package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes;

/* compiled from: AbstractTypeConstructor.kt */
public final class AbstractTypeConstructor$supertypes$3 extends Lambda implements Function1<Supertypes, Unit> {
    public final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractTypeConstructor$supertypes$3(AbstractTypeConstructor abstractTypeConstructor) {
        // this.this$0 = abstractTypeConstructor;
        super(1);
    }

    public Object invoke(Object obj) {
        Supertypes supertypes = (Supertypes) obj;
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        SupertypeLoopChecker supertypeLoopChecker = this.this$0.getSupertypeLoopChecker();
        AbstractTypeConstructor abstractTypeConstructor = this.this$0;
        Collection<KotlinType> findLoopsInSupertypesAndDisconnect = supertypeLoopChecker.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor, supertypes.allSupertypes, new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(abstractTypeConstructor), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(this.this$0));
        List<T> list = null;
        if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
            KotlinType defaultSupertypeIfEmpty = this.this$0.defaultSupertypeIfEmpty();
            findLoopsInSupertypesAndDisconnect = defaultSupertypeIfEmpty == null ? null : TweetUtils.listOf(defaultSupertypeIfEmpty);
            if (findLoopsInSupertypesAndDisconnect == null) {
                findLoopsInSupertypesAndDisconnect = EmptyList.INSTANCE;
            }
        }
        AbstractTypeConstructor abstractTypeConstructor2 = this.this$0;
        if (abstractTypeConstructor2 != null) {
            if (findLoopsInSupertypesAndDisconnect instanceof List) {
                list = findLoopsInSupertypesAndDisconnect;
            }
            if (list == null) {
                list = ArraysKt___ArraysJvmKt.toList(findLoopsInSupertypesAndDisconnect);
            }
            List<KotlinType> processSupertypesWithoutCycles = abstractTypeConstructor2.processSupertypesWithoutCycles(list);
            Intrinsics.checkNotNullParameter(processSupertypesWithoutCycles, "<set-?>");
            supertypes.supertypesWithoutCycles = processSupertypesWithoutCycles;
            return Unit.INSTANCE;
        }
        throw null;
    }
}
