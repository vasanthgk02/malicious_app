package co.hyperverge.crashguard.data.repo;

import androidx.datastore.preferences.PreferenceDataStoreDelegateKt$preferencesDataStore$1;
import androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"defaultDs", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getDefaultDs", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "defaultDs$delegate", "Lkotlin/properties/ReadOnlyProperty;", "crashguard_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: PrefsRepo.kt */
public final class PrefsRepoKt {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(PrefsRepoKt.class, "defaultDs", "getDefaultDs(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    public static final ReadOnlyProperty defaultDs$delegate;

    static {
        PreferenceDataStoreDelegateKt$preferencesDataStore$1 preferenceDataStoreDelegateKt$preferencesDataStore$1 = PreferenceDataStoreDelegateKt$preferencesDataStore$1.INSTANCE;
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        CoroutineScope CoroutineScope = TypeUtilsKt.CoroutineScope(Dispatchers.IO.plus(TypeUtilsKt.SupervisorJob$default(null, 1)));
        Intrinsics.checkNotNullParameter("default", "name");
        Intrinsics.checkNotNullParameter(preferenceDataStoreDelegateKt$preferencesDataStore$1, "produceMigrations");
        Intrinsics.checkNotNullParameter(CoroutineScope, "scope");
        defaultDs$delegate = new PreferenceDataStoreSingletonDelegate("default", preferenceDataStoreDelegateKt$preferencesDataStore$1, CoroutineScope);
    }
}
