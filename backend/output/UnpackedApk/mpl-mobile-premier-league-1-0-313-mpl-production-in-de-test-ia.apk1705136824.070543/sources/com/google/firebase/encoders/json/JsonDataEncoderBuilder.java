package com.google.firebase.encoders.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.EncoderConfig;
import io.sentry.DateUtils;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {
    public static final ValueEncoder<Boolean> BOOLEAN_ENCODER = $$Lambda$JsonDataEncoderBuilder$qsuhyVxU2dugEaZUhp79euedYA.INSTANCE;
    public static final ObjectEncoder<Object> DEFAULT_FALLBACK_ENCODER = $$Lambda$JsonDataEncoderBuilder$nyKpx2sMm_XGQOwwVrJE0nbmA_4.INSTANCE;
    public static final ValueEncoder<String> STRING_ENCODER = $$Lambda$JsonDataEncoderBuilder$2Ag7wGKl6ZAWZofWT2AtuisPdQ.INSTANCE;
    public static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder(null);
    public ObjectEncoder<Object> fallbackEncoder;
    public boolean ignoreNullValues;
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders = new HashMap();
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    public static final class TimestampEncoder implements ValueEncoder<Date> {
        public static final DateFormat rfc339;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO_FORMAT_WITH_MILLIS, Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public TimestampEncoder(AnonymousClass1 r1) {
        }

        public void encode(Object obj, Object obj2) throws IOException {
            ((ValueEncoderContext) obj2).add(rfc339.format((Date) obj));
        }
    }

    public JsonDataEncoderBuilder() {
        HashMap hashMap = new HashMap();
        this.valueEncoders = hashMap;
        this.fallbackEncoder = DEFAULT_FALLBACK_ENCODER;
        this.ignoreNullValues = false;
        Class<String> cls = String.class;
        hashMap.put(cls, STRING_ENCODER);
        this.objectEncoders.remove(cls);
        Class<Boolean> cls2 = Boolean.class;
        this.valueEncoders.put(cls2, BOOLEAN_ENCODER);
        this.objectEncoders.remove(cls2);
        Class<Date> cls3 = Date.class;
        this.valueEncoders.put(cls3, TIMESTAMP_ENCODER);
        this.objectEncoders.remove(cls3);
    }

    public static /* synthetic */ void lambda$static$0(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't find encoder for type ");
        outline73.append(obj.getClass().getCanonicalName());
        throw new EncodingException(outline73.toString());
    }

    public EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        this.objectEncoders.put(cls, objectEncoder);
        this.valueEncoders.remove(cls);
        return this;
    }
}
