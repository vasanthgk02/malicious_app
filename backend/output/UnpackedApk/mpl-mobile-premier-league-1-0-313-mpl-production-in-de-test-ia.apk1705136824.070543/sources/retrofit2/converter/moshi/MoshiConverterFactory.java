package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

public final class MoshiConverterFactory extends Factory {
    public final boolean failOnUnknown;
    public final boolean lenient;
    public final Moshi moshi;
    public final boolean serializeNulls;

    public MoshiConverterFactory(Moshi moshi2, boolean z, boolean z2, boolean z3) {
        this.moshi = moshi2;
        this.lenient = z;
        this.failOnUnknown = z2;
        this.serializeNulls = z3;
    }

    public static Set<? extends Annotation> jsonAnnotations(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        return linkedHashSet != null ? Collections.unmodifiableSet(linkedHashSet) : Collections.emptySet();
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        JsonAdapter<T> adapter = this.moshi.adapter(type, jsonAnnotations(annotationArr));
        if (this.lenient) {
            adapter = adapter.lenient();
        }
        if (this.failOnUnknown) {
            adapter = adapter.failOnUnknown();
        }
        if (this.serializeNulls) {
            adapter = adapter.serializeNulls();
        }
        return new MoshiRequestBodyConverter(adapter);
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        JsonAdapter<T> adapter = this.moshi.adapter(type, jsonAnnotations(annotationArr));
        if (this.lenient) {
            adapter = adapter.lenient();
        }
        if (this.failOnUnknown) {
            adapter = adapter.failOnUnknown();
        }
        if (this.serializeNulls) {
            adapter = adapter.serializeNulls();
        }
        return new MoshiResponseBodyConverter(adapter);
    }
}
