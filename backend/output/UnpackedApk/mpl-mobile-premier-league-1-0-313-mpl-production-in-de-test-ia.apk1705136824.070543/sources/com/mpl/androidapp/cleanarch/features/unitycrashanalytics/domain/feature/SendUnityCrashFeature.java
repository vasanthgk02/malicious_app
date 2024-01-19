package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature;

import com.mpl.androidapp.cleanarch.core.utils.Resource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/SendUnityCrashFeature;", "", "sendCrashEventToKafka", "Lcom/mpl/androidapp/cleanarch/core/utils/Resource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendUnityCrashFeature.kt */
public interface SendUnityCrashFeature {
    Object sendCrashEventToKafka(Continuation<? super Resource<Boolean>> continuation);
}
