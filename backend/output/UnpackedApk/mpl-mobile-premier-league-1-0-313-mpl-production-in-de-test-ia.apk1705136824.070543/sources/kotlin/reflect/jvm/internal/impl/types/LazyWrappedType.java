package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NotValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
public final class LazyWrappedType extends WrappedType {
    public final Function0<KotlinType> computation;
    public final NotNullLazyValue<KotlinType> lazyValue;
    public final StorageManager storageManager;

    public LazyWrappedType(StorageManager storageManager2, Function0<? extends KotlinType> function0) {
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "computation");
        this.storageManager = storageManager2;
        this.computation = function0;
        this.lazyValue = storageManager2.createLazyValue(function0);
    }

    public KotlinType getDelegate() {
        return (KotlinType) this.lazyValue.invoke();
    }

    public boolean isComputed() {
        LockBasedLazyValue lockBasedLazyValue = (LockBasedLazyValue) this.lazyValue;
        return (lockBasedLazyValue.value == NotValue.NOT_COMPUTED || lockBasedLazyValue.value == NotValue.COMPUTING) ? false : true;
    }

    public KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new LazyWrappedType(this.storageManager, new LazyWrappedType$refine$1(kotlinTypeRefiner, this));
    }
}
