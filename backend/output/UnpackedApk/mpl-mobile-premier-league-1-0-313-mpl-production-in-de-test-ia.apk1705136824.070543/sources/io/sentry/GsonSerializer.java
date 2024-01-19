package io.sentry;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.sentry.adapters.CollectionAdapter;
import io.sentry.adapters.ContextsDeserializerAdapter;
import io.sentry.adapters.ContextsSerializerAdapter;
import io.sentry.adapters.DateDeserializerAdapter;
import io.sentry.adapters.DateSerializerAdapter;
import io.sentry.adapters.MapAdapter;
import io.sentry.adapters.OrientationDeserializerAdapter;
import io.sentry.adapters.OrientationSerializerAdapter;
import io.sentry.adapters.SentryIdDeserializerAdapter;
import io.sentry.adapters.SentryIdSerializerAdapter;
import io.sentry.adapters.SentryLevelDeserializerAdapter;
import io.sentry.adapters.SentryLevelSerializerAdapter;
import io.sentry.adapters.SpanIdDeserializerAdapter;
import io.sentry.adapters.SpanIdSerializerAdapter;
import io.sentry.adapters.SpanStatusDeserializerAdapter;
import io.sentry.adapters.SpanStatusSerializerAdapter;
import io.sentry.adapters.TimeZoneDeserializerAdapter;
import io.sentry.adapters.TimeZoneSerializerAdapter;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Device.DeviceOrientation;
import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public final class GsonSerializer implements ISerializer {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public final Gson gson = provideGson();
    public final SentryOptions options;

    public static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    public GsonSerializer(SentryOptions sentryOptions) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "The SentryOptions object is required.");
    }

    private Gson provideGson() {
        Class<SpanId> cls = SpanId.class;
        Class<SentryId> cls2 = SentryId.class;
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(cls2, new SentryIdSerializerAdapter(this.options)).registerTypeAdapter(cls2, new SentryIdDeserializerAdapter(this.options)).registerTypeAdapter(Date.class, new DateSerializerAdapter(this.options)).registerTypeAdapter(Date.class, new DateDeserializerAdapter(this.options)).registerTypeAdapter(TimeZone.class, new TimeZoneSerializerAdapter(this.options)).registerTypeAdapter(TimeZone.class, new TimeZoneDeserializerAdapter(this.options)).registerTypeAdapter(DeviceOrientation.class, new OrientationSerializerAdapter(this.options)).registerTypeAdapter(DeviceOrientation.class, new OrientationDeserializerAdapter(this.options)).registerTypeAdapter(SentryLevel.class, new SentryLevelSerializerAdapter(this.options)).registerTypeAdapter(SentryLevel.class, new SentryLevelDeserializerAdapter(this.options)).registerTypeAdapter(Contexts.class, new ContextsDeserializerAdapter(this.options)).registerTypeAdapter(Contexts.class, new ContextsSerializerAdapter(this.options)).registerTypeAdapterFactory(UnknownPropertiesTypeAdapterFactory.get()).registerTypeAdapter(SentryEnvelopeHeader.class, new SentryEnvelopeHeaderAdapter()).registerTypeAdapter(SentryEnvelopeItemHeader.class, new SentryEnvelopeItemHeaderAdapter()).registerTypeAdapter(Session.class, new SessionAdapter(this.options)).registerTypeAdapter(cls, new SpanIdDeserializerAdapter(this.options)).registerTypeAdapter(cls, new SpanIdSerializerAdapter(this.options)).registerTypeAdapter(SpanStatus.class, new SpanStatusDeserializerAdapter(this.options)).registerTypeAdapter(SpanStatus.class, new SpanStatusSerializerAdapter(this.options)).registerTypeHierarchyAdapter(Collection.class, new CollectionAdapter()).registerTypeHierarchyAdapter(Map.class, new MapAdapter()).disableHtmlEscaping().create();
    }

    public <T> T deserialize(Reader reader, Class<T> cls) {
        Objects.requireNonNull(reader, "The Reader object is required.");
        Objects.requireNonNull(cls, "The Class type is required.");
        return this.gson.fromJson(reader, cls);
    }

    public SentryEnvelope deserializeEnvelope(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "The InputStream object is required.");
        try {
            return this.options.getEnvelopeReader().read(inputStream);
        } catch (IOException e2) {
            this.options.getLogger().log(SentryLevel.ERROR, (String) "Error deserializing envelope.", (Throwable) e2);
            return null;
        }
    }

    public <T> void serialize(T t, Writer writer) throws IOException {
        Objects.requireNonNull(t, "The entity is required.");
        Objects.requireNonNull(writer, "The Writer object is required.");
        if (this.options.getLogger().isEnabled(SentryLevel.DEBUG)) {
            this.options.getLogger().log(SentryLevel.DEBUG, (String) "Serializing object: %s", this.gson.toJson((Object) t));
        }
        this.gson.toJson((Object) t, (Type) t.getClass(), (Appendable) writer);
        writer.flush();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        $closeResource(r8, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        $closeResource(r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void serialize(io.sentry.SentryEnvelope r8, java.io.OutputStream r9) throws java.lang.Exception {
        /*
            r7 = this;
            java.lang.String r0 = "\n"
            java.lang.String r1 = "The SentryEnvelope object is required."
            io.sentry.util.Objects.requireNonNull(r8, r1)
            java.lang.String r1 = "The Stream object is required."
            io.sentry.util.Objects.requireNonNull(r9, r1)
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream
            r1.<init>(r9)
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ all -> 0x007c }
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x007c }
            java.nio.charset.Charset r4 = UTF_8     // Catch:{ all -> 0x007c }
            r3.<init>(r1, r4)     // Catch:{ all -> 0x007c }
            r2.<init>(r3)     // Catch:{ all -> 0x007c }
            com.google.gson.Gson r3 = r7.gson     // Catch:{ all -> 0x0075 }
            io.sentry.SentryEnvelopeHeader r4 = r8.getHeader()     // Catch:{ all -> 0x0075 }
            java.lang.Class<io.sentry.SentryEnvelopeHeader> r5 = io.sentry.SentryEnvelopeHeader.class
            r3.toJson(r4, r5, r2)     // Catch:{ all -> 0x0075 }
            r2.write(r0)     // Catch:{ all -> 0x0075 }
            java.lang.Iterable r8 = r8.getItems()     // Catch:{ all -> 0x0075 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0075 }
        L_0x0033:
            boolean r3 = r8.hasNext()     // Catch:{ all -> 0x0075 }
            if (r3 == 0) goto L_0x006a
            java.lang.Object r3 = r8.next()     // Catch:{ all -> 0x0075 }
            io.sentry.SentryEnvelopeItem r3 = (io.sentry.SentryEnvelopeItem) r3     // Catch:{ all -> 0x0075 }
            byte[] r4 = r3.getData()     // Catch:{ Exception -> 0x005b }
            com.google.gson.Gson r5 = r7.gson     // Catch:{ Exception -> 0x005b }
            io.sentry.SentryEnvelopeItemHeader r3 = r3.getHeader()     // Catch:{ Exception -> 0x005b }
            java.lang.Class<io.sentry.SentryEnvelopeItemHeader> r6 = io.sentry.SentryEnvelopeItemHeader.class
            r5.toJson(r3, r6, r2)     // Catch:{ Exception -> 0x005b }
            r2.write(r0)     // Catch:{ Exception -> 0x005b }
            r2.flush()     // Catch:{ Exception -> 0x005b }
            r9.write(r4)     // Catch:{ Exception -> 0x005b }
            r2.write(r0)     // Catch:{ Exception -> 0x005b }
            goto L_0x0033
        L_0x005b:
            r3 = move-exception
            io.sentry.SentryOptions r4 = r7.options     // Catch:{ all -> 0x0075 }
            io.sentry.ILogger r4 = r4.getLogger()     // Catch:{ all -> 0x0075 }
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x0075 }
            java.lang.String r6 = "Failed to create envelope item. Dropping it."
            r4.log(r5, r6, r3)     // Catch:{ all -> 0x0075 }
            goto L_0x0033
        L_0x006a:
            r2.flush()     // Catch:{ all -> 0x0075 }
            r8 = 0
            $closeResource(r8, r2)     // Catch:{ all -> 0x007c }
            $closeResource(r8, r1)
            return
        L_0x0075:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r9 = move-exception
            $closeResource(r8, r2)     // Catch:{ all -> 0x007c }
            throw r9     // Catch:{ all -> 0x007c }
        L_0x007c:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x007e }
        L_0x007e:
            r9 = move-exception
            $closeResource(r8, r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.GsonSerializer.serialize(io.sentry.SentryEnvelope, java.io.OutputStream):void");
    }

    public String serialize(Map<String, Object> map) throws Exception {
        Objects.requireNonNull(map, "The SentryEnvelope object is required.");
        return this.gson.toJson((Object) map);
    }
}
