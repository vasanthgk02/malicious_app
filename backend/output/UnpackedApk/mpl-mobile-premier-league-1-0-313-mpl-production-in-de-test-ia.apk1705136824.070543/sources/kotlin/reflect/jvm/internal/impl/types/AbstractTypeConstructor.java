package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: AbstractTypeConstructor.kt */
public abstract class AbstractTypeConstructor implements TypeConstructor {
    public final NotNullLazyValue<Supertypes> supertypes;

    /* compiled from: AbstractTypeConstructor.kt */
    public static final class Supertypes {
        public final Collection<KotlinType> allSupertypes;
        public List<? extends KotlinType> supertypesWithoutCycles = TweetUtils.listOf(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);

        public Supertypes(Collection<? extends KotlinType> collection) {
            Intrinsics.checkNotNullParameter(collection, "allSupertypes");
            this.allSupertypes = collection;
        }
    }

    public AbstractTypeConstructor(StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.INSTANCE, new AbstractTypeConstructor$supertypes$3(this));
    }

    public static final Collection access$computeNeighbours(AbstractTypeConstructor abstractTypeConstructor, TypeConstructor typeConstructor, boolean z) {
        List<T> list = null;
        if (abstractTypeConstructor != null) {
            AbstractTypeConstructor abstractTypeConstructor2 = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
            if (abstractTypeConstructor2 != null) {
                list = ArraysKt___ArraysJvmKt.plus(((Supertypes) abstractTypeConstructor2.supertypes.invoke()).allSupertypes, (Iterable<? extends T>) abstractTypeConstructor2.getAdditionalNeighboursInSupertypeGraph(z));
            }
            if (list != null) {
                return list;
            }
            Collection<KotlinType> supertypes2 = typeConstructor.getSupertypes();
            Intrinsics.checkNotNullExpressionValue(supertypes2, "supertypes");
            return supertypes2;
        }
        throw null;
    }

    public abstract Collection<KotlinType> computeSupertypes();

    public KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    public Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z) {
        return EmptyList.INSTANCE;
    }

    public abstract SupertypeLoopChecker getSupertypeLoopChecker();

    public List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> list) {
        Intrinsics.checkNotNullParameter(list, "supertypes");
        return list;
    }

    public void reportSupertypeLoopError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    public List<KotlinType> getSupertypes() {
        return ((Supertypes) this.supertypes.invoke()).supertypesWithoutCycles;
    }
}
