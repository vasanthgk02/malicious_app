package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public interface CallAdapter<R, T> {

    public static abstract class Factory {
        public abstract CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit);
    }

    T adapt(Call<R> call);

    Type responseType();
}
