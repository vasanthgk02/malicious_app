package com.jakewharton.retrofit2.converter.kotlinx.serialization;

import com.jakewharton.retrofit2.converter.kotlinx.serialization.Serializer.FromString;
import com.netcore.android.notification.SMTNotificationConstants;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import okhttp3.ResponseBody;
import retrofit2.Converter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/DeserializationStrategyConverter;", "T", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "loader", "Lkotlinx/serialization/DeserializationStrategy;", "serializer", "Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer;", "(Lkotlinx/serialization/DeserializationStrategy;Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer;)V", "convert", "value", "(Lokhttp3/ResponseBody;)Ljava/lang/Object;", "retrofit2-kotlinx-serialization-converter"}, k = 1, mv = {1, 4, 0})
/* compiled from: DeserializationStrategyConverter.kt */
public final class DeserializationStrategyConverter<T> implements Converter<ResponseBody, T> {
    public final DeserializationStrategy<T> loader;
    public final Serializer serializer;

    public DeserializationStrategyConverter(DeserializationStrategy<T> deserializationStrategy, Serializer serializer2) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "loader");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        this.loader = deserializationStrategy;
        this.serializer = serializer2;
    }

    public Object convert(Object obj) {
        ResponseBody responseBody = (ResponseBody) obj;
        Intrinsics.checkNotNullParameter(responseBody, HSLCriteriaBuilder.VALUE);
        Serializer serializer2 = this.serializer;
        DeserializationStrategy<T> deserializationStrategy = this.loader;
        FromString fromString = (FromString) serializer2;
        if (fromString != null) {
            Intrinsics.checkNotNullParameter(deserializationStrategy, "loader");
            Intrinsics.checkNotNullParameter(responseBody, SMTNotificationConstants.NOTIF_BODY_KEY);
            String string = responseBody.string();
            Intrinsics.checkNotNullExpressionValue(string, "body.string()");
            return fromString.format.decodeFromString(deserializationStrategy, string);
        }
        throw null;
    }
}
