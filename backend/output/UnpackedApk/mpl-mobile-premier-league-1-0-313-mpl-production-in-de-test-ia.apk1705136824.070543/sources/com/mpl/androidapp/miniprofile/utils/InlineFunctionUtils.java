package com.mpl.androidapp.miniprofile.utils;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JM\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00050\u0007\"\u0004\u0018\u0001H\u00052\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n\u0012\u0004\u0012\u00020\u00040\tH\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"Lcom/mpl/androidapp/miniprofile/utils/InlineFunctionUtils;", "", "()V", "ifLet", "", "T", "elements", "", "closure", "Lkotlin/Function1;", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InlineFunctionUtils.kt */
public final class InlineFunctionUtils {
    public static final InlineFunctionUtils INSTANCE = new InlineFunctionUtils();

    public final <T> void ifLet(T[] tArr, Function1<? super List<? extends T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        Intrinsics.checkNotNullParameter(function1, "closure");
        int length = tArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= length) {
                z = true;
                break;
            }
            if (tArr[i] == null) {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            i++;
        }
        if (z) {
            function1.invoke(TweetUtils.filterNotNull(tArr));
        }
    }
}
