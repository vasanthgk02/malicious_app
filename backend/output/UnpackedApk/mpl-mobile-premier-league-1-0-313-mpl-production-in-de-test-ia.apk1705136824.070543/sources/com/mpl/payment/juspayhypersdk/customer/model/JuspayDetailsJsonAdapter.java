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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/customer/model/JuspayDetailsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/customer/model/JuspayDetails;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: JuspayDetailsJsonAdapter.kt */
public final class JuspayDetailsJsonAdapter extends JsonAdapter<JuspayDetails> {
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public JuspayDetailsJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("customerId");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"customerId\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "customerId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…et(),\n      \"customerId\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(JuspayDetails)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(JuspayDetails)";
    }

    public JuspayDetails fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName != 0) {
                continue;
            } else {
                str = (String) this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("customerId", "customerId", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"cus…    \"customerId\", reader)");
                    throw unexpectedNull;
                }
            }
        }
        jsonReader.endObject();
        if (str != null) {
            return new JuspayDetails(str);
        }
        JsonDataException missingProperty = Util.missingProperty("customerId", "customerId", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"cu…d\", \"customerId\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, JuspayDetails juspayDetails) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (juspayDetails != null) {
            jsonWriter.beginObject();
            jsonWriter.name("customerId");
            this.stringAdapter.toJson(jsonWriter, juspayDetails.getCustomerId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
