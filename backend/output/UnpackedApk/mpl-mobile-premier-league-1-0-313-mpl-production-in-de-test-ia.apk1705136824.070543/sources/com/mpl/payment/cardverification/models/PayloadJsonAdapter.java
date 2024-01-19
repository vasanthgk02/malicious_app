package com.mpl.payment.cardverification.models;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/mpl/payment/cardverification/models/PayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/cardverification/models/Payload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableBooleanAdapter", "", "nullableDataAdapter", "Lcom/mpl/payment/cardverification/models/Data;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PayloadJsonAdapter.kt */
public final class PayloadJsonAdapter extends JsonAdapter<Payload> {
    public final JsonAdapter<Boolean> nullableBooleanAdapter;
    public final JsonAdapter<Data> nullableDataAdapter;
    public final Options options;

    public PayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("success", "data");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"success\", \"data\")");
        this.options = of;
        JsonAdapter<Boolean> adapter = moshi.adapter(Boolean.class, EmptySet.INSTANCE, "success");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Boolean::c…e, emptySet(), \"success\")");
        this.nullableBooleanAdapter = adapter;
        JsonAdapter<Data> adapter2 = moshi.adapter(Data.class, EmptySet.INSTANCE, "data");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Data::clas…emptySet(),\n      \"data\")");
        this.nullableDataAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(Payload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(Payload)";
    }

    public Payload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Boolean bool = null;
        Data data = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                bool = (Boolean) this.nullableBooleanAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                data = (Data) this.nullableDataAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new Payload(bool, data);
    }

    public void toJson(JsonWriter jsonWriter, Payload payload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (payload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("success");
            this.nullableBooleanAdapter.toJson(jsonWriter, payload.getSuccess());
            jsonWriter.name("data");
            this.nullableDataAdapter.toJson(jsonWriter, payload.getData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
