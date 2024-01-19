package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: CapturedTypeApproximation.kt */
public final class CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    public static final CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 INSTANCE = new CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1();

    public CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        UnwrappedType unwrappedType = (UnwrappedType) obj;
        Intrinsics.checkNotNullExpressionValue(unwrappedType, "it");
        return Boolean.valueOf(TweetUtils.isCaptured(unwrappedType));
    }
}
