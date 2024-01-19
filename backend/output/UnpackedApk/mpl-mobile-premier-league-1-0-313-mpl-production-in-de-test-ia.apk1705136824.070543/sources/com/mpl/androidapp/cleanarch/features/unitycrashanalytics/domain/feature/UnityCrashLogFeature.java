package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/UnityCrashLogFeature;", "", "clearTable", "", "crashInterceptedExceptionHandler", "data", "", "battleId", "crashMessage", "isEnabledInCt", "", "isEnabledInKafka", "isUnityCrashFeatureEnabled", "unityGameClosedNormally", "unityGameInstantiated", "unityGameUpdated", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityCrashLogFeature.kt */
public interface UnityCrashLogFeature {
    void clearTable();

    void crashInterceptedExceptionHandler(String str, String str2, String str3);

    boolean isEnabledInCt();

    boolean isEnabledInKafka();

    boolean isUnityCrashFeatureEnabled();

    void unityGameClosedNormally(String str, String str2);

    void unityGameInstantiated(String str);

    void unityGameUpdated(String str, String str2);
}
