package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProvider.KeyedFactory;
import androidx.lifecycle.ViewModelProvider.OnRequeryFactory;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B/\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", "value", "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", "", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: ViewModelProvider.kt */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    public VM cached;
    public final Function0<Factory> factoryProducer;
    public final Function0<ViewModelStore> storeProducer;
    public final KClass<VM> viewModelClass;

    public ViewModelLazy(KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends Factory> function02) {
        Intrinsics.checkNotNullParameter(kClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(function0, "storeProducer");
        Intrinsics.checkNotNullParameter(function02, "factoryProducer");
        this.viewModelClass = kClass;
        this.storeProducer = function0;
        this.factoryProducer = function02;
    }

    public Object getValue() {
        VM vm = this.cached;
        if (vm == null) {
            Factory factory = (Factory) this.factoryProducer.invoke();
            ViewModelStore viewModelStore = (ViewModelStore) this.storeProducer.invoke();
            Class javaClass = TweetUtils.getJavaClass(this.viewModelClass);
            String canonicalName = javaClass.getCanonicalName();
            if (canonicalName != null) {
                String outline50 = GeneratedOutlineSupport.outline50("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                VM vm2 = (ViewModel) viewModelStore.mMap.get(outline50);
                if (javaClass.isInstance(vm2)) {
                    if (factory instanceof OnRequeryFactory) {
                        ((OnRequeryFactory) factory).onRequery(vm2);
                    }
                    vm = vm2;
                } else {
                    if (factory instanceof KeyedFactory) {
                        vm = ((KeyedFactory) factory).create(outline50, javaClass);
                    } else {
                        vm = factory.create(javaClass);
                    }
                    ViewModel put = viewModelStore.mMap.put(outline50, vm);
                    if (put != null) {
                        put.onCleared();
                    }
                }
                this.cached = vm;
                Intrinsics.checkNotNullExpressionValue(vm, "ViewModelProvider(store,…ed = it\n                }");
            } else {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
        }
        return vm;
    }

    public boolean isInitialized() {
        return this.cached != null;
    }
}
