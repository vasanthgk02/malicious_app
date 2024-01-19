package com.mpl.androidapp.miniprofile.extensions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"openActivity", "", "T", "Landroid/content/Context;", "it", "Ljava/lang/Class;", "extras", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ExtensionFunctionType;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntentData.kt */
public final class IntentDataKt {
    public static final <T> void openActivity(Context context, Class<T> cls, Function1<? super Bundle, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(cls, "it");
        Intrinsics.checkNotNullParameter(function1, "extras");
        Intent intent = new Intent(context, cls);
        Bundle bundle = new Bundle();
        function1.invoke(bundle);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static /* synthetic */ void openActivity$default(Context context, Class cls, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = IntentDataKt$openActivity$1.INSTANCE;
        }
        openActivity(context, cls, function1);
    }
}
