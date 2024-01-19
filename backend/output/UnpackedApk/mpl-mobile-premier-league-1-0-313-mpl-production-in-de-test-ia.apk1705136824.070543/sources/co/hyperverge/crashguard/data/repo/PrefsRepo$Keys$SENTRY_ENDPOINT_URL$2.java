package co.hyperverge.crashguard.data.repo;

import androidx.core.widget.CompoundButtonCompat;
import androidx.datastore.preferences.core.Preferences.Key;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences$Key;", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: PrefsRepo.kt */
public final class PrefsRepo$Keys$SENTRY_ENDPOINT_URL$2 extends Lambda implements Function0<Key<String>> {
    public static final PrefsRepo$Keys$SENTRY_ENDPOINT_URL$2 INSTANCE = new PrefsRepo$Keys$SENTRY_ENDPOINT_URL$2();

    public PrefsRepo$Keys$SENTRY_ENDPOINT_URL$2() {
        super(0);
    }

    public Object invoke() {
        return CompoundButtonCompat.stringKey("sentryEndpointUrl");
    }
}
