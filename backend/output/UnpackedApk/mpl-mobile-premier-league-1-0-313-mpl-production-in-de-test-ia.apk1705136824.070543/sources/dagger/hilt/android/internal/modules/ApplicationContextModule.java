package dagger.hilt.android.internal.modules;

import android.content.Context;

public final class ApplicationContextModule {
    public final Context applicationContext;

    public ApplicationContextModule(Context context) {
        this.applicationContext = context;
    }
}
