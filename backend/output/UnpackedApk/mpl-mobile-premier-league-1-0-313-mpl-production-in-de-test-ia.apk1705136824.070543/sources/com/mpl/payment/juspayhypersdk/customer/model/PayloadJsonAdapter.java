package com.mpl.payment.juspayhypersdk.customer.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/customer/model/PayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/customer/model/Payload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfJuspayDetailsAdapter", "", "Lcom/mpl/payment/juspayhypersdk/customer/model/JuspayDetails;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PayloadJsonAdapter.kt */
public final class PayloadJsonAdapter extends JsonAdapter<Payload> {
    public final JsonAdapter<List<JuspayDetails>> listOfJuspayDetailsAdapter;
    public final Options options;

    public PayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("partnerCustomerDetailList");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"partnerCustomerDetailList\")");
        this.options = of;
        JsonAdapter<List<JuspayDetails>> adapter = moshi.adapter(Types.newParameterizedType(List.class, JuspayDetails.class), EmptySet.INSTANCE, "partnerCustomerDetailList");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…rtnerCustomerDetailList\")");
        this.listOfJuspayDetailsAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(Payload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(Payload)";
    }

    public Payload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName != 0) {
                continue;
            } else {
                list = (List) this.listOfJuspayDetailsAdapter.fromJson(jsonReader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("partnerCustomerDetailList", "partnerCustomerDetailList", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"par…ist\",\n            reader)");
                    throw unexpectedNull;
                }
            }
        }
        jsonReader.endObject();
        if (list != null) {
            return new Payload(list);
        }
        JsonDataException missingProperty = Util.missingProperty("partnerCustomerDetailList", "partnerCustomerDetailList", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"pa…ist\",\n            reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, Payload payload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (payload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("partnerCustomerDetailList");
            this.listOfJuspayDetailsAdapter.toJson(jsonWriter, payload.getPartnerCustomerDetailList());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
