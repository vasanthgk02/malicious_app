package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Token;
import java.io.IOException;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.ByteString;
import retrofit2.Converter;

public final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    public static final ByteString UTF8_BOM = ByteString.decodeHex("EFBBBF");
    public final JsonAdapter<T> adapter;

    public MoshiResponseBodyConverter(JsonAdapter<T> jsonAdapter) {
        this.adapter = jsonAdapter;
    }

    public Object convert(Object obj) throws IOException {
        ResponseBody responseBody = (ResponseBody) obj;
        BufferedSource source = responseBody.source();
        try {
            if (source.rangeEquals(0, UTF8_BOM)) {
                source.skip((long) UTF8_BOM.size());
            }
            JsonReader of = JsonReader.of(source);
            Object fromJson = this.adapter.fromJson(of);
            if (of.peek() == Token.END_DOCUMENT) {
                return fromJson;
            }
            throw new JsonDataException((String) "JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
