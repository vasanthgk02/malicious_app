package com.mpl.payment.juspayhypersdk.customer.model;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/customer/model/CustomerDetailsPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/customer/model/CustomerDetailsPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "payloadAdapter", "Lcom/mpl/payment/juspayhypersdk/customer/model/Payload;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CustomerDetailsPayloadJsonAdapter.kt */
public final class CustomerDetailsPayloadJsonAdapter extends JsonAdapter<CustomerDetailsPayload> {
    public final Options options;
    public final JsonAdapter<Payload> payloadAdapter;

    public CustomerDetailsPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("payload");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"payload\")");
        this.options = of;
        JsonAdapter<Payload> adapter = moshi.adapter(Payload.class, EmptySet.INSTANCE, "payload");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Payload::c…tySet(),\n      \"payload\")");
        this.payloadAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(CustomerDetailsPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(CustomerDetailsPayload)";
    }

    public CustomerDetailsPayload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Payload payload = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName != 0) {
                continue;
            } else {
                payload = (Payload) this.payloadAdapter.fromJson(jsonReader);
                if (payload == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("payload", "payload", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"pay…       \"payload\", reader)");
                    throw unexpectedNull;
                }
            }
        }
        jsonReader.endObject();
        if (payload != null) {
            return new CustomerDetailsPayload(payload);
        }
        JsonDataException missingProperty = Util.missingProperty("payload", "payload", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"payload\", \"payload\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, CustomerDetailsPayload customerDetailsPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (customerDetailsPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("payload");
            this.payloadAdapter.toJson(jsonWriter, customerDetailsPayload.getPayload());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
