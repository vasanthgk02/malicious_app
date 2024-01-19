package retrofit2;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import okhttp3.RequestBody;
import okio.Buffer;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;

public abstract class ParameterHandler<T> {

    public static final class Body<T> extends ParameterHandler<T> {
        public final Converter<T, RequestBody> converter;
        public final Method method;
        public final int p;

        public Body(Method method2, int i, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.p = i;
            this.converter = converter2;
        }

        public void apply(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    requestBuilder.body = (RequestBody) this.converter.convert(t);
                } catch (IOException e2) {
                    Method method2 = this.method;
                    int i = this.p;
                    throw Utils.parameterError(method2, e2, i, "Unable to convert " + t + " to RequestBody", new Object[0]);
                }
            } else {
                throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    public static final class Field<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final String name;
        public final Converter<T, String> valueConverter;

        public Field(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                String str = (String) this.valueConverter.convert(t);
                if (str != null) {
                    String str2 = this.name;
                    if (this.encoded) {
                        requestBuilder.formBuilder.addEncoded(str2, str);
                    } else {
                        requestBuilder.formBuilder.add(str2, str);
                    }
                }
            }
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        public final boolean encoded;
        public final Method method;
        public final int p;
        public final Converter<T, String> valueConverter;

        public FieldMap(Method method2, int i, Converter<T, String> converter, boolean z) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String str2 = (String) this.valueConverter.convert(value);
                            if (str2 == null) {
                                Method method2 = this.method;
                                int i = this.p;
                                throw Utils.parameterError(method2, i, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            } else if (this.encoded) {
                                requestBuilder.formBuilder.addEncoded(str, str2);
                            } else {
                                requestBuilder.formBuilder.add(str, str2);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.p, GeneratedOutlineSupport.outline52("Field map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        public final String name;
        public final Converter<T, String> valueConverter;

        public Header(String str, Converter<T, String> converter) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
        }

        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                String str = (String) this.valueConverter.convert(t);
                if (str != null) {
                    requestBuilder.addHeader(this.name, str);
                }
            }
        }
    }

    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        public final Method method;
        public final int p;
        public final Converter<T, String> valueConverter;

