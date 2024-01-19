package com.mpl.payment.braintree.hostedfields;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mpl/payment/braintree/hostedfields/BtHostedFieldsParamsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/braintree/hostedfields/BtHostedFieldsParams;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "dataAdapter", "Lcom/mpl/payment/braintree/hostedfields/Data;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: BtHostedFieldsParamsJsonAdapter.kt */
public final class BtHostedFieldsParamsJsonAdapter extends JsonAdapter<BtHostedFieldsParams> {
    public final JsonAdapter<Data> dataAdapter;
    public final Options options;

    public BtHostedFieldsParamsJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("data");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"data\")");
        this.options = of;
        JsonAdapter<Data> adapter = moshi.adapter(Data.class, EmptySet.INSTANCE, "data");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Data::clas…java, emptySet(), \"data\")");
        this.dataAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(BtHostedFieldsParams)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(BtHostedFieldsParams)";
    }

    public BtHostedFieldsParams fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Data data = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName != 0) {
                continue;
            } else {
                data = (Data) this.dataAdapter.fromJson(jsonReader);
                if (data == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("data_", "data", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"dat…ata\",\n            reader)");
                    throw unexpectedNull;
                }
            }
        }
        jsonReader.endObject();
        if (data != null) {
            return new BtHostedFieldsParams(data);
        }
        JsonDataException missingProperty = Util.missingProperty("data_", "data", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"data_\", \"data\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, BtHostedFieldsParams btHostedFieldsParams) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (btHostedFieldsParams != null) {
            jsonWriter.beginObject();
            jsonWriter.name("data");
            this.dataAdapter.toJson(jsonWriter, btHostedFieldsParams.getData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
