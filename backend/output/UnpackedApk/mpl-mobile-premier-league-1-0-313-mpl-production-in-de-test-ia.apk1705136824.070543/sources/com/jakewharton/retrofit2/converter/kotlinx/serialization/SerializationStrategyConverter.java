package com.jakewharton.retrofit2.converter.kotlinx.serialization;

import com.jakewharton.retrofit2.converter.kotlinx.serialization.Serializer.FromString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/SerializationStrategyConverter;", "T", "Lretrofit2/Converter;", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "saver", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer;", "(Lokhttp3/MediaType;Lkotlinx/serialization/SerializationStrategy;Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer;)V", "convert", "value", "(Ljava/lang/Object;)Lokhttp3/RequestBody;", "retrofit2-kotlinx-serialization-converter"}, k = 1, mv = {1, 4, 0})
/* compiled from: SerializationStrategyConverter.kt */
public final class SerializationStrategyConverter<T> implements Converter<T, RequestBody> {
    public final MediaType contentType;
    public final SerializationStrategy<T> saver;
    public final Serializer serializer;

    public SerializationStrategyConverter(MediaType mediaType, SerializationStrategy<? super T> serializationStrategy, Serializer serializer2) {
        Intrinsics.checkNotNullParameter(mediaType, "contentType");
        Intrinsics.checkNotNullParameter(serializationStrategy, "saver");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        this.contentType = mediaType;
        this.saver = serializationStrategy;
        this.serializer = serializer2;
    }

    public Object convert(Object obj) {
        Serializer serializer2 = this.serializer;
        MediaType mediaType = this.contentType;
        SerializationStrategy<T> serializationStrategy = this.saver;
        FromString fromString = (FromString) serializer2;
        if (fromString != null) {
            Intrinsics.checkNotNullParameter(mediaType, "contentType");
            Intrinsics.checkNotNullParameter(serializationStrategy, "saver");
            RequestBody create = RequestBody.create(mediaType, fromString.format.encodeToString(serializationStrategy, obj));
            Intrinsics.checkNotNullExpressionValue(create, "RequestBody.create(contentType, string)");
            return create;
        }
        throw null;
    }
}
