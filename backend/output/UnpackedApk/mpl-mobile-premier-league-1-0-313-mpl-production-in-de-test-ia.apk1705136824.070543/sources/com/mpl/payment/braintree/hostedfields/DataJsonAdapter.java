package com.mpl.payment.braintree.hostedfields;

import com.mpl.payment.routing.RoutingConstants;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mpl/payment/braintree/hostedfields/DataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/braintree/hostedfields/Data;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataJsonAdapter.kt */
public final class DataJsonAdapter extends JsonAdapter<Data> {
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public DataJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of(RoutingConstants.KILLBILL_BRAINTREE_REDIRECT_PATH, RoutingConstants.KILLBILL_BRAINTREE_HOSTED_FIELD_URL, "clientToken");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"r…rl\",\n      \"clientToken\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, RoutingConstants.KILLBILL_BRAINTREE_REDIRECT_PATH);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…(),\n      \"redirectPath\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(Data)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(Data)";
    }

    public Data fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(RoutingConstants.KILLBILL_BRAINTREE_REDIRECT_PATH, RoutingConstants.KILLBILL_BRAINTREE_REDIRECT_PATH, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"red…, \"redirectPath\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(RoutingConstants.KILLBILL_BRAINTREE_HOSTED_FIELD_URL, RoutingConstants.KILLBILL_BRAINTREE_HOSTED_FIELD_URL, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"hos…\"hostedFieldUrl\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName != 2) {
                continue;
            } else {
                str3 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("clientToken", "clientToken", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"cli…\", \"clientToken\", reader)");
                    throw unexpectedNull3;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(RoutingConstants.KILLBILL_BRAINTREE_REDIRECT_PATH, RoutingConstants.KILLBILL_BRAINTREE_REDIRECT_PATH, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"re…ath\",\n            reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(RoutingConstants.KILLBILL_BRAINTREE_HOSTED_FIELD_URL, RoutingConstants.KILLBILL_BRAINTREE_HOSTED_FIELD_URL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"ho…\"hostedFieldUrl\", reader)");
            throw missingProperty2;
        } else if (str3 != null) {
            return new Data(str, str2, str3);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("clientToken", "clientToken", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"cl…ken\",\n            reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, Data data) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (data != null) {
            jsonWriter.beginObject();
            jsonWriter.name(RoutingConstants.KILLBILL_BRAINTREE_REDIRECT_PATH);
            this.stringAdapter.toJson(jsonWriter, data.getRedirectPath());
            jsonWriter.name(RoutingConstants.KILLBILL_BRAINTREE_HOSTED_FIELD_URL);
            this.stringAdapter.toJson(jsonWriter, data.getHostedFieldUrl());
            jsonWriter.name("clientToken");
            this.stringAdapter.toJson(jsonWriter, data.getClientToken());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
