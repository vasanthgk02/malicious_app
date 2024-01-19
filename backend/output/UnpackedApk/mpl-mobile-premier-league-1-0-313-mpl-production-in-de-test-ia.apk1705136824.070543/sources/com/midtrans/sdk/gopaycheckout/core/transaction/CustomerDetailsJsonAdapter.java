package com.midtrans.sdk.gopaycheckout.core.transaction;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/CustomerDetailsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/CustomerDetails;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class CustomerDetailsJsonAdapter extends JsonAdapter<CustomerDetails> {
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public CustomerDetailsJsonAdapter(Moshi moshi) {
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("phone");
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"phone\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "phone");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl…mptySet(),\n      \"phone\")");
        this.stringAdapter = adapter;
    }

    public CustomerDetails fromJson(JsonReader jsonReader) {
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
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
                    JsonDataException unexpectedNull = Util.unexpectedNull("phone", "phone", jsonReader);
                    Intrinsics.checkExpressionValueIsNotNull(unexpectedNull, "Util.unexpectedNull(\"pho…one\",\n            reader)");
                    throw unexpectedNull;
                }
            }
        }
        jsonReader.endObject();
        if (str != null) {
            return new CustomerDetails(str);
        }
        JsonDataException missingProperty = Util.missingProperty("phone", "phone", jsonReader);
        Intrinsics.checkExpressionValueIsNotNull(missingProperty, "Util.missingProperty(\"phone\", \"phone\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, CustomerDetails customerDetails) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (customerDetails != null) {
            jsonWriter.beginObject();
            jsonWriter.name("phone");
            this.stringAdapter.toJson(jsonWriter, customerDetails.getPhone());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(CustomerDetails)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(CustomerDetails)";
    }
}
