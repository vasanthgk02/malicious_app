package co.hyperverge.crashguard.data.repo;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.Preferences.Key;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bJ\"\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00042\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0002\u0010\u000eJ*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00042\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0012R\u0010\u0010\u0007\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lco/hyperverge/crashguard/data/repo/PrefsDelegate;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "Lco/hyperverge/crashguard/data/repo/PrefsRepo;", "key", "Landroidx/datastore/preferences/core/Preferences$Key;", "defaultValue", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;)V", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lco/hyperverge/crashguard/data/repo/PrefsRepo;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Lco/hyperverge/crashguard/data/repo/PrefsRepo;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PrefsRepo.kt */
public final class PrefsDelegate<T> implements ReadWriteProperty<PrefsRepo, T> {
    public final T defaultValue;
    public final Key<T> key;

    public PrefsDelegate(Key<T> key2, T t) {
        Intrinsics.checkNotNullParameter(key2, "key");
        Intrinsics.checkNotNullParameter(t, "defaultValue");
        this.key = key2;
        this.defaultValue = t;
    }

    public T getValue(PrefsRepo prefsRepo, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(prefsRepo, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Key<T> key2 = this.key;
        T t = this.defaultValue;
        Intrinsics.checkNotNullParameter(key2, "key");
        T runBlocking$default = TypeUtilsKt.runBlocking$default(null, new PrefsRepo$get$1(prefsRepo, key2, null), 1, null);
        if (runBlocking$default != null) {
            t = runBlocking$default;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("get: key: ");
        outline73.append(key2.name);
        outline73.append(", value: ");
        outline73.append(t);
        outline73.toString();
        return t;
    }

    public void setValue(PrefsRepo prefsRepo, KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(prefsRepo, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t, HSLCriteriaBuilder.VALUE);
        Key<T> key2 = this.key;
        Intrinsics.checkNotNullParameter(key2, "key");
        Preferences preferences = (Preferences) TypeUtilsKt.runBlocking$default(null, new PrefsRepo$set$1(key2, t, prefsRepo, null), 1, null);
    }
}
