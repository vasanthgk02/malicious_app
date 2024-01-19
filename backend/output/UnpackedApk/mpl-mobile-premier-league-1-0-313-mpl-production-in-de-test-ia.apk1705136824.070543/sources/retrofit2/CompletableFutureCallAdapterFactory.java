package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter.Factory;

@IgnoreJRERequirement
public final class CompletableFutureCallAdapterFactory extends Factory {
    public static final Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    @IgnoreJRERequirement
    public static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        public final Type responseType;

        @IgnoreJRERequirement
        public class BodyCallback implements Callback<R> {
            public final CompletableFuture<R> future;

            public BodyCallback(BodyCallAdapter bodyCallAdapter, CompletableFuture<R> completableFuture) {
                this.future = completableFuture;
            }

            public void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }

            public void onResponse(Call<R> call, Response<R> response) {
                if (response.isSuccessful()) {
                    this.future.complete(response.body);
                } else {
                    this.future.completeExceptionally(new HttpException(response));
                }
            }
        }

        public BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        public Object adapt(Call call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new BodyCallback(this, callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        public Type responseType() {
            return this.responseType;
        }
    }

    @IgnoreJRERequirement
    public static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {
        public final Call<?> call;

        public CallCancelCompletableFuture(Call<?> call2) {
            this.call = call2;
        }

        public boolean cancel(boolean z) {
            if (z) {
                this.call.cancel();
            }
            return super.cancel(z);
        }
    }

    @IgnoreJRERequirement
    public static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        public final Type responseType;

        @IgnoreJRERequirement
        public class ResponseCallback implements Callback<R> {
            public final CompletableFuture<Response<R>> future;

            public ResponseCallback(ResponseCallAdapter responseCallAdapter, CompletableFuture<Response<R>> completableFuture) {
                this.future = completableFuture;
            }

            public void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }

            public void onResponse(Call<R> call, Response<R> response) {
                this.future.complete(response);
            }
        }

        public ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        public Object adapt(Call call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new ResponseCallback(this, callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        public Type responseType() {
            return this.responseType;
        }
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Utils.getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
            if (Utils.getRawType(parameterUpperBound) != Response.class) {
                return new BodyCallAdapter(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(Utils.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
