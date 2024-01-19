package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.SingleProcessDataStore;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.PreferenceDataStore;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory$create$delegate$1;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesSerializer;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001BG\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f0\u000b0\n\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00020\u00022\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002R\u001a\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f0\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/datastore/preferences/PreferenceDataStoreSingletonDelegate;", "Lkotlin/properties/ReadOnlyProperty;", "Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "name", "", "corruptionHandler", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "produceMigrations", "Lkotlin/Function1;", "", "Landroidx/datastore/core/DataMigration;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Ljava/lang/String;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)V", "INSTANCE", "lock", "", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "datastore-preferences_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PreferenceDataStoreDelegate.kt */
public final class PreferenceDataStoreSingletonDelegate implements ReadOnlyProperty<Context, DataStore<Preferences>> {
    public volatile DataStore<Preferences> INSTANCE;
    public final ReplaceFileCorruptionHandler<Preferences> corruptionHandler = null;
    public final Object lock;
    public final String name;
    public final Function1<Context, List<DataMigration<Preferences>>> produceMigrations;
    public final CoroutineScope scope;

    public PreferenceDataStoreSingletonDelegate(String str, Function1 function1, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "produceMigrations");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.name = str;
        this.produceMigrations = function1;
        this.scope = coroutineScope;
        this.lock = new Object();
    }

    public Object getValue(Object obj, KProperty kProperty) {
        DataStore<Preferences> dataStore;
        Context context = (Context) obj;
        Intrinsics.checkNotNullParameter(context, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        DataStore<Preferences> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            if (this.INSTANCE == null) {
                Context applicationContext = context.getApplicationContext();
                Function1<Context, List<DataMigration<Preferences>>> function1 = this.produceMigrations;
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                List list = (List) function1.invoke(applicationContext);
                CoroutineScope coroutineScope = this.scope;
                PreferenceDataStoreSingletonDelegate$getValue$1$1 preferenceDataStoreSingletonDelegate$getValue$1$1 = new PreferenceDataStoreSingletonDelegate$getValue$1$1(applicationContext, this);
                Intrinsics.checkNotNullParameter(list, "migrations");
                Intrinsics.checkNotNullParameter(coroutineScope, "scope");
                Intrinsics.checkNotNullParameter(preferenceDataStoreSingletonDelegate$getValue$1$1, "produceFile");
                PreferencesSerializer preferencesSerializer = PreferencesSerializer.INSTANCE;
                PreferenceDataStoreFactory$create$delegate$1 preferenceDataStoreFactory$create$delegate$1 = new PreferenceDataStoreFactory$create$delegate$1(preferenceDataStoreSingletonDelegate$getValue$1$1);
                Intrinsics.checkNotNullParameter(preferencesSerializer, "serializer");
                Intrinsics.checkNotNullParameter(list, "migrations");
                Intrinsics.checkNotNullParameter(coroutineScope, "scope");
                Intrinsics.checkNotNullParameter(preferenceDataStoreFactory$create$delegate$1, "produceFile");
                NoOpCorruptionHandler noOpCorruptionHandler = new NoOpCorruptionHandler();
                Intrinsics.checkNotNullParameter(list, "migrations");
                SingleProcessDataStore singleProcessDataStore = new SingleProcessDataStore(preferenceDataStoreFactory$create$delegate$1, preferencesSerializer, TweetUtils.listOf(new DataMigrationInitializer$Companion$getInitializer$1(list, null)), noOpCorruptionHandler, coroutineScope);
                this.INSTANCE = new PreferenceDataStore(singleProcessDataStore);
            }
            dataStore = this.INSTANCE;
            Intrinsics.checkNotNull(dataStore);
        }
        return dataStore;
    }
}
