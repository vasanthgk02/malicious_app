package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

public final class MoshiRequestBodyConverter<T> implements Converter<T, RequestBody> {
    public static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    public final JsonAdapter<T> adapter;

    public MoshiRequestBodyConverter(JsonAdapter<T> jsonAdapter) {
        this.adapter = jsonAdapter;
    }

    public Object convert(Object obj) throws IOException {
        Buffer buffer = new Buffer();
        this.adapter.toJson(JsonWriter.of(buffer), obj);
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }
}
