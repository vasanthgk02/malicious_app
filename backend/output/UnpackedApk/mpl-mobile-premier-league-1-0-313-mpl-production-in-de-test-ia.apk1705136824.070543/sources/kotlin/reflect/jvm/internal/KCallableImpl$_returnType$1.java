package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KCallableImpl.kt */
public final class KCallableImpl$_returnType$1 extends Lambda implements Function0<KTypeImpl> {
    public final /* synthetic */ KCallableImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KCallableImpl$_returnType$1(KCallableImpl kCallableImpl) {
        // this.this$0 = kCallableImpl;
        super(0);
    }

    public Object invoke() {
        KotlinType returnType = this.this$0.getDescriptor().getReturnType();
        Intrinsics.checkNotNull(returnType);
        Intrinsics.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        return new KTypeImpl(returnType, new Function0<Type>() {
            public Object invoke() {
                KCallableImpl kCallableImpl = KCallableImpl$_returnType$1.this.this$0;
                CallableMemberDescriptor descriptor = kCallableImpl.getDescriptor();
                Type type = null;
                if (!(descriptor instanceof FunctionDescriptor)) {
                    descriptor = null;
                }
                FunctionDescriptor functionDescriptor = (FunctionDescriptor) descriptor;
                if (functionDescriptor != null && functionDescriptor.isSuspend()) {
                    Object lastOrNull = ArraysKt___ArraysJvmKt.lastOrNull(kCallableImpl.getCaller().getParameterTypes());
                    if (!(lastOrNull instanceof ParameterizedType)) {
                        lastOrNull = null;
                    }
                    ParameterizedType parameterizedType = (ParameterizedType) lastOrNull;
                    if (Intrinsics.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
                        Object single = TweetUtils.single((T[]) actualTypeArguments);
                        if (!(single instanceof WildcardType)) {
                            single = null;
                        }
                        WildcardType wildcardType = (WildcardType) single;
                        if (wildcardType != null) {
                            Type[] lowerBounds = wildcardType.getLowerBounds();
                            if (lowerBounds != null) {
                                type = (Type) TweetUtils.first(lowerBounds);
                            }
                        }
                    }
                }
                return type != null ? type : KCallableImpl$_returnType$1.this.this$0.getCaller().getReturnType();
            }
        });
    }
}
