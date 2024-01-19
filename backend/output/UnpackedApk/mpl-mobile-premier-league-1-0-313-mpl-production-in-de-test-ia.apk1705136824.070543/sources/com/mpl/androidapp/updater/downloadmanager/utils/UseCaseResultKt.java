package com.mpl.androidapp.updater.downloadmanager.utils;

import androidx.lifecycle.MutableLiveData;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0005\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\bH\b\u001a#\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\n\u001a\u0002H\u0001¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000eH\b\"#\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000f"}, d2 = {"data", "T", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "getData", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;)Ljava/lang/Object;", "flowOnSuccess", "", "stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "successOr", "fallback", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;Ljava/lang/Object;)Ljava/lang/Object;", "updateOnSuccess", "liveData", "Landroidx/lifecycle/MutableLiveData;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UseCaseResult.kt */
public final class UseCaseResultKt {
    public static final /* synthetic */ <T> void flowOnSuccess(UseCaseResult<? extends T> useCaseResult, MutableStateFlow<T> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(useCaseResult, "<this>");
        Intrinsics.checkNotNullParameter(mutableStateFlow, "stateFlow");
        if (useCaseResult instanceof Success) {
            mutableStateFlow.setValue(((Success) useCaseResult).getValue());
        }
    }

    public static final <T> T getData(UseCaseResult<? extends T> useCaseResult) {
        Intrinsics.checkNotNullParameter(useCaseResult, "<this>");
        Success success = useCaseResult instanceof Success ? (Success) useCaseResult : null;
        if (success == null) {
            return null;
        }
        return success.getValue();
    }

    public static final <T> T successOr(UseCaseResult<? extends T> useCaseResult, T t) {
        Intrinsics.checkNotNullParameter(useCaseResult, "<this>");
        Success success = useCaseResult instanceof Success ? (Success) useCaseResult : null;
        if (success == null) {
            return t;
        }
        Object value = success.getValue();
        return value == null ? t : value;
    }

    public static final /* synthetic */ <T> void updateOnSuccess(UseCaseResult<? extends T> useCaseResult, MutableLiveData<T> mutableLiveData) {
        Intrinsics.checkNotNullParameter(useCaseResult, "<this>");
        Intrinsics.checkNotNullParameter(mutableLiveData, "liveData");
        if (useCaseResult instanceof Success) {
            mutableLiveData.setValue(((Success) useCaseResult).getValue());
        }
    }
}
