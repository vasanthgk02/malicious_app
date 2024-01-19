package retrofit2;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call.Factory;
import okhttp3.ResponseBody;

public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    public final Factory callFactory;
    public final RequestFactory requestFactory;
    public final Converter<ResponseBody, ResponseT> responseConverter;

    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        public final CallAdapter<ResponseT, ReturnT> callAdapter;

        public CallAdapted(RequestFactory requestFactory, Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter2) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
        }

        public ReturnT adapt(Call<ResponseT> call, Object[] objArr) {
            return this.callAdapter.adapt(call);
        }
    }

    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        public final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        public final boolean isNullable;

        public SuspendForBody(RequestFactory requestFactory, Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2, boolean z) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
            this.isNullable = z;
        }

        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Object obj;
            Call call2 = (Call) this.callAdapter.adapt(call);
            Continuation continuation = objArr[objArr.length - 1];
            try {
                if (this.isNullable) {
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
                    cancellableContinuationImpl.invokeOnCancellation(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call2));
                    call2.enqueue(new KotlinExtensions$await$4$2(cancellableContinuationImpl));
                    obj = cancellableContinuationImpl.getResult();
                    if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        Intrinsics.checkNotNullParameter(continuation, "frame");
                    }
                } else {
                    CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
                    cancellableContinuationImpl2.invokeOnCancellation(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call2));
                    call2.enqueue(new KotlinExtensions$await$2$2(cancellableContinuationImpl2));
                    obj = cancellableContinuationImpl2.getResult();
                    if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        Intrinsics.checkNotNullParameter(continuation, "frame");
                    }
                }
                return obj;
            } catch (Exception e2) {
                return TypeUtilsKt.suspendAndThrow(e2, continuation);
            }
        }
    }

    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        public final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        public SuspendForResponse(RequestFactory requestFactory, Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
        }

        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call call2 = (Call) this.callAdapter.adapt(call);
            Continuation continuation = objArr[objArr.length - 1];
            try {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
                cancellableContinuationImpl.invokeOnCancellation(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call2));
                call2.enqueue(new KotlinExtensions$awaitResponse$2$2(cancellableContinuationImpl));
                Object result = cancellableContinuationImpl.getResult();
                if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    Intrinsics.checkNotNullParameter(continuation, "frame");
                }
                return result;
            } catch (Exception e2) {
                return TypeUtilsKt.suspendAndThrow(e2, continuation);
            }
        }
    }

    public HttpServiceMethod(RequestFactory requestFactory2, Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.requestFactory = requestFactory2;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    public abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);
}
