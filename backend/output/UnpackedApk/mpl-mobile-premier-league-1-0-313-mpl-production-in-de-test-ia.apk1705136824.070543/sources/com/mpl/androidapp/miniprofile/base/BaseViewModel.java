package com.mpl.androidapp.miniprofile.base;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/mpl/androidapp/miniprofile/base/BaseViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "context", "getContext", "()Landroid/app/Application;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseViewModel.kt */
public class BaseViewModel extends AndroidViewModel {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BaseViewModel(Application application) {
        // Intrinsics.checkNotNullParameter(application, "application");
        super(application);
    }

    public final Application getContext() {
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication<Application>()");
        return application;
    }
}
