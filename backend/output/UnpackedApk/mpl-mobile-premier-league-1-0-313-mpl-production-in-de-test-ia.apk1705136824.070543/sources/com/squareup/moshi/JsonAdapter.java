package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonReader.Token;
import com.squareup.moshi.internal.NonNullJsonAdapter;
import com.squareup.moshi.internal.NullSafeJsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class JsonAdapter<T> {

    public interface Factory {
        JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi);
    }

    public final JsonAdapter<T> failOnUnknown() {
        return new JsonAdapter<T>() {
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean failOnUnknown = jsonReader.failOnUnknown();
                jsonReader.setFailOnUnknown(true);
                try {
                    return this.fromJson(jsonReader);
                } finally {
                    jsonReader.setFailOnUnknown(failOnUnknown);
                }
            }

            public boolean isLenient() {
                return this.isLenient();
            }

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                this.toJson(jsonWriter, t);
            }

            public String toString() {
                return this + ".failOnUnknown()";
            }
        };
    }

    public abstract T fromJson(JsonReader jsonReader) throws IOException;

    public final T fromJson(BufferedSource bufferedSource) throws IOException {
        return fromJson(JsonReader.of(bufferedSource));
    }

    public final T fromJsonValue(Object obj) {
        try {
            return fromJson((JsonReader) new JsonValueReader(obj));
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public JsonAdapter<T> indent(final String str) {
        if (str != null) {
            return new JsonAdapter<T>() {
                public T fromJson(JsonReader jsonReader) throws IOException {
                    return this.fromJson(jsonReader);
                }

                public boolean isLenient() {
                    return this.isLenient();
                }

                public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                    String indent = jsonWriter.getIndent();
                    jsonWriter.setIndent(str);
                    try {
                        this.toJson(jsonWriter, t);
                    } finally {
                        jsonWriter.setIndent(indent);
                    }
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this);
                    sb.append(".indent(\"");
                    return GeneratedOutlineSupport.outline62(sb, str, "\")");
                }
            };
        }
        throw new NullPointerException("indent == null");
    }

    public boolean isLenient() {
        return false;
    }

    public final JsonAdapter<T> lenient() {
        return new JsonAdapter<T>() {
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean isLenient = jsonReader.isLenient();
                jsonReader.setLenient(true);
                try {
                    return this.fromJson(jsonReader);
                } finally {
                    jsonReader.setLenient(isLenient);
                }
            }

            public boolean isLenient() {
                return true;
            }

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                boolean isLenient = jsonWriter.isLenient();
                jsonWriter.setLenient(true);
                try {
                    this.toJson(jsonWriter, t);
                } finally {
                    jsonWriter.setLenient(isLenient);
                }
            }

            public String toString() {
                return this + ".lenient()";
            }
        };
    }

    public final JsonAdapter<T> nonNull() {
        if (this instanceof NonNullJsonAdapter) {
            return this;
        }
        return new NonNullJsonAdapter(this);
    }

    public final JsonAdapter<T> nullSafe() {
        if (this instanceof NullSafeJsonAdapter) {
            return this;
        }
        return new NullSafeJsonAdapter(this);
    }

    public final JsonAdapter<T> serializeNulls() {
        return new JsonAdapter<T>() {
            public T fromJson(JsonReader jsonReader) throws IOException {
                return this.fromJson(jsonReader);
            }

            public boolean isLenient() {
                return this.isLenient();
            }

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                boolean serializeNulls = jsonWriter.getSerializeNulls();
                jsonWriter.setSerializeNulls(true);
                try {
                    this.toJson(jsonWriter, t);
                } finally {
                    jsonWriter.setSerializeNulls(serializeNulls);
                }
            }

            public String toString() {
                return this + ".serializeNulls()";
            }
        };
    }

    public abstract void toJson(JsonWriter jsonWriter, T t) throws IOException;

    public final void toJson(BufferedSink bufferedSink, T t) throws IOException {
        toJson(JsonWriter.of(bufferedSink), t);
    }

    public final Object toJsonValue(T t) {
        JsonValueWriter jsonValueWriter = new JsonValueWriter();
        try {
            toJson((JsonWriter) jsonValueWriter, t);
            return jsonValueWriter.root();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final T fromJson(String str) throws IOException {
        JsonReader of = JsonReader.of(new Buffer().writeUtf8(str));
        T fromJson = fromJson(of);
        if (isLenient() || of.peek() == Token.END_DOCUMENT) {
            return fromJson;
        }
        throw new JsonDataException((String) "JSON document was not fully consumed.");
    }

    public final String toJson(T t) {
        Buffer buffer = new Buffer();
        try {
            toJson((BufferedSink) buffer, t);
            return buffer.readUtf8();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
