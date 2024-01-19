package com.squareup.moshi.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Token;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;

public final class NonNullJsonAdapter<T> extends JsonAdapter<T> {
    public final JsonAdapter<T> delegate;

    public NonNullJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    public JsonAdapter<T> delegate() {
        return this.delegate;
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != Token.NULL) {
            return this.delegate.fromJson(jsonReader);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected null at ");
        outline73.append(jsonReader.getPath());
        throw new JsonDataException(outline73.toString());
    }

    public void toJson(JsonWriter jsonWriter, T t) throws IOException {
        if (t != null) {
            this.delegate.toJson(jsonWriter, t);
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected null at ");
        outline73.append(jsonWriter.getPath());
        throw new JsonDataException(outline73.toString());
    }

    public String toString() {
        return this.delegate + ".nonNull()";
    }
}
