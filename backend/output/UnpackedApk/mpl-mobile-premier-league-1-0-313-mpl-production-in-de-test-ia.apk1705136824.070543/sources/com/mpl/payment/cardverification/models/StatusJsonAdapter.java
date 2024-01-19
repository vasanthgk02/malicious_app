package com.mpl.payment.cardverification.models;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/cardverification/models/StatusJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/cardverification/models/Status;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: StatusJsonAdapter.kt */
public final class StatusJsonAdapter extends JsonAdapter<Status> {
    public final JsonAdapter<Integer> intAdapter;
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;

    public StatusJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("code", "message");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"code\", \"message\")");
        this.options = of;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, EmptySet.INSTANCE, "code");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class.java, emptySet(), \"code\")");
        this.intAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, EmptySet.INSTANCE, "message");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…   emptySet(), \"message\")");
        this.nullableStringAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(Status)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(Status)";
    }

    public Status fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Integer num = null;
        String str = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                Integer num2 = (Integer) this.intAdapter.fromJson(jsonReader);
                if (num2 != null) {
                    num = Integer.valueOf(num2.intValue());
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("code", "code", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"code\", \"code\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = (String) this.nullableStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (num != null) {
            return new Status(num.intValue(), str);
        }
        JsonDataException missingProperty = Util.missingProperty("code", "code", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"code\", \"code\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, Status status) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (status != null) {
            jsonWriter.beginObject();
            jsonWriter.name("code");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(status.getCode()));
            jsonWriter.name("message");
            this.nullableStringAdapter.toJson(jsonWriter, status.getMessage());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
