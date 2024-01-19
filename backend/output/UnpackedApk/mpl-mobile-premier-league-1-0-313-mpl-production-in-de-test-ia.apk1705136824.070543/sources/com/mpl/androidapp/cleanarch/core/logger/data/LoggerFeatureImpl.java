package com.mpl.androidapp.cleanarch.core.logger.data;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import com.mpl.androidapp.utils.MLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ/\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ/\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ/\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/cleanarch/core/logger/data/LoggerFeatureImpl;", "Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "()V", "d", "", "tag", "", "params", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoggerFeatureImpl.kt */
public final class LoggerFeatureImpl implements LoggerFeature {
    public void d(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        MLogger.d(str, objArr);
    }

    public void e(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        MLogger.e(str, objArr);
    }

    public void i(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        MLogger.i(str, objArr);
    }

    public void v(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        MLogger.v(str, objArr);
    }

    public void w(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        MLogger.w(str, objArr);
    }
}