        public HeaderMap(Method method2, int i, Converter<T, String> converter) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            requestBuilder.addHeader(str, (String) this.valueConverter.convert(value));
                        } else {
                            throw Utils.parameterError(this.method, this.p, GeneratedOutlineSupport.outline52("Header map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[0]);
        }
    }

    public static final class Headers extends ParameterHandler<okhttp3.Headers> {
        public final Method method;
        public final int p;

        public Headers(Method method2, int i) {
            this.method = method2;
            this.p = i;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            okhttp3.Headers headers = (okhttp3.Headers) obj;
            if (headers != null) {
                requestBuilder.headersBuilder.addAll(headers);
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    public static final class Part<T> extends ParameterHandler<T> {
        public final Converter<T, RequestBody> converter;
        public final okhttp3.Headers headers;
        public final Method method;
        public final int p;

        public Part(Method method2, int i, okhttp3.Headers headers2, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.p = i;
            this.headers = headers2;
            this.converter = converter2;
        }

        public void apply(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    RequestBody requestBody = (RequestBody) this.converter.convert(t);
                    requestBuilder.multipartBuilder.addPart(this.headers, requestBody);
                } catch (IOException e2) {
                    Method method2 = this.method;
                    int i = this.p;
                    throw Utils.parameterError(method2, i, "Unable to convert " + t + " to RequestBody", e2);
                }
            }
        }
    }

    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        public final Method method;
        public final int p;
        public final String transferEncoding;
        public final Converter<T, RequestBody> valueConverter;

        public PartMap(Method method2, int i, Converter<T, RequestBody> converter, String str) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String[] strArr = {"Content-Disposition", GeneratedOutlineSupport.outline52("form-data; name=\"", str, "\""), Names.CONTENT_TRANSFER_ENCODING, this.transferEncoding};
                            requestBuilder.multipartBuilder.addPart(okhttp3.Headers.of(strArr), (RequestBody) this.valueConverter.convert(value));
                        } else {
                            throw Utils.parameterError(this.method, this.p, GeneratedOutlineSupport.outline52("Part map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
        }
    }

    public static final class Path<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final Method method;
        public final String name;
        public final int p;
        public final Converter<T, String> valueConverter;

        public Path(Method method2, int i, String str, Converter<T, String> converter, boolean z) {
            this.method = method2;
            this.p = i;
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String str;
            int i;
            RequestBuilder requestBuilder2 = requestBuilder;
            T t2 = t;
            if (t2 != null) {
                String str2 = this.name;
                String str3 = (String) this.valueConverter.convert(t2);
                boolean z = this.encoded;
                if (requestBuilder2.relativeUrl != null) {
                    int length = str3.length();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            str = str3;
                            break;
                        }
                        int codePointAt = str3.codePointAt(i2);
                        i = 47;
                        if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                            Buffer buffer = new Buffer();
                            buffer.writeUtf8(str3, 0, i2);
                            Buffer buffer2 = null;
                        } else {
                            i2 += Character.charCount(codePointAt);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    buffer3.writeUtf8(str3, 0, i2);
                    Buffer buffer22 = null;
                    while (i2 < length) {
                        int codePointAt2 = str3.codePointAt(i2);
                        if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                            if (codePointAt2 < 32 || codePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt2) != -1 || (!z && (codePointAt2 == i || codePointAt2 == 37))) {
                                if (buffer22 == null) {
                                    buffer22 = new Buffer();
                                }
                                buffer22.writeUtf8CodePoint(codePointAt2);
                                while (!buffer22.exhausted()) {
                                    byte readByte = buffer22.readByte() & 255;
                                    buffer3.writeByte(37);
                                    buffer3.writeByte((int) RequestBuilder.HEX_DIGITS[(readByte >> 4) & 15]);
                                    buffer3.writeByte((int) RequestBuilder.HEX_DIGITS[readByte & 15]);
                                }
                            } else {
                                buffer3.writeUtf8CodePoint(codePointAt2);
                            }
                        }
                        i2 += Character.charCount(codePointAt2);
                        i = 47;
                    }
                    str = buffer3.readUtf8();
                    String str4 = requestBuilder2.relativeUrl;
                    String replace = str4.replace("{" + str2 + "}", str);
                    if (!RequestBuilder.PATH_TRAVERSAL.matcher(replace).matches()) {
                        requestBuilder2.relativeUrl = replace;
                        return;
                    }
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("@Path parameters shouldn't perform path traversal ('.' or '..'): ", str3));
                }
                throw new AssertionError();
            }
            throw Utils.parameterError(this.method, this.p, GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("Path parameter \""), this.name, "\" value must not be null."), new Object[0]);
        }
    }

    public static final class Query<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final String name;
        public final Converter<T, String> valueConverter;

        public Query(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                String str = (String) this.valueConverter.convert(t);
                if (str != null) {
                    requestBuilder.addQueryParam(this.name, str, this.encoded);
                }
            }
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        public final boolean encoded;
        public final Method method;
        public final int p;
        public final Converter<T, String> valueConverter;

        public QueryMap(Method method2, int i, Converter<T, String> converter, boolean z) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String str2 = (String) this.valueConverter.convert(value);
                            if (str2 != null) {
                                requestBuilder.addQueryParam(str, str2, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i = this.p;
                                throw Utils.parameterError(method2, i, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.p, GeneratedOutlineSupport.outline52("Query map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Query map was null", new Object[0]);
        }
    }

    public static final class QueryName<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> converter, boolean z) {
            this.nameConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.addQueryParam((String) this.nameConverter.convert(t), null, this.encoded);
            }
        }
    }

    public static final class RawPart extends ParameterHandler<okhttp3.MultipartBody.Part> {
        public static final RawPart INSTANCE = new RawPart();

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            okhttp3.MultipartBody.Part part = (okhttp3.MultipartBody.Part) obj;
            if (part != null) {
                requestBuilder.multipartBuilder.addPart(part);
            }
        }
    }

    public static final class RelativeUrl extends ParameterHandler<Object> {
        public final Method method;
        public final int p;

        public RelativeUrl(Method method2, int i) {
            this.method = method2;
            this.p = i;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils.parameterError(this.method, this.p, "@Url parameter is null.", new Object[0]);
            } else if (requestBuilder != null) {
                requestBuilder.relativeUrl = obj.toString();
            } else {
                throw null;
            }
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, T t) throws IOException;
}
